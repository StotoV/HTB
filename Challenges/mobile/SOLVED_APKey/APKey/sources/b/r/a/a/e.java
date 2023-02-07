package b.r.a.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import b.h.c.b.h;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class e implements Interpolator {
    public float[] a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f743b;

    public e(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray e = h.e(context.getResources(), context.getTheme(), attributeSet, a.l);
        if (h.c(xmlPullParser, "pathData")) {
            String b2 = h.b(e, xmlPullParser, "pathData", 4);
            Path t = b.h.b.a.t(b2);
            if (t == null) {
                throw new InflateException(c.a.a.a.a.d("The path is null, which is created from ", b2));
            }
            a(t);
        } else if (!h.c(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else {
            if (!h.c(xmlPullParser, "controlY1")) {
                throw new InflateException("pathInterpolator requires the controlY1 attribute");
            }
            float f = !h.c(xmlPullParser, "controlX1") ? 0.0f : e.getFloat(0, 0.0f);
            float f2 = !h.c(xmlPullParser, "controlY1") ? 0.0f : e.getFloat(1, 0.0f);
            boolean c2 = h.c(xmlPullParser, "controlX2");
            if (c2 != h.c(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            }
            if (!c2) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(f, f2, 1.0f, 1.0f);
                a(path);
            } else {
                float f3 = !h.c(xmlPullParser, "controlX2") ? 0.0f : e.getFloat(2, 0.0f);
                float f4 = !h.c(xmlPullParser, "controlY2") ? 0.0f : e.getFloat(3, 0.0f);
                Path path2 = new Path();
                path2.moveTo(0.0f, 0.0f);
                path2.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
                a(path2);
            }
        }
        e.recycle();
    }

    public final void a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.a = new float[min];
        this.f743b = new float[min];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((i2 * length) / (min - 1), fArr, null);
            this.a[i2] = fArr[0];
            this.f743b[i2] = fArr[1];
        }
        if (Math.abs(this.a[0]) <= 1.0E-5d && Math.abs(this.f743b[0]) <= 1.0E-5d) {
            int i3 = min - 1;
            if (Math.abs(this.a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f743b[i3] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i4 = 0;
                while (i < min) {
                    float[] fArr2 = this.a;
                    int i5 = i4 + 1;
                    float f2 = fArr2[i4];
                    if (f2 < f) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                    }
                    fArr2[i] = f2;
                    i++;
                    f = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder g = c.a.a.a.a.g("The Path must start at (0,0) and end at (1,1) start: ");
        g.append(this.a[0]);
        g.append(",");
        g.append(this.f743b[0]);
        g.append(" end:");
        int i6 = min - 1;
        g.append(this.a[i6]);
        g.append(",");
        g.append(this.f743b[i6]);
        throw new IllegalArgumentException(g.toString());
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.a;
        float f2 = fArr[length] - fArr[i];
        if (f2 == 0.0f) {
            return this.f743b[i];
        }
        float[] fArr2 = this.f743b;
        float f3 = fArr2[i];
        return c.a.a.a.a.a(fArr2[length], f3, (f - fArr[i]) / f2, f3);
    }
}
