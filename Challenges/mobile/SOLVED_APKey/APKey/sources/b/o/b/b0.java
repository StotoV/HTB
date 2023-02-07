package b.o.b;

import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class b0 {
    public final b.e.f<RecyclerView.z, a> a = new b.e.f<>();

    /* renamed from: b  reason: collision with root package name */
    public final b.e.c<RecyclerView.z> f656b = new b.e.c<>();

    /* loaded from: classes.dex */
    public static class a {
        public static b.h.i.c<a> d = new b.h.i.c<>(20);
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.i.c f657b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.i.c f658c;

        public static a a() {
            a a = d.a();
            return a == null ? new a() : a;
        }

        public static void b(a aVar) {
            aVar.a = 0;
            aVar.f657b = null;
            aVar.f658c = null;
            d.b(aVar);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public void a(RecyclerView.z zVar) {
        a orDefault = this.a.getOrDefault(zVar, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(zVar, orDefault);
        }
        orDefault.a |= 1;
    }

    public void b(RecyclerView.z zVar, RecyclerView.i.c cVar) {
        a orDefault = this.a.getOrDefault(zVar, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(zVar, orDefault);
        }
        orDefault.f658c = cVar;
        orDefault.a |= 8;
    }

    public void c(RecyclerView.z zVar, RecyclerView.i.c cVar) {
        a orDefault = this.a.getOrDefault(zVar, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(zVar, orDefault);
        }
        orDefault.f657b = cVar;
        orDefault.a |= 4;
    }

    public boolean d(RecyclerView.z zVar) {
        a orDefault = this.a.getOrDefault(zVar, null);
        return (orDefault == null || (orDefault.a & 1) == 0) ? false : true;
    }

    public final RecyclerView.i.c e(RecyclerView.z zVar, int i) {
        a k;
        RecyclerView.i.c cVar;
        int e = this.a.e(zVar);
        if (e >= 0 && (k = this.a.k(e)) != null) {
            int i2 = k.a;
            if ((i2 & i) != 0) {
                int i3 = (i ^ (-1)) & i2;
                k.a = i3;
                if (i == 4) {
                    cVar = k.f657b;
                } else if (i != 8) {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                } else {
                    cVar = k.f658c;
                }
                if ((i3 & 12) == 0) {
                    this.a.i(e);
                    a.b(k);
                }
                return cVar;
            }
        }
        return null;
    }

    public void f(RecyclerView.z zVar) {
        a orDefault = this.a.getOrDefault(zVar, null);
        if (orDefault == null) {
            return;
        }
        orDefault.a &= -2;
    }

    public void g(RecyclerView.z zVar) {
        int h = this.f656b.h() - 1;
        while (true) {
            if (h < 0) {
                break;
            } else if (zVar == this.f656b.i(h)) {
                b.e.c<RecyclerView.z> cVar = this.f656b;
                Object[] objArr = cVar.d;
                Object obj = objArr[h];
                Object obj2 = b.e.c.f;
                if (obj != obj2) {
                    objArr[h] = obj2;
                    cVar.f303b = true;
                }
            } else {
                h--;
            }
        }
        a remove = this.a.remove(zVar);
        if (remove != null) {
            a.b(remove);
        }
    }
}
