package b.h.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import b.h.g.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
/* loaded from: classes.dex */
public class f extends j {

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?> f417b;

    /* renamed from: c  reason: collision with root package name */
    public static final Constructor<?> f418c;
    public static final Method d;
    public static final Method e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method = null;
            method2 = null;
        }
        f418c = constructor;
        f417b = cls;
        d = method2;
        e = method;
    }

    public static boolean h(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface i(Object obj) {
        try {
            Object newInstance = Array.newInstance(f417b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.h.d.j
    public Typeface a(Context context, b.h.c.b.c cVar, Resources resources, int i) {
        Object obj;
        b.h.c.b.d[] dVarArr;
        MappedByteBuffer mappedByteBuffer;
        try {
            obj = f418c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (b.h.c.b.d dVar : cVar.a) {
            int i2 = dVar.f;
            File C = b.h.b.a.C(context);
            if (C != null) {
                try {
                    if (b.h.b.a.o(C, resources, i2)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(C);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable unused2) {
                                }
                                throw th;
                                break;
                            }
                        } catch (IOException unused3) {
                            mappedByteBuffer = null;
                        }
                        if (mappedByteBuffer != null || !h(obj, mappedByteBuffer, dVar.e, dVar.f402b, dVar.f403c)) {
                            return null;
                        }
                    }
                } finally {
                    C.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer != null) {
                return null;
            }
        }
        return i(obj);
    }

    @Override // b.h.d.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i) {
        Object obj;
        try {
            obj = f418c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        b.e.f fVar = new b.e.f();
        for (l lVar : lVarArr) {
            Uri uri = lVar.a;
            ByteBuffer byteBuffer = (ByteBuffer) fVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = b.h.b.a.L(context, cancellationSignal, uri);
                fVar.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !h(obj, byteBuffer, lVar.f440b, lVar.f441c, lVar.d)) {
                return null;
            }
        }
        Typeface i2 = i(obj);
        if (i2 != null) {
            return Typeface.create(i2, i);
        }
        return null;
    }
}
