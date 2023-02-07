package c.c.a.a.l;

import android.view.View;
import c.c.a.a.l.g;
/* loaded from: classes.dex */
public class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f798b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f799c;

    public b0(c0 c0Var, int i) {
        this.f799c = c0Var;
        this.f798b = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s k = s.k(this.f798b, this.f799c.f802c.Y.f823c);
        a aVar = this.f799c.f802c.X;
        if (k.compareTo(aVar.f792b) < 0) {
            k = aVar.f792b;
        } else if (k.compareTo(aVar.f793c) > 0) {
            k = aVar.f793c;
        }
        this.f799c.f802c.w0(k);
        this.f799c.f802c.x0(g.e.DAY);
    }
}
