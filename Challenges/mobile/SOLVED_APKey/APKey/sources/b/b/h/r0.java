package b.b.h;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.example.apkey.R;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class r0 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static r0 k;
    public static r0 l;

    /* renamed from: b  reason: collision with root package name */
    public final View f265b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f266c;
    public final int d;
    public final Runnable e = new a();
    public final Runnable f = new b();
    public int g;
    public int h;
    public s0 i;
    public boolean j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r0.this.d(false);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r0.this.b();
        }
    }

    public r0(View view, CharSequence charSequence) {
        this.f265b = view;
        this.f266c = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = b.h.j.w.a;
        this.d = Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / 2;
        a();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void c(r0 r0Var) {
        r0 r0Var2 = k;
        if (r0Var2 != null) {
            r0Var2.f265b.removeCallbacks(r0Var2.e);
        }
        k = r0Var;
        if (r0Var != null) {
            r0Var.f265b.postDelayed(r0Var.e, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        this.g = Integer.MAX_VALUE;
        this.h = Integer.MAX_VALUE;
    }

    public void b() {
        if (l == this) {
            l = null;
            s0 s0Var = this.i;
            if (s0Var != null) {
                s0Var.a();
                this.i = null;
                a();
                this.f265b.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            c(null);
        }
        this.f265b.removeCallbacks(this.f);
    }

    public void d(boolean z) {
        int height;
        int i;
        long longPressTimeout;
        if (!b.h.j.q.t(this.f265b)) {
            return;
        }
        c(null);
        r0 r0Var = l;
        if (r0Var != null) {
            r0Var.b();
        }
        l = this;
        this.j = z;
        s0 s0Var = new s0(this.f265b.getContext());
        this.i = s0Var;
        View view = this.f265b;
        int i2 = this.g;
        int i3 = this.h;
        boolean z2 = this.j;
        CharSequence charSequence = this.f266c;
        if (s0Var.f271b.getParent() != null) {
            s0Var.a();
        }
        s0Var.f272c.setText(charSequence);
        WindowManager.LayoutParams layoutParams = s0Var.d;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = s0Var.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i2 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = s0Var.a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i3 + dimensionPixelOffset2;
            i = i3 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = s0Var.a.getResources().getDimensionPixelOffset(z2 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
        if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
            Context context = view.getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                } else if (context instanceof Activity) {
                    rootView = ((Activity) context).getWindow().getDecorView();
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
        }
        if (rootView == null) {
            Log.e("TooltipPopup", "Cannot find app view");
        } else {
            rootView.getWindowVisibleDisplayFrame(s0Var.e);
            Rect rect = s0Var.e;
            if (rect.left < 0 && rect.top < 0) {
                Resources resources = s0Var.a.getResources();
                int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                s0Var.e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            rootView.getLocationOnScreen(s0Var.g);
            view.getLocationOnScreen(s0Var.f);
            int[] iArr = s0Var.f;
            int i4 = iArr[0];
            int[] iArr2 = s0Var.g;
            iArr[0] = i4 - iArr2[0];
            iArr[1] = iArr[1] - iArr2[1];
            layoutParams.x = (iArr[0] + i2) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            s0Var.f271b.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = s0Var.f271b.getMeasuredHeight();
            int[] iArr3 = s0Var.f;
            int i5 = ((iArr3[1] + i) - dimensionPixelOffset3) - measuredHeight;
            int i6 = iArr3[1] + height + dimensionPixelOffset3;
            if (!z2 ? measuredHeight + i6 > s0Var.e.height() : i5 >= 0) {
                layoutParams.y = i5;
            } else {
                layoutParams.y = i6;
            }
        }
        ((WindowManager) s0Var.a.getSystemService("window")).addView(s0Var.f271b, s0Var.d);
        this.f265b.addOnAttachStateChangeListener(this);
        if (this.j) {
            longPressTimeout = 2500;
        } else {
            longPressTimeout = ((this.f265b.getWindowSystemUiVisibility() & 1) == 1 ? 3000L : 15000L) - ViewConfiguration.getLongPressTimeout();
        }
        this.f265b.removeCallbacks(this.f);
        this.f265b.postDelayed(this.f, longPressTimeout);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.i == null || !this.j) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f265b.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    a();
                    b();
                }
            } else if (this.f265b.isEnabled() && this.i == null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (Math.abs(x - this.g) > this.d || Math.abs(y - this.h) > this.d) {
                    this.g = x;
                    this.h = y;
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c(this);
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        d(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
