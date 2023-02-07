package b.b.e.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import b.b.e.a.b;
import b.b.e.a.d;
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class a extends b.b.e.a.d implements b.h.d.l.a {
    public c q;
    public g r;
    public int s;
    public int t;
    public boolean u;

    /* loaded from: classes.dex */
    public static class b extends g {
        public final Animatable a;

        public b(Animatable animatable) {
            super(null);
            this.a = animatable;
        }

        @Override // b.b.e.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // b.b.e.a.a.g
        public void d() {
            this.a.stop();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends d.a {
        public b.e.c<Long> K;
        public b.e.g<Integer> L;

        public c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            b.e.g<Integer> gVar;
            if (cVar != null) {
                this.K = cVar.K;
                gVar = cVar.L;
            } else {
                this.K = new b.e.c<>();
                gVar = new b.e.g<>();
            }
            this.L = gVar;
        }

        public static long h(int i, int i2) {
            return i2 | (i << 32);
        }

        @Override // b.b.e.a.d.a, b.b.e.a.b.c
        public void e() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        public int i(int i) {
            if (i < 0) {
                return 0;
            }
            return this.L.d(i, 0).intValue();
        }

        @Override // b.b.e.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // b.b.e.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends g {
        public final b.r.a.a.b a;

        public d(b.r.a.a.b bVar) {
            super(null);
            this.a = bVar;
        }

        @Override // b.b.e.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // b.b.e.a.a.g
        public void d() {
            this.a.stop();
        }
    }

    /* loaded from: classes.dex */
    public static class e extends g {
        public final ObjectAnimator a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f142b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(fVar.f144c);
            ofInt.setInterpolator(fVar);
            this.f142b = z2;
            this.a = ofInt;
        }

        @Override // b.b.e.a.a.g
        public boolean a() {
            return this.f142b;
        }

        @Override // b.b.e.a.a.g
        public void b() {
            this.a.reverse();
        }

        @Override // b.b.e.a.a.g
        public void c() {
            this.a.start();
        }

        @Override // b.b.e.a.a.g
        public void d() {
            this.a.cancel();
        }
    }

    /* loaded from: classes.dex */
    public static class f implements TimeInterpolator {
        public int[] a;

        /* renamed from: b  reason: collision with root package name */
        public int f143b;

        /* renamed from: c  reason: collision with root package name */
        public int f144c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f143b = numberOfFrames;
            int[] iArr = this.a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.a = new int[numberOfFrames];
            }
            int[] iArr2 = this.a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f144c = i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f144c) + 0.5f);
            int i2 = this.f143b;
            int[] iArr = this.a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f144c : 0.0f);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class g {
        public g(C0005a c0005a) {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public a(c cVar, Resources resources) {
        super(null);
        this.s = -1;
        this.t = -1;
        c cVar2 = new c(cVar, this, resources);
        super.e(cVar2);
        this.q = cVar2;
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0219, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(c.a.a.a.a.f(r21, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v10, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.b.e.a.a g(android.content.Context r19, android.content.res.Resources r20, org.xmlpull.v1.XmlPullParser r21, android.util.AttributeSet r22, android.content.res.Resources.Theme r23) {
        /*
            Method dump skipped, instructions count: 608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.e.a.a.g(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):b.b.e.a.a");
    }

    @Override // b.b.e.a.d, b.b.e.a.b
    public b.c b() {
        return new c(this.q, this, null);
    }

    @Override // b.b.e.a.d, b.b.e.a.b
    public void e(b.c cVar) {
        super.e(cVar);
        if (cVar instanceof c) {
            this.q = (c) cVar;
        }
    }

    @Override // b.b.e.a.d
    public d.a f() {
        return new c(this.q, this, null);
    }

    @Override // b.b.e.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // b.b.e.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.r;
        if (gVar != null) {
            gVar.d();
            this.r = null;
            d(this.s);
            this.s = -1;
            this.t = -1;
        }
    }

    @Override // b.b.e.a.d, b.b.e.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.u) {
            super.mutate();
            if (this == this) {
                this.q.e();
                this.u = true;
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    @Override // b.b.e.a.d, b.b.e.a.b, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onStateChange(int[] r19) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.e.a.a.onStateChange(int[]):boolean");
    }

    @Override // b.b.e.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        g gVar = this.r;
        if (gVar != null && (visible || z2)) {
            if (z) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
