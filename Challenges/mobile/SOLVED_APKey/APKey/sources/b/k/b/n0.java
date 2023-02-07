package b.k.b;

import b.k.b.c0;
import b.k.b.r0;
/* loaded from: classes.dex */
public class n0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0.a f580b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f581c;
    public final /* synthetic */ b.h.f.a d;

    public n0(r0.a aVar, m mVar, b.h.f.a aVar2) {
        this.f580b = aVar;
        this.f581c = mVar;
        this.d = aVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((c0.d) this.f580b).a(this.f581c, this.d);
    }
}
