package b.b.g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import b.b.g.e.g;
import b.b.g.e.h;
import b.b.h.o0;
import b.b.h.w;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c extends MenuInflater {
    public static final Class<?>[] e;
    public static final Class<?>[] f;
    public final Object[] a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f156b;

    /* renamed from: c  reason: collision with root package name */
    public Context f157c;
    public Object d;

    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?>[] f158c = {MenuItem.class};
        public Object a;

        /* renamed from: b  reason: collision with root package name */
        public Method f159b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f159b = cls.getMethod(str, f158c);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f159b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f159b.invoke(this.a, menuItem)).booleanValue();
                }
                this.f159b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public b.h.j.b A;
        public CharSequence B;
        public CharSequence C;
        public Menu a;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: b  reason: collision with root package name */
        public int f160b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f161c = 0;
        public int d = 0;
        public int e = 0;
        public boolean f = true;
        public boolean g = true;

        public b(Menu menu) {
            this.a = menu;
        }

        public SubMenu a() {
            this.h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.f160b, this.i, this.j, this.k);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, c.this.f157c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        public final void c(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (c.this.f157c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                c cVar = c.this;
                if (cVar.d == null) {
                    cVar.d = cVar.a(cVar.f157c);
                }
                menuItem.setOnMenuItemClickListener(new a(cVar.d, this.z));
            }
            if (this.r >= 2) {
                if (menuItem instanceof g) {
                    g gVar = (g) menuItem;
                    gVar.x = (gVar.x & (-5)) | 4;
                } else if (menuItem instanceof h) {
                    h hVar = (h) menuItem;
                    try {
                        if (hVar.e == null) {
                            hVar.e = hVar.d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        hVar.e.invoke(hVar.d, Boolean.TRUE);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) b(str, c.e, c.this.a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            b.h.j.b bVar = this.A;
            if (bVar != null) {
                if (menuItem instanceof b.h.e.a.b) {
                    ((b.h.e.a.b) menuItem).b(bVar);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.B;
            boolean z2 = menuItem instanceof b.h.e.a.b;
            if (z2) {
                ((b.h.e.a.b) menuItem).mo2setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z2) {
                ((b.h.e.a.b) menuItem).mo3setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.n;
            int i3 = this.o;
            if (z2) {
                ((b.h.e.a.b) menuItem).setAlphabeticShortcut(c2, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c2, i3);
            }
            char c3 = this.p;
            int i4 = this.q;
            if (z2) {
                ((b.h.e.a.b) menuItem).setNumericShortcut(c3, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c3, i4);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (z2) {
                    ((b.h.e.a.b) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                if (z2) {
                    ((b.h.e.a.b) menuItem).setIconTintList(colorStateList);
                } else if (Build.VERSION.SDK_INT < 26) {
                } else {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public c(Context context) {
        super(context);
        this.f157c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.f156b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b.h.j.b bVar;
        ColorStateList colorStateList;
        b bVar2 = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException(c.a.a.a.a.d("Expecting menu, got ", name));
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != 2) {
                if (eventType == 3) {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name2.equals("group")) {
                        bVar2.f160b = 0;
                        bVar2.f161c = 0;
                        bVar2.d = 0;
                        bVar2.e = 0;
                        bVar2.f = true;
                        bVar2.g = true;
                    } else if (name2.equals("item")) {
                        if (!bVar2.h) {
                            b.h.j.b bVar3 = bVar2.A;
                            if (bVar3 == null || !bVar3.a()) {
                                bVar2.h = true;
                                bVar2.c(bVar2.a.add(bVar2.f160b, bVar2.i, bVar2.j, bVar2.k));
                            } else {
                                bVar2.a();
                            }
                        }
                    } else if (name2.equals("menu")) {
                        z = true;
                    }
                }
            } else if (!z2) {
                String name3 = xmlPullParser.getName();
                if (name3.equals("group")) {
                    TypedArray obtainStyledAttributes = c.this.f157c.obtainStyledAttributes(attributeSet, b.b.b.o);
                    bVar2.f160b = obtainStyledAttributes.getResourceId(1, 0);
                    bVar2.f161c = obtainStyledAttributes.getInt(3, 0);
                    bVar2.d = obtainStyledAttributes.getInt(4, 0);
                    bVar2.e = obtainStyledAttributes.getInt(5, 0);
                    bVar2.f = obtainStyledAttributes.getBoolean(2, true);
                    bVar2.g = obtainStyledAttributes.getBoolean(0, true);
                    obtainStyledAttributes.recycle();
                } else if (name3.equals("item")) {
                    o0 o = o0.o(c.this.f157c, attributeSet, b.b.b.p);
                    bVar2.i = o.k(2, 0);
                    bVar2.j = (o.i(5, bVar2.f161c) & (-65536)) | (o.i(6, bVar2.d) & 65535);
                    bVar2.k = o.m(7);
                    bVar2.l = o.m(8);
                    bVar2.m = o.k(0, 0);
                    String l = o.l(9);
                    bVar2.n = l == null ? (char) 0 : l.charAt(0);
                    bVar2.o = o.i(16, 4096);
                    String l2 = o.l(10);
                    bVar2.p = l2 == null ? (char) 0 : l2.charAt(0);
                    bVar2.q = o.i(20, 4096);
                    bVar2.r = o.n(11) ? o.a(11, false) : bVar2.e;
                    bVar2.s = o.a(3, false);
                    bVar2.t = o.a(4, bVar2.f);
                    bVar2.u = o.a(1, bVar2.g);
                    bVar2.v = o.i(21, -1);
                    bVar2.z = o.l(12);
                    bVar2.w = o.k(13, 0);
                    bVar2.x = o.l(15);
                    String l3 = o.l(14);
                    bVar2.y = l3;
                    boolean z3 = l3 != null;
                    if (z3 && bVar2.w == 0 && bVar2.x == null) {
                        bVar = (b.h.j.b) bVar2.b(l3, f, c.this.f156b);
                    } else {
                        if (z3) {
                            Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                        }
                        bVar = null;
                    }
                    bVar2.A = bVar;
                    bVar2.B = o.m(17);
                    bVar2.C = o.m(22);
                    if (o.n(19)) {
                        bVar2.E = w.c(o.i(19, -1), bVar2.E);
                        colorStateList = null;
                    } else {
                        colorStateList = null;
                        bVar2.E = null;
                    }
                    if (o.n(18)) {
                        colorStateList = o.c(18);
                    }
                    bVar2.D = colorStateList;
                    o.f252b.recycle();
                    bVar2.h = false;
                } else if (name3.equals("menu")) {
                    b(xmlPullParser, attributeSet, bVar2.a());
                } else {
                    z2 = true;
                    str = name3;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof b.h.e.a.a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f157c.getResources().getLayout(i);
                    b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
