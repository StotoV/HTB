package c.c.a.a.q;

import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    public float f856c;
    public WeakReference<b> e;
    public c.c.a.a.r.b f;
    public final TextPaint a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    public final c.c.a.a.r.d f855b = new a();
    public boolean d = true;

    /* loaded from: classes.dex */
    public class a extends c.c.a.a.r.d {
        public a() {
        }

        @Override // c.c.a.a.r.d
        public void a(int i) {
            i iVar = i.this;
            iVar.d = true;
            b bVar = iVar.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // c.c.a.a.r.d
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            i iVar = i.this;
            iVar.d = true;
            b bVar = iVar.e.get();
            if (bVar == null) {
                return;
            }
            bVar.a();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public i(b bVar) {
        this.e = new WeakReference<>(null);
        this.e = new WeakReference<>(bVar);
    }

    public float a(String str) {
        if (!this.d) {
            return this.f856c;
        }
        float measureText = str == null ? 0.0f : this.a.measureText((CharSequence) str, 0, str.length());
        this.f856c = measureText;
        this.d = false;
        return measureText;
    }
}
