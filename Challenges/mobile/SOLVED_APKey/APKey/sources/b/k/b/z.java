package b.k.b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
/* loaded from: classes.dex */
public abstract class z<E> extends v {

    /* renamed from: b  reason: collision with root package name */
    public final Activity f627b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f628c;
    public final Handler d;
    public final c0 e;

    public z(p pVar) {
        Handler handler = new Handler();
        this.e = new d0();
        this.f627b = pVar;
        b.h.b.a.h(pVar, "context == null");
        this.f628c = pVar;
        b.h.b.a.h(handler, "handler == null");
        this.d = handler;
    }

    public abstract E i();

    public abstract LayoutInflater j();

    public abstract boolean k(m mVar);

    public abstract void l();
}
