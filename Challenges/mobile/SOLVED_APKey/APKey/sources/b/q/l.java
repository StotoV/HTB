package b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* loaded from: classes.dex */
public class l extends AnimatorListenerAdapter {
    public final /* synthetic */ b.e.a a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f723b;

    public l(k kVar, b.e.a aVar) {
        this.f723b = kVar;
        this.a = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.remove(animator);
        this.f723b.n.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f723b.n.add(animator);
    }
}
