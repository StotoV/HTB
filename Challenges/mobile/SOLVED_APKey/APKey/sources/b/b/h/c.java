package b.b.h;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.g.e.f;
import b.b.g.e.k;
import b.b.g.e.l;
import com.example.apkey.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends b.b.g.e.b {
    public d j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public final SparseBooleanArray t;
    public e u;
    public a v;
    public RunnableC0009c w;
    public b x;
    public final f y;

    /* loaded from: classes.dex */
    public class a extends b.b.g.e.j {
        public a(Context context, b.b.g.e.p pVar, View view) {
            super(context, pVar, view, false, R.attr.actionOverflowMenuStyle, 0);
            if (!pVar.A.g()) {
                View view2 = c.this.j;
                this.f = view2 == null ? (View) c.this.i : view2;
            }
            d(c.this.y);
        }

        @Override // b.b.g.e.j
        public void c() {
            c cVar = c.this;
            cVar.v = null;
            cVar.getClass();
            super.c();
        }
    }

    /* loaded from: classes.dex */
    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* renamed from: b.b.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0009c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public e f205b;

        public RunnableC0009c(e eVar) {
            this.f205b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.a aVar;
            b.b.g.e.f fVar = c.this.d;
            if (fVar != null && (aVar = fVar.e) != null) {
                aVar.a(fVar);
            }
            View view = (View) c.this.i;
            if (view != null && view.getWindowToken() != null && this.f205b.f()) {
                c.this.u = this.f205b;
            }
            c.this.w = null;
        }
    }

    /* loaded from: classes.dex */
    public class d extends m implements ActionMenuView.a {

        /* loaded from: classes.dex */
        public class a extends z {
            public a(View view, c cVar) {
                super(view);
            }

            @Override // b.b.h.z
            public b.b.g.e.n b() {
                e eVar = c.this.u;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // b.b.h.z
            public boolean c() {
                c.this.n();
                return true;
            }

            @Override // b.b.h.z
            public boolean d() {
                c cVar = c.this;
                if (cVar.w != null) {
                    return false;
                }
                cVar.e();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            b.b.a.e(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.n();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                b.h.b.a.W(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* loaded from: classes.dex */
    public class e extends b.b.g.e.j {
        public e(Context context, b.b.g.e.f fVar, View view, boolean z) {
            super(context, fVar, view, z, R.attr.actionOverflowMenuStyle, 0);
            this.g = 8388613;
            d(c.this.y);
        }

        @Override // b.b.g.e.j
        public void c() {
            b.b.g.e.f fVar = c.this.d;
            if (fVar != null) {
                fVar.c(true);
            }
            c.this.u = null;
            super.c();
        }
    }

    /* loaded from: classes.dex */
    public class f implements k.a {
        public f() {
        }

        @Override // b.b.g.e.k.a
        public void a(b.b.g.e.f fVar, boolean z) {
            if (fVar instanceof b.b.g.e.p) {
                fVar.j().c(false);
            }
            k.a aVar = c.this.f;
            if (aVar != null) {
                aVar.a(fVar, z);
            }
        }

        @Override // b.b.g.e.k.a
        public boolean b(b.b.g.e.f fVar) {
            c cVar = c.this;
            if (fVar == cVar.d) {
                return false;
            }
            int i = ((b.b.g.e.p) fVar).A.a;
            k.a aVar = cVar.f;
            if (aVar == null) {
                return false;
            }
            return aVar.b(fVar);
        }
    }

    public c(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.t = new SparseBooleanArray();
        this.y = new f();
    }

    @Override // b.b.g.e.k
    public void a(b.b.g.e.f fVar, boolean z) {
        b();
        k.a aVar = this.f;
        if (aVar != null) {
            aVar.a(fVar, z);
        }
    }

    public boolean b() {
        return e() | i();
    }

    public View c(b.b.g.e.g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        int i = 0;
        if (actionView == null || gVar.f()) {
            l.a aVar = view instanceof l.a ? (l.a) view : (l.a) this.e.inflate(this.h, viewGroup, false);
            aVar.c(gVar, 0);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.i);
            if (this.x == null) {
                this.x = new b();
            }
            actionMenuItemView.setPopupCallback(this.x);
            actionView = (View) aVar;
        }
        if (gVar.C) {
            i = 8;
        }
        actionView.setVisibility(i);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.i(layoutParams));
        }
        return actionView;
    }

    public boolean e() {
        b.b.g.e.l lVar;
        RunnableC0009c runnableC0009c = this.w;
        if (runnableC0009c != null && (lVar = this.i) != null) {
            ((View) lVar).removeCallbacks(runnableC0009c);
            this.w = null;
            return true;
        }
        e eVar = this.u;
        if (eVar == null) {
            return false;
        }
        if (eVar.b()) {
            eVar.j.i();
        }
        return true;
    }

    @Override // b.b.g.e.k
    public boolean g(b.b.g.e.p pVar) {
        boolean z = false;
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        b.b.g.e.p pVar2 = pVar;
        while (true) {
            b.b.g.e.f fVar = pVar2.z;
            if (fVar == this.d) {
                break;
            }
            pVar2 = (b.b.g.e.p) fVar;
        }
        b.b.g.e.g gVar = pVar2.A;
        ViewGroup viewGroup = (ViewGroup) this.i;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof l.a) && ((l.a) childAt).getItemData() == gVar) {
                    view = childAt;
                    break;
                }
                i++;
            }
        }
        if (view == null) {
            return false;
        }
        int i2 = pVar.A.a;
        int size = pVar.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            MenuItem item = pVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i3++;
        }
        a aVar = new a(this.f169c, pVar, view);
        this.v = aVar;
        aVar.h = z;
        b.b.g.e.i iVar = aVar.j;
        if (iVar != null) {
            iVar.q(z);
        }
        if (this.v.f()) {
            k.a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.b(pVar);
            }
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    @Override // b.b.g.e.k
    public boolean h() {
        ArrayList<b.b.g.e.g> arrayList;
        int i;
        int i2;
        boolean z;
        b.b.g.e.f fVar = this.d;
        if (fVar != null) {
            arrayList = fVar.k();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i3 = this.q;
        int i4 = this.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.i;
        int i5 = 0;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= i) {
                break;
            }
            b.b.g.e.g gVar = arrayList.get(i5);
            int i8 = gVar.y;
            if ((i8 & 2) == 2) {
                i7++;
            } else if ((i8 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (this.r && gVar.C) {
                i3 = 0;
            }
            i5++;
        }
        if (this.m && (z2 || i6 + i7 > i3)) {
            i3--;
        }
        int i9 = i3 - i7;
        SparseBooleanArray sparseBooleanArray = this.t;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            b.b.g.e.g gVar2 = arrayList.get(i10);
            int i12 = gVar2.y;
            if ((i12 & 2) == i2) {
                View c2 = c(gVar2, null, viewGroup);
                c2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = c2.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int i13 = gVar2.f184b;
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                gVar2.k(z);
            } else if ((i12 & 1) == z) {
                int i14 = gVar2.f184b;
                boolean z3 = sparseBooleanArray.get(i14);
                boolean z4 = (i9 > 0 || z3) && i4 > 0;
                if (z4) {
                    View c3 = c(gVar2, null, viewGroup);
                    c3.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = c3.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z4 &= i4 + i11 > 0;
                }
                if (z4 && i14 != 0) {
                    sparseBooleanArray.put(i14, true);
                } else if (z3) {
                    sparseBooleanArray.put(i14, false);
                    for (int i15 = 0; i15 < i10; i15++) {
                        b.b.g.e.g gVar3 = arrayList.get(i15);
                        if (gVar3.f184b == i14) {
                            if (gVar3.g()) {
                                i9++;
                            }
                            gVar3.k(false);
                        }
                    }
                }
                if (z4) {
                    i9--;
                }
                gVar2.k(z4);
            } else {
                gVar2.k(false);
                i10++;
                i2 = 2;
                z = true;
            }
            i10++;
            i2 = 2;
            z = true;
        }
        return true;
    }

    public boolean i() {
        a aVar = this.v;
        if (aVar != null) {
            if (!aVar.b()) {
                return true;
            }
            aVar.j.i();
            return true;
        }
        return false;
    }

    @Override // b.b.g.e.k
    public void j(boolean z) {
        int i;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.i;
        ArrayList<b.b.g.e.g> arrayList = null;
        boolean z3 = false;
        if (viewGroup != null) {
            b.b.g.e.f fVar = this.d;
            if (fVar != null) {
                fVar.i();
                ArrayList<b.b.g.e.g> k = this.d.k();
                int size = k.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    b.b.g.e.g gVar = k.get(i2);
                    if (gVar.g()) {
                        View childAt = viewGroup.getChildAt(i);
                        b.b.g.e.g itemData = childAt instanceof l.a ? ((l.a) childAt).getItemData() : null;
                        View c2 = c(gVar, childAt, viewGroup);
                        if (gVar != itemData) {
                            c2.setPressed(false);
                            c2.jumpDrawablesToCurrentState();
                        }
                        if (c2 != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) c2.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(c2);
                            }
                            ((ViewGroup) this.i).addView(c2, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.j) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i);
                    z2 = true;
                }
                if (!z2) {
                    i++;
                }
            }
        }
        ((View) this.i).requestLayout();
        b.b.g.e.f fVar2 = this.d;
        if (fVar2 != null) {
            fVar2.i();
            ArrayList<b.b.g.e.g> arrayList2 = fVar2.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                b.h.j.b bVar = arrayList2.get(i3).A;
            }
        }
        b.b.g.e.f fVar3 = this.d;
        if (fVar3 != null) {
            fVar3.i();
            arrayList = fVar3.j;
        }
        if (this.m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z3 = !arrayList.get(0).C;
            } else if (size3 > 0) {
                z3 = true;
            }
        }
        d dVar = this.j;
        if (z3) {
            if (dVar == null) {
                this.j = new d(this.f168b);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.j.getParent();
            if (viewGroup3 != this.i) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                d dVar2 = this.j;
                ActionMenuView.c generateDefaultLayoutParams = actionMenuView.generateDefaultLayoutParams();
                generateDefaultLayoutParams.a = true;
                actionMenuView.addView(dVar2, generateDefaultLayoutParams);
            }
        } else if (dVar != null) {
            ViewParent parent = dVar.getParent();
            b.b.g.e.l lVar = this.i;
            if (parent == lVar) {
                ((ViewGroup) lVar).removeView(this.j);
            }
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    @Override // b.b.g.e.k
    public void k(Context context, b.b.g.e.f fVar) {
        this.f169c = context;
        LayoutInflater.from(context);
        this.d = fVar;
        Resources resources = context.getResources();
        if (!this.n) {
            boolean z = true;
            if (Build.VERSION.SDK_INT < 19) {
                z = true ^ ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            this.m = z;
        }
        int i = 2;
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.q = i;
        int i4 = this.o;
        if (this.m) {
            if (this.j == null) {
                d dVar = new d(this.f168b);
                this.j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = i4;
        this.s = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public boolean m() {
        e eVar = this.u;
        return eVar != null && eVar.b();
    }

    public boolean n() {
        b.b.g.e.f fVar;
        if (!this.m || m() || (fVar = this.d) == null || this.i == null || this.w != null) {
            return false;
        }
        fVar.i();
        if (fVar.j.isEmpty()) {
            return false;
        }
        RunnableC0009c runnableC0009c = new RunnableC0009c(new e(this.f169c, this.d, this.j, true));
        this.w = runnableC0009c;
        ((View) this.i).post(runnableC0009c);
        return true;
    }
}
