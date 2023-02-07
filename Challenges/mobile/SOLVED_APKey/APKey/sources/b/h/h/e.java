package b.h.h;
/* loaded from: classes.dex */
public final class e {
    public static final b.h.h.d a = new d(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final b.h.h.d f455b = new d(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final b.h.h.d f456c;
    public static final b.h.h.d d;

    /* loaded from: classes.dex */
    public static class a implements b {
        public static final a a = new a();

        @Override // b.h.h.e.b
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                byte directionality = Character.getDirectionality(charSequence.charAt(i));
                b.h.h.d dVar = e.a;
                if (directionality != 0) {
                    if (directionality != 1 && directionality != 2) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                break;
                            case 16:
                            case 17:
                                break;
                            default:
                                i4 = 2;
                                break;
                        }
                        i++;
                    }
                    i4 = 0;
                    i++;
                }
                i4 = 1;
                i++;
            }
            return i4;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        int a(CharSequence charSequence, int i, int i2);
    }

    /* loaded from: classes.dex */
    public static abstract class c implements b.h.h.d {
        public final b a;

        public c(b bVar) {
            this.a = bVar;
        }

        public abstract boolean a();

        public boolean b(CharSequence charSequence, int i, int i2) {
            if (i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            b bVar = this.a;
            if (bVar == null) {
                return a();
            }
            int a = bVar.a(charSequence, i, i2);
            if (a == 0) {
                return true;
            }
            if (a == 1) {
                return false;
            }
            return a();
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final boolean f457b;

        public d(b bVar, boolean z) {
            super(bVar);
            this.f457b = z;
        }

        @Override // b.h.h.e.c
        public boolean a() {
            return this.f457b;
        }
    }

    static {
        a aVar = a.a;
        f456c = new d(aVar, false);
        d = new d(aVar, true);
    }
}
