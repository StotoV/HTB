package c.c.a.a.x;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.example.apkey.R;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public class p extends m {
    public final TextWatcher d;
    public final TextInputLayout.f e;
    public final TextInputLayout.g f;

    /* loaded from: classes.dex */
    public class a extends c.c.a.a.q.j {
        public a() {
        }

        @Override // c.c.a.a.q.j, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            p pVar = p.this;
            pVar.f914c.setChecked(!p.e(pVar));
        }
    }

    /* loaded from: classes.dex */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            p pVar = p.this;
            pVar.f914c.setChecked(!p.e(pVar));
            editText.removeTextChangedListener(p.this.d);
            editText.addTextChangedListener(p.this.d);
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextInputLayout.g {

        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ EditText f920b;

            public a(EditText editText) {
                this.f920b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f920b.removeTextChangedListener(p.this.d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = p.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            editText.setTransformationMethod(p.e(p.this) ? null : PasswordTransformationMethod.getInstance());
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            p.this.a.o();
        }
    }

    public p(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c();
    }

    public static boolean e(p pVar) {
        EditText editText = pVar.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // c.c.a.a.x.m
    public void a() {
        this.a.setEndIconDrawable(b.b.d.a.a.b(this.f913b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.a(this.e);
        this.a.g0.add(this.f);
        EditText editText = this.a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
