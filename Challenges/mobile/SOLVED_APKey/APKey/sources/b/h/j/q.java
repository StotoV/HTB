package b.h.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.h.j.a;
import b.h.j.b0;
import b.h.j.c0.b;
import com.example.apkey.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class q {

    /* renamed from: b  reason: collision with root package name */
    public static WeakHashMap<View, String> f489b;
    public static Field d;
    public static ThreadLocal<Rect> f;
    public static final AtomicInteger a = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    public static WeakHashMap<View, x> f490c = null;
    public static boolean e = false;
    public static final int[] g = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final n h = new a();

    /* loaded from: classes.dex */
    public class a implements n {
        @Override // b.h.j.n
        public b.h.j.c a(b.h.j.c cVar) {
            return cVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<T> {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f491b;

        /* renamed from: c  reason: collision with root package name */
        public final int f492c;
        public final int d;

        public b(int i, Class<T> cls, int i2) {
            this.a = i;
            this.f491b = cls;
            this.d = 0;
            this.f492c = i2;
        }

        public b(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.f491b = cls;
            this.d = i2;
            this.f492c = i3;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public abstract T b(View view);

        public T c(View view) {
            int i = Build.VERSION.SDK_INT;
            boolean z = false;
            if (i >= this.f492c) {
                return b(view);
            }
            if (i >= 19) {
                z = true;
            }
            if (!z) {
                return null;
            }
            T t = (T) view.getTag(this.a);
            if (!this.f491b.isInstance(t)) {
                return null;
            }
            return t;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public static class d {
        public static final ArrayList<WeakReference<View>> d = new ArrayList<>();
        public WeakHashMap<View, Boolean> a = null;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<WeakReference<View>> f493b = null;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<KeyEvent> f494c = null;

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a != null) {
                            return a;
                        }
                    }
                }
                if (b(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((c) arrayList.get(size)).a(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    static {
        new WeakHashMap();
    }

    public static void A(View view, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            B(i, view);
            v(view, 0);
        }
    }

    public static void B(int i, View view) {
        List<b.a> k = k(view);
        for (int i2 = 0; i2 < k.size(); i2++) {
            if (k.get(i2).a() == i) {
                k.remove(i2);
                return;
            }
        }
    }

    public static void C(View view, b.a aVar, CharSequence charSequence, b.h.j.c0.d dVar) {
        a(view, new b.a(null, aVar.f478b, null, dVar, aVar.f479c));
    }

    public static void D(View view) {
        if (Build.VERSION.SDK_INT >= 20) {
            view.requestApplyInsets();
        } else {
            view.requestFitSystemWindows();
        }
    }

    public static void E(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void F(View view, b.h.j.a aVar) {
        if (aVar == null && (i(view) instanceof a.C0018a)) {
            aVar = new b.h.j.a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.f461b);
    }

    public static void G(View view, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setAccessibilityLiveRegion(i);
        }
    }

    public static void H(View view, Rect rect) {
        if (Build.VERSION.SDK_INT >= 18) {
            view.setClipBounds(rect);
        }
    }

    public static void I(View view, int i) {
        if (Build.VERSION.SDK_INT < 19 && i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public static void J(View view, l lVar) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, lVar);
            }
            if (lVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new v(view, lVar));
            }
        }
    }

    public static void K(View view, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            view.setPaddingRelative(i, i2, i3, i4);
        } else {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public static void L(View view, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            view.setTransitionName(str);
            return;
        }
        if (f489b == null) {
            f489b = new WeakHashMap<>();
        }
        f489b.put(view, str);
    }

    public static void M(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public static void a(View view, b.a aVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.h.j.a h2 = h(view);
            if (h2 == null) {
                h2 = new b.h.j.a();
            }
            F(view, h2);
            B(aVar.a(), view);
            k(view).add(aVar);
            v(view, 0);
        }
    }

    public static x b(View view) {
        if (f490c == null) {
            f490c = new WeakHashMap<>();
        }
        x xVar = f490c.get(view);
        if (xVar == null) {
            x xVar2 = new x(view);
            f490c.put(view, xVar2);
            return xVar2;
        }
        return xVar;
    }

    public static void c(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            M((View) parent);
        }
    }

    public static void d(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            M((View) parent);
        }
    }

    public static b0 e(View view, b0 b0Var) {
        WindowInsets g2;
        if (Build.VERSION.SDK_INT >= 21 && (g2 = b0Var.g()) != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(g2);
            if (!dispatchApplyWindowInsets.equals(g2)) {
                return b0.i(dispatchApplyWindowInsets, view);
            }
        }
        return b0Var;
    }

    public static boolean f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = d.d;
        d dVar = (d) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (dVar == null) {
            dVar = new d();
            view.setTag(R.id.tag_unhandled_key_event_manager, dVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = dVar.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = d.d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (dVar.a == null) {
                        dVar.a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = d.d;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            dVar.a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                dVar.a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a2 = dVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (dVar.f493b == null) {
                    dVar.f493b = new SparseArray<>();
                }
                dVar.f493b.put(keyCode, new WeakReference<>(a2));
            }
        }
        return a2 != null;
    }

    public static int g() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = a;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static b.h.j.a h(View view) {
        View.AccessibilityDelegate i = i(view);
        if (i == null) {
            return null;
        }
        return i instanceof a.C0018a ? ((a.C0018a) i).a : new b.h.j.a(i);
    }

    public static View.AccessibilityDelegate i(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (e) {
            return null;
        }
        if (d == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                d = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                e = true;
                return null;
            }
        }
        Object obj = d.get(view);
        if (!(obj instanceof View.AccessibilityDelegate)) {
            return null;
        }
        return (View.AccessibilityDelegate) obj;
    }

    public static CharSequence j(View view) {
        return new s(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).c(view);
    }

    public static List<b.a> k(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(R.id.tag_accessibility_actions, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    public static ColorStateList l(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getBackgroundTintList();
        }
        if (!(view instanceof p)) {
            return null;
        }
        return ((p) view).getSupportBackgroundTintList();
    }

    public static float m(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getElevation();
        }
        return 0.0f;
    }

    public static Rect n() {
        if (f == null) {
            f = new ThreadLocal<>();
        }
        Rect rect = f.get();
        if (rect == null) {
            rect = new Rect();
            f.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }

    public static int p(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingEnd() : view.getPaddingRight();
    }

    public static int q(View view) {
        return Build.VERSION.SDK_INT >= 17 ? view.getPaddingStart() : view.getPaddingLeft();
    }

    public static b0 r(View view) {
        b0.e cVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            b0 h2 = b0.h(rootWindowInsets);
            h2.a.m(h2);
            h2.a.d(view.getRootView());
            return h2;
        } else if (i < 21 || !b0.a.d || !view.isAttachedToWindow()) {
            return null;
        } else {
            try {
                Object obj = b0.a.a.get(view.getRootView());
                if (obj == null) {
                    return null;
                }
                Rect rect = (Rect) b0.a.f463b.get(obj);
                Rect rect2 = (Rect) b0.a.f464c.get(obj);
                if (rect == null || rect2 == null) {
                    return null;
                }
                if (i >= 30) {
                    cVar = new b0.d();
                } else {
                    cVar = i >= 29 ? new b0.c() : i >= 20 ? new b0.b() : new b0.e();
                }
                cVar.b(b.h.d.b.a(rect.left, rect.top, rect.right, rect.bottom));
                cVar.c(b.h.d.b.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
                b0 a2 = cVar.a();
                a2.a.m(a2);
                a2.a.d(view.getRootView());
                return a2;
            } catch (IllegalAccessException e2) {
                StringBuilder g2 = c.a.a.a.a.g("Failed to get insets from AttachInfo. ");
                g2.append(e2.getMessage());
                Log.w("WindowInsetsCompat", g2.toString(), e2);
                return null;
            }
        }
    }

    public static String s(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getTransitionName();
        }
        WeakHashMap<View, String> weakHashMap = f489b;
        if (weakHashMap != null) {
            return weakHashMap.get(view);
        }
        return null;
    }

    public static boolean t(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isAttachedToWindow() : view.getWindowToken() != null;
    }

    public static boolean u(View view) {
        return Build.VERSION.SDK_INT >= 19 ? view.isLaidOut() : view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static void v(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (!accessibilityManager.isEnabled()) {
            return;
        }
        int i2 = 0;
        boolean z = j(view) != null && view.getVisibility() == 0;
        if (Build.VERSION.SDK_INT >= 19) {
            i2 = view.getAccessibilityLiveRegion();
        }
        int i3 = 32;
        if (i2 != 0 || z) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            if (!z) {
                i3 = 2048;
            }
            obtain.setEventType(i3);
            obtain.setContentChangeTypes(i);
            if (z) {
                obtain.getText().add(j(view));
                if (view.getImportantForAccessibility() == 0) {
                    I(view, 1);
                }
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (((View) parent).getImportantForAccessibility() == 4) {
                        I(view, 2);
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            view.sendAccessibilityEventUnchecked(obtain);
        } else if (i == 32) {
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            obtain2.setContentChangeTypes(i);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            obtain2.getText().add(j(view));
            accessibilityManager.sendAccessibilityEvent(obtain2);
        } else if (view.getParent() == null) {
        } else {
            try {
                view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
            } catch (AbstractMethodError e2) {
                Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
            }
        }
    }

    public static void w(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetLeftAndRight(i);
        } else if (i2 < 21) {
            c(view, i);
        } else {
            Rect n = n();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                n.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !n.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            c(view, i);
            if (!z || !n.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                return;
            }
            ((View) parent).invalidate(n);
        }
    }

    public static void x(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            view.offsetTopAndBottom(i);
        } else if (i2 < 21) {
            d(view, i);
        } else {
            Rect n = n();
            boolean z = false;
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                n.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !n.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            d(view, i);
            if (!z || !n.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                return;
            }
            ((View) parent).invalidate(n);
        }
    }

    public static b0 y(View view, b0 b0Var) {
        WindowInsets g2;
        if (Build.VERSION.SDK_INT >= 21 && (g2 = b0Var.g()) != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(g2);
            if (!onApplyWindowInsets.equals(g2)) {
                return b0.i(onApplyWindowInsets, view);
            }
        }
        return b0Var;
    }

    public static b.h.j.c z(View view, b.h.j.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        m mVar = (m) view.getTag(R.id.tag_on_receive_content_listener);
        if (mVar == null) {
            return (view instanceof n ? (n) view : h).a(cVar);
        }
        b.h.j.c a2 = mVar.a(view, cVar);
        if (a2 == null) {
            return null;
        }
        return (view instanceof n ? (n) view : h).a(a2);
    }
}
