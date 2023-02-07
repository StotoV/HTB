package c.c.a.a.r;

import android.graphics.Typeface;
/* loaded from: classes.dex */
public final class a extends d {
    public final Typeface a;

    /* renamed from: b  reason: collision with root package name */
    public final InterfaceC0039a f862b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f863c;

    /* renamed from: c.c.a.a.r.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039a {
    }

    public a(InterfaceC0039a interfaceC0039a, Typeface typeface) {
        this.a = typeface;
        this.f862b = interfaceC0039a;
    }

    @Override // c.c.a.a.r.d
    public void a(int i) {
        c(this.a);
    }

    @Override // c.c.a.a.r.d
    public void b(Typeface typeface, boolean z) {
        c(typeface);
    }

    public final void c(Typeface typeface) {
        if (!this.f863c) {
            c.c.a.a.q.c cVar = ((c.c.a.a.q.b) this.f862b).a;
            a aVar = cVar.v;
            boolean z = true;
            if (aVar != null) {
                aVar.f863c = true;
            }
            if (cVar.s != typeface) {
                cVar.s = typeface;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            cVar.k();
        }
    }
}
