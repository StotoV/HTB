package b.h.g;

import b.h.d.d;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f427b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f428c;

    public b(c cVar, m mVar, int i) {
        this.f427b = mVar;
        this.f428c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.f427b;
        int i = this.f428c;
        b.h.c.b.g gVar = ((d.a) mVar).a;
        if (gVar != null) {
            gVar.d(i);
        }
    }
}
