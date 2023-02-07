package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.b.h.i;
import b.h.j.q;
import b.h.k.h;
import c.c.a.a.c.j;
import c.c.a.a.p.d;
import c.c.a.a.p.f;
import c.c.a.a.p.g;
import c.c.a.a.q.p;
import c.c.a.a.u.n;
import com.example.apkey.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingActionButton extends p implements b.h.j.p, h, c.c.a.a.o.a, n, CoordinatorLayout.b {

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f956c;
    public PorterDuff.Mode d;
    public ColorStateList e;
    public PorterDuff.Mode f;
    public ColorStateList g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public d l;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {
        public Rect a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f957b;

        public BaseBehavior() {
            this.f957b = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.h);
            this.f957b = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        }

        public boolean B(FloatingActionButton floatingActionButton, Rect rect) {
            floatingActionButton.getClass();
            floatingActionButton.getLeft();
            throw null;
        }

        public final boolean C(View view, FloatingActionButton floatingActionButton) {
            return this.f957b && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).f == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        public final boolean D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!C(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            c.c.a.a.q.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.m(null, false);
            return true;
        }

        public final boolean E(View view, FloatingActionButton floatingActionButton) {
            if (!C(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.i(null, false);
                return true;
            }
            floatingActionButton.m(null, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return B((FloatingActionButton) view, rect);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) {
                    E(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            List<View> j = coordinatorLayout.j(floatingActionButton);
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = j.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) && E(view2, floatingActionButton)) {
                        break;
                    }
                } else if (D(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.r(floatingActionButton, i);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.c.a.a.t.b {
        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class c<T extends FloatingActionButton> implements d.e {
        public final j<T> a;

        public c(j<T> jVar) {
            this.a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.c.a.a.p.d.e
        public void a() {
            this.a.a(FloatingActionButton.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.c.a.a.p.d.e
        public void b() {
            this.a.b(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof c) && ((c) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private d getImpl() {
        if (this.l == null) {
            this.l = Build.VERSION.SDK_INT >= 21 ? new g(this, new b()) : new d(this, new b());
        }
        return this.l;
    }

    @Override // c.c.a.a.o.a
    public boolean a() {
        throw null;
    }

    public void d(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.q == null) {
            impl.q = new ArrayList<>();
        }
        impl.q.add(null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        d impl = getImpl();
        if (impl.p == null) {
            impl.p = new ArrayList<>();
        }
        impl.p.add(animatorListener);
    }

    public void f(j<? extends FloatingActionButton> jVar) {
        d impl = getImpl();
        c cVar = new c(null);
        if (impl.r == null) {
            impl.r = new ArrayList<>();
        }
        impl.r.add(cVar);
    }

    @Deprecated
    public boolean g(Rect rect) {
        if (!q.u(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        throw null;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f956c;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.d;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /* renamed from: getBehavior */
    public CoordinatorLayout.c<FloatingActionButton> mo8getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().c();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().e;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f;
    }

    public Drawable getContentBackground() {
        getImpl().getClass();
        return null;
    }

    public int getCustomSize() {
        return this.i;
    }

    public int getExpandedComponentIdHint() {
        throw null;
    }

    public c.c.a.a.c.g getHideMotionSpec() {
        return getImpl().l;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.g;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.g;
    }

    public c.c.a.a.u.j getShapeAppearanceModel() {
        c.c.a.a.u.j jVar = getImpl().a;
        jVar.getClass();
        return jVar;
    }

    public c.c.a.a.c.g getShowMotionSpec() {
        return getImpl().k;
    }

    public int getSize() {
        return this.h;
    }

    public int getSizeDimension() {
        return h(this.h);
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // b.h.k.h
    public ColorStateList getSupportImageTintList() {
        return this.e;
    }

    @Override // b.h.k.h
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f;
    }

    public boolean getUseCompatPadding() {
        return this.k;
    }

    public final int h(int i) {
        int i2 = this.i;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        if (i != -1) {
            return resources.getDimensionPixelSize(i != 1 ? R.dimen.design_fab_size_normal : R.dimen.design_fab_size_mini);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? h(1) : h(0);
    }

    public void i(a aVar, boolean z) {
        d impl = getImpl();
        c.c.a.a.p.a aVar2 = aVar == null ? null : new c.c.a.a.p.a(this, aVar);
        if (impl.e()) {
            return;
        }
        Animator animator = impl.j;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.q()) {
            impl.s.b(z ? 8 : 4, z);
            if (aVar2 == null) {
                return;
            }
            aVar2.a.a(aVar2.f835b);
            return;
        }
        c.c.a.a.c.g gVar = impl.l;
        if (gVar == null) {
            if (impl.i == null) {
                impl.i = c.c.a.a.c.g.b(impl.s.getContext(), R.animator.design_fab_hide_motion_spec);
            }
            gVar = impl.i;
            gVar.getClass();
        }
        AnimatorSet a2 = impl.a(gVar, 0.0f, 0.0f, 0.0f);
        a2.addListener(new c.c.a.a.p.b(impl, z, aVar2));
        ArrayList<Animator.AnimatorListener> arrayList = impl.q;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                a2.addListener(it.next());
            }
        }
        a2.start();
    }

    public boolean j() {
        return getImpl().e();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public boolean k() {
        return getImpl().f();
    }

    public final void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.e;
        if (colorStateList == null) {
            b.h.b.a.j(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(i.c(colorForState, mode));
    }

    public void m(a aVar, boolean z) {
        d impl = getImpl();
        c.c.a.a.p.a aVar2 = aVar == null ? null : new c.c.a.a.p.a(this, aVar);
        if (impl.f()) {
            return;
        }
        Animator animator = impl.j;
        if (animator != null) {
            animator.cancel();
        }
        if (!impl.q()) {
            impl.s.b(0, z);
            impl.s.setAlpha(1.0f);
            impl.s.setScaleY(1.0f);
            impl.s.setScaleX(1.0f);
            impl.n(1.0f);
            if (aVar2 == null) {
                return;
            }
            aVar2.a.b(aVar2.f835b);
            return;
        }
        if (impl.s.getVisibility() != 0) {
            impl.s.setAlpha(0.0f);
            impl.s.setScaleY(0.0f);
            impl.s.setScaleX(0.0f);
            impl.n(0.0f);
        }
        c.c.a.a.c.g gVar = impl.k;
        if (gVar == null) {
            if (impl.h == null) {
                impl.h = c.c.a.a.c.g.b(impl.s.getContext(), R.animator.design_fab_show_motion_spec);
            }
            gVar = impl.h;
            gVar.getClass();
        }
        AnimatorSet a2 = impl.a(gVar, 1.0f, 1.0f, 1.0f);
        a2.addListener(new c.c.a.a.p.c(impl, z, aVar2));
        ArrayList<Animator.AnimatorListener> arrayList = impl.p;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                a2.addListener(it.next());
            }
        }
        a2.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d impl = getImpl();
        if (impl.m()) {
            ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
            if (impl.y == null) {
                impl.y = new f(impl);
            }
            viewTreeObserver.addOnPreDrawListener(impl.y);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = impl.y;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            impl.y = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        this.j = (getSizeDimension() + 0) / 2;
        getImpl().t();
        throw null;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c.c.a.a.w.a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c.c.a.a.w.a aVar = (c.c.a.a.w.a) parcelable;
        super.onRestoreInstanceState(aVar.f510b);
        aVar.d.getOrDefault("expandableWidgetHelper", null).getClass();
        throw null;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (super.onSaveInstanceState() == null) {
            new Bundle();
        }
        b.j.a.a aVar = b.j.a.a.f509c;
        throw null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            g(null);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f956c != colorStateList) {
            this.f956c = colorStateList;
            getImpl().getClass();
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.d != mode) {
            this.d = mode;
            getImpl().getClass();
        }
    }

    public void setCompatElevation(float f) {
        d impl = getImpl();
        if (impl.d != f) {
            impl.d = f;
            impl.j(f, impl.e, impl.f);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        d impl = getImpl();
        if (impl.e != f) {
            impl.e = f;
            impl.j(impl.d, f, impl.f);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        d impl = getImpl();
        if (impl.f != f) {
            impl.f = f;
            impl.j(impl.d, impl.e, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i >= 0) {
            if (i == this.i) {
                return;
            }
            this.i = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        getImpl().getClass();
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f840b) {
            getImpl().f840b = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        throw null;
    }

    public void setHideMotionSpec(c.c.a.a.c.g gVar) {
        getImpl().l = gVar;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(c.c.a.a.c.g.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            d impl = getImpl();
            impl.n(impl.n);
            if (this.e == null) {
                return;
            }
            l();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        throw null;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.g != colorStateList) {
            this.g = colorStateList;
            getImpl().o(this.g);
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().k();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().k();
    }

    public void setShadowPaddingEnabled(boolean z) {
        d impl = getImpl();
        impl.f841c = z;
        impl.t();
        throw null;
    }

    @Override // c.c.a.a.u.n
    public void setShapeAppearanceModel(c.c.a.a.u.j jVar) {
        getImpl().a = jVar;
    }

    public void setShowMotionSpec(c.c.a.a.c.g gVar) {
        getImpl().k = gVar;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(c.c.a.a.c.g.b(getContext(), i));
    }

    public void setSize(int i) {
        this.i = 0;
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // b.h.k.h
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.e != colorStateList) {
            this.e = colorStateList;
            l();
        }
    }

    @Override // b.h.k.h
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f != mode) {
            this.f = mode;
            l();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.k != z) {
            this.k = z;
            getImpl().h();
        }
    }

    @Override // c.c.a.a.q.p, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
