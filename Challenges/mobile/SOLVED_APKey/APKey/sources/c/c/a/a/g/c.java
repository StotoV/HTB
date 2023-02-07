package c.c.a.a.g;

import android.view.View;
import b.h.j.c0.d;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
/* loaded from: classes.dex */
public class c implements d {
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f786b;

    public c(BottomSheetBehavior bottomSheetBehavior, int i) {
        this.f786b = bottomSheetBehavior;
        this.a = i;
    }

    @Override // b.h.j.c0.d
    public boolean a(View view, d.a aVar) {
        this.f786b.J(this.a);
        return true;
    }
}
