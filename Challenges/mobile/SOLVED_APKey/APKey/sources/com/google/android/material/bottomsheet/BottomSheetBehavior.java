package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.c0.b;
import b.h.j.f;
import b.h.j.q;
import b.j.b.e;
import c.c.a.a.q.l;
import c.c.a.a.q.m;
import c.c.a.a.q.o;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import com.example.apkey.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public boolean A;
    public int B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public WeakReference<V> G;
    public WeakReference<View> H;
    public final ArrayList<c> I;
    public VelocityTracker J;
    public int K;
    public int L;
    public boolean M;
    public Map<View, Integer> N;
    public int O;
    public final e.c P;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f941b;

    /* renamed from: c  reason: collision with root package name */
    public float f942c;
    public int d;
    public boolean e;
    public int f;
    public int g;
    public boolean h;
    public g i;
    public int j;
    public boolean k;
    public j l;
    public boolean m;
    public BottomSheetBehavior<V>.e n;
    public ValueAnimator o;
    public int p;
    public int q;
    public int r;
    public float s;
    public int t;
    public float u;
    public boolean v;
    public boolean w;
    public boolean x;
    public int y;
    public b.j.b.e z;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f943b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f944c;

        public a(View view, int i) {
            this.f943b = view;
            this.f944c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.L(this.f943b, this.f944c);
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.c {
        public b() {
        }

        @Override // b.j.b.e.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // b.j.b.e.c
        public int b(View view, int i, int i2) {
            int G = BottomSheetBehavior.this.G();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return b.h.b.a.i(i, G, bottomSheetBehavior.v ? bottomSheetBehavior.F : bottomSheetBehavior.t);
        }

        @Override // b.j.b.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.v ? bottomSheetBehavior.F : bottomSheetBehavior.t;
        }

        @Override // b.j.b.e.c
        public void f(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.x) {
                    return;
                }
                bottomSheetBehavior.K(1);
            }
        }

        @Override // b.j.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.E(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.a.p) < java.lang.Math.abs(r8.getTop() - r7.a.r)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
            r9 = r7.a.p;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00b8, code lost:
            if (java.lang.Math.abs(r9 - r7.a.r) < java.lang.Math.abs(r9 - r7.a.t)) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00f0, code lost:
            if (r9 < java.lang.Math.abs(r9 - r10.t)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0102, code lost:
            if (java.lang.Math.abs(r9 - r1) < java.lang.Math.abs(r9 - r7.a.t)) goto L33;
         */
        @Override // b.j.b.e.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(android.view.View r8, float r9, float r10) {
            /*
                Method dump skipped, instructions count: 267
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.b.h(android.view.View, float, float):void");
        }

        @Override // b.j.b.e.c
        public boolean i(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.y;
            if (i2 != 1 && !bottomSheetBehavior.M) {
                if (i2 == 3 && bottomSheetBehavior.K == i) {
                    WeakReference<View> weakReference = bottomSheetBehavior.H;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                WeakReference<V> weakReference2 = BottomSheetBehavior.this.G;
                return weakReference2 != null && weakReference2.get() == view;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract void a(View view, float f);

        public abstract void b(View view, int i);
    }

    /* loaded from: classes.dex */
    public static class d extends b.j.a.a {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public final int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<d> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new d(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new d[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }
        }

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            boolean z = false;
            this.f = parcel.readInt() == 1;
            this.g = parcel.readInt() == 1;
            this.h = parcel.readInt() == 1 ? true : z;
        }

        public d(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.d = bottomSheetBehavior.y;
            this.e = bottomSheetBehavior.d;
            this.f = bottomSheetBehavior.f941b;
            this.g = bottomSheetBehavior.v;
            this.h = bottomSheetBehavior.w;
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
            parcel.writeInt(this.h ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f945b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f946c;
        public int d;

        public e(View view, int i) {
            this.f945b = view;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.j.b.e eVar = BottomSheetBehavior.this.z;
            if (eVar != null && eVar.i(true)) {
                View view = this.f945b;
                AtomicInteger atomicInteger = q.a;
                view.postOnAnimation(this);
            } else {
                BottomSheetBehavior.this.K(this.d);
            }
            this.f946c = false;
        }
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.f941b = true;
        this.n = null;
        this.s = 0.5f;
        this.u = -1.0f;
        this.x = true;
        this.y = 4;
        this.I = new ArrayList<>();
        this.O = -1;
        this.P = new b();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int dimensionPixelOffset;
        int i;
        this.a = 0;
        this.f941b = true;
        this.n = null;
        this.s = 0.5f;
        this.u = -1.0f;
        this.x = true;
        this.y = 4;
        this.I = new ArrayList<>();
        this.O = -1;
        this.P = new b();
        this.g = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.f757b);
        this.h = obtainStyledAttributes.hasValue(11);
        boolean hasValue = obtainStyledAttributes.hasValue(1);
        if (hasValue) {
            D(context, attributeSet, hasValue, c.c.a.a.a.f(context, obtainStyledAttributes, 1));
        } else {
            D(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ofFloat;
        ofFloat.setDuration(500L);
        this.o.addUpdateListener(new c.c.a.a.g.a(this));
        if (Build.VERSION.SDK_INT >= 21) {
            this.u = obtainStyledAttributes.getDimension(0, -1.0f);
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(7);
        if (peekValue == null || (i = peekValue.data) != -1) {
            I(obtainStyledAttributes.getDimensionPixelSize(7, -1));
        } else {
            I(i);
        }
        boolean z = obtainStyledAttributes.getBoolean(6, false);
        if (this.v != z) {
            this.v = z;
            if (!z && this.y == 5) {
                J(4);
            }
            P();
        }
        this.k = obtainStyledAttributes.getBoolean(10, false);
        boolean z2 = obtainStyledAttributes.getBoolean(4, true);
        if (this.f941b != z2) {
            this.f941b = z2;
            if (this.G != null) {
                B();
            }
            K((!this.f941b || this.y != 6) ? this.y : 3);
            P();
        }
        this.w = obtainStyledAttributes.getBoolean(9, false);
        this.x = obtainStyledAttributes.getBoolean(2, true);
        this.a = obtainStyledAttributes.getInt(8, 0);
        float f = obtainStyledAttributes.getFloat(5, 0.5f);
        if (f > 0.0f && f < 1.0f) {
            this.s = f;
            if (this.G != null) {
                this.r = (int) ((1.0f - f) * this.F);
            }
            TypedValue peekValue2 = obtainStyledAttributes.peekValue(3);
            if (peekValue2 == null || peekValue2.type != 16) {
                dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(3, 0);
                if (dimensionPixelOffset < 0) {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                dimensionPixelOffset = peekValue2.data;
                if (dimensionPixelOffset < 0) {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.p = dimensionPixelOffset;
            obtainStyledAttributes.recycle();
            this.f942c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.y == 1 && actionMasked == 0) {
            return true;
        }
        b.j.b.e eVar = this.z;
        if (eVar != null) {
            eVar.n(motionEvent);
        }
        if (actionMasked == 0) {
            this.K = -1;
            VelocityTracker velocityTracker = this.J;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.J = null;
            }
        }
        if (this.J == null) {
            this.J = VelocityTracker.obtain();
        }
        this.J.addMovement(motionEvent);
        if (this.z != null && actionMasked == 2 && !this.A) {
            float abs = Math.abs(this.L - motionEvent.getY());
            b.j.b.e eVar2 = this.z;
            if (abs > eVar2.f514b) {
                eVar2.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.A;
    }

    public final void B() {
        int C = C();
        if (this.f941b) {
            this.t = Math.max(this.F - C, this.q);
        } else {
            this.t = this.F - C;
        }
    }

    public final int C() {
        int i;
        return this.e ? Math.min(Math.max(this.f, this.F - ((this.E * 9) / 16)), this.D) : (this.k || (i = this.j) <= 0) ? this.d : Math.max(this.d, i + this.g);
    }

    public final void D(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.h) {
            this.l = j.b(context, attributeSet, R.attr.bottomSheetStyle, 2131690064).a();
            g gVar = new g(this.l);
            this.i = gVar;
            gVar.f876b.f878b = new c.c.a.a.n.a(context);
            gVar.w();
            if (z && colorStateList != null) {
                this.i.p(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.i.setTint(typedValue.data);
        }
    }

    public void E(int i) {
        float f;
        float f2;
        V v = this.G.get();
        if (v == null || this.I.isEmpty()) {
            return;
        }
        int i2 = this.t;
        if (i > i2 || i2 == G()) {
            int i3 = this.t;
            f = i3 - i;
            f2 = this.F - i3;
        } else {
            int i4 = this.t;
            f = i4 - i;
            f2 = i4 - G();
        }
        float f3 = f / f2;
        for (int i5 = 0; i5 < this.I.size(); i5++) {
            this.I.get(i5).a(v, f3);
        }
    }

    public View F(View view) {
        AtomicInteger atomicInteger = q.a;
        if (Build.VERSION.SDK_INT >= 21 ? view.isNestedScrollingEnabled() : view instanceof f ? ((f) view).isNestedScrollingEnabled() : false) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View F = F(viewGroup.getChildAt(i));
            if (F != null) {
                return F;
            }
        }
        return null;
    }

    public int G() {
        return this.f941b ? this.q : this.p;
    }

    public final void H(V v, b.a aVar, int i) {
        q.C(v, aVar, null, new c.c.a.a.g.c(this, i));
    }

    public void I(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.e) {
                this.e = true;
            }
            z = false;
        } else {
            if (this.e || this.d != i) {
                this.e = false;
                this.d = Math.max(0, i);
            }
            z = false;
        }
        if (z) {
            S(false);
        }
    }

    public void J(int i) {
        if (i == this.y) {
            return;
        }
        if (this.G != null) {
            M(i);
        } else if (i != 4 && i != 3 && i != 6 && (!this.v || i != 5)) {
        } else {
            this.y = i;
        }
    }

    public void K(int i) {
        V v;
        if (this.y == i) {
            return;
        }
        this.y = i;
        WeakReference<V> weakReference = this.G;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            R(true);
        } else if (i == 6 || i == 5 || i == 4) {
            R(false);
        }
        Q(i);
        for (int i2 = 0; i2 < this.I.size(); i2++) {
            this.I.get(i2).b(v, i);
        }
        P();
    }

    public void L(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.t;
        } else if (i == 6) {
            int i4 = this.r;
            if (!this.f941b || i4 > (i3 = this.q)) {
                i2 = i4;
            } else {
                i2 = i3;
                i = 3;
            }
        } else if (i == 3) {
            i2 = G();
        } else if (!this.v || i != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        } else {
            i2 = this.F;
        }
        O(view, i, i2, false);
    }

    public final void M(int i) {
        V v = this.G.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent == null || !parent.isLayoutRequested() || !q.t(v)) {
            L(v, i);
        } else {
            v.post(new a(v, i));
        }
    }

    public boolean N(View view, float f) {
        if (this.w) {
            return true;
        }
        if (view.getTop() < this.t) {
            return false;
        }
        return Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.t)) / ((float) C()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r7 != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r0.t(r5.getLeft(), r7) != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(android.view.View r5, int r6, int r7, boolean r8) {
        /*
            r4 = this;
            b.j.b.e r0 = r4.z
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L30
            if (r8 == 0) goto L13
            int r8 = r5.getLeft()
            boolean r7 = r0.t(r8, r7)
            if (r7 == 0) goto L30
            goto L2f
        L13:
            int r8 = r5.getLeft()
            r0.r = r5
            r3 = -1
            r0.f515c = r3
            boolean r7 = r0.l(r8, r7, r2, r2)
            if (r7 != 0) goto L2d
            int r8 = r0.a
            if (r8 != 0) goto L2d
            android.view.View r8 = r0.r
            if (r8 == 0) goto L2d
            r8 = 0
            r0.r = r8
        L2d:
            if (r7 == 0) goto L30
        L2f:
            r2 = 1
        L30:
            if (r2 == 0) goto L56
            r7 = 2
            r4.K(r7)
            r4.Q(r6)
            com.google.android.material.bottomsheet.BottomSheetBehavior<V>$e r7 = r4.n
            if (r7 != 0) goto L44
            com.google.android.material.bottomsheet.BottomSheetBehavior$e r7 = new com.google.android.material.bottomsheet.BottomSheetBehavior$e
            r7.<init>(r5, r6)
            r4.n = r7
        L44:
            com.google.android.material.bottomsheet.BottomSheetBehavior<V>$e r7 = r4.n
            boolean r8 = r7.f946c
            r7.d = r6
            if (r8 != 0) goto L59
            java.util.concurrent.atomic.AtomicInteger r6 = b.h.j.q.a
            r5.postOnAnimation(r7)
            com.google.android.material.bottomsheet.BottomSheetBehavior<V>$e r5 = r4.n
            r5.f946c = r1
            goto L59
        L56:
            r4.K(r6)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.O(android.view.View, int, int, boolean):void");
    }

    public final void P() {
        V v;
        b.a aVar;
        WeakReference<V> weakReference = this.G;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        q.A(v, 524288);
        q.A(v, 262144);
        q.A(v, 1048576);
        int i = this.O;
        if (i != -1) {
            q.A(v, i);
        }
        int i2 = 6;
        if (this.y != 6) {
            String string = v.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            c.c.a.a.g.c cVar = new c.c.a.a.g.c(this, 6);
            List<b.a> k = q.k(v);
            int i3 = 0;
            int i4 = -1;
            while (true) {
                int[] iArr = q.g;
                if (i3 >= iArr.length || i4 != -1) {
                    break;
                }
                int i5 = iArr[i3];
                boolean z = true;
                for (int i6 = 0; i6 < k.size(); i6++) {
                    z &= k.get(i6).a() != i5;
                }
                if (z) {
                    i4 = i5;
                }
                i3++;
            }
            if (i4 != -1) {
                q.a(v, new b.a(null, i4, string, cVar, null));
            }
            this.O = i4;
        }
        if (this.v && this.y != 5) {
            H(v, b.a.j, 5);
        }
        int i7 = this.y;
        if (i7 == 3) {
            if (this.f941b) {
                i2 = 4;
            }
            aVar = b.a.i;
        } else if (i7 != 4) {
            if (i7 != 6) {
                return;
            }
            H(v, b.a.i, 4);
            H(v, b.a.h, 3);
            return;
        } else {
            if (this.f941b) {
                i2 = 3;
            }
            aVar = b.a.h;
        }
        H(v, aVar, i2);
    }

    public final void Q(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.m == z) {
            return;
        }
        this.m = z;
        if (this.i == null || (valueAnimator = this.o) == null) {
            return;
        }
        if (valueAnimator.isRunning()) {
            this.o.reverse();
            return;
        }
        float f = z ? 0.0f : 1.0f;
        this.o.setFloatValues(1.0f - f, f);
        this.o.start();
    }

    public final void R(boolean z) {
        WeakReference<V> weakReference = this.G;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (!(parent instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
        int childCount = coordinatorLayout.getChildCount();
        if (z) {
            if (this.N != null) {
                return;
            }
            this.N = new HashMap(childCount);
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = coordinatorLayout.getChildAt(i);
            if (childAt != this.G.get() && z) {
                this.N.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
            }
        }
        if (z) {
            return;
        }
        this.N = null;
    }

    public final void S(boolean z) {
        V v;
        if (this.G != null) {
            B();
            if (this.y != 4 || (v = this.G.get()) == null) {
                return;
            }
            if (z) {
                M(this.y);
            } else {
                v.requestLayout();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.G = null;
        this.z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.G = null;
        this.z = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        b.j.b.e eVar;
        if (v.isShown() && this.x) {
            int actionMasked = motionEvent.getActionMasked();
            View view = null;
            if (actionMasked == 0) {
                this.K = -1;
                VelocityTracker velocityTracker = this.J;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.J = null;
                }
            }
            if (this.J == null) {
                this.J = VelocityTracker.obtain();
            }
            this.J.addMovement(motionEvent);
            if (actionMasked == 0) {
                int x = (int) motionEvent.getX();
                this.L = (int) motionEvent.getY();
                if (this.y != 2) {
                    WeakReference<View> weakReference = this.H;
                    View view2 = weakReference != null ? weakReference.get() : null;
                    if (view2 != null && coordinatorLayout.p(view2, x, this.L)) {
                        this.K = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.M = true;
                    }
                }
                this.A = this.K == -1 && !coordinatorLayout.p(v, x, this.L);
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.M = false;
                this.K = -1;
                if (this.A) {
                    this.A = false;
                    return false;
                }
            }
            if (!this.A && (eVar = this.z) != null && eVar.u(motionEvent)) {
                return true;
            }
            WeakReference<View> weakReference2 = this.H;
            if (weakReference2 != null) {
                view = weakReference2.get();
            }
            return actionMasked == 2 && view != null && !this.A && this.y != 1 && !coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.z != null && Math.abs(((float) this.L) - motionEvent.getY()) > ((float) this.z.f514b);
        }
        this.A = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        int i2;
        g gVar;
        AtomicInteger atomicInteger = q.a;
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.G == null) {
            this.f = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 29 && !this.k && !this.e) {
                q.J(v, new l(new c.c.a.a.g.b(this), new o(q.q(v), v.getPaddingTop(), q.p(v), v.getPaddingBottom())));
                if (!q.t(v)) {
                    v.addOnAttachStateChangeListener(new m());
                } else if (i3 >= 20) {
                    v.requestApplyInsets();
                } else {
                    v.requestFitSystemWindows();
                }
            }
            this.G = new WeakReference<>(v);
            if (this.h && (gVar = this.i) != null) {
                v.setBackground(gVar);
            }
            g gVar2 = this.i;
            if (gVar2 != null) {
                float f = this.u;
                if (f == -1.0f) {
                    f = q.m(v);
                }
                gVar2.o(f);
                boolean z = this.y == 3;
                this.m = z;
                this.i.q(z ? 0.0f : 1.0f);
            }
            P();
            if (v.getImportantForAccessibility() == 0) {
                q.I(v, 1);
            }
        }
        if (this.z == null) {
            this.z = new b.j.b.e(coordinatorLayout.getContext(), coordinatorLayout, this.P);
        }
        int top = v.getTop();
        coordinatorLayout.r(v, i);
        this.E = coordinatorLayout.getWidth();
        this.F = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.D = height;
        this.q = Math.max(0, this.F - height);
        this.r = (int) ((1.0f - this.s) * this.F);
        B();
        int i4 = this.y;
        if (i4 == 3) {
            i2 = G();
        } else if (i4 == 6) {
            i2 = this.r;
        } else if (this.v && i4 == 5) {
            i2 = this.F;
        } else if (i4 != 4) {
            if (i4 == 1 || i4 == 2) {
                q.x(v, top - v.getTop());
            }
            this.H = new WeakReference<>(F(v));
            return true;
        } else {
            i2 = this.t;
        }
        q.x(v, i2);
        this.H = new WeakReference<>(F(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.H;
        return (weakReference == null || view != weakReference.get() || this.y == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.H;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i2;
        if (i2 > 0) {
            if (i5 < G()) {
                iArr[1] = top - G();
                q.x(v, -iArr[1]);
                i4 = 3;
                K(i4);
            } else if (!this.x) {
                return;
            } else {
                iArr[1] = i2;
                q.x(v, -i2);
                K(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.t;
            if (i5 > i6 && !this.v) {
                iArr[1] = top - i6;
                q.x(v, -iArr[1]);
                i4 = 4;
                K(i4);
            } else if (!this.x) {
                return;
            } else {
                iArr[1] = i2;
                q.x(v, -i2);
                K(1);
            }
        }
        E(v.getTop());
        this.B = i2;
        this.C = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        d dVar = (d) parcelable;
        int i = this.a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.d = dVar.e;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f941b = dVar.f;
            }
            if (i == -1 || (i & 4) == 4) {
                this.v = dVar.g;
            }
            if (i == -1 || (i & 8) == 8) {
                this.w = dVar.h;
            }
        }
        int i2 = dVar.d;
        if (i2 == 1 || i2 == 2) {
            this.y = 4;
        } else {
            this.y = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
        return new d((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.B = 0;
        this.C = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        if (r2 > r4) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
        if (java.lang.Math.abs(r2 - r1.q) < java.lang.Math.abs(r2 - r1.t)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0081, code lost:
        if (r2 < java.lang.Math.abs(r2 - r1.t)) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0083, code lost:
        r2 = r1.p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0093, code lost:
        if (java.lang.Math.abs(r2 - r4) < java.lang.Math.abs(r2 - r1.t)) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ae, code lost:
        if (java.lang.Math.abs(r2 - r1.r) < java.lang.Math.abs(r2 - r1.t)) goto L43;
     */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void z(androidx.coordinatorlayout.widget.CoordinatorLayout r2, V r3, android.view.View r4, int r5) {
        /*
            r1 = this;
            int r2 = r3.getTop()
            int r5 = r1.G()
            r0 = 3
            if (r2 != r5) goto Lf
            r1.K(r0)
            return
        Lf:
            java.lang.ref.WeakReference<android.view.View> r2 = r1.H
            if (r2 == 0) goto Lbe
            java.lang.Object r2 = r2.get()
            if (r4 != r2) goto Lbe
            boolean r2 = r1.C
            if (r2 != 0) goto L1f
            goto Lbe
        L1f:
            int r2 = r1.B
            if (r2 <= 0) goto L32
            boolean r2 = r1.f941b
            if (r2 == 0) goto L28
            goto L72
        L28:
            int r2 = r3.getTop()
            int r4 = r1.r
            if (r2 <= r4) goto L83
            goto Lb2
        L32:
            boolean r2 = r1.v
            if (r2 == 0) goto L55
            android.view.VelocityTracker r2 = r1.J
            if (r2 != 0) goto L3c
            r2 = 0
            goto L4b
        L3c:
            r4 = 1000(0x3e8, float:1.401E-42)
            float r5 = r1.f942c
            r2.computeCurrentVelocity(r4, r5)
            android.view.VelocityTracker r2 = r1.J
            int r4 = r1.K
            float r2 = r2.getYVelocity(r4)
        L4b:
            boolean r2 = r1.N(r3, r2)
            if (r2 == 0) goto L55
            int r2 = r1.F
            r0 = 5
            goto Lb8
        L55:
            int r2 = r1.B
            if (r2 != 0) goto L96
            int r2 = r3.getTop()
            boolean r4 = r1.f941b
            if (r4 == 0) goto L75
            int r4 = r1.q
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.t
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lb5
        L72:
            int r2 = r1.q
            goto Lb8
        L75:
            int r4 = r1.r
            if (r2 >= r4) goto L86
            int r4 = r1.t
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r2 >= r4) goto Lb0
        L83:
            int r2 = r1.p
            goto Lb8
        L86:
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.t
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lb5
            goto Lb0
        L96:
            boolean r2 = r1.f941b
            if (r2 == 0) goto L9b
            goto Lb5
        L9b:
            int r2 = r3.getTop()
            int r4 = r1.r
            int r4 = r2 - r4
            int r4 = java.lang.Math.abs(r4)
            int r5 = r1.t
            int r2 = r2 - r5
            int r2 = java.lang.Math.abs(r2)
            if (r4 >= r2) goto Lb5
        Lb0:
            int r4 = r1.r
        Lb2:
            r0 = 6
            r2 = r4
            goto Lb8
        Lb5:
            int r2 = r1.t
            r0 = 4
        Lb8:
            r4 = 0
            r1.O(r3, r0, r2, r4)
            r1.C = r4
        Lbe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }
}
