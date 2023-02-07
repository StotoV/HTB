package b.a.e;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0002a();

    /* renamed from: b  reason: collision with root package name */
    public final int f126b;

    /* renamed from: c  reason: collision with root package name */
    public final Intent f127c;

    /* renamed from: b.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0002a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    public a(int i, Intent intent) {
        this.f126b = i;
        this.f127c = intent;
    }

    public a(Parcel parcel) {
        this.f126b = parcel.readInt();
        this.f127c = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder g = c.a.a.a.a.g("ActivityResult{resultCode=");
        int i = this.f126b;
        if (i != -1) {
            str = i != 0 ? String.valueOf(i) : "RESULT_CANCELED";
        } else {
            str = "RESULT_OK";
        }
        g.append(str);
        g.append(", data=");
        g.append(this.f127c);
        g.append('}');
        return g.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f126b);
        parcel.writeInt(this.f127c == null ? 0 : 1);
        Intent intent = this.f127c;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}
