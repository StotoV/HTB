package b.o.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b {
    public final InterfaceC0029b a;

    /* renamed from: b  reason: collision with root package name */
    public final a f653b = new a();

    /* renamed from: c  reason: collision with root package name */
    public final List<View> f654c = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public long a = 0;

        /* renamed from: b  reason: collision with root package name */
        public a f655b;

        public void a(int i) {
            if (i < 64) {
                this.a &= (1 << i) ^ (-1);
                return;
            }
            a aVar = this.f655b;
            if (aVar == null) {
                return;
            }
            aVar.a(i - 64);
        }

        public int b(int i) {
            long j;
            a aVar = this.f655b;
            if (aVar == null) {
                if (i >= 64) {
                    j = this.a;
                    return Long.bitCount(j);
                }
            } else if (i >= 64) {
                return Long.bitCount(this.a) + aVar.b(i - 64);
            }
            j = this.a & ((1 << i) - 1);
            return Long.bitCount(j);
        }

        public final void c() {
            if (this.f655b == null) {
                this.f655b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            c();
            return this.f655b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.f655b.e(i - 64, z);
                return;
            }
            long j = this.a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.a = ((j & (j2 ^ (-1))) << 1) | (j & j2);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (!z2 && this.f655b == null) {
                return;
            }
            c();
            this.f655b.e(0, z2);
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.f655b.f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (j ^ (-1));
            this.a = j3;
            long j4 = j - 1;
            this.a = (j3 & j4) | Long.rotateRight((j4 ^ (-1)) & j3, 1);
            a aVar = this.f655b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f655b.f(0);
            }
            return z;
        }

        public void g() {
            this.a = 0L;
            a aVar = this.f655b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i < 64) {
                this.a |= 1 << i;
                return;
            }
            c();
            this.f655b.h(i - 64);
        }

        public String toString() {
            if (this.f655b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.f655b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* renamed from: b.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0029b {
    }

    public b(InterfaceC0029b interfaceC0029b) {
        this.a = interfaceC0029b;
    }

    public void a(View view, int i, boolean z) {
        int b2 = i < 0 ? ((v) this.a).b() : f(i);
        this.f653b.e(b2, z);
        if (z) {
            i(view);
        }
        v vVar = (v) this.a;
        vVar.a.addView(view, b2);
        RecyclerView recyclerView = vVar.a;
        recyclerView.getClass();
        RecyclerView.J(view);
        recyclerView.R();
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int b2 = i < 0 ? ((v) this.a).b() : f(i);
        this.f653b.e(b2, z);
        if (z) {
            i(view);
        }
        v vVar = (v) this.a;
        vVar.getClass();
        RecyclerView.z J = RecyclerView.J(view);
        if (J != null) {
            if (!J.n() && !J.t()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(J);
                throw new IllegalArgumentException(c.a.a.a.a.b(vVar.a, sb));
            }
            J.j &= -257;
        }
        vVar.a.attachViewToParent(view, b2, layoutParams);
    }

    public void c(int i) {
        RecyclerView.z J;
        int f = f(i);
        this.f653b.f(f);
        v vVar = (v) this.a;
        View childAt = vVar.a.getChildAt(f);
        if (childAt != null && (J = RecyclerView.J(childAt)) != null) {
            if (J.n() && !J.t()) {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(J);
                throw new IllegalArgumentException(c.a.a.a.a.b(vVar.a, sb));
            }
            J.b(256);
        }
        vVar.a.detachViewFromParent(f);
    }

    public View d(int i) {
        return ((v) this.a).a(f(i));
    }

    public int e() {
        return ((v) this.a).b() - this.f654c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int b2 = ((v) this.a).b();
        int i2 = i;
        while (i2 < b2) {
            int b3 = i - (i2 - this.f653b.b(i2));
            if (b3 == 0) {
                while (this.f653b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b3;
        }
        return -1;
    }

    public View g(int i) {
        return ((v) this.a).a.getChildAt(i);
    }

    public int h() {
        return ((v) this.a).b();
    }

    public final void i(View view) {
        this.f654c.add(view);
        v vVar = (v) this.a;
        vVar.getClass();
        RecyclerView.z J = RecyclerView.J(view);
        if (J != null) {
            RecyclerView recyclerView = vVar.a;
            int i = J.q;
            if (i == -1) {
                View view2 = J.a;
                AtomicInteger atomicInteger = b.h.j.q.a;
                i = view2.getImportantForAccessibility();
            }
            J.p = i;
            recyclerView.i0(J, 4);
        }
    }

    public int j(View view) {
        int indexOfChild = ((v) this.a).a.indexOfChild(view);
        if (indexOfChild != -1 && !this.f653b.d(indexOfChild)) {
            return indexOfChild - this.f653b.b(indexOfChild);
        }
        return -1;
    }

    public boolean k(View view) {
        return this.f654c.contains(view);
    }

    public final boolean l(View view) {
        if (this.f654c.remove(view)) {
            v vVar = (v) this.a;
            vVar.getClass();
            RecyclerView.z J = RecyclerView.J(view);
            if (J == null) {
                return true;
            }
            vVar.a.i0(J, J.p);
            J.p = 0;
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f653b.toString() + ", hidden list:" + this.f654c.size();
    }
}
