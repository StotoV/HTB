package c.c.a.a.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.c.a.a.p.d;
/* loaded from: classes.dex */
public class c extends AnimatorListenerAdapter {
    public final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d.f f838b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f839c;

    public c(d dVar, boolean z, d.f fVar) {
        this.f839c = dVar;
        this.a = z;
        this.f838b = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d dVar = this.f839c;
        dVar.o = 0;
        dVar.j = null;
        d.f fVar = this.f838b;
        if (fVar != null) {
            a aVar = (a) fVar;
            aVar.a.b(aVar.f835b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f839c.s.b(0, this.a);
        d dVar = this.f839c;
        dVar.o = 2;
        dVar.j = animator;
    }
}
