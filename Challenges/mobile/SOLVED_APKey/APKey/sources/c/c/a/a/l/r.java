package c.c.a.a.l;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class r<S> extends x<S> {
    public int V;
    public d<S> W;
    public c.c.a.a.l.a X;

    /* loaded from: classes.dex */
    public class a extends w<S> {
        public a() {
        }

        @Override // c.c.a.a.l.w
        public void a(S s) {
            Iterator<w<S>> it = r.this.U.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }
    }

    @Override // b.k.b.m
    public void L(Bundle bundle) {
        super.L(bundle);
        if (bundle == null) {
            bundle = this.g;
        }
        this.V = bundle.getInt("THEME_RES_ID_KEY");
        this.W = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.X = (c.c.a.a.l.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // b.k.b.m
    public View O(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.W.e(layoutInflater.cloneInContext(new ContextThemeWrapper(j(), this.V)), viewGroup, bundle, this.X, new a());
    }

    @Override // b.k.b.m
    public void Z(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.V);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.W);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.X);
    }
}
