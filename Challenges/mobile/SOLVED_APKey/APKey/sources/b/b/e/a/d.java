package b.b.e.a;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import b.b.e.a.b;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class d extends b {
    public a o;
    public boolean p;

    /* loaded from: classes.dex */
    public static class a extends b.c {
        public int[][] J;

        public a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[this.g.length];
            }
        }

        @Override // b.b.e.a.b.c
        public void e() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        public int g(int[] iArr) {
            int[][] iArr2 = this.J;
            int i = this.h;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    public d(a aVar) {
    }

    public d(a aVar, Resources resources) {
        e(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // b.b.e.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // b.b.e.a.b
    public void e(b.c cVar) {
        this.f145b = cVar;
        int i = this.h;
        if (i >= 0) {
            Drawable d = cVar.d(i);
            this.d = d;
            if (d != null) {
                c(d);
            }
        }
        this.e = null;
        if (cVar instanceof a) {
            this.o = (a) cVar;
        }
    }

    @Override // b.b.e.a.b
    /* renamed from: f */
    public a b() {
        return new a(this.o, this, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // b.b.e.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.p) {
            super.mutate();
            if (this == this) {
                this.o.e();
                this.p = true;
            }
        }
        return this;
    }

    @Override // b.b.e.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int g = this.o.g(iArr);
        if (g < 0) {
            g = this.o.g(StateSet.WILD_CARD);
        }
        return d(g) || onStateChange;
    }
}
