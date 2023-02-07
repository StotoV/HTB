package b.h.d.l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* loaded from: classes.dex */
public final class e extends Drawable.ConstantState {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Drawable.ConstantState f421b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f422c;
    public PorterDuff.Mode d;

    public e(e eVar) {
        this.f422c = null;
        this.d = c.h;
        if (eVar != null) {
            this.a = eVar.a;
            this.f421b = eVar.f421b;
            this.f422c = eVar.f422c;
            this.d = eVar.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.a;
        Drawable.ConstantState constantState = this.f421b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new d(this, resources) : new c(this, resources);
    }
}
