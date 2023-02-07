package c.c.a.a.u;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import c.c.a.a.u.k;
import c.c.a.a.u.m;
import java.util.BitSet;
/* loaded from: classes.dex */
public class g extends Drawable implements b.h.d.l.a, n {
    public static final String x = g.class.getSimpleName();
    public static final Paint y = new Paint(1);

    /* renamed from: b  reason: collision with root package name */
    public b f876b;

    /* renamed from: c  reason: collision with root package name */
    public final m.f[] f877c;
    public final m.f[] d;
    public final BitSet e;
    public boolean f;
    public final Matrix g;
    public final Path h;
    public final Path i;
    public final RectF j;
    public final RectF k;
    public final Region l;
    public final Region m;
    public j n;
    public final Paint o;
    public final Paint p;
    public final c.c.a.a.t.a q;
    public final k.b r;
    public final k s;
    public PorterDuffColorFilter t;
    public PorterDuffColorFilter u;
    public final RectF v;
    public boolean w;

    /* loaded from: classes.dex */
    public class a implements k.b {
        public a() {
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {
        public j a;

        /* renamed from: b  reason: collision with root package name */
        public c.c.a.a.n.a f878b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f879c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;

        public b(b bVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = bVar.a;
            this.f878b = bVar.f878b;
            this.l = bVar.l;
            this.f879c = bVar.f879c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.h = bVar.h;
            this.g = bVar.g;
            this.m = bVar.m;
            this.j = bVar.j;
            this.s = bVar.s;
            this.q = bVar.q;
            this.u = bVar.u;
            this.k = bVar.k;
            this.n = bVar.n;
            this.o = bVar.o;
            this.p = bVar.p;
            this.r = bVar.r;
            this.t = bVar.t;
            this.f = bVar.f;
            this.v = bVar.v;
            if (bVar.i != null) {
                this.i = new Rect(bVar.i);
            }
        }

        public b(j jVar, c.c.a.a.n.a aVar) {
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.j = 1.0f;
            this.k = 1.0f;
            this.m = 255;
            this.n = 0.0f;
            this.o = 0.0f;
            this.p = 0.0f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = false;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = jVar;
            this.f878b = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.f = true;
            return gVar;
        }
    }

    public g() {
        this(new j());
    }

    public g(b bVar) {
        k kVar;
        this.f877c = new m.f[4];
        this.d = new m.f[4];
        this.e = new BitSet(8);
        this.g = new Matrix();
        this.h = new Path();
        this.i = new Path();
        this.j = new RectF();
        this.k = new RectF();
        this.l = new Region();
        this.m = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.q = new c.c.a.a.t.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            kVar = k.a.a;
        } else {
            kVar = new k();
        }
        this.s = kVar;
        this.v = new RectF();
        this.w = true;
        this.f876b = bVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = y;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        v();
        u(getState());
        this.r = new a();
    }

    public g(j jVar) {
        this(new b(jVar, null));
    }

    public final void b(RectF rectF, Path path) {
        c(rectF, path);
        if (this.f876b.j != 1.0f) {
            this.g.reset();
            Matrix matrix = this.g;
            float f = this.f876b.j;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.g);
        }
        path.computeBounds(this.v, true);
    }

    public final void c(RectF rectF, Path path) {
        k kVar = this.s;
        b bVar = this.f876b;
        kVar.a(bVar.a, bVar.k, rectF, this.r, path);
    }

    public final PorterDuffColorFilter d(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        int color;
        int e;
        if (colorStateList == null || mode == null) {
            return (!z || (e = e((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(e, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = e(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f6, code lost:
        if ((r4 < 21 || (!r2.a.d(h()) && !r12.h.isConvex() && r4 < 29)) != false) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d2  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r13) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.u.g.draw(android.graphics.Canvas):void");
    }

    public int e(int i) {
        b bVar = this.f876b;
        float f = bVar.o + bVar.p + bVar.n;
        c.c.a.a.n.a aVar = bVar.f878b;
        if (aVar == null || !aVar.a) {
            return i;
        }
        if (!(b.h.d.a.c(i, 255) == aVar.f834c)) {
            return i;
        }
        float f2 = aVar.d;
        float f3 = 0.0f;
        if (f2 > 0.0f && f > 0.0f) {
            f3 = Math.min(((((float) Math.log1p(f / f2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return b.h.d.a.c(c.c.a.a.a.l(b.h.d.a.c(i, 255), aVar.f833b, f3), Color.alpha(i));
    }

    public final void f(Canvas canvas) {
        if (this.e.cardinality() > 0) {
            Log.w(x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f876b.s != 0) {
            canvas.drawPath(this.h, this.q.a);
        }
        for (int i = 0; i < 4; i++) {
            m.f fVar = this.f877c[i];
            c.c.a.a.t.a aVar = this.q;
            int i2 = this.f876b.r;
            Matrix matrix = m.f.a;
            fVar.a(matrix, aVar, i2, canvas);
            this.d[i].a(matrix, this.q, this.f876b.r, canvas);
        }
        if (this.w) {
            int i3 = i();
            int j = j();
            canvas.translate(-i3, -j);
            canvas.drawPath(this.h, y);
            canvas.translate(i3, j);
        }
    }

    public final void g(Canvas canvas, Paint paint, Path path, j jVar, RectF rectF) {
        if (!jVar.d(rectF)) {
            canvas.drawPath(path, paint);
            return;
        }
        float a2 = jVar.f.a(rectF) * this.f876b.k;
        canvas.drawRoundRect(rectF, a2, a2, paint);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f876b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        b bVar = this.f876b;
        if (bVar.q == 2) {
            return;
        }
        if (bVar.a.d(h())) {
            outline.setRoundRect(getBounds(), l() * this.f876b.k);
            return;
        }
        b(h(), this.h);
        if (!this.h.isConvex() && Build.VERSION.SDK_INT < 29) {
            return;
        }
        try {
            outline.setConvexPath(this.h);
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f876b.i;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.l.set(getBounds());
        b(h(), this.h);
        this.m.setPath(this.h, this.l);
        this.l.op(this.m, Region.Op.DIFFERENCE);
        return this.l;
    }

    public RectF h() {
        this.j.set(getBounds());
        return this.j;
    }

    public int i() {
        b bVar;
        double d = this.f876b.s;
        double sin = Math.sin(Math.toRadians(bVar.t));
        Double.isNaN(d);
        return (int) (sin * d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f876b.g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f876b.f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f876b.e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f876b.d) != null && colorStateList4.isStateful())));
    }

    public int j() {
        b bVar;
        double d = this.f876b.s;
        double cos = Math.cos(Math.toRadians(bVar.t));
        Double.isNaN(d);
        return (int) (cos * d);
    }

    public final float k() {
        if (m()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float l() {
        return this.f876b.a.e.a(h());
    }

    public final boolean m() {
        Paint.Style style = this.f876b.v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f876b = new b(this.f876b);
        return this;
    }

    public void n(Context context) {
        this.f876b.f878b = new c.c.a.a.n.a(context);
        w();
    }

    public void o(float f) {
        b bVar = this.f876b;
        if (bVar.o != f) {
            bVar.o = f;
            w();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable, c.c.a.a.q.i.b
    public boolean onStateChange(int[] iArr) {
        boolean z = u(iArr) || v();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void p(ColorStateList colorStateList) {
        b bVar = this.f876b;
        if (bVar.d != colorStateList) {
            bVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    public void q(float f) {
        b bVar = this.f876b;
        if (bVar.k != f) {
            bVar.k = f;
            this.f = true;
            invalidateSelf();
        }
    }

    public void r(float f, int i) {
        this.f876b.l = f;
        invalidateSelf();
        t(ColorStateList.valueOf(i));
    }

    public void s(float f, ColorStateList colorStateList) {
        this.f876b.l = f;
        invalidateSelf();
        t(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        b bVar = this.f876b;
        if (bVar.m != i) {
            bVar.m = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f876b.f879c = colorFilter;
        super.invalidateSelf();
    }

    @Override // c.c.a.a.u.n
    public void setShapeAppearanceModel(j jVar) {
        this.f876b.a = jVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintList(ColorStateList colorStateList) {
        this.f876b.g = colorStateList;
        v();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintMode(PorterDuff.Mode mode) {
        b bVar = this.f876b;
        if (bVar.h != mode) {
            bVar.h = mode;
            v();
            super.invalidateSelf();
        }
    }

    public void t(ColorStateList colorStateList) {
        b bVar = this.f876b;
        if (bVar.e != colorStateList) {
            bVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean u(int[] iArr) {
        boolean z;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f876b.d == null || color2 == (colorForState2 = this.f876b.d.getColorForState(iArr, (color2 = this.o.getColor())))) {
            z = false;
        } else {
            this.o.setColor(colorForState2);
            z = true;
        }
        if (this.f876b.e == null || color == (colorForState = this.f876b.e.getColorForState(iArr, (color = this.p.getColor())))) {
            return z;
        }
        this.p.setColor(colorForState);
        return true;
    }

    public final boolean v() {
        PorterDuffColorFilter porterDuffColorFilter = this.t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        b bVar = this.f876b;
        this.t = d(bVar.g, bVar.h, this.o, true);
        b bVar2 = this.f876b;
        this.u = d(bVar2.f, bVar2.h, this.p, false);
        b bVar3 = this.f876b;
        if (bVar3.u) {
            this.q.a(bVar3.g.getColorForState(getState(), 0));
        }
        return !b.h.b.a.v(porterDuffColorFilter, this.t) || !b.h.b.a.v(porterDuffColorFilter2, this.u);
    }

    public final void w() {
        b bVar = this.f876b;
        float f = bVar.o + bVar.p;
        bVar.r = (int) Math.ceil(0.75f * f);
        this.f876b.s = (int) Math.ceil(f * 0.25f);
        v();
        super.invalidateSelf();
    }
}
