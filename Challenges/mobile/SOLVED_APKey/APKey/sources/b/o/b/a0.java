package b.o.b;

import android.view.View;
/* loaded from: classes.dex */
public class a0 {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public a f650b = new a();

    /* loaded from: classes.dex */
    public static class a {
        public int a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f651b;

        /* renamed from: c  reason: collision with root package name */
        public int f652c;
        public int d;
        public int e;

        public boolean a() {
            int i = this.a;
            if ((i & 7) == 0 || (i & (b(this.d, this.f651b) << 0)) != 0) {
                int i2 = this.a;
                if ((i2 & 112) != 0 && (i2 & (b(this.d, this.f652c) << 4)) == 0) {
                    return false;
                }
                int i3 = this.a;
                if ((i3 & 1792) != 0 && (i3 & (b(this.e, this.f651b) << 8)) == 0) {
                    return false;
                }
                int i4 = this.a;
                return (i4 & 28672) == 0 || (i4 & (b(this.e, this.f652c) << 12)) != 0;
            }
            return false;
        }

        public int b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        int a();

        int b();

        int c(View view);

        int d(View view);

        View e(int i);
    }

    public a0(b bVar) {
        this.a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int b2 = this.a.b();
        int a2 = this.a.a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View e = this.a.e(i);
            int d = this.a.d(e);
            int c2 = this.a.c(e);
            a aVar = this.f650b;
            aVar.f651b = b2;
            aVar.f652c = a2;
            aVar.d = d;
            aVar.e = c2;
            if (i3 != 0) {
                aVar.a = 0;
                aVar.a = i3 | 0;
                if (aVar.a()) {
                    return e;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.f650b;
                aVar2.a = 0;
                aVar2.a = i4 | 0;
                if (aVar2.a()) {
                    view = e;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.f650b;
        int b2 = this.a.b();
        int a2 = this.a.a();
        int d = this.a.d(view);
        int c2 = this.a.c(view);
        aVar.f651b = b2;
        aVar.f652c = a2;
        aVar.d = d;
        aVar.e = c2;
        if (i != 0) {
            a aVar2 = this.f650b;
            aVar2.a = 0;
            aVar2.a = 0 | i;
            return aVar2.a();
        }
        return false;
    }
}
