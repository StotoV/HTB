package c.c.a.a.l;

import android.view.View;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class i extends b.h.j.a {
    public final /* synthetic */ g d;

    public i(g gVar) {
        this.d = gVar;
    }

    @Override // b.h.j.a
    public void d(View view, b.h.j.c0.b bVar) {
        g gVar;
        int i;
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        if (this.d.e0.getVisibility() == 0) {
            gVar = this.d;
            i = R.string.mtrl_picker_toggle_to_year_selection;
        } else {
            gVar = this.d;
            i = R.string.mtrl_picker_toggle_to_day_selection;
        }
        bVar.k(gVar.B(i));
    }
}
