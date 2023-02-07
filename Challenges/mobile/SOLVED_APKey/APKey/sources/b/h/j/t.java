package b.h.j;

import android.view.View;
import b.h.j.q;
/* loaded from: classes.dex */
public class t extends q.b<CharSequence> {
    public t(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    @Override // b.h.j.q.b
    public CharSequence b(View view) {
        return view.getStateDescription();
    }
}
