package c.c.a.a.l;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.c.a.a.l.a;
import com.example.apkey.R;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public final class o<S> extends b.k.b.l {
    public static final /* synthetic */ int A0 = 0;
    public final LinkedHashSet<q<? super S>> j0 = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> k0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> l0 = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> m0 = new LinkedHashSet<>();
    public int n0;
    public d<S> o0;
    public x<S> p0;
    public c.c.a.a.l.a q0;
    public g<S> r0;
    public int s0;
    public CharSequence t0;
    public boolean u0;
    public int v0;
    public TextView w0;
    public CheckableImageButton x0;
    public c.c.a.a.u.g y0;
    public Button z0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<q<? super S>> it = o.this.j0.iterator();
            while (it.hasNext()) {
                it.next().a((S) o.this.o0.a());
            }
            o.this.t0(false, false);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator<View.OnClickListener> it = o.this.k0.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            o.this.t0(false, false);
        }
    }

    /* loaded from: classes.dex */
    public class c extends w<S> {
        public c() {
        }

        @Override // c.c.a.a.l.w
        public void a(S s) {
            o oVar = o.this;
            int i = o.A0;
            oVar.A0();
            o oVar2 = o.this;
            oVar2.z0.setEnabled(oVar2.o0.b());
        }
    }

    public static int w0(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar d = a0.d();
        d.set(5, 1);
        Calendar b2 = a0.b(d);
        b2.get(2);
        b2.get(1);
        int maximum = b2.getMaximum(7);
        b2.getActualMaximum(5);
        b2.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean x0(Context context) {
        return y0(context, 16843277);
    }

    public static boolean y0(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.c.a.a.a.r(context, R.attr.materialCalendarStyle, g.class.getCanonicalName()), new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void A0() {
        String d = this.o0.d(j());
        this.w0.setContentDescription(String.format(B(R.string.mtrl_picker_announce_current_selection), d));
        this.w0.setText(d);
    }

    public final void B0(CheckableImageButton checkableImageButton) {
        this.x0.setContentDescription(checkableImageButton.getContext().getString(this.x0.isChecked() ? R.string.mtrl_picker_toggle_to_calendar_input_mode : R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    @Override // b.k.b.l, b.k.b.m
    public final void L(Bundle bundle) {
        super.L(bundle);
        if (bundle == null) {
            bundle = this.g;
        }
        this.n0 = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.o0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.q0 = (c.c.a.a.l.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.s0 = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.t0 = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.v0 = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // b.k.b.m
    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.u0 ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.u0) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(w0(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(w0(context), -1));
            Resources resources = i0().getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
            int i = t.g;
            findViewById2.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.w0 = textView;
        b.h.j.q.G(textView, 1);
        this.x0 = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.t0;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.s0);
        }
        this.x0.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.x0;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, b.b.d.a.a.b(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], b.b.d.a.a.b(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.x0.setChecked(this.v0 != 0);
        b.h.j.q.F(this.x0, null);
        B0(this.x0);
        this.x0.setOnClickListener(new p(this));
        this.z0 = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.o0.b()) {
            this.z0.setEnabled(true);
        } else {
            this.z0.setEnabled(false);
        }
        this.z0.setTag("CONFIRM_BUTTON_TAG");
        this.z0.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // b.k.b.l, b.k.b.m
    public final void Z(Bundle bundle) {
        super.Z(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.n0);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.o0);
        a.b bVar = new a.b(this.q0);
        s sVar = this.r0.Y;
        if (sVar != null) {
            bVar.f795c = Long.valueOf(sVar.g);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", bVar.d);
        s l = s.l(bVar.a);
        s l2 = s.l(bVar.f794b);
        a.c cVar = (a.c) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l3 = bVar.f795c;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new c.c.a.a.l.a(l, l2, cVar, l3 == null ? null : s.l(l3.longValue()), null));
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.s0);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.t0);
    }

    @Override // b.k.b.l, b.k.b.m
    public void a0() {
        super.a0();
        Window window = v0().getWindow();
        if (this.u0) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.y0);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = x().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.y0, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new c.c.a.a.m.a(v0(), rect));
        }
        z0();
    }

    @Override // b.k.b.l, b.k.b.m
    public void b0() {
        this.p0.U.clear();
        this.D = true;
        Dialog dialog = this.f0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // b.k.b.l, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.l0.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
    }

    @Override // b.k.b.l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.m0.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.F;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // b.k.b.l
    public final Dialog u0(Bundle bundle) {
        Context i0 = i0();
        Context i02 = i0();
        int i = this.n0;
        if (i == 0) {
            i = this.o0.f(i02);
        }
        Dialog dialog = new Dialog(i0, i);
        Context context = dialog.getContext();
        this.u0 = x0(context);
        int r = c.c.a.a.a.r(context, R.attr.colorSurface, o.class.getCanonicalName());
        c.c.a.a.u.g gVar = new c.c.a.a.u.g(c.c.a.a.u.j.b(context, null, R.attr.materialCalendarStyle, 2131690126).a());
        this.y0 = gVar;
        gVar.f876b.f878b = new c.c.a.a.n.a(context);
        gVar.w();
        this.y0.p(ColorStateList.valueOf(r));
        this.y0.o(b.h.j.q.m(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public final void z0() {
        x<S> xVar;
        Context i0 = i0();
        int i = this.n0;
        if (i == 0) {
            i = this.o0.f(i0);
        }
        d<S> dVar = this.o0;
        c.c.a.a.l.a aVar = this.q0;
        g<S> gVar = new g<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        bundle.putParcelable("CURRENT_MONTH_KEY", aVar.e);
        gVar.n0(bundle);
        this.r0 = gVar;
        if (this.x0.isChecked()) {
            d<S> dVar2 = this.o0;
            c.c.a.a.l.a aVar2 = this.q0;
            xVar = new r<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dVar2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar2);
            xVar.n0(bundle2);
        } else {
            xVar = this.r0;
        }
        this.p0 = xVar;
        A0();
        b.k.b.a aVar3 = new b.k.b.a(i());
        aVar3.e(R.id.mtrl_calendar_frame, this.p0, null, 2);
        if (!aVar3.g) {
            aVar3.p.D(aVar3, false);
            this.p0.t0(new c());
            return;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }
}
