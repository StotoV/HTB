package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.f.c.d;
import b.h.j.q;
import c.c.a.a.z.d;
import c.c.a.a.z.e;
import c.c.a.a.z.f;
import com.example.apkey.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
/* loaded from: classes.dex */
public class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int y = 0;
    public final Chip u;
    public final Chip v;
    public final MaterialButtonToggleGroup w;
    public final View.OnClickListener x;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimePickerView timePickerView = TimePickerView.this;
            int i = TimePickerView.y;
            timePickerView.getClass();
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.x = aVar;
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        ClockFaceView clockFaceView = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.w = materialButtonToggleGroup;
        materialButtonToggleGroup.e.add(new d(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.u = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.v = chip2;
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        f fVar = new f(this, new GestureDetector(getContext(), new e(this)));
        chip.setOnTouchListener(fVar);
        chip2.setOnTouchListener(fVar);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
    }

    public final void k() {
        if (this.w.getVisibility() == 0) {
            b.f.c.d dVar = new b.f.c.d();
            dVar.b(this);
            char c2 = q.o(this) == 0 ? (char) 2 : (char) 1;
            if (dVar.f375c.containsKey(Integer.valueOf((int) R.id.material_clock_display))) {
                d.a aVar = dVar.f375c.get(Integer.valueOf((int) R.id.material_clock_display));
                switch (c2) {
                    case 1:
                        d.b bVar = aVar.d;
                        bVar.i = -1;
                        bVar.h = -1;
                        bVar.D = -1;
                        bVar.J = -1;
                        break;
                    case 2:
                        d.b bVar2 = aVar.d;
                        bVar2.k = -1;
                        bVar2.j = -1;
                        bVar2.E = -1;
                        bVar2.L = -1;
                        break;
                    case 3:
                        d.b bVar3 = aVar.d;
                        bVar3.m = -1;
                        bVar3.l = -1;
                        bVar3.F = -1;
                        bVar3.K = -1;
                        break;
                    case 4:
                        d.b bVar4 = aVar.d;
                        bVar4.n = -1;
                        bVar4.o = -1;
                        bVar4.G = -1;
                        bVar4.M = -1;
                        break;
                    case 5:
                        aVar.d.p = -1;
                        break;
                    case 6:
                        d.b bVar5 = aVar.d;
                        bVar5.q = -1;
                        bVar5.r = -1;
                        bVar5.I = -1;
                        bVar5.O = -1;
                        break;
                    case 7:
                        d.b bVar6 = aVar.d;
                        bVar6.s = -1;
                        bVar6.t = -1;
                        bVar6.H = -1;
                        bVar6.N = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            dVar.a(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            k();
        }
    }
}
