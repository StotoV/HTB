package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.memory.MemoryTrimType;
import java.util.Set;
/* loaded from: classes.dex */
public class DummyTrackingInUseBitmapPool implements BitmapPool {
    private final Set<Bitmap> mInUseValues = Sets.newIdentityHashSet();

    @Override // com.facebook.common.memory.MemoryTrimmable
    public void trim(MemoryTrimType memoryTrimType) {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.memory.Pool
    /* renamed from: get */
    public Bitmap mo137get(int i) {
        Bitmap createBitmap = Bitmap.createBitmap(1, (int) Math.ceil(i / 2.0d), Bitmap.Config.RGB_565);
        this.mInUseValues.add(createBitmap);
        return createBitmap;
    }

    @Override // com.facebook.common.memory.Pool, com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        Preconditions.checkNotNull(bitmap);
        this.mInUseValues.remove(bitmap);
        bitmap.recycle();
    }
}
