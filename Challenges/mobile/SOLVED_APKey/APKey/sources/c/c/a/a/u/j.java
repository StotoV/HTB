package c.c.a.a.u;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
/* loaded from: classes.dex */
public class j {
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public d f880b;

    /* renamed from: c  reason: collision with root package name */
    public d f881c;
    public d d;
    public c e;
    public c f;
    public c g;
    public c h;
    public f i;
    public f j;
    public f k;
    public f l;

    public j() {
        this.a = new i();
        this.f880b = new i();
        this.f881c = new i();
        this.d = new i();
        this.e = new c.c.a.a.u.a(0.0f);
        this.f = new c.c.a.a.u.a(0.0f);
        this.g = new c.c.a.a.u.a(0.0f);
        this.h = new c.c.a.a.u.a(0.0f);
        this.i = new f();
        this.j = new f();
        this.k = new f();
        this.l = new f();
    }

    public static b a(Context context, int i, int i2, c cVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, c.c.a.a.b.x);
        try {
            int i3 = obtainStyledAttributes.getInt(0, 0);
            int i4 = obtainStyledAttributes.getInt(3, i3);
            int i5 = obtainStyledAttributes.getInt(4, i3);
            int i6 = obtainStyledAttributes.getInt(2, i3);
            int i7 = obtainStyledAttributes.getInt(1, i3);
            c c2 = c(obtainStyledAttributes, 5, cVar);
            c c3 = c(obtainStyledAttributes, 8, c2);
            c c4 = c(obtainStyledAttributes, 9, c2);
            c c5 = c(obtainStyledAttributes, 7, c2);
            c c6 = c(obtainStyledAttributes, 6, c2);
            b bVar = new b();
            d b2 = c.c.a.a.a.b(i4);
            bVar.a = b2;
            b.b(b2);
            bVar.e = c3;
            d b3 = c.c.a.a.a.b(i5);
            bVar.f882b = b3;
            b.b(b3);
            bVar.f = c4;
            d b4 = c.c.a.a.a.b(i6);
            bVar.f883c = b4;
            b.b(b4);
            bVar.g = c5;
            d b5 = c.c.a.a.a.b(i7);
            bVar.d = b5;
            b.b(b5);
            bVar.h = c6;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b b(Context context, AttributeSet attributeSet, int i, int i2) {
        c.c.a.a.u.a aVar = new c.c.a.a.u.a(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.r, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, aVar);
    }

    public static c c(TypedArray typedArray, int i, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cVar;
        }
        int i2 = peekValue.type;
        return i2 == 5 ? new c.c.a.a.u.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new h(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public boolean d(RectF rectF) {
        boolean z = this.l.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.i.getClass().equals(f.class) && this.k.getClass().equals(f.class);
        float a2 = this.e.a(rectF);
        return z && ((this.f.a(rectF) > a2 ? 1 : (this.f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f880b instanceof i) && (this.a instanceof i) && (this.f881c instanceof i) && (this.d instanceof i));
    }

    public j e(float f) {
        b bVar = new b(this);
        bVar.c(f);
        return bVar.a();
    }

    /* loaded from: classes.dex */
    public static final class b {
        public d a;

        /* renamed from: b  reason: collision with root package name */
        public d f882b;

        /* renamed from: c  reason: collision with root package name */
        public d f883c;
        public d d;
        public c e;
        public c f;
        public c g;
        public c h;
        public f i;
        public f j;
        public f k;
        public f l;

        public b() {
            this.a = new i();
            this.f882b = new i();
            this.f883c = new i();
            this.d = new i();
            this.e = new c.c.a.a.u.a(0.0f);
            this.f = new c.c.a.a.u.a(0.0f);
            this.g = new c.c.a.a.u.a(0.0f);
            this.h = new c.c.a.a.u.a(0.0f);
            this.i = new f();
            this.j = new f();
            this.k = new f();
            this.l = new f();
        }

        public static float b(d dVar) {
            Object obj;
            if (dVar instanceof i) {
                obj = (i) dVar;
            } else if (!(dVar instanceof e)) {
                return -1.0f;
            } else {
                obj = (e) dVar;
            }
            obj.getClass();
            return -1.0f;
        }

        public j a() {
            return new j(this, null);
        }

        public b c(float f) {
            this.e = new c.c.a.a.u.a(f);
            this.f = new c.c.a.a.u.a(f);
            this.g = new c.c.a.a.u.a(f);
            this.h = new c.c.a.a.u.a(f);
            return this;
        }

        public b d(float f) {
            this.h = new c.c.a.a.u.a(f);
            return this;
        }

        public b e(float f) {
            this.g = new c.c.a.a.u.a(f);
            return this;
        }

        public b f(float f) {
            this.e = new c.c.a.a.u.a(f);
            return this;
        }

        public b g(float f) {
            this.f = new c.c.a.a.u.a(f);
            return this;
        }

        public b(j jVar) {
            this.a = new i();
            this.f882b = new i();
            this.f883c = new i();
            this.d = new i();
            this.e = new c.c.a.a.u.a(0.0f);
            this.f = new c.c.a.a.u.a(0.0f);
            this.g = new c.c.a.a.u.a(0.0f);
            this.h = new c.c.a.a.u.a(0.0f);
            this.i = new f();
            this.j = new f();
            this.k = new f();
            this.l = new f();
            this.a = jVar.a;
            this.f882b = jVar.f880b;
            this.f883c = jVar.f881c;
            this.d = jVar.d;
            this.e = jVar.e;
            this.f = jVar.f;
            this.g = jVar.g;
            this.h = jVar.h;
            this.i = jVar.i;
            this.j = jVar.j;
            this.k = jVar.k;
            this.l = jVar.l;
        }
    }

    public j(b bVar, a aVar) {
        this.a = bVar.a;
        this.f880b = bVar.f882b;
        this.f881c = bVar.f883c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = bVar.g;
        this.h = bVar.h;
        this.i = bVar.i;
        this.j = bVar.j;
        this.k = bVar.k;
        this.l = bVar.l;
    }
}
