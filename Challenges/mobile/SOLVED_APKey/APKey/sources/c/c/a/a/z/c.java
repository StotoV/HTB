package c.c.a.a.z;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.c.d;
import b.h.j.q;
import c.c.a.a.u.g;
import c.c.a.a.u.h;
import c.c.a.a.u.j;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class c extends ConstraintLayout {
    public final Runnable u;
    public int v;
    public g w;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.k();
        }
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        g gVar = new g();
        this.w = gVar;
        h hVar = new h(0.5f);
        j jVar = gVar.f876b.a;
        jVar.getClass();
        j.b bVar = new j.b(jVar);
        bVar.e = hVar;
        bVar.f = hVar;
        bVar.g = hVar;
        bVar.h = hVar;
        gVar.f876b.a = bVar.a();
        gVar.invalidateSelf();
        this.w.p(ColorStateList.valueOf(-1));
        g gVar2 = this.w;
        AtomicInteger atomicInteger = q.a;
        setBackground(gVar2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.c.a.a.b.v, i, 0);
        this.v = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.u = new a();
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            view.setId(q.g());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.u);
            handler.post(this.u);
        }
    }

    public void k() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        b.f.c.d dVar = new b.f.c.d();
        dVar.b(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int id = childAt.getId();
                int i4 = this.v;
                if (!dVar.f375c.containsKey(Integer.valueOf(id))) {
                    dVar.f375c.put(Integer.valueOf(id), new d.a());
                }
                d.b bVar = dVar.f375c.get(Integer.valueOf(id)).d;
                bVar.x = R.id.circle_center;
                bVar.y = i4;
                bVar.z = f;
                f = (360.0f / (childCount - i)) + f;
            }
        }
        dVar.a(this, true);
        setConstraintSet(null);
        requestLayout();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        k();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.u);
            handler.post(this.u);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.w.p(ColorStateList.valueOf(i));
    }
}
