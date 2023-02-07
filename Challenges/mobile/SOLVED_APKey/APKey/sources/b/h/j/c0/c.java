package b.h.j.c0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public final Object a;

    /* loaded from: classes.dex */
    public static class a extends AccessibilityNodeProvider {
        public final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            b.h.j.c0.b a = this.a.a(i);
            if (a == null) {
                return null;
            }
            return a.a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            this.a.getClass();
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.a.c(i, i2, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public b(c cVar) {
            super(cVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            b.h.j.c0.b b2 = this.a.b(i);
            if (b2 == null) {
                return null;
            }
            return b2.a;
        }
    }

    /* renamed from: b.h.j.c0.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0020c extends b {
        public C0020c(c cVar) {
            super(cVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.a.getClass();
        }
    }

    public c() {
        int i = Build.VERSION.SDK_INT;
        this.a = i >= 26 ? new C0020c(this) : i >= 19 ? new b(this) : new a(this);
    }

    public c(Object obj) {
        this.a = obj;
    }

    public b.h.j.c0.b a(int i) {
        return null;
    }

    public b.h.j.c0.b b(int i) {
        return null;
    }

    public boolean c(int i, int i2, Bundle bundle) {
        return false;
    }
}
