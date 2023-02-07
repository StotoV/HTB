package c.c.a.a.q;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import b.h.h.e;
import b.h.j.q;
import c.c.a.a.q.h;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class c {
    public static final boolean U;
    public Bitmap A;
    public Paint B;
    public float C;
    public float D;
    public int[] E;
    public boolean F;
    public final TextPaint G;
    public final TextPaint H;
    public TimeInterpolator I;
    public TimeInterpolator J;
    public float K;
    public float L;
    public float M;
    public ColorStateList N;
    public float O;
    public StaticLayout P;
    public float Q;
    public float R;
    public float S;
    public CharSequence T;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f845b;

    /* renamed from: c  reason: collision with root package name */
    public float f846c;
    public final Rect d;
    public final Rect e;
    public final RectF f;
    public int g = 16;
    public int h = 16;
    public float i = 15.0f;
    public float j = 15.0f;
    public ColorStateList k;
    public ColorStateList l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public Typeface s;
    public Typeface t;
    public Typeface u;
    public c.c.a.a.r.a v;
    public CharSequence w;
    public CharSequence x;
    public boolean y;
    public boolean z;

    static {
        U = Build.VERSION.SDK_INT < 18;
    }

    public c(View view) {
        this.a = view;
        TextPaint textPaint = new TextPaint(129);
        this.G = textPaint;
        this.H = new TextPaint(textPaint);
        this.e = new Rect();
        this.d = new Rect();
        this.f = new RectF();
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i2) * f) + (Color.alpha(i) * f2)), (int) ((Color.red(i2) * f) + (Color.red(i) * f2)), (int) ((Color.green(i2) * f) + (Color.green(i) * f2)), (int) ((Color.blue(i2) * f) + (Color.blue(i) * f2)));
    }

    public static float i(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        TimeInterpolator timeInterpolator2 = c.c.a.a.c.a.a;
        return c.a.a.a.a.a(f2, f, f3, f);
    }

    public static boolean l(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public float b() {
        if (this.w == null) {
            return 0.0f;
        }
        TextPaint textPaint = this.H;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.O);
        }
        TextPaint textPaint2 = this.H;
        CharSequence charSequence = this.w;
        return textPaint2.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c(CharSequence charSequence) {
        boolean z = true;
        if (q.o(this.a) != 1) {
            z = false;
        }
        return ((e.c) (z ? b.h.h.e.d : b.h.h.e.f456c)).b(charSequence, 0, charSequence.length());
    }

    public final void d(float f) {
        TextPaint textPaint;
        int g;
        TextPaint textPaint2;
        this.f.left = i(this.d.left, this.e.left, f, this.I);
        this.f.top = i(this.m, this.n, f, this.I);
        this.f.right = i(this.d.right, this.e.right, f, this.I);
        this.f.bottom = i(this.d.bottom, this.e.bottom, f, this.I);
        this.q = i(this.o, this.p, f, this.I);
        this.r = i(this.m, this.n, f, this.I);
        p(i(this.i, this.j, f, this.J));
        TimeInterpolator timeInterpolator = c.c.a.a.c.a.f759b;
        this.Q = 1.0f - i(0.0f, 1.0f, 1.0f - f, timeInterpolator);
        View view = this.a;
        AtomicInteger atomicInteger = q.a;
        view.postInvalidateOnAnimation();
        this.R = i(1.0f, 0.0f, f, timeInterpolator);
        this.a.postInvalidateOnAnimation();
        ColorStateList colorStateList = this.l;
        ColorStateList colorStateList2 = this.k;
        if (colorStateList != colorStateList2) {
            textPaint = this.G;
            g = a(h(colorStateList2), g(), f);
        } else {
            textPaint = this.G;
            g = g();
        }
        textPaint.setColor(g);
        if (Build.VERSION.SDK_INT >= 21) {
            float f2 = this.O;
            if (f2 != 0.0f) {
                textPaint2 = this.G;
                f2 = i(0.0f, f2, f, timeInterpolator);
            } else {
                textPaint2 = this.G;
            }
            textPaint2.setLetterSpacing(f2);
        }
        this.G.setShadowLayer(i(0.0f, this.K, f, null), i(0.0f, this.L, f, null), i(0.0f, this.M, f, null), a(h(null), h(this.N), f));
        this.a.postInvalidateOnAnimation();
    }

    public final void e(float f) {
        boolean z;
        float f2;
        StaticLayout staticLayout;
        if (this.w == null) {
            return;
        }
        float width = this.e.width();
        float width2 = this.d.width();
        if (Math.abs(f - this.j) < 0.001f) {
            f2 = this.j;
            this.C = 1.0f;
            Typeface typeface = this.u;
            Typeface typeface2 = this.s;
            if (typeface != typeface2) {
                this.u = typeface2;
                z = true;
            } else {
                z = false;
            }
        } else {
            float f3 = this.i;
            Typeface typeface3 = this.u;
            Typeface typeface4 = this.t;
            if (typeface3 != typeface4) {
                this.u = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (Math.abs(f - f3) < 0.001f) {
                this.C = 1.0f;
            } else {
                this.C = f / this.i;
            }
            float f4 = this.j / this.i;
            width = width2 * f4 > width ? Math.min(width / f4, width2) : width2;
            f2 = f3;
        }
        if (width > 0.0f) {
            z = this.D != f2 || this.F || z;
            this.D = f2;
            this.F = false;
        }
        if (this.x != null && !z) {
            return;
        }
        this.G.setTextSize(this.D);
        this.G.setTypeface(this.u);
        this.G.setLinearText(this.C != 1.0f);
        boolean c2 = c(this.w);
        this.y = c2;
        try {
            h hVar = new h(this.w, this.G, (int) width);
            hVar.i = TextUtils.TruncateAt.END;
            hVar.h = c2;
            hVar.e = Layout.Alignment.ALIGN_NORMAL;
            hVar.g = false;
            hVar.f = 1;
            staticLayout = hVar.a();
        } catch (h.a e) {
            Log.e("CollapsingTextHelper", e.getCause().getMessage(), e);
            staticLayout = null;
        }
        staticLayout.getClass();
        this.P = staticLayout;
        this.x = staticLayout.getText();
    }

    public float f() {
        TextPaint textPaint = this.H;
        textPaint.setTextSize(this.j);
        textPaint.setTypeface(this.s);
        if (Build.VERSION.SDK_INT >= 21) {
            textPaint.setLetterSpacing(this.O);
        }
        return -this.H.ascent();
    }

    public int g() {
        return h(this.l);
    }

    public final int h(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.E;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public void j() {
        this.f845b = this.e.width() > 0 && this.e.height() > 0 && this.d.width() > 0 && this.d.height() > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.q.c.k():void");
    }

    public void m(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            k();
        }
    }

    public void n(int i) {
        if (this.h != i) {
            this.h = i;
            k();
        }
    }

    public void o(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 1.0f) {
            f = 1.0f;
        }
        if (f != this.f846c) {
            this.f846c = f;
            d(f);
        }
    }

    public final void p(float f) {
        e(f);
        boolean z = U && this.C != 1.0f;
        this.z = z;
        if (z && this.A == null && !this.d.isEmpty() && !TextUtils.isEmpty(this.x)) {
            d(0.0f);
            int width = this.P.getWidth();
            int height = this.P.getHeight();
            if (width > 0 && height > 0) {
                this.A = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.P.draw(new Canvas(this.A));
                if (this.B == null) {
                    this.B = new Paint(3);
                }
            }
        }
        View view = this.a;
        AtomicInteger atomicInteger = q.a;
        view.postInvalidateOnAnimation();
    }

    public void q(Typeface typeface) {
        boolean z;
        c.c.a.a.r.a aVar = this.v;
        boolean z2 = true;
        if (aVar != null) {
            aVar.f863c = true;
        }
        if (this.s != typeface) {
            this.s = typeface;
            z = true;
        } else {
            z = false;
        }
        if (this.t != typeface) {
            this.t = typeface;
        } else {
            z2 = false;
        }
        if (z || z2) {
            k();
        }
    }
}
