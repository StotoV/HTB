package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class ImageViewCompat {
    public static ColorStateList getImageTintList(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintList();
        }
        if (!(imageView instanceof TintableImageSourceView)) {
            return null;
        }
        return ((TintableImageSourceView) imageView).getSupportImageTintList();
    }

    public static void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT != 21) {
                return;
            }
            Drawable drawable = imageView.getDrawable();
            boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
            if (drawable == null || !z) {
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        } else if (!(imageView instanceof TintableImageSourceView)) {
        } else {
            ((TintableImageSourceView) imageView).setSupportImageTintList(colorStateList);
        }
    }

    public static PorterDuff.Mode getImageTintMode(ImageView imageView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return imageView.getImageTintMode();
        }
        if (!(imageView instanceof TintableImageSourceView)) {
            return null;
        }
        return ((TintableImageSourceView) imageView).getSupportImageTintMode();
    }

    public static void setImageTintMode(ImageView imageView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT != 21) {
                return;
            }
            Drawable drawable = imageView.getDrawable();
            boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
            if (drawable == null || !z) {
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        } else if (!(imageView instanceof TintableImageSourceView)) {
        } else {
            ((TintableImageSourceView) imageView).setSupportImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }
}
