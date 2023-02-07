package b.b.h;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import com.example.apkey.R;
/* loaded from: classes.dex */
public abstract class a extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    public final C0008a f198b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f199c;
    public ActionMenuView d;
    public c e;
    public int f;
    public b.h.j.x g;
    public boolean h;
    public boolean i;

    /* renamed from: b.b.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0008a implements b.h.j.y {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f200b;

        public C0008a() {
        }

        @Override // b.h.j.y
        public void a(View view) {
            if (this.a) {
                return;
            }
            a aVar = a.this;
            aVar.g = null;
            a.super.setVisibility(this.f200b);
        }

        @Override // b.h.j.y
        public void b(View view) {
            a.super.setVisibility(0);
            this.a = false;
        }

        @Override // b.h.j.y
        public void c(View view) {
            this.a = true;
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f198b = new C0008a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f199c = context;
        } else {
            this.f199c = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int d(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public int getAnimatedVisibility() {
        return this.g != null ? this.f198b.f200b : getVisibility();
    }

    public int getContentHeight() {
        return this.f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, b.b.b.a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        c cVar = this.e;
        if (cVar != null) {
            Configuration configuration2 = cVar.f169c.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            cVar.q = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            b.b.g.e.f fVar = cVar.d;
            if (fVar == null) {
                return;
            }
            fVar.p(true);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.i = false;
        }
        if (!this.i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.h = false;
        }
        if (!this.h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            b.h.j.x xVar = this.g;
            if (xVar != null) {
                xVar.a();
            }
            super.setVisibility(i);
        }
    }
}
