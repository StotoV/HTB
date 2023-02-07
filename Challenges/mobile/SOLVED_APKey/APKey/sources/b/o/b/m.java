package b.o.b;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class m implements Runnable {
    public static final ThreadLocal<m> f = new ThreadLocal<>();
    public static Comparator<c> g = new a();

    /* renamed from: c  reason: collision with root package name */
    public long f684c;
    public long d;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<RecyclerView> f683b = new ArrayList<>();
    public ArrayList<c> e = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a implements Comparator<c> {
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r0 != false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
            r1 = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
            return r1;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int compare(b.o.b.m.c r7, b.o.b.m.c r8) {
            /*
                r6 = this;
                b.o.b.m$c r7 = (b.o.b.m.c) r7
                b.o.b.m$c r8 = (b.o.b.m.c) r8
                androidx.recyclerview.widget.RecyclerView r0 = r7.d
                r1 = 1
                r2 = 0
                if (r0 != 0) goto Lc
                r3 = 1
                goto Ld
            Lc:
                r3 = 0
            Ld:
                androidx.recyclerview.widget.RecyclerView r4 = r8.d
                if (r4 != 0) goto L13
                r4 = 1
                goto L14
            L13:
                r4 = 0
            L14:
                r5 = -1
                if (r3 == r4) goto L1a
                if (r0 != 0) goto L22
                goto L23
            L1a:
                boolean r0 = r7.a
                boolean r3 = r8.a
                if (r0 == r3) goto L25
                if (r0 == 0) goto L23
            L22:
                r1 = -1
            L23:
                r2 = r1
                goto L36
            L25:
                int r0 = r8.f687b
                int r1 = r7.f687b
                int r0 = r0 - r1
                if (r0 == 0) goto L2e
                r2 = r0
                goto L36
            L2e:
                int r7 = r7.f688c
                int r8 = r8.f688c
                int r7 = r7 - r8
                if (r7 == 0) goto L36
                r2 = r7
            L36:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: b.o.b.m.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* loaded from: classes.dex */
    public static class b implements RecyclerView.l.c {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f685b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f686c;
        public int d;

        public void a(int i, int i2) {
            if (i >= 0) {
                if (i2 < 0) {
                    throw new IllegalArgumentException("Pixel distance must be non-negative");
                }
                int i3 = this.d * 2;
                int[] iArr = this.f686c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f686c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[i3 * 2];
                    this.f686c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f686c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.d++;
                return;
            }
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void b(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.f686c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.l lVar = recyclerView.m;
            if (recyclerView.l == null || lVar == null || !lVar.k) {
                return;
            }
            if (z) {
                if (!recyclerView.e.g()) {
                    lVar.j(recyclerView.l.a(), this);
                }
            } else if (!recyclerView.L()) {
                lVar.i(this.a, this.f685b, recyclerView.f0, this);
            }
            int i = this.d;
            if (i <= lVar.l) {
                return;
            }
            lVar.l = i;
            lVar.m = z;
            recyclerView.f86c.m();
        }

        public boolean c(int i) {
            if (this.f686c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f686c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public int f687b;

        /* renamed from: c  reason: collision with root package name */
        public int f688c;
        public RecyclerView d;
        public int e;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f684c == 0) {
            this.f684c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.e0;
        bVar.a = i;
        bVar.f685b = i2;
    }

    public void b(long j) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        int size = this.f683b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = this.f683b.get(i2);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.e0.b(recyclerView3, false);
                i += recyclerView3.e0.d;
            }
        }
        this.e.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = this.f683b.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar = recyclerView4.e0;
                int abs = Math.abs(bVar.f685b) + Math.abs(bVar.a);
                for (int i5 = 0; i5 < bVar.d * 2; i5 += 2) {
                    if (i3 >= this.e.size()) {
                        cVar2 = new c();
                        this.e.add(cVar2);
                    } else {
                        cVar2 = this.e.get(i3);
                    }
                    int[] iArr = bVar.f686c;
                    int i6 = iArr[i5 + 1];
                    cVar2.a = i6 <= abs;
                    cVar2.f687b = abs;
                    cVar2.f688c = i6;
                    cVar2.d = recyclerView4;
                    cVar2.e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.e, g);
        for (int i7 = 0; i7 < this.e.size() && (recyclerView = (cVar = this.e.get(i7)).d) != null; i7++) {
            RecyclerView.z c2 = c(recyclerView, cVar.e, cVar.a ? Long.MAX_VALUE : j);
            if (c2 != null && c2.f111b != null && c2.i() && !c2.j() && (recyclerView2 = c2.f111b.get()) != null) {
                if (recyclerView2.B && recyclerView2.f.h() != 0) {
                    recyclerView2.c0();
                }
                b bVar2 = recyclerView2.e0;
                bVar2.b(recyclerView2, true);
                if (bVar2.d != 0) {
                    try {
                        b.h.f.b.a("RV Nested Prefetch");
                        RecyclerView.w wVar = recyclerView2.f0;
                        RecyclerView.d dVar = recyclerView2.l;
                        wVar.d = 1;
                        wVar.e = dVar.a();
                        wVar.g = false;
                        wVar.h = false;
                        wVar.i = false;
                        for (int i8 = 0; i8 < bVar2.d * 2; i8 += 2) {
                            c(recyclerView2, bVar2.f686c[i8], j);
                        }
                    } finally {
                        b.h.f.b.b();
                    }
                } else {
                    continue;
                }
            }
            cVar.a = false;
            cVar.f687b = 0;
            cVar.f688c = 0;
            cVar.d = null;
            cVar.e = 0;
        }
    }

    public final RecyclerView.z c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int h = recyclerView.f.h();
        int i2 = 0;
        while (true) {
            if (i2 >= h) {
                z = false;
                break;
            }
            RecyclerView.z J = RecyclerView.J(recyclerView.f.g(i2));
            if (J.f112c == i && !J.j()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.r rVar = recyclerView.f86c;
        try {
            recyclerView.T();
            RecyclerView.z k = rVar.k(i, false, j);
            if (k != null) {
                if (!k.i() || k.j()) {
                    rVar.a(k, false);
                } else {
                    rVar.h(k.a);
                }
            }
            return k;
        } finally {
            recyclerView.U(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            b.h.f.b.a("RV Prefetch");
            if (!this.f683b.isEmpty()) {
                int size = this.f683b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f683b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j) + this.d);
                }
            }
        } finally {
            this.f684c = 0L;
            b.h.f.b.b();
        }
    }
}
