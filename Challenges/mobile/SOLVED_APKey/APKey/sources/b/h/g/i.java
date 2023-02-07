package b.h.g;

import b.h.g.j;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements b.h.i.a<j.a> {
    public final /* synthetic */ String a;

    public i(String str) {
        this.a = str;
    }

    @Override // b.h.i.a
    /* renamed from: b */
    public void a(j.a aVar) {
        synchronized (j.f437c) {
            b.e.f<String, ArrayList<b.h.i.a<j.a>>> fVar = j.d;
            ArrayList<b.h.i.a<j.a>> arrayList = fVar.get(this.a);
            if (arrayList == null) {
                return;
            }
            fVar.remove(this.a);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).a(aVar);
            }
        }
    }
}
