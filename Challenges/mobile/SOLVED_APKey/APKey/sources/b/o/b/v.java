package b.o.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.o.b.b;
/* loaded from: classes.dex */
public class v implements b.InterfaceC0029b {
    public final /* synthetic */ RecyclerView a;

    public v(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public View a(int i) {
        return this.a.getChildAt(i);
    }

    public int b() {
        return this.a.getChildCount();
    }

    public void c(int i) {
        View childAt = this.a.getChildAt(i);
        if (childAt != null) {
            this.a.o(childAt);
            childAt.clearAnimation();
        }
        this.a.removeViewAt(i);
    }
}
