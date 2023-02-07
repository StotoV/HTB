package c.c.a.a.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import c.c.a.a.q.i;
import c.c.a.a.r.c;
import c.c.a.a.r.d;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes.dex */
public class b extends g implements b.h.d.l.a, Drawable.Callback, i.b {
    public static final int[] I0 = {16842910};
    public static final ShapeDrawable J0 = new ShapeDrawable(new OvalShape());
    public ColorStateList A;
    public int[] A0;
    public float B;
    public boolean B0;
    public float C;
    public ColorStateList C0;
    public ColorStateList D;
    public WeakReference<a> D0;
    public float E;
    public TextUtils.TruncateAt E0;
    public ColorStateList F;
    public boolean F0;
    public CharSequence G;
    public int G0;
    public boolean H;
    public boolean H0;
    public Drawable I;
    public ColorStateList J;
    public float K;
    public boolean L;
    public boolean M;
    public Drawable N;
    public Drawable O;
    public ColorStateList P;
    public float Q;
    public CharSequence R;
    public boolean S;
    public boolean T;
    public Drawable U;
    public ColorStateList V;
    public c.c.a.a.c.g W;
    public c.c.a.a.c.g X;
    public float Y;
    public float Z;
    public float a0;
    public float b0;
    public float c0;
    public float d0;
    public float e0;
    public float f0;
    public final Context g0;
    public final Paint h0;
    public final Paint.FontMetrics i0;
    public final RectF j0;
    public final PointF k0;
    public final Path l0;
    public final i m0;
    public int n0;
    public int o0;
    public int p0;
    public int q0;
    public int r0;
    public int s0;
    public boolean t0;
    public int u0;
    public int v0;
    public ColorFilter w0;
    public PorterDuffColorFilter x0;
    public ColorStateList y0;
    public ColorStateList z;
    public PorterDuff.Mode z0;

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(j.b(context, attributeSet, i, i2).a());
        this.C = -1.0f;
        this.h0 = new Paint(1);
        this.i0 = new Paint.FontMetrics();
        this.j0 = new RectF();
        this.k0 = new PointF();
        this.l0 = new Path();
        this.v0 = 255;
        this.z0 = PorterDuff.Mode.SRC_IN;
        this.D0 = new WeakReference<>(null);
        this.f876b.f878b = new c.c.a.a.n.a(context);
        w();
        this.g0 = context;
        i iVar = new i(this);
        this.m0 = iVar;
        this.G = "";
        iVar.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = I0;
        setState(iArr);
        d0(iArr);
        this.F0 = true;
        if (c.c.a.a.s.b.a) {
            J0.setTint(-1);
        }
    }

    public static boolean G(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean H(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (q0()) {
            float f = this.f0 + this.e0;
            if (b.h.b.a.A(this) == 0) {
                float f2 = rect.right - f;
                rectF.right = f2;
                rectF.left = f2 - this.Q;
            } else {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + this.Q;
            }
            float exactCenterY = rect.exactCenterY();
            float f4 = this.Q;
            float f5 = exactCenterY - (f4 / 2.0f);
            rectF.top = f5;
            rectF.bottom = f5 + f4;
        }
    }

    public final void B(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (q0()) {
            float f = this.f0 + this.e0 + this.Q + this.d0 + this.c0;
            if (b.h.b.a.A(this) == 0) {
                float f2 = rect.right;
                rectF.right = f2;
                rectF.left = f2 - f;
            } else {
                int i = rect.left;
                rectF.left = i;
                rectF.right = i + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public float C() {
        if (q0()) {
            return this.d0 + this.Q + this.e0;
        }
        return 0.0f;
    }

    public float D() {
        return this.H0 ? l() : this.C;
    }

    public Drawable E() {
        Drawable drawable = this.N;
        if (drawable != null) {
            return drawable instanceof b.h.d.l.b ? ((b.h.d.l.b) drawable).a() : drawable;
        }
        return null;
    }

    public final float F() {
        Drawable drawable = this.t0 ? this.U : this.I;
        float f = this.K;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    public void I() {
        a aVar = this.D0.get();
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean J(int[] r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.j.b.J(int[], int[]):boolean");
    }

    public void K(boolean z) {
        if (this.S != z) {
            this.S = z;
            float z2 = z();
            if (!z && this.t0) {
                this.t0 = false;
            }
            float z3 = z();
            invalidateSelf();
            if (z2 == z3) {
                return;
            }
            I();
        }
    }

    public void L(Drawable drawable) {
        if (this.U != drawable) {
            float z = z();
            this.U = drawable;
            float z2 = z();
            r0(this.U);
            x(this.U);
            invalidateSelf();
            if (z == z2) {
                return;
            }
            I();
        }
    }

    public void M(ColorStateList colorStateList) {
        if (this.V != colorStateList) {
            this.V = colorStateList;
            if (this.T && this.U != null && this.S) {
                b.h.b.a.g0(this.U, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void N(boolean z) {
        if (this.T != z) {
            boolean o0 = o0();
            this.T = z;
            boolean o02 = o0();
            if (!(o0 != o02)) {
                return;
            }
            if (o02) {
                x(this.U);
            } else {
                r0(this.U);
            }
            invalidateSelf();
            I();
        }
    }

    public void O(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            onStateChange(getState());
        }
    }

    @Deprecated
    public void P(float f) {
        if (this.C != f) {
            this.C = f;
            this.f876b.a = this.f876b.a.e(f);
            invalidateSelf();
        }
    }

    public void Q(float f) {
        if (this.f0 != f) {
            this.f0 = f;
            invalidateSelf();
            I();
        }
    }

    public void R(Drawable drawable) {
        Drawable drawable2 = this.I;
        Drawable drawable3 = null;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof b.h.d.l.b) {
            drawable2 = ((b.h.d.l.b) drawable2).a();
        }
        if (drawable2 != drawable) {
            float z = z();
            if (drawable != null) {
                drawable3 = b.h.b.a.l0(drawable).mutate();
            }
            this.I = drawable3;
            float z2 = z();
            r0(drawable2);
            if (p0()) {
                x(this.I);
            }
            invalidateSelf();
            if (z == z2) {
                return;
            }
            I();
        }
    }

    public void S(float f) {
        if (this.K != f) {
            float z = z();
            this.K = f;
            float z2 = z();
            invalidateSelf();
            if (z == z2) {
                return;
            }
            I();
        }
    }

    public void T(ColorStateList colorStateList) {
        this.L = true;
        if (this.J != colorStateList) {
            this.J = colorStateList;
            if (p0()) {
                b.h.b.a.g0(this.I, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void U(boolean z) {
        if (this.H != z) {
            boolean p0 = p0();
            this.H = z;
            boolean p02 = p0();
            if (!(p0 != p02)) {
                return;
            }
            if (p02) {
                x(this.I);
            } else {
                r0(this.I);
            }
            invalidateSelf();
            I();
        }
    }

    public void V(float f) {
        if (this.B != f) {
            this.B = f;
            invalidateSelf();
            I();
        }
    }

    public void W(float f) {
        if (this.Y != f) {
            this.Y = f;
            invalidateSelf();
            I();
        }
    }

    public void X(ColorStateList colorStateList) {
        if (this.D != colorStateList) {
            this.D = colorStateList;
            if (this.H0) {
                t(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void Y(float f) {
        if (this.E != f) {
            this.E = f;
            this.h0.setStrokeWidth(f);
            if (this.H0) {
                this.f876b.l = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public void Z(Drawable drawable) {
        Drawable E = E();
        if (E != drawable) {
            float C = C();
            this.N = drawable != null ? b.h.b.a.l0(drawable).mutate() : null;
            if (c.c.a.a.s.b.a) {
                this.O = new RippleDrawable(c.c.a.a.s.b.a(this.F), this.N, J0);
            }
            float C2 = C();
            r0(E);
            if (q0()) {
                x(this.N);
            }
            invalidateSelf();
            if (C == C2) {
                return;
            }
            I();
        }
    }

    @Override // c.c.a.a.q.i.b
    public void a() {
        I();
        invalidateSelf();
    }

    public void a0(float f) {
        if (this.e0 != f) {
            this.e0 = f;
            invalidateSelf();
            if (!q0()) {
                return;
            }
            I();
        }
    }

    public void b0(float f) {
        if (this.Q != f) {
            this.Q = f;
            invalidateSelf();
            if (!q0()) {
                return;
            }
            I();
        }
    }

    public void c0(float f) {
        if (this.d0 != f) {
            this.d0 = f;
            invalidateSelf();
            if (!q0()) {
                return;
            }
            I();
        }
    }

    public boolean d0(int[] iArr) {
        if (!Arrays.equals(this.A0, iArr)) {
            this.A0 = iArr;
            if (!q0()) {
                return false;
            }
            return J(getState(), iArr);
        }
        return false;
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Drawable drawable;
        int i7;
        float f;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.v0) == 0) {
            return;
        }
        if (i < 255) {
            float f2 = bounds.left;
            float f3 = bounds.top;
            float f4 = bounds.right;
            float f5 = bounds.bottom;
            i2 = Build.VERSION.SDK_INT > 21 ? canvas.saveLayerAlpha(f2, f3, f4, f5, i) : canvas.saveLayerAlpha(f2, f3, f4, f5, i, 31);
        } else {
            i2 = 0;
        }
        if (!this.H0) {
            this.h0.setColor(this.n0);
            this.h0.setStyle(Paint.Style.FILL);
            this.j0.set(bounds);
            canvas.drawRoundRect(this.j0, D(), D(), this.h0);
        }
        if (!this.H0) {
            this.h0.setColor(this.o0);
            this.h0.setStyle(Paint.Style.FILL);
            Paint paint = this.h0;
            ColorFilter colorFilter = this.w0;
            if (colorFilter == null) {
                colorFilter = this.x0;
            }
            paint.setColorFilter(colorFilter);
            this.j0.set(bounds);
            canvas.drawRoundRect(this.j0, D(), D(), this.h0);
        }
        if (this.H0) {
            super.draw(canvas);
        }
        if (this.E > 0.0f && !this.H0) {
            this.h0.setColor(this.q0);
            this.h0.setStyle(Paint.Style.STROKE);
            if (!this.H0) {
                Paint paint2 = this.h0;
                ColorFilter colorFilter2 = this.w0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.x0;
                }
                paint2.setColorFilter(colorFilter2);
            }
            RectF rectF = this.j0;
            float f6 = this.E / 2.0f;
            rectF.set(bounds.left + f6, bounds.top + f6, bounds.right - f6, bounds.bottom - f6);
            float f7 = this.C - (this.E / 2.0f);
            canvas.drawRoundRect(this.j0, f7, f7, this.h0);
        }
        this.h0.setColor(this.r0);
        this.h0.setStyle(Paint.Style.FILL);
        this.j0.set(bounds);
        if (!this.H0) {
            canvas.drawRoundRect(this.j0, D(), D(), this.h0);
            i3 = 0;
        } else {
            c(new RectF(bounds), this.l0);
            i3 = 0;
            g(canvas, this.h0, this.l0, this.f876b.a, h());
        }
        if (p0()) {
            y(bounds, this.j0);
            RectF rectF2 = this.j0;
            float f8 = rectF2.left;
            float f9 = rectF2.top;
            canvas.translate(f8, f9);
            this.I.setBounds(i3, i3, (int) this.j0.width(), (int) this.j0.height());
            this.I.draw(canvas);
            canvas.translate(-f8, -f9);
        }
        if (o0()) {
            y(bounds, this.j0);
            RectF rectF3 = this.j0;
            float f10 = rectF3.left;
            float f11 = rectF3.top;
            canvas.translate(f10, f11);
            this.U.setBounds(i3, i3, (int) this.j0.width(), (int) this.j0.height());
            this.U.draw(canvas);
            canvas.translate(-f10, -f11);
        }
        if (!this.F0 || this.G == null) {
            i4 = i2;
            i5 = 255;
            i6 = 0;
        } else {
            PointF pointF = this.k0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            if (this.G != null) {
                float z = z() + this.Y + this.b0;
                if (b.h.b.a.A(this) == 0) {
                    pointF.x = bounds.left + z;
                    align = Paint.Align.LEFT;
                } else {
                    pointF.x = bounds.right - z;
                    align = Paint.Align.RIGHT;
                }
                this.m0.a.getFontMetrics(this.i0);
                Paint.FontMetrics fontMetrics = this.i0;
                pointF.y = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            RectF rectF4 = this.j0;
            rectF4.setEmpty();
            if (this.G != null) {
                float z2 = z() + this.Y + this.b0;
                float C = C() + this.f0 + this.c0;
                if (b.h.b.a.A(this) == 0) {
                    rectF4.left = bounds.left + z2;
                    f = bounds.right - C;
                } else {
                    rectF4.left = bounds.left + C;
                    f = bounds.right - z2;
                }
                rectF4.right = f;
                rectF4.top = bounds.top;
                rectF4.bottom = bounds.bottom;
            }
            i iVar = this.m0;
            if (iVar.f != null) {
                iVar.a.drawableState = getState();
                i iVar2 = this.m0;
                iVar2.f.c(this.g0, iVar2.a, iVar2.f855b);
            }
            this.m0.a.setTextAlign(align);
            boolean z3 = Math.round(this.m0.a(this.G.toString())) > Math.round(this.j0.width());
            if (z3) {
                i7 = canvas.save();
                canvas.clipRect(this.j0);
            } else {
                i7 = 0;
            }
            CharSequence charSequence = this.G;
            if (z3 && this.E0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.m0.a, this.j0.width(), this.E0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF2 = this.k0;
            i6 = 0;
            i5 = 255;
            i4 = i2;
            canvas.drawText(charSequence2, 0, length, pointF2.x, pointF2.y, this.m0.a);
            if (z3) {
                canvas.restoreToCount(i7);
            }
        }
        if (q0()) {
            A(bounds, this.j0);
            RectF rectF5 = this.j0;
            float f12 = rectF5.left;
            float f13 = rectF5.top;
            canvas.translate(f12, f13);
            this.N.setBounds(i6, i6, (int) this.j0.width(), (int) this.j0.height());
            if (c.c.a.a.s.b.a) {
                this.O.setBounds(this.N.getBounds());
                this.O.jumpToCurrentState();
                drawable = this.O;
            } else {
                drawable = this.N;
            }
            drawable.draw(canvas);
            canvas.translate(-f12, -f13);
        }
        if (this.v0 >= i5) {
            return;
        }
        canvas.restoreToCount(i4);
    }

    public void e0(ColorStateList colorStateList) {
        if (this.P != colorStateList) {
            this.P = colorStateList;
            if (q0()) {
                b.h.b.a.g0(this.N, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void f0(boolean z) {
        if (this.M != z) {
            boolean q0 = q0();
            this.M = z;
            boolean q02 = q0();
            if (!(q0 != q02)) {
                return;
            }
            if (q02) {
                x(this.N);
            } else {
                r0(this.N);
            }
            invalidateSelf();
            I();
        }
    }

    public void g0(float f) {
        if (this.a0 != f) {
            float z = z();
            this.a0 = f;
            float z2 = z();
            invalidateSelf();
            if (z == z2) {
                return;
            }
            I();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.v0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.w0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(C() + this.m0.a(this.G.toString()) + z() + this.Y + this.b0 + this.c0 + this.f0), this.G0);
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.H0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.C);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.B, this.C);
        }
        outline.setAlpha(this.v0 / 255.0f);
    }

    public void h0(float f) {
        if (this.Z != f) {
            float z = z();
            this.Z = f;
            float z2 = z();
            invalidateSelf();
            if (z == z2) {
                return;
            }
            I();
        }
    }

    public void i0(ColorStateList colorStateList) {
        if (this.F != colorStateList) {
            this.F = colorStateList;
            this.C0 = this.B0 ? c.c.a.a.s.b.a(colorStateList) : null;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (G(this.z) || G(this.A) || G(this.D)) {
            return true;
        }
        if (this.B0 && G(this.C0)) {
            return true;
        }
        c.c.a.a.r.b bVar = this.m0.f;
        if ((bVar == null || (colorStateList = bVar.a) == null || !colorStateList.isStateful()) ? false : true) {
            return true;
        }
        return (this.T && this.U != null && this.S) || H(this.I) || H(this.U) || G(this.y0);
    }

    public void j0(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.m0.d = true;
            invalidateSelf();
            I();
        }
    }

    public void k0(c.c.a.a.r.b bVar) {
        i iVar = this.m0;
        Context context = this.g0;
        if (iVar.f != bVar) {
            iVar.f = bVar;
            if (bVar != null) {
                TextPaint textPaint = iVar.a;
                d dVar = iVar.f855b;
                bVar.a();
                bVar.d(textPaint, bVar.n);
                bVar.b(context, new c(bVar, textPaint, dVar));
                i.b bVar2 = iVar.e.get();
                if (bVar2 != null) {
                    iVar.a.drawableState = bVar2.getState();
                }
                bVar.c(context, iVar.a, iVar.f855b);
                iVar.d = true;
            }
            i.b bVar3 = iVar.e.get();
            if (bVar3 == null) {
                return;
            }
            bVar3.a();
            bVar3.onStateChange(bVar3.getState());
        }
    }

    public void l0(float f) {
        if (this.c0 != f) {
            this.c0 = f;
            invalidateSelf();
            I();
        }
    }

    public void m0(float f) {
        if (this.b0 != f) {
            this.b0 = f;
            invalidateSelf();
            I();
        }
    }

    public void n0(boolean z) {
        if (this.B0 != z) {
            this.B0 = z;
            this.C0 = z ? c.c.a.a.s.b.a(this.F) : null;
            onStateChange(getState());
        }
    }

    public final boolean o0() {
        return this.T && this.U != null && this.t0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (p0()) {
            onLayoutDirectionChanged |= b.h.b.a.Y(this.I, i);
        }
        if (o0()) {
            onLayoutDirectionChanged |= b.h.b.a.Y(this.U, i);
        }
        if (q0()) {
            onLayoutDirectionChanged |= b.h.b.a.Y(this.N, i);
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (p0()) {
            onLevelChange |= this.I.setLevel(i);
        }
        if (o0()) {
            onLevelChange |= this.U.setLevel(i);
        }
        if (q0()) {
            onLevelChange |= this.N.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable, c.c.a.a.q.i.b
    public boolean onStateChange(int[] iArr) {
        if (this.H0) {
            super.onStateChange(iArr);
        }
        return J(iArr, this.A0);
    }

    public final boolean p0() {
        return this.H && this.I != null;
    }

    public final boolean q0() {
        return this.M && this.N != null;
    }

    public final void r0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.v0 != i) {
            this.v0 = i;
            invalidateSelf();
        }
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.w0 != colorFilter) {
            this.w0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintList(ColorStateList colorStateList) {
        if (this.y0 != colorStateList) {
            this.y0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // c.c.a.a.u.g, android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.z0 != mode) {
            this.z0 = mode;
            this.x0 = c.c.a.a.a.u(this, this.y0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (p0()) {
            visible |= this.I.setVisible(z, z2);
        }
        if (o0()) {
            visible |= this.U.setVisible(z, z2);
        }
        if (q0()) {
            visible |= this.N.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void x(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        b.h.b.a.Y(drawable, b.h.b.a.A(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.N) {
            if (drawable.isStateful()) {
                drawable.setState(this.A0);
            }
            b.h.b.a.g0(drawable, this.P);
            return;
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
        Drawable drawable2 = this.I;
        if (drawable != drawable2 || !this.L) {
            return;
        }
        b.h.b.a.g0(drawable2, this.J);
    }

    public final void y(Rect rect, RectF rectF) {
        float f;
        rectF.setEmpty();
        if (p0() || o0()) {
            float f2 = this.Y + this.Z;
            float F = F();
            if (b.h.b.a.A(this) == 0) {
                float f3 = rect.left + f2;
                rectF.left = f3;
                rectF.right = f3 + F;
            } else {
                float f4 = rect.right - f2;
                rectF.right = f4;
                rectF.left = f4 - F;
            }
            Drawable drawable = this.t0 ? this.U : this.I;
            float f5 = this.K;
            if (f5 <= 0.0f && drawable != null) {
                f5 = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.g0.getResources().getDisplayMetrics()));
                if (drawable.getIntrinsicHeight() <= f5) {
                    f = drawable.getIntrinsicHeight();
                    float exactCenterY = rect.exactCenterY() - (f / 2.0f);
                    rectF.top = exactCenterY;
                    rectF.bottom = exactCenterY + f;
                }
            }
            f = f5;
            float exactCenterY2 = rect.exactCenterY() - (f / 2.0f);
            rectF.top = exactCenterY2;
            rectF.bottom = exactCenterY2 + f;
        }
    }

    public float z() {
        if (p0() || o0()) {
            return F() + this.Z + this.a0;
        }
        return 0.0f;
    }
}
