package b.m;

import b.m.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f633c = new a();
    public final Map<Class<?>, C0026a> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, Boolean> f634b = new HashMap();

    /* renamed from: b.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0026a {
        public final Map<d.a, List<b>> a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<b, d.a> f635b;

        public C0026a(Map<b, d.a> map) {
            this.f635b = map;
            for (Map.Entry<b, d.a> entry : map.entrySet()) {
                d.a value = entry.getValue();
                List<b> list = this.a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void a(List<b> list, g gVar, d.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    b bVar = list.get(size);
                    bVar.getClass();
                    try {
                        int i = bVar.a;
                        if (i == 0) {
                            bVar.f636b.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            bVar.f636b.invoke(obj, gVar);
                        } else if (i == 2) {
                            bVar.f636b.invoke(obj, gVar, aVar);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f636b;

        public b(int i, Method method) {
            this.a = i;
            this.f636b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.f636b.getName().equals(bVar.f636b.getName());
        }

        public int hashCode() {
            return this.f636b.getName().hashCode() + (this.a * 31);
        }
    }

    public final C0026a a(Class<?> cls, Method[] methodArr) {
        int i;
        C0026a b2;
        Class<?> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b2 = b(superclass)) != null) {
            hashMap.putAll(b2.f635b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, d.a> entry : b(cls2).f635b.entrySet()) {
                c(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(g.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                d.a value = nVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != d.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                c(hashMap, new b(i, method), value, cls);
                z = true;
            }
        }
        C0026a c0026a = new C0026a(hashMap);
        this.a.put(cls, c0026a);
        this.f634b.put(cls, Boolean.valueOf(z));
        return c0026a;
    }

    public C0026a b(Class<?> cls) {
        C0026a c0026a = this.a.get(cls);
        return c0026a != null ? c0026a : a(cls, null);
    }

    public final void c(Map<b, d.a> map, b bVar, d.a aVar, Class<?> cls) {
        d.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 != null) {
                return;
            }
            map.put(bVar, aVar);
            return;
        }
        Method method = bVar.f636b;
        StringBuilder g = c.a.a.a.a.g("Method ");
        g.append(method.getName());
        g.append(" in ");
        g.append(cls.getName());
        g.append(" already declared with different @OnLifecycleEvent value: previous value ");
        g.append(aVar2);
        g.append(", new value ");
        g.append(aVar);
        throw new IllegalArgumentException(g.toString());
    }
}
