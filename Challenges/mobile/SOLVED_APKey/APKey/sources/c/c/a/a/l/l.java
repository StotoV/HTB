package c.c.a.a.l;

import android.view.View;
/* loaded from: classes.dex */
public class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f815b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f816c;

    public l(g gVar, v vVar) {
        this.f816c = gVar;
        this.f815b = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int k1 = this.f816c.u0().k1() + 1;
        if (k1 < this.f816c.c0.getAdapter().a()) {
            this.f816c.w0(this.f815b.e(k1));
        }
    }
}
