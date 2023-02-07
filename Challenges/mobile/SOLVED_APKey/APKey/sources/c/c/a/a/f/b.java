package c.c.a.a.f;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
/* loaded from: classes.dex */
public class b extends FloatingActionButton.a {
    public final /* synthetic */ int a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f779b;

    /* loaded from: classes.dex */
    public class a extends FloatingActionButton.a {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public void b(FloatingActionButton floatingActionButton) {
            BottomAppBar.w(b.this.f779b);
        }
    }

    public b(BottomAppBar bottomAppBar, int i) {
        this.f779b = bottomAppBar;
        this.a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public void a(FloatingActionButton floatingActionButton) {
        BottomAppBar bottomAppBar = this.f779b;
        int i = this.a;
        int i2 = BottomAppBar.a0;
        floatingActionButton.setTranslationX(bottomAppBar.B(i));
        floatingActionButton.m(new a(), true);
    }
}
