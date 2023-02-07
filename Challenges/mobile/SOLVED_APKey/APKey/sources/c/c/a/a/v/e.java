package c.c.a.a.v;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    public static e f899c;
    public final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Handler f900b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            e eVar = e.this;
            b bVar = (b) message.obj;
            synchronized (eVar.a) {
                if (bVar == null) {
                    bVar.getClass();
                    throw null;
                }
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
    }
}
