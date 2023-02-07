package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import b.h.j.c0.b;
import b.o.b.a;
import b.o.b.a0;
import b.o.b.b;
import b.o.b.b0;
import b.o.b.k;
import b.o.b.m;
import b.o.b.x;
import com.example.apkey.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements b.h.j.f {
    public static final Class<?>[] A0;
    public static final Interpolator B0;
    public static final int[] w0 = {16843830};
    public static final boolean x0;
    public static final boolean y0;
    public static final boolean z0;
    public final AccessibilityManager A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public h F;
    public EdgeEffect G;
    public EdgeEffect H;
    public EdgeEffect I;
    public EdgeEffect J;
    public i K;
    public int L;
    public int M;
    public VelocityTracker N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public n T;
    public final int U;
    public final int V;
    public float W;
    public float a0;

    /* renamed from: b  reason: collision with root package name */
    public final t f85b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public final r f86c;
    public final y c0;
    public u d;
    public b.o.b.m d0;
    public b.o.b.a e;
    public m.b e0;
    public b.o.b.b f;
    public final w f0;
    public final b0 g;
    public p g0;
    public boolean h;
    public List<p> h0;
    public final Rect i;
    public boolean i0;
    public final Rect j;
    public boolean j0;
    public final RectF k;
    public i.b k0;
    public d l;
    public boolean l0;
    public l m;
    public b.o.b.x m0;
    public s n;
    public g n0;
    public final ArrayList<k> o;
    public final int[] o0;
    public final ArrayList<o> p;
    public b.h.j.g p0;
    public o q;
    public final int[] q0;
    public boolean r;
    public final int[] r0;
    public boolean s;
    public final int[] s0;
    public boolean t;
    public final List<z> t0;
    public boolean u;
    public Runnable u0;
    public int v;
    public final b0.b v0;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar = RecyclerView.this.K;
            if (iVar != null) {
                b.o.b.k kVar = (b.o.b.k) iVar;
                boolean z = !kVar.h.isEmpty();
                boolean z2 = !kVar.j.isEmpty();
                boolean z3 = !kVar.k.isEmpty();
                boolean z4 = !kVar.i.isEmpty();
                if (z || z2 || z4 || z3) {
                    Iterator<z> it = kVar.h.iterator();
                    while (it.hasNext()) {
                        z next = it.next();
                        View view = next.a;
                        ViewPropertyAnimator animate = view.animate();
                        kVar.q.add(next);
                        animate.setDuration(kVar.d).alpha(0.0f).setListener(new b.o.b.f(kVar, next, animate, view)).start();
                    }
                    kVar.h.clear();
                    if (z2) {
                        ArrayList<k.b> arrayList = new ArrayList<>();
                        arrayList.addAll(kVar.j);
                        kVar.m.add(arrayList);
                        kVar.j.clear();
                        b.o.b.c cVar = new b.o.b.c(kVar, arrayList);
                        if (z) {
                            View view2 = arrayList.get(0).a.a;
                            long j = kVar.d;
                            AtomicInteger atomicInteger = b.h.j.q.a;
                            view2.postOnAnimationDelayed(cVar, j);
                        } else {
                            cVar.run();
                        }
                    }
                    if (z3) {
                        ArrayList<k.a> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(kVar.k);
                        kVar.n.add(arrayList2);
                        kVar.k.clear();
                        b.o.b.d dVar = new b.o.b.d(kVar, arrayList2);
                        if (z) {
                            View view3 = arrayList2.get(0).a.a;
                            long j2 = kVar.d;
                            AtomicInteger atomicInteger2 = b.h.j.q.a;
                            view3.postOnAnimationDelayed(dVar, j2);
                        } else {
                            dVar.run();
                        }
                    }
                    if (z4) {
                        ArrayList<z> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(kVar.i);
                        kVar.l.add(arrayList3);
                        kVar.i.clear();
                        b.o.b.e eVar = new b.o.b.e(kVar, arrayList3);
                        if (z || z2 || z3) {
                            long j3 = 0;
                            long j4 = z ? kVar.d : 0L;
                            long j5 = z2 ? kVar.e : 0L;
                            if (z3) {
                                j3 = kVar.f;
                            }
                            View view4 = arrayList3.get(0).a;
                            AtomicInteger atomicInteger3 = b.h.j.q.a;
                            view4.postOnAnimationDelayed(eVar, Math.max(j5, j3) + j4);
                        } else {
                            eVar.run();
                        }
                    }
                }
            }
            RecyclerView.this.l0 = false;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class c implements b0.b {
        public c() {
        }

        public void a(z zVar, i.c cVar, i.c cVar2) {
            boolean z;
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.getClass();
            zVar.s(false);
            b.o.b.y yVar = (b.o.b.y) recyclerView.K;
            yVar.getClass();
            if (cVar == null || ((i = cVar.a) == (i2 = cVar2.a) && cVar.f91b == cVar2.f91b)) {
                b.o.b.k kVar = (b.o.b.k) yVar;
                kVar.n(zVar);
                zVar.a.setAlpha(0.0f);
                kVar.i.add(zVar);
                z = true;
            } else {
                z = yVar.i(zVar, i, cVar.f91b, i2, cVar2.f91b);
            }
            if (z) {
                recyclerView.Y();
            }
        }

        public void b(z zVar, i.c cVar, i.c cVar2) {
            boolean z;
            RecyclerView.this.f86c.l(zVar);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.e(zVar);
            zVar.s(false);
            b.o.b.y yVar = (b.o.b.y) recyclerView.K;
            yVar.getClass();
            int i = cVar.a;
            int i2 = cVar.f91b;
            View view = zVar.a;
            int left = cVar2 == null ? view.getLeft() : cVar2.a;
            int top = cVar2 == null ? view.getTop() : cVar2.f91b;
            if (zVar.l() || (i == left && i2 == top)) {
                b.o.b.k kVar = (b.o.b.k) yVar;
                kVar.n(zVar);
                kVar.h.add(zVar);
                z = true;
            } else {
                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                z = yVar.i(zVar, i, i2, left, top);
            }
            if (z) {
                recyclerView.Y();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d<VH extends z> {
        public final e a = new e();

        /* renamed from: b  reason: collision with root package name */
        public boolean f88b = false;

        public abstract int a();

        public long b(int i) {
            return -1L;
        }

        public abstract void c(VH vh, int i);

        public abstract VH d(ViewGroup viewGroup, int i);
    }

    /* loaded from: classes.dex */
    public static class e extends Observable<f> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public void a() {
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class h {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public b a = null;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f89b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public long f90c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* loaded from: classes.dex */
        public interface b {
        }

        /* loaded from: classes.dex */
        public static class c {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f91b;
        }

        public static int b(z zVar) {
            int i = zVar.j & 14;
            if (zVar.j()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int i2 = zVar.d;
            RecyclerView recyclerView = zVar.r;
            int G = recyclerView == null ? -1 : recyclerView.G(zVar);
            return (i2 == -1 || G == -1 || i2 == G) ? i : i | 2048;
        }

        public abstract boolean a(z zVar, z zVar2, c cVar, c cVar2);

        public final void c(z zVar) {
            b bVar = this.a;
            if (bVar != null) {
                j jVar = (j) bVar;
                jVar.getClass();
                boolean z = true;
                zVar.s(true);
                if (zVar.h != null && zVar.i == null) {
                    zVar.h = null;
                }
                zVar.i = null;
                if ((zVar.j & 16) != 0) {
                    return;
                }
                RecyclerView recyclerView = RecyclerView.this;
                View view = zVar.a;
                recyclerView.k0();
                b.o.b.b bVar2 = recyclerView.f;
                int indexOfChild = ((b.o.b.v) bVar2.a).a.indexOfChild(view);
                if (indexOfChild == -1) {
                    bVar2.l(view);
                } else if (bVar2.f653b.d(indexOfChild)) {
                    bVar2.f653b.f(indexOfChild);
                    bVar2.l(view);
                    ((b.o.b.v) bVar2.a).c(indexOfChild);
                } else {
                    z = false;
                }
                if (z) {
                    z J = RecyclerView.J(view);
                    recyclerView.f86c.l(J);
                    recyclerView.f86c.i(J);
                }
                recyclerView.m0(!z);
                if (z || !zVar.n()) {
                    return;
                }
                RecyclerView.this.removeDetachedView(zVar.a, false);
            }
        }

        public final void d() {
            int size = this.f89b.size();
            for (int i = 0; i < size; i++) {
                this.f89b.get(i).a();
            }
            this.f89b.clear();
        }

        public abstract void e(z zVar);

        public abstract void f();

        public abstract boolean g();

        public c h(z zVar) {
            c cVar = new c();
            View view = zVar.a;
            cVar.a = view.getLeft();
            cVar.f91b = view.getTop();
            view.getRight();
            view.getBottom();
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public class j implements i.b {
        public j() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        public void d(Canvas canvas, RecyclerView recyclerView, w wVar) {
        }

        public void e(Canvas canvas, RecyclerView recyclerView, w wVar) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class l {
        public b.o.b.b a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f92b;

        /* renamed from: c  reason: collision with root package name */
        public final a0.b f93c;
        public final a0.b d;
        public a0 e;
        public a0 f;
        public v g;
        public boolean h;
        public boolean i;
        public boolean j;
        public boolean k;
        public int l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;

        /* loaded from: classes.dex */
        public class a implements a0.b {
            public a() {
            }

            @Override // b.o.b.a0.b
            public int a() {
                l lVar = l.this;
                return lVar.p - lVar.P();
            }

            @Override // b.o.b.a0.b
            public int b() {
                return l.this.O();
            }

            @Override // b.o.b.a0.b
            public int c(View view) {
                return l.this.G(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).rightMargin;
            }

            @Override // b.o.b.a0.b
            public int d(View view) {
                return l.this.D(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).leftMargin;
            }

            @Override // b.o.b.a0.b
            public View e(int i) {
                return l.this.x(i);
            }
        }

        /* loaded from: classes.dex */
        public class b implements a0.b {
            public b() {
            }

            @Override // b.o.b.a0.b
            public int a() {
                l lVar = l.this;
                return lVar.q - lVar.N();
            }

            @Override // b.o.b.a0.b
            public int b() {
                return l.this.Q();
            }

            @Override // b.o.b.a0.b
            public int c(View view) {
                return l.this.B(view) + ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).bottomMargin;
            }

            @Override // b.o.b.a0.b
            public int d(View view) {
                return l.this.H(view) - ((ViewGroup.MarginLayoutParams) ((m) view.getLayoutParams())).topMargin;
            }

            @Override // b.o.b.a0.b
            public View e(int i) {
                return l.this.x(i);
            }
        }

        /* loaded from: classes.dex */
        public interface c {
        }

        /* loaded from: classes.dex */
        public static class d {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f94b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f95c;
            public boolean d;
        }

        public l() {
            a aVar = new a();
            this.f93c = aVar;
            b bVar = new b();
            this.d = bVar;
            this.e = new a0(aVar);
            this.f = new a0(bVar);
            this.h = false;
            this.i = false;
            this.j = true;
            this.k = true;
        }

        public static d S(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.o.a.a, i, i2);
            dVar.a = obtainStyledAttributes.getInt(0, 1);
            dVar.f94b = obtainStyledAttributes.getInt(10, 1);
            dVar.f95c = obtainStyledAttributes.getBoolean(9, false);
            dVar.d = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean Y(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode == 0) {
                    return true;
                } else {
                    return mode == 1073741824 && size == i;
                }
            }
            return false;
        }

        public static int h(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int z(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L21
                goto L2f
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L31
            L23:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L2a
                goto L2c
            L2a:
                r5 = 0
                goto L21
            L2c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2f:
                r5 = 0
                r7 = 0
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.l.z(int, int, int, int, boolean):int");
        }

        public int A(r rVar, w wVar) {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView == null || recyclerView.l == null || !e()) {
                return 1;
            }
            return this.f92b.l.a();
        }

        public Parcelable A0() {
            return null;
        }

        public int B(View view) {
            return view.getBottom() + ((m) view.getLayoutParams()).f96b.bottom;
        }

        public void B0(int i) {
        }

        public void C(View view, Rect rect) {
            int[] iArr = RecyclerView.w0;
            m mVar = (m) view.getLayoutParams();
            Rect rect2 = mVar.f96b;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) mVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) mVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) mVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public boolean C0(int i) {
            int Q;
            int O;
            int i2;
            int i3;
            RecyclerView recyclerView = this.f92b;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                Q = recyclerView.canScrollVertically(1) ? (this.q - Q()) - N() : 0;
                if (this.f92b.canScrollHorizontally(1)) {
                    O = (this.p - O()) - P();
                    i3 = O;
                    i2 = Q;
                }
                i2 = Q;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                Q = recyclerView.canScrollVertically(-1) ? -((this.q - Q()) - N()) : 0;
                if (this.f92b.canScrollHorizontally(-1)) {
                    O = -((this.p - O()) - P());
                    i3 = O;
                    i2 = Q;
                }
                i2 = Q;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.f92b.j0(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public int D(View view) {
            return view.getLeft() - ((m) view.getLayoutParams()).f96b.left;
        }

        public boolean D0() {
            return false;
        }

        public int E(View view) {
            Rect rect = ((m) view.getLayoutParams()).f96b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void E0(r rVar) {
            for (int y = y() - 1; y >= 0; y--) {
                if (!RecyclerView.J(x(y)).t()) {
                    H0(y, rVar);
                }
            }
        }

        public int F(View view) {
            Rect rect = ((m) view.getLayoutParams()).f96b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void F0(r rVar) {
            int size = rVar.a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = rVar.a.get(i).a;
                z J = RecyclerView.J(view);
                if (!J.t()) {
                    J.s(false);
                    if (J.n()) {
                        this.f92b.removeDetachedView(view, false);
                    }
                    i iVar = this.f92b.K;
                    if (iVar != null) {
                        iVar.e(J);
                    }
                    J.s(true);
                    z J2 = RecyclerView.J(view);
                    J2.n = null;
                    J2.o = false;
                    J2.d();
                    rVar.i(J2);
                }
            }
            rVar.a.clear();
            ArrayList<z> arrayList = rVar.f101b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.f92b.invalidate();
            }
        }

        public int G(View view) {
            return view.getRight() + ((m) view.getLayoutParams()).f96b.right;
        }

        public void G0(View view, r rVar) {
            b.o.b.b bVar = this.a;
            int indexOfChild = ((b.o.b.v) bVar.a).a.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (bVar.f653b.f(indexOfChild)) {
                    bVar.l(view);
                }
                ((b.o.b.v) bVar.a).c(indexOfChild);
            }
            rVar.h(view);
        }

        public int H(View view) {
            return view.getTop() - ((m) view.getLayoutParams()).f96b.top;
        }

        public void H0(int i, r rVar) {
            View x = x(i);
            I0(i);
            rVar.h(x);
        }

        public View I() {
            View focusedChild;
            RecyclerView recyclerView = this.f92b;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.a.f654c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void I0(int i) {
            b.o.b.b bVar;
            int f;
            View a2;
            if (x(i) == null || (a2 = ((b.o.b.v) bVar.a).a((f = (bVar = this.a).f(i)))) == null) {
                return;
            }
            if (bVar.f653b.f(f)) {
                bVar.l(a2);
            }
            ((b.o.b.v) bVar.a).c(f);
        }

        public int J() {
            RecyclerView recyclerView = this.f92b;
            d adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.a();
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00b8, code lost:
            if (r1 == false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean J0(androidx.recyclerview.widget.RecyclerView r19, android.view.View r20, android.graphics.Rect r21, boolean r22, boolean r23) {
            /*
                r18 = this;
                r0 = r18
                r1 = r21
                r2 = 2
                int[] r2 = new int[r2]
                int r3 = r18.O()
                int r4 = r18.Q()
                int r5 = r0.p
                int r6 = r18.P()
                int r5 = r5 - r6
                int r6 = r0.q
                int r7 = r18.N()
                int r6 = r6 - r7
                int r7 = r20.getLeft()
                int r8 = r1.left
                int r7 = r7 + r8
                int r8 = r20.getScrollX()
                int r7 = r7 - r8
                int r8 = r20.getTop()
                int r9 = r1.top
                int r8 = r8 + r9
                int r9 = r20.getScrollY()
                int r8 = r8 - r9
                int r9 = r21.width()
                int r9 = r9 + r7
                int r1 = r21.height()
                int r1 = r1 + r8
                int r7 = r7 - r3
                r3 = 0
                int r10 = java.lang.Math.min(r3, r7)
                int r8 = r8 - r4
                int r4 = java.lang.Math.min(r3, r8)
                int r9 = r9 - r5
                int r5 = java.lang.Math.max(r3, r9)
                int r1 = r1 - r6
                int r1 = java.lang.Math.max(r3, r1)
                int r6 = r18.K()
                r11 = 1
                if (r6 != r11) goto L63
                if (r5 == 0) goto L5e
                goto L6b
            L5e:
                int r5 = java.lang.Math.max(r10, r9)
                goto L6b
            L63:
                if (r10 == 0) goto L66
                goto L6a
            L66:
                int r10 = java.lang.Math.min(r7, r5)
            L6a:
                r5 = r10
            L6b:
                if (r4 == 0) goto L6e
                goto L72
            L6e:
                int r4 = java.lang.Math.min(r8, r1)
            L72:
                r2[r3] = r5
                r2[r11] = r4
                r13 = r2[r3]
                r14 = r2[r11]
                if (r23 == 0) goto Lba
                android.view.View r1 = r19.getFocusedChild()
                if (r1 != 0) goto L83
                goto Lb7
            L83:
                int r2 = r18.O()
                int r4 = r18.Q()
                int r5 = r0.p
                int r6 = r18.P()
                int r5 = r5 - r6
                int r6 = r0.q
                int r7 = r18.N()
                int r6 = r6 - r7
                androidx.recyclerview.widget.RecyclerView r7 = r0.f92b
                android.graphics.Rect r7 = r7.i
                r0.C(r1, r7)
                int r1 = r7.left
                int r1 = r1 - r13
                if (r1 >= r5) goto Lb7
                int r1 = r7.right
                int r1 = r1 - r13
                if (r1 <= r2) goto Lb7
                int r1 = r7.top
                int r1 = r1 - r14
                if (r1 >= r6) goto Lb7
                int r1 = r7.bottom
                int r1 = r1 - r14
                if (r1 > r4) goto Lb5
                goto Lb7
            Lb5:
                r1 = 1
                goto Lb8
            Lb7:
                r1 = 0
            Lb8:
                if (r1 == 0) goto Lbf
            Lba:
                if (r13 != 0) goto Lc0
                if (r14 == 0) goto Lbf
                goto Lc0
            Lbf:
                return r3
            Lc0:
                if (r22 == 0) goto Lc8
                r1 = r19
                r1.scrollBy(r13, r14)
                goto Ld4
            Lc8:
                r1 = r19
                r17 = 0
                r16 = -2147483648(0xffffffff80000000, float:-0.0)
                r15 = 0
                r12 = r19
                r12.j0(r13, r14, r15, r16, r17)
            Ld4:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.l.J0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public int K() {
            return b.h.j.q.o(this.f92b);
        }

        public void K0() {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int L() {
            RecyclerView recyclerView = this.f92b;
            AtomicInteger atomicInteger = b.h.j.q.a;
            return recyclerView.getMinimumHeight();
        }

        public int L0(int i, r rVar, w wVar) {
            return 0;
        }

        public int M() {
            RecyclerView recyclerView = this.f92b;
            AtomicInteger atomicInteger = b.h.j.q.a;
            return recyclerView.getMinimumWidth();
        }

        public void M0(int i) {
        }

        public int N() {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int N0(int i, r rVar, w wVar) {
            return 0;
        }

        public int O() {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public void O0(RecyclerView recyclerView) {
            P0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public int P() {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public void P0(int i, int i2) {
            this.p = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.n = mode;
            if (mode == 0 && !RecyclerView.y0) {
                this.p = 0;
            }
            this.q = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.o = mode2;
            if (mode2 != 0 || RecyclerView.y0) {
                return;
            }
            this.q = 0;
        }

        public int Q() {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public void Q0(Rect rect, int i, int i2) {
            int P = P() + O() + rect.width();
            int N = N() + Q() + rect.height();
            this.f92b.setMeasuredDimension(h(i, P, M()), h(i2, N, L()));
        }

        public int R(View view) {
            return ((m) view.getLayoutParams()).a();
        }

        public void R0(int i, int i2) {
            int y = y();
            if (y == 0) {
                this.f92b.n(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < y; i7++) {
                View x = x(i7);
                Rect rect = this.f92b.i;
                C(x, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.f92b.i.set(i5, i6, i3, i4);
            Q0(this.f92b.i, i, i2);
        }

        public void S0(RecyclerView recyclerView) {
            int height;
            if (recyclerView == null) {
                this.f92b = null;
                this.a = null;
                height = 0;
                this.p = 0;
            } else {
                this.f92b = recyclerView;
                this.a = recyclerView.f;
                this.p = recyclerView.getWidth();
                height = recyclerView.getHeight();
            }
            this.q = height;
            this.n = 1073741824;
            this.o = 1073741824;
        }

        public int T(r rVar, w wVar) {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView == null || recyclerView.l == null || !f()) {
                return 1;
            }
            return this.f92b.l.a();
        }

        public boolean T0(View view, int i, int i2, m mVar) {
            return view.isLayoutRequested() || !this.j || !Y(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) mVar).width) || !Y(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) mVar).height);
        }

        public int U() {
            return 0;
        }

        public boolean U0() {
            return false;
        }

        public void V(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((m) view.getLayoutParams()).f96b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.f92b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.f92b.k;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean V0(View view, int i, int i2, m mVar) {
            return !this.j || !Y(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) mVar).width) || !Y(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) mVar).height);
        }

        public boolean W() {
            return false;
        }

        public void W0(RecyclerView recyclerView, w wVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public boolean X() {
            return false;
        }

        public void X0(v vVar) {
            v vVar2 = this.g;
            if (vVar2 != null && vVar != vVar2 && vVar2.e) {
                vVar2.d();
            }
            this.g = vVar;
            RecyclerView recyclerView = this.f92b;
            vVar.getClass();
            recyclerView.c0.c();
            if (vVar.h) {
                StringBuilder g = c.a.a.a.a.g("An instance of ");
                g.append(vVar.getClass().getSimpleName());
                g.append(" was started more than once. Each instance of");
                g.append(vVar.getClass().getSimpleName());
                g.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w("RecyclerView", g.toString());
            }
            vVar.f103b = recyclerView;
            vVar.f104c = this;
            int i = vVar.a;
            if (i != -1) {
                recyclerView.f0.a = i;
                vVar.e = true;
                vVar.d = true;
                vVar.f = recyclerView.m.t(i);
                vVar.f103b.c0.a();
                vVar.h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public boolean Y0() {
            return false;
        }

        public boolean Z(View view, boolean z) {
            boolean z2 = this.e.b(view, 24579) && this.f.b(view, 24579);
            return z ? z2 : !z2;
        }

        public void a0(View view, int i, int i2, int i3, int i4) {
            m mVar = (m) view.getLayoutParams();
            Rect rect = mVar.f96b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) mVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) mVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) mVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) mVar).bottomMargin);
        }

        public void b(View view) {
            c(view, -1, false);
        }

        public void b0(int i) {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                int e = recyclerView.f.e();
                for (int i2 = 0; i2 < e; i2++) {
                    recyclerView.f.d(i2).offsetLeftAndRight(i);
                }
            }
        }

        public final void c(View view, int i, boolean z) {
            z J = RecyclerView.J(view);
            if (z || J.l()) {
                this.f92b.g.a(J);
            } else {
                this.f92b.g.f(J);
            }
            m mVar = (m) view.getLayoutParams();
            if (J.u() || J.m()) {
                if (J.m()) {
                    J.n.l(J);
                } else {
                    J.d();
                }
                this.a.b(view, i, view.getLayoutParams(), false);
            } else {
                int i2 = -1;
                if (view.getParent() == this.f92b) {
                    int j = this.a.j(view);
                    if (i == -1) {
                        i = this.a.e();
                    }
                    if (j == -1) {
                        StringBuilder g = c.a.a.a.a.g("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        g.append(this.f92b.indexOfChild(view));
                        throw new IllegalStateException(c.a.a.a.a.b(this.f92b, g));
                    } else if (j != i) {
                        l lVar = this.f92b.m;
                        View x = lVar.x(j);
                        if (x != null) {
                            lVar.x(j);
                            lVar.r(j);
                            m mVar2 = (m) x.getLayoutParams();
                            z J2 = RecyclerView.J(x);
                            if (J2.l()) {
                                lVar.f92b.g.a(J2);
                            } else {
                                lVar.f92b.g.f(J2);
                            }
                            lVar.a.b(x, i, mVar2, J2.l());
                        } else {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j + lVar.f92b.toString());
                        }
                    }
                } else {
                    this.a.a(view, i, false);
                    mVar.f97c = true;
                    v vVar = this.g;
                    if (vVar != null && vVar.e) {
                        vVar.f103b.getClass();
                        z J3 = RecyclerView.J(view);
                        if (J3 != null) {
                            i2 = J3.e();
                        }
                        if (i2 == vVar.a) {
                            vVar.f = view;
                        }
                    }
                }
            }
            if (mVar.d) {
                J.a.invalidate();
                mVar.d = false;
            }
        }

        public void c0(int i) {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                int e = recyclerView.f.e();
                for (int i2 = 0; i2 < e; i2++) {
                    recyclerView.f.d(i2).offsetTopAndBottom(i);
                }
            }
        }

        public void d(String str) {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView != null) {
                recyclerView.h(str);
            }
        }

        public void d0() {
        }

        public boolean e() {
            return false;
        }

        public boolean e0() {
            return false;
        }

        public boolean f() {
            return false;
        }

        public void f0() {
        }

        public boolean g(m mVar) {
            return mVar != null;
        }

        @Deprecated
        public void g0() {
        }

        public void h0(RecyclerView recyclerView, r rVar) {
            g0();
        }

        public void i(int i, int i2, w wVar, c cVar) {
        }

        public View i0(View view, int i, r rVar, w wVar) {
            return null;
        }

        public void j(int i, c cVar) {
        }

        public void j0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f92b;
            r rVar = recyclerView.f86c;
            w wVar = recyclerView.f0;
            k0(accessibilityEvent);
        }

        public int k(w wVar) {
            return 0;
        }

        public void k0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f92b;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.f92b.canScrollVertically(-1) && !this.f92b.canScrollHorizontally(-1) && !this.f92b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            d dVar = this.f92b.l;
            if (dVar == null) {
                return;
            }
            accessibilityEvent.setItemCount(dVar.a());
        }

        public int l(w wVar) {
            return 0;
        }

        public void l0(View view, b.h.j.c0.b bVar) {
            z J = RecyclerView.J(view);
            if (J == null || J.l() || this.a.k(J.a)) {
                return;
            }
            RecyclerView recyclerView = this.f92b;
            m0(recyclerView.f86c, recyclerView.f0, view, bVar);
        }

        public int m(w wVar) {
            return 0;
        }

        public void m0(r rVar, w wVar, View view, b.h.j.c0.b bVar) {
            bVar.j(b.c.a(f() ? R(view) : 0, 1, e() ? R(view) : 0, 1, false, false));
        }

        public int n(w wVar) {
            return 0;
        }

        public View n0() {
            return null;
        }

        public int o(w wVar) {
            return 0;
        }

        public void o0(RecyclerView recyclerView, int i, int i2) {
        }

        public int p(w wVar) {
            return 0;
        }

        public void p0(RecyclerView recyclerView) {
        }

        public void q(r rVar) {
            int y = y();
            while (true) {
                y--;
                if (y >= 0) {
                    View x = x(y);
                    z J = RecyclerView.J(x);
                    if (!J.t()) {
                        if (J.j() && !J.l() && !this.f92b.l.f88b) {
                            I0(y);
                            rVar.i(J);
                        } else {
                            x(y);
                            r(y);
                            rVar.j(x);
                            this.f92b.g.f(J);
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public void q0(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public final void r(int i) {
            this.a.c(i);
        }

        public void r0(RecyclerView recyclerView, int i, int i2) {
        }

        public View s(View view) {
            View B;
            RecyclerView recyclerView = this.f92b;
            if (recyclerView == null || (B = recyclerView.B(view)) == null || this.a.f654c.contains(B)) {
                return null;
            }
            return B;
        }

        public void s0() {
        }

        public View t(int i) {
            int y = y();
            for (int i2 = 0; i2 < y; i2++) {
                View x = x(i2);
                z J = RecyclerView.J(x);
                if (J != null && J.e() == i && !J.t() && (this.f92b.f0.g || !J.l())) {
                    return x;
                }
            }
            return null;
        }

        public void t0(RecyclerView recyclerView, int i, int i2, Object obj) {
            s0();
        }

        public abstract m u();

        public void u0(r rVar, w wVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public m v(Context context, AttributeSet attributeSet) {
            return new m(context, attributeSet);
        }

        public void v0(w wVar) {
        }

        public m w(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof m ? new m((m) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new m((ViewGroup.MarginLayoutParams) layoutParams) : new m(layoutParams);
        }

        public void w0(int i, int i2) {
            this.f92b.n(i, i2);
        }

        public View x(int i) {
            b.o.b.b bVar = this.a;
            if (bVar != null) {
                return ((b.o.b.v) bVar.a).a(bVar.f(i));
            }
            return null;
        }

        @Deprecated
        public boolean x0(RecyclerView recyclerView) {
            v vVar = this.g;
            return (vVar != null && vVar.e) || recyclerView.N();
        }

        public int y() {
            b.o.b.b bVar = this.a;
            if (bVar != null) {
                return bVar.e();
            }
            return 0;
        }

        public boolean y0(RecyclerView recyclerView, View view, View view2) {
            return x0(recyclerView);
        }

        public void z0(Parcelable parcelable) {
        }
    }

    /* loaded from: classes.dex */
    public static class m extends ViewGroup.MarginLayoutParams {
        public z a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f96b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f97c;
        public boolean d;

        public m(int i, int i2) {
            super(i, i2);
            this.f96b = new Rect();
            this.f97c = true;
            this.d = false;
        }

        public m(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f96b = new Rect();
            this.f97c = true;
            this.d = false;
        }

        public m(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f96b = new Rect();
            this.f97c = true;
            this.d = false;
        }

        public m(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f96b = new Rect();
            this.f97c = true;
            this.d = false;
        }

        public m(m mVar) {
            super((ViewGroup.LayoutParams) mVar);
            this.f96b = new Rect();
            this.f97c = true;
            this.d = false;
        }

        public int a() {
            return this.a.e();
        }

        public boolean b() {
            return this.a.o();
        }

        public boolean c() {
            return this.a.l();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
    }

    /* loaded from: classes.dex */
    public interface o {
        void a(boolean z);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class p {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public static class q {
        public SparseArray<a> a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        public int f98b = 0;

        /* loaded from: classes.dex */
        public static class a {
            public final ArrayList<z> a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            public int f99b = 5;

            /* renamed from: c  reason: collision with root package name */
            public long f100c = 0;
            public long d = 0;
        }

        public final a a(int i) {
            a aVar = this.a.get(i);
            if (aVar == null) {
                a aVar2 = new a();
                this.a.put(i, aVar2);
                return aVar2;
            }
            return aVar;
        }

        public long b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    /* loaded from: classes.dex */
    public final class r {
        public final ArrayList<z> a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<z> f101b;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<z> f102c;
        public final List<z> d;
        public int e;
        public int f;
        public q g;

        public r() {
            ArrayList<z> arrayList = new ArrayList<>();
            this.a = arrayList;
            this.f101b = null;
            this.f102c = new ArrayList<>();
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        public void a(z zVar, boolean z) {
            RecyclerView.j(zVar);
            View view = zVar.a;
            b.o.b.x xVar = RecyclerView.this.m0;
            if (xVar != null) {
                x.a aVar = xVar.e;
                b.h.j.q.F(view, aVar instanceof x.a ? aVar.e.remove(view) : null);
            }
            if (z) {
                s sVar = RecyclerView.this.n;
                if (sVar != null) {
                    sVar.a(zVar);
                }
                RecyclerView recyclerView = RecyclerView.this;
                d dVar = recyclerView.l;
                if (recyclerView.f0 != null) {
                    recyclerView.g.g(zVar);
                }
            }
            zVar.r = null;
            q d = d();
            d.getClass();
            int i = zVar.f;
            ArrayList<z> arrayList = d.a(i).a;
            if (d.a.get(i).f99b <= arrayList.size()) {
                return;
            }
            zVar.q();
            arrayList.add(zVar);
        }

        public void b() {
            this.a.clear();
            f();
        }

        public int c(int i) {
            if (i >= 0 && i < RecyclerView.this.f0.b()) {
                RecyclerView recyclerView = RecyclerView.this;
                return !recyclerView.f0.g ? i : recyclerView.e.f(i, 0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("invalid position ");
            sb.append(i);
            sb.append(". State item count is ");
            sb.append(RecyclerView.this.f0.b());
            throw new IndexOutOfBoundsException(c.a.a.a.a.b(RecyclerView.this, sb));
        }

        public q d() {
            if (this.g == null) {
                this.g = new q();
            }
            return this.g;
        }

        public final void e(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    e((ViewGroup) childAt, true);
                }
            }
            if (!z) {
                return;
            }
            if (viewGroup.getVisibility() == 4) {
                viewGroup.setVisibility(0);
                viewGroup.setVisibility(4);
                return;
            }
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }

        public void f() {
            for (int size = this.f102c.size() - 1; size >= 0; size--) {
                g(size);
            }
            this.f102c.clear();
            if (RecyclerView.z0) {
                m.b bVar = RecyclerView.this.e0;
                int[] iArr = bVar.f686c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.d = 0;
            }
        }

        public void g(int i) {
            a(this.f102c.get(i), true);
            this.f102c.remove(i);
        }

        public void h(View view) {
            z J = RecyclerView.J(view);
            if (J.n()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (J.m()) {
                J.n.l(J);
            } else if (J.u()) {
                J.d();
            }
            i(J);
            if (RecyclerView.this.K == null || J.k()) {
                return;
            }
            RecyclerView.this.K.e(J);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00a2 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:64:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(androidx.recyclerview.widget.RecyclerView.z r6) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.i(androidx.recyclerview.widget.RecyclerView$z):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0043  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void j(android.view.View r5) {
            /*
                r4 = this;
                androidx.recyclerview.widget.RecyclerView$z r5 = androidx.recyclerview.widget.RecyclerView.J(r5)
                r0 = 12
                boolean r0 = r5.g(r0)
                r1 = 0
                if (r0 != 0) goto L55
                boolean r0 = r5.o()
                if (r0 == 0) goto L55
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$i r0 = r0.K
                r2 = 1
                if (r0 == 0) goto L3f
                java.util.List r3 = r5.f()
                b.o.b.k r0 = (b.o.b.k) r0
                boolean r3 = r3.isEmpty()
                if (r3 == 0) goto L39
                boolean r0 = r0.g
                if (r0 == 0) goto L33
                boolean r0 = r5.j()
                if (r0 == 0) goto L31
                goto L33
            L31:
                r0 = 0
                goto L34
            L33:
                r0 = 1
            L34:
                if (r0 == 0) goto L37
                goto L39
            L37:
                r0 = 0
                goto L3a
            L39:
                r0 = 1
            L3a:
                if (r0 == 0) goto L3d
                goto L3f
            L3d:
                r0 = 0
                goto L40
            L3f:
                r0 = 1
            L40:
                if (r0 == 0) goto L43
                goto L55
            L43:
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$z> r0 = r4.f101b
                if (r0 != 0) goto L4e
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r4.f101b = r0
            L4e:
                r5.n = r4
                r5.o = r2
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$z> r0 = r4.f101b
                goto L82
            L55:
                boolean r0 = r5.j()
                if (r0 == 0) goto L7c
                boolean r0 = r5.l()
                if (r0 != 0) goto L7c
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$d r0 = r0.l
                boolean r0 = r0.f88b
                if (r0 == 0) goto L6a
                goto L7c
            L6a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r0 = "Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool."
                java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r0 = c.a.a.a.a.b(r1, r0)
                r5.<init>(r0)
                throw r5
            L7c:
                r5.n = r4
                r5.o = r1
                java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$z> r0 = r4.a
            L82:
                r0.add(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.j(android.view.View):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:106:0x01e6, code lost:
            if (r7.f != 0) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x02fb, code lost:
            r7 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:238:0x0453, code lost:
            if (r7.j() == false) goto L240;
         */
        /* JADX WARN: Code restructure failed: missing block: B:248:0x0487, code lost:
            if ((r10 == 0 || r10 + r8 < r19) == false) goto L240;
         */
        /* JADX WARN: Removed duplicated region for block: B:130:0x0248  */
        /* JADX WARN: Removed duplicated region for block: B:224:0x041b  */
        /* JADX WARN: Removed duplicated region for block: B:232:0x0445  */
        /* JADX WARN: Removed duplicated region for block: B:241:0x0470  */
        /* JADX WARN: Removed duplicated region for block: B:252:0x0499  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x04b4  */
        /* JADX WARN: Removed duplicated region for block: B:258:0x04c7  */
        /* JADX WARN: Removed duplicated region for block: B:266:0x04f7  */
        /* JADX WARN: Removed duplicated region for block: B:281:0x052d  */
        /* JADX WARN: Removed duplicated region for block: B:285:0x0538  */
        /* JADX WARN: Removed duplicated region for block: B:286:0x053f  */
        /* JADX WARN: Removed duplicated region for block: B:293:0x055b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x01bc  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.recyclerview.widget.RecyclerView.z k(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 1428
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r.k(int, boolean, long):androidx.recyclerview.widget.RecyclerView$z");
        }

        public void l(z zVar) {
            (zVar.o ? this.f101b : this.a).remove(zVar);
            zVar.n = null;
            zVar.o = false;
            zVar.d();
        }

        public void m() {
            l lVar = RecyclerView.this.m;
            this.f = this.e + (lVar != null ? lVar.l : 0);
            for (int size = this.f102c.size() - 1; size >= 0 && this.f102c.size() > this.f; size--) {
                g(size);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface s {
        void a(z zVar);
    }

    /* loaded from: classes.dex */
    public class t extends f {
        public t() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f
        public void a() {
            RecyclerView.this.h(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.f0.f = true;
            recyclerView.a0(true);
            if (!RecyclerView.this.e.g()) {
                RecyclerView.this.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class u extends b.j.a.a {
        public static final Parcelable.Creator<u> CREATOR = new a();
        public Parcelable d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<u> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new u(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new u[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public u createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new u(parcel, classLoader);
            }
        }

        public u(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readParcelable(classLoader == null ? l.class.getClassLoader() : classLoader);
        }

        public u(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            parcel.writeParcelable(this.d, 0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class v {

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView f103b;

        /* renamed from: c  reason: collision with root package name */
        public l f104c;
        public boolean d;
        public boolean e;
        public View f;
        public boolean h;
        public int a = -1;
        public final a g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {
            public int a;

            /* renamed from: b  reason: collision with root package name */
            public int f105b;
            public int d = -1;
            public boolean f = false;
            public int g = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f106c = Integer.MIN_VALUE;
            public Interpolator e = null;

            public a(int i, int i2) {
                this.a = i;
                this.f105b = i2;
            }

            public void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.O(i);
                    this.f = false;
                } else if (this.f) {
                    Interpolator interpolator = this.e;
                    if (interpolator != null && this.f106c < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    int i2 = this.f106c;
                    if (i2 >= 1) {
                        recyclerView.c0.b(this.a, this.f105b, i2, interpolator);
                        int i3 = this.g + 1;
                        this.g = i3;
                        if (i3 > 10) {
                            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    this.g = 0;
                }
            }

            public void b(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.f105b = i2;
                this.f106c = i3;
                this.e = interpolator;
                this.f = true;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i);
        }

        public PointF a(int i) {
            l lVar = this.f104c;
            if (lVar instanceof b) {
                return ((b) lVar).a(i);
            }
            StringBuilder g = c.a.a.a.a.g("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            g.append(b.class.getCanonicalName());
            Log.w("RecyclerView", g.toString());
            return null;
        }

        public void b(int i, int i2) {
            PointF a2;
            RecyclerView recyclerView = this.f103b;
            int i3 = -1;
            if (this.a == -1 || recyclerView == null) {
                d();
            }
            if (this.d && this.f == null && this.f104c != null && (a2 = a(this.a)) != null) {
                float f = a2.x;
                if (f != 0.0f || a2.y != 0.0f) {
                    recyclerView.g0((int) Math.signum(f), (int) Math.signum(a2.y), null);
                }
            }
            boolean z = false;
            this.d = false;
            View view = this.f;
            if (view != null) {
                this.f103b.getClass();
                z J = RecyclerView.J(view);
                if (J != null) {
                    i3 = J.e();
                }
                if (i3 == this.a) {
                    c(this.f, recyclerView.f0, this.g);
                    this.g.a(recyclerView);
                    d();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                w wVar = recyclerView.f0;
                a aVar = this.g;
                b.o.b.o oVar = (b.o.b.o) this;
                if (oVar.f103b.m.y() == 0) {
                    oVar.d();
                } else {
                    int i4 = oVar.o;
                    int i5 = i4 - i;
                    if (i4 * i5 <= 0) {
                        i5 = 0;
                    }
                    oVar.o = i5;
                    int i6 = oVar.p;
                    int i7 = i6 - i2;
                    if (i6 * i7 <= 0) {
                        i7 = 0;
                    }
                    oVar.p = i7;
                    if (i5 == 0 && i7 == 0) {
                        PointF a3 = oVar.a(oVar.a);
                        if (a3 != null) {
                            float f2 = a3.x;
                            if (f2 != 0.0f || a3.y != 0.0f) {
                                float f3 = a3.y;
                                float sqrt = (float) Math.sqrt((f3 * f3) + (f2 * f2));
                                float f4 = a3.x / sqrt;
                                a3.x = f4;
                                float f5 = a3.y / sqrt;
                                a3.y = f5;
                                oVar.k = a3;
                                oVar.o = (int) (f4 * 10000.0f);
                                oVar.p = (int) (f5 * 10000.0f);
                                aVar.b((int) (oVar.o * 1.2f), (int) (oVar.p * 1.2f), (int) (oVar.g(10000) * 1.2f), oVar.i);
                            }
                        }
                        aVar.d = oVar.a;
                        oVar.d();
                    }
                }
                a aVar2 = this.g;
                if (aVar2.d >= 0) {
                    z = true;
                }
                aVar2.a(recyclerView);
                if (!z || !this.e) {
                    return;
                }
                this.d = true;
                recyclerView.c0.a();
            }
        }

        public abstract void c(View view, w wVar, a aVar);

        public final void d() {
            if (!this.e) {
                return;
            }
            this.e = false;
            b.o.b.o oVar = (b.o.b.o) this;
            oVar.p = 0;
            oVar.o = 0;
            oVar.k = null;
            this.f103b.f0.a = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            l lVar = this.f104c;
            if (lVar.g == this) {
                lVar.g = null;
            }
            this.f104c = null;
            this.f103b = null;
        }
    }

    /* loaded from: classes.dex */
    public static class w {
        public int a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f107b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f108c = 0;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;

        public void a(int i) {
            if ((this.d & i) != 0) {
                return;
            }
            StringBuilder g = c.a.a.a.a.g("Layout state should be one of ");
            g.append(Integer.toBinaryString(i));
            g.append(" but it is ");
            g.append(Integer.toBinaryString(this.d));
            throw new IllegalStateException(g.toString());
        }

        public int b() {
            return this.g ? this.f107b - this.f108c : this.e;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("State{mTargetPosition=");
            g.append(this.a);
            g.append(", mData=");
            g.append((Object) null);
            g.append(", mItemCount=");
            g.append(this.e);
            g.append(", mIsMeasuring=");
            g.append(this.i);
            g.append(", mPreviousLayoutItemCount=");
            g.append(this.f107b);
            g.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            g.append(this.f108c);
            g.append(", mStructureChanged=");
            g.append(this.f);
            g.append(", mInPreLayout=");
            g.append(this.g);
            g.append(", mRunSimpleAnimations=");
            g.append(this.j);
            g.append(", mRunPredictiveAnimations=");
            g.append(this.k);
            g.append('}');
            return g.toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class x {
    }

    /* loaded from: classes.dex */
    public class y implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f109b;

        /* renamed from: c  reason: collision with root package name */
        public int f110c;
        public OverScroller d;
        public Interpolator e;
        public boolean f;
        public boolean g;

        public y() {
            Interpolator interpolator = RecyclerView.B0;
            this.e = interpolator;
            this.f = false;
            this.g = false;
            this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void a() {
            if (this.f) {
                this.g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            AtomicInteger atomicInteger = b.h.j.q.a;
            recyclerView.postOnAnimation(this);
        }

        public void b(int i, int i2, int i3, Interpolator interpolator) {
            int i4;
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                int sqrt = (int) Math.sqrt(0);
                int sqrt2 = (int) Math.sqrt((i2 * i2) + (i * i));
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i5 = width / 2;
                float f = width;
                float f2 = i5;
                float sin = (((float) Math.sin((Math.min(1.0f, (sqrt2 * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                if (sqrt > 0) {
                    i4 = Math.round(Math.abs(sin / sqrt) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i4 = (int) (((abs / f) + 1.0f) * 300.0f);
                }
                i3 = Math.min(i4, 2000);
            }
            int i6 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.B0;
            }
            if (this.e != interpolator) {
                this.e = interpolator;
                this.d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f110c = 0;
            this.f109b = 0;
            RecyclerView.this.setScrollState(2);
            this.d.startScroll(0, 0, i, i2, i6);
            if (Build.VERSION.SDK_INT < 23) {
                this.d.computeScrollOffset();
            }
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.d.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.m == null) {
                c();
                return;
            }
            this.g = false;
            this.f = true;
            recyclerView.m();
            OverScroller overScroller = this.d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f109b;
                int i4 = currY - this.f110c;
                this.f109b = currX;
                this.f110c = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.s0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.s(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.s0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.l(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.l != null) {
                    int[] iArr3 = recyclerView3.s0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.g0(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.s0;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    v vVar = recyclerView4.m.g;
                    if (vVar != null && !vVar.d && vVar.e) {
                        int b2 = recyclerView4.f0.b();
                        if (b2 == 0) {
                            vVar.d();
                        } else {
                            if (vVar.a >= b2) {
                                vVar.a = b2 - 1;
                            }
                            vVar.b(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.o.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.s0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.t(i2, i, i3, i4, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.s0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    recyclerView6.u(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                RecyclerView recyclerView7 = RecyclerView.this;
                v vVar2 = recyclerView7.m.g;
                if (!(vVar2 != null && vVar2.d) && z) {
                    if (recyclerView7.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView recyclerView8 = RecyclerView.this;
                        recyclerView8.getClass();
                        if (i7 < 0) {
                            recyclerView8.w();
                            if (recyclerView8.G.isFinished()) {
                                recyclerView8.G.onAbsorb(-i7);
                            }
                        } else if (i7 > 0) {
                            recyclerView8.x();
                            if (recyclerView8.I.isFinished()) {
                                recyclerView8.I.onAbsorb(i7);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView8.y();
                            if (recyclerView8.H.isFinished()) {
                                recyclerView8.H.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView8.v();
                            if (recyclerView8.J.isFinished()) {
                                recyclerView8.J.onAbsorb(currVelocity);
                            }
                        }
                        if (i7 != 0 || currVelocity != 0) {
                            AtomicInteger atomicInteger = b.h.j.q.a;
                            recyclerView8.postInvalidateOnAnimation();
                        }
                    }
                    if (RecyclerView.z0) {
                        m.b bVar = RecyclerView.this.e0;
                        int[] iArr7 = bVar.f686c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.d = 0;
                    }
                } else {
                    a();
                    RecyclerView recyclerView9 = RecyclerView.this;
                    b.o.b.m mVar = recyclerView9.d0;
                    if (mVar != null) {
                        mVar.a(recyclerView9, i2, i);
                    }
                }
            }
            v vVar3 = RecyclerView.this.m.g;
            if (vVar3 != null && vVar3.d) {
                vVar3.b(0, 0);
            }
            this.f = false;
            if (this.g) {
                RecyclerView.this.removeCallbacks(this);
                RecyclerView recyclerView10 = RecyclerView.this;
                AtomicInteger atomicInteger2 = b.h.j.q.a;
                recyclerView10.postOnAnimation(this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.n0(1);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class z {
        public static final List<Object> s = Collections.emptyList();
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<RecyclerView> f111b;
        public int j;
        public RecyclerView r;

        /* renamed from: c  reason: collision with root package name */
        public int f112c = -1;
        public int d = -1;
        public long e = -1;
        public int f = -1;
        public int g = -1;
        public z h = null;
        public z i = null;
        public List<Object> k = null;
        public List<Object> l = null;
        public int m = 0;
        public r n = null;
        public boolean o = false;
        public int p = 0;
        public int q = -1;

        public z(View view) {
            if (view != null) {
                this.a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void a(Object obj) {
            if (obj == null) {
                b(1024);
            } else if ((1024 & this.j) != 0) {
            } else {
                if (this.k == null) {
                    ArrayList arrayList = new ArrayList();
                    this.k = arrayList;
                    this.l = Collections.unmodifiableList(arrayList);
                }
                this.k.add(obj);
            }
        }

        public void b(int i) {
            this.j = i | this.j;
        }

        public void c() {
            this.d = -1;
            this.g = -1;
        }

        public void d() {
            this.j &= -33;
        }

        public final int e() {
            int i = this.g;
            return i == -1 ? this.f112c : i;
        }

        public List<Object> f() {
            if ((this.j & 1024) == 0) {
                List<Object> list = this.k;
                return (list == null || list.size() == 0) ? s : this.l;
            }
            return s;
        }

        public boolean g(int i) {
            return (i & this.j) != 0;
        }

        public boolean h() {
            return (this.a.getParent() == null || this.a.getParent() == this.r) ? false : true;
        }

        public boolean i() {
            return (this.j & 1) != 0;
        }

        public boolean j() {
            return (this.j & 4) != 0;
        }

        public final boolean k() {
            if ((this.j & 16) == 0) {
                View view = this.a;
                AtomicInteger atomicInteger = b.h.j.q.a;
                if (!view.hasTransientState()) {
                    return true;
                }
            }
            return false;
        }

        public boolean l() {
            return (this.j & 8) != 0;
        }

        public boolean m() {
            return this.n != null;
        }

        public boolean n() {
            return (this.j & 256) != 0;
        }

        public boolean o() {
            return (this.j & 2) != 0;
        }

        public void p(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.f112c;
            }
            if (this.g == -1) {
                this.g = this.f112c;
            }
            if (z) {
                this.g += i;
            }
            this.f112c += i;
            if (this.a.getLayoutParams() != null) {
                ((m) this.a.getLayoutParams()).f97c = true;
            }
        }

        public void q() {
            this.j = 0;
            this.f112c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
            this.p = 0;
            this.q = -1;
            RecyclerView.j(this);
        }

        public void r(int i, int i2) {
            this.j = (i & i2) | (this.j & (i2 ^ (-1)));
        }

        public final void s(boolean z) {
            int i;
            int i2 = this.m;
            int i3 = z ? i2 - 1 : i2 + 1;
            this.m = i3;
            if (i3 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i3 == 1) {
                i = this.j | 16;
            } else if (!z || i3 != 0) {
                return;
            } else {
                i = this.j & (-17);
            }
            this.j = i;
        }

        public boolean t() {
            return (this.j & 128) != 0;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.f112c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (m()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (j()) {
                sb.append(" invalid");
            }
            if (!i()) {
                sb.append(" unbound");
            }
            boolean z = false;
            if ((this.j & 2) != 0) {
                sb.append(" update");
            }
            if (l()) {
                sb.append(" removed");
            }
            if (t()) {
                sb.append(" ignored");
            }
            if (n()) {
                sb.append(" tmpDetached");
            }
            if (!k()) {
                StringBuilder g = c.a.a.a.a.g(" not recyclable(");
                g.append(this.m);
                g.append(")");
                sb.append(g.toString());
            }
            if ((this.j & 512) != 0 || j()) {
                z = true;
            }
            if (z) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean u() {
            return (this.j & 32) != 0;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        x0 = i2 == 18 || i2 == 19 || i2 == 20;
        y0 = i2 >= 23;
        z0 = i2 >= 21;
        Class<?> cls = Integer.TYPE;
        A0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        B0 = new b();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:(1:43)(11:82|(1:84)|45|46|47|(1:49)(1:66)|50|51|52|53|54)|46|47|(0)(0)|50|51|52|53|54) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0276, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0279, code lost:
        r0 = r4.getConstructor(new java.lang.Class[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x027f, code lost:
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x028e, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x028f, code lost:
        r0.initCause(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02af, code lost:
        throw new java.lang.IllegalStateException(r20.getPositionDescription() + ": Error creating LayoutManager " + r3, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0242 A[Catch: ClassCastException -> 0x02b0, IllegalAccessException -> 0x02cf, InstantiationException -> 0x02ee, InvocationTargetException -> 0x030b, ClassNotFoundException -> 0x0328, TryCatch #4 {ClassCastException -> 0x02b0, ClassNotFoundException -> 0x0328, IllegalAccessException -> 0x02cf, InstantiationException -> 0x02ee, InvocationTargetException -> 0x030b, blocks: (B:59:0x023c, B:61:0x0242, B:63:0x024f, B:64:0x025a, B:70:0x0280, B:68:0x0279, B:72:0x028f, B:73:0x02af, B:62:0x024b), top: B:101:0x023c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x024b A[Catch: ClassCastException -> 0x02b0, IllegalAccessException -> 0x02cf, InstantiationException -> 0x02ee, InvocationTargetException -> 0x030b, ClassNotFoundException -> 0x0328, TryCatch #4 {ClassCastException -> 0x02b0, ClassNotFoundException -> 0x0328, IllegalAccessException -> 0x02cf, InstantiationException -> 0x02ee, InvocationTargetException -> 0x030b, blocks: (B:59:0x023c, B:61:0x0242, B:63:0x024f, B:64:0x025a, B:70:0x0280, B:68:0x0279, B:72:0x028f, B:73:0x02af, B:62:0x024b), top: B:101:0x023c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public RecyclerView(android.content.Context r19, android.util.AttributeSet r20, int r21) {
        /*
            Method dump skipped, instructions count: 881
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public static RecyclerView E(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView E = E(viewGroup.getChildAt(i2));
            if (E != null) {
                return E;
            }
        }
        return null;
    }

    public static z J(View view) {
        if (view == null) {
            return null;
        }
        return ((m) view.getLayoutParams()).a;
    }

    private b.h.j.g getScrollingChildHelper() {
        if (this.p0 == null) {
            this.p0 = new b.h.j.g(this);
        }
        return this.p0;
    }

    public static void j(z zVar) {
        WeakReference<RecyclerView> weakReference = zVar.f111b;
        if (weakReference != null) {
            ViewParent viewParent = weakReference.get();
            while (true) {
                for (View view = (View) viewParent; view != null; view = null) {
                    if (view == zVar.a) {
                        return;
                    }
                    viewParent = view.getParent();
                    if (viewParent instanceof View) {
                        break;
                    }
                }
                zVar.f111b = null;
                return;
            }
        }
    }

    public final void A(w wVar) {
        if (getScrollState() != 2) {
            wVar.getClass();
            return;
        }
        OverScroller overScroller = this.c0.d;
        overScroller.getFinalX();
        overScroller.getCurrX();
        wVar.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View B(android.view.View r3) {
        /*
            r2 = this;
        L0:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L10
            if (r0 == r2) goto L10
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L10
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L0
        L10:
            if (r0 != r2) goto L13
            goto L14
        L13:
            r3 = 0
        L14:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.B(android.view.View):android.view.View");
    }

    public final boolean C(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            o oVar = this.p.get(i2);
            if (oVar.b(this, motionEvent) && action != 3) {
                this.q = oVar;
                return true;
            }
        }
        return false;
    }

    public final void D(int[] iArr) {
        int e2 = this.f.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < e2; i4++) {
            z J = J(this.f.d(i4));
            if (!J.t()) {
                int e3 = J.e();
                if (e3 < i2) {
                    i2 = e3;
                }
                if (e3 > i3) {
                    i3 = e3;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public z F(int i2) {
        z zVar = null;
        if (this.B) {
            return null;
        }
        int h2 = this.f.h();
        for (int i3 = 0; i3 < h2; i3++) {
            z J = J(this.f.g(i3));
            if (J != null && !J.l() && G(J) == i2) {
                if (!this.f.k(J.a)) {
                    return J;
                }
                zVar = J;
            }
        }
        return zVar;
    }

    public int G(z zVar) {
        if (zVar.g(524) || !zVar.i()) {
            return -1;
        }
        b.o.b.a aVar = this.e;
        int i2 = zVar.f112c;
        int size = aVar.f646b.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.f646b.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f648b;
                    if (i5 <= i2) {
                        int i6 = bVar.d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f648b;
                    if (i7 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f648b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    public long H(z zVar) {
        if (this.l.f88b) {
            return zVar.e;
        }
        return zVar.f112c;
    }

    public z I(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return J(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public Rect K(View view) {
        m mVar = (m) view.getLayoutParams();
        if (!mVar.f97c) {
            return mVar.f96b;
        }
        if (this.f0.g && (mVar.b() || mVar.a.j())) {
            return mVar.f96b;
        }
        Rect rect = mVar.f96b;
        rect.set(0, 0, 0, 0);
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.i.set(0, 0, 0, 0);
            Rect rect2 = this.i;
            this.o.get(i2).getClass();
            ((m) view.getLayoutParams()).a();
            rect2.set(0, 0, 0, 0);
            int i3 = rect.left;
            Rect rect3 = this.i;
            rect.left = i3 + rect3.left;
            rect.top += rect3.top;
            rect.right += rect3.right;
            rect.bottom += rect3.bottom;
        }
        mVar.f97c = false;
        return rect;
    }

    public boolean L() {
        return !this.u || this.B || this.e.g();
    }

    public void M() {
        this.J = null;
        this.H = null;
        this.I = null;
        this.G = null;
    }

    public boolean N() {
        return this.D > 0;
    }

    public void O(int i2) {
        if (this.m == null) {
            return;
        }
        setScrollState(2);
        this.m.M0(i2);
        awakenScrollBars();
    }

    public void P() {
        int h2 = this.f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((m) this.f.g(i2).getLayoutParams()).f97c = true;
        }
        r rVar = this.f86c;
        int size = rVar.f102c.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = (m) rVar.f102c.get(i3).a.getLayoutParams();
            if (mVar != null) {
                mVar.f97c = true;
            }
        }
    }

    public void Q(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.f.h();
        for (int i5 = 0; i5 < h2; i5++) {
            z J = J(this.f.g(i5));
            if (J != null && !J.t()) {
                int i6 = J.f112c;
                if (i6 >= i4) {
                    J.p(-i3, z2);
                } else if (i6 >= i2) {
                    J.b(8);
                    J.p(-i3, z2);
                    J.f112c = i2 - 1;
                }
                this.f0.f = true;
            }
        }
        r rVar = this.f86c;
        int size = rVar.f102c.size();
        while (true) {
            size--;
            if (size < 0) {
                requestLayout();
                return;
            }
            z zVar = rVar.f102c.get(size);
            if (zVar != null) {
                int i7 = zVar.f112c;
                if (i7 >= i4) {
                    zVar.p(-i3, z2);
                } else if (i7 >= i2) {
                    zVar.b(8);
                    rVar.g(size);
                }
            }
        }
    }

    public void R() {
    }

    public void S() {
    }

    public void T() {
        this.D++;
    }

    public void U(boolean z2) {
        int i2;
        boolean z3 = true;
        int i3 = this.D - 1;
        this.D = i3;
        if (i3 < 1) {
            this.D = 0;
            if (!z2) {
                return;
            }
            int i4 = this.z;
            this.z = 0;
            if (i4 != 0) {
                AccessibilityManager accessibilityManager = this.A;
                if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                    z3 = false;
                }
                if (z3) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    if (Build.VERSION.SDK_INT >= 19) {
                        obtain.setContentChangeTypes(i4);
                    }
                    sendAccessibilityEventUnchecked(obtain);
                }
            }
            for (int size = this.t0.size() - 1; size >= 0; size--) {
                z zVar = this.t0.get(size);
                if (zVar.a.getParent() == this && !zVar.t() && (i2 = zVar.q) != -1) {
                    b.h.j.q.I(zVar.a, i2);
                    zVar.q = -1;
                }
            }
            this.t0.clear();
        }
    }

    public final void V(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.M) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.M = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.Q = x2;
            this.O = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.R = y2;
            this.P = y2;
        }
    }

    public void W() {
    }

    public void X() {
    }

    public void Y() {
        if (this.l0 || !this.r) {
            return;
        }
        Runnable runnable = this.u0;
        AtomicInteger atomicInteger = b.h.j.q.a;
        postOnAnimation(runnable);
        this.l0 = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x007d, code lost:
        if ((r6.K != null && r6.m.Y0()) != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z() {
        /*
            r6 = this;
            boolean r0 = r6.B
            if (r0 == 0) goto L19
            b.o.b.a r0 = r6.e
            java.util.ArrayList<b.o.b.a$b> r1 = r0.f646b
            r0.l(r1)
            java.util.ArrayList<b.o.b.a$b> r1 = r0.f647c
            r0.l(r1)
            boolean r0 = r6.C
            if (r0 == 0) goto L19
            androidx.recyclerview.widget.RecyclerView$l r0 = r6.m
            r0.p0(r6)
        L19:
            androidx.recyclerview.widget.RecyclerView$i r0 = r6.K
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L29
            androidx.recyclerview.widget.RecyclerView$l r0 = r6.m
            boolean r0 = r0.Y0()
            if (r0 == 0) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 == 0) goto L32
            b.o.b.a r0 = r6.e
            r0.j()
            goto L37
        L32:
            b.o.b.a r0 = r6.e
            r0.c()
        L37:
            boolean r0 = r6.i0
            if (r0 != 0) goto L42
            boolean r0 = r6.j0
            if (r0 == 0) goto L40
            goto L42
        L40:
            r0 = 0
            goto L43
        L42:
            r0 = 1
        L43:
            androidx.recyclerview.widget.RecyclerView$w r3 = r6.f0
            boolean r4 = r6.u
            if (r4 == 0) goto L63
            androidx.recyclerview.widget.RecyclerView$i r4 = r6.K
            if (r4 == 0) goto L63
            boolean r4 = r6.B
            if (r4 != 0) goto L59
            if (r0 != 0) goto L59
            androidx.recyclerview.widget.RecyclerView$l r5 = r6.m
            boolean r5 = r5.h
            if (r5 == 0) goto L63
        L59:
            if (r4 == 0) goto L61
            androidx.recyclerview.widget.RecyclerView$d r4 = r6.l
            boolean r4 = r4.f88b
            if (r4 == 0) goto L63
        L61:
            r4 = 1
            goto L64
        L63:
            r4 = 0
        L64:
            r3.j = r4
            if (r4 == 0) goto L80
            if (r0 == 0) goto L80
            boolean r0 = r6.B
            if (r0 != 0) goto L80
            androidx.recyclerview.widget.RecyclerView$i r0 = r6.K
            if (r0 == 0) goto L7c
            androidx.recyclerview.widget.RecyclerView$l r0 = r6.m
            boolean r0 = r0.Y0()
            if (r0 == 0) goto L7c
            r0 = 1
            goto L7d
        L7c:
            r0 = 0
        L7d:
            if (r0 == 0) goto L80
            goto L81
        L80:
            r1 = 0
        L81:
            r3.k = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Z():void");
    }

    public void a0(boolean z2) {
        this.C = z2 | this.C;
        this.B = true;
        int h2 = this.f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            z J = J(this.f.g(i2));
            if (J != null && !J.t()) {
                J.b(6);
            }
        }
        P();
        r rVar = this.f86c;
        int size = rVar.f102c.size();
        for (int i3 = 0; i3 < size; i3++) {
            z zVar = rVar.f102c.get(i3);
            if (zVar != null) {
                zVar.b(6);
                zVar.a(null);
            }
        }
        d dVar = RecyclerView.this.l;
        if (dVar == null || !dVar.f88b) {
            rVar.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        l lVar = this.m;
        if (lVar == null || !lVar.e0()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b0(z zVar, i.c cVar) {
        zVar.r(0, 8192);
        if (this.f0.h && zVar.o() && !zVar.l() && !zVar.t()) {
            this.g.f656b.g(H(zVar), zVar);
        }
        this.g.c(zVar, cVar);
    }

    public void c0() {
        i iVar = this.K;
        if (iVar != null) {
            iVar.f();
        }
        l lVar = this.m;
        if (lVar != null) {
            lVar.E0(this.f86c);
            this.m.F0(this.f86c);
        }
        this.f86c.b();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof m) && this.m.g((m) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        l lVar = this.m;
        if (lVar != null && lVar.e()) {
            return this.m.k(this.f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        l lVar = this.m;
        if (lVar != null && lVar.e()) {
            return this.m.l(this.f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        l lVar = this.m;
        if (lVar != null && lVar.e()) {
            return this.m.m(this.f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        l lVar = this.m;
        if (lVar != null && lVar.f()) {
            return this.m.n(this.f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        l lVar = this.m;
        if (lVar != null && lVar.f()) {
            return this.m.o(this.f0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        l lVar = this.m;
        if (lVar != null && lVar.f()) {
            return this.m.p(this.f0);
        }
        return 0;
    }

    public final void d0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.i.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof m) {
            m mVar = (m) layoutParams;
            if (!mVar.f97c) {
                Rect rect = mVar.f96b;
                Rect rect2 = this.i;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.i);
            offsetRectIntoDescendantCoords(view, this.i);
        }
        this.m.J0(this, view, this.i, !this.u, view2 == null);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        float f2;
        float f3;
        super.draw(canvas);
        int size = this.o.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.o.get(i2).e(canvas, this, this.f0);
        }
        EdgeEffect edgeEffect = this.G;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.G;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.H;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.h) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.H;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.I;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.I;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.J;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                f2 = getPaddingRight() + (-getWidth());
                f3 = getPaddingBottom() + (-getHeight());
            } else {
                f2 = -getWidth();
                f3 = -getHeight();
            }
            canvas.translate(f2, f3);
            EdgeEffect edgeEffect8 = this.J;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.K == null || this.o.size() <= 0 || !this.K.g()) {
            z4 = z2;
        }
        if (z4) {
            AtomicInteger atomicInteger = b.h.j.q.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e(z zVar) {
        View view = zVar.a;
        boolean z2 = view.getParent() == this;
        this.f86c.l(I(view));
        if (zVar.n()) {
            this.f.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        b.o.b.b bVar = this.f;
        if (!z2) {
            bVar.a(view, -1, true);
            return;
        }
        int indexOfChild = ((b.o.b.v) bVar.a).a.indexOfChild(view);
        if (indexOfChild >= 0) {
            bVar.f653b.h(indexOfChild);
            bVar.i(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public final void e0() {
        VelocityTracker velocityTracker = this.N;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z2 = false;
        n0(0);
        EdgeEffect edgeEffect = this.G;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.G.isFinished();
        }
        EdgeEffect edgeEffect2 = this.H;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.H.isFinished();
        }
        EdgeEffect edgeEffect3 = this.I;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.I.isFinished();
        }
        EdgeEffect edgeEffect4 = this.J;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.J.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = b.h.j.q.a;
            postInvalidateOnAnimation();
        }
    }

    public void f(k kVar) {
        l lVar = this.m;
        if (lVar != null) {
            lVar.d("Cannot add item decoration during a scroll  or layout");
        }
        if (this.o.isEmpty()) {
            setWillNotDraw(false);
        }
        this.o.add(kVar);
        P();
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f0(int r18, int r19, android.view.MotionEvent r20) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.f0(int, int, android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0169, code lost:
        if (r3 > 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0183, code lost:
        if (r6 > 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0186, code lost:
        if (r3 < 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0189, code lost:
        if (r6 < 0) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0192, code lost:
        if ((r6 * r1) < 0) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x019b, code lost:
        if ((r6 * r1) > 0) goto L122;
     */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0075  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public void g(p pVar) {
        if (this.h0 == null) {
            this.h0 = new ArrayList();
        }
        this.h0.add(pVar);
    }

    public void g0(int i2, int i3, int[] iArr) {
        z zVar;
        k0();
        T();
        b.h.f.b.a("RV Scroll");
        A(this.f0);
        int L0 = i2 != 0 ? this.m.L0(i2, this.f86c, this.f0) : 0;
        int N0 = i3 != 0 ? this.m.N0(i3, this.f86c, this.f0) : 0;
        b.h.f.b.b();
        int e2 = this.f.e();
        for (int i4 = 0; i4 < e2; i4++) {
            View d2 = this.f.d(i4);
            z I = I(d2);
            if (I != null && (zVar = I.i) != null) {
                View view = zVar.a;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        U(true);
        m0(false);
        if (iArr != null) {
            iArr[0] = L0;
            iArr[1] = N0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        l lVar = this.m;
        if (lVar != null) {
            return lVar.u();
        }
        throw new IllegalStateException(c.a.a.a.a.b(this, c.a.a.a.a.g("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        l lVar = this.m;
        if (lVar != null) {
            return lVar.v(getContext(), attributeSet);
        }
        throw new IllegalStateException(c.a.a.a.a.b(this, c.a.a.a.a.g("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        l lVar = this.m;
        if (lVar != null) {
            return lVar.w(layoutParams);
        }
        throw new IllegalStateException(c.a.a.a.a.b(this, c.a.a.a.a.g("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public d getAdapter() {
        return this.l;
    }

    @Override // android.view.View
    public int getBaseline() {
        l lVar = this.m;
        if (lVar != null) {
            lVar.getClass();
            return -1;
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        g gVar = this.n0;
        return gVar == null ? super.getChildDrawingOrder(i2, i3) : gVar.a(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.h;
    }

    public b.o.b.x getCompatAccessibilityDelegate() {
        return this.m0;
    }

    public h getEdgeEffectFactory() {
        return this.F;
    }

    public i getItemAnimator() {
        return this.K;
    }

    public int getItemDecorationCount() {
        return this.o.size();
    }

    public l getLayoutManager() {
        return this.m;
    }

    public int getMaxFlingVelocity() {
        return this.V;
    }

    public int getMinFlingVelocity() {
        return this.U;
    }

    public long getNanoTime() {
        if (z0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public n getOnFlingListener() {
        return this.T;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.b0;
    }

    public q getRecycledViewPool() {
        return this.f86c.d();
    }

    public int getScrollState() {
        return this.L;
    }

    public void h(String str) {
        if (N()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(c.a.a.a.a.b(this, c.a.a.a.a.g("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        } else if (this.E <= 0) {
        } else {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(c.a.a.a.a.b(this, c.a.a.a.a.g(""))));
        }
    }

    public void h0(int i2) {
        if (this.x) {
            return;
        }
        o0();
        l lVar = this.m;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        lVar.M0(i2);
        awakenScrollBars();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().h(0);
    }

    public final void i() {
        e0();
        setScrollState(0);
    }

    public boolean i0(z zVar, int i2) {
        if (!N()) {
            b.h.j.q.I(zVar.a, i2);
            return true;
        }
        zVar.q = i2;
        this.t0.add(zVar);
        return false;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.r;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.x;
    }

    @Override // android.view.View, b.h.j.f
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public void j0(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        l lVar = this.m;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.x) {
        } else {
            int i5 = 0;
            if (!lVar.e()) {
                i2 = 0;
            }
            if (!this.m.f()) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            if (!(i4 == Integer.MIN_VALUE || i4 > 0)) {
                scrollBy(i2, i3);
                return;
            }
            if (z2) {
                if (i2 != 0) {
                    i5 = 1;
                }
                if (i3 != 0) {
                    i5 |= 2;
                }
                l0(i5, 1);
            }
            this.c0.b(i2, i3, i4, interpolator);
        }
    }

    public void k() {
        int h2 = this.f.h();
        for (int i2 = 0; i2 < h2; i2++) {
            z J = J(this.f.g(i2));
            if (!J.t()) {
                J.c();
            }
        }
        r rVar = this.f86c;
        int size = rVar.f102c.size();
        for (int i3 = 0; i3 < size; i3++) {
            rVar.f102c.get(i3).c();
        }
        int size2 = rVar.a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            rVar.a.get(i4).c();
        }
        ArrayList<z> arrayList = rVar.f101b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                rVar.f101b.get(i5).c();
            }
        }
    }

    public void k0() {
        int i2 = this.v + 1;
        this.v = i2;
        if (i2 != 1 || this.x) {
            return;
        }
        this.w = false;
    }

    public void l(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.G;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.G.onRelease();
            z2 = this.G.isFinished();
        }
        EdgeEffect edgeEffect2 = this.I;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.I.onRelease();
            z2 |= this.I.isFinished();
        }
        EdgeEffect edgeEffect3 = this.H;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.H.onRelease();
            z2 |= this.H.isFinished();
        }
        EdgeEffect edgeEffect4 = this.J;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.J.onRelease();
            z2 |= this.J.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = b.h.j.q.a;
            postInvalidateOnAnimation();
        }
    }

    public boolean l0(int i2, int i3) {
        return getScrollingChildHelper().j(i2, i3);
    }

    public void m() {
        if (!this.u || this.B) {
            b.h.f.b.a("RV FullInvalidate");
            p();
            b.h.f.b.b();
        } else if (!this.e.g()) {
        } else {
            this.e.getClass();
            if (!this.e.g()) {
                return;
            }
            b.h.f.b.a("RV FullInvalidate");
            p();
            b.h.f.b.b();
        }
    }

    public void m0(boolean z2) {
        if (this.v < 1) {
            this.v = 1;
        }
        if (!z2 && !this.x) {
            this.w = false;
        }
        if (this.v == 1) {
            if (z2 && this.w && !this.x && this.m != null && this.l != null) {
                p();
            }
            if (!this.x) {
                this.w = false;
            }
        }
        this.v--;
    }

    public void n(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        AtomicInteger atomicInteger = b.h.j.q.a;
        setMeasuredDimension(l.h(i2, paddingRight, getMinimumWidth()), l.h(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void n0(int i2) {
        getScrollingChildHelper().k(i2);
    }

    public void o(View view) {
        z J = J(view);
        S();
        d dVar = this.l;
        if (dVar == null || J == null) {
            return;
        }
        dVar.getClass();
    }

    public void o0() {
        v vVar;
        setScrollState(0);
        this.c0.c();
        l lVar = this.m;
        if (lVar == null || (vVar = lVar.g) == null) {
            return;
        }
        vVar.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = 0;
        this.r = true;
        this.u = this.u && !isLayoutRequested();
        l lVar = this.m;
        if (lVar != null) {
            lVar.i = true;
            lVar.f0();
        }
        this.l0 = false;
        if (z0) {
            ThreadLocal<b.o.b.m> threadLocal = b.o.b.m.f;
            b.o.b.m mVar = threadLocal.get();
            this.d0 = mVar;
            if (mVar == null) {
                this.d0 = new b.o.b.m();
                AtomicInteger atomicInteger = b.h.j.q.a;
                Display display = Build.VERSION.SDK_INT >= 17 ? getDisplay() : b.h.j.q.t(this) ? ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay() : null;
                float f2 = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                b.o.b.m mVar2 = this.d0;
                mVar2.d = 1.0E9f / f2;
                threadLocal.set(mVar2);
            }
            this.d0.f683b.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        b.o.b.m mVar;
        super.onDetachedFromWindow();
        i iVar = this.K;
        if (iVar != null) {
            iVar.f();
        }
        o0();
        this.r = false;
        l lVar = this.m;
        if (lVar != null) {
            r rVar = this.f86c;
            lVar.i = false;
            lVar.h0(this, rVar);
        }
        this.t0.clear();
        removeCallbacks(this.u0);
        this.g.getClass();
        do {
        } while (b0.a.d.a() != null);
        if (!z0 || (mVar = this.d0) == null) {
            return;
        }
        mVar.f683b.remove(this);
        this.d0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.o.get(i2).d(canvas, this, this.f0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$l r0 = r5.m
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.x
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$l r0 = r5.m
            boolean r0 = r0.f()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$l r3 = r5.m
            boolean r3 = r3.e()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$l r3 = r5.m
            boolean r3 = r3.f()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$l r3 = r5.m
            boolean r3 = r3.e()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.W
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.a0
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.f0(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.x) {
            return false;
        }
        this.q = null;
        if (C(motionEvent)) {
            i();
            return true;
        }
        l lVar = this.m;
        if (lVar == null) {
            return false;
        }
        boolean e2 = lVar.e();
        boolean f2 = this.m.f();
        if (this.N == null) {
            this.N = VelocityTracker.obtain();
        }
        this.N.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.y) {
                this.y = false;
            }
            this.M = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.Q = x2;
            this.O = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.R = y2;
            this.P = y2;
            if (this.L == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                n0(1);
            }
            int[] iArr = this.r0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (f2) {
                boolean z3 = e2 ? 1 : 0;
                char c2 = e2 ? 1 : 0;
                e2 = z3 | true;
            }
            int i2 = e2 ? 1 : 0;
            int i3 = e2 ? 1 : 0;
            l0(i2, 0);
        } else if (actionMasked == 1) {
            this.N.clear();
            n0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.M);
            if (findPointerIndex < 0) {
                StringBuilder g2 = c.a.a.a.a.g("Error processing scroll; pointer index for id ");
                g2.append(this.M);
                g2.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", g2.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.L != 1) {
                int i4 = x3 - this.O;
                int i5 = y3 - this.P;
                if (!e2 || Math.abs(i4) <= this.S) {
                    z2 = false;
                } else {
                    this.Q = x3;
                    z2 = true;
                }
                if (f2 && Math.abs(i5) > this.S) {
                    this.R = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            i();
        } else if (actionMasked == 5) {
            this.M = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.Q = x4;
            this.O = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.R = y4;
            this.P = y4;
        } else if (actionMasked == 6) {
            V(motionEvent);
        }
        return this.L == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        b.h.f.b.a("RV OnLayout");
        p();
        b.h.f.b.b();
        this.u = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        l lVar = this.m;
        if (lVar == null) {
            n(i2, i3);
            return;
        }
        boolean z2 = false;
        if (!lVar.W()) {
            if (this.s) {
                this.m.w0(i2, i3);
                return;
            }
            w wVar = this.f0;
            if (wVar.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            d dVar = this.l;
            if (dVar != null) {
                wVar.e = dVar.a();
            } else {
                wVar.e = 0;
            }
            k0();
            this.m.w0(i2, i3);
            m0(false);
            this.f0.g = false;
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        this.m.w0(i2, i3);
        if (mode == 1073741824 && mode2 == 1073741824) {
            z2 = true;
        }
        if (z2 || this.l == null) {
            return;
        }
        if (this.f0.d == 1) {
            q();
        }
        this.m.P0(i2, i3);
        this.f0.i = true;
        r();
        this.m.R0(i2, i3);
        if (!this.m.U0()) {
            return;
        }
        this.m.P0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.f0.i = true;
        r();
        this.m.R0(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (N()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof u)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        u uVar = (u) parcelable;
        this.d = uVar;
        super.onRestoreInstanceState(uVar.f510b);
        l lVar = this.m;
        if (lVar == null || (parcelable2 = this.d.d) == null) {
            return;
        }
        lVar.z0(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        u uVar = new u(super.onSaveInstanceState());
        u uVar2 = this.d;
        if (uVar2 != null) {
            uVar.d = uVar2.d;
        } else {
            l lVar = this.m;
            uVar.d = lVar != null ? lVar.A0() : null;
        }
        return uVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        M();
    }

    /* JADX WARN: Code restructure failed: missing block: B:213:0x031a, code lost:
        if (r0 < r3) goto L173;
     */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instructions count: 994
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x02f5, code lost:
        if (r15.f.k(getFocusedChild()) == false) goto L209;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p() {
        /*
            Method dump skipped, instructions count: 963
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p():void");
    }

    public final void q() {
        int i2;
        View view;
        int id;
        View B;
        this.f0.a(1);
        A(this.f0);
        this.f0.i = false;
        k0();
        b0 b0Var = this.g;
        b0Var.a.clear();
        b0Var.f656b.b();
        T();
        Z();
        View focusedChild = (!this.b0 || !hasFocus() || this.l == null) ? null : getFocusedChild();
        z I = (focusedChild == null || (B = B(focusedChild)) == null) ? null : I(B);
        long j2 = -1;
        if (I == null) {
            w wVar = this.f0;
            wVar.m = -1L;
            wVar.l = -1;
            wVar.n = -1;
        } else {
            w wVar2 = this.f0;
            if (this.l.f88b) {
                j2 = I.e;
            }
            wVar2.m = j2;
            if (!this.B) {
                if (I.l()) {
                    i2 = I.d;
                } else {
                    RecyclerView recyclerView = I.r;
                    if (recyclerView != null) {
                        i2 = recyclerView.G(I);
                    }
                }
                wVar2.l = i2;
                w wVar3 = this.f0;
                view = I.a;
                loop3: while (true) {
                    id = view.getId();
                    while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                        view = ((ViewGroup) view).getFocusedChild();
                        if (view.getId() != -1) {
                            break;
                        }
                    }
                }
                wVar3.n = id;
            }
            i2 = -1;
            wVar2.l = i2;
            w wVar32 = this.f0;
            view = I.a;
            loop3: while (true) {
                id = view.getId();
                while (!view.isFocused()) {
                    view = ((ViewGroup) view).getFocusedChild();
                    if (view.getId() != -1) {
                        break;
                    }
                }
            }
            wVar32.n = id;
        }
        w wVar4 = this.f0;
        wVar4.h = wVar4.j && this.j0;
        this.j0 = false;
        this.i0 = false;
        wVar4.g = wVar4.k;
        wVar4.e = this.l.a();
        D(this.o0);
        if (this.f0.j) {
            int e2 = this.f.e();
            for (int i3 = 0; i3 < e2; i3++) {
                z J = J(this.f.d(i3));
                if (!J.t() && (!J.j() || this.l.f88b)) {
                    i iVar = this.K;
                    i.b(J);
                    J.f();
                    this.g.c(J, iVar.h(J));
                    if (this.f0.h && J.o() && !J.l() && !J.t() && !J.j()) {
                        this.g.f656b.g(H(J), J);
                    }
                }
            }
        }
        if (this.f0.k) {
            int h2 = this.f.h();
            for (int i4 = 0; i4 < h2; i4++) {
                z J2 = J(this.f.g(i4));
                if (!J2.t() && J2.d == -1) {
                    J2.d = J2.f112c;
                }
            }
            w wVar5 = this.f0;
            boolean z2 = wVar5.f;
            wVar5.f = false;
            this.m.u0(this.f86c, wVar5);
            this.f0.f = z2;
            for (int i5 = 0; i5 < this.f.e(); i5++) {
                z J3 = J(this.f.d(i5));
                if (!J3.t()) {
                    b0.a orDefault = this.g.a.getOrDefault(J3, null);
                    if (!((orDefault == null || (orDefault.a & 4) == 0) ? false : true)) {
                        i.b(J3);
                        boolean g2 = J3.g(8192);
                        i iVar2 = this.K;
                        J3.f();
                        i.c h3 = iVar2.h(J3);
                        if (g2) {
                            b0(J3, h3);
                        } else {
                            b0 b0Var2 = this.g;
                            b0.a orDefault2 = b0Var2.a.getOrDefault(J3, null);
                            if (orDefault2 == null) {
                                orDefault2 = b0.a.a();
                                b0Var2.a.put(J3, orDefault2);
                            }
                            orDefault2.a |= 2;
                            orDefault2.f657b = h3;
                        }
                    }
                }
            }
        }
        k();
        U(true);
        m0(false);
        this.f0.d = 2;
    }

    public final void r() {
        k0();
        T();
        this.f0.a(6);
        this.e.c();
        this.f0.e = this.l.a();
        w wVar = this.f0;
        wVar.f108c = 0;
        wVar.g = false;
        this.m.u0(this.f86c, wVar);
        w wVar2 = this.f0;
        wVar2.f = false;
        this.d = null;
        wVar2.j = wVar2.j && this.K != null;
        wVar2.d = 4;
        U(true);
        m0(false);
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        z J = J(view);
        if (J != null) {
            if (J.n()) {
                J.j &= -257;
            } else if (!J.t()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(J);
                throw new IllegalArgumentException(c.a.a.a.a.b(this, sb));
            }
        }
        view.clearAnimation();
        o(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.m.y0(this, view, view2) && view2 != null) {
            d0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.m.J0(this, view, rect, z2, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.p.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.v != 0 || this.x) {
            this.w = true;
        } else {
            super.requestLayout();
        }
    }

    public boolean s(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, null, i4);
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        l lVar = this.m;
        if (lVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.x) {
        } else {
            boolean e2 = lVar.e();
            boolean f2 = this.m.f();
            if (!e2 && !f2) {
                return;
            }
            if (!e2) {
                i2 = 0;
            }
            if (!f2) {
                i3 = 0;
            }
            f0(i2, i3, null);
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (N()) {
            int contentChangeTypes = (accessibilityEvent == null || Build.VERSION.SDK_INT < 19) ? 0 : accessibilityEvent.getContentChangeTypes();
            if (contentChangeTypes != 0) {
                i2 = contentChangeTypes;
            }
            this.z |= i2;
            i2 = 1;
        }
        if (i2 != 0) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(b.o.b.x xVar) {
        this.m0 = xVar;
        b.h.j.q.F(this, xVar);
    }

    public void setAdapter(d dVar) {
        setLayoutFrozen(false);
        d dVar2 = this.l;
        if (dVar2 != null) {
            dVar2.a.unregisterObserver(this.f85b);
            this.l.getClass();
        }
        c0();
        b.o.b.a aVar = this.e;
        aVar.l(aVar.f646b);
        aVar.l(aVar.f647c);
        d dVar3 = this.l;
        this.l = dVar;
        if (dVar != null) {
            dVar.a.registerObserver(this.f85b);
        }
        l lVar = this.m;
        if (lVar != null) {
            lVar.d0();
        }
        r rVar = this.f86c;
        d dVar4 = this.l;
        rVar.b();
        q d2 = rVar.d();
        d2.getClass();
        if (dVar3 != null) {
            d2.f98b--;
        }
        if (d2.f98b == 0) {
            for (int i2 = 0; i2 < d2.a.size(); i2++) {
                d2.a.valueAt(i2).a.clear();
            }
        }
        if (dVar4 != null) {
            d2.f98b++;
        }
        this.f0.f = true;
        a0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(g gVar) {
        if (gVar == this.n0) {
            return;
        }
        this.n0 = gVar;
        setChildrenDrawingOrderEnabled(gVar != null);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.h) {
            M();
        }
        this.h = z2;
        super.setClipToPadding(z2);
        if (this.u) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(h hVar) {
        hVar.getClass();
        this.F = hVar;
        M();
    }

    public void setHasFixedSize(boolean z2) {
        this.s = z2;
    }

    public void setItemAnimator(i iVar) {
        i iVar2 = this.K;
        if (iVar2 != null) {
            iVar2.f();
            this.K.a = null;
        }
        this.K = iVar;
        if (iVar != null) {
            iVar.a = this.k0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        r rVar = this.f86c;
        rVar.e = i2;
        rVar.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(l lVar) {
        if (lVar == this.m) {
            return;
        }
        o0();
        if (this.m != null) {
            i iVar = this.K;
            if (iVar != null) {
                iVar.f();
            }
            this.m.E0(this.f86c);
            this.m.F0(this.f86c);
            this.f86c.b();
            if (this.r) {
                l lVar2 = this.m;
                r rVar = this.f86c;
                lVar2.i = false;
                lVar2.h0(this, rVar);
            }
            this.m.S0(null);
            this.m = null;
        } else {
            this.f86c.b();
        }
        b.o.b.b bVar = this.f;
        b.a aVar = bVar.f653b;
        aVar.a = 0L;
        b.a aVar2 = aVar.f655b;
        if (aVar2 != null) {
            aVar2.g();
        }
        int size = bVar.f654c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b.o.b.v vVar = (b.o.b.v) bVar.a;
            vVar.getClass();
            z J = J(bVar.f654c.get(size));
            if (J != null) {
                vVar.a.i0(J, J.p);
                J.p = 0;
            }
            bVar.f654c.remove(size);
        }
        b.o.b.v vVar2 = (b.o.b.v) bVar.a;
        int b2 = vVar2.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View a2 = vVar2.a(i2);
            vVar2.a.o(a2);
            a2.clearAnimation();
        }
        vVar2.a.removeAllViews();
        this.m = lVar;
        if (lVar != null) {
            if (lVar.f92b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("LayoutManager ");
                sb.append(lVar);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(c.a.a.a.a.b(lVar.f92b, sb));
            }
            lVar.S0(this);
            if (this.r) {
                l lVar3 = this.m;
                lVar3.i = true;
                lVar3.f0();
            }
        }
        this.f86c.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().i(z2);
    }

    public void setOnFlingListener(n nVar) {
        this.T = nVar;
    }

    @Deprecated
    public void setOnScrollListener(p pVar) {
        this.g0 = pVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.b0 = z2;
    }

    public void setRecycledViewPool(q qVar) {
        q qVar2;
        r rVar = this.f86c;
        if (rVar.g != null) {
            qVar2.f98b--;
        }
        rVar.g = qVar;
        if (qVar == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        rVar.g.f98b++;
    }

    public void setRecyclerListener(s sVar) {
        this.n = sVar;
    }

    public void setScrollState(int i2) {
        v vVar;
        if (i2 == this.L) {
            return;
        }
        this.L = i2;
        if (i2 != 2) {
            this.c0.c();
            l lVar = this.m;
            if (lVar != null && (vVar = lVar.g) != null) {
                vVar.d();
            }
        }
        l lVar2 = this.m;
        if (lVar2 != null) {
            lVar2.B0(i2);
        }
        W();
        p pVar = this.g0;
        if (pVar != null) {
            pVar.a(this, i2);
        }
        List<p> list = this.h0;
        if (list == null) {
            return;
        }
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            this.h0.get(size).a(this, i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        int scaledTouchSlop;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                scaledTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                this.S = scaledTouchSlop;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.S = scaledTouchSlop;
    }

    public void setViewCacheExtension(x xVar) {
        this.f86c.getClass();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().j(i2, 0);
    }

    @Override // android.view.View, b.h.j.f
    public void stopNestedScroll() {
        getScrollingChildHelper().k(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.x) {
            h("Do not suppressLayout in layout or scroll");
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.x = true;
                this.y = true;
                o0();
                return;
            }
            this.x = false;
            if (this.w && this.m != null && this.l != null) {
                requestLayout();
            }
            this.w = false;
        }
    }

    public final void t(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().f(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void u(int i2, int i3) {
        this.E++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        X();
        p pVar = this.g0;
        if (pVar != null) {
            pVar.b(this, i2, i3);
        }
        List<p> list = this.h0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.h0.get(size).b(this, i2, i3);
            }
        }
        this.E--;
    }

    public void v() {
        int measuredWidth;
        int measuredHeight;
        if (this.J != null) {
            return;
        }
        EdgeEffect a2 = this.F.a(this);
        this.J = a2;
        if (this.h) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a2.setSize(measuredWidth, measuredHeight);
    }

    public void w() {
        int measuredHeight;
        int measuredWidth;
        if (this.G != null) {
            return;
        }
        EdgeEffect a2 = this.F.a(this);
        this.G = a2;
        if (this.h) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a2.setSize(measuredHeight, measuredWidth);
    }

    public void x() {
        int measuredHeight;
        int measuredWidth;
        if (this.I != null) {
            return;
        }
        EdgeEffect a2 = this.F.a(this);
        this.I = a2;
        if (this.h) {
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        } else {
            measuredHeight = getMeasuredHeight();
            measuredWidth = getMeasuredWidth();
        }
        a2.setSize(measuredHeight, measuredWidth);
    }

    public void y() {
        int measuredWidth;
        int measuredHeight;
        if (this.H != null) {
            return;
        }
        EdgeEffect a2 = this.F.a(this);
        this.H = a2;
        if (this.h) {
            measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        } else {
            measuredWidth = getMeasuredWidth();
            measuredHeight = getMeasuredHeight();
        }
        a2.setSize(measuredWidth, measuredHeight);
    }

    public String z() {
        StringBuilder g2 = c.a.a.a.a.g(" ");
        g2.append(super.toString());
        g2.append(", adapter:");
        g2.append(this.l);
        g2.append(", layout:");
        g2.append(this.m);
        g2.append(", context:");
        g2.append(getContext());
        return g2.toString();
    }
}
