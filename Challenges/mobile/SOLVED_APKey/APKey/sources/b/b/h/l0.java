package b.b.h;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l0 extends ContextWrapper {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f244b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<WeakReference<l0>> f245c;
    public final Resources a;

    public l0(Context context) {
        super(context);
        int i = t0.a;
        this.a = new n0(this, context.getResources());
    }

    public static Context a(Context context) {
        boolean z = false;
        if (!(context instanceof l0) && !(context.getResources() instanceof n0)) {
            context.getResources();
            if (Build.VERSION.SDK_INT >= 21) {
                int i = t0.a;
            } else {
                z = true;
            }
        }
        if (z) {
            synchronized (f244b) {
                ArrayList<WeakReference<l0>> arrayList = f245c;
                if (arrayList == null) {
                    f245c = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<l0> weakReference = f245c.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f245c.remove(size);
                        }
                    }
                    for (int size2 = f245c.size() - 1; size2 >= 0; size2--) {
                        WeakReference<l0> weakReference2 = f245c.get(size2);
                        l0 l0Var = weakReference2 != null ? weakReference2.get() : null;
                        if (l0Var != null && l0Var.getBaseContext() == context) {
                            return l0Var;
                        }
                    }
                }
                l0 l0Var2 = new l0(context);
                f245c.add(new WeakReference<>(l0Var2));
                return l0Var2;
            }
        }
        return context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return super.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
    }
}
