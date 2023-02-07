package b.q;

import android.graphics.Matrix;
import android.view.View;
/* loaded from: classes.dex */
public class f0 extends e0 {
    @Override // b.q.b0, b.q.g0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // b.q.d0, b.q.g0
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // b.q.b0, b.q.g0
    public void e(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // b.q.e0, b.q.g0
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // b.q.c0, b.q.g0
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // b.q.c0, b.q.g0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
