package c.c.a.a.l;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
/* loaded from: classes.dex */
public class j extends RecyclerView.p {
    public final /* synthetic */ v a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MaterialButton f812b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f813c;

    public j(g gVar, v vVar, MaterialButton materialButton) {
        this.f813c = gVar;
        this.a = vVar;
        this.f812b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.f812b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void b(RecyclerView recyclerView, int i, int i2) {
        LinearLayoutManager u0 = this.f813c.u0();
        int k1 = i < 0 ? u0.k1() : u0.m1();
        this.f813c.Y = this.a.e(k1);
        MaterialButton materialButton = this.f812b;
        v vVar = this.a;
        materialButton.setText(vVar.d.f792b.o(k1).n(vVar.f828c));
    }
}
