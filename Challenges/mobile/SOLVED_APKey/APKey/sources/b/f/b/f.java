package b.f.b;

import b.f.b.b;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes.dex */
public class f extends b.f.b.b {
    public int f;
    public g[] g;
    public g[] h;
    public int i;
    public b j;

    /* loaded from: classes.dex */
    public class a implements Comparator<g> {
        public a(f fVar) {
        }

        @Override // java.util.Comparator
        public int compare(g gVar, g gVar2) {
            return gVar.f331b - gVar2.f331b;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Comparable {

        /* renamed from: b  reason: collision with root package name */
        public g f329b;

        public b(f fVar) {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.f329b.f331b - ((g) obj).f331b;
        }

        public String toString() {
            String str = "[ ";
            if (this.f329b != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder g = c.a.a.a.a.g(str);
                    g.append(this.f329b.h[i]);
                    g.append(" ");
                    str = g.toString();
                }
            }
            return str + "] " + this.f329b;
        }
    }

    public f(c cVar) {
        super(cVar);
        this.f = 128;
        this.g = new g[128];
        this.h = new g[128];
        this.i = 0;
        this.j = new b(this);
    }

    @Override // b.f.b.b, b.f.b.d.a
    public void a(g gVar) {
        this.j.f329b = gVar;
        Arrays.fill(gVar.h, 0.0f);
        gVar.h[gVar.d] = 1.0f;
        m(gVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r8 < r7) goto L33;
     */
    @Override // b.f.b.b, b.f.b.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.f.b.g b(b.f.b.d r11, boolean[] r12) {
        /*
            r10 = this;
            r11 = 0
            r0 = -1
            r1 = 0
            r2 = -1
        L4:
            int r3 = r10.i
            if (r1 >= r3) goto L5d
            b.f.b.g[] r3 = r10.g
            r4 = r3[r1]
            int r5 = r4.f331b
            boolean r5 = r12[r5]
            if (r5 == 0) goto L13
            goto L5a
        L13:
            b.f.b.f$b r5 = r10.j
            r5.f329b = r4
            r4 = 8
            r6 = 1
            if (r2 != r0) goto L39
            r5.getClass()
        L1f:
            if (r4 < 0) goto L35
            b.f.b.g r3 = r5.f329b
            float[] r3 = r3.h
            r3 = r3[r4]
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L2d
            goto L35
        L2d:
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L32
            goto L36
        L32:
            int r4 = r4 + (-1)
            goto L1f
        L35:
            r6 = 0
        L36:
            if (r6 == 0) goto L5a
            goto L59
        L39:
            r3 = r3[r2]
            r5.getClass()
        L3e:
            if (r4 < 0) goto L56
            float[] r7 = r3.h
            r7 = r7[r4]
            b.f.b.g r8 = r5.f329b
            float[] r8 = r8.h
            r8 = r8[r4]
            int r9 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r9 != 0) goto L51
            int r4 = r4 + (-1)
            goto L3e
        L51:
            int r3 = (r8 > r7 ? 1 : (r8 == r7 ? 0 : -1))
            if (r3 >= 0) goto L56
            goto L57
        L56:
            r6 = 0
        L57:
            if (r6 == 0) goto L5a
        L59:
            r2 = r1
        L5a:
            int r1 = r1 + 1
            goto L4
        L5d:
            if (r2 != r0) goto L61
            r11 = 0
            return r11
        L61:
            b.f.b.g[] r11 = r10.g
            r11 = r11[r2]
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.b.f.b(b.f.b.d, boolean[]):b.f.b.g");
    }

    @Override // b.f.b.b, b.f.b.d.a
    public void clear() {
        this.i = 0;
        this.f322b = 0.0f;
    }

    @Override // b.f.b.b, b.f.b.d.a
    public boolean isEmpty() {
        return this.i == 0;
    }

    @Override // b.f.b.b
    public void l(d dVar, b.f.b.b bVar, boolean z) {
        g gVar = bVar.a;
        if (gVar == null) {
            return;
        }
        b.a aVar = bVar.d;
        int k = aVar.k();
        for (int i = 0; i < k; i++) {
            g d = aVar.d(i);
            float a2 = aVar.a(i);
            b bVar2 = this.j;
            bVar2.f329b = d;
            boolean z2 = true;
            if (d.a) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr = bVar2.f329b.h;
                    fArr[i2] = (gVar.h[i2] * a2) + fArr[i2];
                    if (Math.abs(fArr[i2]) < 1.0E-4f) {
                        bVar2.f329b.h[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    f.this.n(bVar2.f329b);
                }
                z2 = false;
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f = gVar.h[i3];
                    if (f != 0.0f) {
                        float f2 = f * a2;
                        if (Math.abs(f2) < 1.0E-4f) {
                            f2 = 0.0f;
                        }
                        bVar2.f329b.h[i3] = f2;
                    } else {
                        bVar2.f329b.h[i3] = 0.0f;
                    }
                }
            }
            if (z2) {
                m(d);
            }
            this.f322b = (bVar.f322b * a2) + this.f322b;
        }
        n(gVar);
    }

    public final void m(g gVar) {
        int i;
        int i2 = this.i + 1;
        g[] gVarArr = this.g;
        if (i2 > gVarArr.length) {
            g[] gVarArr2 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
            this.g = gVarArr2;
            this.h = (g[]) Arrays.copyOf(gVarArr2, gVarArr2.length * 2);
        }
        g[] gVarArr3 = this.g;
        int i3 = this.i;
        gVarArr3[i3] = gVar;
        int i4 = i3 + 1;
        this.i = i4;
        if (i4 > 1 && gVarArr3[i4 - 1].f331b > gVar.f331b) {
            int i5 = 0;
            while (true) {
                i = this.i;
                if (i5 >= i) {
                    break;
                }
                this.h[i5] = this.g[i5];
                i5++;
            }
            Arrays.sort(this.h, 0, i, new a(this));
            for (int i6 = 0; i6 < this.i; i6++) {
                this.g[i6] = this.h[i6];
            }
        }
        gVar.a = true;
        gVar.a(this);
    }

    public final void n(g gVar) {
        int i = 0;
        while (i < this.i) {
            if (this.g[i] == gVar) {
                while (true) {
                    int i2 = this.i;
                    if (i >= i2 - 1) {
                        this.i = i2 - 1;
                        gVar.a = false;
                        return;
                    }
                    g[] gVarArr = this.g;
                    int i3 = i + 1;
                    gVarArr[i] = gVarArr[i3];
                    i = i3;
                }
            } else {
                i++;
            }
        }
    }

    @Override // b.f.b.b
    public String toString() {
        String str = " goal -> (" + this.f322b + ") : ";
        for (int i = 0; i < this.i; i++) {
            this.j.f329b = this.g[i];
            StringBuilder g = c.a.a.a.a.g(str);
            g.append(this.j);
            g.append(" ");
            str = g.toString();
        }
        return str;
    }
}
