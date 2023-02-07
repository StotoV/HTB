package b.j.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import b.e.g;
import b.h.j.q;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class a extends b.h.j.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b.j.b.b<b.h.j.c0.b> o = new C0024a();
    public static final b.j.b.c<g<b.h.j.c0.b>, b.h.j.c0.b> p = new b();
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    /* renamed from: b.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0024a implements b.j.b.b<b.h.j.c0.b> {
        public void a(Object obj, Rect rect) {
            ((b.h.j.c0.b) obj).a.getBoundsInParent(rect);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements b.j.b.c<g<b.h.j.c0.b>, b.h.j.c0.b> {
    }

    /* loaded from: classes.dex */
    public class c extends b.h.j.c0.c {
        public c() {
        }

        @Override // b.h.j.c0.c
        public b.h.j.c0.b a(int i) {
            return new b.h.j.c0.b(AccessibilityNodeInfo.obtain(a.this.q(i).a));
        }

        @Override // b.h.j.c0.c
        public b.h.j.c0.b b(int i) {
            int i2 = i == 2 ? a.this.k : a.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new b.h.j.c0.b(AccessibilityNodeInfo.obtain(a.this.q(i2).a));
        }

        @Override // b.h.j.c0.c
        public boolean c(int i, int i2, Bundle bundle) {
            int i3;
            a aVar = a.this;
            if (i == -1) {
                View view = aVar.i;
                AtomicInteger atomicInteger = q.a;
                return view.performAccessibilityAction(i2, bundle);
            }
            boolean z = true;
            if (i2 == 1) {
                return aVar.v(i);
            }
            if (i2 == 2) {
                return aVar.k(i);
            }
            if (i2 != 64) {
                return i2 != 128 ? aVar.r(i, i2, bundle) : aVar.j(i);
            }
            if (!aVar.h.isEnabled() || !aVar.h.isTouchExplorationEnabled() || (i3 = aVar.k) == i) {
                z = false;
            } else {
                if (i3 != Integer.MIN_VALUE) {
                    aVar.j(i3);
                }
                aVar.k = i;
                aVar.i.invalidate();
                aVar.w(i, 32768);
            }
            return z;
        }
    }

    public a(View view) {
        if (view != null) {
            this.i = view;
            this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            AtomicInteger atomicInteger = q.a;
            if (view.getImportantForAccessibility() != 0) {
                return;
            }
            q.I(view, 1);
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // b.h.j.a
    public b.h.j.c0.c b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // b.h.j.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // b.h.j.a
    public void d(View view, b.h.j.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        s(bVar);
    }

    public final boolean j(int i) {
        if (this.k == i) {
            this.k = Integer.MIN_VALUE;
            this.i.invalidate();
            w(i, 65536);
            return true;
        }
        return false;
    }

    public final boolean k(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        u(i, false);
        w(i, 8);
        return true;
    }

    public final b.h.j.c0.b l(int i) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        b.h.j.c0.b bVar = new b.h.j.c0.b(obtain);
        obtain.setEnabled(true);
        bVar.a.setFocusable(true);
        bVar.a.setClassName("android.view.View");
        Rect rect = n;
        bVar.a.setBoundsInParent(rect);
        bVar.a.setBoundsInScreen(rect);
        View view = this.i;
        bVar.f476b = -1;
        bVar.a.setParent(view);
        t(i, bVar);
        if (bVar.g() == null && bVar.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVar.a.getBoundsInParent(this.e);
        if (this.e.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = bVar.a.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        int i2 = 128;
        if ((actions & 128) == 0) {
            bVar.a.setPackageName(this.i.getContext().getPackageName());
            View view2 = this.i;
            bVar.f477c = i;
            bVar.a.setSource(view2, i);
            boolean z = false;
            if (this.k == i) {
                bVar.a.setAccessibilityFocused(true);
                accessibilityNodeInfo = bVar.a;
            } else {
                bVar.a.setAccessibilityFocused(false);
                accessibilityNodeInfo = bVar.a;
                i2 = 64;
            }
            accessibilityNodeInfo.addAction(i2);
            boolean z2 = this.l == i;
            if (z2) {
                bVar.a.addAction(2);
            } else if (bVar.a.isFocusable()) {
                bVar.a.addAction(1);
            }
            bVar.a.setFocused(z2);
            this.i.getLocationOnScreen(this.g);
            bVar.a.getBoundsInScreen(this.d);
            if (this.d.equals(rect)) {
                bVar.a.getBoundsInParent(this.d);
                if (bVar.f476b != -1) {
                    b.h.j.c0.b bVar2 = new b.h.j.c0.b(AccessibilityNodeInfo.obtain());
                    for (int i3 = bVar.f476b; i3 != -1; i3 = bVar2.f476b) {
                        View view3 = this.i;
                        bVar2.f476b = -1;
                        bVar2.a.setParent(view3, -1);
                        bVar2.a.setBoundsInParent(n);
                        t(i3, bVar2);
                        bVar2.a.getBoundsInParent(this.e);
                        Rect rect2 = this.d;
                        Rect rect3 = this.e;
                        rect2.offset(rect3.left, rect3.top);
                    }
                    bVar2.a.recycle();
                }
                this.d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            }
            if (this.i.getLocalVisibleRect(this.f)) {
                this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                if (this.d.intersect(this.f)) {
                    bVar.a.setBoundsInScreen(this.d);
                    Rect rect4 = this.d;
                    if (rect4 != null && !rect4.isEmpty() && this.i.getWindowVisibility() == 0) {
                        View view4 = this.i;
                        while (true) {
                            ViewParent parent = view4.getParent();
                            if (parent instanceof View) {
                                view4 = (View) parent;
                                if (view4.getAlpha() <= 0.0f) {
                                    break;
                                } else if (view4.getVisibility() != 0) {
                                    break;
                                }
                            } else if (parent != null) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        bVar.a.setVisibleToUser(true);
                    }
                }
            }
            return bVar;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }

    public final boolean m(MotionEvent motionEvent) {
        int i;
        if (this.h.isEnabled() && this.h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || (i = this.m) == Integer.MIN_VALUE) {
                    return false;
                }
                if (i != Integer.MIN_VALUE) {
                    this.m = Integer.MIN_VALUE;
                    w(Integer.MIN_VALUE, 128);
                    w(i, 256);
                }
                return true;
            }
            int n2 = n(motionEvent.getX(), motionEvent.getY());
            int i2 = this.m;
            if (i2 != n2) {
                this.m = n2;
                w(n2, 128);
                w(i2, 256);
            }
            if (n2 != Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }

    public abstract int n(float f, float f2);

    public abstract void o(List<Integer> list);

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0129, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L44;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(int r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instructions count: 451
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.j.b.a.p(int, android.graphics.Rect):boolean");
    }

    public b.h.j.c0.b q(int i) {
        if (i == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.i);
            b.h.j.c0.b bVar = new b.h.j.c0.b(obtain);
            View view = this.i;
            AtomicInteger atomicInteger = q.a;
            view.onInitializeAccessibilityNodeInfo(obtain);
            ArrayList arrayList = new ArrayList();
            o(arrayList);
            if (bVar.a.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                bVar.a.addChild(this.i, ((Integer) arrayList.get(i2)).intValue());
            }
            return bVar;
        }
        return l(i);
    }

    public abstract boolean r(int i, int i2, Bundle bundle);

    public void s(b.h.j.c0.b bVar) {
    }

    public abstract void t(int i, b.h.j.c0.b bVar);

    public void u(int i, boolean z) {
    }

    public final boolean v(int i) {
        int i2;
        if ((this.i.isFocused() || this.i.requestFocus()) && (i2 = this.l) != i) {
            if (i2 != Integer.MIN_VALUE) {
                k(i2);
            }
            this.l = i;
            u(i, true);
            w(i, 8);
            return true;
        }
        return false;
    }

    public final boolean w(int i, int i2) {
        ViewParent parent;
        AccessibilityEvent obtain;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        if (i != -1) {
            obtain = AccessibilityEvent.obtain(i2);
            b.h.j.c0.b q = q(i);
            obtain.getText().add(q.g());
            obtain.setContentDescription(q.e());
            obtain.setScrollable(q.a.isScrollable());
            obtain.setPassword(q.a.isPassword());
            obtain.setEnabled(q.a.isEnabled());
            obtain.setChecked(q.a.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(q.a.getClassName());
            obtain.setSource(this.i, i);
            obtain.setPackageName(this.i.getContext().getPackageName());
        } else {
            obtain = AccessibilityEvent.obtain(i2);
            this.i.onInitializeAccessibilityEvent(obtain);
        }
        return parent.requestSendAccessibilityEvent(this.i, obtain);
    }

    public final void x(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        w(i, 128);
        w(i2, 256);
    }
}
