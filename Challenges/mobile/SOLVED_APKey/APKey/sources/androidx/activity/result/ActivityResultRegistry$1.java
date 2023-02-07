package androidx.activity.result;

import b.m.d;
import b.m.e;
import b.m.g;
/* loaded from: classes.dex */
public class ActivityResultRegistry$1 implements e {
    @Override // b.m.e
    public void h(g gVar, d.a aVar) {
        if (!d.a.ON_START.equals(aVar)) {
            if (d.a.ON_STOP.equals(aVar)) {
                throw null;
            }
            if (d.a.ON_DESTROY.equals(aVar)) {
                throw null;
            }
            return;
        }
        throw null;
    }
}
