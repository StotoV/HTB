package c.c.a.a.e;

import android.view.View;
import b.h.j.c0.d;
import b.h.j.q;
import com.google.android.material.behavior.SwipeDismissBehavior;
/* loaded from: classes.dex */
public class a implements d {
    public final /* synthetic */ SwipeDismissBehavior a;

    public a(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    @Override // b.h.j.c0.d
    public boolean a(View view, d.a aVar) {
        boolean z = false;
        if (this.a.B(view)) {
            boolean z2 = q.o(view) == 1;
            int i = this.a.f936c;
            if ((i == 0 && z2) || (i == 1 && !z2)) {
                z = true;
            }
            int width = view.getWidth();
            if (z) {
                width = -width;
            }
            q.w(view, width);
            view.setAlpha(0.0f);
            this.a.getClass();
            return true;
        }
        return false;
    }
}
