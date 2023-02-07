package b.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.q.z;
/* loaded from: classes.dex */
public class u extends z implements w {
    public u(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    @Override // b.q.w
    public void a(View view) {
        z.a aVar = this.a;
        aVar.removeView(view);
        aVar.a();
    }

    @Override // b.q.w
    public void b(View view) {
        z.a aVar = this.a;
        if (!aVar.f) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != aVar.f735b && viewGroup.getParent() != null && b.h.j.q.t(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    aVar.f735b.getLocationOnScreen(iArr2);
                    b.h.j.q.w(view, iArr[0] - iArr2[0]);
                    b.h.j.q.x(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            aVar.addView(view);
            return;
        }
        throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
    }
}
