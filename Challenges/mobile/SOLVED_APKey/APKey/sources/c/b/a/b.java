package c.b.a;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes.dex */
public class b {
    public static String a(String str) {
        char charAt = h.a().charAt(0);
        char charAt2 = a.a().charAt(8);
        char charAt3 = e.a().charAt(5);
        char charAt4 = i.a().charAt(4);
        char charAt5 = h.a().charAt(1);
        char charAt6 = h.a().charAt(4);
        char charAt7 = h.a().charAt(3);
        char charAt8 = h.a().charAt(3);
        char charAt9 = h.a().charAt(0);
        char charAt10 = a.a().charAt(8);
        char charAt11 = a.a().charAt(8);
        char charAt12 = i.a().charAt(0);
        char charAt13 = c.a().charAt(3);
        char charAt14 = f.a().charAt(3);
        char charAt15 = f.a().charAt(0);
        char charAt16 = c.a().charAt(0);
        SecretKeySpec secretKeySpec = new SecretKeySpec((String.valueOf(charAt) + String.valueOf(charAt2) + String.valueOf(charAt3) + String.valueOf(charAt4) + String.valueOf(charAt5).toLowerCase() + String.valueOf(charAt6) + String.valueOf(charAt7).toLowerCase() + String.valueOf(charAt8) + String.valueOf(charAt9) + String.valueOf(charAt10).toLowerCase() + String.valueOf(charAt11).toLowerCase() + String.valueOf(charAt12) + String.valueOf(charAt13).toLowerCase() + String.valueOf(charAt14) + String.valueOf(charAt15) + String.valueOf(charAt16)).getBytes(), g.b());
        Cipher cipher = Cipher.getInstance(g.b());
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(Base64.decode(str, 0)), "utf-8");
    }
}
