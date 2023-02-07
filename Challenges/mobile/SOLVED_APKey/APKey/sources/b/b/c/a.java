package b.b.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: b.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0003a extends ViewGroup.MarginLayoutParams {
        public int a;

        public C0003a(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.a = 8388627;
        }

        public C0003a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.b.b.f132b);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public C0003a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }

        public C0003a(C0003a c0003a) {
            super((ViewGroup.MarginLayoutParams) c0003a);
            this.a = 0;
            this.a = c0003a.a;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a();
    }
}
