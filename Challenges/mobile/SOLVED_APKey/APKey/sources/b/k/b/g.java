package b.k.b;

import android.view.View;
import android.view.ViewGroup;
import b.h.f.a;
import b.k.b.c;
/* loaded from: classes.dex */
public class g implements a.InterfaceC0016a {
    public final /* synthetic */ View a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f550b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c.b f551c;

    public g(c cVar, View view, ViewGroup viewGroup, c.b bVar) {
        this.a = view;
        this.f550b = viewGroup;
        this.f551c = bVar;
    }

    @Override // b.h.f.a.InterfaceC0016a
    public void a() {
        this.a.clearAnimation();
        this.f550b.endViewTransition(this.a);
        this.f551c.a();
    }
}
