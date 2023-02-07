package b.k.b;

import b.m.d;
/* loaded from: classes.dex */
public class w0 implements b.p.c, b.m.u {

    /* renamed from: b  reason: collision with root package name */
    public final b.m.t f611b;

    /* renamed from: c  reason: collision with root package name */
    public b.m.h f612c = null;
    public b.p.b d = null;

    public w0(m mVar, b.m.t tVar) {
        this.f611b = tVar;
    }

    @Override // b.m.g
    public b.m.d a() {
        f();
        return this.f612c;
    }

    @Override // b.p.c
    public b.p.a c() {
        f();
        return this.d.f698b;
    }

    @Override // b.m.u
    public b.m.t d() {
        f();
        return this.f611b;
    }

    public void e(d.a aVar) {
        b.m.h hVar = this.f612c;
        hVar.c("handleLifecycleEvent");
        hVar.f(aVar.a());
    }

    public void f() {
        if (this.f612c == null) {
            this.f612c = new b.m.h(this);
            this.d = new b.p.b(this);
        }
    }
}
