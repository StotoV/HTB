package c.c.a.a.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import c.c.a.a.p.d;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
/* loaded from: classes.dex */
public class b extends AnimatorListenerAdapter {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f836b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d.f f837c;
    public final /* synthetic */ d d;

    public b(d dVar, boolean z, d.f fVar) {
        this.d = dVar;
        this.f836b = z;
        this.f837c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d dVar = this.d;
        dVar.o = 0;
        dVar.j = null;
        if (!this.a) {
            FloatingActionButton floatingActionButton = dVar.s;
            boolean z = this.f836b;
            floatingActionButton.b(z ? 8 : 4, z);
            d.f fVar = this.f837c;
            if (fVar == null) {
                return;
            }
            a aVar = (a) fVar;
            aVar.a.a(aVar.f835b);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.d.s.b(0, this.f836b);
        d dVar = this.d;
        dVar.o = 1;
        dVar.j = animator;
        this.a = false;
    }
}
