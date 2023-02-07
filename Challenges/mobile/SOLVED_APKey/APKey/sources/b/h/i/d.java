package b.h.i;
/* loaded from: classes.dex */
public class d<T> extends c<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f459c;

    public d(int i) {
        super(i);
        this.f459c = new Object();
    }

    @Override // b.h.i.c
    public T a() {
        T t;
        synchronized (this.f459c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // b.h.i.c
    public boolean b(T t) {
        boolean b2;
        synchronized (this.f459c) {
            b2 = super.b(t);
        }
        return b2;
    }
}
