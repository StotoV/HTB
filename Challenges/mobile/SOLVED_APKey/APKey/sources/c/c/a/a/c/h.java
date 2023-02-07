package c.c.a.a.c;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
/* loaded from: classes.dex */
public class h {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f765b;

    /* renamed from: c  reason: collision with root package name */
    public TimeInterpolator f766c;
    public int d;
    public int e;

    public h(long j, long j2) {
        this.a = 0L;
        this.f765b = 300L;
        this.f766c = null;
        this.d = 0;
        this.e = 1;
        this.a = j;
        this.f765b = j2;
    }

    public h(long j, long j2, TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.f765b = 300L;
        this.f766c = null;
        this.d = 0;
        this.e = 1;
        this.a = j;
        this.f765b = j2;
        this.f766c = timeInterpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(this.a);
        animator.setDuration(this.f765b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.d);
            valueAnimator.setRepeatMode(this.e);
        }
    }

    public TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f766c;
        return timeInterpolator != null ? timeInterpolator : a.f759b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.a != hVar.a || this.f765b != hVar.f765b || this.d != hVar.d || this.e != hVar.e) {
            return false;
        }
        return b().getClass().equals(hVar.b().getClass());
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.f765b;
        return ((((b().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return '\n' + h.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.a + " duration: " + this.f765b + " interpolator: " + b().getClass() + " repeatCount: " + this.d + " repeatMode: " + this.e + "}\n";
    }
}
