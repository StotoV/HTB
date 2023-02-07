package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import b.b.b;
import b.b.g.e.g;
import b.b.g.e.l;
import b.b.h.o0;
import b.h.j.q;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements l.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    public g f12b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f13c;
    public RadioButton d;
    public TextView e;
    public CheckBox f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public LinearLayout j;
    public Drawable k;
    public int l;
    public Context m;
    public boolean n;
    public Drawable o;
    public boolean p;
    public LayoutInflater q;
    public boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        o0 p = o0.p(getContext(), attributeSet, b.q, R.attr.listMenuViewStyle, 0);
        this.k = p.g(5);
        this.l = p.k(1, -1);
        this.n = p.a(7, false);
        this.m = context;
        this.o = p.g(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.p = obtainStyledAttributes.hasValue(0);
        p.f252b.recycle();
        obtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from(getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public final void a() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f = checkBox;
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(checkBox, -1);
        } else {
            addView(checkBox, -1);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        rect.top = this.i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    public final void b() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.d = radioButton;
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            linearLayout.addView(radioButton, -1);
        } else {
            addView(radioButton, -1);
        }
    }

    @Override // b.b.g.e.l.a
    public void c(g gVar, int i) {
        this.f12b = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.e);
        setCheckable(gVar.isCheckable());
        boolean m = gVar.m();
        gVar.e();
        d(m);
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.q);
    }

    public void d(boolean z) {
        int i;
        String sb;
        int i2 = (!z || !this.f12b.m()) ? 8 : 0;
        if (i2 == 0) {
            TextView textView = this.g;
            g gVar = this.f12b;
            char e = gVar.e();
            if (e == 0) {
                sb = "";
            } else {
                Resources resources = gVar.n.a.getResources();
                StringBuilder sb2 = new StringBuilder();
                if (ViewConfiguration.get(gVar.n.a).hasPermanentMenuKey()) {
                    sb2.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i3 = gVar.n.m() ? gVar.k : gVar.i;
                g.c(sb2, i3, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                g.c(sb2, i3, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                g.c(sb2, i3, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                g.c(sb2, i3, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                g.c(sb2, i3, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                g.c(sb2, i3, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (e == '\b') {
                    i = R.string.abc_menu_delete_shortcut_label;
                } else if (e == '\n') {
                    i = R.string.abc_menu_enter_shortcut_label;
                } else if (e != ' ') {
                    sb2.append(e);
                    sb = sb2.toString();
                } else {
                    i = R.string.abc_menu_space_shortcut_label;
                }
                sb2.append(resources.getString(i));
                sb = sb2.toString();
            }
            textView.setText(sb);
        }
        if (this.g.getVisibility() != i2) {
            this.g.setVisibility(i2);
        }
    }

    @Override // b.b.g.e.l.a
    public g getItemData() {
        return this.f12b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable = this.k;
        AtomicInteger atomicInteger = q.a;
        setBackground(drawable);
        TextView textView = (TextView) findViewById(R.id.title);
        this.e = textView;
        int i = this.l;
        if (i != -1) {
            textView.setTextAppearance(this.m, i);
        }
        this.g = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.o);
        }
        this.i = (ImageView) findViewById(R.id.group_divider);
        this.j = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f13c != null && this.n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f13c.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.d == null && this.f == null) {
            return;
        }
        if (this.f12b.h()) {
            if (this.d == null) {
                b();
            }
            compoundButton = this.d;
            compoundButton2 = this.f;
        } else {
            if (this.f == null) {
                a();
            }
            compoundButton = this.f;
            compoundButton2 = this.d;
        }
        if (z) {
            compoundButton.setChecked(this.f12b.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.d;
        if (radioButton == null) {
            return;
        }
        radioButton.setVisibility(8);
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f12b.h()) {
            if (this.d == null) {
                b();
            }
            compoundButton = this.d;
        } else {
            if (this.f == null) {
                a();
            }
            compoundButton = this.f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.r = z;
        this.n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.i;
        if (imageView != null) {
            imageView.setVisibility((this.p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f12b.n.getClass();
        boolean z = this.r;
        if (z || this.n) {
            ImageView imageView = this.f13c;
            if (imageView == null && drawable == null && !this.n) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f13c = imageView2;
                LinearLayout linearLayout = this.j;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.n) {
                this.f13c.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f13c;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f13c.getVisibility() == 0) {
                return;
            }
            this.f13c.setVisibility(0);
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence != null) {
            this.e.setText(charSequence);
            if (this.e.getVisibility() == 0) {
                return;
            }
            textView = this.e;
            i = 0;
        } else {
            i = 8;
            if (this.e.getVisibility() == 8) {
                return;
            }
            textView = this.e;
        }
        textView.setVisibility(i);
    }
}
