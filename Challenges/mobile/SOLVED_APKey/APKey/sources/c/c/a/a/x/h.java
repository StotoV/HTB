package c.c.a.a.x;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import b.h.j.q;
import c.c.a.a.u.g;
import c.c.a.a.u.j;
import com.example.apkey.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class h extends m {
    public static final boolean q;
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.e f;
    public final TextInputLayout.f g;
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g h;
    public boolean i;
    public boolean j;
    public long k;
    public StateListDrawable l;
    public c.c.a.a.u.g m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* loaded from: classes.dex */
    public class a extends c.c.a.a.q.j {

        /* renamed from: c.c.a.a.x.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0044a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f906b;

            public RunnableC0044a(AutoCompleteTextView autoCompleteTextView) {
                this.f906b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.f906b.isPopupShowing();
                h.g(h.this, isPopupShowing);
                h.this.i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // c.c.a.a.q.j, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e = h.e(h.this.a.getEditText());
            if (h.this.n.isTouchExplorationEnabled() && h.f(e) && !h.this.f914c.hasFocus()) {
                e.dismissDropDown();
            }
            e.post(new RunnableC0044a(e));
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            h.this.a.setEndIconActivated(z);
            if (!z) {
                h.g(h.this, false);
                h.this.i = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends TextInputLayout.e {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, b.h.j.a
        public void d(View view, b.h.j.c0.b bVar) {
            boolean z;
            super.d(view, bVar);
            if (!h.f(h.this.a.getEditText())) {
                bVar.a.setClassName(Spinner.class.getName());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                z = bVar.a.isShowingHintText();
            } else {
                Bundle f = bVar.f();
                z = f != null && (f.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                bVar.k(null);
            }
        }

        @Override // b.h.j.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView e = h.e(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() != 1 || !h.this.n.isTouchExplorationEnabled() || h.f(h.this.a.getEditText())) {
                return;
            }
            h.h(h.this, e);
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextInputLayout.f {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            LayerDrawable layerDrawable;
            Drawable drawable;
            AutoCompleteTextView e = h.e(textInputLayout.getEditText());
            h hVar = h.this;
            hVar.getClass();
            boolean z = h.q;
            if (z) {
                int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
                if (boxBackgroundMode == 2) {
                    drawable = hVar.m;
                } else if (boxBackgroundMode == 1) {
                    drawable = hVar.l;
                }
                e.setDropDownBackgroundDrawable(drawable);
            }
            h hVar2 = h.this;
            hVar2.getClass();
            boolean z2 = false;
            if (!(e.getKeyListener() != null)) {
                int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                c.c.a.a.u.g boxBackground = hVar2.a.getBoxBackground();
                int e2 = c.c.a.a.a.e(e, R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{16842919}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int e3 = c.c.a.a.a.e(e, R.attr.colorSurface);
                    c.c.a.a.u.g gVar = new c.c.a.a.u.g(boxBackground.f876b.a);
                    int l = c.c.a.a.a.l(e2, e3, 0.1f);
                    gVar.p(new ColorStateList(iArr, new int[]{l, 0}));
                    if (z) {
                        gVar.setTint(e3);
                        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{l, e3});
                        c.c.a.a.u.g gVar2 = new c.c.a.a.u.g(boxBackground.f876b.a);
                        gVar2.setTint(-1);
                        layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar, gVar2), boxBackground});
                    } else {
                        layerDrawable = new LayerDrawable(new Drawable[]{gVar, boxBackground});
                    }
                    AtomicInteger atomicInteger = q.a;
                    e.setBackground(layerDrawable);
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                    int[] iArr2 = {c.c.a.a.a.l(e2, boxBackgroundColor, 0.1f), boxBackgroundColor};
                    if (z) {
                        RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, iArr2), boxBackground, boxBackground);
                        AtomicInteger atomicInteger2 = q.a;
                        e.setBackground(rippleDrawable);
                    } else {
                        c.c.a.a.u.g gVar3 = new c.c.a.a.u.g(boxBackground.f876b.a);
                        gVar3.p(new ColorStateList(iArr, iArr2));
                        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{boxBackground, gVar3});
                        int q = q.q(e);
                        int paddingTop = e.getPaddingTop();
                        int p = q.p(e);
                        int paddingBottom = e.getPaddingBottom();
                        e.setBackground(layerDrawable2);
                        if (Build.VERSION.SDK_INT >= 17) {
                            e.setPaddingRelative(q, paddingTop, p, paddingBottom);
                        } else {
                            e.setPadding(q, paddingTop, p, paddingBottom);
                        }
                    }
                }
            }
            h hVar3 = h.this;
            hVar3.getClass();
            e.setOnTouchListener(new j(hVar3, e));
            e.setOnFocusChangeListener(hVar3.e);
            if (z) {
                e.setOnDismissListener(new k(hVar3));
            }
            e.setThreshold(0);
            e.removeTextChangedListener(h.this.d);
            e.addTextChangedListener(h.this.d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (e.getKeyListener() != null) {
                z2 = true;
            }
            if (!z2) {
                q.I(h.this.f914c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes.dex */
    public class e implements TextInputLayout.g {

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AutoCompleteTextView f908b;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f908b = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f908b.removeTextChangedListener(h.this.d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == h.this.e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (!h.q) {
                return;
            }
            autoCompleteTextView.setOnDismissListener(null);
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.h(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    static {
        q = Build.VERSION.SDK_INT >= 21;
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c(this.a);
        this.g = new d();
        this.h = new e();
        this.i = false;
        this.j = false;
        this.k = Long.MAX_VALUE;
    }

    public static AutoCompleteTextView e(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean f(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void g(h hVar, boolean z) {
        if (hVar.j != z) {
            hVar.j = z;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void h(h hVar, AutoCompleteTextView autoCompleteTextView) {
        hVar.getClass();
        if (autoCompleteTextView == null) {
            return;
        }
        if (hVar.j()) {
            hVar.i = false;
        }
        if (hVar.i) {
            hVar.i = false;
            return;
        }
        if (q) {
            boolean z = hVar.j;
            boolean z2 = !z;
            if (z != z2) {
                hVar.j = z2;
                hVar.p.cancel();
                hVar.o.start();
            }
        } else {
            hVar.j = !hVar.j;
            hVar.f914c.toggle();
        }
        if (!hVar.j) {
            autoCompleteTextView.dismissDropDown();
            return;
        }
        autoCompleteTextView.requestFocus();
        autoCompleteTextView.showDropDown();
    }

    @Override // c.c.a.a.x.m
    public void a() {
        float dimensionPixelOffset = this.f913b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f913b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f913b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        c.c.a.a.u.g i = i(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        c.c.a.a.u.g i2 = i(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = i;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, i);
        this.l.addState(new int[0], i2);
        this.a.setEndIconDrawable(b.b.d.a.a.b(this.f913b, q ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.a(this.g);
        this.a.g0.add(this.h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = c.c.a.a.c.a.a;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(67);
        ofFloat.addUpdateListener(new i(this));
        this.p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(50);
        ofFloat2.addUpdateListener(new i(this));
        this.o = ofFloat2;
        ofFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.f913b.getSystemService("accessibility");
    }

    @Override // c.c.a.a.x.m
    public boolean b(int i) {
        return i != 0;
    }

    @Override // c.c.a.a.x.m
    public boolean d() {
        return true;
    }

    public final c.c.a.a.u.g i(float f2, float f3, float f4, int i) {
        j.b bVar = new j.b();
        bVar.e = new c.c.a.a.u.a(f2);
        bVar.f = new c.c.a.a.u.a(f2);
        bVar.h = new c.c.a.a.u.a(f3);
        bVar.g = new c.c.a.a.u.a(f3);
        c.c.a.a.u.j a2 = bVar.a();
        Context context = this.f913b;
        String str = c.c.a.a.u.g.x;
        int r = c.c.a.a.a.r(context, R.attr.colorSurface, c.c.a.a.u.g.class.getSimpleName());
        c.c.a.a.u.g gVar = new c.c.a.a.u.g();
        gVar.f876b.f878b = new c.c.a.a.n.a(context);
        gVar.w();
        gVar.p(ColorStateList.valueOf(r));
        g.b bVar2 = gVar.f876b;
        if (bVar2.o != f4) {
            bVar2.o = f4;
            gVar.w();
        }
        gVar.f876b.a = a2;
        gVar.invalidateSelf();
        g.b bVar3 = gVar.f876b;
        if (bVar3.i == null) {
            bVar3.i = new Rect();
        }
        gVar.f876b.i.set(0, i, 0, i);
        gVar.invalidateSelf();
        return gVar;
    }

    public final boolean j() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
