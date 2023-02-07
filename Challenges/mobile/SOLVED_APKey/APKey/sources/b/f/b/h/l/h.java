package b.f.b.h.l;

import b.f.b.h.c;
import b.f.b.h.d;
import b.f.b.h.l.b;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class h {
    public static b.a a = new b.a();

    public static boolean a(b.f.b.h.d dVar) {
        d.a aVar = d.a.MATCH_CONSTRAINT;
        d.a aVar2 = d.a.WRAP_CONTENT;
        d.a aVar3 = d.a.FIXED;
        d.a m = dVar.m();
        d.a q = dVar.q();
        b.f.b.h.d dVar2 = dVar.P;
        b.f.b.h.e eVar = dVar2 != null ? (b.f.b.h.e) dVar2 : null;
        if (eVar != null) {
            eVar.m();
        }
        if (eVar != null) {
            eVar.q();
        }
        boolean z = m == aVar3 || m == aVar2 || (m == aVar && dVar.l == 0 && dVar.S == 0.0f && dVar.u(0)) || dVar.z();
        boolean z2 = q == aVar3 || q == aVar2 || (q == aVar && dVar.m == 0 && dVar.S == 0.0f && dVar.u(1)) || dVar.A();
        if (dVar.S <= 0.0f || (!z && !z2)) {
            return z && z2;
        }
        return true;
    }

    public static void b(b.f.b.h.d dVar, b.InterfaceC0013b interfaceC0013b, boolean z) {
        HashSet<b.f.b.h.c> hashSet;
        b.f.b.h.c cVar;
        b.f.b.h.c cVar2;
        b.f.b.h.c cVar3;
        b.f.b.h.c cVar4;
        b.f.b.h.c cVar5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        if (!(dVar instanceof b.f.b.h.e) && dVar.y() && a(dVar)) {
            b.f.b.h.e.X(dVar, interfaceC0013b, new b.a(), 0);
        }
        b.f.b.h.c i = dVar.i(c.a.LEFT);
        b.f.b.h.c i2 = dVar.i(c.a.RIGHT);
        int c2 = i.c();
        int c3 = i2.c();
        HashSet<b.f.b.h.c> hashSet2 = i.a;
        if (hashSet2 != null && i.f338c) {
            Iterator<b.f.b.h.c> it = hashSet2.iterator();
            while (it.hasNext()) {
                b.f.b.h.c next = it.next();
                b.f.b.h.d dVar2 = next.d;
                boolean a2 = a(dVar2);
                if (dVar2.y() && a2) {
                    b.f.b.h.e.X(dVar2, interfaceC0013b, new b.a(), 0);
                }
                if (dVar2.m() != aVar || a2) {
                    if (!dVar2.y()) {
                        b.f.b.h.c cVar6 = dVar2.D;
                        if (next == cVar6 && dVar2.F.f == null) {
                            int d = cVar6.d() + c2;
                            dVar2.F(d, dVar2.r() + d);
                        } else {
                            b.f.b.h.c cVar7 = dVar2.F;
                            if (next == cVar7 && cVar6.f == null) {
                                int d2 = c2 - cVar7.d();
                                dVar2.F(d2 - dVar2.r(), d2);
                            } else if (next == cVar6 && (cVar3 = cVar7.f) != null && cVar3.f338c && !dVar2.w()) {
                                c(interfaceC0013b, dVar2, z);
                            }
                        }
                        b(dVar2, interfaceC0013b, z);
                    }
                } else if (dVar2.m() == aVar && dVar2.p >= 0 && dVar2.o >= 0 && (dVar2.c0 == 8 || (dVar2.l == 0 && dVar2.S == 0.0f))) {
                    if (!dVar2.w() && !dVar2.A) {
                        b.f.b.h.c cVar8 = dVar2.D;
                        if (((next == cVar8 && (cVar5 = dVar2.F.f) != null && cVar5.f338c) || (next == dVar2.F && (cVar4 = cVar8.f) != null && cVar4.f338c)) && !dVar2.w()) {
                            d(dVar, interfaceC0013b, dVar2, z);
                        }
                    }
                }
            }
        }
        if (!(dVar instanceof b.f.b.h.f) && (hashSet = i2.a) != null && i2.f338c) {
            Iterator<b.f.b.h.c> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                b.f.b.h.c next2 = it2.next();
                b.f.b.h.d dVar3 = next2.d;
                boolean a3 = a(dVar3);
                if (dVar3.y() && a3) {
                    b.f.b.h.e.X(dVar3, interfaceC0013b, new b.a(), 0);
                }
                b.f.b.h.c cVar9 = dVar3.D;
                boolean z2 = (next2 == cVar9 && (cVar2 = dVar3.F.f) != null && cVar2.f338c) || (next2 == dVar3.F && (cVar = cVar9.f) != null && cVar.f338c);
                if (dVar3.m() != aVar || a3) {
                    if (!dVar3.y()) {
                        b.f.b.h.c cVar10 = dVar3.D;
                        if (next2 == cVar10 && dVar3.F.f == null) {
                            int d3 = cVar10.d() + c3;
                            dVar3.F(d3, dVar3.r() + d3);
                        } else {
                            b.f.b.h.c cVar11 = dVar3.F;
                            if (next2 == cVar11 && cVar10.f == null) {
                                int d4 = c3 - cVar11.d();
                                dVar3.F(d4 - dVar3.r(), d4);
                            } else if (z2 && !dVar3.w()) {
                                c(interfaceC0013b, dVar3, z);
                            }
                        }
                        b(dVar3, interfaceC0013b, z);
                    }
                } else if (dVar3.m() == aVar && dVar3.p >= 0 && dVar3.o >= 0 && (dVar3.c0 == 8 || (dVar3.l == 0 && dVar3.S == 0.0f))) {
                    if (!dVar3.w() && !dVar3.A && z2 && !dVar3.w()) {
                        d(dVar, interfaceC0013b, dVar3, z);
                    }
                }
            }
        }
    }

    public static void c(b.InterfaceC0013b interfaceC0013b, b.f.b.h.d dVar, boolean z) {
        float f = dVar.Z;
        int c2 = dVar.D.f.c();
        int c3 = dVar.F.f.c();
        int d = dVar.D.d() + c2;
        int d2 = c3 - dVar.F.d();
        if (c2 == c3) {
            f = 0.5f;
        } else {
            c2 = d;
            c3 = d2;
        }
        int r = dVar.r();
        int i = (c3 - c2) - r;
        if (c2 > c3) {
            i = (c2 - c3) - r;
        }
        int i2 = ((int) ((f * i) + 0.5f)) + c2;
        int i3 = i2 + r;
        if (c2 > c3) {
            i3 = i2 - r;
        }
        dVar.F(i2, i3);
        b(dVar, interfaceC0013b, z);
    }

    public static void d(b.f.b.h.d dVar, b.InterfaceC0013b interfaceC0013b, b.f.b.h.d dVar2, boolean z) {
        float f = dVar2.Z;
        int d = dVar2.D.d() + dVar2.D.f.c();
        int c2 = dVar2.F.f.c() - dVar2.F.d();
        if (c2 >= d) {
            int r = dVar2.r();
            if (dVar2.c0 != 8) {
                int i = dVar2.l;
                if (i == 2) {
                    if (!(dVar instanceof b.f.b.h.e)) {
                        dVar = dVar.P;
                    }
                    r = (int) (dVar2.Z * 0.5f * dVar.r());
                } else if (i == 0) {
                    r = c2 - d;
                }
                r = Math.max(dVar2.o, r);
                int i2 = dVar2.p;
                if (i2 > 0) {
                    r = Math.min(i2, r);
                }
            }
            int i3 = d + ((int) ((f * ((c2 - d) - r)) + 0.5f));
            dVar2.F(i3, r + i3);
            b(dVar2, interfaceC0013b, z);
        }
    }

    public static void e(b.InterfaceC0013b interfaceC0013b, b.f.b.h.d dVar) {
        float f = dVar.a0;
        int c2 = dVar.E.f.c();
        int c3 = dVar.G.f.c();
        int d = dVar.E.d() + c2;
        int d2 = c3 - dVar.G.d();
        if (c2 == c3) {
            f = 0.5f;
        } else {
            c2 = d;
            c3 = d2;
        }
        int l = dVar.l();
        int i = (c3 - c2) - l;
        if (c2 > c3) {
            i = (c2 - c3) - l;
        }
        int i2 = (int) ((f * i) + 0.5f);
        int i3 = c2 + i2;
        int i4 = i3 + l;
        if (c2 > c3) {
            i3 = c2 - i2;
            i4 = i3 - l;
        }
        dVar.G(i3, i4);
        g(dVar, interfaceC0013b);
    }

    public static void f(b.f.b.h.d dVar, b.InterfaceC0013b interfaceC0013b, b.f.b.h.d dVar2) {
        float f = dVar2.a0;
        int d = dVar2.E.d() + dVar2.E.f.c();
        int c2 = dVar2.G.f.c() - dVar2.G.d();
        if (c2 >= d) {
            int l = dVar2.l();
            if (dVar2.c0 != 8) {
                int i = dVar2.m;
                if (i == 2) {
                    if (!(dVar instanceof b.f.b.h.e)) {
                        dVar = dVar.P;
                    }
                    l = (int) (f * 0.5f * dVar.l());
                } else if (i == 0) {
                    l = c2 - d;
                }
                l = Math.max(dVar2.r, l);
                int i2 = dVar2.s;
                if (i2 > 0) {
                    l = Math.min(i2, l);
                }
            }
            int i3 = d + ((int) ((f * ((c2 - d) - l)) + 0.5f));
            dVar2.G(i3, l + i3);
            g(dVar2, interfaceC0013b);
        }
    }

    public static void g(b.f.b.h.d dVar, b.InterfaceC0013b interfaceC0013b) {
        b.f.b.h.c cVar;
        b.f.b.h.c cVar2;
        b.f.b.h.c cVar3;
        b.f.b.h.c cVar4;
        b.f.b.h.c cVar5;
        d.a aVar = d.a.MATCH_CONSTRAINT;
        if (!(dVar instanceof b.f.b.h.e) && dVar.y() && a(dVar)) {
            b.f.b.h.e.X(dVar, interfaceC0013b, new b.a(), 0);
        }
        b.f.b.h.c i = dVar.i(c.a.TOP);
        b.f.b.h.c i2 = dVar.i(c.a.BOTTOM);
        int c2 = i.c();
        int c3 = i2.c();
        HashSet<b.f.b.h.c> hashSet = i.a;
        if (hashSet != null && i.f338c) {
            Iterator<b.f.b.h.c> it = hashSet.iterator();
            while (it.hasNext()) {
                b.f.b.h.c next = it.next();
                b.f.b.h.d dVar2 = next.d;
                boolean a2 = a(dVar2);
                if (dVar2.y() && a2) {
                    b.f.b.h.e.X(dVar2, interfaceC0013b, new b.a(), 0);
                }
                if (dVar2.q() != aVar || a2) {
                    if (!dVar2.y()) {
                        b.f.b.h.c cVar6 = dVar2.E;
                        if (next == cVar6 && dVar2.G.f == null) {
                            int d = cVar6.d() + c2;
                            dVar2.G(d, dVar2.l() + d);
                        } else {
                            b.f.b.h.c cVar7 = dVar2.G;
                            if (next == cVar7 && cVar7.f == null) {
                                int d2 = c2 - cVar7.d();
                                dVar2.G(d2 - dVar2.l(), d2);
                            } else if (next == cVar6 && (cVar3 = cVar7.f) != null && cVar3.f338c) {
                                e(interfaceC0013b, dVar2);
                            }
                        }
                        g(dVar2, interfaceC0013b);
                    }
                } else if (dVar2.q() == aVar && dVar2.s >= 0 && dVar2.r >= 0 && (dVar2.c0 == 8 || (dVar2.m == 0 && dVar2.S == 0.0f))) {
                    if (!dVar2.x() && !dVar2.A) {
                        b.f.b.h.c cVar8 = dVar2.E;
                        if (((next == cVar8 && (cVar5 = dVar2.G.f) != null && cVar5.f338c) || (next == dVar2.G && (cVar4 = cVar8.f) != null && cVar4.f338c)) && !dVar2.x()) {
                            f(dVar, interfaceC0013b, dVar2);
                        }
                    }
                }
            }
        }
        if (dVar instanceof b.f.b.h.f) {
            return;
        }
        HashSet<b.f.b.h.c> hashSet2 = i2.a;
        if (hashSet2 != null && i2.f338c) {
            Iterator<b.f.b.h.c> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                b.f.b.h.c next2 = it2.next();
                b.f.b.h.d dVar3 = next2.d;
                boolean a3 = a(dVar3);
                if (dVar3.y() && a3) {
                    b.f.b.h.e.X(dVar3, interfaceC0013b, new b.a(), 0);
                }
                b.f.b.h.c cVar9 = dVar3.E;
                boolean z = (next2 == cVar9 && (cVar2 = dVar3.G.f) != null && cVar2.f338c) || (next2 == dVar3.G && (cVar = cVar9.f) != null && cVar.f338c);
                if (dVar3.q() != aVar || a3) {
                    if (!dVar3.y()) {
                        b.f.b.h.c cVar10 = dVar3.E;
                        if (next2 == cVar10 && dVar3.G.f == null) {
                            int d3 = cVar10.d() + c3;
                            dVar3.G(d3, dVar3.l() + d3);
                        } else {
                            b.f.b.h.c cVar11 = dVar3.G;
                            if (next2 == cVar11 && cVar10.f == null) {
                                int d4 = c3 - cVar11.d();
                                dVar3.G(d4 - dVar3.l(), d4);
                            } else if (z && !dVar3.x()) {
                                e(interfaceC0013b, dVar3);
                            }
                        }
                        g(dVar3, interfaceC0013b);
                    }
                } else if (dVar3.q() == aVar && dVar3.s >= 0 && dVar3.r >= 0 && (dVar3.c0 == 8 || (dVar3.m == 0 && dVar3.S == 0.0f))) {
                    if (!dVar3.x() && !dVar3.A && z && !dVar3.x()) {
                        f(dVar, interfaceC0013b, dVar3);
                    }
                }
            }
        }
        b.f.b.h.c i3 = dVar.i(c.a.BASELINE);
        if (i3.a == null || !i3.f338c) {
            return;
        }
        int c4 = i3.c();
        Iterator<b.f.b.h.c> it3 = i3.a.iterator();
        while (it3.hasNext()) {
            b.f.b.h.c next3 = it3.next();
            b.f.b.h.d dVar4 = next3.d;
            boolean a4 = a(dVar4);
            if (dVar4.y() && a4) {
                b.f.b.h.e.X(dVar4, interfaceC0013b, new b.a(), 0);
            }
            if (dVar4.q() != aVar || a4) {
                if (!dVar4.y() && next3 == dVar4.H) {
                    if (dVar4.y) {
                        int i4 = c4 - dVar4.W;
                        int i5 = dVar4.R + i4;
                        dVar4.V = i4;
                        dVar4.E.j(i4);
                        dVar4.G.j(i5);
                        b.f.b.h.c cVar12 = dVar4.H;
                        cVar12.f337b = c4;
                        cVar12.f338c = true;
                        dVar4.i = true;
                    }
                    g(dVar4, interfaceC0013b);
                }
            }
        }
    }
}
