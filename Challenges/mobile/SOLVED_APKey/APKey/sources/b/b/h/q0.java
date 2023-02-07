package b.b.h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class q0 implements v {
    public Toolbar a;

    /* renamed from: b  reason: collision with root package name */
    public int f261b;

    /* renamed from: c  reason: collision with root package name */
    public View f262c;
    public Drawable d;
    public Drawable e;
    public Drawable f;
    public boolean g;
    public CharSequence h;
    public CharSequence i;
    public CharSequence j;
    public Window.Callback k;
    public boolean l;
    public int m;
    public Drawable n;

    public q0(Toolbar toolbar, boolean z) {
        Drawable drawable;
        this.m = 0;
        this.a = toolbar;
        this.h = toolbar.getTitle();
        this.i = toolbar.getSubtitle();
        this.g = this.h != null;
        this.f = toolbar.getNavigationIcon();
        String str = null;
        o0 p = o0.p(toolbar.getContext(), null, b.b.b.a, R.attr.actionBarStyle, 0);
        int i = 15;
        this.n = p.g(15);
        if (z) {
            CharSequence m = p.m(27);
            if (!TextUtils.isEmpty(m)) {
                this.g = true;
                this.h = m;
                if ((this.f261b & 8) != 0) {
                    this.a.setTitle(m);
                }
            }
            CharSequence m2 = p.m(25);
            if (!TextUtils.isEmpty(m2)) {
                this.i = m2;
                if ((this.f261b & 8) != 0) {
                    this.a.setSubtitle(m2);
                }
            }
            Drawable g = p.g(20);
            if (g != null) {
                this.e = g;
                i();
            }
            Drawable g2 = p.g(17);
            if (g2 != null) {
                this.d = g2;
                i();
            }
            if (this.f == null && (drawable = this.n) != null) {
                this.f = drawable;
                h();
            }
            f(p.i(10, 0));
            int k = p.k(9, 0);
            if (k != 0) {
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(k, (ViewGroup) this.a, false);
                View view = this.f262c;
                if (view != null && (this.f261b & 16) != 0) {
                    this.a.removeView(view);
                }
                this.f262c = inflate;
                if (inflate != null && (this.f261b & 16) != 0) {
                    this.a.addView(inflate);
                }
                f(this.f261b | 16);
            }
            int j = p.j(13, 0);
            if (j > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = j;
                this.a.setLayoutParams(layoutParams);
            }
            int e = p.e(7, -1);
            int e2 = p.e(3, -1);
            if (e >= 0 || e2 >= 0) {
                Toolbar toolbar2 = this.a;
                int max = Math.max(e, 0);
                int max2 = Math.max(e2, 0);
                toolbar2.d();
                toolbar2.u.a(max, max2);
            }
            int k2 = p.k(28, 0);
            if (k2 != 0) {
                Toolbar toolbar3 = this.a;
                Context context = toolbar3.getContext();
                toolbar3.m = k2;
                TextView textView = toolbar3.f43c;
                if (textView != null) {
                    textView.setTextAppearance(context, k2);
                }
            }
            int k3 = p.k(26, 0);
            if (k3 != 0) {
                Toolbar toolbar4 = this.a;
                Context context2 = toolbar4.getContext();
                toolbar4.n = k3;
                TextView textView2 = toolbar4.d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, k3);
                }
            }
            int k4 = p.k(22, 0);
            if (k4 != 0) {
                this.a.setPopupTheme(k4);
            }
        } else {
            if (this.a.getNavigationIcon() != null) {
                this.n = this.a.getNavigationIcon();
            } else {
                i = 11;
            }
            this.f261b = i;
        }
        p.f252b.recycle();
        if (R.string.abc_action_bar_up_description != this.m) {
            this.m = R.string.abc_action_bar_up_description;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                int i2 = this.m;
                this.j = i2 != 0 ? e().getString(i2) : str;
                g();
            }
        }
        this.j = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new p0(this));
    }

    @Override // b.b.h.v
    public void a() {
        c cVar;
        ActionMenuView actionMenuView = this.a.f42b;
        if (actionMenuView == null || (cVar = actionMenuView.u) == null) {
            return;
        }
        cVar.b();
    }

    @Override // b.b.h.v
    public void b(int i) {
        this.e = i != 0 ? b.b.d.a.a.b(e(), i) : null;
        i();
    }

    @Override // b.b.h.v
    public void c(CharSequence charSequence) {
        if (!this.g) {
            this.h = charSequence;
            if ((this.f261b & 8) == 0) {
                return;
            }
            this.a.setTitle(charSequence);
        }
    }

    @Override // b.b.h.v
    public void d(Window.Callback callback) {
        this.k = callback;
    }

    public Context e() {
        return this.a.getContext();
    }

    public void f(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f261b ^ i;
        this.f261b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    g();
                }
                h();
            }
            if ((i2 & 3) != 0) {
                i();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.h);
                    toolbar = this.a;
                    charSequence = this.i;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || (view = this.f262c) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    public final void g() {
        if ((this.f261b & 4) != 0) {
            if (TextUtils.isEmpty(this.j)) {
                this.a.setNavigationContentDescription(this.m);
            } else {
                this.a.setNavigationContentDescription(this.j);
            }
        }
    }

    @Override // b.b.h.v
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    public final void h() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f261b & 4) != 0) {
            toolbar = this.a;
            drawable = this.f;
            if (drawable == null) {
                drawable = this.n;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void i() {
        Drawable drawable;
        int i = this.f261b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.e) == null) {
            drawable = this.d;
        }
        this.a.setLogo(drawable);
    }

    @Override // b.b.h.v
    public void setIcon(int i) {
        this.d = i != 0 ? b.b.d.a.a.b(e(), i) : null;
        i();
    }

    @Override // b.b.h.v
    public void setIcon(Drawable drawable) {
        this.d = drawable;
        i();
    }
}
