package b.q;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import b.q.k;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class q extends k {
    public int A;
    public ArrayList<k> y = new ArrayList<>();
    public boolean z = true;
    public boolean B = false;
    public int C = 0;

    /* loaded from: classes.dex */
    public class a extends n {
        public final /* synthetic */ k a;

        public a(q qVar, k kVar) {
            this.a = kVar;
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            this.a.y();
            kVar.v(this);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends n {
        public q a;

        public b(q qVar) {
            this.a = qVar;
        }

        @Override // b.q.n, b.q.k.d
        public void a(k kVar) {
            q qVar = this.a;
            if (!qVar.B) {
                qVar.F();
                this.a.B = true;
            }
        }

        @Override // b.q.k.d
        public void c(k kVar) {
            q qVar = this.a;
            int i = qVar.A - 1;
            qVar.A = i;
            if (i == 0) {
                qVar.B = false;
                qVar.m();
            }
            kVar.v(this);
        }
    }

    @Override // b.q.k
    public void A(k.c cVar) {
        this.t = cVar;
        this.C |= 8;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).A(cVar);
        }
    }

    @Override // b.q.k
    public k B(TimeInterpolator timeInterpolator) {
        this.C |= 1;
        ArrayList<k> arrayList = this.y;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.y.get(i).B(timeInterpolator);
            }
        }
        this.e = timeInterpolator;
        return this;
    }

    @Override // b.q.k
    public void C(f fVar) {
        this.u = fVar == null ? k.w : fVar;
        this.C |= 4;
        if (this.y != null) {
            for (int i = 0; i < this.y.size(); i++) {
                this.y.get(i).C(fVar);
            }
        }
    }

    @Override // b.q.k
    public void D(p pVar) {
        this.C |= 2;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).D(pVar);
        }
    }

    @Override // b.q.k
    public k E(long j) {
        this.f720c = j;
        return this;
    }

    @Override // b.q.k
    public String G(String str) {
        String G = super.G(str);
        for (int i = 0; i < this.y.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(G);
            sb.append("\n");
            sb.append(this.y.get(i).G(str + "  "));
            G = sb.toString();
        }
        return G;
    }

    public q H(k kVar) {
        this.y.add(kVar);
        kVar.j = this;
        long j = this.d;
        if (j >= 0) {
            kVar.z(j);
        }
        if ((this.C & 1) != 0) {
            kVar.B(this.e);
        }
        if ((this.C & 2) != 0) {
            kVar.D(null);
        }
        if ((this.C & 4) != 0) {
            kVar.C(this.u);
        }
        if ((this.C & 8) != 0) {
            kVar.A(this.t);
        }
        return this;
    }

    public k I(int i) {
        if (i < 0 || i >= this.y.size()) {
            return null;
        }
        return this.y.get(i);
    }

    public q J(int i) {
        if (i == 0) {
            this.z = true;
        } else if (i != 1) {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        } else {
            this.z = false;
        }
        return this;
    }

    @Override // b.q.k
    public k a(k.d dVar) {
        super.a(dVar);
        return this;
    }

    @Override // b.q.k
    public k b(View view) {
        for (int i = 0; i < this.y.size(); i++) {
            this.y.get(i).b(view);
        }
        this.g.add(view);
        return this;
    }

    @Override // b.q.k
    public void d(s sVar) {
        if (s(sVar.f731b)) {
            Iterator<k> it = this.y.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next.s(sVar.f731b)) {
                    next.d(sVar);
                    sVar.f732c.add(next);
                }
            }
        }
    }

    @Override // b.q.k
    public void f(s sVar) {
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).f(sVar);
        }
    }

    @Override // b.q.k
    public void g(s sVar) {
        if (s(sVar.f731b)) {
            Iterator<k> it = this.y.iterator();
            while (it.hasNext()) {
                k next = it.next();
                if (next.s(sVar.f731b)) {
                    next.g(sVar);
                    sVar.f732c.add(next);
                }
            }
        }
    }

    @Override // b.q.k
    /* renamed from: j */
    public k clone() {
        q qVar = (q) super.clone();
        qVar.y = new ArrayList<>();
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            k clone = this.y.get(i).clone();
            qVar.y.add(clone);
            clone.j = qVar;
        }
        return qVar;
    }

    @Override // b.q.k
    public void l(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long j = this.f720c;
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            k kVar = this.y.get(i);
            if (j > 0 && (this.z || i == 0)) {
                long j2 = kVar.f720c;
                if (j2 > 0) {
                    kVar.E(j2 + j);
                } else {
                    kVar.E(j);
                }
            }
            kVar.l(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    @Override // b.q.k
    public void u(View view) {
        super.u(view);
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).u(view);
        }
    }

    @Override // b.q.k
    public k v(k.d dVar) {
        super.v(dVar);
        return this;
    }

    @Override // b.q.k
    public k w(View view) {
        for (int i = 0; i < this.y.size(); i++) {
            this.y.get(i).w(view);
        }
        this.g.remove(view);
        return this;
    }

    @Override // b.q.k
    public void x(View view) {
        super.x(view);
        int size = this.y.size();
        for (int i = 0; i < size; i++) {
            this.y.get(i).x(view);
        }
    }

    @Override // b.q.k
    public void y() {
        if (this.y.isEmpty()) {
            F();
            m();
            return;
        }
        b bVar = new b(this);
        Iterator<k> it = this.y.iterator();
        while (it.hasNext()) {
            it.next().a(bVar);
        }
        this.A = this.y.size();
        if (this.z) {
            Iterator<k> it2 = this.y.iterator();
            while (it2.hasNext()) {
                it2.next().y();
            }
            return;
        }
        for (int i = 1; i < this.y.size(); i++) {
            this.y.get(i - 1).a(new a(this, this.y.get(i)));
        }
        k kVar = this.y.get(0);
        if (kVar == null) {
            return;
        }
        kVar.y();
    }

    @Override // b.q.k
    public k z(long j) {
        ArrayList<k> arrayList;
        this.d = j;
        if (j >= 0 && (arrayList = this.y) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.y.get(i).z(j);
            }
        }
        return this;
    }
}
