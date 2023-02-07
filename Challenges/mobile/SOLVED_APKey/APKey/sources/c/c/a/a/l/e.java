package c.c.a.a.l;

import android.os.Parcel;
import android.os.Parcelable;
import c.c.a.a.l.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public class e implements a.c {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final long f803b;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<e> {
        @Override // android.os.Parcelable.Creator
        public e createFromParcel(Parcel parcel) {
            return new e(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        public e[] newArray(int i) {
            return new e[i];
        }
    }

    public e(long j) {
        this.f803b = j;
    }

    public e(long j, a aVar) {
        this.f803b = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f803b == ((e) obj).f803b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f803b)});
    }

    @Override // c.c.a.a.l.a.c
    public boolean i(long j) {
        return j >= this.f803b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f803b);
    }
}
