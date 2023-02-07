package c.c.a.a.l;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class a0 {
    public static AtomicReference<z> a = new AtomicReference<>();

    public static long a(long j) {
        Calendar e = e();
        e.setTimeInMillis(j);
        return b(e).getTimeInMillis();
    }

    public static Calendar b(Calendar calendar) {
        Calendar f = f(calendar);
        Calendar e = e();
        e.set(f.get(1), f.get(2), f.get(5));
        return e;
    }

    public static TimeZone c() {
        return TimeZone.getTimeZone("UTC");
    }

    public static Calendar d() {
        z zVar = a.get();
        if (zVar == null) {
            zVar = z.f829c;
        }
        TimeZone timeZone = zVar.f830b;
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = zVar.a;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.setTimeZone(c());
        return calendar;
    }

    public static Calendar e() {
        return f(null);
    }

    public static Calendar f(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(c());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }
}
