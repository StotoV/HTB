package b.b.g.e;

import android.content.Context;
import android.view.LayoutInflater;
import b.b.g.e.k;
/* loaded from: classes.dex */
public abstract class b implements k {

    /* renamed from: b  reason: collision with root package name */
    public Context f168b;

    /* renamed from: c  reason: collision with root package name */
    public Context f169c;
    public f d;
    public LayoutInflater e;
    public k.a f;
    public int g;
    public int h;
    public l i;

    public b(Context context, int i, int i2) {
        this.f168b = context;
        this.e = LayoutInflater.from(context);
        this.g = i;
        this.h = i2;
    }

    @Override // b.b.g.e.k
    public boolean d(f fVar, g gVar) {
        return false;
    }

    @Override // b.b.g.e.k
    public void f(k.a aVar) {
        this.f = aVar;
    }

    @Override // b.b.g.e.k
    public boolean l(f fVar, g gVar) {
        return false;
    }
}
