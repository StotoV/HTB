package b.k.b;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class f0 extends b.m.p {
    public static final b.m.q h = new a();
    public final boolean e;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, m> f548b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<String, f0> f549c = new HashMap<>();
    public final HashMap<String, b.m.t> d = new HashMap<>();
    public boolean f = false;
    public boolean g = false;

    /* loaded from: classes.dex */
    public class a implements b.m.q {
        public <T extends b.m.p> T a(Class<T> cls) {
            return new f0(true);
        }
    }

    public f0(boolean z) {
        this.e = z;
    }

    @Override // b.m.p
    public void a() {
        if (c0.M(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    public void b(m mVar) {
        if (this.g) {
            if (!c0.M(2)) {
                return;
            }
            Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            return;
        }
        if (!(this.f548b.remove(mVar.f) != null) || !c0.M(2)) {
            return;
        }
        Log.v("FragmentManager", "Updating retained Fragments: Removed " + mVar);
    }

    public boolean c(m mVar) {
        if (this.f548b.containsKey(mVar.f) && this.e) {
            return this.f;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f0.class != obj.getClass()) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f548b.equals(f0Var.f548b) && this.f549c.equals(f0Var.f549c) && this.d.equals(f0Var.d);
    }

    public int hashCode() {
        int hashCode = this.f549c.hashCode();
        return this.d.hashCode() + ((hashCode + (this.f548b.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<m> it = this.f548b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f549c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
