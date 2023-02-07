package b.k.b;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class w extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<View> f609b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<View> f610c;
    public View.OnApplyWindowInsetsListener d;
    public boolean e;

    public w(Context context, AttributeSet attributeSet, c0 c0Var) {
        super(context, attributeSet);
        View view;
        this.e = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.k.a.f517b);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        m H = c0Var.H(id);
        if (classAttribute != null && H == null) {
            if (id <= 0) {
                throw new IllegalStateException(c.a.a.a.a.e("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? c.a.a.a.a.d(" with tag ", string) : ""));
            }
            m a = c0Var.J().a(context.getClassLoader(), classAttribute);
            a.U(attributeSet, null);
            a aVar = new a(c0Var);
            aVar.o = true;
            a.E = this;
            aVar.e(getId(), a, string, 1);
            if (!aVar.g) {
                aVar.p.D(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = ((ArrayList) c0Var.f530c.f()).iterator();
        while (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            m mVar = i0Var.f559c;
            if (mVar.x == getId() && (view = mVar.F) != null && view.getParent() == null) {
                mVar.E = this;
                i0Var.b();
            }
        }
    }

    public final void a(View view) {
        ArrayList<View> arrayList = this.f610c;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f609b == null) {
            this.f609b = new ArrayList<>();
        }
        this.f609b.add(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof m ? (m) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof m ? (m) tag : null) != null) {
            return super.addViewInLayout(view, i, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        b.h.j.b0 i = b.h.j.b0.i(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.d;
        b.h.j.b0 h = onApplyWindowInsetsListener != null ? b.h.j.b0.h(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets)) : b.h.j.q.y(this, i);
        if (!h.f()) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                b.h.j.q.e(getChildAt(i2), h);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.e && this.f609b != null) {
            for (int i = 0; i < this.f609b.size(); i++) {
                super.drawChild(canvas, this.f609b.get(i), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (!this.e || (arrayList = this.f609b) == null || arrayList.size() <= 0 || !this.f609b.contains(view)) {
            return super.drawChild(canvas, view, j);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        ArrayList<View> arrayList = this.f610c;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.f609b;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.e = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        if (z) {
            a(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            a(getChildAt(i3));
        }
        super.removeViewsInLayout(i, i2);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.e = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            super.setLayoutTransition(layoutTransition);
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.d = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f610c == null) {
                this.f610c = new ArrayList<>();
            }
            this.f610c.add(view);
        }
        super.startViewTransition(view);
    }
}
