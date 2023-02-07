package b.h.c.b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public final class h {
    public static a a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        a aVar;
        if (c(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return new a(null, null, typedValue.data);
            }
            try {
                aVar = a.a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception e) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                aVar = null;
            }
            if (aVar != null) {
                return aVar;
            }
        }
        return new a(null, null, i2);
    }

    public static String b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!c(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    public static boolean c(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a6, code lost:
        if (r20 != null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a8, code lost:
        r20.a(-3, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0026, code lost:
        if (r20 != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface d(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, b.h.c.b.g r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.c.b.h.d(android.content.Context, int, android.util.TypedValue, int, b.h.c.b.g, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    public static TypedArray e(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
