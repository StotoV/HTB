package b.h.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import b.h.g.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class j {
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, b.h.c.b.c> a = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public class a implements b<l> {
        public a(j jVar) {
        }

        @Override // b.h.d.j.b
        public int a(l lVar) {
            return lVar.f441c;
        }

        @Override // b.h.d.j.b
        public boolean b(l lVar) {
            return lVar.d;
        }
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        int a(T t);

        boolean b(T t);
    }

    public static <T> T e(T[] tArr, int i, b<T> bVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(bVar.a(t2) - i2) * 2) + (bVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    public static long g(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    public Typeface a(Context context, b.h.c.b.c cVar, Resources resources, int i) {
        b.h.c.b.d dVar = (b.h.c.b.d) e(cVar.a, i, new k(this));
        if (dVar == null) {
            return null;
        }
        Typeface b2 = d.b(context, resources, dVar.f, dVar.a, i);
        long g = g(b2);
        if (g != 0) {
            this.a.put(Long.valueOf(g), cVar);
        }
        return b2;
    }

    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (lVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(f(lVarArr, i).a);
            try {
                Typeface c2 = c(context, inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return c2;
            } catch (IOException unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Typeface c(Context context, InputStream inputStream) {
        File C = b.h.b.a.C(context);
        if (C == null) {
            return null;
        }
        try {
            if (b.h.b.a.p(C, inputStream)) {
                return Typeface.createFromFile(C.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            C.delete();
        }
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File C = b.h.b.a.C(context);
        if (C == null) {
            return null;
        }
        try {
            if (b.h.b.a.o(C, resources, i)) {
                return Typeface.createFromFile(C.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            C.delete();
        }
    }

    public l f(l[] lVarArr, int i) {
        return (l) e(lVarArr, i, new a(this));
    }
}
