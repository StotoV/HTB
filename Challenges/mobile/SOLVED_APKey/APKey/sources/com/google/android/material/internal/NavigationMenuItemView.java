package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b.b.g.e.g;
import b.b.g.e.l;
import b.b.h.a0;
import b.h.j.c0.b;
import b.h.j.q;
import c.c.a.a.q.f;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class NavigationMenuItemView extends f implements l.a {
    public static final int[] G = {16842912};
    public FrameLayout A;
    public g B;
    public ColorStateList C;
    public boolean D;
    public Drawable E;
    public final b.h.j.a F;
    public int w;
    public boolean x;
    public boolean y;
    public final CheckedTextView z;

    /* loaded from: classes.dex */
    public class a extends b.h.j.a {
        public a() {
        }

        @Override // b.h.j.a
        public void d(View view, b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.a.setCheckable(NavigationMenuItemView.this.y);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.F = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.z = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        q.F(checkedTextView, aVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.A == null) {
                this.A = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.A.removeAllViews();
            this.A.addView(view);
        }
    }

    @Override // b.b.g.e.l.a
    public void c(g gVar, int i) {
        a0.a aVar;
        int i2;
        StateListDrawable stateListDrawable;
        this.B = gVar;
        int i3 = gVar.a;
        if (i3 > 0) {
            setId(i3);
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        boolean z = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(G, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            AtomicInteger atomicInteger = q.a;
            setBackground(stateListDrawable);
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.e);
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.q);
        b.b.a.e(this, gVar.r);
        g gVar2 = this.B;
        if (gVar2.e != null || gVar2.getIcon() != null || this.B.getActionView() == null) {
            z = false;
        }
        if (z) {
            this.z.setVisibility(8);
            FrameLayout frameLayout = this.A;
            if (frameLayout == null) {
                return;
            }
            aVar = (a0.a) frameLayout.getLayoutParams();
            i2 = -1;
        } else {
            this.z.setVisibility(0);
            FrameLayout frameLayout2 = this.A;
            if (frameLayout2 == null) {
                return;
            }
            aVar = (a0.a) frameLayout2.getLayoutParams();
            i2 = -2;
        }
        ((LinearLayout.LayoutParams) aVar).width = i2;
        this.A.setLayoutParams(aVar);
    }

    @Override // b.b.g.e.l.a
    public g getItemData() {
        return this.B;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        g gVar = this.B;
        if (gVar != null && gVar.isCheckable() && this.B.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, G);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.y != z) {
            this.y = z;
            this.F.h(this.z, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.z.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.D) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = b.h.b.a.l0(drawable).mutate();
                b.h.b.a.g0(drawable, this.C);
            }
            int i = this.w;
            drawable.setBounds(0, 0, i, i);
        } else if (this.x) {
            if (this.E == null) {
                Resources resources = getResources();
                Drawable drawable2 = Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(R.drawable.navigation_empty_icon, getContext().getTheme()) : resources.getDrawable(R.drawable.navigation_empty_icon);
                this.E = drawable2;
                if (drawable2 != null) {
                    int i2 = this.w;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.E;
        }
        b.h.b.a.S(this.z, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.z.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.w = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.C = colorStateList;
        this.D = colorStateList != null;
        g gVar = this.B;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.z.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.x = z;
    }

    public void setTextAppearance(int i) {
        b.h.b.a.e0(this.z, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.z.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.z.setText(charSequence);
    }
}
