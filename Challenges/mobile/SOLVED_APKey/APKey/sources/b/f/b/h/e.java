package b.f.b.h;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.b.h.d;
import b.f.b.h.l.b;
import b.f.b.h.l.o;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e extends k {
    public int r0;
    public int s0;
    public b.f.b.h.l.b m0 = new b.f.b.h.l.b(this);
    public b.f.b.h.l.e n0 = new b.f.b.h.l.e(this);
    public b.InterfaceC0013b o0 = null;
    public boolean p0 = false;
    public b.f.b.d q0 = new b.f.b.d();
    public int t0 = 0;
    public int u0 = 0;
    public b[] v0 = new b[4];
    public b[] w0 = new b[4];
    public int x0 = 257;
    public boolean y0 = false;
    public boolean z0 = false;
    public WeakReference<c> A0 = null;
    public WeakReference<c> B0 = null;
    public WeakReference<c> C0 = null;
    public WeakReference<c> D0 = null;
    public b.a E0 = new b.a();

    public static boolean X(d dVar, b.InterfaceC0013b interfaceC0013b, b.a aVar, int i) {
        int i2;
        int i3;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        if (interfaceC0013b == null) {
            return false;
        }
        aVar.a = dVar.m();
        aVar.f347b = dVar.q();
        aVar.f348c = dVar.r();
        aVar.d = dVar.l();
        aVar.i = false;
        aVar.j = i;
        d.a aVar4 = aVar.a;
        d.a aVar5 = d.a.MATCH_CONSTRAINT;
        boolean z = aVar4 == aVar5;
        boolean z2 = aVar.f347b == aVar5;
        boolean z3 = z && dVar.S > 0.0f;
        boolean z4 = z2 && dVar.S > 0.0f;
        if (z && dVar.u(0) && dVar.l == 0 && !z3) {
            aVar.a = aVar2;
            if (z2 && dVar.m == 0) {
                aVar.a = aVar3;
            }
            z = false;
        }
        if (z2 && dVar.u(1) && dVar.m == 0 && !z4) {
            aVar.f347b = aVar2;
            if (z && dVar.l == 0) {
                aVar.f347b = aVar3;
            }
            z2 = false;
        }
        if (dVar.z()) {
            aVar.a = aVar3;
            z = false;
        }
        if (dVar.A()) {
            aVar.f347b = aVar3;
            z2 = false;
        }
        if (z3) {
            if (dVar.n[0] == 4) {
                aVar.a = aVar3;
            } else if (!z2) {
                if (aVar.f347b == aVar3) {
                    i3 = aVar.d;
                } else {
                    aVar.a = aVar2;
                    ((ConstraintLayout.b) interfaceC0013b).b(dVar, aVar);
                    i3 = aVar.f;
                }
                aVar.a = aVar3;
                int i4 = dVar.T;
                aVar.f348c = (int) ((i4 == 0 || i4 == -1) ? dVar.S * i3 : dVar.S / i3);
            }
        }
        if (z4) {
            if (dVar.n[1] == 4) {
                aVar.f347b = aVar3;
            } else if (!z) {
                if (aVar.a == aVar3) {
                    i2 = aVar.f348c;
                } else {
                    aVar.f347b = aVar2;
                    ((ConstraintLayout.b) interfaceC0013b).b(dVar, aVar);
                    i2 = aVar.e;
                }
                aVar.f347b = aVar3;
                int i5 = dVar.T;
                aVar.d = (int) ((i5 == 0 || i5 == -1) ? i2 / dVar.S : i2 * dVar.S);
            }
        }
        ((ConstraintLayout.b) interfaceC0013b).b(dVar, aVar);
        dVar.M(aVar.e);
        dVar.H(aVar.f);
        dVar.y = aVar.h;
        dVar.E(aVar.g);
        aVar.j = 0;
        return aVar.i;
    }

    @Override // b.f.b.h.k, b.f.b.h.d
    public void B() {
        this.q0.u();
        this.r0 = 0;
        this.s0 = 0;
        super.B();
    }

    @Override // b.f.b.h.d
    public void N(boolean z, boolean z2) {
        super.N(z, z2);
        int size = this.l0.size();
        for (int i = 0; i < size; i++) {
            this.l0.get(i).N(z, z2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:344:0x05d0, code lost:
        r0 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:328:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x05cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:358:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:363:0x060c  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0655 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0676  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0693  */
    /* JADX WARN: Removed duplicated region for block: B:441:0x07a0  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x07c8  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:468:0x0859  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0874  */
    /* JADX WARN: Removed duplicated region for block: B:472:0x0880  */
    /* JADX WARN: Removed duplicated region for block: B:474:0x0883  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x08c6  */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16 */
    @Override // b.f.b.h.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void P() {
        /*
            Method dump skipped, instructions count: 2262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.e.P():void");
    }

    public void Q(d dVar, int i) {
        if (i == 0) {
            int i2 = this.t0 + 1;
            b[] bVarArr = this.w0;
            if (i2 >= bVarArr.length) {
                this.w0 = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
            }
            b[] bVarArr2 = this.w0;
            int i3 = this.t0;
            bVarArr2[i3] = new b(dVar, 0, this.p0);
            this.t0 = i3 + 1;
        } else if (i != 1) {
        } else {
            int i4 = this.u0 + 1;
            b[] bVarArr3 = this.v0;
            if (i4 >= bVarArr3.length) {
                this.v0 = (b[]) Arrays.copyOf(bVarArr3, bVarArr3.length * 2);
            }
            b[] bVarArr4 = this.v0;
            int i5 = this.u0;
            bVarArr4[i5] = new b(dVar, 1, this.p0);
            this.u0 = i5 + 1;
        }
    }

    public boolean R(b.f.b.d dVar) {
        d.a aVar = d.a.FIXED;
        d.a aVar2 = d.a.WRAP_CONTENT;
        boolean Y = Y(64);
        d(dVar, Y);
        int size = this.l0.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            d dVar2 = this.l0.get(i);
            boolean[] zArr = dVar2.N;
            zArr[0] = false;
            zArr[1] = false;
            if (dVar2 instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                d dVar3 = this.l0.get(i2);
                if (dVar3 instanceof a) {
                    a aVar3 = (a) dVar3;
                    for (int i3 = 0; i3 < aVar3.m0; i3++) {
                        d dVar4 = aVar3.l0[i3];
                        int i4 = aVar3.n0;
                        if (i4 == 0 || i4 == 1) {
                            dVar4.N[0] = true;
                        } else if (i4 == 2 || i4 == 3) {
                            dVar4.N[1] = true;
                        }
                    }
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            d dVar5 = this.l0.get(i5);
            if (dVar5.c()) {
                dVar5.d(dVar, Y);
            }
        }
        if (b.f.b.d.p) {
            HashSet<d> hashSet = new HashSet<>();
            for (int i6 = 0; i6 < size; i6++) {
                d dVar6 = this.l0.get(i6);
                if (!dVar6.c()) {
                    hashSet.add(dVar6);
                }
            }
            b(this, dVar, hashSet, m() == aVar2 ? 0 : 1, false);
            Iterator<d> it = hashSet.iterator();
            while (it.hasNext()) {
                d next = it.next();
                i.a(this, dVar, next);
                next.d(dVar, Y);
            }
        } else {
            for (int i7 = 0; i7 < size; i7++) {
                d dVar7 = this.l0.get(i7);
                if (dVar7 instanceof e) {
                    d.a[] aVarArr = dVar7.O;
                    d.a aVar4 = aVarArr[0];
                    d.a aVar5 = aVarArr[1];
                    if (aVar4 == aVar2) {
                        aVarArr[0] = aVar;
                    }
                    if (aVar5 == aVar2) {
                        aVarArr[1] = aVar;
                    }
                    dVar7.d(dVar, Y);
                    if (aVar4 == aVar2) {
                        dVar7.I(aVar4);
                    }
                    if (aVar5 == aVar2) {
                        dVar7.L(aVar5);
                    }
                } else {
                    i.a(this, dVar, dVar7);
                    if (!dVar7.c()) {
                        dVar7.d(dVar, Y);
                    }
                }
            }
        }
        if (this.t0 > 0) {
            b.b.a.a(this, dVar, null, 0);
        }
        if (this.u0 > 0) {
            b.b.a.a(this, dVar, null, 1);
        }
        return true;
    }

    public void S(c cVar) {
        WeakReference<c> weakReference = this.D0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.D0.get().c()) {
            this.D0 = new WeakReference<>(cVar);
        }
    }

    public void T(c cVar) {
        WeakReference<c> weakReference = this.C0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.C0.get().c()) {
            this.C0 = new WeakReference<>(cVar);
        }
    }

    public void U(c cVar) {
        WeakReference<c> weakReference = this.A0;
        if (weakReference == null || weakReference.get() == null || cVar.c() > this.A0.get().c()) {
            this.A0 = new WeakReference<>(cVar);
        }
    }

    public boolean V(boolean z, int i) {
        b.f.b.h.l.g gVar;
        int i2;
        boolean z2;
        b.f.b.h.l.g gVar2;
        int l;
        b.f.b.h.l.e eVar = this.n0;
        d.a aVar = d.a.MATCH_PARENT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        boolean z3 = true;
        boolean z4 = z & true;
        d.a k = eVar.a.k(0);
        d.a k2 = eVar.a.k(1);
        int s = eVar.a.s();
        int t = eVar.a.t();
        if (z4 && (k == aVar2 || k2 == aVar2)) {
            Iterator<o> it = eVar.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o next = it.next();
                if (next.f == i && !next.k()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && k == aVar2) {
                    e eVar2 = eVar.a;
                    eVar2.O[0] = aVar3;
                    eVar2.M(eVar.d(eVar2, 0));
                    e eVar3 = eVar.a;
                    gVar2 = eVar3.d.e;
                    l = eVar3.r();
                    gVar2.c(l);
                }
            } else if (z4 && k2 == aVar2) {
                e eVar4 = eVar.a;
                eVar4.O[1] = aVar3;
                eVar4.H(eVar.d(eVar4, 1));
                e eVar5 = eVar.a;
                gVar2 = eVar5.e.e;
                l = eVar5.l();
                gVar2.c(l);
            }
        }
        e eVar6 = eVar.a;
        d.a[] aVarArr = eVar6.O;
        if (i == 0) {
            if (aVarArr[0] == aVar3 || aVarArr[0] == aVar) {
                int r = eVar6.r() + s;
                eVar.a.d.i.c(r);
                gVar = eVar.a.d.e;
                i2 = r - s;
                gVar.c(i2);
                z2 = true;
            }
            z2 = false;
        } else {
            if (aVarArr[1] == aVar3 || aVarArr[1] == aVar) {
                int l2 = eVar6.l() + t;
                eVar.a.e.i.c(l2);
                gVar = eVar.a.e.e;
                i2 = l2 - t;
                gVar.c(i2);
                z2 = true;
            }
            z2 = false;
        }
        eVar.g();
        Iterator<o> it2 = eVar.e.iterator();
        while (it2.hasNext()) {
            o next2 = it2.next();
            if (next2.f == i && (next2.f359b != eVar.a || next2.g)) {
                next2.e();
            }
        }
        Iterator<o> it3 = eVar.e.iterator();
        while (it3.hasNext()) {
            o next3 = it3.next();
            if (next3.f == i && (z2 || next3.f359b != eVar.a)) {
                if (!next3.h.j || !next3.i.j || (!(next3 instanceof b.f.b.h.l.c) && !next3.e.j)) {
                    z3 = false;
                    break;
                }
            }
        }
        eVar.a.I(k);
        eVar.a.L(k2);
        return z3;
    }

    public void W() {
        this.n0.f349b = true;
    }

    public boolean Y(int i) {
        return (this.x0 & i) == i;
    }

    public void Z(int i) {
        this.x0 = i;
        b.f.b.d.p = Y(512);
    }
}
