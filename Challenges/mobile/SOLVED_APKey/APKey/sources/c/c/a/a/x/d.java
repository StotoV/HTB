package c.c.a.a.x;

import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public class d implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ a a;

    public d(a aVar) {
        this.a = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.f914c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
