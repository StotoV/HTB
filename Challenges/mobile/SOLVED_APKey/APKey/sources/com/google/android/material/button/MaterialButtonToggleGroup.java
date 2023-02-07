package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import b.h.j.c0.b;
import b.h.j.q;
import c.c.a.a.q.k;
import c.c.a.a.u.j;
import com.example.apkey.R;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String l = MaterialButtonToggleGroup.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final List<d> f947b;

    /* renamed from: c  reason: collision with root package name */
    public final c f948c;
    public final f d;
    public final LinkedHashSet<e> e;
    public final Comparator<MaterialButton> f;
    public Integer[] g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;

    /* loaded from: classes.dex */
    public class a implements Comparator<MaterialButton> {
        public a() {
        }

        @Override // java.util.Comparator
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int compareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton3)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton4)));
        }
    }

    /* loaded from: classes.dex */
    public class b extends b.h.j.a {
        public b() {
        }

        @Override // b.h.j.a
        public void d(View view, b.h.j.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            String str = MaterialButtonToggleGroup.l;
            materialButtonToggleGroup.getClass();
            int i = -1;
            if (view instanceof MaterialButton) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= materialButtonToggleGroup.getChildCount()) {
                        break;
                    } else if (materialButtonToggleGroup.getChildAt(i2) == view) {
                        i = i3;
                        break;
                    } else {
                        if ((materialButtonToggleGroup.getChildAt(i2) instanceof MaterialButton) && materialButtonToggleGroup.d(i2)) {
                            i3++;
                        }
                        i2++;
                    }
                }
            }
            bVar.j(b.c.a(0, 1, i, 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* loaded from: classes.dex */
    public class c implements MaterialButton.a {
        public c(a aVar) {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (materialButtonToggleGroup.h) {
                return;
            }
            if (materialButtonToggleGroup.i) {
                materialButtonToggleGroup.k = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.f(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.b(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static final c.c.a.a.u.c e = new c.c.a.a.u.a(0.0f);
        public c.c.a.a.u.c a;

        /* renamed from: b  reason: collision with root package name */
        public c.c.a.a.u.c f949b;

        /* renamed from: c  reason: collision with root package name */
        public c.c.a.a.u.c f950c;
        public c.c.a.a.u.c d;

        public d(c.c.a.a.u.c cVar, c.c.a.a.u.c cVar2, c.c.a.a.u.c cVar3, c.c.a.a.u.c cVar4) {
            this.a = cVar;
            this.f949b = cVar3;
            this.f950c = cVar4;
            this.d = cVar2;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    /* loaded from: classes.dex */
    public class f implements MaterialButton.b {
        public f(a aVar) {
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(c.c.a.a.y.a.a.a(context, attributeSet, R.attr.materialButtonToggleGroupStyle, 2131690125), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.f947b = new ArrayList();
        this.f948c = new c(null);
        this.d = new f(null);
        this.e = new LinkedHashSet<>();
        this.f = new a();
        this.h = false;
        TypedArray d2 = k.d(getContext(), attributeSet, c.c.a.a.b.m, R.attr.materialButtonToggleGroupStyle, 2131690125, new int[0]);
        setSingleSelection(d2.getBoolean(2, false));
        this.k = d2.getResourceId(0, -1);
        this.j = d2.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        d2.recycle();
        q.I(this, 1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (d(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && d(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setCheckedId(int i) {
        this.k = i;
        b(i, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(q.g());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.e.add(this.f948c);
        materialButton.setOnPressedChangeListenerInternal(this.d);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton c2 = c(i);
            int min = Math.min(c2.getStrokeWidth(), c(i - 1).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                b.h.b.a.a0(layoutParams2, 0);
                b.h.b.a.b0(layoutParams2, -min);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -min;
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams2.setMarginStart(0);
                } else {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = 0;
                }
            }
            c2.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
            return;
        }
        b.h.b.a.a0(layoutParams3, 0);
        b.h.b.a.b0(layoutParams3, 0);
        layoutParams3.leftMargin = 0;
        layoutParams3.rightMargin = 0;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(l, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            f(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        j shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f947b.add(new d(shapeAppearanceModel.e, shapeAppearanceModel.h, shapeAppearanceModel.f, shapeAppearanceModel.g));
        q.F(materialButton, new b());
    }

    public final void b(int i, boolean z) {
        Iterator<e> it = this.e.iterator();
        while (it.hasNext()) {
            it.next().a(this, i, z);
        }
    }

    public final MaterialButton c(int i) {
        return (MaterialButton) getChildAt(i);
    }

    public final boolean d(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(c(i), Integer.valueOf(i));
        }
        this.g = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof MaterialButton) {
            this.h = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.h = false;
        }
    }

    public final boolean f(int i, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.j && checkedButtonIds.isEmpty()) {
            e(i, true);
            this.k = i;
            return false;
        }
        if (z && this.i) {
            checkedButtonIds.remove(Integer.valueOf(i));
            for (Integer num : checkedButtonIds) {
                int intValue = num.intValue();
                e(intValue, false);
                b(intValue, false);
            }
        }
        return true;
    }

    public void g() {
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton c2 = c(i);
            if (c2.getVisibility() != 8) {
                j shapeAppearanceModel = c2.getShapeAppearanceModel();
                shapeAppearanceModel.getClass();
                j.b bVar = new j.b(shapeAppearanceModel);
                d dVar2 = this.f947b.get(i);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    if (i == firstVisibleChildIndex) {
                        if (z) {
                            if (c.c.a.a.a.k(this)) {
                                c.c.a.a.u.c cVar = d.e;
                                dVar = new d(cVar, cVar, dVar2.f949b, dVar2.f950c);
                            } else {
                                c.c.a.a.u.c cVar2 = dVar2.a;
                                c.c.a.a.u.c cVar3 = dVar2.d;
                                c.c.a.a.u.c cVar4 = d.e;
                                dVar = new d(cVar2, cVar3, cVar4, cVar4);
                            }
                        } else {
                            c.c.a.a.u.c cVar5 = dVar2.a;
                            c.c.a.a.u.c cVar6 = d.e;
                            dVar = new d(cVar5, cVar6, dVar2.f949b, cVar6);
                        }
                    } else if (i != lastVisibleChildIndex) {
                        dVar2 = null;
                    } else if (z) {
                        if (c.c.a.a.a.k(this)) {
                            c.c.a.a.u.c cVar7 = dVar2.a;
                            c.c.a.a.u.c cVar8 = dVar2.d;
                            c.c.a.a.u.c cVar9 = d.e;
                            dVar = new d(cVar7, cVar8, cVar9, cVar9);
                        } else {
                            c.c.a.a.u.c cVar10 = d.e;
                            dVar = new d(cVar10, cVar10, dVar2.f949b, dVar2.f950c);
                        }
                    } else {
                        c.c.a.a.u.c cVar11 = d.e;
                        dVar = new d(cVar11, dVar2.d, cVar11, dVar2.f950c);
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    bVar.c(0.0f);
                } else {
                    bVar.e = dVar2.a;
                    bVar.h = dVar2.d;
                    bVar.f = dVar2.f949b;
                    bVar.g = dVar2.f950c;
                }
                c2.setShapeAppearanceModel(bVar.a());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.i) {
            return this.k;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton c2 = c(i);
            if (c2.isChecked()) {
                arrayList.add(Integer.valueOf(c2.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.g;
        if (numArr == null || i2 >= numArr.length) {
            Log.w(l, "Child order wasn't updated");
            return i2;
        }
        return numArr[i2].intValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.k;
        if (i != -1) {
            e(i, true);
            f(i, true);
            setCheckedId(i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        b.C0019b a2 = b.C0019b.a(1, getVisibleButtonCount(), false, this.i ? 1 : 2);
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) a2.a);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        g();
        a();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.e.remove(this.f948c);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f947b.remove(indexOfChild);
        }
        g();
        a();
    }

    public void setSelectionRequired(boolean z) {
        this.j = z;
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        if (this.i != z) {
            this.i = z;
            this.h = true;
            for (int i = 0; i < getChildCount(); i++) {
                MaterialButton c2 = c(i);
                c2.setChecked(false);
                b(c2.getId(), false);
            }
            this.h = false;
            setCheckedId(-1);
        }
    }
}
