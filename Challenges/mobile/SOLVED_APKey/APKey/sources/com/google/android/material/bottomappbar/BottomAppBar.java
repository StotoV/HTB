package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.q;
import c.c.a.a.f.b;
import c.c.a.a.f.c;
import c.c.a.a.f.d;
import c.c.a.a.f.f;
import c.c.a.a.f.g;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final /* synthetic */ int a0 = 0;
    public Animator O;
    public Animator P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public int U;
    public boolean V;
    public Behavior W;

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public final Rect e;
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h;

        /* loaded from: classes.dex */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (Behavior.this.f.get() != null && (view instanceof FloatingActionButton)) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    Behavior.this.e.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                    throw null;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.h = new a();
            this.e = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.h = new a();
            this.e = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f = new WeakReference<>(bottomAppBar);
            int i2 = BottomAppBar.a0;
            View z = bottomAppBar.z();
            if (z != null && !q.u(z)) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) z.getLayoutParams();
                fVar.d = 49;
                this.g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                if (z instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) z;
                    floatingActionButton.addOnLayoutChangeListener(this.h);
                    floatingActionButton.d(null);
                    floatingActionButton.e(new f(bottomAppBar));
                    floatingActionButton.f(null);
                }
                bottomAppBar.D();
                throw null;
            }
            coordinatorLayout.r(bottomAppBar, i);
            this.a = bottomAppBar.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar.getLayoutParams()).bottomMargin;
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (((BottomAppBar) view).getHideOnScroll()) {
                if (i == 2) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends b.j.a.a {
        public static final Parcelable.Creator<a> CREATOR = new C0046a();
        public int d;
        public boolean e;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0046a implements Parcelable.ClassLoaderCreator<a> {
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
            this.e = parcel.readInt() != 0;
        }

        public a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return 0;
    }

    private float getFabTranslationX() {
        return B(this.Q);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().d;
    }

    private int getLeftInset() {
        return 0;
    }

    private int getRightInset() {
        return 0;
    }

    private g getTopEdgeTreatment() {
        throw null;
    }

    public static void w(BottomAppBar bottomAppBar) {
        bottomAppBar.T--;
    }

    public int A(ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean k = c.c.a.a.a.k(this);
        int measuredWidth = k ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                measuredWidth = k ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        return measuredWidth - ((k ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    public final float B(int i) {
        boolean k = c.c.a.a.a.k(this);
        int i2 = 1;
        if (i == 1) {
            int measuredWidth = (getMeasuredWidth() / 2) + 0;
            if (k) {
                i2 = -1;
            }
            return measuredWidth * i2;
        }
        return 0.0f;
    }

    public final boolean C() {
        FloatingActionButton y = y();
        return y != null && y.k();
    }

    public final void D() {
        getTopEdgeTreatment().e = getFabTranslationX();
        z();
        if (this.V) {
            C();
        }
        throw null;
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /* renamed from: getBehavior  reason: collision with other method in class */
    public Behavior mo8getBehavior() {
        if (this.W == null) {
            this.W = new Behavior();
        }
        return this.W;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d;
    }

    public int getFabAlignmentMode() {
        return this.Q;
    }

    public int getFabAnimationMode() {
        return this.R;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f785c;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().f784b;
    }

    public boolean getHideOnScroll() {
        return this.S;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int A;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.P;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.O;
            if (animator2 != null) {
                animator2.cancel();
            }
            D();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.P != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (!C()) {
            A = A(actionMenuView, 0, false);
        } else {
            A = A(actionMenuView, this.Q, this.V);
        }
        actionMenuView.setTranslationX(A);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.f510b);
        this.Q = aVar.d;
        this.V = aVar.e;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.d = this.Q;
        aVar.e = this.V;
        return aVar;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        b.h.b.a.g0(null, colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            g topEdgeTreatment = getTopEdgeTreatment();
            topEdgeTreatment.getClass();
            if (f >= 0.0f) {
                topEdgeTreatment.d = f;
                throw null;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        int i2;
        this.U = 0;
        boolean z = this.V;
        if (!q.u(this)) {
            int i3 = this.U;
            if (i3 != 0) {
                this.U = 0;
                getMenu().clear();
                n(i3);
            }
        } else {
            Animator animator = this.P;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!C()) {
                z = false;
                i2 = 0;
            } else {
                i2 = i;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - A(actionMenuView, i2, z)) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.addListener(new d(this, actionMenuView, i2, z));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150L);
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.P = animatorSet2;
            animatorSet2.addListener(new c(this));
            this.P.start();
        }
        if (this.Q != i && q.u(this)) {
            Animator animator2 = this.O;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.R == 1) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(y(), "translationX", B(i));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                x(i);
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.O = animatorSet3;
            animatorSet3.addListener(new c.c.a.a.f.a(this));
            this.O.start();
        }
        this.Q = i;
    }

    public void setFabAnimationMode(int i) {
        this.R = i;
    }

    public void setFabCradleMargin(float f) {
        if (f == getFabCradleMargin()) {
            return;
        }
        getTopEdgeTreatment().f785c = f;
        throw null;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f == getFabCradleRoundedCornerRadius()) {
            return;
        }
        getTopEdgeTreatment().f784b = f;
        throw null;
    }

    public void setHideOnScroll(boolean z) {
        this.S = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void x(int i) {
        FloatingActionButton y = y();
        if (y == null || y.j()) {
            return;
        }
        this.T++;
        y.i(new b(this, i), true);
    }

    public final FloatingActionButton y() {
        View z = z();
        if (z instanceof FloatingActionButton) {
            return (FloatingActionButton) z;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View z() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.k(r4)
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L2c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L18
        L2c:
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.z():android.view.View");
    }
}
