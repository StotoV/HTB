package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class k extends ImageButton implements b.h.j.p, b.h.k.h {

    /* renamed from: b  reason: collision with root package name */
    public final e f238b;

    /* renamed from: c  reason: collision with root package name */
    public final l f239c;

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public k(Context context, AttributeSet attributeSet, int i) {
        super(l0.a(context), attributeSet, i);
        k0.a(this, getContext());
        e eVar = new e(this);
        this.f238b = eVar;
        eVar.d(attributeSet, i);
        l lVar = new l(this);
        this.f239c = lVar;
        lVar.c(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f238b;
        if (eVar != null) {
            eVar.a();
        }
        l lVar = this.f239c;
        if (lVar != null) {
            lVar.a();
        }
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f238b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f238b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // b.h.k.h
    public ColorStateList getSupportImageTintList() {
        m0 m0Var;
        l lVar = this.f239c;
        if (lVar == null || (m0Var = lVar.f242b) == null) {
            return null;
        }
        return m0Var.a;
    }

    @Override // b.h.k.h
    public PorterDuff.Mode getSupportImageTintMode() {
        m0 m0Var;
        l lVar = this.f239c;
        if (lVar == null || (m0Var = lVar.f242b) == null) {
            return null;
        }
        return m0Var.f248b;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f239c.b() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f238b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f238b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        l lVar = this.f239c;
        if (lVar != null) {
            lVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        l lVar = this.f239c;
        if (lVar != null) {
            lVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f239c.d(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        l lVar = this.f239c;
        if (lVar != null) {
            lVar.a();
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f238b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f238b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // b.h.k.h
    public void setSupportImageTintList(ColorStateList colorStateList) {
        l lVar = this.f239c;
        if (lVar != null) {
            lVar.e(colorStateList);
        }
    }

    @Override // b.h.k.h
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        l lVar = this.f239c;
        if (lVar != null) {
            lVar.f(mode);
        }
    }
}
