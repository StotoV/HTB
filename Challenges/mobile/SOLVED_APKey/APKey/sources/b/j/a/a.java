package b.j.a;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public abstract class a implements Parcelable {

    /* renamed from: b  reason: collision with root package name */
    public final Parcelable f510b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f509c = new C0023a();
    public static final Parcelable.Creator<a> CREATOR = new b();

    /* renamed from: b.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0023a extends a {
        public C0023a() {
            super((C0023a) null);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Parcelable.ClassLoaderCreator<a> {
        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            if (parcel.readParcelable(null) == null) {
                return a.f509c;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new a[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return a.f509c;
            }
            throw new IllegalStateException("superState must be null");
        }
    }

    public a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f510b = readParcelable == null ? f509c : readParcelable;
    }

    public a(Parcelable parcelable) {
        if (parcelable != null) {
            this.f510b = parcelable == f509c ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public a(C0023a c0023a) {
        this.f510b = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f510b, i);
    }
}
