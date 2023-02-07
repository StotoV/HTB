package b.h.c.b;

import android.content.res.ColorStateList;
import android.graphics.Shader;
/* loaded from: classes.dex */
public final class a {
    public final Shader a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f400b;

    /* renamed from: c  reason: collision with root package name */
    public int f401c;

    public a(Shader shader, ColorStateList colorStateList, int i) {
        this.a = shader;
        this.f400b = colorStateList;
        this.f401c = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c1, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.h.c.b.a a(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.c.b.a.a(android.content.res.Resources, int, android.content.res.Resources$Theme):b.h.c.b.a");
    }

    public boolean b() {
        return this.a != null;
    }

    public boolean c() {
        ColorStateList colorStateList;
        return this.a == null && (colorStateList = this.f400b) != null && colorStateList.isStateful();
    }

    public boolean d(int[] iArr) {
        if (c()) {
            ColorStateList colorStateList = this.f400b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f401c) {
                this.f401c = colorForState;
                return true;
            }
        }
        return false;
    }
}
