package c.c.a.a.u;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class h implements c {
    public final float a;

    public h(float f) {
        this.a = f;
    }

    @Override // c.c.a.a.u.c
    public float a(RectF rectF) {
        return rectF.height() * this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.a == ((h) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
