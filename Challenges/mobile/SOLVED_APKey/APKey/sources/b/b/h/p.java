package b.b.h;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class p {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextClassifier f254b;

    public p(TextView textView) {
        this.a = textView;
    }

    public TextClassifier a() {
        TextClassifier textClassifier = this.f254b;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.a.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}
