package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.f.b.h.a;
import b.f.c.b;
import b.f.c.i;
/* loaded from: classes.dex */
public class Barrier extends b {
    public int i;
    public int j;
    public a k;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    @Override // b.f.c.b
    public void f(AttributeSet attributeSet) {
        super.f(attributeSet);
        this.k = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f389b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 15) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.k.o0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.k.p0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.e = this.k;
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r0 == 6) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
        if (r0 == 6) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 == 6) goto L11;
     */
    @Override // b.f.c.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(b.f.b.h.d r6, boolean r7) {
        /*
            r5 = this;
            int r0 = r5.i
            r5.j = r0
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 6
            r3 = 5
            r4 = 17
            if (r1 >= r4) goto L12
            if (r0 != r3) goto Lf
            goto L1c
        Lf:
            if (r0 != r2) goto L24
            goto L22
        L12:
            if (r7 == 0) goto L1a
            if (r0 != r3) goto L17
            goto L22
        L17:
            if (r0 != r2) goto L24
            goto L1c
        L1a:
            if (r0 != r3) goto L20
        L1c:
            r7 = 0
        L1d:
            r5.j = r7
            goto L24
        L20:
            if (r0 != r2) goto L24
        L22:
            r7 = 1
            goto L1d
        L24:
            boolean r7 = r6 instanceof b.f.b.h.a
            if (r7 == 0) goto L2e
            b.f.b.h.a r6 = (b.f.b.h.a) r6
            int r7 = r5.j
            r6.n0 = r7
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.g(b.f.b.h.d, boolean):void");
    }

    public int getMargin() {
        return this.k.p0;
    }

    public int getType() {
        return this.i;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.k.o0 = z;
    }

    public void setDpMargin(int i) {
        this.k.p0 = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.k.p0 = i;
    }

    public void setType(int i) {
        this.i = i;
    }
}
