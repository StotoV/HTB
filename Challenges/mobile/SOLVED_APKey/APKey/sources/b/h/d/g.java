package b.h.d;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import b.h.d.j;
import b.h.g.l;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class g extends e {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public g() {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = q(cls2);
            method4 = r(cls2);
            method5 = cls2.getMethod("freeze", new Class[0]);
            method2 = cls2.getMethod("abortCreation", new Class[0]);
            method = s(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder g = c.a.a.a.a.g("Unable to collect necessary methods for class ");
            g.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", g.toString(), e);
            method = null;
            method2 = null;
            constructor = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = method3;
        this.j = method4;
        this.k = method5;
        this.l = method2;
        this.m = method;
    }

    private Object p() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // b.h.d.e, b.h.d.j
    public Typeface a(Context context, b.h.c.b.c cVar, Resources resources, int i) {
        b.h.c.b.d[] dVarArr;
        if (!o()) {
            return super.a(context, cVar, resources, i);
        }
        Object p = p();
        if (p == null) {
            return null;
        }
        for (b.h.c.b.d dVar : cVar.a) {
            if (!l(context, p, dVar.a, dVar.e, dVar.f402b, dVar.f403c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d))) {
                k(p);
                return null;
            }
        }
        if (n(p)) {
            return m(p);
        }
        return null;
    }

    @Override // b.h.d.e, b.h.d.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i) {
        Typeface m;
        boolean z;
        if (lVarArr.length < 1) {
            return null;
        }
        if (!o()) {
            l lVar = (l) j.e(lVarArr, i, new j.a(this));
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(lVar.a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(lVar.f441c).setItalic(lVar.d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap hashMap = new HashMap();
        for (l lVar2 : lVarArr) {
            if (lVar2.e == 0) {
                Uri uri = lVar2.a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, b.h.b.a.L(context, cancellationSignal, uri));
                }
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Object p = p();
        if (p == null) {
            return null;
        }
        boolean z2 = false;
        for (l lVar3 : lVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(lVar3.a);
            if (byteBuffer != null) {
                try {
                    z = ((Boolean) this.j.invoke(p, byteBuffer, Integer.valueOf(lVar3.f440b), null, Integer.valueOf(lVar3.f441c), Integer.valueOf(lVar3.d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    z = false;
                }
                if (!z) {
                    k(p);
                    return null;
                }
                z2 = true;
            }
        }
        if (!z2) {
            k(p);
            return null;
        } else if (n(p) && (m = m(p)) != null) {
            return Typeface.create(m, i);
        } else {
            return null;
        }
    }

    @Override // b.h.d.j
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        if (!o()) {
            return super.d(context, resources, i, str, i2);
        }
        Object p = p();
        if (p == null) {
            return null;
        }
        if (!l(context, p, str, 0, -1, -1, null)) {
            k(p);
            return null;
        } else if (n(p)) {
            return m(p);
        } else {
            return null;
        }
    }

    public final void k(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean l(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface m(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean n(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean o() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    public Method q(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method r(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method s(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
