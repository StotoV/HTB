package b.h.j;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: b  reason: collision with root package name */
    public static final b0 f462b;
    public final k a;

    /* loaded from: classes.dex */
    public static class a {
        public static Field a;

        /* renamed from: b  reason: collision with root package name */
        public static Field f463b;

        /* renamed from: c  reason: collision with root package name */
        public static Field f464c;
        public static boolean d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f463b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f464c = declaredField3;
                declaredField3.setAccessible(true);
                d = true;
            } catch (ReflectiveOperationException e) {
                StringBuilder g = c.a.a.a.a.g("Failed to get visible insets from AttachInfo ");
                g.append(e.getMessage());
                Log.w("WindowInsetsCompat", g.toString(), e);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends e {
        public static Field d = null;
        public static boolean e = false;
        public static Constructor<WindowInsets> f = null;
        public static boolean g = false;

        /* renamed from: b  reason: collision with root package name */
        public WindowInsets f465b;

        /* renamed from: c  reason: collision with root package name */
        public b.h.d.b f466c;

        public b() {
            this.f465b = d();
        }

        public b(b0 b0Var) {
            this.f465b = b0Var.g();
        }

        public static WindowInsets d() {
            if (!e) {
                try {
                    d = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                e = true;
            }
            Field field = d;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!g) {
                try {
                    f = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                g = true;
            }
            Constructor<WindowInsets> constructor = f;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // b.h.j.b0.e
        public b0 a() {
            b0 h = b0.h(this.f465b);
            h.a.l(null);
            h.a.n(this.f466c);
            return h;
        }

        @Override // b.h.j.b0.e
        public void b(b.h.d.b bVar) {
            this.f466c = bVar;
        }

        @Override // b.h.j.b0.e
        public void c(b.h.d.b bVar) {
            WindowInsets windowInsets = this.f465b;
            if (windowInsets != null) {
                this.f465b = windowInsets.replaceSystemWindowInsets(bVar.a, bVar.f411b, bVar.f412c, bVar.d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends e {

        /* renamed from: b  reason: collision with root package name */
        public final WindowInsets.Builder f467b;

        public c() {
            this.f467b = new WindowInsets.Builder();
        }

        public c(b0 b0Var) {
            WindowInsets g = b0Var.g();
            this.f467b = g != null ? new WindowInsets.Builder(g) : new WindowInsets.Builder();
        }

        @Override // b.h.j.b0.e
        public b0 a() {
            b0 h = b0.h(this.f467b.build());
            h.a.l(null);
            return h;
        }

        @Override // b.h.j.b0.e
        public void b(b.h.d.b bVar) {
            this.f467b.setStableInsets(bVar.b());
        }

        @Override // b.h.j.b0.e
        public void c(b.h.d.b bVar) {
            this.f467b.setSystemWindowInsets(bVar.b());
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c {
        public d() {
        }

        public d(b0 b0Var) {
            super(b0Var);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public final b0 a;

        public e() {
            this.a = new b0((b0) null);
        }

        public e(b0 b0Var) {
            this.a = b0Var;
        }

        public b0 a() {
            return this.a;
        }

        public void b(b.h.d.b bVar) {
        }

        public void c(b.h.d.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class f extends k {
        public static boolean g = false;
        public static Method h;
        public static Class<?> i;
        public static Class<?> j;
        public static Field k;
        public static Field l;

        /* renamed from: c  reason: collision with root package name */
        public final WindowInsets f468c;
        public b.h.d.b d;
        public b0 e;
        public b.h.d.b f;

        public f(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var);
            this.d = null;
            this.f468c = windowInsets;
        }

        @SuppressLint({"PrivateApi"})
        public static void p() {
            try {
                h = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                i = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                j = cls;
                k = cls.getDeclaredField("mVisibleInsets");
                l = i.getDeclaredField("mAttachInfo");
                k.setAccessible(true);
                l.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                StringBuilder g2 = c.a.a.a.a.g("Failed to get visible insets. (Reflection error). ");
                g2.append(e.getMessage());
                Log.e("WindowInsetsCompat", g2.toString(), e);
            }
            g = true;
        }

        @Override // b.h.j.b0.k
        public void d(View view) {
            b.h.d.b o = o(view);
            if (o == null) {
                o = b.h.d.b.e;
            }
            this.f = o;
        }

        @Override // b.h.j.b0.k
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return defpackage.a.a(this.f, ((f) obj).f);
        }

        @Override // b.h.j.b0.k
        public final b.h.d.b h() {
            if (this.d == null) {
                this.d = b.h.d.b.a(this.f468c.getSystemWindowInsetLeft(), this.f468c.getSystemWindowInsetTop(), this.f468c.getSystemWindowInsetRight(), this.f468c.getSystemWindowInsetBottom());
            }
            return this.d;
        }

        @Override // b.h.j.b0.k
        public b0 i(int i2, int i3, int i4, int i5) {
            b0 h2 = b0.h(this.f468c);
            int i6 = Build.VERSION.SDK_INT;
            e dVar = i6 >= 30 ? new d(h2) : i6 >= 29 ? new c(h2) : i6 >= 20 ? new b(h2) : new e(h2);
            dVar.c(b0.e(h(), i2, i3, i4, i5));
            dVar.b(b0.e(g(), i2, i3, i4, i5));
            return dVar.a();
        }

        @Override // b.h.j.b0.k
        public boolean k() {
            return this.f468c.isRound();
        }

        @Override // b.h.j.b0.k
        public void l(b.h.d.b[] bVarArr) {
        }

        @Override // b.h.j.b0.k
        public void m(b0 b0Var) {
            this.e = b0Var;
        }

        public final b.h.d.b o(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!g) {
                    p();
                }
                Method method = h;
                if (method != null && j != null && k != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) k.get(l.get(invoke));
                        if (rect == null) {
                            return null;
                        }
                        return b.h.d.b.a(rect.left, rect.top, rect.right, rect.bottom);
                    } catch (ReflectiveOperationException e) {
                        StringBuilder g2 = c.a.a.a.a.g("Failed to get visible insets. (Reflection error). ");
                        g2.append(e.getMessage());
                        Log.e("WindowInsetsCompat", g2.toString(), e);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
    }

    /* loaded from: classes.dex */
    public static class g extends f {
        public b.h.d.b m;

        public g(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
            this.m = null;
        }

        @Override // b.h.j.b0.k
        public b0 b() {
            return b0.h(this.f468c.consumeStableInsets());
        }

        @Override // b.h.j.b0.k
        public b0 c() {
            return b0.h(this.f468c.consumeSystemWindowInsets());
        }

        @Override // b.h.j.b0.k
        public final b.h.d.b g() {
            if (this.m == null) {
                this.m = b.h.d.b.a(this.f468c.getStableInsetLeft(), this.f468c.getStableInsetTop(), this.f468c.getStableInsetRight(), this.f468c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // b.h.j.b0.k
        public boolean j() {
            return this.f468c.isConsumed();
        }

        @Override // b.h.j.b0.k
        public void n(b.h.d.b bVar) {
            this.m = bVar;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends g {
        public h(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // b.h.j.b0.k
        public b0 a() {
            return b0.h(this.f468c.consumeDisplayCutout());
        }

        @Override // b.h.j.b0.k
        public b.h.j.d e() {
            DisplayCutout displayCutout = this.f468c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new b.h.j.d(displayCutout);
        }

        @Override // b.h.j.b0.f, b.h.j.b0.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return defpackage.a.a(this.f468c, hVar.f468c) && defpackage.a.a(this.f, hVar.f);
        }

        @Override // b.h.j.b0.k
        public int hashCode() {
            return this.f468c.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static class i extends h {
        public b.h.d.b n;

        public i(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
            this.n = null;
        }

        @Override // b.h.j.b0.k
        public b.h.d.b f() {
            if (this.n == null) {
                Insets mandatorySystemGestureInsets = this.f468c.getMandatorySystemGestureInsets();
                this.n = b.h.d.b.a(mandatorySystemGestureInsets.left, mandatorySystemGestureInsets.top, mandatorySystemGestureInsets.right, mandatorySystemGestureInsets.bottom);
            }
            return this.n;
        }

        @Override // b.h.j.b0.f, b.h.j.b0.k
        public b0 i(int i, int i2, int i3, int i4) {
            return b0.h(this.f468c.inset(i, i2, i3, i4));
        }

        @Override // b.h.j.b0.g, b.h.j.b0.k
        public void n(b.h.d.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class j extends i {
        public static final b0 o = b0.h(WindowInsets.CONSUMED);

        public j(b0 b0Var, WindowInsets windowInsets) {
            super(b0Var, windowInsets);
        }

        @Override // b.h.j.b0.f, b.h.j.b0.k
        public final void d(View view) {
        }
    }

    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: b  reason: collision with root package name */
        public static final b0 f469b;
        public final b0 a;

        static {
            int i = Build.VERSION.SDK_INT;
            f469b = (i >= 30 ? new d() : i >= 29 ? new c() : i >= 20 ? new b() : new e()).a().a.a().a.b().a.c();
        }

        public k(b0 b0Var) {
            this.a = b0Var;
        }

        public b0 a() {
            return this.a;
        }

        public b0 b() {
            return this.a;
        }

        public b0 c() {
            return this.a;
        }

        public void d(View view) {
        }

        public b.h.j.d e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return k() == kVar.k() && j() == kVar.j() && b.h.b.a.v(h(), kVar.h()) && b.h.b.a.v(g(), kVar.g()) && b.h.b.a.v(e(), kVar.e());
        }

        public b.h.d.b f() {
            return h();
        }

        public b.h.d.b g() {
            return b.h.d.b.e;
        }

        public b.h.d.b h() {
            return b.h.d.b.e;
        }

        public int hashCode() {
            return b.h.b.a.E(Boolean.valueOf(k()), Boolean.valueOf(j()), h(), g(), e());
        }

        public b0 i(int i, int i2, int i3, int i4) {
            return f469b;
        }

        public boolean j() {
            return false;
        }

        public boolean k() {
            return false;
        }

        public void l(b.h.d.b[] bVarArr) {
        }

        public void m(b0 b0Var) {
        }

        public void n(b.h.d.b bVar) {
        }
    }

    static {
        f462b = Build.VERSION.SDK_INT >= 30 ? j.o : k.f469b;
    }

    public b0(WindowInsets windowInsets) {
        k fVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            fVar = new j(this, windowInsets);
        } else if (i2 >= 29) {
            fVar = new i(this, windowInsets);
        } else if (i2 >= 28) {
            fVar = new h(this, windowInsets);
        } else if (i2 >= 21) {
            fVar = new g(this, windowInsets);
        } else if (i2 < 20) {
            this.a = new k(this);
            return;
        } else {
            fVar = new f(this, windowInsets);
        }
        this.a = fVar;
    }

    public b0(b0 b0Var) {
        this.a = new k(this);
    }

    public static b.h.d.b e(b.h.d.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.a - i2);
        int max2 = Math.max(0, bVar.f411b - i3);
        int max3 = Math.max(0, bVar.f412c - i4);
        int max4 = Math.max(0, bVar.d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : b.h.d.b.a(max, max2, max3, max4);
    }

    public static b0 h(WindowInsets windowInsets) {
        return i(windowInsets, null);
    }

    public static b0 i(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        b0 b0Var = new b0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            b0Var.a.m(q.r(view));
            b0Var.a.d(view.getRootView());
        }
        return b0Var;
    }

    @Deprecated
    public int a() {
        return this.a.h().d;
    }

    @Deprecated
    public int b() {
        return this.a.h().a;
    }

    @Deprecated
    public int c() {
        return this.a.h().f412c;
    }

    @Deprecated
    public int d() {
        return this.a.h().f411b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return b.h.b.a.v(this.a, ((b0) obj).a);
        }
        return false;
    }

    public boolean f() {
        return this.a.j();
    }

    public WindowInsets g() {
        k kVar = this.a;
        if (kVar instanceof f) {
            return ((f) kVar).f468c;
        }
        return null;
    }

    public int hashCode() {
        k kVar = this.a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }
}
