package b.h.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import b.h.d.j;
import b.h.g.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class e extends j {

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f415b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Constructor<?> f416c = null;
    public static Method d = null;
    public static Method e = null;
    public static boolean f = false;

    public static boolean h(Object obj, String str, int i, boolean z) {
        j();
        try {
            return ((Boolean) d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static void j() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f) {
            return;
        }
        f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
            method = null;
            cls = null;
            method2 = null;
        }
        f416c = constructor;
        f415b = cls;
        d = method2;
        e = method;
    }

    @Override // b.h.d.j
    public Typeface a(Context context, b.h.c.b.c cVar, Resources resources, int i) {
        b.h.c.b.d[] dVarArr;
        j();
        try {
            Object newInstance = f416c.newInstance(new Object[0]);
            for (b.h.c.b.d dVar : cVar.a) {
                File C = b.h.b.a.C(context);
                if (C == null) {
                    return null;
                }
                try {
                    if (!b.h.b.a.o(C, resources, dVar.f)) {
                        return null;
                    }
                    if (!h(newInstance, C.getPath(), dVar.f402b, dVar.f403c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    C.delete();
                }
            }
            j();
            try {
                Object newInstance2 = Array.newInstance(f415b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // b.h.d.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i) {
        if (lVarArr.length < 1) {
            return null;
        }
        l lVar = (l) j.e(lVarArr, i, new j.a(this));
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(lVar.a, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            File i2 = i(openFileDescriptor);
            if (i2 != null && i2.canRead()) {
                Typeface createFromFile = Typeface.createFromFile(i2);
                openFileDescriptor.close();
                return createFromFile;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface c2 = c(context, fileInputStream);
            fileInputStream.close();
            openFileDescriptor.close();
            return c2;
        } catch (IOException unused) {
            return null;
        }
    }

    public final File i(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (!OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return null;
            }
            return new File(readlink);
        } catch (ErrnoException unused) {
            return null;
        }
    }
}
