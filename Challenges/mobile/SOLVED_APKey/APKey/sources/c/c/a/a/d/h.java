package c.c.a.a.d;

import android.view.View;
import b.h.j.q;
/* loaded from: classes.dex */
public class h {
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public int f777b;

    /* renamed from: c  reason: collision with root package name */
    public int f778c;
    public int d;
    public int e;

    public h(View view) {
        this.a = view;
    }

    public void a() {
        View view = this.a;
        q.x(view, this.d - (view.getTop() - this.f777b));
        View view2 = this.a;
        q.w(view2, this.e - (view2.getLeft() - this.f778c));
    }
}
