package b.n.a;

import b.m.g;
import b.m.l;
import b.m.m;
import b.m.p;
import b.m.q;
import b.m.r;
import b.m.s;
import b.m.t;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class b extends b.n.a.a {
    public final g a;

    /* renamed from: b  reason: collision with root package name */
    public final C0027b f643b;

    /* loaded from: classes.dex */
    public static class a<D> extends l<D> {
        @Override // androidx.lifecycle.LiveData
        public void d() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void e() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void f(m<? super D> mVar) {
            super.f(mVar);
        }

        @Override // b.m.l
        public void g(D d) {
            super.g(d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            b.h.b.a.d(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: b.n.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0027b extends p {

        /* renamed from: c  reason: collision with root package name */
        public static final q f644c = new a();

        /* renamed from: b  reason: collision with root package name */
        public b.e.g<a> f645b = new b.e.g<>();

        /* renamed from: b.n.a.b$b$a */
        /* loaded from: classes.dex */
        public static class a implements q {
            public <T extends p> T a(Class<T> cls) {
                return new C0027b();
            }
        }

        @Override // b.m.p
        public void a() {
            if (this.f645b.g() <= 0) {
                b.e.g<a> gVar = this.f645b;
                int i = gVar.d;
                Object[] objArr = gVar.f319c;
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = null;
                }
                gVar.d = 0;
                return;
            }
            this.f645b.h(0).getClass();
            throw null;
        }
    }

    public b(g gVar, t tVar) {
        this.a = gVar;
        q qVar = C0027b.f644c;
        String canonicalName = C0027b.class.getCanonicalName();
        if (canonicalName != null) {
            String d = c.a.a.a.a.d("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            p pVar = tVar.a.get(d);
            if (!C0027b.class.isInstance(pVar)) {
                pVar = qVar instanceof r ? ((r) qVar).a(d, C0027b.class) : ((C0027b.a) qVar).a(C0027b.class);
                p put = tVar.a.put(d, pVar);
                if (put != null) {
                    put.a();
                }
            } else if (qVar instanceof s) {
                s sVar = (s) qVar;
            }
            this.f643b = (C0027b) pVar;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // b.n.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        C0027b c0027b = this.f643b;
        if (c0027b.f645b.g() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (c0027b.f645b.g() <= 0) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(c0027b.f645b.e(0));
            printWriter.print(": ");
            printWriter.println(c0027b.f645b.h(0).toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            throw null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        b.h.b.a.d(this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
