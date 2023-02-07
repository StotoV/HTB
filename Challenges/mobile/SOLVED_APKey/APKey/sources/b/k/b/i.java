package b.k.b;

import android.graphics.Rect;
import android.view.View;
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f557c;
    public final /* synthetic */ Rect d;

    public i(c cVar, t0 t0Var, View view, Rect rect) {
        this.f556b = t0Var;
        this.f557c = view;
        this.d = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f556b.j(this.f557c, this.d);
    }
}
