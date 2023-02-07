package b.h.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import b.h.j.e;
import b.m.d;
import b.m.g;
import b.m.h;
import b.m.o;
/* loaded from: classes.dex */
public class b extends Activity implements g, e.a {

    /* renamed from: b  reason: collision with root package name */
    public h f399b = new h(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return e.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // b.h.j.e.a
    public boolean e(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.c(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        h hVar = this.f399b;
        d.b bVar = d.b.CREATED;
        hVar.c("markState");
        hVar.c("setCurrentState");
        hVar.f(bVar);
        super.onSaveInstanceState(bundle);
    }
}
