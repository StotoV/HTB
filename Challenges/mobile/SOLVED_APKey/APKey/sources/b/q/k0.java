package b.q;

import android.view.View;
import android.view.WindowId;
/* loaded from: classes.dex */
public class k0 implements l0 {
    public final WindowId a;

    public k0(View view) {
        this.a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
