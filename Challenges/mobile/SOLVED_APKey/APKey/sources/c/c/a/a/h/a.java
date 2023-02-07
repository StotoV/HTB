package c.c.a.a.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import b.h.j.q;
import c.c.a.a.s.b;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import c.c.a.a.u.n;
import com.example.apkey.R;
import com.google.android.material.button.MaterialButton;
/* loaded from: classes.dex */
public class a {
    public static final boolean t;
    public final MaterialButton a;

    /* renamed from: b  reason: collision with root package name */
    public j f787b;

    /* renamed from: c  reason: collision with root package name */
    public int f788c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public Drawable m;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q;
    public LayerDrawable r;
    public int s;

    static {
        t = Build.VERSION.SDK_INT >= 21;
    }

    public a(MaterialButton materialButton, j jVar) {
        this.a = materialButton;
        this.f787b = jVar;
    }

    public n a() {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (n) (this.r.getNumberOfLayers() > 2 ? this.r.getDrawable(2) : this.r.getDrawable(1));
    }

    public g b() {
        return c(false);
    }

    public final g c(boolean z) {
        LayerDrawable layerDrawable = this.r;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (g) (t ? (LayerDrawable) ((InsetDrawable) this.r.getDrawable(0)).getDrawable() : this.r).getDrawable(!z ? 1 : 0);
    }

    public final g d() {
        return c(true);
    }

    public void e(j jVar) {
        this.f787b = jVar;
        if (b() != null) {
            g b2 = b();
            b2.f876b.a = jVar;
            b2.invalidateSelf();
        }
        if (d() != null) {
            g d = d();
            d.f876b.a = jVar;
            d.invalidateSelf();
        }
        if (a() != null) {
            a().setShapeAppearanceModel(jVar);
        }
    }

    public final void f(int i, int i2) {
        int q = q.q(this.a);
        int paddingTop = this.a.getPaddingTop();
        int p = q.p(this.a);
        int paddingBottom = this.a.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            g();
        }
        q.K(this.a, q, (paddingTop + i) - i3, p, (paddingBottom + i2) - i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.graphics.drawable.LayerDrawable, android.graphics.drawable.RippleDrawable] */
    public final void g() {
        InsetDrawable insetDrawable;
        MaterialButton materialButton = this.a;
        g gVar = new g(this.f787b);
        gVar.n(this.a.getContext());
        b.h.b.a.g0(gVar, this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            b.h.b.a.h0(gVar, mode);
        }
        gVar.s(this.h, this.k);
        g gVar2 = new g(this.f787b);
        gVar2.setTint(0);
        gVar2.r(this.h, this.n ? c.c.a.a.a.e(this.a, R.attr.colorSurface) : 0);
        if (t) {
            g gVar3 = new g(this.f787b);
            this.m = gVar3;
            b.h.b.a.f0(gVar3, -1);
            ?? rippleDrawable = new RippleDrawable(b.a(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.f788c, this.e, this.d, this.f), this.m);
            this.r = rippleDrawable;
            insetDrawable = rippleDrawable;
        } else {
            c.c.a.a.s.a aVar = new c.c.a.a.s.a(this.f787b);
            this.m = aVar;
            b.h.b.a.g0(aVar, b.a(this.l));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.m});
            this.r = layerDrawable;
            insetDrawable = new InsetDrawable((Drawable) layerDrawable, this.f788c, this.e, this.d, this.f);
        }
        materialButton.setInternalBackground(insetDrawable);
        g b2 = b();
        if (b2 != null) {
            b2.o(this.s);
        }
    }

    public final void h() {
        g b2 = b();
        g d = d();
        if (b2 != null) {
            b2.s(this.h, this.k);
            if (d == null) {
                return;
            }
            d.r(this.h, this.n ? c.c.a.a.a.e(this.a, R.attr.colorSurface) : 0);
        }
    }
}
