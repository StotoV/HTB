package b.f.b.h.l;

import b.f.b.h.l.f;
/* loaded from: classes.dex */
public class j extends o {
    public j(b.f.b.h.d dVar) {
        super(dVar);
    }

    @Override // b.f.b.h.l.o, b.f.b.h.l.d
    public void a(d dVar) {
        b.f.b.h.a aVar = (b.f.b.h.a) this.f359b;
        int i = aVar.n0;
        int i2 = 0;
        int i3 = -1;
        for (f fVar : this.h.l) {
            int i4 = fVar.g;
            if (i3 == -1 || i4 < i3) {
                i3 = i4;
            }
            if (i2 < i4) {
                i2 = i4;
            }
        }
        if (i != 0 && i != 2) {
            this.h.c(i2 + aVar.p0);
        } else {
            this.h.c(i3 + aVar.p0);
        }
    }

    @Override // b.f.b.h.l.o
    public void d() {
        o oVar;
        b.f.b.h.d dVar = this.f359b;
        if (dVar instanceof b.f.b.h.a) {
            f fVar = this.h;
            fVar.f351b = true;
            b.f.b.h.a aVar = (b.f.b.h.a) dVar;
            int i = aVar.n0;
            boolean z = aVar.o0;
            int i2 = 0;
            if (i == 0) {
                fVar.e = f.a.LEFT;
                while (i2 < aVar.m0) {
                    b.f.b.h.d dVar2 = aVar.l0[i2];
                    if (z || dVar2.c0 != 8) {
                        f fVar2 = dVar2.d.h;
                        fVar2.k.add(this.h);
                        this.h.l.add(fVar2);
                    }
                    i2++;
                }
            } else if (i != 1) {
                if (i == 2) {
                    fVar.e = f.a.TOP;
                    while (i2 < aVar.m0) {
                        b.f.b.h.d dVar3 = aVar.l0[i2];
                        if (z || dVar3.c0 != 8) {
                            f fVar3 = dVar3.e.h;
                            fVar3.k.add(this.h);
                            this.h.l.add(fVar3);
                        }
                        i2++;
                    }
                } else if (i != 3) {
                    return;
                } else {
                    fVar.e = f.a.BOTTOM;
                    while (i2 < aVar.m0) {
                        b.f.b.h.d dVar4 = aVar.l0[i2];
                        if (z || dVar4.c0 != 8) {
                            f fVar4 = dVar4.e.i;
                            fVar4.k.add(this.h);
                            this.h.l.add(fVar4);
                        }
                        i2++;
                    }
                }
                m(this.f359b.e.h);
                oVar = this.f359b.e;
                m(oVar.i);
            } else {
                fVar.e = f.a.RIGHT;
                while (i2 < aVar.m0) {
                    b.f.b.h.d dVar5 = aVar.l0[i2];
                    if (z || dVar5.c0 != 8) {
                        f fVar5 = dVar5.d.i;
                        fVar5.k.add(this.h);
                        this.h.l.add(fVar5);
                    }
                    i2++;
                }
            }
            m(this.f359b.d.h);
            oVar = this.f359b.d;
            m(oVar.i);
        }
    }

    @Override // b.f.b.h.l.o
    public void e() {
        b.f.b.h.d dVar = this.f359b;
        if (dVar instanceof b.f.b.h.a) {
            int i = ((b.f.b.h.a) dVar).n0;
            if (i != 0 && i != 1) {
                dVar.V = this.h.g;
            } else {
                dVar.U = this.h.g;
            }
        }
    }

    @Override // b.f.b.h.l.o
    public void f() {
        this.f360c = null;
        this.h.b();
    }

    @Override // b.f.b.h.l.o
    public boolean k() {
        return false;
    }

    public final void m(f fVar) {
        this.h.k.add(fVar);
        fVar.l.add(this.h);
    }
}
