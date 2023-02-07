package c.c.a.a.r;

import android.graphics.Typeface;
import android.text.TextPaint;
/* loaded from: classes.dex */
public class c extends d {
    public final /* synthetic */ TextPaint a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f867b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f868c;

    public c(b bVar, TextPaint textPaint, d dVar) {
        this.f868c = bVar;
        this.a = textPaint;
        this.f867b = dVar;
    }

    @Override // c.c.a.a.r.d
    public void a(int i) {
        this.f867b.a(i);
    }

    @Override // c.c.a.a.r.d
    public void b(Typeface typeface, boolean z) {
        this.f868c.d(this.a, typeface);
        this.f867b.b(typeface, z);
    }
}
