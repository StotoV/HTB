package c.c.a.a.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class b {
    public final Rect a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f796b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f797c;
    public final ColorStateList d;
    public final int e;
    public final c.c.a.a.u.j f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, c.c.a.a.u.j jVar, Rect rect) {
        b.h.b.a.g(rect.left);
        b.h.b.a.g(rect.top);
        b.h.b.a.g(rect.right);
        b.h.b.a.g(rect.bottom);
        this.a = rect;
        this.f796b = colorStateList2;
        this.f797c = colorStateList;
        this.d = colorStateList3;
        this.e = i;
        this.f = jVar;
    }

    public static b a(Context context, int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, c.c.a.a.b.o);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(0, 0), obtainStyledAttributes.getDimensionPixelOffset(2, 0), obtainStyledAttributes.getDimensionPixelOffset(1, 0), obtainStyledAttributes.getDimensionPixelOffset(3, 0));
            ColorStateList f = c.c.a.a.a.f(context, obtainStyledAttributes, 4);
            ColorStateList f2 = c.c.a.a.a.f(context, obtainStyledAttributes, 9);
            ColorStateList f3 = c.c.a.a.a.f(context, obtainStyledAttributes, 7);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
            c.c.a.a.u.j a = c.c.a.a.u.j.a(context, obtainStyledAttributes.getResourceId(5, 0), obtainStyledAttributes.getResourceId(6, 0), new c.c.a.a.u.a(0)).a();
            obtainStyledAttributes.recycle();
            return new b(f, f2, f3, dimensionPixelSize, a, rect);
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    public void b(TextView textView) {
        c.c.a.a.u.g gVar = new c.c.a.a.u.g();
        c.c.a.a.u.g gVar2 = new c.c.a.a.u.g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.p(this.f797c);
        gVar.s(this.e, this.d);
        textView.setTextColor(this.f796b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f796b.withAlpha(30), gVar, gVar2) : gVar;
        Rect rect = this.a;
        InsetDrawable insetDrawable = new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        AtomicInteger atomicInteger = b.h.j.q.a;
        textView.setBackground(insetDrawable);
    }
}
