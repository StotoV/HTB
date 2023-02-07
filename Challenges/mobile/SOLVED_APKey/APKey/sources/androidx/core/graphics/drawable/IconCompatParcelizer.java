package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import b.s.a;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        Parcelable parcelable;
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = aVar.k(iconCompat.a, 1);
        byte[] bArr = iconCompat.f65c;
        if (aVar.i(2)) {
            bArr = aVar.g();
        }
        iconCompat.f65c = bArr;
        iconCompat.d = aVar.m(iconCompat.d, 3);
        iconCompat.e = aVar.k(iconCompat.e, 4);
        iconCompat.f = aVar.k(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.m(iconCompat.g, 6);
        String str = iconCompat.i;
        if (aVar.i(7)) {
            str = aVar.n();
        }
        iconCompat.i = str;
        String str2 = iconCompat.j;
        if (aVar.i(8)) {
            str2 = aVar.n();
        }
        iconCompat.j = str2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.a) {
            case -1:
                parcelable = iconCompat.d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f64b = parcelable;
                break;
            case 1:
            case 5:
                parcelable = iconCompat.d;
                if (parcelable == null) {
                    byte[] bArr2 = iconCompat.f65c;
                    iconCompat.f64b = bArr2;
                    iconCompat.a = 3;
                    iconCompat.e = 0;
                    iconCompat.f = bArr2.length;
                    break;
                }
                iconCompat.f64b = parcelable;
                break;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f65c, Charset.forName("UTF-16"));
                iconCompat.f64b = str3;
                if (iconCompat.a == 2 && iconCompat.j == null) {
                    iconCompat.j = str3.split(":", -1)[0];
                    break;
                }
                break;
            case 3:
                iconCompat.f64b = iconCompat.f65c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.getClass();
        iconCompat.i = iconCompat.h.name();
        switch (iconCompat.a) {
            case -1:
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.f64b;
                break;
            case 2:
                iconCompat.f65c = ((String) iconCompat.f64b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f65c = (byte[]) iconCompat.f64b;
                break;
            case 4:
            case 6:
                iconCompat.f65c = iconCompat.f64b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.a;
        if (-1 != i) {
            aVar.p(1);
            aVar.t(i);
        }
        byte[] bArr = iconCompat.f65c;
        if (bArr != null) {
            aVar.p(2);
            aVar.r(bArr);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            aVar.p(3);
            aVar.u(parcelable);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            aVar.p(4);
            aVar.t(i2);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            aVar.p(5);
            aVar.t(i3);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            aVar.p(6);
            aVar.u(colorStateList);
        }
        String str = iconCompat.i;
        if (str != null) {
            aVar.p(7);
            aVar.v(str);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            aVar.p(8);
            aVar.v(str2);
        }
    }
}
