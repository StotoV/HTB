package b.o.b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f662c;

    public d(k kVar, ArrayList arrayList) {
        this.f662c = kVar;
        this.f661b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f661b.iterator();
        while (it.hasNext()) {
            k.a aVar = (k.a) it.next();
            k kVar = this.f662c;
            kVar.getClass();
            RecyclerView.z zVar = aVar.a;
            View view = null;
            View view2 = zVar == null ? null : zVar.a;
            RecyclerView.z zVar2 = aVar.f675b;
            if (zVar2 != null) {
                view = zVar2.a;
            }
            if (view2 != null) {
                ViewPropertyAnimator duration = view2.animate().setDuration(kVar.f);
                kVar.r.add(aVar.a);
                duration.translationX(aVar.e - aVar.f676c);
                duration.translationY(aVar.f - aVar.d);
                duration.alpha(0.0f).setListener(new i(kVar, aVar, duration, view2)).start();
            }
            if (view != null) {
                ViewPropertyAnimator animate = view.animate();
                kVar.r.add(aVar.f675b);
                animate.translationX(0.0f).translationY(0.0f).setDuration(kVar.f).alpha(1.0f).setListener(new j(kVar, aVar, animate, view)).start();
            }
        }
        this.f661b.clear();
        this.f662c.n.remove(this.f661b);
    }
}
