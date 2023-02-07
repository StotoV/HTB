package b.o.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class z extends RecyclerView.n {
    public RecyclerView a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView.p f694b = new a();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.p {
        public boolean a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void a(RecyclerView recyclerView, int i) {
            if (i != 0 || !this.a) {
                return;
            }
            this.a = false;
            z.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.p
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.a = true;
        }
    }

    public abstract int[] a(RecyclerView.l lVar, View view);

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r10 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r10.a
            if (r0 != 0) goto L5
            return
        L5:
            androidx.recyclerview.widget.RecyclerView$l r0 = r0.getLayoutManager()
            if (r0 != 0) goto Lc
            return
        Lc:
            r1 = r10
            b.o.b.u r1 = (b.o.b.u) r1
            boolean r2 = r0.f()
            if (r2 == 0) goto L1a
            b.o.b.s r2 = r1.f(r0)
            goto L24
        L1a:
            boolean r2 = r0.e()
            if (r2 == 0) goto L29
            b.o.b.s r2 = r1.e(r0)
        L24:
            android.view.View r1 = r1.d(r0, r2)
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 != 0) goto L2d
            return
        L2d:
            int[] r0 = r10.a(r0, r1)
            r1 = 0
            r2 = r0[r1]
            r3 = 1
            if (r2 != 0) goto L3b
            r2 = r0[r3]
            if (r2 == 0) goto L48
        L3b:
            androidx.recyclerview.widget.RecyclerView r4 = r10.a
            r5 = r0[r1]
            r6 = r0[r3]
            r9 = 0
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 0
            r4.j0(r5, r6, r7, r8, r9)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.o.b.z.b():void");
    }
}
