package c.c.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewParent;
import b.b.h.o0;
import b.h.j.q;
import c.c.a.a.k.d;
import c.c.a.a.u.e;
import c.c.a.a.u.g;
import c.c.a.a.u.i;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public static Animator a(d dVar, float f, float f2, float f3) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, (Property<d, V>) d.c.a, (TypeEvaluator) d.b.f789b, (Object[]) new d.e[]{new d.e(f, f2, f3)});
        if (Build.VERSION.SDK_INT >= 21) {
            d.e revealInfo = dVar.getRevealInfo();
            if (revealInfo == null) {
                throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
            }
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f, (int) f2, revealInfo.f791c, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        return ofObject;
    }

    public static c.c.a.a.u.d b(int i) {
        if (i != 0) {
            if (i != 1) {
                return new i();
            }
            return new e();
        }
        return new i();
    }

    public static float c(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f3 - f, f4 - f2);
    }

    public static int d(Context context, int i, int i2) {
        TypedValue p = p(context, i);
        return p != null ? p.data : i2;
    }

    public static int e(View view, int i) {
        return r(view.getContext(), i, view.getClass().getCanonicalName());
    }

    public static ColorStateList f(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList a;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (a = b.b.d.a.a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : a;
    }

    public static ColorStateList g(Context context, o0 o0Var, int i) {
        int resourceId;
        ColorStateList a;
        return (!o0Var.f252b.hasValue(i) || (resourceId = o0Var.f252b.getResourceId(i, 0)) == 0 || (a = b.b.d.a.a.a(context, resourceId)) == null) ? o0Var.c(i) : a;
    }

    public static Drawable h(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable b2;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (b2 = b.b.d.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : b2;
    }

    public static boolean i(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean j(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static boolean k(View view) {
        return q.o(view) == 1;
    }

    public static int l(int i, int i2, float f) {
        return b.h.d.a.a(b.h.d.a.c(i2, Math.round(Color.alpha(i2) * f)), i);
    }

    public static float m(float f, float f2, float f3) {
        return (f3 * f2) + ((1.0f - f3) * f);
    }

    public static PorterDuff.Mode n(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i == 5) {
                return PorterDuff.Mode.SRC_IN;
            }
            if (i == 9) {
                return PorterDuff.Mode.SRC_ATOP;
            }
            switch (i) {
                case 14:
                    return PorterDuff.Mode.MULTIPLY;
                case 15:
                    return PorterDuff.Mode.SCREEN;
                case 16:
                    return PorterDuff.Mode.ADD;
                default:
                    return mode;
            }
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void o(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Animator animator = list.get(i);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static TypedValue p(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean q(Context context, int i, boolean z) {
        TypedValue p = p(context, i);
        return (p == null || p.type != 18) ? z : p.data != 0;
    }

    public static int r(Context context, int i, String str) {
        TypedValue p = p(context, i);
        if (p != null) {
            return p.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i)));
    }

    public static void s(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            g gVar = (g) background;
            g.b bVar = gVar.f876b;
            if (bVar.o == f) {
                return;
            }
            bVar.o = f;
            gVar.w();
        }
    }

    public static void t(View view, g gVar) {
        c.c.a.a.n.a aVar = gVar.f876b.f878b;
        if (aVar != null && aVar.a) {
            float f = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                f += q.m((View) parent);
            }
            g.b bVar = gVar.f876b;
            if (bVar.n == f) {
                return;
            }
            bVar.n = f;
            gVar.w();
        }
    }

    public static PorterDuffColorFilter u(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
