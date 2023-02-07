package b.c.a.b;

import b.c.a.b.b;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a<K, V> extends b<K, V> {
    public HashMap<K, b.c<K, V>> f = new HashMap<>();

    @Override // b.c.a.b.b
    public b.c<K, V> a(K k) {
        return this.f.get(k);
    }

    public boolean contains(K k) {
        return this.f.containsKey(k);
    }

    @Override // b.c.a.b.b
    public V d(K k, V v) {
        b.c<K, V> cVar = this.f.get(k);
        if (cVar != null) {
            return cVar.f290c;
        }
        this.f.put(k, c(k, v));
        return null;
    }

    @Override // b.c.a.b.b
    public V e(K k) {
        V v = (V) super.e(k);
        this.f.remove(k);
        return v;
    }
}
