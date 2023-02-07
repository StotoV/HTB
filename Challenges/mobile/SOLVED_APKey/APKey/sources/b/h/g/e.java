package b.h.g;

import android.util.Base64;
import java.util.List;
/* loaded from: classes.dex */
public final class e {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f430b;

    /* renamed from: c  reason: collision with root package name */
    public final String f431c;
    public final List<List<byte[]>> d;
    public final String e;

    public e(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = str;
        this.f430b = str2;
        this.f431c = str3;
        list.getClass();
        this.d = list;
        this.e = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder g = c.a.a.a.a.g("FontRequest {mProviderAuthority: ");
        g.append(this.a);
        g.append(", mProviderPackage: ");
        g.append(this.f430b);
        g.append(", mQuery: ");
        g.append(this.f431c);
        g.append(", mCertificates:");
        sb.append(g.toString());
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: 0");
        return sb.toString();
    }
}
