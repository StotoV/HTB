package c.c.a.a.z;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.TimePickerView;
/* loaded from: classes.dex */
public class e extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView a;

    public e(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView timePickerView = this.a;
        int i = TimePickerView.y;
        timePickerView.getClass();
        return onDoubleTap;
    }
}
