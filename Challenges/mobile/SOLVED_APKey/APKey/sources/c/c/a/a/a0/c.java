package c.c.a.a.a0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.c.a.a.k.d;
import com.google.android.material.transformation.FabTransformationBehavior;
/* loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ c.c.a.a.k.d a;

    public c(FabTransformationBehavior fabTransformationBehavior, c.c.a.a.k.d dVar) {
        this.a = dVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d.e revealInfo = this.a.getRevealInfo();
        revealInfo.f791c = Float.MAX_VALUE;
        this.a.setRevealInfo(revealInfo);
    }
}
