package c.c.a.a.l;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0037a();

    /* renamed from: b  reason: collision with root package name */
    public final s f792b;

    /* renamed from: c  reason: collision with root package name */
    public final s f793c;
    public final c d;
    public s e;
    public final int f;
    public final int g;

    /* renamed from: c.c.a.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0037a implements Parcelable.Creator<a> {
        @Override // android.os.Parcelable.Creator
        public a createFromParcel(Parcel parcel) {
            return new a((s) parcel.readParcelable(s.class.getClassLoader()), (s) parcel.readParcelable(s.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), (s) parcel.readParcelable(s.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static final long e = a0.a(s.k(1900, 0).g);
        public static final long f = a0.a(s.k(2100, 11).g);
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f794b;

        /* renamed from: c  reason: collision with root package name */
        public Long f795c;
        public c d;

        public b(a aVar) {
            this.a = e;
            this.f794b = f;
            this.d = new e(Long.MIN_VALUE);
            this.a = aVar.f792b.g;
            this.f794b = aVar.f793c.g;
            this.f795c = Long.valueOf(aVar.e.g);
            this.d = aVar.d;
        }
    }

    /* loaded from: classes.dex */
    public interface c extends Parcelable {
        boolean i(long j);
    }

    public a(s sVar, s sVar2, c cVar, s sVar3, C0037a c0037a) {
        this.f792b = sVar;
        this.f793c = sVar2;
        this.e = sVar3;
        this.d = cVar;
        if (sVar3 != null && sVar.f822b.compareTo(sVar3.f822b) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (sVar3 != null && sVar3.f822b.compareTo(sVar2.f822b) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.g = sVar.p(sVar2) + 1;
        this.f = (sVar2.d - sVar.d) + 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f792b.equals(aVar.f792b) && this.f793c.equals(aVar.f793c) && b.h.b.a.v(this.e, aVar.e) && this.d.equals(aVar.d);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f792b, this.f793c, this.e, this.d});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f792b, 0);
        parcel.writeParcelable(this.f793c, 0);
        parcel.writeParcelable(this.e, 0);
        parcel.writeParcelable(this.d, 0);
    }
}
