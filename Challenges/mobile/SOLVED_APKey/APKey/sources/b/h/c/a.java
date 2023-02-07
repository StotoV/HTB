package b.h.c;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* loaded from: classes.dex */
public class a {
    public static final Object a = new Object();

    public static int a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColor(i) : context.getResources().getColor(i);
    }

    public static Drawable b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 21 ? context.getDrawable(i) : context.getResources().getDrawable(i);
    }
}
