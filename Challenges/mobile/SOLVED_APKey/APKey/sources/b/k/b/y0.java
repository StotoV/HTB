package b.k.b;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import b.h.f.a;
import b.k.b.c0;
import b.k.b.m;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class y0 {
    public final ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<d> f615b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<d> f616c = new ArrayList<>();
    public boolean d = false;
    public boolean e = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f617b;

        public a(c cVar) {
            this.f617b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y0.this.f615b.contains(this.f617b)) {
                c cVar = this.f617b;
                cVar.a.a(cVar.f622c.F);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f619b;

        public b(c cVar) {
            this.f619b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            y0.this.f615b.remove(this.f619b);
            y0.this.f616c.remove(this.f619b);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d {
        public final i0 h;

        public c(d.c cVar, d.b bVar, i0 i0Var, b.h.f.a aVar) {
            super(cVar, bVar, i0Var.f559c, aVar);
            this.h = i0Var;
        }

        @Override // b.k.b.y0.d
        public void b() {
            super.b();
            this.h.k();
        }

        @Override // b.k.b.y0.d
        public void d() {
            if (this.f621b == d.b.ADDING) {
                m mVar = this.h.f559c;
                View findFocus = mVar.F.findFocus();
                if (findFocus != null) {
                    mVar.g().o = findFocus;
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + mVar);
                    }
                }
                View j0 = this.f622c.j0();
                if (j0.getParent() == null) {
                    this.h.b();
                    j0.setAlpha(0.0f);
                }
                if (j0.getAlpha() == 0.0f && j0.getVisibility() == 0) {
                    j0.setVisibility(4);
                }
                m.b bVar = mVar.I;
                j0.setAlpha(bVar == null ? 1.0f : bVar.n);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public b f621b;

        /* renamed from: c  reason: collision with root package name */
        public final m f622c;
        public final List<Runnable> d = new ArrayList();
        public final HashSet<b.h.f.a> e = new HashSet<>();
        public boolean f = false;
        public boolean g = false;

        /* loaded from: classes.dex */
        public class a implements a.InterfaceC0016a {
            public a() {
            }

            @Override // b.h.f.a.InterfaceC0016a
            public void a() {
                d.this.a();
            }
        }

        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c b(int i) {
                if (i != 0) {
                    if (i == 4) {
                        return INVISIBLE;
                    }
                    if (i == 8) {
                        return GONE;
                    }
                    throw new IllegalArgumentException("Unknown visibility " + i);
                }
                return VISIBLE;
            }

            public static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            public void a(View view) {
                int i;
                int ordinal = ordinal();
                if (ordinal == 0) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup == null) {
                        return;
                    }
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                    return;
                }
                if (ordinal == 1) {
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    i = 0;
                } else if (ordinal == 2) {
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i = 8;
                } else if (ordinal != 3) {
                    return;
                } else {
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                    i = 4;
                }
                view.setVisibility(i);
            }
        }

        public d(c cVar, b bVar, m mVar, b.h.f.a aVar) {
            this.a = cVar;
            this.f621b = bVar;
            this.f622c = mVar;
            aVar.b(new a());
        }

        public final void a() {
            if (this.f) {
                return;
            }
            this.f = true;
            if (this.e.isEmpty()) {
                b();
                return;
            }
            Iterator it = new ArrayList(this.e).iterator();
            while (it.hasNext()) {
                ((b.h.f.a) it.next()).a();
            }
        }

        public void b() {
            if (this.g) {
                return;
            }
            if (c0.M(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.g = true;
            for (Runnable runnable : this.d) {
                runnable.run();
            }
        }

        public final void c(c cVar, b bVar) {
            b bVar2;
            c cVar2 = c.REMOVED;
            int ordinal = bVar.ordinal();
            if (ordinal == 0) {
                if (this.a == cVar2) {
                    return;
                }
                if (c0.M(2)) {
                    StringBuilder g = c.a.a.a.a.g("SpecialEffectsController: For fragment ");
                    g.append(this.f622c);
                    g.append(" mFinalState = ");
                    g.append(this.a);
                    g.append(" -> ");
                    g.append(cVar);
                    g.append(". ");
                    Log.v("FragmentManager", g.toString());
                }
                this.a = cVar;
                return;
            }
            if (ordinal != 1) {
                if (ordinal != 2) {
                    return;
                }
                if (c0.M(2)) {
                    StringBuilder g2 = c.a.a.a.a.g("SpecialEffectsController: For fragment ");
                    g2.append(this.f622c);
                    g2.append(" mFinalState = ");
                    g2.append(this.a);
                    g2.append(" -> REMOVED. mLifecycleImpact  = ");
                    g2.append(this.f621b);
                    g2.append(" to REMOVING.");
                    Log.v("FragmentManager", g2.toString());
                }
                this.a = cVar2;
                bVar2 = b.REMOVING;
            } else if (this.a != cVar2) {
                return;
            } else {
                if (c0.M(2)) {
                    StringBuilder g3 = c.a.a.a.a.g("SpecialEffectsController: For fragment ");
                    g3.append(this.f622c);
                    g3.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    g3.append(this.f621b);
                    g3.append(" to ADDING.");
                    Log.v("FragmentManager", g3.toString());
                }
                this.a = c.VISIBLE;
                bVar2 = b.ADDING;
            }
            this.f621b = bVar2;
        }

        public void d() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.a + "} {mLifecycleImpact = " + this.f621b + "} {mFragment = " + this.f622c + "}";
        }
    }

    public y0(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static y0 f(ViewGroup viewGroup, c0 c0Var) {
        return g(viewGroup, c0Var.K());
    }

    public static y0 g(ViewGroup viewGroup, z0 z0Var) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof y0) {
            return (y0) tag;
        }
        ((c0.f) z0Var).getClass();
        b.k.b.c cVar = new b.k.b.c(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, cVar);
        return cVar;
    }

    public final void a(d.c cVar, d.b bVar, i0 i0Var) {
        synchronized (this.f615b) {
            b.h.f.a aVar = new b.h.f.a();
            d d2 = d(i0Var.f559c);
            if (d2 != null) {
                d2.c(cVar, bVar);
                return;
            }
            c cVar2 = new c(cVar, bVar, i0Var, aVar);
            this.f615b.add(cVar2);
            cVar2.d.add(new a(cVar2));
            cVar2.d.add(new b(cVar2));
        }
    }

    public abstract void b(List<d> list, boolean z);

    public void c() {
        if (this.e) {
            return;
        }
        if (!b.h.j.q.t(this.a)) {
            e();
            this.d = false;
            return;
        }
        synchronized (this.f615b) {
            if (!this.f615b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f616c);
                this.f616c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + dVar);
                    }
                    dVar.a();
                    if (!dVar.g) {
                        this.f616c.add(dVar);
                    }
                }
                i();
                ArrayList arrayList2 = new ArrayList(this.f615b);
                this.f615b.clear();
                this.f616c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((d) it2.next()).d();
                }
                b(arrayList2, this.d);
                this.d = false;
            }
        }
    }

    public final d d(m mVar) {
        Iterator<d> it = this.f615b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f622c.equals(mVar) && !next.f) {
                return next;
            }
        }
        return null;
    }

    public void e() {
        String str;
        String str2;
        boolean t = b.h.j.q.t(this.a);
        synchronized (this.f615b) {
            i();
            Iterator<d> it = this.f615b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            Iterator it2 = new ArrayList(this.f616c).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (c0.M(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (t) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(dVar);
                    Log.v("FragmentManager", sb.toString());
                }
                dVar.a();
            }
            Iterator it3 = new ArrayList(this.f615b).iterator();
            while (it3.hasNext()) {
                d dVar2 = (d) it3.next();
                if (c0.M(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (t) {
                        str = "";
                    } else {
                        str = "Container " + this.a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(dVar2);
                    Log.v("FragmentManager", sb2.toString());
                }
                dVar2.a();
            }
        }
    }

    public void h() {
        synchronized (this.f615b) {
            i();
            this.e = false;
            int size = this.f615b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                d dVar = this.f615b.get(size);
                d.c c2 = d.c.c(dVar.f622c.F);
                d.c cVar = dVar.a;
                d.c cVar2 = d.c.VISIBLE;
                if (cVar == cVar2 && c2 != cVar2) {
                    this.e = dVar.f622c.D();
                    break;
                }
                size--;
            }
        }
    }

    public final void i() {
        Iterator<d> it = this.f615b.iterator();
        while (it.hasNext()) {
            d next = it.next();
            if (next.f621b == d.b.ADDING) {
                next.c(d.c.b(next.f622c.j0().getVisibility()), d.b.NONE);
            }
        }
    }
}
