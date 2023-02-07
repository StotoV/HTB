package c.c.a.a.l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
/* loaded from: classes.dex */
public final class s implements Comparable<s>, Parcelable {
    public static final Parcelable.Creator<s> CREATOR = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f822b;

    /* renamed from: c  reason: collision with root package name */
    public final int f823c;
    public final int d;
    public final int e;
    public final int f;
    public final long g;
    public String h;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<s> {
        @Override // android.os.Parcelable.Creator
        public s createFromParcel(Parcel parcel) {
            return s.k(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public s[] newArray(int i) {
            return new s[i];
        }
    }

    public s(Calendar calendar) {
        calendar.set(5, 1);
        Calendar b2 = a0.b(calendar);
        this.f822b = b2;
        this.f823c = b2.get(2);
        this.d = b2.get(1);
        this.e = b2.getMaximum(7);
        this.f = b2.getActualMaximum(5);
        this.g = b2.getTimeInMillis();
    }

    public static s k(int i, int i2) {
        Calendar e = a0.e();
        e.set(1, i);
        e.set(2, i2);
        return new s(e);
    }

    public static s l(long j) {
        Calendar e = a0.e();
        e.setTimeInMillis(j);
        return new s(e);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f823c == sVar.f823c && this.d == sVar.d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f823c), Integer.valueOf(this.d)});
    }

    @Override // java.lang.Comparable
    /* renamed from: j */
    public int compareTo(s sVar) {
        return this.f822b.compareTo(sVar.f822b);
    }

    public int m() {
        int firstDayOfWeek = this.f822b.get(7) - this.f822b.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.e : firstDayOfWeek;
    }

    public String n(Context context) {
        if (this.h == null) {
            long timeInMillis = this.f822b.getTimeInMillis();
            this.h = DateUtils.formatDateTime(context, timeInMillis - TimeZone.getDefault().getOffset(timeInMillis), 36);
        }
        return this.h;
    }

    public s o(int i) {
        Calendar b2 = a0.b(this.f822b);
        b2.add(2, i);
        return new s(b2);
    }

    public int p(s sVar) {
        if (this.f822b instanceof GregorianCalendar) {
            return (sVar.f823c - this.f823c) + ((sVar.d - this.d) * 12);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeInt(this.f823c);
    }
}
