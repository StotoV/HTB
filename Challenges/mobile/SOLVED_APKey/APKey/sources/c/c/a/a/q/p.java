package c.c.a.a.q;

import android.annotation.SuppressLint;
import android.widget.ImageButton;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class p extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    public int f861b;

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f861b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f861b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f861b = i;
    }
}
