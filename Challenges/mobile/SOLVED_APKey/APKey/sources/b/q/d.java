package b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d extends i0 {

    /* loaded from: classes.dex */
    public class a extends n {
        public final /* synthetic */ View a;

        public a(d dVar, View view) {
            this.a = view;
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            View view = this.a;
            g0 g0Var = a0.a;
            g0Var.e(view, 1.0f);
            g0Var.a(this.a);
            kVar.v(this);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f703b = false;

        public b(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a0.a.e(this.a, 1.0f);
            if (this.f703b) {
                this.a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view = this.a;
            AtomicInteger atomicInteger = b.h.j.q.a;
            if (!view.hasOverlappingRendering() || this.a.getLayerType() != 0) {
                return;
            }
            this.f703b = true;
            this.a.setLayerType(2, null);
        }
    }

    public d(int i) {
        if ((i & (-4)) == 0) {
            this.y = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // b.q.i0
    public Animator J(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        a0.a.c(view);
        Float f = (Float) sVar.a.get("android:fade:transitionAlpha");
        return K(view, f != null ? f.floatValue() : 1.0f, 0.0f);
    }

    public final Animator K(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        a0.a.e(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, a0.f699b, f2);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    @Override // b.q.k
    public void g(s sVar) {
        H(sVar);
        sVar.a.put("android:fade:transitionAlpha", Float.valueOf(a0.a(sVar.f731b)));
    }
}
