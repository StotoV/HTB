package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
/* loaded from: classes.dex */
public class o0 {
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final TypedArray f252b;

    /* renamed from: c  reason: collision with root package name */
    public TypedValue f253c;

    public o0(Context context, TypedArray typedArray) {
        this.a = context;
        this.f252b = typedArray;
    }

    public static o0 o(Context context, AttributeSet attributeSet, int[] iArr) {
        return new o0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static o0 p(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new o0(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean a(int i, boolean z) {
        return this.f252b.getBoolean(i, z);
    }

    public int b(int i, int i2) {
        return this.f252b.getColor(i, i2);
    }

    public ColorStateList c(int i) {
        int resourceId;
        ColorStateList a;
        return (!this.f252b.hasValue(i) || (resourceId = this.f252b.getResourceId(i, 0)) == 0 || (a = b.b.d.a.a.a(this.a, resourceId)) == null) ? this.f252b.getColorStateList(i) : a;
    }

    public float d(int i, float f) {
        return this.f252b.getDimension(i, f);
    }

    public int e(int i, int i2) {
        return this.f252b.getDimensionPixelOffset(i, i2);
    }

    public int f(int i, int i2) {
        return this.f252b.getDimensionPixelSize(i, i2);
    }

    public Drawable g(int i) {
        int resourceId;
        return (!this.f252b.hasValue(i) || (resourceId = this.f252b.getResourceId(i, 0)) == 0) ? this.f252b.getDrawable(i) : b.b.d.a.a.b(this.a, resourceId);
    }

    public Typeface h(int i, int i2, b.h.c.b.g gVar) {
        int resourceId = this.f252b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f253c == null) {
            this.f253c = new TypedValue();
        }
        Context context = this.a;
        TypedValue typedValue = this.f253c;
        if (!context.isRestricted()) {
            return b.h.c.b.h.d(context, resourceId, typedValue, i2, gVar, null, true, false);
        }
        return null;
    }

    public int i(int i, int i2) {
        return this.f252b.getInt(i, i2);
    }

    public int j(int i, int i2) {
        return this.f252b.getLayoutDimension(i, i2);
    }

    public int k(int i, int i2) {
        return this.f252b.getResourceId(i, i2);
    }

    public String l(int i) {
        return this.f252b.getString(i);
    }

    public CharSequence m(int i) {
        return this.f252b.getText(i);
    }

    public boolean n(int i) {
        return this.f252b.hasValue(i);
    }
}
