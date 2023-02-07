package b.f.b.h.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.b.h.d;
import b.f.b.h.l.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e {
    public b.f.b.h.e a;
    public b.f.b.h.e d;
    public b.InterfaceC0013b f;
    public b.a g;
    public ArrayList<l> h;

    /* renamed from: b  reason: collision with root package name */
    public boolean f349b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f350c = true;
    public ArrayList<o> e = new ArrayList<>();

    public e(b.f.b.h.e eVar) {
        new ArrayList();
        this.f = null;
        this.g = new b.a();
        this.h = new ArrayList<>();
        this.a = eVar;
        this.d = eVar;
    }

    public final void a(f fVar, int i, int i2, f fVar2, ArrayList<l> arrayList, l lVar) {
        o oVar = fVar.d;
        if (oVar.f360c == null) {
            b.f.b.h.e eVar = this.a;
            if (oVar == eVar.d || oVar == eVar.e) {
                return;
            }
            if (lVar == null) {
                lVar = new l(oVar, i2);
                arrayList.add(lVar);
            }
            oVar.f360c = lVar;
            lVar.f356b.add(oVar);
            for (d dVar : oVar.h.k) {
                if (dVar instanceof f) {
                    a((f) dVar, i, 0, fVar2, arrayList, lVar);
                }
            }
            for (d dVar2 : oVar.i.k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i, 1, fVar2, arrayList, lVar);
                }
            }
            if (i == 1 && (oVar instanceof m)) {
                for (d dVar3 : ((m) oVar).k.k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i, 2, fVar2, arrayList, lVar);
                    }
                }
            }
            for (f fVar3 : oVar.h.l) {
                a(fVar3, i, 0, fVar2, arrayList, lVar);
            }
            for (f fVar4 : oVar.i.l) {
                a(fVar4, i, 1, fVar2, arrayList, lVar);
            }
            if (i != 1 || !(oVar instanceof m)) {
                return;
            }
            for (f fVar5 : ((m) oVar).k.l) {
                a(fVar5, i, 2, fVar2, arrayList, lVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        if (r15.m == 0) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(b.f.b.h.e r20) {
        /*
            Method dump skipped, instructions count: 709
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.l.e.b(b.f.b.h.e):boolean");
    }

    public void c() {
        o iVar;
        ArrayList<o> arrayList = this.e;
        arrayList.clear();
        this.d.d.f();
        this.d.e.f();
        arrayList.add(this.d.d);
        arrayList.add(this.d.e);
        Iterator<b.f.b.h.d> it = this.d.l0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            b.f.b.h.d next = it.next();
            if (next instanceof b.f.b.h.f) {
                iVar = new i(next);
            } else {
                if (next.w()) {
                    if (next.f341b == null) {
                        next.f341b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f341b);
                } else {
                    arrayList.add(next.d);
                }
                if (next.x()) {
                    if (next.f342c == null) {
                        next.f342c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f342c);
                } else {
                    arrayList.add(next.e);
                }
                if (next instanceof b.f.b.h.h) {
                    iVar = new j(next);
                }
            }
            arrayList.add(iVar);
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<o> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<o> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            o next2 = it3.next();
            if (next2.f359b != this.d) {
                next2.d();
            }
        }
        this.h.clear();
        l.f355c = 0;
        e(this.a.d, 0, this.h);
        e(this.a.e, 1, this.h);
        this.f349b = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0064 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(b.f.b.h.e r18, int r19) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.l.e.d(b.f.b.h.e, int):int");
    }

    public final void e(o oVar, int i, ArrayList<l> arrayList) {
        for (d dVar : oVar.h.k) {
            if (dVar instanceof f) {
                a((f) dVar, i, 0, oVar.i, arrayList, null);
            } else if (dVar instanceof o) {
                a(((o) dVar).h, i, 0, oVar.i, arrayList, null);
            }
        }
        for (d dVar2 : oVar.i.k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i, 1, oVar.h, arrayList, null);
            } else if (dVar2 instanceof o) {
                a(((o) dVar2).i, i, 1, oVar.h, arrayList, null);
            }
        }
        if (i == 1) {
            for (d dVar3 : ((m) oVar).k.k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    public final void f(b.f.b.h.d dVar, d.a aVar, int i, d.a aVar2, int i2) {
        b.a aVar3 = this.g;
        aVar3.a = aVar;
        aVar3.f347b = aVar2;
        aVar3.f348c = i;
        aVar3.d = i2;
        ((ConstraintLayout.b) this.f).b(dVar, aVar3);
        dVar.M(this.g.e);
        dVar.H(this.g.f);
        b.a aVar4 = this.g;
        dVar.y = aVar4.h;
        dVar.E(aVar4.g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r12 == r7) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        r0.m = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        r0.c(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
        if (r10 == r7) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g() {
        /*
            r14 = this;
            b.f.b.h.d$a r6 = b.f.b.h.d.a.FIXED
            b.f.b.h.d$a r7 = b.f.b.h.d.a.MATCH_CONSTRAINT
            b.f.b.h.e r0 = r14.a
            java.util.ArrayList<b.f.b.h.d> r0 = r0.l0
            java.util.Iterator r8 = r0.iterator()
        Lc:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto La5
            java.lang.Object r0 = r8.next()
            r9 = r0
            b.f.b.h.d r9 = (b.f.b.h.d) r9
            boolean r0 = r9.a
            if (r0 == 0) goto L1e
            goto Lc
        L1e:
            b.f.b.h.d$a[] r0 = r9.O
            r1 = 0
            r10 = r0[r1]
            r11 = 1
            r12 = r0[r11]
            int r0 = r9.l
            int r2 = r9.m
            b.f.b.h.d$a r4 = b.f.b.h.d.a.WRAP_CONTENT
            if (r10 == r4) goto L35
            if (r10 != r7) goto L33
            if (r0 != r11) goto L33
            goto L35
        L33:
            r0 = 0
            goto L36
        L35:
            r0 = 1
        L36:
            if (r12 == r4) goto L3c
            if (r12 != r7) goto L3d
            if (r2 != r11) goto L3d
        L3c:
            r1 = 1
        L3d:
            b.f.b.h.l.k r2 = r9.d
            b.f.b.h.l.g r2 = r2.e
            boolean r3 = r2.j
            b.f.b.h.l.m r5 = r9.e
            b.f.b.h.l.g r5 = r5.e
            boolean r13 = r5.j
            if (r3 == 0) goto L5b
            if (r13 == 0) goto L5b
            int r3 = r2.g
            int r5 = r5.g
            r0 = r14
            r1 = r9
            r2 = r6
            r4 = r6
            r0.f(r1, r2, r3, r4, r5)
        L58:
            r9.a = r11
            goto L94
        L5b:
            if (r3 == 0) goto L7a
            if (r1 == 0) goto L7a
            int r3 = r2.g
            int r5 = r5.g
            r0 = r14
            r1 = r9
            r2 = r6
            r0.f(r1, r2, r3, r4, r5)
            b.f.b.h.l.m r0 = r9.e
            b.f.b.h.l.g r0 = r0.e
            int r1 = r9.l()
            if (r12 != r7) goto L76
        L73:
            r0.m = r1
            goto L94
        L76:
            r0.c(r1)
            goto L58
        L7a:
            if (r13 == 0) goto L94
            if (r0 == 0) goto L94
            int r3 = r2.g
            int r5 = r5.g
            r0 = r14
            r1 = r9
            r2 = r4
            r4 = r6
            r0.f(r1, r2, r3, r4, r5)
            b.f.b.h.l.k r0 = r9.d
            b.f.b.h.l.g r0 = r0.e
            int r1 = r9.r()
            if (r10 != r7) goto L76
            goto L73
        L94:
            boolean r0 = r9.a
            if (r0 == 0) goto Lc
            b.f.b.h.l.m r0 = r9.e
            b.f.b.h.l.g r0 = r0.l
            if (r0 == 0) goto Lc
            int r1 = r9.W
            r0.c(r1)
            goto Lc
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.l.e.g():void");
    }
}
