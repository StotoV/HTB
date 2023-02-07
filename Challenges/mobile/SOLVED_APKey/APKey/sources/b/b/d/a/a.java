package b.b.d.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import b.b.h.f0;
import java.util.WeakHashMap;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public final class a {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<Context, SparseArray<C0004a>> f139b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f140c = new Object();

    /* renamed from: b.b.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0004a {
        public final ColorStateList a;

        /* renamed from: b  reason: collision with root package name */
        public final Configuration f141b;

        public C0004a(ColorStateList colorStateList, Configuration configuration) {
            this.a = colorStateList;
            this.f141b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        C0004a c0004a;
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        synchronized (f140c) {
            SparseArray<C0004a> sparseArray = f139b.get(context);
            colorStateList = null;
            if (sparseArray != null && sparseArray.size() > 0 && (c0004a = sparseArray.get(i)) != null) {
                if (c0004a.f141b.equals(context.getResources().getConfiguration())) {
                    colorStateList2 = c0004a.a;
                } else {
                    sparseArray.remove(i);
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        Resources resources = context.getResources();
        ThreadLocal<TypedValue> threadLocal = a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            z = false;
        }
        if (!z) {
            Resources resources2 = context.getResources();
            try {
                colorStateList = b.h.b.a.q(resources2, resources2.getXml(i), context.getTheme());
            } catch (Exception e) {
                Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            }
        }
        if (colorStateList != null) {
            synchronized (f140c) {
                WeakHashMap<Context, SparseArray<C0004a>> weakHashMap = f139b;
                SparseArray<C0004a> sparseArray2 = weakHashMap.get(context);
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray<>();
                    weakHashMap.put(context, sparseArray2);
                }
                sparseArray2.append(i, new C0004a(colorStateList, context.getResources().getConfiguration()));
            }
            return colorStateList;
        }
        Object obj = b.h.c.a.a;
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }

    public static Drawable b(Context context, int i) {
        return f0.d().f(context, i);
    }
}
