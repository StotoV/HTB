package b.q;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class e0 extends d0 {
    public static boolean i = true;

    @Override // b.q.g0
    @SuppressLint({"NewApi"})
    public void f(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i2);
        } else if (!i) {
        } else {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                i = false;
            }
        }
    }
}
