package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.c.a.a.v.a;
import c.c.a.a.v.d;
import c.c.a.a.v.e;
import com.google.android.material.behavior.SwipeDismissBehavior;
/* loaded from: classes.dex */
public class BaseTransientBottomBar$Behavior extends SwipeDismissBehavior<View> {
    public final a h = new a(this);

    @Override // com.google.android.material.behavior.SwipeDismissBehavior
    public boolean B(View view) {
        this.h.getClass();
        return view instanceof d;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        this.h.getClass();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 3) {
                if (e.f899c == null) {
                    e.f899c = new e();
                }
                synchronized (e.f899c.a) {
                }
            }
        } else if (coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (e.f899c == null) {
                e.f899c = new e();
            }
            synchronized (e.f899c.a) {
            }
        }
        return super.j(coordinatorLayout, view, motionEvent);
    }
}
