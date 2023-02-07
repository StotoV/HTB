package b.e;

import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class f<K, V> {
    public static Object[] e;
    public static int f;
    public static Object[] g;
    public static int h;

    /* renamed from: b  reason: collision with root package name */
    public int[] f316b;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f317c;
    public int d;

    public f() {
        this.f316b = b.a;
        this.f317c = b.f302c;
        this.d = 0;
    }

    public f(int i) {
        if (i == 0) {
            this.f316b = b.a;
            this.f317c = b.f302c;
        } else {
            a(i);
        }
        this.d = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (f.class) {
                if (h < 10) {
                    objArr[0] = g;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    g = objArr;
                    h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (f.class) {
                if (f < 10) {
                    objArr[0] = e;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    e = objArr;
                    f++;
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (f.class) {
                Object[] objArr = g;
                if (objArr != null) {
                    this.f317c = objArr;
                    g = (Object[]) objArr[0];
                    this.f316b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (f.class) {
                Object[] objArr2 = e;
                if (objArr2 != null) {
                    this.f317c = objArr2;
                    e = (Object[]) objArr2[0];
                    this.f316b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f--;
                    return;
                }
            }
        }
        this.f316b = new int[i];
        this.f317c = new Object[i << 1];
    }

    public void b(int i) {
        int i2 = this.d;
        int[] iArr = this.f316b;
        if (iArr.length < i) {
            Object[] objArr = this.f317c;
            a(i);
            if (this.d > 0) {
                System.arraycopy(iArr, 0, this.f316b, 0, i2);
                System.arraycopy(objArr, 0, this.f317c, 0, i2 << 1);
            }
            c(iArr, objArr, i2);
        }
        if (this.d == i2) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public void clear() {
        int i = this.d;
        if (i > 0) {
            int[] iArr = this.f316b;
            Object[] objArr = this.f317c;
            this.f316b = b.a;
            this.f317c = b.f302c;
            this.d = 0;
            c(iArr, objArr, i);
        }
        if (this.d <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public int d(Object obj, int i) {
        int i2 = this.d;
        if (i2 == 0) {
            return -1;
        }
        try {
            int a = b.a(this.f316b, i2, i);
            if (a < 0 || obj.equals(this.f317c[a << 1])) {
                return a;
            }
            int i3 = a + 1;
            while (i3 < i2 && this.f316b[i3] == i) {
                if (obj.equals(this.f317c[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = a - 1; i4 >= 0 && this.f316b[i4] == i; i4--) {
                if (obj.equals(this.f317c[i4 << 1])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.d != fVar.d) {
                return false;
            }
            for (int i = 0; i < this.d; i++) {
                try {
                    K h2 = h(i);
                    V k = k(i);
                    Object obj2 = fVar.get(h2);
                    if (k == null) {
                        if (obj2 != null || !fVar.containsKey(h2)) {
                            return false;
                        }
                    } else if (!k.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.d != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                try {
                    K h3 = h(i2);
                    V k2 = k(i2);
                    Object obj3 = map.get(h3);
                    if (k2 == null) {
                        if (obj3 != null || !map.containsKey(h3)) {
                            return false;
                        }
                    } else if (!k2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i = this.d;
        if (i == 0) {
            return -1;
        }
        try {
            int a = b.a(this.f316b, i, 0);
            if (a < 0 || this.f317c[a << 1] == null) {
                return a;
            }
            int i2 = a + 1;
            while (i2 < i && this.f316b[i2] == 0) {
                if (this.f317c[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = a - 1; i3 >= 0 && this.f316b[i3] == 0; i3--) {
                if (this.f317c[i3 << 1] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int g(Object obj) {
        int i = this.d * 2;
        Object[] objArr = this.f317c;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int e2 = e(obj);
        return e2 >= 0 ? (V) this.f317c[(e2 << 1) + 1] : v;
    }

    public K h(int i) {
        return (K) this.f317c[i << 1];
    }

    public int hashCode() {
        int[] iArr = this.f316b;
        Object[] objArr = this.f317c;
        int i = this.d;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public V i(int i) {
        Object[] objArr = this.f317c;
        int i2 = i << 1;
        V v = (V) objArr[i2 + 1];
        int i3 = this.d;
        int i4 = 0;
        if (i3 <= 1) {
            c(this.f316b, objArr, i3);
            this.f316b = b.a;
            this.f317c = b.f302c;
        } else {
            int i5 = i3 - 1;
            int[] iArr = this.f316b;
            int i6 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(iArr, i7, iArr, i, i8);
                    Object[] objArr2 = this.f317c;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i2, i8 << 1);
                }
                Object[] objArr3 = this.f317c;
                int i9 = i5 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                a(i6);
                if (i3 != this.d) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f316b, 0, i);
                    System.arraycopy(objArr, 0, this.f317c, 0, i2);
                }
                if (i < i5) {
                    int i10 = i + 1;
                    int i11 = i5 - i;
                    System.arraycopy(iArr, i10, this.f316b, i, i11);
                    System.arraycopy(objArr, i10 << 1, this.f317c, i2, i11 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 == this.d) {
            this.d = i4;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public boolean isEmpty() {
        return this.d <= 0;
    }

    public V j(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f317c;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public V k(int i) {
        return (V) this.f317c[(i << 1) + 1];
    }

    public V put(K k, V v) {
        int i;
        int d;
        int i2 = this.d;
        if (k == null) {
            d = f();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            d = d(k, hashCode);
        }
        if (d >= 0) {
            int i3 = (d << 1) + 1;
            Object[] objArr = this.f317c;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = d ^ (-1);
        int[] iArr = this.f316b;
        if (i2 >= iArr.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            Object[] objArr2 = this.f317c;
            a(i5);
            if (i2 != this.d) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f316b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f317c, 0, objArr2.length);
            }
            c(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f316b;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f317c;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.d - i4) << 1);
        }
        int i7 = this.d;
        if (i2 == i7) {
            int[] iArr4 = this.f316b;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f317c;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.d = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V orDefault = getOrDefault(k, null);
        return orDefault == null ? put(k, v) : orDefault;
    }

    public V remove(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return i(e2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int e2 = e(obj);
        if (e2 >= 0) {
            V k = k(e2);
            if (obj2 != k && (obj2 == null || !obj2.equals(k))) {
                return false;
            }
            i(e2);
            return true;
        }
        return false;
    }

    public V replace(K k, V v) {
        int e2 = e(k);
        if (e2 >= 0) {
            return j(e2, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int e2 = e(k);
        if (e2 >= 0) {
            V k2 = k(e2);
            if (k2 != v && (v == null || !v.equals(k2))) {
                return false;
            }
            j(e2, v2);
            return true;
        }
        return false;
    }

    public int size() {
        return this.d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.d * 28);
        sb.append('{');
        for (int i = 0; i < this.d; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K h2 = h(i);
            if (h2 != this) {
                sb.append(h2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V k = k(i);
            if (k != this) {
                sb.append(k);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
