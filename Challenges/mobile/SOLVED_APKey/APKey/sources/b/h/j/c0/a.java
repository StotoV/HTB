package b.h.j.c0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final int f474b;

    /* renamed from: c  reason: collision with root package name */
    public final b f475c;
    public final int d;

    public a(int i, b bVar, int i2) {
        this.f474b = i;
        this.f475c = bVar;
        this.d = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f474b);
        b bVar = this.f475c;
        bVar.a.performAction(this.d, bundle);
    }
}
