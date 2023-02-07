package c.c.a.a.q;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;
/* loaded from: classes.dex */
public class a extends b.h.j.a {
    public final /* synthetic */ CheckableImageButton d;

    public a(CheckableImageButton checkableImageButton) {
        this.d = checkableImageButton;
    }

    @Override // b.h.j.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.d.isChecked());
    }

    @Override // b.h.j.a
    public void d(View view, b.h.j.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        bVar.a.setCheckable(this.d.e);
        bVar.a.setChecked(this.d.isChecked());
    }
}
