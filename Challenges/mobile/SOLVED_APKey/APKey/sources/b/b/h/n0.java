package b.b.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class n0 extends g0 {

    /* renamed from: b  reason: collision with root package name */
    public final WeakReference<Context> f251b;

    public n0(Context context, Resources resources) {
        super(resources);
        this.f251b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = this.a.getDrawable(i);
        Context context = this.f251b.get();
        if (drawable != null && context != null) {
            f0.d().m(context, i, drawable);
        }
        return drawable;
    }
}
