package b.b.h;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import b.b.h.f0;
import com.example.apkey.R;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static final PorterDuff.Mode f226b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c  reason: collision with root package name */
    public static i f227c;
    public f0 a;

    /* loaded from: classes.dex */
    public class a implements f0.f {
        public final int[] a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b  reason: collision with root package name */
        public final int[] f228b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c  reason: collision with root package name */
        public final int[] f229c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        public final int[] d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        public final int[] e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        public final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public final boolean a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public final ColorStateList b(Context context, int i) {
            int c2 = k0.c(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{k0.f240b, k0.d, k0.f241c, k0.f}, new int[]{k0.b(context, R.attr.colorButtonNormal), b.h.d.a.a(c2, i), b.h.d.a.a(c2, i), i});
        }

        public final LayerDrawable c(f0 f0Var, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable f = f0Var.f(context, R.drawable.abc_star_black_48dp);
            Drawable f2 = f0Var.f(context, R.drawable.abc_star_half_black_48dp);
            if ((f instanceof BitmapDrawable) && f.getIntrinsicWidth() == dimensionPixelSize && f.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) f;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                f.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                f.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((f2 instanceof BitmapDrawable) && f2.getIntrinsicWidth() == dimensionPixelSize && f2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) f2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                f2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                f2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public ColorStateList d(Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return b.b.d.a.a.a(context, R.color.abc_tint_edittext);
            }
            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                return b.b.d.a.a.a(context, R.color.abc_tint_switch_track);
            }
            if (i == R.drawable.abc_switch_thumb_material) {
                int[][] iArr = new int[3];
                int[] iArr2 = new int[3];
                ColorStateList d = k0.d(context, R.attr.colorSwitchThumbNormal);
                if (d == null || !d.isStateful()) {
                    iArr[0] = k0.f240b;
                    iArr2[0] = k0.b(context, R.attr.colorSwitchThumbNormal);
                    iArr[1] = k0.e;
                    iArr2[1] = k0.c(context, R.attr.colorControlActivated);
                    iArr[2] = k0.f;
                    iArr2[2] = k0.c(context, R.attr.colorSwitchThumbNormal);
                } else {
                    iArr[0] = k0.f240b;
                    iArr2[0] = d.getColorForState(iArr[0], 0);
                    iArr[1] = k0.e;
                    iArr2[1] = k0.c(context, R.attr.colorControlActivated);
                    iArr[2] = k0.f;
                    iArr2[2] = d.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return b(context, k0.c(context, R.attr.colorButtonNormal));
            } else {
                if (i == R.drawable.abc_btn_borderless_material) {
                    return b(context, 0);
                }
                if (i == R.drawable.abc_btn_colored_material) {
                    return b(context, k0.c(context, R.attr.colorAccent));
                }
                if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                    return b.b.d.a.a.a(context, R.color.abc_tint_spinner);
                }
                if (a(this.f228b, i)) {
                    return k0.d(context, R.attr.colorControlNormal);
                }
                if (a(this.e, i)) {
                    return b.b.d.a.a.a(context, R.color.abc_tint_default);
                }
                if (a(this.f, i)) {
                    return b.b.d.a.a.a(context, R.color.abc_tint_btn_checkable);
                }
                if (i != R.drawable.abc_seekbar_thumb_material) {
                    return null;
                }
                return b.b.d.a.a.a(context, R.color.abc_tint_seek_thumb);
            }
        }

        public final void e(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (w.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = i.f226b;
            }
            drawable.setColorFilter(i.c(i, mode));
        }
    }

    public static synchronized i a() {
        i iVar;
        synchronized (i.class) {
            if (f227c == null) {
                e();
            }
            iVar = f227c;
        }
        return iVar;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter h;
        synchronized (i.class) {
            h = f0.h(i, mode);
        }
        return h;
    }

    public static synchronized void e() {
        synchronized (i.class) {
            if (f227c == null) {
                i iVar = new i();
                f227c = iVar;
                iVar.a = f0.d();
                f0 f0Var = f227c.a;
                a aVar = new a();
                synchronized (f0Var) {
                    f0Var.g = aVar;
                }
            }
        }
    }

    public static void f(Drawable drawable, m0 m0Var, int[] iArr) {
        PorterDuff.Mode mode = f0.h;
        if (w.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = m0Var.d;
        if (z || m0Var.f249c) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z ? m0Var.a : null;
            PorterDuff.Mode mode2 = m0Var.f249c ? m0Var.f248b : f0.h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = f0.h(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT > 23) {
            return;
        }
        drawable.invalidateSelf();
    }

    public synchronized Drawable b(Context context, int i) {
        return this.a.f(context, i);
    }

    public synchronized ColorStateList d(Context context, int i) {
        return this.a.i(context, i);
    }
}
