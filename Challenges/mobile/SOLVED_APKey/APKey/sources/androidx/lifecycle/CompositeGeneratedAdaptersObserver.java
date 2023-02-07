package androidx.lifecycle;

import b.m.c;
import b.m.d;
import b.m.e;
import b.m.g;
import b.m.k;
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements e {
    public final c[] a;

    public CompositeGeneratedAdaptersObserver(c[] cVarArr) {
        this.a = cVarArr;
    }

    @Override // b.m.e
    public void h(g gVar, d.a aVar) {
        k kVar = new k();
        for (c cVar : this.a) {
            cVar.a(gVar, aVar, false, kVar);
        }
        for (c cVar2 : this.a) {
            cVar2.a(gVar, aVar, true, kVar);
        }
    }
}
