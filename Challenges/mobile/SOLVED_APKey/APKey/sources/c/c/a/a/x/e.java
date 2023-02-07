package c.c.a.a.x;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public e(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.f914c.setScaleX(floatValue);
        this.a.f914c.setScaleY(floatValue);
    }
}
