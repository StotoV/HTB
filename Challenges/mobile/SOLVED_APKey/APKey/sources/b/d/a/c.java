package b.d.a;

import android.content.res.ColorStateList;
/* loaded from: classes.dex */
public class c implements f {
    @Override // b.d.a.f
    public float a(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public float b(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public void c(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public void d(e eVar, ColorStateList colorStateList) {
        throw null;
    }

    @Override // b.d.a.f
    public float e(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public float f(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public float g(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public void h(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public ColorStateList i(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public void j(e eVar, float f) {
        throw null;
    }

    @Override // b.d.a.f
    public void k(e eVar, float f) {
        g n = n(eVar);
        boolean a = eVar.a();
        boolean d = eVar.d();
        if (f == n.f297b && n.f298c == a && n.d == d) {
            if (!eVar.a()) {
                eVar.b(0, 0, 0, 0);
                return;
            }
            float f2 = n(eVar).f297b;
            float f3 = n(eVar).a;
            int ceil = (int) Math.ceil(h.a(f2, f3, eVar.d()));
            int ceil2 = (int) Math.ceil(h.b(f2, f3, eVar.d()));
            eVar.b(ceil, ceil2, ceil, ceil2);
            return;
        }
        n.f297b = f;
        n.f298c = a;
        n.d = d;
        n.b(null);
        throw null;
    }

    @Override // b.d.a.f
    public void l() {
    }

    @Override // b.d.a.f
    public void m(e eVar, float f) {
        throw null;
    }

    public final g n(e eVar) {
        return (g) eVar.c();
    }
}
