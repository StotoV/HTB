package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
/* loaded from: classes.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    private static final int DEF_STYLE_ATTR = R.attr.alertDialogStyle;
    private static final int DEF_STYLE_RES = R.style.MaterialAlertDialog_MaterialComponents;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R.attr.materialAlertDialogTheme;
    private Drawable background;
    private final Rect backgroundInsets;

    private static int getMaterialAlertDialogThemeOverlay(Context context) {
        TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private static Context createMaterialAlertDialogThemedContext(Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context wrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? wrap : new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    private static int getOverridingThemeResId(Context context, int i) {
        return i == 0 ? getMaterialAlertDialogThemeOverlay(context) : i;
    }

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(Context context, int i) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i2 = DEF_STYLE_ATTR;
        int i3 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, i2, i3);
        int color = MaterialColors.getColor(context2, R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, i2, i3);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(ViewCompat.getElevation(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.backgroundInsets));
        return create;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public MaterialAlertDialogBuilder setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int i) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i;
        } else {
            this.backgroundInsets.left = i;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int i) {
        this.backgroundInsets.top = i;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int i) {
        if (Build.VERSION.SDK_INT >= 17 && getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i;
        } else {
            this.backgroundInsets.right = i;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int i) {
        this.backgroundInsets.bottom = i;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setTitle  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo228setTitle(int i) {
        return (MaterialAlertDialogBuilder) super.mo228setTitle(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setTitle  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo229setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.mo229setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setCustomTitle  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo200setCustomTitle(View view) {
        return (MaterialAlertDialogBuilder) super.mo200setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setMessage  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo206setMessage(int i) {
        return (MaterialAlertDialogBuilder) super.mo206setMessage(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setMessage  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo207setMessage(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.mo207setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setIcon  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo201setIcon(int i) {
        return (MaterialAlertDialogBuilder) super.mo201setIcon(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setIcon  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo202setIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.mo202setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setIconAttribute  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo203setIconAttribute(int i) {
        return (MaterialAlertDialogBuilder) super.mo203setIconAttribute(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setPositiveButton  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo221setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo221setPositiveButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setPositiveButton  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo222setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo222setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setPositiveButtonIcon  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo223setPositiveButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.mo223setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setNegativeButton  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo211setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo211setNegativeButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setNegativeButton  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo212setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo212setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setNegativeButtonIcon  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo213setNegativeButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.mo213setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setNeutralButton  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo214setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo214setNeutralButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setNeutralButton  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo215setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo215setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setNeutralButtonIcon  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo216setNeutralButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.mo216setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setCancelable  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo198setCancelable(boolean z) {
        return (MaterialAlertDialogBuilder) super.mo198setCancelable(z);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setOnCancelListener  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo217setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.mo217setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setOnDismissListener  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo218setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.mo218setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setOnKeyListener  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo220setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.mo220setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo204setItems(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo204setItems(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo205setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo205setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setAdapter  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo197setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo197setAdapter(listAdapter, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setCursor  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo199setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (MaterialAlertDialogBuilder) super.mo199setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setMultiChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo208setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.mo208setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setMultiChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo210setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.mo210setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setMultiChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo209setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.mo209setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setSingleChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo224setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo224setSingleChoiceItems(i, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setSingleChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo225setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo225setSingleChoiceItems(cursor, i, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setSingleChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo227setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo227setSingleChoiceItems(charSequenceArr, i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setSingleChoiceItems  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo226setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.mo226setSingleChoiceItems(listAdapter, i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setOnItemSelectedListener  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo219setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.mo219setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setView  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo230setView(int i) {
        return (MaterialAlertDialogBuilder) super.mo230setView(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* renamed from: setView  reason: collision with other method in class */
    public MaterialAlertDialogBuilder mo231setView(View view) {
        return (MaterialAlertDialogBuilder) super.mo231setView(view);
    }
}
