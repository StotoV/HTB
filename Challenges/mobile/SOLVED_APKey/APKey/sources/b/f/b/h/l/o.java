package b.f.b.h.l;

import b.f.b.h.d;
/* loaded from: classes.dex */
public abstract class o implements d {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public b.f.b.h.d f359b;

    /* renamed from: c  reason: collision with root package name */
    public l f360c;
    public d.a d;
    public g e = new g(this);
    public int f = 0;
    public boolean g = false;
    public f h = new f(this);
    public f i = new f(this);
    public a j = a.NONE;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        START,
        END,
        CENTER
    }

    public o(b.f.b.h.d dVar) {
        this.f359b = dVar;
    }

    @Override // b.f.b.h.l.d
    public void a(d dVar) {
    }

    public final void b(f fVar, f fVar2, int i) {
        fVar.l.add(fVar2);
        fVar.f = i;
        fVar2.k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i, g gVar) {
        fVar.l.add(fVar2);
        fVar.l.add(this.e);
        fVar.h = i;
        fVar.i = gVar;
        fVar2.k.add(fVar);
        gVar.k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        int max;
        if (i2 == 0) {
            b.f.b.h.d dVar = this.f359b;
            int i3 = dVar.p;
            max = Math.max(dVar.o, i);
            if (i3 > 0) {
                max = Math.min(i3, i);
            }
            if (max == i) {
                return i;
            }
        } else {
            b.f.b.h.d dVar2 = this.f359b;
            int i4 = dVar2.s;
            max = Math.max(dVar2.r, i);
            if (i4 > 0) {
                max = Math.min(i4, i);
            }
            if (max == i) {
                return i;
            }
        }
        return max;
    }

    public final f h(b.f.b.h.c cVar) {
        o oVar;
        o oVar2;
        b.f.b.h.c cVar2 = cVar.f;
        if (cVar2 == null) {
            return null;
        }
        b.f.b.h.d dVar = cVar2.d;
        int ordinal = cVar2.e.ordinal();
        if (ordinal == 1) {
            oVar = dVar.d;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                oVar2 = dVar.d;
            } else if (ordinal != 4) {
                if (ordinal == 5) {
                    return dVar.e.k;
                }
                return null;
            } else {
                oVar2 = dVar.e;
            }
            return oVar2.i;
        } else {
            oVar = dVar.e;
        }
        return oVar.h;
    }

    public final f i(b.f.b.h.c cVar, int i) {
        b.f.b.h.c cVar2 = cVar.f;
        if (cVar2 == null) {
            return null;
        }
        b.f.b.h.d dVar = cVar2.d;
        o oVar = i == 0 ? dVar.d : dVar.e;
        int ordinal = cVar2.e.ordinal();
        if (ordinal == 1 || ordinal == 2) {
            return oVar.h;
        }
        if (ordinal != 3 && ordinal != 4) {
            return null;
        }
        return oVar.i;
    }

    public long j() {
        g gVar = this.e;
        if (gVar.j) {
            return gVar.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
        if (r14.a == 3) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(b.f.b.h.c r18, b.f.b.h.c r19, int r20) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.l.o.l(b.f.b.h.c, b.f.b.h.c, int):void");
    }
}
