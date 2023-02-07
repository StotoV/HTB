package b.b.g.e;

import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import b.b.g.e.k;
import b.b.h.e0;
import com.example.apkey.R;
/* loaded from: classes.dex */
public final class o extends i implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, k, View.OnKeyListener {

    /* renamed from: c  reason: collision with root package name */
    public final Context f195c;
    public final f d;
    public final e e;
    public final boolean f;
    public final int g;
    public final int h;
    public final int i;
    public final e0 j;
    public PopupWindow.OnDismissListener m;
    public View n;
    public View o;
    public k.a p;
    public ViewTreeObserver q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean v;
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public int u = 0;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (o.this.b()) {
                o oVar = o.this;
                if (oVar.j.z) {
                    return;
                }
                View view = oVar.o;
                if (view == null || !view.isShown()) {
                    o.this.i();
                } else {
                    o.this.j.e();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = o.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    o.this.q = view.getViewTreeObserver();
                }
                o oVar = o.this;
                oVar.q.removeGlobalOnLayoutListener(oVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public o(Context context, f fVar, View view, int i, int i2, boolean z) {
        this.f195c = context;
        this.d = fVar;
        this.f = z;
        this.e = new e(fVar, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.h = i;
        this.i = i2;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new e0(context, null, i, i2);
        fVar.b(this, context);
    }

    @Override // b.b.g.e.k
    public void a(f fVar, boolean z) {
        if (fVar != this.d) {
            return;
        }
        i();
        k.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        aVar.a(fVar, z);
    }

    @Override // b.b.g.e.n
    public boolean b() {
        return !this.r && this.j.b();
    }

    @Override // b.b.g.e.n
    public ListView c() {
        return this.j.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    @Override // b.b.g.e.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e() {
        /*
            r7 = this;
            boolean r0 = r7.b()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lb
        L8:
            r1 = 1
            goto Lc7
        Lb:
            boolean r0 = r7.r
            if (r0 != 0) goto Lc7
            android.view.View r0 = r7.n
            if (r0 != 0) goto L15
            goto Lc7
        L15:
            r7.o = r0
            b.b.h.e0 r0 = r7.j
            android.widget.PopupWindow r0 = r0.A
            r0.setOnDismissListener(r7)
            b.b.h.e0 r0 = r7.j
            r0.r = r7
            r0.j(r2)
            android.view.View r0 = r7.o
            android.view.ViewTreeObserver r3 = r7.q
            if (r3 != 0) goto L2d
            r3 = 1
            goto L2e
        L2d:
            r3 = 0
        L2e:
            android.view.ViewTreeObserver r4 = r0.getViewTreeObserver()
            r7.q = r4
            if (r3 == 0) goto L3b
            android.view.ViewTreeObserver$OnGlobalLayoutListener r3 = r7.k
            r4.addOnGlobalLayoutListener(r3)
        L3b:
            android.view.View$OnAttachStateChangeListener r3 = r7.l
            r0.addOnAttachStateChangeListener(r3)
            b.b.h.e0 r3 = r7.j
            r3.q = r0
            int r0 = r7.u
            r3.m = r0
            boolean r0 = r7.s
            r3 = 0
            if (r0 != 0) goto L5b
            b.b.g.e.e r0 = r7.e
            android.content.Context r4 = r7.f195c
            int r5 = r7.g
            int r0 = b.b.g.e.i.o(r0, r3, r4, r5)
            r7.t = r0
            r7.s = r2
        L5b:
            b.b.h.e0 r0 = r7.j
            int r4 = r7.t
            r0.h(r4)
            b.b.h.e0 r0 = r7.j
            r4 = 2
            android.widget.PopupWindow r0 = r0.A
            r0.setInputMethodMode(r4)
            b.b.h.e0 r0 = r7.j
            android.graphics.Rect r4 = r7.f191b
            r0.getClass()
            if (r4 == 0) goto L79
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>(r4)
            goto L7a
        L79:
            r5 = r3
        L7a:
            r0.y = r5
            b.b.h.e0 r0 = r7.j
            r0.e()
            b.b.h.e0 r0 = r7.j
            b.b.h.x r0 = r0.d
            r0.setOnKeyListener(r7)
            boolean r4 = r7.v
            if (r4 == 0) goto Lb9
            b.b.g.e.f r4 = r7.d
            java.lang.CharSequence r4 = r4.m
            if (r4 == 0) goto Lb9
            android.content.Context r4 = r7.f195c
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r5 = 2131427346(0x7f0b0012, float:1.8476306E38)
            android.view.View r4 = r4.inflate(r5, r0, r1)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto Lb3
            b.b.g.e.f r6 = r7.d
            java.lang.CharSequence r6 = r6.m
            r5.setText(r6)
        Lb3:
            r4.setEnabled(r1)
            r0.addHeaderView(r4, r3, r1)
        Lb9:
            b.b.h.e0 r0 = r7.j
            b.b.g.e.e r1 = r7.e
            r0.g(r1)
            b.b.h.e0 r0 = r7.j
            r0.e()
            goto L8
        Lc7:
            if (r1 == 0) goto Lca
            return
        Lca:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "StandardMenuPopup cannot be used without an anchor"
            r0.<init>(r1)
            goto Ld3
        Ld2:
            throw r0
        Ld3:
            goto Ld2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.g.e.o.e():void");
    }

    @Override // b.b.g.e.k
    public void f(k.a aVar) {
        this.p = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // b.b.g.e.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(b.b.g.e.p r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L76
            b.b.g.e.j r0 = new b.b.g.e.j
            android.content.Context r3 = r9.f195c
            android.view.View r5 = r9.o
            boolean r6 = r9.f
            int r7 = r9.h
            int r8 = r9.i
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            b.b.g.e.k$a r2 = r9.p
            r0.d(r2)
            boolean r2 = b.b.g.e.i.w(r10)
            r0.h = r2
            b.b.g.e.i r3 = r0.j
            if (r3 == 0) goto L2a
            r3.q(r2)
        L2a:
            android.widget.PopupWindow$OnDismissListener r2 = r9.m
            r0.k = r2
            r2 = 0
            r9.m = r2
            b.b.g.e.f r2 = r9.d
            r2.c(r1)
            b.b.h.e0 r2 = r9.j
            int r3 = r2.g
            boolean r4 = r2.j
            if (r4 != 0) goto L40
            r2 = 0
            goto L42
        L40:
            int r2 = r2.h
        L42:
            int r4 = r9.u
            android.view.View r5 = r9.n
            int r5 = b.h.j.q.o(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L5a
            android.view.View r4 = r9.n
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L5a:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L62
            goto L6b
        L62:
            android.view.View r4 = r0.f
            if (r4 != 0) goto L68
            r0 = 0
            goto L6c
        L68:
            r0.e(r3, r2, r5, r5)
        L6b:
            r0 = 1
        L6c:
            if (r0 == 0) goto L76
            b.b.g.e.k$a r0 = r9.p
            if (r0 == 0) goto L75
            r0.b(r10)
        L75:
            return r5
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.g.e.o.g(b.b.g.e.p):boolean");
    }

    @Override // b.b.g.e.k
    public boolean h() {
        return false;
    }

    @Override // b.b.g.e.n
    public void i() {
        if (b()) {
            this.j.i();
        }
    }

    @Override // b.b.g.e.k
    public void j(boolean z) {
        this.s = false;
        e eVar = this.e;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // b.b.g.e.i
    public void m(f fVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.d.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            i();
            return true;
        }
        return false;
    }

    @Override // b.b.g.e.i
    public void p(View view) {
        this.n = view;
    }

    @Override // b.b.g.e.i
    public void q(boolean z) {
        this.e.d = z;
    }

    @Override // b.b.g.e.i
    public void r(int i) {
        this.u = i;
    }

    @Override // b.b.g.e.i
    public void s(int i) {
        this.j.g = i;
    }

    @Override // b.b.g.e.i
    public void t(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // b.b.g.e.i
    public void u(boolean z) {
        this.v = z;
    }

    @Override // b.b.g.e.i
    public void v(int i) {
        e0 e0Var = this.j;
        e0Var.h = i;
        e0Var.j = true;
    }
}
