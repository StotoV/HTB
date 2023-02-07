package b.a.e;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* loaded from: classes.dex */
public abstract class d {
    public Random a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, String> f128b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Integer> f129c = new HashMap();
    public final Map<String, c> d = new HashMap();
    public ArrayList<String> e = new ArrayList<>();
    public final transient Map<String, b<?>> f = new HashMap();
    public final Map<String, Object> g = new HashMap();
    public final Bundle h = new Bundle();

    /* loaded from: classes.dex */
    public class a extends b.a.e.c<I> {
        public final /* synthetic */ String a;

        public a(String str, int i, b.a.e.f.a aVar) {
            this.a = str;
        }

        @Override // b.a.e.c
        public void a() {
            d.this.c(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class b<O> {
        public final b.a.e.b<O> a;

        /* renamed from: b  reason: collision with root package name */
        public final b.a.e.f.a<?, O> f131b;

        public b(b.a.e.b<O> bVar, b.a.e.f.a<?, O> aVar) {
            this.a = bVar;
            this.f131b = aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
    }

    public final boolean a(int i, int i2, Intent intent) {
        b.a.e.b<?> bVar;
        String str = this.f128b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.e.remove(str);
        b<?> bVar2 = this.f.get(str);
        if (bVar2 != null && (bVar = bVar2.a) != null) {
            bVar.a(bVar2.f131b.a(i2, intent));
            return true;
        }
        this.g.remove(str);
        this.h.putParcelable(str, new b.a.e.a(i2, intent));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> b.a.e.c<I> b(String str, b.a.e.f.a<I, O> aVar, b.a.e.b<O> bVar) {
        int i;
        Integer num = this.f129c.get(str);
        if (num != null) {
            i = num.intValue();
        } else {
            int nextInt = this.a.nextInt(2147418112);
            while (true) {
                i = nextInt + 65536;
                if (!this.f128b.containsKey(Integer.valueOf(i))) {
                    break;
                }
                nextInt = this.a.nextInt(2147418112);
            }
            this.f128b.put(Integer.valueOf(i), str);
            this.f129c.put(str, Integer.valueOf(i));
        }
        this.f.put(str, new b<>(bVar, aVar));
        if (this.g.containsKey(str)) {
            Object obj = this.g.get(str);
            this.g.remove(str);
            bVar.a(obj);
        }
        b.a.e.a aVar2 = (b.a.e.a) this.h.getParcelable(str);
        if (aVar2 != null) {
            this.h.remove(str);
            bVar.a(aVar.a(aVar2.f126b, aVar2.f127c));
        }
        return new a(str, i, aVar);
    }

    public final void c(String str) {
        Integer remove;
        if (!this.e.contains(str) && (remove = this.f129c.remove(str)) != null) {
            this.f128b.remove(remove);
        }
        this.f.remove(str);
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.get(str));
            this.g.remove(str);
        }
        if (this.h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.h.getParcelable(str));
            this.h.remove(str);
        }
        if (this.d.get(str) == null) {
            return;
        }
        throw null;
    }
}
