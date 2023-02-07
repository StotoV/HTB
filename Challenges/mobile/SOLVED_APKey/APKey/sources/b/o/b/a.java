package b.o.b;

import androidx.recyclerview.widget.RecyclerView;
import b.o.b.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a implements p.a {
    public final InterfaceC0028a d;
    public b.h.i.c<b> a = new b.h.i.c<>(30);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f646b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<b> f647c = new ArrayList<>();
    public final p e = new p(this);

    /* renamed from: b.o.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0028a {
    }

    /* loaded from: classes.dex */
    public static class b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f648b;

        /* renamed from: c  reason: collision with root package name */
        public Object f649c;
        public int d;

        public b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.f648b = i2;
            this.d = i3;
            this.f649c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.a;
            if (i != bVar.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.f648b) == 1 && this.d == bVar.f648b && this.f648b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.f648b != bVar.f648b) {
                return false;
            }
            Object obj2 = this.f649c;
            Object obj3 = bVar.f649c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.f648b) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.a;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f648b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            sb.append(this.f649c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(InterfaceC0028a interfaceC0028a) {
        this.d = interfaceC0028a;
    }

    public final boolean a(int i) {
        int size = this.f647c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f647c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (f(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f648b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        int size = this.f647c.size();
        for (int i = 0; i < size; i++) {
            ((w) this.d).a(this.f647c.get(i));
        }
        l(this.f647c);
    }

    public void c() {
        b();
        int size = this.f646b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f646b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                ((w) this.d).a(bVar);
                ((w) this.d).d(bVar.f648b, bVar.d);
            } else if (i2 == 2) {
                ((w) this.d).a(bVar);
                InterfaceC0028a interfaceC0028a = this.d;
                int i3 = bVar.f648b;
                int i4 = bVar.d;
                w wVar = (w) interfaceC0028a;
                wVar.a.Q(i3, i4, true);
                RecyclerView recyclerView = wVar.a;
                recyclerView.i0 = true;
                recyclerView.f0.f108c += i4;
            } else if (i2 == 4) {
                ((w) this.d).a(bVar);
                ((w) this.d).c(bVar.f648b, bVar.d, bVar.f649c);
            } else if (i2 == 8) {
                ((w) this.d).a(bVar);
                ((w) this.d).e(bVar.f648b, bVar.d);
            }
        }
        l(this.f646b);
    }

    public final void d(b bVar) {
        int i;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m = m(bVar.f648b, i2);
        int i3 = bVar.f648b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 != 4) {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        } else {
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.d; i6++) {
            int m2 = m((i * i6) + bVar.f648b, bVar.a);
            int i7 = bVar.a;
            if (i7 == 2 ? m2 == m : i7 == 4 && m2 == m + 1) {
                i5++;
            } else {
                b h = h(i7, m, i5, bVar.f649c);
                e(h, i3);
                k(h);
                if (bVar.a == 4) {
                    i3 += i5;
                }
                m = m2;
                i5 = 1;
            }
        }
        Object obj = bVar.f649c;
        k(bVar);
        if (i5 <= 0) {
            return;
        }
        b h2 = h(bVar.a, m, i5, obj);
        e(h2, i3);
        k(h2);
    }

    public void e(b bVar, int i) {
        ((w) this.d).a(bVar);
        int i2 = bVar.a;
        if (i2 != 2) {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            ((w) this.d).c(i, bVar.d, bVar.f649c);
            return;
        }
        InterfaceC0028a interfaceC0028a = this.d;
        int i3 = bVar.d;
        w wVar = (w) interfaceC0028a;
        wVar.a.Q(i, i3, true);
        RecyclerView recyclerView = wVar.a;
        recyclerView.i0 = true;
        recyclerView.f0.f108c += i3;
    }

    public int f(int i, int i2) {
        int size = this.f647c.size();
        while (i2 < size) {
            b bVar = this.f647c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.f648b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f648b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean g() {
        return this.f646b.size() > 0;
    }

    public b h(int i, int i2, int i3, Object obj) {
        b a = this.a.a();
        if (a == null) {
            return new b(i, i2, i3, obj);
        }
        a.a = i;
        a.f648b = i2;
        a.d = i3;
        a.f649c = obj;
        return a;
    }

    public final void i(b bVar) {
        this.f647c.add(bVar);
        int i = bVar.a;
        if (i == 1) {
            ((w) this.d).d(bVar.f648b, bVar.d);
        } else if (i == 2) {
            InterfaceC0028a interfaceC0028a = this.d;
            w wVar = (w) interfaceC0028a;
            wVar.a.Q(bVar.f648b, bVar.d, false);
            wVar.a.i0 = true;
        } else if (i == 4) {
            ((w) this.d).c(bVar.f648b, bVar.d, bVar.f649c);
        } else if (i == 8) {
            ((w) this.d).e(bVar.f648b, bVar.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x018a, code lost:
        r2.remove(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x018d, code lost:
        if (r6 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x018f, code lost:
        r2.add(r3, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x014c, code lost:
        if (r4 > r12.f648b) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0176, code lost:
        if (r4 >= r12.f648b) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0178, code lost:
        r11.d = r4 - r12.d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x017d, code lost:
        r2.set(r3, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0184, code lost:
        if (r11.f648b == r11.d) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0186, code lost:
        r2.set(r7, r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            Method dump skipped, instructions count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.o.b.a.j():void");
    }

    public void k(b bVar) {
        bVar.f649c = null;
        this.a.b(bVar);
    }

    public void l(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            k(list.get(i));
        }
        list.clear();
    }

    public final int m(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        for (int size = this.f647c.size() - 1; size >= 0; size--) {
            b bVar = this.f647c.get(size);
            int i9 = bVar.a;
            if (i9 == 8) {
                int i10 = bVar.f648b;
                int i11 = bVar.d;
                if (i10 < i11) {
                    i5 = i10;
                    i4 = i11;
                } else {
                    i4 = i10;
                    i5 = i11;
                }
                if (i < i5 || i > i4) {
                    if (i < i10) {
                        if (i2 == 1) {
                            bVar.f648b = i10 + 1;
                            i6 = i11 + 1;
                        } else if (i2 == 2) {
                            bVar.f648b = i10 - 1;
                            i6 = i11 - 1;
                        }
                        bVar.d = i6;
                    }
                } else if (i5 == i10) {
                    if (i2 == 1) {
                        i8 = i11 + 1;
                    } else {
                        if (i2 == 2) {
                            i8 = i11 - 1;
                        }
                        i++;
                    }
                    bVar.d = i8;
                    i++;
                } else {
                    if (i2 == 1) {
                        i7 = i10 + 1;
                    } else {
                        if (i2 == 2) {
                            i7 = i10 - 1;
                        }
                        i--;
                    }
                    bVar.f648b = i7;
                    i--;
                }
            } else {
                int i12 = bVar.f648b;
                if (i12 > i) {
                    if (i2 == 1) {
                        i3 = i12 + 1;
                    } else if (i2 == 2) {
                        i3 = i12 - 1;
                    }
                    bVar.f648b = i3;
                } else if (i9 == 1) {
                    i -= bVar.d;
                } else if (i9 == 2) {
                    i += bVar.d;
                }
            }
        }
        for (int size2 = this.f647c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f647c.get(size2);
            if (bVar2.a == 8) {
                int i13 = bVar2.d;
                if (i13 != bVar2.f648b && i13 >= 0) {
                }
                this.f647c.remove(size2);
                k(bVar2);
            } else {
                if (bVar2.d > 0) {
                }
                this.f647c.remove(size2);
                k(bVar2);
            }
        }
        return i;
    }
}
