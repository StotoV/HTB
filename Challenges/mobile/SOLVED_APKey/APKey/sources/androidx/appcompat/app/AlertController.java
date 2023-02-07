package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import b.b.b;
/* loaded from: classes.dex */
public class AlertController {

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: b  reason: collision with root package name */
        public final int f8b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9c;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.s);
            this.f9c = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.f8b = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    public static void a(View view, View view2, View view3) {
        int i = 4;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (view.canScrollVertically(1)) {
                i = 0;
            }
            view3.setVisibility(i);
        }
    }
}
