package b.k.b;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f582b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ t0 f583c;
    public final /* synthetic */ View d;
    public final /* synthetic */ m e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ Object i;

    public o0(Object obj, t0 t0Var, View view, m mVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f582b = obj;
        this.f583c = t0Var;
        this.d = view;
        this.e = mVar;
        this.f = arrayList;
        this.g = arrayList2;
        this.h = arrayList3;
        this.i = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.f582b;
        if (obj != null) {
            this.f583c.o(obj, this.d);
            this.g.addAll(r0.h(this.f583c, this.f582b, this.e, this.f, this.d));
        }
        if (this.h != null) {
            if (this.i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.d);
                this.f583c.p(this.i, this.h, arrayList);
            }
            this.h.clear();
            this.h.add(this.d);
        }
    }
}
