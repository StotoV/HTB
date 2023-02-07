package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b.h.j.b0;
import b.h.j.k;
import b.h.j.l;
import b.h.j.q;
import com.example.apkey.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements b.h.j.h, b.h.j.i {
    public static final String v;
    public static final Class<?>[] w;
    public static final ThreadLocal<Map<String, Constructor<c>>> x;
    public static final Comparator<View> y;
    public static final b.h.i.c<Rect> z;

    /* renamed from: b  reason: collision with root package name */
    public final List<View> f57b;

    /* renamed from: c  reason: collision with root package name */
    public final b.g.b.a<View> f58c;
    public final List<View> d;
    public final List<View> e;
    public Paint f;
    public final int[] g;
    public final int[] h;
    public boolean i;
    public boolean j;
    public int[] k;
    public View l;
    public View m;
    public g n;
    public boolean o;
    public b0 p;
    public boolean q;
    public Drawable r;
    public ViewGroup.OnHierarchyChangeListener s;
    public l t;
    public final k u;

    /* loaded from: classes.dex */
    public class a implements l {
        public a() {
        }

        @Override // b.h.j.l
        public b0 a(View view, b0 b0Var) {
            c cVar;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!b.h.b.a.v(coordinatorLayout.p, b0Var)) {
                coordinatorLayout.p = b0Var;
                boolean z = true;
                boolean z2 = b0Var.d() > 0;
                coordinatorLayout.q = z2;
                if (z2 || coordinatorLayout.getBackground() != null) {
                    z = false;
                }
                coordinatorLayout.setWillNotDraw(z);
                if (!b0Var.f()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = coordinatorLayout.getChildAt(i);
                        AtomicInteger atomicInteger = q.a;
                        if (childAt.getFitsSystemWindows() && (cVar = ((f) childAt.getLayoutParams()).a) != null) {
                            b0Var = cVar.e(b0Var);
                            if (b0Var.f()) {
                                break;
                            }
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return b0Var;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        /* renamed from: getBehavior */
        c mo8getBehavior();
    }

    /* loaded from: classes.dex */
    public static abstract class c<V extends View> {
        public c() {
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public int b() {
            return -16777216;
        }

        public float c() {
            return 0.0f;
        }

        public boolean d(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public b0 e(b0 b0Var) {
            return b0Var;
        }

        public void f(f fVar) {
        }

        public boolean g(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void h(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void i() {
        }

        public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean l(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean m() {
            return false;
        }

        public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void o() {
        }

        public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                o();
            }
        }

        @Deprecated
        public void q() {
        }

        public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (i5 == 0) {
                q();
            }
        }

        @Deprecated
        public void s() {
        }

        public boolean t(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean w() {
            return false;
        }

        public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return w();
            }
            return false;
        }

        @Deprecated
        public void y() {
        }

        public void z(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                y();
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    /* loaded from: classes.dex */
    public @interface d {
        Class<? extends c> value();
    }

    /* loaded from: classes.dex */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.q(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.s;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {
        public c a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f59b;

        /* renamed from: c  reason: collision with root package name */
        public int f60c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public View k;
        public View l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public final Rect q;

        public f(int i, int i2) {
            super(i, i2);
            this.f59b = false;
            this.f60c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            c newInstance;
            this.f59b = false;
            this.f60c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.g.a.f391b);
            this.f60c = obtainStyledAttributes.getInteger(0, 0);
            this.f = obtainStyledAttributes.getResourceId(1, -1);
            this.d = obtainStyledAttributes.getInteger(2, 0);
            this.e = obtainStyledAttributes.getInteger(6, -1);
            this.g = obtainStyledAttributes.getInt(5, 0);
            this.h = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.f59b = hasValue;
            if (hasValue) {
                String string = obtainStyledAttributes.getString(3);
                String str = CoordinatorLayout.v;
                if (TextUtils.isEmpty(string)) {
                    newInstance = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.v;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.x;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.w);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        newInstance = constructor.newInstance(context, attributeSet);
                    } catch (Exception e) {
                        throw new RuntimeException(c.a.a.a.a.d("Could not inflate Behavior subclass ", string), e);
                    }
                }
                this.a = newInstance;
            }
            obtainStyledAttributes.recycle();
            c cVar = this.a;
            if (cVar != null) {
                cVar.f(this);
            }
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f59b = false;
            this.f60c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f59b = false;
            this.f60c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f59b = false;
            this.f60c = 0;
            this.d = 0;
            this.e = -1;
            this.f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public boolean a(int i) {
            if (i != 0) {
                if (i == 1) {
                    return this.o;
                }
                return false;
            }
            return this.n;
        }

        public void b(int i, boolean z) {
            if (i == 0) {
                this.n = z;
            } else if (i != 1) {
            } else {
                this.o = z;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.q(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends b.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public SparseArray<Parcelable> d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new h[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.d = new SparseArray<>(readInt);
            for (int i = 0; i < readInt; i++) {
                this.d.append(iArr[i], readParcelableArray[i]);
            }
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            SparseArray<Parcelable> sparseArray = this.d;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.d.keyAt(i2);
                parcelableArr[i2] = this.d.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    /* loaded from: classes.dex */
    public static class i implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            View view3 = view;
            View view4 = view2;
            AtomicInteger atomicInteger = q.a;
            int i = Build.VERSION.SDK_INT;
            float f = 0.0f;
            float z = i >= 21 ? view3.getZ() : 0.0f;
            if (i >= 21) {
                f = view4.getZ();
            }
            if (z > f) {
                return -1;
            }
            return z < f ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        v = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            y = new i();
        } else {
            y = null;
        }
        w = new Class[]{Context.class, AttributeSet.class};
        x = new ThreadLocal<>();
        z = new b.h.i.d(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f57b = new ArrayList();
        this.f58c = new b.g.b.a<>();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.g = new int[2];
        this.h = new int[2];
        this.u = new k();
        int[] iArr = b.g.a.a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.k = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.k.length;
            for (int i2 = 0; i2 < length; i2++) {
                int[] iArr2 = this.k;
                iArr2[i2] = (int) (iArr2[i2] * f2);
            }
        }
        this.r = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        y();
        super.setOnHierarchyChangeListener(new e());
        AtomicInteger atomicInteger = q.a;
        if (getImportantForAccessibility() == 0) {
            q.I(this, 1);
        }
    }

    public static Rect b() {
        Rect a2 = z.a();
        return a2 == null ? new Rect() : a2;
    }

    @Override // b.h.j.h
    public void a(View view, View view2, int i2, int i3) {
        c cVar;
        k kVar = this.u;
        if (i3 == 1) {
            kVar.f486b = i2;
        } else {
            kVar.a = i2;
        }
        this.m = view2;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            f fVar = (f) getChildAt(i4).getLayoutParams();
            if (fVar.a(i3) && (cVar = fVar.a) != null && i3 == 0) {
                cVar.s();
            }
        }
    }

    @Override // b.h.j.i
    public void c(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i6) && (cVar = fVar.a) != null) {
                    int[] iArr2 = this.g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.r(this, childAt, view, i2, i3, i4, i5, i6, iArr2);
                    int[] iArr3 = this.g;
                    i7 = i4 > 0 ? Math.max(i7, iArr3[0]) : Math.min(i7, iArr3[0]);
                    i8 = i5 > 0 ? Math.max(i8, this.g[1]) : Math.min(i8, this.g[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (z2) {
            q(1);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // b.h.j.h
    public void d(View view, int i2, int i3, int i4, int i5, int i6) {
        c(view, i2, i3, i4, i5, 0, this.h);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        f fVar = (f) view.getLayoutParams();
        c cVar = fVar.a;
        if (cVar != null) {
            float c2 = cVar.c();
            if (c2 > 0.0f) {
                if (this.f == null) {
                    this.f = new Paint();
                }
                this.f.setColor(fVar.a.b());
                Paint paint = this.f;
                int round = Math.round(c2 * 255.0f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                paint.setAlpha(round);
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // b.h.j.h
    public void e(View view, int i2) {
        k kVar = this.u;
        if (i2 == 1) {
            kVar.f486b = 0;
        } else {
            kVar.a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i2)) {
                c cVar = fVar.a;
                if (cVar != null) {
                    cVar.z(this, childAt, view, i2);
                }
                fVar.b(i2, false);
                fVar.p = false;
            }
        }
        this.m = null;
    }

    @Override // b.h.j.h
    public void f(View view, int i2, int i3, int[] iArr, int i4) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i4) && (cVar = fVar.a) != null) {
                    int[] iArr2 = this.g;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.p(this, childAt, view, i2, i3, iArr2, i4);
                    int[] iArr3 = this.g;
                    i5 = i2 > 0 ? Math.max(i5, iArr3[0]) : Math.min(i5, iArr3[0]);
                    int[] iArr4 = this.g;
                    i6 = i3 > 0 ? Math.max(i6, iArr4[1]) : Math.min(i6, iArr4[1]);
                    z2 = true;
                }
            }
        }
        iArr[0] = i5;
        iArr[1] = i6;
        if (z2) {
            q(1);
        }
    }

    @Override // b.h.j.h
    public boolean g(View view, View view2, int i2, int i3) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.a;
                if (cVar != null) {
                    boolean x2 = cVar.x(this, childAt, view, view2, i2, i3);
                    z2 |= x2;
                    fVar.b(i3, x2);
                } else {
                    fVar.b(i3, false);
                }
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        u();
        return Collections.unmodifiableList(this.f57b);
    }

    public final b0 getLastWindowInsets() {
        return this.p;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.u.a();
    }

    public Drawable getStatusBarBackground() {
        return this.r;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(f fVar, Rect rect, int i2, int i3) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(max, max2, i2 + max, i3 + max2);
    }

    public void i(View view, boolean z2, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z2) {
            l(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> j(View view) {
        b.g.b.a<View> aVar = this.f58c;
        int i2 = aVar.f392b.d;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i2; i3++) {
            ArrayList<View> k = aVar.f392b.k(i3);
            if (k != null && k.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(aVar.f392b.h(i3));
            }
        }
        this.e.clear();
        if (arrayList != null) {
            this.e.addAll(arrayList);
        }
        return this.e;
    }

    public List<View> k(View view) {
        ArrayList<View> orDefault = this.f58c.f392b.getOrDefault(view, null);
        this.e.clear();
        if (orDefault != null) {
            this.e.addAll(orDefault);
        }
        return this.e;
    }

    public void l(View view, Rect rect) {
        ThreadLocal<Matrix> threadLocal = b.g.b.b.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal<Matrix> threadLocal2 = b.g.b.b.a;
        Matrix matrix = threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        b.g.b.b.a(this, view, matrix);
        ThreadLocal<RectF> threadLocal3 = b.g.b.b.f394b;
        RectF rectF = threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final void m(int i2, Rect rect, Rect rect2, f fVar, int i3, int i4) {
        int i5 = fVar.f60c;
        if (i5 == 0) {
            i5 = 17;
        }
        int x2 = b.h.b.a.x(i5, i2);
        int i6 = fVar.d;
        if ((i6 & 7) == 0) {
            i6 |= 8388611;
        }
        if ((i6 & 112) == 0) {
            i6 |= 48;
        }
        int x3 = b.h.b.a.x(i6, i2);
        int i7 = x2 & 7;
        int i8 = x2 & 112;
        int i9 = x3 & 7;
        int i10 = x3 & 112;
        int width = i9 != 1 ? i9 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i10 != 16 ? i10 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i7 == 1) {
            width -= i3 / 2;
        } else if (i7 != 5) {
            width -= i3;
        }
        if (i8 == 16) {
            height -= i4 / 2;
        } else if (i8 != 80) {
            height -= i4;
        }
        rect2.set(width, height, i3 + width, i4 + height);
    }

    public final int n(int i2) {
        StringBuilder sb;
        int[] iArr = this.k;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i2);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e("CoordinatorLayout", sb.toString());
        return 0;
    }

    public f o(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f59b) {
            if (view instanceof b) {
                c mo8getBehavior = ((b) view).mo8getBehavior();
                if (mo8getBehavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c cVar = fVar.a;
                if (cVar != mo8getBehavior) {
                    if (cVar != null) {
                        cVar.i();
                    }
                    fVar.a = mo8getBehavior;
                    fVar.f59b = true;
                    if (mo8getBehavior != null) {
                        mo8getBehavior.f(fVar);
                    }
                }
            } else {
                d dVar = null;
                for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    dVar = (d) cls.getAnnotation(d.class);
                    if (dVar != null) {
                        break;
                    }
                }
                if (dVar != null) {
                    try {
                        c newInstance = dVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        c cVar2 = fVar.a;
                        if (cVar2 != newInstance) {
                            if (cVar2 != null) {
                                cVar2.i();
                            }
                            fVar.a = newInstance;
                            fVar.f59b = true;
                            if (newInstance != null) {
                                newInstance.f(fVar);
                            }
                        }
                    } catch (Exception e2) {
                        StringBuilder g2 = c.a.a.a.a.g("Default behavior class ");
                        g2.append(dVar.value().getName());
                        g2.append(" could not be instantiated. Did you forget a default constructor?");
                        Log.e("CoordinatorLayout", g2.toString(), e2);
                    }
                }
            }
            fVar.f59b = true;
        }
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        v(false);
        if (this.o) {
            if (this.n == null) {
                this.n = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.n);
        }
        if (this.p == null) {
            AtomicInteger atomicInteger = q.a;
            if (getFitsSystemWindows()) {
                if (Build.VERSION.SDK_INT >= 20) {
                    requestApplyInsets();
                } else {
                    requestFitSystemWindows();
                }
            }
        }
        this.j = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v(false);
        if (this.o && this.n != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.n);
        }
        View view = this.m;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.j = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.q || this.r == null) {
            return;
        }
        b0 b0Var = this.p;
        int d2 = b0Var != null ? b0Var.d() : 0;
        if (d2 <= 0) {
            return;
        }
        this.r.setBounds(0, 0, getWidth(), d2);
        this.r.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            v(true);
        }
        boolean t = t(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            v(true);
        }
        return t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        c cVar;
        int o = q.o(this);
        int size = this.f57b.size();
        for (int i6 = 0; i6 < size; i6++) {
            View view = this.f57b.get(i6);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).a) == null || !cVar.k(this, view, o))) {
                r(view, o);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x017e, code lost:
        if (r0.l(r30, r20, r8, r21, r23, 0) == false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0181  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        c cVar;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.a) != null) {
                    z3 |= cVar.m();
                }
            }
        }
        if (z3) {
            q(1);
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public boolean onNestedPreFling(View view, float f2, float f3) {
        c cVar;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(0) && (cVar = fVar.a) != null) {
                    z2 |= cVar.n(this, childAt, view, f2, f3);
                }
            }
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        f(view, i2, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        c(view, i2, i3, i4, i5, 0, this.h);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onNestedScrollAccepted(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f510b);
        SparseArray<Parcelable> sparseArray = hVar.d;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = o(childAt).a;
            if (id != -1 && cVar != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVar.u(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable v2;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).a;
            if (id != -1 && cVar != null && (v2 = cVar.v(this, childAt)) != null) {
                sparseArray.append(id, v2);
            }
        }
        hVar.d = sparseArray;
        return hVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return g(view, view2, i2, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, b.h.j.j
    public void onStopNestedScroll(View view) {
        e(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.l
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.t(r1, r4)
            if (r3 == 0) goto L29
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.l
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.a
            if (r6 == 0) goto L29
            android.view.View r7 = r0.l
            boolean r6 = r6.A(r0, r7, r1)
            goto L2a
        L29:
            r6 = 0
        L2a:
            android.view.View r7 = r0.l
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.v(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean p(View view, int i2, int i3) {
        Rect b2 = b();
        l(view, b2);
        try {
            return b2.contains(i2, i3);
        } finally {
            b2.setEmpty();
            z.b(b2);
        }
    }

    public final void q(int i2) {
        int i3;
        Rect rect;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        int width;
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Rect rect2;
        int i13;
        f fVar;
        c cVar;
        int o = q.o(this);
        int size = this.f57b.size();
        Rect b2 = b();
        Rect b3 = b();
        Rect b4 = b();
        int i14 = 0;
        while (i14 < size) {
            View view = this.f57b.get(i14);
            f fVar2 = (f) view.getLayoutParams();
            if (i2 == 0 && view.getVisibility() == 8) {
                i4 = size;
                rect = b4;
                i3 = i14;
            } else {
                int i15 = 0;
                while (i15 < i14) {
                    if (fVar2.l == this.f57b.get(i15)) {
                        f fVar3 = (f) view.getLayoutParams();
                        if (fVar3.k != null) {
                            Rect b5 = b();
                            Rect b6 = b();
                            Rect b7 = b();
                            l(fVar3.k, b5);
                            i(view, false, b6);
                            int measuredWidth = view.getMeasuredWidth();
                            i12 = size;
                            int measuredHeight = view.getMeasuredHeight();
                            i13 = i14;
                            i11 = i15;
                            rect2 = b4;
                            fVar = fVar2;
                            m(o, b5, b7, fVar3, measuredWidth, measuredHeight);
                            boolean z5 = (b7.left == b6.left && b7.top == b6.top) ? false : true;
                            h(fVar3, b7, measuredWidth, measuredHeight);
                            int i16 = b7.left - b6.left;
                            int i17 = b7.top - b6.top;
                            if (i16 != 0) {
                                q.w(view, i16);
                            }
                            if (i17 != 0) {
                                q.x(view, i17);
                            }
                            if (z5 && (cVar = fVar3.a) != null) {
                                cVar.g(this, view, fVar3.k);
                            }
                            b5.setEmpty();
                            b.h.i.c<Rect> cVar2 = z;
                            cVar2.b(b5);
                            b6.setEmpty();
                            cVar2.b(b6);
                            b7.setEmpty();
                            cVar2.b(b7);
                            i15 = i11 + 1;
                            fVar2 = fVar;
                            size = i12;
                            i14 = i13;
                            b4 = rect2;
                        }
                    }
                    i11 = i15;
                    i12 = size;
                    rect2 = b4;
                    i13 = i14;
                    fVar = fVar2;
                    i15 = i11 + 1;
                    fVar2 = fVar;
                    size = i12;
                    i14 = i13;
                    b4 = rect2;
                }
                int i18 = size;
                Rect rect3 = b4;
                i3 = i14;
                f fVar4 = fVar2;
                i(view, true, b3);
                if (fVar4.g != 0 && !b3.isEmpty()) {
                    int x2 = b.h.b.a.x(fVar4.g, o);
                    int i19 = x2 & 112;
                    if (i19 == 48) {
                        b2.top = Math.max(b2.top, b3.bottom);
                    } else if (i19 == 80) {
                        b2.bottom = Math.max(b2.bottom, getHeight() - b3.top);
                    }
                    int i20 = x2 & 7;
                    if (i20 == 3) {
                        b2.left = Math.max(b2.left, b3.right);
                    } else if (i20 == 5) {
                        b2.right = Math.max(b2.right, getWidth() - b3.left);
                    }
                }
                if (fVar4.h != 0 && view.getVisibility() == 0 && q.u(view) && view.getWidth() > 0 && view.getHeight() > 0) {
                    f fVar5 = (f) view.getLayoutParams();
                    c cVar3 = fVar5.a;
                    Rect b8 = b();
                    Rect b9 = b();
                    b9.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    if (cVar3 == null || !cVar3.a(this, view, b8)) {
                        b8.set(b9);
                    } else if (!b9.contains(b8)) {
                        StringBuilder g2 = c.a.a.a.a.g("Rect should be within the child's bounds. Rect:");
                        g2.append(b8.toShortString());
                        g2.append(" | Bounds:");
                        g2.append(b9.toShortString());
                        throw new IllegalArgumentException(g2.toString());
                    }
                    b9.setEmpty();
                    b.h.i.c<Rect> cVar4 = z;
                    cVar4.b(b9);
                    if (!b8.isEmpty()) {
                        int x3 = b.h.b.a.x(fVar5.h, o);
                        if ((x3 & 48) != 48 || (i9 = (b8.top - ((ViewGroup.MarginLayoutParams) fVar5).topMargin) - fVar5.j) >= (i10 = b2.top)) {
                            z3 = false;
                        } else {
                            x(view, i10 - i9);
                            z3 = true;
                        }
                        if ((x3 & 80) == 80 && (height = ((getHeight() - b8.bottom) - ((ViewGroup.MarginLayoutParams) fVar5).bottomMargin) + fVar5.j) < (i8 = b2.bottom)) {
                            x(view, height - i8);
                            z3 = true;
                        }
                        if (!z3) {
                            x(view, 0);
                        }
                        if ((x3 & 3) != 3 || (i6 = (b8.left - ((ViewGroup.MarginLayoutParams) fVar5).leftMargin) - fVar5.i) >= (i7 = b2.left)) {
                            z4 = false;
                        } else {
                            w(view, i7 - i6);
                            z4 = true;
                        }
                        if ((x3 & 5) == 5 && (width = ((getWidth() - b8.right) - ((ViewGroup.MarginLayoutParams) fVar5).rightMargin) + fVar5.i) < (i5 = b2.right)) {
                            w(view, width - i5);
                            z4 = true;
                        }
                        if (!z4) {
                            w(view, 0);
                        }
                    }
                    b8.setEmpty();
                    cVar4.b(b8);
                }
                if (i2 != 2) {
                    rect = rect3;
                    rect.set(((f) view.getLayoutParams()).q);
                    if (rect.equals(b3)) {
                        i4 = i18;
                    } else {
                        ((f) view.getLayoutParams()).q.set(b3);
                    }
                } else {
                    rect = rect3;
                }
                i4 = i18;
                for (int i21 = i3 + 1; i21 < i4; i21++) {
                    View view2 = this.f57b.get(i21);
                    f fVar6 = (f) view2.getLayoutParams();
                    c cVar5 = fVar6.a;
                    if (cVar5 != null && cVar5.d(this, view2, view)) {
                        if (i2 != 0 || !fVar6.p) {
                            if (i2 != 2) {
                                z2 = cVar5.g(this, view2, view);
                            } else {
                                cVar5.h(this, view2, view);
                                z2 = true;
                            }
                            if (i2 == 1) {
                                fVar6.p = z2;
                            }
                        } else {
                            fVar6.p = false;
                        }
                    }
                }
            }
            i14 = i3 + 1;
            size = i4;
            b4 = rect;
        }
        Rect rect4 = b4;
        b2.setEmpty();
        b.h.i.c<Rect> cVar6 = z;
        cVar6.b(b2);
        b3.setEmpty();
        cVar6.b(b3);
        rect4.setEmpty();
        cVar6.b(rect4);
    }

    public void r(View view, int i2) {
        Rect b2;
        Rect b3;
        b.h.i.c<Rect> cVar;
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.k;
        int i3 = 0;
        if (!(view2 == null && fVar.f != -1)) {
            if (view2 != null) {
                b2 = b();
                b3 = b();
                try {
                    l(view2, b2);
                    f fVar2 = (f) view.getLayoutParams();
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    m(i2, b2, b3, fVar2, measuredWidth, measuredHeight);
                    h(fVar2, b3, measuredWidth, measuredHeight);
                    view.layout(b3.left, b3.top, b3.right, b3.bottom);
                    return;
                } finally {
                    b2.setEmpty();
                    cVar = z;
                    cVar.b(b2);
                    b3.setEmpty();
                    cVar.b(b3);
                }
            }
            int i4 = fVar.e;
            if (i4 >= 0) {
                f fVar3 = (f) view.getLayoutParams();
                int i5 = fVar3.f60c;
                if (i5 == 0) {
                    i5 = 8388661;
                }
                int x2 = b.h.b.a.x(i5, i2);
                int i6 = x2 & 7;
                int i7 = x2 & 112;
                int width = getWidth();
                int height = getHeight();
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                if (i2 == 1) {
                    i4 = width - i4;
                }
                int n = n(i4) - measuredWidth2;
                if (i6 == 1) {
                    n += measuredWidth2 / 2;
                } else if (i6 == 5) {
                    n += measuredWidth2;
                }
                if (i7 == 16) {
                    i3 = 0 + (measuredHeight2 / 2);
                } else if (i7 == 80) {
                    i3 = measuredHeight2 + 0;
                }
                int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, Math.min(n, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin));
                int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin));
                view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                return;
            }
            f fVar4 = (f) view.getLayoutParams();
            b2 = b();
            b2.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin);
            if (this.p != null) {
                AtomicInteger atomicInteger = q.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    b2.left = this.p.b() + b2.left;
                    b2.top = this.p.d() + b2.top;
                    b2.right -= this.p.c();
                    b2.bottom -= this.p.a();
                }
            }
            b3 = b();
            int i8 = fVar4.f60c;
            if ((i8 & 7) == 0) {
                i8 |= 8388611;
            }
            if ((i8 & 112) == 0) {
                i8 |= 48;
            }
            int i9 = i8;
            int measuredWidth3 = view.getMeasuredWidth();
            int measuredHeight3 = view.getMeasuredHeight();
            if (Build.VERSION.SDK_INT >= 17) {
                Gravity.apply(i9, measuredWidth3, measuredHeight3, b2, b3, i2);
            } else {
                Gravity.apply(i9, measuredWidth3, measuredHeight3, b2, b3);
            }
            view.layout(b3.left, b3.top, b3.right, b3.bottom);
            return;
        }
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        c cVar = ((f) view.getLayoutParams()).a;
        if (cVar == null || !cVar.t(this, view, rect, z2)) {
            return super.requestChildRectangleOnScreen(view, rect, z2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (!z2 || this.i) {
            return;
        }
        v(false);
        this.i = true;
    }

    public void s(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z2) {
        super.setFitsSystemWindows(z2);
        y();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.s = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.r.setState(getDrawableState());
                }
                b.h.b.a.Y(this.r, q.o(this));
                this.r.setVisible(getVisibility() == 0, false);
                this.r.setCallback(this);
            }
            AtomicInteger atomicInteger = q.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(int i2) {
        setStatusBarBackground(i2 != 0 ? b.h.c.a.b(getContext(), i2) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z2 = i2 == 0;
        Drawable drawable = this.r;
        if (drawable == null || drawable.isVisible() == z2) {
            return;
        }
        this.r.setVisible(z2, false);
    }

    public final boolean t(MotionEvent motionEvent, int i2) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.d;
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        Comparator<View> comparator = y;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
        int size = list.size();
        MotionEvent motionEvent2 = null;
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = list.get(i4);
            f fVar = (f) view.getLayoutParams();
            c cVar = fVar.a;
            boolean z5 = true;
            if (!(z3 || z4) || actionMasked == 0) {
                if (!z3 && cVar != null) {
                    if (i2 == 0) {
                        z3 = cVar.j(this, view, motionEvent);
                    } else if (i2 == 1) {
                        z3 = cVar.A(this, view, motionEvent);
                    }
                    if (z3) {
                        this.l = view;
                    }
                }
                c cVar2 = fVar.a;
                if (cVar2 == null) {
                    fVar.m = false;
                }
                boolean z6 = fVar.m;
                if (z6) {
                    z2 = true;
                } else {
                    z2 = (cVar2 != null && cVar2.c() > 0.0f) | z6;
                    fVar.m = z2;
                }
                if (!z2 || z6) {
                    z5 = false;
                }
                if (z2 && !z5) {
                    break;
                }
                z4 = z5;
            } else if (cVar != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i2 == 0) {
                    cVar.j(this, view, motionEvent2);
                } else if (i2 == 1) {
                    cVar.A(this, view, motionEvent2);
                }
            }
        }
        list.clear();
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
        if (r5 != false) goto L15;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u() {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.u():void");
    }

    public final void v(boolean z2) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            c cVar = ((f) childAt.getLayoutParams()).a;
            if (cVar != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z2) {
                    cVar.j(this, childAt, obtain);
                } else {
                    cVar.A(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            ((f) getChildAt(i3).getLayoutParams()).m = false;
        }
        this.l = null;
        this.i = false;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public final void w(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.i;
        if (i3 != i2) {
            q.w(view, i2 - i3);
            fVar.i = i2;
        }
    }

    public final void x(View view, int i2) {
        f fVar = (f) view.getLayoutParams();
        int i3 = fVar.j;
        if (i3 != i2) {
            q.x(view, i2 - i3);
            fVar.j = i2;
        }
    }

    public final void y() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        AtomicInteger atomicInteger = q.a;
        if (!getFitsSystemWindows()) {
            q.J(this, null);
            return;
        }
        if (this.t == null) {
            this.t = new a();
        }
        q.J(this, this.t);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }
}
