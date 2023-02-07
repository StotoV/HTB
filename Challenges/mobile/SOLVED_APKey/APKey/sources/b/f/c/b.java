package b.f.c;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class b extends View {

    /* renamed from: b  reason: collision with root package name */
    public int[] f367b;

    /* renamed from: c  reason: collision with root package name */
    public int f368c;
    public Context d;
    public b.f.b.h.g e;
    public String f;
    public String g;
    public HashMap<Integer, String> h;

    public b(Context context) {
        super(context);
        this.f367b = new int[32];
        this.h = new HashMap<>();
        this.d = context;
        f(null);
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f367b = new int[32];
        this.h = new HashMap<>();
        this.d = context;
        f(attributeSet);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.d == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        ConstraintLayout constraintLayout2 = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout2 != null) {
            Object c2 = constraintLayout2.c(0, trim);
            if (c2 instanceof Integer) {
                i = ((Integer) c2).intValue();
            }
        }
        if (i == 0 && constraintLayout2 != null) {
            i = e(constraintLayout2, trim);
        }
        if (i == 0) {
            try {
                i = h.class.getField(trim).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i == 0) {
            i = this.d.getResources().getIdentifier(trim, "id", this.d.getPackageName());
        }
        if (i != 0) {
            this.h.put(Integer.valueOf(i), trim);
            b(i);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final void b(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.f368c + 1;
        int[] iArr = this.f367b;
        if (i2 > iArr.length) {
            this.f367b = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f367b;
        int i3 = this.f368c;
        iArr2[i3] = i;
        this.f368c = i3 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.d == null) {
            return;
        }
        String trim = str.trim();
        ConstraintLayout constraintLayout = null;
        if (getParent() instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) getParent();
        }
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.a) && trim.equals(((ConstraintLayout.a) layoutParams).U)) {
                if (childAt.getId() == -1) {
                    StringBuilder g = c.a.a.a.a.g("to use ConstraintTag view ");
                    g.append(childAt.getClass().getSimpleName());
                    g.append(" must have an ID");
                    Log.w("ConstraintHelper", g.toString());
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public void d() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i = 0; i < this.f368c; i++) {
            View d = constraintLayout.d(this.f367b[i]);
            if (d != null) {
                d.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    d.setTranslationZ(d.getTranslationZ() + elevation);
                }
            }
        }
    }

    public final int e(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void f(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f389b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 19) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f = string;
                    setIds(string);
                } else if (index == 20) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void g(b.f.b.h.d dVar, boolean z) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f367b, this.f368c);
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
        if (this.e == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.a)) {
            return;
        }
        ((ConstraintLayout.a) layoutParams).l0 = (b.f.b.h.d) this.e;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.f = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f368c = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                a(str.substring(i));
                return;
            } else {
                a(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.g = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f368c = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                c(str.substring(i));
                return;
            } else {
                c(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f = null;
        this.f368c = 0;
        for (int i : iArr) {
            b(i);
        }
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        super.setTag(i, obj);
        if (obj == null && this.f == null) {
            b(i);
        }
    }
}
