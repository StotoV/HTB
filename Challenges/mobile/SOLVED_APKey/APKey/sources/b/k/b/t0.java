package b.k.b;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class t0 {

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f601b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ArrayList f602c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ ArrayList e;
        public final /* synthetic */ ArrayList f;

        public a(t0 t0Var, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f601b = i;
            this.f602c = arrayList;
            this.d = arrayList2;
            this.e = arrayList3;
            this.f = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f601b; i++) {
                b.h.j.q.L((View) this.f602c.get(i), (String) this.d.get(i));
                b.h.j.q.L((View) this.e.get(i), (String) this.f.get(i));
            }
        }
    }

    public static void d(List<View> list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (b.h.j.q.s(view) != null) {
            list.add(view);
        }
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!h(list, childAt, size) && b.h.j.q.s(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean h(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList<android.view.View>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View, android.view.ViewGroup] */
    public void f(ArrayList<View> arrayList, View view) {
        boolean z;
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                view = (ViewGroup) view;
                if (Build.VERSION.SDK_INT >= 21) {
                    z = view.isTransitionGroup();
                } else {
                    Boolean bool = (Boolean) view.getTag(R.id.tag_transition_group);
                    z = ((bool == null || !bool.booleanValue()) && view.getBackground() == null && b.h.j.q.s(view) == null) ? false : true;
                }
                if (!z) {
                    int childCount = view.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        f(arrayList, view.getChildAt(i));
                    }
                    return;
                }
            }
            arrayList.add(view);
        }
    }

    public abstract Object g(Object obj);

    public void i(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String s = b.h.j.q.s(view);
            if (s != null) {
                map.put(s, view);
            }
            if (!(view instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                i(map, viewGroup.getChildAt(i));
            }
        }
    }

    public void j(View view, Rect rect) {
        if (!b.h.j.q.t(view)) {
            return;
        }
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getMatrix().mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            view2.getMatrix().mapRect(rectF);
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
        int[] iArr = new int[2];
        view.getRootView().getLocationOnScreen(iArr);
        rectF.offset(iArr[0], iArr[1]);
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public abstract Object l(Object obj, Object obj2, Object obj3);

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public ArrayList<String> n(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(b.h.j.q.s(view));
            b.h.j.q.L(view, null);
        }
        return arrayList2;
    }

    public abstract void o(Object obj, View view);

    public abstract void p(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void q(Object obj, View view, ArrayList<View> arrayList);

    public abstract void r(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void s(Object obj, Rect rect);

    public abstract void t(Object obj, View view);

    public void u(m mVar, Object obj, b.h.f.a aVar, Runnable runnable) {
        runnable.run();
    }

    public void v(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String s = b.h.j.q.s(view2);
            arrayList4.add(s);
            if (s != null) {
                b.h.j.q.L(view2, null);
                String str = (String) ((b.e.f) map).getOrDefault(s, null);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i2))) {
                        b.h.j.q.L(arrayList2.get(i2), s);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        b.h.j.o.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void w(Object obj, View view, ArrayList<View> arrayList);

    public abstract void x(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object y(Object obj);
}
