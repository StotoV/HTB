package b.f.b.h.l;

import b.f.b.h.d;
import b.f.b.h.l.f;
/* loaded from: classes.dex */
public class m extends o {
    public f k;
    public g l;

    public m(b.f.b.h.d dVar) {
        super(dVar);
        f fVar = new f(this);
        this.k = fVar;
        this.l = null;
        this.h.e = f.a.TOP;
        this.i.e = f.a.BOTTOM;
        fVar.e = f.a.BASELINE;
        this.f = 1;
    }

    @Override // b.f.b.h.l.o, b.f.b.h.l.d
    public void a(d dVar) {
        float f;
        float f2;
        float f3;
        int i;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        int ordinal = this.j.ordinal();
        if (ordinal != 1 && ordinal != 2 && ordinal == 3) {
            b.f.b.h.d dVar2 = this.f359b;
            l(dVar2.E, dVar2.G, 1);
            return;
        }
        g gVar = this.e;
        if (gVar.f352c && !gVar.j && this.d == aVar) {
            b.f.b.h.d dVar3 = this.f359b;
            int i2 = dVar3.m;
            if (i2 == 2) {
                b.f.b.h.d dVar4 = dVar3.P;
                if (dVar4 != null) {
                    g gVar2 = dVar4.e.e;
                    if (gVar2.j) {
                        f = dVar3.t;
                        f2 = gVar2.g;
                        f3 = f2 * f;
                    }
                }
            } else if (i2 == 3) {
                g gVar3 = dVar3.d.e;
                if (gVar3.j) {
                    int i3 = dVar3.T;
                    if (i3 != -1) {
                        if (i3 == 0) {
                            f2 = gVar3.g;
                            f = dVar3.S;
                            f3 = f2 * f;
                        } else if (i3 != 1) {
                            i = 0;
                            gVar.c(i);
                        }
                    }
                    f3 = gVar3.g / dVar3.S;
                }
            }
            i = (int) (f3 + 0.5f);
            gVar.c(i);
        }
        f fVar = this.h;
        if (!fVar.f352c) {
            return;
        }
        f fVar2 = this.i;
        if (!fVar2.f352c) {
            return;
        }
        if (fVar.j && fVar2.j && this.e.j) {
            return;
        }
        if (!this.e.j && this.d == aVar) {
            b.f.b.h.d dVar5 = this.f359b;
            if (dVar5.l == 0 && !dVar5.x()) {
                int i4 = this.h.l.get(0).g;
                f fVar3 = this.h;
                int i5 = i4 + fVar3.f;
                int i6 = this.i.l.get(0).g + this.i.f;
                fVar3.c(i5);
                this.i.c(i6);
                this.e.c(i6 - i5);
                return;
            }
        }
        if (!this.e.j && this.d == aVar && this.a == 1 && this.h.l.size() > 0 && this.i.l.size() > 0) {
            int i7 = (this.i.l.get(0).g + this.i.f) - (this.h.l.get(0).g + this.h.f);
            g gVar4 = this.e;
            int i8 = gVar4.m;
            if (i7 < i8) {
                gVar4.c(i7);
            } else {
                gVar4.c(i8);
            }
        }
        if (!this.e.j || this.h.l.size() <= 0 || this.i.l.size() <= 0) {
            return;
        }
        f fVar4 = this.h.l.get(0);
        f fVar5 = this.i.l.get(0);
        int i9 = fVar4.g;
        f fVar6 = this.h;
        int i10 = fVar6.f + i9;
        int i11 = fVar5.g;
        int i12 = this.i.f + i11;
        float f4 = this.f359b.a0;
        if (fVar4 == fVar5) {
            f4 = 0.5f;
        } else {
            i9 = i10;
            i11 = i12;
        }
        fVar6.c((int) ((((i11 - i9) - this.e.g) * f4) + i9 + 0.5f));
        this.i.c(this.h.g + this.e.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x031c, code lost:
        if (r10.f359b.y != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x031e, code lost:
        r0 = r10.k;
        r1 = r10.h;
        r2 = r10.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0378, code lost:
        if (r0.d == r2) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x03b1, code lost:
        if (r10.f359b.y != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x041f, code lost:
        if (r0.d == r2) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0421, code lost:
        r0.e.k.add(r10.e);
        r10.e.l.add(r10.f359b.d.e);
        r10.e.a = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    @Override // b.f.b.h.l.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instructions count: 1098
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.l.m.d():void");
    }

    @Override // b.f.b.h.l.o
    public void e() {
        f fVar = this.h;
        if (fVar.j) {
            this.f359b.V = fVar.g;
        }
    }

    @Override // b.f.b.h.l.o
    public void f() {
        this.f360c = null;
        this.h.b();
        this.i.b();
        this.k.b();
        this.e.b();
        this.g = false;
    }

    @Override // b.f.b.h.l.o
    public boolean k() {
        return this.d != d.a.MATCH_CONSTRAINT || this.f359b.m == 0;
    }

    public void m() {
        this.g = false;
        this.h.b();
        this.h.j = false;
        this.i.b();
        this.i.j = false;
        this.k.b();
        this.k.j = false;
        this.e.j = false;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("VerticalRun ");
        g.append(this.f359b.d0);
        return g.toString();
    }
}
