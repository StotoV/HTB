package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.q;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c<View> {
    public int a;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f974c;
        public final /* synthetic */ c.c.a.a.o.a d;

        public a(View view, int i, c.c.a.a.o.a aVar) {
            this.f973b = view;
            this.f974c = i;
            this.d = aVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f973b.getViewTreeObserver().removeOnPreDrawListener(this);
            ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
            if (expandableBehavior.a == this.f974c) {
                c.c.a.a.o.a aVar = this.d;
                expandableBehavior.C((View) aVar, this.f973b, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0;
    }

    public final boolean B(boolean z) {
        if (!z) {
            return this.a == 1;
        }
        int i = this.a;
        return i == 0 || i == 2;
    }

    public abstract boolean C(View view, View view2, boolean z, boolean z2);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean g(CoordinatorLayout coordinatorLayout, View view, View view2) {
        c.c.a.a.o.a aVar = (c.c.a.a.o.a) view2;
        if (B(aVar.a())) {
            this.a = aVar.a() ? 1 : 2;
            return C((View) aVar, view, aVar.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
        c.c.a.a.o.a aVar;
        if (!q.u(view)) {
            List<View> j = coordinatorLayout.j(view);
            int size = j.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    aVar = null;
                    break;
                }
                View view2 = j.get(i2);
                if (d(coordinatorLayout, view, view2)) {
                    aVar = (c.c.a.a.o.a) view2;
                    break;
                }
                i2++;
            }
            if (aVar != null && B(aVar.a())) {
                int i3 = aVar.a() ? 1 : 2;
                this.a = i3;
                view.getViewTreeObserver().addOnPreDrawListener(new a(view, i3, aVar));
            }
        }
        return false;
    }
}
