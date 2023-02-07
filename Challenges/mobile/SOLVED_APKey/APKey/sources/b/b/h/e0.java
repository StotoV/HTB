package b.b.h;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class e0 extends c0 implements d0 {
    public static Method F;
    public d0 E;

    /* loaded from: classes.dex */
    public static class a extends x {
        public final int o;
        public final int p;
        public d0 q;
        public MenuItem r;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.o = 22;
                this.p = 21;
                return;
            }
            this.o = 21;
            this.p = 22;
        }

        @Override // b.b.h.x, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            int pointToPosition;
            int i2;
            if (this.q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                }
                b.b.g.e.e eVar = (b.b.g.e.e) adapter;
                b.b.g.e.g gVar = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < eVar.getCount()) {
                    gVar = eVar.getItem(i2);
                }
                MenuItem menuItem = this.r;
                if (menuItem != gVar) {
                    b.b.g.e.f fVar = eVar.f180b;
                    if (menuItem != null) {
                        this.q.d(fVar, menuItem);
                    }
                    this.r = gVar;
                    if (gVar != null) {
                        this.q.a(fVar, gVar);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i != this.p) {
                return super.onKeyDown(i, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                }
                ((b.b.g.e.e) adapter).f180b.c(false);
                return true;
            }
        }

        public void setHoverListener(d0 d0Var) {
            this.q = d0Var;
        }

        @Override // b.b.h.x, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT > 28) {
                return;
            }
            F = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public e0(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, null, i, i2);
    }

    @Override // b.b.h.d0
    public void a(b.b.g.e.f fVar, MenuItem menuItem) {
        d0 d0Var = this.E;
        if (d0Var != null) {
            d0Var.a(fVar, menuItem);
        }
    }

    @Override // b.b.h.d0
    public void d(b.b.g.e.f fVar, MenuItem menuItem) {
        d0 d0Var = this.E;
        if (d0Var != null) {
            d0Var.d(fVar, menuItem);
        }
    }

    @Override // b.b.h.c0
    public x f(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }
}
