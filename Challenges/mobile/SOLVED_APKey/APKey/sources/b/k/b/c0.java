package b.k.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import b.k.b.k0;
import b.k.b.m;
import b.k.b.r0;
import b.m.d;
import com.example.apkey.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class c0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ArrayList<b.k.b.a> F;
    public ArrayList<Boolean> G;
    public ArrayList<b.k.b.m> H;
    public ArrayList<n> I;
    public f0 J;

    /* renamed from: b  reason: collision with root package name */
    public boolean f529b;
    public ArrayList<b.k.b.a> d;
    public ArrayList<b.k.b.m> e;
    public OnBackPressedDispatcher g;
    public z<?> q;
    public v r;
    public b.k.b.m s;
    public b.k.b.m t;
    public b.a.e.c<Intent> w;
    public b.a.e.c<Object> x;
    public b.a.e.c<String[]> y;
    public final ArrayList<l> a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final j0 f530c = new j0();
    public final a0 f = new a0(this);
    public final b.a.b h = new c(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map<String, Bundle> j = Collections.synchronizedMap(new HashMap());
    public final Map<String, Object> k = Collections.synchronizedMap(new HashMap());
    public Map<b.k.b.m, HashSet<b.h.f.a>> l = Collections.synchronizedMap(new HashMap());
    public final r0.a m = new d();
    public final b0 n = new b0(this);
    public final CopyOnWriteArrayList<g0> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public y u = new e();
    public z0 v = new f(this);
    public ArrayDeque<k> z = new ArrayDeque<>();
    public Runnable K = new g();

    /* loaded from: classes.dex */
    public class a implements b.a.e.b<b.a.e.a> {
        public a() {
        }

        @Override // b.a.e.b
        public void a(b.a.e.a aVar) {
            StringBuilder sb;
            b.a.e.a aVar2 = aVar;
            k pollFirst = c0.this.z.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No IntentSenders were started for ");
                sb.append(this);
            } else {
                String str = pollFirst.f535b;
                int i = pollFirst.f536c;
                b.k.b.m e = c0.this.f530c.e(str);
                if (e != null) {
                    e.G(i, aVar2.f126b, aVar2.f127c);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Intent Sender result delivered for unknown Fragment ");
                sb.append(str);
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.e.b<Map<String, Boolean>> {
        public b() {
        }

        @Override // b.a.e.b
        @SuppressLint({"SyntheticAccessor"})
        public void a(Map<String, Boolean> map) {
            String d;
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            k pollFirst = c0.this.z.pollFirst();
            if (pollFirst == null) {
                d = "No permissions were requested for " + this;
            } else {
                String str = pollFirst.f535b;
                b.k.b.m e = c0.this.f530c.e(str);
                if (e != null) {
                    e.Y();
                    return;
                }
                d = c.a.a.a.a.d("Permission request result delivered for unknown Fragment ", str);
            }
            Log.w("FragmentManager", d);
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.b {
        public c(boolean z) {
            super(z);
        }

        @Override // b.a.b
        public void a() {
            c0 c0Var = c0.this;
            c0Var.C(true);
            if (c0Var.h.a) {
                c0Var.U();
            } else {
                c0Var.g.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements r0.a {
        public d() {
        }

        public void a(b.k.b.m mVar, b.h.f.a aVar) {
            boolean z;
            synchronized (aVar) {
                z = aVar.a;
            }
            if (!z) {
                c0 c0Var = c0.this;
                HashSet<b.h.f.a> hashSet = c0Var.l.get(mVar);
                if (hashSet == null || !hashSet.remove(aVar) || !hashSet.isEmpty()) {
                    return;
                }
                c0Var.l.remove(mVar);
                if (mVar.f575b >= 5) {
                    return;
                }
                c0Var.i(mVar);
                c0Var.S(mVar, c0Var.p);
            }
        }

        public void b(b.k.b.m mVar, b.h.f.a aVar) {
            c0 c0Var = c0.this;
            if (c0Var.l.get(mVar) == null) {
                c0Var.l.put(mVar, new HashSet<>());
            }
            c0Var.l.get(mVar).add(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class e extends y {
        public e() {
        }

        @Override // b.k.b.y
        public b.k.b.m a(ClassLoader classLoader, String str) {
            z<?> zVar = c0.this.q;
            Context context = zVar.f628c;
            zVar.getClass();
            Object obj = b.k.b.m.T;
            try {
                return y.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                throw new m.c(c.a.a.a.a.e("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
            } catch (InstantiationException e2) {
                throw new m.c(c.a.a.a.a.e("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
            } catch (NoSuchMethodException e3) {
                throw new m.c(c.a.a.a.a.e("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
            } catch (InvocationTargetException e4) {
                throw new m.c(c.a.a.a.a.e("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements z0 {
        public f(c0 c0Var) {
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.C(true);
        }
    }

    /* loaded from: classes.dex */
    public class h implements g0 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.k.b.m f534b;

        public h(c0 c0Var, b.k.b.m mVar) {
            this.f534b = mVar;
        }

        @Override // b.k.b.g0
        public void e(c0 c0Var, b.k.b.m mVar) {
            this.f534b.J();
        }
    }

    /* loaded from: classes.dex */
    public class i implements b.a.e.b<b.a.e.a> {
        public i() {
        }

        @Override // b.a.e.b
        public void a(b.a.e.a aVar) {
            StringBuilder sb;
            b.a.e.a aVar2 = aVar;
            k pollFirst = c0.this.z.pollFirst();
            if (pollFirst == null) {
                sb = new StringBuilder();
                sb.append("No Activities were started for result for ");
                sb.append(this);
            } else {
                String str = pollFirst.f535b;
                int i = pollFirst.f536c;
                b.k.b.m e = c0.this.f530c.e(str);
                if (e != null) {
                    e.G(i, aVar2.f126b, aVar2.f127c);
                    return;
                }
                sb = new StringBuilder();
                sb.append("Activity result delivered for unknown Fragment ");
                sb.append(str);
            }
            Log.w("FragmentManager", sb.toString());
        }
    }

    /* loaded from: classes.dex */
    public static class j extends b.a.e.f.a<Object, b.a.e.a> {
        @Override // b.a.e.f.a
        public b.a.e.a a(int i, Intent intent) {
            return new b.a.e.a(i, intent);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class k implements Parcelable {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public String f535b;

        /* renamed from: c  reason: collision with root package name */
        public int f536c;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<k> {
            @Override // android.os.Parcelable.Creator
            public k createFromParcel(Parcel parcel) {
                return new k(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public k[] newArray(int i) {
                return new k[i];
            }
        }

        public k(Parcel parcel) {
            this.f535b = parcel.readString();
            this.f536c = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f535b);
            parcel.writeInt(this.f536c);
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a(ArrayList<b.k.b.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    public class m implements l {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f537b;

        public m(String str, int i, int i2) {
            this.a = i;
            this.f537b = i2;
        }

        @Override // b.k.b.c0.l
        public boolean a(ArrayList<b.k.b.a> arrayList, ArrayList<Boolean> arrayList2) {
            b.k.b.m mVar = c0.this.t;
            if (mVar == null || this.a >= 0 || !mVar.i().U()) {
                return c0.this.V(arrayList, arrayList2, null, this.a, this.f537b);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class n implements m.e {
        public final boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final b.k.b.a f539b;

        /* renamed from: c  reason: collision with root package name */
        public int f540c;

        public void a() {
            boolean z = this.f540c > 0;
            for (b.k.b.m mVar : this.f539b.p.f530c.i()) {
                mVar.q0(null);
                if (z && mVar.D()) {
                    mVar.s0();
                }
            }
            b.k.b.a aVar = this.f539b;
            aVar.p.g(aVar, this.a, !z, true);
        }
    }

    public static boolean M(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public void A(l lVar, boolean z) {
        if (!z) {
            if (this.q == null) {
                if (!this.D) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else if (Q()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.q == null) {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
                return;
            }
            this.a.add(lVar);
            a0();
        }
    }

    public final void B(boolean z) {
        if (!this.f529b) {
            if (this.q == null) {
                if (!this.D) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            } else if (Looper.myLooper() != this.q.d.getLooper()) {
                throw new IllegalStateException("Must be called from main thread of fragment host");
            } else {
                if (!z && Q()) {
                    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                }
                if (this.F == null) {
                    this.F = new ArrayList<>();
                    this.G = new ArrayList<>();
                }
                this.f529b = true;
                try {
                    F(null, null);
                    return;
                } finally {
                    this.f529b = false;
                }
            }
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    public boolean C(boolean z) {
        boolean z2;
        B(z);
        boolean z3 = false;
        while (true) {
            ArrayList<b.k.b.a> arrayList = this.F;
            ArrayList<Boolean> arrayList2 = this.G;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    z2 = false;
                } else {
                    int size = this.a.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z2 |= this.a.get(i2).a(arrayList, arrayList2);
                    }
                    this.a.clear();
                    this.q.d.removeCallbacks(this.K);
                }
            }
            if (!z2) {
                h0();
                x();
                this.f530c.b();
                return z3;
            }
            this.f529b = true;
            try {
                X(this.F, this.G);
                e();
                z3 = true;
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
    }

    public void D(l lVar, boolean z) {
        if (!z || (this.q != null && !this.D)) {
            B(z);
            ((b.k.b.a) lVar).a(this.F, this.G);
            this.f529b = true;
            try {
                X(this.F, this.G);
                e();
                h0();
                x();
                this.f530c.b();
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
    }

    public final void E(ArrayList<b.k.b.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        int i5;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z = arrayList.get(i2).o;
        ArrayList<b.k.b.m> arrayList4 = this.H;
        if (arrayList4 == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.H.addAll(this.f530c.i());
        b.k.b.m mVar = this.t;
        int i6 = i2;
        boolean z2 = false;
        while (true) {
            int i7 = 1;
            if (i6 < i3) {
                b.k.b.a aVar = arrayList.get(i6);
                int i8 = 3;
                if (!arrayList3.get(i6).booleanValue()) {
                    ArrayList<b.k.b.m> arrayList5 = this.H;
                    int i9 = 0;
                    while (i9 < aVar.a.size()) {
                        k0.a aVar2 = aVar.a.get(i9);
                        int i10 = aVar2.a;
                        if (i10 != i7) {
                            if (i10 != 2) {
                                if (i10 == i8 || i10 == 6) {
                                    arrayList5.remove(aVar2.f567b);
                                    b.k.b.m mVar2 = aVar2.f567b;
                                    if (mVar2 == mVar) {
                                        aVar.a.add(i9, new k0.a(9, mVar2));
                                        i9++;
                                        i4 = 1;
                                        mVar = null;
                                        i9 += i4;
                                        i7 = 1;
                                        i8 = 3;
                                    }
                                } else if (i10 != 7) {
                                    if (i10 == 8) {
                                        aVar.a.add(i9, new k0.a(9, mVar));
                                        i9++;
                                        mVar = aVar2.f567b;
                                    }
                                }
                                i4 = 1;
                                i9 += i4;
                                i7 = 1;
                                i8 = 3;
                            } else {
                                b.k.b.m mVar3 = aVar2.f567b;
                                int i11 = mVar3.x;
                                int size = arrayList5.size() - 1;
                                boolean z3 = false;
                                while (size >= 0) {
                                    b.k.b.m mVar4 = arrayList5.get(size);
                                    if (mVar4.x != i11) {
                                        i5 = i11;
                                    } else if (mVar4 == mVar3) {
                                        i5 = i11;
                                        z3 = true;
                                    } else {
                                        if (mVar4 == mVar) {
                                            i5 = i11;
                                            aVar.a.add(i9, new k0.a(9, mVar4));
                                            i9++;
                                            mVar = null;
                                        } else {
                                            i5 = i11;
                                        }
                                        k0.a aVar3 = new k0.a(3, mVar4);
                                        aVar3.f568c = aVar2.f568c;
                                        aVar3.e = aVar2.e;
                                        aVar3.d = aVar2.d;
                                        aVar3.f = aVar2.f;
                                        aVar.a.add(i9, aVar3);
                                        arrayList5.remove(mVar4);
                                        i9++;
                                    }
                                    size--;
                                    i11 = i5;
                                }
                                if (z3) {
                                    aVar.a.remove(i9);
                                    i9--;
                                    i4 = 1;
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                } else {
                                    i4 = 1;
                                    aVar2.a = 1;
                                    arrayList5.add(mVar3);
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                }
                            }
                        }
                        i4 = 1;
                        arrayList5.add(aVar2.f567b);
                        i9 += i4;
                        i7 = 1;
                        i8 = 3;
                    }
                } else {
                    int i12 = 1;
                    ArrayList<b.k.b.m> arrayList6 = this.H;
                    int size2 = aVar.a.size() - 1;
                    while (size2 >= 0) {
                        k0.a aVar4 = aVar.a.get(size2);
                        int i13 = aVar4.a;
                        if (i13 != i12) {
                            if (i13 != 3) {
                                switch (i13) {
                                    case 8:
                                        mVar = null;
                                        break;
                                    case 9:
                                        mVar = aVar4.f567b;
                                        break;
                                    case 10:
                                        aVar4.h = aVar4.g;
                                        break;
                                }
                                size2--;
                                i12 = 1;
                            }
                            arrayList6.add(aVar4.f567b);
                            size2--;
                            i12 = 1;
                        }
                        arrayList6.remove(aVar4.f567b);
                        size2--;
                        i12 = 1;
                    }
                }
                z2 = z2 || aVar.g;
                i6++;
                arrayList3 = arrayList2;
            } else {
                this.H.clear();
                if (!z && this.p >= 1) {
                    for (int i14 = i2; i14 < i3; i14++) {
                        Iterator<k0.a> it = arrayList.get(i14).a.iterator();
                        while (it.hasNext()) {
                            b.k.b.m mVar5 = it.next().f567b;
                            if (mVar5 != null && mVar5.s != null) {
                                this.f530c.j(h(mVar5));
                            }
                        }
                    }
                }
                int i15 = i2;
                while (i15 < i3) {
                    b.k.b.a aVar5 = arrayList.get(i15);
                    if (arrayList2.get(i15).booleanValue()) {
                        aVar5.c(-1);
                        aVar5.h(i15 == i3 + (-1));
                    } else {
                        aVar5.c(1);
                        aVar5.g();
                    }
                    i15++;
                }
                boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                for (int i16 = i2; i16 < i3; i16++) {
                    b.k.b.a aVar6 = arrayList.get(i16);
                    if (booleanValue) {
                        for (int size3 = aVar6.a.size() - 1; size3 >= 0; size3--) {
                            b.k.b.m mVar6 = aVar6.a.get(size3).f567b;
                            if (mVar6 != null) {
                                h(mVar6).k();
                            }
                        }
                    } else {
                        Iterator<k0.a> it2 = aVar6.a.iterator();
                        while (it2.hasNext()) {
                            b.k.b.m mVar7 = it2.next().f567b;
                            if (mVar7 != null) {
                                h(mVar7).k();
                            }
                        }
                    }
                }
                R(this.p, true);
                HashSet hashSet = new HashSet();
                for (int i17 = i2; i17 < i3; i17++) {
                    Iterator<k0.a> it3 = arrayList.get(i17).a.iterator();
                    while (it3.hasNext()) {
                        b.k.b.m mVar8 = it3.next().f567b;
                        if (mVar8 != null && (viewGroup = mVar8.E) != null) {
                            hashSet.add(y0.g(viewGroup, K()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    y0 y0Var = (y0) it4.next();
                    y0Var.d = booleanValue;
                    y0Var.h();
                    y0Var.c();
                }
                for (int i18 = i2; i18 < i3; i18++) {
                    b.k.b.a aVar7 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue() && aVar7.r >= 0) {
                        aVar7.r = -1;
                    }
                    aVar7.getClass();
                }
                return;
            }
        }
    }

    public final void F(ArrayList<b.k.b.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<n> arrayList3 = this.I;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            n nVar = this.I.get(i2);
            if (arrayList == null || nVar.a || (indexOf2 = arrayList.indexOf(nVar.f539b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((nVar.f540c == 0) || (arrayList != null && nVar.f539b.j(arrayList, 0, arrayList.size()))) {
                    this.I.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || nVar.a || (indexOf = arrayList.indexOf(nVar.f539b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        nVar.a();
                    }
                }
                i2++;
            } else {
                this.I.remove(i2);
                i2--;
                size--;
            }
            b.k.b.a aVar = nVar.f539b;
            aVar.p.g(aVar, nVar.a, false, false);
            i2++;
        }
    }

    public b.k.b.m G(String str) {
        return this.f530c.d(str);
    }

    public b.k.b.m H(int i2) {
        j0 j0Var = this.f530c;
        int size = j0Var.a.size();
        while (true) {
            size--;
            if (size < 0) {
                for (i0 i0Var : j0Var.f562b.values()) {
                    if (i0Var != null) {
                        b.k.b.m mVar = i0Var.f559c;
                        if (mVar.w == i2) {
                            return mVar;
                        }
                    }
                }
                return null;
            }
            b.k.b.m mVar2 = j0Var.a.get(size);
            if (mVar2 != null && mVar2.w == i2) {
                return mVar2;
            }
        }
    }

    public final ViewGroup I(b.k.b.m mVar) {
        ViewGroup viewGroup = mVar.E;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (mVar.x > 0 && this.r.h()) {
            View g2 = this.r.g(mVar.x);
            if (g2 instanceof ViewGroup) {
                return (ViewGroup) g2;
            }
        }
        return null;
    }

    public y J() {
        b.k.b.m mVar = this.s;
        return mVar != null ? mVar.s.J() : this.u;
    }

    public z0 K() {
        b.k.b.m mVar = this.s;
        return mVar != null ? mVar.s.K() : this.v;
    }

    public void L(b.k.b.m mVar) {
        if (M(2)) {
            Log.v("FragmentManager", "hide: " + mVar);
        }
        if (!mVar.z) {
            mVar.z = true;
            mVar.J = true ^ mVar.J;
            e0(mVar);
        }
    }

    public final boolean N(b.k.b.m mVar) {
        c0 c0Var = mVar.u;
        Iterator it = ((ArrayList) c0Var.f530c.g()).iterator();
        boolean z = false;
        while (it.hasNext()) {
            b.k.b.m mVar2 = (b.k.b.m) it.next();
            if (mVar2 != null) {
                z = c0Var.N(mVar2);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public boolean O(b.k.b.m mVar) {
        c0 c0Var;
        if (mVar == null) {
            return true;
        }
        return mVar.C && ((c0Var = mVar.s) == null || c0Var.O(mVar.v));
    }

    public boolean P(b.k.b.m mVar) {
        if (mVar == null) {
            return true;
        }
        c0 c0Var = mVar.s;
        return mVar.equals(c0Var.t) && P(c0Var.s);
    }

    public boolean Q() {
        return this.B || this.C;
    }

    public void R(int i2, boolean z) {
        z<?> zVar;
        if (this.q != null || i2 == -1) {
            if (!z && i2 == this.p) {
                return;
            }
            this.p = i2;
            j0 j0Var = this.f530c;
            Iterator<b.k.b.m> it = j0Var.a.iterator();
            while (it.hasNext()) {
                i0 i0Var = j0Var.f562b.get(it.next().f);
                if (i0Var != null) {
                    i0Var.k();
                }
            }
            Iterator<i0> it2 = j0Var.f562b.values().iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                i0 next = it2.next();
                if (next != null) {
                    next.k();
                    b.k.b.m mVar = next.f559c;
                    if (mVar.m && !mVar.C()) {
                        z2 = true;
                    }
                    if (z2) {
                        j0Var.k(next);
                    }
                }
            }
            g0();
            if (!this.A || (zVar = this.q) == null || this.p != 7) {
                return;
            }
            zVar.l();
            this.A = false;
            return;
        }
        throw new IllegalStateException("No activity");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != 5) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void S(b.k.b.m r17, int r18) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.c0.S(b.k.b.m, int):void");
    }

    public void T() {
        if (this.q == null) {
            return;
        }
        this.B = false;
        this.C = false;
        this.J.g = false;
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                mVar.u.T();
            }
        }
    }

    public boolean U() {
        C(false);
        B(true);
        b.k.b.m mVar = this.t;
        if (mVar == null || !mVar.i().U()) {
            boolean V = V(this.F, this.G, null, -1, 0);
            if (V) {
                this.f529b = true;
                try {
                    X(this.F, this.G);
                } finally {
                    e();
                }
            }
            h0();
            x();
            this.f530c.b();
            return V;
        }
        return true;
    }

    public boolean V(ArrayList<b.k.b.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<b.k.b.a> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    b.k.b.a aVar = this.d.get(size2);
                    if ((str != null && str.equals(aVar.h)) || (i2 >= 0 && i2 == aVar.r)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        b.k.b.a aVar2 = this.d.get(size2);
                        if (str == null || !str.equals(aVar2.h)) {
                            if (i2 < 0 || i2 != aVar2.r) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public void W(b.k.b.m mVar) {
        if (M(2)) {
            Log.v("FragmentManager", "remove: " + mVar + " nesting=" + mVar.r);
        }
        boolean z = !mVar.C();
        if (!mVar.A || z) {
            this.f530c.l(mVar);
            if (N(mVar)) {
                this.A = true;
            }
            mVar.m = true;
            e0(mVar);
        }
    }

    public final void X(ArrayList<b.k.b.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        F(arrayList, arrayList2);
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            if (!arrayList.get(i2).o) {
                if (i3 != i2) {
                    E(arrayList, arrayList2, i3, i2);
                }
                i3 = i2 + 1;
                if (arrayList2.get(i2).booleanValue()) {
                    while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).o) {
                        i3++;
                    }
                }
                E(arrayList, arrayList2, i2, i3);
                i2 = i3 - 1;
            }
            i2++;
        }
        if (i3 == size) {
            return;
        }
        E(arrayList, arrayList2, i3, size);
    }

    public void Y(Parcelable parcelable) {
        i0 i0Var;
        if (parcelable == null) {
            return;
        }
        e0 e0Var = (e0) parcelable;
        if (e0Var.f543b == null) {
            return;
        }
        this.f530c.f562b.clear();
        Iterator<h0> it = e0Var.f543b.iterator();
        while (it.hasNext()) {
            h0 next = it.next();
            if (next != null) {
                b.k.b.m mVar = this.J.f548b.get(next.f555c);
                if (mVar != null) {
                    if (M(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + mVar);
                    }
                    i0Var = new i0(this.n, this.f530c, mVar, next);
                } else {
                    i0Var = new i0(this.n, this.f530c, this.q.f628c.getClassLoader(), J(), next);
                }
                b.k.b.m mVar2 = i0Var.f559c;
                mVar2.s = this;
                if (M(2)) {
                    StringBuilder g2 = c.a.a.a.a.g("restoreSaveState: active (");
                    g2.append(mVar2.f);
                    g2.append("): ");
                    g2.append(mVar2);
                    Log.v("FragmentManager", g2.toString());
                }
                i0Var.m(this.q.f628c.getClassLoader());
                this.f530c.j(i0Var);
                i0Var.e = this.p;
            }
        }
        f0 f0Var = this.J;
        f0Var.getClass();
        Iterator it2 = new ArrayList(f0Var.f548b.values()).iterator();
        while (it2.hasNext()) {
            b.k.b.m mVar3 = (b.k.b.m) it2.next();
            if (!this.f530c.c(mVar3.f)) {
                if (M(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + mVar3 + " that was not found in the set of active Fragments " + e0Var.f543b);
                }
                this.J.b(mVar3);
                mVar3.s = this;
                i0 i0Var2 = new i0(this.n, this.f530c, mVar3);
                i0Var2.e = 1;
                i0Var2.k();
                mVar3.m = true;
                i0Var2.k();
            }
        }
        j0 j0Var = this.f530c;
        ArrayList<String> arrayList = e0Var.f544c;
        j0Var.a.clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                b.k.b.m d2 = j0Var.d(str);
                if (d2 == null) {
                    throw new IllegalStateException(c.a.a.a.a.e("No instantiated fragment for (", str, ")"));
                }
                if (M(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + d2);
                }
                j0Var.a(d2);
            }
        }
        if (e0Var.d != null) {
            this.d = new ArrayList<>(e0Var.d.length);
            int i2 = 0;
            while (true) {
                b.k.b.b[] bVarArr = e0Var.d;
                if (i2 >= bVarArr.length) {
                    break;
                }
                b.k.b.b bVar = bVarArr[i2];
                bVar.getClass();
                b.k.b.a aVar = new b.k.b.a(this);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    int[] iArr = bVar.f521b;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    k0.a aVar2 = new k0.a();
                    int i5 = i3 + 1;
                    aVar2.a = iArr[i3];
                    if (M(2)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i4 + " base fragment #" + bVar.f521b[i5]);
                    }
                    String str2 = bVar.f522c.get(i4);
                    aVar2.f567b = str2 != null ? this.f530c.d(str2) : null;
                    aVar2.g = d.b.values()[bVar.d[i4]];
                    aVar2.h = d.b.values()[bVar.e[i4]];
                    int[] iArr2 = bVar.f521b;
                    int i6 = i5 + 1;
                    int i7 = iArr2[i5];
                    aVar2.f568c = i7;
                    int i8 = i6 + 1;
                    int i9 = iArr2[i6];
                    aVar2.d = i9;
                    int i10 = i8 + 1;
                    int i11 = iArr2[i8];
                    aVar2.e = i11;
                    int i12 = iArr2[i10];
                    aVar2.f = i12;
                    aVar.f565b = i7;
                    aVar.f566c = i9;
                    aVar.d = i11;
                    aVar.e = i12;
                    aVar.b(aVar2);
                    i4++;
                    i3 = i10 + 1;
                }
                aVar.f = bVar.f;
                aVar.h = bVar.g;
                aVar.r = bVar.h;
                aVar.g = true;
                aVar.i = bVar.i;
                aVar.j = bVar.j;
                aVar.k = bVar.k;
                aVar.l = bVar.l;
                aVar.m = bVar.m;
                aVar.n = bVar.n;
                aVar.o = bVar.o;
                aVar.c(1);
                if (M(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i2 + " (index " + aVar.r + "): " + aVar);
                    PrintWriter printWriter = new PrintWriter(new x0("FragmentManager"));
                    aVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVar);
                i2++;
            }
        } else {
            this.d = null;
        }
        this.i.set(e0Var.e);
        String str3 = e0Var.f;
        if (str3 != null) {
            b.k.b.m G = G(str3);
            this.t = G;
            t(G);
        }
        ArrayList<String> arrayList2 = e0Var.g;
        if (arrayList2 != null) {
            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                Bundle bundle = e0Var.h.get(i13);
                bundle.setClassLoader(this.q.f628c.getClassLoader());
                this.j.put(arrayList2.get(i13), bundle);
            }
        }
        this.z = new ArrayDeque<>(e0Var.i);
    }

    public Parcelable Z() {
        int i2;
        b.k.b.b[] bVarArr;
        ArrayList<String> arrayList;
        int size;
        Iterator it = ((HashSet) f()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var = (y0) it.next();
            if (y0Var.e) {
                y0Var.e = false;
                y0Var.c();
            }
        }
        z();
        C(true);
        this.B = true;
        this.J.g = true;
        j0 j0Var = this.f530c;
        j0Var.getClass();
        ArrayList<h0> arrayList2 = new ArrayList<>(j0Var.f562b.size());
        Iterator<i0> it2 = j0Var.f562b.values().iterator();
        while (true) {
            bVarArr = null;
            Bundle bundle = null;
            bVarArr = null;
            if (!it2.hasNext()) {
                break;
            }
            i0 next = it2.next();
            if (next != null) {
                b.k.b.m mVar = next.f559c;
                h0 h0Var = new h0(mVar);
                b.k.b.m mVar2 = next.f559c;
                if (mVar2.f575b <= -1 || h0Var.n != null) {
                    h0Var.n = mVar2.f576c;
                } else {
                    Bundle bundle2 = new Bundle();
                    b.k.b.m mVar3 = next.f559c;
                    mVar3.Z(bundle2);
                    mVar3.R.b(bundle2);
                    Parcelable Z = mVar3.u.Z();
                    if (Z != null) {
                        bundle2.putParcelable("android:support:fragments", Z);
                    }
                    next.a.j(next.f559c, bundle2, false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (next.f559c.F != null) {
                        next.o();
                    }
                    if (next.f559c.d != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", next.f559c.d);
                    }
                    if (next.f559c.e != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", next.f559c.e);
                    }
                    if (!next.f559c.H) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", next.f559c.H);
                    }
                    h0Var.n = bundle;
                    if (next.f559c.i != null) {
                        if (bundle == null) {
                            h0Var.n = new Bundle();
                        }
                        h0Var.n.putString("android:target_state", next.f559c.i);
                        int i3 = next.f559c.j;
                        if (i3 != 0) {
                            h0Var.n.putInt("android:target_req_state", i3);
                        }
                    }
                }
                arrayList2.add(h0Var);
                if (M(2)) {
                    Log.v("FragmentManager", "Saved state of " + mVar + ": " + h0Var.n);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (M(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        j0 j0Var2 = this.f530c;
        synchronized (j0Var2.a) {
            if (j0Var2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(j0Var2.a.size());
                Iterator<b.k.b.m> it3 = j0Var2.a.iterator();
                while (it3.hasNext()) {
                    b.k.b.m next2 = it3.next();
                    arrayList.add(next2.f);
                    if (M(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.f + "): " + next2);
                    }
                }
            }
        }
        ArrayList<b.k.b.a> arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new b.k.b.b[size];
            for (i2 = 0; i2 < size; i2++) {
                bVarArr[i2] = new b.k.b.b(this.d.get(i2));
                if (M(2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.d.get(i2));
                }
            }
        }
        e0 e0Var = new e0();
        e0Var.f543b = arrayList2;
        e0Var.f544c = arrayList;
        e0Var.d = bVarArr;
        e0Var.e = this.i.get();
        b.k.b.m mVar4 = this.t;
        if (mVar4 != null) {
            e0Var.f = mVar4.f;
        }
        e0Var.g.addAll(this.j.keySet());
        e0Var.h.addAll(this.j.values());
        e0Var.i = new ArrayList<>(this.z);
        return e0Var;
    }

    public i0 a(b.k.b.m mVar) {
        if (M(2)) {
            Log.v("FragmentManager", "add: " + mVar);
        }
        i0 h2 = h(mVar);
        mVar.s = this;
        this.f530c.j(h2);
        if (!mVar.A) {
            this.f530c.a(mVar);
            mVar.m = false;
            if (mVar.F == null) {
                mVar.J = false;
            }
            if (N(mVar)) {
                this.A = true;
            }
        }
        return h2;
    }

    public void a0() {
        synchronized (this.a) {
            ArrayList<n> arrayList = this.I;
            boolean z = false;
            boolean z2 = arrayList != null && !arrayList.isEmpty();
            if (this.a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.q.d.removeCallbacks(this.K);
                this.q.d.post(this.K);
                h0();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"SyntheticAccessor"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(b.k.b.z<?> r5, b.k.b.v r6, b.k.b.m r7) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.c0.b(b.k.b.z, b.k.b.v, b.k.b.m):void");
    }

    public void b0(b.k.b.m mVar, boolean z) {
        ViewGroup I = I(mVar);
        if (I == null || !(I instanceof w)) {
            return;
        }
        ((w) I).setDrawDisappearingViewsLast(!z);
    }

    public void c(b.k.b.m mVar) {
        if (M(2)) {
            Log.v("FragmentManager", "attach: " + mVar);
        }
        if (mVar.A) {
            mVar.A = false;
            if (mVar.l) {
                return;
            }
            this.f530c.a(mVar);
            if (M(2)) {
                Log.v("FragmentManager", "add from attach: " + mVar);
            }
            if (!N(mVar)) {
                return;
            }
            this.A = true;
        }
    }

    public void c0(b.k.b.m mVar, d.b bVar) {
        if (mVar.equals(G(mVar.f)) && (mVar.t == null || mVar.s == this)) {
            mVar.N = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + mVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void d(b.k.b.m mVar) {
        HashSet<b.h.f.a> hashSet = this.l.get(mVar);
        if (hashSet != null) {
            Iterator<b.h.f.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            i(mVar);
            this.l.remove(mVar);
        }
    }

    public void d0(b.k.b.m mVar) {
        if (mVar == null || (mVar.equals(G(mVar.f)) && (mVar.t == null || mVar.s == this))) {
            b.k.b.m mVar2 = this.t;
            this.t = mVar;
            t(mVar2);
            t(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + mVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void e() {
        this.f529b = false;
        this.G.clear();
        this.F.clear();
    }

    public final void e0(b.k.b.m mVar) {
        ViewGroup I = I(mVar);
        if (I != null) {
            if (mVar.v() + mVar.u() + mVar.n() + mVar.k() <= 0) {
                return;
            }
            if (I.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                I.setTag(R.id.visible_removing_fragment_view_tag, mVar);
            }
            ((b.k.b.m) I.getTag(R.id.visible_removing_fragment_view_tag)).r0(mVar.t());
        }
    }

    public final Set<y0> f() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.f530c.f()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((i0) it.next()).f559c.E;
            if (viewGroup != null) {
                hashSet.add(y0.g(viewGroup, K()));
            }
        }
        return hashSet;
    }

    public void f0(b.k.b.m mVar) {
        if (M(2)) {
            Log.v("FragmentManager", "show: " + mVar);
        }
        if (mVar.z) {
            mVar.z = false;
            mVar.J = !mVar.J;
        }
    }

    public void g(b.k.b.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.h(z3);
        } else {
            aVar.g();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.p >= 1) {
            r0.p(this.q.f628c, this.r, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z3) {
            R(this.p, true);
        }
        Iterator it = ((ArrayList) this.f530c.g()).iterator();
        while (it.hasNext()) {
            b.k.b.m mVar = (b.k.b.m) it.next();
            if (mVar != null) {
                View view = mVar.F;
            }
        }
    }

    public final void g0() {
        Iterator it = ((ArrayList) this.f530c.f()).iterator();
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            b.k.b.m mVar = i0Var.f559c;
            if (mVar.G) {
                if (this.f529b) {
                    this.E = true;
                } else {
                    mVar.G = false;
                    i0Var.k();
                }
            }
        }
    }

    public i0 h(b.k.b.m mVar) {
        i0 h2 = this.f530c.h(mVar.f);
        if (h2 != null) {
            return h2;
        }
        i0 i0Var = new i0(this.n, this.f530c, mVar);
        i0Var.m(this.q.f628c.getClassLoader());
        i0Var.e = this.p;
        return i0Var;
    }

    public final void h0() {
        synchronized (this.a) {
            boolean z = true;
            if (!this.a.isEmpty()) {
                this.h.a = true;
                return;
            }
            b.a.b bVar = this.h;
            ArrayList<b.k.b.a> arrayList = this.d;
            if ((arrayList != null ? arrayList.size() : 0) <= 0 || !P(this.s)) {
                z = false;
            }
            bVar.a = z;
        }
    }

    public final void i(b.k.b.m mVar) {
        mVar.f0();
        this.n.n(mVar, false);
        mVar.E = null;
        mVar.F = null;
        mVar.P = null;
        mVar.Q.g(null);
        mVar.o = false;
    }

    public void j(b.k.b.m mVar) {
        if (M(2)) {
            Log.v("FragmentManager", "detach: " + mVar);
        }
        if (!mVar.A) {
            mVar.A = true;
            if (!mVar.l) {
                return;
            }
            if (M(2)) {
                Log.v("FragmentManager", "remove from detach: " + mVar);
            }
            this.f530c.l(mVar);
            if (N(mVar)) {
                this.A = true;
            }
            e0(mVar);
        }
    }

    public void k(Configuration configuration) {
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                mVar.onConfigurationChanged(configuration);
                mVar.u.k(configuration);
            }
        }
    }

    public boolean l(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                if (!mVar.z ? mVar.K() ? true : mVar.u.l(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public void m() {
        this.B = false;
        this.C = false;
        this.J.g = false;
        w(1);
    }

    public boolean n(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<b.k.b.m> arrayList = null;
        boolean z = false;
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null && O(mVar)) {
                if (!mVar.z ? mVar.u.n(menu, menuInflater) | false : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(mVar);
                    z = true;
                }
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                b.k.b.m mVar2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(mVar2)) {
                    mVar2.getClass();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public void o() {
        this.D = true;
        C(true);
        z();
        w(-1);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.g != null) {
            Iterator<b.a.a> it = this.h.f124b.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
            this.g = null;
        }
        b.a.e.c<Intent> cVar = this.w;
        if (cVar != null) {
            cVar.a();
            this.x.a();
            this.y.a();
        }
    }

    public void p() {
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                mVar.g0();
            }
        }
    }

    public void q(boolean z) {
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                mVar.V();
                mVar.u.q(z);
            }
        }
    }

    public boolean r(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                if (!mVar.z ? mVar.u.r(menuItem) : false) {
                    return true;
                }
            }
        }
        return false;
    }

    public void s(Menu menu) {
        if (this.p < 1) {
            return;
        }
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null && !mVar.z) {
                mVar.u.s(menu);
            }
        }
    }

    public final void t(b.k.b.m mVar) {
        if (mVar == null || !mVar.equals(G(mVar.f))) {
            return;
        }
        boolean P = mVar.s.P(mVar);
        Boolean bool = mVar.k;
        if (bool != null && bool.booleanValue() == P) {
            return;
        }
        mVar.k = Boolean.valueOf(P);
        mVar.X();
        c0 c0Var = mVar.u;
        c0Var.h0();
        c0Var.t(c0Var.t);
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        b.k.b.m mVar = this.s;
        if (mVar != null) {
            sb.append(mVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.s;
        } else {
            z<?> zVar = this.q;
            if (zVar == null) {
                sb.append("null");
                sb.append("}}");
                return sb.toString();
            }
            sb.append(zVar.getClass().getSimpleName());
            sb.append("{");
            obj = this.q;
        }
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("}");
        sb.append("}}");
        return sb.toString();
    }

    public void u(boolean z) {
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null) {
                mVar.W();
                mVar.u.u(z);
            }
        }
    }

    public boolean v(Menu menu) {
        boolean z = false;
        if (this.p < 1) {
            return false;
        }
        for (b.k.b.m mVar : this.f530c.i()) {
            if (mVar != null && O(mVar) && mVar.h0(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void w(int i2) {
        try {
            this.f529b = true;
            for (i0 i0Var : this.f530c.f562b.values()) {
                if (i0Var != null) {
                    i0Var.e = i2;
                }
            }
            R(i2, false);
            Iterator it = ((HashSet) f()).iterator();
            while (it.hasNext()) {
                ((y0) it.next()).e();
            }
            this.f529b = false;
            C(true);
        } catch (Throwable th) {
            this.f529b = false;
            throw th;
        }
    }

    public final void x() {
        if (this.E) {
            this.E = false;
            g0();
        }
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String d2 = c.a.a.a.a.d(str, "    ");
        j0 j0Var = this.f530c;
        j0Var.getClass();
        String str2 = str + "    ";
        if (!j0Var.f562b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (i0 i0Var : j0Var.f562b.values()) {
                printWriter.print(str);
                if (i0Var != null) {
                    b.k.b.m mVar = i0Var.f559c;
                    printWriter.println(mVar);
                    mVar.f(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = j0Var.a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(j0Var.a.get(i2).toString());
            }
        }
        ArrayList<b.k.b.m> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        ArrayList<b.k.b.a> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                b.k.b.a aVar = this.d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(d2, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            int size4 = this.a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size4; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((l) this.a.get(i5));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.r);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.B);
        printWriter.print(" mStopped=");
        printWriter.print(this.C);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.D);
        if (this.A) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.A);
        }
    }

    public final void z() {
        Iterator it = ((HashSet) f()).iterator();
        while (it.hasNext()) {
            ((y0) it.next()).e();
        }
    }
}
