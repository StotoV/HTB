package b.f.b.h;

import b.f.b.h.d;
/* loaded from: classes.dex */
public class i {
    public static boolean[] a = new boolean[3];

    public static void a(e eVar, b.f.b.d dVar, d dVar2) {
        d.a aVar = d.a.MATCH_PARENT;
        dVar2.j = -1;
        dVar2.k = -1;
        d.a aVar2 = eVar.O[0];
        d.a aVar3 = d.a.WRAP_CONTENT;
        if (aVar2 != aVar3 && dVar2.O[0] == aVar) {
            int i = dVar2.D.g;
            int r = eVar.r() - dVar2.F.g;
            c cVar = dVar2.D;
            cVar.i = dVar.l(cVar);
            c cVar2 = dVar2.F;
            cVar2.i = dVar.l(cVar2);
            dVar.e(dVar2.D.i, i);
            dVar.e(dVar2.F.i, r);
            dVar2.j = 2;
            dVar2.U = i;
            int i2 = r - i;
            dVar2.Q = i2;
            int i3 = dVar2.X;
            if (i2 < i3) {
                dVar2.Q = i3;
            }
        }
        if (eVar.O[1] == aVar3 || dVar2.O[1] != aVar) {
            return;
        }
        int i4 = dVar2.E.g;
        int l = eVar.l() - dVar2.G.g;
        c cVar3 = dVar2.E;
        cVar3.i = dVar.l(cVar3);
        c cVar4 = dVar2.G;
        cVar4.i = dVar.l(cVar4);
        dVar.e(dVar2.E.i, i4);
        dVar.e(dVar2.G.i, l);
        if (dVar2.W > 0 || dVar2.c0 == 8) {
            c cVar5 = dVar2.H;
            cVar5.i = dVar.l(cVar5);
            dVar.e(dVar2.H.i, dVar2.W + i4);
        }
        dVar2.k = 2;
        dVar2.V = i4;
        int i5 = l - i4;
        dVar2.R = i5;
        int i6 = dVar2.Y;
        if (i5 >= i6) {
            return;
        }
        dVar2.R = i6;
    }

    public static final boolean b(int i, int i2) {
        return (i & i2) == i2;
    }
}
