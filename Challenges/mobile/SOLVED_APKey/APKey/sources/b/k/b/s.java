package b.k.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.k.b.c0;
import b.k.b.m;
import b.k.b.r0;
/* loaded from: classes.dex */
public class s extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f595b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f596c;
    public final /* synthetic */ r0.a d;
    public final /* synthetic */ b.h.f.a e;

    public s(ViewGroup viewGroup, View view, m mVar, r0.a aVar, b.h.f.a aVar2) {
        this.a = viewGroup;
        this.f595b = view;
        this.f596c = mVar;
        this.d = aVar;
        this.e = aVar2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.f595b);
        m mVar = this.f596c;
        m.b bVar = mVar.I;
        Animator animator2 = bVar == null ? null : bVar.f577b;
        mVar.m0(null);
        if (animator2 == null || this.a.indexOfChild(this.f595b) >= 0) {
            return;
        }
        ((c0.d) this.d).a(this.f596c, this.e);
    }
}
