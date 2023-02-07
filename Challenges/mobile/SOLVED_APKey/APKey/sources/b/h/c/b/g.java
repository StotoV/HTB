package b.h.c.b;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public abstract class g {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Typeface f407b;

        public a(Typeface typeface) {
            this.f407b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.e(this.f407b);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f409b;

        public b(int i) {
            this.f409b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d(this.f409b);
        }
    }

    public static Handler c(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }

    public final void a(int i, Handler handler) {
        c(handler).post(new b(i));
    }

    public final void b(Typeface typeface, Handler handler) {
        c(handler).post(new a(typeface));
    }

    public abstract void d(int i);

    public abstract void e(Typeface typeface);
}
