package b.h.j;
/* loaded from: classes.dex */
public final class d {
    public final Object a;

    public d(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            return b.h.b.a.v(this.a, ((d) obj).a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("DisplayCutoutCompat{");
        g.append(this.a);
        g.append("}");
        return g.toString();
    }
}
