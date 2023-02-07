package b.k.b;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public class p0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f584b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f585c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ b.e.a e;
    public final /* synthetic */ View f;
    public final /* synthetic */ t0 g;
    public final /* synthetic */ Rect h;

    public p0(m mVar, m mVar2, boolean z, b.e.a aVar, View view, t0 t0Var, Rect rect) {
        this.f584b = mVar;
        this.f585c = mVar2;
        this.d = z;
        this.e = aVar;
        this.f = view;
        this.g = t0Var;
        this.h = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        r0.c(this.f584b, this.f585c, this.d, this.e, false);
        View view = this.f;
        if (view != null) {
            this.g.j(view, this.h);
        }
    }
}
