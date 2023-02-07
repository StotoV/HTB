package b.q;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.q.k;
/* loaded from: classes.dex */
public abstract class i0 extends k {
    public static final String[] z = {"android:visibility:visibility", "android:visibility:parent"};
    public int y = 3;

    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements k.d, b.q.a {
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public final int f715b;

        /* renamed from: c  reason: collision with root package name */
        public final ViewGroup f716c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        public a(View view, int i, boolean z) {
            this.a = view;
            this.f715b = i;
            this.f716c = (ViewGroup) view.getParent();
            this.d = z;
            g(true);
        }

        @Override // b.q.k.d
        public void a(k kVar) {
        }

        @Override // b.q.k.d
        public void b(k kVar) {
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            f();
            kVar.v(this);
        }

        @Override // b.q.k.d
        public void d(k kVar) {
            g(false);
        }

        @Override // b.q.k.d
        public void e(k kVar) {
            g(true);
        }

        public final void f() {
            if (!this.f) {
                a0.a.f(this.a, this.f715b);
                ViewGroup viewGroup = this.f716c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.f716c) == null) {
                return;
            }
            this.e = z;
            x.b(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, b.q.a
        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                a0.a.f(this.a, this.f715b);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, b.q.a
        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                a0.a.f(this.a, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f717b;

        /* renamed from: c  reason: collision with root package name */
        public int f718c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    public final void H(s sVar) {
        sVar.a.put("android:visibility:visibility", Integer.valueOf(sVar.f731b.getVisibility()));
        sVar.a.put("android:visibility:parent", sVar.f731b.getParent());
        int[] iArr = new int[2];
        sVar.f731b.getLocationOnScreen(iArr);
        sVar.a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r9 == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
        if (r0.e == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0091, code lost:
        if (r0.f718c == 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b.q.i0.b I(b.q.s r8, b.q.s r9) {
        /*
            r7 = this;
            b.q.i0$b r0 = new b.q.i0$b
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.f717b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f718c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L37
        L33:
            r0.f718c = r4
            r0.e = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L5e
        L5a:
            r0.d = r4
            r0.f = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L82
            if (r9 == 0) goto L82
            int r8 = r0.f718c
            int r9 = r0.d
            if (r8 != r9) goto L70
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f
            if (r3 != r4) goto L70
            return r0
        L70:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L75
            goto L93
        L75:
            if (r9 != 0) goto L96
            goto L88
        L78:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L7d
            goto L93
        L7d:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L96
            goto L88
        L82:
            if (r8 != 0) goto L8d
            int r8 = r0.d
            if (r8 != 0) goto L8d
        L88:
            r0.f717b = r2
        L8a:
            r0.a = r2
            goto L96
        L8d:
            if (r9 != 0) goto L96
            int r8 = r0.f718c
            if (r8 != 0) goto L96
        L93:
            r0.f717b = r1
            goto L8a
        L96:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.q.i0.I(b.q.s, b.q.s):b.q.i0$b");
    }

    public abstract Animator J(ViewGroup viewGroup, View view, s sVar, s sVar2);

    @Override // b.q.k
    public void d(s sVar) {
        H(sVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        if (I(n(r1, false), q(r1, false)).a != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ed  */
    @Override // b.q.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator k(android.view.ViewGroup r22, b.q.s r23, b.q.s r24) {
        /*
            Method dump skipped, instructions count: 691
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.q.i0.k(android.view.ViewGroup, b.q.s, b.q.s):android.animation.Animator");
    }

    @Override // b.q.k
    public String[] p() {
        return z;
    }

    @Override // b.q.k
    public boolean r(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar != null && sVar2 != null && sVar2.a.containsKey("android:visibility:visibility") != sVar.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b I = I(sVar, sVar2);
        if (!I.a) {
            return false;
        }
        return I.f718c == 0 || I.d == 0;
    }
}
