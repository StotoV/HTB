package b.b.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class f extends Button implements b.h.j.p, b.h.k.b, b.h.k.g {

    /* renamed from: b  reason: collision with root package name */
    public final e f216b;

    /* renamed from: c  reason: collision with root package name */
    public final q f217c;

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(l0.a(context), attributeSet, i);
        k0.a(this, getContext());
        e eVar = new e(this);
        this.f216b = eVar;
        eVar.d(attributeSet, i);
        q qVar = new q(this);
        this.f217c = qVar;
        qVar.e(attributeSet, i);
        qVar.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f216b;
        if (eVar != null) {
            eVar.a();
        }
        q qVar = this.f217c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b.h.k.b.a) {
            return super.getAutoSizeMaxTextSize();
        }
        q qVar = this.f217c;
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
        q qVar = this.f217c;
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
        q qVar = this.f217c;
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
        q qVar = this.f217c;
        return qVar != null ? qVar.i.f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b.h.k.b.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        q qVar = this.f217c;
        if (qVar == null) {
            return 0;
        }
        return qVar.i.a;
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f216b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f216b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        m0 m0Var = this.f217c.h;
        if (m0Var != null) {
            return m0Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        m0 m0Var = this.f217c.h;
        if (m0Var != null) {
            return m0Var.f248b;
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        q qVar = this.f217c;
        if (qVar == null || b.h.k.b.a) {
            return;
        }
        qVar.i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        q qVar = this.f217c;
        if (qVar == null || b.h.k.b.a || !qVar.d()) {
            return;
        }
        this.f217c.i.a();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (b.h.k.b.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        q qVar = this.f217c;
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
        q qVar = this.f217c;
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
        q qVar = this.f217c;
        if (qVar == null) {
            return;
        }
        qVar.j(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f216b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f216b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b.h.b.a.m0(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        q qVar = this.f217c;
        if (qVar != null) {
            qVar.a.setAllCaps(z);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f216b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f216b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.h.k.g
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f217c.k(colorStateList);
        this.f217c.b();
    }

    @Override // b.h.k.g
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f217c.l(mode);
        this.f217c.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        q qVar = this.f217c;
        if (qVar != null) {
            qVar.f(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = b.h.k.b.a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        q qVar = this.f217c;
        if (qVar == null || z || qVar.d()) {
            return;
        }
        qVar.i.f(i, f);
    }
}
