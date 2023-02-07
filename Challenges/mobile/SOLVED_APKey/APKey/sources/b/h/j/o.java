package b.h.j;

import android.view.View;
import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public final class o implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final View f487b;

    /* renamed from: c  reason: collision with root package name */
    public ViewTreeObserver f488c;
    public final Runnable d;

    public o(View view, Runnable runnable) {
        this.f487b = view;
        this.f488c = view.getViewTreeObserver();
        this.d = runnable;
    }

    public static o a(View view, Runnable runnable) {
        if (view != null) {
            o oVar = new o(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(oVar);
            view.addOnAttachStateChangeListener(oVar);
            return oVar;
        }
        throw new NullPointerException("view == null");
    }

    public void b() {
        (this.f488c.isAlive() ? this.f488c : this.f487b.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f487b.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.d.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f488c = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
