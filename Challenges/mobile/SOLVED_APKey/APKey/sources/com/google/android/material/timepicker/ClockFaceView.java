package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import b.h.j.a;
import b.h.j.c0.b;
import b.h.j.q;
import c.c.a.a.b;
import c.c.a.a.z.c;
import com.example.apkey.R;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ClockFaceView extends c implements ClockHandView.c {
    public final SparseArray<TextView> A;
    public final a B;
    public final int[] C;
    public final float[] D;
    public final int E;
    public String[] F;
    public float G;
    public final ColorStateList H;
    public final ClockHandView x;
    public final Rect y;
    public final RectF z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        this.y = new Rect();
        this.z = new RectF();
        SparseArray<TextView> sparseArray = new SparseArray<>();
        this.A = sparseArray;
        this.D = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.e, R.attr.materialClockStyle, 2131690177);
        Resources resources = getResources();
        ColorStateList f = c.c.a.a.a.f(context, obtainStyledAttributes, 1);
        this.H = f;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.x = clockHandView;
        this.E = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = f.getColorForState(new int[]{16842913}, f.getDefaultColor());
        this.C = new int[]{colorForState, colorForState, f.getDefaultColor()};
        clockHandView.g.add(this);
        int defaultColor = b.b.d.a.a.a(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList f2 = c.c.a.a.a.f(context, obtainStyledAttributes, 0);
        setBackgroundColor(f2 != null ? f2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new c.c.a.a.z.a(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.B = new c.c.a.a.z.b(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.F = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int i = 0; i < Math.max(this.F.length, size); i++) {
            TextView textView = this.A.get(i);
            if (i >= this.F.length) {
                removeView(textView);
                this.A.remove(i);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.A.put(i, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.F[i]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i));
                q.F(textView, this.B);
                textView.setTextColor(this.H);
            }
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f, boolean z) {
        if (Math.abs(this.G - f) > 0.001f) {
            this.G = f;
            l();
        }
    }

    public final void l() {
        RectF rectF = this.x.k;
        for (int i = 0; i < this.A.size(); i++) {
            TextView textView = this.A.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.y);
                this.y.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.y);
                this.z.set(this.y);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.z) ? null : new RadialGradient(rectF.centerX() - this.z.left, rectF.centerY() - this.z.top, 0.5f * rectF.width(), this.C, this.D, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        b.C0019b a = b.C0019b.a(1, this.F.length, false, 1);
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) a.a);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        l();
    }
}
