package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class l {
    public final ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public m0 f242b;

    /* renamed from: c  reason: collision with root package name */
    public m0 f243c;

    public l(ImageView imageView) {
        this.a = imageView;
    }

    public void a() {
        ColorStateList supportImageTintList;
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            w.b(drawable);
        }
        if (drawable != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i <= 21 && i == 21) {
                if (this.f243c == null) {
                    this.f243c = new m0();
                }
                m0 m0Var = this.f243c;
                PorterDuff.Mode mode = null;
                m0Var.a = null;
                m0Var.d = false;
                m0Var.f248b = null;
                m0Var.f249c = false;
                ImageView imageView = this.a;
                if (i >= 21) {
                    supportImageTintList = imageView.getImageTintList();
                } else {
                    supportImageTintList = imageView instanceof b.h.k.h ? ((b.h.k.h) imageView).getSupportImageTintList() : null;
                }
                if (supportImageTintList != null) {
                    m0Var.d = true;
                    m0Var.a = supportImageTintList;
                }
                ImageView imageView2 = this.a;
                if (i >= 21) {
                    mode = imageView2.getImageTintMode();
                } else if (imageView2 instanceof b.h.k.h) {
                    mode = ((b.h.k.h) imageView2).getSupportImageTintMode();
                }
                if (mode != null) {
                    m0Var.f249c = true;
                    m0Var.f248b = mode;
                }
                if (m0Var.d || m0Var.f249c) {
                    i.f(drawable, m0Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            m0 m0Var2 = this.f242b;
            if (m0Var2 == null) {
                return;
            }
            i.f(drawable, m0Var2, this.a.getDrawableState());
        }
    }

    public boolean b() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void c(AttributeSet attributeSet, int i) {
        Drawable drawable;
        Drawable drawable2;
        int k;
        Context context = this.a.getContext();
        int[] iArr = b.b.b.f;
        o0 p = o0.p(context, attributeSet, iArr, i, 0);
        ImageView imageView = this.a;
        b.h.j.q.E(imageView, imageView.getContext(), iArr, attributeSet, p.f252b, i, 0);
        try {
            Drawable drawable3 = this.a.getDrawable();
            if (drawable3 == null && (k = p.k(1, -1)) != -1 && (drawable3 = b.b.d.a.a.b(this.a.getContext(), k)) != null) {
                this.a.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                w.b(drawable3);
            }
            if (p.n(2)) {
                ImageView imageView2 = this.a;
                ColorStateList c2 = p.c(2);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 21) {
                    imageView2.setImageTintList(c2);
                    if (i2 == 21 && (drawable2 = imageView2.getDrawable()) != null && imageView2.getImageTintList() != null) {
                        if (drawable2.isStateful()) {
                            drawable2.setState(imageView2.getDrawableState());
                        }
                        imageView2.setImageDrawable(drawable2);
                    }
                } else if (imageView2 instanceof b.h.k.h) {
                    ((b.h.k.h) imageView2).setSupportImageTintList(c2);
                }
            }
            if (p.n(3)) {
                ImageView imageView3 = this.a;
                PorterDuff.Mode c3 = w.c(p.i(3, -1), null);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 21) {
                    imageView3.setImageTintMode(c3);
                    if (i3 == 21 && (drawable = imageView3.getDrawable()) != null && imageView3.getImageTintList() != null) {
                        if (drawable.isStateful()) {
                            drawable.setState(imageView3.getDrawableState());
                        }
                        imageView3.setImageDrawable(drawable);
                    }
                } else if (imageView3 instanceof b.h.k.h) {
                    ((b.h.k.h) imageView3).setSupportImageTintMode(c3);
                }
            }
            p.f252b.recycle();
        } catch (Throwable th) {
            p.f252b.recycle();
            throw th;
        }
    }

    public void d(int i) {
        if (i != 0) {
            Drawable b2 = b.b.d.a.a.b(this.a.getContext(), i);
            if (b2 != null) {
                w.b(b2);
            }
            this.a.setImageDrawable(b2);
        } else {
            this.a.setImageDrawable(null);
        }
        a();
    }

    public void e(ColorStateList colorStateList) {
        if (this.f242b == null) {
            this.f242b = new m0();
        }
        m0 m0Var = this.f242b;
        m0Var.a = colorStateList;
        m0Var.d = true;
        a();
    }

    public void f(PorterDuff.Mode mode) {
        if (this.f242b == null) {
            this.f242b = new m0();
        }
        m0 m0Var = this.f242b;
        m0Var.f248b = mode;
        m0Var.f249c = true;
        a();
    }
}
