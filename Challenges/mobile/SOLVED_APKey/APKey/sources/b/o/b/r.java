package b.o.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public final class r extends s {
    public r(RecyclerView.l lVar) {
        super(lVar, null);
    }

    @Override // b.o.b.s
    public int b(View view) {
        return this.a.B(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).bottomMargin;
    }

    @Override // b.o.b.s
    public int c(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return this.a.E(view) + ((ViewGroup.MarginLayoutParams) mVar).topMargin + ((ViewGroup.MarginLayoutParams) mVar).bottomMargin;
    }

    @Override // b.o.b.s
    public int d(View view) {
        RecyclerView.m mVar = (RecyclerView.m) view.getLayoutParams();
        return this.a.F(view) + ((ViewGroup.MarginLayoutParams) mVar).leftMargin + ((ViewGroup.MarginLayoutParams) mVar).rightMargin;
    }

    @Override // b.o.b.s
    public int e(View view) {
        return this.a.H(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.m) view.getLayoutParams())).topMargin;
    }

    @Override // b.o.b.s
    public int f() {
        return this.a.q;
    }

    @Override // b.o.b.s
    public int g() {
        RecyclerView.l lVar = this.a;
        return lVar.q - lVar.N();
    }

    @Override // b.o.b.s
    public int h() {
        return this.a.N();
    }

    @Override // b.o.b.s
    public int i() {
        return this.a.o;
    }

    @Override // b.o.b.s
    public int j() {
        return this.a.n;
    }

    @Override // b.o.b.s
    public int k() {
        return this.a.Q();
    }

    @Override // b.o.b.s
    public int l() {
        RecyclerView.l lVar = this.a;
        return (lVar.q - lVar.Q()) - this.a.N();
    }

    @Override // b.o.b.s
    public int n(View view) {
        this.a.V(view, true, this.f692c);
        return this.f692c.bottom;
    }

    @Override // b.o.b.s
    public int o(View view) {
        this.a.V(view, true, this.f692c);
        return this.f692c.top;
    }

    @Override // b.o.b.s
    public void p(int i) {
        this.a.c0(i);
    }
}
