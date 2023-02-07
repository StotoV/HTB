package b.o.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class t extends o {
    public final /* synthetic */ u q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, Context context) {
        super(context);
        this.q = uVar;
    }

    @Override // b.o.b.o, androidx.recyclerview.widget.RecyclerView.v
    public void c(View view, RecyclerView.w wVar, RecyclerView.v.a aVar) {
        u uVar = this.q;
        int[] a = uVar.a(uVar.a.getLayoutManager(), view);
        int i = a[0];
        int i2 = a[1];
        double g = g(Math.max(Math.abs(i), Math.abs(i2)));
        Double.isNaN(g);
        Double.isNaN(g);
        Double.isNaN(g);
        int ceil = (int) Math.ceil(g / 0.3356d);
        if (ceil > 0) {
            aVar.b(i, i2, ceil, this.j);
        }
    }

    @Override // b.o.b.o
    public float f(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // b.o.b.o
    public int g(int i) {
        return Math.min(100, super.g(i));
    }
}
