package c.c.a.a.y.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import b.b.g.b;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class a {
    public static final int[] a = {16842752, R.attr.theme};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f923b = {R.attr.materialThemeOverlay};

    public static Context a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f923b, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        boolean z = (context instanceof b) && ((b) context).a == resourceId;
        if (resourceId == 0 || z) {
            return context;
        }
        b bVar = new b(context, resourceId);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a);
        int resourceId2 = obtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = obtainStyledAttributes2.getResourceId(1, 0);
        obtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            bVar.getTheme().applyStyle(resourceId2, true);
        }
        return bVar;
    }
}
