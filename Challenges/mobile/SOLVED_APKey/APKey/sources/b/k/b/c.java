package b.k.b;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import b.e.e;
import b.k.b.m;
import b.k.b.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends y0 {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f524b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y0.d f525c;

        public a(List list, y0.d dVar) {
            this.f524b = list;
            this.f525c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f524b.contains(this.f525c)) {
                this.f524b.remove(this.f525c);
                c cVar = c.this;
                y0.d dVar = this.f525c;
                cVar.getClass();
                dVar.a.a(dVar.f622c.F);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends C0025c {

        /* renamed from: c  reason: collision with root package name */
        public boolean f526c;
        public boolean d;
        public t e;

        public b(y0.d dVar, b.h.f.a aVar, boolean z) {
            super(dVar, aVar);
            this.d = false;
            this.f526c = z;
        }

        public t c(Context context) {
            if (this.d) {
                return this.e;
            }
            y0.d dVar = this.a;
            t I = b.h.b.a.I(context, dVar.f622c, dVar.a == y0.d.c.VISIBLE, this.f526c);
            this.e = I;
            this.d = true;
            return I;
        }
    }

    /* renamed from: b.k.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0025c {
        public final y0.d a;

        /* renamed from: b  reason: collision with root package name */
        public final b.h.f.a f527b;

        public C0025c(y0.d dVar, b.h.f.a aVar) {
            this.a = dVar;
            this.f527b = aVar;
        }

        public void a() {
            y0.d dVar = this.a;
            if (!dVar.e.remove(this.f527b) || !dVar.e.isEmpty()) {
                return;
            }
            dVar.b();
        }

        public boolean b() {
            y0.d.c cVar;
            y0.d.c c2 = y0.d.c.c(this.a.f622c.F);
            y0.d.c cVar2 = this.a.a;
            return c2 == cVar2 || !(c2 == (cVar = y0.d.c.VISIBLE) || cVar2 == cVar);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends C0025c {

        /* renamed from: c  reason: collision with root package name */
        public final Object f528c;
        public final boolean d;
        public final Object e;

        public d(y0.d dVar, b.h.f.a aVar, boolean z, boolean z2) {
            super(dVar, aVar);
            Object obj;
            Object obj2;
            if (dVar.a == y0.d.c.VISIBLE) {
                if (z) {
                    obj2 = dVar.f622c.w();
                } else {
                    dVar.f622c.l();
                    obj2 = null;
                }
                this.f528c = obj2;
                if (z) {
                    m.b bVar = dVar.f622c.I;
                } else {
                    m.b bVar2 = dVar.f622c.I;
                }
            } else {
                if (z) {
                    obj = dVar.f622c.y();
                } else {
                    dVar.f622c.o();
                    obj = null;
                }
                this.f528c = obj;
            }
            this.d = true;
            if (z2) {
                if (z) {
                    this.e = dVar.f622c.A();
                    return;
                }
                dVar.f622c.z();
            }
            this.e = null;
        }

        public final t0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            t0 t0Var = r0.f591b;
            if (t0Var != null && t0Var.e(obj)) {
                return t0Var;
            }
            t0 t0Var2 = r0.f592c;
            if (t0Var2 != null && t0Var2.e(obj)) {
                return t0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.f622c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.k.b.y0
    public void b(List<y0.d> list, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        HashMap hashMap;
        y0.d.c cVar;
        String str;
        String str2;
        Iterator it;
        y0.d dVar;
        Object obj;
        y0.d.c cVar2;
        View view;
        y0.d.c cVar3;
        View view2;
        Object m;
        Object obj2;
        y0.d dVar2;
        ArrayList<View> arrayList3;
        y0.d.c cVar4;
        b.e.a aVar;
        ArrayList arrayList4;
        ArrayList arrayList5;
        HashMap hashMap2;
        String str3;
        ArrayList<View> arrayList6;
        y0.d dVar3;
        View view3;
        t0 t0Var;
        Rect rect;
        ArrayList<String> arrayList7;
        ArrayList<String> arrayList8;
        ArrayList<String> arrayList9;
        ArrayList<String> arrayList10;
        View view4;
        StringBuilder sb;
        String str4;
        t c2;
        boolean z2 = z;
        y0.d.c cVar5 = y0.d.c.GONE;
        y0.d.c cVar6 = y0.d.c.VISIBLE;
        y0.d dVar4 = null;
        y0.d dVar5 = null;
        for (y0.d dVar6 : list) {
            y0.d.c c3 = y0.d.c.c(dVar6.f622c.F);
            int ordinal = dVar6.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2 && ordinal != 3) {
                    }
                } else if (c3 != cVar6) {
                    dVar5 = dVar6;
                }
            }
            if (c3 == cVar6 && dVar4 == null) {
                dVar4 = dVar6;
            }
        }
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList(list);
        Iterator<y0.d> it2 = list.iterator();
        while (it2.hasNext()) {
            y0.d next = it2.next();
            b.h.f.a aVar2 = new b.h.f.a();
            next.d();
            next.e.add(aVar2);
            arrayList11.add(new b(next, aVar2, z2));
            b.h.f.a aVar3 = new b.h.f.a();
            next.d();
            next.e.add(aVar3);
            arrayList12.add(new d(next, aVar3, z2, !z2 ? next == dVar5 : next == dVar4));
            next.d.add(new a(arrayList13, next));
        }
        HashMap hashMap3 = new HashMap();
        Iterator it3 = arrayList12.iterator();
        t0 t0Var2 = null;
        while (it3.hasNext()) {
            d dVar7 = (d) it3.next();
            if (!dVar7.b()) {
                t0 c4 = dVar7.c(dVar7.f528c);
                t0 c5 = dVar7.c(dVar7.e);
                if (c4 != null && c5 != null && c4 != c5) {
                    StringBuilder g = c.a.a.a.a.g("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    g.append(dVar7.a.f622c);
                    g.append(" returned Transition ");
                    g.append(dVar7.f528c);
                    g.append(" which uses a different Transition  type than its shared element transition ");
                    g.append(dVar7.e);
                    throw new IllegalArgumentException(g.toString());
                }
                if (c4 == null) {
                    c4 = c5;
                }
                if (t0Var2 == null) {
                    t0Var2 = c4;
                } else if (c4 != null && t0Var2 != c4) {
                    StringBuilder g2 = c.a.a.a.a.g("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    g2.append(dVar7.a.f622c);
                    g2.append(" returned Transition ");
                    g2.append(dVar7.f528c);
                    g2.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(g2.toString());
                }
            }
        }
        if (t0Var2 == null) {
            Iterator it4 = arrayList12.iterator();
            while (it4.hasNext()) {
                d dVar8 = (d) it4.next();
                hashMap3.put(dVar8.a, Boolean.FALSE);
                dVar8.a();
            }
            cVar = cVar5;
            arrayList = arrayList11;
            arrayList2 = arrayList13;
            hashMap = hashMap3;
            str = "FragmentManager";
        } else {
            View view5 = new View(this.a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList14 = new ArrayList<>();
            ArrayList<View> arrayList15 = new ArrayList<>();
            arrayList = arrayList11;
            b.e.a aVar4 = new b.e.a();
            Iterator it5 = arrayList12.iterator();
            Rect rect3 = rect2;
            Object obj3 = null;
            View view6 = null;
            boolean z3 = false;
            View view7 = view5;
            String str5 = "FragmentManager";
            y0.d dVar9 = dVar4;
            y0.d dVar10 = dVar5;
            while (it5.hasNext()) {
                y0.d.c cVar7 = cVar6;
                Object obj4 = ((d) it5.next()).e;
                if (!(obj4 != null) || dVar9 == null || dVar10 == null) {
                    arrayList3 = arrayList14;
                    cVar4 = cVar5;
                    aVar = aVar4;
                    arrayList4 = arrayList12;
                    arrayList5 = arrayList13;
                    hashMap2 = hashMap3;
                    str3 = str5;
                    arrayList6 = arrayList15;
                    dVar3 = dVar5;
                    view3 = view7;
                    t0Var = t0Var2;
                    rect = rect3;
                } else {
                    Object y = t0Var2.y(t0Var2.g(obj4));
                    m.b bVar = dVar10.f622c.I;
                    if (bVar == null || (arrayList7 = bVar.i) == null) {
                        arrayList7 = new ArrayList<>();
                    }
                    t0 t0Var3 = t0Var2;
                    m.b bVar2 = dVar9.f622c.I;
                    if (bVar2 == null || (arrayList8 = bVar2.i) == null) {
                        arrayList8 = new ArrayList<>();
                    }
                    arrayList5 = arrayList13;
                    m.b bVar3 = dVar9.f622c.I;
                    if (bVar3 == null || (arrayList9 = bVar3.j) == null) {
                        arrayList9 = new ArrayList<>();
                    }
                    cVar4 = cVar5;
                    arrayList4 = arrayList12;
                    int i = 0;
                    while (i < arrayList9.size()) {
                        int indexOf = arrayList7.indexOf(arrayList9.get(i));
                        ArrayList<String> arrayList16 = arrayList9;
                        if (indexOf != -1) {
                            arrayList7.set(indexOf, arrayList8.get(i));
                        }
                        i++;
                        arrayList9 = arrayList16;
                    }
                    m.b bVar4 = dVar10.f622c.I;
                    if (bVar4 == null || (arrayList10 = bVar4.j) == null) {
                        arrayList10 = new ArrayList<>();
                    }
                    ArrayList<String> arrayList17 = arrayList10;
                    if (!z2) {
                        dVar9.f622c.p();
                        dVar10.f622c.m();
                    } else {
                        dVar9.f622c.m();
                        dVar10.f622c.p();
                    }
                    int i2 = 0;
                    for (int size = arrayList7.size(); i2 < size; size = size) {
                        aVar4.put(arrayList7.get(i2), arrayList17.get(i2));
                        i2++;
                    }
                    b.e.a<String, View> aVar5 = new b.e.a<>();
                    k(aVar5, dVar9.f622c.F);
                    b.e.e.k(aVar5, arrayList7);
                    b.e.e.k(aVar4, aVar5.keySet());
                    b.e.a<String, View> aVar6 = new b.e.a<>();
                    k(aVar6, dVar10.f622c.F);
                    b.e.e.k(aVar6, arrayList17);
                    b.e.e.k(aVar6, aVar4.values());
                    r0.m(aVar4, aVar6);
                    l(aVar5, aVar4.keySet());
                    l(aVar6, aVar4.values());
                    if (aVar4.isEmpty()) {
                        arrayList14.clear();
                        arrayList15.clear();
                        obj3 = null;
                        rect = rect3;
                        arrayList3 = arrayList14;
                        aVar = aVar4;
                        hashMap2 = hashMap3;
                        str3 = str5;
                        arrayList6 = arrayList15;
                        dVar3 = dVar5;
                        view3 = view7;
                        t0Var = t0Var3;
                    } else {
                        r0.c(dVar10.f622c, dVar9.f622c, z2, aVar5, true);
                        arrayList3 = arrayList14;
                        aVar = aVar4;
                        Rect rect4 = rect3;
                        ArrayList<String> arrayList18 = arrayList7;
                        y0.d dVar11 = dVar5;
                        y0.d dVar12 = dVar5;
                        HashMap hashMap4 = hashMap3;
                        View view8 = view7;
                        arrayList6 = arrayList15;
                        y0.d dVar13 = dVar4;
                        str3 = str5;
                        t0Var = t0Var3;
                        b.h.j.o.a(this.a, new h(this, dVar11, dVar4, z, aVar6));
                        Iterator it6 = ((e.C0012e) aVar5.values()).iterator();
                        while (true) {
                            e.a aVar7 = (e.a) it6;
                            if (!aVar7.hasNext()) {
                                break;
                            }
                            j(arrayList3, (View) aVar7.next());
                        }
                        if (!arrayList18.isEmpty()) {
                            View view9 = aVar5.get(arrayList18.get(0));
                            t0Var.t(y, view9);
                            view6 = view9;
                        }
                        Iterator it7 = ((e.C0012e) aVar6.values()).iterator();
                        while (true) {
                            e.a aVar8 = (e.a) it7;
                            if (!aVar8.hasNext()) {
                                break;
                            }
                            j(arrayList6, (View) aVar8.next());
                        }
                        if (arrayList17.isEmpty() || (view4 = aVar6.get(arrayList17.get(0))) == null) {
                            rect = rect4;
                            view3 = view8;
                        } else {
                            rect = rect4;
                            b.h.j.o.a(this.a, new i(this, t0Var, view4, rect));
                            view3 = view8;
                            z3 = true;
                        }
                        t0Var.w(y, view3, arrayList3);
                        t0Var.r(y, null, null, null, null, y, arrayList6);
                        Boolean bool = Boolean.TRUE;
                        hashMap2 = hashMap4;
                        dVar4 = dVar13;
                        hashMap2.put(dVar4, bool);
                        dVar3 = dVar12;
                        hashMap2.put(dVar3, bool);
                        obj3 = y;
                        dVar9 = dVar4;
                        dVar10 = dVar3;
                    }
                }
                view7 = view3;
                rect3 = rect;
                arrayList14 = arrayList3;
                t0Var2 = t0Var;
                dVar5 = dVar3;
                arrayList15 = arrayList6;
                cVar6 = cVar7;
                arrayList13 = arrayList5;
                arrayList12 = arrayList4;
                aVar4 = aVar;
                str5 = str3;
                z2 = z;
                hashMap3 = hashMap2;
                cVar5 = cVar4;
            }
            ArrayList<View> arrayList19 = arrayList14;
            y0.d.c cVar8 = cVar5;
            y0.d.c cVar9 = cVar6;
            b.e.a aVar9 = aVar4;
            ArrayList arrayList20 = arrayList12;
            arrayList2 = arrayList13;
            hashMap = hashMap3;
            String str6 = str5;
            ArrayList<View> arrayList21 = arrayList15;
            y0.d dVar14 = dVar5;
            View view10 = view7;
            t0 t0Var4 = t0Var2;
            Rect rect5 = rect3;
            ArrayList arrayList22 = new ArrayList();
            Iterator it8 = arrayList20.iterator();
            Object obj5 = null;
            Object obj6 = null;
            while (it8.hasNext()) {
                d dVar15 = (d) it8.next();
                if (dVar15.b()) {
                    it = it8;
                    dVar = dVar14;
                    hashMap.put(dVar15.a, Boolean.FALSE);
                    dVar15.a();
                    view = view10;
                    obj = obj3;
                    dVar2 = dVar10;
                    obj2 = obj5;
                    view2 = view6;
                    cVar3 = cVar9;
                    cVar2 = cVar8;
                } else {
                    it = it8;
                    dVar = dVar14;
                    Object g3 = t0Var4.g(dVar15.f528c);
                    y0.d dVar16 = dVar15.a;
                    boolean z4 = obj3 != null && (dVar16 == dVar9 || dVar16 == dVar10);
                    if (g3 == null) {
                        if (!z4) {
                            hashMap.put(dVar16, Boolean.FALSE);
                            dVar15.a();
                        }
                        view = view10;
                        obj = obj3;
                        m = obj5;
                        view2 = view6;
                        cVar3 = cVar9;
                        cVar2 = cVar8;
                    } else {
                        obj = obj3;
                        ArrayList<View> arrayList23 = new ArrayList<>();
                        Object obj7 = obj5;
                        j(arrayList23, dVar16.f622c.F);
                        if (z4) {
                            if (dVar16 == dVar9) {
                                arrayList23.removeAll(arrayList19);
                            } else {
                                arrayList23.removeAll(arrayList21);
                            }
                        }
                        if (arrayList23.isEmpty()) {
                            t0Var4.a(g3, view10);
                            view = view10;
                            cVar2 = cVar8;
                        } else {
                            t0Var4.b(g3, arrayList23);
                            t0Var4.r(g3, g3, arrayList23, null, null, null, null);
                            cVar2 = cVar8;
                            if (dVar16.a == cVar2) {
                                arrayList2.remove(dVar16);
                                view = view10;
                                t0Var4.q(g3, dVar16.f622c.F, arrayList23);
                                b.h.j.o.a(this.a, new j(this, arrayList23));
                            } else {
                                view = view10;
                            }
                        }
                        cVar3 = cVar9;
                        if (dVar16.a == cVar3) {
                            arrayList22.addAll(arrayList23);
                            if (z3) {
                                t0Var4.s(g3, rect5);
                            }
                            view2 = view6;
                        } else {
                            view2 = view6;
                            t0Var4.t(g3, view2);
                        }
                        hashMap.put(dVar16, Boolean.TRUE);
                        if (dVar15.d) {
                            obj6 = t0Var4.m(obj6, g3, null);
                            m = obj7;
                        } else {
                            m = t0Var4.m(obj7, g3, null);
                        }
                    }
                    obj2 = m;
                    dVar2 = dVar;
                }
                view6 = view2;
                cVar9 = cVar3;
                cVar8 = cVar2;
                view10 = view;
                dVar14 = dVar;
                dVar10 = dVar2;
                obj5 = obj2;
                obj3 = obj;
                it8 = it;
            }
            y0.d dVar17 = dVar14;
            Object obj8 = obj5;
            cVar = cVar8;
            Object l = t0Var4.l(obj6, obj8, obj3);
            Iterator it9 = arrayList20.iterator();
            while (it9.hasNext()) {
                d dVar18 = (d) it9.next();
                if (!dVar18.b()) {
                    Object obj9 = dVar18.f528c;
                    y0.d dVar19 = dVar18.a;
                    y0.d dVar20 = dVar17;
                    boolean z5 = obj3 != null && (dVar19 == dVar9 || dVar19 == dVar20);
                    if (obj9 == null && !z5) {
                        str2 = str6;
                    } else if (!b.h.j.q.u(this.a)) {
                        if (c0.M(2)) {
                            StringBuilder g4 = c.a.a.a.a.g("SpecialEffectsController: Container ");
                            g4.append(this.a);
                            g4.append(" has not been laid out. Completing operation ");
                            g4.append(dVar19);
                            str2 = str6;
                            Log.v(str2, g4.toString());
                        } else {
                            str2 = str6;
                        }
                        dVar18.a();
                    } else {
                        t0Var4.u(dVar18.a.f622c, l, dVar18.f527b, new k(this, dVar18));
                        dVar9 = dVar9;
                        dVar17 = dVar20;
                    }
                    str6 = str2;
                    dVar17 = dVar20;
                }
            }
            str = str6;
            if (b.h.j.q.u(this.a)) {
                r0.o(arrayList22, 4);
                ArrayList<String> n = t0Var4.n(arrayList21);
                t0Var4.c(this.a, l);
                t0Var4.v(this.a, arrayList19, arrayList21, n, aVar9);
                r0.o(arrayList22, 0);
                t0Var4.x(obj3, arrayList19, arrayList21);
            }
        }
        boolean containsValue = hashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.a;
        Context context = viewGroup.getContext();
        ArrayList arrayList24 = new ArrayList();
        Iterator it10 = arrayList.iterator();
        boolean z6 = false;
        while (it10.hasNext()) {
            b bVar5 = (b) it10.next();
            if (!bVar5.b() && (c2 = bVar5.c(context)) != null) {
                Animator animator = c2.f600b;
                if (animator == null) {
                    arrayList24.add(bVar5);
                } else {
                    y0.d dVar21 = bVar5.a;
                    m mVar = dVar21.f622c;
                    if (!Boolean.TRUE.equals(hashMap.get(dVar21))) {
                        boolean z7 = dVar21.a == cVar;
                        ArrayList arrayList25 = arrayList2;
                        if (z7) {
                            arrayList25.remove(dVar21);
                        }
                        View view11 = mVar.F;
                        viewGroup.startViewTransition(view11);
                        animator.addListener(new b.k.b.d(this, viewGroup, view11, z7, dVar21, bVar5));
                        animator.setTarget(view11);
                        animator.start();
                        bVar5.f527b.b(new e(this, animator));
                        z6 = true;
                        arrayList2 = arrayList25;
                        cVar = cVar;
                        hashMap = hashMap;
                    } else if (c0.M(2)) {
                        Log.v(str, "Ignoring Animator set on " + mVar + " as this Fragment was involved in a Transition.");
                    }
                }
            }
            bVar5.a();
        }
        ArrayList arrayList26 = arrayList2;
        Iterator it11 = arrayList24.iterator();
        while (it11.hasNext()) {
            b bVar6 = (b) it11.next();
            y0.d dVar22 = bVar6.a;
            m mVar2 = dVar22.f622c;
            if (containsValue) {
                if (c0.M(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(mVar2);
                    str4 = " as Animations cannot run alongside Transitions.";
                    sb.append(str4);
                    Log.v(str, sb.toString());
                }
                bVar6.a();
            } else if (z6) {
                if (c0.M(2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(mVar2);
                    str4 = " as Animations cannot run alongside Animators.";
                    sb.append(str4);
                    Log.v(str, sb.toString());
                }
                bVar6.a();
            } else {
                View view12 = mVar2.F;
                t c6 = bVar6.c(context);
                c6.getClass();
                Animation animation = c6.a;
                animation.getClass();
                if (dVar22.a != y0.d.c.REMOVED) {
                    view12.startAnimation(animation);
                    bVar6.a();
                } else {
                    viewGroup.startViewTransition(view12);
                    u uVar = new u(animation, viewGroup, view12);
                    uVar.setAnimationListener(new f(this, viewGroup, view12, bVar6));
                    view12.startAnimation(uVar);
                }
                bVar6.f527b.b(new g(this, view12, viewGroup, bVar6));
            }
        }
        Iterator it12 = arrayList26.iterator();
        while (it12.hasNext()) {
            y0.d dVar23 = (y0.d) it12.next();
            dVar23.a.a(dVar23.f622c.F);
        }
        arrayList26.clear();
    }

    public void j(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        if (!arrayList.contains(view) && b.h.j.q.s(view) != null) {
            arrayList.add(view);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                j(arrayList, childAt);
            }
        }
    }

    public void k(Map<String, View> map, View view) {
        String s = b.h.j.q.s(view);
        if (s != null) {
            map.put(s, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    k(map, childAt);
                }
            }
        }
    }

    public void l(b.e.a<String, View> aVar, Collection<String> collection) {
        Iterator it = ((e.b) aVar.entrySet()).iterator();
        while (true) {
            e.d dVar = (e.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                if (!collection.contains(b.h.j.q.s((View) dVar.getValue()))) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
