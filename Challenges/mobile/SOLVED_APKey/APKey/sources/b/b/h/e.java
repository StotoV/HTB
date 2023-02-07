package b.b.h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class e {
    public final View a;
    public m0 d;
    public m0 e;
    public m0 f;

    /* renamed from: c  reason: collision with root package name */
    public int f215c = -1;

    /* renamed from: b  reason: collision with root package name */
    public final i f214b = i.a();

    public e(View view) {
        this.a = view;
    }

    public void a() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i <= 21 ? i == 21 : this.d != null) {
                if (this.f == null) {
                    this.f = new m0();
                }
                m0 m0Var = this.f;
                PorterDuff.Mode mode = null;
                m0Var.a = null;
                m0Var.d = false;
                m0Var.f248b = null;
                m0Var.f249c = false;
                ColorStateList l = b.h.j.q.l(this.a);
                if (l != null) {
                    m0Var.d = true;
                    m0Var.a = l;
                }
                View view = this.a;
                if (i >= 21) {
                    mode = view.getBackgroundTintMode();
                } else if (view instanceof b.h.j.p) {
                    mode = ((b.h.j.p) view).getSupportBackgroundTintMode();
                }
                if (mode != null) {
                    m0Var.f249c = true;
                    m0Var.f248b = mode;
                }
                if (m0Var.d || m0Var.f249c) {
                    i.f(background, m0Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            m0 m0Var2 = this.e;
            if (m0Var2 != null) {
                i.f(background, m0Var2, this.a.getDrawableState());
                return;
            }
            m0 m0Var3 = this.d;
            if (m0Var3 == null) {
                return;
            }
            i.f(background, m0Var3, this.a.getDrawableState());
        }
    }

    public ColorStateList b() {
        m0 m0Var = this.e;
        if (m0Var != null) {
            return m0Var.a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        m0 m0Var = this.e;
        if (m0Var != null) {
            return m0Var.f248b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0071 A[Catch: all -> 0x0079, TryCatch #0 {all -> 0x0079, blocks: (B:3:0x001b, B:5:0x0022, B:7:0x0038, B:8:0x003b, B:10:0x0044, B:12:0x004e, B:14:0x0053, B:16:0x005d, B:23:0x006b, B:25:0x0071, B:28:0x007b, B:29:0x007f, B:31:0x0083, B:32:0x0088, B:34:0x008f, B:36:0x009e, B:38:0x00a3, B:40:0x00ad, B:45:0x00b8, B:47:0x00be, B:48:0x00c5, B:49:0x00c9, B:51:0x00cd), top: B:56:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.view.View r0 = r9.a
            android.content.Context r0 = r0.getContext()
            int[] r3 = b.b.b.y
            r8 = 0
            b.b.h.o0 r0 = b.b.h.o0.p(r0, r10, r3, r11, r8)
            android.view.View r1 = r9.a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.f252b
            r7 = 0
            r4 = r10
            r6 = r11
            b.h.j.q.E(r1, r2, r3, r4, r5, r6, r7)
            boolean r10 = r0.n(r8)     // Catch: java.lang.Throwable -> L79
            r11 = -1
            if (r10 == 0) goto L3b
            int r10 = r0.k(r8, r11)     // Catch: java.lang.Throwable -> L79
            r9.f215c = r10     // Catch: java.lang.Throwable -> L79
            b.b.h.i r10 = r9.f214b     // Catch: java.lang.Throwable -> L79
            android.view.View r1 = r9.a     // Catch: java.lang.Throwable -> L79
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L79
            int r2 = r9.f215c     // Catch: java.lang.Throwable -> L79
            android.content.res.ColorStateList r10 = r10.d(r1, r2)     // Catch: java.lang.Throwable -> L79
            if (r10 == 0) goto L3b
            r9.g(r10)     // Catch: java.lang.Throwable -> L79
        L3b:
            r10 = 1
            boolean r1 = r0.n(r10)     // Catch: java.lang.Throwable -> L79
            r2 = 21
            if (r1 == 0) goto L88
            android.view.View r1 = r9.a     // Catch: java.lang.Throwable -> L79
            android.content.res.ColorStateList r3 = r0.c(r10)     // Catch: java.lang.Throwable -> L79
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L79
            if (r4 < r2) goto L7f
            r1.setBackgroundTintList(r3)     // Catch: java.lang.Throwable -> L79
            if (r4 != r2) goto L88
            android.graphics.drawable.Drawable r3 = r1.getBackground()     // Catch: java.lang.Throwable -> L79
            android.content.res.ColorStateList r4 = r1.getBackgroundTintList()     // Catch: java.lang.Throwable -> L79
            if (r4 != 0) goto L66
            android.graphics.PorterDuff$Mode r4 = r1.getBackgroundTintMode()     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L64
            goto L66
        L64:
            r4 = 0
            goto L67
        L66:
            r4 = 1
        L67:
            if (r3 == 0) goto L88
            if (r4 == 0) goto L88
            boolean r4 = r3.isStateful()     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L7b
            int[] r4 = r1.getDrawableState()     // Catch: java.lang.Throwable -> L79
            r3.setState(r4)     // Catch: java.lang.Throwable -> L79
            goto L7b
        L79:
            r10 = move-exception
            goto Ld8
        L7b:
            r1.setBackground(r3)     // Catch: java.lang.Throwable -> L79
            goto L88
        L7f:
            boolean r4 = r1 instanceof b.h.j.p     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L88
            b.h.j.p r1 = (b.h.j.p) r1     // Catch: java.lang.Throwable -> L79
            r1.setSupportBackgroundTintList(r3)     // Catch: java.lang.Throwable -> L79
        L88:
            r1 = 2
            boolean r3 = r0.n(r1)     // Catch: java.lang.Throwable -> L79
            if (r3 == 0) goto Ld2
            android.view.View r3 = r9.a     // Catch: java.lang.Throwable -> L79
            int r11 = r0.i(r1, r11)     // Catch: java.lang.Throwable -> L79
            r1 = 0
            android.graphics.PorterDuff$Mode r11 = b.b.h.w.c(r11, r1)     // Catch: java.lang.Throwable -> L79
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L79
            if (r1 < r2) goto Lc9
            r3.setBackgroundTintMode(r11)     // Catch: java.lang.Throwable -> L79
            if (r1 != r2) goto Ld2
            android.graphics.drawable.Drawable r11 = r3.getBackground()     // Catch: java.lang.Throwable -> L79
            android.content.res.ColorStateList r1 = r3.getBackgroundTintList()     // Catch: java.lang.Throwable -> L79
            if (r1 != 0) goto Lb3
            android.graphics.PorterDuff$Mode r1 = r3.getBackgroundTintMode()     // Catch: java.lang.Throwable -> L79
            if (r1 == 0) goto Lb4
        Lb3:
            r8 = 1
        Lb4:
            if (r11 == 0) goto Ld2
            if (r8 == 0) goto Ld2
            boolean r10 = r11.isStateful()     // Catch: java.lang.Throwable -> L79
            if (r10 == 0) goto Lc5
            int[] r10 = r3.getDrawableState()     // Catch: java.lang.Throwable -> L79
            r11.setState(r10)     // Catch: java.lang.Throwable -> L79
        Lc5:
            r3.setBackground(r11)     // Catch: java.lang.Throwable -> L79
            goto Ld2
        Lc9:
            boolean r10 = r3 instanceof b.h.j.p     // Catch: java.lang.Throwable -> L79
            if (r10 == 0) goto Ld2
            b.h.j.p r3 = (b.h.j.p) r3     // Catch: java.lang.Throwable -> L79
            r3.setSupportBackgroundTintMode(r11)     // Catch: java.lang.Throwable -> L79
        Ld2:
            android.content.res.TypedArray r10 = r0.f252b
            r10.recycle()
            return
        Ld8:
            android.content.res.TypedArray r11 = r0.f252b
            r11.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.e.d(android.util.AttributeSet, int):void");
    }

    public void e() {
        this.f215c = -1;
        g(null);
        a();
    }

    public void f(int i) {
        this.f215c = i;
        i iVar = this.f214b;
        g(iVar != null ? iVar.d(this.a.getContext(), i) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new m0();
            }
            m0 m0Var = this.d;
            m0Var.a = colorStateList;
            m0Var.d = true;
        } else {
            this.d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new m0();
        }
        m0 m0Var = this.e;
        m0Var.a = colorStateList;
        m0Var.d = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new m0();
        }
        m0 m0Var = this.e;
        m0Var.f248b = mode;
        m0Var.f249c = true;
        a();
    }
}
