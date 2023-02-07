package c.c.a.a.a0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import com.google.android.material.transformation.FabTransformationBehavior;
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {
    public final /* synthetic */ c.c.a.a.k.d a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Drawable f756b;

    public b(FabTransformationBehavior fabTransformationBehavior, c.c.a.a.k.d dVar, Drawable drawable) {
        this.a = dVar;
        this.f756b = drawable;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.a.setCircularRevealOverlayDrawable(this.f756b);
    }
}
