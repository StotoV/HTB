package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import b.b.g.e.f;
import b.b.g.e.g;
import b.b.g.e.l;
import b.b.g.e.n;
import b.b.h.c;
import b.b.h.s;
import b.b.h.z;
/* loaded from: classes.dex */
public class ActionMenuItemView extends s implements l.a, View.OnClickListener, ActionMenuView.a {
    public g g;
    public CharSequence h;
    public Drawable i;
    public f.b j;
    public z k;
    public b l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;

    /* loaded from: classes.dex */
    public class a extends z {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // b.b.h.z
        public n b() {
            c.a aVar;
            b bVar = ActionMenuItemView.this.l;
            if (bVar == null || (aVar = c.this.v) == null) {
                return null;
            }
            return aVar.a();
        }

        @Override // b.b.h.z
        public boolean c() {
            n b2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            f.b bVar = actionMenuItemView.j;
            return bVar != null && bVar.b(actionMenuItemView.g) && (b2 = b()) != null && b2.b();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.m = e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.b.f133c, 0, 0);
        this.o = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        this.q = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.p = -1;
        setSaveEnabled(false);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean a() {
        return d() && this.g.getIcon() == null;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean b() {
        return d();
    }

    @Override // b.b.g.e.l.a
    public void c(g gVar, int i) {
        this.g = gVar;
        setIcon(gVar.getIcon());
        setTitle(gVar.getTitleCondensed());
        setId(gVar.a);
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (!gVar.hasSubMenu() || this.k != null) {
            return;
        }
        this.k = new a();
    }

    public boolean d() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.h);
        if (this.i != null) {
            if (!((this.g.y & 4) == 4) || (!this.m && !this.n)) {
                z = false;
            }
        }
        boolean z3 = z2 & z;
        CharSequence charSequence = null;
        setText(z3 ? this.h : null);
        CharSequence charSequence2 = this.g.q;
        if (TextUtils.isEmpty(charSequence2)) {
            charSequence2 = z3 ? null : this.g.e;
        }
        setContentDescription(charSequence2);
        CharSequence charSequence3 = this.g.r;
        if (!TextUtils.isEmpty(charSequence3)) {
            b.b.a.e(this, charSequence3);
            return;
        }
        if (!z3) {
            charSequence = this.g.e;
        }
        b.b.a.e(this, charSequence);
    }

    @Override // b.b.g.e.l.a
    public g getItemData() {
        return this.g;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f.b bVar = this.j;
        if (bVar != null) {
            bVar.b(this.g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.m = e();
        f();
    }

    @Override // b.b.h.s, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        boolean d = d();
        if (d && (i3 = this.p) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.o) : this.o;
        if (mode != 1073741824 && this.o > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (d || this.i == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        z zVar;
        if (!this.g.hasSubMenu() || (zVar = this.k) == null || !zVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.n != z) {
            this.n = z;
            g gVar = this.g;
            if (gVar == null) {
                return;
            }
            gVar.n.o();
        }
    }

    public void setIcon(Drawable drawable) {
        this.i = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.q;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        f();
    }

    public void setItemInvoker(f.b bVar) {
        this.j = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.p = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(b bVar) {
        this.l = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.h = charSequence;
        f();
    }
}
