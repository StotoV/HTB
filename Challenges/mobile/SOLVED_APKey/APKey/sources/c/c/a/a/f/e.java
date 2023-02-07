package c.c.a.a.f;

import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.bottomappbar.BottomAppBar;
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ActionMenuView f782b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f783c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ BottomAppBar e;

    public e(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.e = bottomAppBar;
        this.f782b = actionMenuView;
        this.f783c = i;
        this.d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        ActionMenuView actionMenuView = this.f782b;
        actionMenuView.setTranslationX(this.e.A(actionMenuView, this.f783c, this.d));
    }
}
