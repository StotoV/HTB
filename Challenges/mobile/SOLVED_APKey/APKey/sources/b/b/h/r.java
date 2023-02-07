package b.b.h;

import android.graphics.Typeface;
import android.widget.TextView;
/* loaded from: classes.dex */
public class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f263b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Typeface f264c;
    public final /* synthetic */ int d;

    public r(q qVar, TextView textView, Typeface typeface, int i) {
        this.f263b = textView;
        this.f264c = typeface;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f263b.setTypeface(this.f264c, this.d);
    }
}
