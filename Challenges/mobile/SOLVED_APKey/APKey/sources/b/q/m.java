package b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public class m extends AnimatorListenerAdapter {
    public final /* synthetic */ k a;

    public m(k kVar) {
        this.a = kVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.m();
        animator.removeListener(this);
    }
}
