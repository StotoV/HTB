package b.h.j.d0;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.inputmethod.EditorInfo;
/* loaded from: classes.dex */
public final class a {
    public static final String[] a = new String[0];

    public static boolean a(CharSequence charSequence, int i, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return Character.isHighSurrogate(charSequence.charAt(i));
            }
            return false;
        }
        return Character.isLowSurrogate(charSequence.charAt(i));
    }

    public static void b(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }
}
