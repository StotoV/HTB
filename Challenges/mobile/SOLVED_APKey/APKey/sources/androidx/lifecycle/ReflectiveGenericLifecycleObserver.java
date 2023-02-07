package androidx.lifecycle;

import b.m.a;
import b.m.d;
import b.m.e;
import b.m.g;
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements e {
    public final Object a;

    /* renamed from: b  reason: collision with root package name */
    public final a.C0026a f74b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.f74b = a.f633c.b(obj.getClass());
    }

    @Override // b.m.e
    public void h(g gVar, d.a aVar) {
        a.C0026a c0026a = this.f74b;
        Object obj = this.a;
        a.C0026a.a(c0026a.a.get(aVar), gVar, aVar, obj);
        a.C0026a.a(c0026a.a.get(d.a.ON_ANY), gVar, aVar, obj);
    }
}
