package b.h.f;
/* loaded from: classes.dex */
public final class a {
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC0016a f423b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f424c;

    /* renamed from: b.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0016a {
        void a();
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.f424c = true;
            InterfaceC0016a interfaceC0016a = this.f423b;
            if (interfaceC0016a != null) {
                try {
                    interfaceC0016a.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.f424c = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            synchronized (this) {
                this.f424c = false;
                notifyAll();
            }
        }
    }

    public void b(InterfaceC0016a interfaceC0016a) {
        synchronized (this) {
            while (this.f424c) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.f423b == interfaceC0016a) {
                return;
            }
            this.f423b = interfaceC0016a;
            if (!this.a) {
                return;
            }
            interfaceC0016a.a();
        }
    }
}
