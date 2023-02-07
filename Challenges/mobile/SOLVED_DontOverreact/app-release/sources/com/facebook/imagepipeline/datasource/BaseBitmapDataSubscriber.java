package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    protected abstract void onNewResultImpl(@Nullable Bitmap bitmap);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (!dataSource.isFinished()) {
            return;
        }
        CloseableReference<CloseableImage> mo129getResult = dataSource.mo129getResult();
        Bitmap bitmap = null;
        if (mo129getResult != null && (mo129getResult.get() instanceof CloseableBitmap)) {
            bitmap = ((CloseableBitmap) mo129getResult.get()).getUnderlyingBitmap();
        }
        try {
            onNewResultImpl(bitmap);
        } finally {
            CloseableReference.closeSafely(mo129getResult);
        }
    }
}
