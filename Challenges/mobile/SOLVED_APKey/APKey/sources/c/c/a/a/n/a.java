package c.c.a.a.n;

import android.content.Context;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class a {
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final int f833b;

    /* renamed from: c  reason: collision with root package name */
    public final int f834c;
    public final float d;

    public a(Context context) {
        this.a = c.c.a.a.a.q(context, R.attr.elevationOverlayEnabled, false);
        this.f833b = c.c.a.a.a.d(context, R.attr.elevationOverlayColor, 0);
        this.f834c = c.c.a.a.a.d(context, R.attr.colorSurface, 0);
        this.d = context.getResources().getDisplayMetrics().density;
    }
}
