package b.q;

import android.os.IBinder;
/* loaded from: classes.dex */
public class j0 implements l0 {
    public final IBinder a;

    public j0(IBinder iBinder) {
        this.a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j0) && ((j0) obj).a.equals(this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
