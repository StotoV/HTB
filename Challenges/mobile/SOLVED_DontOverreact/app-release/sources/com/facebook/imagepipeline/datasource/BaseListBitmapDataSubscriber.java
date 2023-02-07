package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
    protected abstract void onNewResultListImpl(List<Bitmap> list);

    @Override // com.facebook.datasource.BaseDataSubscriber
    public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> dataSource) {
        if (!dataSource.isFinished()) {
            return;
        }
        List<CloseableReference<CloseableImage>> mo129getResult = dataSource.mo129getResult();
        if (mo129getResult == null) {
            onNewResultListImpl(null);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList(mo129getResult.size());
            for (CloseableReference<CloseableImage> closeableReference : mo129getResult) {
                if (closeableReference != null && (closeableReference.get() instanceof CloseableBitmap)) {
                    arrayList.add(((CloseableBitmap) closeableReference.get()).getUnderlyingBitmap());
                } else {
                    arrayList.add(null);
                }
            }
            onNewResultListImpl(arrayList);
        } finally {
            for (CloseableReference<CloseableImage> next : mo129getResult) {
                CloseableReference.closeSafely(next);
            }
        }
    }
}
