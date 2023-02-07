package c.c.a.a.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.h.j.q;
import com.example.apkey.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class n {
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f915b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f916c;
    public int d;
    public FrameLayout e;
    public Animator f;
    public final float g;
    public int h;
    public int i;
    public CharSequence j;
    public boolean k;
    public TextView l;
    public CharSequence m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f918c;
        public final /* synthetic */ TextView d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.a = i;
            this.f917b = textView;
            this.f918c = i2;
            this.d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.h = this.a;
            nVar.f = null;
            TextView textView2 = this.f917b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f918c == 1 && (textView = n.this.l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.f915b = textInputLayout;
        this.g = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i) {
        if (this.f916c == null && this.e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.f916c = linearLayout;
            linearLayout.setOrientation(0);
            this.f915b.addView(this.f916c, -1, -2);
            this.e = new FrameLayout(this.a);
            this.f916c.addView(this.e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f915b.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.e.setVisibility(0);
            this.e.addView(textView);
        } else {
            this.f916c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f916c.setVisibility(0);
        this.d++;
    }

    public void b() {
        if ((this.f916c == null || this.f915b.getEditText() == null) ? false : true) {
            EditText editText = this.f915b.getEditText();
            boolean i = c.c.a.a.a.i(this.a);
            q.K(this.f916c, h(i, R.dimen.material_helper_text_font_1_3_padding_horizontal, q.q(editText)), h(i, R.dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top)), h(i, R.dimen.material_helper_text_font_1_3_padding_horizontal, q.p(editText)), 0);
        }
    }

    public void c() {
        Animator animator = this.f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i != i3 && i != i2) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i3 == i ? 1.0f : 0.0f);
        ofFloat.setDuration(167L);
        ofFloat.setInterpolator(c.c.a.a.c.a.a);
        list.add(ofFloat);
        if (i3 != i) {
            return;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.g, 0.0f);
        ofFloat2.setDuration(217L);
        ofFloat2.setInterpolator(c.c.a.a.c.a.d);
        list.add(ofFloat2);
    }

    public boolean e() {
        return this.i == 1 && this.l != null && !TextUtils.isEmpty(this.j);
    }

    public final TextView f(int i) {
        if (i != 1) {
            if (i == 2) {
                return this.r;
            }
            return null;
        }
        return this.l;
    }

    public int g() {
        TextView textView = this.l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int h(boolean z, int i, int i2) {
        return z ? this.a.getResources().getDimensionPixelSize(i) : i2;
    }

    public void i() {
        this.j = null;
        c();
        if (this.h == 1) {
            this.i = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        l(this.h, this.i, k(this.l, null));
    }

    public void j(TextView textView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f916c;
        if (linearLayout == null) {
            return;
        }
        if (!(i == 0 || i == 1) || (frameLayout = this.e) == null) {
            linearLayout.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i2 = this.d - 1;
        this.d = i2;
        LinearLayout linearLayout2 = this.f916c;
        if (i2 != 0) {
            return;
        }
        linearLayout2.setVisibility(8);
    }

    public final boolean k(TextView textView, CharSequence charSequence) {
        return q.u(this.f915b) && this.f915b.isEnabled() && (this.i != this.h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void l(int i, int i2, boolean z) {
        TextView f;
        TextView f2;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.q, this.r, 2, i, i2);
            d(arrayList, this.k, this.l, 1, i, i2);
            c.c.a.a.a.o(animatorSet, arrayList);
            animatorSet.addListener(new a(i2, f(i), i, f(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (f2 = f(i2)) != null) {
                f2.setVisibility(0);
                f2.setAlpha(1.0f);
            }
            if (i != 0 && (f = f(i)) != null) {
                f.setVisibility(4);
                if (i == 1) {
                    f.setText((CharSequence) null);
                }
            }
            this.h = i2;
        }
        this.f915b.w();
        this.f915b.y(z, false);
        this.f915b.F();
    }
}
