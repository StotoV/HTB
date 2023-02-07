package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import b.b.c.g;
import b.b.h.u;
import b.b.h.u0;
import b.b.h.v;
import b.h.j.b0;
import b.h.j.h;
import b.h.j.i;
import b.h.j.j;
import b.h.j.k;
import b.h.j.q;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements u, j, h, i {
    public static final int[] G = {R.attr.actionBarSize, 16842841};
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final k F;

    /* renamed from: b  reason: collision with root package name */
    public int f16b;

    /* renamed from: c  reason: collision with root package name */
    public int f17c;
    public ContentFrameLayout d;
    public ActionBarContainer e;
    public v f;
    public Drawable g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final Rect o;
    public final Rect p;
    public final Rect q;
    public final Rect r;
    public final Rect s;
    public final Rect t;
    public final Rect u;
    public b0 v;
    public b0 w;
    public b0 x;
    public b0 y;
    public d z;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.i();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.e.animate().translationY(-ActionBarOverlayLayout.this.e.getHeight()).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i, int i2) {
            super(i, i2);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17c = 0;
        this.o = new Rect();
        this.p = new Rect();
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        b0 b0Var = b0.f462b;
        this.v = b0Var;
        this.w = b0Var;
        this.x = b0Var;
        this.y = b0Var;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        j(context);
        this.F = new k();
    }

    @Override // b.h.j.h
    public void a(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // b.b.h.u
    public void b() {
        k();
        this.f.a();
    }

    @Override // b.h.j.i
    public void c(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // b.h.j.h
    public void d(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.g == null || this.h) {
            return;
        }
        if (this.e.getVisibility() == 0) {
            i = (int) (this.e.getTranslationY() + this.e.getBottom() + 0.5f);
        } else {
            i = 0;
        }
        this.g.setBounds(0, i, getWidth(), this.g.getIntrinsicHeight() + i);
        this.g.draw(canvas);
    }

    @Override // b.h.j.h
    public void e(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // b.h.j.h
    public void f(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        k();
        boolean h = h(this.e, rect, true, true, false, true);
        this.r.set(rect);
        u0.a(this, this.r, this.o);
        if (!this.s.equals(this.r)) {
            this.s.set(this.r);
            h = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
            h = true;
        }
        if (h) {
            requestLayout();
        }
        return true;
    }

    @Override // b.h.j.h
    public boolean g(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        k();
        return this.f.getTitle();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(android.view.View r3, android.graphics.Rect r4, boolean r5, boolean r6, boolean r7, boolean r8) {
        /*
            r2 = this;
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            androidx.appcompat.widget.ActionBarOverlayLayout$e r3 = (androidx.appcompat.widget.ActionBarOverlayLayout.e) r3
            r0 = 1
            if (r5 == 0) goto L13
            int r5 = r3.leftMargin
            int r1 = r4.left
            if (r5 == r1) goto L13
            r3.leftMargin = r1
            r5 = 1
            goto L14
        L13:
            r5 = 0
        L14:
            if (r6 == 0) goto L1f
            int r6 = r3.topMargin
            int r1 = r4.top
            if (r6 == r1) goto L1f
            r3.topMargin = r1
            r5 = 1
        L1f:
            if (r8 == 0) goto L2a
            int r6 = r3.rightMargin
            int r8 = r4.right
            if (r6 == r8) goto L2a
            r3.rightMargin = r8
            r5 = 1
        L2a:
            if (r7 == 0) goto L35
            int r6 = r3.bottomMargin
            int r4 = r4.bottom
            if (r6 == r4) goto L35
            r3.bottomMargin = r4
            goto L36
        L35:
            r0 = r5
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.h(android.view.View, android.graphics.Rect, boolean, boolean, boolean, boolean):boolean");
    }

    public void i() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void j(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z = false;
        this.f16b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.h = z;
        this.A = new OverScroller(context);
    }

    public void k() {
        v wrapper;
        if (this.d == null) {
            this.d = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.e = (ActionBarContainer) findViewById(R.id.action_bar_container);
            View findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof v) {
                wrapper = (v) findViewById;
            } else if (!(findViewById instanceof Toolbar)) {
                StringBuilder g = c.a.a.a.a.g("Can't make a decor toolbar out of ");
                g.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(g.toString());
            } else {
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.f = wrapper;
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        b0 i = b0.i(windowInsets, this);
        boolean h = h(this.e, new Rect(i.b(), i.d(), i.c(), i.a()), true, true, false, true);
        Rect rect = this.o;
        AtomicInteger atomicInteger = q.a;
        if (Build.VERSION.SDK_INT >= 21) {
            WindowInsets g = i.g();
            if (g != null) {
                b0.i(computeSystemWindowInsets(g, rect), this);
            } else {
                rect.setEmpty();
            }
        }
        Rect rect2 = this.o;
        b0 i2 = i.a.i(rect2.left, rect2.top, rect2.right, rect2.bottom);
        this.v = i2;
        boolean z = true;
        if (!this.w.equals(i2)) {
            this.w = this.v;
            h = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
        } else {
            z = h;
        }
        if (z) {
            requestLayout();
        }
        return i.a.a().a.c().a.b().g();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j(getContext());
        AtomicInteger atomicInteger = q.a;
        if (Build.VERSION.SDK_INT >= 20) {
            requestApplyInsets();
        } else {
            requestFitSystemWindows();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int measuredHeight;
        b0.e cVar;
        b0 a2;
        k();
        measureChildWithMargins(this.e, i, 0, i2, 0);
        e eVar = (e) this.e.getLayoutParams();
        int max = Math.max(0, this.e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.e.getMeasuredState());
        AtomicInteger atomicInteger = q.a;
        boolean z = (getWindowSystemUiVisibility() & 256) != 0;
        if (z) {
            measuredHeight = this.f16b;
            if (this.j && this.e.getTabContainer() != null) {
                measuredHeight += this.f16b;
            }
        } else {
            measuredHeight = this.e.getVisibility() != 8 ? this.e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 21) {
            this.x = this.v;
        } else {
            this.t.set(this.r);
        }
        if (!this.i && !z) {
            Rect rect = this.q;
            rect.top += measuredHeight;
            rect.bottom += 0;
            if (i3 >= 21) {
                a2 = this.x.a.i(0, measuredHeight, 0, 0);
                this.x = a2;
            }
        } else if (i3 >= 21) {
            b.h.d.b a3 = b.h.d.b.a(this.x.b(), this.x.d() + measuredHeight, this.x.c(), this.x.a() + 0);
            b0 b0Var = this.x;
            if (i3 >= 30) {
                cVar = new b0.d(b0Var);
            } else {
                cVar = i3 >= 29 ? new b0.c(b0Var) : i3 >= 20 ? new b0.b(b0Var) : new b0.e(b0Var);
            }
            cVar.c(a3);
            a2 = cVar.a();
            this.x = a2;
        } else {
            Rect rect2 = this.t;
            rect2.top += measuredHeight;
            rect2.bottom += 0;
        }
        h(this.d, this.q, true, true, true, true);
        if (i3 >= 21 && !this.y.equals(this.x)) {
            b0 b0Var2 = this.x;
            this.y = b0Var2;
            q.e(this.d, b0Var2);
        } else if (i3 < 21 && !this.u.equals(this.t)) {
            this.u.set(this.t);
            this.d.a(this.t);
        }
        measureChildWithMargins(this.d, i, 0, i2, 0);
        e eVar2 = (e) this.d.getLayoutParams();
        int max3 = Math.max(max, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.k || !z) {
            return false;
        }
        this.A.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.A.getFinalY() > this.e.getHeight()) {
            z2 = true;
        }
        if (z2) {
            i();
            this.E.run();
        } else {
            i();
            this.D.run();
        }
        this.l = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.m + i2;
        this.m = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onNestedScrollAccepted(View view, View view2, int i) {
        g gVar;
        b.b.g.d dVar;
        this.F.a = i;
        this.m = getActionBarHideOffset();
        i();
        d dVar2 = this.z;
        if (dVar2 == null || (dVar = (gVar = (g) dVar2).i) == null) {
            return;
        }
        dVar.a();
        gVar.i = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.e.getHeight()) {
                i();
                postDelayed(this.D, 600L);
            } else {
                i();
                postDelayed(this.E, 600L);
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            ((g) dVar).getClass();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i) {
        int i2 = Build.VERSION.SDK_INT;
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i3 = this.n ^ i;
        this.n = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        d dVar = this.z;
        if (dVar != null) {
            ((g) dVar).e = !z2;
            if (!z && z2) {
                g gVar = (g) dVar;
                if (!gVar.f) {
                    gVar.f = true;
                    gVar.a(true);
                }
            } else {
                g gVar2 = (g) dVar;
                if (gVar2.f) {
                    gVar2.f = false;
                    gVar2.a(true);
                }
            }
        }
        if ((i3 & 256) == 0 || this.z == null) {
            return;
        }
        AtomicInteger atomicInteger = q.a;
        if (i2 >= 20) {
            requestApplyInsets();
        } else {
            requestFitSystemWindows();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f17c = i;
        d dVar = this.z;
        if (dVar != null) {
            ((g) dVar).d = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        i();
        this.e.setTranslationY(-Math.max(0, Math.min(i, this.e.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.z = dVar;
        if (getWindowToken() != null) {
            ((g) this.z).d = this.f17c;
            int i = this.n;
            if (i == 0) {
                return;
            }
            onWindowSystemUiVisibilityChanged(i);
            AtomicInteger atomicInteger = q.a;
            if (Build.VERSION.SDK_INT >= 20) {
                requestApplyInsets();
            } else {
                requestFitSystemWindows();
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.j = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.k) {
            this.k = z;
            if (z) {
                return;
            }
            i();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        k();
        this.f.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        k();
        this.f.setIcon(drawable);
    }

    public void setLogo(int i) {
        k();
        this.f.b(i);
    }

    public void setOverlayMode(boolean z) {
        this.i = z;
        this.h = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        k();
        this.f.d(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        k();
        this.f.c(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
