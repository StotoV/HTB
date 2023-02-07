package b.h.h;

import android.icu.util.ULocale;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes.dex */
public final class f {
    public static final Locale a = new Locale("", "");

    public static int a(Locale locale) {
        String script;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(a)) {
            Method method = b.a;
            if (i >= 24) {
                script = ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
            } else if (i >= 21) {
                try {
                    script = ((Locale) b.f452b.invoke(null, locale)).getScript();
                } catch (IllegalAccessException | InvocationTargetException e) {
                    Log.w("ICUCompat", e);
                    script = locale.getScript();
                }
            } else {
                String locale2 = locale.toString();
                try {
                    Method method2 = b.f452b;
                    if (method2 != null) {
                        locale2 = (String) method2.invoke(null, locale2);
                    }
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    Log.w("ICUCompat", e2);
                }
                if (locale2 != null) {
                    try {
                        Method method3 = b.a;
                        if (method3 != null) {
                            script = (String) method3.invoke(null, locale2);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e3) {
                        Log.w("ICUCompat", e3);
                    }
                }
                script = null;
            }
            if (script == null) {
                byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
                return (directionality == 1 || directionality == 2) ? 1 : 0;
            } else if (script.equalsIgnoreCase("Arab") || script.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }
}
