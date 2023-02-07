package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.m.d;
import b.m.e;
import b.m.g;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class ImmLeaksCleaner implements e {

    /* renamed from: b  reason: collision with root package name */
    public static int f2b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f3c;
    public static Field d;
    public static Field e;
    public Activity a;

    public ImmLeaksCleaner(Activity activity) {
        this.a = activity;
    }

    @Override // b.m.e
    public void h(g gVar, d.a aVar) {
        if (aVar != d.a.ON_DESTROY) {
            return;
        }
        if (f2b == 0) {
            try {
                f2b = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                d = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                e = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f3c = declaredField3;
                declaredField3.setAccessible(true);
                f2b = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f2b != 1) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.a.getSystemService("input_method");
        try {
            Object obj = f3c.get(inputMethodManager);
            if (obj == null) {
                return;
            }
            synchronized (obj) {
                try {
                    try {
                        View view = (View) d.get(inputMethodManager);
                        if (view == null) {
                            return;
                        }
                        if (view.isAttachedToWindow()) {
                            return;
                        }
                        try {
                            e.set(inputMethodManager, null);
                            inputMethodManager.isActive();
                        } catch (IllegalAccessException unused2) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (ClassCastException unused3) {
                } catch (IllegalAccessException unused4) {
                }
            }
        } catch (IllegalAccessException unused5) {
        }
    }
}
