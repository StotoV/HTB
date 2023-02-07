package b.k.b;

import b.k.b.m;
/* loaded from: classes.dex */
public class y {
    public static final b.e.f<ClassLoader, b.e.f<String, Class<?>>> a = new b.e.f<>();

    public static Class<?> b(ClassLoader classLoader, String str) {
        b.e.f<ClassLoader, b.e.f<String, Class<?>>> fVar = a;
        b.e.f<String, Class<?>> orDefault = fVar.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new b.e.f<>();
            fVar.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 == null) {
            Class<?> cls = Class.forName(str, false, classLoader);
            orDefault.put(str, cls);
            return cls;
        }
        return orDefault2;
    }

    public static Class<? extends m> c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new m.c(c.a.a.a.a.e("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new m.c(c.a.a.a.a.e("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public m a(ClassLoader classLoader, String str) {
        throw null;
    }
}
