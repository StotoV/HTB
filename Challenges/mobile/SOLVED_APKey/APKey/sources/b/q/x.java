package b.q;

import android.os.Build;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class x {
    public static boolean a = true;

    public static w a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new v(viewGroup) : (u) z.c(viewGroup);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.view.ViewGroup r8, boolean r9) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto Lb
            r8.suppressLayout(r9)
            goto Ld7
        Lb:
            r1 = 18
            r2 = 0
            if (r0 < r1) goto L1d
            boolean r0 = b.q.x.a
            if (r0 == 0) goto Ld7
            r8.suppressLayout(r9)     // Catch: java.lang.NoSuchMethodError -> L19
            goto Ld7
        L19:
            b.q.x.a = r2
            goto Ld7
        L1d:
            android.animation.LayoutTransition r0 = b.q.h.a
            r1 = 1
            r3 = 0
            if (r0 != 0) goto L44
            b.q.y r0 = new b.q.y
            r0.<init>()
            b.q.h.a = r0
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = b.q.h.a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = b.q.h.a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = b.q.h.a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = b.q.h.a
            r4 = 4
            r0.setAnimator(r4, r3)
        L44:
            r0 = 2131231124(0x7f080194, float:1.807832E38)
            java.lang.String r4 = "ViewGroupUtilsApi14"
            if (r9 == 0) goto L8f
            android.animation.LayoutTransition r9 = r8.getLayoutTransition()
            if (r9 == 0) goto L8c
            boolean r3 = r9.isRunning()
            if (r3 == 0) goto L85
            boolean r3 = b.q.h.e
            java.lang.String r5 = "Failed to access cancel method by reflection"
            if (r3 != 0) goto L72
            java.lang.Class<android.animation.LayoutTransition> r3 = android.animation.LayoutTransition.class
            java.lang.String r6 = "cancel"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L6d
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r6, r7)     // Catch: java.lang.NoSuchMethodException -> L6d
            b.q.h.d = r3     // Catch: java.lang.NoSuchMethodException -> L6d
            r3.setAccessible(r1)     // Catch: java.lang.NoSuchMethodException -> L6d
            goto L70
        L6d:
            android.util.Log.i(r4, r5)
        L70:
            b.q.h.e = r1
        L72:
            java.lang.reflect.Method r1 = b.q.h.d
            if (r1 == 0) goto L85
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L82
            r1.invoke(r9, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L7c java.lang.IllegalAccessException -> L82
            goto L85
        L7c:
            java.lang.String r1 = "Failed to invoke cancel method by reflection"
            android.util.Log.i(r4, r1)
            goto L85
        L82:
            android.util.Log.i(r4, r5)
        L85:
            android.animation.LayoutTransition r1 = b.q.h.a
            if (r9 == r1) goto L8c
            r8.setTag(r0, r9)
        L8c:
            android.animation.LayoutTransition r9 = b.q.h.a
            goto Ld4
        L8f:
            r8.setLayoutTransition(r3)
            boolean r9 = b.q.h.f712c
            if (r9 != 0) goto Lab
            java.lang.Class<android.view.ViewGroup> r9 = android.view.ViewGroup.class
            java.lang.String r5 = "mLayoutSuppressed"
            java.lang.reflect.Field r9 = r9.getDeclaredField(r5)     // Catch: java.lang.NoSuchFieldException -> La4
            b.q.h.f711b = r9     // Catch: java.lang.NoSuchFieldException -> La4
            r9.setAccessible(r1)     // Catch: java.lang.NoSuchFieldException -> La4
            goto La9
        La4:
            java.lang.String r9 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r4, r9)
        La9:
            b.q.h.f712c = r1
        Lab:
            java.lang.reflect.Field r9 = b.q.h.f711b
            if (r9 == 0) goto Lc4
            boolean r9 = r9.getBoolean(r8)     // Catch: java.lang.IllegalAccessException -> Lbf
            if (r9 == 0) goto Lbd
            java.lang.reflect.Field r1 = b.q.h.f711b     // Catch: java.lang.IllegalAccessException -> Lbb
            r1.setBoolean(r8, r2)     // Catch: java.lang.IllegalAccessException -> Lbb
            goto Lbd
        Lbb:
            r2 = r9
            goto Lbf
        Lbd:
            r2 = r9
            goto Lc4
        Lbf:
            java.lang.String r9 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r4, r9)
        Lc4:
            if (r2 == 0) goto Lc9
            r8.requestLayout()
        Lc9:
            java.lang.Object r9 = r8.getTag(r0)
            android.animation.LayoutTransition r9 = (android.animation.LayoutTransition) r9
            if (r9 == 0) goto Ld7
            r8.setTag(r0, r3)
        Ld4:
            r8.setLayoutTransition(r9)
        Ld7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.q.x.b(android.view.ViewGroup, boolean):void");
    }
}
