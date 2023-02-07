package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.m;
import b.o.b.o;
import b.o.b.s;
import java.util.List;
/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.l implements RecyclerView.v.b {
    public int A;
    public d B;
    public final a C;
    public final b D;
    public int E;
    public int[] F;
    public int r;
    public c s;
    public s t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes.dex */
    public static class a {
        public s a;

        /* renamed from: b  reason: collision with root package name */
        public int f77b;

        /* renamed from: c  reason: collision with root package name */
        public int f78c;
        public boolean d;
        public boolean e;

        public a() {
            d();
        }

        public void a() {
            this.f78c = this.d ? this.a.g() : this.a.k();
        }

        public void b(View view, int i) {
            if (this.d) {
                this.f78c = this.a.m() + this.a.b(view);
            } else {
                this.f78c = this.a.e(view);
            }
            this.f77b = i;
        }

        public void c(View view, int i) {
            int min;
            int m = this.a.m();
            if (m >= 0) {
                b(view, i);
                return;
            }
            this.f77b = i;
            if (this.d) {
                int g = (this.a.g() - m) - this.a.b(view);
                this.f78c = this.a.g() - g;
                if (g <= 0) {
                    return;
                }
                int c2 = this.f78c - this.a.c(view);
                int k = this.a.k();
                int min2 = c2 - (Math.min(this.a.e(view) - k, 0) + k);
                if (min2 >= 0) {
                    return;
                }
                min = Math.min(g, -min2) + this.f78c;
            } else {
                int e = this.a.e(view);
                int k2 = e - this.a.k();
                this.f78c = e;
                if (k2 <= 0) {
                    return;
                }
                int g2 = (this.a.g() - Math.min(0, (this.a.g() - m) - this.a.b(view))) - (this.a.c(view) + e);
                if (g2 >= 0) {
                    return;
                }
                min = this.f78c - Math.min(k2, -g2);
            }
            this.f78c = min;
        }

        public void d() {
            this.f77b = -1;
            this.f78c = Integer.MIN_VALUE;
            this.d = false;
            this.e = false;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("AnchorInfo{mPosition=");
            g.append(this.f77b);
            g.append(", mCoordinate=");
            g.append(this.f78c);
            g.append(", mLayoutFromEnd=");
            g.append(this.d);
            g.append(", mValid=");
            g.append(this.e);
            g.append('}');
            return g.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f79b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f80c;
        public boolean d;
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b  reason: collision with root package name */
        public int f81b;

        /* renamed from: c  reason: collision with root package name */
        public int f82c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int j;
        public boolean l;
        public boolean a = true;
        public int h = 0;
        public int i = 0;
        public List<RecyclerView.z> k = null;

        public void a(View view) {
            int a;
            int size = this.k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.k.get(i2).a;
                RecyclerView.m mVar = (RecyclerView.m) view3.getLayoutParams();
                if (view3 != view && !mVar.c() && (a = (mVar.a() - this.d) * this.e) >= 0 && a < i) {
                    view2 = view3;
                    if (a == 0) {
                        break;
                    }
                    i = a;
                }
            }
            this.d = view2 == null ? -1 : ((RecyclerView.m) view2.getLayoutParams()).a();
        }

        public boolean b(RecyclerView.w wVar) {
            int i = this.d;
            return i >= 0 && i < wVar.b();
        }

        public View c(RecyclerView.r rVar) {
            List<RecyclerView.z> list = this.k;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    View view = this.k.get(i).a;
                    RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
                    if (!mVar.c() && this.d == mVar.a()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View view2 = rVar.k(this.d, false, Long.MAX_VALUE).a;
            this.d += this.e;
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f83b;

        /* renamed from: c  reason: collision with root package name */
        public int f84c;
        public boolean d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<d> {
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        public d(Parcel parcel) {
            this.f83b = parcel.readInt();
            this.f84c = parcel.readInt();
            this.d = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f83b = dVar.f83b;
            this.f84c = dVar.f84c;
            this.d = dVar.d;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean j() {
            return this.f83b >= 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f83b);
            parcel.writeInt(this.f84c);
            parcel.writeInt(this.d ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i, boolean z) {
        this.r = 1;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.B = null;
        this.C = new a();
        this.D = new b();
        this.E = 2;
        this.F = new int[2];
        C1(i);
        d(null);
        if (z == this.v) {
            return;
        }
        this.v = z;
        K0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public Parcelable A0() {
        d dVar = this.B;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (y() > 0) {
            f1();
            boolean z = this.u ^ this.w;
            dVar2.d = z;
            if (z) {
                View s1 = s1();
                dVar2.f84c = this.t.g() - this.t.b(s1);
                dVar2.f83b = R(s1);
            } else {
                View t1 = t1();
                dVar2.f83b = R(t1);
                dVar2.f84c = this.t.e(t1) - this.t.k();
            }
        } else {
            dVar2.f83b = -1;
        }
        return dVar2;
    }

    public final void A1() {
        this.w = (this.r == 1 || !u1()) ? this.v : !this.v;
    }

    public int B1(int i, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        f1();
        this.s.a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        E1(i2, abs, true, wVar);
        c cVar = this.s;
        int g1 = g1(rVar, cVar, wVar, false) + cVar.g;
        if (g1 < 0) {
            return 0;
        }
        if (abs > g1) {
            i = i2 * g1;
        }
        this.t.p(-i);
        this.s.j = i;
        return i;
    }

    public void C1(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        d(null);
        if (i == this.r && this.t != null) {
            return;
        }
        s a2 = s.a(this, i);
        this.t = a2;
        this.C.a = a2;
        this.r = i;
        K0();
    }

    public void D1(boolean z) {
        d(null);
        if (this.x == z) {
            return;
        }
        this.x = z;
        K0();
    }

    public final void E1(int i, int i2, boolean z, RecyclerView.w wVar) {
        int k;
        this.s.l = z1();
        this.s.f = i;
        int[] iArr = this.F;
        boolean z2 = false;
        iArr[0] = 0;
        int i3 = 1;
        iArr[1] = 0;
        Z0(wVar, iArr);
        int max = Math.max(0, this.F[0]);
        int max2 = Math.max(0, this.F[1]);
        if (i == 1) {
            z2 = true;
        }
        c cVar = this.s;
        int i4 = z2 ? max2 : max;
        cVar.h = i4;
        if (!z2) {
            max = max2;
        }
        cVar.i = max;
        if (z2) {
            cVar.h = this.t.h() + i4;
            View s1 = s1();
            c cVar2 = this.s;
            if (this.w) {
                i3 = -1;
            }
            cVar2.e = i3;
            int R = R(s1);
            c cVar3 = this.s;
            cVar2.d = R + cVar3.e;
            cVar3.f81b = this.t.b(s1);
            k = this.t.b(s1) - this.t.g();
        } else {
            View t1 = t1();
            c cVar4 = this.s;
            cVar4.h = this.t.k() + cVar4.h;
            c cVar5 = this.s;
            if (!this.w) {
                i3 = -1;
            }
            cVar5.e = i3;
            int R2 = R(t1);
            c cVar6 = this.s;
            cVar5.d = R2 + cVar6.e;
            cVar6.f81b = this.t.e(t1);
            k = (-this.t.e(t1)) + this.t.k();
        }
        c cVar7 = this.s;
        cVar7.f82c = i2;
        if (z) {
            cVar7.f82c = i2 - k;
        }
        cVar7.g = k;
    }

    public final void F1(int i, int i2) {
        this.s.f82c = this.t.g() - i2;
        c cVar = this.s;
        cVar.e = this.w ? -1 : 1;
        cVar.d = i;
        cVar.f = 1;
        cVar.f81b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    public final void G1(int i, int i2) {
        this.s.f82c = i2 - this.t.k();
        c cVar = this.s;
        cVar.d = i;
        cVar.e = this.w ? 1 : -1;
        cVar.f = -1;
        cVar.f81b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int L0(int i, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.r == 1) {
            return 0;
        }
        return B1(i, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void M0(int i) {
        this.z = i;
        this.A = Integer.MIN_VALUE;
        d dVar = this.B;
        if (dVar != null) {
            dVar.f83b = -1;
        }
        K0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int N0(int i, RecyclerView.r rVar, RecyclerView.w wVar) {
        if (this.r == 0) {
            return 0;
        }
        return B1(i, rVar, wVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean U0() {
        boolean z;
        if (this.o != 1073741824 && this.n != 1073741824) {
            int y = y();
            int i = 0;
            while (true) {
                if (i >= y) {
                    z = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = x(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean W() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void W0(RecyclerView recyclerView, RecyclerView.w wVar, int i) {
        o oVar = new o(recyclerView.getContext());
        oVar.a = i;
        X0(oVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean Y0() {
        return this.B == null && this.u == this.x;
    }

    public void Z0(RecyclerView.w wVar, int[] iArr) {
        int i;
        int l = wVar.a != -1 ? this.t.l() : 0;
        if (this.s.f == -1) {
            i = 0;
        } else {
            i = l;
            l = 0;
        }
        iArr[0] = l;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.v.b
    public PointF a(int i) {
        if (y() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < R(x(0))) {
            z = true;
        }
        if (z != this.w) {
            i2 = -1;
        }
        return this.r == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public void a1(RecyclerView.w wVar, c cVar, RecyclerView.l.c cVar2) {
        int i = cVar.d;
        if (i < 0 || i >= wVar.b()) {
            return;
        }
        ((m.b) cVar2).a(i, Math.max(0, cVar.g));
    }

    public final int b1(RecyclerView.w wVar) {
        if (y() == 0) {
            return 0;
        }
        f1();
        return b.h.b.a.k(wVar, this.t, j1(!this.y, true), i1(!this.y, true), this, this.y);
    }

    public final int c1(RecyclerView.w wVar) {
        if (y() == 0) {
            return 0;
        }
        f1();
        return b.h.b.a.l(wVar, this.t, j1(!this.y, true), i1(!this.y, true), this, this.y, this.w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.B != null || (recyclerView = this.f92b) == null) {
            return;
        }
        recyclerView.h(str);
    }

    public final int d1(RecyclerView.w wVar) {
        if (y() == 0) {
            return 0;
        }
        f1();
        return b.h.b.a.m(wVar, this.t, j1(!this.y, true), i1(!this.y, true), this, this.y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean e() {
        return this.r == 0;
    }

    public int e1(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.r == 1) ? 1 : Integer.MIN_VALUE : this.r == 0 ? 1 : Integer.MIN_VALUE : this.r == 1 ? -1 : Integer.MIN_VALUE : this.r == 0 ? -1 : Integer.MIN_VALUE : (this.r != 1 && u1()) ? -1 : 1 : (this.r != 1 && u1()) ? 1 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean f() {
        return this.r == 1;
    }

    public void f1() {
        if (this.s == null) {
            this.s = new c();
        }
    }

    public int g1(RecyclerView.r rVar, c cVar, RecyclerView.w wVar, boolean z) {
        int i = cVar.f82c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            x1(rVar, cVar);
        }
        int i3 = cVar.f82c + cVar.h;
        b bVar = this.D;
        while (true) {
            if ((!cVar.l && i3 <= 0) || !cVar.b(wVar)) {
                break;
            }
            bVar.a = 0;
            bVar.f79b = false;
            bVar.f80c = false;
            bVar.d = false;
            v1(rVar, wVar, cVar, bVar);
            if (!bVar.f79b) {
                int i4 = cVar.f81b;
                int i5 = bVar.a;
                cVar.f81b = (cVar.f * i5) + i4;
                if (!bVar.f80c || cVar.k != null || !wVar.g) {
                    cVar.f82c -= i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + i5;
                    cVar.g = i7;
                    int i8 = cVar.f82c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    x1(rVar, cVar);
                }
                if (z && bVar.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f82c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void h0(RecyclerView recyclerView, RecyclerView.r rVar) {
        g0();
    }

    public final View h1(RecyclerView.r rVar, RecyclerView.w wVar) {
        return p1(rVar, wVar, 0, y(), wVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void i(int i, int i2, RecyclerView.w wVar, RecyclerView.l.c cVar) {
        if (this.r != 0) {
            i = i2;
        }
        if (y() == 0 || i == 0) {
            return;
        }
        f1();
        E1(i > 0 ? 1 : -1, Math.abs(i), true, wVar);
        a1(wVar, this.s, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public View i0(View view, int i, RecyclerView.r rVar, RecyclerView.w wVar) {
        int e1;
        View n1;
        A1();
        if (y() == 0 || (e1 = e1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        f1();
        E1(e1, (int) (this.t.l() * 0.33333334f), false, wVar);
        c cVar = this.s;
        cVar.g = Integer.MIN_VALUE;
        cVar.a = false;
        g1(rVar, cVar, wVar, true);
        if (e1 == -1) {
            if (this.w) {
                n1 = n1(y() - 1, -1);
            } else {
                n1 = n1(0, y());
            }
        } else if (this.w) {
            n1 = n1(0, y());
        } else {
            n1 = n1(y() - 1, -1);
        }
        View t1 = e1 == -1 ? t1() : s1();
        if (!t1.hasFocusable()) {
            return n1;
        }
        if (n1 != null) {
            return t1;
        }
        return null;
    }

    public View i1(boolean z, boolean z2) {
        int y;
        int i;
        if (this.w) {
            y = 0;
            i = y();
        } else {
            y = y() - 1;
            i = -1;
        }
        return o1(y, i, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(int i, RecyclerView.l.c cVar) {
        boolean z;
        int i2;
        d dVar = this.B;
        int i3 = -1;
        if (dVar == null || !dVar.j()) {
            A1();
            z = this.w;
            i2 = this.z;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.B;
            z = dVar2.d;
            i2 = dVar2.f83b;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.E && i2 >= 0 && i2 < i; i4++) {
            ((m.b) cVar).a(i2, 0);
            i2 += i3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.r rVar = this.f92b.f86c;
        k0(accessibilityEvent);
        if (y() > 0) {
            accessibilityEvent.setFromIndex(k1());
            accessibilityEvent.setToIndex(m1());
        }
    }

    public View j1(boolean z, boolean z2) {
        int i;
        int y;
        if (this.w) {
            i = y() - 1;
            y = -1;
        } else {
            i = 0;
            y = y();
        }
        return o1(i, y, z, z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int k(RecyclerView.w wVar) {
        return b1(wVar);
    }

    public int k1() {
        View o1 = o1(0, y(), false, true);
        if (o1 == null) {
            return -1;
        }
        return R(o1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int l(RecyclerView.w wVar) {
        return c1(wVar);
    }

    public final View l1(RecyclerView.r rVar, RecyclerView.w wVar) {
        return p1(rVar, wVar, y() - 1, -1, wVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int m(RecyclerView.w wVar) {
        return d1(wVar);
    }

    public int m1() {
        View o1 = o1(y() - 1, -1, false, true);
        if (o1 == null) {
            return -1;
        }
        return R(o1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int n(RecyclerView.w wVar) {
        return b1(wVar);
    }

    public View n1(int i, int i2) {
        int i3;
        int i4;
        f1();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return x(i);
        }
        if (this.t.e(x(i)) < this.t.k()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return (this.r == 0 ? this.e : this.f).a(i, i2, i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int o(RecyclerView.w wVar) {
        return c1(wVar);
    }

    public View o1(int i, int i2, boolean z, boolean z2) {
        f1();
        int i3 = 320;
        int i4 = z ? 24579 : 320;
        if (!z2) {
            i3 = 0;
        }
        return (this.r == 0 ? this.e : this.f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public int p(RecyclerView.w wVar) {
        return d1(wVar);
    }

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
            if (R >= 0 && R < i3) {
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

    public final int q1(int i, RecyclerView.r rVar, RecyclerView.w wVar, boolean z) {
        int g;
        int g2 = this.t.g() - i;
        if (g2 > 0) {
            int i2 = -B1(-g2, rVar, wVar);
            int i3 = i + i2;
            if (!z || (g = this.t.g() - i3) <= 0) {
                return i2;
            }
            this.t.p(g);
            return g + i2;
        }
        return 0;
    }

    public final int r1(int i, RecyclerView.r rVar, RecyclerView.w wVar, boolean z) {
        int k;
        int k2 = i - this.t.k();
        if (k2 > 0) {
            int i2 = -B1(k2, rVar, wVar);
            int i3 = i + i2;
            if (!z || (k = i3 - this.t.k()) <= 0) {
                return i2;
            }
            this.t.p(-k);
            return i2 - k;
        }
        return 0;
    }

    public final View s1() {
        return x(this.w ? 0 : y() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public View t(int i) {
        int y = y();
        if (y == 0) {
            return null;
        }
        int R = i - R(x(0));
        if (R >= 0 && R < y) {
            View x = x(R);
            if (R(x) == i) {
                return x;
            }
        }
        return super.t(i);
    }

    public final View t1() {
        return x(this.w ? y() - 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public RecyclerView.m u() {
        return new RecyclerView.m(-2, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0175  */
    @Override // androidx.recyclerview.widget.RecyclerView.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u0(androidx.recyclerview.widget.RecyclerView.r r17, androidx.recyclerview.widget.RecyclerView.w r18) {
        /*
            Method dump skipped, instructions count: 1072
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.u0(androidx.recyclerview.widget.RecyclerView$r, androidx.recyclerview.widget.RecyclerView$w):void");
    }

    public boolean u1() {
        return K() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void v0(RecyclerView.w wVar) {
        this.B = null;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.C.d();
    }

    public void v1(RecyclerView.r rVar, RecyclerView.w wVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int d2;
        View c2 = cVar.c(rVar);
        if (c2 == null) {
            bVar.f79b = true;
            return;
        }
        RecyclerView.m mVar = (RecyclerView.m) c2.getLayoutParams();
        if (cVar.k == null) {
            if (this.w == (cVar.f == -1)) {
                c(c2, -1, false);
            } else {
                c(c2, 0, false);
            }
        } else {
            if (this.w == (cVar.f == -1)) {
                c(c2, -1, true);
            } else {
                c(c2, 0, true);
            }
        }
        RecyclerView.m mVar2 = (RecyclerView.m) c2.getLayoutParams();
        Rect K = this.f92b.K(c2);
        int z = RecyclerView.l.z(this.p, this.n, P() + O() + ((ViewGroup.MarginLayoutParams) mVar2).leftMargin + ((ViewGroup.MarginLayoutParams) mVar2).rightMargin + K.left + K.right + 0, ((ViewGroup.MarginLayoutParams) mVar2).width, e());
        int z2 = RecyclerView.l.z(this.q, this.o, N() + Q() + ((ViewGroup.MarginLayoutParams) mVar2).topMargin + ((ViewGroup.MarginLayoutParams) mVar2).bottomMargin + K.top + K.bottom + 0, ((ViewGroup.MarginLayoutParams) mVar2).height, f());
        if (T0(c2, z, z2, mVar2)) {
            c2.measure(z, z2);
        }
        bVar.a = this.t.c(c2);
        if (this.r == 1) {
            if (u1()) {
                d2 = this.p - P();
                i4 = d2 - this.t.d(c2);
            } else {
                i4 = O();
                d2 = this.t.d(c2) + i4;
            }
            int i5 = cVar.f;
            int i6 = cVar.f81b;
            if (i5 == -1) {
                i3 = i6;
                i2 = d2;
                i = i6 - bVar.a;
            } else {
                i = i6;
                i2 = d2;
                i3 = bVar.a + i6;
            }
        } else {
            int Q = Q();
            int d3 = this.t.d(c2) + Q;
            int i7 = cVar.f;
            int i8 = cVar.f81b;
            if (i7 == -1) {
                i2 = i8;
                i = Q;
                i3 = d3;
                i4 = i8 - bVar.a;
            } else {
                i = Q;
                i2 = bVar.a + i8;
                i3 = d3;
                i4 = i8;
            }
        }
        a0(c2, i4, i, i2, i3);
        if (mVar.c() || mVar.b()) {
            bVar.f80c = true;
        }
        bVar.d = c2.hasFocusable();
    }

    public void w1(RecyclerView.r rVar, RecyclerView.w wVar, a aVar, int i) {
    }

    public final void x1(RecyclerView.r rVar, c cVar) {
        if (!cVar.a || cVar.l) {
            return;
        }
        int i = cVar.g;
        int i2 = cVar.i;
        if (cVar.f == -1) {
            int y = y();
            if (i < 0) {
                return;
            }
            int f = (this.t.f() - i) + i2;
            if (this.w) {
                for (int i3 = 0; i3 < y; i3++) {
                    View x = x(i3);
                    if (this.t.e(x) < f || this.t.o(x) < f) {
                        y1(rVar, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = y - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View x2 = x(i5);
                if (this.t.e(x2) < f || this.t.o(x2) < f) {
                    y1(rVar, i4, i5);
                    return;
                }
            }
        } else if (i >= 0) {
            int i6 = i - i2;
            int y2 = y();
            if (!this.w) {
                for (int i7 = 0; i7 < y2; i7++) {
                    View x3 = x(i7);
                    if (this.t.b(x3) > i6 || this.t.n(x3) > i6) {
                        y1(rVar, 0, i7);
                        return;
                    }
                }
                return;
            }
            int i8 = y2 - 1;
            for (int i9 = i8; i9 >= 0; i9--) {
                View x4 = x(i9);
                if (this.t.b(x4) > i6 || this.t.n(x4) > i6) {
                    y1(rVar, i8, i9);
                    return;
                }
            }
        }
    }

    public final void y1(RecyclerView.r rVar, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                H0(i, rVar);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            H0(i3, rVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void z0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.B = (d) parcelable;
            K0();
        }
    }

    public boolean z1() {
        return this.t.i() == 0 && this.t.f() == 0;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.r = 1;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.B = null;
        this.C = new a();
        this.D = new b();
        this.E = 2;
        this.F = new int[2];
        RecyclerView.l.d S = RecyclerView.l.S(context, attributeSet, i, i2);
        C1(S.a);
        boolean z = S.f95c;
        d(null);
        if (z != this.v) {
            this.v = z;
            K0();
        }
        D1(S.d);
    }
}
