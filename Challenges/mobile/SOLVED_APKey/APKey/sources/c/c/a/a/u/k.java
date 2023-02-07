package c.c.a.a.u;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import c.c.a.a.u.g;
import c.c.a.a.u.m;
import java.util.ArrayList;
import java.util.BitSet;
/* loaded from: classes.dex */
public class k {
    public final m[] a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    public final Matrix[] f884b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    public final Matrix[] f885c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final m g = new m();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public boolean l = true;

    /* loaded from: classes.dex */
    public static class a {
        public static final k a = new k();
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public k() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new m();
            this.f884b[i] = new Matrix();
            this.f885c[i] = new Matrix();
        }
    }

    public void a(j jVar, float f, RectF rectF, b bVar, Path path) {
        int i;
        float[] fArr;
        float centerX;
        float f2;
        f fVar;
        m mVar;
        Matrix matrix;
        Path path2;
        c cVar;
        d dVar;
        float f3;
        float f4;
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        int i2 = 0;
        while (true) {
            if (i2 >= 4) {
                break;
            }
            if (i2 == 1) {
                cVar = jVar.g;
            } else if (i2 == 2) {
                cVar = jVar.h;
            } else if (i2 != 3) {
                cVar = jVar.f;
            } else {
                cVar = jVar.e;
            }
            if (i2 == 1) {
                dVar = jVar.f881c;
            } else if (i2 == 2) {
                dVar = jVar.d;
            } else if (i2 != 3) {
                dVar = jVar.f880b;
            } else {
                dVar = jVar.a;
            }
            m mVar2 = this.a[i2];
            dVar.getClass();
            dVar.a(mVar2, 90.0f, f, cVar.a(rectF));
            int i3 = i2 + 1;
            float f5 = i3 * 90;
            this.f884b[i2].reset();
            PointF pointF = this.d;
            if (i2 == 1) {
                f3 = rectF.right;
            } else if (i2 != 2) {
                f3 = i2 != 3 ? rectF.right : rectF.left;
                f4 = rectF.top;
                pointF.set(f3, f4);
                Matrix matrix2 = this.f884b[i2];
                PointF pointF2 = this.d;
                matrix2.setTranslate(pointF2.x, pointF2.y);
                this.f884b[i2].preRotate(f5);
                float[] fArr2 = this.h;
                m[] mVarArr = this.a;
                fArr2[0] = mVarArr[i2].f889c;
                fArr2[1] = mVarArr[i2].d;
                this.f884b[i2].mapPoints(fArr2);
                this.f885c[i2].reset();
                Matrix matrix3 = this.f885c[i2];
                float[] fArr3 = this.h;
                matrix3.setTranslate(fArr3[0], fArr3[1]);
                this.f885c[i2].preRotate(f5);
                i2 = i3;
            } else {
                f3 = rectF.left;
            }
            f4 = rectF.bottom;
            pointF.set(f3, f4);
            Matrix matrix22 = this.f884b[i2];
            PointF pointF22 = this.d;
            matrix22.setTranslate(pointF22.x, pointF22.y);
            this.f884b[i2].preRotate(f5);
            float[] fArr22 = this.h;
            m[] mVarArr2 = this.a;
            fArr22[0] = mVarArr2[i2].f889c;
            fArr22[1] = mVarArr2[i2].d;
            this.f884b[i2].mapPoints(fArr22);
            this.f885c[i2].reset();
            Matrix matrix32 = this.f885c[i2];
            float[] fArr32 = this.h;
            matrix32.setTranslate(fArr32[0], fArr32[1]);
            this.f885c[i2].preRotate(f5);
            i2 = i3;
        }
        int i4 = 0;
        for (i = 4; i4 < i; i = 4) {
            float[] fArr4 = this.h;
            m[] mVarArr3 = this.a;
            fArr4[0] = mVarArr3[i4].a;
            fArr4[1] = mVarArr3[i4].f888b;
            this.f884b[i4].mapPoints(fArr4);
            float[] fArr5 = this.h;
            if (i4 == 0) {
                path.moveTo(fArr5[0], fArr5[1]);
            } else {
                path.lineTo(fArr5[0], fArr5[1]);
            }
            this.a[i4].c(this.f884b[i4], path);
            if (bVar != null) {
                m mVar3 = this.a[i4];
                Matrix matrix4 = this.f884b[i4];
                g.a aVar = (g.a) bVar;
                BitSet bitSet = g.this.e;
                mVar3.getClass();
                bitSet.set(i4, false);
                m.f[] fVarArr = g.this.f877c;
                mVar3.b(mVar3.f);
                fVarArr[i4] = new l(mVar3, new ArrayList(mVar3.h), new Matrix(matrix4));
            }
            int i5 = i4 + 1;
            int i6 = i5 % 4;
            float[] fArr6 = this.h;
            m[] mVarArr4 = this.a;
            fArr6[0] = mVarArr4[i4].f889c;
            fArr6[1] = mVarArr4[i4].d;
            this.f884b[i4].mapPoints(fArr6);
            float[] fArr7 = this.i;
            m[] mVarArr5 = this.a;
            fArr7[0] = mVarArr5[i6].a;
            fArr7[1] = mVarArr5[i6].f888b;
            this.f884b[i6].mapPoints(fArr7);
            float f6 = this.h[0];
            float[] fArr8 = this.i;
            float max = Math.max(((float) Math.hypot(f6 - fArr8[0], fArr[1] - fArr8[1])) - 0.001f, 0.0f);
            float[] fArr9 = this.h;
            m[] mVarArr6 = this.a;
            fArr9[0] = mVarArr6[i4].f889c;
            fArr9[1] = mVarArr6[i4].d;
            this.f884b[i4].mapPoints(fArr9);
            if (i4 == 1 || i4 == 3) {
                centerX = rectF.centerX();
                f2 = this.h[0];
            } else {
                centerX = rectF.centerY();
                f2 = this.h[1];
            }
            float abs = Math.abs(centerX - f2);
            this.g.e(0.0f, 0.0f, 270.0f, 0.0f);
            if (i4 == 1) {
                fVar = jVar.k;
            } else if (i4 == 2) {
                fVar = jVar.l;
            } else if (i4 != 3) {
                fVar = jVar.j;
            } else {
                fVar = jVar.i;
            }
            fVar.a(max, abs, f, this.g);
            this.j.reset();
            this.g.c(this.f885c[i4], this.j);
            if (!this.l || Build.VERSION.SDK_INT < 19 || (!b(this.j, i4) && !b(this.j, i6))) {
                mVar = this.g;
                matrix = this.f885c[i4];
                path2 = path;
            } else {
                Path path3 = this.j;
                path3.op(path3, this.f, Path.Op.DIFFERENCE);
                float[] fArr10 = this.h;
                m mVar4 = this.g;
                fArr10[0] = mVar4.a;
                fArr10[1] = mVar4.f888b;
                this.f885c[i4].mapPoints(fArr10);
                Path path4 = this.e;
                float[] fArr11 = this.h;
                path4.moveTo(fArr11[0], fArr11[1]);
                mVar = this.g;
                matrix = this.f885c[i4];
                path2 = this.e;
            }
            mVar.c(matrix, path2);
            if (bVar != null) {
                m mVar5 = this.g;
                Matrix matrix5 = this.f885c[i4];
                g.a aVar2 = (g.a) bVar;
                mVar5.getClass();
                g.this.e.set(i4 + 4, false);
                m.f[] fVarArr2 = g.this.d;
                mVar5.b(mVar5.f);
                fVarArr2[i4] = new l(mVar5, new ArrayList(mVar5.h), new Matrix(matrix5));
            }
            i4 = i5;
        }
        path.close();
        this.e.close();
        if (Build.VERSION.SDK_INT < 19 || this.e.isEmpty()) {
            return;
        }
        path.op(this.e, Path.Op.UNION);
    }

    public final boolean b(Path path, int i) {
        this.k.reset();
        this.a[i].c(this.f884b[i], this.k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.k.computeBounds(rectF, true);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }
}
