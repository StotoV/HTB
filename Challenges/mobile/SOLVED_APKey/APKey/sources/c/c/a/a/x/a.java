package c.c.a.a.x;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.example.apkey.R;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public class a extends m {
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.f f;
    public final TextInputLayout.g g;
    public AnimatorSet h;
    public ValueAnimator i;

    /* renamed from: c.c.a.a.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a implements TextWatcher {
        public C0042a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() != null) {
                return;
            }
            a.this.e(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            a aVar = a.this;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.e(z2);
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextInputLayout.f {
        public c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            if ((r0.getText().length() > 0) != false) goto L7;
         */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(com.google.android.material.textfield.TextInputLayout r5) {
            /*
                r4 = this;
                android.widget.EditText r0 = r5.getEditText()
                boolean r1 = r0.hasFocus()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L1c
                android.text.Editable r1 = r0.getText()
                int r1 = r1.length()
                if (r1 <= 0) goto L18
                r1 = 1
                goto L19
            L18:
                r1 = 0
            L19:
                if (r1 == 0) goto L1c
                goto L1d
            L1c:
                r2 = 0
            L1d:
                r5.setEndIconVisible(r2)
                r5.setEndIconCheckable(r3)
                c.c.a.a.x.a r5 = c.c.a.a.x.a.this
                android.view.View$OnFocusChangeListener r5 = r5.e
                r0.setOnFocusChangeListener(r5)
                c.c.a.a.x.a r5 = c.c.a.a.x.a.this
                android.text.TextWatcher r5 = r5.d
                r0.removeTextChangedListener(r5)
                c.c.a.a.x.a r5 = c.c.a.a.x.a.this
                android.text.TextWatcher r5 = r5.d
                r0.addTextChangedListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.x.a.c.a(com.google.android.material.textfield.TextInputLayout):void");
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextInputLayout.g {

        /* renamed from: c.c.a.a.x.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0043a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EditText f902b;

            public RunnableC0043a(EditText editText) {
                this.f902b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f902b.removeTextChangedListener(a.this.d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new RunnableC0043a(editText));
            if (editText.getOnFocusChangeListener() != a.this.e) {
                return;
            }
            editText.setOnFocusChangeListener(null);
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.o();
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new C0042a();
        this.e = new b();
        this.f = new c();
        this.g = new d();
    }

    @Override // c.c.a.a.x.m
    public void a() {
        this.a.setEndIconDrawable(b.b.d.a.a.b(this.f913b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.a(this.f);
        this.a.g0.add(this.g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(c.c.a.a.c.a.d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new c.c.a.a.x.e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = c.c.a.a.c.a.a;
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new c.c.a.a.x.d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.h.addListener(new c.c.a.a.x.b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new c.c.a.a.x.d(this));
        this.i = ofFloat3;
        ofFloat3.addListener(new c.c.a.a.x.c(this));
    }

    @Override // c.c.a.a.x.m
    public void c(boolean z) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        e(z);
    }

    public final void e(boolean z) {
        boolean z2 = this.a.k() == z;
        if (z && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (!z2) {
                return;
            }
            this.h.end();
        } else if (z) {
        } else {
            this.h.cancel();
            this.i.start();
            if (!z2) {
                return;
            }
            this.i.end();
        }
    }
}
