package b.h.h;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes.dex */
public final class b {
    public static Method a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f452b;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i >= 24) {
                return;
            }
            try {
                f452b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                return;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            a = cls.getMethod("getScript", String.class);
            f452b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e2) {
            a = null;
            f452b = null;
            Log.w("ICUCompat", e2);
        }
    }
}
