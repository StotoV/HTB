package c.c.a.a.l;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
/* loaded from: classes.dex */
public class h extends RecyclerView.k {
    public final Calendar a = a0.e();

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f810b = a0.e();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f811c;

    public h(g gVar) {
        this.f811c = gVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.k
    public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.w wVar) {
        if (!(recyclerView.getAdapter() instanceof c0) || !(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return;
        }
        c0 c0Var = (c0) recyclerView.getAdapter();
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        for (b.h.i.b<Long, Long> bVar : this.f811c.W.g()) {
            bVar.getClass();
        }
    }
}
