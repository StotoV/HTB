package b.b.c;

import android.os.Build;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import b.h.j.a0;
import b.h.j.q;
import b.h.j.x;
import b.h.j.y;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class g extends b.b.c.a implements ActionBarOverlayLayout.d {
    public static final Interpolator n = new AccelerateInterpolator();
    public static final Interpolator o = new DecelerateInterpolator();
    public ActionBarOverlayLayout a;

    /* renamed from: b  reason: collision with root package name */
    public ActionBarContainer f137b;

    /* renamed from: c  reason: collision with root package name */
    public View f138c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public b.b.g.d i;
    public boolean j;
    public final y k;
    public final y l;
    public final a0 m;

    /* loaded from: classes.dex */
    public class a implements a0 {
        public final /* synthetic */ g a;
    }

    public final void a(boolean z) {
        View view;
        int[] iArr;
        View view2;
        View view3;
        int[] iArr2;
        if (!(this.g || !this.f)) {
            if (!this.h) {
                return;
            }
            this.h = false;
            b.b.g.d dVar = this.i;
            if (dVar != null) {
                dVar.a();
            }
            if (this.d != 0 || (!this.j && !z)) {
                this.k.a(null);
                return;
            }
            this.f137b.setAlpha(1.0f);
            this.f137b.setTransitioning(true);
            b.b.g.d dVar2 = new b.b.g.d();
            float f = -this.f137b.getHeight();
            if (z) {
                this.f137b.getLocationInWindow(new int[]{0, 0});
                f -= iArr[1];
            }
            x b2 = q.b(this.f137b);
            b2.f(f);
            b2.e(this.m);
            if (!dVar2.e) {
                dVar2.a.add(b2);
            }
            if (this.e && (view = this.f138c) != null) {
                x b3 = q.b(view);
                b3.f(f);
                if (!dVar2.e) {
                    dVar2.a.add(b3);
                }
            }
            Interpolator interpolator = n;
            boolean z2 = dVar2.e;
            if (!z2) {
                dVar2.f163c = interpolator;
            }
            if (!z2) {
                dVar2.f162b = 250L;
            }
            y yVar = this.k;
            if (!z2) {
                dVar2.d = yVar;
            }
            this.i = dVar2;
            dVar2.b();
        } else if (this.h) {
        } else {
            this.h = true;
            b.b.g.d dVar3 = this.i;
            if (dVar3 != null) {
                dVar3.a();
            }
            this.f137b.setVisibility(0);
            if (this.d != 0 || (!this.j && !z)) {
                this.f137b.setAlpha(1.0f);
                this.f137b.setTranslationY(0.0f);
                if (this.e && (view2 = this.f138c) != null) {
                    view2.setTranslationY(0.0f);
                }
                this.l.a(null);
            } else {
                this.f137b.setTranslationY(0.0f);
                float f2 = -this.f137b.getHeight();
                if (z) {
                    this.f137b.getLocationInWindow(new int[]{0, 0});
                    f2 -= iArr2[1];
                }
                this.f137b.setTranslationY(f2);
                b.b.g.d dVar4 = new b.b.g.d();
                x b4 = q.b(this.f137b);
                b4.f(0.0f);
                b4.e(this.m);
                if (!dVar4.e) {
                    dVar4.a.add(b4);
                }
                if (this.e && (view3 = this.f138c) != null) {
                    view3.setTranslationY(f2);
                    x b5 = q.b(this.f138c);
                    b5.f(0.0f);
                    if (!dVar4.e) {
                        dVar4.a.add(b5);
                    }
                }
                Interpolator interpolator2 = o;
                boolean z3 = dVar4.e;
                if (!z3) {
                    dVar4.f163c = interpolator2;
                }
                if (!z3) {
                    dVar4.f162b = 250L;
                }
                y yVar2 = this.l;
                if (!z3) {
                    dVar4.d = yVar2;
                }
                this.i = dVar4;
                dVar4.b();
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.a;
            if (actionBarOverlayLayout == null) {
                return;
            }
            AtomicInteger atomicInteger = q.a;
            if (Build.VERSION.SDK_INT >= 20) {
                actionBarOverlayLayout.requestApplyInsets();
            } else {
                actionBarOverlayLayout.requestFitSystemWindows();
            }
        }
    }
}
