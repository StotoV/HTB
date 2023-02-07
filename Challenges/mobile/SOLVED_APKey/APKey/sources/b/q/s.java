package b.q;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    public View f731b;
    public final Map<String, Object> a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<k> f732c = new ArrayList<>();

    @Deprecated
    public s() {
    }

    public s(View view) {
        this.f731b = view;
    }

    public boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            return this.f731b == sVar.f731b && this.a.equals(sVar.a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + (this.f731b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("TransitionValues@");
        g.append(Integer.toHexString(hashCode()));
        g.append(":\n");
        String d = c.a.a.a.a.d(g.toString() + "    view = " + this.f731b + "\n", "    values:");
        for (String str : this.a.keySet()) {
            d = d + "    " + str + ": " + this.a.get(str) + "\n";
        }
        return d;
    }
}
