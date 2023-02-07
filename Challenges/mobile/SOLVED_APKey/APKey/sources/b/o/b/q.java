package b.o.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public final class q extends s {
    public q(RecyclerView.l lVar) {
        super(lVar, null);
    }

    @Override // b.o.b.s
    public int b(View view) {
        return this.a.G(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).rightMargin;
    }

    @Override // b.o.b.s
    public int c(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return this.a.F(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // b.o.b.s
    public int d(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return this.a.E(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // b.o.b.s
    public int e(View view) {
        return this.a.D(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).leftMargin;
    }

    @Override // b.o.b.s
    public int f() {
        return this.a.p;
    }

    @Override // b.o.b.s
    public int g() {
        RecyclerView.l lVar = this.a;
        return lVar.p - lVar.P();
    }

    @Override // b.o.b.s
    public int h() {
        return this.a.P();
    }

    @Override // b.o.b.s
    public int i() {
        return this.a.n;
    }

    @Override // b.o.b.s
    public int j() {
        return this.a.o;
    }

    @Override // b.o.b.s
    public int k() {
        return this.a.O();
    }

    @Override // b.o.b.s
    public int l() {
        RecyclerView.l lVar = this.a;
        return (lVar.p - lVar.O()) - this.a.P();
    }

    @Override // b.o.b.s
    public int n(View view) {
        this.a.V(view, true, this.f692c);
        return this.f692c.right;
    }

    @Override // b.o.b.s
    public int o(View view) {
        this.a.V(view, true, this.f692c);
        return this.f692c.left;
    }

    @Override // b.o.b.s
    public void p(int i) {
        this.a.b0(i);
    }
}
