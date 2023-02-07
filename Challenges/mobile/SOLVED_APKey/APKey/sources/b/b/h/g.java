package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class g extends CheckBox implements b.h.k.f, b.h.j.p {

    /* renamed from: b  reason: collision with root package name */
    public final h f220b;

    /* renamed from: c  reason: collision with root package name */
    public final e f221c;
    public final q d;

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(l0.a(context), attributeSet, i);
        k0.a(this, getContext());
        h hVar = new h(this);
        this.f220b = hVar;
        hVar.c(attributeSet, i);
        e eVar = new e(this);
        this.f221c = eVar;
        eVar.d(attributeSet, i);
        q qVar = new q(this);
        this.d = qVar;
        qVar.e(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f221c;
        if (eVar != null) {
            eVar.a();
        }
        q qVar = this.d;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        h hVar = this.f220b;
        return hVar != null ? hVar.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f221c;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f221c;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        h hVar = this.f220b;
        if (hVar != null) {
            return hVar.f222b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        h hVar = this.f220b;
        if (hVar != null) {
            return hVar.f223c;
        }
        return null;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f221c;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f221c;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(b.b.d.a.a.b(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        h hVar = this.f220b;
        if (hVar != null) {
            if (hVar.f) {
                hVar.f = false;
                return;
            }
            hVar.f = true;
            hVar.a();
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f221c;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f221c;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.h.k.f
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        h hVar = this.f220b;
        if (hVar != null) {
            hVar.f222b = colorStateList;
            hVar.d = true;
            hVar.a();
        }
    }

    @Override // b.h.k.f
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        h hVar = this.f220b;
        if (hVar != null) {
            hVar.f223c = mode;
            hVar.e = true;
            hVar.a();
        }
    }
}
