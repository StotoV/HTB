package b.f.b;

import b.f.b.d;
import b.f.b.g;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b implements d.a {
    public a d;
    public g a = null;

    /* renamed from: b  reason: collision with root package name */
    public float f322b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<g> f323c = new ArrayList<>();
    public boolean e = false;

    /* loaded from: classes.dex */
    public interface a {
        float a(int i);

        float b(g gVar, boolean z);

        void c(g gVar, float f, boolean z);

        void clear();

        g d(int i);

        float e(g gVar);

        float f(b bVar, boolean z);

        boolean g(g gVar);

        void h(float f);

        void i();

        void j(g gVar, float f);

        int k();
    }

    public b() {
    }

    public b(c cVar) {
        this.d = new b.f.b.a(this, cVar);
    }

    @Override // b.f.b.d.a
    public void a(g gVar) {
        float f;
        int i = gVar.d;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
            this.d.j(gVar, f);
        }
        f = 1.0f;
        this.d.j(gVar, f);
    }

    @Override // b.f.b.d.a
    public g b(d dVar, boolean[] zArr) {
        return i(zArr, null);
    }

    public b c(d dVar, int i) {
        this.d.j(dVar.k(i, "ep"), 1.0f);
        this.d.j(dVar.k(i, "em"), -1.0f);
        return this;
    }

    @Override // b.f.b.d.a
    public void clear() {
        this.d.clear();
        this.a = null;
        this.f322b = 0.0f;
    }

    public b d(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.d.j(gVar, -1.0f);
        this.d.j(gVar2, 1.0f);
        this.d.j(gVar3, f);
        this.d.j(gVar4, -f);
        return this;
    }

    public b e(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f322b = i;
        }
        if (!z) {
            this.d.j(gVar, -1.0f);
            this.d.j(gVar2, 1.0f);
            this.d.j(gVar3, 1.0f);
        } else {
            this.d.j(gVar, 1.0f);
            this.d.j(gVar2, -1.0f);
            this.d.j(gVar3, -1.0f);
        }
        return this;
    }

    public b f(g gVar, g gVar2, g gVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f322b = i;
        }
        if (!z) {
            this.d.j(gVar, -1.0f);
            this.d.j(gVar2, 1.0f);
            this.d.j(gVar3, -1.0f);
        } else {
            this.d.j(gVar, 1.0f);
            this.d.j(gVar2, -1.0f);
            this.d.j(gVar3, 1.0f);
        }
        return this;
    }

    public b g(g gVar, g gVar2, g gVar3, g gVar4, float f) {
        this.d.j(gVar3, 0.5f);
        this.d.j(gVar4, 0.5f);
        this.d.j(gVar, -0.5f);
        this.d.j(gVar2, -0.5f);
        this.f322b = -f;
        return this;
    }

    public final boolean h(g gVar) {
        return gVar.l <= 1;
    }

    public final g i(boolean[] zArr, g gVar) {
        g.a aVar;
        int k = this.d.k();
        g gVar2 = null;
        float f = 0.0f;
        for (int i = 0; i < k; i++) {
            float a2 = this.d.a(i);
            if (a2 < 0.0f) {
                g d = this.d.d(i);
                if ((zArr == null || !zArr[d.f331b]) && d != gVar && (((aVar = d.i) == g.a.SLACK || aVar == g.a.ERROR) && a2 < f)) {
                    f = a2;
                    gVar2 = d;
                }
            }
        }
        return gVar2;
    }

    @Override // b.f.b.d.a
    public boolean isEmpty() {
        return this.a == null && this.f322b == 0.0f && this.d.k() == 0;
    }

    public void j(g gVar) {
        g gVar2 = this.a;
        if (gVar2 != null) {
            this.d.j(gVar2, -1.0f);
            this.a.f332c = -1;
            this.a = null;
        }
        float b2 = this.d.b(gVar, true) * (-1.0f);
        this.a = gVar;
        if (b2 == 1.0f) {
            return;
        }
        this.f322b /= b2;
        this.d.h(b2);
    }

    public void k(d dVar, g gVar, boolean z) {
        if (!gVar.f) {
            return;
        }
        float e = this.d.e(gVar);
        this.f322b = (gVar.e * e) + this.f322b;
        this.d.b(gVar, z);
        if (z) {
            gVar.b(this);
        }
        if (this.d.k() != 0) {
            return;
        }
        this.e = true;
        dVar.a = true;
    }

    public void l(d dVar, b bVar, boolean z) {
        float f = this.d.f(bVar, z);
        this.f322b = (bVar.f322b * f) + this.f322b;
        if (z) {
            bVar.a.b(this);
        }
        if (this.a == null || this.d.k() != 0) {
            return;
        }
        this.e = true;
        dVar.a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r8 = this;
            b.f.b.g r0 = r8.a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L16
        L7:
            java.lang.String r0 = ""
            java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
            b.f.b.g r1 = r8.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L16:
            java.lang.String r1 = " = "
            java.lang.String r0 = c.a.a.a.a.d(r0, r1)
            float r1 = r8.f322b
            r2 = 0
            r3 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L33
            java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
            float r1 = r8.f322b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L34
        L33:
            r1 = 0
        L34:
            b.f.b.b$a r4 = r8.d
            int r4 = r4.k()
        L3a:
            if (r3 >= r4) goto La4
            b.f.b.b$a r5 = r8.d
            b.f.b.g r5 = r5.d(r3)
            if (r5 != 0) goto L45
            goto La1
        L45:
            b.f.b.b$a r6 = r8.d
            float r6 = r6.a(r3)
            int r7 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r7 != 0) goto L50
            goto La1
        L50:
            java.lang.String r5 = r5.toString()
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L63
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 >= 0) goto L7d
            java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
            java.lang.String r1 = "- "
            goto L74
        L63:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L6e
            java.lang.String r1 = " + "
            java.lang.String r0 = c.a.a.a.a.d(r0, r1)
            goto L7d
        L6e:
            java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
            java.lang.String r1 = " - "
        L74:
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            float r6 = r6 * r7
        L7d:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 != 0) goto L89
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L96
        L89:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = " "
        L96:
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = r1.toString()
            r1 = 1
        La1:
            int r3 = r3 + 1
            goto L3a
        La4:
            if (r1 != 0) goto Lac
            java.lang.String r1 = "0.0"
            java.lang.String r0 = c.a.a.a.a.d(r0, r1)
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.b.toString():java.lang.String");
    }
}
