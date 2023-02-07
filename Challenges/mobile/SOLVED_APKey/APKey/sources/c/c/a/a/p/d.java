package c.c.a.a.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.StateSet;
import android.view.View;
import android.view.ViewTreeObserver;
import b.h.j.q;
import c.c.a.a.q.g;
import c.c.a.a.u.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d {
    public j a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f840b;
    public float d;
    public float e;
    public float f;
    public final c.c.a.a.q.g g;
    public c.c.a.a.c.g h;
    public c.c.a.a.c.g i;
    public Animator j;
    public c.c.a.a.c.g k;
    public c.c.a.a.c.g l;
    public float m;
    public ArrayList<Animator.AnimatorListener> p;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<e> r;
    public final FloatingActionButton s;
    public final c.c.a.a.t.b t;
    public ViewTreeObserver.OnPreDrawListener y;
    public static final TimeInterpolator z = c.c.a.a.c.a.f760c;
    public static final int[] A = {16842919, 16842910};
    public static final int[] B = {16843623, 16842908, 16842910};
    public static final int[] C = {16842908, 16842910};
    public static final int[] D = {16843623, 16842910};
    public static final int[] E = {16842910};
    public static final int[] F = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public boolean f841c = true;
    public float n = 1.0f;
    public int o = 0;
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public final RectF w = new RectF();
    public final Matrix x = new Matrix();

    /* loaded from: classes.dex */
    public class a extends c.c.a.a.c.f {
        public a() {
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            d.this.n = f;
            matrix.getValues(this.a);
            matrix2.getValues(this.f762b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f762b;
                float f2 = fArr[i];
                float[] fArr2 = this.a;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.f763c.setValues(this.f762b);
            return this.f763c;
        }
    }

    /* loaded from: classes.dex */
    public class b extends h {
        public b(d dVar) {
            super(null);
        }

        @Override // c.c.a.a.p.d.h
        public float a() {
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public class c extends h {
        public c() {
            super(null);
        }

        @Override // c.c.a.a.p.d.h
        public float a() {
            d dVar = d.this;
            return dVar.d + dVar.e;
        }
    }

    /* renamed from: c.c.a.a.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0038d extends h {
        public C0038d() {
            super(null);
        }

        @Override // c.c.a.a.p.d.h
        public float a() {
            d dVar = d.this;
            return dVar.d + dVar.f;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public class g extends h {
        public g() {
            super(null);
        }

        @Override // c.c.a.a.p.d.h
        public float a() {
            return d.this.d;
        }
    }

    /* loaded from: classes.dex */
    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public float f842b;

        public h(c.c.a.a.p.b bVar) {
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d.this.getClass();
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                d.this.getClass();
                this.f842b = a();
                this.a = true;
            }
            d dVar = d.this;
            valueAnimator.getAnimatedFraction();
            dVar.getClass();
        }
    }

    public d(FloatingActionButton floatingActionButton, c.c.a.a.t.b bVar) {
        this.s = floatingActionButton;
        this.t = bVar;
        c.c.a.a.q.g gVar = new c.c.a.a.q.g();
        this.g = gVar;
        gVar.a(A, b(new C0038d()));
        gVar.a(B, b(new c()));
        gVar.a(C, b(new c()));
        gVar.a(D, b(new c()));
        gVar.a(E, b(new g()));
        gVar.a(F, b(new b(this)));
        this.m = floatingActionButton.getRotation();
    }

    public final AnimatorSet a(c.c.a.a.c.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, View.ALPHA, f2);
        gVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s, View.SCALE_X, f3);
        gVar.d("scale").a(ofFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            ofFloat2.setEvaluator(new c.c.a.a.p.e(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.s, View.SCALE_Y, f3);
        gVar.d("scale").a(ofFloat3);
        if (i == 26) {
            ofFloat3.setEvaluator(new c.c.a.a.p.e(this));
        }
        arrayList.add(ofFloat3);
        this.x.reset();
        this.s.getDrawable();
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.s, new c.c.a.a.c.e(), new a(), new Matrix(this.x));
        gVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        c.c.a.a.a.o(animatorSet, arrayList);
        return animatorSet;
    }

    public final ValueAnimator b(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(z);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float c() {
        return this.d;
    }

    public void d(Rect rect) {
        int i = 0;
        if (this.f840b) {
            i = (0 - this.s.getSizeDimension()) / 2;
        }
        float c2 = this.f841c ? c() + this.f : 0.0f;
        int max = Math.max(i, (int) Math.ceil(c2));
        int max2 = Math.max(i, (int) Math.ceil(c2 * 1.5f));
        rect.set(max, max2, max, max2);
    }

    public boolean e() {
        return this.s.getVisibility() == 0 ? this.o == 1 : this.o != 2;
    }

    public boolean f() {
        return this.s.getVisibility() != 0 ? this.o == 2 : this.o != 1;
    }

    public void g() {
        c.c.a.a.q.g gVar = this.g;
        ValueAnimator valueAnimator = gVar.f851c;
        if (valueAnimator != null) {
            valueAnimator.end();
            gVar.f851c = null;
        }
    }

    public void h() {
    }

    public void i(int[] iArr) {
        g.b bVar;
        ValueAnimator valueAnimator;
        c.c.a.a.q.g gVar = this.g;
        int size = gVar.a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                bVar = null;
                break;
            }
            bVar = gVar.a.get(i);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            }
            i++;
        }
        g.b bVar2 = gVar.f850b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null && (valueAnimator = gVar.f851c) != null) {
            valueAnimator.cancel();
            gVar.f851c = null;
        }
        gVar.f850b = bVar;
        if (bVar == null) {
            return;
        }
        ValueAnimator valueAnimator2 = bVar.f852b;
        gVar.f851c = valueAnimator2;
        valueAnimator2.start();
    }

    public void j(float f2, float f3, float f4) {
        t();
        throw null;
    }

    public void k() {
        ArrayList<e> arrayList = this.r;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void l() {
        ArrayList<e> arrayList = this.r;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public boolean m() {
        return true;
    }

    public final void n(float f2) {
        this.n = f2;
        Matrix matrix = this.x;
        matrix.reset();
        this.s.getDrawable();
        this.s.setImageMatrix(matrix);
    }

    public void o(ColorStateList colorStateList) {
    }

    public boolean p() {
        return true;
    }

    public final boolean q() {
        return q.u(this.s) && !this.s.isInEditMode();
    }

    public final boolean r() {
        return !this.f840b || this.s.getSizeDimension() >= 0;
    }

    public void s() {
        FloatingActionButton floatingActionButton;
        int i;
        if (Build.VERSION.SDK_INT == 19) {
            if (this.m % 90.0f != 0.0f) {
                i = 1;
                if (this.s.getLayerType() == 1) {
                    return;
                }
                floatingActionButton = this.s;
            } else if (this.s.getLayerType() == 0) {
                return;
            } else {
                floatingActionButton = this.s;
                i = 0;
            }
            floatingActionButton.setLayerType(i, null);
        }
    }

    public final void t() {
        Rect rect = this.u;
        d(rect);
        b.h.b.a.h(null, "Didn't initialize content background");
        if (p()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.t;
            bVar.getClass();
            super/*android.widget.ImageButton*/.setBackgroundDrawable(insetDrawable);
        } else {
            ((FloatingActionButton.b) this.t).getClass();
        }
        c.c.a.a.t.b bVar2 = this.t;
        int i = rect.left;
        FloatingActionButton.this.getClass();
        throw null;
    }
}
