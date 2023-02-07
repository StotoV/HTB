package c.c.a.a.p;

import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public class f implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f844b;

    public f(d dVar) {
        this.f844b = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        d dVar = this.f844b;
        float rotation = dVar.s.getRotation();
        if (dVar.m != rotation) {
            dVar.m = rotation;
            dVar.s();
            return true;
        }
        return true;
    }
}
