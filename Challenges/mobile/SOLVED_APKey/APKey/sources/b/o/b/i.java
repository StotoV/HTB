package b.o.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.k;
/* loaded from: classes.dex */
public class i extends AnimatorListenerAdapter {
    public final /* synthetic */ k.a a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f671b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f672c;
    public final /* synthetic */ k d;

    public i(k kVar, k.a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.d = kVar;
        this.a = aVar;
        this.f671b = viewPropertyAnimator;
        this.f672c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f671b.setListener(null);
        this.f672c.setAlpha(1.0f);
        this.f672c.setTranslationX(0.0f);
        this.f672c.setTranslationY(0.0f);
        this.d.c(this.a.a);
        this.d.r.remove(this.a.a);
        this.d.k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        k kVar = this.d;
        RecyclerView.z zVar = this.a.a;
        kVar.getClass();
    }
}
