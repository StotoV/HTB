package b.f.b.h;

import b.f.b.h.c;
import b.f.b.h.d;
/* loaded from: classes.dex */
public class a extends h {
    public int n0 = 0;
    public boolean o0 = true;
    public int p0 = 0;
    public boolean q0 = false;

    @Override // b.f.b.h.d
    public boolean A() {
        return this.q0;
    }

    public boolean Q() {
        int i;
        c i2;
        c i3;
        c i4;
        int i5;
        int i6;
        c.a aVar = c.a.BOTTOM;
        c.a aVar2 = c.a.TOP;
        c.a aVar3 = c.a.RIGHT;
        c.a aVar4 = c.a.LEFT;
        int i7 = 0;
        boolean z = true;
        while (true) {
            i = this.m0;
            if (i7 >= i) {
                break;
            }
            d dVar = this.l0[i7];
            if ((this.o0 || dVar.e()) && ((((i5 = this.n0) == 0 || i5 == 1) && !dVar.z()) || (((i6 = this.n0) == 2 || i6 == 3) && !dVar.A()))) {
                z = false;
            }
            i7++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int i8 = 0;
        boolean z2 = false;
        for (int i9 = 0; i9 < this.m0; i9++) {
            d dVar2 = this.l0[i9];
            if (this.o0 || dVar2.e()) {
                if (!z2) {
                    int i10 = this.n0;
                    if (i10 == 0) {
                        i4 = dVar2.i(aVar4);
                    } else if (i10 == 1) {
                        i4 = dVar2.i(aVar3);
                    } else if (i10 == 2) {
                        i4 = dVar2.i(aVar2);
                    } else {
                        if (i10 == 3) {
                            i4 = dVar2.i(aVar);
                        }
                        z2 = true;
                    }
                    i8 = i4.c();
                    z2 = true;
                }
                int i11 = this.n0;
                if (i11 == 0) {
                    i3 = dVar2.i(aVar4);
                } else {
                    if (i11 == 1) {
                        i2 = dVar2.i(aVar3);
                    } else if (i11 == 2) {
                        i3 = dVar2.i(aVar2);
                    } else if (i11 == 3) {
                        i2 = dVar2.i(aVar);
                    }
                    i8 = Math.max(i8, i2.c());
                }
                i8 = Math.min(i8, i3.c());
            }
        }
        int i12 = i8 + this.p0;
        int i13 = this.n0;
        if (i13 == 0 || i13 == 1) {
            F(i12, i12);
        } else {
            G(i12, i12);
        }
        this.q0 = true;
        return true;
    }

    public int R() {
        int i = this.n0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // b.f.b.h.d
    public void d(b.f.b.d dVar, boolean z) {
        Object[] objArr;
        boolean z2;
        b.f.b.g gVar;
        c cVar;
        int i;
        int i2;
        int i3;
        b.f.b.g gVar2;
        int i4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        c[] cVarArr = this.L;
        cVarArr[0] = this.D;
        cVarArr[2] = this.E;
        cVarArr[1] = this.F;
        cVarArr[3] = this.G;
        int i5 = 0;
        while (true) {
            objArr = this.L;
            if (i5 >= objArr.length) {
                break;
            }
            objArr[i5].i = dVar.l(objArr[i5]);
            i5++;
        }
        int i6 = this.n0;
        if (i6 < 0 || i6 >= 4) {
            return;
        }
        c cVar2 = objArr[i6];
        if (!this.q0) {
            Q();
        }
        if (this.q0) {
            this.q0 = false;
            int i7 = this.n0;
            if (i7 == 0 || i7 == 1) {
                dVar.e(this.D.i, this.U);
                gVar2 = this.F.i;
                i4 = this.U;
            } else if (i7 != 2 && i7 != 3) {
                return;
            } else {
                dVar.e(this.E.i, this.V);
                gVar2 = this.G.i;
                i4 = this.V;
            }
            dVar.e(gVar2, i4);
            return;
        }
        for (int i8 = 0; i8 < this.m0; i8++) {
            d dVar2 = this.l0[i8];
            if ((this.o0 || dVar2.e()) && ((((i2 = this.n0) == 0 || i2 == 1) && dVar2.m() == aVar && dVar2.D.f != null && dVar2.F.f != null) || (((i3 = this.n0) == 2 || i3 == 3) && dVar2.q() == aVar && dVar2.E.f != null && dVar2.G.f != null))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        boolean z3 = this.D.e() || this.F.e();
        boolean z4 = this.E.e() || this.G.e();
        boolean z5 = !z2 && (((i = this.n0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))));
        int i9 = 5;
        if (!z5) {
            i9 = 4;
        }
        for (int i10 = 0; i10 < this.m0; i10++) {
            d dVar3 = this.l0[i10];
            if (this.o0 || dVar3.e()) {
                b.f.b.g l = dVar.l(dVar3.L[this.n0]);
                c[] cVarArr2 = dVar3.L;
                int i11 = this.n0;
                cVarArr2[i11].i = l;
                int i12 = (cVarArr2[i11].f == null || cVarArr2[i11].f.d != this) ? 0 : cVarArr2[i11].g + 0;
                if (i11 != 0 && i11 != 2) {
                    b.f.b.b m = dVar.m();
                    b.f.b.g n = dVar.n();
                    n.d = 0;
                    m.e(cVar2.i, l, n, this.p0 + i12);
                    dVar.c(m);
                } else {
                    b.f.b.b m2 = dVar.m();
                    b.f.b.g n2 = dVar.n();
                    n2.d = 0;
                    m2.f(cVar2.i, l, n2, this.p0 - i12);
                    dVar.c(m2);
                }
                dVar.d(cVar2.i, l, this.p0 + i12, i9);
            }
        }
        int i13 = this.n0;
        if (i13 == 0) {
            dVar.d(this.F.i, this.D.i, 0, 8);
            dVar.d(this.D.i, this.P.F.i, 0, 4);
            gVar = this.D.i;
            cVar = this.P.D;
        } else if (i13 == 1) {
            dVar.d(this.D.i, this.F.i, 0, 8);
            dVar.d(this.D.i, this.P.D.i, 0, 4);
            gVar = this.D.i;
            cVar = this.P.F;
        } else if (i13 == 2) {
            dVar.d(this.G.i, this.E.i, 0, 8);
            dVar.d(this.E.i, this.P.G.i, 0, 4);
            gVar = this.E.i;
            cVar = this.P.E;
        } else if (i13 != 3) {
            return;
        } else {
            dVar.d(this.E.i, this.G.i, 0, 8);
            dVar.d(this.E.i, this.P.E.i, 0, 4);
            gVar = this.E.i;
            cVar = this.P.G;
        }
        dVar.d(gVar, cVar.i, 0, 0);
    }

    @Override // b.f.b.h.d
    public boolean e() {
        return true;
    }

    @Override // b.f.b.h.d
    public String toString() {
        StringBuilder g = c.a.a.a.a.g("[Barrier] ");
        g.append(this.d0);
        g.append(" {");
        String sb = g.toString();
        for (int i = 0; i < this.m0; i++) {
            d dVar = this.l0[i];
            if (i > 0) {
                sb = c.a.a.a.a.d(sb, ", ");
            }
            StringBuilder g2 = c.a.a.a.a.g(sb);
            g2.append(dVar.d0);
            sb = g2.toString();
        }
        return c.a.a.a.a.d(sb, "}");
    }

    @Override // b.f.b.h.d
    public boolean z() {
        return this.q0;
    }
}
