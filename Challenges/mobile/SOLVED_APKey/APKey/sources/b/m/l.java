package b.m;

import androidx.lifecycle.LiveData;
/* loaded from: classes.dex */
public class l<T> extends LiveData<T> {
    public void g(T t) {
        LiveData.a("setValue");
        this.g++;
        this.e = t;
        c(null);
    }
}
