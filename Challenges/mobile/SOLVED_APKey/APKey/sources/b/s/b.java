package b.s;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class b extends a {
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new b.e.a(), new b.e.a(), new b.e.a());
    }

    public b(Parcel parcel, int i, int i2, String str, b.e.a<String, Method> aVar, b.e.a<String, Method> aVar2, b.e.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = parcel;
        this.f = i;
        this.g = i2;
        this.j = i;
        this.h = str;
    }

    @Override // b.s.a
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.d.get(i);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i2);
            this.e.writeInt(dataPosition - i2);
            this.e.setDataPosition(dataPosition);
        }
    }

    @Override // b.s.a
    public a b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        int i2 = i;
        return new b(parcel, dataPosition, i2, this.h + "  ", this.a, this.f754b, this.f755c);
    }

    @Override // b.s.a
    public boolean f() {
        return this.e.readInt() != 0;
    }

    @Override // b.s.a
    public byte[] g() {
        int readInt = this.e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // b.s.a
    public CharSequence h() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // b.s.a
    public boolean i(int i) {
        while (this.j < this.g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int readInt = this.e.readInt();
            this.k = this.e.readInt();
            this.j += readInt;
        }
        return this.k == i;
    }

    @Override // b.s.a
    public int j() {
        return this.e.readInt();
    }

    @Override // b.s.a
    public <T extends Parcelable> T l() {
        return (T) this.e.readParcelable(b.class.getClassLoader());
    }

    @Override // b.s.a
    public String n() {
        return this.e.readString();
    }

    @Override // b.s.a
    public void p(int i) {
        a();
        this.i = i;
        this.d.put(i, this.e.dataPosition());
        this.e.writeInt(0);
        this.e.writeInt(i);
    }

    @Override // b.s.a
    public void q(boolean z) {
        this.e.writeInt(z ? 1 : 0);
    }

    @Override // b.s.a
    public void r(byte[] bArr) {
        if (bArr == null) {
            this.e.writeInt(-1);
            return;
        }
        this.e.writeInt(bArr.length);
        this.e.writeByteArray(bArr);
    }

    @Override // b.s.a
    public void s(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // b.s.a
    public void t(int i) {
        this.e.writeInt(i);
    }

    @Override // b.s.a
    public void u(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // b.s.a
    public void v(String str) {
        this.e.writeString(str);
    }
}
