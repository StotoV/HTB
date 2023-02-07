package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.c0.b;
import b.h.j.q;
import b.j.b.e;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public e a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f935b;

    /* renamed from: c  reason: collision with root package name */
    public int f936c = 2;
    public float d = 0.5f;
    public float e = 0.0f;
    public float f = 0.5f;
    public final e.c g = new a();

    /* loaded from: classes.dex */
    public class a extends e.c {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f937b = -1;

        public a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
            r5 = r2.a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (r5 != false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
            if (r5 != false) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
            r5 = r2.a - r3.getWidth();
            r3 = r2.a;
         */
        @Override // b.j.b.e.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int a(android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = b.h.j.q.o(r3)
                r0 = 1
                if (r5 != r0) goto L9
                r5 = 1
                goto La
            L9:
                r5 = 0
            La:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.f936c
                if (r1 != 0) goto L24
                if (r5 == 0) goto L1c
            L12:
                int r5 = r2.a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.a
                goto L37
            L1c:
                int r5 = r2.a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L37
            L24:
                if (r1 != r0) goto L29
                if (r5 == 0) goto L12
                goto L1c
            L29:
                int r5 = r2.a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L37:
                int r4 = java.lang.Math.max(r5, r4)
                int r3 = java.lang.Math.min(r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.a(android.view.View, int, int):int");
        }

        @Override // b.j.b.e.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // b.j.b.e.c
        public int c(View view) {
            return view.getWidth();
        }

        @Override // b.j.b.e.c
        public void e(View view, int i) {
            this.f937b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // b.j.b.e.c
        public void f(int i) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // b.j.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            float width = (view.getWidth() * SwipeDismissBehavior.this.e) + this.a;
            float width2 = (view.getWidth() * SwipeDismissBehavior.this.f) + this.a;
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
            if (java.lang.Math.abs(r7.getLeft() - r6.a) >= java.lang.Math.round(r7.getWidth() * r6.f938c.d)) goto L37;
         */
        @Override // b.j.b.e.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(android.view.View r7, float r8, float r9) {
            /*
                r6 = this;
                r9 = -1
                r6.f937b = r9
                int r9 = r7.getWidth()
                r0 = 0
                r1 = 0
                r2 = 1
                int r3 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r3 == 0) goto L3e
                int r3 = b.h.j.q.o(r7)
                if (r3 != r2) goto L16
                r3 = 1
                goto L17
            L16:
                r3 = 0
            L17:
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r4 = r4.f936c
                r5 = 2
                if (r4 != r5) goto L1f
                goto L2c
            L1f:
                if (r4 != 0) goto L30
                if (r3 == 0) goto L28
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 >= 0) goto L2e
                goto L2c
            L28:
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 <= 0) goto L2e
            L2c:
                r8 = 1
                goto L5b
            L2e:
                r8 = 0
                goto L5b
            L30:
                if (r4 != r2) goto L2e
                if (r3 == 0) goto L39
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 <= 0) goto L2e
                goto L3d
            L39:
                int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r8 >= 0) goto L2e
            L3d:
                goto L2c
            L3e:
                int r8 = r7.getLeft()
                int r0 = r6.a
                int r8 = r8 - r0
                int r0 = r7.getWidth()
                float r0 = (float) r0
                com.google.android.material.behavior.SwipeDismissBehavior r3 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r3 = r3.d
                float r0 = r0 * r3
                int r0 = java.lang.Math.round(r0)
                int r8 = java.lang.Math.abs(r8)
                if (r8 < r0) goto L2e
                goto L2c
            L5b:
                if (r8 == 0) goto L6a
                int r8 = r7.getLeft()
                int r0 = r6.a
                if (r8 >= r0) goto L67
                int r0 = r0 - r9
                goto L68
            L67:
                int r0 = r0 + r9
            L68:
                r1 = 1
                goto L6c
            L6a:
                int r0 = r6.a
            L6c:
                com.google.android.material.behavior.SwipeDismissBehavior r8 = com.google.android.material.behavior.SwipeDismissBehavior.this
                b.j.b.e r8 = r8.a
                int r9 = r7.getTop()
                boolean r8 = r8.t(r0, r9)
                if (r8 == 0) goto L87
                com.google.android.material.behavior.SwipeDismissBehavior$b r8 = new com.google.android.material.behavior.SwipeDismissBehavior$b
                com.google.android.material.behavior.SwipeDismissBehavior r9 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r8.<init>(r7, r1)
                java.util.concurrent.atomic.AtomicInteger r9 = b.h.j.q.a
                r7.postOnAnimation(r8)
                goto L8e
            L87:
                if (r1 == 0) goto L8e
                com.google.android.material.behavior.SwipeDismissBehavior r7 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r7.getClass()
            L8e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.h(android.view.View, float, float):void");
        }

        @Override // b.j.b.e.c
        public boolean i(View view, int i) {
            int i2 = this.f937b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.B(view);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f939b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f940c;

        public b(View view, boolean z) {
            this.f939b = view;
            this.f940c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = SwipeDismissBehavior.this.a;
            if (eVar != null && eVar.i(true)) {
                View view = this.f939b;
                AtomicInteger atomicInteger = q.a;
                view.postOnAnimation(this);
            } else if (!this.f940c) {
            } else {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    public static float C(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.n(motionEvent);
            return true;
        }
        return false;
    }

    public boolean B(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f935b;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.p(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f935b = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f935b = false;
        }
        if (z) {
            if (this.a == null) {
                this.a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.g);
            }
            return this.a.u(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        AtomicInteger atomicInteger = q.a;
        if (v.getImportantForAccessibility() == 0) {
            q.I(v, 1);
            q.A(v, 1048576);
            if (!B(v)) {
                return false;
            }
            q.C(v, b.a.j, null, new c.c.a.a.e.a(this));
            return false;
        }
        return false;
    }
}
