package b.q;

import android.view.View;
import android.view.ViewGroup;
import b.q.k;
import com.example.apkey.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h0 extends n {
    public final /* synthetic */ ViewGroup a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f713b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f714c;
    public final /* synthetic */ i0 d;

    public h0(i0 i0Var, ViewGroup viewGroup, View view, View view2) {
        this.d = i0Var;
        this.a = viewGroup;
        this.f713b = view;
        this.f714c = view2;
    }

    @Override // b.q.k.d
    public void c(k kVar) {
        this.f714c.setTag(R.id.save_overlay_view, null);
        x.a(this.a).a(this.f713b);
        kVar.v(this);
    }

    @Override // b.q.n, b.q.k.d
    public void d(k kVar) {
        x.a(this.a).a(this.f713b);
    }

    @Override // b.q.n, b.q.k.d
    public void e(k kVar) {
        if (this.f713b.getParent() == null) {
            x.a(this.a).b(this.f713b);
            return;
        }
        i0 i0Var = this.d;
        int size = i0Var.n.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            i0Var.n.get(size).cancel();
        }
        ArrayList<k.d> arrayList = i0Var.r;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) i0Var.r.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((k.d) arrayList2.get(i)).b(i0Var);
        }
    }
}
