package b.k.b;

import b.k.b.y0;
/* loaded from: classes.dex */
public class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ y0.d f552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ y0.d f553c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ b.e.a e;

    public h(c cVar, y0.d dVar, y0.d dVar2, boolean z, b.e.a aVar) {
        this.f552b = dVar;
        this.f553c = dVar2;
        this.d = z;
        this.e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.c(this.f552b.f622c, this.f553c.f622c, this.d, this.e, false);
    }
}
