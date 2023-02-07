package b.h.g;

import android.content.Context;
import b.h.g.j;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class f implements Callable<j.a> {
    public final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f432b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e f433c;
    public final /* synthetic */ int d;

    public f(String str, Context context, e eVar, int i) {
        this.a = str;
        this.f432b = context;
        this.f433c = eVar;
        this.d = i;
    }

    @Override // java.util.concurrent.Callable
    public j.a call() {
        return j.a(this.a, this.f432b, this.f433c, this.d);
    }
}
