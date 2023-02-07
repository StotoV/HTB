package b.f.b;

import b.f.b.b;
import b.f.b.g;
import java.util.Arrays;
/* loaded from: classes.dex */
public class d {
    public static boolean p = false;
    public static int q = 1000;
    public static long r;

    /* renamed from: c  reason: collision with root package name */
    public a f327c;
    public b[] f;
    public final c l;
    public a o;
    public boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    public int f326b = 0;
    public int d = 32;
    public int e = 32;
    public boolean g = false;
    public boolean[] h = new boolean[32];
    public int i = 1;
    public int j = 0;
    public int k = 32;
    public g[] m = new g[q];
    public int n = 0;

    /* loaded from: classes.dex */
    public interface a {
        void a(g gVar);

        g b(d dVar, boolean[] zArr);

        void clear();

        boolean isEmpty();
    }

    public d() {
        this.f = null;
        this.f = new b[32];
        t();
        c cVar = new c();
        this.l = cVar;
        this.f327c = new f(cVar);
        this.o = new b(cVar);
    }

    public final g a(g.a aVar, String str) {
        g a2 = this.l.f325c.a();
        if (a2 == null) {
            a2 = new g(aVar);
        } else {
            a2.c();
        }
        a2.i = aVar;
        int i = this.n;
        int i2 = q;
        if (i >= i2) {
            int i3 = i2 * 2;
            q = i3;
            this.m = (g[]) Arrays.copyOf(this.m, i3);
        }
        g[] gVarArr = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        gVarArr[i4] = a2;
        return a2;
    }

    public void b(g gVar, g gVar2, int i, float f, g gVar3, g gVar4, int i2, int i3) {
        int i4;
        float f2;
        b m = m();
        if (gVar2 == gVar3) {
            m.d.j(gVar, 1.0f);
            m.d.j(gVar4, 1.0f);
            m.d.j(gVar2, -2.0f);
        } else {
            if (f == 0.5f) {
                m.d.j(gVar, 1.0f);
                m.d.j(gVar2, -1.0f);
                m.d.j(gVar3, -1.0f);
                m.d.j(gVar4, 1.0f);
                if (i > 0 || i2 > 0) {
                    i4 = (-i) + i2;
                    f2 = i4;
                }
            } else if (f <= 0.0f) {
                m.d.j(gVar, -1.0f);
                m.d.j(gVar2, 1.0f);
                f2 = i;
            } else if (f >= 1.0f) {
                m.d.j(gVar4, -1.0f);
                m.d.j(gVar3, 1.0f);
                i4 = -i2;
                f2 = i4;
            } else {
                float f3 = 1.0f - f;
                m.d.j(gVar, f3 * 1.0f);
                m.d.j(gVar2, f3 * (-1.0f));
                m.d.j(gVar3, (-1.0f) * f);
                m.d.j(gVar4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    m.f322b = (i2 * f) + ((-i) * f3);
                }
            }
            m.f322b = f2;
        }
        if (i3 != 8) {
            m.c(this, i3);
        }
        c(m);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01af A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(b.f.b.b r17) {
        /*
            Method dump skipped, instructions count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.d.c(b.f.b.b):void");
    }

    public b d(g gVar, g gVar2, int i, int i2) {
        if (i2 == 8 && gVar2.f && gVar.f332c == -1) {
            gVar.d(this, gVar2.e + i);
            return null;
        }
        b m = m();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            m.f322b = i;
        }
        if (!z) {
            m.d.j(gVar, -1.0f);
            m.d.j(gVar2, 1.0f);
        } else {
            m.d.j(gVar, 1.0f);
            m.d.j(gVar2, -1.0f);
        }
        if (i2 != 8) {
            m.c(this, i2);
        }
        c(m);
        return m;
    }

    public void e(g gVar, int i) {
        b m;
        b.a aVar;
        float f;
        int i2 = gVar.f332c;
        if (i2 == -1) {
            gVar.d(this, i);
            for (int i3 = 0; i3 < this.f326b + 1; i3++) {
                g gVar2 = this.l.d[i3];
            }
            return;
        }
        if (i2 != -1) {
            b bVar = this.f[i2];
            if (!bVar.e) {
                if (bVar.d.k() == 0) {
                    bVar.e = true;
                } else {
                    m = m();
                    if (i < 0) {
                        m.f322b = i * (-1);
                        aVar = m.d;
                        f = 1.0f;
                    } else {
                        m.f322b = i;
                        aVar = m.d;
                        f = -1.0f;
                    }
                    aVar.j(gVar, f);
                }
            }
            bVar.f322b = i;
            return;
        }
        m = m();
        m.a = gVar;
        float f2 = i;
        gVar.e = f2;
        m.f322b = f2;
        m.e = true;
        c(m);
    }

    public void f(g gVar, g gVar2, int i, int i2) {
        b m = m();
        g n = n();
        n.d = 0;
        m.e(gVar, gVar2, n, i);
        if (i2 != 8) {
            m.d.j(k(i2, null), (int) (m.d.e(n) * (-1.0f)));
        }
        c(m);
    }

    public void g(g gVar, g gVar2, int i, int i2) {
        b m = m();
        g n = n();
        n.d = 0;
        m.f(gVar, gVar2, n, i);
        if (i2 != 8) {
            m.d.j(k(i2, null), (int) (m.d.e(n) * (-1.0f)));
        }
        c(m);
    }

    public void h(g gVar, g gVar2, g gVar3, g gVar4, float f, int i) {
        b m = m();
        m.d(gVar, gVar2, gVar3, gVar4, f);
        if (i != 8) {
            m.c(this, i);
        }
        c(m);
    }

    public final void i(b bVar) {
        int i;
        if (bVar.e) {
            bVar.a.d(this, bVar.f322b);
        } else {
            b[] bVarArr = this.f;
            int i2 = this.j;
            bVarArr[i2] = bVar;
            g gVar = bVar.a;
            gVar.f332c = i2;
            this.j = i2 + 1;
            gVar.e(this, bVar);
        }
        if (this.a) {
            int i3 = 0;
            while (i3 < this.j) {
                if (this.f[i3] == null) {
                    System.out.println("WTF");
                }
                b[] bVarArr2 = this.f;
                if (bVarArr2[i3] != null && bVarArr2[i3].e) {
                    b bVar2 = bVarArr2[i3];
                    bVar2.a.d(this, bVar2.f322b);
                    this.l.f324b.b(bVar2);
                    this.f[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.j;
                        if (i4 >= i) {
                            break;
                        }
                        b[] bVarArr3 = this.f;
                        int i6 = i4 - 1;
                        bVarArr3[i6] = bVarArr3[i4];
                        if (bVarArr3[i6].a.f332c == i4) {
                            bVarArr3[i6].a.f332c = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.f[i5] = null;
                    }
                    this.j = i - 1;
                    i3--;
                }
                i3++;
            }
            this.a = false;
        }
    }

    public final void j() {
        for (int i = 0; i < this.j; i++) {
            b bVar = this.f[i];
            bVar.a.e = bVar.f322b;
        }
    }

    public g k(int i, String str) {
        if (this.i + 1 >= this.e) {
            p();
        }
        g a2 = a(g.a.ERROR, str);
        int i2 = this.f326b + 1;
        this.f326b = i2;
        this.i++;
        a2.f331b = i2;
        a2.d = i;
        this.l.d[i2] = a2;
        this.f327c.a(a2);
        return a2;
    }

    public g l(Object obj) {
        g gVar = null;
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.e) {
            p();
        }
        if (obj instanceof b.f.b.h.c) {
            b.f.b.h.c cVar = (b.f.b.h.c) obj;
            gVar = cVar.i;
            if (gVar == null) {
                cVar.i();
                gVar = cVar.i;
            }
            int i = gVar.f331b;
            if (i == -1 || i > this.f326b || this.l.d[i] == null) {
                if (i != -1) {
                    gVar.c();
                }
                int i2 = this.f326b + 1;
                this.f326b = i2;
                this.i++;
                gVar.f331b = i2;
                gVar.i = g.a.UNRESTRICTED;
                this.l.d[i2] = gVar;
            }
        }
        return gVar;
    }

    public b m() {
        b a2 = this.l.f324b.a();
        if (a2 == null) {
            a2 = new b(this.l);
            r++;
        } else {
            a2.a = null;
            a2.d.clear();
            a2.f322b = 0.0f;
            a2.e = false;
        }
        g.n++;
        return a2;
    }

    public g n() {
        if (this.i + 1 >= this.e) {
            p();
        }
        g a2 = a(g.a.SLACK, null);
        int i = this.f326b + 1;
        this.f326b = i;
        this.i++;
        a2.f331b = i;
        this.l.d[i] = a2;
        return a2;
    }

    public int o(Object obj) {
        g gVar = ((b.f.b.h.c) obj).i;
        if (gVar != null) {
            return (int) (gVar.e + 0.5f);
        }
        return 0;
    }

    public final void p() {
        int i = this.d * 2;
        this.d = i;
        this.f = (b[]) Arrays.copyOf(this.f, i);
        c cVar = this.l;
        cVar.d = (g[]) Arrays.copyOf(cVar.d, this.d);
        int i2 = this.d;
        this.h = new boolean[i2];
        this.e = i2;
        this.k = i2;
    }

    public void q() {
        if (this.f327c.isEmpty()) {
            j();
            return;
        }
        if (this.g) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.j) {
                    z = true;
                    break;
                } else if (!this.f[i].e) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                j();
                return;
            }
        }
        r(this.f327c);
    }

    public void r(a aVar) {
        float f;
        int i;
        boolean z;
        g.a aVar2 = g.a.UNRESTRICTED;
        int i2 = 0;
        while (true) {
            f = 0.0f;
            i = 1;
            if (i2 >= this.j) {
                z = false;
                break;
            }
            b[] bVarArr = this.f;
            if (bVarArr[i2].a.i != aVar2 && bVarArr[i2].f322b < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            boolean z2 = false;
            int i3 = 0;
            while (!z2) {
                i3 += i;
                float f2 = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                int i6 = -1;
                int i7 = 0;
                while (i4 < this.j) {
                    b bVar = this.f[i4];
                    if (bVar.a.i != aVar2 && !bVar.e && bVar.f322b < f) {
                        int k = bVar.d.k();
                        int i8 = 0;
                        while (i8 < k) {
                            g d = bVar.d.d(i8);
                            float e = bVar.d.e(d);
                            if (e > f) {
                                for (int i9 = 0; i9 < 9; i9++) {
                                    float f3 = d.g[i9] / e;
                                    if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                        i6 = d.f331b;
                                        i7 = i9;
                                        f2 = f3;
                                        i5 = i4;
                                    }
                                }
                            }
                            i8++;
                            f = 0.0f;
                        }
                    }
                    i4++;
                    f = 0.0f;
                }
                if (i5 != -1) {
                    b bVar2 = this.f[i5];
                    bVar2.a.f332c = -1;
                    bVar2.j(this.l.d[i6]);
                    g gVar = bVar2.a;
                    gVar.f332c = i5;
                    gVar.e(this, bVar2);
                } else {
                    z2 = true;
                }
                if (i3 > this.i / 2) {
                    z2 = true;
                }
                f = 0.0f;
                i = 1;
            }
        }
        s(aVar);
        j();
    }

    public final int s(a aVar) {
        for (int i = 0; i < this.i; i++) {
            this.h[i] = false;
        }
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2++;
            if (i2 >= this.i * 2) {
                return i2;
            }
            g gVar = ((b) aVar).a;
            if (gVar != null) {
                this.h[gVar.f331b] = true;
            }
            g b2 = aVar.b(this, this.h);
            if (b2 != null) {
                boolean[] zArr = this.h;
                int i3 = b2.f331b;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (b2 != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.j; i5++) {
                    b bVar = this.f[i5];
                    if (bVar.a.i != g.a.UNRESTRICTED && !bVar.e && bVar.d.g(b2)) {
                        float e = bVar.d.e(b2);
                        if (e < 0.0f) {
                            float f2 = (-bVar.f322b) / e;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f[i4];
                    bVar2.a.f332c = -1;
                    bVar2.j(b2);
                    g gVar2 = bVar2.a;
                    gVar2.f332c = i4;
                    gVar2.e(this, bVar2);
                }
            } else {
                z = true;
            }
        }
        return i2;
    }

    public final void t() {
        for (int i = 0; i < this.j; i++) {
            b bVar = this.f[i];
            if (bVar != null) {
                this.l.f324b.b(bVar);
            }
            this.f[i] = null;
        }
    }

    public void u() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.l;
            g[] gVarArr = cVar.d;
            if (i >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i];
            if (gVar != null) {
                gVar.c();
            }
            i++;
        }
        e<g> eVar = cVar.f325c;
        g[] gVarArr2 = this.m;
        int i2 = this.n;
        eVar.getClass();
        if (i2 > gVarArr2.length) {
            i2 = gVarArr2.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            g gVar2 = gVarArr2[i3];
            int i4 = eVar.f328b;
            Object[] objArr = eVar.a;
            if (i4 < objArr.length) {
                objArr[i4] = gVar2;
                eVar.f328b = i4 + 1;
            }
        }
        this.n = 0;
        Arrays.fill(this.l.d, (Object) null);
        this.f326b = 0;
        this.f327c.clear();
        this.i = 1;
        for (int i5 = 0; i5 < this.j; i5++) {
            b[] bVarArr = this.f;
            if (bVarArr[i5] != null) {
                bVarArr[i5].getClass();
            }
        }
        t();
        this.j = 0;
        this.o = new b(this.l);
    }
}
