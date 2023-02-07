package c.c.a.a.u;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b implements c {
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final float f875b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).a;
            f += ((b) cVar).f875b;
        }
        this.a = cVar;
        this.f875b = f;
    }

    @Override // c.c.a.a.u.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.a.a(rectF) + this.f875b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.f875b == bVar.f875b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.f875b)});
    }
}
