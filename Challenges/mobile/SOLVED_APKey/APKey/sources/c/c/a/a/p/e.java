package c.c.a.a.p;

import android.animation.FloatEvaluator;
import android.animation.TypeEvaluator;
/* loaded from: classes.dex */
public class e implements TypeEvaluator<Float> {
    public FloatEvaluator a = new FloatEvaluator();

    public e(d dVar) {
    }

    @Override // android.animation.TypeEvaluator
    public Float evaluate(float f, Float f2, Float f3) {
        float floatValue = this.a.evaluate(f, (Number) f2, (Number) f3).floatValue();
        if (floatValue < 0.1f) {
            floatValue = 0.0f;
        }
        return Float.valueOf(floatValue);
    }
}
