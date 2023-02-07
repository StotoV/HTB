package b.f.b.h.l;
/* loaded from: classes.dex */
public class i extends o {
    public i(b.f.b.h.d dVar) {
        super(dVar);
        dVar.d.f();
        dVar.e.f();
        this.f = ((b.f.b.h.f) dVar).p0;
    }

    @Override // b.f.b.h.l.o, b.f.b.h.l.d
    public void a(d dVar) {
        f fVar = this.h;
        if (fVar.f352c && !fVar.j) {
            this.h.c((int) ((fVar.l.get(0).g * ((b.f.b.h.f) this.f359b).l0) + 0.5f));
        }
    }

    @Override // b.f.b.h.l.o
    public void d() {
        o oVar;
        b.f.b.h.d dVar = this.f359b;
        b.f.b.h.f fVar = (b.f.b.h.f) dVar;
        int i = fVar.m0;
        int i2 = fVar.n0;
        if (fVar.p0 == 1) {
            f fVar2 = this.h;
            if (i != -1) {
                fVar2.l.add(dVar.P.d.h);
                this.f359b.P.d.h.k.add(this.h);
                this.h.f = i;
            } else if (i2 != -1) {
                fVar2.l.add(dVar.P.d.i);
                this.f359b.P.d.i.k.add(this.h);
                this.h.f = -i2;
            } else {
                fVar2.f351b = true;
                fVar2.l.add(dVar.P.d.i);
                this.f359b.P.d.i.k.add(this.h);
            }
            m(this.f359b.d.h);
            oVar = this.f359b.d;
        } else {
            f fVar3 = this.h;
            if (i != -1) {
                fVar3.l.add(dVar.P.e.h);
                this.f359b.P.e.h.k.add(this.h);
                this.h.f = i;
            } else if (i2 != -1) {
                fVar3.l.add(dVar.P.e.i);
                this.f359b.P.e.i.k.add(this.h);
                this.h.f = -i2;
            } else {
                fVar3.f351b = true;
                fVar3.l.add(dVar.P.e.i);
                this.f359b.P.e.i.k.add(this.h);
            }
            m(this.f359b.e.h);
            oVar = this.f359b.e;
        }
        m(oVar.i);
    }

    @Override // b.f.b.h.l.o
    public void e() {
        b.f.b.h.d dVar = this.f359b;
        if (((b.f.b.h.f) dVar).p0 == 1) {
            dVar.U = this.h.g;
        } else {
            dVar.V = this.h.g;
        }
    }

    @Override // b.f.b.h.l.o
    public void f() {
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
