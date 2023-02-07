package c.c.a.a.m;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final Dialog f831b;

    /* renamed from: c  reason: collision with root package name */
    public final int f832c;
    public final int d;
    public final int e;

    public a(Dialog dialog, Rect rect) {
        this.f831b = dialog;
        this.f832c = rect.left;
        this.d = rect.top;
        this.e = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.f832c;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.d;
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.e;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.f831b.onTouchEvent(obtain);
    }
}
