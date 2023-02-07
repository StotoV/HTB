package b.m;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class t {
    public final HashMap<String, p> a = new HashMap<>();

    public final void a() {
        for (p pVar : this.a.values()) {
            Map<String, Object> map = pVar.a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : pVar.a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
            pVar.a();
        }
        this.a.clear();
    }
}
