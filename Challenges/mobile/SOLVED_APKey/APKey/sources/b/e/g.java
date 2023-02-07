package b.e;
/* loaded from: classes.dex */
public class g<E> implements Cloneable {
    public static final Object e = new Object();

    /* renamed from: b  reason: collision with root package name */
    public int[] f318b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f319c;
    public int d;

    public g() {
        int e2 = b.e(10);
        this.f318b = new int[e2];
        this.f319c = new Object[e2];
    }

    public void a(int i, E e2) {
        int i2 = this.d;
        if (i2 != 0 && i <= this.f318b[i2 - 1]) {
            f(i, e2);
            return;
        }
        if (i2 >= this.f318b.length) {
            int e3 = b.e(i2 + 1);
            int[] iArr = new int[e3];
            Object[] objArr = new Object[e3];
            int[] iArr2 = this.f318b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f319c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f318b = iArr;
            this.f319c = objArr;
        }
        this.f318b[i2] = i;
        this.f319c[i2] = e2;
        this.d = i2 + 1;
    }

    /* renamed from: b */
    public g<E> clone() {
        try {
            g<E> gVar = (g) super.clone();
            gVar.f318b = (int[]) this.f318b.clone();
            gVar.f319c = (Object[]) this.f319c.clone();
            return gVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E c(int i) {
        return d(i, null);
    }

    public E d(int i, E e2) {
        int a = b.a(this.f318b, this.d, i);
        if (a >= 0) {
            Object[] objArr = this.f319c;
            if (objArr[a] != e) {
                return (E) objArr[a];
            }
        }
        return e2;
    }

    public int e(int i) {
        return this.f318b[i];
    }

    public void f(int i, E e2) {
        int a = b.a(this.f318b, this.d, i);
        if (a >= 0) {
            this.f319c[a] = e2;
            return;
        }
        int i2 = a ^ (-1);
        int i3 = this.d;
        if (i2 < i3) {
            Object[] objArr = this.f319c;
            if (objArr[i2] == e) {
                this.f318b[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (i3 >= this.f318b.length) {
            int e3 = b.e(i3 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f318b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f319c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f318b = iArr;
            this.f319c = objArr2;
        }
        int i4 = this.d - i2;
        if (i4 != 0) {
            int[] iArr3 = this.f318b;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4);
            Object[] objArr4 = this.f319c;
            System.arraycopy(objArr4, i2, objArr4, i5, this.d - i2);
        }
        this.f318b[i2] = i;
        this.f319c[i2] = e2;
        this.d++;
    }

    public int g() {
        return this.d;
    }

    public E h(int i) {
        return (E) this.f319c[i];
    }

    public String toString() {
        if (g() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(e(i));
            sb.append('=');
            E h = h(i);
            if (h != this) {
                sb.append(h);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
