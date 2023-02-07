package c.c.a.a.w;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.e.f;
/* loaded from: classes.dex */
public class a extends b.j.a.a {
    public static final Parcelable.Creator<a> CREATOR = new C0041a();
    public final f<String, Bundle> d;

    /* renamed from: c.c.a.a.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0041a implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new a(parcel, null, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader, null);
        }
    }

    public a(Parcel parcel, ClassLoader classLoader, C0041a c0041a) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.d = new f<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.d.put(strArr[i], bundleArr[i]);
        }
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("ExtendableSavedState{");
        g.append(Integer.toHexString(System.identityHashCode(this)));
        g.append(" states=");
        g.append(this.d);
        g.append("}");
        return g.toString();
    }

    @Override // b.j.a.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f510b, i);
        int i2 = this.d.d;
        parcel.writeInt(i2);
        String[] strArr = new String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = this.d.h(i3);
            bundleArr[i3] = this.d.k(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }
}
