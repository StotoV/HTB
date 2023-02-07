package c.c.a.a.x;

import android.widget.AutoCompleteTextView;
/* loaded from: classes.dex */
public class k implements AutoCompleteTextView.OnDismissListener {
    public final /* synthetic */ h a;

    public k(h hVar) {
        this.a = hVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        h hVar = this.a;
        hVar.i = true;
        hVar.k = System.currentTimeMillis();
        h.g(this.a, false);
    }
}
