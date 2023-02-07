package b.k.b;

import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public class r0 {
    public static final int[] a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b  reason: collision with root package name */
    public static final t0 f591b;

    /* renamed from: c  reason: collision with root package name */
    public static final t0 f592c;

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static class b {
        public m a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f593b;

        /* renamed from: c  reason: collision with root package name */
        public b.k.b.a f594c;
        public m d;
        public boolean e;
        public b.k.b.a f;
    }

    static {
        t0 t0Var = null;
        f591b = Build.VERSION.SDK_INT >= 21 ? new s0() : null;
        try {
            t0Var = (t0) Class.forName("b.q.e").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
        }
        f592c = t0Var;
    }

    public static void a(ArrayList<View> arrayList, b.e.a<String, View> aVar, Collection<String> collection) {
        for (int i = aVar.d - 1; i >= 0; i--) {
            View k = aVar.k(i);
            if (collection.contains(b.h.j.q.s(k))) {
                arrayList.add(k);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0038, code lost:
        if (r0.l != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0074, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0084, code lost:
        if (r0.z != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0086, code lost:
        r9 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(b.k.b.a r8, b.k.b.k0.a r9, android.util.SparseArray<b.k.b.r0.b> r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.r0.b(b.k.b.a, b.k.b.k0$a, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(m mVar, m mVar2, boolean z, b.e.a<String, View> aVar, boolean z2) {
        if (z) {
            mVar2.m();
        } else {
            mVar.m();
        }
    }

    public static boolean d(t0 t0Var, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!t0Var.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static b.e.a<String, View> e(t0 t0Var, b.e.a<String, String> aVar, Object obj, b bVar) {
        ArrayList<String> arrayList;
        m mVar = bVar.a;
        View view = mVar.F;
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        b.e.a<String, View> aVar2 = new b.e.a<>();
        t0Var.i(aVar2, view);
        b.k.b.a aVar3 = bVar.f594c;
        if (bVar.f593b) {
            mVar.p();
            arrayList = aVar3.m;
        } else {
            mVar.m();
            arrayList = aVar3.n;
        }
        if (arrayList != null) {
            b.e.e.k(aVar2, arrayList);
            b.e.e.k(aVar2, aVar.values());
        }
        m(aVar, aVar2);
        return aVar2;
    }

    public static b.e.a<String, View> f(t0 t0Var, b.e.a<String, String> aVar, Object obj, b bVar) {
        ArrayList<String> arrayList;
        if (!aVar.isEmpty() && obj != null) {
            m mVar = bVar.d;
            b.e.a<String, View> aVar2 = new b.e.a<>();
            t0Var.i(aVar2, mVar.j0());
            b.k.b.a aVar3 = bVar.f;
            if (bVar.e) {
                mVar.m();
                arrayList = aVar3.n;
            } else {
                mVar.p();
                arrayList = aVar3.m;
            }
            if (arrayList != null) {
                b.e.e.k(aVar2, arrayList);
            }
            b.e.e.k(aVar, aVar2.keySet());
            return aVar2;
        }
        aVar.clear();
        return null;
    }

    public static t0 g(m mVar, m mVar2) {
        ArrayList arrayList = new ArrayList();
        if (mVar != null) {
            mVar.o();
            Object y = mVar.y();
            if (y != null) {
                arrayList.add(y);
            }
            Object A = mVar.A();
            if (A != null) {
                arrayList.add(A);
            }
        }
        if (mVar2 != null) {
            mVar2.l();
            Object w = mVar2.w();
            if (w != null) {
                arrayList.add(w);
            }
            mVar2.z();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        t0 t0Var = f591b;
        if (t0Var != null && d(t0Var, arrayList)) {
            return t0Var;
        }
        t0 t0Var2 = f592c;
        if (t0Var2 != null && d(t0Var2, arrayList)) {
            return t0Var2;
        }
        if (t0Var != null || t0Var2 != null) {
            throw new IllegalArgumentException("Invalid Transition types");
        }
        return null;
    }

    public static ArrayList<View> h(t0 t0Var, Object obj, m mVar, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View view2 = mVar.F;
            if (view2 != null) {
                t0Var.f(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            t0Var.b(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    public static Object i(t0 t0Var, m mVar, boolean z) {
        Object obj = null;
        if (mVar == null) {
            return null;
        }
        if (z) {
            obj = mVar.w();
        } else {
            mVar.l();
        }
        return t0Var.g(obj);
    }

    public static Object j(t0 t0Var, m mVar, boolean z) {
        Object obj = null;
        if (mVar == null) {
            return null;
        }
        if (z) {
            obj = mVar.y();
        } else {
            mVar.o();
        }
        return t0Var.g(obj);
    }

    public static View k(b.e.a<String, View> aVar, b bVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        b.k.b.a aVar2 = bVar.f594c;
        if (obj == null || aVar == null || (arrayList = aVar2.m) == null || arrayList.isEmpty()) {
            return null;
        }
        return aVar.get((z ? aVar2.m : aVar2.n).get(0));
    }

    public static Object l(t0 t0Var, m mVar, m mVar2, boolean z) {
        Object obj;
        if (z) {
            obj = mVar2.A();
        } else {
            mVar.z();
            obj = null;
        }
        return t0Var.y(t0Var.g(obj));
    }

    public static void m(b.e.a<String, String> aVar, b.e.a<String, View> aVar2) {
        int i = aVar.d;
        while (true) {
            i--;
            if (i >= 0) {
                if (!aVar2.containsKey(aVar.k(i))) {
                    aVar.i(i);
                }
            } else {
                return;
            }
        }
    }

    public static void n(t0 t0Var, Object obj, Object obj2, b.e.a<String, View> aVar, boolean z, b.k.b.a aVar2) {
        ArrayList<String> arrayList = aVar2.m;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = aVar.get((z ? aVar2.n : aVar2.m).get(0));
        t0Var.t(obj, view);
        if (obj2 == null) {
            return;
        }
        t0Var.t(obj2, view);
    }

    public static void o(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void p(android.content.Context r37, b.k.b.v r38, java.util.ArrayList<b.k.b.a> r39, java.util.ArrayList<java.lang.Boolean> r40, int r41, int r42, boolean r43, b.k.b.r0.a r44) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.r0.p(android.content.Context, b.k.b.v, java.util.ArrayList, java.util.ArrayList, int, int, boolean, b.k.b.r0$a):void");
    }
}
