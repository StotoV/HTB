package b.h.j;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class v implements View.OnApplyWindowInsetsListener {
    public b0 a = null;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f495b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f496c;

    public v(View view, l lVar) {
        this.f495b = view;
        this.f496c = lVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        b0 i = b0.i(windowInsets, view);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            View view2 = this.f495b;
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view2.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
            }
            if (i.equals(this.a)) {
                return this.f496c.a(view, i).g();
            }
        }
        this.a = i;
        b0 a = this.f496c.a(view, i);
        if (i2 >= 30) {
            return a.g();
        }
        AtomicInteger atomicInteger = q.a;
        if (i2 >= 20) {
            view.requestApplyInsets();
        } else {
            view.requestFitSystemWindows();
        }
        return a.g();
    }
}
