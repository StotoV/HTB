package b.k.b;

import b.m.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: b  reason: collision with root package name */
    public int f565b;

    /* renamed from: c  reason: collision with root package name */
    public int f566c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public CharSequence j;
    public int k;
    public CharSequence l;
    public ArrayList<String> m;
    public ArrayList<String> n;
    public ArrayList<a> a = new ArrayList<>();
    public boolean o = false;

    /* loaded from: classes.dex */
    public static final class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public m f567b;

        /* renamed from: c  reason: collision with root package name */
        public int f568c;
        public int d;
        public int e;
        public int f;
        public d.b g;
        public d.b h;

        public a() {
        }

        public a(int i, m mVar) {
            this.a = i;
            this.f567b = mVar;
            d.b bVar = d.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }
    }

    public k0(y yVar, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.a.add(aVar);
        aVar.f568c = this.f565b;
        aVar.d = this.f566c;
        aVar.e = this.d;
        aVar.f = this.e;
    }
}
