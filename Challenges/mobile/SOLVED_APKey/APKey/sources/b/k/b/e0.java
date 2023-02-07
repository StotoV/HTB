package b.k.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.k.b.c0;
import java.util.ArrayList;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class e0 implements Parcelable {
    public static final Parcelable.Creator<e0> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<h0> f543b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f544c;
    public b[] d;
    public int e;
    public String f;
    public ArrayList<String> g;
    public ArrayList<Bundle> h;
    public ArrayList<c0.k> i;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<e0> {
        @Override // android.os.Parcelable.Creator
        public e0 createFromParcel(Parcel parcel) {
            return new e0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public e0[] newArray(int i) {
            return new e0[i];
        }
    }

    public e0() {
        this.f = null;
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
    }

    public e0(Parcel parcel) {
        this.f = null;
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.f543b = parcel.createTypedArrayList(h0.CREATOR);
        this.f544c = parcel.createStringArrayList();
        this.d = (b[]) parcel.createTypedArray(b.CREATOR);
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = parcel.createStringArrayList();
        this.h = parcel.createTypedArrayList(Bundle.CREATOR);
        this.i = parcel.createTypedArrayList(c0.k.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f543b);
        parcel.writeStringList(this.f544c);
        parcel.writeTypedArray(this.d, i);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeStringList(this.g);
        parcel.writeTypedList(this.h);
        parcel.writeTypedList(this.i);
    }
}
