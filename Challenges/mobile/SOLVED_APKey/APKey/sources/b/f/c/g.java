package b.f.c;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.b.h.d;
/* loaded from: classes.dex */
public class g extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f387b;

    /* renamed from: c  reason: collision with root package name */
    public View f388c;
    public int d;

    public void a() {
        if (this.f388c == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.f388c.getLayoutParams();
        aVar2.l0.c0 = 0;
        d.a m = aVar.l0.m();
        d.a aVar3 = d.a.FIXED;
        if (m != aVar3) {
            aVar.l0.M(aVar2.l0.r());
        }
        if (aVar.l0.q() != aVar3) {
            aVar.l0.H(aVar2.l0.l());
        }
        aVar2.l0.c0 = 8;
    }

    public View getContent() {
        return this.f388c;
    }

    public int getEmptyVisibility() {
        return this.d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f387b == i) {
            return;
        }
        View view = this.f388c;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.f388c.getLayoutParams()).a0 = false;
            this.f388c = null;
        }
        this.f387b = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.d = i;
    }
}
