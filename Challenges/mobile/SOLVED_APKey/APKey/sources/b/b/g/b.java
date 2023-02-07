package b.b.g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* loaded from: classes.dex */
public class b extends ContextWrapper {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f154b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f155c;
    public Configuration d;
    public Resources e;

    public b() {
        super(null);
    }

    public b(Context context, int i) {
        super(context);
        this.a = i;
    }

    public final void a() {
        if (this.f154b == null) {
            this.f154b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f154b.setTo(theme);
            }
        }
        this.f154b.applyStyle(this.a, true);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources;
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(configuration).getResources();
            } else {
                Resources resources2 = super.getResources();
                Configuration configuration2 = new Configuration(resources2.getConfiguration());
                configuration2.updateFrom(this.d);
                this.e = new Resources(resources2.getAssets(), resources2.getDisplayMetrics(), configuration2);
            }
            this.e = resources;
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.f155c == null) {
                this.f155c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.f155c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f154b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = 2131689874;
        }
        a();
        return this.f154b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            a();
        }
    }
}
