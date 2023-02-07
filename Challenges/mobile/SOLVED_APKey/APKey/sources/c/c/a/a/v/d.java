package c.c.a.a.v;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import b.h.j.q;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d extends FrameLayout {
    public static final View.OnTouchListener i = new a();

    /* renamed from: b  reason: collision with root package name */
    public c f897b;

    /* renamed from: c  reason: collision with root package name */
    public b f898c;
    public int d;
    public final float e;
    public final float f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    /* loaded from: classes.dex */
    public static class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public d(Context context, AttributeSet attributeSet) {
        super(c.c.a.a.y.a.a.a(context, attributeSet, 0, 0), attributeSet);
        Drawable l0;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, c.c.a.a.b.y);
        if (obtainStyledAttributes.hasValue(6)) {
            float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            AtomicInteger atomicInteger = q.a;
            if (Build.VERSION.SDK_INT >= 21) {
                setElevation(dimensionPixelSize);
            }
        }
        this.d = obtainStyledAttributes.getInt(2, 0);
        this.e = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(c.c.a.a.a.f(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(c.c.a.a.a.n(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        setOnTouchListener(i);
        setFocusable(true);
        if (getBackground() == null) {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(c.c.a.a.a.l(c.c.a.a.a.e(this, R.attr.colorSurface), c.c.a.a.a.e(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha()));
            if (this.g != null) {
                l0 = b.h.b.a.l0(gradientDrawable);
                b.h.b.a.g0(l0, this.g);
            } else {
                l0 = b.h.b.a.l0(gradientDrawable);
            }
            AtomicInteger atomicInteger2 = q.a;
            setBackground(l0);
        }
    }

    public float getActionTextColorAlpha() {
        return this.f;
    }

    public int getAnimationMode() {
        return this.d;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b bVar = this.f898c;
        if (bVar != null) {
            bVar.onViewAttachedToWindow(this);
        }
        AtomicInteger atomicInteger = q.a;
        if (Build.VERSION.SDK_INT >= 20) {
            requestApplyInsets();
        } else {
            requestFitSystemWindows();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b bVar = this.f898c;
        if (bVar != null) {
            bVar.onViewDetachedFromWindow(this);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        c cVar = this.f897b;
        if (cVar != null) {
            cVar.a(this, i2, i3, i4, i5);
        }
    }

    public void setAnimationMode(int i2) {
        this.d = i2;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.g != null) {
            drawable = b.h.b.a.l0(drawable.mutate());
            b.h.b.a.g0(drawable, this.g);
            b.h.b.a.h0(drawable, this.h);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.g = colorStateList;
        if (getBackground() != null) {
            Drawable l0 = b.h.b.a.l0(getBackground().mutate());
            b.h.b.a.g0(l0, colorStateList);
            b.h.b.a.h0(l0, this.h);
            if (l0 == getBackground()) {
                return;
            }
            super.setBackgroundDrawable(l0);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.h = mode;
        if (getBackground() != null) {
            Drawable l0 = b.h.b.a.l0(getBackground().mutate());
            b.h.b.a.h0(l0, mode);
            if (l0 == getBackground()) {
                return;
            }
            super.setBackgroundDrawable(l0);
        }
    }

    public void setOnAttachStateChangeListener(b bVar) {
        this.f898c = bVar;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : i);
        super.setOnClickListener(onClickListener);
    }

    public void setOnLayoutChangeListener(c cVar) {
        this.f897b = cVar;
    }
}
