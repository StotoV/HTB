package b.b.h;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public class p0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final b.b.g.e.a f255b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q0 f256c;

    public p0(q0 q0Var) {
        this.f256c = q0Var;
        this.f255b = new b.b.g.e.a(q0Var.a.getContext(), 0, 16908332, 0, q0Var.h);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q0 q0Var = this.f256c;
        Window.Callback callback = q0Var.k;
        if (callback == null || !q0Var.l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f255b);
    }
}
