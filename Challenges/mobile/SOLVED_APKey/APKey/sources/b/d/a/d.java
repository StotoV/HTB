package b.d.a;

import android.content.res.ColorStateList;
import android.graphics.RectF;
import b.d.a.h;
/* loaded from: classes.dex */
public class d implements f {
    public final RectF a = new RectF();

    /* loaded from: classes.dex */
    public class a implements h.a {
        public a() {
        }
    }

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
        h n = n(eVar);
        float f = n.f299b;
        float f2 = 0;
        return (((n.f299b * 1.5f) + f2) * 2.0f) + (Math.max(f, ((f * 1.5f) / 2.0f) + n.a + f2) * 2.0f);
    }

    @Override // b.d.a.f
    public float f(e eVar) {
        throw null;
    }

    @Override // b.d.a.f
    public float g(e eVar) {
        h n = n(eVar);
        float f = n.f299b;
        float f2 = 0;
        return ((n.f299b + f2) * 2.0f) + (Math.max(f, (f / 2.0f) + n.a + f2) * 2.0f);
    }

    @Override // b.d.a.f
    public void h(e eVar) {
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
        throw null;
    }

    @Override // b.d.a.f
    public void l() {
        h.h = new a();
    }

    @Override // b.d.a.f
    public void m(e eVar, float f) {
        throw null;
    }

    public final h n(e eVar) {
        return (h) eVar.c();
    }
}
