package c.c.a.a.i;

import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import c.c.a.a.u.j;
import c.c.a.a.u.n;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class a extends b.d.a.a implements Checkable, n {
    public static final int[] g = {16842911};
    public static final int[] h = {16842912};
    public static final int[] i = {R.attr.state_dragged};
    public boolean e;
    public InterfaceC0035a f;

    /* renamed from: c.c.a.a.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0035a {
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    @Override // b.d.a.a
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // b.d.a.a
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // b.d.a.a
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // b.d.a.a
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // b.d.a.a
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // b.d.a.a
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public j getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, h);
        }
        if (this.e) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, i);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(false);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // b.d.a.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // b.d.a.a
    public void setCardBackgroundColor(int i2) {
        ColorStateList.valueOf(i2);
        throw null;
    }

    @Override // b.d.a.a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    @Override // b.d.a.a
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconMargin(int i2) {
        throw null;
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i2);
        throw null;
    }

    public void setCheckedIconResource(int i2) {
        b.b.d.a.a.b(getContext(), i2);
        throw null;
    }

    public void setCheckedIconSize(int i2) {
        throw null;
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i2);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
    }

    public void setDragged(boolean z) {
        if (this.e != z) {
            this.e = z;
            refreshDrawableState();
            if (Build.VERSION.SDK_INT <= 26) {
                invalidate();
                return;
            }
            throw null;
        }
    }

    @Override // b.d.a.a
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        throw null;
    }

    public void setOnCheckedChangeListener(InterfaceC0035a interfaceC0035a) {
        this.f = interfaceC0035a;
    }

    @Override // b.d.a.a
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        throw null;
    }

    public void setProgress(float f) {
        throw null;
    }

    @Override // b.d.a.a
    public void setRadius(float f) {
        super.setRadius(f);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i2) {
        b.b.d.a.a.a(getContext(), i2);
        throw null;
    }

    @Override // c.c.a.a.u.n
    public void setShapeAppearanceModel(j jVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(jVar.d(getBoundsAsRectF()));
        }
        throw null;
    }

    public void setStrokeColor(int i2) {
        ColorStateList.valueOf(i2);
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeWidth(int i2) {
        throw null;
    }

    @Override // b.d.a.a
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
    }
}
