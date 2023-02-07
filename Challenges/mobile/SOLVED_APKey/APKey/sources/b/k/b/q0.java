package b.k.b;

import android.graphics.Rect;
import android.view.View;
import b.k.b.r0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class q0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t0 f586b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b.e.a f587c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ r0.b e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ View g;
    public final /* synthetic */ m h;
    public final /* synthetic */ m i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ ArrayList k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Rect m;

    public q0(t0 t0Var, b.e.a aVar, Object obj, r0.b bVar, ArrayList arrayList, View view, m mVar, m mVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f586b = t0Var;
        this.f587c = aVar;
        this.d = obj;
        this.e = bVar;
        this.f = arrayList;
        this.g = view;
        this.h = mVar;
        this.i = mVar2;
        this.j = z;
        this.k = arrayList2;
        this.l = obj2;
        this.m = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.e.a<String, View> e = r0.e(this.f586b, this.f587c, this.d, this.e);
        if (e != null) {
            this.f.addAll(e.values());
            this.f.add(this.g);
        }
        r0.c(this.h, this.i, this.j, e, false);
        Object obj = this.d;
        if (obj != null) {
            this.f586b.x(obj, this.k, this.f);
            View k = r0.k(e, this.e, this.l, this.j);
            if (k == null) {
                return;
            }
            this.f586b.j(k, this.m);
        }
    }
}
