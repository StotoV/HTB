package c.c.a.a.l;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.c.a.a.l.g;
import com.example.apkey.R;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class v extends RecyclerView.d<a> {

    /* renamed from: c  reason: collision with root package name */
    public final Context f828c;
    public final c.c.a.a.l.a d;
    public final d<?> e;
    public final g.f f;
    public final int g;

    /* loaded from: classes.dex */
    public static class a extends RecyclerView.z {
        public final TextView t;
        public final MaterialCalendarGridView u;

        public a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.t = textView;
            AtomicInteger atomicInteger = b.h.j.q.a;
            b.h.j.u uVar = new b.h.j.u(R.id.tag_accessibility_heading, Boolean.class, 28);
            Boolean bool = Boolean.TRUE;
            int i = Build.VERSION.SDK_INT;
            boolean z2 = true;
            if (i >= 28) {
                uVar.d(textView, bool);
            } else {
                if ((i < 19 ? false : z2) && uVar.e(uVar.c(textView), bool)) {
                    b.h.j.a h = b.h.j.q.h(textView);
                    b.h.j.q.F(textView, h == null ? new b.h.j.a() : h);
                    textView.setTag(uVar.a, bool);
                    b.h.j.q.v(textView, uVar.d);
                }
            }
            this.u = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    public v(Context context, d<?> dVar, c.c.a.a.l.a aVar, g.f fVar) {
        s sVar = aVar.f792b;
        s sVar2 = aVar.f793c;
        s sVar3 = aVar.e;
        if (sVar.compareTo(sVar3) <= 0) {
            if (sVar3.compareTo(sVar2) <= 0) {
                int i = t.g;
                int i2 = g.f0;
                int dimensionPixelSize = i * context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
                int dimensionPixelSize2 = o.x0(context) ? context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0;
                this.f828c = context;
                this.g = dimensionPixelSize + dimensionPixelSize2;
                this.d = aVar;
                this.e = dVar;
                this.f = fVar;
                if (this.a.a()) {
                    throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
                }
                this.f88b = true;
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public int a() {
        return this.d.g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public long b(int i) {
        return this.d.f792b.o(i).f822b.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public void c(a aVar, int i) {
        a aVar2 = aVar;
        s o = this.d.f792b.o(i);
        aVar2.t.setText(o.n(aVar2.a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar2.u.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && o.equals(materialCalendarGridView.getAdapter2().f824b)) {
            materialCalendarGridView.invalidate();
            t adapter2 = materialCalendarGridView.getAdapter2();
            for (Long l : adapter2.d) {
                adapter2.f(materialCalendarGridView, l.longValue());
            }
            d<?> dVar = adapter2.f825c;
            if (dVar != null) {
                for (Long l2 : dVar.h()) {
                    adapter2.f(materialCalendarGridView, l2.longValue());
                }
                adapter2.d = adapter2.f825c.h();
            }
        } else {
            t tVar = new t(o, this.e, this.d);
            materialCalendarGridView.setNumColumns(o.e);
            materialCalendarGridView.setAdapter((ListAdapter) tVar);
        }
        materialCalendarGridView.setOnItemClickListener(new u(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.d
    public a d(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (o.x0(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.m(-1, this.g));
            return new a(linearLayout, true);
        }
        return new a(linearLayout, false);
    }

    public s e(int i) {
        return this.d.f792b.o(i);
    }

    public int f(s sVar) {
        return this.d.f792b.p(sVar);
    }
}
