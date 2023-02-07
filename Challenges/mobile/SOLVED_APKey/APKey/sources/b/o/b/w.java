package b.o.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.a;
/* loaded from: classes.dex */
public class w implements a.InterfaceC0028a {
    public final /* synthetic */ RecyclerView a;

    public w(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(a.b bVar) {
        int i = bVar.a;
        if (i == 1) {
            RecyclerView recyclerView = this.a;
            recyclerView.m.o0(recyclerView, bVar.f648b, bVar.d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.a;
            recyclerView2.m.r0(recyclerView2, bVar.f648b, bVar.d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.a;
            recyclerView3.m.t0(recyclerView3, bVar.f648b, bVar.d, bVar.f649c);
        } else if (i != 8) {
        } else {
            RecyclerView recyclerView4 = this.a;
            recyclerView4.m.q0(recyclerView4, bVar.f648b, bVar.d, 1);
        }
    }

    public RecyclerView.z b(int i) {
        RecyclerView recyclerView = this.a;
        int h = recyclerView.f.h();
        int i2 = 0;
        RecyclerView.z zVar = null;
        while (true) {
            if (i2 >= h) {
                break;
            }
            RecyclerView.z J = RecyclerView.J(recyclerView.f.g(i2));
            if (J != null && !J.l() && J.f112c == i) {
                if (!recyclerView.f.k(J.a)) {
                    zVar = J;
                    break;
                }
                zVar = J;
            }
            i2++;
        }
        if (zVar != null && !this.a.f.k(zVar.a)) {
            return zVar;
        }
        return null;
    }

    public void c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.a;
        int h = recyclerView.f.h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < h; i6++) {
            View g = recyclerView.f.g(i6);
            RecyclerView.z J = RecyclerView.J(g);
            if (J != null && !J.t() && (i4 = J.f112c) >= i && i4 < i5) {
                J.b(2);
                J.a(obj);
                ((RecyclerView.m) g.getLayoutParams()).f97c = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f86c;
        int size = rVar.f102c.size();
        while (true) {
            size--;
            if (size < 0) {
                this.a.j0 = true;
                return;
            }
            RecyclerView.z zVar = rVar.f102c.get(size);
            if (zVar != null && (i3 = zVar.f112c) >= i && i3 < i5) {
                zVar.b(2);
                rVar.g(size);
            }
        }
    }

    public void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        int h = recyclerView.f.h();
        for (int i3 = 0; i3 < h; i3++) {
            RecyclerView.z J = RecyclerView.J(recyclerView.f.g(i3));
            if (J != null && !J.t() && J.f112c >= i) {
                J.p(i2, false);
                recyclerView.f0.f = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f86c;
        int size = rVar.f102c.size();
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.z zVar = rVar.f102c.get(i4);
            if (zVar != null && zVar.f112c >= i) {
                zVar.p(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.a.i0 = true;
    }

    public void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.a;
        int h = recyclerView.f.h();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < h; i11++) {
            RecyclerView.z J = RecyclerView.J(recyclerView.f.g(i11));
            if (J != null && (i9 = J.f112c) >= i4 && i9 <= i3) {
                if (i9 == i) {
                    J.p(i2 - i, false);
                } else {
                    J.p(i5, false);
                }
                recyclerView.f0.f = true;
            }
        }
        RecyclerView.r rVar = recyclerView.f86c;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = rVar.f102c.size();
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.z zVar = rVar.f102c.get(i12);
            if (zVar != null && (i8 = zVar.f112c) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    zVar.p(i2 - i, false);
                } else {
                    zVar.p(i10, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.a.i0 = true;
    }
}
