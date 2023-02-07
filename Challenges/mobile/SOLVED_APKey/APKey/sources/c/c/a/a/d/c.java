package c.c.a.a.d;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.c0.d;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class c implements b.h.j.c0.d {
    public final /* synthetic */ CoordinatorLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f769b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f770c;
    public final /* synthetic */ int d;
    public final /* synthetic */ AppBarLayout.BaseBehavior e;

    public c(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.e = baseBehavior;
        this.a = coordinatorLayout;
        this.f769b = appBarLayout;
        this.f770c = view;
        this.d = i;
    }

    @Override // b.h.j.c0.d
    public boolean a(View view, d.a aVar) {
        this.e.L(this.a, this.f769b, this.f770c, this.d, new int[]{0, 0});
        return true;
    }
}
