package c.c.a.a.k;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final int a;

    static {
        int i = Build.VERSION.SDK_INT;
        a = i >= 21 ? 2 : i >= 18 ? 1 : 0;
    }
}
