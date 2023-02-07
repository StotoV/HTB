package b.f.b.h;

import b.f.b.g;
import b.f.b.h.l.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public int f337b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f338c;
    public final d d;
    public final a e;
    public c f;
    public b.f.b.g i;
    public HashSet<c> a = null;
    public int g = 0;
    public int h = -1;

    /* loaded from: classes.dex */
    public enum a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public c(d dVar, a aVar) {
        this.d = dVar;
        this.e = aVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (r6.d.y == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (r4 != r10) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
        if (r4 != r10) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006f, code lost:
        if (r4 != r2) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(b.f.b.h.c r7, int r8, int r9, boolean r10) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != 0) goto L7
            r6.h()
            return r0
        L7:
            r1 = 0
            if (r10 != 0) goto L75
            b.f.b.h.c$a r10 = b.f.b.h.c.a.CENTER_Y
            b.f.b.h.c$a r2 = b.f.b.h.c.a.CENTER_X
            b.f.b.h.c$a r3 = b.f.b.h.c.a.BASELINE
            b.f.b.h.c$a r4 = r7.e
            b.f.b.h.c$a r5 = r6.e
            if (r4 != r5) goto L25
            if (r5 != r3) goto L3e
            b.f.b.h.d r10 = r7.d
            boolean r10 = r10.y
            if (r10 == 0) goto L40
            b.f.b.h.d r10 = r6.d
            boolean r10 = r10.y
            if (r10 != 0) goto L3e
            goto L40
        L25:
            int r5 = r5.ordinal()
            switch(r5) {
                case 0: goto L40;
                case 1: goto L5b;
                case 2: goto L42;
                case 3: goto L5b;
                case 4: goto L42;
                case 5: goto L40;
                case 6: goto L38;
                case 7: goto L40;
                case 8: goto L40;
                default: goto L2c;
            }
        L2c:
            java.lang.AssertionError r7 = new java.lang.AssertionError
            b.f.b.h.c$a r8 = r6.e
            java.lang.String r8 = r8.name()
            r7.<init>(r8)
            throw r7
        L38:
            if (r4 == r3) goto L40
            if (r4 == r2) goto L40
            if (r4 == r10) goto L40
        L3e:
            r10 = 1
            goto L72
        L40:
            r10 = 0
            goto L72
        L42:
            b.f.b.h.c$a r2 = b.f.b.h.c.a.TOP
            if (r4 == r2) goto L4d
            b.f.b.h.c$a r2 = b.f.b.h.c.a.BOTTOM
            if (r4 != r2) goto L4b
            goto L4d
        L4b:
            r2 = 0
            goto L4e
        L4d:
            r2 = 1
        L4e:
            b.f.b.h.d r3 = r7.d
            boolean r3 = r3 instanceof b.f.b.h.f
            if (r3 == 0) goto L59
            if (r2 != 0) goto L3e
            if (r4 != r10) goto L40
            goto L3e
        L59:
            r10 = r2
            goto L72
        L5b:
            b.f.b.h.c$a r10 = b.f.b.h.c.a.LEFT
            if (r4 == r10) goto L66
            b.f.b.h.c$a r10 = b.f.b.h.c.a.RIGHT
            if (r4 != r10) goto L64
            goto L66
        L64:
            r10 = 0
            goto L67
        L66:
            r10 = 1
        L67:
            b.f.b.h.d r3 = r7.d
            boolean r3 = r3 instanceof b.f.b.h.f
            if (r3 == 0) goto L72
            if (r10 != 0) goto L3e
            if (r4 != r2) goto L40
            goto L3e
        L72:
            if (r10 != 0) goto L75
            return r1
        L75:
            r6.f = r7
            java.util.HashSet<b.f.b.h.c> r10 = r7.a
            if (r10 != 0) goto L82
            java.util.HashSet r10 = new java.util.HashSet
            r10.<init>()
            r7.a = r10
        L82:
            b.f.b.h.c r7 = r6.f
            java.util.HashSet<b.f.b.h.c> r7 = r7.a
            if (r7 == 0) goto L8b
            r7.add(r6)
        L8b:
            if (r8 <= 0) goto L90
            r6.g = r8
            goto L92
        L90:
            r6.g = r1
        L92:
            r6.h = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.h.c.a(b.f.b.h.c, int, int, boolean):boolean");
    }

    public void b(int i, ArrayList<n> arrayList, n nVar) {
        HashSet<c> hashSet = this.a;
        if (hashSet != null) {
            Iterator<c> it = hashSet.iterator();
            while (it.hasNext()) {
                b.b.a.b(it.next().d, i, arrayList, nVar);
            }
        }
    }

    public int c() {
        if (!this.f338c) {
            return 0;
        }
        return this.f337b;
    }

    public int d() {
        c cVar;
        if (this.d.c0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i <= -1 || (cVar = this.f) == null || cVar.d.c0 != 8) ? this.g : i;
    }

    public boolean e() {
        c cVar;
        HashSet<c> hashSet = this.a;
        if (hashSet == null) {
            return false;
        }
        Iterator<c> it = hashSet.iterator();
        while (it.hasNext()) {
            c next = it.next();
            switch (next.e.ordinal()) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                    cVar = null;
                    break;
                case 1:
                    cVar = next.d.F;
                    break;
                case 2:
                    cVar = next.d.G;
                    break;
                case 3:
                    cVar = next.d.D;
                    break;
                case 4:
                    cVar = next.d.E;
                    break;
                default:
                    throw new AssertionError(next.e.name());
            }
            if (cVar.g()) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        HashSet<c> hashSet = this.a;
        return hashSet != null && hashSet.size() > 0;
    }

    public boolean g() {
        return this.f != null;
    }

    public void h() {
        HashSet<c> hashSet;
        c cVar = this.f;
        if (cVar != null && (hashSet = cVar.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = -1;
        this.f338c = false;
        this.f337b = 0;
    }

    public void i() {
        b.f.b.g gVar = this.i;
        if (gVar == null) {
            this.i = new b.f.b.g(g.a.UNRESTRICTED);
        } else {
            gVar.c();
        }
    }

    public void j(int i) {
        this.f337b = i;
        this.f338c = true;
    }

    public String toString() {
        return this.d.d0 + ":" + this.e.toString();
    }
}
