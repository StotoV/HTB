package b.o.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class h extends AnimatorListenerAdapter {
    public final /* synthetic */ RecyclerView.z a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f669b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f670c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ViewPropertyAnimator e;
    public final /* synthetic */ k f;

    public h(k kVar, RecyclerView.z zVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f = kVar;
        this.a = zVar;
        this.f669b = i;
        this.f670c = view;
        this.d = i2;
        this.e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.f669b != 0) {
            this.f670c.setTranslationX(0.0f);
        }
        if (this.d != 0) {
            this.f670c.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.e.setListener(null);
        this.f.c(this.a);
        this.f.p.remove(this.a);
        this.f.k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f.getClass();
    }
}
