package b.k.b;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f605b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f606c;

    public u0(t0 t0Var, ArrayList arrayList, Map map) {
        this.f605b = arrayList;
        this.f606c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int size = this.f605b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f605b.get(i);
            String s = b.h.j.q.s(view);
            if (s != null) {
                Iterator it = this.f606c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (s.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                b.h.j.q.L(view, str);
            }
        }
    }
}
