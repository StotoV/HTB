package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.h.j.q;
import c.c.a.a.a0.c;
import c.c.a.a.a0.e;
import c.c.a.a.c.g;
import c.c.a.a.c.h;
import c.c.a.a.c.i;
import c.c.a.a.k.d;
import com.example.apkey.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c  reason: collision with root package name */
    public final Rect f976c;
    public final RectF d;
    public final RectF e;
    public final int[] f;
    public float g;
    public float h;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f977b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f978c;

        public a(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
            this.a = z;
            this.f977b = view;
            this.f978c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                this.f977b.setVisibility(4);
                this.f978c.setAlpha(1.0f);
                this.f978c.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.f977b.setVisibility(0);
                this.f978c.setAlpha(0.0f);
                this.f978c.setVisibility(4);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public g a;

        /* renamed from: b  reason: collision with root package name */
        public i f979b;
    }

    public FabTransformationBehavior() {
        this.f976c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f976c = new Rect();
        this.d = new RectF();
        this.e = new RectF();
        this.f = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet D(View view, View view2, boolean z, boolean z2) {
        h hVar;
        Animator a2;
        ArrayList arrayList;
        d dVar;
        ArrayList arrayList2;
        ObjectAnimator ofInt;
        b O = O(view2.getContext(), z);
        if (z) {
            this.g = view.getTranslationX();
            this.h = view.getTranslationY();
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            L(view, view2, z, z2, O, arrayList3);
        }
        RectF rectF = this.d;
        N(view, view2, z, z2, O, arrayList3, rectF);
        float width = rectF.width();
        float height = rectF.height();
        float F = F(view, view2, O.f979b);
        float G = G(view, view2, O.f979b);
        Pair<h, h> E = E(F, G, z, O);
        h hVar2 = (h) E.first;
        h hVar3 = (h) E.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            F = this.g;
        }
        fArr[0] = F;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            G = this.h;
        }
        fArr2[0] = G;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        hVar2.a(ofFloat);
        hVar3.a(ofFloat2);
        arrayList3.add(ofFloat);
        arrayList3.add(ofFloat2);
        boolean z3 = view2 instanceof d;
        if (z3 && (view instanceof ImageView)) {
            d dVar2 = (d) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable != null) {
                drawable.mutate();
                if (z) {
                    if (!z2) {
                        drawable.setAlpha(255);
                    }
                    ofInt = ObjectAnimator.ofInt(drawable, c.c.a.a.c.d.f761b, 0);
                } else {
                    ofInt = ObjectAnimator.ofInt(drawable, c.c.a.a.c.d.f761b, 255);
                }
                ofInt.addUpdateListener(new c.c.a.a.a0.a(this, view2));
                O.a.d("iconFade").a(ofInt);
                arrayList3.add(ofInt);
                arrayList4.add(new c.c.a.a.a0.b(this, dVar2, drawable));
            }
        }
        if (!z3) {
            arrayList2 = arrayList4;
        } else {
            d dVar3 = (d) view2;
            i iVar = O.f979b;
            RectF rectF2 = this.d;
            RectF rectF3 = this.e;
            I(view, rectF2);
            rectF2.offset(this.g, this.h);
            I(view2, rectF3);
            rectF3.offset(-F(view, view2, iVar), 0.0f);
            float centerX = rectF2.centerX() - rectF3.left;
            i iVar2 = O.f979b;
            RectF rectF4 = this.d;
            RectF rectF5 = this.e;
            I(view, rectF4);
            rectF4.offset(this.g, this.h);
            I(view2, rectF5);
            rectF5.offset(0.0f, -G(view, view2, iVar2));
            float centerY = rectF4.centerY() - rectF5.top;
            ((FloatingActionButton) view).g(this.f976c);
            float width2 = this.f976c.width() / 2.0f;
            h d = O.a.d("expansion");
            if (z) {
                if (!z2) {
                    dVar3.setRevealInfo(new d.e(centerX, centerY, width2));
                }
                if (z2) {
                    width2 = dVar3.getRevealInfo().f791c;
                }
                float c2 = c.c.a.a.a.c(centerX, centerY, 0.0f, 0.0f);
                float c3 = c.c.a.a.a.c(centerX, centerY, width, 0.0f);
                float c4 = c.c.a.a.a.c(centerX, centerY, width, height);
                float c5 = c.c.a.a.a.c(centerX, centerY, 0.0f, height);
                if (c2 <= c3 || c2 <= c4 || c2 <= c5) {
                    c2 = (c3 <= c4 || c3 <= c5) ? c4 > c5 ? c4 : c5 : c3;
                }
                Animator a3 = c.c.a.a.a.a(dVar3, centerX, centerY, c2);
                a3.addListener(new c(this, dVar3));
                a2 = a3;
                hVar = d;
                M(view2, d.a, (int) centerX, (int) centerY, width2, arrayList3);
                arrayList = arrayList4;
                dVar = dVar3;
            } else {
                hVar = d;
                float f = dVar3.getRevealInfo().f791c;
                a2 = c.c.a.a.a.a(dVar3, centerX, centerY, width2);
                int i = (int) centerX;
                int i2 = (int) centerY;
                M(view2, hVar.a, i, i2, f, arrayList3);
                long j = hVar.a;
                long j2 = hVar.f765b;
                g gVar = O.a;
                int i3 = gVar.a.d;
                long j3 = 0;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = i3;
                    h k = gVar.a.k(i4);
                    j3 = Math.max(j3, k.a + k.f765b);
                    i4++;
                    i3 = i5;
                    arrayList4 = arrayList4;
                    dVar3 = dVar3;
                    gVar = gVar;
                }
                arrayList = arrayList4;
                dVar = dVar3;
                if (Build.VERSION.SDK_INT >= 21) {
                    long j4 = j + j2;
                    if (j4 < j3) {
                        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view2, i, i2, width2, width2);
                        createCircularReveal.setStartDelay(j4);
                        createCircularReveal.setDuration(j3 - j4);
                        arrayList3.add(createCircularReveal);
                    }
                }
            }
            Animator animator = a2;
            hVar.a(animator);
            arrayList3.add(animator);
            arrayList2 = arrayList;
            arrayList2.add(new c.c.a.a.k.a(dVar));
        }
        K(view, view2, z, z2, O, arrayList3);
        J(view2, z, z2, O, arrayList3);
        AnimatorSet animatorSet = new AnimatorSet();
        c.c.a.a.a.o(animatorSet, arrayList3);
        animatorSet.addListener(new a(this, z, view2, view));
        int size = arrayList2.size();
        for (int i6 = 0; i6 < size; i6++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i6));
        }
        return animatorSet;
    }

    public final Pair<h, h> E(float f, float f2, boolean z, b bVar) {
        h d;
        g gVar;
        String str;
        if (f == 0.0f || f2 == 0.0f) {
            d = bVar.a.d("translationXLinear");
            gVar = bVar.a;
            str = "translationYLinear";
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            d = bVar.a.d("translationXCurveDownwards");
            gVar = bVar.a;
            str = "translationYCurveDownwards";
        } else {
            d = bVar.a.d("translationXCurveUpwards");
            gVar = bVar.a;
            str = "translationYCurveUpwards";
        }
        return new Pair<>(d, gVar.d(str));
    }

    public final float F(View view, View view2, i iVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        I(view, rectF);
        rectF.offset(this.g, this.h);
        I(view2, rectF2);
        iVar.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float G(View view, View view2, i iVar) {
        RectF rectF = this.d;
        RectF rectF2 = this.e;
        I(view, rectF);
        rectF.offset(this.g, this.h);
        I(view2, rectF2);
        iVar.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final float H(b bVar, h hVar, float f, float f2) {
        long j = hVar.a;
        long j2 = hVar.f765b;
        h d = bVar.a.d("expansion");
        float interpolation = hVar.b().getInterpolation(((float) (((d.a + d.f765b) + 17) - j)) / ((float) j2));
        TimeInterpolator timeInterpolator = c.c.a.a.c.a.a;
        return c.a.a.a.a.a(f2, f, interpolation, f);
    }

    public final void I(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void J(View view, boolean z, boolean z2, b bVar, List list) {
        ViewGroup P;
        ObjectAnimator ofFloat;
        if (!(view instanceof ViewGroup)) {
            return;
        }
        if ((view instanceof d) && c.c.a.a.k.c.a == 0) {
            return;
        }
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            P = P(findViewById);
        } else {
            if ((view instanceof e) || (view instanceof c.c.a.a.a0.d)) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            P = P(view);
        }
        if (P == null) {
            return;
        }
        if (z) {
            if (!z2) {
                c.c.a.a.c.c.a.set(P, Float.valueOf(0.0f));
            }
            ofFloat = ObjectAnimator.ofFloat(P, c.c.a.a.c.c.a, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(P, c.c.a.a.c.c.a, 0.0f);
        }
        bVar.a.d("contentFade").a(ofFloat);
        list.add(ofFloat);
    }

    public final void K(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof d)) {
            return;
        }
        d dVar = (d) view2;
        ColorStateList l = q.l(view);
        int colorForState = l != null ? l.getColorForState(view.getDrawableState(), l.getDefaultColor()) : 0;
        int i = 16777215 & colorForState;
        if (z) {
            if (!z2) {
                dVar.setCircularRevealScrimColor(colorForState);
            }
            ofInt = ObjectAnimator.ofInt(dVar, d.C0036d.a, i);
        } else {
            ofInt = ObjectAnimator.ofInt(dVar, d.C0036d.a, colorForState);
        }
        ofInt.setEvaluator(c.c.a.a.c.b.a);
        bVar.a.d("color").a(ofInt);
        list.add(ofInt);
    }

    @TargetApi(21)
    public final void L(View view, View view2, boolean z, boolean z2, b bVar, List list) {
        ObjectAnimator ofFloat;
        float m = q.m(view2) - q.m(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-m);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -m);
        }
        bVar.a.d("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    public final void M(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j);
        list.add(createCircularReveal);
    }

    public final void N(View view, View view2, boolean z, boolean z2, b bVar, List list, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float F = F(view, view2, bVar.f979b);
        float G = G(view, view2, bVar.f979b);
        Pair<h, h> E = E(F, G, z, bVar);
        h hVar = (h) E.first;
        h hVar2 = (h) E.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-F);
                view2.setTranslationY(-G);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float H = H(bVar, hVar, -F, 0.0f);
            float H2 = H(bVar, hVar2, -G, 0.0f);
            Rect rect = this.f976c;
            view2.getWindowVisibleDisplayFrame(rect);
            RectF rectF2 = this.d;
            rectF2.set(rect);
            RectF rectF3 = this.e;
            I(view2, rectF3);
            rectF3.offset(H, H2);
            rectF3.intersect(rectF2);
            rectF.set(rectF3);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -F);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -G);
        }
        hVar.a(ofFloat);
        hVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public abstract b O(Context context, boolean z);

    public final ViewGroup P(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }
}
