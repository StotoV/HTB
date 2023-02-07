package c.c.a.a.u;

import android.graphics.Canvas;
import android.graphics.Matrix;
import c.c.a.a.u.m;
import java.util.List;
/* loaded from: classes.dex */
public class l extends m.f {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f886b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Matrix f887c;

    public l(m mVar, List list, Matrix matrix) {
        this.f886b = list;
        this.f887c = matrix;
    }

    @Override // c.c.a.a.u.m.f
    public void a(Matrix matrix, c.c.a.a.t.a aVar, int i, Canvas canvas) {
        for (m.f fVar : this.f886b) {
            fVar.a(this.f887c, aVar, i, canvas);
        }
    }
}
