package b.b.h;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c0 implements b.b.g.e.n {
    public static Method B;
    public static Method C;
    public static Method D;
    public PopupWindow A;

    /* renamed from: b  reason: collision with root package name */
    public Context f207b;

    /* renamed from: c  reason: collision with root package name */
    public ListAdapter f208c;
    public x d;
    public int g;
    public int h;
    public boolean j;
    public boolean k;
    public boolean l;
    public DataSetObserver p;
    public View q;
    public AdapterView.OnItemClickListener r;
    public final Handler w;
    public Rect y;
    public boolean z;
    public int e = -2;
    public int f = -2;
    public int i = 1002;
    public int m = 0;
    public int n = Integer.MAX_VALUE;
    public int o = 0;
    public final e s = new e();
    public final d t = new d();
    public final c u = new c();
    public final a v = new a();
    public final Rect x = new Rect();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = c0.this.d;
            if (xVar != null) {
                xVar.setListSelectionHidden(true);
                xVar.requestLayout();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (c0.this.b()) {
                c0.this.e();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            c0.this.i();
        }
    }

    /* loaded from: classes.dex */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            boolean z = true;
            if (i == 1) {
                if (c0.this.A.getInputMethodMode() != 2) {
                    z = false;
                }
                if (z || c0.this.A.getContentView() == null) {
                    return;
                }
                c0 c0Var = c0.this;
                c0Var.w.removeCallbacks(c0Var.s);
                c0.this.s.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = c0.this.A) != null && popupWindow.isShowing() && x >= 0 && x < c0.this.A.getWidth() && y >= 0 && y < c0.this.A.getHeight()) {
                c0 c0Var = c0.this;
                c0Var.w.postDelayed(c0Var.s, 250L);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                c0 c0Var2 = c0.this;
                c0Var2.w.removeCallbacks(c0Var2.s);
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = c0.this.d;
            if (xVar == null || !b.h.j.q.t(xVar) || c0.this.d.getCount() <= c0.this.d.getChildCount()) {
                return;
            }
            int childCount = c0.this.d.getChildCount();
            c0 c0Var = c0.this;
            if (childCount > c0Var.n) {
                return;
            }
            c0Var.A.setInputMethodMode(2);
            c0.this.e();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                B = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                D = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                C = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public c0(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f207b = context;
        this.w = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.b.n, i, i2);
        this.g = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.j = true;
        }
        obtainStyledAttributes.recycle();
        n nVar = new n(context, attributeSet, i, i2);
        this.A = nVar;
        nVar.setInputMethodMode(1);
    }

    @Override // b.b.g.e.n
    public boolean b() {
        return this.A.isShowing();
    }

    @Override // b.b.g.e.n
    public ListView c() {
        return this.d;
    }

    @Override // b.b.g.e.n
    public void e() {
        int i;
        int maxAvailableHeight;
        int i2;
        int paddingBottom;
        x xVar;
        if (this.d == null) {
            x f = f(this.f207b, !this.z);
            this.d = f;
            f.setAdapter(this.f208c);
            this.d.setOnItemClickListener(this.r);
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            this.d.setOnItemSelectedListener(new b0(this));
            this.d.setOnScrollListener(this.u);
            this.A.setContentView(this.d);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.A.getContentView();
        }
        Drawable background = this.A.getBackground();
        int i3 = 0;
        if (background != null) {
            background.getPadding(this.x);
            Rect rect = this.x;
            int i4 = rect.top;
            i = rect.bottom + i4;
            if (!this.j) {
                this.h = -i4;
            }
        } else {
            this.x.setEmpty();
            i = 0;
        }
        boolean z = this.A.getInputMethodMode() == 2;
        View view = this.q;
        int i5 = this.h;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = C;
            if (method != null) {
                try {
                    maxAvailableHeight = ((Integer) method.invoke(this.A, view, Integer.valueOf(i5), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            maxAvailableHeight = this.A.getMaxAvailableHeight(view, i5);
        } else {
            maxAvailableHeight = this.A.getMaxAvailableHeight(view, i5, z);
        }
        if (this.e == -1) {
            paddingBottom = maxAvailableHeight + i;
        } else {
            int i6 = this.f;
            if (i6 != -2) {
                i2 = 1073741824;
                if (i6 == -1) {
                    int i7 = this.f207b.getResources().getDisplayMetrics().widthPixels;
                    Rect rect2 = this.x;
                    i6 = i7 - (rect2.left + rect2.right);
                }
            } else {
                int i8 = this.f207b.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.x;
                i6 = i8 - (rect3.left + rect3.right);
                i2 = Integer.MIN_VALUE;
            }
            int a2 = this.d.a(View.MeasureSpec.makeMeasureSpec(i6, i2), maxAvailableHeight - 0, -1);
            paddingBottom = a2 + (a2 > 0 ? this.d.getPaddingBottom() + this.d.getPaddingTop() + i + 0 : 0);
        }
        boolean z2 = this.A.getInputMethodMode() == 2;
        b.h.b.a.i0(this.A, this.i);
        if (this.A.isShowing()) {
            if (!b.h.j.q.t(this.q)) {
                return;
            }
            int i9 = this.f;
            if (i9 == -1) {
                i9 = -1;
            } else if (i9 == -2) {
                i9 = this.q.getWidth();
            }
            int i10 = this.e;
            if (i10 == -1) {
                if (!z2) {
                    paddingBottom = -1;
                }
                if (z2) {
                    this.A.setWidth(this.f == -1 ? -1 : 0);
                    this.A.setHeight(0);
                } else {
                    PopupWindow popupWindow = this.A;
                    if (this.f == -1) {
                        i3 = -1;
                    }
                    popupWindow.setWidth(i3);
                    this.A.setHeight(-1);
                }
            } else if (i10 != -2) {
                paddingBottom = i10;
            }
            this.A.setOutsideTouchable(true);
            this.A.update(this.q, this.g, this.h, i9 < 0 ? -1 : i9, paddingBottom < 0 ? -1 : paddingBottom);
            return;
        }
        int i11 = this.f;
        if (i11 == -1) {
            i11 = -1;
        } else if (i11 == -2) {
            i11 = this.q.getWidth();
        }
        int i12 = this.e;
        if (i12 == -1) {
            paddingBottom = -1;
        } else if (i12 != -2) {
            paddingBottom = i12;
        }
        this.A.setWidth(i11);
        this.A.setHeight(paddingBottom);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = B;
            if (method2 != null) {
                try {
                    method2.invoke(this.A, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.A.setIsClippedToScreen(true);
        }
        this.A.setOutsideTouchable(true);
        this.A.setTouchInterceptor(this.t);
        if (this.l) {
            b.h.b.a.c0(this.A, this.k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = D;
            if (method3 != null) {
                try {
                    method3.invoke(this.A, this.y);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            this.A.setEpicenterBounds(this.y);
        }
        PopupWindow popupWindow2 = this.A;
        View view2 = this.q;
        int i13 = this.g;
        int i14 = this.h;
        int i15 = this.m;
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow2.showAsDropDown(view2, i13, i14, i15);
        } else {
            if ((b.h.b.a.x(i15, b.h.j.q.o(view2)) & 7) == 5) {
                i13 -= popupWindow2.getWidth() - view2.getWidth();
            }
            popupWindow2.showAsDropDown(view2, i13, i14);
        }
        this.d.setSelection(-1);
        if ((!this.z || this.d.isInTouchMode()) && (xVar = this.d) != null) {
            xVar.setListSelectionHidden(true);
            xVar.requestLayout();
        }
        if (this.z) {
            return;
        }
        this.w.post(this.v);
    }

    public x f(Context context, boolean z) {
        throw null;
    }

    public void g(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.p;
        if (dataSetObserver == null) {
            this.p = new b();
        } else {
            ListAdapter listAdapter2 = this.f208c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f208c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.p);
        }
        x xVar = this.d;
        if (xVar != null) {
            xVar.setAdapter(this.f208c);
        }
    }

    public void h(int i) {
        Drawable background = this.A.getBackground();
        if (background == null) {
            this.f = i;
            return;
        }
        background.getPadding(this.x);
        Rect rect = this.x;
        this.f = rect.left + rect.right + i;
    }

    @Override // b.b.g.e.n
    public void i() {
        this.A.dismiss();
        this.A.setContentView(null);
        this.d = null;
        this.w.removeCallbacks(this.s);
    }

    public void j(boolean z) {
        this.z = z;
        this.A.setFocusable(z);
    }

    public void k(int i) {
        this.h = i;
        this.j = true;
    }
}
