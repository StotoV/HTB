package b.k.b;

import android.view.ViewGroup;
import android.view.animation.Animation;
import b.k.b.c0;
import b.k.b.r0;
/* loaded from: classes.dex */
public class r implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f588b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r0.a f589c;
    public final /* synthetic */ b.h.f.a d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.f588b.h() != null) {
                r.this.f588b.k0(null);
                r rVar = r.this;
                ((c0.d) rVar.f589c).a(rVar.f588b, rVar.d);
            }
        }
    }

    public r(ViewGroup viewGroup, m mVar, r0.a aVar, b.h.f.a aVar2) {
        this.a = viewGroup;
        this.f588b = mVar;
        this.f589c = aVar;
        this.d = aVar2;
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
