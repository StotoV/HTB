package b.f.b.h;

import b.f.b.h.c;
import b.f.b.h.l.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    public c D;
    public c E;
    public c F;
    public c G;
    public c H;
    public c I;
    public c J;
    public c K;
    public c[] L;
    public ArrayList<c> M;
    public boolean[] N;
    public a[] O;
    public d P;
    public int Q;
    public int R;
    public float S;
    public int T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public float Z;
    public float a0;

    /* renamed from: b  reason: collision with root package name */
    public b.f.b.h.l.c f341b;
    public Object b0;

    /* renamed from: c  reason: collision with root package name */
    public b.f.b.h.l.c f342c;
    public int c0;
    public String d0;
    public int e0;
    public int f0;
    public float[] g0;
    public d[] h0;
    public d[] i0;
    public int j0;
    public int k0;
    public boolean z;
    public boolean a = false;
    public b.f.b.h.l.k d = null;
    public m e = null;
    public boolean[] f = {true, true};
    public boolean g = true;
    public boolean h = false;
    public boolean i = false;
    public int j = -1;
    public int k = -1;
    public int l = 0;
    public int m = 0;
    public int[] n = new int[2];
    public int o = 0;
    public int p = 0;
    public float q = 1.0f;
    public int r = 0;
    public int s = 0;
    public float t = 1.0f;
    public int u = -1;
    public float v = 1.0f;
    public int[] w = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float x = 0.0f;
    public boolean y = false;
    public boolean A = false;
    public int B = 0;
    public int C = 0;

    /* loaded from: classes.dex */
    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public d() {
        c cVar = new c(this, c.a.LEFT);
        this.D = cVar;
        c cVar2 = new c(this, c.a.TOP);
        this.E = cVar2;
        c cVar3 = new c(this, c.a.RIGHT);
        this.F = cVar3;
        c cVar4 = new c(this, c.a.BOTTOM);
        this.G = cVar4;
        c cVar5 = new c(this, c.a.BASELINE);
        this.H = cVar5;
        this.I = new c(this, c.a.CENTER_X);
        this.J = new c(this, c.a.CENTER_Y);
        c cVar6 = new c(this, c.a.CENTER);
        this.K = cVar6;
        this.L = new c[]{cVar, cVar3, cVar2, cVar4, cVar5, cVar6};
        ArrayList<c> arrayList = new ArrayList<>();
        this.M = arrayList;
        this.N = new boolean[2];
        a aVar = a.FIXED;
        this.O = new a[]{aVar, aVar};
        this.P = null;
        this.Q = 0;
        this.R = 0;
        this.S = 0.0f;
        this.T = -1;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.Z = 0.5f;
        this.a0 = 0.5f;
        this.c0 = 0;
        this.d0 = null;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = new float[]{-1.0f, -1.0f};
        this.h0 = new d[]{null, null};
        this.i0 = new d[]{null, null};
        this.j0 = -1;
        this.k0 = -1;
        arrayList.add(this.D);
        this.M.add(this.E);
        this.M.add(this.F);
        this.M.add(this.G);
        this.M.add(this.I);
        this.M.add(this.J);
        this.M.add(this.K);
        this.M.add(this.H);
    }

    public boolean A() {
        return this.i || (this.E.f338c && this.G.f338c);
    }

    public void B() {
        this.D.h();
        this.E.h();
        this.F.h();
        this.G.h();
        this.H.h();
        this.I.h();
        this.J.h();
        this.K.h();
        this.P = null;
        this.x = 0.0f;
        this.Q = 0;
        this.R = 0;
        this.S = 0.0f;
        this.T = -1;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.5f;
        this.a0 = 0.5f;
        a[] aVarArr = this.O;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.b0 = null;
        this.c0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        float[] fArr = this.g0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.j = -1;
        this.k = -1;
        int[] iArr = this.w;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.l = 0;
        this.m = 0;
        this.q = 1.0f;
        this.t = 1.0f;
        this.p = Integer.MAX_VALUE;
        this.s = Integer.MAX_VALUE;
        this.o = 0;
        this.r = 0;
        this.u = -1;
        this.v = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.A = false;
        boolean[] zArr2 = this.N;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
    }

    public void C() {
        this.h = false;
        this.i = false;
        int size = this.M.size();
        for (int i = 0; i < size; i++) {
            c cVar = this.M.get(i);
            cVar.f338c = false;
            cVar.f337b = 0;
        }
    }

    public void D(b.f.b.c cVar) {
        this.D.i();
        this.E.i();
        this.F.i();
        this.G.i();
        this.H.i();
        this.K.i();
        this.I.i();
        this.J.i();
    }

    public void E(int i) {
        this.W = i;
        this.y = i > 0;
    }

    public void F(int i, int i2) {
        c cVar = this.D;
        cVar.f337b = i;
        cVar.f338c = true;
        c cVar2 = this.F;
        cVar2.f337b = i2;
        cVar2.f338c = true;
        this.U = i;
        this.Q = i2 - i;
        this.h = true;
    }

    public void G(int i, int i2) {
        c cVar = this.E;
        cVar.f337b = i;
        cVar.f338c = true;
        c cVar2 = this.G;
        cVar2.f337b = i2;
        cVar2.f338c = true;
        this.V = i;
        this.R = i2 - i;
        if (this.y) {
            this.H.j(i + this.W);
        }
        this.i = true;
    }

    public void H(int i) {
        this.R = i;
        int i2 = this.Y;
        if (i < i2) {
            this.R = i2;
        }
    }

    public void I(a aVar) {
        this.O[0] = aVar;
    }

    public void J(int i) {
        if (i < 0) {
            i = 0;
        }
        this.Y = i;
    }

    public void K(int i) {
        if (i < 0) {
            i = 0;
        }
        this.X = i;
    }

    public void L(a aVar) {
        this.O[1] = aVar;
    }

    public void M(int i) {
        this.Q = i;
        int i2 = this.X;
        if (i < i2) {
            this.Q = i2;
        }
    }

    public void N(boolean z, boolean z2) {
        int i;
        int i2;
        a aVar = a.FIXED;
        b.f.b.h.l.k kVar = this.d;
        boolean z3 = z & kVar.g;
        m mVar = this.e;
        boolean z4 = z2 & mVar.g;
        int i3 = kVar.h.g;
        int i4 = mVar.h.g;
        int i5 = kVar.i.g;
        int i6 = mVar.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.U = i3;
        }
        if (z4) {
            this.V = i4;
        }
        if (this.c0 == 8) {
            this.Q = 0;
            this.R = 0;
            return;
        }
        if (z3) {
            if (this.O[0] == aVar && i8 < (i2 = this.Q)) {
                i8 = i2;
            }
            this.Q = i8;
            int i10 = this.X;
            if (i8 < i10) {
                this.Q = i10;
            }
        }
        if (!z4) {
            return;
        }
        if (this.O[1] == aVar && i9 < (i = this.R)) {
            i9 = i;
        }
        this.R = i9;
        int i11 = this.Y;
        if (i9 >= i11) {
            return;
        }
        this.R = i11;
    }

    public void O(b.f.b.d dVar, boolean z) {
        int i;
        int i2;
        m mVar;
        b.f.b.h.l.k kVar;
        int o = dVar.o(this.D);
        int o2 = dVar.o(this.E);
        int o3 = dVar.o(this.F);
        int o4 = dVar.o(this.G);
        if (z && (kVar = this.d) != null) {
            b.f.b.h.l.f fVar = kVar.h;
            if (fVar.j) {
                b.f.b.h.l.f fVar2 = kVar.i;
                if (fVar2.j) {
                    o = fVar.g;
                    o3 = fVar2.g;
                }
            }
        }
        if (z && (mVar = this.e) != null) {
            b.f.b.h.l.f fVar3 = mVar.h;
            if (fVar3.j) {
                b.f.b.h.l.f fVar4 = mVar.i;
                if (fVar4.j) {
                    o2 = fVar3.g;
                    o4 = fVar4.g;
                }
            }
        }
        int i3 = o4 - o2;
        if (o3 - o < 0 || i3 < 0 || o == Integer.MIN_VALUE || o == Integer.MAX_VALUE || o2 == Integer.MIN_VALUE || o2 == Integer.MAX_VALUE || o3 == Integer.MIN_VALUE || o3 == Integer.MAX_VALUE || o4 == Integer.MIN_VALUE || o4 == Integer.MAX_VALUE) {
            o4 = 0;
            o = 0;
            o2 = 0;
            o3 = 0;
        }
        int i4 = o3 - o;
        int i5 = o4 - o2;
        this.U = o;
        this.V = o2;
        if (this.c0 == 8) {
            this.Q = 0;
            this.R = 0;
            return;
        }
        a[] aVarArr = this.O;
        a aVar = aVarArr[0];
        a aVar2 = a.FIXED;
        if (aVar == aVar2 && i4 < (i2 = this.Q)) {
            i4 = i2;
        }
        if (aVarArr[1] == aVar2 && i5 < (i = this.R)) {
            i5 = i;
        }
        this.Q = i4;
        this.R = i5;
        int i6 = this.Y;
        if (i5 < i6) {
            this.R = i6;
        }
        int i7 = this.X;
        if (i4 >= i7) {
            return;
        }
        this.Q = i7;
    }

    public void b(e eVar, b.f.b.d dVar, HashSet<d> hashSet, int i, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            i.a(eVar, dVar, this);
            hashSet.remove(this);
            d(dVar, eVar.Y(64));
        }
        if (i == 0) {
            HashSet<c> hashSet2 = this.D.a;
            if (hashSet2 != null) {
                Iterator<c> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().d.b(eVar, dVar, hashSet, i, true);
                }
            }
            HashSet<c> hashSet3 = this.F.a;
            if (hashSet3 == null) {
                return;
            }
            Iterator<c> it2 = hashSet3.iterator();
            while (it2.hasNext()) {
                it2.next().d.b(eVar, dVar, hashSet, i, true);
            }
            return;
        }
        HashSet<c> hashSet4 = this.E.a;
        if (hashSet4 != null) {
            Iterator<c> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().d.b(eVar, dVar, hashSet, i, true);
            }
        }
        HashSet<c> hashSet5 = this.G.a;
        if (hashSet5 != null) {
            Iterator<c> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().d.b(eVar, dVar, hashSet, i, true);
            }
        }
        HashSet<c> hashSet6 = this.H.a;
        if (hashSet6 == null) {
            return;
        }
        Iterator<c> it5 = hashSet6.iterator();
        while (it5.hasNext()) {
            it5.next().d.b(eVar, dVar, hashSet, i, true);
        }
    }

    public boolean c() {
        return (this instanceof j) || (this instanceof f);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0635  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(b.f.b.d r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1754
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.d.d(b.f.b.d, boolean):void");
    }

    public boolean e() {
        return this.c0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x030b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0427 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x044a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0472 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:328:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:331:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(b.f.b.d r31, boolean r32, boolean r33, boolean r34, boolean r35, b.f.b.g r36, b.f.b.g r37, b.f.b.h.d.a r38, boolean r39, b.f.b.h.c r40, b.f.b.h.c r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            Method dump skipped, instructions count: 1199
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.d.f(b.f.b.d, boolean, boolean, boolean, boolean, b.f.b.g, b.f.b.g, b.f.b.h.d$a, boolean, b.f.b.h.c, b.f.b.h.c, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public void g(b.f.b.d dVar) {
        dVar.l(this.D);
        dVar.l(this.E);
        dVar.l(this.F);
        dVar.l(this.G);
        if (this.W > 0) {
            dVar.l(this.H);
        }
    }

    public void h() {
        if (this.d == null) {
            this.d = new b.f.b.h.l.k(this);
        }
        if (this.e == null) {
            this.e = new m(this);
        }
    }

    public c i(c.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.D;
            case 2:
                return this.E;
            case 3:
                return this.F;
            case 4:
                return this.G;
            case 5:
                return this.H;
            case 6:
                return this.K;
            case 7:
                return this.I;
            case 8:
                return this.J;
            default:
                throw new AssertionError(aVar.name());
        }
    }

    public int j() {
        return t() + this.R;
    }

    public a k(int i) {
        if (i == 0) {
            return m();
        }
        if (i != 1) {
            return null;
        }
        return q();
    }

    public int l() {
        if (this.c0 == 8) {
            return 0;
        }
        return this.R;
    }

    public a m() {
        return this.O[0];
    }

    public d n(int i) {
        c cVar;
        c cVar2;
        if (i != 0) {
            if (i != 1 || (cVar2 = (cVar = this.G).f) == null || cVar2.f != cVar) {
                return null;
            }
            return cVar2.d;
        }
        c cVar3 = this.F;
        c cVar4 = cVar3.f;
        if (cVar4 != null && cVar4.f == cVar3) {
            return cVar4.d;
        }
        return null;
    }

    public d o(int i) {
        c cVar;
        c cVar2;
        if (i != 0) {
            if (i != 1 || (cVar2 = (cVar = this.E).f) == null || cVar2.f != cVar) {
                return null;
            }
            return cVar2.d;
        }
        c cVar3 = this.D;
        c cVar4 = cVar3.f;
        if (cVar4 != null && cVar4.f == cVar3) {
            return cVar4.d;
        }
        return null;
    }

    public int p() {
        return s() + this.Q;
    }

    public a q() {
        return this.O[1];
    }

    public int r() {
        if (this.c0 == 8) {
            return 0;
        }
        return this.Q;
    }

    public int s() {
        d dVar = this.P;
        return (dVar == null || !(dVar instanceof e)) ? this.U : ((e) dVar).r0 + this.U;
    }

    public int t() {
        d dVar = this.P;
        return (dVar == null || !(dVar instanceof e)) ? this.V : ((e) dVar).s0 + this.V;
    }

    public String toString() {
        String str = "";
        StringBuilder g = c.a.a.a.a.g(str);
        if (this.d0 != null) {
            StringBuilder g2 = c.a.a.a.a.g("id: ");
            g2.append(this.d0);
            g2.append(" ");
            str = g2.toString();
        }
        g.append(str);
        g.append("(");
        g.append(this.U);
        g.append(", ");
        g.append(this.V);
        g.append(") - (");
        g.append(this.Q);
        g.append(" x ");
        g.append(this.R);
        g.append(")");
        return g.toString();
    }

    public boolean u(int i) {
        if (i == 0) {
            return (this.D.f != null ? 1 : 0) + (this.F.f != null ? 1 : 0) < 2;
        }
        return ((this.E.f != null ? 1 : 0) + (this.G.f != null ? 1 : 0)) + (this.H.f != null ? 1 : 0) < 2;
    }

    public final boolean v(int i) {
        int i2 = i * 2;
        c[] cVarArr = this.L;
        if (cVarArr[i2].f != null && cVarArr[i2].f.f != cVarArr[i2]) {
            int i3 = i2 + 1;
            if (cVarArr[i3].f != null && cVarArr[i3].f.f == cVarArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public boolean w() {
        c cVar = this.D;
        c cVar2 = cVar.f;
        if (cVar2 == null || cVar2.f != cVar) {
            c cVar3 = this.F;
            c cVar4 = cVar3.f;
            return cVar4 != null && cVar4.f == cVar3;
        }
        return true;
    }

    public boolean x() {
        c cVar = this.E;
        c cVar2 = cVar.f;
        if (cVar2 == null || cVar2.f != cVar) {
            c cVar3 = this.G;
            c cVar4 = cVar3.f;
            return cVar4 != null && cVar4.f == cVar3;
        }
        return true;
    }

    public boolean y() {
        return this.g && this.c0 != 8;
    }

    public boolean z() {
        return this.h || (this.D.f338c && this.F.f338c);
    }
}
