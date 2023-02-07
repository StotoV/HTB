package b.h.h;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
/* loaded from: classes.dex */
public class c implements Spannable {

    /* loaded from: classes.dex */
    public static final class a {
        public final TextPaint a;

        /* renamed from: b  reason: collision with root package name */
        public final TextDirectionHeuristic f453b;

        /* renamed from: c  reason: collision with root package name */
        public final int f454c;
        public final int d;

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.f453b = params.getTextDirection();
            this.f454c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        @SuppressLint({"NewApi"})
        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.a = textPaint;
            this.f453b = textDirectionHeuristic;
            this.f454c = i;
            this.d = i2;
        }

        public boolean a(a aVar) {
            int i = Build.VERSION.SDK_INT;
            if ((i < 23 || (this.f454c == aVar.f454c && this.d == aVar.d)) && this.a.getTextSize() == aVar.a.getTextSize() && this.a.getTextScaleX() == aVar.a.getTextScaleX() && this.a.getTextSkewX() == aVar.a.getTextSkewX()) {
                if ((i >= 21 && (this.a.getLetterSpacing() != aVar.a.getLetterSpacing() || !TextUtils.equals(this.a.getFontFeatureSettings(), aVar.a.getFontFeatureSettings()))) || this.a.getFlags() != aVar.a.getFlags()) {
                    return false;
                }
                if (i >= 24) {
                    if (!this.a.getTextLocales().equals(aVar.a.getTextLocales())) {
                        return false;
                    }
                } else if (i >= 17 && !this.a.getTextLocale().equals(aVar.a.getTextLocale())) {
                    return false;
                }
                return this.a.getTypeface() == null ? aVar.a.getTypeface() == null : this.a.getTypeface().equals(aVar.a.getTypeface());
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f453b == aVar.f453b;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 24) {
                return b.h.b.a.E(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.f453b, Integer.valueOf(this.f454c), Integer.valueOf(this.d));
            }
            if (i >= 21) {
                return b.h.b.a.E(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.f453b, Integer.valueOf(this.f454c), Integer.valueOf(this.d));
            }
            if (i < 18 && i < 17) {
                return b.h.b.a.E(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.f453b, Integer.valueOf(this.f454c), Integer.valueOf(this.d));
            }
            return b.h.b.a.E(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.f453b, Integer.valueOf(this.f454c), Integer.valueOf(this.d));
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00ca  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                Method dump skipped, instructions count: 296
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: b.h.h.c.a.toString():java.lang.String");
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        throw null;
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        int i3 = Build.VERSION.SDK_INT;
        throw null;
    }

    @Override // java.lang.CharSequence
    public int length() {
        throw null;
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        throw null;
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            int i = Build.VERSION.SDK_INT;
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            int i4 = Build.VERSION.SDK_INT;
            throw null;
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        throw null;
    }
}
