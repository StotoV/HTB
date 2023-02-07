package b.m;

import android.annotation.SuppressLint;
import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import b.c.a.b.b;
import b.m.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends d {

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<g> f640c;
    public b.c.a.b.a<f, a> a = new b.c.a.b.a<>();
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public ArrayList<d.b> g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public d.b f639b = d.b.INITIALIZED;
    public final boolean h = true;

    /* loaded from: classes.dex */
    public static class a {
        public d.b a;

        /* renamed from: b  reason: collision with root package name */
        public e f641b;

        public a(f fVar, d.b bVar) {
            e reflectiveGenericLifecycleObserver;
            Map<Class<?>, Integer> map = j.a;
            boolean z = fVar instanceof e;
            boolean z2 = fVar instanceof b;
            if (z && z2) {
                reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((b) fVar, (e) fVar);
            } else if (z2) {
                reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((b) fVar, null);
            } else if (z) {
                reflectiveGenericLifecycleObserver = (e) fVar;
            } else {
                Class<?> cls = fVar.getClass();
                if (j.c(cls) == 2) {
                    List<Constructor<? extends c>> list = j.f642b.get(cls);
                    if (list.size() == 1) {
                        reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver(j.a(list.get(0), fVar));
                    } else {
                        c[] cVarArr = new c[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            cVarArr[i] = j.a(list.get(i), fVar);
                        }
                        reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(cVarArr);
                    }
                } else {
                    reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(fVar);
                }
            }
            this.f641b = reflectiveGenericLifecycleObserver;
            this.a = bVar;
        }

        public void a(g gVar, d.a aVar) {
            d.b a = aVar.a();
            this.a = h.e(this.a, a);
            this.f641b.h(gVar, aVar);
            this.a = a;
        }
    }

    public h(g gVar) {
        this.f640c = new WeakReference<>(gVar);
    }

    public static d.b e(d.b bVar, d.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @Override // b.m.d
    public void a(f fVar) {
        g gVar;
        c("addObserver");
        d.b bVar = this.f639b;
        d.b bVar2 = d.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = d.b.INITIALIZED;
        }
        a aVar = new a(fVar, bVar2);
        if (this.a.d(fVar, aVar) == null && (gVar = this.f640c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            d.b b2 = b(fVar);
            this.d++;
            while (aVar.a.compareTo(b2) < 0 && this.a.f.containsKey(fVar)) {
                this.g.add(aVar.a);
                d.a b3 = d.a.b(aVar.a);
                if (b3 == null) {
                    StringBuilder g = c.a.a.a.a.g("no event up from ");
                    g.append(aVar.a);
                    throw new IllegalStateException(g.toString());
                }
                aVar.a(gVar, b3);
                g();
                b2 = b(fVar);
            }
            if (!z) {
                h();
            }
            this.d--;
        }
    }

    public final d.b b(f fVar) {
        b.c.a.b.a<f, a> aVar = this.a;
        d.b bVar = null;
        b.c<f, a> cVar = aVar.f.containsKey(fVar) ? aVar.f.get(fVar).e : null;
        d.b bVar2 = cVar != null ? cVar.f290c.a : null;
        if (!this.g.isEmpty()) {
            ArrayList<d.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return e(e(this.f639b, bVar2), bVar);
    }

    @SuppressLint({"RestrictedApi"})
    public final void c(String str) {
        if (!this.h || b.c.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException(c.a.a.a.a.e("Method ", str, " must be called on the main thread"));
    }

    public void d(d.a aVar) {
        c("handleLifecycleEvent");
        f(aVar.a());
    }

    public final void f(d.b bVar) {
        if (this.f639b == bVar) {
            return;
        }
        this.f639b = bVar;
        if (this.e || this.d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        h();
        this.e = false;
    }

    public final void g() {
        ArrayList<d.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        g gVar = this.f640c.get();
        if (gVar != null) {
            while (true) {
                b.c.a.b.a<f, a> aVar = this.a;
                boolean z = true;
                if (aVar.e != 0) {
                    d.b bVar = aVar.f287b.f290c.a;
                    d.b bVar2 = aVar.f288c.f290c.a;
                    if (bVar != bVar2 || this.f639b != bVar2) {
                        z = false;
                    }
                }
                this.f = false;
                if (z) {
                    return;
                }
                if (this.f639b.compareTo(aVar.f287b.f290c.a) < 0) {
                    b.c.a.b.a<f, a> aVar2 = this.a;
                    b.C0010b c0010b = new b.C0010b(aVar2.f288c, aVar2.f287b);
                    aVar2.d.put(c0010b, Boolean.FALSE);
                    while (c0010b.hasNext() && !this.f) {
                        Map.Entry entry = (Map.Entry) c0010b.next();
                        a aVar3 = (a) entry.getValue();
                        while (aVar3.a.compareTo(this.f639b) > 0 && !this.f && this.a.contains(entry.getKey())) {
                            int ordinal = aVar3.a.ordinal();
                            d.a aVar4 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : d.a.ON_PAUSE : d.a.ON_STOP : d.a.ON_DESTROY;
                            if (aVar4 == null) {
                                StringBuilder g = c.a.a.a.a.g("no event down from ");
                                g.append(aVar3.a);
                                throw new IllegalStateException(g.toString());
                            }
                            this.g.add(aVar4.a());
                            aVar3.a(gVar, aVar4);
                            g();
                        }
                    }
                }
                b.c<f, a> cVar = this.a.f288c;
                if (!this.f && cVar != null && this.f639b.compareTo(cVar.f290c.a) > 0) {
                    b.c.a.b.b<f, a>.d b2 = this.a.b();
                    while (b2.hasNext() && !this.f) {
                        Map.Entry entry2 = (Map.Entry) b2.next();
                        a aVar5 = (a) entry2.getValue();
                        while (aVar5.a.compareTo(this.f639b) < 0 && !this.f && this.a.contains(entry2.getKey())) {
                            this.g.add(aVar5.a);
                            d.a b3 = d.a.b(aVar5.a);
                            if (b3 == null) {
                                StringBuilder g2 = c.a.a.a.a.g("no event up from ");
                                g2.append(aVar5.a);
                                throw new IllegalStateException(g2.toString());
                            }
                            aVar5.a(gVar, b3);
                            g();
                        }
                    }
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }
}
