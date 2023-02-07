package b.s;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class a {
    public final b.e.a<String, Method> a;

    /* renamed from: b  reason: collision with root package name */
    public final b.e.a<String, Method> f754b;

    /* renamed from: c  reason: collision with root package name */
    public final b.e.a<String, Class> f755c;

    public a(b.e.a<String, Method> aVar, b.e.a<String, Method> aVar2, b.e.a<String, Class> aVar3) {
        this.a = aVar;
        this.f754b = aVar2;
        this.f755c = aVar3;
    }

    public abstract void a();

    public abstract a b();

    public final Class c(Class<? extends c> cls) {
        Class orDefault = this.f755c.getOrDefault(cls.getName(), null);
        if (orDefault == null) {
            Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f755c.put(cls.getName(), cls2);
            return cls2;
        }
        return orDefault;
    }

    public final Method d(String str) {
        Method orDefault = this.a.getOrDefault(str, null);
        if (orDefault == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, a.class.getClassLoader()).getDeclaredMethod("read", a.class);
            this.a.put(str, declaredMethod);
            return declaredMethod;
        }
        return orDefault;
    }

    public final Method e(Class cls) {
        Method orDefault = this.f754b.getOrDefault(cls.getName(), null);
        if (orDefault == null) {
            Class c2 = c(cls);
            System.currentTimeMillis();
            Method declaredMethod = c2.getDeclaredMethod("write", cls, a.class);
            this.f754b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return orDefault;
    }

    public abstract boolean f();

    public abstract byte[] g();

    public abstract CharSequence h();

    public abstract boolean i(int i);

    public abstract int j();

    public int k(int i, int i2) {
        return !i(i2) ? i : j();
    }

    public abstract <T extends Parcelable> T l();

    public <T extends Parcelable> T m(T t, int i) {
        return !i(i) ? t : (T) l();
    }

    public abstract String n();

    public <T extends c> T o() {
        String n = n();
        if (n == null) {
            return null;
        }
        try {
            return (T) d(n).invoke(null, b());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }

    public abstract void p(int i);

    public abstract void q(boolean z);

    public abstract void r(byte[] bArr);

    public abstract void s(CharSequence charSequence);

    public abstract void t(int i);

    public abstract void u(Parcelable parcelable);

    public abstract void v(String str);

    /* JADX WARN: Multi-variable type inference failed */
    public void w(c cVar) {
        if (cVar == null) {
            v(null);
            return;
        }
        try {
            v(c(cVar.getClass()).getName());
            a b2 = b();
            try {
                e(cVar.getClass()).invoke(null, cVar, b2);
                b2.a();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (!(e4.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
                }
                throw ((RuntimeException) e4.getCause());
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(cVar.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }
}
