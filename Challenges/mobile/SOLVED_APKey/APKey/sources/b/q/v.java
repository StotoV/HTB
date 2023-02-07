package b.q;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
/* loaded from: classes.dex */
public class v implements w {
    public final ViewGroupOverlay a;

    public v(ViewGroup viewGroup) {
        this.a = viewGroup.getOverlay();
    }

    @Override // b.q.w
    public void a(View view) {
        this.a.remove(view);
    }

    @Override // b.q.w
    public void b(View view) {
        this.a.add(view);
    }
}
