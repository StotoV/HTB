package b.h.g;

import android.graphics.Typeface;
import b.h.d.d;
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ m f425b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Typeface f426c;

    public a(c cVar, m mVar, Typeface typeface) {
        this.f425b = mVar;
        this.f426c = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar = this.f425b;
        Typeface typeface = this.f426c;
        b.h.c.b.g gVar = ((d.a) mVar).a;
        if (gVar != null) {
            gVar.e(typeface);
        }
    }
}
