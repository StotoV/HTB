package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.h.j.q;
import c.c.a.a.b;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f960b;

    /* renamed from: c  reason: collision with root package name */
    public Button f961c;
    public int d;
    public int e;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.y);
        this.d = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.e = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
    }

    public final boolean a(int i, int i2, int i3) {
        boolean z;
        boolean z2 = false;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f960b.getPaddingTop() == i2 && this.f960b.getPaddingBottom() == i3) {
            return z;
        }
        TextView textView = this.f960b;
        AtomicInteger atomicInteger = q.a;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 17) {
            z2 = textView.isPaddingRelative();
        }
        if (z2) {
            int q = q.q(textView);
            int p = q.p(textView);
            if (i4 >= 17) {
                textView.setPaddingRelative(q, i2, p, i3);
                return true;
            }
            textView.setPadding(q, i2, p, i3);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), i3);
        return true;
    }

    public Button getActionView() {
        return this.f961c;
    }

    public TextView getMessageView() {
        return this.f960b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f960b = (TextView) findViewById(R.id.snackbar_text);
        this.f961c = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (a(1, r0, r0 - r1) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (a(0, r0, r0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.d
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.d
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            r1 = 2131099783(0x7f060087, float:1.7811929E38)
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            r2 = 2131099782(0x7f060086, float:1.7811927E38)
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f960b
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3e
            r2 = 1
            goto L3f
        L3e:
            r2 = 0
        L3f:
            if (r2 == 0) goto L58
            int r5 = r7.e
            if (r5 <= 0) goto L58
            android.widget.Button r5 = r7.f961c
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.e
            if (r5 <= r6) goto L58
            int r1 = r0 - r1
            boolean r0 = r7.a(r4, r0, r1)
            if (r0 == 0) goto L63
            goto L62
        L58:
            if (r2 == 0) goto L5b
            goto L5c
        L5b:
            r0 = r1
        L5c:
            boolean r0 = r7.a(r3, r0, r0)
            if (r0 == 0) goto L63
        L62:
            r3 = 1
        L63:
            if (r3 == 0) goto L68
            super.onMeasure(r8, r9)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i) {
        this.e = i;
    }
}
