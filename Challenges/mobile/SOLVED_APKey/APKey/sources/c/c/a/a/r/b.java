package c.c.a.a.r;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import b.h.c.b.g;
import b.h.c.b.h;
/* loaded from: classes.dex */
public class b {
    public final ColorStateList a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f864b;

    /* renamed from: c  reason: collision with root package name */
    public final String f865c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;
    public final float h;
    public final boolean i;
    public final float j;
    public float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    /* loaded from: classes.dex */
    public class a extends g {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // b.h.c.b.g
        public void d(int i) {
            b.this.m = true;
            this.a.a(i);
        }

        @Override // b.h.c.b.g
        public void e(Typeface typeface) {
            b bVar = b.this;
            bVar.n = Typeface.create(typeface, bVar.d);
            b bVar2 = b.this;
            bVar2.m = true;
            this.a.b(bVar2.n, false);
        }
    }

    public b(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, c.c.a.a.b.z);
        this.k = obtainStyledAttributes.getDimension(0, 0.0f);
        this.a = c.c.a.a.a.f(context, obtainStyledAttributes, 3);
        c.c.a.a.a.f(context, obtainStyledAttributes, 4);
        c.c.a.a.a.f(context, obtainStyledAttributes, 5);
        this.d = obtainStyledAttributes.getInt(2, 0);
        this.e = obtainStyledAttributes.getInt(1, 1);
        int i2 = !obtainStyledAttributes.hasValue(12) ? 10 : 12;
        this.l = obtainStyledAttributes.getResourceId(i2, 0);
        this.f865c = obtainStyledAttributes.getString(i2);
        obtainStyledAttributes.getBoolean(14, false);
        this.f864b = c.c.a.a.a.f(context, obtainStyledAttributes, 6);
        this.f = obtainStyledAttributes.getFloat(7, 0.0f);
        this.g = obtainStyledAttributes.getFloat(8, 0.0f);
        this.h = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT < 21) {
            this.i = false;
            this.j = 0.0f;
            return;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, c.c.a.a.b.s);
        this.i = obtainStyledAttributes2.hasValue(0);
        this.j = obtainStyledAttributes2.getFloat(0, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.f865c) != null) {
            this.n = Typeface.create(str, this.d);
        }
        if (this.n == null) {
            int i = this.e;
            this.n = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.n = Typeface.create(this.n, this.d);
        }
    }

    public void b(Context context, d dVar) {
        a();
        int i = this.l;
        if (i == 0) {
            this.m = true;
        }
        if (this.m) {
            dVar.b(this.n, true);
            return;
        }
        try {
            a aVar = new a(dVar);
            if (context.isRestricted()) {
                aVar.a(-4, null);
            } else {
                h.d(context, i, new TypedValue(), 0, aVar, null, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            dVar.a(1);
        } catch (Exception e) {
            StringBuilder g = c.a.a.a.a.g("Error loading font ");
            g.append(this.f865c);
            Log.d("TextAppearance", g.toString(), e);
            this.m = true;
            dVar.a(-3);
        }
    }

    public void c(Context context, TextPaint textPaint, d dVar) {
        a();
        d(textPaint, this.n);
        b(context, new c(this, textPaint, dVar));
        ColorStateList colorStateList = this.a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.h;
        float f2 = this.f;
        float f3 = this.g;
        ColorStateList colorStateList2 = this.f864b;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.d;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.k);
        if (Build.VERSION.SDK_INT < 21 || !this.i) {
            return;
        }
        textPaint.setLetterSpacing(this.j);
    }
}
