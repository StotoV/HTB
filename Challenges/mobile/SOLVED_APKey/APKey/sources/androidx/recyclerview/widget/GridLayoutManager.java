package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.h.j.c0.b;
import b.o.b.m;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public boolean G;
    public int H;
    public int[] I;
    public View[] J;
    public final SparseIntArray K;
    public final SparseIntArray L;
    public c M;
    public final Rect N;

    /* loaded from: classes.dex */
    public static final class a extends c {
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.m {
        public int e;
        public int f;

        public b(int i, int i2) {
            super(i, i2);
            this.e = -1;
            this.f = 0;
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.e = -1;
            this.f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.e = -1;
            this.f = 0;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public final SparseIntArray a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        public final SparseIntArray f76b = new SparseIntArray();

        public int a(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i3++;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = 1;
                }
            }
            return i3 + 1 > i2 ? i4 + 1 : i4;
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(i2, z);
        this.G = false;
        this.H = -1;
        this.K = new SparseIntArray();
        this.L = new SparseIntArray();
        this.M = new a();
        this.N = new Rect();
        P1(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.G = false;
        this.H = -1;
        this.K = new SparseIntArray();
        this.L = new SparseIntArray();
        this.M = new a();
        this.N = new Rect();
        P1(RecyclerView.l.S(context, attributeSet, i, i2).f94b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int A(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.r == 1) {
            return this.H;
        }
        if (wVar.b() >= 1) {
            return K1(rVar, wVar, wVar.b() - 1) + 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D1(boolean z) {
        if (!z) {
            d(null);
            if (!this.x) {
                return;
            }
            this.x = false;
            K0();
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final void H1(int i) {
        int i2;
        int[] iArr = this.I;
        int i3 = this.H;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.I = iArr;
    }

    public final void I1() {
        View[] viewArr = this.J;
        if (viewArr == null || viewArr.length != this.H) {
            this.J = new View[this.H];
        }
    }

    public int J1(int i, int i2) {
        if (this.r != 1 || !u1()) {
            int[] iArr = this.I;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.I;
        int i3 = this.H;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int K1(RecyclerView.r rVar, RecyclerView.w wVar, int i) {
        if (!wVar.g) {
            return this.M.a(i, this.H);
        }
        int c2 = rVar.c(i);
        if (c2 != -1) {
            return this.M.a(c2, this.H);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int L0(int i, RecyclerView.r rVar, RecyclerView.w wVar) {
        Q1();
        I1();
        if (this.r == 1) {
            return 0;
        }
        return B1(i, rVar, wVar);
    }

    public final int L1(RecyclerView.r rVar, RecyclerView.w wVar, int i) {
        if (!wVar.g) {
            c cVar = this.M;
            int i2 = this.H;
            cVar.getClass();
            return i % i2;
        }
        int i3 = this.L.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        int c2 = rVar.c(i);
        if (c2 != -1) {
            c cVar2 = this.M;
            int i4 = this.H;
            cVar2.getClass();
            return c2 % i4;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int M1(RecyclerView.r rVar, RecyclerView.w wVar, int i) {
        if (!wVar.g) {
            this.M.getClass();
            return 1;
        }
        int i2 = this.K.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (rVar.c(i) != -1) {
            this.M.getClass();
            return 1;
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int N0(int i, RecyclerView.r rVar, RecyclerView.w wVar) {
        Q1();
        I1();
        if (this.r == 0) {
            return 0;
        }
        return B1(i, rVar, wVar);
    }

    public final void N1(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f96b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int J1 = J1(bVar.e, bVar.f);
        if (this.r == 1) {
            i3 = RecyclerView.l.z(J1, i, i5, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i2 = RecyclerView.l.z(this.t.l(), this.o, i4, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int z2 = RecyclerView.l.z(J1, i, i4, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int z3 = RecyclerView.l.z(this.t.l(), this.n, i5, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i2 = z2;
            i3 = z3;
        }
        O1(view, i3, i2, z);
    }

    public final void O1(View view, int i, int i2, boolean z) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        if (z ? V0(view, i, i2, mVar) : T0(view, i, i2, mVar)) {
            view.measure(i, i2);
        }
    }

    public void P1(int i) {
        if (i == this.H) {
            return;
        }
        this.G = true;
        if (i >= 1) {
            this.H = i;
            this.M.a.clear();
            K0();
            return;
        }
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void Q0(Rect rect, int i, int i2) {
        int h;
        int h2;
        if (this.I == null) {
            super.Q0(rect, i, i2);
        }
        int P = P() + O();
        int N = N() + Q();
        if (this.r == 1) {
            h2 = RecyclerView.l.h(i2, rect.height() + N, L());
            int[] iArr = this.I;
            h = RecyclerView.l.h(i, iArr[iArr.length - 1] + P, M());
        } else {
            h = RecyclerView.l.h(i, rect.width() + P, M());
            int[] iArr2 = this.I;
            h2 = RecyclerView.l.h(i2, iArr2[iArr2.length - 1] + N, L());
        }
        this.f92b.setMeasuredDimension(h, h2);
    }

    public final void Q1() {
        int N;
        int Q;
        if (this.r == 1) {
            N = this.p - P();
            Q = O();
        } else {
            N = this.q - N();
            Q = Q();
        }
        H1(N - Q);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int T(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.r == 0) {
            return this.H;
        }
        if (wVar.b() >= 1) {
            return K1(rVar, wVar, wVar.b() - 1) + 1;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public boolean Y0() {
        return this.B == null && !this.G;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void a1(RecyclerView.w wVar, LinearLayoutManager.c cVar, RecyclerView.l.c cVar2) {
        int i = this.H;
        for (int i2 = 0; i2 < this.H && cVar.b(wVar) && i > 0; i2++) {
            ((m.b) cVar2).a(cVar.d, Math.max(0, cVar.g));
            this.M.getClass();
            i--;
            cVar.d += cVar.e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.m mVar) {
        return mVar instanceof b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:
        if (r13 == (r2 > r15)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e6, code lost:
        if (r13 == (r2 > r8)) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f0  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View i0(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.r r25, androidx.recyclerview.widget.RecyclerView.w r26) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.i0(android.view.View, int, androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int l(RecyclerView.w wVar) {
        return c1(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int m(RecyclerView.w wVar) {
        return d1(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void m0(RecyclerView.r rVar, RecyclerView.w wVar, View view, b.h.j.c0.b bVar) {
        int i;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            l0(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        int K1 = K1(rVar, wVar, bVar2.a());
        if (this.r == 0) {
            i4 = bVar2.e;
            i = bVar2.f;
            i3 = 1;
            z = false;
            z2 = false;
            i2 = K1;
        } else {
            i = 1;
            i2 = bVar2.e;
            i3 = bVar2.f;
            z = false;
            z2 = false;
            i4 = K1;
        }
        bVar.j(b.c.a(i4, i, i2, i3, z, z2));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int o(RecyclerView.w wVar) {
        return c1(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void o0(RecyclerView recyclerView, int i, int i2) {
        this.M.a.clear();
        this.M.f76b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public int p(RecyclerView.w wVar) {
        return d1(wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void p0(RecyclerView recyclerView) {
        this.M.a.clear();
        this.M.f76b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View p1(RecyclerView.r rVar, RecyclerView.w wVar, int i, int i2, int i3) {
        f1();
        int k = this.t.k();
        int g = this.t.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View x = x(i);
            int R = R(x);
            if (R >= 0 && R < i3 && L1(rVar, wVar, R) == 0) {
                if (((RecyclerView.m) x.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = x;
                    }
                } else if (this.t.e(x) < g && this.t.b(x) >= k) {
                    return x;
                } else {
                    if (view == null) {
                        view = x;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void q0(RecyclerView recyclerView, int i, int i2, int i3) {
        this.M.a.clear();
        this.M.f76b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void r0(RecyclerView recyclerView, int i, int i2) {
        this.M.a.clear();
        this.M.f76b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void t0(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.M.a.clear();
        this.M.f76b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m u() {
        return this.r == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void u0(RecyclerView.r rVar, RecyclerView.w wVar) {
        if (wVar.g) {
            int y = y();
            for (int i = 0; i < y; i++) {
                b bVar = (b) x(i).getLayoutParams();
                int a2 = bVar.a();
                this.K.put(a2, bVar.f);
                this.L.put(a2, bVar.e);
            }
        }
        super.u0(rVar, wVar);
        this.K.clear();
        this.L.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m v(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void v0(RecyclerView.w wVar) {
        this.B = null;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.C.d();
        this.G = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r22.f79b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v1(androidx.recyclerview.widget.RecyclerView.r r19, androidx.recyclerview.widget.RecyclerView.w r20, androidx.recyclerview.widget.LinearLayoutManager.c r21, androidx.recyclerview.widget.LinearLayoutManager.b r22) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.v1(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void w1(RecyclerView.r rVar, RecyclerView.w wVar, LinearLayoutManager.a aVar, int i) {
        Q1();
        if (wVar.b() > 0 && !wVar.g) {
            boolean z = i == 1;
            int L1 = L1(rVar, wVar, aVar.f77b);
            if (z) {
                while (L1 > 0) {
                    int i2 = aVar.f77b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    aVar.f77b = i3;
                    L1 = L1(rVar, wVar, i3);
                }
            } else {
                int b2 = wVar.b() - 1;
                int i4 = aVar.f77b;
                while (i4 < b2) {
                    int i5 = i4 + 1;
                    int L12 = L1(rVar, wVar, i5);
                    if (L12 <= L1) {
                        break;
                    }
                    i4 = i5;
                    L1 = L12;
                }
                aVar.f77b = i4;
            }
        }
        I1();
    }
}
