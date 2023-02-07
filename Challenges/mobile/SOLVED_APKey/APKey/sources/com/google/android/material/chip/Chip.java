package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import b.b.h.g;
import b.h.j.c0.b;
import b.h.j.q;
import c.c.a.a.j.b;
import c.c.a.a.r.d;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import c.c.a.a.u.n;
import com.example.apkey.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class Chip extends g implements b.a, n {
    public static final Rect u = new Rect();
    public static final int[] v = {16842913};
    public static final int[] w = {16842911};
    public c.c.a.a.j.b e;
    public InsetDrawable f;
    public RippleDrawable g;
    public View.OnClickListener h;
    public CompoundButton.OnCheckedChangeListener i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public final b q;
    public final Rect r;
    public final RectF s;
    public final d t;

    /* loaded from: classes.dex */
    public class a extends d {
        public a() {
        }

        @Override // c.c.a.a.r.d
        public void a(int i) {
        }

        @Override // c.c.a.a.r.d
        public void b(Typeface typeface, boolean z) {
            CharSequence text;
            Chip chip = Chip.this;
            c.c.a.a.j.b bVar = chip.e;
            if (bVar.F0) {
                text = bVar.G;
            } else {
                text = chip.getText();
            }
            chip.setText(text);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.j.b.a {
        public b(Chip chip) {
            super(chip);
        }

        @Override // b.j.b.a
        public int n(float f, float f2) {
            Chip chip = Chip.this;
            Rect rect = Chip.u;
            return (!chip.e() || !Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 0 : 1;
        }

        @Override // b.j.b.a
        public void o(List<Integer> list) {
            boolean z = false;
            list.add(0);
            Chip chip = Chip.this;
            Rect rect = Chip.u;
            if (chip.e()) {
                Chip chip2 = Chip.this;
                c.c.a.a.j.b bVar = chip2.e;
                if (bVar != null && bVar.M) {
                    z = true;
                }
                if (!z || chip2.h == null) {
                    return;
                }
                list.add(1);
            }
        }

        @Override // b.j.b.a
        public boolean r(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.h;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.q.w(1, 1);
                }
            }
            return z;
        }

        @Override // b.j.b.a
        public void s(b.h.j.c0.b bVar) {
            bVar.a.setCheckable(Chip.this.f());
            bVar.a.setClickable(Chip.this.isClickable());
            if (!Chip.this.f() && !Chip.this.isClickable()) {
                bVar.a.setClassName("android.view.View");
            } else {
                bVar.a.setClassName(Chip.this.f() ? "android.widget.CompoundButton" : "android.widget.Button");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.a.setText(text);
            } else {
                bVar.a.setContentDescription(text);
            }
        }

        @Override // b.j.b.a
        public void t(int i, b.h.j.c0.b bVar) {
            String str = "";
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription == null) {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    closeIconContentDescription = context.getString(R.string.mtrl_chip_close_icon_content_description, objArr).trim();
                }
                bVar.a.setContentDescription(closeIconContentDescription);
                bVar.a.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                bVar.a(b.a.e);
                bVar.a.setEnabled(Chip.this.isEnabled());
                return;
            }
            bVar.a.setContentDescription(str);
            bVar.a.setBoundsInParent(Chip.u);
        }

        @Override // b.j.b.a
        public void u(int i, boolean z) {
            if (i == 1) {
                Chip chip = Chip.this;
                chip.m = z;
                chip.refreshDrawableState();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0355  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r20, android.util.AttributeSet r21) {
        /*
            Method dump skipped, instructions count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (e() && this.h != null) {
            c.c.a.a.j.b bVar = this.e;
            bVar.B(bVar.getBounds(), this.s);
        }
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.r;
    }

    private c.c.a.a.r.b getTextAppearance() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.m0.f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    @Override // c.c.a.a.j.b.a
    public void a() {
        d(this.p);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public boolean d(int i) {
        this.p = i;
        if (!this.n) {
            if (this.f != null) {
                g();
            } else {
                i();
            }
            return false;
        }
        int max = Math.max(0, i - ((int) this.e.B));
        int max2 = Math.max(0, i - this.e.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f != null) {
                g();
            } else {
                i();
            }
            return false;
        }
        int i2 = max2 > 0 ? max2 / 2 : 0;
        int i3 = max > 0 ? max / 2 : 0;
        if (this.f != null) {
            Rect rect = new Rect();
            this.f.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                i();
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.f = new InsetDrawable((Drawable) this.e, i2, i3, i2, i3);
        i();
        return true;
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        Field declaredField;
        boolean z;
        if (motionEvent.getAction() == 10) {
            try {
                declaredField = b.j.b.a.class.getDeclaredField("m");
                declaredField.setAccessible(true);
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            }
            if (((Integer) declaredField.get(this.q)).intValue() != Integer.MIN_VALUE) {
                Method declaredMethod = b.j.b.a.class.getDeclaredMethod("x", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.q, Integer.MIN_VALUE);
                z = true;
                return !z ? true : true;
            }
        }
        z = false;
        return !z ? true : true;
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        b bVar = this.q;
        bVar.getClass();
        boolean z = false;
        int i = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i2 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i2 = 33;
                                } else if (keyCode == 21) {
                                    i2 = 17;
                                } else if (keyCode != 22) {
                                    i2 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z2 = false;
                                while (i < repeatCount && bVar.p(i2, null)) {
                                    i++;
                                    z2 = true;
                                }
                                z = z2;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i3 = bVar.l;
                    if (i3 != Integer.MIN_VALUE) {
                        bVar.r(i3, 16, null);
                    }
                    z = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z = bVar.p(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z = bVar.p(1, null);
            }
        }
        if (!z || this.q.l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [int, boolean] */
    @Override // b.b.h.g, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        c.c.a.a.j.b bVar = this.e;
        boolean z = false;
        int i = 0;
        z = false;
        if (bVar != null && c.c.a.a.j.b.H(bVar.N)) {
            c.c.a.a.j.b bVar2 = this.e;
            ?? isEnabled = isEnabled();
            int i2 = isEnabled;
            if (this.m) {
                i2 = isEnabled + 1;
            }
            int i3 = i2;
            if (this.l) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.k) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            }
            if (this.m) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.l) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.k) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            z = bVar2.d0(iArr);
        }
        if (z) {
            invalidate();
        }
    }

    public final boolean e() {
        c.c.a.a.j.b bVar = this.e;
        return (bVar == null || bVar.E() == null) ? false : true;
    }

    public boolean f() {
        c.c.a.a.j.b bVar = this.e;
        return bVar != null && bVar.S;
    }

    public final void g() {
        if (this.f != null) {
            this.f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            i();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f;
        return insetDrawable == null ? this.e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.U;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.V;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.A;
        }
        return null;
    }

    public float getChipCornerRadius() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return Math.max(0.0f, bVar.D());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.e;
    }

    public float getChipEndPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.f0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || (drawable = bVar.I) == null) {
            return null;
        }
        return drawable instanceof b.h.d.l.b ? ((b.h.d.l.b) drawable).a() : drawable;
    }

    public float getChipIconSize() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.K;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.J;
        }
        return null;
    }

    public float getChipMinHeight() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.B;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.Y;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.D;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.E;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.E();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.R;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.e0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.Q;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.d0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.P;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.E0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        b bVar = this.q;
        if (bVar.l == 1 || bVar.k == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public c.c.a.a.c.g getHideMotionSpec() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.X;
        }
        return null;
    }

    public float getIconEndPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.a0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.Z;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.F;
        }
        return null;
    }

    public j getShapeAppearanceModel() {
        return this.e.f876b.a;
    }

    public c.c.a.a.c.g getShowMotionSpec() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.W;
        }
        return null;
    }

    public float getTextEndPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.c0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            return bVar.b0;
        }
        return 0.0f;
    }

    public final void h() {
        b bVar;
        if (e()) {
            c.c.a.a.j.b bVar2 = this.e;
            if ((bVar2 != null && bVar2.M) && this.h != null) {
                bVar = this.q;
                q.F(this, bVar);
            }
        }
        bVar = null;
        q.F(this, bVar);
    }

    public final void i() {
        if (c.c.a.a.s.b.a) {
            j();
            return;
        }
        this.e.n0(true);
        Drawable backgroundDrawable = getBackgroundDrawable();
        AtomicInteger atomicInteger = q.a;
        setBackground(backgroundDrawable);
        k();
        if (getBackgroundDrawable() != this.f || this.e.getCallback() != null) {
            return;
        }
        this.e.setCallback(this.f);
    }

    public final void j() {
        this.g = new RippleDrawable(c.c.a.a.s.b.a(this.e.F), getBackgroundDrawable(), null);
        this.e.n0(false);
        RippleDrawable rippleDrawable = this.g;
        AtomicInteger atomicInteger = q.a;
        setBackground(rippleDrawable);
        k();
    }

    public final void k() {
        c.c.a.a.j.b bVar;
        if (TextUtils.isEmpty(getText()) || (bVar = this.e) == null) {
            return;
        }
        int C = (int) (bVar.C() + bVar.f0 + bVar.c0);
        c.c.a.a.j.b bVar2 = this.e;
        int z = (int) (bVar2.z() + bVar2.Y + bVar2.b0);
        if (this.f != null) {
            Rect rect = new Rect();
            this.f.getPadding(rect);
            z += rect.left;
            C += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        AtomicInteger atomicInteger = q.a;
        if (Build.VERSION.SDK_INT >= 17) {
            setPaddingRelative(z, paddingTop, C, paddingBottom);
        } else {
            setPadding(z, paddingTop, C, paddingBottom);
        }
    }

    public final void l() {
        TextPaint paint = getPaint();
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            paint.drawableState = bVar.getState();
        }
        c.c.a.a.r.b textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.c(getContext(), paint, this.t);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.c.a.a.a.t(this, this.e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, v);
        }
        if (f()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, w);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        b bVar = this.q;
        int i2 = bVar.l;
        if (i2 != Integer.MIN_VALUE) {
            bVar.k(i2);
        }
        if (z) {
            bVar.p(i, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean contains;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                contains = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(contains);
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((f() || isClickable()) ? f() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.d) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= chipGroup.getChildCount()) {
                        i3 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i2) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i2)) == this) {
                            break;
                        }
                        i3++;
                    }
                    i2++;
                }
                i = i3;
            } else {
                i = -1;
            }
            Object tag = getTag(R.id.row_index_key);
            b.c a2 = b.c.a(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i, 1, false, isChecked());
            if (Build.VERSION.SDK_INT < 19) {
                return;
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) a2.a);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.o != i) {
            this.o = i;
            k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L16;
     */
    @Override // android.widget.TextView, android.view.View
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L45
            if (r0 == r3) goto L2b
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L40
            goto L4c
        L21:
            boolean r0 = r5.k
            if (r0 == 0) goto L4c
            if (r1 != 0) goto L4a
            r5.setCloseIconPressed(r2)
            goto L4a
        L2b:
            boolean r0 = r5.k
            if (r0 == 0) goto L40
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.h
            if (r0 == 0) goto L39
            r0.onClick(r5)
        L39:
            com.google.android.material.chip.Chip$b r0 = r5.q
            r0.w(r3, r3)
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            r5.setCloseIconPressed(r2)
            goto L4d
        L45:
            if (r1 == 0) goto L4c
            r5.setCloseIconPressed(r3)
        L4a:
            r0 = 1
            goto L4d
        L4c:
            r0 = 0
        L4d:
            if (r0 != 0) goto L55
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L56
        L55:
            r2 = 1
        L56:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // b.b.h.g, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // b.b.h.g, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.K(z);
        }
    }

    public void setCheckableResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.K(bVar.g0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null) {
            this.j = z;
        } else if (!bVar.S) {
        } else {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked == z || (onCheckedChangeListener = this.i) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.L(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.L(b.b.d.a.a.b(bVar.g0, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.M(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.M(b.b.d.a.a.a(bVar.g0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.N(bVar.g0.getResources().getBoolean(i));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.N(z);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.A == colorStateList) {
            return;
        }
        bVar.A = colorStateList;
        bVar.onStateChange(bVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.O(b.b.d.a.a.a(bVar.g0, i));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.P(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.P(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(c.c.a.a.j.b bVar) {
        c.c.a.a.j.b bVar2 = this.e;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.D0 = new WeakReference<>(null);
            }
            this.e = bVar;
            bVar.F0 = false;
            bVar.getClass();
            bVar.D0 = new WeakReference<>(this);
            d(this.p);
        }
    }

    public void setChipEndPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.f0 == f) {
            return;
        }
        bVar.f0 = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setChipEndPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.Q(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setChipIcon(Drawable drawable) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.R(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.R(b.b.d.a.a.b(bVar.g0, i));
        }
    }

    public void setChipIconSize(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.S(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.S(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.T(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.T(b.b.d.a.a.a(bVar.g0, i));
        }
    }

    public void setChipIconVisible(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.U(bVar.g0.getResources().getBoolean(i));
        }
    }

    public void setChipIconVisible(boolean z) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.U(z);
        }
    }

    public void setChipMinHeight(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.B == f) {
            return;
        }
        bVar.B = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setChipMinHeightResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.V(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setChipStartPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.Y == f) {
            return;
        }
        bVar.Y = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setChipStartPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.W(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.X(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.X(b.b.d.a.a.a(bVar.g0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.Y(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.Y(bVar.g0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.Z(drawable);
        }
        h();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.R == charSequence) {
            return;
        }
        b.h.h.a c2 = b.h.h.a.c();
        bVar.R = c2.d(charSequence, c2.f449c, true);
        bVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.a0(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.a0(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.Z(b.b.d.a.a.b(bVar.g0, i));
        }
        h();
    }

    public void setCloseIconSize(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.b0(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.b0(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.c0(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.c0(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.e0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.e0(b.b.d.a.a.a(bVar.g0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.f0(z);
        }
        h();
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i == 0) {
            if (i3 != 0) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i == 0) {
            if (i3 != 0) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
            return;
        }
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable == null) {
            if (drawable3 != null) {
                throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
            }
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            g.b bVar2 = bVar.f876b;
            if (bVar2.o == f) {
                return;
            }
            bVar2.o = f;
            bVar.w();
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.e == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        bVar.E0 = truncateAt;
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        d(this.p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(c.c.a.a.c.g gVar) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.X = gVar;
        }
    }

    public void setHideMotionSpecResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.X = c.c.a.a.c.g.b(bVar.g0, i);
        }
    }

    public void setIconEndPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.g0(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.g0(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.h0(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.h0(bVar.g0.getResources().getDimension(i));
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.e != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i <= 1) {
            super.setLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i <= 1) {
            super.setMaxLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.G0 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i <= 1) {
            super.setMinLines(i);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.h = onClickListener;
        h();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.i0(colorStateList);
        }
        if (!this.e.B0) {
            j();
        }
    }

    public void setRippleColorResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.i0(b.b.d.a.a.a(bVar.g0, i));
            if (this.e.B0) {
                return;
            }
            j();
        }
    }

    @Override // c.c.a.a.u.n
    public void setShapeAppearanceModel(j jVar) {
        c.c.a.a.j.b bVar = this.e;
        bVar.f876b.a = jVar;
        bVar.invalidateSelf();
    }

    public void setShowMotionSpec(c.c.a.a.c.g gVar) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.W = gVar;
        }
    }

    public void setShowMotionSpecResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.W = c.c.a.a.c.g.b(bVar.g0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(bVar.F0 ? null : charSequence, bufferType);
        c.c.a.a.j.b bVar2 = this.e;
        if (bVar2 == null) {
            return;
        }
        bVar2.j0(charSequence);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.k0(new c.c.a.a.r.b(bVar.g0, i));
        }
        l();
    }

    public void setTextAppearance(c.c.a.a.r.b bVar) {
        c.c.a.a.j.b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.k0(bVar);
        }
        l();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.c0 == f) {
            return;
        }
        bVar.c0 = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setTextEndPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.l0(bVar.g0.getResources().getDimension(i));
        }
    }

    public void setTextStartPadding(float f) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar == null || bVar.b0 == f) {
            return;
        }
        bVar.b0 = f;
        bVar.invalidateSelf();
        bVar.I();
    }

    public void setTextStartPaddingResource(int i) {
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.m0(bVar.g0.getResources().getDimension(i));
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        c.c.a.a.j.b bVar = this.e;
        if (bVar != null) {
            bVar.k0(new c.c.a.a.r.b(bVar.g0, i));
        }
        l();
    }
}
