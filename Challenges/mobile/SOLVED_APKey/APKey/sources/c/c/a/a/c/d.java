package c.c.a.a.c;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class d extends Property<Drawable, Integer> {

    /* renamed from: b  reason: collision with root package name */
    public static final Property<Drawable, Integer> f761b = new d();
    public final WeakHashMap<Drawable, Integer> a;

    public d() {
        super(Integer.class, "drawableAlphaCompat");
        this.a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    public Integer get(Drawable drawable) {
        int i;
        Drawable drawable2 = drawable;
        if (Build.VERSION.SDK_INT >= 19) {
            i = drawable2.getAlpha();
        } else if (this.a.containsKey(drawable2)) {
            return this.a.get(drawable2);
        } else {
            i = 255;
        }
        return Integer.valueOf(i);
    }

    @Override // android.util.Property
    public void set(Drawable drawable, Integer num) {
        Drawable drawable2 = drawable;
        Integer num2 = num;
        if (Build.VERSION.SDK_INT < 19) {
            this.a.put(drawable2, num2);
        }
        drawable2.setAlpha(num2.intValue());
    }
}
