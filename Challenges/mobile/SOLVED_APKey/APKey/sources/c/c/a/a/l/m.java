package c.c.a.a.l;

import android.view.View;
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f817b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f818c;

    public m(g gVar, v vVar) {
        this.f818c = gVar;
        this.f817b = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int m1 = this.f818c.u0().m1() - 1;
        if (m1 >= 0) {
            this.f818c.w0(this.f817b.e(m1));
        }
    }
}
