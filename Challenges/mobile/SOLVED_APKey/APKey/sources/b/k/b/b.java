package b.k.b;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b.k.b.k0;
import java.util.ArrayList;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final int[] f521b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<String> f522c;
    public final int[] d;
    public final int[] e;
    public final int f;
    public final String g;
    public final int h;
    public final int i;
    public final CharSequence j;
    public final int k;
    public final CharSequence l;
    public final ArrayList<String> m;
    public final ArrayList<String> n;
    public final boolean o;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<b> {
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.f521b = parcel.createIntArray();
        this.f522c = parcel.createStringArrayList();
        this.d = parcel.createIntArray();
        this.e = parcel.createIntArray();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.k = parcel.readInt();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.m = parcel.createStringArrayList();
        this.n = parcel.createStringArrayList();
        this.o = parcel.readInt() != 0;
    }

    public b(b.k.b.a aVar) {
        int size = aVar.a.size();
        this.f521b = new int[size * 5];
        if (aVar.g) {
            this.f522c = new ArrayList<>(size);
            this.d = new int[size];
            this.e = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                k0.a aVar2 = aVar.a.get(i);
                int i3 = i2 + 1;
                this.f521b[i2] = aVar2.a;
                ArrayList<String> arrayList = this.f522c;
                m mVar = aVar2.f567b;
                arrayList.add(mVar != null ? mVar.f : null);
                int[] iArr = this.f521b;
                int i4 = i3 + 1;
                iArr[i3] = aVar2.f568c;
                int i5 = i4 + 1;
                iArr[i4] = aVar2.d;
                int i6 = i5 + 1;
                iArr[i5] = aVar2.e;
                iArr[i6] = aVar2.f;
                this.d[i] = aVar2.g.ordinal();
                this.e[i] = aVar2.h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.f = aVar.f;
            this.g = aVar.h;
            this.h = aVar.r;
            this.i = aVar.i;
            this.j = aVar.j;
            this.k = aVar.k;
            this.l = aVar.l;
            this.m = aVar.m;
            this.n = aVar.n;
            this.o = aVar.o;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f521b);
        parcel.writeStringList(this.f522c);
        parcel.writeIntArray(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        TextUtils.writeToParcel(this.j, parcel, 0);
        parcel.writeInt(this.k);
        TextUtils.writeToParcel(this.l, parcel, 0);
        parcel.writeStringList(this.m);
        parcel.writeStringList(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }
}
