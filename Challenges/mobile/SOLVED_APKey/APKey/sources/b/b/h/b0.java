package b.b.h;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
public class b0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f204b;

    public b0(c0 c0Var) {
        this.f204b = c0Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        x xVar;
        if (i == -1 || (xVar = this.f204b.d) == null) {
            return;
        }
        xVar.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
