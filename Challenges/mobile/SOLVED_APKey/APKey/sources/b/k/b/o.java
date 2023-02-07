package b.k.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class o implements b.a.d.b {
    public final /* synthetic */ p a;

    public o(p pVar) {
        this.a = pVar;
    }

    @Override // b.a.d.b
    public void a(Context context) {
        z<?> zVar = this.a.i.a;
        zVar.e.b(zVar, zVar, null);
        Bundle a = this.a.e.f698b.a("android:support:fragments");
        if (a != null) {
            Parcelable parcelable = a.getParcelable("android:support:fragments");
            z<?> zVar2 = this.a.i.a;
            if (!(zVar2 instanceof b.m.u)) {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
            zVar2.e.Y(parcelable);
        }
    }
}
