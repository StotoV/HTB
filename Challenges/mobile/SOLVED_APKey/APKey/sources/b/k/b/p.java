package b.k.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import b.m.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class p extends ComponentActivity {
    public final x i;
    public final b.m.h j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* loaded from: classes.dex */
    public class a extends z<p> implements b.m.u, b.a.c, b.a.e.e, g0 {
        public a() {
            super(p.this);
        }

        @Override // b.m.g
        public b.m.d a() {
            return p.this.j;
        }

        @Override // b.a.c
        public OnBackPressedDispatcher b() {
            return p.this.g;
        }

        @Override // b.m.u
        public b.m.t d() {
            return p.this.d();
        }

        @Override // b.k.b.g0
        public void e(c0 c0Var, m mVar) {
            p.this.k();
        }

        @Override // b.a.e.e
        public b.a.e.d f() {
            return p.this.h;
        }

        @Override // b.k.b.v
        public View g(int i) {
            return p.this.findViewById(i);
        }

        @Override // b.k.b.v
        public boolean h() {
            Window window = p.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // b.k.b.z
        public p i() {
            return p.this;
        }

        @Override // b.k.b.z
        public LayoutInflater j() {
            return p.this.getLayoutInflater().cloneInContext(p.this);
        }

        @Override // b.k.b.z
        public boolean k(m mVar) {
            return !p.this.isFinishing();
        }

        @Override // b.k.b.z
        public void l() {
            p.this.l();
        }
    }

    public p() {
        a aVar = new a();
        b.h.b.a.h(aVar, "callbacks == null");
        this.i = new x(aVar);
        this.j = new b.m.h(this);
        this.m = true;
        this.e.f698b.b("android:support:fragments", new n(this));
        o oVar = new o(this);
        b.a.d.a aVar2 = this.f0c;
        if (aVar2.f125b != null) {
            oVar.a(aVar2.f125b);
        }
        aVar2.a.add(oVar);
    }

    public static boolean j(c0 c0Var, d.b bVar) {
        d.b bVar2 = d.b.STARTED;
        boolean z = false;
        for (m mVar : c0Var.f530c.i()) {
            if (mVar != null) {
                z<?> zVar = mVar.t;
                if ((zVar == null ? null : zVar.i()) != null) {
                    z |= j(mVar.i(), bVar);
                }
                w0 w0Var = mVar.P;
                if (w0Var != null) {
                    w0Var.f();
                    if (w0Var.f612c.f639b.compareTo(bVar2) >= 0) {
                        b.m.h hVar = mVar.P.f612c;
                        hVar.c("setCurrentState");
                        hVar.f(bVar);
                        z = true;
                    }
                }
                if (mVar.O.f639b.compareTo(bVar2) >= 0) {
                    b.m.h hVar2 = mVar.O;
                    hVar2.c("setCurrentState");
                    hVar2.f(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.k);
        printWriter.print(" mResumed=");
        printWriter.print(this.l);
        printWriter.print(" mStopped=");
        printWriter.print(this.m);
        if (getApplication() != null) {
            b.n.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.i.a.e.y(str, fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    public void k() {
    }

    @Deprecated
    public void l() {
        invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.i.a();
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.i.a();
        this.i.a.e.k(configuration);
    }

    @Override // androidx.activity.ComponentActivity, b.h.b.b, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j.d(d.a.ON_CREATE);
        this.i.a.e.m();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0) {
            boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
            x xVar = this.i;
            return onCreatePanelMenu | xVar.a.e.n(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.i.a.e.f.onCreateView(view, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(view, str, context, attributeSet) : onCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.i.a.e.o();
        this.j.d(d.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.i.a.e.p();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.i.a.e.r(menuItem);
        }
        if (i == 6) {
            return this.i.a.e.l(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.i.a.e.q(z);
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        super.onNewIntent(intent);
        this.i.a();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.i.a.e.s(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.l = false;
        this.i.a.e.w(5);
        this.j.d(d.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.i.a.e.u(z);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.j.d(d.a.ON_RESUME);
        c0 c0Var = this.i.a.e;
        c0Var.B = false;
        c0Var.C = false;
        c0Var.J.g = false;
        c0Var.w(7);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return super.onPreparePanel(0, view, menu) | this.i.a.e.v(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.i.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.l = true;
        this.i.a();
        this.i.a.e.C(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.m = false;
        if (!this.k) {
            this.k = true;
            c0 c0Var = this.i.a.e;
            c0Var.B = false;
            c0Var.C = false;
            c0Var.J.g = false;
            c0Var.w(4);
        }
        this.i.a();
        this.i.a.e.C(true);
        this.j.d(d.a.ON_START);
        c0 c0Var2 = this.i.a.e;
        c0Var2.B = false;
        c0Var2.C = false;
        c0Var2.J.g = false;
        c0Var2.w(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.i.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.m = true;
        do {
        } while (j(this.i.a.e, d.b.CREATED));
        c0 c0Var = this.i.a.e;
        c0Var.C = true;
        c0Var.J.g = true;
        c0Var.w(4);
        this.j.d(d.a.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View onCreateView = this.i.a.e.f.onCreateView(null, str, context, attributeSet);
        return onCreateView == null ? super.onCreateView(str, context, attributeSet) : onCreateView;
    }
}
