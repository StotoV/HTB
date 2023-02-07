package c.c.a.a.z;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;
/* loaded from: classes.dex */
public class f implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GestureDetector f926b;

    public f(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.f926b = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f926b.onTouchEvent(motionEvent);
        }
        return false;
    }
}
