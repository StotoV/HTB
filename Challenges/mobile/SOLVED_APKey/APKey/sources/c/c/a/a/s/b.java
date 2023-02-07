package c.c.a.a.s;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
/* loaded from: classes.dex */
public class b {
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f871b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f872c;

    static {
        a = Build.VERSION.SDK_INT >= 21;
        f871b = new int[]{16842910, 16842919};
        f872c = b.class.getSimpleName();
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f871b, 0)) != 0) {
                Log.w(f872c, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean b(int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i : iArr) {
            if (i == 16842910) {
                z = true;
            } else if (i == 16842908 || i == 16842919 || i == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
