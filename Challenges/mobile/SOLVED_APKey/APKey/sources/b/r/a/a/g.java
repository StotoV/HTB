package b.r.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class g extends b.r.a.a.f {
    public static final PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public h f745c;
    public PorterDuffColorFilter d;
    public ColorFilter e;
    public boolean f;
    public boolean g;
    public final float[] h;
    public final Matrix i;
    public final Rect j;

    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public b(b bVar) {
            super(bVar);
        }

        @Override // b.r.a.a.g.f
        public boolean c() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {
        public int[] e;
        public b.h.c.b.a f;
        public float g;
        public b.h.c.b.a h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public c(c cVar) {
            super(cVar);
            this.g = 0.0f;
            this.i = 1.0f;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            this.i = cVar.i;
            this.h = cVar.h;
            this.f749c = cVar.f749c;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // b.r.a.a.g.e
        public boolean a() {
            return this.h.c() || this.f.c();
        }

        @Override // b.r.a.a.g.e
        public boolean b(int[] iArr) {
            return this.f.d(iArr) | this.h.d(iArr);
        }

        public float getFillAlpha() {
            return this.j;
        }

        public int getFillColor() {
            return this.h.f401c;
        }

        public float getStrokeAlpha() {
            return this.i;
        }

        public int getStrokeColor() {
            return this.f.f401c;
        }

        public float getStrokeWidth() {
            return this.g;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f) {
            this.j = f;
        }

        public void setFillColor(int i) {
            this.h.f401c = i;
        }

        public void setStrokeAlpha(float f) {
            this.i = f;
        }

        public void setStrokeColor(int i) {
            this.f.f401c = i;
        }

        public void setStrokeWidth(float f) {
            this.g = f;
        }

        public void setTrimPathEnd(float f) {
            this.l = f;
        }

        public void setTrimPathOffset(float f) {
            this.m = f;
        }

        public void setTrimPathStart(float f) {
            this.k = f;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends e {
        public final Matrix a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<e> f746b;

        /* renamed from: c  reason: collision with root package name */
        public float f747c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;
        public float i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d() {
            super(null);
            this.a = new Matrix();
            this.f746b = new ArrayList<>();
            this.f747c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }

        public d(d dVar, b.e.a<String, Object> aVar) {
            super(null);
            f bVar;
            this.a = new Matrix();
            this.f746b = new ArrayList<>();
            this.f747c = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 1.0f;
            this.g = 1.0f;
            this.h = 0.0f;
            this.i = 0.0f;
            Matrix matrix = new Matrix();
            this.j = matrix;
            this.m = null;
            this.f747c = dVar.f747c;
            this.d = dVar.d;
            this.e = dVar.e;
            this.f = dVar.f;
            this.g = dVar.g;
            this.h = dVar.h;
            this.i = dVar.i;
            this.l = dVar.l;
            String str = dVar.m;
            this.m = str;
            this.k = dVar.k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.j);
            ArrayList<e> arrayList = dVar.f746b;
            for (int i = 0; i < arrayList.size(); i++) {
                e eVar = arrayList.get(i);
                if (eVar instanceof d) {
                    this.f746b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (!(eVar instanceof b)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    } else {
                        bVar = new b((b) eVar);
                    }
                    this.f746b.add(bVar);
                    String str2 = bVar.f748b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        @Override // b.r.a.a.g.e
        public boolean a() {
            for (int i = 0; i < this.f746b.size(); i++) {
                if (this.f746b.get(i).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // b.r.a.a.g.e
        public boolean b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f746b.size(); i++) {
                z |= this.f746b.get(i).b(iArr);
            }
            return z;
        }

        public final void c() {
            this.j.reset();
            this.j.postTranslate(-this.d, -this.e);
            this.j.postScale(this.f, this.g);
            this.j.postRotate(this.f747c, 0.0f, 0.0f);
            this.j.postTranslate(this.h + this.d, this.i + this.e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.d;
        }

        public float getPivotY() {
            return this.e;
        }

        public float getRotation() {
            return this.f747c;
        }

        public float getScaleX() {
            return this.f;
        }

        public float getScaleY() {
            return this.g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.i;
        }

        public void setPivotX(float f) {
            if (f != this.d) {
                this.d = f;
                c();
            }
        }

        public void setPivotY(float f) {
            if (f != this.e) {
                this.e = f;
                c();
            }
        }

        public void setRotation(float f) {
            if (f != this.f747c) {
                this.f747c = f;
                c();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f) {
                this.f = f;
                c();
            }
        }

        public void setScaleY(float f) {
            if (f != this.g) {
                this.g = f;
                c();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.h) {
                this.h = f;
                c();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.i) {
                this.i = f;
                c();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public e() {
        }

        public e(a aVar) {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f extends e {
        public b.h.d.c[] a;

        /* renamed from: b  reason: collision with root package name */
        public String f748b;

        /* renamed from: c  reason: collision with root package name */
        public int f749c;
        public int d;

        public f() {
            super(null);
            this.a = null;
            this.f749c = 0;
        }

        public f(f fVar) {
            super(null);
            this.a = null;
            this.f749c = 0;
            this.f748b = fVar.f748b;
            this.d = fVar.d;
            this.a = b.h.b.a.u(fVar.a);
        }

        public boolean c() {
            return false;
        }

        public b.h.d.c[] getPathData() {
            return this.a;
        }

        public String getPathName() {
            return this.f748b;
        }

        public void setPathData(b.h.d.c[] cVarArr) {
            if (!b.h.b.a.f(this.a, cVarArr)) {
                this.a = b.h.b.a.u(cVarArr);
                return;
            }
            b.h.d.c[] cVarArr2 = this.a;
            for (int i = 0; i < cVarArr.length; i++) {
                cVarArr2[i].a = cVarArr[i].a;
                for (int i2 = 0; i2 < cVarArr[i].f413b.length; i2++) {
                    cVarArr2[i].f413b[i2] = cVarArr[i].f413b[i2];
                }
            }
        }
    }

    /* renamed from: b.r.a.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034g {
        public static final Matrix q = new Matrix();
        public final Path a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f750b;

        /* renamed from: c  reason: collision with root package name */
        public final Matrix f751c;
        public Paint d;
        public Paint e;
        public PathMeasure f;
        public int g;
        public final d h;
        public float i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final b.e.a<String, Object> p;

        public C0034g() {
            this.f751c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new b.e.a<>();
            this.h = new d();
            this.a = new Path();
            this.f750b = new Path();
        }

        public C0034g(C0034g c0034g) {
            this.f751c = new Matrix();
            this.i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            b.e.a<String, Object> aVar = new b.e.a<>();
            this.p = aVar;
            this.h = new d(c0034g.h, aVar);
            this.a = new Path(c0034g.a);
            this.f750b = new Path(c0034g.f750b);
            this.i = c0034g.i;
            this.j = c0034g.j;
            this.k = c0034g.k;
            this.l = c0034g.l;
            this.g = c0034g.g;
            this.m = c0034g.m;
            this.n = c0034g.n;
            String str = c0034g.n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.o = c0034g.o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v18 */
        public final void a(d dVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            C0034g c0034g;
            C0034g c0034g2 = this;
            dVar.a.set(matrix);
            dVar.a.preConcat(dVar.j);
            canvas.save();
            ?? r11 = 0;
            int i3 = 0;
            while (i3 < dVar.f746b.size()) {
                e eVar = dVar.f746b.get(i3);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.a, canvas, i, i2, colorFilter);
                } else if (eVar instanceof f) {
                    f fVar = (f) eVar;
                    float f = i / c0034g2.k;
                    float f2 = i2 / c0034g2.l;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = dVar.a;
                    c0034g2.f751c.set(matrix2);
                    c0034g2.f751c.postScale(f, f2);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    char c2 = r11 == true ? 1 : 0;
                    char c3 = r11 == true ? 1 : 0;
                    float f3 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot(fArr[c2], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f3) / max : 0.0f;
                    if (abs == 0.0f) {
                        c0034g = this;
                    } else {
                        c0034g = this;
                        Path path = c0034g.a;
                        fVar.getClass();
                        path.reset();
                        b.h.d.c[] cVarArr = fVar.a;
                        if (cVarArr != null) {
                            b.h.d.c.b(cVarArr, path);
                        }
                        Path path2 = c0034g.a;
                        c0034g.f750b.reset();
                        if (fVar.c()) {
                            c0034g.f750b.setFillType(fVar.f749c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            c0034g.f750b.addPath(path2, c0034g.f751c);
                            canvas.clipPath(c0034g.f750b);
                        } else {
                            c cVar = (c) fVar;
                            float f4 = cVar.k;
                            if (f4 != 0.0f || cVar.l != 1.0f) {
                                float f5 = cVar.m;
                                float f6 = (f4 + f5) % 1.0f;
                                float f7 = (cVar.l + f5) % 1.0f;
                                if (c0034g.f == null) {
                                    c0034g.f = new PathMeasure();
                                }
                                c0034g.f.setPath(c0034g.a, r11);
                                float length = c0034g.f.getLength();
                                float f8 = f6 * length;
                                float f9 = f7 * length;
                                path2.reset();
                                if (f8 > f9) {
                                    c0034g.f.getSegment(f8, length, path2, true);
                                    c0034g.f.getSegment(0.0f, f9, path2, true);
                                } else {
                                    c0034g.f.getSegment(f8, f9, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            c0034g.f750b.addPath(path2, c0034g.f751c);
                            b.h.c.b.a aVar = cVar.h;
                            if (aVar.b() || aVar.f401c != 0) {
                                b.h.c.b.a aVar2 = cVar.h;
                                if (c0034g.e == null) {
                                    Paint paint = new Paint(1);
                                    c0034g.e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = c0034g.e;
                                if (aVar2.b()) {
                                    Shader shader = aVar2.a;
                                    shader.setLocalMatrix(c0034g.f751c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(cVar.j * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i4 = aVar2.f401c;
                                    float f10 = cVar.j;
                                    PorterDuff.Mode mode = g.k;
                                    paint2.setColor((i4 & 16777215) | (((int) (Color.alpha(i4) * f10)) << 24));
                                }
                                paint2.setColorFilter(colorFilter);
                                c0034g.f750b.setFillType(cVar.f749c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(c0034g.f750b, paint2);
                            }
                            b.h.c.b.a aVar3 = cVar.f;
                            if (aVar3.b() || aVar3.f401c != 0) {
                                b.h.c.b.a aVar4 = cVar.f;
                                if (c0034g.d == null) {
                                    Paint paint3 = new Paint(1);
                                    c0034g.d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = c0034g.d;
                                Paint.Join join = cVar.o;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = cVar.n;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(cVar.p);
                                if (aVar4.b()) {
                                    Shader shader2 = aVar4.a;
                                    shader2.setLocalMatrix(c0034g.f751c);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(cVar.i * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i5 = aVar4.f401c;
                                    float f11 = cVar.i;
                                    PorterDuff.Mode mode2 = g.k;
                                    paint4.setColor((i5 & 16777215) | (((int) (Color.alpha(i5) * f11)) << 24));
                                }
                                paint4.setColorFilter(colorFilter);
                                paint4.setStrokeWidth(cVar.g * abs * min);
                                canvas.drawPath(c0034g.f750b, paint4);
                            }
                        }
                    }
                    i3++;
                    c0034g2 = c0034g;
                    r11 = 0;
                }
                c0034g = c0034g2;
                i3++;
                c0034g2 = c0034g;
                r11 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.m = i;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public C0034g f752b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f753c;
        public PorterDuff.Mode d;
        public boolean e;
        public Bitmap f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public int i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h() {
            this.f753c = null;
            this.d = g.k;
            this.f752b = new C0034g();
        }

        public h(h hVar) {
            this.f753c = null;
            this.d = g.k;
            if (hVar != null) {
                this.a = hVar.a;
                C0034g c0034g = new C0034g(hVar.f752b);
                this.f752b = c0034g;
                if (hVar.f752b.e != null) {
                    c0034g.e = new Paint(hVar.f752b.e);
                }
                if (hVar.f752b.d != null) {
                    this.f752b.d = new Paint(hVar.f752b.d);
                }
                this.f753c = hVar.f753c;
                this.d = hVar.d;
                this.e = hVar.e;
            }
        }

        public boolean a() {
            C0034g c0034g = this.f752b;
            if (c0034g.o == null) {
                c0034g.o = Boolean.valueOf(c0034g.h.a());
            }
            return c0034g.o.booleanValue();
        }

        public void b(int i, int i2) {
            this.f.eraseColor(0);
            Canvas canvas = new Canvas(this.f);
            C0034g c0034g = this.f752b;
            c0034g.a(c0034g.h, C0034g.q, canvas, i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new g(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new g(this);
        }
    }

    /* loaded from: classes.dex */
    public static class i extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public i(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g();
            gVar.f744b = (VectorDrawable) this.a.newDrawable();
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            gVar.f744b = (VectorDrawable) this.a.newDrawable(resources);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            g gVar = new g();
            gVar.f744b = (VectorDrawable) this.a.newDrawable(resources, theme);
            return gVar;
        }
    }

    public g() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f745c = new h();
    }

    public g(h hVar) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.f745c = hVar;
        this.d = b(hVar.f753c, hVar.d);
    }

    public static g a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = new g();
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    public PorterDuffColorFilter b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.e(drawable);
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f.getHeight()) == false) goto L68;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.a.a.g.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            if (Build.VERSION.SDK_INT < 19) {
                return 0;
            }
            return drawable.getAlpha();
        }
        return this.f745c.f752b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f745c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return drawable.getColorFilter();
        }
        return this.e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f744b == null || Build.VERSION.SDK_INT < 24) {
            this.f745c.a = getChangingConfigurations();
            return this.f745c;
        }
        return new i(this.f744b.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f745c.f752b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f745c.f752b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:222:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0101  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void inflate(android.content.res.Resources r28, org.xmlpull.v1.XmlPullParser r29, android.util.AttributeSet r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.a.a.g.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f744b;
        return drawable != null ? b.h.b.a.F(drawable) : this.f745c.e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f745c) != null && (hVar.a() || ((colorStateList = this.f745c.f753c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f && super.mutate() == this) {
            this.f745c = new h(this.f745c);
            this.f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f744b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f745c;
        ColorStateList colorStateList = hVar.f753c;
        if (colorStateList != null && (mode = hVar.d) != null) {
            this.d = b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.a()) {
            boolean b2 = hVar.f752b.h.b(iArr);
            hVar.k |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f745c.f752b.getRootAlpha() == i2) {
        } else {
            this.f745c.f752b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.Q(drawable, z);
        } else {
            this.f745c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.e = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTint(int i2) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.f0(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.g0(drawable, colorStateList);
            return;
        }
        h hVar = this.f745c;
        if (hVar.f753c == colorStateList) {
            return;
        }
        hVar.f753c = colorStateList;
        this.d = b(colorStateList, hVar.d);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.h0(drawable, mode);
            return;
        }
        h hVar = this.f745c;
        if (hVar.d == mode) {
            return;
        }
        hVar.d = mode;
        this.d = b(hVar.f753c, mode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
