package b.b.h;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class a0 extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public boolean f202b;

    /* renamed from: c  reason: collision with root package name */
    public int f203c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public boolean i;
    public int[] j;
    public int[] k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public int p;

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public a0(Context context) {
        this(context, null);
    }

    public a0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int resourceId;
        this.f202b = true;
        this.f203c = -1;
        this.d = 0;
        this.f = 8388659;
        int[] iArr = b.b.b.m;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        b.h.j.q.E(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        int i2 = obtainStyledAttributes.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.h = obtainStyledAttributes.getFloat(4, -1.0f);
        this.f203c = obtainStyledAttributes.getInt(3, -1);
        this.i = obtainStyledAttributes.getBoolean(7, false);
        setDividerDrawable((!obtainStyledAttributes.hasValue(5) || (resourceId = obtainStyledAttributes.getResourceId(5, 0)) == 0) ? obtainStyledAttributes.getDrawable(5) : b.b.d.a.a.b(context, resourceId));
        this.o = obtainStyledAttributes.getInt(8, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void e(Canvas canvas, int i) {
        this.l.setBounds(getPaddingLeft() + this.p, i, (getWidth() - getPaddingRight()) - this.p, this.n + i);
        this.l.draw(canvas);
    }

    public void f(Canvas canvas, int i) {
        this.l.setBounds(i, getPaddingTop() + this.p, this.m + i, (getHeight() - getPaddingBottom()) - this.p);
        this.l.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* renamed from: g */
    public a generateDefaultLayoutParams() {
        int i = this.e;
        if (i == 0) {
            return new a(-2, -2);
        }
        if (i != 1) {
            return null;
        }
        return new a(-1, -2);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f203c < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f203c;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f203c != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            return -1;
        }
        int i3 = this.d;
        if (this.e == 1 && (i = this.f & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.g) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.g;
            }
        }
        return i3 + ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f203c;
    }

    public Drawable getDividerDrawable() {
        return this.l;
    }

    public int getDividerPadding() {
        return this.p;
    }

    public int getDividerWidth() {
        return this.m;
    }

    public int getGravity() {
        return this.f;
    }

    public int getOrientation() {
        return this.e;
    }

    public int getShowDividers() {
        return this.o;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* renamed from: i */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public int j() {
        return 0;
    }

    public int k() {
        return 0;
    }

    public int l() {
        return 0;
    }

    public boolean m(int i) {
        if (i == 0) {
            return (this.o & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.o & 4) != 0;
        } else if ((this.o & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    public void n(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    public int o() {
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.l == null) {
            return;
        }
        int i2 = 0;
        if (this.e == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && m(i2)) {
                    e(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((a) childAt.getLayoutParams())).topMargin) - this.n);
                }
                i2++;
            }
            if (!m(virtualChildCount)) {
                return;
            }
            View childAt2 = getChildAt(virtualChildCount - 1);
            e(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.n : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((a) childAt2.getLayoutParams())).bottomMargin);
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean b2 = u0.b(this);
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && m(i2)) {
                a aVar = (a) childAt3.getLayoutParams();
                f(canvas, b2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) aVar).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) aVar).leftMargin) - this.m);
            }
            i2++;
        }
        if (!m(virtualChildCount2)) {
            return;
        }
        View childAt4 = getChildAt(virtualChildCount2 - 1);
        if (childAt4 != null) {
            a aVar2 = (a) childAt4.getLayoutParams();
            if (b2) {
                left = childAt4.getLeft();
                i = ((LinearLayout.LayoutParams) aVar2).leftMargin;
                right = (left - i) - this.m;
            } else {
                right = childAt4.getRight() + ((LinearLayout.LayoutParams) aVar2).rightMargin;
            }
        } else if (b2) {
            right = getPaddingLeft();
        } else {
            left = getWidth();
            i = getPaddingRight();
            right = (left - i) - this.m;
        }
        f(canvas, right);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.a0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x02c8, code lost:
        if (r13 < 0) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x075a, code lost:
        if (r7 < 0) goto L404;
     */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04f8  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0620  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0703  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0886  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x08ad  */
    /* JADX WARN: Removed duplicated region for block: B:439:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instructions count: 2286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.a0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.f202b = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f203c = i;
            return;
        }
        StringBuilder g = c.a.a.a.a.g("base aligned child index out of range (0, ");
        g.append(getChildCount());
        g.append(")");
        throw new IllegalArgumentException(g.toString());
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.l) {
            return;
        }
        this.l = drawable;
        boolean z = false;
        if (drawable != null) {
            this.m = drawable.getIntrinsicWidth();
            this.n = drawable.getIntrinsicHeight();
        } else {
            this.m = 0;
            this.n = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.p = i;
    }

    public void setGravity(int i) {
        if (this.f != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.f;
        if ((8388615 & i3) != i2) {
            this.f = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.i = z;
    }

    public void setOrientation(int i) {
        if (this.e != i) {
            this.e = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.o) {
            requestLayout();
        }
        this.o = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.f;
        if ((i3 & 112) != i2) {
            this.f = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.h = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
