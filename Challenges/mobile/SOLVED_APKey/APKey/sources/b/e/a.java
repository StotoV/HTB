package b.e;

import b.e.e;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class a<K, V> extends f<K, V> implements Map<K, V> {
    public e<K, V> i;

    /* renamed from: b.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0011a extends e<K, V> {
        public C0011a() {
        }

        @Override // b.e.e
        public void a() {
            a.this.clear();
        }

        @Override // b.e.e
        public Object b(int i, int i2) {
            return a.this.f317c[(i << 1) + i2];
        }

        @Override // b.e.e
        public Map<K, V> c() {
            return a.this;
        }

        @Override // b.e.e
        public int d() {
            return a.this.d;
        }

        @Override // b.e.e
        public int e(Object obj) {
            return a.this.e(obj);
        }

        @Override // b.e.e
        public int f(Object obj) {
            return a.this.g(obj);
        }

        @Override // b.e.e
        public void g(K k, V v) {
            a.this.put(k, v);
        }

        @Override // b.e.e
        public void h(int i) {
            a.this.i(i);
        }

        @Override // b.e.e
        public V i(int i, V v) {
            int i2 = (i << 1) + 1;
            Object[] objArr = a.this.f317c;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
    }

    public a() {
    }

    public a(int i) {
        super(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(f fVar) {
        if (fVar != null) {
            int i = fVar.d;
            b(this.d + i);
            if (this.d != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    put(fVar.h(i2), fVar.k(i2));
                }
            } else if (i > 0) {
                System.arraycopy(fVar.f316b, 0, this.f316b, 0, i);
                System.arraycopy(fVar.f317c, 0, this.f317c, 0, i << 1);
                this.d = i;
            }
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e<K, V> l = l();
        if (l.a == null) {
            l.a = new e.b();
        }
        return l.a;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        e<K, V> l = l();
        if (l.f307b == null) {
            l.f307b = new e.c();
        }
        return l.f307b;
    }

    public final e<K, V> l() {
        if (this.i == null) {
            this.i = new C0011a();
        }
        return this.i;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.d);
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        e<K, V> l = l();
        if (l.f308c == null) {
            l.f308c = new e.C0012e();
        }
        return l.f308c;
    }
}
