package c.c.a.a.d;

import android.view.View;
import b.h.j.c0.d;
import com.google.android.material.appbar.AppBarLayout;
/* loaded from: classes.dex */
public class d implements b.h.j.c0.d {
    public final /* synthetic */ AppBarLayout a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f771b;

    public d(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.a = appBarLayout;
        this.f771b = z;
    }

    @Override // b.h.j.c0.d
    public boolean a(View view, d.a aVar) {
        this.a.setExpanded(this.f771b);
        return true;
    }
}
