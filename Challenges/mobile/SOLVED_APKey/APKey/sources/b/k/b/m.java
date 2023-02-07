package b.k.b;

import android.animation.Animator;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import b.k.b.c0;
import b.m.d;
import b.n.a.b;
import com.example.apkey.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class m implements ComponentCallbacks, View.OnCreateContextMenuListener, b.m.g, b.m.u, b.p.c {
    public static final Object T = new Object();
    public boolean A;
    public boolean B;
    public boolean D;
    public ViewGroup E;
    public View F;
    public boolean G;
    public b I;
    public boolean J;
    public float K;
    public LayoutInflater L;
    public boolean M;
    public b.m.h O;
    public w0 P;
    public b.p.b R;
    public final ArrayList<d> S;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f576c;
    public SparseArray<Parcelable> d;
    public Bundle e;
    public Bundle g;
    public m h;
    public int j;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public c0 s;
    public z<?> t;
    public m v;
    public int w;
    public int x;
    public String y;
    public boolean z;

    /* renamed from: b  reason: collision with root package name */
    public int f575b = -1;
    public String f = UUID.randomUUID().toString();
    public String i = null;
    public Boolean k = null;
    public c0 u = new d0();
    public boolean C = true;
    public boolean H = true;
    public d.b N = d.b.RESUMED;
    public b.m.l<b.m.g> Q = new b.m.l<>();

    /* loaded from: classes.dex */
    public class a extends v {
        public a() {
        }

        @Override // b.k.b.v
        public View g(int i) {
            View view = m.this.F;
            if (view != null) {
                return view.findViewById(i);
            }
            StringBuilder g = c.a.a.a.a.g("Fragment ");
            g.append(m.this);
            g.append(" does not have a view");
            throw new IllegalStateException(g.toString());
        }

        @Override // b.k.b.v
        public boolean h() {
            return m.this.F != null;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public Animator f577b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f578c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public ArrayList<String> i;
        public ArrayList<String> j;
        public Object k;
        public Object l;
        public Object m;
        public float n;
        public View o;
        public e p;
        public boolean q;

        public b() {
            Object obj = m.T;
            this.k = obj;
            this.l = obj;
            this.m = obj;
            this.n = 1.0f;
            this.o = null;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends RuntimeException {
        public c(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract void a();
    }

    /* loaded from: classes.dex */
    public interface e {
    }

    public m() {
        new AtomicInteger();
        this.S = new ArrayList<>();
        this.O = new b.m.h(this);
        this.R = new b.p.b(this);
    }

    public Object A() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Object obj = bVar.m;
        if (obj != T) {
            return obj;
        }
        z();
        return null;
    }

    public final String B(int i) {
        return x().getString(i);
    }

    public final boolean C() {
        return this.r > 0;
    }

    public boolean D() {
        b bVar = this.I;
        return false;
    }

    public final boolean E() {
        m mVar = this.v;
        return mVar != null && (mVar.m || mVar.E());
    }

    @Deprecated
    public void F() {
        this.D = true;
    }

    @Deprecated
    public void G(int i, int i2, Intent intent) {
        if (c0.M(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    @Deprecated
    public void H() {
        this.D = true;
    }

    public void I(Context context) {
        this.D = true;
        z<?> zVar = this.t;
        if ((zVar == null ? null : zVar.f627b) != null) {
            this.D = false;
            H();
        }
    }

    @Deprecated
    public void J() {
    }

    public boolean K() {
        return false;
    }

    public void L(Bundle bundle) {
        Parcelable parcelable;
        boolean z = true;
        this.D = true;
        if (bundle != null && (parcelable = bundle.getParcelable("android:support:fragments")) != null) {
            this.u.Y(parcelable);
            this.u.m();
        }
        c0 c0Var = this.u;
        if (c0Var.p < 1) {
            z = false;
        }
        if (!z) {
            c0Var.m();
        }
    }

    public Animation M() {
        return null;
    }

    public Animator N() {
        return null;
    }

    public View O(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void P() {
        this.D = true;
    }

    public void Q() {
        this.D = true;
    }

    public LayoutInflater R(Bundle bundle) {
        return q();
    }

    public void S() {
    }

    @Deprecated
    public void T() {
        this.D = true;
    }

    public void U(AttributeSet attributeSet, Bundle bundle) {
        this.D = true;
        z<?> zVar = this.t;
        if ((zVar == null ? null : zVar.f627b) != null) {
            this.D = false;
            T();
        }
    }

    public void V() {
    }

    public void W() {
    }

    public void X() {
    }

    @Deprecated
    public void Y() {
    }

    public void Z(Bundle bundle) {
    }

    @Override // b.m.g
    public b.m.d a() {
        return this.O;
    }

    public void a0() {
        this.D = true;
    }

    public void b0() {
        this.D = true;
    }

    @Override // b.p.c
    public final b.p.a c() {
        return this.R.f698b;
    }

    public void c0() {
    }

    @Override // b.m.u
    public b.m.t d() {
        if (this.s != null) {
            if (r() != 1) {
                f0 f0Var = this.s.J;
                b.m.t tVar = f0Var.d.get(this.f);
                if (tVar != null) {
                    return tVar;
                }
                b.m.t tVar2 = new b.m.t();
                f0Var.d.put(this.f, tVar2);
                return tVar2;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public void d0(Bundle bundle) {
        this.D = true;
    }

    public v e() {
        return new a();
    }

    public void e0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.u.T();
        boolean z = true;
        this.q = true;
        this.P = new w0(this, d());
        View O = O(layoutInflater, viewGroup, bundle);
        this.F = O;
        if (O != null) {
            this.P.f();
            this.F.setTag(R.id.view_tree_lifecycle_owner, this.P);
            this.F.setTag(R.id.view_tree_view_model_store_owner, this.P);
            this.F.setTag(R.id.view_tree_saved_state_registry_owner, this.P);
            this.Q.g(this.P);
            return;
        }
        if (this.P.f612c == null) {
            z = false;
        }
        if (z) {
            throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
        }
        this.P = null;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.w));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.x));
        printWriter.print(" mTag=");
        printWriter.println(this.y);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f575b);
        printWriter.print(" mWho=");
        printWriter.print(this.f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.z);
        printWriter.print(" mDetached=");
        printWriter.print(this.A);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.C);
        printWriter.print(" mHasMenu=");
        printWriter.println(false);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.B);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.H);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.s);
        }
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.t);
        }
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.v);
        }
        if (this.g != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.g);
        }
        if (this.f576c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f576c);
        }
        if (this.d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.d);
        }
        if (this.e != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.e);
        }
        m mVar = this.h;
        if (mVar == null) {
            c0 c0Var = this.s;
            mVar = (c0Var == null || (str2 = this.i) == null) ? null : c0Var.f530c.d(str2);
        }
        if (mVar != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(mVar);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.j);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(t());
        if (k() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(k());
        }
        if (n() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(n());
        }
        if (u() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(u());
        }
        if (v() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(v());
        }
        if (this.E != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.E);
        }
        if (this.F != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.F);
        }
        if (h() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(h());
        }
        if (j() != null) {
            b.n.a.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.u + ":");
        this.u.y(c.a.a.a.a.d(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public void f0() {
        this.u.w(1);
        if (this.F != null) {
            w0 w0Var = this.P;
            w0Var.f();
            if (w0Var.f612c.f639b.compareTo(d.b.CREATED) >= 0) {
                this.P.e(d.a.ON_DESTROY);
            }
        }
        this.f575b = 1;
        this.D = false;
        P();
        if (this.D) {
            b.C0027b c0027b = ((b.n.a.b) b.n.a.a.b(this)).f643b;
            int g = c0027b.f645b.g();
            for (int i = 0; i < g; i++) {
                c0027b.f645b.h(i).getClass();
            }
            this.q = false;
            return;
        }
        throw new a1(c.a.a.a.a.c("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public final b g() {
        if (this.I == null) {
            this.I = new b();
        }
        return this.I;
    }

    public void g0() {
        onLowMemory();
        this.u.p();
    }

    public View h() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        return bVar.a;
    }

    public boolean h0(Menu menu) {
        if (!this.z) {
            return false | this.u.v(menu);
        }
        return false;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final c0 i() {
        if (this.t != null) {
            return this.u;
        }
        throw new IllegalStateException(c.a.a.a.a.c("Fragment ", this, " has not been attached yet."));
    }

    public final Context i0() {
        Context j = j();
        if (j != null) {
            return j;
        }
        throw new IllegalStateException(c.a.a.a.a.c("Fragment ", this, " not attached to a context."));
    }

    public Context j() {
        z<?> zVar = this.t;
        if (zVar == null) {
            return null;
        }
        return zVar.f628c;
    }

    public final View j0() {
        View view = this.F;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(c.a.a.a.a.c("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public int k() {
        b bVar = this.I;
        if (bVar == null) {
            return 0;
        }
        return bVar.d;
    }

    public void k0(View view) {
        g().a = view;
    }

    public Object l() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        bVar.getClass();
        return null;
    }

    public void l0(int i, int i2, int i3, int i4) {
        if (this.I == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        g().d = i;
        g().e = i2;
        g().f = i3;
        g().g = i4;
    }

    public void m() {
        b bVar = this.I;
        if (bVar == null) {
            return;
        }
        bVar.getClass();
    }

    public void m0(Animator animator) {
        g().f577b = animator;
    }

    public int n() {
        b bVar = this.I;
        if (bVar == null) {
            return 0;
        }
        return bVar.e;
    }

    public void n0(Bundle bundle) {
        c0 c0Var = this.s;
        if (c0Var != null) {
            if (c0Var == null ? false : c0Var.Q()) {
                throw new IllegalStateException("Fragment already added and state has been saved");
            }
        }
        this.g = bundle;
    }

    public Object o() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        bVar.getClass();
        return null;
    }

    public void o0(View view) {
        g().o = null;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.D = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        z<?> zVar = this.t;
        p pVar = zVar == null ? null : (p) zVar.f627b;
        if (pVar != null) {
            pVar.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException(c.a.a.a.a.c("Fragment ", this, " not attached to an activity."));
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.D = true;
    }

    public void p() {
        b bVar = this.I;
        if (bVar == null) {
            return;
        }
        bVar.getClass();
    }

    public void p0(boolean z) {
        g().q = z;
    }

    @Deprecated
    public LayoutInflater q() {
        z<?> zVar = this.t;
        if (zVar != null) {
            LayoutInflater j = zVar.j();
            b.h.b.a.T(j, this.u.f);
            return j;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    public void q0(e eVar) {
        g();
        e eVar2 = this.I.p;
        if (eVar == eVar2) {
            return;
        }
        if (eVar != null && eVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        } else if (eVar == null) {
        } else {
            ((c0.n) eVar).f540c++;
        }
    }

    public final int r() {
        d.b bVar = this.N;
        return (bVar == d.b.INITIALIZED || this.v == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.v.r());
    }

    public void r0(boolean z) {
        if (this.I == null) {
            return;
        }
        g().f578c = z;
    }

    public final c0 s() {
        c0 c0Var = this.s;
        if (c0Var != null) {
            return c0Var;
        }
        throw new IllegalStateException(c.a.a.a.a.c("Fragment ", this, " not associated with a fragment manager."));
    }

    public void s0() {
        if (this.I != null) {
            g().getClass();
        }
    }

    public boolean t() {
        b bVar = this.I;
        if (bVar == null) {
            return false;
        }
        return bVar.f578c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f);
        if (this.w != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.w));
        }
        if (this.y != null) {
            sb.append(" tag=");
            sb.append(this.y);
        }
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        b bVar = this.I;
        if (bVar == null) {
            return 0;
        }
        return bVar.f;
    }

    public int v() {
        b bVar = this.I;
        if (bVar == null) {
            return 0;
        }
        return bVar.g;
    }

    public Object w() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Object obj = bVar.l;
        if (obj != T) {
            return obj;
        }
        o();
        return null;
    }

    public final Resources x() {
        return i0().getResources();
    }

    public Object y() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        Object obj = bVar.k;
        if (obj != T) {
            return obj;
        }
        l();
        return null;
    }

    public Object z() {
        b bVar = this.I;
        if (bVar == null) {
            return null;
        }
        bVar.getClass();
        return null;
    }
}
