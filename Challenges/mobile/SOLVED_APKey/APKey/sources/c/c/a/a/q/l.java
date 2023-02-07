package c.c.a.a.q;

import android.view.View;
import b.h.j.b0;
/* loaded from: classes.dex */
public final class l implements b.h.j.l {
    public final /* synthetic */ n a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f858b;

    public l(n nVar, o oVar) {
        this.a = nVar;
        this.f858b = oVar;
    }

    @Override // b.h.j.l
    public b0 a(View view, b0 b0Var) {
        n nVar = this.a;
        int i = this.f858b.a;
        c.c.a.a.g.b bVar = (c.c.a.a.g.b) nVar;
        bVar.a.j = b0Var.a.f().d;
        bVar.a.S(false);
        return b0Var;
    }
}
