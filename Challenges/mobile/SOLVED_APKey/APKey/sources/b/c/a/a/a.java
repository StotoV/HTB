package b.c.a.a;
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f284c;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public c f285b;

    public a() {
        b bVar = new b();
        this.f285b = bVar;
        this.a = bVar;
    }

    public static a b() {
        if (f284c != null) {
            return f284c;
        }
        synchronized (a.class) {
            if (f284c == null) {
                f284c = new a();
            }
        }
        return f284c;
    }

    @Override // b.c.a.a.c
    public boolean a() {
        return this.a.a();
    }
}
