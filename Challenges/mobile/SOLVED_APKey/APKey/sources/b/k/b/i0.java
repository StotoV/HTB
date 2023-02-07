package b.k.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.k.b.m;
import b.k.b.y0;
import b.m.d;
import b.m.g;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes.dex */
public class i0 {
    public final b0 a;

    /* renamed from: b  reason: collision with root package name */
    public final j0 f558b;

    /* renamed from: c  reason: collision with root package name */
    public final m f559c;
    public boolean d = false;
    public int e = -1;

    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f560b;

        public a(i0 i0Var, View view) {
            this.f560b = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f560b.removeOnAttachStateChangeListener(this);
            b.h.j.q.D(this.f560b);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public i0(b0 b0Var, j0 j0Var, m mVar) {
        this.a = b0Var;
        this.f558b = j0Var;
        this.f559c = mVar;
    }

    public i0(b0 b0Var, j0 j0Var, m mVar, h0 h0Var) {
        this.a = b0Var;
        this.f558b = j0Var;
        this.f559c = mVar;
        mVar.d = null;
        mVar.e = null;
        mVar.r = 0;
        mVar.o = false;
        mVar.l = false;
        m mVar2 = mVar.h;
        mVar.i = mVar2 != null ? mVar2.f : null;
        mVar.h = null;
        Bundle bundle = h0Var.n;
        mVar.f576c = bundle == null ? new Bundle() : bundle;
    }

    public i0(b0 b0Var, j0 j0Var, ClassLoader classLoader, y yVar, h0 h0Var) {
        this.a = b0Var;
        this.f558b = j0Var;
        m a2 = yVar.a(classLoader, h0Var.f554b);
        this.f559c = a2;
        Bundle bundle = h0Var.k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.n0(h0Var.k);
        a2.f = h0Var.f555c;
        a2.n = h0Var.d;
        a2.p = true;
        a2.w = h0Var.e;
        a2.x = h0Var.f;
        a2.y = h0Var.g;
        a2.B = h0Var.h;
        a2.m = h0Var.i;
        a2.A = h0Var.j;
        a2.z = h0Var.l;
        a2.N = d.b.values()[h0Var.m];
        Bundle bundle2 = h0Var.n;
        a2.f576c = bundle2 == null ? new Bundle() : bundle2;
        if (c0.M(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a2);
        }
    }

    public void a() {
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("moveto ACTIVITY_CREATED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        Bundle bundle = mVar.f576c;
        mVar.u.T();
        mVar.f575b = 3;
        mVar.D = false;
        mVar.F();
        if (mVar.D) {
            if (c0.M(3)) {
                Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + mVar);
            }
            View view = mVar.F;
            if (view != null) {
                Bundle bundle2 = mVar.f576c;
                SparseArray<Parcelable> sparseArray = mVar.d;
                if (sparseArray != null) {
                    view.restoreHierarchyState(sparseArray);
                    mVar.d = null;
                }
                if (mVar.F != null) {
                    w0 w0Var = mVar.P;
                    w0Var.d.a(mVar.e);
                    mVar.e = null;
                }
                mVar.D = false;
                mVar.d0(bundle2);
                if (!mVar.D) {
                    throw new a1(c.a.a.a.a.c("Fragment ", mVar, " did not call through to super.onViewStateRestored()"));
                }
                if (mVar.F != null) {
                    mVar.P.e(d.a.ON_CREATE);
                }
            }
            mVar.f576c = null;
            c0 c0Var = mVar.u;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.g = false;
            c0Var.w(4);
            b0 b0Var = this.a;
            m mVar2 = this.f559c;
            b0Var.a(mVar2, mVar2.f576c, false);
            return;
        }
        throw new a1(c.a.a.a.a.c("Fragment ", mVar, " did not call through to super.onActivityCreated()"));
    }

    public void b() {
        View view;
        View view2;
        j0 j0Var = this.f558b;
        m mVar = this.f559c;
        j0Var.getClass();
        ViewGroup viewGroup = mVar.E;
        int i = -1;
        if (viewGroup != null) {
            int indexOf = j0Var.a.indexOf(mVar);
            int i2 = indexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= j0Var.a.size()) {
                            break;
                        }
                        m mVar2 = j0Var.a.get(indexOf);
                        if (mVar2.E == viewGroup && (view = mVar2.F) != null) {
                            i = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    m mVar3 = j0Var.a.get(i2);
                    if (mVar3.E == viewGroup && (view2 = mVar3.F) != null) {
                        i = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        m mVar4 = this.f559c;
        mVar4.E.addView(mVar4.F, i);
    }

    public void c() {
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("moveto ATTACHED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        m mVar2 = mVar.h;
        i0 i0Var = null;
        if (mVar2 != null) {
            i0 h = this.f558b.h(mVar2.f);
            if (h == null) {
                StringBuilder g2 = c.a.a.a.a.g("Fragment ");
                g2.append(this.f559c);
                g2.append(" declared target fragment ");
                g2.append(this.f559c.h);
                g2.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(g2.toString());
            }
            m mVar3 = this.f559c;
            mVar3.i = mVar3.h.f;
            mVar3.h = null;
            i0Var = h;
        } else {
            String str = mVar.i;
            if (str != null && (i0Var = this.f558b.h(str)) == null) {
                StringBuilder g3 = c.a.a.a.a.g("Fragment ");
                g3.append(this.f559c);
                g3.append(" declared target fragment ");
                g3.append(this.f559c.i);
                g3.append(" that does not belong to this FragmentManager!");
                throw new IllegalStateException(g3.toString());
            }
        }
        if (i0Var != null) {
            i0Var.k();
        }
        m mVar4 = this.f559c;
        c0 c0Var = mVar4.s;
        mVar4.t = c0Var.q;
        mVar4.v = c0Var.s;
        this.a.g(mVar4, false);
        m mVar5 = this.f559c;
        Iterator<m.d> it = mVar5.S.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        mVar5.S.clear();
        mVar5.u.b(mVar5.t, mVar5.e(), mVar5);
        mVar5.f575b = 0;
        mVar5.D = false;
        mVar5.I(mVar5.t.f628c);
        if (mVar5.D) {
            c0 c0Var2 = mVar5.s;
            Iterator<g0> it2 = c0Var2.o.iterator();
            while (it2.hasNext()) {
                it2.next().e(c0Var2, mVar5);
            }
            c0 c0Var3 = mVar5.u;
            c0Var3.B = false;
            c0Var3.C = false;
            c0Var3.J.g = false;
            c0Var3.w(0);
            this.a.b(this.f559c, false);
            return;
        }
        throw new a1(c.a.a.a.a.c("Fragment ", mVar5, " did not call through to super.onAttach()"));
    }

    public int d() {
        y0.d dVar;
        y0.d.b bVar;
        m mVar = this.f559c;
        if (mVar.s == null) {
            return mVar.f575b;
        }
        int i = this.e;
        int ordinal = mVar.N.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        m mVar2 = this.f559c;
        if (mVar2.n) {
            if (mVar2.o) {
                i = Math.max(this.e, 2);
                View view = this.f559c.F;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, mVar2.f575b) : Math.min(i, 1);
            }
        }
        if (!this.f559c.l) {
            i = Math.min(i, 1);
        }
        m mVar3 = this.f559c;
        ViewGroup viewGroup = mVar3.E;
        y0.d.b bVar2 = null;
        if (viewGroup != null) {
            y0 g = y0.g(viewGroup, mVar3.s().K());
            g.getClass();
            y0.d d = g.d(this.f559c);
            if (d != null) {
                bVar = d.f621b;
            } else {
                m mVar4 = this.f559c;
                Iterator<y0.d> it = g.f616c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        dVar = null;
                        break;
                    }
                    dVar = it.next();
                    if (dVar.f622c.equals(mVar4) && !dVar.f) {
                        break;
                    }
                }
                if (dVar != null) {
                    bVar = dVar.f621b;
                }
            }
            bVar2 = bVar;
        }
        if (bVar2 == y0.d.b.ADDING) {
            i = Math.min(i, 6);
        } else if (bVar2 == y0.d.b.REMOVING) {
            i = Math.max(i, 3);
        } else {
            m mVar5 = this.f559c;
            if (mVar5.m) {
                i = mVar5.C() ? Math.min(i, 1) : Math.min(i, -1);
            }
        }
        m mVar6 = this.f559c;
        if (mVar6.G && mVar6.f575b < 5) {
            i = Math.min(i, 4);
        }
        if (c0.M(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i + " for " + this.f559c);
        }
        return i;
    }

    public void e() {
        Parcelable parcelable;
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("moveto CREATED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        if (!mVar.M) {
            this.a.h(mVar, mVar.f576c, false);
            final m mVar2 = this.f559c;
            Bundle bundle = mVar2.f576c;
            mVar2.u.T();
            mVar2.f575b = 1;
            mVar2.D = false;
            if (Build.VERSION.SDK_INT >= 19) {
                mVar2.O.a(new b.m.e() { // from class: androidx.fragment.app.Fragment$5
                    @Override // b.m.e
                    public void h(g gVar, d.a aVar) {
                        View view;
                        if (aVar != d.a.ON_STOP || (view = m.this.F) == null) {
                            return;
                        }
                        view.cancelPendingInputEvents();
                    }
                });
            }
            mVar2.R.a(bundle);
            mVar2.L(bundle);
            mVar2.M = true;
            if (mVar2.D) {
                mVar2.O.d(d.a.ON_CREATE);
                b0 b0Var = this.a;
                m mVar3 = this.f559c;
                b0Var.c(mVar3, mVar3.f576c, false);
                return;
            }
            throw new a1(c.a.a.a.a.c("Fragment ", mVar2, " did not call through to super.onCreate()"));
        }
        Bundle bundle2 = mVar.f576c;
        if (bundle2 != null && (parcelable = bundle2.getParcelable("android:support:fragments")) != null) {
            mVar.u.Y(parcelable);
            mVar.u.m();
        }
        this.f559c.f575b = 1;
    }

    public void f() {
        String str;
        if (this.f559c.n) {
            return;
        }
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("moveto CREATE_VIEW: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        LayoutInflater R = mVar.R(mVar.f576c);
        mVar.L = R;
        ViewGroup viewGroup = null;
        m mVar2 = this.f559c;
        ViewGroup viewGroup2 = mVar2.E;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i = mVar2.x;
            if (i != 0) {
                if (i == -1) {
                    StringBuilder g2 = c.a.a.a.a.g("Cannot create fragment ");
                    g2.append(this.f559c);
                    g2.append(" for a container view with no id");
                    throw new IllegalArgumentException(g2.toString());
                }
                viewGroup = (ViewGroup) mVar2.s.r.g(i);
                if (viewGroup == null) {
                    m mVar3 = this.f559c;
                    if (!mVar3.p) {
                        try {
                            str = mVar3.x().getResourceName(this.f559c.x);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        StringBuilder g3 = c.a.a.a.a.g("No view found for id 0x");
                        g3.append(Integer.toHexString(this.f559c.x));
                        g3.append(" (");
                        g3.append(str);
                        g3.append(") for fragment ");
                        g3.append(this.f559c);
                        throw new IllegalArgumentException(g3.toString());
                    }
                }
            }
        }
        m mVar4 = this.f559c;
        mVar4.E = viewGroup;
        mVar4.e0(R, viewGroup, mVar4.f576c);
        View view = this.f559c.F;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            m mVar5 = this.f559c;
            mVar5.F.setTag(R.id.fragment_container_view_tag, mVar5);
            if (viewGroup != null) {
                b();
            }
            m mVar6 = this.f559c;
            if (mVar6.z) {
                mVar6.F.setVisibility(8);
            }
            if (b.h.j.q.t(this.f559c.F)) {
                b.h.j.q.D(this.f559c.F);
            } else {
                View view2 = this.f559c.F;
                view2.addOnAttachStateChangeListener(new a(this, view2));
            }
            m mVar7 = this.f559c;
            mVar7.c0();
            mVar7.u.w(2);
            b0 b0Var = this.a;
            m mVar8 = this.f559c;
            b0Var.m(mVar8, mVar8.F, mVar8.f576c, false);
            int visibility = this.f559c.F.getVisibility();
            this.f559c.g().n = this.f559c.F.getAlpha();
            m mVar9 = this.f559c;
            if (mVar9.E != null && visibility == 0) {
                View findFocus = mVar9.F.findFocus();
                if (findFocus != null) {
                    this.f559c.g().o = findFocus;
                    if (c0.M(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f559c);
                    }
                }
                this.f559c.F.setAlpha(0.0f);
            }
        }
        this.f559c.f575b = 2;
    }

    public void g() {
        m d;
        boolean z;
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("movefrom CREATED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        boolean z2 = mVar.m && !mVar.C();
        if (!(z2 || this.f558b.f563c.c(this.f559c))) {
            String str = this.f559c.i;
            if (str != null && (d = this.f558b.d(str)) != null && d.B) {
                this.f559c.h = d;
            }
            this.f559c.f575b = 0;
            return;
        }
        z<?> zVar = this.f559c.t;
        if (zVar instanceof b.m.u) {
            z = this.f558b.f563c.f;
        } else {
            Context context = zVar.f628c;
            z = context instanceof Activity ? !((Activity) context).isChangingConfigurations() : true;
        }
        if (z2 || z) {
            f0 f0Var = this.f558b.f563c;
            m mVar2 = this.f559c;
            f0Var.getClass();
            if (c0.M(3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + mVar2);
            }
            f0 f0Var2 = f0Var.f549c.get(mVar2.f);
            if (f0Var2 != null) {
                f0Var2.a();
                f0Var.f549c.remove(mVar2.f);
            }
            b.m.t tVar = f0Var.d.get(mVar2.f);
            if (tVar != null) {
                tVar.a();
                f0Var.d.remove(mVar2.f);
            }
        }
        m mVar3 = this.f559c;
        mVar3.u.o();
        mVar3.O.d(d.a.ON_DESTROY);
        mVar3.f575b = 0;
        mVar3.D = false;
        mVar3.M = false;
        mVar3.D = true;
        this.a.d(this.f559c, false);
        Iterator it = ((ArrayList) this.f558b.f()).iterator();
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            if (i0Var != null) {
                m mVar4 = i0Var.f559c;
                if (this.f559c.f.equals(mVar4.i)) {
                    mVar4.h = this.f559c;
                    mVar4.i = null;
                }
            }
        }
        m mVar5 = this.f559c;
        String str2 = mVar5.i;
        if (str2 != null) {
            mVar5.h = this.f558b.d(str2);
        }
        this.f558b.k(this);
    }

    public void h() {
        View view;
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("movefrom CREATE_VIEW: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        ViewGroup viewGroup = mVar.E;
        if (viewGroup != null && (view = mVar.F) != null) {
            viewGroup.removeView(view);
        }
        this.f559c.f0();
        this.a.n(this.f559c, false);
        m mVar2 = this.f559c;
        mVar2.E = null;
        mVar2.F = null;
        mVar2.P = null;
        mVar2.Q.g(null);
        this.f559c.o = false;
    }

    public void i() {
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("movefrom ATTACHED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        mVar.f575b = -1;
        mVar.D = false;
        mVar.Q();
        mVar.L = null;
        if (mVar.D) {
            c0 c0Var = mVar.u;
            if (!c0Var.D) {
                c0Var.o();
                mVar.u = new d0();
            }
            this.a.e(this.f559c, false);
            m mVar2 = this.f559c;
            mVar2.f575b = -1;
            mVar2.t = null;
            mVar2.v = null;
            mVar2.s = null;
            if (!(mVar2.m && !mVar2.C()) && !this.f558b.f563c.c(this.f559c)) {
                return;
            }
            if (c0.M(3)) {
                StringBuilder g2 = c.a.a.a.a.g("initState called for fragment: ");
                g2.append(this.f559c);
                Log.d("FragmentManager", g2.toString());
            }
            m mVar3 = this.f559c;
            mVar3.getClass();
            mVar3.O = new b.m.h(mVar3);
            mVar3.R = new b.p.b(mVar3);
            mVar3.f = UUID.randomUUID().toString();
            mVar3.l = false;
            mVar3.m = false;
            mVar3.n = false;
            mVar3.o = false;
            mVar3.p = false;
            mVar3.r = 0;
            mVar3.s = null;
            mVar3.u = new d0();
            mVar3.t = null;
            mVar3.w = 0;
            mVar3.x = 0;
            mVar3.y = null;
            mVar3.z = false;
            mVar3.A = false;
            return;
        }
        throw new a1(c.a.a.a.a.c("Fragment ", mVar, " did not call through to super.onDetach()"));
    }

    public void j() {
        m mVar = this.f559c;
        if (!mVar.n || !mVar.o || mVar.q) {
            return;
        }
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("moveto CREATE_VIEW: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar2 = this.f559c;
        LayoutInflater R = mVar2.R(mVar2.f576c);
        mVar2.L = R;
        mVar2.e0(R, null, this.f559c.f576c);
        View view = this.f559c.F;
        if (view == null) {
            return;
        }
        view.setSaveFromParentEnabled(false);
        m mVar3 = this.f559c;
        mVar3.F.setTag(R.id.fragment_container_view_tag, mVar3);
        m mVar4 = this.f559c;
        if (mVar4.z) {
            mVar4.F.setVisibility(8);
        }
        m mVar5 = this.f559c;
        mVar5.c0();
        mVar5.u.w(2);
        b0 b0Var = this.a;
        m mVar6 = this.f559c;
        b0Var.m(mVar6, mVar6.F, mVar6.f576c, false);
        this.f559c.f575b = 2;
    }

    public void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        y0.d.b bVar = y0.d.b.NONE;
        if (this.d) {
            if (!c0.M(2)) {
                return;
            }
            StringBuilder g = c.a.a.a.a.g("Ignoring re-entrant call to moveToExpectedState() for ");
            g.append(this.f559c);
            Log.v("FragmentManager", g.toString());
            return;
        }
        try {
            this.d = true;
            while (true) {
                int d = d();
                m mVar = this.f559c;
                int i = mVar.f575b;
                if (d == i) {
                    if (mVar.J) {
                        if (mVar.F != null && (viewGroup = mVar.E) != null) {
                            y0 g2 = y0.g(viewGroup, mVar.s().K());
                            if (this.f559c.z) {
                                g2.getClass();
                                if (c0.M(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + this.f559c);
                                }
                                g2.a(y0.d.c.GONE, bVar, this);
                            } else {
                                g2.getClass();
                                if (c0.M(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + this.f559c);
                                }
                                g2.a(y0.d.c.VISIBLE, bVar, this);
                            }
                        }
                        m mVar2 = this.f559c;
                        c0 c0Var = mVar2.s;
                        if (c0Var != null && mVar2.l && c0Var.N(mVar2)) {
                            c0Var.A = true;
                        }
                        m mVar3 = this.f559c;
                        mVar3.J = false;
                        mVar3.S();
                    }
                    return;
                } else if (d > i) {
                    switch (i + 1) {
                        case 0:
                            c();
                            continue;
                        case 1:
                            e();
                            continue;
                        case 2:
                            j();
                            f();
                            continue;
                        case 3:
                            a();
                            continue;
                        case 4:
                            if (mVar.F != null && (viewGroup2 = mVar.E) != null) {
                                y0 g3 = y0.g(viewGroup2, mVar.s().K());
                                y0.d.c b2 = y0.d.c.b(this.f559c.F.getVisibility());
                                g3.getClass();
                                if (c0.M(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + this.f559c);
                                }
                                g3.a(b2, y0.d.b.ADDING, this);
                            }
                            this.f559c.f575b = 4;
                            continue;
                        case 5:
                            p();
                            continue;
                        case 6:
                            mVar.f575b = 6;
                            continue;
                        case 7:
                            n();
                            continue;
                        default:
                            continue;
                    }
                } else {
                    switch (i - 1) {
                        case -1:
                            i();
                            continue;
                        case 0:
                            g();
                            continue;
                        case 1:
                            h();
                            this.f559c.f575b = 1;
                            continue;
                        case 2:
                            mVar.o = false;
                            mVar.f575b = 2;
                            continue;
                        case 3:
                            if (c0.M(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f559c);
                            }
                            m mVar4 = this.f559c;
                            if (mVar4.F != null && mVar4.d == null) {
                                o();
                            }
                            m mVar5 = this.f559c;
                            if (mVar5.F != null && (viewGroup3 = mVar5.E) != null) {
                                y0 g4 = y0.g(viewGroup3, mVar5.s().K());
                                g4.getClass();
                                if (c0.M(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + this.f559c);
                                }
                                g4.a(y0.d.c.REMOVED, y0.d.b.REMOVING, this);
                            }
                            this.f559c.f575b = 3;
                            continue;
                        case 4:
                            q();
                            continue;
                        case 5:
                            mVar.f575b = 5;
                            continue;
                        case 6:
                            l();
                            continue;
                        default:
                            continue;
                    }
                }
            }
        } finally {
            this.d = false;
        }
    }

    public void l() {
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("movefrom RESUMED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        mVar.u.w(5);
        if (mVar.F != null) {
            mVar.P.e(d.a.ON_PAUSE);
        }
        mVar.O.d(d.a.ON_PAUSE);
        mVar.f575b = 6;
        mVar.D = false;
        mVar.D = true;
        this.a.f(this.f559c, false);
    }

    public void m(ClassLoader classLoader) {
        Bundle bundle = this.f559c.f576c;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        m mVar = this.f559c;
        mVar.d = mVar.f576c.getSparseParcelableArray("android:view_state");
        m mVar2 = this.f559c;
        mVar2.e = mVar2.f576c.getBundle("android:view_registry_state");
        m mVar3 = this.f559c;
        mVar3.i = mVar3.f576c.getString("android:target_state");
        m mVar4 = this.f559c;
        if (mVar4.i != null) {
            mVar4.j = mVar4.f576c.getInt("android:target_req_state", 0);
        }
        m mVar5 = this.f559c;
        mVar5.getClass();
        mVar5.H = mVar5.f576c.getBoolean("android:user_visible_hint", true);
        m mVar6 = this.f559c;
        if (mVar6.H) {
            return;
        }
        mVar6.G = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n() {
        /*
            r8 = this;
            r0 = 3
            boolean r0 = b.k.b.c0.M(r0)
            java.lang.String r1 = "FragmentManager"
            if (r0 == 0) goto L1b
            java.lang.String r0 = "moveto RESUMED: "
            java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
            b.k.b.m r2 = r8.f559c
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1b:
            b.k.b.m r0 = r8.f559c
            b.k.b.m$b r2 = r0.I
            r3 = 0
            if (r2 != 0) goto L24
            r2 = r3
            goto L26
        L24:
            android.view.View r2 = r2.o
        L26:
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L8d
            android.view.View r0 = r0.F
            if (r2 != r0) goto L2f
            goto L3b
        L2f:
            android.view.ViewParent r0 = r2.getParent()
        L33:
            if (r0 == 0) goto L42
            b.k.b.m r6 = r8.f559c
            android.view.View r6 = r6.F
            if (r0 != r6) goto L3d
        L3b:
            r0 = 1
            goto L43
        L3d:
            android.view.ViewParent r0 = r0.getParent()
            goto L33
        L42:
            r0 = 0
        L43:
            if (r0 == 0) goto L8d
            boolean r0 = r2.requestFocus()
            r6 = 2
            boolean r6 = b.k.b.c0.M(r6)
            if (r6 == 0) goto L8d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "requestFocus: Restoring focused view "
            r6.append(r7)
            r6.append(r2)
            java.lang.String r2 = " "
            r6.append(r2)
            if (r0 == 0) goto L67
            java.lang.String r0 = "succeeded"
            goto L69
        L67:
            java.lang.String r0 = "failed"
        L69:
            r6.append(r0)
            java.lang.String r0 = " on Fragment "
            r6.append(r0)
            b.k.b.m r0 = r8.f559c
            r6.append(r0)
            java.lang.String r0 = " resulting in focused view "
            r6.append(r0)
            b.k.b.m r0 = r8.f559c
            android.view.View r0 = r0.F
            android.view.View r0 = r0.findFocus()
            r6.append(r0)
            java.lang.String r0 = r6.toString()
            android.util.Log.v(r1, r0)
        L8d:
            b.k.b.m r0 = r8.f559c
            r0.o0(r3)
            b.k.b.m r0 = r8.f559c
            b.k.b.c0 r1 = r0.u
            r1.T()
            b.k.b.c0 r1 = r0.u
            r1.C(r4)
            r1 = 7
            r0.f575b = r1
            r0.D = r5
            r0.D = r4
            b.m.h r2 = r0.O
            b.m.d$a r4 = b.m.d.a.ON_RESUME
            r2.d(r4)
            android.view.View r2 = r0.F
            if (r2 == 0) goto Lb5
            b.k.b.w0 r2 = r0.P
            r2.e(r4)
        Lb5:
            b.k.b.c0 r0 = r0.u
            r0.B = r5
            r0.C = r5
            b.k.b.f0 r2 = r0.J
            r2.g = r5
            r0.w(r1)
            b.k.b.b0 r0 = r8.a
            b.k.b.m r1 = r8.f559c
            r0.i(r1, r5)
            b.k.b.m r0 = r8.f559c
            r0.f576c = r3
            r0.d = r3
            r0.e = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.i0.n():void");
    }

    public void o() {
        if (this.f559c.F == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f559c.F.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f559c.d = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f559c.P.d.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f559c.e = bundle;
    }

    public void p() {
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("moveto STARTED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        mVar.u.T();
        mVar.u.C(true);
        mVar.f575b = 5;
        mVar.D = false;
        mVar.a0();
        if (mVar.D) {
            b.m.h hVar = mVar.O;
            d.a aVar = d.a.ON_START;
            hVar.d(aVar);
            if (mVar.F != null) {
                mVar.P.e(aVar);
            }
            c0 c0Var = mVar.u;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.g = false;
            c0Var.w(5);
            this.a.k(this.f559c, false);
            return;
        }
        throw new a1(c.a.a.a.a.c("Fragment ", mVar, " did not call through to super.onStart()"));
    }

    public void q() {
        if (c0.M(3)) {
            StringBuilder g = c.a.a.a.a.g("movefrom STARTED: ");
            g.append(this.f559c);
            Log.d("FragmentManager", g.toString());
        }
        m mVar = this.f559c;
        c0 c0Var = mVar.u;
        c0Var.C = true;
        c0Var.J.g = true;
        c0Var.w(4);
        if (mVar.F != null) {
            mVar.P.e(d.a.ON_STOP);
        }
        mVar.O.d(d.a.ON_STOP);
        mVar.f575b = 4;
        mVar.D = false;
        mVar.b0();
        if (mVar.D) {
            this.a.l(this.f559c, false);
            return;
        }
        throw new a1(c.a.a.a.a.c("Fragment ", mVar, " did not call through to super.onStop()"));
    }
}
