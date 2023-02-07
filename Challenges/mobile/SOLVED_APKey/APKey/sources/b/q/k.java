package b.q;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.os.Build;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class k implements Cloneable {
    public static final int[] v = {2, 1, 3, 4};
    public static final f w = new a();
    public static ThreadLocal<b.e.a<Animator, b>> x = new ThreadLocal<>();
    public ArrayList<s> l;
    public ArrayList<s> m;
    public c t;

    /* renamed from: b  reason: collision with root package name */
    public String f719b = getClass().getName();

    /* renamed from: c  reason: collision with root package name */
    public long f720c = -1;
    public long d = -1;
    public TimeInterpolator e = null;
    public ArrayList<Integer> f = new ArrayList<>();
    public ArrayList<View> g = new ArrayList<>();
    public t h = new t();
    public t i = new t();
    public q j = null;
    public int[] k = v;
    public ArrayList<Animator> n = new ArrayList<>();
    public int o = 0;
    public boolean p = false;
    public boolean q = false;
    public ArrayList<d> r = null;
    public ArrayList<Animator> s = new ArrayList<>();
    public f u = w;

    /* loaded from: classes.dex */
    public static class a extends f {
        @Override // b.q.f
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public String f721b;

        /* renamed from: c  reason: collision with root package name */
        public s f722c;
        public l0 d;
        public k e;

        public b(View view, String str, k kVar, l0 l0Var, s sVar) {
            this.a = view;
            this.f721b = str;
            this.f722c = sVar;
            this.d = l0Var;
            this.e = kVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(k kVar);

        void b(k kVar);

        void c(k kVar);

        void d(k kVar);

        void e(k kVar);
    }

    public static void c(t tVar, View view, s sVar) {
        tVar.a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f733b.indexOfKey(id) >= 0) {
                tVar.f733b.put(id, null);
            } else {
                tVar.f733b.put(id, view);
            }
        }
        String s = b.h.j.q.s(view);
        if (s != null) {
            if (tVar.d.e(s) >= 0) {
                tVar.d.put(s, null);
            } else {
                tVar.d.put(s, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (!listView.getAdapter().hasStableIds()) {
                return;
            }
            long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
            b.e.c<View> cVar = tVar.f734c;
            if (cVar.f303b) {
                cVar.d();
            }
            if (b.e.b.b(cVar.f304c, cVar.e, itemIdAtPosition) >= 0) {
                View e = tVar.f734c.e(itemIdAtPosition);
                if (e == null) {
                    return;
                }
                e.setHasTransientState(false);
                tVar.f734c.g(itemIdAtPosition, null);
                return;
            }
            view.setHasTransientState(true);
            tVar.f734c.g(itemIdAtPosition, view);
        }
    }

    public static b.e.a<Animator, b> o() {
        b.e.a<Animator, b> aVar = x.get();
        if (aVar == null) {
            b.e.a<Animator, b> aVar2 = new b.e.a<>();
            x.set(aVar2);
            return aVar2;
        }
        return aVar;
    }

    public static boolean t(s sVar, s sVar2, String str) {
        Object obj = sVar.a.get(str);
        Object obj2 = sVar2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj != null && obj2 != null) {
            return true ^ obj.equals(obj2);
        }
        return true;
    }

    public void A(c cVar) {
        this.t = cVar;
    }

    public k B(TimeInterpolator timeInterpolator) {
        this.e = timeInterpolator;
        return this;
    }

    public void C(f fVar) {
        if (fVar == null) {
            fVar = w;
        }
        this.u = fVar;
    }

    public void D(p pVar) {
    }

    public k E(long j) {
        this.f720c = j;
        return this;
    }

    public void F() {
        if (this.o == 0) {
            ArrayList<d> arrayList = this.r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.r.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((d) arrayList2.get(i)).a(this);
                }
            }
            this.q = false;
        }
        this.o++;
    }

    public String G(String str) {
        StringBuilder g = c.a.a.a.a.g(str);
        g.append(getClass().getSimpleName());
        g.append("@");
        g.append(Integer.toHexString(hashCode()));
        g.append(": ");
        String sb = g.toString();
        if (this.d != -1) {
            sb = sb + "dur(" + this.d + ") ";
        }
        if (this.f720c != -1) {
            sb = sb + "dly(" + this.f720c + ") ";
        }
        if (this.e != null) {
            sb = sb + "interp(" + this.e + ") ";
        }
        if (this.f.size() > 0 || this.g.size() > 0) {
            String d2 = c.a.a.a.a.d(sb, "tgts(");
            if (this.f.size() > 0) {
                for (int i = 0; i < this.f.size(); i++) {
                    if (i > 0) {
                        d2 = c.a.a.a.a.d(d2, ", ");
                    }
                    StringBuilder g2 = c.a.a.a.a.g(d2);
                    g2.append(this.f.get(i));
                    d2 = g2.toString();
                }
            }
            if (this.g.size() > 0) {
                for (int i2 = 0; i2 < this.g.size(); i2++) {
                    if (i2 > 0) {
                        d2 = c.a.a.a.a.d(d2, ", ");
                    }
                    StringBuilder g3 = c.a.a.a.a.g(d2);
                    g3.append(this.g.get(i2));
                    d2 = g3.toString();
                }
            }
            return c.a.a.a.a.d(d2, ")");
        }
        return sb;
    }

    public k a(d dVar) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(dVar);
        return this;
    }

    public k b(View view) {
        this.g.add(view);
        return this;
    }

    public abstract void d(s sVar);

    public final void e(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            s sVar = new s(view);
            if (z) {
                g(sVar);
            } else {
                d(sVar);
            }
            sVar.f732c.add(this);
            f(sVar);
            c(z ? this.h : this.i, view, sVar);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            e(viewGroup.getChildAt(i), z);
        }
    }

    public void f(s sVar) {
    }

    public abstract void g(s sVar);

    public void h(ViewGroup viewGroup, boolean z) {
        i(z);
        if (this.f.size() <= 0 && this.g.size() <= 0) {
            e(viewGroup, z);
            return;
        }
        for (int i = 0; i < this.f.size(); i++) {
            View findViewById = viewGroup.findViewById(this.f.get(i).intValue());
            if (findViewById != null) {
                s sVar = new s(findViewById);
                if (z) {
                    g(sVar);
                } else {
                    d(sVar);
                }
                sVar.f732c.add(this);
                f(sVar);
                c(z ? this.h : this.i, findViewById, sVar);
            }
        }
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            View view = this.g.get(i2);
            s sVar2 = new s(view);
            if (z) {
                g(sVar2);
            } else {
                d(sVar2);
            }
            sVar2.f732c.add(this);
            f(sVar2);
            c(z ? this.h : this.i, view, sVar2);
        }
    }

    public void i(boolean z) {
        t tVar;
        if (z) {
            this.h.a.clear();
            this.h.f733b.clear();
            tVar = this.h;
        } else {
            this.i.a.clear();
            this.i.f733b.clear();
            tVar = this.i;
        }
        tVar.f734c.b();
    }

    @Override // 
    /* renamed from: j */
    public k clone() {
        try {
            k kVar = (k) super.clone();
            kVar.s = new ArrayList<>();
            kVar.h = new t();
            kVar.i = new t();
            kVar.l = null;
            kVar.m = null;
            return kVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator k(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    public void l(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        b.e.a<Animator, b> o = o();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            s sVar3 = arrayList.get(i2);
            s sVar4 = arrayList2.get(i2);
            if (sVar3 != null && !sVar3.f732c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f732c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if (sVar3 == null || sVar4 == null || r(sVar3, sVar4)) {
                    Animator k = k(viewGroup, sVar3, sVar4);
                    if (k != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f731b;
                            String[] p = p();
                            if (p != null && p.length > 0) {
                                sVar2 = new s(view2);
                                s sVar5 = tVar2.a.get(view2);
                                if (sVar5 != null) {
                                    int i3 = 0;
                                    while (i3 < p.length) {
                                        sVar2.a.put(p[i3], sVar5.a.get(p[i3]));
                                        i3++;
                                        k = k;
                                        size = size;
                                        sVar5 = sVar5;
                                    }
                                }
                                Animator animator3 = k;
                                i = size;
                                int i4 = o.d;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= i4) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    b bVar = o.get(o.h(i5));
                                    if (bVar.f722c != null && bVar.a == view2 && bVar.f721b.equals(this.f719b) && bVar.f722c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                i = size;
                                animator2 = k;
                                sVar2 = null;
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            i = size;
                            view = sVar3.f731b;
                            animator = k;
                            sVar = null;
                        }
                        if (animator != null) {
                            o.put(animator, new b(view, this.f719b, this, a0.b(viewGroup), sVar));
                            this.s.add(animator);
                        }
                        i2++;
                        size = i;
                    }
                    i = size;
                    i2++;
                    size = i;
                }
            }
            i = size;
            i2++;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator4 = this.s.get(sparseIntArray.keyAt(i6));
                animator4.setStartDelay(animator4.getStartDelay() + (sparseIntArray.valueAt(i6) - Long.MAX_VALUE));
            }
        }
    }

    public void m() {
        int i = this.o - 1;
        this.o = i;
        if (i == 0) {
            ArrayList<d> arrayList = this.r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.r.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList2.get(i2)).c(this);
                }
            }
            for (int i3 = 0; i3 < this.h.f734c.h(); i3++) {
                View i4 = this.h.f734c.i(i3);
                if (i4 != null) {
                    AtomicInteger atomicInteger = b.h.j.q.a;
                    i4.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < this.i.f734c.h(); i5++) {
                View i6 = this.i.f734c.i(i5);
                if (i6 != null) {
                    AtomicInteger atomicInteger2 = b.h.j.q.a;
                    i6.setHasTransientState(false);
                }
            }
            this.q = true;
        }
    }

    public s n(View view, boolean z) {
        q qVar = this.j;
        if (qVar != null) {
            return qVar.n(view, z);
        }
        ArrayList<s> arrayList = z ? this.l : this.m;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            s sVar = arrayList.get(i2);
            if (sVar == null) {
                return null;
            }
            if (sVar.f731b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i < 0) {
            return null;
        }
        return (z ? this.m : this.l).get(i);
    }

    public String[] p() {
        return null;
    }

    public s q(View view, boolean z) {
        q qVar = this.j;
        if (qVar != null) {
            return qVar.q(view, z);
        }
        return (z ? this.h : this.i).a.getOrDefault(view, null);
    }

    public boolean r(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] p = p();
        if (p == null) {
            for (String str : sVar.a.keySet()) {
                if (t(sVar, sVar2, str)) {
                }
            }
            return false;
        }
        for (String str2 : p) {
            if (!t(sVar, sVar2, str2)) {
            }
        }
        return false;
        return true;
    }

    public boolean s(View view) {
        return (this.f.size() == 0 && this.g.size() == 0) || this.f.contains(Integer.valueOf(view.getId())) || this.g.contains(view);
    }

    public String toString() {
        return G("");
    }

    public void u(View view) {
        int i;
        if (!this.q) {
            b.e.a<Animator, b> o = o();
            int i2 = o.d;
            l0 b2 = a0.b(view);
            int i3 = i2 - 1;
            while (true) {
                i = 0;
                if (i3 < 0) {
                    break;
                }
                b k = o.k(i3);
                if (k.a != null && b2.equals(k.d)) {
                    Animator h = o.h(i3);
                    if (Build.VERSION.SDK_INT >= 19) {
                        h.pause();
                    } else {
                        ArrayList<Animator.AnimatorListener> listeners = h.getListeners();
                        if (listeners != null) {
                            int size = listeners.size();
                            while (i < size) {
                                Animator.AnimatorListener animatorListener = listeners.get(i);
                                if (animatorListener instanceof b.q.a) {
                                    ((b.q.a) animatorListener).onAnimationPause(h);
                                }
                                i++;
                            }
                        }
                    }
                }
                i3--;
            }
            ArrayList<d> arrayList = this.r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.r.clone();
                int size2 = arrayList2.size();
                while (i < size2) {
                    ((d) arrayList2.get(i)).d(this);
                    i++;
                }
            }
            this.p = true;
        }
    }

    public k v(d dVar) {
        ArrayList<d> arrayList = this.r;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(dVar);
        if (this.r.size() == 0) {
            this.r = null;
        }
        return this;
    }

    public k w(View view) {
        this.g.remove(view);
        return this;
    }

    public void x(View view) {
        if (this.p) {
            if (!this.q) {
                b.e.a<Animator, b> o = o();
                int i = o.d;
                l0 b2 = a0.b(view);
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    b k = o.k(i2);
                    if (k.a != null && b2.equals(k.d)) {
                        Animator h = o.h(i2);
                        if (Build.VERSION.SDK_INT >= 19) {
                            h.resume();
                        } else {
                            ArrayList<Animator.AnimatorListener> listeners = h.getListeners();
                            if (listeners != null) {
                                int size = listeners.size();
                                for (int i3 = 0; i3 < size; i3++) {
                                    Animator.AnimatorListener animatorListener = listeners.get(i3);
                                    if (animatorListener instanceof b.q.a) {
                                        ((b.q.a) animatorListener).onAnimationResume(h);
                                    }
                                }
                            }
                        }
                    }
                }
                ArrayList<d> arrayList = this.r;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.r.clone();
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ((d) arrayList2.get(i4)).e(this);
                    }
                }
            }
            this.p = false;
        }
    }

    public void y() {
        F();
        b.e.a<Animator, b> o = o();
        Iterator<Animator> it = this.s.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (o.containsKey(next)) {
                F();
                if (next != null) {
                    next.addListener(new l(this, o));
                    long j = this.d;
                    if (j >= 0) {
                        next.setDuration(j);
                    }
                    long j2 = this.f720c;
                    if (j2 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.e;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new m(this));
                    next.start();
                }
            }
        }
        this.s.clear();
        m();
    }

    public k z(long j) {
        this.d = j;
        return this;
    }
}
