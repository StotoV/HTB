package b.n.a;

import b.m.g;
import b.m.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class a {
    public static <T extends g & u> a b(T t) {
        return new b(t, t.d());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
