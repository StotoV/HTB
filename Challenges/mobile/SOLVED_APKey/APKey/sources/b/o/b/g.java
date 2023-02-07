package b.o.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class g extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.z a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f667b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f668c;
    public final /* synthetic */ k d;

    public g(k kVar, RecyclerView.z zVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.d = kVar;
        this.a = zVar;
        this.f667b = view;
        this.f668c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f667b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f668c.setListener(null);
        this.d.c(this.a);
        this.d.o.remove(this.a);
        this.d.k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.getClass();
    }
}
