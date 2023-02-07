package b.h.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import b.h.g.m;
import java.lang.reflect.Method;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class d {
    public static final j a;

    /* renamed from: b  reason: collision with root package name */
    public static final b.e.d<String, Typeface> f414b;

    /* loaded from: classes.dex */
    public static class a extends m {
        public b.h.c.b.g a;

        public a(b.h.c.b.g gVar) {
            this.a = gVar;
        }
    }

    static {
        j eVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            eVar = new i();
        } else if (i >= 28) {
            eVar = new h();
        } else if (i >= 26) {
            eVar = new g();
        } else {
            if (i >= 24) {
                Method method = f.d;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    eVar = new f();
                }
            }
            eVar = i >= 21 ? new e() : new j();
        }
        a = eVar;
        f414b = new b.e.d<>(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r0.equals(r4) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r5, b.h.c.b.b r6, android.content.res.Resources r7, int r8, int r9, b.h.c.b.g r10, android.os.Handler r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.d.d.a(android.content.Context, b.h.c.b.b, android.content.res.Resources, int, int, b.h.c.b.g, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Typeface b(Context context, Resources resources, int i, String str, int i2) {
        Typeface d = a.d(context, resources, i, str, i2);
        if (d != null) {
            f414b.b(c(resources, i, i2), d);
        }
        return d;
    }

    public static String c(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
