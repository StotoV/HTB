package b.o.b;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.h.j.c0.b;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class x extends b.h.j.a {
    public final RecyclerView d;
    public final a e;

    /* loaded from: classes.dex */
    public static class a extends b.h.j.a {
        public final x d;
        public Map<View, b.h.j.a> e = new WeakHashMap();

        public a(x xVar) {
            this.d = xVar;
        }

        @Override // b.h.j.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            b.h.j.a aVar = this.e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // b.h.j.a
        public b.h.j.c0.c b(View view) {
            b.h.j.a aVar = this.e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // b.h.j.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            b.h.j.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.h.j.a
        public void d(View view, b.h.j.c0.b bVar) {
            if (!this.d.j() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().l0(view, bVar);
                b.h.j.a aVar = this.e.get(view);
                if (aVar != null) {
                    aVar.d(view, bVar);
                    return;
                }
            }
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        }

        @Override // b.h.j.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            b.h.j.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.h.j.a
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            b.h.j.a aVar = this.e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // b.h.j.a
        public boolean g(View view, int i, Bundle bundle) {
            if (!this.d.j() && this.d.d.getLayoutManager() != null) {
                b.h.j.a aVar = this.e.get(view);
                if (aVar != null) {
                    if (aVar.g(view, i, bundle)) {
                        return true;
                    }
                } else if (super.g(view, i, bundle)) {
                    return true;
                }
                RecyclerView.l layoutManager = this.d.d.getLayoutManager();
                RecyclerView.r rVar = layoutManager.f92b.f86c;
                return layoutManager.D0();
            }
            return super.g(view, i, bundle);
        }

        @Override // b.h.j.a
        public void h(View view, int i) {
            b.h.j.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.h(view, i);
            } else {
                this.a.sendAccessibilityEvent(view, i);
            }
        }

        @Override // b.h.j.a
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            b.h.j.a aVar = this.e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public x(RecyclerView recyclerView) {
        this.d = recyclerView;
        a aVar = this.e;
        this.e = aVar == null ? new a(this) : aVar;
    }

    @Override // b.h.j.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || j()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() == null) {
            return;
        }
        recyclerView.getLayoutManager().j0(accessibilityEvent);
    }

    @Override // b.h.j.a
    public void d(View view, b.h.j.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        if (j() || this.d.getLayoutManager() == null) {
            return;
        }
        RecyclerView.l layoutManager = this.d.getLayoutManager();
        RecyclerView recyclerView = layoutManager.f92b;
        RecyclerView.r rVar = recyclerView.f86c;
        RecyclerView.w wVar = recyclerView.f0;
        if (recyclerView.canScrollVertically(-1) || layoutManager.f92b.canScrollHorizontally(-1)) {
            bVar.a.addAction(8192);
            bVar.a.setScrollable(true);
        }
        if (layoutManager.f92b.canScrollVertically(1) || layoutManager.f92b.canScrollHorizontally(1)) {
            bVar.a.addAction(4096);
            bVar.a.setScrollable(true);
        }
        bVar.i(b.C0019b.a(layoutManager.T(rVar, wVar), layoutManager.A(rVar, wVar), layoutManager.X(), layoutManager.U()));
    }

    @Override // b.h.j.a
    public boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        if (j() || this.d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.l layoutManager = this.d.getLayoutManager();
        RecyclerView.r rVar = layoutManager.f92b.f86c;
        return layoutManager.C0(i);
    }

    public boolean j() {
        return this.d.L();
    }
}
