package c.c.a.a.q;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
/* loaded from: classes.dex */
public final class h {
    public static boolean j;
    public static Constructor<StaticLayout> k;
    public static Object l;
    public CharSequence a;

    /* renamed from: b  reason: collision with root package name */
    public final TextPaint f853b;

    /* renamed from: c  reason: collision with root package name */
    public final int f854c;
    public int d;
    public boolean h;
    public Layout.Alignment e = Layout.Alignment.ALIGN_NORMAL;
    public int f = Integer.MAX_VALUE;
    public boolean g = true;
    public TextUtils.TruncateAt i = null;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.Throwable r3) {
            /*
                r2 = this;
                java.lang.String r0 = "Error thrown initializing StaticLayout "
                java.lang.StringBuilder r0 = c.a.a.a.a.g(r0)
                java.lang.String r1 = r3.getMessage()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r2.<init>(r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.c.a.a.q.h.a.<init>(java.lang.Throwable):void");
        }
    }

    public h(CharSequence charSequence, TextPaint textPaint, int i) {
        this.a = charSequence;
        this.f853b = textPaint;
        this.f854c = i;
        this.d = charSequence.length();
    }

    public StaticLayout a() {
        Class<?> cls;
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.f854c);
        CharSequence charSequence = this.a;
        if (this.f == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f853b, max, this.i);
        }
        int min = Math.min(charSequence.length(), this.d);
        this.d = min;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (this.h) {
                this.e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, this.f853b, max);
            obtain.setAlignment(this.e);
            obtain.setIncludePad(this.g);
            obtain.setTextDirection(this.h ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.i;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f);
            return obtain.build();
        }
        if (!j) {
            try {
                boolean z = this.h && i >= 23;
                if (i >= 18) {
                    cls = TextDirectionHeuristic.class;
                    l = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = h.class.getClassLoader();
                    String str = this.h ? "RTL" : "LTR";
                    Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                    Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                    l = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Class cls2 = Integer.TYPE;
                Class cls3 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls2, cls2, TextPaint.class, cls2, Layout.Alignment.class, cls, cls3, cls3, Boolean.TYPE, TextUtils.TruncateAt.class, cls2, cls2);
                k = declaredConstructor;
                declaredConstructor.setAccessible(true);
                j = true;
            } catch (Exception e) {
                throw new a(e);
            }
        }
        try {
            Constructor<StaticLayout> constructor = k;
            constructor.getClass();
            Object obj = l;
            obj.getClass();
            return constructor.newInstance(charSequence, 0, Integer.valueOf(this.d), this.f853b, Integer.valueOf(max), this.e, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.g), null, Integer.valueOf(max), Integer.valueOf(this.f));
        } catch (Exception e2) {
            throw new a(e2);
        }
    }
}
