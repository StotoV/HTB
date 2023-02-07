package c.c.a.a.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class g extends d {
    public g(FloatingActionButton floatingActionButton, c.c.a.a.t.b bVar) {
        super(floatingActionButton, bVar);
    }

    @Override // c.c.a.a.p.d
    public float c() {
        return this.s.getElevation();
    }

    @Override // c.c.a.a.p.d
    public void d(Rect rect) {
        if (FloatingActionButton.this.k) {
            super.d(rect);
            return;
        }
        int i = 0;
        if (!r()) {
            i = (0 - this.s.getSizeDimension()) / 2;
        }
        rect.set(i, i, i, i);
    }

    @Override // c.c.a.a.p.d
    public void g() {
    }

    @Override // c.c.a.a.p.d
    public void h() {
        t();
        throw null;
    }

    @Override // c.c.a.a.p.d
    public void i(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f = 0.0f;
            if (this.s.isEnabled()) {
                this.s.setElevation(this.d);
                if (this.s.isPressed()) {
                    floatingActionButton = this.s;
                    f = this.f;
                } else if (this.s.isFocused() || this.s.isHovered()) {
                    floatingActionButton = this.s;
                    f = this.e;
                }
                floatingActionButton.setTranslationZ(f);
            }
            this.s.setElevation(0.0f);
            floatingActionButton = this.s;
            floatingActionButton.setTranslationZ(f);
        }
    }

    @Override // c.c.a.a.p.d
    public void j(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.s.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.A, u(f, f3));
            stateListAnimator.addState(d.B, u(f, f2));
            stateListAnimator.addState(d.C, u(f, f2));
            stateListAnimator.addState(d.D, u(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.s, "elevation", f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.s;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.z);
            stateListAnimator.addState(d.E, animatorSet);
            stateListAnimator.addState(d.F, u(0.0f, 0.0f));
            this.s.setStateListAnimator(stateListAnimator);
        }
        if (!p()) {
            return;
        }
        t();
        throw null;
    }

    @Override // c.c.a.a.p.d
    public boolean m() {
        return false;
    }

    @Override // c.c.a.a.p.d
    public void o(ColorStateList colorStateList) {
    }

    @Override // c.c.a.a.p.d
    public boolean p() {
        return FloatingActionButton.this.k || !r();
    }

    @Override // c.c.a.a.p.d
    public void s() {
    }

    public final Animator u(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.s, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.s, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(d.z);
        return animatorSet;
    }
}
