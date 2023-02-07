package b.f.c;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public abstract class j extends b {
    public boolean i;
    public boolean j;

    @Override // b.f.c.b
    public void f(AttributeSet attributeSet) {
        super.f(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f389b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 6) {
                    this.i = true;
                } else if (index == 13) {
                    this.j = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void l() {
    }

    @Override // b.f.c.b, android.view.View
    public void onAttachedToWindow() {
        ViewParent parent;
        super.onAttachedToWindow();
        if ((this.i || this.j) && (parent = getParent()) != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
            for (int i = 0; i < this.f368c; i++) {
                View d = constraintLayout.d(this.f367b[i]);
                if (d != null) {
                    if (this.i) {
                        d.setVisibility(visibility);
                    }
                    if (this.j && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                        d.setTranslationZ(d.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        d();
    }
}
