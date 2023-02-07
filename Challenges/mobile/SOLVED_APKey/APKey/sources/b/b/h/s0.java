package b.b.h;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class s0 {
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final View f271b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f272c;
    public final WindowManager.LayoutParams d;
    public final Rect e;
    public final int[] f;
    public final int[] g;

    public s0(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f271b = inflate;
        this.f272c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(s0.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 2131689477;
        layoutParams.flags = 24;
    }

    public void a() {
        if (!(this.f271b.getParent() != null)) {
            return;
        }
        ((WindowManager) this.a.getSystemService("window")).removeView(this.f271b);
    }
}
