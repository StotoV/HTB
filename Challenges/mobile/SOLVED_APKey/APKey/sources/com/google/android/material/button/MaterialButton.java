package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import b.b.h.f;
import b.h.j.q;
import c.c.a.a.q.k;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import c.c.a.a.u.n;
import com.example.apkey.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public class MaterialButton extends f implements Checkable, n {
    public static final int[] q = {16842911};
    public static final int[] r = {16842912};
    public final c.c.a.a.h.a d;
    public final LinkedHashSet<a> e;
    public b f;
    public PorterDuff.Mode g;
    public ColorStateList h;
    public Drawable i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public int p;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c extends b.j.a.a {
        public static final Parcelable.Creator<c> CREATOR = new a();
        public boolean d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<c> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new c(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new c[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new c(parcel, classLoader);
            }
        }

        public c(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                c.class.getClassLoader();
            }
            this.d = parcel.readInt() != 1 ? false : true;
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            parcel.writeInt(this.d ? 1 : 0);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        super(c.c.a.a.y.a.a.a(context, attributeSet, R.attr.materialButtonStyle, 2131690093), attributeSet, R.attr.materialButtonStyle);
        this.e = new LinkedHashSet<>();
        boolean z = false;
        this.n = false;
        this.o = false;
        Context context2 = getContext();
        TypedArray d = k.d(context2, attributeSet, c.c.a.a.b.l, R.attr.materialButtonStyle, 2131690093, new int[0]);
        this.m = d.getDimensionPixelSize(12, 0);
        this.g = c.c.a.a.a.n(d.getInt(15, -1), PorterDuff.Mode.SRC_IN);
        this.h = c.c.a.a.a.f(getContext(), d, 14);
        this.i = c.c.a.a.a.h(getContext(), d, 10);
        this.p = d.getInteger(11, 1);
        this.j = d.getDimensionPixelSize(13, 0);
        c.c.a.a.h.a aVar = new c.c.a.a.h.a(this, j.b(context2, attributeSet, R.attr.materialButtonStyle, 2131690093).a());
        this.d = aVar;
        aVar.f788c = d.getDimensionPixelOffset(1, 0);
        aVar.d = d.getDimensionPixelOffset(2, 0);
        aVar.e = d.getDimensionPixelOffset(3, 0);
        aVar.f = d.getDimensionPixelOffset(4, 0);
        if (d.hasValue(8)) {
            int dimensionPixelSize = d.getDimensionPixelSize(8, -1);
            aVar.g = dimensionPixelSize;
            aVar.e(aVar.f787b.e(dimensionPixelSize));
            aVar.p = true;
        }
        aVar.h = d.getDimensionPixelSize(20, 0);
        aVar.i = c.c.a.a.a.n(d.getInt(7, -1), PorterDuff.Mode.SRC_IN);
        aVar.j = c.c.a.a.a.f(aVar.a.getContext(), d, 6);
        aVar.k = c.c.a.a.a.f(aVar.a.getContext(), d, 19);
        aVar.l = c.c.a.a.a.f(aVar.a.getContext(), d, 16);
        aVar.q = d.getBoolean(5, false);
        aVar.s = d.getDimensionPixelSize(9, 0);
        int q2 = q.q(aVar.a);
        int paddingTop = aVar.a.getPaddingTop();
        int p = q.p(aVar.a);
        int paddingBottom = aVar.a.getPaddingBottom();
        if (d.hasValue(0)) {
            aVar.o = true;
            aVar.a.setSupportBackgroundTintList(aVar.j);
            aVar.a.setSupportBackgroundTintMode(aVar.i);
        } else {
            aVar.g();
        }
        q.K(aVar.a, q2 + aVar.f788c, paddingTop + aVar.e, p + aVar.d, paddingBottom + aVar.f);
        d.recycle();
        setCompoundDrawablePadding(this.m);
        g(this.i != null ? true : z);
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public boolean a() {
        c.c.a.a.h.a aVar = this.d;
        return aVar != null && aVar.q;
    }

    public final boolean b() {
        int i = this.p;
        return i == 3 || i == 4;
    }

    public final boolean c() {
        int i = this.p;
        return i == 1 || i == 2;
    }

    public final boolean d() {
        int i = this.p;
        return i == 16 || i == 32;
    }

    public final boolean e() {
        c.c.a.a.h.a aVar = this.d;
        return aVar != null && !aVar.o;
    }

    public final void f() {
        if (c()) {
            b.h.b.a.S(this, this.i, null, null, null);
        } else if (b()) {
            b.h.b.a.S(this, null, null, this.i, null);
        } else if (!d()) {
        } else {
            b.h.b.a.S(this, null, this.i, null, null);
        }
    }

    public final void g(boolean z) {
        Drawable drawable = this.i;
        if (drawable != null) {
            Drawable mutate = b.h.b.a.l0(drawable).mutate();
            this.i = mutate;
            b.h.b.a.g0(mutate, this.h);
            PorterDuff.Mode mode = this.g;
            if (mode != null) {
                b.h.b.a.h0(this.i, mode);
            }
            int i = this.j;
            if (i == 0) {
                i = this.i.getIntrinsicWidth();
            }
            int i2 = this.j;
            if (i2 == 0) {
                i2 = this.i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.i;
            int i3 = this.k;
            int i4 = this.l;
            drawable2.setBounds(i3, i4, i + i3, i2 + i4);
        }
        if (z) {
            f();
            return;
        }
        Drawable[] z2 = b.h.b.a.z(this);
        boolean z3 = false;
        Drawable drawable3 = z2[0];
        Drawable drawable4 = z2[1];
        Drawable drawable5 = z2[2];
        if ((c() && drawable3 != this.i) || ((b() && drawable5 != this.i) || (d() && drawable4 != this.i))) {
            z3 = true;
        }
        if (!z3) {
            return;
        }
        f();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (e()) {
            return this.d.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.i;
    }

    public int getIconGravity() {
        return this.p;
    }

    public int getIconPadding() {
        return this.m;
    }

    public int getIconSize() {
        return this.j;
    }

    public ColorStateList getIconTint() {
        return this.h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.g;
    }

    public int getInsetBottom() {
        return this.d.f;
    }

    public int getInsetTop() {
        return this.d.e;
    }

    public ColorStateList getRippleColor() {
        if (e()) {
            return this.d.l;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        if (e()) {
            return this.d.f787b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (e()) {
            return this.d.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (e()) {
            return this.d.h;
        }
        return 0;
    }

    @Override // b.b.h.f, b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        if (e()) {
            return this.d.j;
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // b.b.h.f, b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (e()) {
            return this.d.i;
        }
        return super.getSupportBackgroundTintMode();
    }

    public final void h(int i, int i2) {
        if (this.i == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (!d()) {
                return;
            }
            this.k = 0;
            if (this.p == 16) {
                this.l = 0;
                g(false);
                return;
            }
            int i3 = this.j;
            if (i3 == 0) {
                i3 = this.i.getIntrinsicHeight();
            }
            int textHeight = (((((i2 - getTextHeight()) - getPaddingTop()) - i3) - this.m) - getPaddingBottom()) / 2;
            if (this.l == textHeight) {
                return;
            }
            this.l = textHeight;
            g(false);
        }
        this.l = 0;
        int i4 = this.p;
        boolean z = true;
        if (i4 == 1 || i4 == 3) {
            this.k = 0;
            g(false);
            return;
        }
        int i5 = this.j;
        if (i5 == 0) {
            i5 = this.i.getIntrinsicWidth();
        }
        int textWidth = (((((i - getTextWidth()) - q.p(this)) - i5) - this.m) - q.q(this)) / 2;
        boolean z2 = q.o(this) == 1;
        if (this.p != 4) {
            z = false;
        }
        if (z2 != z) {
            textWidth = -textWidth;
        }
        if (this.k == textWidth) {
            return;
        }
        this.k = textWidth;
        g(false);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.n;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (e()) {
            c.c.a.a.a.t(this, this.d.b());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (a()) {
            Button.mergeDrawableStates(onCreateDrawableState, q);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, r);
        }
        return onCreateDrawableState;
    }

    @Override // b.b.h.f, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // b.b.h.f, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // b.b.h.f, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c.c.a.a.h.a aVar;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT != 21 || (aVar = this.d) == null) {
            return;
        }
        int i5 = i4 - i2;
        int i6 = i3 - i;
        Drawable drawable = aVar.m;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(aVar.f788c, aVar.e, i6 - aVar.d, i5 - aVar.f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        c cVar = (c) parcelable;
        super.onRestoreInstanceState(cVar.f510b);
        setChecked(cVar.d);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = new c(super.onSaveInstanceState());
        cVar.d = this.n;
        return cVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        h(i, i2);
    }

    @Override // b.b.h.f, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        h(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.b() == null) {
                return;
            }
            aVar.b().setTint(i);
            return;
        }
        super.setBackgroundColor(i);
    }

    @Override // b.b.h.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (e()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                c.c.a.a.h.a aVar = this.d;
                aVar.o = true;
                aVar.a.setSupportBackgroundTintList(aVar.j);
                aVar.a.setSupportBackgroundTintMode(aVar.i);
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // b.b.h.f, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? b.b.d.a.a.b(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (e()) {
            this.d.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!a() || !isEnabled() || this.n == z) {
            return;
        }
        this.n = z;
        refreshDrawableState();
        if (this.o) {
            return;
        }
        this.o = true;
        Iterator<a> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(this, this.n);
        }
        this.o = false;
    }

    public void setCornerRadius(int i) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.p && aVar.g == i) {
                return;
            }
            aVar.g = i;
            aVar.p = true;
            aVar.e(aVar.f787b.e(i));
        }
    }

    public void setCornerRadiusResource(int i) {
        if (e()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (e()) {
            g b2 = this.d.b();
            g.b bVar = b2.f876b;
            if (bVar.o == f) {
                return;
            }
            bVar.o = f;
            b2.w();
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.i != drawable) {
            this.i = drawable;
            g(true);
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.p != i) {
            this.p = i;
            h(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.m != i) {
            this.m = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? b.b.d.a.a.b(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            if (this.j == i) {
                return;
            }
            this.j = i;
            g(true);
            return;
        }
        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            g(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.g != mode) {
            this.g = mode;
            g(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(b.b.d.a.a.a(getContext(), i));
    }

    public void setInsetBottom(int i) {
        c.c.a.a.h.a aVar = this.d;
        aVar.f(aVar.e, i);
    }

    public void setInsetTop(int i) {
        c.c.a.a.h.a aVar = this.d;
        aVar.f(i, aVar.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        b bVar = this.f;
        if (bVar != null) {
            MaterialButtonToggleGroup.this.invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.l == colorStateList) {
                return;
            }
            aVar.l = colorStateList;
            boolean z = c.c.a.a.h.a.t;
            if (z && (aVar.a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) aVar.a.getBackground()).setColor(c.c.a.a.s.b.a(colorStateList));
            } else if (z || !(aVar.a.getBackground() instanceof c.c.a.a.s.a)) {
            } else {
                ((c.c.a.a.s.a) aVar.a.getBackground()).setTintList(c.c.a.a.s.b.a(colorStateList));
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (e()) {
            setRippleColor(b.b.d.a.a.a(getContext(), i));
        }
    }

    @Override // c.c.a.a.u.n
    public void setShapeAppearanceModel(j jVar) {
        if (e()) {
            this.d.e(jVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            aVar.n = z;
            aVar.h();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.k == colorStateList) {
                return;
            }
            aVar.k = colorStateList;
            aVar.h();
        }
    }

    public void setStrokeColorResource(int i) {
        if (e()) {
            setStrokeColor(b.b.d.a.a.a(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.h == i) {
                return;
            }
            aVar.h = i;
            aVar.h();
        }
    }

    public void setStrokeWidthResource(int i) {
        if (e()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // b.b.h.f, b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.j == colorStateList) {
                return;
            }
            aVar.j = colorStateList;
            if (aVar.b() == null) {
                return;
            }
            b.h.b.a.g0(aVar.b(), aVar.j);
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    @Override // b.b.h.f, b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (e()) {
            c.c.a.a.h.a aVar = this.d;
            if (aVar.i == mode) {
                return;
            }
            aVar.i = mode;
            if (aVar.b() == null || aVar.i == null) {
                return;
            }
            b.h.b.a.h0(aVar.b(), aVar.i);
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.n);
    }
}
