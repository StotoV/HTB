package b.h.g;

import android.os.Handler;
import b.h.g.j;
/* loaded from: classes.dex */
public class c {
    public final m a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f429b;

    public c(m mVar, Handler handler) {
        this.a = mVar;
        this.f429b = handler;
    }

    public void a(j.a aVar) {
        int i = aVar.f438b;
        if (!(i == 0)) {
            this.f429b.post(new b(this, this.a, i));
            return;
        }
        this.f429b.post(new a(this, this.a, aVar.a));
    }
}
