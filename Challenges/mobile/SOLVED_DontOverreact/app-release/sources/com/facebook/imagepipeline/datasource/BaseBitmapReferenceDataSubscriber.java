package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    protected abstract void onNewResultImpl(@Nullable CloseableReference<Bitmap> closeableReference);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (!dataSource.isFinished()) {
            return;
        }
        CloseableReference<CloseableImage> mo129getResult = dataSource.mo129getResult();
        CloseableReference<Bitmap> closeableReference = null;
        if (mo129getResult != null && (mo129getResult.get() instanceof CloseableStaticBitmap)) {
            closeableReference = ((CloseableStaticBitmap) mo129getResult.get()).cloneUnderlyingBitmapReference();
        }
        try {
            onNewResultImpl(closeableReference);
        } finally {
            CloseableReference.closeSafely(closeableReference);
            CloseableReference.closeSafely(mo129getResult);
        }
    }
}
