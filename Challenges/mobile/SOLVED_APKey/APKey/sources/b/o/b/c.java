package b.o.b;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f660c;

    public c(k kVar, ArrayList arrayList) {
        this.f660c = kVar;
        this.f659b = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f659b.iterator();
        while (it.hasNext()) {
            k.b bVar = (k.b) it.next();
            k kVar = this.f660c;
            RecyclerView.z zVar = bVar.a;
            int i = bVar.f677b;
            int i2 = bVar.f678c;
            int i3 = bVar.d;
            int i4 = bVar.e;
            kVar.getClass();
            View view = zVar.a;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (i5 != 0) {
                view.animate().translationX(0.0f);
            }
            if (i6 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator animate = view.animate();
            kVar.p.add(zVar);
            animate.setDuration(kVar.e).setListener(new h(kVar, zVar, i5, view, i6, animate)).start();
        }
        this.f659b.clear();
        this.f660c.m.remove(this.f659b);
    }
}
