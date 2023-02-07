package b.d.a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
/* loaded from: classes.dex */
public class h extends Drawable {
    public static final double g = Math.cos(Math.toRadians(45.0d));
    public static a h;
    public float a;

    /* renamed from: b  reason: collision with root package name */
    public float f299b;

    /* renamed from: c  reason: collision with root package name */
    public float f300c;
    public ColorStateList d;
    public boolean e;
    public boolean f;

    /* loaded from: classes.dex */
    public interface a {
    }

    public static float a(float f, float f2, boolean z) {
        if (z) {
            double d = f;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (((1.0d - g) * d2) + d);
        }
        return f;
    }

    public static float b(float f, float f2, boolean z) {
        float f3 = f * 1.5f;
        if (z) {
            double d = f3;
            double d2 = f2;
            Double.isNaN(d2);
            Double.isNaN(d);
            return (float) (((1.0d - g) * d2) + d);
        }
        return f3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.e) {
            int i = getBounds().left;
            throw null;
        } else {
            canvas.translate(0.0f, this.f300c / 2.0f);
            throw null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(b(this.f299b, this.a, this.f));
        int ceil2 = (int) Math.ceil(a(this.f299b, this.a, this.f));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.d;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.e = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.d;
        colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        throw null;
    }
}
