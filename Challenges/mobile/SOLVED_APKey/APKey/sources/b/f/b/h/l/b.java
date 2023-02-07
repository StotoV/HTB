package b.f.b.h.l;

import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.b.h.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {
    public final ArrayList<b.f.b.h.d> a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public a f345b = new a();

    /* renamed from: c  reason: collision with root package name */
    public b.f.b.h.e f346c;

    /* loaded from: classes.dex */
    public static class a {
        public d.a a;

        /* renamed from: b  reason: collision with root package name */
        public d.a f347b;

        /* renamed from: c  reason: collision with root package name */
        public int f348c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public boolean i;
        public int j;
    }

    /* renamed from: b.f.b.h.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0013b {
    }

    public b(b.f.b.h.e eVar) {
        this.f346c = eVar;
    }

    public final boolean a(InterfaceC0013b interfaceC0013b, b.f.b.h.d dVar, int i) {
        d.a aVar = d.a.FIXED;
        this.f345b.a = dVar.m();
        this.f345b.f347b = dVar.q();
        this.f345b.f348c = dVar.r();
        this.f345b.d = dVar.l();
        a aVar2 = this.f345b;
        aVar2.i = false;
        aVar2.j = i;
        d.a aVar3 = aVar2.a;
        d.a aVar4 = d.a.MATCH_CONSTRAINT;
        boolean z = aVar3 == aVar4;
        boolean z2 = aVar2.f347b == aVar4;
        boolean z3 = z && dVar.S > 0.0f;
        boolean z4 = z2 && dVar.S > 0.0f;
        if (z3 && dVar.n[0] == 4) {
            aVar2.a = aVar;
        }
        if (z4 && dVar.n[1] == 4) {
            aVar2.f347b = aVar;
        }
        ((ConstraintLayout.b) interfaceC0013b).b(dVar, aVar2);
        dVar.M(this.f345b.e);
        dVar.H(this.f345b.f);
        a aVar5 = this.f345b;
        dVar.y = aVar5.h;
        dVar.E(aVar5.g);
        a aVar6 = this.f345b;
        aVar6.j = 0;
        return aVar6.i;
    }

    public final void b(b.f.b.h.e eVar, int i, int i2) {
        int i3 = eVar.X;
        int i4 = eVar.Y;
        eVar.K(0);
        eVar.J(0);
        eVar.Q = i;
        int i5 = eVar.X;
        if (i < i5) {
            eVar.Q = i5;
        }
        eVar.R = i2;
        int i6 = eVar.Y;
        if (i2 < i6) {
            eVar.R = i6;
        }
        eVar.K(i3);
        eVar.J(i4);
        this.f346c.P();
    }

    public void c(b.f.b.h.e eVar) {
        this.a.clear();
        int size = eVar.l0.size();
        for (int i = 0; i < size; i++) {
            b.f.b.h.d dVar = eVar.l0.get(i);
            d.a m = dVar.m();
            d.a aVar = d.a.MATCH_CONSTRAINT;
            if (m == aVar || dVar.q() == aVar) {
                this.a.add(dVar);
            }
        }
        eVar.W();
    }
}
