package b.o.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.k;
/* loaded from: classes.dex */
public class j extends AnimatorListenerAdapter {
    public final /* synthetic */ k.a a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f673b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f674c;
    public final /* synthetic */ k d;

    public j(k kVar, k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.a = aVar;
        this.f673b = viewPropertyAnimator;
        this.f674c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f673b.setListener(null);
        this.f674c.setAlpha(1.0f);
        this.f674c.setTranslationX(0.0f);
        this.f674c.setTranslationY(0.0f);
        this.d.c(this.a.f675b);
        this.d.r.remove(this.a.f675b);
        this.d.k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        k kVar = this.d;
        RecyclerView.z zVar = this.a.f675b;
        kVar.getClass();
    }
}
