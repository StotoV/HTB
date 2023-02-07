package c.c.a.a.l;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class y extends LinearLayoutManager {

    /* loaded from: classes.dex */
    public class a extends b.o.b.o {
        public a(y yVar, Context context) {
            super(context);
        }

        @Override // b.o.b.o
        public float f(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public y(Context context, int i, boolean z) {
        super(i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.l
    public void W0(RecyclerView recyclerView, RecyclerView.w wVar, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.a = i;
        X0(aVar);
    }
}
