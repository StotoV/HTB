package c.c.a.a.z;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import b.h.j.c0.b;
import com.example.apkey.R;
import com.google.android.material.timepicker.ClockFaceView;
/* loaded from: classes.dex */
public class b extends b.h.j.a {
    public final /* synthetic */ ClockFaceView d;

    public b(ClockFaceView clockFaceView) {
        this.d = clockFaceView;
    }

    @Override // b.h.j.a
    public void d(View view, b.h.j.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            TextView textView = this.d.A.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                bVar.a.setTraversalAfter(textView);
            }
        }
        bVar.j(b.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}
