package c.c.a.a.k;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f789b = new b();
        public final e a = new e(null);

        @Override // android.animation.TypeEvaluator
        public e evaluate(float f, e eVar, e eVar2) {
            e eVar3 = eVar;
            e eVar4 = eVar2;
            e eVar5 = this.a;
            float m = c.c.a.a.a.m(eVar3.a, eVar4.a, f);
            float m2 = c.c.a.a.a.m(eVar3.f790b, eVar4.f790b, f);
            float m3 = c.c.a.a.a.m(eVar3.f791c, eVar4.f791c, f);
            eVar5.a = m;
            eVar5.f790b = m2;
            eVar5.f791c = m3;
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {
        public static final Property<d, e> a = new c("circularReveal");

        public c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: c.c.a.a.k.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036d extends Property<d, Integer> {
        public static final Property<d, Integer> a = new C0036d("circularRevealScrimColor");

        public C0036d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f790b;

        /* renamed from: c  reason: collision with root package name */
        public float f791c;

        public e() {
        }

        public e(float f, float f2, float f3) {
            this.a = f;
            this.f790b = f2;
            this.f791c = f3;
        }

        public e(a aVar) {
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
