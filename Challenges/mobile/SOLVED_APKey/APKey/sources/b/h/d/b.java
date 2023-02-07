package b.h.d;

import android.graphics.Insets;
/* loaded from: classes.dex */
public final class b {
    public static final b e = new b(0, 0, 0, 0);
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f411b;

    /* renamed from: c  reason: collision with root package name */
    public final int f412c;
    public final int d;

    public b(int i, int i2, int i3, int i4) {
        this.a = i;
        this.f411b = i2;
        this.f412c = i3;
        this.d = i4;
    }

    public static b a(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new b(i, i2, i3, i4);
    }

    public Insets b() {
        return Insets.of(this.a, this.f411b, this.f412c, this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.d == bVar.d && this.a == bVar.a && this.f412c == bVar.f412c && this.f411b == bVar.f411b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.f411b) * 31) + this.f412c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("Insets{left=");
        g.append(this.a);
        g.append(", top=");
        g.append(this.f411b);
        g.append(", right=");
        g.append(this.f412c);
        g.append(", bottom=");
        g.append(this.d);
        g.append('}');
        return g.toString();
    }
}
