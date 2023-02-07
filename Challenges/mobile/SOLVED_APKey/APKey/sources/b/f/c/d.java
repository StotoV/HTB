package b.f.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.f.c.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class d {
    public static final int[] d = {0, 4, 8};
    public static SparseIntArray e;
    public HashMap<String, b.f.c.a> a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f374b = true;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<Integer, a> f375c = new HashMap<>();

    /* loaded from: classes.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final C0015d f376b = new C0015d();

        /* renamed from: c  reason: collision with root package name */
        public final c f377c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap<String, b.f.c.a> f = new HashMap<>();

        public void a(ConstraintLayout.a aVar) {
            b bVar = this.d;
            aVar.d = bVar.h;
            aVar.e = bVar.i;
            aVar.f = bVar.j;
            aVar.g = bVar.k;
            aVar.h = bVar.l;
            aVar.i = bVar.m;
            aVar.j = bVar.n;
            aVar.k = bVar.o;
            aVar.l = bVar.p;
            aVar.p = bVar.q;
            aVar.q = bVar.r;
            aVar.r = bVar.s;
            aVar.s = bVar.t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = bVar.D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = bVar.E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = bVar.G;
            aVar.x = bVar.O;
            aVar.y = bVar.N;
            aVar.u = bVar.K;
            aVar.w = bVar.M;
            aVar.z = bVar.u;
            aVar.A = bVar.v;
            aVar.m = bVar.x;
            aVar.n = bVar.y;
            b bVar2 = this.d;
            aVar.o = bVar2.z;
            aVar.B = bVar2.w;
            aVar.P = bVar2.A;
            aVar.Q = bVar2.B;
            aVar.E = bVar2.P;
            aVar.D = bVar2.Q;
            aVar.G = bVar2.S;
            aVar.F = bVar2.R;
            aVar.S = bVar2.h0;
            aVar.T = bVar2.i0;
            aVar.H = bVar2.T;
            aVar.I = bVar2.U;
            aVar.L = bVar2.V;
            aVar.M = bVar2.W;
            aVar.J = bVar2.X;
            aVar.K = bVar2.Y;
            aVar.N = bVar2.Z;
            aVar.O = bVar2.a0;
            aVar.R = bVar2.C;
            aVar.f54c = bVar2.g;
            aVar.a = bVar2.e;
            aVar.f53b = bVar2.f;
            ((ViewGroup.MarginLayoutParams) aVar).width = bVar2.f379c;
            ((ViewGroup.MarginLayoutParams) aVar).height = bVar2.d;
            String str = bVar2.g0;
            if (str != null) {
                aVar.U = str;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.d.I);
                aVar.setMarginEnd(this.d.H);
            }
            aVar.a();
        }

        public final void b(int i, ConstraintLayout.a aVar) {
            this.a = i;
            b bVar = this.d;
            bVar.h = aVar.d;
            bVar.i = aVar.e;
            bVar.j = aVar.f;
            bVar.k = aVar.g;
            bVar.l = aVar.h;
            bVar.m = aVar.i;
            bVar.n = aVar.j;
            bVar.o = aVar.k;
            bVar.p = aVar.l;
            bVar.q = aVar.p;
            bVar.r = aVar.q;
            bVar.s = aVar.r;
            bVar.t = aVar.s;
            bVar.u = aVar.z;
            bVar.v = aVar.A;
            bVar.w = aVar.B;
            bVar.x = aVar.m;
            bVar.y = aVar.n;
            bVar.z = aVar.o;
            bVar.A = aVar.P;
            bVar.B = aVar.Q;
            bVar.C = aVar.R;
            bVar.g = aVar.f54c;
            bVar.e = aVar.a;
            bVar.f = aVar.f53b;
            b bVar2 = this.d;
            bVar2.f379c = ((ViewGroup.MarginLayoutParams) aVar).width;
            bVar2.d = ((ViewGroup.MarginLayoutParams) aVar).height;
            bVar2.D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            bVar2.E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            bVar2.F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            bVar2.P = aVar.E;
            bVar2.Q = aVar.D;
            bVar2.S = aVar.G;
            bVar2.R = aVar.F;
            bVar2.h0 = aVar.S;
            bVar2.i0 = aVar.T;
            bVar2.T = aVar.H;
            bVar2.U = aVar.I;
            bVar2.V = aVar.L;
            bVar2.W = aVar.M;
            bVar2.X = aVar.J;
            bVar2.Y = aVar.K;
            bVar2.Z = aVar.N;
            bVar2.a0 = aVar.O;
            bVar2.g0 = aVar.U;
            bVar2.K = aVar.u;
            bVar2.M = aVar.w;
            bVar2.J = aVar.t;
            bVar2.L = aVar.v;
            b bVar3 = this.d;
            bVar3.O = aVar.x;
            bVar3.N = aVar.y;
            if (Build.VERSION.SDK_INT >= 17) {
                bVar3.H = aVar.getMarginEnd();
                this.d.I = aVar.getMarginStart();
            }
        }

        public final void c(int i, e.a aVar) {
            b(i, aVar);
            this.f376b.d = aVar.m0;
            e eVar = this.e;
            eVar.f384b = aVar.p0;
            eVar.f385c = aVar.q0;
            eVar.d = aVar.r0;
            eVar.e = aVar.s0;
            eVar.f = aVar.t0;
            eVar.g = aVar.u0;
            eVar.h = aVar.v0;
            eVar.i = aVar.w0;
            eVar.j = aVar.x0;
            eVar.k = aVar.y0;
            eVar.m = aVar.o0;
            eVar.l = aVar.n0;
        }

        public Object clone() {
            a aVar = new a();
            b bVar = aVar.d;
            b bVar2 = this.d;
            bVar.getClass();
            bVar.a = bVar2.a;
            bVar.f379c = bVar2.f379c;
            bVar.f378b = bVar2.f378b;
            bVar.d = bVar2.d;
            bVar.e = bVar2.e;
            bVar.f = bVar2.f;
            bVar.g = bVar2.g;
            bVar.h = bVar2.h;
            bVar.i = bVar2.i;
            bVar.j = bVar2.j;
            bVar.k = bVar2.k;
            bVar.l = bVar2.l;
            bVar.m = bVar2.m;
            bVar.n = bVar2.n;
            bVar.o = bVar2.o;
            bVar.p = bVar2.p;
            bVar.q = bVar2.q;
            bVar.r = bVar2.r;
            bVar.s = bVar2.s;
            bVar.t = bVar2.t;
            bVar.u = bVar2.u;
            bVar.v = bVar2.v;
            bVar.w = bVar2.w;
            bVar.x = bVar2.x;
            bVar.y = bVar2.y;
            bVar.z = bVar2.z;
            bVar.A = bVar2.A;
            bVar.B = bVar2.B;
            bVar.C = bVar2.C;
            bVar.D = bVar2.D;
            bVar.E = bVar2.E;
            bVar.F = bVar2.F;
            bVar.G = bVar2.G;
            bVar.H = bVar2.H;
            bVar.I = bVar2.I;
            bVar.J = bVar2.J;
            bVar.K = bVar2.K;
            bVar.L = bVar2.L;
            bVar.M = bVar2.M;
            bVar.N = bVar2.N;
            bVar.O = bVar2.O;
            bVar.P = bVar2.P;
            bVar.Q = bVar2.Q;
            bVar.R = bVar2.R;
            bVar.S = bVar2.S;
            bVar.T = bVar2.T;
            bVar.U = bVar2.U;
            bVar.V = bVar2.V;
            bVar.W = bVar2.W;
            bVar.X = bVar2.X;
            bVar.Y = bVar2.Y;
            bVar.Z = bVar2.Z;
            bVar.a0 = bVar2.a0;
            bVar.b0 = bVar2.b0;
            bVar.c0 = bVar2.c0;
            bVar.d0 = bVar2.d0;
            bVar.g0 = bVar2.g0;
            int[] iArr = bVar2.e0;
            if (iArr != null) {
                bVar.e0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                bVar.e0 = null;
            }
            bVar.f0 = bVar2.f0;
            bVar.h0 = bVar2.h0;
            bVar.i0 = bVar2.i0;
            bVar.j0 = bVar2.j0;
            c cVar = aVar.f377c;
            c cVar2 = this.f377c;
            cVar.getClass();
            cVar.a = cVar2.a;
            cVar.f380b = cVar2.f380b;
            cVar.f381c = cVar2.f381c;
            cVar.d = cVar2.d;
            cVar.e = cVar2.e;
            cVar.g = cVar2.g;
            cVar.f = cVar2.f;
            C0015d c0015d = aVar.f376b;
            C0015d c0015d2 = this.f376b;
            c0015d.getClass();
            c0015d.a = c0015d2.a;
            c0015d.f382b = c0015d2.f382b;
            c0015d.d = c0015d2.d;
            c0015d.e = c0015d2.e;
            c0015d.f383c = c0015d2.f383c;
            e eVar = aVar.e;
            e eVar2 = this.e;
            eVar.getClass();
            eVar.a = eVar2.a;
            eVar.f384b = eVar2.f384b;
            eVar.f385c = eVar2.f385c;
            eVar.d = eVar2.d;
            eVar.e = eVar2.e;
            eVar.f = eVar2.f;
            eVar.g = eVar2.g;
            eVar.h = eVar2.h;
            eVar.i = eVar2.i;
            eVar.j = eVar2.j;
            eVar.k = eVar2.k;
            eVar.l = eVar2.l;
            eVar.m = eVar2.m;
            aVar.a = this.a;
            return aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static SparseIntArray k0;

        /* renamed from: c  reason: collision with root package name */
        public int f379c;
        public int d;
        public int[] e0;
        public String f0;
        public String g0;
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f378b = false;
        public int e = -1;
        public int f = -1;
        public float g = -1.0f;
        public int h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public float u = 0.5f;
        public float v = 0.5f;
        public String w = null;
        public int x = -1;
        public int y = 0;
        public float z = 0.0f;
        public int A = -1;
        public int B = -1;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = -1;
        public int I = -1;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = -1;
        public int N = -1;
        public int O = -1;
        public float P = -1.0f;
        public float Q = -1.0f;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public int U = 0;
        public int V = -1;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public float Z = 1.0f;
        public float a0 = 1.0f;
        public int b0 = -1;
        public int c0 = 0;
        public int d0 = -1;
        public boolean h0 = false;
        public boolean i0 = false;
        public boolean j0 = true;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            k0 = sparseIntArray;
            sparseIntArray.append(39, 24);
            k0.append(40, 25);
            k0.append(42, 28);
            k0.append(43, 29);
            k0.append(48, 35);
            k0.append(47, 34);
            k0.append(21, 4);
            k0.append(20, 3);
            k0.append(18, 1);
            k0.append(56, 6);
            k0.append(57, 7);
            k0.append(28, 17);
            k0.append(29, 18);
            k0.append(30, 19);
            k0.append(0, 26);
            k0.append(44, 31);
            k0.append(45, 32);
            k0.append(27, 10);
            k0.append(26, 9);
            k0.append(60, 13);
            k0.append(63, 16);
            k0.append(61, 14);
            k0.append(58, 11);
            k0.append(62, 15);
            k0.append(59, 12);
            k0.append(51, 38);
            k0.append(37, 37);
            k0.append(36, 39);
            k0.append(50, 40);
            k0.append(35, 20);
            k0.append(49, 36);
            k0.append(25, 5);
            k0.append(38, 76);
            k0.append(46, 76);
            k0.append(41, 76);
            k0.append(19, 76);
            k0.append(17, 76);
            k0.append(3, 23);
            k0.append(5, 27);
            k0.append(7, 30);
            k0.append(8, 8);
            k0.append(4, 33);
            k0.append(6, 2);
            k0.append(1, 22);
            k0.append(2, 21);
            k0.append(22, 61);
            k0.append(24, 62);
            k0.append(23, 63);
            k0.append(55, 69);
            k0.append(34, 70);
            k0.append(12, 71);
            k0.append(10, 72);
            k0.append(11, 73);
            k0.append(13, 74);
            k0.append(9, 75);
        }

        public void a(Context context, AttributeSet attributeSet) {
            StringBuilder sb;
            String str;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.e);
            this.f378b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = k0.get(index);
                if (i2 == 80) {
                    this.h0 = obtainStyledAttributes.getBoolean(index, this.h0);
                } else if (i2 != 81) {
                    switch (i2) {
                        case 1:
                            int i3 = this.p;
                            int[] iArr = d.d;
                            int resourceId = obtainStyledAttributes.getResourceId(index, i3);
                            if (resourceId == -1) {
                                resourceId = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.p = resourceId;
                            continue;
                        case 2:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 3:
                            int i4 = this.o;
                            int[] iArr2 = d.d;
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, i4);
                            if (resourceId2 == -1) {
                                resourceId2 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.o = resourceId2;
                            continue;
                        case 4:
                            int i5 = this.n;
                            int[] iArr3 = d.d;
                            int resourceId3 = obtainStyledAttributes.getResourceId(index, i5);
                            if (resourceId3 == -1) {
                                resourceId3 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.n = resourceId3;
                            continue;
                        case 5:
                            this.w = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.A = obtainStyledAttributes.getDimensionPixelOffset(index, this.A);
                            continue;
                        case 7:
                            this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                            continue;
                        case 8:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                                break;
                            } else {
                                continue;
                            }
                        case 9:
                            int i6 = this.t;
                            int[] iArr4 = d.d;
                            int resourceId4 = obtainStyledAttributes.getResourceId(index, i6);
                            if (resourceId4 == -1) {
                                resourceId4 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.t = resourceId4;
                            continue;
                        case 10:
                            int i7 = this.s;
                            int[] iArr5 = d.d;
                            int resourceId5 = obtainStyledAttributes.getResourceId(index, i7);
                            if (resourceId5 == -1) {
                                resourceId5 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.s = resourceId5;
                            continue;
                        case 11:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 12:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 13:
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 14:
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            continue;
                        case 15:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 16:
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 17:
                            this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                            continue;
                        case 18:
                            this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                            continue;
                        case 19:
                            this.g = obtainStyledAttributes.getFloat(index, this.g);
                            continue;
                        case 20:
                            this.u = obtainStyledAttributes.getFloat(index, this.u);
                            continue;
                        case 21:
                            this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                            continue;
                        case 22:
                            this.f379c = obtainStyledAttributes.getLayoutDimension(index, this.f379c);
                            continue;
                        case 23:
                            this.D = obtainStyledAttributes.getDimensionPixelSize(index, this.D);
                            continue;
                        case 24:
                            int i8 = this.h;
                            int[] iArr6 = d.d;
                            int resourceId6 = obtainStyledAttributes.getResourceId(index, i8);
                            if (resourceId6 == -1) {
                                resourceId6 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.h = resourceId6;
                            continue;
                        case 25:
                            int i9 = this.i;
                            int[] iArr7 = d.d;
                            int resourceId7 = obtainStyledAttributes.getResourceId(index, i9);
                            if (resourceId7 == -1) {
                                resourceId7 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.i = resourceId7;
                            continue;
                        case 26:
                            this.C = obtainStyledAttributes.getInt(index, this.C);
                            continue;
                        case 27:
                            this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                            continue;
                        case 28:
                            int i10 = this.j;
                            int[] iArr8 = d.d;
                            int resourceId8 = obtainStyledAttributes.getResourceId(index, i10);
                            if (resourceId8 == -1) {
                                resourceId8 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.j = resourceId8;
                            continue;
                        case 29:
                            int i11 = this.k;
                            int[] iArr9 = d.d;
                            int resourceId9 = obtainStyledAttributes.getResourceId(index, i11);
                            if (resourceId9 == -1) {
                                resourceId9 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.k = resourceId9;
                            continue;
                        case 30:
                            if (Build.VERSION.SDK_INT >= 17) {
                                this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                                break;
                            } else {
                                continue;
                            }
                        case 31:
                            int i12 = this.q;
                            int[] iArr10 = d.d;
                            int resourceId10 = obtainStyledAttributes.getResourceId(index, i12);
                            if (resourceId10 == -1) {
                                resourceId10 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.q = resourceId10;
                            continue;
                        case 32:
                            int i13 = this.r;
                            int[] iArr11 = d.d;
                            int resourceId11 = obtainStyledAttributes.getResourceId(index, i13);
                            if (resourceId11 == -1) {
                                resourceId11 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.r = resourceId11;
                            continue;
                        case 33:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 34:
                            int i14 = this.m;
                            int[] iArr12 = d.d;
                            int resourceId12 = obtainStyledAttributes.getResourceId(index, i14);
                            if (resourceId12 == -1) {
                                resourceId12 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.m = resourceId12;
                            continue;
                        case 35:
                            int i15 = this.l;
                            int[] iArr13 = d.d;
                            int resourceId13 = obtainStyledAttributes.getResourceId(index, i15);
                            if (resourceId13 == -1) {
                                resourceId13 = obtainStyledAttributes.getInt(index, -1);
                            }
                            this.l = resourceId13;
                            continue;
                        case 36:
                            this.v = obtainStyledAttributes.getFloat(index, this.v);
                            continue;
                        case 37:
                            this.Q = obtainStyledAttributes.getFloat(index, this.Q);
                            continue;
                        case 38:
                            this.P = obtainStyledAttributes.getFloat(index, this.P);
                            continue;
                        case 39:
                            this.R = obtainStyledAttributes.getInt(index, this.R);
                            continue;
                        case 40:
                            this.S = obtainStyledAttributes.getInt(index, this.S);
                            continue;
                        default:
                            switch (i2) {
                                case 54:
                                    this.T = obtainStyledAttributes.getInt(index, this.T);
                                    continue;
                                case 55:
                                    this.U = obtainStyledAttributes.getInt(index, this.U);
                                    continue;
                                case 56:
                                    this.V = obtainStyledAttributes.getDimensionPixelSize(index, this.V);
                                    continue;
                                case 57:
                                    this.W = obtainStyledAttributes.getDimensionPixelSize(index, this.W);
                                    continue;
                                case 58:
                                    this.X = obtainStyledAttributes.getDimensionPixelSize(index, this.X);
                                    continue;
                                case 59:
                                    this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                    continue;
                                    continue;
                                default:
                                    switch (i2) {
                                        case 61:
                                            int i16 = this.x;
                                            int[] iArr14 = d.d;
                                            int resourceId14 = obtainStyledAttributes.getResourceId(index, i16);
                                            if (resourceId14 == -1) {
                                                resourceId14 = obtainStyledAttributes.getInt(index, -1);
                                            }
                                            this.x = resourceId14;
                                            continue;
                                        case 62:
                                            this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                                            continue;
                                        case 63:
                                            this.z = obtainStyledAttributes.getFloat(index, this.z);
                                            continue;
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 70:
                                                    this.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    break;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    break;
                                                case 72:
                                                    this.b0 = obtainStyledAttributes.getInt(index, this.b0);
                                                    break;
                                                case 73:
                                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                                    break;
                                                case 74:
                                                    this.f0 = obtainStyledAttributes.getString(index);
                                                    break;
                                                case 75:
                                                    this.j0 = obtainStyledAttributes.getBoolean(index, this.j0);
                                                    break;
                                                case 76:
                                                    sb = new StringBuilder();
                                                    str = "unused attribute 0x";
                                                    sb.append(str);
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(k0.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    break;
                                                case 77:
                                                    this.g0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    sb = new StringBuilder();
                                                    str = "Unknown attribute 0x";
                                                    sb.append(str);
                                                    sb.append(Integer.toHexString(index));
                                                    sb.append("   ");
                                                    sb.append(k0.get(index));
                                                    Log.w("ConstraintSet", sb.toString());
                                                    break;
                                            }
                                    }
                            }
                    }
                } else {
                    this.i0 = obtainStyledAttributes.getBoolean(index, this.i0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static SparseIntArray h;
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f380b = -1;

        /* renamed from: c  reason: collision with root package name */
        public String f381c = null;
        public int d = -1;
        public int e = 0;
        public float f = Float.NaN;
        public float g = Float.NaN;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            h = sparseIntArray;
            sparseIntArray.append(2, 1);
            h.append(4, 2);
            h.append(5, 3);
            h.append(1, 4);
            h.append(0, 5);
            h.append(3, 6);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.f);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (h.get(index)) {
                    case 1:
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 2:
                        this.d = obtainStyledAttributes.getInt(index, this.d);
                        break;
                    case 3:
                        this.f381c = obtainStyledAttributes.peekValue(index).type == 3 ? obtainStyledAttributes.getString(index) : b.f.a.a.a.a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        int i2 = this.f380b;
                        int[] iArr = d.d;
                        int resourceId = obtainStyledAttributes.getResourceId(index, i2);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        this.f380b = resourceId;
                        break;
                    case 6:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b.f.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0015d {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f382b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f383c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.g);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 1) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                } else if (index == 0) {
                    int i2 = obtainStyledAttributes.getInt(index, this.f382b);
                    this.f382b = i2;
                    int[] iArr = d.d;
                    this.f382b = d.d[i2];
                } else if (index == 4) {
                    this.f383c = obtainStyledAttributes.getInt(index, this.f383c);
                } else if (index == 3) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static SparseIntArray n;
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public float f384b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f385c = 0.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public float i = 0.0f;
        public float j = 0.0f;
        public float k = 0.0f;
        public boolean l = false;
        public float m = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            n = sparseIntArray;
            sparseIntArray.append(6, 1);
            n.append(7, 2);
            n.append(8, 3);
            n.append(4, 4);
            n.append(5, 5);
            n.append(0, 6);
            n.append(1, 7);
            n.append(2, 8);
            n.append(3, 9);
            n.append(9, 10);
            n.append(10, 11);
        }

        public void a(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.i);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (n.get(index)) {
                    case 1:
                        this.f384b = obtainStyledAttributes.getFloat(index, this.f384b);
                        break;
                    case 2:
                        this.f385c = obtainStyledAttributes.getFloat(index, this.f385c);
                        break;
                    case 3:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.i = obtainStyledAttributes.getDimension(index, this.i);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 10:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.k = obtainStyledAttributes.getDimension(index, this.k);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (Build.VERSION.SDK_INT >= 21) {
                            this.l = true;
                            this.m = obtainStyledAttributes.getDimension(index, this.m);
                            break;
                        } else {
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        e = sparseIntArray;
        sparseIntArray.append(77, 25);
        e.append(78, 26);
        e.append(80, 29);
        e.append(81, 30);
        e.append(87, 36);
        e.append(86, 35);
        e.append(59, 4);
        e.append(58, 3);
        e.append(56, 1);
        e.append(95, 6);
        e.append(96, 7);
        e.append(66, 17);
        e.append(67, 18);
        e.append(68, 19);
        e.append(0, 27);
        e.append(82, 32);
        e.append(83, 33);
        e.append(65, 10);
        e.append(64, 9);
        e.append(99, 13);
        e.append(102, 16);
        e.append(100, 14);
        e.append(97, 11);
        e.append(101, 15);
        e.append(98, 12);
        e.append(90, 40);
        e.append(75, 39);
        e.append(74, 41);
        e.append(89, 42);
        e.append(73, 20);
        e.append(88, 37);
        e.append(63, 5);
        e.append(76, 82);
        e.append(85, 82);
        e.append(79, 82);
        e.append(57, 82);
        e.append(55, 82);
        e.append(5, 24);
        e.append(7, 28);
        e.append(23, 31);
        e.append(24, 8);
        e.append(6, 34);
        e.append(8, 2);
        e.append(3, 23);
        e.append(4, 21);
        e.append(2, 22);
        e.append(13, 43);
        e.append(26, 44);
        e.append(21, 45);
        e.append(22, 46);
        e.append(20, 60);
        e.append(18, 47);
        e.append(19, 48);
        e.append(14, 49);
        e.append(15, 50);
        e.append(16, 51);
        e.append(17, 52);
        e.append(25, 53);
        e.append(91, 54);
        e.append(69, 55);
        e.append(92, 56);
        e.append(70, 57);
        e.append(93, 58);
        e.append(71, 59);
        e.append(60, 61);
        e.append(62, 62);
        e.append(61, 63);
        e.append(27, 64);
        e.append(107, 65);
        e.append(34, 66);
        e.append(108, 67);
        e.append(104, 79);
        e.append(1, 38);
        e.append(103, 68);
        e.append(94, 69);
        e.append(72, 70);
        e.append(31, 71);
        e.append(29, 72);
        e.append(30, 73);
        e.append(32, 74);
        e.append(28, 75);
        e.append(105, 76);
        e.append(84, 77);
        e.append(109, 78);
        e.append(54, 80);
        e.append(53, 81);
    }

    public void a(ConstraintLayout constraintLayout, boolean z) {
        int i;
        Iterator<String> it;
        String str;
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f375c.keySet());
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!this.f375c.containsKey(Integer.valueOf(id))) {
                StringBuilder g = c.a.a.a.a.g("id unknown ");
                try {
                    str = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str = "UNKNOWN";
                }
                g.append(str);
                Log.w("ConstraintSet", g.toString());
            } else if (this.f374b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.f375c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.f375c.get(Integer.valueOf(id));
                        if (childAt instanceof Barrier) {
                            aVar.d.d0 = 1;
                        }
                        int i3 = aVar.d.d0;
                        if (i3 != -1 && i3 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id);
                            barrier.setType(aVar.d.b0);
                            barrier.setMargin(aVar.d.c0);
                            barrier.setAllowsGoneWidget(aVar.d.j0);
                            b bVar = aVar.d;
                            int[] iArr = bVar.e0;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str2 = bVar.f0;
                                if (str2 != null) {
                                    bVar.e0 = c(barrier, str2);
                                    barrier.setReferencedIds(aVar.d.e0);
                                }
                            }
                        }
                        ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                        aVar2.a();
                        aVar.a(aVar2);
                        if (z) {
                            HashMap<String, b.f.c.a> hashMap = aVar.f;
                            Class<?> cls = childAt.getClass();
                            Iterator<String> it2 = hashMap.keySet().iterator();
                            while (it2.hasNext()) {
                                String next = it2.next();
                                b.f.c.a aVar3 = hashMap.get(next);
                                int i4 = childCount;
                                String d2 = c.a.a.a.a.d("set", next);
                                HashMap<String, b.f.c.a> hashMap2 = hashMap;
                                try {
                                    switch (aVar3.f363b.ordinal()) {
                                        case 0:
                                            it = it2;
                                            cls.getMethod(d2, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.f364c));
                                            break;
                                        case 1:
                                            it = it2;
                                            cls.getMethod(d2, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.d));
                                            break;
                                        case 2:
                                            it = it2;
                                            cls.getMethod(d2, Integer.TYPE).invoke(childAt, Integer.valueOf(aVar3.g));
                                            break;
                                        case 3:
                                            it = it2;
                                            Method method = cls.getMethod(d2, Drawable.class);
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(aVar3.g);
                                            method.invoke(childAt, colorDrawable);
                                            break;
                                        case 4:
                                            it = it2;
                                            cls.getMethod(d2, CharSequence.class).invoke(childAt, aVar3.e);
                                            break;
                                        case 5:
                                            it = it2;
                                            cls.getMethod(d2, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar3.f));
                                            break;
                                        case 6:
                                            it = it2;
                                            try {
                                                cls.getMethod(d2, Float.TYPE).invoke(childAt, Float.valueOf(aVar3.d));
                                            } catch (IllegalAccessException e2) {
                                                e = e2;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                                childCount = i4;
                                                hashMap = hashMap2;
                                                it2 = it;
                                            } catch (NoSuchMethodException e3) {
                                                e = e3;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(cls.getName());
                                                sb.append(" must have a method ");
                                                sb.append(d2);
                                                Log.e("TransitionLayout", sb.toString());
                                                childCount = i4;
                                                hashMap = hashMap2;
                                                it2 = it;
                                            } catch (InvocationTargetException e4) {
                                                e = e4;
                                                Log.e("TransitionLayout", " Custom Attribute \"" + next + "\" not found on " + cls.getName());
                                                e.printStackTrace();
                                                childCount = i4;
                                                hashMap = hashMap2;
                                                it2 = it;
                                            }
                                        default:
                                            it = it2;
                                            break;
                                    }
                                } catch (IllegalAccessException e5) {
                                    e = e5;
                                    it = it2;
                                } catch (NoSuchMethodException e6) {
                                    e = e6;
                                    it = it2;
                                } catch (InvocationTargetException e7) {
                                    e = e7;
                                    it = it2;
                                }
                                childCount = i4;
                                hashMap = hashMap2;
                                it2 = it;
                            }
                        }
                        i = childCount;
                        childAt.setLayoutParams(aVar2);
                        C0015d c0015d = aVar.f376b;
                        if (c0015d.f383c == 0) {
                            childAt.setVisibility(c0015d.f382b);
                        }
                        int i5 = Build.VERSION.SDK_INT;
                        if (i5 >= 17) {
                            childAt.setAlpha(aVar.f376b.d);
                            childAt.setRotation(aVar.e.f384b);
                            childAt.setRotationX(aVar.e.f385c);
                            childAt.setRotationY(aVar.e.d);
                            childAt.setScaleX(aVar.e.e);
                            childAt.setScaleY(aVar.e.f);
                            if (!Float.isNaN(aVar.e.g)) {
                                childAt.setPivotX(aVar.e.g);
                            }
                            if (!Float.isNaN(aVar.e.h)) {
                                childAt.setPivotY(aVar.e.h);
                            }
                            childAt.setTranslationX(aVar.e.i);
                            childAt.setTranslationY(aVar.e.j);
                            if (i5 >= 21) {
                                childAt.setTranslationZ(aVar.e.k);
                                e eVar = aVar.e;
                                if (eVar.l) {
                                    childAt.setElevation(eVar.m);
                                }
                            }
                        }
                    } else {
                        i = childCount;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                    i2++;
                    childCount = i;
                }
            }
            i = childCount;
            i2++;
            childCount = i;
        }
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            Integer num = (Integer) it3.next();
            a aVar4 = this.f375c.get(num);
            int i6 = aVar4.d.d0;
            if (i6 != -1 && i6 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                b bVar2 = aVar4.d;
                int[] iArr2 = bVar2.e0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str3 = bVar2.f0;
                    if (str3 != null) {
                        bVar2.e0 = c(barrier2, str3);
                        barrier2.setReferencedIds(aVar4.d.e0);
                    }
                }
                barrier2.setType(aVar4.d.b0);
                barrier2.setMargin(aVar4.d.c0);
                ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.k();
                aVar4.a(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (aVar4.d.a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        b.f.c.a aVar;
        d dVar = this;
        int childCount = constraintLayout.getChildCount();
        dVar.f375c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (dVar.f374b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!dVar.f375c.containsKey(Integer.valueOf(id))) {
                dVar.f375c.put(Integer.valueOf(id), new a());
            }
            a aVar3 = dVar.f375c.get(Integer.valueOf(id));
            HashMap<String, b.f.c.a> hashMap = dVar.a;
            HashMap<String, b.f.c.a> hashMap2 = new HashMap<>();
            Class<?> cls = childAt.getClass();
            for (String str : hashMap.keySet()) {
                b.f.c.a aVar4 = hashMap.get(str);
                try {
                    if (str.equals("BackgroundColor")) {
                        aVar = new b.f.c.a(aVar4, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor()));
                    } else {
                        try {
                            aVar = new b.f.c.a(aVar4, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0]));
                        } catch (IllegalAccessException e2) {
                            e = e2;
                            e.printStackTrace();
                        } catch (NoSuchMethodException e3) {
                            e = e3;
                            e.printStackTrace();
                        } catch (InvocationTargetException e4) {
                            e = e4;
                            e.printStackTrace();
                        }
                    }
                    hashMap2.put(str, aVar);
                } catch (IllegalAccessException e5) {
                    e = e5;
                } catch (NoSuchMethodException e6) {
                    e = e6;
                } catch (InvocationTargetException e7) {
                    e = e7;
                }
            }
            aVar3.f = hashMap2;
            aVar3.b(id, aVar2);
            aVar3.f376b.f382b = childAt.getVisibility();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                aVar3.f376b.d = childAt.getAlpha();
                aVar3.e.f384b = childAt.getRotation();
                aVar3.e.f385c = childAt.getRotationX();
                aVar3.e.d = childAt.getRotationY();
                aVar3.e.e = childAt.getScaleX();
                aVar3.e.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar3.e;
                    eVar.g = pivotX;
                    eVar.h = pivotY;
                }
                aVar3.e.i = childAt.getTranslationX();
                aVar3.e.j = childAt.getTranslationY();
                if (i2 >= 21) {
                    aVar3.e.k = childAt.getTranslationZ();
                    e eVar2 = aVar3.e;
                    if (eVar2.l) {
                        eVar2.m = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                b bVar = aVar3.d;
                bVar.j0 = barrier.k.o0;
                bVar.e0 = barrier.getReferencedIds();
                aVar3.d.b0 = barrier.getType();
                aVar3.d.c0 = barrier.getMargin();
            }
            i++;
            dVar = this;
        }
    }

    public final int[] c(View view, String str) {
        int i;
        Object c2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = h.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (c2 = ((ConstraintLayout) view.getParent()).c(0, trim)) != null && (c2 instanceof Integer)) {
                i = ((Integer) c2).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    public final a d(Context context, AttributeSet attributeSet) {
        c cVar;
        String str;
        StringBuilder sb;
        String str2;
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.a);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index != 1 && 23 != index && 24 != index) {
                aVar.f377c.a = true;
                aVar.d.f378b = true;
                aVar.f376b.a = true;
                aVar.e.a = true;
            }
            switch (e.get(index)) {
                case 1:
                    b bVar = aVar.d;
                    int resourceId = obtainStyledAttributes.getResourceId(index, bVar.p);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar.p = resourceId;
                    continue;
                case 2:
                    b bVar2 = aVar.d;
                    bVar2.G = obtainStyledAttributes.getDimensionPixelSize(index, bVar2.G);
                    continue;
                case 3:
                    b bVar3 = aVar.d;
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, bVar3.o);
                    if (resourceId2 == -1) {
                        resourceId2 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar3.o = resourceId2;
                    continue;
                case 4:
                    b bVar4 = aVar.d;
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, bVar4.n);
                    if (resourceId3 == -1) {
                        resourceId3 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar4.n = resourceId3;
                    continue;
                case 5:
                    aVar.d.w = obtainStyledAttributes.getString(index);
                    continue;
                case 6:
                    b bVar5 = aVar.d;
                    bVar5.A = obtainStyledAttributes.getDimensionPixelOffset(index, bVar5.A);
                    continue;
                case 7:
                    b bVar6 = aVar.d;
                    bVar6.B = obtainStyledAttributes.getDimensionPixelOffset(index, bVar6.B);
                    continue;
                case 8:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar7 = aVar.d;
                        bVar7.H = obtainStyledAttributes.getDimensionPixelSize(index, bVar7.H);
                    } else {
                        continue;
                    }
                case 9:
                    b bVar8 = aVar.d;
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, bVar8.t);
                    if (resourceId4 == -1) {
                        resourceId4 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar8.t = resourceId4;
                    continue;
                case 10:
                    b bVar9 = aVar.d;
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, bVar9.s);
                    if (resourceId5 == -1) {
                        resourceId5 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar9.s = resourceId5;
                    continue;
                case 11:
                    b bVar10 = aVar.d;
                    bVar10.M = obtainStyledAttributes.getDimensionPixelSize(index, bVar10.M);
                    continue;
                case 12:
                    b bVar11 = aVar.d;
                    bVar11.N = obtainStyledAttributes.getDimensionPixelSize(index, bVar11.N);
                    continue;
                case 13:
                    b bVar12 = aVar.d;
                    bVar12.J = obtainStyledAttributes.getDimensionPixelSize(index, bVar12.J);
                    continue;
                case 14:
                    b bVar13 = aVar.d;
                    bVar13.L = obtainStyledAttributes.getDimensionPixelSize(index, bVar13.L);
                    continue;
                case 15:
                    b bVar14 = aVar.d;
                    bVar14.O = obtainStyledAttributes.getDimensionPixelSize(index, bVar14.O);
                    continue;
                case 16:
                    b bVar15 = aVar.d;
                    bVar15.K = obtainStyledAttributes.getDimensionPixelSize(index, bVar15.K);
                    continue;
                case 17:
                    b bVar16 = aVar.d;
                    bVar16.e = obtainStyledAttributes.getDimensionPixelOffset(index, bVar16.e);
                    continue;
                case 18:
                    b bVar17 = aVar.d;
                    bVar17.f = obtainStyledAttributes.getDimensionPixelOffset(index, bVar17.f);
                    continue;
                case 19:
                    b bVar18 = aVar.d;
                    bVar18.g = obtainStyledAttributes.getFloat(index, bVar18.g);
                    continue;
                case 20:
                    b bVar19 = aVar.d;
                    bVar19.u = obtainStyledAttributes.getFloat(index, bVar19.u);
                    continue;
                case 21:
                    b bVar20 = aVar.d;
                    bVar20.d = obtainStyledAttributes.getLayoutDimension(index, bVar20.d);
                    continue;
                case 22:
                    C0015d c0015d = aVar.f376b;
                    c0015d.f382b = obtainStyledAttributes.getInt(index, c0015d.f382b);
                    C0015d c0015d2 = aVar.f376b;
                    c0015d2.f382b = d[c0015d2.f382b];
                    continue;
                case 23:
                    b bVar21 = aVar.d;
                    bVar21.f379c = obtainStyledAttributes.getLayoutDimension(index, bVar21.f379c);
                    continue;
                case 24:
                    b bVar22 = aVar.d;
                    bVar22.D = obtainStyledAttributes.getDimensionPixelSize(index, bVar22.D);
                    continue;
                case 25:
                    b bVar23 = aVar.d;
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, bVar23.h);
                    if (resourceId6 == -1) {
                        resourceId6 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar23.h = resourceId6;
                    continue;
                case 26:
                    b bVar24 = aVar.d;
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, bVar24.i);
                    if (resourceId7 == -1) {
                        resourceId7 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar24.i = resourceId7;
                    continue;
                case 27:
                    b bVar25 = aVar.d;
                    bVar25.C = obtainStyledAttributes.getInt(index, bVar25.C);
                    continue;
                case 28:
                    b bVar26 = aVar.d;
                    bVar26.E = obtainStyledAttributes.getDimensionPixelSize(index, bVar26.E);
                    continue;
                case 29:
                    b bVar27 = aVar.d;
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, bVar27.j);
                    if (resourceId8 == -1) {
                        resourceId8 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar27.j = resourceId8;
                    continue;
                case 30:
                    b bVar28 = aVar.d;
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, bVar28.k);
                    if (resourceId9 == -1) {
                        resourceId9 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar28.k = resourceId9;
                    continue;
                case 31:
                    if (Build.VERSION.SDK_INT >= 17) {
                        b bVar29 = aVar.d;
                        bVar29.I = obtainStyledAttributes.getDimensionPixelSize(index, bVar29.I);
                    } else {
                        continue;
                    }
                case 32:
                    b bVar30 = aVar.d;
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, bVar30.q);
                    if (resourceId10 == -1) {
                        resourceId10 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar30.q = resourceId10;
                    continue;
                case 33:
                    b bVar31 = aVar.d;
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, bVar31.r);
                    if (resourceId11 == -1) {
                        resourceId11 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar31.r = resourceId11;
                    continue;
                case 34:
                    b bVar32 = aVar.d;
                    bVar32.F = obtainStyledAttributes.getDimensionPixelSize(index, bVar32.F);
                    continue;
                case 35:
                    b bVar33 = aVar.d;
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, bVar33.m);
                    if (resourceId12 == -1) {
                        resourceId12 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar33.m = resourceId12;
                    continue;
                case 36:
                    b bVar34 = aVar.d;
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, bVar34.l);
                    if (resourceId13 == -1) {
                        resourceId13 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar34.l = resourceId13;
                    continue;
                case 37:
                    b bVar35 = aVar.d;
                    bVar35.v = obtainStyledAttributes.getFloat(index, bVar35.v);
                    continue;
                case 38:
                    aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                    continue;
                case 39:
                    b bVar36 = aVar.d;
                    bVar36.Q = obtainStyledAttributes.getFloat(index, bVar36.Q);
                    continue;
                case 40:
                    b bVar37 = aVar.d;
                    bVar37.P = obtainStyledAttributes.getFloat(index, bVar37.P);
                    continue;
                case 41:
                    b bVar38 = aVar.d;
                    bVar38.R = obtainStyledAttributes.getInt(index, bVar38.R);
                    continue;
                case 42:
                    b bVar39 = aVar.d;
                    bVar39.S = obtainStyledAttributes.getInt(index, bVar39.S);
                    continue;
                case 43:
                    C0015d c0015d3 = aVar.f376b;
                    c0015d3.d = obtainStyledAttributes.getFloat(index, c0015d3.d);
                    continue;
                case 44:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar = aVar.e;
                        eVar.l = true;
                        eVar.m = obtainStyledAttributes.getDimension(index, eVar.m);
                    } else {
                        continue;
                    }
                case 45:
                    e eVar2 = aVar.e;
                    eVar2.f385c = obtainStyledAttributes.getFloat(index, eVar2.f385c);
                    continue;
                case 46:
                    e eVar3 = aVar.e;
                    eVar3.d = obtainStyledAttributes.getFloat(index, eVar3.d);
                    continue;
                case 47:
                    e eVar4 = aVar.e;
                    eVar4.e = obtainStyledAttributes.getFloat(index, eVar4.e);
                    continue;
                case 48:
                    e eVar5 = aVar.e;
                    eVar5.f = obtainStyledAttributes.getFloat(index, eVar5.f);
                    continue;
                case 49:
                    e eVar6 = aVar.e;
                    eVar6.g = obtainStyledAttributes.getDimension(index, eVar6.g);
                    continue;
                case 50:
                    e eVar7 = aVar.e;
                    eVar7.h = obtainStyledAttributes.getDimension(index, eVar7.h);
                    continue;
                case 51:
                    e eVar8 = aVar.e;
                    eVar8.i = obtainStyledAttributes.getDimension(index, eVar8.i);
                    continue;
                case 52:
                    e eVar9 = aVar.e;
                    eVar9.j = obtainStyledAttributes.getDimension(index, eVar9.j);
                    continue;
                case 53:
                    if (Build.VERSION.SDK_INT >= 21) {
                        e eVar10 = aVar.e;
                        eVar10.k = obtainStyledAttributes.getDimension(index, eVar10.k);
                    } else {
                        continue;
                    }
                case 54:
                    b bVar40 = aVar.d;
                    bVar40.T = obtainStyledAttributes.getInt(index, bVar40.T);
                    continue;
                case 55:
                    b bVar41 = aVar.d;
                    bVar41.U = obtainStyledAttributes.getInt(index, bVar41.U);
                    continue;
                case 56:
                    b bVar42 = aVar.d;
                    bVar42.V = obtainStyledAttributes.getDimensionPixelSize(index, bVar42.V);
                    continue;
                case 57:
                    b bVar43 = aVar.d;
                    bVar43.W = obtainStyledAttributes.getDimensionPixelSize(index, bVar43.W);
                    continue;
                case 58:
                    b bVar44 = aVar.d;
                    bVar44.X = obtainStyledAttributes.getDimensionPixelSize(index, bVar44.X);
                    continue;
                case 59:
                    b bVar45 = aVar.d;
                    bVar45.Y = obtainStyledAttributes.getDimensionPixelSize(index, bVar45.Y);
                    continue;
                case 60:
                    e eVar11 = aVar.e;
                    eVar11.f384b = obtainStyledAttributes.getFloat(index, eVar11.f384b);
                    continue;
                case 61:
                    b bVar46 = aVar.d;
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, bVar46.x);
                    if (resourceId14 == -1) {
                        resourceId14 = obtainStyledAttributes.getInt(index, -1);
                    }
                    bVar46.x = resourceId14;
                    continue;
                case 62:
                    b bVar47 = aVar.d;
                    bVar47.y = obtainStyledAttributes.getDimensionPixelSize(index, bVar47.y);
                    continue;
                case 63:
                    b bVar48 = aVar.d;
                    bVar48.z = obtainStyledAttributes.getFloat(index, bVar48.z);
                    continue;
                case 64:
                    c cVar2 = aVar.f377c;
                    int resourceId15 = obtainStyledAttributes.getResourceId(index, cVar2.f380b);
                    if (resourceId15 == -1) {
                        resourceId15 = obtainStyledAttributes.getInt(index, -1);
                    }
                    cVar2.f380b = resourceId15;
                    continue;
                case 65:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        cVar = aVar.f377c;
                        str = obtainStyledAttributes.getString(index);
                    } else {
                        cVar = aVar.f377c;
                        str = b.f.a.a.a.a[obtainStyledAttributes.getInteger(index, 0)];
                    }
                    cVar.f381c = str;
                    continue;
                case 66:
                    aVar.f377c.e = obtainStyledAttributes.getInt(index, 0);
                    continue;
                case 67:
                    c cVar3 = aVar.f377c;
                    cVar3.g = obtainStyledAttributes.getFloat(index, cVar3.g);
                    continue;
                case 68:
                    C0015d c0015d4 = aVar.f376b;
                    c0015d4.e = obtainStyledAttributes.getFloat(index, c0015d4.e);
                    continue;
                case 69:
                    aVar.d.Z = obtainStyledAttributes.getFloat(index, 1.0f);
                    continue;
                case 70:
                    aVar.d.a0 = obtainStyledAttributes.getFloat(index, 1.0f);
                    continue;
                case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    continue;
                case 72:
                    b bVar49 = aVar.d;
                    bVar49.b0 = obtainStyledAttributes.getInt(index, bVar49.b0);
                    continue;
                case 73:
                    b bVar50 = aVar.d;
                    bVar50.c0 = obtainStyledAttributes.getDimensionPixelSize(index, bVar50.c0);
                    continue;
                case 74:
                    aVar.d.f0 = obtainStyledAttributes.getString(index);
                    continue;
                case 75:
                    b bVar51 = aVar.d;
                    bVar51.j0 = obtainStyledAttributes.getBoolean(index, bVar51.j0);
                    continue;
                case 76:
                    c cVar4 = aVar.f377c;
                    cVar4.d = obtainStyledAttributes.getInt(index, cVar4.d);
                    continue;
                case 77:
                    aVar.d.g0 = obtainStyledAttributes.getString(index);
                    continue;
                case 78:
                    C0015d c0015d5 = aVar.f376b;
                    c0015d5.f383c = obtainStyledAttributes.getInt(index, c0015d5.f383c);
                    continue;
                case 79:
                    c cVar5 = aVar.f377c;
                    cVar5.f = obtainStyledAttributes.getFloat(index, cVar5.f);
                    continue;
                case 80:
                    b bVar52 = aVar.d;
                    bVar52.h0 = obtainStyledAttributes.getBoolean(index, bVar52.h0);
                    continue;
                case 81:
                    b bVar53 = aVar.d;
                    bVar53.i0 = obtainStyledAttributes.getBoolean(index, bVar53.i0);
                    continue;
                case 82:
                    sb = new StringBuilder();
                    str2 = "unused attribute 0x";
                    break;
                default:
                    sb = new StringBuilder();
                    str2 = "Unknown attribute 0x";
                    break;
            }
            sb.append(str2);
            sb.append(Integer.toHexString(index));
            sb.append("   ");
            sb.append(e.get(index));
            Log.w("ConstraintSet", sb.toString());
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public void e(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    a d2 = d(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        d2.d.a = true;
                    }
                    this.f375c.put(Integer.valueOf(d2.a), d2);
                    continue;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }
}
