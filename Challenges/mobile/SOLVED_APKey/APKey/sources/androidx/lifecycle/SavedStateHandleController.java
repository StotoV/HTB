package androidx.lifecycle;

import b.m.d;
import b.m.e;
import b.m.g;
import b.m.h;
import b.m.p;
import b.m.t;
import b.m.u;
import b.p.a;
import b.p.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class SavedStateHandleController implements e {
    public boolean a;

    /* renamed from: androidx.lifecycle.SavedStateHandleController$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements e {
        public final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.p.a f75b;

        @Override // b.m.e
        public void h(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                h hVar = (h) this.a;
                hVar.c("removeObserver");
                hVar.a.e(this);
                this.f75b.c(a.class);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements a.InterfaceC0030a {
        @Override // b.p.a.InterfaceC0030a
        public void a(c cVar) {
            Object obj;
            boolean z;
            if (cVar instanceof u) {
                t d = ((u) cVar).d();
                b.p.a c2 = cVar.c();
                d.getClass();
                Iterator it = new HashSet(d.a.keySet()).iterator();
                while (it.hasNext()) {
                    p pVar = d.a.get((String) it.next());
                    d a = cVar.a();
                    Map<String, Object> map = pVar.a;
                    if (map == null) {
                        obj = null;
                    } else {
                        synchronized (map) {
                            obj = pVar.a.get("androidx.lifecycle.savedstate.vm.tag");
                        }
                    }
                    SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
                    if (savedStateHandleController != null && !(z = savedStateHandleController.a)) {
                        if (z) {
                            throw new IllegalStateException("Already attached to lifecycleOwner");
                        }
                        savedStateHandleController.a = true;
                        a.a(savedStateHandleController);
                        throw null;
                    }
                }
                if (new HashSet(d.a.keySet()).isEmpty()) {
                    return;
                }
                c2.c(a.class);
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
        }
    }

    @Override // b.m.e
    public void h(g gVar, d.a aVar) {
        if (aVar == d.a.ON_DESTROY) {
            this.a = false;
            h hVar = (h) gVar.a();
            hVar.c("removeObserver");
            hVar.a.e(this);
        }
    }
}
