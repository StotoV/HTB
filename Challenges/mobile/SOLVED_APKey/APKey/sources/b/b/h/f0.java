package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import b.b.h.i;
import com.example.apkey.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class f0 {
    public static f0 i;
    public WeakHashMap<Context, b.e.g<ColorStateList>> a;

    /* renamed from: b  reason: collision with root package name */
    public b.e.f<String, e> f218b;

    /* renamed from: c  reason: collision with root package name */
    public b.e.g<String> f219c;
    public final WeakHashMap<Context, b.e.c<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap<>(0);
    public TypedValue e;
    public boolean f;
    public f g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final c j = new c(6);

    /* loaded from: classes.dex */
    public static class a implements e {
        @Override // b.b.h.f0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.b.e.a.a.g(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e {
        @Override // b.b.h.f0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                Resources resources = context.getResources();
                b.r.a.a.b bVar = new b.r.a.a.b(context, null, null);
                bVar.inflate(resources, xmlPullParser, attributeSet, theme);
                return bVar;
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends b.e.d<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements e {
        @Override // b.b.h.f0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                    return null;
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public static class g implements e {
        @Override // b.b.h.f0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return b.r.a.a.g.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    public static synchronized f0 d() {
        f0 f0Var;
        synchronized (f0.class) {
            if (i == null) {
                f0 f0Var2 = new f0();
                i = f0Var2;
                j(f0Var2);
            }
            f0Var = i;
        }
        return f0Var;
    }

    public static synchronized PorterDuffColorFilter h(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (f0.class) {
            c cVar = j;
            cVar.getClass();
            int i3 = (i2 + 31) * 31;
            a2 = cVar.a(Integer.valueOf(mode.hashCode() + i3));
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                cVar.getClass();
                cVar.b(Integer.valueOf(mode.hashCode() + i3), a2);
            }
        }
        return a2;
    }

    public static void j(f0 f0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            f0Var.a("vector", new g());
            f0Var.a("animated-vector", new b());
            f0Var.a("animated-selector", new a());
            f0Var.a("drawable", new d());
        }
    }

    public final void a(String str, e eVar) {
        if (this.f218b == null) {
            this.f218b = new b.e.f<>();
        }
        this.f218b.put(str, eVar);
    }

    public final synchronized boolean b(Context context, long j2, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            b.e.c<WeakReference<Drawable.ConstantState>> cVar = this.d.get(context);
            if (cVar == null) {
                cVar = new b.e.c<>();
                this.d.put(context, cVar);
            }
            cVar.g(j2, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final Drawable c(Context context, int i2) {
        int i3;
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable e2 = e(context, j2);
        if (e2 != null) {
            return e2;
        }
        f fVar = this.g;
        LayerDrawable layerDrawable = null;
        if (fVar != null) {
            i.a aVar = (i.a) fVar;
            if (i2 == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{f(context, R.drawable.abc_cab_background_internal_bg), f(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else {
                if (i2 == R.drawable.abc_ratingbar_material) {
                    i3 = R.dimen.abc_star_big;
                } else if (i2 == R.drawable.abc_ratingbar_indicator_material) {
                    i3 = R.dimen.abc_star_medium;
                } else if (i2 == R.drawable.abc_ratingbar_small_material) {
                    i3 = R.dimen.abc_star_small;
                }
                layerDrawable = aVar.c(this, context, i3);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, j2, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable e(Context context, long j2) {
        b.e.c<WeakReference<Drawable.ConstantState>> cVar = this.d.get(context);
        if (cVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> f2 = cVar.f(j2, null);
        if (f2 != null) {
            Drawable.ConstantState constantState = f2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int b2 = b.e.b.b(cVar.f304c, cVar.e, j2);
            if (b2 >= 0) {
                Object[] objArr = cVar.d;
                Object obj = objArr[b2];
                Object obj2 = b.e.c.f;
                if (obj != obj2) {
                    objArr[b2] = obj2;
                    cVar.f303b = true;
                }
            }
        }
        return null;
    }

    public synchronized Drawable f(Context context, int i2) {
        return g(context, i2, false);
    }

    public synchronized Drawable g(Context context, int i2, boolean z) {
        Drawable k;
        if (!this.f) {
            boolean z2 = true;
            this.f = true;
            Drawable f2 = f(context, R.drawable.abc_vector_test);
            if (f2 != null) {
                if (!(f2 instanceof b.r.a.a.g) && !"android.graphics.drawable.VectorDrawable".equals(f2.getClass().getName())) {
                    z2 = false;
                }
            }
            this.f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        k = k(context, i2);
        if (k == null) {
            k = c(context, i2);
        }
        if (k == null) {
            k = b.h.c.a.b(context, i2);
        }
        if (k != null) {
            k = l(context, i2, z, k);
        }
        if (k != null) {
            w.b(k);
        }
        return k;
    }

    public synchronized ColorStateList i(Context context, int i2) {
        ColorStateList d2;
        b.e.g<ColorStateList> gVar;
        WeakHashMap<Context, b.e.g<ColorStateList>> weakHashMap = this.a;
        ColorStateList colorStateList = null;
        d2 = (weakHashMap == null || (gVar = weakHashMap.get(context)) == null) ? null : gVar.d(i2, null);
        if (d2 == null) {
            f fVar = this.g;
            if (fVar != null) {
                colorStateList = ((i.a) fVar).d(context, i2);
            }
            if (colorStateList != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap<>();
                }
                b.e.g<ColorStateList> gVar2 = this.a.get(context);
                if (gVar2 == null) {
                    gVar2 = new b.e.g<>();
                    this.a.put(context, gVar2);
                }
                gVar2.a(i2, colorStateList);
            }
            d2 = colorStateList;
        }
        return d2;
    }

    public final Drawable k(Context context, int i2) {
        int next;
        b.e.f<String, e> fVar = this.f218b;
        if (fVar == null || fVar.isEmpty()) {
            return null;
        }
        b.e.g<String> gVar = this.f219c;
        if (gVar != null) {
            String d2 = gVar.d(i2, null);
            if ("appcompat_skip_skip".equals(d2) || (d2 != null && this.f218b.getOrDefault(d2, null) == null)) {
                return null;
            }
        } else {
            this.f219c = new b.e.g<>();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable e2 = e(context, j2);
        if (e2 != null) {
            return e2;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f219c.a(i2, name);
                e eVar = this.f218b.get(name);
                if (eVar != null) {
                    e2 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (e2 != null) {
                    e2.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, j2, e2);
                }
            } catch (Exception e3) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e3);
            }
        }
        if (e2 == null) {
            this.f219c.a(i2, "appcompat_skip_skip");
        }
        return e2;
    }

    public final Drawable l(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList i3 = i(context, i2);
        PorterDuff.Mode mode = null;
        if (i3 != null) {
            if (w.a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable l0 = b.h.b.a.l0(drawable);
            b.h.b.a.g0(l0, i3);
            f fVar = this.g;
            if (fVar != null) {
                i.a aVar = (i.a) fVar;
                if (i2 == R.drawable.abc_switch_thumb_material) {
                    mode = PorterDuff.Mode.MULTIPLY;
                }
            }
            if (mode == null) {
                return l0;
            }
            b.h.b.a.h0(l0, mode);
            return l0;
        }
        f fVar2 = this.g;
        if (fVar2 != null) {
            i.a aVar2 = (i.a) fVar2;
            aVar2.getClass();
            boolean z2 = true;
            if (i2 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int c2 = k0.c(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = i.f226b;
                aVar2.e(findDrawableByLayerId, c2, mode2);
                aVar2.e(layerDrawable.findDrawableByLayerId(16908303), k0.c(context, R.attr.colorControlNormal), mode2);
                aVar2.e(layerDrawable.findDrawableByLayerId(16908301), k0.c(context, R.attr.colorControlActivated), mode2);
            } else if (i2 == R.drawable.abc_ratingbar_material || i2 == R.drawable.abc_ratingbar_indicator_material || i2 == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
                int b2 = k0.b(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = i.f226b;
                aVar2.e(findDrawableByLayerId2, b2, mode3);
                aVar2.e(layerDrawable2.findDrawableByLayerId(16908303), k0.c(context, R.attr.colorControlActivated), mode3);
                aVar2.e(layerDrawable2.findDrawableByLayerId(16908301), k0.c(context, R.attr.colorControlActivated), mode3);
            } else {
                z2 = false;
            }
            if (z2) {
                return drawable;
            }
        }
        if (!m(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m(android.content.Context r8, int r9, android.graphics.drawable.Drawable r10) {
        /*
            r7 = this;
            b.b.h.f0$f r0 = r7.g
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L72
            b.b.h.i$a r0 = (b.b.h.i.a) r0
            r0.getClass()
            android.graphics.PorterDuff$Mode r3 = b.b.h.i.f226b
            int[] r4 = r0.a
            boolean r4 = r0.a(r4, r9)
            r5 = 16842801(0x1010031, float:2.3693695E-38)
            r6 = -1
            if (r4 == 0) goto L1d
            r5 = 2130903226(0x7f0300ba, float:1.7413264E38)
            goto L49
        L1d:
            int[] r4 = r0.f229c
            boolean r4 = r0.a(r4, r9)
            if (r4 == 0) goto L29
            r5 = 2130903224(0x7f0300b8, float:1.741326E38)
            goto L49
        L29:
            int[] r4 = r0.d
            boolean r0 = r0.a(r4, r9)
            if (r0 == 0) goto L34
            android.graphics.PorterDuff$Mode r3 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L49
        L34:
            r0 = 2131165228(0x7f07002c, float:1.7944667E38)
            if (r9 != r0) goto L44
            r9 = 16842800(0x1010030, float:2.3693693E-38)
            r0 = 1109603123(0x42233333, float:40.8)
            int r0 = java.lang.Math.round(r0)
            goto L4b
        L44:
            r0 = 2131165210(0x7f07001a, float:1.794463E38)
            if (r9 != r0) goto L4d
        L49:
            r9 = r5
            r0 = -1
        L4b:
            r4 = 1
            goto L50
        L4d:
            r9 = 0
            r0 = -1
            r4 = 0
        L50:
            if (r4 == 0) goto L6e
            boolean r4 = b.b.h.w.a(r10)
            if (r4 == 0) goto L5c
            android.graphics.drawable.Drawable r10 = r10.mutate()
        L5c:
            int r8 = b.b.h.k0.c(r8, r9)
            android.graphics.PorterDuffColorFilter r8 = b.b.h.i.c(r8, r3)
            r10.setColorFilter(r8)
            if (r0 == r6) goto L6c
            r10.setAlpha(r0)
        L6c:
            r8 = 1
            goto L6f
        L6e:
            r8 = 0
        L6f:
            if (r8 == 0) goto L72
            goto L73
        L72:
            r1 = 0
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.f0.m(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }
}
