package b.h.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import b.b.c.g;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class x {
    public WeakReference<View> a;

    /* renamed from: b  reason: collision with root package name */
    public int f497b = -1;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ y a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f498b;

        public a(x xVar, y yVar, View view) {
            this.a = yVar;
            this.f498b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.c(this.f498b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.a(this.f498b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.b(this.f498b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f499b;

        public b(x xVar, a0 a0Var, View view) {
            this.a = a0Var;
            this.f499b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) ((g.a) this.a).a.f137b.getParent()).invalidate();
        }
    }

    public x(View view) {
        this.a = new WeakReference<>(view);
    }

    public void a() {
        View view = this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public x b(long j) {
        View view = this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    public x c(y yVar) {
        View view = this.a.get();
        if (view != null) {
            d(view, yVar);
        }
        return this;
    }

    public final void d(View view, y yVar) {
        if (yVar != null) {
            view.animate().setListener(new a(this, yVar, view));
        } else {
            view.animate().setListener(null);
        }
    }

    public x e(a0 a0Var) {
        View view = this.a.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            b bVar = null;
            if (a0Var != null) {
                bVar = new b(this, a0Var, view);
            }
            view.animate().setUpdateListener(bVar);
        }
        return this;
    }

    public x f(float f) {
        View view = this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
