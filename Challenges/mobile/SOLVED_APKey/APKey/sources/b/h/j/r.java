package b.h.j;

import android.view.View;
import b.h.j.q;
/* loaded from: classes.dex */
public class r extends q.b<Boolean> {
    public r(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // b.h.j.q.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }
}
