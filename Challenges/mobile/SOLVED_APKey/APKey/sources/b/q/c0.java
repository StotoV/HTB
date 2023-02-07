package b.q;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
public class c0 extends b0 {
    public static boolean f = true;
    public static boolean g = true;

    @Override // b.q.g0
    @SuppressLint({"NewApi"})
    public void g(View view, Matrix matrix) {
        if (f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }

    @Override // b.q.g0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }
}
