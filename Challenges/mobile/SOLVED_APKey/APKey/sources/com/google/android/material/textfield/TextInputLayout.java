package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.h.i;
import b.b.h.s;
import b.b.h.w;
import b.h.j.q;
import c.c.a.a.u.j;
import c.c.a.a.x.m;
import c.c.a.a.x.n;
import com.example.apkey.R;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public CharSequence A;
    public int A0;
    public boolean B;
    public int B0;
    public c.c.a.a.u.g C;
    public int C0;
    public c.c.a.a.u.g D;
    public boolean D0;
    public j E;
    public final c.c.a.a.q.c E0;
    public final int F;
    public boolean F0;
    public int G;
    public boolean G0;
    public int H;
    public ValueAnimator H0;
    public int I;
    public boolean I0;
    public int J;
    public boolean J0;
    public int K;
    public int L;
    public int M;
    public final Rect N;
    public final Rect O;
    public final RectF P;
    public Typeface Q;
    public final CheckableImageButton R;
    public ColorStateList S;
    public boolean T;
    public PorterDuff.Mode U;
    public boolean V;
    public Drawable W;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f962b;
    public View.OnLongClickListener b0;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f963c;
    public final LinkedHashSet<f> c0;
    public final LinearLayout d;
    public int d0;
    public final FrameLayout e;
    public final SparseArray<m> e0;
    public EditText f;
    public final CheckableImageButton f0;
    public CharSequence g;
    public final LinkedHashSet<g> g0;
    public final n h;
    public ColorStateList h0;
    public boolean i;
    public boolean i0;
    public int j;
    public PorterDuff.Mode j0;
    public boolean k;
    public boolean k0;
    public TextView l;
    public Drawable l0;
    public int m;
    public int m0;
    public int n;
    public Drawable n0;
    public CharSequence o;
    public View.OnLongClickListener o0;
    public boolean p;
    public View.OnLongClickListener p0;
    public TextView q;
    public final CheckableImageButton q0;
    public ColorStateList r;
    public ColorStateList r0;
    public int s;
    public ColorStateList s0;
    public ColorStateList t;
    public ColorStateList t0;
    public ColorStateList u;
    public int u0;
    public CharSequence v;
    public int v0;
    public final TextView w;
    public int w0;
    public CharSequence x;
    public ColorStateList x0;
    public final TextView y;
    public int y0;
    public boolean z;
    public int z0;

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.y(!textInputLayout.J0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.i) {
                textInputLayout2.t(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.p) {
                textInputLayout3.z(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f0.performClick();
            TextInputLayout.this.f0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.E0.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends b.h.j.a {
        public final TextInputLayout d;

        public e(TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x008e, code lost:
            if (r3 != null) goto L52;
         */
        @Override // b.h.j.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void d(android.view.View r14, b.h.j.c0.b r15) {
            /*
                Method dump skipped, instructions count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.e.d(android.view.View, b.h.j.c0.b):void");
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    /* loaded from: classes.dex */
    public static class h extends b.j.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();
        public CharSequence d;
        public boolean e;
        public CharSequence f;
        public CharSequence g;
        public CharSequence h;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new h[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.e = parcel.readInt() != 1 ? false : true;
            this.f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("TextInputLayout.SavedState{");
            g.append(Integer.toHexString(System.identityHashCode(this)));
            g.append(" error=");
            g.append((Object) this.d);
            g.append(" hint=");
            g.append((Object) this.f);
            g.append(" helperText=");
            g.append((Object) this.g);
            g.append(" placeholderText=");
            g.append((Object) this.h);
            g.append("}");
            return g.toString();
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            TextUtils.writeToParcel(this.d, parcel, i);
            parcel.writeInt(this.e ? 1 : 0);
            TextUtils.writeToParcel(this.f, parcel, i);
            TextUtils.writeToParcel(this.g, parcel, i);
            TextUtils.writeToParcel(this.h, parcel, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0570  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0581  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TextInputLayout(android.content.Context r31, android.util.AttributeSet r32) {
        /*
            Method dump skipped, instructions count: 1568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private m getEndIconDelegate() {
        m mVar = this.e0.get(this.d0);
        return mVar != null ? mVar : this.e0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.q0.getVisibility() == 0) {
            return this.q0;
        }
        if (j() && k()) {
            return this.f0;
        }
        return null;
    }

    public static void n(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                n((ViewGroup) childAt, z);
            }
        }
    }

    public static void q(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        AtomicInteger atomicInteger = q.a;
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (hasOnClickListeners || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        q.I(checkableImageButton, i);
    }

    private void setEditText(EditText editText) {
        if (this.f == null) {
            if (this.d0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f = editText;
            l();
            setTextInputAccessibilityDelegate(new e(this));
            this.E0.q(this.f.getTypeface());
            c.c.a.a.q.c cVar = this.E0;
            float textSize = this.f.getTextSize();
            if (cVar.i != textSize) {
                cVar.i = textSize;
                cVar.k();
            }
            int gravity = this.f.getGravity();
            this.E0.n((gravity & (-113)) | 48);
            c.c.a.a.q.c cVar2 = this.E0;
            if (cVar2.g != gravity) {
                cVar2.g = gravity;
                cVar2.k();
            }
            this.f.addTextChangedListener(new a());
            if (this.s0 == null) {
                this.s0 = this.f.getHintTextColors();
            }
            if (this.z) {
                if (TextUtils.isEmpty(this.A)) {
                    CharSequence hint = this.f.getHint();
                    this.g = hint;
                    setHint(hint);
                    this.f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.l != null) {
                t(this.f.getText().length());
            }
            w();
            this.h.b();
            this.f963c.bringToFront();
            this.d.bringToFront();
            this.e.bringToFront();
            this.q0.bringToFront();
            Iterator<f> it = this.c0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            A();
            D();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            y(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.q0.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.e;
        if (z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        D();
        if (!j()) {
            v();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.A)) {
            this.A = charSequence;
            c.c.a.a.q.c cVar = this.E0;
            if (charSequence == null || !TextUtils.equals(cVar.w, charSequence)) {
                cVar.w = charSequence;
                cVar.x = null;
                Bitmap bitmap = cVar.A;
                if (bitmap != null) {
                    bitmap.recycle();
                    cVar.A = null;
                }
                cVar.k();
            }
            if (this.D0) {
                return;
            }
            m();
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.p == z) {
            return;
        }
        if (z) {
            s sVar = new s(getContext(), null);
            this.q = sVar;
            sVar.setId(R.id.textinput_placeholder);
            q.G(this.q, 1);
            setPlaceholderTextAppearance(this.s);
            setPlaceholderTextColor(this.r);
            TextView textView = this.q;
            if (textView != null) {
                this.f962b.addView(textView);
                this.q.setVisibility(0);
            }
        } else {
            TextView textView2 = this.q;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            this.q = null;
        }
        this.p = z;
    }

    public final void A() {
        if (this.f == null) {
            return;
        }
        int i = 0;
        if (!(this.R.getVisibility() == 0)) {
            i = q.q(this.f);
        }
        q.K(this.w, i, this.f.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f.getCompoundPaddingBottom());
    }

    public final void B() {
        this.w.setVisibility((this.v == null || this.D0) ? 8 : 0);
        v();
    }

    public final void C(boolean z, boolean z2) {
        int defaultColor = this.x0.getDefaultColor();
        int colorForState = this.x0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.x0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.L = colorForState2;
        } else if (z2) {
            this.L = colorForState;
        } else {
            this.L = defaultColor;
        }
    }

    public final void D() {
        if (this.f == null) {
            return;
        }
        int i = 0;
        if (!k()) {
            if (!(this.q0.getVisibility() == 0)) {
                i = q.p(this.f);
            }
        }
        q.K(this.y, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f.getPaddingTop(), i, this.f.getPaddingBottom());
    }

    public final void E() {
        int visibility = this.y.getVisibility();
        int i = 0;
        boolean z = this.x != null && !this.D0;
        TextView textView = this.y;
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
        if (visibility != this.y.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        v();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void F() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.F():void");
    }

    public void a(f fVar) {
        this.c0.add(fVar);
        if (this.f != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f962b.addView(view, layoutParams2);
        this.f962b.setLayoutParams(layoutParams);
        x();
        setEditText((EditText) view);
    }

    public void b(float f2) {
        if (this.E0.f846c == f2) {
            return;
        }
        if (this.H0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.H0 = valueAnimator;
            valueAnimator.setInterpolator(c.c.a.a.c.a.f759b);
            this.H0.setDuration(167L);
            this.H0.addUpdateListener(new d());
        }
        this.H0.setFloatValues(this.E0.f846c, f2);
        this.H0.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            r6 = this;
            c.c.a.a.u.g r0 = r6.C
            if (r0 != 0) goto L5
            return
        L5:
            c.c.a.a.u.j r1 = r6.E
            r0.setShapeAppearanceModel(r1)
            int r0 = r6.G
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            if (r0 != r1) goto L21
            int r0 = r6.I
            if (r0 <= r2) goto L1c
            int r0 = r6.L
            if (r0 == 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L21
            r0 = 1
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 == 0) goto L2e
            c.c.a.a.u.g r0 = r6.C
            int r1 = r6.I
            float r1 = (float) r1
            int r5 = r6.L
            r0.r(r1, r5)
        L2e:
            int r0 = r6.M
            int r1 = r6.G
            if (r1 != r4) goto L45
            r0 = 2130903240(0x7f0300c8, float:1.7413292E38)
            android.content.Context r1 = r6.getContext()
            int r0 = c.c.a.a.a.d(r1, r0, r3)
            int r1 = r6.M
            int r0 = b.h.d.a.a(r1, r0)
        L45:
            r6.M = r0
            c.c.a.a.u.g r1 = r6.C
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.p(r0)
            int r0 = r6.d0
            r1 = 3
            if (r0 != r1) goto L5e
            android.widget.EditText r0 = r6.f
            android.graphics.drawable.Drawable r0 = r0.getBackground()
            r0.invalidateSelf()
        L5e:
            c.c.a.a.u.g r0 = r6.D
            if (r0 != 0) goto L63
            goto L7a
        L63:
            int r1 = r6.I
            if (r1 <= r2) goto L6c
            int r1 = r6.L
            if (r1 == 0) goto L6c
            r3 = 1
        L6c:
            if (r3 == 0) goto L77
            int r1 = r6.L
            android.content.res.ColorStateList r1 = android.content.res.ColorStateList.valueOf(r1)
            r0.p(r1)
        L77:
            r6.invalidate()
        L7a:
            r6.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.c():void");
    }

    public final void d() {
        e(this.f0, this.i0, this.h0, this.k0, this.j0);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.g != null) {
            boolean z = this.B;
            this.B = false;
            CharSequence hint = editText.getHint();
            this.f.setHint(this.g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.f.setHint(hint);
                this.B = z;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.f962b.getChildCount());
        for (int i2 = 0; i2 < this.f962b.getChildCount(); i2++) {
            View childAt = this.f962b.getChildAt(i2);
            ViewStructure newChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(newChild, i);
            if (childAt == this.f) {
                newChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.J0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.J0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.z) {
            c.c.a.a.q.c cVar = this.E0;
            cVar.getClass();
            int save = canvas.save();
            if (cVar.x != null && cVar.f845b) {
                boolean z = false;
                cVar.P.getLineLeft(0);
                cVar.G.setTextSize(cVar.D);
                float f2 = cVar.q;
                float f3 = cVar.r;
                if (cVar.z && cVar.A != null) {
                    z = true;
                }
                float f4 = cVar.C;
                if (f4 != 1.0f) {
                    canvas.scale(f4, f4, f2, f3);
                }
                if (z) {
                    canvas.drawBitmap(cVar.A, f2, f3, cVar.B);
                } else {
                    canvas.translate(f2, f3);
                    cVar.P.draw(canvas);
                }
                canvas.restoreToCount(save);
            }
        }
        c.c.a.a.u.g gVar = this.D;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        boolean z;
        ColorStateList colorStateList;
        boolean z2;
        if (this.I0) {
            return;
        }
        boolean z3 = true;
        this.I0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        c.c.a.a.q.c cVar = this.E0;
        if (cVar != null) {
            cVar.E = drawableState;
            ColorStateList colorStateList2 = cVar.l;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.k) != null && colorStateList.isStateful())) {
                cVar.k();
                z2 = true;
            } else {
                z2 = false;
            }
            z = z2 | false;
        } else {
            z = false;
        }
        if (this.f != null) {
            if (!q.u(this) || !isEnabled()) {
                z3 = false;
            }
            y(z3, false);
        }
        w();
        F();
        if (z) {
            invalidate();
        }
        this.I0 = false;
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = b.h.b.a.l0(drawable).mutate();
            if (z) {
                b.h.b.a.g0(drawable, colorStateList);
            }
            if (z2) {
                b.h.b.a.h0(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final int f() {
        float f2;
        if (!this.z) {
            return 0;
        }
        int i = this.G;
        if (i == 0 || i == 1) {
            f2 = this.E0.f();
        } else if (i != 2) {
            return 0;
        } else {
            f2 = this.E0.f() / 2.0f;
        }
        return (int) f2;
    }

    public final boolean g() {
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof c.c.a.a.x.g);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f;
        if (editText != null) {
            return f() + getPaddingTop() + editText.getBaseline();
        }
        return super.getBaseline();
    }

    public c.c.a.a.u.g getBoxBackground() {
        int i = this.G;
        if (i == 1 || i == 2) {
            return this.C;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.M;
    }

    public int getBoxBackgroundMode() {
        return this.G;
    }

    public float getBoxCornerRadiusBottomEnd() {
        c.c.a.a.u.g gVar = this.C;
        return gVar.f876b.a.h.a(gVar.h());
    }

    public float getBoxCornerRadiusBottomStart() {
        c.c.a.a.u.g gVar = this.C;
        return gVar.f876b.a.g.a(gVar.h());
    }

    public float getBoxCornerRadiusTopEnd() {
        c.c.a.a.u.g gVar = this.C;
        return gVar.f876b.a.f.a(gVar.h());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.l();
    }

    public int getBoxStrokeColor() {
        return this.w0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.x0;
    }

    public int getBoxStrokeWidth() {
        return this.J;
    }

    public int getBoxStrokeWidthFocused() {
        return this.K;
    }

    public int getCounterMaxLength() {
        return this.j;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.i || !this.k || (textView = this.l) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.t;
    }

    public ColorStateList getCounterTextColor() {
        return this.t;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.s0;
    }

    public EditText getEditText() {
        return this.f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.d0;
    }

    public CheckableImageButton getEndIconView() {
        return this.f0;
    }

    public CharSequence getError() {
        n nVar = this.h;
        if (nVar.k) {
            return nVar.j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.h.m;
    }

    public int getErrorCurrentTextColors() {
        return this.h.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.q0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.h.g();
    }

    public CharSequence getHelperText() {
        n nVar = this.h;
        if (nVar.q) {
            return nVar.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.h.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.z) {
            return this.A;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.E0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.E0.g();
    }

    public ColorStateList getHintTextColor() {
        return this.t0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.p) {
            return this.o;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.s;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.r;
    }

    public CharSequence getPrefixText() {
        return this.v;
    }

    public ColorStateList getPrefixTextColor() {
        return this.w.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.w;
    }

    public CharSequence getStartIconContentDescription() {
        return this.R.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.R.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.x;
    }

    public ColorStateList getSuffixTextColor() {
        return this.y.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.y;
    }

    public Typeface getTypeface() {
        return this.Q;
    }

    public final int h(int i, boolean z) {
        int compoundPaddingLeft = this.f.getCompoundPaddingLeft() + i;
        return (this.v == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    public final int i(int i, boolean z) {
        int compoundPaddingRight = i - this.f.getCompoundPaddingRight();
        return (this.v == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.w.getMeasuredWidth() - this.w.getPaddingRight());
    }

    public final boolean j() {
        return this.d0 != 0;
    }

    public boolean k() {
        return this.e.getVisibility() == 0 && this.f0.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.l():void");
    }

    public final void m() {
        float f2;
        float b2;
        float f3;
        if (!g()) {
            return;
        }
        RectF rectF = this.P;
        c.c.a.a.q.c cVar = this.E0;
        int width = this.f.getWidth();
        int gravity = this.f.getGravity();
        boolean c2 = cVar.c(cVar.w);
        cVar.y = c2;
        if (gravity == 17 || (gravity & 7) == 1) {
            f2 = width / 2.0f;
            b2 = cVar.b() / 2.0f;
        } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? c2 : !c2) {
            f3 = cVar.e.left;
            rectF.left = f3;
            Rect rect = cVar.e;
            rectF.top = rect.top;
            if (gravity != 17 || (gravity & 7) == 1) {
                float b3 = (width / 2.0f) + (cVar.b() / 2.0f);
            } else {
                b3 = ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !cVar.y : cVar.y) ? rect.right : cVar.b() + f3;
            }
            rectF.right = b3;
            float f4 = cVar.f() + cVar.e.top;
            rectF.bottom = f4;
            float f5 = rectF.left;
            float f6 = this.F;
            rectF.left = f5 - f6;
            rectF.top -= f6;
            rectF.right += f6;
            rectF.bottom = f4 + f6;
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            c.c.a.a.x.g gVar = (c.c.a.a.x.g) this.C;
            gVar.getClass();
            gVar.x(rectF.left, rectF.top, rectF.right, rectF.bottom);
        } else {
            f2 = cVar.e.right;
            b2 = cVar.b();
        }
        f3 = f2 - b2;
        rectF.left = f3;
        Rect rect2 = cVar.e;
        rectF.top = rect2.top;
        if (gravity != 17) {
        }
        float b32 = (width / 2.0f) + (cVar.b() / 2.0f);
        rectF.right = b32;
        float f42 = cVar.f() + cVar.e.top;
        rectF.bottom = f42;
        float f52 = rectF.left;
        float f62 = this.F;
        rectF.left = f52 - f62;
        rectF.top -= f62;
        rectF.right += f62;
        rectF.bottom = f42 + f62;
        rectF.offset(-getPaddingLeft(), -getPaddingTop());
        c.c.a.a.x.g gVar2 = (c.c.a.a.x.g) this.C;
        gVar2.getClass();
        gVar2.x(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void o() {
        p(this.f0, this.h0);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0179  */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        EditText editText;
        int max;
        super.onMeasure(i, i2);
        boolean z = false;
        if (this.f != null && this.f.getMeasuredHeight() < (max = Math.max(this.d.getMeasuredHeight(), this.f963c.getMeasuredHeight()))) {
            this.f.setMinimumHeight(max);
            z = true;
        }
        boolean v = v();
        if (z || v) {
            this.f.post(new c());
        }
        if (this.q != null && (editText = this.f) != null) {
            this.q.setGravity(editText.getGravity());
            this.q.setPadding(this.f.getCompoundPaddingLeft(), this.f.getCompoundPaddingTop(), this.f.getCompoundPaddingRight(), this.f.getCompoundPaddingBottom());
        }
        A();
        D();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f510b);
        setError(hVar.d);
        if (hVar.e) {
            this.f0.post(new b());
        }
        setHint(hVar.f);
        setHelperText(hVar.g);
        setPlaceholderText(hVar.h);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.h.e()) {
            hVar.d = getError();
        }
        hVar.e = j() && this.f0.isChecked();
        hVar.f = getHint();
        hVar.g = getHelperText();
        hVar.h = getPlaceholderText();
        return hVar;
    }

    public final void p(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = b.h.b.a.l0(drawable).mutate();
        b.h.b.a.g0(mutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == (-65281)) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            b.h.b.a.e0(r3, r4)     // Catch: java.lang.Exception -> L1b
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1b
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L1b
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L1b
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L1c
        L18:
            r4 = 0
            r0 = 0
            goto L1c
        L1b:
        L1c:
            if (r0 == 0) goto L32
            r4 = 2131689779(0x7f0f0133, float:1.9008583E38)
            b.h.b.a.e0(r3, r4)
            android.content.Context r4 = r2.getContext()
            r0 = 2131034187(0x7f05004b, float:1.7678884E38)
            int r4 = b.h.c.a.a(r4, r0)
            r3.setTextColor(r4)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.r(android.widget.TextView, int):void");
    }

    public final void s() {
        if (this.l != null) {
            EditText editText = this.f;
            t(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.M != i) {
            this.M = i;
            this.y0 = i;
            this.A0 = i;
            this.B0 = i;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(b.h.c.a.a(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.y0 = defaultColor;
        this.M = defaultColor;
        this.z0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.A0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.B0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.G) {
            return;
        }
        this.G = i;
        if (this.f == null) {
            return;
        }
        l();
    }

    public void setBoxStrokeColor(int i) {
        if (this.w0 != i) {
            this.w0 = i;
            F();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (!colorStateList.isStateful()) {
            if (this.w0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            F();
        }
        this.u0 = colorStateList.getDefaultColor();
        this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.v0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.w0 = defaultColor;
        F();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            F();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.J = i;
        F();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.K = i;
        F();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.i != z) {
            if (z) {
                s sVar = new s(getContext(), null);
                this.l = sVar;
                sVar.setId(R.id.textinput_counter);
                Typeface typeface = this.Q;
                if (typeface != null) {
                    this.l.setTypeface(typeface);
                }
                this.l.setMaxLines(1);
                this.h.a(this.l, 2);
                b.h.b.a.b0((ViewGroup.MarginLayoutParams) this.l.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                u();
                s();
            } else {
                this.h.j(this.l, 2);
                this.l = null;
            }
            this.i = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.j != i) {
            if (i <= 0) {
                i = -1;
            }
            this.j = i;
            if (!this.i) {
                return;
            }
            s();
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.m != i) {
            this.m = i;
            u();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            u();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.n != i) {
            this.n = i;
            u();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            u();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.s0 = colorStateList;
        this.t0 = colorStateList;
        if (this.f != null) {
            y(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        n(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.f0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.f0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? b.b.d.a.a.b(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
        o();
    }

    public void setEndIconMode(int i) {
        int i2 = this.d0;
        this.d0 = i;
        Iterator<g> it = this.g0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2);
        }
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().b(this.G)) {
            getEndIconDelegate().a();
            d();
            return;
        }
        StringBuilder g2 = c.a.a.a.a.g("The current box background mode ");
        g2.append(this.G);
        g2.append(" is not supported by the end icon mode ");
        g2.append(i);
        throw new IllegalStateException(g2.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.f0;
        View.OnLongClickListener onLongClickListener = this.o0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.o0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.h0 != colorStateList) {
            this.h0 = colorStateList;
            this.i0 = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.j0 != mode) {
            this.j0 = mode;
            this.k0 = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (k() != z) {
            this.f0.setVisibility(z ? 0 : 8);
            D();
            v();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.h.k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            setErrorEnabled(true);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            n nVar = this.h;
            nVar.c();
            nVar.j = charSequence;
            nVar.l.setText(charSequence);
            int i = nVar.h;
            if (i != 1) {
                nVar.i = 1;
            }
            nVar.l(i, nVar.i, nVar.k(nVar.l, charSequence));
            return;
        }
        this.h.i();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.h;
        nVar.m = charSequence;
        TextView textView = nVar.l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        n nVar = this.h;
        if (nVar.k == z) {
            return;
        }
        nVar.c();
        if (z) {
            s sVar = new s(nVar.a, null);
            nVar.l = sVar;
            sVar.setId(R.id.textinput_error);
            if (Build.VERSION.SDK_INT >= 17) {
                nVar.l.setTextAlignment(5);
            }
            Typeface typeface = nVar.u;
            if (typeface != null) {
                nVar.l.setTypeface(typeface);
            }
            int i = nVar.n;
            nVar.n = i;
            TextView textView = nVar.l;
            if (textView != null) {
                nVar.f915b.r(textView, i);
            }
            ColorStateList colorStateList = nVar.o;
            nVar.o = colorStateList;
            TextView textView2 = nVar.l;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            CharSequence charSequence = nVar.m;
            nVar.m = charSequence;
            TextView textView3 = nVar.l;
            if (textView3 != null) {
                textView3.setContentDescription(charSequence);
            }
            nVar.l.setVisibility(4);
            q.G(nVar.l, 1);
            nVar.a(nVar.l, 0);
        } else {
            nVar.i();
            nVar.j(nVar.l, 0);
            nVar.l = null;
            nVar.f915b.w();
            nVar.f915b.F();
        }
        nVar.k = z;
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? b.b.d.a.a.b(getContext(), i) : null);
        p(this.q0, this.r0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.q0;
        View.OnLongClickListener onLongClickListener = this.p0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.p0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.q0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.r0 = colorStateList;
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = b.h.b.a.l0(drawable).mutate();
            b.h.b.a.g0(drawable, colorStateList);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = b.h.b.a.l0(drawable).mutate();
            b.h.b.a.h0(drawable, mode);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        n nVar = this.h;
        nVar.n = i;
        TextView textView = nVar.l;
        if (textView != null) {
            nVar.f915b.r(textView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.h;
        nVar.o = colorStateList;
        TextView textView = nVar.l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.F0 != z) {
            this.F0 = z;
            y(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (!this.h.q) {
                return;
            }
            setHelperTextEnabled(false);
            return;
        }
        if (!this.h.q) {
            setHelperTextEnabled(true);
        }
        n nVar = this.h;
        nVar.c();
        nVar.p = charSequence;
        nVar.r.setText(charSequence);
        int i = nVar.h;
        if (i != 2) {
            nVar.i = 2;
        }
        nVar.l(i, nVar.i, nVar.k(nVar.r, charSequence));
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.h;
        nVar.t = colorStateList;
        TextView textView = nVar.r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        n nVar = this.h;
        if (nVar.q == z) {
            return;
        }
        nVar.c();
        if (z) {
            s sVar = new s(nVar.a, null);
            nVar.r = sVar;
            sVar.setId(R.id.textinput_helper_text);
            if (Build.VERSION.SDK_INT >= 17) {
                nVar.r.setTextAlignment(5);
            }
            Typeface typeface = nVar.u;
            if (typeface != null) {
                nVar.r.setTypeface(typeface);
            }
            nVar.r.setVisibility(4);
            q.G(nVar.r, 1);
            int i = nVar.s;
            nVar.s = i;
            TextView textView = nVar.r;
            if (textView != null) {
                b.h.b.a.e0(textView, i);
            }
            ColorStateList colorStateList = nVar.t;
            nVar.t = colorStateList;
            TextView textView2 = nVar.r;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            nVar.a(nVar.r, 1);
        } else {
            nVar.c();
            int i2 = nVar.h;
            if (i2 == 2) {
                nVar.i = 0;
            }
            nVar.l(i2, nVar.i, nVar.k(nVar.r, null));
            nVar.j(nVar.r, 1);
            nVar.r = null;
            nVar.f915b.w();
            nVar.f915b.F();
        }
        nVar.q = z;
    }

    public void setHelperTextTextAppearance(int i) {
        n nVar = this.h;
        nVar.s = i;
        TextView textView = nVar.r;
        if (textView != null) {
            b.h.b.a.e0(textView, i);
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    public void setHint(CharSequence charSequence) {
        if (this.z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.G0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.z) {
            this.z = z;
            if (!z) {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f.getHint())) {
                    this.f.setHint(this.A);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.f == null) {
                return;
            }
            x();
        }
    }

    public void setHintTextAppearance(int i) {
        c.c.a.a.q.c cVar = this.E0;
        c.c.a.a.r.b bVar = new c.c.a.a.r.b(cVar.a.getContext(), i);
        ColorStateList colorStateList = bVar.a;
        if (colorStateList != null) {
            cVar.l = colorStateList;
        }
        float f2 = bVar.k;
        if (f2 != 0.0f) {
            cVar.j = f2;
        }
        ColorStateList colorStateList2 = bVar.f864b;
        if (colorStateList2 != null) {
            cVar.N = colorStateList2;
        }
        cVar.L = bVar.f;
        cVar.M = bVar.g;
        cVar.K = bVar.h;
        cVar.O = bVar.j;
        c.c.a.a.r.a aVar = cVar.v;
        if (aVar != null) {
            aVar.f863c = true;
        }
        c.c.a.a.q.b bVar2 = new c.c.a.a.q.b(cVar);
        bVar.a();
        cVar.v = new c.c.a.a.r.a(bVar2, bVar.n);
        bVar.b(cVar.a.getContext(), cVar.v);
        cVar.k();
        this.t0 = this.E0.l;
        if (this.f != null) {
            y(false, false);
            x();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            if (this.s0 == null) {
                c.c.a.a.q.c cVar = this.E0;
                if (cVar.l != colorStateList) {
                    cVar.l = colorStateList;
                    cVar.k();
                }
            }
            this.t0 = colorStateList;
            if (this.f == null) {
                return;
            }
            y(false, false);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? b.b.d.a.a.b(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.d0 != 1) {
            setEndIconMode(1);
        } else if (z) {
        } else {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.h0 = colorStateList;
        this.i0 = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.j0 = mode;
        this.k0 = true;
        d();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        int i = 0;
        if (!this.p || !TextUtils.isEmpty(charSequence)) {
            if (!this.p) {
                setPlaceholderTextEnabled(true);
            }
            this.o = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText = this.f;
        if (editText != null) {
            i = editText.getText().length();
        }
        z(i);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.s = i;
        TextView textView = this.q;
        if (textView != null) {
            b.h.b.a.e0(textView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            TextView textView = this.q;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.w.setText(charSequence);
        B();
    }

    public void setPrefixTextAppearance(int i) {
        b.h.b.a.e0(this.w, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.w.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.R.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.R.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? b.b.d.a.a.b(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.R.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            p(this.R, this.S);
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.R;
        View.OnLongClickListener onLongClickListener = this.b0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.R;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            e(this.R, true, colorStateList, this.V, this.U);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            e(this.R, this.T, this.S, true, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        int i = 0;
        if ((this.R.getVisibility() == 0) != z) {
            CheckableImageButton checkableImageButton = this.R;
            if (!z) {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            A();
            v();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        E();
    }

    public void setSuffixTextAppearance(int i) {
        b.h.b.a.e0(this.y, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f;
        if (editText != null) {
            q.F(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.E0.q(typeface);
            n nVar = this.h;
            if (typeface != nVar.u) {
                nVar.u = typeface;
                TextView textView = nVar.l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.l;
            if (textView3 == null) {
                return;
            }
            textView3.setTypeface(typeface);
        }
    }

    public void t(int i) {
        boolean z = this.k;
        int i2 = this.j;
        String str = null;
        if (i2 == -1) {
            this.l.setText(String.valueOf(i));
            this.l.setContentDescription(null);
            this.k = false;
        } else {
            this.k = i > i2;
            Context context = getContext();
            this.l.setContentDescription(context.getString(this.k ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.j)));
            if (z != this.k) {
                u();
            }
            b.h.h.a c2 = b.h.h.a.c();
            TextView textView = this.l;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.j));
            b.h.h.d dVar = c2.f449c;
            if (string != null) {
                str = c2.d(string, dVar, true).toString();
            }
            textView.setText(str);
        }
        if (this.f == null || z == this.k) {
            return;
        }
        y(false, false);
        F();
        w();
    }

    public final void u() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.l;
        if (textView != null) {
            r(textView, this.k ? this.m : this.n);
            if (!this.k && (colorStateList2 = this.t) != null) {
                this.l.setTextColor(colorStateList2);
            }
            if (!this.k || (colorStateList = this.u) == null) {
                return;
            }
            this.l.setTextColor(colorStateList);
        }
    }

    public final boolean v() {
        boolean z;
        if (this.f == null) {
            return false;
        }
        boolean z2 = true;
        if (!(getStartIconDrawable() == null && this.v == null) && this.f963c.getMeasuredWidth() > 0) {
            int measuredWidth = this.f963c.getMeasuredWidth() - this.f.getPaddingLeft();
            if (this.W == null || this.a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.W = colorDrawable;
                this.a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] z3 = b.h.b.a.z(this.f);
            Drawable drawable = z3[0];
            Drawable drawable2 = this.W;
            if (drawable != drawable2) {
                b.h.b.a.S(this.f, drawable2, z3[1], z3[2], z3[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.W != null) {
                Drawable[] z4 = b.h.b.a.z(this.f);
                b.h.b.a.S(this.f, null, z4[1], z4[2], z4[3]);
                this.W = null;
                z = true;
            }
            z = false;
        }
        if ((this.q0.getVisibility() == 0 || ((j() && k()) || this.x != null)) && this.d.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.y.getMeasuredWidth() - this.f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = b.h.b.a.B((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()) + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] z5 = b.h.b.a.z(this.f);
            Drawable drawable3 = this.l0;
            if (drawable3 == null || this.m0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.l0 = colorDrawable2;
                    this.m0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = z5[2];
                Drawable drawable5 = this.l0;
                if (drawable4 != drawable5) {
                    this.n0 = z5[2];
                    b.h.b.a.S(this.f, z5[0], z5[1], drawable5, z5[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.m0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                b.h.b.a.S(this.f, z5[0], z5[1], this.l0, z5[3]);
            }
        } else if (this.l0 == null) {
            return z;
        } else {
            Drawable[] z6 = b.h.b.a.z(this.f);
            if (z6[2] == this.l0) {
                b.h.b.a.S(this.f, z6[0], z6[1], this.n0, z6[3]);
            } else {
                z2 = z;
            }
            this.l0 = null;
        }
        return z2;
    }

    public void w() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f;
        if (editText == null || this.G != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (w.a(background)) {
            background = background.mutate();
        }
        if (this.h.e()) {
            currentTextColor = this.h.g();
        } else if (!this.k || (textView = this.l) == null) {
            b.h.b.a.j(background);
            this.f.refreshDrawableState();
            return;
        } else {
            currentTextColor = textView.getCurrentTextColor();
        }
        background.setColorFilter(i.c(currentTextColor, PorterDuff.Mode.SRC_IN));
    }

    public final void x() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f962b.getLayoutParams();
            int f2 = f();
            if (f2 == layoutParams.topMargin) {
                return;
            }
            layoutParams.topMargin = f2;
            this.f962b.requestLayout();
        }
    }

    public final void y(boolean z, boolean z2) {
        ColorStateList colorStateList;
        c.c.a.a.q.c cVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f;
        int i = 0;
        boolean z3 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.h.e();
        ColorStateList colorStateList2 = this.s0;
        if (colorStateList2 != null) {
            c.c.a.a.q.c cVar2 = this.E0;
            if (cVar2.l != colorStateList2) {
                cVar2.l = colorStateList2;
                cVar2.k();
            }
            c.c.a.a.q.c cVar3 = this.E0;
            ColorStateList colorStateList3 = this.s0;
            if (cVar3.k != colorStateList3) {
                cVar3.k = colorStateList3;
                cVar3.k();
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.s0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.C0) : this.C0;
            this.E0.m(ColorStateList.valueOf(colorForState));
            c.c.a.a.q.c cVar4 = this.E0;
            ColorStateList valueOf = ColorStateList.valueOf(colorForState);
            if (cVar4.k != valueOf) {
                cVar4.k = valueOf;
                cVar4.k();
            }
        } else if (e2) {
            c.c.a.a.q.c cVar5 = this.E0;
            TextView textView2 = this.h.l;
            cVar5.m(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.k && (textView = this.l) != null) {
                cVar = this.E0;
                colorStateList = textView.getTextColors();
            } else if (z4 && (colorStateList = this.t0) != null) {
                cVar = this.E0;
            }
            cVar.m(colorStateList);
        }
        if (z3 || !this.F0 || (isEnabled() && z4)) {
            if (!z2 && !this.D0) {
                return;
            }
            ValueAnimator valueAnimator = this.H0;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.H0.cancel();
            }
            if (!z || !this.G0) {
                this.E0.o(1.0f);
            } else {
                b(1.0f);
            }
            this.D0 = false;
            if (g()) {
                m();
            }
            EditText editText3 = this.f;
            if (editText3 != null) {
                i = editText3.getText().length();
            }
            z(i);
            B();
            E();
        } else if (!z2 && this.D0) {
        } else {
            ValueAnimator valueAnimator2 = this.H0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.H0.cancel();
            }
            if (!z || !this.G0) {
                this.E0.o(0.0f);
            } else {
                b(0.0f);
            }
            if (g() && (!((c.c.a.a.x.g) this.C).A.isEmpty()) && g()) {
                ((c.c.a.a.x.g) this.C).x(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.D0 = true;
            TextView textView3 = this.q;
            if (textView3 != null && this.p) {
                textView3.setText((CharSequence) null);
                this.q.setVisibility(4);
            }
            B();
            E();
        }
    }

    public final void z(int i) {
        if (i == 0 && !this.D0) {
            TextView textView = this.q;
            if (textView == null || !this.p) {
                return;
            }
            textView.setText(this.o);
            this.q.setVisibility(0);
            this.q.bringToFront();
            return;
        }
        TextView textView2 = this.q;
        if (textView2 == null || !this.p) {
            return;
        }
        textView2.setText((CharSequence) null);
        this.q.setVisibility(4);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.q0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.h.k);
    }
}
