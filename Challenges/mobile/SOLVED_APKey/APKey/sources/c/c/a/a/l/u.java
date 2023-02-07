package c.c.a.a.l;

import android.view.View;
import android.widget.AdapterView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.a.l.g;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Iterator;
/* loaded from: classes.dex */
public class u implements AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f826b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v f827c;

    public u(v vVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f827c = vVar;
        this.f826b = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        t adapter2 = this.f826b.getAdapter2();
        if (i >= adapter2.b() && i <= adapter2.d()) {
            g.f fVar = this.f827c.f;
            long longValue = this.f826b.getAdapter2().getItem(i).longValue();
            g.d dVar = (g.d) fVar;
            if (!g.this.X.d.i(longValue)) {
                return;
            }
            g.this.W.c(longValue);
            Iterator it = g.this.U.iterator();
            while (it.hasNext()) {
                ((w) it.next()).a(g.this.W.a());
            }
            g.this.c0.getAdapter().a.b();
            RecyclerView recyclerView = g.this.b0;
            if (recyclerView == null) {
                return;
            }
            recyclerView.getAdapter().a.b();
        }
    }
}
