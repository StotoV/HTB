package c.c.a.a.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class g {
    public final ArrayList<b> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public b f850b = null;

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f851c = null;
    public final Animator.AnimatorListener d = new a();

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g gVar = g.this;
            if (gVar.f851c == animator) {
                gVar.f851c = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public final int[] a;

        /* renamed from: b  reason: collision with root package name */
        public final ValueAnimator f852b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.f852b = valueAnimator;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.d);
        this.a.add(bVar);
    }
}
