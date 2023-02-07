package b.k.b;

import android.util.Log;
import java.io.Writer;
/* loaded from: classes.dex */
public final class x0 extends Writer {

    /* renamed from: b  reason: collision with root package name */
    public final String f613b;

    /* renamed from: c  reason: collision with root package name */
    public StringBuilder f614c = new StringBuilder(128);

    public x0(String str) {
        this.f613b = str;
    }

    public final void a() {
        if (this.f614c.length() > 0) {
            Log.d(this.f613b, this.f614c.toString());
            StringBuilder sb = this.f614c;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.f614c.append(c2);
            }
        }
    }
}
