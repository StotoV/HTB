package b.h.h;

import android.text.SpannableStringBuilder;
import b.h.h.e;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {
    public static final d d;
    public static final String e;
    public static final String f;
    public static final a g;
    public static final a h;
    public final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final int f448b;

    /* renamed from: c  reason: collision with root package name */
    public final d f449c;

    /* renamed from: b.h.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0017a {
        public static final byte[] e = new byte[1792];
        public final CharSequence a;

        /* renamed from: b  reason: collision with root package name */
        public final int f450b;

        /* renamed from: c  reason: collision with root package name */
        public int f451c;
        public char d;

        static {
            for (int i = 0; i < 1792; i++) {
                e[i] = Character.getDirectionality(i);
            }
        }

        public C0017a(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.f450b = charSequence.length();
        }

        public byte a() {
            char charAt = this.a.charAt(this.f451c - 1);
            this.d = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.f451c);
                this.f451c -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f451c--;
            char c2 = this.d;
            return c2 < 1792 ? e[c2] : Character.getDirectionality(c2);
        }
    }

    static {
        d dVar = e.f456c;
        d = dVar;
        e = Character.toString((char) 8206);
        f = Character.toString((char) 8207);
        g = new a(false, 2, dVar);
        h = new a(true, 2, dVar);
    }

    public a(boolean z, int i, d dVar) {
        this.a = z;
        this.f448b = i;
        this.f449c = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r3 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
        if (r4 == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
        if (r0.f451c <= 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007f, code lost:
        switch(r0.a()) {
            case 14: goto L62;
            case 15: goto L62;
            case 16: goto L57;
            case 17: goto L57;
            case 18: goto L53;
            default: goto L65;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0086, code lost:
        if (r3 != r5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0088, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
        if (r3 != r5) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0091, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:?, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.CharSequence r9) {
        /*
            b.h.h.a$a r0 = new b.h.h.a$a
            r1 = 0
            r0.<init>(r9, r1)
            r0.f451c = r1
            r9 = -1
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
        Ld:
            int r6 = r0.f451c
            int r7 = r0.f450b
            if (r6 >= r7) goto L70
            if (r3 != 0) goto L70
            java.lang.CharSequence r7 = r0.a
            char r6 = r7.charAt(r6)
            r0.d = r6
            boolean r6 = java.lang.Character.isHighSurrogate(r6)
            if (r6 == 0) goto L39
            java.lang.CharSequence r6 = r0.a
            int r7 = r0.f451c
            int r6 = java.lang.Character.codePointAt(r6, r7)
            int r7 = r0.f451c
            int r8 = java.lang.Character.charCount(r6)
            int r8 = r8 + r7
            r0.f451c = r8
            byte r6 = java.lang.Character.getDirectionality(r6)
            goto L4d
        L39:
            int r6 = r0.f451c
            int r6 = r6 + r2
            r0.f451c = r6
            char r6 = r0.d
            r7 = 1792(0x700, float:2.511E-42)
            if (r6 >= r7) goto L49
            byte[] r7 = b.h.h.a.C0017a.e
            r6 = r7[r6]
            goto L4d
        L49:
            byte r6 = java.lang.Character.getDirectionality(r6)
        L4d:
            if (r6 == 0) goto L6b
            if (r6 == r2) goto L68
            r7 = 2
            if (r6 == r7) goto L68
            r7 = 9
            if (r6 == r7) goto Ld
            switch(r6) {
                case 14: goto L64;
                case 15: goto L64;
                case 16: goto L60;
                case 17: goto L60;
                case 18: goto L5c;
                default: goto L5b;
            }
        L5b:
            goto L6e
        L5c:
            int r5 = r5 + (-1)
            r4 = 0
            goto Ld
        L60:
            int r5 = r5 + 1
            r4 = 1
            goto Ld
        L64:
            int r5 = r5 + 1
            r4 = -1
            goto Ld
        L68:
            if (r5 != 0) goto L6e
            goto L88
        L6b:
            if (r5 != 0) goto L6e
            goto L8c
        L6e:
            r3 = r5
            goto Ld
        L70:
            if (r3 != 0) goto L73
            goto L91
        L73:
            if (r4 == 0) goto L77
            r1 = r4
            goto L91
        L77:
            int r4 = r0.f451c
            if (r4 <= 0) goto L91
            byte r4 = r0.a()
            switch(r4) {
                case 14: goto L8a;
                case 15: goto L8a;
                case 16: goto L86;
                case 17: goto L86;
                case 18: goto L83;
                default: goto L82;
            }
        L82:
            goto L77
        L83:
            int r5 = r5 + 1
            goto L77
        L86:
            if (r3 != r5) goto L8e
        L88:
            r1 = 1
            goto L91
        L8a:
            if (r3 != r5) goto L8e
        L8c:
            r1 = -1
            goto L91
        L8e:
            int r5 = r5 + (-1)
            goto L77
        L91:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.h.a.a(java.lang.CharSequence):int");
    }

    public static int b(CharSequence charSequence) {
        C0017a c0017a = new C0017a(charSequence, false);
        c0017a.f451c = c0017a.f450b;
        int i = 0;
        int i2 = 0;
        while (c0017a.f451c > 0) {
            byte a = c0017a.a();
            if (a != 0) {
                if (a == 1 || a == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (a != 9) {
                    switch (a) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else if (i == 0) {
                return -1;
            } else {
                if (i2 == 0) {
                    i2 = i;
                }
            }
        }
        return 0;
    }

    public static a c() {
        boolean z = true;
        if (f.a(Locale.getDefault()) != 1) {
            z = false;
        }
        d dVar = d;
        if (dVar == d) {
            return z ? h : g;
        }
        return new a(z, 2, dVar);
    }

    public CharSequence d(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean b2 = ((e.c) dVar).b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String str = "";
        if (((this.f448b & 2) != 0) && z) {
            boolean b3 = ((e.c) (b2 ? e.f455b : e.a)).b(charSequence, 0, charSequence.length());
            spannableStringBuilder.append((CharSequence) ((this.a || (!b3 && a(charSequence) != 1)) ? (!this.a || (b3 && a(charSequence) != -1)) ? str : f : e));
        }
        if (b2 != this.a) {
            spannableStringBuilder.append(b2 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            boolean b4 = ((e.c) (b2 ? e.f455b : e.a)).b(charSequence, 0, charSequence.length());
            if (!this.a && (b4 || b(charSequence) == 1)) {
                str = e;
            } else if (this.a && (!b4 || b(charSequence) == -1)) {
                str = f;
            }
            spannableStringBuilder.append((CharSequence) str);
        }
        return spannableStringBuilder;
    }
}
