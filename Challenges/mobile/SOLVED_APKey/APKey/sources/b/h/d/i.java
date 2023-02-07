package b.h.d;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import b.h.g.l;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class i extends j {
    @Override // b.h.d.j
    public Typeface a(Context context, b.h.c.b.c cVar, Resources resources, int i) {
        try {
            b.h.c.b.d[] dVarArr = cVar.a;
            int length = dVarArr.length;
            int i2 = 0;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    break;
                }
                b.h.c.b.d dVar = dVarArr[i3];
                try {
                    Font.Builder weight = new Font.Builder(resources, dVar.f).setWeight(dVar.f402b);
                    if (!dVar.f403c) {
                        i4 = 0;
                    }
                    Font build = weight.setSlant(i4).setTtcIndex(dVar.e).setFontVariationSettings(dVar.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i3++;
            }
            if (builder == null) {
                return null;
            }
            int i5 = (i & 1) != 0 ? 700 : 400;
            if ((i & 2) != 0) {
                i2 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // b.h.d.j
    public Typeface b(Context context, CancellationSignal cancellationSignal, l[] lVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = lVarArr.length;
            int i2 = 0;
            FontFamily.Builder builder = null;
            int i3 = 0;
            while (true) {
                int i4 = 1;
                if (i3 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    int i5 = (i & 1) != 0 ? 700 : 400;
                    if ((i & 2) != 0) {
                        i2 = 1;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
                }
                l lVar = lVarArr[i3];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(lVar.a, "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(lVar.f441c);
                        if (!lVar.d) {
                            i4 = 0;
                        }
                        Font build = weight.setSlant(i4).setTtcIndex(lVar.f440b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable unused2) {
                        }
                        throw th;
                        break;
                    }
                } else if (openFileDescriptor == null) {
                    i3++;
                }
                openFileDescriptor.close();
                i3++;
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    @Override // b.h.d.j
    public Typeface c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // b.h.d.j
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // b.h.d.j
    public l f(l[] lVarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
