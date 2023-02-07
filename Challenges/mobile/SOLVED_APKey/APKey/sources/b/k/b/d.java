package b.k.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.k.b.c;
import b.k.b.y0;
/* loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {
    public final /* synthetic */ ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f541b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f542c;
    public final /* synthetic */ y0.d d;
    public final /* synthetic */ c.b e;

    public d(c cVar, ViewGroup viewGroup, View view, boolean z, y0.d dVar, c.b bVar) {
        this.a = viewGroup;
        this.f541b = view;
        this.f542c = z;
        this.d = dVar;
        this.e = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.a.endViewTransition(this.f541b);
        if (this.f542c) {
            this.d.a.a(this.f541b);
        }
        this.e.a();
    }
}
