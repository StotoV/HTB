package b.k.b;

import android.os.Bundle;
import android.os.Parcelable;
import b.m.d;
import b.p.a;
/* loaded from: classes.dex */
public class n implements a.b {
    public final /* synthetic */ p a;

    public n(p pVar) {
        this.a = pVar;
    }

    @Override // b.p.a.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        do {
        } while (p.j(this.a.i.a.e, d.b.CREATED));
        this.a.j.d(d.a.ON_STOP);
        Parcelable Z = this.a.i.a.e.Z();
        if (Z != null) {
            bundle.putParcelable("android:support:fragments", Z);
        }
        return bundle;
    }
}
