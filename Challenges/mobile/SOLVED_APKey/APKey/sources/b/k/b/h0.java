package b.k.b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class h0 implements Parcelable {
    public static final Parcelable.Creator<h0> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final String f554b;

    /* renamed from: c  reason: collision with root package name */
    public final String f555c;
    public final boolean d;
    public final int e;
    public final int f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final Bundle k;
    public final boolean l;
    public final int m;
    public Bundle n;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<h0> {
        @Override // android.os.Parcelable.Creator
        public h0 createFromParcel(Parcel parcel) {
            return new h0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public h0[] newArray(int i) {
            return new h0[i];
        }
    }

    public h0(Parcel parcel) {
        this.f554b = parcel.readString();
        this.f555c = parcel.readString();
        boolean z = true;
        this.d = parcel.readInt() != 0;
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readBundle();
        this.l = parcel.readInt() == 0 ? false : z;
        this.n = parcel.readBundle();
        this.m = parcel.readInt();
    }

    public h0(m mVar) {
        this.f554b = mVar.getClass().getName();
        this.f555c = mVar.f;
        this.d = mVar.n;
        this.e = mVar.w;
        this.f = mVar.x;
        this.g = mVar.y;
        this.h = mVar.B;
        this.i = mVar.m;
        this.j = mVar.A;
        this.k = mVar.g;
        this.l = mVar.z;
        this.m = mVar.N.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f554b);
        sb.append(" (");
        sb.append(this.f555c);
        sb.append(")}:");
        if (this.d) {
            sb.append(" fromLayout");
        }
        if (this.f != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f));
        }
        String str = this.g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.g);
        }
        if (this.h) {
            sb.append(" retainInstance");
        }
        if (this.i) {
            sb.append(" removing");
        }
        if (this.j) {
            sb.append(" detached");
        }
        if (this.l) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f554b);
        parcel.writeString(this.f555c);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeBundle(this.n);
        parcel.writeInt(this.m);
    }
}
