package b.h.d;

import android.graphics.Path;
import android.util.Log;
/* loaded from: classes.dex */
public class c {
    public char a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f413b;

    public c(char c2, float[] fArr) {
        this.a = c2;
        this.f413b = fArr;
    }

    public c(c cVar) {
        this.a = cVar.a;
        float[] fArr = cVar.f413b;
        this.f413b = b.h.b.a.n(fArr, 0, fArr.length);
    }

    public static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
        double d;
        double d2;
        double radians = Math.toRadians(f7);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d3 = f;
        Double.isNaN(d3);
        double d4 = f2;
        Double.isNaN(d4);
        double d5 = (d4 * sin) + (d3 * cos);
        double d6 = d3;
        double d7 = f5;
        Double.isNaN(d7);
        double d8 = d5 / d7;
        double d9 = -f;
        Double.isNaN(d9);
        Double.isNaN(d4);
        double d10 = (d4 * cos) + (d9 * sin);
        double d11 = f6;
        Double.isNaN(d11);
        double d12 = d10 / d11;
        double d13 = d4;
        double d14 = f3;
        Double.isNaN(d14);
        double d15 = f4;
        Double.isNaN(d15);
        Double.isNaN(d7);
        double d16 = ((d15 * sin) + (d14 * cos)) / d7;
        double d17 = -f3;
        Double.isNaN(d17);
        Double.isNaN(d15);
        Double.isNaN(d11);
        double d18 = ((d15 * cos) + (d17 * sin)) / d11;
        double d19 = d8 - d16;
        double d20 = d12 - d18;
        double d21 = (d8 + d16) / 2.0d;
        double d22 = (d12 + d18) / 2.0d;
        double d23 = (d20 * d20) + (d19 * d19);
        if (d23 == 0.0d) {
            Log.w("PathParser", " Points are coincident");
            return;
        }
        double d24 = (1.0d / d23) - 0.25d;
        if (d24 < 0.0d) {
            Log.w("PathParser", "Points are too far apart " + d23);
            float sqrt = (float) (Math.sqrt(d23) / 1.99999d);
            a(path, f, f2, f3, f4, f5 * sqrt, f6 * sqrt, f7, z, z2);
            return;
        }
        double sqrt2 = Math.sqrt(d24);
        double d25 = d19 * sqrt2;
        double d26 = sqrt2 * d20;
        if (z == z2) {
            d = d21 - d26;
            d2 = d22 + d25;
        } else {
            d = d21 + d26;
            d2 = d22 - d25;
        }
        double atan2 = Math.atan2(d12 - d2, d8 - d);
        double atan22 = Math.atan2(d18 - d2, d16 - d) - atan2;
        int i = 0;
        if (z2 != (atan22 >= 0.0d)) {
            atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
        }
        Double.isNaN(d7);
        double d27 = d * d7;
        Double.isNaN(d11);
        double d28 = d2 * d11;
        double d29 = (d27 * cos) - (d28 * sin);
        double d30 = (d28 * cos) + (d27 * sin);
        int ceil = (int) Math.ceil(Math.abs((atan22 * 4.0d) / 3.141592653589793d));
        double cos2 = Math.cos(radians);
        double sin2 = Math.sin(radians);
        double cos3 = Math.cos(atan2);
        double sin3 = Math.sin(atan2);
        Double.isNaN(d7);
        double d31 = -d7;
        double d32 = d31 * cos2;
        Double.isNaN(d11);
        double d33 = d11 * sin2;
        double d34 = (d32 * sin3) - (d33 * cos3);
        double d35 = d31 * sin2;
        Double.isNaN(d11);
        double d36 = d11 * cos2;
        double d37 = (cos3 * d36) + (sin3 * d35);
        double d38 = ceil;
        Double.isNaN(d38);
        Double.isNaN(d38);
        double d39 = atan22 / d38;
        double d40 = atan2;
        while (i < ceil) {
            double d41 = d40 + d39;
            double sin4 = Math.sin(d41);
            double cos4 = Math.cos(d41);
            Double.isNaN(d7);
            double d42 = d39;
            double d43 = (((d7 * cos2) * cos4) + d29) - (d33 * sin4);
            Double.isNaN(d7);
            double d44 = d29;
            double d45 = (d36 * sin4) + (d7 * sin2 * cos4) + d30;
            double d46 = (d32 * sin4) - (d33 * cos4);
            double d47 = (cos4 * d36) + (sin4 * d35);
            double d48 = d41 - d40;
            double tan = Math.tan(d48 / 2.0d);
            double sqrt3 = ((Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d) * Math.sin(d48)) / 3.0d;
            path.rLineTo(0.0f, 0.0f);
            path.cubicTo((float) ((d34 * sqrt3) + d6), (float) ((d37 * sqrt3) + d13), (float) (d43 - (sqrt3 * d46)), (float) (d45 - (sqrt3 * d47)), (float) d43, (float) d45);
            i++;
            d36 = d36;
            d35 = d35;
            ceil = ceil;
            cos2 = cos2;
            d40 = d41;
            d7 = d7;
            d37 = d47;
            d34 = d46;
            d6 = d43;
            d13 = d45;
            d39 = d42;
            d29 = d44;
        }
    }

    public static void b(c[] cVarArr, Path path) {
        int i;
        int i2;
        float[] fArr;
        char c2;
        int i3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        c[] cVarArr2 = cVarArr;
        float[] fArr2 = new float[6];
        char c3 = 'm';
        char c4 = 0;
        char c5 = 'm';
        int i4 = 0;
        while (i4 < cVarArr2.length) {
            char c6 = cVarArr2[i4].a;
            float[] fArr3 = cVarArr2[i4].f413b;
            float f20 = fArr2[c4];
            float f21 = fArr2[1];
            float f22 = fArr2[2];
            float f23 = fArr2[3];
            float f24 = fArr2[4];
            float f25 = fArr2[5];
            switch (c6) {
                case 'A':
                case 'a':
                    i = 7;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f24, f25);
                    f20 = f24;
                    f22 = f20;
                    f21 = f25;
                    f23 = f21;
                default:
                    i = 2;
                    break;
            }
            float f26 = f24;
            float f27 = f25;
            float f28 = f20;
            float f29 = f21;
            int i5 = 0;
            while (i5 < fArr3.length) {
                if (c6 != 'A') {
                    if (c6 != 'C') {
                        if (c6 == 'H') {
                            i2 = i5;
                            fArr = fArr3;
                            c2 = c6;
                            i3 = i4;
                            int i6 = i2 + 0;
                            path.lineTo(fArr[i6], f29);
                            f28 = fArr[i6];
                        } else if (c6 == 'Q') {
                            i2 = i5;
                            fArr = fArr3;
                            c2 = c6;
                            i3 = i4;
                            int i7 = i2 + 0;
                            int i8 = i2 + 1;
                            int i9 = i2 + 2;
                            int i10 = i2 + 3;
                            path.quadTo(fArr[i7], fArr[i8], fArr[i9], fArr[i10]);
                            f = fArr[i7];
                            f2 = fArr[i8];
                            f28 = fArr[i9];
                            f29 = fArr[i10];
                        } else if (c6 == 'V') {
                            i2 = i5;
                            fArr = fArr3;
                            c2 = c6;
                            i3 = i4;
                            int i11 = i2 + 0;
                            path.lineTo(f28, fArr[i11]);
                            f29 = fArr[i11];
                        } else if (c6 != 'a') {
                            if (c6 != 'c') {
                                if (c6 == 'h') {
                                    i2 = i5;
                                    int i12 = i2 + 0;
                                    path.rLineTo(fArr3[i12], 0.0f);
                                    f28 += fArr3[i12];
                                } else if (c6 != 'q') {
                                    if (c6 == 'v') {
                                        i2 = i5;
                                        f10 = f29;
                                        int i13 = i2 + 0;
                                        path.rLineTo(0.0f, fArr3[i13]);
                                        f11 = fArr3[i13];
                                    } else if (c6 == 'L') {
                                        i2 = i5;
                                        int i14 = i2 + 0;
                                        int i15 = i2 + 1;
                                        path.lineTo(fArr3[i14], fArr3[i15]);
                                        f28 = fArr3[i14];
                                        f29 = fArr3[i15];
                                    } else if (c6 == 'M') {
                                        i2 = i5;
                                        int i16 = i2 + 0;
                                        float f30 = fArr3[i16];
                                        int i17 = i2 + 1;
                                        float f31 = fArr3[i17];
                                        if (i2 > 0) {
                                            path.lineTo(fArr3[i16], fArr3[i17]);
                                            f28 = f30;
                                            f29 = f31;
                                        } else {
                                            path.moveTo(fArr3[i16], fArr3[i17]);
                                            f26 = f30;
                                            f27 = f31;
                                            f28 = f26;
                                            f29 = f27;
                                        }
                                    } else if (c6 == 'S') {
                                        i2 = i5;
                                        float f32 = f29;
                                        float f33 = f28;
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f12 = (f32 * 2.0f) - f23;
                                            f13 = (f33 * 2.0f) - f22;
                                        } else {
                                            f13 = f33;
                                            f12 = f32;
                                        }
                                        int i18 = i2 + 0;
                                        int i19 = i2 + 1;
                                        int i20 = i2 + 2;
                                        int i21 = i2 + 3;
                                        path.cubicTo(f13, f12, fArr3[i18], fArr3[i19], fArr3[i20], fArr3[i21]);
                                        float f34 = fArr3[i18];
                                        float f35 = fArr3[i19];
                                        f9 = fArr3[i20];
                                        f8 = fArr3[i21];
                                        f22 = f34;
                                        f23 = f35;
                                        f28 = f9;
                                        f29 = f8;
                                    } else if (c6 == 'T') {
                                        i2 = i5;
                                        float f36 = f29;
                                        float f37 = f28;
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f14 = (f37 * 2.0f) - f22;
                                            f15 = (f36 * 2.0f) - f23;
                                        } else {
                                            f14 = f37;
                                            f15 = f36;
                                        }
                                        int i22 = i2 + 0;
                                        int i23 = i2 + 1;
                                        path.quadTo(f14, f15, fArr3[i22], fArr3[i23]);
                                        f23 = f15;
                                        f22 = f14;
                                        fArr = fArr3;
                                        c2 = c6;
                                        i3 = i4;
                                        f28 = fArr3[i22];
                                        f29 = fArr3[i23];
                                    } else if (c6 == 'l') {
                                        i2 = i5;
                                        f10 = f29;
                                        int i24 = i2 + 0;
                                        int i25 = i2 + 1;
                                        path.rLineTo(fArr3[i24], fArr3[i25]);
                                        f28 += fArr3[i24];
                                        f11 = fArr3[i25];
                                    } else if (c6 == c3) {
                                        i2 = i5;
                                        int i26 = i2 + 0;
                                        f28 += fArr3[i26];
                                        int i27 = i2 + 1;
                                        f29 += fArr3[i27];
                                        if (i2 > 0) {
                                            path.rLineTo(fArr3[i26], fArr3[i27]);
                                        } else {
                                            path.rMoveTo(fArr3[i26], fArr3[i27]);
                                            f27 = f29;
                                            f26 = f28;
                                            f28 = f26;
                                            f29 = f27;
                                        }
                                    } else if (c6 != 's') {
                                        if (c6 == 't') {
                                            if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                                f18 = f28 - f22;
                                                f19 = f29 - f23;
                                            } else {
                                                f19 = 0.0f;
                                                f18 = 0.0f;
                                            }
                                            int i28 = i5 + 0;
                                            int i29 = i5 + 1;
                                            path.rQuadTo(f18, f19, fArr3[i28], fArr3[i29]);
                                            float f38 = f18 + f28;
                                            float f39 = f19 + f29;
                                            f28 += fArr3[i28];
                                            f29 += fArr3[i29];
                                            f23 = f39;
                                            f22 = f38;
                                        }
                                        i2 = i5;
                                    } else {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f16 = f29 - f23;
                                            f17 = f28 - f22;
                                        } else {
                                            f17 = 0.0f;
                                            f16 = 0.0f;
                                        }
                                        int i30 = i5 + 0;
                                        int i31 = i5 + 1;
                                        int i32 = i5 + 2;
                                        int i33 = i5 + 3;
                                        i2 = i5;
                                        f3 = f29;
                                        float f40 = f28;
                                        path.rCubicTo(f17, f16, fArr3[i30], fArr3[i31], fArr3[i32], fArr3[i33]);
                                        f4 = fArr3[i30] + f40;
                                        f5 = fArr3[i31] + f3;
                                        f6 = f40 + fArr3[i32];
                                        f7 = fArr3[i33];
                                    }
                                    f29 = f10 + f11;
                                } else {
                                    i2 = i5;
                                    f3 = f29;
                                    float f41 = f28;
                                    int i34 = i2 + 0;
                                    int i35 = i2 + 1;
                                    int i36 = i2 + 2;
                                    int i37 = i2 + 3;
                                    path.rQuadTo(fArr3[i34], fArr3[i35], fArr3[i36], fArr3[i37]);
                                    f4 = fArr3[i34] + f41;
                                    f5 = fArr3[i35] + f3;
                                    float f42 = f41 + fArr3[i36];
                                    float f43 = fArr3[i37];
                                    f6 = f42;
                                    f7 = f43;
                                }
                                fArr = fArr3;
                                c2 = c6;
                                i3 = i4;
                            } else {
                                i2 = i5;
                                f3 = f29;
                                float f44 = f28;
                                int i38 = i2 + 2;
                                int i39 = i2 + 3;
                                int i40 = i2 + 4;
                                int i41 = i2 + 5;
                                path.rCubicTo(fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i38], fArr3[i39], fArr3[i40], fArr3[i41]);
                                f4 = fArr3[i38] + f44;
                                f5 = fArr3[i39] + f3;
                                f6 = f44 + fArr3[i40];
                                f7 = fArr3[i41];
                            }
                            f8 = f3 + f7;
                            f22 = f4;
                            f23 = f5;
                            f9 = f6;
                            f28 = f9;
                            f29 = f8;
                            fArr = fArr3;
                            c2 = c6;
                            i3 = i4;
                        } else {
                            i2 = i5;
                            float f45 = f29;
                            float f46 = f28;
                            int i42 = i2 + 5;
                            int i43 = i2 + 6;
                            fArr = fArr3;
                            c2 = c6;
                            i3 = i4;
                            a(path, f46, f45, fArr3[i42] + f46, fArr3[i43] + f45, fArr3[i2 + 0], fArr3[i2 + 1], fArr3[i2 + 2], fArr3[i2 + 3] != 0.0f, fArr3[i2 + 4] != 0.0f);
                            f28 = f46 + fArr[i42];
                            f29 = f45 + fArr[i43];
                        }
                        i5 = i2 + i;
                        c5 = c2;
                        c6 = c5;
                        fArr3 = fArr;
                        i4 = i3;
                        c3 = 'm';
                    } else {
                        i2 = i5;
                        fArr = fArr3;
                        c2 = c6;
                        i3 = i4;
                        int i44 = i2 + 2;
                        int i45 = i2 + 3;
                        int i46 = i2 + 4;
                        int i47 = i2 + 5;
                        path.cubicTo(fArr[i2 + 0], fArr[i2 + 1], fArr[i44], fArr[i45], fArr[i46], fArr[i47]);
                        float f47 = fArr[i46];
                        float f48 = fArr[i47];
                        f = fArr[i44];
                        f28 = f47;
                        f29 = f48;
                        f2 = fArr[i45];
                    }
                    f22 = f;
                    f23 = f2;
                    i5 = i2 + i;
                    c5 = c2;
                    c6 = c5;
                    fArr3 = fArr;
                    i4 = i3;
                    c3 = 'm';
                } else {
                    i2 = i5;
                    fArr = fArr3;
                    c2 = c6;
                    i3 = i4;
                    int i48 = i2 + 5;
                    int i49 = i2 + 6;
                    a(path, f28, f29, fArr[i48], fArr[i49], fArr[i2 + 0], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3] != 0.0f, fArr[i2 + 4] != 0.0f);
                    f28 = fArr[i48];
                    f29 = fArr[i49];
                }
                f23 = f29;
                f22 = f28;
                i5 = i2 + i;
                c5 = c2;
                c6 = c5;
                fArr3 = fArr;
                i4 = i3;
                c3 = 'm';
            }
            int i50 = i4;
            fArr2[0] = f28;
            fArr2[1] = f29;
            fArr2[2] = f22;
            fArr2[3] = f23;
            fArr2[4] = f26;
            fArr2[5] = f27;
            i4 = i50 + 1;
            c5 = cVarArr[i50].a;
            c3 = 'm';
            c4 = 0;
            cVarArr2 = cVarArr;
        }
    }
}
