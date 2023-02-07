package c.c.a.a.x;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;
/* loaded from: classes.dex */
public class j implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AutoCompleteTextView f911b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ h f912c;

    public j(h hVar, AutoCompleteTextView autoCompleteTextView) {
        this.f912c = hVar;
        this.f911b = autoCompleteTextView;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f912c.j()) {
                this.f912c.i = false;
            }
            h.h(this.f912c, this.f911b);
        }
        return false;
    }
}
