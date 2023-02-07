package b.j.b;

import android.graphics.Rect;
import b.j.b.a;
import java.util.Comparator;
/* loaded from: classes.dex */
public class d<T> implements Comparator<T> {
    public final Rect a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public final Rect f512b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f513c;
    public final b<T> d;

    public d(boolean z, b<T> bVar) {
        this.f513c = z;
        this.d = bVar;
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.a;
        Rect rect2 = this.f512b;
        ((a.C0024a) this.d).a(t, rect);
        ((a.C0024a) this.d).a(t2, rect2);
        int i = rect.top;
        int i2 = rect2.top;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = rect.left;
        int i4 = rect2.left;
        if (i3 < i4) {
            return this.f513c ? 1 : -1;
        } else if (i3 > i4) {
            return this.f513c ? -1 : 1;
        } else {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = rect.right;
            int i8 = rect2.right;
            if (i7 < i8) {
                return this.f513c ? 1 : -1;
            } else if (i7 <= i8) {
                return 0;
            } else {
                return this.f513c ? -1 : 1;
            }
        }
    }
}
