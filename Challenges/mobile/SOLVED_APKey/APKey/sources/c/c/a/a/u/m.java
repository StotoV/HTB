package c.c.a.a.u;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    @Deprecated
    public float a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f888b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f889c;
    @Deprecated
    public float d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    public final List<e> g = new ArrayList();
    public final List<f> h = new ArrayList();

    /* loaded from: classes.dex */
    public static class a extends f {

        /* renamed from: b  reason: collision with root package name */
        public final c f890b;

        public a(c cVar) {
            this.f890b = cVar;
        }

        @Override // c.c.a.a.u.m.f
        public void a(Matrix matrix, c.c.a.a.t.a aVar, int i, Canvas canvas) {
            c cVar = this.f890b;
            float f = cVar.f;
            float f2 = cVar.g;
            c cVar2 = this.f890b;
            RectF rectF = new RectF(cVar2.f893b, cVar2.f894c, cVar2.d, cVar2.e);
            boolean z = f2 < 0.0f;
            Path path = aVar.g;
            if (z) {
                int[] iArr = c.c.a.a.t.a.k;
                iArr[0] = 0;
                iArr[1] = aVar.f;
                iArr[2] = aVar.e;
                iArr[3] = aVar.d;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = -i;
                rectF.inset(f3, f3);
                int[] iArr2 = c.c.a.a.t.a.k;
                iArr2[0] = 0;
                iArr2[1] = aVar.d;
                iArr2[2] = aVar.e;
                iArr2[3] = aVar.f;
            }
            float width = rectF.width() / 2.0f;
            if (width <= 0.0f) {
                return;
            }
            float f4 = 1.0f - (i / width);
            float[] fArr = c.c.a.a.t.a.l;
            fArr[1] = f4;
            fArr[2] = ((1.0f - f4) / 2.0f) + f4;
            aVar.f873b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, c.c.a.a.t.a.k, fArr, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix);
            if (!z) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
                canvas.drawPath(path, aVar.h);
            }
            canvas.drawArc(rectF, f, f2, true, aVar.f873b);
            canvas.restore();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends f {

        /* renamed from: b  reason: collision with root package name */
        public final d f891b;

        /* renamed from: c  reason: collision with root package name */
        public final float f892c;
        public final float d;

        public b(d dVar, float f, float f2) {
            this.f891b = dVar;
            this.f892c = f;
            this.d = f2;
        }

        @Override // c.c.a.a.u.m.f
        public void a(Matrix matrix, c.c.a.a.t.a aVar, int i, Canvas canvas) {
            d dVar = this.f891b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(dVar.f896c - this.d, dVar.f895b - this.f892c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f892c, this.d);
            matrix2.preRotate(b());
            aVar.getClass();
            rectF.bottom += i;
            rectF.offset(0.0f, -i);
            int[] iArr = c.c.a.a.t.a.i;
            iArr[0] = aVar.f;
            iArr[1] = aVar.e;
            iArr[2] = aVar.d;
            Paint paint = aVar.f874c;
            float f = rectF.left;
            paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, iArr, c.c.a.a.t.a.j, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.f874c);
            canvas.restore();
        }

        public float b() {
            d dVar = this.f891b;
            return (float) Math.toDegrees(Math.atan((dVar.f896c - this.d) / (dVar.f895b - this.f892c)));
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e {
        public static final RectF h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f893b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f894c;
        @Deprecated
        public float d;
        @Deprecated
        public float e;
        @Deprecated
        public float f;
        @Deprecated
        public float g;

        public c(float f, float f2, float f3, float f4) {
            this.f893b = f;
            this.f894c = f2;
            this.d = f3;
            this.e = f4;
        }

        @Override // c.c.a.a.u.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = h;
            rectF.set(this.f893b, this.f894c, this.d, this.e);
            path.arcTo(rectF, this.f, this.g, false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: b  reason: collision with root package name */
        public float f895b;

        /* renamed from: c  reason: collision with root package name */
        public float f896c;

        @Override // c.c.a.a.u.m.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f895b, this.f896c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
        public final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, c.c.a.a.t.a aVar, int i, Canvas canvas);
    }

    public m() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.f = f6;
        cVar.g = f7;
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.h.add(aVar);
        this.e = f9;
        double d2 = f8;
        this.f889c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.e;
        if (f3 == f2) {
            return;
        }
        float f4 = ((f2 - f3) + 360.0f) % 360.0f;
        if (f4 > 180.0f) {
            return;
        }
        float f5 = this.f889c;
        float f6 = this.d;
        c cVar = new c(f5, f6, f5, f6);
        cVar.f = this.e;
        cVar.g = f4;
        this.h.add(new a(cVar));
        this.e = f2;
    }

    public void c(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.f895b = f2;
        dVar.f896c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, this.f889c, this.d);
        b(bVar.b() + 270.0f);
        this.h.add(bVar);
        this.e = bVar.b() + 270.0f;
        this.f889c = f2;
        this.d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.f888b = f3;
        this.f889c = f2;
        this.d = f3;
        this.e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
