package b.h.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class j {
    public static final b.e.d<String, Typeface> a = new b.e.d<>(16);

    /* renamed from: b  reason: collision with root package name */
    public static final ExecutorService f436b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f437c;
    public static final b.e.f<String, ArrayList<b.h.i.a<a>>> d;

    /* loaded from: classes.dex */
    public static final class a {
        public final Typeface a;

        /* renamed from: b  reason: collision with root package name */
        public final int f438b;

        public a(int i) {
            this.a = null;
            this.f438b = i;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.a = typeface;
            this.f438b = 0;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new n("fonts-androidx", 10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f436b = threadPoolExecutor;
        f437c = new Object();
        d = new b.e.f<>();
    }

    public static a a(String str, Context context, e eVar, int i) {
        int i2;
        Typeface a2 = a.a(str);
        if (a2 != null) {
            return new a(a2);
        }
        try {
            k a3 = d.a(context, eVar, null);
            int i3 = a3.a;
            int i4 = 1;
            if (i3 != 0) {
                if (i3 == 1) {
                    i2 = -2;
                }
                i2 = -3;
            } else {
                l[] lVarArr = a3.f439b;
                if (lVarArr != null && lVarArr.length != 0) {
                    for (l lVar : lVarArr) {
                        int i5 = lVar.e;
                        if (i5 != 0) {
                            if (i5 >= 0) {
                                i2 = i5;
                            }
                            i2 = -3;
                        }
                    }
                    i4 = 0;
                }
                i2 = i4;
            }
            if (i2 != 0) {
                return new a(i2);
            }
            Typeface b2 = b.h.d.d.a.b(context, null, a3.f439b, i);
            if (b2 == null) {
                return new a(-3);
            }
            a.b(str, b2);
            return new a(b2);
        } catch (PackageManager.NameNotFoundException unused) {
            return new a(-1);
        }
    }
}
