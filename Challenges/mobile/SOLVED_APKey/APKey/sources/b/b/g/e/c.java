package b.b.g.e;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
/* loaded from: classes.dex */
public abstract class c {
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public b.e.f<b.h.e.a.b, MenuItem> f170b;

    /* renamed from: c  reason: collision with root package name */
    public b.e.f<b.h.e.a.c, SubMenu> f171c;

    public c(Context context) {
        this.a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof b.h.e.a.b) {
            b.h.e.a.b bVar = (b.h.e.a.b) menuItem;
            if (this.f170b == null) {
                this.f170b = new b.e.f<>();
            }
            MenuItem orDefault = this.f170b.getOrDefault(menuItem, null);
            if (orDefault != null) {
                return orDefault;
            }
            h hVar = new h(this.a, bVar);
            this.f170b.put(bVar, hVar);
            return hVar;
        }
        return menuItem;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof b.h.e.a.c) {
            b.h.e.a.c cVar = (b.h.e.a.c) subMenu;
            if (this.f171c == null) {
                this.f171c = new b.e.f<>();
            }
            SubMenu subMenu2 = this.f171c.get(cVar);
            if (subMenu2 != null) {
                return subMenu2;
            }
            q qVar = new q(this.a, cVar);
            this.f171c.put(cVar, qVar);
            return qVar;
        }
        return subMenu;
    }
}
