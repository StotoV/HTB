package c.c.a.a.l;

import android.view.View;
import c.c.a.a.l.g;
/* loaded from: classes.dex */
public class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f814b;

    public k(g gVar) {
        this.f814b = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        g gVar = this.f814b;
        g.e eVar = g.e.DAY;
        g.e eVar2 = gVar.Z;
        g.e eVar3 = g.e.YEAR;
        if (eVar2 == eVar3) {
            gVar.x0(eVar);
        } else if (eVar2 != eVar) {
        } else {
            gVar.x0(eVar3);
        }
    }
}
