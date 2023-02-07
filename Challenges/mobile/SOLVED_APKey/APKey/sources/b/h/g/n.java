package b.h.g;

import android.os.Process;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
public class n implements ThreadFactory {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public int f442b;

    /* loaded from: classes.dex */
    public static class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public final int f443b;

        public a(Runnable runnable, String str, int i) {
            super(runnable, str);
            this.f443b = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(this.f443b);
            super.run();
        }
    }

    public n(String str, int i) {
        this.a = str;
        this.f442b = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new a(runnable, this.a, this.f442b);
    }
}
