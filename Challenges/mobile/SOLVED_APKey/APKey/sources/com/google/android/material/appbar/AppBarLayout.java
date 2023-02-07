package com.google.android.material.appbar;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.c0.b;
import b.h.j.f;
import b.h.j.q;
import c.c.a.a.d.b;
import c.c.a.a.d.c;
import c.c.a.a.d.d;
import c.c.a.a.d.e;
import c.c.a.a.u.g;
import com.example.apkey.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: b  reason: collision with root package name */
    public int f930b;

    /* renamed from: c  reason: collision with root package name */
    public int f931c;
    public int d;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public WeakReference<View> l;
    public ValueAnimator m;
    public int[] n;
    public Drawable o;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends e<T> {
        public int j;
        public int k;
        public ValueAnimator l;
        public int m;
        public boolean n;
        public float o;
        public WeakReference<View> p;

        /* loaded from: classes.dex */
        public static class a extends b.j.a.a {
            public static final Parcelable.Creator<a> CREATOR = new C0045a();
            public int d;
            public float e;
            public boolean f;

            /* renamed from: com.google.android.material.appbar.AppBarLayout$BaseBehavior$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static class C0045a implements Parcelable.ClassLoaderCreator<a> {
                @Override // android.os.Parcelable.Creator
                public Object createFromParcel(Parcel parcel) {
                    return new a(parcel, null);
                }

                @Override // android.os.Parcelable.Creator
                public Object[] newArray(int i) {
                    return new a[i];
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new a(parcel, classLoader);
                }
            }

            public a(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.d = parcel.readInt();
                this.e = parcel.readFloat();
                this.f = parcel.readByte() != 0;
            }

            public a(Parcelable parcelable) {
                super(parcelable);
            }

            @Override // b.j.a.a, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeParcelable(this.f510b, i);
                parcel.writeInt(this.d);
                parcel.writeFloat(this.e);
                parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
            }
        }

        public BaseBehavior() {
            this.m = -1;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.m = -1;
        }

        public static boolean J(int i, int i2) {
            return (i & i2) == i2;
        }

        @Override // c.c.a.a.d.e
        public int E() {
            return B() + this.j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.c.a.a.d.e
        public int H(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            int i4;
            ArrayList<View> orDefault;
            int i5;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int E = E();
            int i6 = 0;
            if (i2 == 0 || E < i2 || E > i3) {
                this.j = 0;
            } else {
                int i7 = b.h.b.a.i(i, i2, i3);
                if (E != i7) {
                    if (appBarLayout.f) {
                        int abs = Math.abs(i7);
                        int childCount = appBarLayout.getChildCount();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i8);
                            a aVar = (a) childAt.getLayoutParams();
                            Interpolator interpolator = aVar.f932b;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i8++;
                            } else if (interpolator != null) {
                                int i9 = aVar.a;
                                if ((i9 & 1) != 0) {
                                    i5 = childAt.getHeight() + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + 0;
                                    if ((i9 & 2) != 0) {
                                        AtomicInteger atomicInteger = q.a;
                                        i5 -= childAt.getMinimumHeight();
                                    }
                                } else {
                                    i5 = 0;
                                }
                                AtomicInteger atomicInteger2 = q.a;
                                if (childAt.getFitsSystemWindows()) {
                                    i5 -= appBarLayout.getTopInset();
                                }
                                if (i5 > 0) {
                                    float f = i5;
                                    i4 = (childAt.getTop() + Math.round(interpolator.getInterpolation((abs - childAt.getTop()) / f) * f)) * Integer.signum(i7);
                                }
                            }
                        }
                    }
                    i4 = i7;
                    boolean D = D(i4);
                    int i10 = E - i7;
                    this.j = i7 - i4;
                    if (!D && appBarLayout.f && (orDefault = coordinatorLayout.f58c.f392b.getOrDefault(appBarLayout, null)) != null && !orDefault.isEmpty()) {
                        while (i6 < orDefault.size()) {
                            View view2 = orDefault.get(i6);
                            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).a;
                            if (cVar != null) {
                                cVar.g(coordinatorLayout, view2, appBarLayout);
                            }
                            i6++;
                        }
                    }
                    appBarLayout.f930b = B();
                    if (!appBarLayout.willNotDraw()) {
                        AtomicInteger atomicInteger3 = q.a;
                        appBarLayout.postInvalidateOnAnimation();
                    }
                    Q(coordinatorLayout, appBarLayout, i7, i7 < E ? -1 : 1, false);
                    i6 = i10;
                }
            }
            P(coordinatorLayout, appBarLayout);
            return i6;
        }

        public final void I(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int abs = Math.abs(E() - i);
            float abs2 = Math.abs(f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            int E = E();
            if (E == i) {
                ValueAnimator valueAnimator = this.l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.l = valueAnimator3;
                valueAnimator3.setInterpolator(c.c.a.a.c.a.e);
                this.l.addUpdateListener(new b(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.l.setDuration(Math.min(round, 600));
            this.l.setIntValues(E, i);
            this.l.start();
        }

        public final View K(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof f) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        public void L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr) {
            int i2;
            int i3;
            if (i != 0) {
                if (i < 0) {
                    int i4 = -appBarLayout.getTotalScrollRange();
                    i2 = i4;
                    i3 = appBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i2 = -appBarLayout.getUpNestedPreScrollRange();
                    i3 = 0;
                }
                if (i2 != i3) {
                    iArr[1] = F(coordinatorLayout, appBarLayout, i, i2, i3);
                }
            }
            if (appBarLayout.j) {
                appBarLayout.c(appBarLayout.d(view));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void M(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int[] iArr) {
            if (i < 0) {
                iArr[1] = F(coordinatorLayout, appBarLayout, i, -appBarLayout.getDownNestedScrollRange(), 0);
            }
            if (i == 0) {
                P(coordinatorLayout, appBarLayout);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
            if (((r4.getTotalScrollRange() != 0) && r3.getHeight() - r5.getHeight() <= r4.getHeight()) != false) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean N(androidx.coordinatorlayout.widget.CoordinatorLayout r3, com.google.android.material.appbar.AppBarLayout r4, android.view.View r5, int r6, int r7) {
            /*
                r2 = this;
                r6 = r6 & 2
                r0 = 1
                r1 = 0
                if (r6 == 0) goto L2a
                boolean r6 = r4.j
                if (r6 != 0) goto L2b
                int r6 = r4.getTotalScrollRange()
                if (r6 == 0) goto L12
                r6 = 1
                goto L13
            L12:
                r6 = 0
            L13:
                if (r6 == 0) goto L26
                int r3 = r3.getHeight()
                int r5 = r5.getHeight()
                int r3 = r3 - r5
                int r4 = r4.getHeight()
                if (r3 > r4) goto L26
                r3 = 1
                goto L27
            L26:
                r3 = 0
            L27:
                if (r3 == 0) goto L2a
                goto L2b
            L2a:
                r0 = 0
            L2b:
                if (r0 == 0) goto L34
                android.animation.ValueAnimator r3 = r2.l
                if (r3 == 0) goto L34
                r3.cancel()
            L34:
                r3 = 0
                r2.p = r3
                r2.k = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.N(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int):boolean");
        }

        public final void O(CoordinatorLayout coordinatorLayout, T t) {
            int E = E();
            int childCount = t.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = t.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                a aVar = (a) childAt.getLayoutParams();
                if (J(aVar.a, 32)) {
                    top -= ((LinearLayout.LayoutParams) aVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) aVar).bottomMargin;
                }
                int i2 = -E;
                if (top <= i2 && bottom >= i2) {
                    break;
                }
                i++;
            }
            if (i >= 0) {
                View childAt2 = t.getChildAt(i);
                a aVar2 = (a) childAt2.getLayoutParams();
                int i3 = aVar2.a;
                if ((i3 & 17) != 17) {
                    return;
                }
                int i4 = -childAt2.getTop();
                int i5 = -childAt2.getBottom();
                if (i == t.getChildCount() - 1) {
                    i5 += t.getTopInset();
                }
                if (J(i3, 2)) {
                    AtomicInteger atomicInteger = q.a;
                    i5 += childAt2.getMinimumHeight();
                } else if (J(i3, 5)) {
                    AtomicInteger atomicInteger2 = q.a;
                    int minimumHeight = childAt2.getMinimumHeight() + i5;
                    if (E < minimumHeight) {
                        i4 = minimumHeight;
                    } else {
                        i5 = minimumHeight;
                    }
                }
                if (J(i3, 32)) {
                    i4 += ((LinearLayout.LayoutParams) aVar2).topMargin;
                    i5 -= ((LinearLayout.LayoutParams) aVar2).bottomMargin;
                }
                if (E < (i5 + i4) / 2) {
                    i4 = i5;
                }
                I(coordinatorLayout, t, b.h.b.a.i(i4, -t.getTotalScrollRange(), 0), 0.0f);
            }
        }

        public final void P(CoordinatorLayout coordinatorLayout, T t) {
            b.a aVar = b.a.f;
            q.A(coordinatorLayout, aVar.a());
            b.a aVar2 = b.a.g;
            q.A(coordinatorLayout, aVar2.a());
            View K = K(coordinatorLayout);
            if (K == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) K.getLayoutParams()).a instanceof ScrollingViewBehavior)) {
                return;
            }
            if (E() != (-t.getTotalScrollRange()) && K.canScrollVertically(1)) {
                q.C(coordinatorLayout, aVar, null, new d(this, t, false));
            }
            if (E() == 0) {
                return;
            }
            if (!K.canScrollVertically(-1)) {
                q.C(coordinatorLayout, aVar2, null, new d(this, t, true));
                return;
            }
            int i = -t.getDownNestedPreScrollRange();
            if (i == 0) {
                return;
            }
            q.C(coordinatorLayout, aVar2, null, new c(this, coordinatorLayout, t, K, i));
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void Q(androidx.coordinatorlayout.widget.CoordinatorLayout r7, T r8, int r9, int r10, boolean r11) {
            /*
                r6 = this;
                int r0 = java.lang.Math.abs(r9)
                int r1 = r8.getChildCount()
                r2 = 0
                r3 = 0
            La:
                if (r3 >= r1) goto L20
                android.view.View r4 = r8.getChildAt(r3)
                int r5 = r4.getTop()
                if (r0 < r5) goto L1d
                int r5 = r4.getBottom()
                if (r0 > r5) goto L1d
                goto L21
            L1d:
                int r3 = r3 + 1
                goto La
            L20:
                r4 = 0
            L21:
                if (r4 == 0) goto L9f
                android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$a r0 = (com.google.android.material.appbar.AppBarLayout.a) r0
                int r0 = r0.a
                r1 = r0 & 1
                r3 = 1
                if (r1 == 0) goto L5d
                java.util.concurrent.atomic.AtomicInteger r1 = b.h.j.q.a
                int r1 = r4.getMinimumHeight()
                if (r10 <= 0) goto L4a
                r10 = r0 & 12
                if (r10 == 0) goto L4a
                int r9 = -r9
                int r10 = r4.getBottom()
                int r10 = r10 - r1
                int r0 = r8.getTopInset()
                int r10 = r10 - r0
                if (r9 < r10) goto L5d
                goto L5b
            L4a:
                r10 = r0 & 2
                if (r10 == 0) goto L5d
                int r9 = -r9
                int r10 = r4.getBottom()
                int r10 = r10 - r1
                int r0 = r8.getTopInset()
                int r10 = r10 - r0
                if (r9 < r10) goto L5d
            L5b:
                r9 = 1
                goto L5e
            L5d:
                r9 = 0
            L5e:
                boolean r10 = r8.j
                if (r10 == 0) goto L6a
                android.view.View r9 = r6.K(r7)
                boolean r9 = r8.d(r9)
            L6a:
                boolean r9 = r8.c(r9)
                if (r11 != 0) goto L9c
                if (r9 == 0) goto L9f
                java.util.List r7 = r7.k(r8)
                int r9 = r7.size()
                r10 = 0
            L7b:
                if (r10 >= r9) goto L9a
                java.lang.Object r11 = r7.get(r10)
                android.view.View r11 = (android.view.View) r11
                android.view.ViewGroup$LayoutParams r11 = r11.getLayoutParams()
                androidx.coordinatorlayout.widget.CoordinatorLayout$f r11 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r11
                androidx.coordinatorlayout.widget.CoordinatorLayout$c r11 = r11.a
                boolean r0 = r11 instanceof com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
                if (r0 == 0) goto L97
                com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior r11 = (com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior) r11
                int r7 = r11.f
                if (r7 == 0) goto L9a
                r2 = 1
                goto L9a
            L97:
                int r10 = r10 + 1
                goto L7b
            L9a:
                if (r2 == 0) goto L9f
            L9c:
                r8.jumpDrawablesToCurrentState()
            L9f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.Q(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.c.a.a.d.g, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.k(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i2 = this.m;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -childAt.getBottom();
                G(coordinatorLayout, appBarLayout, this.n ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3 : Math.round(childAt.getHeight() * this.o) + i3);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -appBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        I(coordinatorLayout, appBarLayout, i4, 0.0f);
                    } else {
                        G(coordinatorLayout, appBarLayout, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        I(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        G(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.g = 0;
            this.m = -1;
            D(b.h.b.a.i(B(), -appBarLayout.getTotalScrollRange(), 0));
            Q(coordinatorLayout, appBarLayout, B(), 0, true);
            appBarLayout.f930b = B();
            if (!appBarLayout.willNotDraw()) {
                AtomicInteger atomicInteger = q.a;
                appBarLayout.postInvalidateOnAnimation();
            }
            P(coordinatorLayout, appBarLayout);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) appBarLayout.getLayoutParams())).height == -2) {
                coordinatorLayout.s(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            L(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void r(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            M(coordinatorLayout, (AppBarLayout) view, i4, iArr);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void u(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (!(parcelable instanceof a)) {
                this.m = -1;
                return;
            }
            a aVar = (a) parcelable;
            this.m = aVar.d;
            this.o = aVar.e;
            this.n = aVar.f;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public Parcelable v(CoordinatorLayout coordinatorLayout, View view) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            int B = B();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + B;
                if (childAt.getTop() + B <= 0 && bottom >= 0) {
                    a aVar = new a(absSavedState);
                    aVar.d = i;
                    AtomicInteger atomicInteger = q.a;
                    if (bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight()) {
                        z = true;
                    }
                    aVar.f = z;
                    aVar.e = bottom / childAt.getHeight();
                    return aVar;
                }
            }
            return absSavedState;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return N(coordinatorLayout, (AppBarLayout) view, view2, i, i2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void z(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.k == 0 || i == 1) {
                O(coordinatorLayout, appBarLayout);
                if (appBarLayout.j) {
                    appBarLayout.c(appBarLayout.d(view2));
                }
            }
            this.p = new WeakReference<>(view2);
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends c.c.a.a.d.f {
        public ScrollingViewBehavior() {
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.w);
            this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }

        public AppBarLayout F(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) view2.getLayoutParams()).a;
            if (cVar instanceof BaseBehavior) {
                q.x(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVar).j) + this.e) - E(view2));
            }
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (!appBarLayout.j) {
                    return false;
                }
                appBarLayout.c(appBarLayout.d(view));
                return false;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                q.A(coordinatorLayout, b.a.f.a());
                q.A(coordinatorLayout, b.a.g.a());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean t(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout F = F(coordinatorLayout.j(view));
            if (F != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f775c;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    F.b(false, !z);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Interpolator f932b;

        public a(int i, int i2) {
            super(i, i2);
            this.a = 1;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.a);
            this.a = obtainStyledAttributes.getInt(0, 0);
            if (obtainStyledAttributes.hasValue(1)) {
                this.f932b = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(1, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public a(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public a mo7generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) ? layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams) : new a((LinearLayout.LayoutParams) layoutParams);
    }

    public void b(boolean z, boolean z2) {
        this.g = (z ? 1 : 2) | (z2 ? 4 : 0) | 8;
        requestLayout();
    }

    public boolean c(boolean z) {
        if (this.i != z) {
            this.i = z;
            refreshDrawableState();
            if (this.j && (getBackground() instanceof g)) {
                g gVar = (g) getBackground();
                float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
                float f = z ? 0.0f : dimension;
                if (!z) {
                    dimension = 0.0f;
                }
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(f, dimension);
                this.m = ofFloat;
                ofFloat.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
                this.m.setInterpolator(c.c.a.a.c.a.a);
                this.m.addUpdateListener(new c.c.a.a.d.a(this, gVar));
                this.m.start();
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public boolean d(View view) {
        int i;
        View view2 = null;
        if (this.l == null && (i = this.k) != -1) {
            View findViewById = view != null ? view.findViewById(i) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.k);
            }
            if (findViewById != null) {
                this.l = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            view2 = weakReference.get();
        }
        if (view2 != null) {
            view = view2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.o != null && getTopInset() > 0) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f930b);
            this.o.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.o;
        if (drawable == null || !drawable.isStateful() || !drawable.setState(drawableState)) {
            return;
        }
        invalidateDrawable(drawable);
    }

    public final boolean e() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() == 8) {
                return false;
            }
            AtomicInteger atomicInteger = q.a;
            return !childAt.getFitsSystemWindows();
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /* renamed from: getBehavior */
    public CoordinatorLayout.c<AppBarLayout> mo8getBehavior() {
        return new Behavior();
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int i2 = this.d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = aVar.a;
            if ((i4 & 5) == 5) {
                int i5 = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                if ((i4 & 8) != 0) {
                    AtomicInteger atomicInteger = q.a;
                    i = i5 + childAt.getMinimumHeight();
                } else if ((i4 & 2) != 0) {
                    AtomicInteger atomicInteger2 = q.a;
                    i = i5 + (measuredHeight - childAt.getMinimumHeight());
                } else {
                    i = i5 + measuredHeight;
                }
                if (childCount == 0) {
                    AtomicInteger atomicInteger3 = q.a;
                    if (childAt.getFitsSystemWindows()) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                }
                i3 += i;
            } else if (i3 > 0) {
                break;
            }
        }
        int max = Math.max(0, i3);
        this.d = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + childAt.getMeasuredHeight();
            int i4 = aVar.a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                AtomicInteger atomicInteger = q.a;
                i3 -= childAt.getMinimumHeight();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.e = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.k;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        AtomicInteger atomicInteger = q.a;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.g;
    }

    public Drawable getStatusBarForeground() {
        return this.o;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f931c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            a aVar = (a) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = aVar.a;
            if ((i4 & 1) == 0) {
                break;
            }
            int i5 = measuredHeight + ((LinearLayout.LayoutParams) aVar).topMargin + ((LinearLayout.LayoutParams) aVar).bottomMargin + i3;
            if (i2 == 0) {
                AtomicInteger atomicInteger = q.a;
                if (childAt.getFitsSystemWindows()) {
                    i5 -= getTopInset();
                }
            }
            i3 = i5;
            if ((i4 & 2) != 0) {
                AtomicInteger atomicInteger2 = q.a;
                i3 -= childAt.getMinimumHeight();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.f931c = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            c.c.a.a.a.t(this, (g) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.n == null) {
            this.n = new int[4];
        }
        int[] iArr = this.n;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.h;
        iArr[0] = z ? R.attr.state_liftable : -2130903758;
        iArr[1] = (!z || !this.i) ? -2130903759 : R.attr.state_lifted;
        iArr[2] = z ? R.attr.state_collapsible : -2130903756;
        iArr[3] = (!z || !this.i) ? -2130903755 : R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.l = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        super.onLayout(z, i, i2, i3, i4);
        AtomicInteger atomicInteger = q.a;
        boolean z3 = true;
        if (getFitsSystemWindows() && e()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                q.x(getChildAt(childCount), topInset);
            }
        }
        this.f931c = -1;
        this.d = -1;
        this.e = -1;
        this.f = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            } else if (((a) getChildAt(i5).getLayoutParams()).f932b != null) {
                this.f = true;
                break;
            } else {
                i5++;
            }
        }
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.j) {
            int childCount3 = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i7 = ((a) getChildAt(i6).getLayoutParams()).a;
                if ((i7 & 1) == 1 && (i7 & 10) != 0) {
                    z2 = true;
                    break;
                }
                i6++;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (this.h != z3) {
            this.h = z3;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            AtomicInteger atomicInteger = q.a;
            if (getFitsSystemWindows() && e()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = b.h.b.a.i(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        this.f931c = -1;
        this.d = -1;
        this.e = -1;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c.c.a.a.a.s(this, f);
    }

    public void setExpanded(boolean z) {
        b(z, q.u(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.j = z;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.k = i;
        WeakReference<View> weakReference = this.l;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.l = null;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.o = drawable3;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.o.setState(getDrawableState());
                }
                b.h.b.a.Y(this.o, q.o(this));
                this.o.setVisible(getVisibility() == 0, false);
                this.o.setCallback(this);
            }
            if (this.o != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            AtomicInteger atomicInteger = q.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(b.b.d.a.a.b(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            int integer = getResources().getInteger(R.integer.app_bar_elevation_anim_duration);
            StateListAnimator stateListAnimator = new StateListAnimator();
            long j = integer;
            stateListAnimator.addState(new int[]{16842766, R.attr.state_liftable, -2130903759}, ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(j));
            stateListAnimator.addState(new int[]{16842766}, ObjectAnimator.ofFloat(this, "elevation", f).setDuration(j));
            stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(this, "elevation", 0.0f).setDuration(0L));
            setStateListAnimator(stateListAnimator);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams mo5generateDefaultLayoutParams() {
        return new a(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: generateLayoutParams  reason: collision with other method in class */
    public LinearLayout.LayoutParams mo6generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }
}
