package b.q;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a0 {
    public static final g0 a;

    /* renamed from: b  reason: collision with root package name */
    public static final Property<View, Float> f699b;

    /* loaded from: classes.dex */
    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(a0.a(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            float floatValue = f.floatValue();
            a0.a.e(view, floatValue);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Rect get(View view) {
            View view2 = view;
            AtomicInteger atomicInteger = b.h.j.q.a;
            if (Build.VERSION.SDK_INT >= 18) {
                return view2.getClipBounds();
            }
            return null;
        }

        @Override // android.util.Property
        public void set(View view, Rect rect) {
            b.h.j.q.H(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        a = i >= 29 ? new f0() : i >= 23 ? new e0() : i >= 22 ? new d0() : i >= 21 ? new c0() : i >= 19 ? new b0() : new g0();
        f699b = new a(Float.class, "translationAlpha");
        new b(Rect.class, "clipBounds");
    }

    public static float a(View view) {
        return a.b(view);
    }

    public static l0 b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new k0(view) : new j0(view.getWindowToken());
    }

    public static void c(View view, int i, int i2, int i3, int i4) {
        a.d(view, i, i2, i3, i4);
    }
}
