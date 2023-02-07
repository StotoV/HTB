package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.q;
import c.c.a.a.c.g;
import c.c.a.a.p.h;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.util.List;
/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    public static final /* synthetic */ int t = 0;
    public boolean s;

    /* loaded from: classes.dex */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {
        public Rect a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f954b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f955c;

        public ExtendedFloatingActionButtonBehavior() {
            this.f954b = false;
            this.f955c = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.g);
            this.f954b = obtainStyledAttributes.getBoolean(0, false);
            this.f955c = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }

        public final boolean B(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f954b || this.f955c) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).f == view.getId();
        }

        public final boolean C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!B(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            c.c.a.a.q.d.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                if (this.f955c) {
                    int i = ExtendedFloatingActionButton.t;
                    extendedFloatingActionButton.getClass();
                } else {
                    int i2 = ExtendedFloatingActionButton.t;
                    extendedFloatingActionButton.getClass();
                }
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
                return true;
            }
            if (this.f955c) {
                int i3 = ExtendedFloatingActionButton.t;
                extendedFloatingActionButton.getClass();
            } else {
                int i4 = ExtendedFloatingActionButton.t;
                extendedFloatingActionButton.getClass();
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
            return true;
        }

        public final boolean D(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!B(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                if (this.f955c) {
                    int i = ExtendedFloatingActionButton.t;
                } else {
                    int i2 = ExtendedFloatingActionButton.t;
                }
                ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
                return true;
            }
            if (this.f955c) {
                int i3 = ExtendedFloatingActionButton.t;
            } else {
                int i4 = ExtendedFloatingActionButton.t;
            }
            ExtendedFloatingActionButton.i(extendedFloatingActionButton, null);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void f(CoordinatorLayout.f fVar) {
            if (fVar.h == 0) {
                fVar.h = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                C(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) {
                    D(view2, extendedFloatingActionButton);
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            List<View> j = coordinatorLayout.j(extendedFloatingActionButton);
            int size = j.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = j.get(i2);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof CoordinatorLayout.f ? ((CoordinatorLayout.f) layoutParams).a instanceof BottomSheetBehavior : false) && D(view2, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (C(coordinatorLayout, (AppBarLayout) view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.r(extendedFloatingActionButton, i);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            view2.getLayoutParams().width = f.intValue();
            view2.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<View, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            view2.getLayoutParams().height = f.intValue();
            view2.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<View, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(q.q(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            int intValue = f.intValue();
            int paddingTop = view2.getPaddingTop();
            int p = q.p(view2);
            int paddingBottom = view2.getPaddingBottom();
            if (Build.VERSION.SDK_INT >= 17) {
                view2.setPaddingRelative(intValue, paddingTop, p, paddingBottom);
            } else {
                view2.setPadding(intValue, paddingTop, p, paddingBottom);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Property<View, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(q.p(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            View view2 = view;
            int q = q.q(view2);
            int paddingTop = view2.getPaddingTop();
            int intValue = f.intValue();
            int paddingBottom = view2.getPaddingBottom();
            if (Build.VERSION.SDK_INT >= 17) {
                view2.setPaddingRelative(q, paddingTop, intValue, paddingBottom);
            } else {
                view2.setPadding(q, paddingTop, intValue, paddingBottom);
            }
        }
    }

    static {
        new a(Float.class, "width");
        new b(Float.class, "height");
        new c(Float.class, "paddingStart");
        new d(Float.class, "paddingEnd");
    }

    public static void i(ExtendedFloatingActionButton extendedFloatingActionButton, h hVar) {
        extendedFloatingActionButton.getClass();
        throw null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    /* renamed from: getBehavior */
    public CoordinatorLayout.c<ExtendedFloatingActionButton> mo8getBehavior() {
        return null;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return 0;
    }

    public g getExtendMotionSpec() {
        throw null;
    }

    public g getHideMotionSpec() {
        throw null;
    }

    public g getShowMotionSpec() {
        throw null;
    }

    public g getShrinkMotionSpec() {
        throw null;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.s = z;
    }

    public void setExtendMotionSpec(g gVar) {
        throw null;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(g.b(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (!z) {
            return;
        }
        throw null;
    }

    public void setHideMotionSpec(g gVar) {
        throw null;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(g.b(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    public void setShowMotionSpec(g gVar) {
        throw null;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(g.b(getContext(), i));
    }

    public void setShrinkMotionSpec(g gVar) {
        throw null;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(g.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        getTextColors();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        getTextColors();
    }
}
