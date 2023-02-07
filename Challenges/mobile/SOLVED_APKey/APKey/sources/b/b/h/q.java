package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes.dex */
public class q {
    public final TextView a;

    /* renamed from: b  reason: collision with root package name */
    public m0 f257b;

    /* renamed from: c  reason: collision with root package name */
    public m0 f258c;
    public m0 d;
    public m0 e;
    public m0 f;
    public m0 g;
    public m0 h;
    public final t i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* loaded from: classes.dex */
    public class a extends b.h.c.b.g {
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f259b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WeakReference f260c;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.f259b = i2;
            this.f260c = weakReference;
        }

        @Override // b.h.c.b.g
        public void d(int i) {
        }

        @Override // b.h.c.b.g
        public void e(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f259b & 2) != 0);
            }
            q qVar = q.this;
            WeakReference weakReference = this.f260c;
            if (qVar.m) {
                qVar.l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView == null) {
                    return;
                }
                if (b.h.j.q.t(textView)) {
                    textView.post(new r(qVar, textView, typeface, qVar.j));
                } else {
                    textView.setTypeface(typeface, qVar.j);
                }
            }
        }
    }

    public q(TextView textView) {
        this.a = textView;
        this.i = new t(textView);
    }

    public static m0 c(Context context, i iVar, int i) {
        ColorStateList d = iVar.d(context, i);
        if (d != null) {
            m0 m0Var = new m0();
            m0Var.d = true;
            m0Var.a = d;
            return m0Var;
        }
        return null;
    }

    public final void a(Drawable drawable, m0 m0Var) {
        if (drawable == null || m0Var == null) {
            return;
        }
        i.f(drawable, m0Var, this.a.getDrawableState());
    }

    public void b() {
        if (this.f257b != null || this.f258c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.f257b);
            a(compoundDrawables[1], this.f258c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f == null && this.g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    public boolean d() {
        t tVar = this.i;
        return tVar.i() && tVar.a != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:217:0x03c1, code lost:
        if (r3[2] != null) goto L228;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.util.AttributeSet r26, int r27) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.q.e(android.util.AttributeSet, int):void");
    }

    public void f(Context context, int i) {
        String l;
        ColorStateList c2;
        ColorStateList c3;
        ColorStateList c4;
        o0 o0Var = new o0(context, context.obtainStyledAttributes(i, b.b.b.v));
        if (o0Var.n(14)) {
            this.a.setAllCaps(o0Var.a(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            if (o0Var.n(3) && (c4 = o0Var.c(3)) != null) {
                this.a.setTextColor(c4);
            }
            if (o0Var.n(5) && (c3 = o0Var.c(5)) != null) {
                this.a.setLinkTextColor(c3);
            }
            if (o0Var.n(4) && (c2 = o0Var.c(4)) != null) {
                this.a.setHintTextColor(c2);
            }
        }
        if (o0Var.n(0) && o0Var.f(0, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        m(context, o0Var);
        if (i2 >= 26 && o0Var.n(13) && (l = o0Var.l(13)) != null) {
            this.a.setFontVariationSettings(l);
        }
        o0Var.f252b.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void g(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            editorInfo.setInitialSurroundingSubText(text, 0);
            return;
        }
        text.getClass();
        if (i >= 30) {
            editorInfo.setInitialSurroundingSubText(text, 0);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 + 0 : i2 + 0;
        int i5 = i2 > i3 ? i2 - 0 : i3 + 0;
        int length = text.length();
        if (i4 >= 0 && i5 <= length) {
            int i6 = editorInfo.inputType & 4095;
            if (!(i6 == 129 || i6 == 225 || i6 == 18)) {
                if (length <= 2048) {
                    b.h.j.d0.a.b(editorInfo, text, i4, i5);
                    return;
                }
                int i7 = i5 - i4;
                int i8 = i7 > 1024 ? 0 : i7;
                int i9 = 2048 - i8;
                double d = i9;
                Double.isNaN(d);
                Double.isNaN(d);
                Double.isNaN(d);
                Double.isNaN(d);
                Double.isNaN(d);
                int min = Math.min(text.length() - i5, i9 - Math.min(i4, (int) (d * 0.8d)));
                int min2 = Math.min(i4, i9 - min);
                int i10 = i4 - min2;
                if (b.h.j.d0.a.a(text, i10, 0)) {
                    i10++;
                    min2--;
                }
                if (b.h.j.d0.a.a(text, (i5 + min) - 1, 1)) {
                    min--;
                }
                CharSequence concat = i8 != i7 ? TextUtils.concat(text.subSequence(i10, i10 + min2), text.subSequence(i5, min + i5)) : text.subSequence(i10, min2 + i8 + min + i10);
                int i11 = min2 + 0;
                b.h.j.d0.a.b(editorInfo, concat, i11, i8 + i11);
                return;
            }
        }
        b.h.j.d0.a.b(editorInfo, null, 0, 0);
    }

    public void h(int i, int i2, int i3, int i4) {
        t tVar = this.i;
        if (tVar.i()) {
            DisplayMetrics displayMetrics = tVar.j.getResources().getDisplayMetrics();
            tVar.j(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (!tVar.g()) {
                return;
            }
            tVar.a();
        }
    }

    public void i(int[] iArr, int i) {
        t tVar = this.i;
        if (tVar.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = tVar.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                tVar.f = tVar.b(iArr2);
                if (!tVar.h()) {
                    StringBuilder g = c.a.a.a.a.g("None of the preset sizes is valid: ");
                    g.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(g.toString());
                }
            } else {
                tVar.g = false;
            }
            if (!tVar.g()) {
                return;
            }
            tVar.a();
        }
    }

    public void j(int i) {
        t tVar = this.i;
        if (tVar.i()) {
            if (i == 0) {
                tVar.a = 0;
                tVar.d = -1.0f;
                tVar.e = -1.0f;
                tVar.f274c = -1.0f;
                tVar.f = new int[0];
                tVar.f273b = false;
            } else if (i != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            } else {
                DisplayMetrics displayMetrics = tVar.j.getResources().getDisplayMetrics();
                tVar.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (!tVar.g()) {
                    return;
                }
                tVar.a();
            }
        }
    }

    public void k(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new m0();
        }
        m0 m0Var = this.h;
        m0Var.a = colorStateList;
        m0Var.d = colorStateList != null;
        this.f257b = m0Var;
        this.f258c = m0Var;
        this.d = m0Var;
        this.e = m0Var;
        this.f = m0Var;
        this.g = m0Var;
    }

    public void l(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new m0();
        }
        m0 m0Var = this.h;
        m0Var.f248b = mode;
        m0Var.f249c = mode != null;
        this.f257b = m0Var;
        this.f258c = m0Var;
        this.d = m0Var;
        this.e = m0Var;
        this.f = m0Var;
        this.g = m0Var;
    }

    public final void m(Context context, o0 o0Var) {
        String l;
        Typeface create;
        Typeface typeface;
        this.j = o0Var.i(2, this.j);
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i >= 28) {
            int i2 = o0Var.i(11, -1);
            this.k = i2;
            if (i2 != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        int i3 = 10;
        if (!o0Var.n(10) && !o0Var.n(12)) {
            if (!o0Var.n(1)) {
                return;
            }
            this.m = false;
            int i4 = o0Var.i(1, 1);
            if (i4 == 1) {
                typeface = Typeface.SANS_SERIF;
            } else if (i4 == 2) {
                typeface = Typeface.SERIF;
            } else if (i4 != 3) {
                return;
            } else {
                typeface = Typeface.MONOSPACE;
            }
            this.l = typeface;
            return;
        }
        this.l = null;
        if (o0Var.n(12)) {
            i3 = 12;
        }
        int i5 = this.k;
        int i6 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface h = o0Var.h(i3, this.j, new a(i5, i6, new WeakReference(this.a)));
                if (h != null) {
                    if (i >= 28 && this.k != -1) {
                        h = Typeface.create(Typeface.create(h, 0), this.k, (this.j & 2) != 0);
                    }
                    this.l = h;
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (l = o0Var.l(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            create = Typeface.create(l, this.j);
        } else {
            Typeface create2 = Typeface.create(l, 0);
            int i7 = this.k;
            if ((this.j & 2) != 0) {
                z = true;
            }
            create = Typeface.create(create2, i7, z);
        }
        this.l = create;
    }
}
