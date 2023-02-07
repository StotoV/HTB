package c.c.a.a.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.example.apkey.R;
/* loaded from: classes.dex */
public final class c {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final b f800b;

    /* renamed from: c  reason: collision with root package name */
    public final b f801c;
    public final b d;
    public final b e;
    public final b f;
    public final b g;
    public final Paint h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.c.a.a.a.r(context, R.attr.materialCalendarStyle, g.class.getCanonicalName()), c.c.a.a.b.n);
        this.a = b.a(context, obtainStyledAttributes.getResourceId(3, 0));
        this.g = b.a(context, obtainStyledAttributes.getResourceId(1, 0));
        this.f800b = b.a(context, obtainStyledAttributes.getResourceId(2, 0));
        this.f801c = b.a(context, obtainStyledAttributes.getResourceId(4, 0));
        ColorStateList f = c.c.a.a.a.f(context, obtainStyledAttributes, 6);
        this.d = b.a(context, obtainStyledAttributes.getResourceId(8, 0));
        this.e = b.a(context, obtainStyledAttributes.getResourceId(7, 0));
        this.f = b.a(context, obtainStyledAttributes.getResourceId(9, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(f.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
