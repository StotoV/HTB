package b.k.b;

import b.k.b.c0;
import b.k.b.r0;
/* loaded from: classes.dex */
public class l0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0.a f573b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f574c;
    public final /* synthetic */ b.h.f.a d;

    public l0(r0.a aVar, m mVar, b.h.f.a aVar2) {
        this.f573b = aVar;
        this.f574c = mVar;
        this.d = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((c0.d) this.f573b).a(this.f574c, this.d);
    }
}
