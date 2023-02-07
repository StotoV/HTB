package c.c.a.a.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class g<V extends View> extends CoordinatorLayout.c<V> {
    public h a;

    /* renamed from: b  reason: collision with root package name */
    public int f776b;

    public g() {
        this.f776b = 0;
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f776b = 0;
    }

    public int B() {
        h hVar = this.a;
        if (hVar != null) {
            return hVar.d;
        }
        return 0;
    }

    public void C(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.r(v, i);
    }

    public boolean D(int i) {
        h hVar = this.a;
        if (hVar != null) {
            if (hVar.d == i) {
                return false;
            }
            hVar.d = i;
            hVar.a();
            return true;
        }
        this.f776b = i;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        C(coordinatorLayout, v, i);
        if (this.a == null) {
            this.a = new h(v);
        }
        h hVar = this.a;
        hVar.f777b = hVar.a.getTop();
        hVar.f778c = hVar.a.getLeft();
        this.a.a();
        int i2 = this.f776b;
        if (i2 != 0) {
            h hVar2 = this.a;
            if (hVar2.d != i2) {
                hVar2.d = i2;
                hVar2.a();
            }
            this.f776b = 0;
            return true;
        }
        return true;
    }
}
