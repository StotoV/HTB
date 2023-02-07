package b.f.b.h;

import b.f.b.h.c;
import b.f.b.h.d;
/* loaded from: classes.dex */
public class f extends d {
    public float l0 = -1.0f;
    public int m0 = -1;
    public int n0 = -1;
    public c o0 = this.E;
    public int p0 = 0;
    public boolean q0;

    public f() {
        this.M.clear();
        this.M.add(this.o0);
        int length = this.L.length;
        for (int i = 0; i < length; i++) {
            this.L[i] = this.o0;
        }
    }

    @Override // b.f.b.h.d
    public boolean A() {
        return this.q0;
    }

    @Override // b.f.b.h.d
    public void O(b.f.b.d dVar, boolean z) {
        if (this.P == null) {
            return;
        }
        int o = dVar.o(this.o0);
        if (this.p0 == 1) {
            this.U = o;
            this.V = 0;
            H(this.P.l());
            M(0);
            return;
        }
        this.U = 0;
        this.V = o;
        M(this.P.r());
        H(0);
    }

    public void P(int i) {
        c cVar = this.o0;
        cVar.f337b = i;
        cVar.f338c = true;
        this.q0 = true;
    }

    public void Q(int i) {
        if (this.p0 == i) {
            return;
        }
        this.p0 = i;
        this.M.clear();
        this.o0 = this.p0 == 1 ? this.D : this.E;
        this.M.add(this.o0);
        int length = this.L.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.L[i2] = this.o0;
        }
    }

    @Override // b.f.b.h.d
    public void d(b.f.b.d dVar, boolean z) {
        b.f.b.g l;
        b.f.b.g l2;
        b.f.b.g l3;
        d.a aVar = d.a.WRAP_CONTENT;
        e eVar = (e) this.P;
        if (eVar == null) {
            return;
        }
        Object i = eVar.i(c.a.LEFT);
        Object i2 = eVar.i(c.a.RIGHT);
        d dVar2 = this.P;
        boolean z2 = true;
        boolean z3 = dVar2 != null && dVar2.O[0] == aVar;
        if (this.p0 == 0) {
            i = eVar.i(c.a.TOP);
            i2 = eVar.i(c.a.BOTTOM);
            d dVar3 = this.P;
            if (dVar3 == null || dVar3.O[1] != aVar) {
                z2 = false;
            }
            z3 = z2;
        }
        if (this.q0) {
            c cVar = this.o0;
            if (cVar.f338c) {
                b.f.b.g l4 = dVar.l(cVar);
                dVar.e(l4, this.o0.c());
                if (this.m0 != -1) {
                    if (z3) {
                        l3 = dVar.l(i2);
                        dVar.f(l3, l4, 0, 5);
                    }
                    this.q0 = false;
                    return;
                }
                if (this.n0 != -1 && z3) {
                    l3 = dVar.l(i2);
                    dVar.f(l4, dVar.l(i), 0, 5);
                    dVar.f(l3, l4, 0, 5);
                }
                this.q0 = false;
                return;
            }
        }
        if (this.m0 != -1) {
            l = dVar.l(this.o0);
            dVar.d(l, dVar.l(i), this.m0, 8);
            if (!z3) {
                return;
            }
            l2 = dVar.l(i2);
        } else if (this.n0 == -1) {
            if (this.l0 == -1.0f) {
                return;
            }
            b.f.b.g l5 = dVar.l(this.o0);
            b.f.b.g l6 = dVar.l(i2);
            float f = this.l0;
            b.f.b.b m = dVar.m();
            m.d.j(l5, -1.0f);
            m.d.j(l6, f);
            dVar.c(m);
            return;
        } else {
            l = dVar.l(this.o0);
            l2 = dVar.l(i2);
            dVar.d(l, l2, -this.n0, 8);
            if (!z3) {
                return;
            }
            dVar.f(l, dVar.l(i), 0, 5);
        }
        dVar.f(l2, l, 0, 5);
    }

    @Override // b.f.b.h.d
    public boolean e() {
        return true;
    }

    @Override // b.f.b.h.d
    public c i(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
            case 3:
                if (this.p0 == 1) {
                    return this.o0;
                }
                break;
            case 2:
            case 4:
                if (this.p0 == 0) {
                    return this.o0;
                }
                break;
        }
        throw new AssertionError(aVar.name());
    }

    @Override // b.f.b.h.d
    public boolean z() {
        return this.q0;
    }
}
