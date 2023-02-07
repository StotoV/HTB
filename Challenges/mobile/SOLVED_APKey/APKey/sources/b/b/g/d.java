package b.b.g;

import android.view.View;
import android.view.animation.Interpolator;
import b.h.j.x;
import b.h.j.y;
import b.h.j.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f163c;
    public y d;
    public boolean e;

    /* renamed from: b  reason: collision with root package name */
    public long f162b = -1;
    public final z f = new a();
    public final ArrayList<x> a = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a extends z {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f164b = 0;

        public a() {
        }

        @Override // b.h.j.y
        public void a(View view) {
            int i = this.f164b + 1;
            this.f164b = i;
            if (i == d.this.a.size()) {
                y yVar = d.this.d;
                if (yVar != null) {
                    yVar.a(null);
                }
                this.f164b = 0;
                this.a = false;
                d.this.e = false;
            }
        }

        @Override // b.h.j.y
        public void b(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            y yVar = d.this.d;
            if (yVar == null) {
                return;
            }
            yVar.b(null);
        }
    }

    public void a() {
        if (!this.e) {
            return;
        }
        Iterator<x> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.e = false;
    }

    public void b() {
        View view;
        if (this.e) {
            return;
        }
        Iterator<x> it = this.a.iterator();
        while (it.hasNext()) {
            x next = it.next();
            long j = this.f162b;
            if (j >= 0) {
                next.b(j);
            }
            Interpolator interpolator = this.f163c;
            if (interpolator != null && (view = next.a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                next.c(this.f);
            }
            View view2 = next.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
