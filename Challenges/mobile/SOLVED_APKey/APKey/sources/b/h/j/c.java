package b.h.j;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import java.util.Locale;
/* loaded from: classes.dex */
public final class c {
    public final ClipData a;

    /* renamed from: b  reason: collision with root package name */
    public final int f470b;

    /* renamed from: c  reason: collision with root package name */
    public final int f471c;
    public final Uri d;
    public final Bundle e;

    /* loaded from: classes.dex */
    public static final class a {
        public ClipData a;

        /* renamed from: b  reason: collision with root package name */
        public int f472b;

        /* renamed from: c  reason: collision with root package name */
        public int f473c;
        public Uri d;
        public Bundle e;

        public a(ClipData clipData, int i) {
            this.a = clipData;
            this.f472b = i;
        }
    }

    public c(a aVar) {
        ClipData clipData = aVar.a;
        clipData.getClass();
        this.a = clipData;
        int i = aVar.f472b;
        if (i >= 0) {
            if (i <= 3) {
                this.f470b = i;
                int i2 = aVar.f473c;
                if ((i2 & 1) == i2) {
                    this.f471c = i2;
                    this.d = aVar.d;
                    this.e = aVar.e;
                    return;
                }
                StringBuilder g = c.a.a.a.a.g("Requested flags 0x");
                g.append(Integer.toHexString(i2));
                g.append(", but only 0x");
                g.append(Integer.toHexString(1));
                g.append(" are allowed");
                throw new IllegalArgumentException(g.toString());
            }
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 3));
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 3));
    }

    public String toString() {
        String str;
        StringBuilder g = c.a.a.a.a.g("ContentInfoCompat{clip=");
        g.append(this.a);
        g.append(", source=");
        int i = this.f470b;
        if (i == 0) {
            str = "SOURCE_APP";
        } else if (i == 1) {
            str = "SOURCE_CLIPBOARD";
        } else if (i != 2) {
            str = i != 3 ? String.valueOf(i) : "SOURCE_DRAG_AND_DROP";
        } else {
            str = "SOURCE_INPUT_METHOD";
        }
        g.append(str);
        g.append(", flags=");
        int i2 = this.f471c;
        g.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
        g.append(", linkUri=");
        g.append(this.d);
        g.append(", extras=");
        g.append(this.e);
        g.append("}");
        return g.toString();
    }
}
