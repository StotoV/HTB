package b.b.h;
/* loaded from: classes.dex */
public class h0 {
    public int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f224b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f225c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public int e = 0;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;

    public void a(int i, int i2) {
        this.f225c = i;
        this.d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.a = i2;
            }
            if (i == Integer.MIN_VALUE) {
                return;
            }
            this.f224b = i;
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.a = i;
        }
        if (i2 == Integer.MIN_VALUE) {
            return;
        }
        this.f224b = i2;
    }
}
