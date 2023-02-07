package b.b.g.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public class p extends f implements SubMenu {
    public g A;
    public f z;

    public p(Context context, f fVar, g gVar) {
        super(context);
        this.z = fVar;
        this.A = gVar;
    }

    @Override // b.b.g.e.f
    public boolean d(g gVar) {
        return this.z.d(gVar);
    }

    @Override // b.b.g.e.f
    public boolean e(f fVar, MenuItem menuItem) {
        return super.e(fVar, menuItem) || this.z.e(fVar, menuItem);
    }

    @Override // b.b.g.e.f
    public boolean f(g gVar) {
        return this.z.f(gVar);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.A;
    }

    @Override // b.b.g.e.f
    public f j() {
        return this.z.j();
    }

    @Override // b.b.g.e.f
    public boolean l() {
        return this.z.l();
    }

    @Override // b.b.g.e.f
    public boolean m() {
        return this.z.m();
    }

    @Override // b.b.g.e.f
    public boolean n() {
        return this.z.n();
    }

    @Override // b.b.g.e.f, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.z.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        u(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        u(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        u(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.A.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // b.b.g.e.f, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.z.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        u(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        u(0, charSequence, 0, null, null);
        return this;
    }
}
