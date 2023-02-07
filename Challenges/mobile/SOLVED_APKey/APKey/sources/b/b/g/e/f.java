package b.b.g.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import b.h.j.w;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class f implements b.h.e.a.a {
    public static final int[] y = {1, 4, 5, 3, 2, 0};
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f182b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f183c;
    public boolean d;
    public a e;
    public ArrayList<g> f;
    public ArrayList<g> g;
    public boolean h;
    public ArrayList<g> i;
    public ArrayList<g> j;
    public boolean k;
    public CharSequence m;
    public Drawable n;
    public View o;
    public g v;
    public boolean x;
    public int l = 0;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public ArrayList<g> t = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<k>> u = new CopyOnWriteArrayList<>();
    public boolean w = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(f fVar);

        boolean b(f fVar, MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean b(g gVar);
    }

    public f(Context context) {
        boolean z;
        boolean z2 = false;
        this.a = context;
        Resources resources = context.getResources();
        this.f182b = resources;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = true;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = w.a;
            if (Build.VERSION.SDK_INT >= 28) {
                z = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z) {
                z2 = true;
            }
        }
        this.d = z2;
    }

    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 >= 0) {
            int[] iArr = y;
            if (i5 < iArr.length) {
                int i6 = (iArr[i5] << 16) | (65535 & i3);
                g gVar = new g(this, i, i2, i3, i6, charSequence, this.l);
                ArrayList<g> arrayList = this.f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        i4 = 0;
                        break;
                    } else if (arrayList.get(size).d <= i6) {
                        i4 = size + 1;
                        break;
                    }
                }
                arrayList.add(i4, gVar);
                p(true);
                return gVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.f182b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.f182b.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            g gVar = (g) a(i, i2, i3, resolveInfo.loadLabel(packageManager));
            gVar.setIcon(resolveInfo.loadIcon(packageManager));
            gVar.setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = gVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f182b.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f182b.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        g gVar = (g) a(i, i2, i3, charSequence);
        p pVar = new p(this.a, this, gVar);
        gVar.o = pVar;
        pVar.setHeaderTitle(gVar.e);
        return pVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(k kVar, Context context) {
        this.u.add(new WeakReference<>(kVar));
        kVar.k(context, this);
        this.k = true;
    }

    public final void c(boolean z) {
        if (this.s) {
            return;
        }
        this.s = true;
        Iterator<WeakReference<k>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar = next.get();
            if (kVar == null) {
                this.u.remove(next);
            } else {
                kVar.a(this, z);
            }
        }
        this.s = false;
    }

    @Override // android.view.Menu
    public void clear() {
        g gVar = this.v;
        if (gVar != null) {
            d(gVar);
        }
        this.f.clear();
        p(true);
    }

    public void clearHeader() {
        this.n = null;
        this.m = null;
        this.o = null;
        p(false);
    }

    @Override // android.view.Menu
    public void close() {
        c(true);
    }

    public boolean d(g gVar) {
        boolean z = false;
        if (!this.u.isEmpty() && this.v == gVar) {
            w();
            Iterator<WeakReference<k>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.u.remove(next);
                } else {
                    z = kVar.l(this, gVar);
                    if (z) {
                        break;
                    }
                }
            }
            v();
            if (z) {
                this.v = null;
            }
        }
        return z;
    }

    public boolean e(f fVar, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.b(fVar, menuItem);
    }

    public boolean f(g gVar) {
        boolean z = false;
        if (this.u.isEmpty()) {
            return false;
        }
        w();
        Iterator<WeakReference<k>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar = next.get();
            if (kVar == null) {
                this.u.remove(next);
            } else {
                z = kVar.d(this, gVar);
                if (z) {
                    break;
                }
            }
        }
        v();
        if (z) {
            this.v = gVar;
        }
        return z;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.f.get(i2);
            if (gVar.a == i) {
                return gVar;
            }
            if (gVar.hasSubMenu() && (findItem = gVar.o.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public g g(int i, KeyEvent keyEvent) {
        char c2;
        ArrayList<g> arrayList = this.t;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean m = m();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = arrayList.get(i2);
            if (m) {
                c2 = gVar.j;
            } else {
                c2 = gVar.h;
            }
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (m && c2 == '\b' && i == 67))) {
                return gVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f.get(i);
    }

    public void h(List<g> list, int i, KeyEvent keyEvent) {
        char c2;
        int i2;
        boolean m = m();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f.size();
            for (int i3 = 0; i3 < size; i3++) {
                g gVar = this.f.get(i3);
                if (gVar.hasSubMenu()) {
                    gVar.o.h(list, i, keyEvent);
                }
                if (m) {
                    c2 = gVar.j;
                } else {
                    c2 = gVar.h;
                }
                if (m) {
                    i2 = gVar.k;
                } else {
                    i2 = gVar.i;
                }
                if (((modifiers & 69647) == (i2 & 69647)) && c2 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c2 == cArr[0] || c2 == cArr[2] || (m && c2 == '\b' && i == 67)) && gVar.isEnabled()) {
                        list.add(gVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.x) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<g> k = k();
        if (!this.k) {
            return;
        }
        Iterator<WeakReference<k>> it = this.u.iterator();
        boolean z = false;
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar = next.get();
            if (kVar == null) {
                this.u.remove(next);
            } else {
                z |= kVar.h();
            }
        }
        if (z) {
            this.i.clear();
            this.j.clear();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                g gVar = k.get(i);
                (gVar.g() ? this.i : this.j).add(gVar);
            }
        } else {
            this.i.clear();
            this.j.clear();
            this.j.addAll(k());
        }
        this.k = false;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public f j() {
        return this;
    }

    public ArrayList<g> k() {
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            g gVar = this.f.get(i);
            if (gVar.isVisible()) {
                this.g.add(gVar);
            }
        }
        this.h = false;
        this.k = true;
        return this.g;
    }

    public boolean l() {
        return this.w;
    }

    public boolean m() {
        return this.f183c;
    }

    public boolean n() {
        return this.d;
    }

    public void o() {
        this.k = true;
        p(true);
    }

    public void p(boolean z) {
        if (!this.p) {
            if (z) {
                this.h = true;
                this.k = true;
            }
            if (this.u.isEmpty()) {
                return;
            }
            w();
            Iterator<WeakReference<k>> it = this.u.iterator();
            while (it.hasNext()) {
                WeakReference<k> next = it.next();
                k kVar = next.get();
                if (kVar == null) {
                    this.u.remove(next);
                } else {
                    kVar.j(z);
                }
            }
            v();
            return;
        }
        this.q = true;
        if (!z) {
            return;
        }
        this.r = true;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return q(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        g g = g(i, keyEvent);
        boolean r = g != null ? r(g, null, i2) : false;
        if ((i2 & 2) != 0) {
            c(true);
        }
        return r;
    }

    public boolean q(MenuItem menuItem, int i) {
        return r(menuItem, null, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005b, code lost:
        if (r1 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006a, code lost:
        if ((r9 & 1) == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c6, code lost:
        if (r1 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
        c(true);
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean r(android.view.MenuItem r7, b.b.g.e.k r8, int r9) {
        /*
            r6 = this;
            b.b.g.e.g r7 = (b.b.g.e.g) r7
            r0 = 0
            if (r7 == 0) goto Lcc
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lcc
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.p
            r2 = 1
            if (r1 == 0) goto L19
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L19
            goto L40
        L19:
            b.b.g.e.f r1 = r7.n
            boolean r1 = r1.e(r1, r7)
            if (r1 == 0) goto L22
            goto L40
        L22:
            android.content.Intent r1 = r7.g
            if (r1 == 0) goto L36
            b.b.g.e.f r3 = r7.n     // Catch: android.content.ActivityNotFoundException -> L2e
            android.content.Context r3 = r3.a     // Catch: android.content.ActivityNotFoundException -> L2e
            r3.startActivity(r1)     // Catch: android.content.ActivityNotFoundException -> L2e
            goto L40
        L2e:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L36:
            b.h.j.b r1 = r7.A
            if (r1 == 0) goto L42
            boolean r1 = r1.e()
            if (r1 == 0) goto L42
        L40:
            r1 = 1
            goto L43
        L42:
            r1 = 0
        L43:
            b.h.j.b r3 = r7.A
            if (r3 == 0) goto L4f
            boolean r4 = r3.a()
            if (r4 == 0) goto L4f
            r4 = 1
            goto L50
        L4f:
            r4 = 0
        L50:
            boolean r5 = r7.f()
            if (r5 == 0) goto L5f
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Lcb
            goto Lc8
        L5f:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L6d
            if (r4 == 0) goto L68
            goto L6d
        L68:
            r7 = r9 & 1
            if (r7 != 0) goto Lcb
            goto Lc8
        L6d:
            r9 = r9 & 4
            if (r9 != 0) goto L74
            r6.c(r0)
        L74:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L88
            b.b.g.e.p r9 = new b.b.g.e.p
            android.content.Context r5 = r6.a
            r9.<init>(r5, r6, r7)
            r7.o = r9
            java.lang.CharSequence r5 = r7.e
            r9.setHeaderTitle(r5)
        L88:
            b.b.g.e.p r7 = r7.o
            if (r4 == 0) goto L8f
            r3.f(r7)
        L8f:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<b.b.g.e.k>> r9 = r6.u
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L98
            goto Lc5
        L98:
            if (r8 == 0) goto L9e
            boolean r0 = r8.g(r7)
        L9e:
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<b.b.g.e.k>> r8 = r6.u
            java.util.Iterator r8 = r8.iterator()
        La4:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto Lc5
            java.lang.Object r9 = r8.next()
            java.lang.ref.WeakReference r9 = (java.lang.ref.WeakReference) r9
            java.lang.Object r3 = r9.get()
            b.b.g.e.k r3 = (b.b.g.e.k) r3
            if (r3 != 0) goto Lbe
            java.util.concurrent.CopyOnWriteArrayList<java.lang.ref.WeakReference<b.b.g.e.k>> r3 = r6.u
            r3.remove(r9)
            goto La4
        Lbe:
            if (r0 != 0) goto La4
            boolean r0 = r3.g(r7)
            goto La4
        Lc5:
            r1 = r1 | r0
            if (r1 != 0) goto Lcb
        Lc8:
            r6.c(r2)
        Lcb:
            return r1
        Lcc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.g.e.f.r(android.view.MenuItem, b.b.g.e.k, int):boolean");
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.f.get(i2).f184b == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int size2 = this.f.size() - i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size2 || this.f.get(i2).f184b != i) {
                    break;
                }
                s(i2, false);
                i3 = i4;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.f.get(i2).a == i) {
                break;
            } else {
                i2++;
            }
        }
        s(i2, true);
    }

    public final void s(int i, boolean z) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        this.f.remove(i);
        if (!z) {
            return;
        }
        p(true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.f.get(i2);
            if (gVar.f184b == i) {
                gVar.x = (gVar.x & (-5)) | (z2 ? 4 : 0);
                gVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.w = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.f.get(i2);
            if (gVar.f184b == i) {
                gVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.f.get(i2);
            if (gVar.f184b == i && gVar.l(z)) {
                z2 = true;
            }
        }
        if (z2) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f183c = z;
        p(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }

    public void t(k kVar) {
        Iterator<WeakReference<k>> it = this.u.iterator();
        while (it.hasNext()) {
            WeakReference<k> next = it.next();
            k kVar2 = next.get();
            if (kVar2 == null || kVar2 == kVar) {
                this.u.remove(next);
            }
        }
    }

    public final void u(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = this.f182b;
        if (view != null) {
            this.o = view;
            this.m = null;
            this.n = null;
        } else {
            if (i > 0) {
                this.m = resources.getText(i);
            } else if (charSequence != null) {
                this.m = charSequence;
            }
            if (i2 > 0) {
                this.n = b.h.c.a.b(this.a, i2);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.o = null;
        }
        p(false);
    }

    public void v() {
        this.p = false;
        if (this.q) {
            this.q = false;
            p(this.r);
        }
    }

    public void w() {
        if (!this.p) {
            this.p = true;
            this.q = false;
            this.r = false;
        }
    }
}
