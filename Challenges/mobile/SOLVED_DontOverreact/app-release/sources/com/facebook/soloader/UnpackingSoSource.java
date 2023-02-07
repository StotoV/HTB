package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    private static final byte STATE_CLEAN = 1;
    private static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    private String[] mAbis;
    protected final Context mContext;
    @Nullable
    protected String mCorruptedLib;
    private final Map<String, Object> mLibsBeingLoaded;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class InputDsoIterator implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        public abstract InputDso next() throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static abstract class Unpacker implements Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        protected abstract DsoManifest getDsoManifest() throws IOException;

        protected abstract InputDsoIterator openDsoIterator() throws IOException;
    }

    protected abstract Unpacker makeUnpacker() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mLibsBeingLoaded = new HashMap();
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    @Override // com.facebook.soloader.SoSource
    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    /* loaded from: classes.dex */
    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    /* loaded from: classes.dex */
    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() != 1) {
                throw new RuntimeException("wrong dso manifest version");
            }
            int readInt = dataInput.readInt();
            if (readInt < 0) {
                throw new RuntimeException("illegal number of shared libraries");
            }
            Dso[] dsoArr = new Dso[readInt];
            for (int i = 0; i < readInt; i++) {
                dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
            }
            return new DsoManifest(dsoArr);
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class InputDso implements Closeable {
        public final InputStream content;
        public final Dso dso;

        public InputDso(Dso dso, InputStream inputStream) {
            this.dso = dso;
            this.content = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.content.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list == null) {
            throw new IOException("unable to list directory " + this.soDirectory);
        }
        for (String str : list) {
            if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                boolean z = false;
                for (int i = 0; !z && i < dsoArr.length; i++) {
                    if (dsoArr[i].name.equals(str)) {
                        z = true;
                    }
                }
                if (!z) {
                    File file = new File(this.soDirectory, str);
                    Log.v(TAG, "deleting unaccounted-for file " + file);
                    SysUtil.dumbDeleteRecursive(file);
                }
            }
        }
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        Log.i(TAG, "extracting DSO " + inputDso.dso.name);
        if (!this.soDirectory.setWritable(true, true)) {
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        }
        File file = new File(this.soDirectory, inputDso.dso.name);
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (IOException e) {
            Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e);
            SysUtil.dumbDeleteRecursive(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
        }
        try {
            try {
                int available = inputDso.content.available();
                if (available > 1) {
                    SysUtil.fallocateIfSupported(randomAccessFile.getFD(), available);
                }
                SysUtil.copyBytes(randomAccessFile, inputDso.content, Integer.MAX_VALUE, bArr);
                randomAccessFile.setLength(randomAccessFile.getFilePointer());
                if (file.setExecutable(true, false)) {
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e2) {
                SysUtil.dumbDeleteRecursive(file);
                throw e2;
            }
        } finally {
            randomAccessFile.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0043 A[Catch: all -> 0x0036, TryCatch #6 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a2, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0077, B:27:0x0088, B:31:0x008f), top: B:53:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #6 {all -> 0x0036, blocks: (B:4:0x0031, B:13:0x0043, B:14:0x004a, B:15:0x0054, B:17:0x005a, B:42:0x00a2, B:9:0x003a, B:20:0x0062, B:22:0x0067, B:24:0x0077, B:27:0x0088, B:31:0x008f), top: B:53:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void regenerate(byte r10, com.facebook.soloader.UnpackingSoSource.DsoManifest r11, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.soDirectory
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L3f
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r2)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L39
            goto L40
        L36:
            r10 = move-exception
            goto Lc6
        L39:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch: java.lang.Throwable -> L36
        L3f:
            r10 = 0
        L40:
            r3 = 0
            if (r10 != 0) goto L4a
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch: java.lang.Throwable -> L36
            com.facebook.soloader.UnpackingSoSource$Dso[] r4 = new com.facebook.soloader.UnpackingSoSource.Dso[r3]     // Catch: java.lang.Throwable -> L36
            r10.<init>(r4)     // Catch: java.lang.Throwable -> L36
        L4a:
            com.facebook.soloader.UnpackingSoSource$Dso[] r11 = r11.dsos     // Catch: java.lang.Throwable -> L36
            r9.deleteUnmentionedFiles(r11)     // Catch: java.lang.Throwable -> L36
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch: java.lang.Throwable -> L36
        L54:
            boolean r4 = r12.hasNext()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto La6
            com.facebook.soloader.UnpackingSoSource$InputDso r4 = r12.next()     // Catch: java.lang.Throwable -> L36
            r5 = 1
            r6 = 0
        L60:
            if (r5 == 0) goto L8d
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch: java.lang.Throwable -> L8b
            int r7 = r7.length     // Catch: java.lang.Throwable -> L8b
            if (r6 >= r7) goto L8d
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch: java.lang.Throwable -> L8b
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L8b
            java.lang.String r7 = r7.name     // Catch: java.lang.Throwable -> L8b
            com.facebook.soloader.UnpackingSoSource$Dso r8 = r4.dso     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = r8.name     // Catch: java.lang.Throwable -> L8b
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L88
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch: java.lang.Throwable -> L8b
            r7 = r7[r6]     // Catch: java.lang.Throwable -> L8b
            java.lang.String r7 = r7.hash     // Catch: java.lang.Throwable -> L8b
            com.facebook.soloader.UnpackingSoSource$Dso r8 = r4.dso     // Catch: java.lang.Throwable -> L8b
            java.lang.String r8 = r8.hash     // Catch: java.lang.Throwable -> L8b
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Throwable -> L8b
            if (r7 == 0) goto L88
            r5 = 0
        L88:
            int r6 = r6 + 1
            goto L60
        L8b:
            r10 = move-exception
            goto L93
        L8d:
            if (r5 == 0) goto La0
            r9.extractDso(r4, r11)     // Catch: java.lang.Throwable -> L8b
            goto La0
        L93:
            throw r10     // Catch: java.lang.Throwable -> L94
        L94:
            r11 = move-exception
            if (r4 == 0) goto L9f
            r4.close()     // Catch: java.lang.Throwable -> L9b
            goto L9f
        L9b:
            r12 = move-exception
            r10.addSuppressed(r12)     // Catch: java.lang.Throwable -> L36
        L9f:
            throw r11     // Catch: java.lang.Throwable -> L36
        La0:
            if (r4 == 0) goto L54
            r4.close()     // Catch: java.lang.Throwable -> L36
            goto L54
        La6:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Finished regenerating DSO store "
            r10.append(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        Lc6:
            throw r10     // Catch: java.lang.Throwable -> Lc7
        Lc7:
            r11 = move-exception
            r2.close()     // Catch: java.lang.Throwable -> Lcc
            goto Ld0
        Lcc:
            r12 = move-exception
            r10.addSuppressed(r12)
        Ld0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean refreshLocked(final com.facebook.soloader.FileLocker r12, int r13, final byte[] r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    protected byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker();
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (makeUnpacker != null) {
                    try {
                        makeUnpacker.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker lock = FileLocker.lock(new File(this.soDirectory, LOCK_FILE_NAME));
        try {
            Log.v(TAG, "locked dso store " + this.soDirectory);
            if (refreshLocked(lock, i, getDepsBlock())) {
                lock = null;
            } else {
                Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
            }
        } finally {
            if (lock != null) {
                Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                lock.close();
            } else {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    @Override // com.facebook.soloader.DirectorySoSource, com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}
