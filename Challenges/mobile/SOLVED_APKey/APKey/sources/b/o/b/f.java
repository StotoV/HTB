package b.o.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class f extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.z a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f665b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f666c;
    public final /* synthetic */ k d;

    public f(k kVar, RecyclerView.z zVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.a = zVar;
        this.f665b = viewPropertyAnimator;
        this.f666c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f665b.setListener(null);
        this.f666c.setAlpha(1.0f);
        this.d.c(this.a);
        this.d.q.remove(this.a);
        this.d.k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.getClass();
    }
}
