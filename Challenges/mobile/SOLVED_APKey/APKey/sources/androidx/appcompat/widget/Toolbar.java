package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.c.a;
import b.b.g.e.k;
import b.b.g.e.p;
import b.b.h.h0;
import b.b.h.m;
import b.b.h.o0;
import b.b.h.q0;
import b.b.h.s;
import b.b.h.v;
import b.h.j.q;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList<View> E;
    public final ArrayList<View> F;
    public final int[] G;
    public f H;
    public final ActionMenuView.e I;
    public q0 J;
    public b.b.h.c K;
    public d L;
    public boolean M;
    public final Runnable N;

    /* renamed from: b  reason: collision with root package name */
    public ActionMenuView f42b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f43c;
    public TextView d;
    public ImageButton e;
    public ImageView f;
    public Drawable g;
    public CharSequence h;
    public ImageButton i;
    public View j;
    public Context k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public h0 u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    /* loaded from: classes.dex */
    public class a implements ActionMenuView.e {
        public a() {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.v();
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = Toolbar.this.L;
            b.b.g.e.g gVar = dVar == null ? null : dVar.f47c;
            if (gVar != null) {
                gVar.collapseActionView();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements k {

        /* renamed from: b  reason: collision with root package name */
        public b.b.g.e.f f46b;

        /* renamed from: c  reason: collision with root package name */
        public b.b.g.e.g f47c;

        public d() {
        }

        @Override // b.b.g.e.k
        public void a(b.b.g.e.f fVar, boolean z) {
        }

        @Override // b.b.g.e.k
        public boolean d(b.b.g.e.f fVar, b.b.g.e.g gVar) {
            Toolbar.this.c();
            ViewParent parent = Toolbar.this.i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.i);
            }
            Toolbar.this.j = gVar.getActionView();
            this.f47c = gVar;
            ViewParent parent2 = Toolbar.this.j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.j);
                }
                e generateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                generateDefaultLayoutParams.a = 8388611 | (toolbar4.o & 112);
                generateDefaultLayoutParams.f48b = 2;
                toolbar4.j.setLayoutParams(generateDefaultLayoutParams);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.j);
            }
            Toolbar toolbar6 = Toolbar.this;
            int childCount = toolbar6.getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    break;
                }
                View childAt = toolbar6.getChildAt(childCount);
                if (((e) childAt.getLayoutParams()).f48b != 2 && childAt != toolbar6.f42b) {
                    toolbar6.removeViewAt(childCount);
                    toolbar6.F.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            gVar.C = true;
            gVar.n.p(false);
            View view = Toolbar.this.j;
            if (view instanceof b.b.g.a) {
                ((b.b.g.a) view).a();
            }
            return true;
        }

        @Override // b.b.g.e.k
        public boolean g(p pVar) {
            return false;
        }

        @Override // b.b.g.e.k
        public boolean h() {
            return false;
        }

        @Override // b.b.g.e.k
        public void j(boolean z) {
            if (this.f47c != null) {
                b.b.g.e.f fVar = this.f46b;
                boolean z2 = false;
                if (fVar != null) {
                    int size = fVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f46b.getItem(i) == this.f47c) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (z2) {
                    return;
                }
                l(this.f46b, this.f47c);
            }
        }

        @Override // b.b.g.e.k
        public void k(Context context, b.b.g.e.f fVar) {
            b.b.g.e.g gVar;
            b.b.g.e.f fVar2 = this.f46b;
            if (fVar2 != null && (gVar = this.f47c) != null) {
                fVar2.d(gVar);
            }
            this.f46b = fVar;
        }

        @Override // b.b.g.e.k
        public boolean l(b.b.g.e.f fVar, b.b.g.e.g gVar) {
            View view = Toolbar.this.j;
            if (view instanceof b.b.g.a) {
                ((b.b.g.a) view).d();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.j = null;
            int size = toolbar3.F.size();
            while (true) {
                size--;
                if (size < 0) {
                    toolbar3.F.clear();
                    this.f47c = null;
                    Toolbar.this.requestLayout();
                    gVar.C = false;
                    gVar.n.p(false);
                    return true;
                }
                toolbar3.addView(toolbar3.F.get(size));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0003a {

        /* renamed from: b  reason: collision with root package name */
        public int f48b;

        public e(int i, int i2) {
            super(i, i2);
            this.f48b = 0;
            this.a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f48b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f48b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f48b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(e eVar) {
            super((a.C0003a) eVar);
            this.f48b = 0;
            this.f48b = eVar.f48b;
        }

        public e(a.C0003a c0003a) {
            super(c0003a);
            this.f48b = 0;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public static class g extends b.j.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public int d;
        public boolean e;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new g[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = parcel.readInt();
            this.e = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.N = new b();
        Context context2 = getContext();
        int[] iArr = b.b.b.w;
        o0 p = o0.p(context2, attributeSet, iArr, i, 0);
        q.E(this, context, iArr, attributeSet, p.f252b, i, 0);
        this.m = p.k(28, 0);
        this.n = p.k(19, 0);
        this.x = p.f252b.getInteger(0, this.x);
        this.o = p.f252b.getInteger(2, 48);
        int e2 = p.e(22, 0);
        e2 = p.n(27) ? p.e(27, e2) : e2;
        this.t = e2;
        this.s = e2;
        this.r = e2;
        this.q = e2;
        int e3 = p.e(25, -1);
        if (e3 >= 0) {
            this.q = e3;
        }
        int e4 = p.e(24, -1);
        if (e4 >= 0) {
            this.r = e4;
        }
        int e5 = p.e(26, -1);
        if (e5 >= 0) {
            this.s = e5;
        }
        int e6 = p.e(23, -1);
        if (e6 >= 0) {
            this.t = e6;
        }
        this.p = p.f(13, -1);
        int e7 = p.e(9, Integer.MIN_VALUE);
        int e8 = p.e(5, Integer.MIN_VALUE);
        int f2 = p.f(7, 0);
        int f3 = p.f(8, 0);
        d();
        h0 h0Var = this.u;
        h0Var.h = false;
        if (f2 != Integer.MIN_VALUE) {
            h0Var.e = f2;
            h0Var.a = f2;
        }
        if (f3 != Integer.MIN_VALUE) {
            h0Var.f = f3;
            h0Var.f224b = f3;
        }
        if (e7 != Integer.MIN_VALUE || e8 != Integer.MIN_VALUE) {
            h0Var.a(e7, e8);
        }
        this.v = p.e(10, Integer.MIN_VALUE);
        this.w = p.e(6, Integer.MIN_VALUE);
        this.g = p.g(4);
        this.h = p.m(3);
        CharSequence m = p.m(21);
        if (!TextUtils.isEmpty(m)) {
            setTitle(m);
        }
        CharSequence m2 = p.m(18);
        if (!TextUtils.isEmpty(m2)) {
            setSubtitle(m2);
        }
        this.k = getContext();
        setPopupTheme(p.k(17, 0));
        Drawable g2 = p.g(16);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence m3 = p.m(15);
        if (!TextUtils.isEmpty(m3)) {
            setNavigationContentDescription(m3);
        }
        Drawable g3 = p.g(11);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence m4 = p.m(12);
        if (!TextUtils.isEmpty(m4)) {
            setLogoDescription(m4);
        }
        if (p.n(29)) {
            setTitleTextColor(p.c(29));
        }
        if (p.n(20)) {
            setSubtitleTextColor(p.c(20));
        }
        if (p.n(14)) {
            getMenuInflater().inflate(p.k(14, 0), getMenu());
        }
        p.f252b.recycle();
    }

    private MenuInflater getMenuInflater() {
        return new b.b.g.c(getContext());
    }

    public final void a(List<View> list, int i) {
        boolean z = q.o(this) == 1;
        int childCount = getChildCount();
        int x = b.h.b.a.x(i, q.o(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f48b == 0 && u(childAt) && j(eVar.a) == x) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f48b == 0 && u(childAt2) && j(eVar2.a) == x) {
                list.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        generateDefaultLayoutParams.f48b = 1;
        if (!z || this.j == null) {
            addView(view, generateDefaultLayoutParams);
            return;
        }
        view.setLayoutParams(generateDefaultLayoutParams);
        this.F.add(view);
    }

    public void c() {
        if (this.i == null) {
            b.b.h.k kVar = new b.b.h.k(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.i = kVar;
            kVar.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.o & 112);
            generateDefaultLayoutParams.f48b = 2;
            this.i.setLayoutParams(generateDefaultLayoutParams);
            this.i.setOnClickListener(new c());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final void d() {
        if (this.u == null) {
            this.u = new h0();
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f42b;
        if (actionMenuView.q == null) {
            b.b.g.e.f fVar = (b.b.g.e.f) actionMenuView.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f42b.setExpandedActionViewsExclusive(true);
            fVar.b(this.L, this.k);
        }
    }

    public final void f() {
        if (this.f42b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f42b = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.f42b.setOnMenuItemClickListener(this.I);
            ActionMenuView actionMenuView2 = this.f42b;
            actionMenuView2.v = null;
            actionMenuView2.w = null;
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388613 | (this.o & 112);
            this.f42b.setLayoutParams(generateDefaultLayoutParams);
            b(this.f42b, false);
        }
    }

    public final void g() {
        if (this.e == null) {
            this.e = new b.b.h.k(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            e generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.a = 8388611 | (this.o & 112);
            this.e.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        h0 h0Var = this.u;
        if (h0Var != null) {
            return h0Var.g ? h0Var.a : h0Var.f224b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.w;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        h0 h0Var = this.u;
        if (h0Var != null) {
            return h0Var.a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        h0 h0Var = this.u;
        if (h0Var != null) {
            return h0Var.f224b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        h0 h0Var = this.u;
        if (h0Var != null) {
            return h0Var.g ? h0Var.f224b : h0Var.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        b.b.g.e.f fVar;
        ActionMenuView actionMenuView = this.f42b;
        return actionMenuView != null && (fVar = actionMenuView.q) != null && fVar.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return q.o(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return q.o(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f42b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public b.b.h.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f42b.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.k;
    }

    public int getPopupTheme() {
        return this.l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.d;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public final TextView getTitleTextView() {
        return this.f43c;
    }

    public v getWrapper() {
        if (this.J == null) {
            this.J = new q0(this, true);
        }
        return this.J;
    }

    @Override // android.view.ViewGroup
    /* renamed from: h */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: i */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0003a ? new e((a.C0003a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int j(int i) {
        int o = q.o(this);
        int x = b.h.b.a.x(i, o) & 7;
        return (x == 1 || x == 3 || x == 5) ? x : o == 1 ? 5 : 3;
    }

    public final int k(View view, int i) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = eVar.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.x & 112;
        }
        if (i3 != 48) {
            if (i3 == 80) {
                return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i2;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
            int i5 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
            if (i4 < i5) {
                i4 = i5;
            } else {
                int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                if (i6 < i7) {
                    i4 = Math.max(0, i4 - (i7 - i6));
                }
            }
            return paddingTop + i4;
        }
        return getPaddingTop() - i2;
    }

    public final int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return b.h.b.a.B(marginLayoutParams) + (Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginEnd() : marginLayoutParams.rightMargin);
    }

    public final int m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public void n(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.N);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0295 A[LOOP:0: B:109:0x0293->B:110:0x0295, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b7 A[LOOP:1: B:112:0x02b5->B:113:0x02b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02dc A[LOOP:2: B:115:0x02da->B:116:0x02dc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x032e A[LOOP:3: B:124:0x032c->B:125:0x032e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0296  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instructions count: 667
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.f510b);
        ActionMenuView actionMenuView = this.f42b;
        b.b.g.e.f fVar = actionMenuView != null ? actionMenuView.q : null;
        int i = gVar.d;
        if (i != 0 && this.L != null && fVar != null && (findItem = fVar.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (!gVar.e) {
            return;
        }
        removeCallbacks(this.N);
        post(this.N);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r1 != Integer.MIN_VALUE) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003b, code lost:
        if (r1 != Integer.MIN_VALUE) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onRtlPropertiesChanged(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 < r1) goto L9
            super.onRtlPropertiesChanged(r3)
        L9:
            r2.d()
            b.b.h.h0 r0 = r2.u
            r1 = 1
            if (r3 != r1) goto L12
            goto L13
        L12:
            r1 = 0
        L13:
            boolean r3 = r0.g
            if (r1 != r3) goto L18
            goto L46
        L18:
            r0.g = r1
            boolean r3 = r0.h
            if (r3 == 0) goto L3e
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == 0) goto L30
            int r1 = r0.d
            if (r1 == r3) goto L27
            goto L29
        L27:
            int r1 = r0.e
        L29:
            r0.a = r1
            int r1 = r0.f225c
            if (r1 == r3) goto L42
            goto L44
        L30:
            int r1 = r0.f225c
            if (r1 == r3) goto L35
            goto L37
        L35:
            int r1 = r0.e
        L37:
            r0.a = r1
            int r1 = r0.d
            if (r1 == r3) goto L42
            goto L44
        L3e:
            int r3 = r0.e
            r0.a = r3
        L42:
            int r1 = r0.f
        L44:
            r0.f224b = r1
        L46:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onRtlPropertiesChanged(int):void");
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        b.b.g.e.g gVar;
        g gVar2 = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (dVar != null && (gVar = dVar.f47c) != null) {
            gVar2.d = gVar.a;
        }
        gVar2.e = p();
        return gVar2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public boolean p() {
        ActionMenuView actionMenuView = this.f42b;
        if (actionMenuView != null) {
            b.b.h.c cVar = actionMenuView.u;
            if (cVar != null && cVar.m()) {
                return true;
            }
        }
        return false;
    }

    public final int q(View view, int i, int[] iArr, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int k = k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, k, max + measuredWidth, view.getMeasuredHeight() + k);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin + max;
    }

    public final int r(View view, int i, int[] iArr, int i2) {
        e eVar = (e) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int k = k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, k, max, view.getMeasuredHeight() + k);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int s(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(b.b.d.a.a.b(getContext(), i));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.i.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.i;
        if (imageButton == null) {
            return;
        }
        imageButton.setImageDrawable(this.g);
    }

    public void setCollapsible(boolean z) {
        this.M = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.w) {
            this.w = i;
            if (getNavigationIcon() == null) {
                return;
            }
            requestLayout();
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() == null) {
                return;
            }
            requestLayout();
        }
    }

    public void setLogo(int i) {
        setLogo(b.b.d.a.a.b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f == null) {
                this.f = new m(getContext(), null, 0);
            }
            if (!o(this.f)) {
                b(this.f, true);
            }
        } else {
            ImageView imageView = this.f;
            if (imageView != null && o(imageView)) {
                removeView(this.f);
                this.F.remove(this.f);
            }
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f == null) {
            this.f = new m(getContext(), null, 0);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(b.b.d.a.a.b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.e)) {
                b(this.e, true);
            }
        } else {
            ImageButton imageButton = this.e;
            if (imageButton != null && o(imageButton)) {
                removeView(this.e);
                this.F.remove(this.e);
            }
        }
        ImageButton imageButton2 = this.e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f42b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.l != i) {
            this.l = i;
            if (i == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.d == null) {
                Context context = getContext();
                s sVar = new s(context, null);
                this.d = sVar;
                sVar.setSingleLine();
                this.d.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.n;
                if (i != 0) {
                    this.d.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.d.setTextColor(colorStateList);
                }
            }
            if (!o(this.d)) {
                b(this.d, true);
            }
        } else {
            TextView textView = this.d;
            if (textView != null && o(textView)) {
                removeView(this.d);
                this.F.remove(this.d);
            }
        }
        TextView textView2 = this.d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f43c == null) {
                Context context = getContext();
                s sVar = new s(context, null);
                this.f43c = sVar;
                sVar.setSingleLine();
                this.f43c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.f43c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f43c.setTextColor(colorStateList);
                }
            }
            if (!o(this.f43c)) {
                b(this.f43c, true);
            }
        } else {
            TextView textView = this.f43c;
            if (textView != null && o(textView)) {
                removeView(this.f43c);
                this.F.remove(this.f43c);
            }
        }
        TextView textView2 = this.f43c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f43c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void t(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean v() {
        ActionMenuView actionMenuView = this.f42b;
        if (actionMenuView != null) {
            b.b.h.c cVar = actionMenuView.u;
            if (cVar != null && cVar.n()) {
                return true;
            }
        }
        return false;
    }
}
