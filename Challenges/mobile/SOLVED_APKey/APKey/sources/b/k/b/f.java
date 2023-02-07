package b.k.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import b.k.b.c;
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f545b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c.b f546c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.a.endViewTransition(fVar.f545b);
            f.this.f546c.a();
        }
    }

    public f(c cVar, ViewGroup viewGroup, View view, c.b bVar) {
        this.a = viewGroup;
        this.f545b = view;
        this.f546c = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
