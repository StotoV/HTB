package c.c.a.a.l;

import android.view.View;
/* loaded from: classes.dex */
public class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f821b;

    public p(o oVar) {
        this.f821b = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar = this.f821b;
        oVar.z0.setEnabled(oVar.o0.b());
        this.f821b.x0.toggle();
        o oVar2 = this.f821b;
        oVar2.B0(oVar2.x0);
        this.f821b.z0();
    }
}
