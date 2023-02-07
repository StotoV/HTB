package c.c.a.a.d;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.b0;
import b.h.j.q;
import com.google.android.material.appbar.AppBarLayout;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class f extends g<View> {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f775c;
    public final Rect d;
    public int e;
    public int f;

    public f() {
        this.f775c = new Rect();
        this.d = new Rect();
        this.e = 0;
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f775c = new Rect();
        this.d = new Rect();
        this.e = 0;
    }

    @Override // c.c.a.a.d.g
    public void C(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        AppBarLayout F = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.j(view));
        if (F != null) {
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
            Rect rect = this.f775c;
            rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, F.getBottom() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((F.getBottom() + coordinatorLayout.getHeight()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
            b0 lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null) {
                AtomicInteger atomicInteger = q.a;
                if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rect.left = lastWindowInsets.b() + rect.left;
                    rect.right -= lastWindowInsets.c();
                }
            }
            Rect rect2 = this.d;
            int i3 = fVar.f60c;
            int i4 = i3 == 0 ? 8388659 : i3;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            if (Build.VERSION.SDK_INT >= 17) {
                Gravity.apply(i4, measuredWidth, measuredHeight, rect, rect2, i);
            } else {
                Gravity.apply(i4, measuredWidth, measuredHeight, rect, rect2);
            }
            int E = E(F);
            view.layout(rect2.left, rect2.top - E, rect2.right, rect2.bottom - E);
            i2 = rect2.top - F.getBottom();
        } else {
            coordinatorLayout.r(view, i);
            i2 = 0;
        }
        this.e = i2;
    }

    public final int E(View view) {
        int i;
        if (this.f == 0) {
            return 0;
        }
        float f = 0.0f;
        if (view instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).a;
            int E = cVar instanceof AppBarLayout.BaseBehavior ? ((AppBarLayout.BaseBehavior) cVar).E() : 0;
            if ((downNestedPreScrollRange == 0 || totalScrollRange + E > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                f = 1.0f + (E / i);
            }
        }
        int i2 = this.f;
        return b.h.b.a.i((int) (f * i2), 0, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        b0 lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            AppBarLayout F = ((AppBarLayout.ScrollingViewBehavior) this).F(coordinatorLayout.j(view));
            if (F == null) {
                return false;
            }
            int size = View.MeasureSpec.getSize(i3);
            if (size > 0) {
                AtomicInteger atomicInteger = q.a;
                if (F.getFitsSystemWindows() && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
                    size += lastWindowInsets.a() + lastWindowInsets.d();
                }
            } else {
                size = coordinatorLayout.getHeight();
            }
            coordinatorLayout.s(view, i, i2, View.MeasureSpec.makeMeasureSpec((size + F.getTotalScrollRange()) - F.getMeasuredHeight(), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
            return true;
        }
        return false;
    }
}
