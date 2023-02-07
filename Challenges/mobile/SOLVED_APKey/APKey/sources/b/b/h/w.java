package b.b.h;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class w {
    public static final int[] a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f275b = new int[0];

    static {
        new Rect();
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    public static boolean a(Drawable drawable) {
        Drawable drawable2;
        if (Build.VERSION.SDK_INT >= 17 || !(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof DrawableContainer)) {
                if (drawable instanceof b.h.d.l.b) {
                    drawable2 = ((b.h.d.l.b) drawable).a();
                } else if (drawable instanceof b.b.e.a.c) {
                    return a(((b.b.e.a.c) drawable).f151b);
                } else {
                    if (!(drawable instanceof ScaleDrawable)) {
                        return true;
                    }
                    drawable2 = ((ScaleDrawable) drawable).getDrawable();
                }
                return a(drawable2);
            }
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable drawable3 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!a(drawable3)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void b(Drawable drawable) {
        if (Build.VERSION.SDK_INT != 21 || !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(a);
        } else {
            drawable.setState(f275b);
        }
        drawable.setState(state);
    }

    public static PorterDuff.Mode c(int i, PorterDuff.Mode mode) {
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
}
