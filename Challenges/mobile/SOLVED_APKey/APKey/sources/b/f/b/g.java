package b.f.b;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {
    public static int n = 1;
    public boolean a;
    public float e;
    public a i;

    /* renamed from: b  reason: collision with root package name */
    public int f331b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f332c = -1;
    public int d = 0;
    public boolean f = false;
    public float[] g = new float[9];
    public float[] h = new float[9];
    public b[] j = new b[16];
    public int k = 0;
    public int l = 0;
    public int m = -1;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public g(a aVar) {
        this.i = aVar;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.k;
            if (i >= i2) {
                b[] bVarArr = this.j;
                if (i2 >= bVarArr.length) {
                    this.j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.j;
                int i3 = this.k;
                bVarArr2[i3] = bVar;
                this.k = i3 + 1;
                return;
            } else if (this.j[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.k;
        int i2 = 0;
        while (i2 < i) {
            if (this.j[i2] == bVar) {
                while (i2 < i - 1) {
                    b[] bVarArr = this.j;
                    int i3 = i2 + 1;
                    bVarArr[i2] = bVarArr[i3];
                    i2 = i3;
                }
                this.k--;
                return;
            }
            i2++;
        }
    }

    public void c() {
        this.i = a.UNKNOWN;
        this.d = 0;
        this.f331b = -1;
        this.f332c = -1;
        this.e = 0.0f;
        this.f = false;
        this.m = -1;
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2] = null;
        }
        this.k = 0;
        this.l = 0;
        this.a = false;
        Arrays.fill(this.h, 0.0f);
    }

    public void d(d dVar, float f) {
        this.e = f;
        this.f = true;
        this.m = -1;
        int i = this.k;
        this.f332c = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2].k(dVar, this, false);
        }
        this.k = 0;
    }

    public final void e(d dVar, b bVar) {
        int i = this.k;
        for (int i2 = 0; i2 < i; i2++) {
            this.j[i2].l(dVar, bVar, false);
        }
        this.k = 0;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("");
        g.append(this.f331b);
        return g.toString();
    }
}
