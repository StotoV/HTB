package b.b.g.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import b.b.g.e.l;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    public f f180b;

    /* renamed from: c  reason: collision with root package name */
    public int f181c = -1;
    public boolean d;
    public final boolean e;
    public final LayoutInflater f;
    public final int g;

    public e(f fVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.e = z;
        this.f = layoutInflater;
        this.f180b = fVar;
        this.g = i;
        a();
    }

    public void a() {
        f fVar = this.f180b;
        g gVar = fVar.v;
        if (gVar != null) {
            fVar.i();
            ArrayList<g> arrayList = fVar.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i) == gVar) {
                    this.f181c = i;
                    return;
                }
            }
        }
        this.f181c = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public g getItem(int i) {
        ArrayList<g> k;
        if (this.e) {
            f fVar = this.f180b;
            fVar.i();
            k = fVar.j;
        } else {
            k = this.f180b.k();
        }
        int i2 = this.f181c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return k.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<g> k;
        if (this.e) {
            f fVar = this.f180b;
            fVar.i();
            k = fVar.j;
        } else {
            k = this.f180b.k();
        }
        int i = this.f181c;
        int size = k.size();
        return i < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f.inflate(this.g, viewGroup, false);
        }
        int i2 = getItem(i).f184b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f180b.l() && i2 != (i3 >= 0 ? getItem(i3).f184b : i2));
        l.a aVar = (l.a) view;
        if (this.d) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.c(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
