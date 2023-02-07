package androidx.lifecycle;

import android.util.Log;
import android.view.View;
import b.k.b.c0;
import b.k.b.l;
import b.m.d;
import b.m.e;
import b.m.g;
import b.m.h;
import b.m.m;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class LiveData<T> {
    public static final Object j = new Object();
    public final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public b.c.a.b.b<m<? super T>, LiveData<T>.b> f70b = new b.c.a.b.b<>();

    /* renamed from: c  reason: collision with root package name */
    public int f71c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;

    /* loaded from: classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.b implements e {
        public final g e;
        public final /* synthetic */ LiveData f;

        @Override // b.m.e
        public void h(g gVar, d.a aVar) {
            d.b bVar = ((h) this.e.a()).f639b;
            if (bVar == d.b.DESTROYED) {
                this.f.f(this.a);
                return;
            }
            d.b bVar2 = null;
            while (bVar2 != bVar) {
                d(j());
                bVar2 = bVar;
                bVar = ((h) this.e.a()).f639b;
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        public void i() {
            h hVar = (h) this.e.a();
            hVar.c("removeObserver");
            hVar.a.e(this);
        }

        @Override // androidx.lifecycle.LiveData.b
        public boolean j() {
            return ((h) this.e.a()).f639b.compareTo(d.b.STARTED) >= 0;
        }
    }

    /* loaded from: classes.dex */
    public class a extends LiveData<T>.b {
        public a(LiveData liveData, m<? super T> mVar) {
            super(mVar);
        }

        @Override // androidx.lifecycle.LiveData.b
        public boolean j() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public abstract class b {
        public final m<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f72b;

        /* renamed from: c  reason: collision with root package name */
        public int f73c = -1;

        public b(m<? super T> mVar) {
            this.a = mVar;
        }

        public void d(boolean z) {
            if (z == this.f72b) {
                return;
            }
            this.f72b = z;
            LiveData liveData = LiveData.this;
            int i = z ? 1 : -1;
            int i2 = liveData.f71c;
            liveData.f71c = i + i2;
            if (!liveData.d) {
                liveData.d = true;
                while (true) {
                    try {
                        int i3 = liveData.f71c;
                        if (i2 == i3) {
                            break;
                        }
                        boolean z2 = i2 == 0 && i3 > 0;
                        boolean z3 = i2 > 0 && i3 == 0;
                        if (z2) {
                            liveData.d();
                        } else if (z3) {
                            liveData.e();
                        }
                        i2 = i3;
                    } finally {
                        liveData.d = false;
                    }
                }
            }
            if (!this.f72b) {
                return;
            }
            LiveData.this.c(this);
        }

        public void i() {
        }

        public abstract boolean j();
    }

    public LiveData() {
        Object obj = j;
        this.f = obj;
        this.e = obj;
        this.g = -1;
    }

    public static void a(String str) {
        if (b.c.a.a.a.b().a()) {
            return;
        }
        throw new IllegalStateException(c.a.a.a.a.e("Cannot invoke ", str, " on a background thread"));
    }

    public final void b(LiveData<T>.b bVar) {
        if (!bVar.f72b) {
            return;
        }
        if (!bVar.j()) {
            bVar.d(false);
            return;
        }
        int i = bVar.f73c;
        int i2 = this.g;
        if (i >= i2) {
            return;
        }
        bVar.f73c = i2;
        m<? super T> mVar = bVar.a;
        Object obj = this.e;
        l.d dVar = (l.d) mVar;
        dVar.getClass();
        if (((g) obj) == null) {
            return;
        }
        l lVar = l.this;
        if (!lVar.b0) {
            return;
        }
        View j0 = lVar.j0();
        if (j0.getParent() != null) {
            throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }
        if (l.this.f0 == null) {
            return;
        }
        if (c0.M(3)) {
            Log.d("FragmentManager", "DialogFragment " + dVar + " setting the content view on " + l.this.f0);
        }
        l.this.f0.setContentView(j0);
    }

    public void c(LiveData<T>.b bVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (bVar == null) {
                b.c.a.b.b<m<? super T>, LiveData<T>.b>.d b2 = this.f70b.b();
                while (b2.hasNext()) {
                    b((b) ((Map.Entry) b2.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            } else {
                b(bVar);
                bVar = null;
            }
        } while (this.i);
        this.h = false;
    }

    public void d() {
    }

    public void e() {
    }

    public void f(m<? super T> mVar) {
        a("removeObserver");
        LiveData<T>.b e = this.f70b.e(mVar);
        if (e == null) {
            return;
        }
        e.i();
        e.d(false);
    }
}
