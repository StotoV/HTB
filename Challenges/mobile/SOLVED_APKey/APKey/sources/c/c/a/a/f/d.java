package c.c.a.a.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
/* loaded from: classes.dex */
public class d extends AnimatorListenerAdapter {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f780b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f781c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BottomAppBar e;

    public d(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.f780b = actionMenuView;
        this.f781c = i;
        this.d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.a) {
            BottomAppBar bottomAppBar = this.e;
            int i = bottomAppBar.U;
            boolean z = i != 0;
            if (i != 0) {
                bottomAppBar.U = 0;
                bottomAppBar.getMenu().clear();
                bottomAppBar.n(i);
            }
            BottomAppBar bottomAppBar2 = this.e;
            ActionMenuView actionMenuView = this.f780b;
            int i2 = this.f781c;
            boolean z2 = this.d;
            bottomAppBar2.getClass();
            e eVar = new e(bottomAppBar2, actionMenuView, i2, z2);
            if (z) {
                actionMenuView.post(eVar);
            } else {
                eVar.run();
            }
        }
    }
}
