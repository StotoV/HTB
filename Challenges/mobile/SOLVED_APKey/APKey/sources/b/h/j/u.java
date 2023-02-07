package b.h.j;

import android.view.View;
import b.h.j.q;
/* loaded from: classes.dex */
public class u extends q.b<Boolean> {
    public u(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // b.h.j.q.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }

    public void d(View view, Object obj) {
        view.setAccessibilityHeading(((Boolean) obj).booleanValue());
    }

    public boolean e(Object obj, Object obj2) {
        return !a((Boolean) obj, (Boolean) obj2);
    }
}
