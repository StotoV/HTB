package b.o.b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f663b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f664c;

    public e(k kVar, ArrayList arrayList) {
        this.f664c = kVar;
        this.f663b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f663b.iterator();
        while (it.hasNext()) {
            RecyclerView.z zVar = (RecyclerView.z) it.next();
            k kVar = this.f664c;
            kVar.getClass();
            View view = zVar.a;
            ViewPropertyAnimator animate = view.animate();
            kVar.o.add(zVar);
            animate.alpha(1.0f).setDuration(kVar.f90c).setListener(new g(kVar, zVar, view, animate)).start();
        }
        this.f663b.clear();
        this.f664c.l.remove(this.f663b);
    }
}
