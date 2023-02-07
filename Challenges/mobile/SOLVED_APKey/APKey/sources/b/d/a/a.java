package b.d.a;

import android.content.res.ColorStateList;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    public static final f d;

    /* renamed from: b  reason: collision with root package name */
    public boolean f295b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f296c;

    static {
        int i = Build.VERSION.SDK_INT;
        f cVar = i >= 21 ? new c() : i >= 17 ? new b() : new d();
        d = cVar;
        cVar.l();
    }

    public ColorStateList getCardBackgroundColor() {
        return d.i(null);
    }

    public float getCardElevation() {
        return d.f(null);
    }

    public int getContentPaddingBottom() {
        throw null;
    }

    public int getContentPaddingLeft() {
        throw null;
    }

    public int getContentPaddingRight() {
        throw null;
    }

    public int getContentPaddingTop() {
        throw null;
    }

    public float getMaxCardElevation() {
        return d.a(null);
    }

    public boolean getPreventCornerOverlap() {
        return this.f296c;
    }

    public float getRadius() {
        return d.b(null);
    }

    public boolean getUseCompatPadding() {
        return this.f295b;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        f fVar = d;
        if (!(fVar instanceof c)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(fVar.g(null)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(fVar.e(null)), View.MeasureSpec.getSize(i2)), mode2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        d.d(null, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        d.d(null, colorStateList);
    }

    public void setCardElevation(float f) {
        d.j(null, f);
    }

    public void setMaxCardElevation(float f) {
        d.k(null, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f296c) {
            this.f296c = z;
            d.c(null);
        }
    }

    public void setRadius(float f) {
        d.m(null, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f295b != z) {
            this.f295b = z;
            d.h(null);
        }
    }
}
