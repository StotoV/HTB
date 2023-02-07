package b.h.g;

import java.util.Comparator;
/* loaded from: classes.dex */
public class d {
    public static final Comparator<byte[]> a = new a();

    /* loaded from: classes.dex */
    public class a implements Comparator<byte[]> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            byte[] bArr3 = bArr;
            byte[] bArr4 = bArr2;
            if (bArr3.length == bArr4.length) {
                for (int i3 = 0; i3 < bArr3.length; i3++) {
                    if (bArr3[i3] != bArr4[i3]) {
                        i = bArr3[i3];
                        i2 = bArr4[i3];
                    }
                }
                return 0;
            }
            i = bArr3.length;
            i2 = bArr4.length;
            return i - i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0090 A[LOOP:1: B:15:0x004b->B:30:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0094 A[EDGE_INSN: B:84:0x0094->B:32:0x0094 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.h.g.k a(android.content.Context r21, b.h.g.e r22, android.os.CancellationSignal r23) {
        /*
            Method dump skipped, instructions count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.g.d.a(android.content.Context, b.h.g.e, android.os.CancellationSignal):b.h.g.k");
    }
}
