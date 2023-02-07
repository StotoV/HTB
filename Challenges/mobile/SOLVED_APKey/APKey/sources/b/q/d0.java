package b.q;

import android.annotation.SuppressLint;
import android.view.View;
/* loaded from: classes.dex */
public class d0 extends c0 {
    public static boolean h = true;

    @Override // b.q.g0
    @SuppressLint({"NewApi"})
    public void d(View view, int i, int i2, int i3, int i4) {
        if (h) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                h = false;
            }
        }
    }
}
