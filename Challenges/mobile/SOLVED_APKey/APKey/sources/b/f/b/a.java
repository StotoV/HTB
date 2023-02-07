package b.f.b;

import b.f.b.b;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: b  reason: collision with root package name */
    public final b f320b;

    /* renamed from: c  reason: collision with root package name */
    public final c f321c;
    public int a = 0;
    public int d = 8;
    public int[] e = new int[8];
    public int[] f = new int[8];
    public float[] g = new float[8];
    public int h = -1;
    public int i = -1;
    public boolean j = false;

    public a(b bVar, c cVar) {
        this.f320b = bVar;
        this.f321c = cVar;
    }

    @Override // b.f.b.b.a
    public float a(int i) {
        int i2 = this.h;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return this.g[i2];
            }
            i2 = this.f[i2];
        }
        return 0.0f;
    }

    @Override // b.f.b.b.a
    public final float b(g gVar, boolean z) {
        int i = this.h;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.a) {
            if (this.e[i] == gVar.f331b) {
                if (i == this.h) {
                    this.h = this.f[i];
                } else {
                    int[] iArr = this.f;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    gVar.b(this.f320b);
                }
                gVar.l--;
                this.a--;
                this.e[i] = -1;
                if (this.j) {
                    this.i = i;
                }
                return this.g[i];
            }
            i2++;
            i3 = i;
            i = this.f[i];
        }
        return 0.0f;
    }

    @Override // b.f.b.b.a
    public void c(g gVar, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.h;
            if (i == -1) {
                this.h = 0;
                this.g[0] = f;
                this.e[0] = gVar.f331b;
                this.f[0] = -1;
                gVar.l++;
                gVar.a(this.f320b);
                this.a++;
                if (this.j) {
                    return;
                }
                int i2 = this.i + 1;
                this.i = i2;
                int[] iArr = this.e;
                if (i2 < iArr.length) {
                    return;
                }
                this.j = true;
                this.i = iArr.length - 1;
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.a; i4++) {
                int[] iArr2 = this.e;
                int i5 = iArr2[i];
                int i6 = gVar.f331b;
                if (i5 == i6) {
                    float[] fArr = this.g;
                    float f2 = fArr[i] + f;
                    if (f2 > -0.001f && f2 < 0.001f) {
                        f2 = 0.0f;
                    }
                    fArr[i] = f2;
                    if (f2 != 0.0f) {
                        return;
                    }
                    if (i == this.h) {
                        this.h = this.f[i];
                    } else {
                        int[] iArr3 = this.f;
                        iArr3[i3] = iArr3[i];
                    }
                    if (z) {
                        gVar.b(this.f320b);
                    }
                    if (this.j) {
                        this.i = i;
                    }
                    gVar.l--;
                    this.a--;
                    return;
                }
                if (iArr2[i] < i6) {
                    i3 = i;
                }
                i = this.f[i];
            }
            int i7 = this.i;
            int i8 = i7 + 1;
            if (this.j) {
                int[] iArr4 = this.e;
                if (iArr4[i7] != -1) {
                    i7 = iArr4.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr5 = this.e;
            if (i7 >= iArr5.length && this.a < iArr5.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr6 = this.e;
                    if (i9 >= iArr6.length) {
                        break;
                    } else if (iArr6[i9] == -1) {
                        i7 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr7 = this.e;
            if (i7 >= iArr7.length) {
                i7 = iArr7.length;
                int i10 = this.d * 2;
                this.d = i10;
                this.j = false;
                this.i = i7 - 1;
                this.g = Arrays.copyOf(this.g, i10);
                this.e = Arrays.copyOf(this.e, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
            }
            this.e[i7] = gVar.f331b;
            this.g[i7] = f;
            int[] iArr8 = this.f;
            if (i3 != -1) {
                iArr8[i7] = iArr8[i3];
                iArr8[i3] = i7;
            } else {
                iArr8[i7] = this.h;
                this.h = i7;
            }
            gVar.l++;
            gVar.a(this.f320b);
            this.a++;
            if (!this.j) {
                this.i++;
            }
            int i11 = this.i;
            int[] iArr9 = this.e;
            if (i11 < iArr9.length) {
                return;
            }
            this.j = true;
            this.i = iArr9.length - 1;
        }
    }

    @Override // b.f.b.b.a
    public final void clear() {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            g gVar = this.f321c.d[this.e[i]];
            if (gVar != null) {
                gVar.b(this.f320b);
            }
            i = this.f[i];
        }
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.a = 0;
    }

    @Override // b.f.b.b.a
    public g d(int i) {
        int i2 = this.h;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return this.f321c.d[this.e[i2]];
            }
            i2 = this.f[i2];
        }
        return null;
    }

    @Override // b.f.b.b.a
    public final float e(g gVar) {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            if (this.e[i] == gVar.f331b) {
                return this.g[i];
            }
            i = this.f[i];
        }
        return 0.0f;
    }

    @Override // b.f.b.b.a
    public float f(b bVar, boolean z) {
        float e = e(bVar.a);
        b(bVar.a, z);
        b.a aVar = bVar.d;
        int k = aVar.k();
        for (int i = 0; i < k; i++) {
            g d = aVar.d(i);
            c(d, aVar.e(d) * e, z);
        }
        return e;
    }

    @Override // b.f.b.b.a
    public boolean g(g gVar) {
        int i = this.h;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            if (this.e[i] == gVar.f331b) {
                return true;
            }
            i = this.f[i];
        }
        return false;
    }

    @Override // b.f.b.b.a
    public void h(float f) {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            float[] fArr = this.g;
            fArr[i] = fArr[i] / f;
            i = this.f[i];
        }
    }

    @Override // b.f.b.b.a
    public void i() {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            float[] fArr = this.g;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f[i];
        }
    }

    @Override // b.f.b.b.a
    public final void j(g gVar, float f) {
        if (f == 0.0f) {
            b(gVar, true);
            return;
        }
        int i = this.h;
        if (i == -1) {
            this.h = 0;
            this.g[0] = f;
            this.e[0] = gVar.f331b;
            this.f[0] = -1;
            gVar.l++;
            gVar.a(this.f320b);
            this.a++;
            if (this.j) {
                return;
            }
            int i2 = this.i + 1;
            this.i = i2;
            int[] iArr = this.e;
            if (i2 < iArr.length) {
                return;
            }
            this.j = true;
            this.i = iArr.length - 1;
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.a; i4++) {
            int[] iArr2 = this.e;
            int i5 = iArr2[i];
            int i6 = gVar.f331b;
            if (i5 == i6) {
                this.g[i] = f;
                return;
            }
            if (iArr2[i] < i6) {
                i3 = i;
            }
            i = this.f[i];
        }
        int i7 = this.i;
        int i8 = i7 + 1;
        if (this.j) {
            int[] iArr3 = this.e;
            if (iArr3[i7] != -1) {
                i7 = iArr3.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr4 = this.e;
        if (i7 >= iArr4.length && this.a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.e;
                if (i9 >= iArr5.length) {
                    break;
                } else if (iArr5[i9] == -1) {
                    i7 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr6 = this.e;
        if (i7 >= iArr6.length) {
            i7 = iArr6.length;
            int i10 = this.d * 2;
            this.d = i10;
            this.j = false;
            this.i = i7 - 1;
            this.g = Arrays.copyOf(this.g, i10);
            this.e = Arrays.copyOf(this.e, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
        }
        this.e[i7] = gVar.f331b;
        this.g[i7] = f;
        int[] iArr7 = this.f;
        if (i3 != -1) {
            iArr7[i7] = iArr7[i3];
            iArr7[i3] = i7;
        } else {
            iArr7[i7] = this.h;
            this.h = i7;
        }
        gVar.l++;
        gVar.a(this.f320b);
        int i11 = this.a + 1;
        this.a = i11;
        if (!this.j) {
            this.i++;
        }
        int[] iArr8 = this.e;
        if (i11 >= iArr8.length) {
            this.j = true;
        }
        if (this.i < iArr8.length) {
            return;
        }
        this.j = true;
        this.i = iArr8.length - 1;
    }

    @Override // b.f.b.b.a
    public int k() {
        return this.a;
    }

    public String toString() {
        int i = this.h;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            StringBuilder g = c.a.a.a.a.g(c.a.a.a.a.d(str, " -> "));
            g.append(this.g[i]);
            g.append(" : ");
            StringBuilder g2 = c.a.a.a.a.g(g.toString());
            g2.append(this.f321c.d[this.e[i]]);
            str = g2.toString();
            i = this.f[i];
        }
        return str;
    }
}
