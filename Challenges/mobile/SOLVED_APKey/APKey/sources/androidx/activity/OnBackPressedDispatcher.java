package androidx.activity;

import b.a.b;
import b.m.d;
import b.m.e;
import b.m.g;
import b.m.h;
import java.util.ArrayDeque;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public final Runnable a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayDeque<b> f4b = new ArrayDeque<>();

    /* loaded from: classes.dex */
    public class LifecycleOnBackPressedCancellable implements e, b.a.a {
        public final d a;

        /* renamed from: b  reason: collision with root package name */
        public final b f5b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.a f6c;

        public LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.a = dVar;
            this.f5b = bVar;
            dVar.a(this);
        }

        @Override // b.a.a
        public void d() {
            h hVar = (h) this.a;
            hVar.c("removeObserver");
            hVar.a.e(this);
            this.f5b.f124b.remove(this);
            b.a.a aVar = this.f6c;
            if (aVar != null) {
                aVar.d();
                this.f6c = null;
            }
        }

        @Override // b.m.e
        public void h(g gVar, d.a aVar) {
            if (aVar == d.a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                b bVar = this.f5b;
                onBackPressedDispatcher.f4b.add(bVar);
                a aVar2 = new a(bVar);
                bVar.f124b.add(aVar2);
                this.f6c = aVar2;
            } else if (aVar != d.a.ON_STOP) {
                if (aVar != d.a.ON_DESTROY) {
                    return;
                }
                d();
            } else {
                b.a.a aVar3 = this.f6c;
                if (aVar3 == null) {
                    return;
                }
                aVar3.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements b.a.a {
        public final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // b.a.a
        public void d() {
            OnBackPressedDispatcher.this.f4b.remove(this.a);
            this.a.f124b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.a = runnable;
    }

    public void a() {
        Iterator<b> descendingIterator = this.f4b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.a) {
                next.a();
                return;
            }
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
