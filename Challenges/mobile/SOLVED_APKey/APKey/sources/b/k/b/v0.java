package b.k.b;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class v0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f607b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f608c;

    public v0(t0 t0Var, ArrayList arrayList, Map map) {
        this.f607b = arrayList;
        this.f608c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f607b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f607b.get(i);
            b.h.j.q.L(view, (String) this.f608c.get(b.h.j.q.s(view)));
        }
    }
}
