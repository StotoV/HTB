package c.c.a.a.d;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ c.c.a.a.u.g a;

    public a(AppBarLayout appBarLayout, c.c.a.a.u.g gVar) {
        this.a = gVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
