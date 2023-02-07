package b.k.b;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class j0 {
    public final ArrayList<m> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, i0> f562b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public f0 f563c;

    public void a(m mVar) {
        if (this.a.contains(mVar)) {
            throw new IllegalStateException("Fragment already added: " + mVar);
        }
        synchronized (this.a) {
            this.a.add(mVar);
        }
        mVar.l = true;
    }

    public void b() {
        this.f562b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.f562b.get(str) != null;
    }

    public m d(String str) {
        i0 i0Var = this.f562b.get(str);
        if (i0Var != null) {
            return i0Var.f559c;
        }
        return null;
    }

    public m e(String str) {
        for (i0 i0Var : this.f562b.values()) {
            if (i0Var != null) {
                m mVar = i0Var.f559c;
                if (!str.equals(mVar.f)) {
                    mVar = mVar.u.f530c.e(str);
                }
                if (mVar != null) {
                    return mVar;
                }
            }
        }
        return null;
    }

    public List<i0> f() {
        ArrayList arrayList = new ArrayList();
        for (i0 i0Var : this.f562b.values()) {
            if (i0Var != null) {
                arrayList.add(i0Var);
            }
        }
        return arrayList;
    }

    public List<m> g() {
        ArrayList arrayList = new ArrayList();
        Iterator<i0> it = this.f562b.values().iterator();
        while (it.hasNext()) {
            i0 next = it.next();
            arrayList.add(next != null ? next.f559c : null);
        }
        return arrayList;
    }

    public i0 h(String str) {
        return this.f562b.get(str);
    }

    public List<m> i() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public void j(i0 i0Var) {
        m mVar = i0Var.f559c;
        if (c(mVar.f)) {
            return;
        }
        this.f562b.put(mVar.f, i0Var);
        if (!c0.M(2)) {
            return;
        }
        Log.v("FragmentManager", "Added fragment to active set " + mVar);
    }

    public void k(i0 i0Var) {
        m mVar = i0Var.f559c;
        if (mVar.B) {
            this.f563c.b(mVar);
        }
        if (this.f562b.put(mVar.f, null) != null && c0.M(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + mVar);
        }
    }

    public void l(m mVar) {
        synchronized (this.a) {
            this.a.remove(mVar);
        }
        mVar.l = false;
    }
}
