package b.q;

import android.annotation.SuppressLint;
import android.view.View;
/* loaded from: classes.dex */
public class b0 extends g0 {
    public static boolean e = true;

    @Override // b.q.g0
    public void a(View view) {
    }

    @Override // b.q.g0
    @SuppressLint({"NewApi"})
    public float b(View view) {
        if (e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // b.q.g0
    public void c(View view) {
    }

    @Override // b.q.g0
    @SuppressLint({"NewApi"})
    public void e(View view, float f) {
        if (e) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
        view.setAlpha(f);
    }
}
