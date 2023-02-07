package b.h.k;

import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import b.h.j.q;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    public final C0021a f500b;

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f501c;
    public final View d;
    public Runnable e;
    public float[] f;
    public float[] g;
    public int h;
    public int i;
    public float[] j;
    public float[] k;
    public float[] l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* renamed from: b.h.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0021a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f502b;

        /* renamed from: c  reason: collision with root package name */
        public float f503c;
        public float d;
        public float j;
        public int k;
        public long e = Long.MIN_VALUE;
        public long i = -1;
        public long f = 0;
        public int g = 0;
        public int h = 0;

        public final float a(long j) {
            long j2 = this.e;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.i;
            if (j3 < 0 || j < j3) {
                return a.b(((float) (j - j2)) / this.a, 0.0f, 1.0f) * 0.5f;
            }
            float f = this.j;
            return (a.b(((float) (j - j3)) / this.k, 0.0f, 1.0f) * f) + (1.0f - f);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            a aVar = a.this;
            if (!aVar.p) {
                return;
            }
            if (aVar.n) {
                aVar.n = false;
                C0021a c0021a = aVar.f500b;
                c0021a.getClass();
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                c0021a.e = currentAnimationTimeMillis;
                c0021a.i = -1L;
                c0021a.f = currentAnimationTimeMillis;
                c0021a.j = 0.5f;
                c0021a.g = 0;
                c0021a.h = 0;
            }
            C0021a c0021a2 = a.this.f500b;
            if (!(c0021a2.i > 0 && AnimationUtils.currentAnimationTimeMillis() > c0021a2.i + ((long) c0021a2.k)) && a.this.e()) {
                a aVar2 = a.this;
                if (aVar2.o) {
                    aVar2.o = false;
                    aVar2.getClass();
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar2.d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (c0021a2.f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a = c0021a2.a(currentAnimationTimeMillis2);
                    c0021a2.f = currentAnimationTimeMillis2;
                    float f = ((float) (currentAnimationTimeMillis2 - c0021a2.f)) * ((a * 4.0f) + ((-4.0f) * a * a));
                    c0021a2.g = (int) (c0021a2.f503c * f);
                    int i = (int) (f * c0021a2.d);
                    c0021a2.h = i;
                    ListView listView = ((c) a.this).s;
                    if (Build.VERSION.SDK_INT >= 19) {
                        listView.scrollListBy(i);
                    } else {
                        int firstVisiblePosition = listView.getFirstVisiblePosition();
                        if (firstVisiblePosition != -1 && (childAt = listView.getChildAt(0)) != null) {
                            listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
                        }
                    }
                    View view = a.this.d;
                    AtomicInteger atomicInteger = q.a;
                    view.postOnAnimation(this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            a.this.p = false;
        }
    }

    public a(View view) {
        C0021a c0021a = new C0021a();
        this.f500b = c0021a;
        this.f501c = new AccelerateInterpolator();
        this.f = new float[]{0.0f, 0.0f};
        this.g = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.j = new float[]{0.0f, 0.0f};
        this.k = new float[]{0.0f, 0.0f};
        this.l = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.d = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.l;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr[0] = f2;
        fArr[1] = f2;
        float[] fArr2 = this.k;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f3;
        fArr2[1] = f3;
        this.h = 1;
        float[] fArr3 = this.g;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.j;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.i = r;
        c0021a.a = 500;
        c0021a.f502b = 500;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f
            r0 = r0[r4]
            float[] r1 = r3.g
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto L26
            android.view.animation.Interpolator r6 = r3.f501c
            float r5 = -r5
            float r5 = r6.getInterpolation(r5)
            float r5 = -r5
            goto L30
        L26:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L39
            android.view.animation.Interpolator r6 = r3.f501c
            float r5 = r6.getInterpolation(r5)
        L30:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L3a
        L39:
            r5 = 0
        L3a:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3f
            return r2
        L3f:
            float[] r6 = r3.j
            r6 = r6[r4]
            float[] r0 = r3.k
            r0 = r0[r4]
            float[] r1 = r3.l
            r4 = r1[r4]
            float r6 = r6 * r7
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 <= 0) goto L58
            float r5 = r5 * r6
            float r4 = b(r5, r0, r4)
            return r4
        L58:
            float r5 = -r5
            float r5 = r5 * r6
            float r4 = b(r5, r0, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.k.a.a(int, float, float, float):float");
    }

    public final float c(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.h;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.p && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.n) {
            this.p = false;
            return;
        }
        C0021a c0021a = this.f500b;
        c0021a.getClass();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - c0021a.e);
        int i3 = c0021a.f502b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        c0021a.k = i;
        c0021a.j = c0021a.a(currentAnimationTimeMillis);
        c0021a.i = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e() {
        /*
            r9 = this;
            b.h.k.a$a r0 = r9.f500b
            float r1 = r0.d
            float r2 = java.lang.Math.abs(r1)
            float r1 = r1 / r2
            int r1 = (int) r1
            float r0 = r0.f503c
            float r2 = java.lang.Math.abs(r0)
            float r0 = r0 / r2
            int r0 = (int) r0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L53
            r4 = r9
            b.h.k.c r4 = (b.h.k.c) r4
            android.widget.ListView r4 = r4.s
            int r5 = r4.getCount()
            if (r5 != 0) goto L23
        L21:
            r1 = 0
            goto L51
        L23:
            int r6 = r4.getChildCount()
            int r7 = r4.getFirstVisiblePosition()
            int r8 = r7 + r6
            if (r1 <= 0) goto L41
            if (r8 < r5) goto L50
            int r6 = r6 - r2
            android.view.View r1 = r4.getChildAt(r6)
            int r1 = r1.getBottom()
            int r4 = r4.getHeight()
            if (r1 > r4) goto L50
            goto L21
        L41:
            if (r1 >= 0) goto L21
            if (r7 > 0) goto L50
            android.view.View r1 = r4.getChildAt(r3)
            int r1 = r1.getTop()
            if (r1 < 0) goto L50
            goto L21
        L50:
            r1 = 1
        L51:
            if (r1 != 0) goto L54
        L53:
            r2 = 0
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.k.a.e():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L7f
        L16:
            r5.d()
            goto L7f
        L1a:
            r5.o = r2
            r5.m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            b.h.k.a$a r7 = r5.f500b
            r7.f503c = r0
            r7.d = r6
            boolean r6 = r5.p
            if (r6 != 0) goto L7f
            boolean r6 = r5.e()
            if (r6 == 0) goto L7f
            java.lang.Runnable r6 = r5.e
            if (r6 != 0) goto L61
            b.h.k.a$b r6 = new b.h.k.a$b
            r6.<init>()
            r5.e = r6
        L61:
            r5.p = r2
            r5.n = r2
            boolean r6 = r5.m
            if (r6 != 0) goto L78
            int r6 = r5.i
            if (r6 <= 0) goto L78
            android.view.View r7 = r5.d
            java.lang.Runnable r0 = r5.e
            long r3 = (long) r6
            java.util.concurrent.atomic.AtomicInteger r6 = b.h.j.q.a
            r7.postOnAnimationDelayed(r0, r3)
            goto L7d
        L78:
            java.lang.Runnable r6 = r5.e
            r6.run()
        L7d:
            r5.m = r2
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.k.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
