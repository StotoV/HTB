package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class d extends AutoCompleteTextView implements b.h.j.p {
    public static final int[] d = {16843126};

    /* renamed from: b  reason: collision with root package name */
    public final e f212b;

    /* renamed from: c  reason: collision with root package name */
    public final q f213c;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public d(Context context, AttributeSet attributeSet, int i) {
        super(l0.a(context), attributeSet, i);
        k0.a(this, getContext());
        o0 p = o0.p(getContext(), attributeSet, d, i, 0);
        if (p.n(0)) {
            setDropDownBackgroundDrawable(p.g(0));
        }
        p.f252b.recycle();
        e eVar = new e(this);
        this.f212b = eVar;
        eVar.d(attributeSet, i);
        q qVar = new q(this);
        this.f213c = qVar;
        qVar.e(attributeSet, i);
        qVar.b();
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f212b;
        if (eVar != null) {
            eVar.a();
        }
        q qVar = this.f213c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f212b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f212b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        b.b.a.d(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f212b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f212b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b.h.b.a.m0(this, callback));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(b.b.d.a.a.b(getContext(), i));
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f212b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f212b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        q qVar = this.f213c;
        if (qVar != null) {
            qVar.f(context, i);
        }
    }
}
