package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.Toolbar;
import b.h.j.q;
import c.c.a.a.b;
import c.c.a.a.q.k;
import c.c.a.a.u.g;
import c.c.a.a.y.a.a;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public Integer O;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, R.attr.toolbarStyle, 2131690182), attributeSet, R.attr.toolbarStyle);
        Context context2 = getContext();
        int i = 0;
        TypedArray d = k.d(context2, attributeSet, b.u, R.attr.toolbarStyle, 2131690182, new int[0]);
        if (d.hasValue(0)) {
            setNavigationIconTint(d.getColor(0, -1));
        }
        d.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.p(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : i));
            gVar.f876b.f878b = new c.c.a.a.n.a(context2);
            gVar.w();
            gVar.o(q.m(this));
            setBackground(gVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof g) {
            c.c.a.a.a.t(this, (g) background);
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c.c.a.a.a.s(this, f);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.O != null) {
            drawable = b.h.b.a.l0(drawable);
            b.h.b.a.f0(drawable, this.O.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.O = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }
}
