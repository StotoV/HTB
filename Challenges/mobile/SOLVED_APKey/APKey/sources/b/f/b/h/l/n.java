package b.f.b.h.l;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n {
    public static int f;

    /* renamed from: b  reason: collision with root package name */
    public int f357b;

    /* renamed from: c  reason: collision with root package name */
    public int f358c;
    public ArrayList<b.f.b.h.d> a = new ArrayList<>();
    public ArrayList<a> d = null;
    public int e = -1;

    /* loaded from: classes.dex */
    public class a {
        public a(n nVar, b.f.b.h.d dVar, b.f.b.d dVar2, int i) {
            new WeakReference(dVar);
            dVar2.o(dVar.D);
            dVar2.o(dVar.E);
            dVar2.o(dVar.F);
            dVar2.o(dVar.G);
            dVar2.o(dVar.H);
        }
    }

    public n(int i) {
        this.f357b = -1;
        this.f358c = 0;
        int i2 = f;
        f = i2 + 1;
        this.f357b = i2;
        this.f358c = i;
    }

    public boolean a(b.f.b.h.d dVar) {
        if (this.a.contains(dVar)) {
            return false;
        }
        this.a.add(dVar);
        return true;
    }

    public void b(ArrayList<n> arrayList) {
        int size = this.a.size();
        if (this.e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                n nVar = arrayList.get(i);
                if (this.e == nVar.f357b) {
                    d(this.f358c, nVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c(b.f.b.d dVar, int i) {
        int o;
        b.f.b.h.c cVar;
        if (this.a.size() == 0) {
            return 0;
        }
        ArrayList<b.f.b.h.d> arrayList = this.a;
        b.f.b.h.e eVar = (b.f.b.h.e) arrayList.get(0).P;
        dVar.u();
        eVar.d(dVar, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).d(dVar, false);
        }
        if (i == 0 && eVar.t0 > 0) {
            b.b.a.a(eVar, dVar, arrayList, 0);
        }
        if (i == 1 && eVar.u0 > 0) {
            b.b.a.a(eVar, dVar, arrayList, 1);
        }
        try {
            dVar.q();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.d.add(new a(this, arrayList.get(i3), dVar, i));
        }
        if (i == 0) {
            o = dVar.o(eVar.D);
            cVar = eVar.F;
        } else {
            o = dVar.o(eVar.E);
            cVar = eVar.G;
        }
        int o2 = dVar.o(cVar);
        dVar.u();
        return o2 - o;
    }

    public void d(int i, n nVar) {
        Iterator<b.f.b.h.d> it = this.a.iterator();
        while (it.hasNext()) {
            b.f.b.h.d next = it.next();
            nVar.a(next);
            if (i == 0) {
                next.j0 = nVar.f357b;
            } else {
                next.k0 = nVar.f357b;
            }
        }
        this.e = nVar.f357b;
    }

    public String toString() {
        Iterator<b.f.b.h.d> it;
        StringBuilder sb = new StringBuilder();
        int i = this.f358c;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.f357b);
        sb.append("] <");
        String sb2 = sb.toString();
        while (this.a.iterator().hasNext()) {
            sb2 = sb2 + " " + it.next().d0;
        }
        return c.a.a.a.a.d(sb2, " >");
    }
}
