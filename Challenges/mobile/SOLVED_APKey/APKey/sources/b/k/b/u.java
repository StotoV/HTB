package b.k.b;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
public class u extends AnimationSet implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f603b;

    /* renamed from: c  reason: collision with root package name */
    public final View f604c;
    public boolean d;
    public boolean e;
    public boolean f;

    public u(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f = true;
        this.f603b = viewGroup;
        this.f604c = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation) {
        this.f = true;
        if (this.d) {
            return !this.e;
        }
        if (!super.getTransformation(j, transformation)) {
            this.d = true;
            b.h.j.o.a(this.f603b, this);
        }
        return true;
    }

    @Override // android.view.animation.Animation
    public boolean getTransformation(long j, Transformation transformation, float f) {
        this.f = true;
        if (this.d) {
            return !this.e;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.d = true;
            b.h.j.o.a(this.f603b, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d || !this.f) {
            this.f603b.endViewTransition(this.f604c);
            this.e = true;
            return;
        }
        this.f = false;
        this.f603b.post(this);
    }
}
