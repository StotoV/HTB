package b.q;

import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class c extends k {
    public int[] y = new int[2];
    public static final String[] z = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> A = new a(PointF.class, "boundsOrigin");
    public static final Property<i, PointF> B = new b(PointF.class, "topLeft");
    public static final Property<i, PointF> C = new C0031c(PointF.class, "bottomRight");
    public static final Property<View, PointF> D = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> E = new e(PointF.class, "topLeft");
    public static final Property<View, PointF> F = new f(PointF.class, "position");
    public static b.q.i G = new b.q.i();

    /* loaded from: classes.dex */
    public static class a extends Property<Drawable, PointF> {
        public Rect a;

        public a(Class cls, String str) {
            super(cls, str);
            this.a = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.a);
            Rect rect = this.a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<i, PointF> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        public void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            iVar2.getClass();
            iVar2.a = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.f701b = round;
            int i = iVar2.f + 1;
            iVar2.f = i;
            if (i == iVar2.g) {
                a0.c(iVar2.e, iVar2.a, round, iVar2.f702c, iVar2.d);
                iVar2.f = 0;
                iVar2.g = 0;
            }
        }
    }

    /* renamed from: b.q.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031c extends Property<i, PointF> {
        public C0031c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        public void set(i iVar, PointF pointF) {
            i iVar2 = iVar;
            PointF pointF2 = pointF;
            iVar2.getClass();
            iVar2.f702c = Math.round(pointF2.x);
            int round = Math.round(pointF2.y);
            iVar2.d = round;
            int i = iVar2.g + 1;
            iVar2.g = i;
            if (iVar2.f == i) {
                a0.c(iVar2.e, iVar2.a, iVar2.f701b, iVar2.f702c, round);
                iVar2.f = 0;
                iVar2.g = 0;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends Property<View, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            a0.c(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    }

    /* loaded from: classes.dex */
    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            a0.c(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    }

    /* loaded from: classes.dex */
    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            a0.c(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    }

    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        private i mViewBounds;

        public g(c cVar, i iVar) {
            this.a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* loaded from: classes.dex */
    public class h extends n {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f700b;

        public h(c cVar, ViewGroup viewGroup) {
            this.f700b = viewGroup;
        }

        @Override // b.q.n, b.q.k.d
        public void b(k kVar) {
            x.b(this.f700b, false);
            this.a = true;
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            if (!this.a) {
                x.b(this.f700b, false);
            }
            kVar.v(this);
        }

        @Override // b.q.n, b.q.k.d
        public void d(k kVar) {
            x.b(this.f700b, false);
        }

        @Override // b.q.n, b.q.k.d
        public void e(k kVar) {
            x.b(this.f700b, true);
        }
    }

    /* loaded from: classes.dex */
    public static class i {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f701b;

        /* renamed from: c  reason: collision with root package name */
        public int f702c;
        public int d;
        public View e;
        public int f;
        public int g;

        public i(View view) {
            this.e = view;
        }
    }

    public final void H(s sVar) {
        View view = sVar.f731b;
        if (!b.h.j.q.u(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.a.put("android:changeBounds:parent", sVar.f731b.getParent());
    }

    @Override // b.q.k
    public void d(s sVar) {
        H(sVar);
    }

    @Override // b.q.k
    public void g(s sVar) {
        H(sVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0114  */
    @Override // b.q.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator k(android.view.ViewGroup r19, b.q.s r20, b.q.s r21) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.q.c.k(android.view.ViewGroup, b.q.s, b.q.s):android.animation.Animator");
    }

    @Override // b.q.k
    public String[] p() {
        return z;
    }
}
