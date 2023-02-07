package c.c.a.a.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class e<V extends View> extends g<V> {

    /* renamed from: c  reason: collision with root package name */
    public Runnable f772c;
    public OverScroller d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public VelocityTracker i;

    /* JADX WARN: Field signature parse error: c
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TV at position 1 ('V'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:83)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:33)
     */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final CoordinatorLayout f773b;

        /* renamed from: c  reason: collision with root package name */
        public final View f774c;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.f773b = coordinatorLayout;
            this.f774c = v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f774c == null || (overScroller = e.this.d) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                e eVar = e.this;
                eVar.G(this.f773b, this.f774c, eVar.d.getCurrY());
                this.f774c.postOnAnimation(this);
                return;
            }
            e eVar2 = e.this;
            CoordinatorLayout coordinatorLayout = this.f773b;
            View view = this.f774c;
            AppBarLayout.BaseBehavior baseBehavior = (AppBarLayout.BaseBehavior) eVar2;
            baseBehavior.getClass();
            AppBarLayout appBarLayout = (AppBarLayout) view;
            baseBehavior.O(coordinatorLayout, appBarLayout);
            if (!appBarLayout.j) {
                return;
            }
            appBarLayout.c(appBarLayout.d(baseBehavior.K(coordinatorLayout)));
        }
    }

    public e() {
        this.f = -1;
        this.h = -1;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = -1;
        this.h = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean A(androidx.coordinatorlayout.widget.CoordinatorLayout r21, V r22, android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.d.e.A(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract int E();

    public final int F(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return H(coordinatorLayout, v, E() - i, i2, i3);
    }

    public int G(CoordinatorLayout coordinatorLayout, V v, int i) {
        return H(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public abstract int H(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        View view;
        int findPointerIndex;
        if (this.h < 0) {
            this.h = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.e) {
            int i = this.f;
            if (i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.g) > this.h) {
                this.g = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) v;
            WeakReference<View> weakReference = ((AppBarLayout.BaseBehavior) this).p;
            boolean z = (weakReference == null || ((view = weakReference.get()) != null && view.isShown() && !view.canScrollVertically(-1))) && coordinatorLayout.p(v, x, y2);
            this.e = z;
            if (z) {
                this.g = y2;
                this.f = motionEvent.getPointerId(0);
                if (this.i == null) {
                    this.i = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.d;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.d.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.i;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }
}
