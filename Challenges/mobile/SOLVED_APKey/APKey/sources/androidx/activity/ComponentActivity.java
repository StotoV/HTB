package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import b.a.e.d;
import b.a.e.e;
import b.m.d;
import b.m.g;
import b.m.h;
import b.m.o;
import b.m.t;
import b.m.u;
import com.example.apkey.R;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ComponentActivity extends b.h.b.b implements g, u, b.p.c, b.a.c, e {

    /* renamed from: c  reason: collision with root package name */
    public final b.a.d.a f0c = new b.a.d.a();
    public final h d;
    public final b.p.b e;
    public t f;
    public final OnBackPressedDispatcher g;
    public final d h;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e) {
                if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends d {
        public b(ComponentActivity componentActivity) {
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public t a;
    }

    public ComponentActivity() {
        h hVar = new h(this);
        this.d = hVar;
        this.e = new b.p.b(this);
        this.g = new OnBackPressedDispatcher(new a());
        new AtomicInteger();
        this.h = new b(this);
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            hVar.a(new b.m.e() { // from class: androidx.activity.ComponentActivity.3
                @Override // b.m.e
                public void h(g gVar, d.a aVar) {
                    if (aVar == d.a.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        View peekDecorView = window != null ? window.peekDecorView() : null;
                        if (peekDecorView == null) {
                            return;
                        }
                        peekDecorView.cancelPendingInputEvents();
                    }
                }
            });
        }
        hVar.a(new b.m.e() { // from class: androidx.activity.ComponentActivity.4
            @Override // b.m.e
            public void h(g gVar, d.a aVar) {
                if (aVar == d.a.ON_DESTROY) {
                    ComponentActivity.this.f0c.f125b = null;
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.d().a();
                }
            }
        });
        hVar.a(new b.m.e() { // from class: androidx.activity.ComponentActivity.5
            @Override // b.m.e
            public void h(g gVar, d.a aVar) {
                ComponentActivity.this.h();
                h hVar2 = ComponentActivity.this.d;
                hVar2.c("removeObserver");
                hVar2.a.e(this);
            }
        });
        if (19 > i || i > 23) {
            return;
        }
        hVar.a(new ImmLeaksCleaner(this));
    }

    @Override // b.m.g
    public b.m.d a() {
        return this.d;
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        i();
        super.addContentView(view, layoutParams);
    }

    @Override // b.a.c
    public final OnBackPressedDispatcher b() {
        return this.g;
    }

    @Override // b.p.c
    public final b.p.a c() {
        return this.e.f698b;
    }

    @Override // b.m.u
    public t d() {
        if (getApplication() != null) {
            h();
            return this.f;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // b.a.e.e
    public final b.a.e.d f() {
        return this.h;
    }

    public void h() {
        if (this.f == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this.f = cVar.a;
            }
            if (this.f != null) {
                return;
            }
            this.f = new t();
        }
    }

    public final void i() {
        getWindow().getDecorView().setTag(R.id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(R.id.view_tree_view_model_store_owner, this);
        getWindow().getDecorView().setTag(R.id.view_tree_saved_state_registry_owner, this);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.h.a(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.g.a();
    }

    @Override // b.h.b.b, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.e.a(bundle);
        b.a.d.a aVar = this.f0c;
        aVar.f125b = this;
        for (b.a.d.b bVar : aVar.a) {
            bVar.a(this);
        }
        super.onCreate(bundle);
        b.a.e.d dVar = this.h;
        dVar.getClass();
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                int size = stringArrayList.size();
                for (int i = 0; i < size; i++) {
                    int intValue = integerArrayList.get(i).intValue();
                    String str = stringArrayList.get(i);
                    dVar.f128b.put(Integer.valueOf(intValue), str);
                    dVar.f129c.put(str, Integer.valueOf(intValue));
                }
                dVar.e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                dVar.a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                dVar.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
        o.c(this);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (this.h.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        t tVar = this.f;
        if (tVar == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            tVar = cVar.a;
        }
        if (tVar == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.a = tVar;
        return cVar2;
    }

    @Override // b.h.b.b, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        h hVar = this.d;
        if (hVar instanceof h) {
            d.b bVar = d.b.CREATED;
            hVar.c("setCurrentState");
            hVar.f(bVar);
        }
        super.onSaveInstanceState(bundle);
        this.e.b(bundle);
        b.a.e.d dVar = this.h;
        dVar.getClass();
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(dVar.f128b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(dVar.f128b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(dVar.e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) dVar.h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", dVar.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (checkPermission("android.permission.UPDATE_DEVICE_STATS", android.os.Process.myPid(), android.os.Process.myUid()) == 0) goto L11;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void reportFullyDrawn() {
        /*
            r5 = this;
            r0 = 18
            boolean r1 = b.h.b.a.H()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L24
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
            r1.<init>()     // Catch: java.lang.Throwable -> L48
            java.lang.String r2 = "reportFullyDrawn() for "
            r1.append(r2)     // Catch: java.lang.Throwable -> L48
            android.content.ComponentName r2 = r5.getComponentName()     // Catch: java.lang.Throwable -> L48
            r1.append(r2)     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L48
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L48
            if (r2 < r0) goto L24
            android.os.Trace.beginSection(r1)     // Catch: java.lang.Throwable -> L48
        L24:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L48
            r2 = 19
            if (r1 <= r2) goto L2b
            goto L3f
        L2b:
            if (r1 != r2) goto L42
            java.lang.String r2 = "android.permission.UPDATE_DEVICE_STATS"
            java.lang.Object r3 = b.h.c.a.a     // Catch: java.lang.Throwable -> L48
            int r3 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L48
            int r4 = android.os.Process.myUid()     // Catch: java.lang.Throwable -> L48
            int r2 = r5.checkPermission(r2, r3, r4)     // Catch: java.lang.Throwable -> L48
            if (r2 != 0) goto L42
        L3f:
            super.reportFullyDrawn()     // Catch: java.lang.Throwable -> L48
        L42:
            if (r1 < r0) goto L47
            android.os.Trace.endSection()
        L47:
            return
        L48:
            r1 = move-exception
            int r2 = android.os.Build.VERSION.SDK_INT
            if (r2 < r0) goto L50
            android.os.Trace.endSection()
        L50:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.ComponentActivity.reportFullyDrawn():void");
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        i();
        super.setContentView(i);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        i();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        i();
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
