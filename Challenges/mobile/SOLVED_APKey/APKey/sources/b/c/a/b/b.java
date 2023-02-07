package b.c.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: b  reason: collision with root package name */
    public c<K, V> f287b;

    /* renamed from: c  reason: collision with root package name */
    public c<K, V> f288c;
    public WeakHashMap<f<K, V>, Boolean> d = new WeakHashMap<>();
    public int e = 0;

    /* loaded from: classes.dex */
    public static class a<K, V> extends e<K, V> {
        public a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.e;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.d;
        }
    }

    /* renamed from: b.c.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010b<K, V> extends e<K, V> {
        public C0010b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // b.c.a.b.b.e
        public c<K, V> b(c<K, V> cVar) {
            return cVar.d;
        }

        @Override // b.c.a.b.b.e
        public c<K, V> c(c<K, V> cVar) {
            return cVar.e;
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f289b;

        /* renamed from: c  reason: collision with root package name */
        public final V f290c;
        public c<K, V> d;
        public c<K, V> e;

        public c(K k, V v) {
            this.f289b = k;
            this.f290c = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f289b.equals(cVar.f289b) && this.f290c.equals(cVar.f290c);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f289b;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f290c;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f289b.hashCode() ^ this.f290c.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f289b + "=" + this.f290c;
        }
    }

    /* loaded from: classes.dex */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f291b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f292c = true;

        public d() {
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f291b;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.e;
                this.f291b = cVar3;
                this.f292c = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f292c) {
                return b.this.f287b != null;
            }
            c<K, V> cVar = this.f291b;
            return (cVar == null || cVar.d == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar;
            if (this.f292c) {
                this.f292c = false;
                cVar = b.this.f287b;
            } else {
                c<K, V> cVar2 = this.f291b;
                cVar = cVar2 != null ? cVar2.d : null;
            }
            this.f291b = cVar;
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public c<K, V> f293b;

        /* renamed from: c  reason: collision with root package name */
        public c<K, V> f294c;

        public e(c<K, V> cVar, c<K, V> cVar2) {
            this.f293b = cVar2;
            this.f294c = cVar;
        }

        @Override // b.c.a.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = null;
            if (this.f293b == cVar && cVar == this.f294c) {
                this.f294c = null;
                this.f293b = null;
            }
            c<K, V> cVar3 = this.f293b;
            if (cVar3 == cVar) {
                this.f293b = b(cVar3);
            }
            c<K, V> cVar4 = this.f294c;
            if (cVar4 == cVar) {
                c<K, V> cVar5 = this.f293b;
                if (cVar4 != cVar5 && cVar5 != null) {
                    cVar2 = c(cVar4);
                }
                this.f294c = cVar2;
            }
        }

        public abstract c<K, V> b(c<K, V> cVar);

        public abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f294c != null;
        }

        @Override // java.util.Iterator
        public Object next() {
            c<K, V> cVar = this.f294c;
            c<K, V> cVar2 = this.f293b;
            this.f294c = (cVar == cVar2 || cVar2 == null) ? null : c(cVar);
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public interface f<K, V> {
        void a(c<K, V> cVar);
    }

    public c<K, V> a(K k) {
        c<K, V> cVar = this.f287b;
        while (cVar != null && !cVar.f289b.equals(k)) {
            cVar = cVar.d;
        }
        return cVar;
    }

    public b<K, V>.d b() {
        b<K, V>.d dVar = new d();
        this.d.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public c<K, V> c(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.e++;
        c<K, V> cVar2 = this.f288c;
        if (cVar2 == null) {
            this.f287b = cVar;
        } else {
            cVar2.d = cVar;
            cVar.e = cVar2;
        }
        this.f288c = cVar;
        return cVar;
    }

    public V d(K k, V v) {
        c<K, V> a2 = a(k);
        if (a2 != null) {
            return a2.f290c;
        }
        c(k, v);
        return null;
    }

    public V e(K k) {
        c<K, V> a2 = a(k);
        if (a2 == null) {
            return null;
        }
        this.e--;
        if (!this.d.isEmpty()) {
            for (f<K, V> fVar : this.d.keySet()) {
                fVar.a(a2);
            }
        }
        c<K, V> cVar = a2.e;
        c<K, V> cVar2 = a2.d;
        if (cVar != null) {
            cVar.d = cVar2;
        } else {
            this.f287b = cVar2;
        }
        c<K, V> cVar3 = a2.d;
        if (cVar3 != null) {
            cVar3.e = cVar;
        } else {
            this.f288c = cVar;
        }
        a2.d = null;
        a2.e = null;
        return a2.f290c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r3.hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (((b.c.a.b.b.e) r7).hasNext() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof b.c.a.b.b
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            b.c.a.b.b r7 = (b.c.a.b.b) r7
            int r1 = r6.e
            int r3 = r7.e
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            b.c.a.b.b$e r3 = (b.c.a.b.b.e) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            b.c.a.b.b$e r4 = (b.c.a.b.b.e) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            b.c.a.b.b$e r7 = (b.c.a.b.b.e) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = 0
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a.b.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int i = 0;
        while (true) {
            e eVar = (e) it;
            if (eVar.hasNext()) {
                i += ((Map.Entry) eVar.next()).hashCode();
            } else {
                return i;
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f287b, this.f288c);
        this.d.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (true) {
            e eVar = (e) it;
            if (!eVar.hasNext()) {
                g.append("]");
                return g.toString();
            }
            g.append(((Map.Entry) eVar.next()).toString());
            if (eVar.hasNext()) {
                g.append(", ");
            }
        }
    }
}
