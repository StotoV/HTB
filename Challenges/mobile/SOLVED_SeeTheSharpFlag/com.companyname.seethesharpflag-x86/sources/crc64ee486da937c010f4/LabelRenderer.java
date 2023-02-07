package crc64ee486da937c010f4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import crc643f46942d9dd1fff9.FormsTextView;
import java.util.ArrayList;
import mono.android.IGCUserPeer;
import mono.android.Runtime;
import mono.android.TypeManager;
/* loaded from: classes.dex */
public class LabelRenderer extends FormsTextView implements IGCUserPeer {
    public static final String __md_methods = "n_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\n";
    private ArrayList refList;

    private native void n_onLayout(boolean z, int i, int i2, int i3, int i4);

    private native boolean n_onTouchEvent(MotionEvent motionEvent);

    static {
        Runtime.register("Xamarin.Forms.Platform.Android.FastRenderers.LabelRenderer, Xamarin.Forms.Platform.Android", LabelRenderer.class, "n_onLayout:(ZIIII)V:GetOnLayout_ZIIIIHandler\nn_onTouchEvent:(Landroid/view/MotionEvent;)Z:GetOnTouchEvent_Landroid_view_MotionEvent_Handler\n");
    }

    public LabelRenderer(Context context) {
        super(context);
        if (getClass() == LabelRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FastRenderers.LabelRenderer, Xamarin.Forms.Platform.Android", "Android.Content.Context, Mono.Android", this, new Object[]{context});
        }
    }

    public LabelRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (getClass() == LabelRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FastRenderers.LabelRenderer, Xamarin.Forms.Platform.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android", this, new Object[]{context, attributeSet});
        }
    }

    public LabelRenderer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getClass() == LabelRenderer.class) {
            TypeManager.Activate("Xamarin.Forms.Platform.Android.FastRenderers.LabelRenderer, Xamarin.Forms.Platform.Android", "Android.Content.Context, Mono.Android:Android.Util.IAttributeSet, Mono.Android:System.Int32, mscorlib", this, new Object[]{context, attributeSet, Integer.valueOf(i)});
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        n_onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return n_onTouchEvent(motionEvent);
    }

    @Override // crc643f46942d9dd1fff9.FormsTextView, mono.android.IGCUserPeer
    public void monodroidAddReference(Object obj) {
        if (this.refList == null) {
            this.refList = new ArrayList();
        }
        this.refList.add(obj);
    }

    @Override // crc643f46942d9dd1fff9.FormsTextView, mono.android.IGCUserPeer
    public void monodroidClearReferences() {
        ArrayList arrayList = this.refList;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}