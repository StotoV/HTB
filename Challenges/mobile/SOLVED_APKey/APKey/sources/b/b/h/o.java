package b.b.h;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import b.h.j.c;
/* loaded from: classes.dex */
public class o implements b.h.j.d0.d {
    public final /* synthetic */ View a;

    public o(View view) {
        this.a = view;
    }

    public boolean a(b.h.j.d0.e eVar, int i, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
            try {
                eVar.a.b();
                InputContentInfo inputContentInfo = (InputContentInfo) eVar.a.d();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception e) {
                Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        c.a aVar = new c.a(new ClipData(eVar.a.a(), new ClipData.Item(eVar.a.e())), 2);
        aVar.d = eVar.a.c();
        aVar.e = bundle;
        return b.h.j.q.z(this.a, new b.h.j.c(aVar)) == null;
    }
}
