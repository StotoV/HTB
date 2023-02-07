package b.h.j.d0;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import b.b.h.o;
import b.h.j.c;
import b.h.j.d0.e;
import b.h.j.q;
/* loaded from: classes.dex */
public class c extends InputConnectionWrapper {
    public final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(InputConnection inputConnection, boolean z, d dVar) {
        super(inputConnection, z);
        this.a = dVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        boolean z;
        ResultReceiver resultReceiver;
        d dVar = this.a;
        int i = 0;
        if (bundle != null) {
            if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                z = false;
            } else if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", str)) {
                z = true;
            }
            try {
                resultReceiver = (ResultReceiver) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER");
            } catch (Throwable th) {
                th = th;
                resultReceiver = null;
            }
            try {
                Uri uri = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI");
                ClipDescription clipDescription = (ClipDescription) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION");
                Uri uri2 = (Uri) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI");
                int i2 = bundle.getInt(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS");
                Bundle bundle2 = (Bundle) bundle.getParcelable(z ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS");
                if (uri != null && clipDescription != null) {
                    int i3 = Build.VERSION.SDK_INT;
                    e.c aVar = i3 >= 25 ? new e.a(uri, clipDescription, uri2) : new e.b(uri, clipDescription, uri2);
                    o oVar = (o) dVar;
                    if (i3 >= 25 && (i2 & 1) != 0) {
                        try {
                            aVar.b();
                            InputContentInfo inputContentInfo = (InputContentInfo) aVar.d();
                            bundle2 = bundle2 == null ? new Bundle() : new Bundle(bundle2);
                            bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
                        } catch (Exception e) {
                            Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e);
                        }
                    }
                    c.a aVar2 = new c.a(new ClipData(aVar.a(), new ClipData.Item(aVar.e())), 2);
                    aVar2.d = aVar.c();
                    aVar2.e = bundle2;
                    if (q.z(oVar.a, new b.h.j.c(aVar2)) == null) {
                        i = 1;
                    }
                }
                if (resultReceiver != null) {
                    resultReceiver.send(i, null);
                }
            } catch (Throwable th2) {
                th = th2;
                if (resultReceiver != null) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        }
        if (i != 0) {
            return true;
        }
        return super.performPrivateCommand(str, bundle);
    }
}
