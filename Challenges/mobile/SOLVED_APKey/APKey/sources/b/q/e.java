package b.q;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import b.k.b.t0;
import b.q.k;
import b.q.o;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e extends t0 {

    /* loaded from: classes.dex */
    public class a extends k.c {
        public a(e eVar, Rect rect) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements k.d {
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f704b;

        public b(e eVar, View view, ArrayList arrayList) {
            this.a = view;
            this.f704b = arrayList;
        }

        @Override // b.q.k.d
        public void a(k kVar) {
        }

        @Override // b.q.k.d
        public void b(k kVar) {
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            kVar.v(this);
            this.a.setVisibility(8);
            int size = this.f704b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f704b.get(i)).setVisibility(0);
            }
        }

        @Override // b.q.k.d
        public void d(k kVar) {
        }

        @Override // b.q.k.d
        public void e(k kVar) {
        }
    }

    /* loaded from: classes.dex */
    public class c extends n {
        public final /* synthetic */ Object a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayList f705b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f706c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ ArrayList f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.a = obj;
            this.f705b = arrayList;
            this.f706c = obj2;
            this.d = arrayList2;
            this.e = obj3;
            this.f = arrayList3;
        }

        @Override // b.q.n, b.q.k.d
        public void a(k kVar) {
            Object obj = this.a;
            if (obj != null) {
                e.this.p(obj, this.f705b, null);
            }
            Object obj2 = this.f706c;
            if (obj2 != null) {
                e.this.p(obj2, this.d, null);
            }
            Object obj3 = this.e;
            if (obj3 != null) {
                e.this.p(obj3, this.f, null);
            }
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            kVar.v(this);
        }
    }

    /* loaded from: classes.dex */
    public class d extends k.c {
        public d(e eVar, Rect rect) {
        }
    }

    public static boolean z(k kVar) {
        return !t0.k(kVar.f) || !t0.k(null) || !t0.k(null);
    }

    @Override // b.k.b.t0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((k) obj).b(view);
        }
    }

    @Override // b.k.b.t0
    public void b(Object obj, ArrayList<View> arrayList) {
        k kVar = (k) obj;
        if (kVar == null) {
            return;
        }
        int i = 0;
        if (kVar instanceof q) {
            q qVar = (q) kVar;
            int size = qVar.y.size();
            while (i < size) {
                b(qVar.I(i), arrayList);
                i++;
            }
        } else if (z(kVar) || !t0.k(kVar.g)) {
        } else {
            int size2 = arrayList.size();
            while (i < size2) {
                kVar.b(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // b.k.b.t0
    public void c(ViewGroup viewGroup, Object obj) {
        k kVar = (k) obj;
        if (o.f725c.contains(viewGroup) || !b.h.j.q.u(viewGroup)) {
            return;
        }
        o.f725c.add(viewGroup);
        if (kVar == null) {
            kVar = o.a;
        }
        k clone = kVar.clone();
        ArrayList<k> orDefault = o.a().getOrDefault(viewGroup, null);
        if (orDefault != null && orDefault.size() > 0) {
            Iterator<k> it = orDefault.iterator();
            while (it.hasNext()) {
                it.next().u(viewGroup);
            }
        }
        if (clone != null) {
            clone.h(viewGroup, true);
        }
        if (((j) viewGroup.getTag(R.id.transition_current_scene)) == null) {
            viewGroup.setTag(R.id.transition_current_scene, null);
            if (clone == null) {
                return;
            }
            o.a aVar = new o.a(clone, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            return;
        }
        throw null;
    }

    @Override // b.k.b.t0
    public boolean e(Object obj) {
        return obj instanceof k;
    }

    @Override // b.k.b.t0
    public Object g(Object obj) {
        if (obj != null) {
            return ((k) obj).clone();
        }
        return null;
    }

    @Override // b.k.b.t0
    public Object l(Object obj, Object obj2, Object obj3) {
        k kVar = (k) obj;
        k kVar2 = (k) obj2;
        k kVar3 = (k) obj3;
        if (kVar != null && kVar2 != null) {
            q qVar = new q();
            qVar.H(kVar);
            qVar.H(kVar2);
            qVar.J(1);
            kVar = qVar;
        } else if (kVar == null) {
            kVar = kVar2 != null ? kVar2 : null;
        }
        if (kVar3 != null) {
            q qVar2 = new q();
            if (kVar != null) {
                qVar2.H(kVar);
            }
            qVar2.H(kVar3);
            return qVar2;
        }
        return kVar;
    }

    @Override // b.k.b.t0
    public Object m(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.H((k) obj);
        }
        if (obj2 != null) {
            qVar.H((k) obj2);
        }
        if (obj3 != null) {
            qVar.H((k) obj3);
        }
        return qVar;
    }

    @Override // b.k.b.t0
    public void o(Object obj, View view) {
        if (obj != null) {
            ((k) obj).w(view);
        }
    }

    @Override // b.k.b.t0
    public void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        k kVar = (k) obj;
        int i = 0;
        if (kVar instanceof q) {
            q qVar = (q) kVar;
            int size = qVar.y.size();
            while (i < size) {
                p(qVar.I(i), arrayList, arrayList2);
                i++;
            }
        } else if (z(kVar)) {
        } else {
            ArrayList<View> arrayList3 = kVar.g;
            if (arrayList3.size() != arrayList.size() || !arrayList3.containsAll(arrayList)) {
                return;
            }
            int size2 = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size2) {
                kVar.b(arrayList2.get(i));
                i++;
            }
            int size3 = arrayList.size();
            while (true) {
                size3--;
                if (size3 < 0) {
                    return;
                }
                kVar.w(arrayList.get(size3));
            }
        }
    }

    @Override // b.k.b.t0
    public void q(Object obj, View view, ArrayList<View> arrayList) {
        ((k) obj).a(new b(this, view, arrayList));
    }

    @Override // b.k.b.t0
    public void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((k) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // b.k.b.t0
    public void s(Object obj, Rect rect) {
        if (obj != null) {
            ((k) obj).A(new d(this, rect));
        }
    }

    @Override // b.k.b.t0
    public void t(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            j(view, rect);
            ((k) obj).A(new a(this, rect));
        }
    }

    @Override // b.k.b.t0
    public void w(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        ArrayList<View> arrayList2 = qVar.g;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            t0.d(arrayList2, arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }

    @Override // b.k.b.t0
    public void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.g.clear();
            qVar.g.addAll(arrayList2);
            p(qVar, arrayList, arrayList2);
        }
    }

    @Override // b.k.b.t0
    public Object y(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.H((k) obj);
        return qVar;
    }
}
