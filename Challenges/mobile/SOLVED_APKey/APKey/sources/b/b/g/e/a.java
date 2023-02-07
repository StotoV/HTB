package b.b.g.e;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* loaded from: classes.dex */
public class a implements b.h.e.a.b {
    public CharSequence a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f166b;

    /* renamed from: c  reason: collision with root package name */
    public Intent f167c;
    public char d;
    public char f;
    public Drawable h;
    public Context i;
    public CharSequence j;
    public CharSequence k;
    public int e = 4096;
    public int g = 4096;
    public ColorStateList l = null;
    public PorterDuff.Mode m = null;
    public boolean n = false;
    public boolean o = false;
    public int p = 16;

    public a(Context context, int i, int i2, int i3, CharSequence charSequence) {
        this.i = context;
        this.a = charSequence;
    }

    @Override // b.h.e.a.b
    public b.h.j.b a() {
        return null;
    }

    @Override // b.h.e.a.b
    public b.h.e.a.b b(b.h.j.b bVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.h;
        if (drawable != null) {
            if (!this.n && !this.o) {
                return;
            }
            Drawable l0 = b.h.b.a.l0(drawable);
            this.h = l0;
            Drawable mutate = l0.mutate();
            this.h = mutate;
            if (this.n) {
                b.h.b.a.g0(mutate, this.l);
            }
            if (!this.o) {
                return;
            }
            b.h.b.a.h0(this.h, this.m);
        }
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.h;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.l;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f167c;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return 16908332;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f166b;
        return charSequence != null ? charSequence : this.a;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        this.f = Character.toLowerCase(c2);
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f = Character.toLowerCase(c2);
        this.g = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.p = (z ? 1 : 0) | (this.p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.p = (z ? 2 : 0) | (this.p & (-3));
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    /* renamed from: setContentDescription */
    public MenuItem mo2setContentDescription(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public b.h.e.a.b mo2setContentDescription(CharSequence charSequence) {
        this.j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.p = (z ? 16 : 0) | (this.p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.h = b.h.c.a.b(this.i, i);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.h = drawable;
        c();
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        this.n = true;
        c();
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        this.o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f167c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        this.d = c2;
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        this.d = c2;
        this.e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        this.d = c2;
        this.f = Character.toLowerCase(c3);
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.d = c2;
        this.e = KeyEvent.normalizeMetaState(i);
        this.f = Character.toLowerCase(c3);
        this.g = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.a = this.i.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f166b = charSequence;
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    /* renamed from: setTooltipText */
    public MenuItem mo3setTooltipText(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public b.h.e.a.b mo3setTooltipText(CharSequence charSequence) {
        this.k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.p & 8;
        if (z) {
            i = 0;
        }
        this.p = i2 | i;
        return this;
    }

    @Override // b.h.e.a.b, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }
}
