package b.f.b.h.l;

import b.f.b.h.c;
import b.f.b.h.d;
import b.f.b.h.l.f;
import b.f.b.h.l.o;
import java.util.List;
/* loaded from: classes.dex */
public class k extends o {
    public static int[] k = new int[2];

    public k(b.f.b.h.d dVar) {
        super(dVar);
        this.h.e = f.a.LEFT;
        this.i.e = f.a.RIGHT;
        this.f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x026c, code lost:
        if (r15 != 1) goto L131;
     */
    @Override // b.f.b.h.l.o, b.f.b.h.l.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(b.f.b.h.l.d r18) {
        /*
            Method dump skipped, instructions count: 982
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.l.k.a(b.f.b.h.l.d):void");
    }

    @Override // b.f.b.h.l.o
    public void d() {
        b.f.b.h.d dVar;
        b.f.b.h.d dVar2;
        f fVar;
        b.f.b.h.c cVar;
        List<d> list;
        d dVar3;
        f fVar2;
        f fVar3;
        f fVar4;
        int i;
        b.f.b.h.d dVar4;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.MATCH_PARENT;
        d.a aVar3 = d.a.FIXED;
        b.f.b.h.d dVar5 = this.f359b;
        if (dVar5.a) {
            this.e.c(dVar5.r());
        }
        if (!this.e.j) {
            d.a m = this.f359b.m();
            this.d = m;
            if (m != aVar) {
                if (m == aVar2 && (((dVar4 = this.f359b.P) != null && dVar4.m() == aVar3) || dVar4.m() == aVar2)) {
                    int r = (dVar4.r() - this.f359b.D.d()) - this.f359b.F.d();
                    b(this.h, dVar4.d.h, this.f359b.D.d());
                    b(this.i, dVar4.d.i, -this.f359b.F.d());
                    this.e.c(r);
                    return;
                } else if (this.d == aVar3) {
                    this.e.c(this.f359b.r());
                }
            }
        } else if (this.d == aVar2 && (((dVar = this.f359b.P) != null && dVar.m() == aVar3) || dVar.m() == aVar2)) {
            b(this.h, dVar.d.h, this.f359b.D.d());
            b(this.i, dVar.d.i, -this.f359b.F.d());
            return;
        }
        g gVar = this.e;
        if (gVar.j) {
            b.f.b.h.d dVar6 = this.f359b;
            if (dVar6.a) {
                b.f.b.h.c[] cVarArr = dVar6.L;
                if (cVarArr[0].f != null && cVarArr[1].f != null) {
                    if (dVar6.w()) {
                        this.h.f = this.f359b.L[0].d();
                        fVar = this.i;
                        cVar = this.f359b.L[1];
                        fVar.f = -cVar.d();
                        return;
                    }
                    f h = h(this.f359b.L[0]);
                    if (h != null) {
                        f fVar5 = this.h;
                        int d = this.f359b.L[0].d();
                        fVar5.l.add(h);
                        fVar5.f = d;
                        h.k.add(fVar5);
                    }
                    f h2 = h(this.f359b.L[1]);
                    if (h2 != null) {
                        f fVar6 = this.i;
                        fVar6.l.add(h2);
                        fVar6.f = -this.f359b.L[1].d();
                        h2.k.add(fVar6);
                    }
                    this.h.f351b = true;
                    this.i.f351b = true;
                    return;
                }
                if (cVarArr[0].f != null) {
                    f h3 = h(cVarArr[0]);
                    if (h3 == null) {
                        return;
                    }
                    f fVar7 = this.h;
                    int d2 = this.f359b.L[0].d();
                    fVar7.l.add(h3);
                    fVar7.f = d2;
                    h3.k.add(fVar7);
                } else if (cVarArr[1].f != null) {
                    f h4 = h(cVarArr[1]);
                    if (h4 == null) {
                        return;
                    }
                    f fVar8 = this.i;
                    fVar8.l.add(h4);
                    fVar8.f = -this.f359b.L[1].d();
                    h4.k.add(fVar8);
                    fVar3 = this.h;
                    fVar4 = this.i;
                    i = -this.e.g;
                    b(fVar3, fVar4, i);
                    return;
                } else if ((dVar6 instanceof b.f.b.h.g) || dVar6.P == null || dVar6.i(c.a.CENTER).f != null) {
                    return;
                } else {
                    b.f.b.h.d dVar7 = this.f359b;
                    b(this.h, dVar7.P.d.h, dVar7.s());
                }
                fVar3 = this.i;
                fVar4 = this.h;
                i = this.e.g;
                b(fVar3, fVar4, i);
                return;
            }
        }
        if (this.d == aVar) {
            b.f.b.h.d dVar8 = this.f359b;
            int i2 = dVar8.l;
            if (i2 == 2) {
                b.f.b.h.d dVar9 = dVar8.P;
                if (dVar9 != null) {
                    g gVar2 = dVar9.e.e;
                    gVar.l.add(gVar2);
                    gVar2.k.add(this.e);
                    g gVar3 = this.e;
                    gVar3.f351b = true;
                    gVar3.k.add(this.h);
                    list = this.e.k;
                    dVar3 = this.i;
                    list.add(dVar3);
                }
            } else if (i2 == 3) {
                if (dVar8.m == 3) {
                    this.h.a = this;
                    this.i.a = this;
                    m mVar = dVar8.e;
                    mVar.h.a = this;
                    mVar.i.a = this;
                    gVar.a = this;
                    if (dVar8.x()) {
                        this.e.l.add(this.f359b.e.e);
                        this.f359b.e.e.k.add(this.e);
                        m mVar2 = this.f359b.e;
                        mVar2.e.a = this;
                        this.e.l.add(mVar2.h);
                        this.e.l.add(this.f359b.e.i);
                        this.f359b.e.h.k.add(this.e);
                        list = this.f359b.e.i.k;
                        dVar3 = this.e;
                        list.add(dVar3);
                    } else if (this.f359b.w()) {
                        this.f359b.e.e.l.add(this.e);
                        list = this.e.k;
                        dVar3 = this.f359b.e.e;
                        list.add(dVar3);
                    } else {
                        fVar2 = this.f359b.e.e;
                    }
                } else {
                    g gVar4 = dVar8.e.e;
                    gVar.l.add(gVar4);
                    gVar4.k.add(this.e);
                    this.f359b.e.h.k.add(this.e);
                    this.f359b.e.i.k.add(this.e);
                    g gVar5 = this.e;
                    gVar5.f351b = true;
                    gVar5.k.add(this.h);
                    this.e.k.add(this.i);
                    this.h.l.add(this.e);
                    fVar2 = this.i;
                }
                list = fVar2.l;
                dVar3 = this.e;
                list.add(dVar3);
            }
            fVar.f = -cVar.d();
            return;
        }
        b.f.b.h.d dVar10 = this.f359b;
        b.f.b.h.c[] cVarArr2 = dVar10.L;
        if (cVarArr2[0].f != null && cVarArr2[1].f != null) {
            if (dVar10.w()) {
                this.h.f = this.f359b.L[0].d();
                fVar = this.i;
                cVar = this.f359b.L[1];
                fVar.f = -cVar.d();
                return;
            }
            f h5 = h(this.f359b.L[0]);
            f h6 = h(this.f359b.L[1]);
            h5.k.add(this);
            if (h5.j) {
                a(this);
            }
            h6.k.add(this);
            if (h6.j) {
                a(this);
            }
            this.j = o.a.CENTER;
            return;
        }
        if (cVarArr2[0].f != null) {
            f h7 = h(cVarArr2[0]);
            if (h7 == null) {
                return;
            }
            f fVar9 = this.h;
            int d3 = this.f359b.L[0].d();
            fVar9.l.add(h7);
            fVar9.f = d3;
            h7.k.add(fVar9);
        } else if (cVarArr2[1].f != null) {
            f h8 = h(cVarArr2[1]);
            if (h8 == null) {
                return;
            }
            f fVar10 = this.i;
            fVar10.l.add(h8);
            fVar10.f = -this.f359b.L[1].d();
            h8.k.add(fVar10);
            c(this.h, this.i, -1, this.e);
            return;
        } else if ((dVar10 instanceof b.f.b.h.g) || (dVar2 = dVar10.P) == null) {
            return;
        } else {
            b(this.h, dVar2.d.h, dVar10.s());
        }
        c(this.i, this.h, 1, this.e);
    }

    @Override // b.f.b.h.l.o
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f359b.U = fVar.g;
        }
    }

    @Override // b.f.b.h.l.o
    public void f() {
        this.f360c = null;
        this.h.b();
        this.i.b();
        this.e.b();
        this.g = false;
    }

    @Override // b.f.b.h.l.o
    public boolean k() {
        return this.d != d.a.MATCH_CONSTRAINT || this.f359b.l == 0;
    }

    public final void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else if (i5 != 1) {
                return;
            } else {
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6 && i7 <= i7) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i6 > i6 || i9 > i7) {
        } else {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    public void n() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("HorizontalRun ");
        g.append(this.f359b.d0);
        return g.toString();
    }
}
