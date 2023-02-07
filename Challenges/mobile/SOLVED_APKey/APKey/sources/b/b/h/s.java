package b.b.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import b.h.h.c;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class s extends TextView implements b.h.j.p, b.h.k.g, b.h.k.b {

    /* renamed from: b  reason: collision with root package name */
    public final e f269b;

    /* renamed from: c  reason: collision with root package name */
    public final q f270c;
    public final p d;
    public boolean e;
    public Future<b.h.h.c> f;

    public s(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public s(Context context, AttributeSet attributeSet, int i) {
        super(l0.a(context), attributeSet, i);
        this.e = false;
        k0.a(this, getContext());
        e eVar = new e(this);
        this.f269b = eVar;
        eVar.d(attributeSet, i);
        q qVar = new q(this);
        this.f270c = qVar;
        qVar.e(attributeSet, i);
        qVar.b();
        this.d = new p(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f269b;
        if (eVar != null) {
            eVar.a();
        }
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.h.k.b.a) {
            return super.getAutoSizeMaxTextSize();
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return -1;
        }
        return Math.round(qVar.i.e);
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b.h.k.b.a) {
            return super.getAutoSizeMinTextSize();
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return -1;
        }
        return Math.round(qVar.i.d);
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b.h.k.b.a) {
            return super.getAutoSizeStepGranularity();
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return -1;
        }
        return Math.round(qVar.i.f274c);
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b.h.k.b.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        q qVar = this.f270c;
        return qVar != null ? qVar.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.h.k.b.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return 0;
        }
        return qVar.i.a;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f269b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f269b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        m0 m0Var = this.f270c.h;
        if (m0Var != null) {
            return m0Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        m0 m0Var = this.f270c.h;
        if (m0Var != null) {
            return m0Var.f248b;
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future<b.h.h.c> future = this.f;
        if (future != null) {
            try {
                this.f = null;
                b.h.b.a.d0(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        p pVar;
        return (Build.VERSION.SDK_INT >= 28 || (pVar = this.d) == null) ? super.getTextClassifier() : pVar.a();
    }

    public c.a getTextMetricsParamsCompat() {
        return b.h.b.a.D(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f270c.g(this, onCreateInputConnection, editorInfo);
        b.b.a.d(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        q qVar = this.f270c;
        if (qVar == null || b.h.k.b.a) {
            return;
        }
        qVar.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Future<b.h.h.c> future = this.f;
        if (future != null) {
            try {
                this.f = null;
                b.h.b.a.d0(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        q qVar = this.f270c;
        if (qVar == null || b.h.k.b.a || !qVar.d()) {
            return;
        }
        this.f270c.i.a();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.h.k.b.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return;
        }
        qVar.h(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (b.h.k.b.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return;
        }
        qVar.i(iArr, i);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (b.h.k.b.a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        q qVar = this.f270c;
        if (qVar == null) {
            return;
        }
        qVar.j(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f269b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f269b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? b.b.d.a.a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? b.b.d.a.a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? b.b.d.a.a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = b.b.d.a.a.b(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? b.b.d.a.a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? b.b.d.a.a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? b.b.d.a.a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = b.b.d.a.a.b(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b.h.b.a.m0(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            b.h.b.a.U(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            b.h.b.a.X(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        b.h.b.a.Z(this, i);
    }

    public void setPrecomputedText(b.h.h.c cVar) {
        b.h.b.a.d0(this, cVar);
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f269b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f269b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.h.k.g
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f270c.k(colorStateList);
        this.f270c.b();
    }

    @Override // b.h.k.g
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f270c.l(mode);
        this.f270c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.f(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        p pVar;
        if (Build.VERSION.SDK_INT < 28 && (pVar = this.d) != null) {
            pVar.f254b = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<b.h.h.c> future) {
        this.f = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(c.a aVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            TextDirectionHeuristic textDirectionHeuristic = aVar.f453b;
            int i2 = 1;
            if (textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL && textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                    i2 = 2;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                    i2 = 3;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                    i2 = 4;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                    i2 = 5;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                    i2 = 6;
                } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                    i2 = 7;
                }
            }
            setTextDirection(i2);
        }
        if (i < 23) {
            float textScaleX = aVar.a.getTextScaleX();
            getPaint().set(aVar.a);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
            return;
        }
        getPaint().set(aVar.a);
        setBreakStrategy(aVar.f454c);
        setHyphenationFrequency(aVar.d);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = b.h.k.b.a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        q qVar = this.f270c;
        if (qVar == null || z || qVar.d()) {
            return;
        }
        qVar.i.f(i, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r0 != null) goto L22;
     */
    @Override // android.widget.TextView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setTypeface(android.graphics.Typeface r9, int r10) {
        /*
            r8 = this;
            boolean r0 = r8.e
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 0
            if (r9 == 0) goto L50
            if (r10 <= 0) goto L50
            android.content.Context r1 = r8.getContext()
            b.h.d.j r2 = b.h.d.d.a
            if (r1 == 0) goto L48
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r2 >= r3) goto L43
            b.h.d.j r2 = b.h.d.d.a
            r2.getClass()
            long r3 = b.h.d.j.g(r9)
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L29
            r3 = r0
            goto L35
        L29:
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, b.h.c.b.c> r5 = r2.a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r3 = r5.get(r3)
            b.h.c.b.c r3 = (b.h.c.b.c) r3
        L35:
            if (r3 != 0) goto L38
            goto L40
        L38:
            android.content.res.Resources r0 = r1.getResources()
            android.graphics.Typeface r0 = r2.a(r1, r3, r0, r10)
        L40:
            if (r0 == 0) goto L43
            goto L50
        L43:
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r9, r10)
            goto L50
        L48:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Context cannot be null"
            r9.<init>(r10)
            throw r9
        L50:
            r1 = 1
            r8.e = r1
            if (r0 == 0) goto L56
            r9 = r0
        L56:
            r0 = 0
            super.setTypeface(r9, r10)     // Catch: java.lang.Throwable -> L5d
            r8.e = r0
            return
        L5d:
            r9 = move-exception
            r8.e = r0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.s.setTypeface(android.graphics.Typeface, int):void");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        q qVar = this.f270c;
        if (qVar != null) {
            qVar.b();
        }
    }
}
