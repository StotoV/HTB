package b.o.b;

import androidx.recyclerview.widget.RecyclerView;
import b.o.b.k;
/* loaded from: classes.dex */
public abstract class y extends RecyclerView.i {
    public boolean g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean a(RecyclerView.z zVar, RecyclerView.z zVar2, RecyclerView.i.c cVar, RecyclerView.i.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.f91b;
        if (zVar2.t()) {
            int i5 = cVar.a;
            i2 = cVar.f91b;
            i = i5;
        } else {
            i = cVar2.a;
            i2 = cVar2.f91b;
        }
        k kVar = (k) this;
        if (zVar == zVar2) {
            return kVar.i(zVar, i3, i4, i, i2);
        }
        float translationX = zVar.a.getTranslationX();
        float translationY = zVar.a.getTranslationY();
        float alpha = zVar.a.getAlpha();
        kVar.n(zVar);
        zVar.a.setTranslationX(translationX);
        zVar.a.setTranslationY(translationY);
        zVar.a.setAlpha(alpha);
        kVar.n(zVar2);
        zVar2.a.setTranslationX(-((int) ((i - i3) - translationX)));
        zVar2.a.setTranslationY(-((int) ((i2 - i4) - translationY)));
        zVar2.a.setAlpha(0.0f);
        kVar.k.add(new k.a(zVar, zVar2, i3, i4, i, i2));
        return true;
    }

    public abstract boolean i(RecyclerView.z zVar, int i, int i2, int i3, int i4);
}
