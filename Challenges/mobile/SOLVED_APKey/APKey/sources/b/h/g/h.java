package b.h.g;

import android.content.Context;
import b.h.g.j;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class h implements Callable<j.a> {
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f434b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f435c;
    public final /* synthetic */ int d;

    public h(String str, Context context, e eVar, int i) {
        this.a = str;
        this.f434b = context;
        this.f435c = eVar;
        this.d = i;
    }

    @Override // java.util.concurrent.Callable
    public j.a call() {
        return j.a(this.a, this.f434b, this.f435c, this.d);
    }
}
