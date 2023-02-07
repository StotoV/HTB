package b.g.b;

import b.e.f;
import b.h.i.c;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class a<T> {
    public final c<ArrayList<T>> a = new c<>(10);

    /* renamed from: b  reason: collision with root package name */
    public final f<T, ArrayList<T>> f392b = new f<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f393c = new ArrayList<>();
    public final HashSet<T> d = new HashSet<>();

    public void a(T t) {
        if (!(this.f392b.e(t) >= 0)) {
            this.f392b.put(t, null);
        }
    }

    public final void b(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (hashSet.contains(t)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t);
        ArrayList<T> orDefault = this.f392b.getOrDefault(t, null);
        if (orDefault != null) {
            int size = orDefault.size();
            for (int i = 0; i < size; i++) {
                b(orDefault.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(t);
        arrayList.add(t);
    }
}
