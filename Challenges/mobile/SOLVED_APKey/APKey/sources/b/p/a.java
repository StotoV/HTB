package b.p;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public Bundle f696b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f697c;
    public Recreator.a d;
    public b.c.a.b.b<String, b> a = new b.c.a.b.b<>();
    public boolean e = true;

    /* renamed from: b.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0030a {
        void a(c cVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f697c) {
            Bundle bundle = this.f696b;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f696b.remove(str);
            if (this.f696b.isEmpty()) {
                this.f696b = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void b(String str, b bVar) {
        if (this.a.d(str, bVar) == null) {
            return;
        }
        throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
    }

    public void c(Class<? extends InterfaceC0030a> cls) {
        if (this.e) {
            if (this.d == null) {
                this.d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.d;
                aVar.a.add(cls.getName());
                return;
            } catch (NoSuchMethodException e) {
                StringBuilder g = c.a.a.a.a.g("Class");
                g.append(cls.getSimpleName());
                g.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(g.toString(), e);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}
