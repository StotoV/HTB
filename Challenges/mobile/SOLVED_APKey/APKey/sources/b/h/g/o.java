package b.h.g;

import android.os.Handler;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class o<T> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public Callable<T> f444b;

    /* renamed from: c  reason: collision with root package name */
    public b.h.i.a<T> f445c;
    public Handler d;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.h.i.a f446b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f447c;

        public a(o oVar, b.h.i.a aVar, Object obj) {
            this.f446b = aVar;
            this.f447c = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f446b.a(this.f447c);
        }
    }

    public o(Handler handler, Callable<T> callable, b.h.i.a<T> aVar) {
        this.f444b = callable;
        this.f445c = aVar;
        this.d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T t;
        try {
            t = this.f444b.call();
        } catch (Exception unused) {
            t = null;
        }
        this.d.post(new a(this, this.f445c, t));
    }
}
