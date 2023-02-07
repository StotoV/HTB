package b.o.b;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends y {
    public static TimeInterpolator s;
    public ArrayList<RecyclerView.z> h = new ArrayList<>();
    public ArrayList<RecyclerView.z> i = new ArrayList<>();
    public ArrayList<b> j = new ArrayList<>();
    public ArrayList<a> k = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.z>> l = new ArrayList<>();
    public ArrayList<ArrayList<b>> m = new ArrayList<>();
    public ArrayList<ArrayList<a>> n = new ArrayList<>();
    public ArrayList<RecyclerView.z> o = new ArrayList<>();
    public ArrayList<RecyclerView.z> p = new ArrayList<>();
    public ArrayList<RecyclerView.z> q = new ArrayList<>();
    public ArrayList<RecyclerView.z> r = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class a {
        public RecyclerView.z a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.z f675b;

        /* renamed from: c  reason: collision with root package name */
        public int f676c;
        public int d;
        public int e;
        public int f;

        public a(RecyclerView.z zVar, RecyclerView.z zVar2, int i, int i2, int i3, int i4) {
            this.a = zVar;
            this.f675b = zVar2;
            this.f676c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("ChangeInfo{oldHolder=");
            g.append(this.a);
            g.append(", newHolder=");
            g.append(this.f675b);
            g.append(", fromX=");
            g.append(this.f676c);
            g.append(", fromY=");
            g.append(this.d);
            g.append(", toX=");
            g.append(this.e);
            g.append(", toY=");
            g.append(this.f);
            g.append('}');
            return g.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public RecyclerView.z a;

        /* renamed from: b  reason: collision with root package name */
        public int f677b;

        /* renamed from: c  reason: collision with root package name */
        public int f678c;
        public int d;
        public int e;

        public b(RecyclerView.z zVar, int i, int i2, int i3, int i4) {
            this.a = zVar;
            this.f677b = i;
            this.f678c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void e(RecyclerView.z zVar) {
        View view = zVar.a;
        view.animate().cancel();
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.j.get(size).a == zVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(zVar);
                this.j.remove(size);
            }
        }
        l(this.k, zVar);
        if (this.h.remove(zVar)) {
            view.setAlpha(1.0f);
            c(zVar);
        }
        if (this.i.remove(zVar)) {
            view.setAlpha(1.0f);
            c(zVar);
        }
        int size2 = this.n.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<a> arrayList = this.n.get(size2);
            l(arrayList, zVar);
            if (arrayList.isEmpty()) {
                this.n.remove(size2);
            }
        }
        int size3 = this.m.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<b> arrayList2 = this.m.get(size3);
            int size4 = arrayList2.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).a == zVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(zVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.m.remove(size3);
                    }
                }
            }
        }
        int size5 = this.l.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                this.q.remove(zVar);
                this.o.remove(zVar);
                this.r.remove(zVar);
                this.p.remove(zVar);
                k();
                return;
            }
            ArrayList<RecyclerView.z> arrayList3 = this.l.get(size5);
            if (arrayList3.remove(zVar)) {
                view.setAlpha(1.0f);
                c(zVar);
                if (arrayList3.isEmpty()) {
                    this.l.remove(size5);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void f() {
        int size = this.j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            b bVar = this.j.get(size);
            View view = bVar.a.a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(bVar.a);
            this.j.remove(size);
        }
        int size2 = this.h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            c(this.h.get(size2));
            this.h.remove(size2);
        }
        int size3 = this.i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.z zVar = this.i.get(size3);
            zVar.a.setAlpha(1.0f);
            c(zVar);
            this.i.remove(size3);
        }
        int size4 = this.k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            a aVar = this.k.get(size4);
            RecyclerView.z zVar2 = aVar.a;
            if (zVar2 != null) {
                m(aVar, zVar2);
            }
            RecyclerView.z zVar3 = aVar.f675b;
            if (zVar3 != null) {
                m(aVar, zVar3);
            }
        }
        this.k.clear();
        if (!g()) {
            return;
        }
        int size5 = this.m.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<b> arrayList = this.m.get(size5);
            int size6 = arrayList.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    b bVar2 = arrayList.get(size6);
                    View view2 = bVar2.a.a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(bVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.m.remove(arrayList);
                    }
                }
            }
        }
        int size7 = this.l.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<RecyclerView.z> arrayList2 = this.l.get(size7);
            int size8 = arrayList2.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    RecyclerView.z zVar4 = arrayList2.get(size8);
                    zVar4.a.setAlpha(1.0f);
                    c(zVar4);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.l.remove(arrayList2);
                    }
                }
            }
        }
        int size9 = this.n.size();
        while (true) {
            size9--;
            if (size9 < 0) {
                j(this.q);
                j(this.p);
                j(this.o);
                j(this.r);
                d();
                return;
            }
            ArrayList<a> arrayList3 = this.n.get(size9);
            int size10 = arrayList3.size();
            while (true) {
                size10--;
                if (size10 >= 0) {
                    a aVar2 = arrayList3.get(size10);
                    RecyclerView.z zVar5 = aVar2.a;
                    if (zVar5 != null) {
                        m(aVar2, zVar5);
                    }
                    RecyclerView.z zVar6 = aVar2.f675b;
                    if (zVar6 != null) {
                        m(aVar2, zVar6);
                    }
                    if (arrayList3.isEmpty()) {
                        this.n.remove(arrayList3);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean g() {
        return !this.i.isEmpty() || !this.k.isEmpty() || !this.j.isEmpty() || !this.h.isEmpty() || !this.p.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.r.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.n.isEmpty();
    }

    @Override // b.o.b.y
    public boolean i(RecyclerView.z zVar, int i, int i2, int i3, int i4) {
        View view = zVar.a;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) zVar.a.getTranslationY());
        n(zVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            c(zVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.j.add(new b(zVar, translationX, translationY, i3, i4));
        return true;
    }

    public void j(List<RecyclerView.z> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                list.get(size).a.animate().cancel();
            } else {
                return;
            }
        }
    }

    public void k() {
        if (!g()) {
            d();
        }
    }

    public final void l(List<a> list, RecyclerView.z zVar) {
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                a aVar = list.get(size);
                if (m(aVar, zVar) && aVar.a == null && aVar.f675b == null) {
                    list.remove(aVar);
                }
            } else {
                return;
            }
        }
    }

    public final boolean m(a aVar, RecyclerView.z zVar) {
        if (aVar.f675b == zVar) {
            aVar.f675b = null;
        } else if (aVar.a != zVar) {
            return false;
        } else {
            aVar.a = null;
        }
        zVar.a.setAlpha(1.0f);
        zVar.a.setTranslationX(0.0f);
        zVar.a.setTranslationY(0.0f);
        c(zVar);
        return true;
    }

    public final void n(RecyclerView.z zVar) {
        if (s == null) {
            s = new ValueAnimator().getInterpolator();
        }
        zVar.a.animate().setInterpolator(s);
        e(zVar);
    }
}
