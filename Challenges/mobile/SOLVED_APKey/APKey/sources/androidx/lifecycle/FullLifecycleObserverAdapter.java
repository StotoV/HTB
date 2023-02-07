package androidx.lifecycle;

import b.m.b;
import b.m.d;
import b.m.e;
import b.m.g;
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements e {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public final e f69b;

    public FullLifecycleObserverAdapter(b bVar, e eVar) {
        this.a = bVar;
        this.f69b = eVar;
    }

    @Override // b.m.e
    public void h(g gVar, d.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                this.a.f(gVar);
                break;
            case 1:
                this.a.g(gVar);
                break;
            case 2:
                this.a.a(gVar);
                break;
            case 3:
                this.a.b(gVar);
                break;
            case 4:
                this.a.e(gVar);
                break;
            case 5:
                this.a.c(gVar);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        e eVar = this.f69b;
        if (eVar != null) {
            eVar.h(gVar, aVar);
        }
    }
}
