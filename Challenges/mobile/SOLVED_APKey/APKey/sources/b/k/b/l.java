package b.k.b;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import b.k.b.c0;
import b.k.b.k0;
import b.k.b.m;
import com.example.apkey.R;
/* loaded from: classes.dex */
public class l extends m implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler U;
    public boolean d0;
    public Dialog f0;
    public boolean g0;
    public boolean h0;
    public Runnable V = new a();
    public DialogInterface.OnCancelListener W = new b();
    public DialogInterface.OnDismissListener X = new c();
    public int Y = 0;
    public int Z = 0;
    public boolean a0 = true;
    public boolean b0 = true;
    public int c0 = -1;
    public b.m.m<b.m.g> e0 = new d();
    public boolean i0 = false;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            l lVar = l.this;
            lVar.X.onDismiss(lVar.f0);
        }
    }

    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(DialogInterface dialogInterface) {
            l lVar = l.this;
            Dialog dialog = lVar.f0;
            if (dialog != null) {
                lVar.onCancel(dialog);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(DialogInterface dialogInterface) {
            l lVar = l.this;
            Dialog dialog = lVar.f0;
            if (dialog != null) {
                lVar.onDismiss(dialog);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements b.m.m<b.m.g> {
        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class e extends v {
        public final /* synthetic */ v a;

        public e(v vVar) {
            this.a = vVar;
        }

        @Override // b.k.b.v
        public View g(int i) {
            if (this.a.h()) {
                return this.a.g(i);
            }
            Dialog dialog = l.this.f0;
            if (dialog == null) {
                return null;
            }
            return dialog.findViewById(i);
        }

        @Override // b.k.b.v
        public boolean h() {
            return this.a.h() || l.this.i0;
        }
    }

    @Override // b.k.b.m
    public void I(Context context) {
        super.I(context);
        b.m.l<b.m.g> lVar = this.Q;
        b.m.m<b.m.g> mVar = this.e0;
        lVar.getClass();
        LiveData.a("observeForever");
        LiveData.a aVar = new LiveData.a(lVar, mVar);
        LiveData<b.m.g>.b d2 = lVar.f70b.d(mVar, aVar);
        if (!(d2 instanceof LiveData.LifecycleBoundObserver)) {
            if (d2 == null) {
                aVar.d(true);
            }
            this.h0 = false;
            return;
        }
        throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }

    @Override // b.k.b.m
    public void L(Bundle bundle) {
        super.L(bundle);
        this.U = new Handler();
        this.b0 = this.x == 0;
        if (bundle != null) {
            this.Y = bundle.getInt("android:style", 0);
            this.Z = bundle.getInt("android:theme", 0);
            this.a0 = bundle.getBoolean("android:cancelable", true);
            this.b0 = bundle.getBoolean("android:showsDialog", this.b0);
            this.c0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // b.k.b.m
    public void P() {
        this.D = true;
        Dialog dialog = this.f0;
        if (dialog != null) {
            this.g0 = true;
            dialog.setOnDismissListener(null);
            this.f0.dismiss();
            if (!this.h0) {
                onDismiss(this.f0);
            }
            this.f0 = null;
            this.i0 = false;
        }
    }

    @Override // b.k.b.m
    public void Q() {
        this.D = true;
        if (!this.h0) {
            this.h0 = true;
        }
        this.Q.f(this.e0);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x006b, TryCatch #0 {all -> 0x006b, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:27:0x004d, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:28:0x0065), top: B:48:0x001a }] */
    @Override // b.k.b.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.LayoutInflater R(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.LayoutInflater r0 = r7.q()
            boolean r1 = r7.b0
            java.lang.String r2 = "FragmentManager"
            r3 = 2
            if (r1 == 0) goto L9b
            boolean r4 = r7.d0
            if (r4 == 0) goto L11
            goto L9b
        L11:
            if (r1 != 0) goto L14
            goto L6f
        L14:
            boolean r1 = r7.i0
            if (r1 != 0) goto L6f
            r1 = 0
            r4 = 1
            r7.d0 = r4     // Catch: java.lang.Throwable -> L6b
            android.app.Dialog r8 = r7.u0(r8)     // Catch: java.lang.Throwable -> L6b
            r7.f0 = r8     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r7.b0     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L65
            int r5 = r7.Y     // Catch: java.lang.Throwable -> L6b
            if (r5 == r4) goto L3b
            if (r5 == r3) goto L3b
            r6 = 3
            if (r5 == r6) goto L30
            goto L3e
        L30:
            android.view.Window r5 = r8.getWindow()     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L3b
            r6 = 24
            r5.addFlags(r6)     // Catch: java.lang.Throwable -> L6b
        L3b:
            r8.requestWindowFeature(r4)     // Catch: java.lang.Throwable -> L6b
        L3e:
            android.content.Context r8 = r7.j()     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r8 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L6b
            if (r5 == 0) goto L4d
            android.app.Dialog r5 = r7.f0     // Catch: java.lang.Throwable -> L6b
            android.app.Activity r8 = (android.app.Activity) r8     // Catch: java.lang.Throwable -> L6b
            r5.setOwnerActivity(r8)     // Catch: java.lang.Throwable -> L6b
        L4d:
            android.app.Dialog r8 = r7.f0     // Catch: java.lang.Throwable -> L6b
            boolean r5 = r7.a0     // Catch: java.lang.Throwable -> L6b
            r8.setCancelable(r5)     // Catch: java.lang.Throwable -> L6b
            android.app.Dialog r8 = r7.f0     // Catch: java.lang.Throwable -> L6b
            android.content.DialogInterface$OnCancelListener r5 = r7.W     // Catch: java.lang.Throwable -> L6b
            r8.setOnCancelListener(r5)     // Catch: java.lang.Throwable -> L6b
            android.app.Dialog r8 = r7.f0     // Catch: java.lang.Throwable -> L6b
            android.content.DialogInterface$OnDismissListener r5 = r7.X     // Catch: java.lang.Throwable -> L6b
            r8.setOnDismissListener(r5)     // Catch: java.lang.Throwable -> L6b
            r7.i0 = r4     // Catch: java.lang.Throwable -> L6b
            goto L68
        L65:
            r8 = 0
            r7.f0 = r8     // Catch: java.lang.Throwable -> L6b
        L68:
            r7.d0 = r1
            goto L6f
        L6b:
            r8 = move-exception
            r7.d0 = r1
            throw r8
        L6f:
            boolean r8 = b.k.b.c0.M(r3)
            if (r8 == 0) goto L8e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "get layout inflater for DialogFragment "
            r8.append(r1)
            r8.append(r7)
            java.lang.String r1 = " from dialog context"
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            android.util.Log.d(r2, r8)
        L8e:
            android.app.Dialog r8 = r7.f0
            if (r8 == 0) goto L9a
            android.content.Context r8 = r8.getContext()
            android.view.LayoutInflater r0 = r0.cloneInContext(r8)
        L9a:
            return r0
        L9b:
            boolean r8 = b.k.b.c0.M(r3)
            if (r8 == 0) goto Ld2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "getting layout inflater for DialogFragment "
            r8.append(r1)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            boolean r1 = r7.b0
            if (r1 != 0) goto Lbe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "mShowsDialog = false: "
            goto Lc5
        Lbe:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "mCreatingDialog = true: "
        Lc5:
            r1.append(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r2, r8)
        Ld2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.k.b.l.R(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // b.k.b.m
    public void Z(Bundle bundle) {
        Dialog dialog = this.f0;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.Y;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.Z;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.a0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.b0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.c0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // b.k.b.m
    public void a0() {
        this.D = true;
        Dialog dialog = this.f0;
        if (dialog != null) {
            this.g0 = false;
            dialog.show();
            View decorView = this.f0.getWindow().getDecorView();
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // b.k.b.m
    public void b0() {
        this.D = true;
        Dialog dialog = this.f0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // b.k.b.m
    public void d0(Bundle bundle) {
        Bundle bundle2;
        this.D = true;
        if (this.f0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f0.onRestoreInstanceState(bundle2);
    }

    @Override // b.k.b.m
    public v e() {
        return new e(new m.a());
    }

    @Override // b.k.b.m
    public void e0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.e0(layoutInflater, viewGroup, bundle);
        if (this.F != null || this.f0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f0.onRestoreInstanceState(bundle2);
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g0) {
            if (c0.M(3)) {
                Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
            }
            t0(true, true);
        }
    }

    public final void t0(boolean z, boolean z2) {
        if (this.h0) {
            return;
        }
        this.h0 = true;
        Dialog dialog = this.f0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.U.getLooper()) {
                    onDismiss(this.f0);
                } else {
                    this.U.post(this.V);
                }
            }
        }
        this.g0 = true;
        if (this.c0 >= 0) {
            c0 s = s();
            int i = this.c0;
            if (i >= 0) {
                s.A(new c0.m(null, i, 1), false);
                this.c0 = -1;
                return;
            }
            throw new IllegalArgumentException("Bad id: " + i);
        }
        b.k.b.a aVar = new b.k.b.a(s());
        c0 c0Var = this.s;
        if (c0Var != null && c0Var != aVar.p) {
            StringBuilder g = c.a.a.a.a.g("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            g.append(toString());
            g.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(g.toString());
        }
        aVar.b(new k0.a(3, this));
        if (z) {
            aVar.d(true);
        } else {
            aVar.d(false);
        }
    }

    public Dialog u0(Bundle bundle) {
        if (c0.M(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(i0(), this.Z);
    }

    public final Dialog v0() {
        Dialog dialog = this.f0;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }
}
