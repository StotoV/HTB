package c.c.a.a.x;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
/* loaded from: classes.dex */
public abstract class m {
    public TextInputLayout a;

    /* renamed from: b  reason: collision with root package name */
    public Context f913b;

    /* renamed from: c  reason: collision with root package name */
    public CheckableImageButton f914c;

    public m(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
        this.f913b = textInputLayout.getContext();
        this.f914c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i) {
        return true;
    }

    public void c(boolean z) {
    }

    public boolean d() {
        return false;
    }
}
