package b.p;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import b.m.d;
import b.m.e;
import b.m.g;
import b.m.h;
import b.p.a;
import java.util.Map;
/* loaded from: classes.dex */
public final class b {
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final a f698b = new a();

    public b(c cVar) {
        this.a = cVar;
    }

    public void a(Bundle bundle) {
        d a = this.a.a();
        if (((h) a).f639b == d.b.INITIALIZED) {
            a.a(new Recreator(this.a));
            final a aVar = this.f698b;
            if (aVar.f697c) {
                throw new IllegalStateException("SavedStateRegistry was already restored.");
            }
            if (bundle != null) {
                aVar.f696b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            a.a(new e() { // from class: androidx.savedstate.SavedStateRegistry$1
                @Override // b.m.e
                public void h(g gVar, d.a aVar2) {
                    a aVar3;
                    boolean z;
                    if (aVar2 == d.a.ON_START) {
                        aVar3 = a.this;
                        z = true;
                    } else if (aVar2 != d.a.ON_STOP) {
                        return;
                    } else {
                        aVar3 = a.this;
                        z = false;
                    }
                    aVar3.e = z;
                }
            });
            aVar.f697c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    public void b(Bundle bundle) {
        a aVar = this.f698b;
        aVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = aVar.f696b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.c.a.b.b<String, a.b>.d b2 = aVar.a.b();
        while (b2.hasNext()) {
            Map.Entry entry = (Map.Entry) b2.next();
            bundle2.putBundle((String) entry.getKey(), ((a.b) entry.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
