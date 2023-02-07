package c.c.a.a.s;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import c.c.a.a.u.n;
/* loaded from: classes.dex */
public class a extends Drawable implements n, b.h.d.l.a {

    /* renamed from: b  reason: collision with root package name */
    public b f869b;

    /* loaded from: classes.dex */
    public static final class b extends Drawable.ConstantState {
        public g a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f870b;

        public b(b bVar) {
            this.a = (g) bVar.a.f876b.newDrawable();
            this.f870b = bVar.f870b;
        }

        public b(g gVar) {
            this.a = gVar;
            this.f870b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(new b(this), null);
        }
    }

    public a(b bVar, C0040a c0040a) {
        this.f869b = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        b bVar = this.f869b;
        if (bVar.f870b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f869b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f869b.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f869b = new b(this.f869b);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f869b.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f869b.a.setState(iArr)) {
            onStateChange = true;
        }
        boolean b2 = c.c.a.a.s.b.b(iArr);
        b bVar = this.f869b;
        if (bVar.f870b != b2) {
            bVar.f870b = b2;
            return true;
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f869b.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f869b.a.setColorFilter(colorFilter);
    }

    @Override // c.c.a.a.u.n
    public void setShapeAppearanceModel(j jVar) {
        g gVar = this.f869b.a;
        gVar.f876b.a = jVar;
        gVar.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTint(int i) {
        this.f869b.a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintList(ColorStateList colorStateList) {
        this.f869b.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintMode(PorterDuff.Mode mode) {
        this.f869b.a.setTintMode(mode);
    }

    public a(j jVar) {
        this.f869b = new b(new g(jVar));
    }
}
