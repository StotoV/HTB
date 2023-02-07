package b.k.b;

import android.util.Log;
import b.k.b.c0;
import b.k.b.k0;
import b.k.b.m;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a extends k0 implements c0.l {
    public final c0 p;
    public boolean q;
    public int r;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(b.k.b.c0 r3) {
        /*
            r2 = this;
            b.k.b.y r0 = r3.J()
            b.k.b.z<?> r1 = r3.q
            if (r1 == 0) goto Lf
            android.content.Context r1 = r1.f628c
            java.lang.ClassLoader r1 = r1.getClassLoader()
            goto L10
        Lf:
            r1 = 0
        L10:
            r2.<init>(r0, r1)
            r0 = -1
            r2.r = r0
            r2.p = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.a.<init>(b.k.b.c0):void");
    }

    @Override // b.k.b.c0.l
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (c0.M(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.g) {
            c0 c0Var = this.p;
            if (c0Var.d == null) {
                c0Var.d = new ArrayList<>();
            }
            c0Var.d.add(this);
            return true;
        }
        return true;
    }

    public void c(int i) {
        if (!this.g) {
            return;
        }
        if (c0.M(2)) {
            Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
        }
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            k0.a aVar = this.a.get(i2);
            m mVar = aVar.f567b;
            if (mVar != null) {
                mVar.r += i;
                if (c0.M(2)) {
                    StringBuilder g = c.a.a.a.a.g("Bump nesting of ");
                    g.append(aVar.f567b);
                    g.append(" to ");
                    g.append(aVar.f567b.r);
                    Log.v("FragmentManager", g.toString());
                }
            }
        }
    }

    public int d(boolean z) {
        if (!this.q) {
            if (c0.M(2)) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new x0("FragmentManager"));
                f("  ", printWriter, true);
                printWriter.close();
            }
            this.q = true;
            this.r = this.g ? this.p.i.getAndIncrement() : -1;
            this.p.A(this, z);
            return this.r;
        }
        throw new IllegalStateException("commit already called");
    }

    public void e(int i, m mVar, String str, int i2) {
        Class<?> cls = mVar.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = mVar.y;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + mVar + ": was " + mVar.y + " now " + str);
                }
                mVar.y = str;
            }
            if (i != 0) {
                if (i == -1) {
                    throw new IllegalArgumentException("Can't add fragment " + mVar + " with tag " + str + " to container view with no id");
                }
                int i3 = mVar.w;
                if (i3 != 0 && i3 != i) {
                    throw new IllegalStateException("Can't change container ID of fragment " + mVar + ": was " + mVar.w + " now " + i);
                }
                mVar.w = i;
                mVar.x = i;
            }
            b(new k0.a(i2, mVar));
            mVar.s = this.p;
            return;
        }
        StringBuilder g = c.a.a.a.a.g("Fragment ");
        g.append(cls.getCanonicalName());
        g.append(" must be a public static class to be  properly recreated from instance state.");
        throw new IllegalStateException(g.toString());
    }

    public void f(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.h);
            printWriter.print(" mIndex=");
            printWriter.print(this.r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.q);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.f565b != 0 || this.f566c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f565b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f566c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.i != 0 || this.j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.j);
            }
            if (this.k != 0 || this.l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.l);
            }
        }
        if (!this.a.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                k0.a aVar = this.a.get(i);
                switch (aVar.a) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    case 10:
                        str2 = "OP_SET_MAX_LIFECYCLE";
                        break;
                    default:
                        StringBuilder g = c.a.a.a.a.g("cmd=");
                        g.append(aVar.a);
                        str2 = g.toString();
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.f567b);
                if (z) {
                    if (aVar.f568c != 0 || aVar.d != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.f568c));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.d));
                    }
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                }
            }
        }
    }

    public void g() {
        c0 c0Var;
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            k0.a aVar = this.a.get(i);
            m mVar = aVar.f567b;
            if (mVar != null) {
                mVar.r0(false);
                int i2 = this.f;
                if (mVar.I != null || i2 != 0) {
                    mVar.g();
                    mVar.I.h = i2;
                }
                ArrayList<String> arrayList = this.m;
                ArrayList<String> arrayList2 = this.n;
                mVar.g();
                m.b bVar = mVar.I;
                bVar.i = arrayList;
                bVar.j = arrayList2;
            }
            switch (aVar.a) {
                case 1:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.b0(mVar, false);
                    this.p.a(mVar);
                    continue;
                case 2:
                default:
                    StringBuilder g = c.a.a.a.a.g("Unknown cmd: ");
                    g.append(aVar.a);
                    throw new IllegalArgumentException(g.toString());
                case 3:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.W(mVar);
                    continue;
                case 4:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.L(mVar);
                    continue;
                case 5:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.b0(mVar, false);
                    this.p.f0(mVar);
                    continue;
                case 6:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.j(mVar);
                    continue;
                case 7:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.b0(mVar, false);
                    this.p.c(mVar);
                    continue;
                case 8:
                    c0Var = this.p;
                    break;
                case 9:
                    c0Var = this.p;
                    mVar = null;
                    break;
                case 10:
                    this.p.c0(mVar, aVar.h);
                    continue;
            }
            c0Var.d0(mVar);
        }
    }

    public void h(boolean z) {
        c0 c0Var;
        for (int size = this.a.size() - 1; size >= 0; size--) {
            k0.a aVar = this.a.get(size);
            m mVar = aVar.f567b;
            if (mVar != null) {
                mVar.r0(true);
                int i = this.f;
                int i2 = 8194;
                if (i != 4097) {
                    i2 = i != 4099 ? i != 8194 ? 0 : 4097 : 4099;
                }
                if (mVar.I != null || i2 != 0) {
                    mVar.g();
                    mVar.I.h = i2;
                }
                ArrayList<String> arrayList = this.n;
                ArrayList<String> arrayList2 = this.m;
                mVar.g();
                m.b bVar = mVar.I;
                bVar.i = arrayList;
                bVar.j = arrayList2;
            }
            switch (aVar.a) {
                case 1:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.b0(mVar, true);
                    this.p.W(mVar);
                    continue;
                case 2:
                default:
                    StringBuilder g = c.a.a.a.a.g("Unknown cmd: ");
                    g.append(aVar.a);
                    throw new IllegalArgumentException(g.toString());
                case 3:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.a(mVar);
                    continue;
                case 4:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.f0(mVar);
                    continue;
                case 5:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.b0(mVar, true);
                    this.p.L(mVar);
                    continue;
                case 6:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.c(mVar);
                    continue;
                case 7:
                    mVar.l0(aVar.f568c, aVar.d, aVar.e, aVar.f);
                    this.p.b0(mVar, true);
                    this.p.j(mVar);
                    continue;
                case 8:
                    c0Var = this.p;
                    mVar = null;
                    break;
                case 9:
                    c0Var = this.p;
                    break;
                case 10:
                    this.p.c0(mVar, aVar.g);
                    continue;
            }
            c0Var.d0(mVar);
        }
    }

    public boolean i(int i) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.a.get(i2).f567b;
            int i3 = mVar != null ? mVar.x : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean j(ArrayList<a> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            m mVar = this.a.get(i4).f567b;
            int i5 = mVar != null ? mVar.x : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    a aVar = arrayList.get(i6);
                    int size2 = aVar.a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        m mVar2 = aVar.a.get(i7).f567b;
                        if ((mVar2 != null ? mVar2.x : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.r >= 0) {
            sb.append(" #");
            sb.append(this.r);
        }
        if (this.h != null) {
            sb.append(" ");
            sb.append(this.h);
        }
        sb.append("}");
        return sb.toString();
    }
}
