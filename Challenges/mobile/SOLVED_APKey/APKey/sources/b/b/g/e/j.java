package b.b.g.e;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import b.b.g.e.k;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class j {
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public final f f192b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f193c;
    public final int d;
    public final int e;
    public View f;
    public boolean h;
    public k.a i;
    public i j;
    public PopupWindow.OnDismissListener k;
    public int g = 8388611;
    public final PopupWindow.OnDismissListener l = new a();

    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            j.this.c();
        }
    }

    public j(Context context, f fVar, View view, boolean z, int i, int i2) {
        this.a = context;
        this.f192b = fVar;
        this.f = view;
        this.f193c = z;
        this.d = i;
        this.e = i2;
    }

    public i a() {
        if (this.j == null) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealSize(point);
            } else {
                defaultDisplay.getSize(point);
            }
            i dVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new d(this.a, this.f, this.d, this.e, this.f193c) : new o(this.a, this.f192b, this.f, this.d, this.e, this.f193c);
            dVar.m(this.f192b);
            dVar.t(this.l);
            dVar.p(this.f);
            dVar.f(this.i);
            dVar.q(this.h);
            dVar.r(this.g);
            this.j = dVar;
        }
        return this.j;
    }

    public boolean b() {
        i iVar = this.j;
        return iVar != null && iVar.b();
    }

    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(k.a aVar) {
        this.i = aVar;
        i iVar = this.j;
        if (iVar != null) {
            iVar.f(aVar);
        }
    }

    public final void e(int i, int i2, boolean z, boolean z2) {
        i a2 = a();
        a2.u(z2);
        if (z) {
            if ((b.h.b.a.x(this.g, b.h.j.q.o(this.f)) & 7) == 5) {
                i -= this.f.getWidth();
            }
            a2.s(i);
            a2.v(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.f191b = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        a2.e();
    }

    public boolean f() {
        if (b()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        e(0, 0, false, false);
        return true;
    }
}
