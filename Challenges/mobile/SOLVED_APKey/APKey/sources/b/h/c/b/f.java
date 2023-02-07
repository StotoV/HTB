package b.h.c.b;

import java.util.List;
/* loaded from: classes.dex */
public final class f {
    public final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f406b;

    public f(int i, int i2) {
        this.a = new int[]{i, i2};
        this.f406b = new float[]{0.0f, 1.0f};
    }

    public f(int i, int i2, int i3) {
        this.a = new int[]{i, i2, i3};
        this.f406b = new float[]{0.0f, 0.5f, 1.0f};
    }

    public f(List<Integer> list, List<Float> list2) {
        int size = list.size();
        this.a = new int[size];
        this.f406b = new float[size];
        for (int i = 0; i < size; i++) {
            this.a[i] = list.get(i).intValue();
            this.f406b[i] = list2.get(i).floatValue();
        }
    }
}
