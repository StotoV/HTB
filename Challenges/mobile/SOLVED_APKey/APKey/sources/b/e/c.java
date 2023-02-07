package b.e;
/* loaded from: classes.dex */
public class c<E> implements Cloneable {
    public static final Object f = new Object();

    /* renamed from: b  reason: collision with root package name */
    public boolean f303b = false;

    /* renamed from: c  reason: collision with root package name */
    public long[] f304c;
    public Object[] d;
    public int e;

    public c() {
        int f2 = b.f(10);
        this.f304c = new long[f2];
        this.d = new Object[f2];
    }

    public void a(long j, E e) {
        int i = this.e;
        if (i != 0 && j <= this.f304c[i - 1]) {
            g(j, e);
            return;
        }
        if (this.f303b && i >= this.f304c.length) {
            d();
        }
        int i2 = this.e;
        if (i2 >= this.f304c.length) {
            int f2 = b.f(i2 + 1);
            long[] jArr = new long[f2];
            Object[] objArr = new Object[f2];
            long[] jArr2 = this.f304c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f304c = jArr;
            this.d = objArr;
        }
        this.f304c[i2] = j;
        this.d[i2] = e;
        this.e = i2 + 1;
    }

    public void b() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.f303b = false;
    }

    /* renamed from: c */
    public c<E> clone() {
        try {
            c<E> cVar = (c) super.clone();
            cVar.f304c = (long[]) this.f304c.clone();
            cVar.d = (Object[]) this.d.clone();
            return cVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void d() {
        int i = this.e;
        long[] jArr = this.f304c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f303b = false;
        this.e = i2;
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e) {
        int b2 = b.b(this.f304c, this.e, j);
        if (b2 >= 0) {
            Object[] objArr = this.d;
            if (objArr[b2] != f) {
                return (E) objArr[b2];
            }
        }
        return e;
    }

    public void g(long j, E e) {
        int b2 = b.b(this.f304c, this.e, j);
        if (b2 >= 0) {
            this.d[b2] = e;
            return;
        }
        int i = b2 ^ (-1);
        int i2 = this.e;
        if (i < i2) {
            Object[] objArr = this.d;
            if (objArr[i] == f) {
                this.f304c[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f303b && i2 >= this.f304c.length) {
            d();
            i = b.b(this.f304c, this.e, j) ^ (-1);
        }
        int i3 = this.e;
        if (i3 >= this.f304c.length) {
            int f2 = b.f(i3 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f304c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f304c = jArr;
            this.d = objArr2;
        }
        int i4 = this.e;
        if (i4 - i != 0) {
            long[] jArr3 = this.f304c;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.d;
            System.arraycopy(objArr4, i, objArr4, i5, this.e - i);
        }
        this.f304c[i] = j;
        this.d[i] = e;
        this.e++;
    }

    public int h() {
        if (this.f303b) {
            d();
        }
        return this.e;
    }

    public E i(int i) {
        if (this.f303b) {
            d();
        }
        return (E) this.d[i];
    }

    public String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            if (this.f303b) {
                d();
            }
            sb.append(this.f304c[i]);
            sb.append('=');
            E i2 = i(i);
            if (i2 != this) {
                sb.append(i2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
