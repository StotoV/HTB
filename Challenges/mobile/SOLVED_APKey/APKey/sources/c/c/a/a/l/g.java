package c.c.a.a.l;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public final class g<S> extends x<S> {
    public static final /* synthetic */ int f0 = 0;
    public int V;
    public c.c.a.a.l.d<S> W;
    public c.c.a.a.l.a X;
    public s Y;
    public e Z;
    public c.c.a.a.l.c a0;
    public RecyclerView b0;
    public RecyclerView c0;
    public View d0;
    public View e0;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f806b;

        public a(int i) {
            this.f806b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.c0;
            int i = this.f806b;
            if (recyclerView.x) {
                return;
            }
            RecyclerView.l lVar = recyclerView.m;
            if (lVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                lVar.W0(recyclerView, recyclerView.f0, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.h.j.a {
        public b(g gVar) {
        }

        @Override // b.h.j.a
        public void d(View view, b.h.j.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.i(null);
        }
    }

    /* loaded from: classes.dex */
    public class c extends y {
        public final /* synthetic */ int G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.G = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void Z0(RecyclerView.w wVar, int[] iArr) {
            if (this.G == 0) {
                iArr[0] = g.this.c0.getWidth();
                iArr[1] = g.this.c0.getWidth();
                return;
            }
            iArr[0] = g.this.c0.getHeight();
            iArr[1] = g.this.c0.getHeight();
        }
    }

    /* loaded from: classes.dex */
    public class d implements f {
        public d() {
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        DAY,
        YEAR
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    @Override // b.k.b.m
    public void L(Bundle bundle) {
        super.L(bundle);
        if (bundle == null) {
            bundle = this.g;
        }
        this.V = bundle.getInt("THEME_RES_ID_KEY");
        this.W = (c.c.a.a.l.d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.X = (c.c.a.a.l.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.Y = (s) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0141, code lost:
        r13 = new b.o.b.u();
     */
    @Override // b.k.b.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View O(android.view.LayoutInflater r11, android.view.ViewGroup r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.l.g.O(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    @Override // b.k.b.m
    public void Z(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.V);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.W);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.X);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.Y);
    }

    @Override // c.c.a.a.l.x
    public boolean t0(w<S> wVar) {
        return this.U.add(wVar);
    }

    public LinearLayoutManager u0() {
        return (LinearLayoutManager) this.c0.getLayoutManager();
    }

    public final void v0(int i) {
        this.c0.post(new a(i));
    }

    public void w0(s sVar) {
        RecyclerView recyclerView;
        int i;
        v vVar = (v) this.c0.getAdapter();
        int p = vVar.d.f792b.p(sVar);
        int f2 = p - vVar.f(this.Y);
        boolean z = true;
        boolean z2 = Math.abs(f2) > 3;
        if (f2 <= 0) {
            z = false;
        }
        this.Y = sVar;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.c0;
                i = p + 3;
            }
            v0(p);
        }
        recyclerView = this.c0;
        i = p - 3;
        recyclerView.h0(i);
        v0(p);
    }

    public void x0(e eVar) {
        this.Z = eVar;
        if (eVar == e.YEAR) {
            this.b0.getLayoutManager().M0(((c0) this.b0.getAdapter()).e(this.Y.d));
            this.d0.setVisibility(0);
            this.e0.setVisibility(8);
        } else if (eVar != e.DAY) {
        } else {
            this.d0.setVisibility(8);
            this.e0.setVisibility(0);
            w0(this.Y);
        }
    }
}
