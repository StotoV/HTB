package b.q;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
/* loaded from: classes.dex */
public class g<T> extends Property<T, Float> {
    public final Property<T, PointF> a;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f707b;

    /* renamed from: c  reason: collision with root package name */
    public final float f708c;
    public final float[] d;
    public final PointF e;
    public float f;

    public g(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f707b = pathMeasure;
        this.f708c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    public Float get(Object obj) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    public void set(Object obj, Float f) {
        Float f2 = f;
        this.f = f2.floatValue();
        this.f707b.getPosTan(f2.floatValue() * this.f708c, this.d, null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.a.set(obj, pointF);
    }
}
