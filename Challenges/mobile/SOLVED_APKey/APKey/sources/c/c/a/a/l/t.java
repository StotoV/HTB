package c.c.a.a.l;

import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t extends BaseAdapter {
    public static final int g = a0.e().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    public final s f824b;

    /* renamed from: c  reason: collision with root package name */
    public final d<?> f825c;
    public Collection<Long> d;
    public c e;
    public final a f;

    public t(s sVar, d<?> dVar, a aVar) {
        this.f824b = sVar;
        this.f825c = dVar;
        this.f = aVar;
        this.d = dVar.h();
    }

    public int a(int i) {
        return b() + (i - 1);
    }

    public int b() {
        return this.f824b.m();
    }

    @Override // android.widget.Adapter
    /* renamed from: c */
    public Long getItem(int i) {
        if (i < this.f824b.m() || i > d()) {
            return null;
        }
        s sVar = this.f824b;
        Calendar b2 = a0.b(sVar.f822b);
        b2.set(5, (i - sVar.m()) + 1);
        return Long.valueOf(b2.getTimeInMillis());
    }

    public int d() {
        return (this.f824b.m() + this.f824b.f) - 1;
    }

    public final void e(TextView textView, long j) {
        b bVar;
        if (textView == null) {
            return;
        }
        boolean z = false;
        if (this.f.d.i(j)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.f825c.h().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (a0.a(j) == a0.a(it.next().longValue())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                bVar = this.e.f800b;
            } else {
                int i = (a0.d().getTimeInMillis() > j ? 1 : (a0.d().getTimeInMillis() == j ? 0 : -1));
                c cVar = this.e;
                bVar = i == 0 ? cVar.f801c : cVar.a;
            }
        } else {
            textView.setEnabled(false);
            bVar = this.e.g;
        }
        bVar.b(textView);
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (s.l(j).equals(this.f824b)) {
            Calendar b2 = a0.b(this.f824b.f822b);
            b2.setTimeInMillis(j);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(b2.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return b() + this.f824b.f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f824b.e;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0116  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.l.t.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
