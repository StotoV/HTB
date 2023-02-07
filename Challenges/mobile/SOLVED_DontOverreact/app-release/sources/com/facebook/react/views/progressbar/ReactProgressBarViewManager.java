package com.facebook.react.views.progressbar;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerDelegate;
import com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import java.util.WeakHashMap;
@ReactModule(name = ReactProgressBarViewManager.REACT_CLASS)
/* loaded from: classes.dex */
public class ReactProgressBarViewManager extends BaseViewManager<ProgressBarContainerView, ProgressBarShadowNode> implements AndroidProgressBarManagerInterface<ProgressBarContainerView> {
    static final String DEFAULT_STYLE = "Normal";
    static final String PROP_ANIMATING = "animating";
    static final String PROP_INDETERMINATE = "indeterminate";
    static final String PROP_PROGRESS = "progress";
    static final String PROP_STYLE = "styleAttr";
    public static final String REACT_CLASS = "AndroidProgressBar";
    private static Object sProgressBarCtorLock = new Object();
    private final WeakHashMap<Integer, Pair<Integer, Integer>> mMeasuredStyles = new WeakHashMap<>();
    private final ViewManagerDelegate<ProgressBarContainerView> mDelegate = new AndroidProgressBarManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    public void setTypeAttr(ProgressBarContainerView progressBarContainerView, String str) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(ProgressBarContainerView progressBarContainerView, Object obj) {
    }

    public static ProgressBar createProgressBar(Context context, int i) {
        ProgressBar progressBar;
        synchronized (sProgressBarCtorLock) {
            progressBar = new ProgressBar(context, null, i);
        }
        return progressBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    /* renamed from: createViewInstance  reason: collision with other method in class */
    public ProgressBarContainerView mo207createViewInstance(ThemedReactContext themedReactContext) {
        return new ProgressBarContainerView(themedReactContext);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_STYLE)
    public void setStyleAttr(ProgressBarContainerView progressBarContainerView, String str) {
        progressBarContainerView.setStyle(str);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(customType = "Color", name = ViewProps.COLOR)
    public void setColor(ProgressBarContainerView progressBarContainerView, Integer num) {
        progressBarContainerView.setColor(num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_INDETERMINATE)
    public void setIndeterminate(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.setIndeterminate(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = "progress")
    public void setProgress(ProgressBarContainerView progressBarContainerView, double d) {
        progressBarContainerView.setProgress(d);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    @ReactProp(name = PROP_ANIMATING)
    public void setAnimating(ProgressBarContainerView progressBarContainerView, boolean z) {
        progressBarContainerView.setAnimating(z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidProgressBarManagerInterface
    public void setTestID(ProgressBarContainerView progressBarContainerView, String str) {
        super.setTestId(progressBarContainerView, str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    /* renamed from: createShadowNodeInstance  reason: collision with other method in class */
    public ProgressBarShadowNode mo204createShadowNodeInstance() {
        return new ProgressBarShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<ProgressBarShadowNode> getShadowNodeClass() {
        return ProgressBarShadowNode.class;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ProgressBarContainerView progressBarContainerView) {
        progressBarContainerView.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ProgressBarContainerView> getDelegate() {
        return this.mDelegate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getStyleFromString(String str) {
        if (str == null) {
            throw new JSApplicationIllegalArgumentException("ProgressBar needs to have a style, null received");
        }
        if (str.equals("Horizontal")) {
            return 16842872;
        }
        if (str.equals("Small")) {
            return 16842873;
        }
        if (str.equals("Large")) {
            return 16842874;
        }
        if (str.equals("Inverse")) {
            return 16843399;
        }
        if (str.equals("SmallInverse")) {
            return 16843400;
        }
        if (str.equals("LargeInverse")) {
            return 16843401;
        }
        if (str.equals(DEFAULT_STYLE)) {
            return 16842871;
        }
        throw new JSApplicationIllegalArgumentException("Unknown ProgressBar style: " + str);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        Integer valueOf = Integer.valueOf(getStyleFromString(readableMap2.getString(PROP_STYLE)));
        Pair<Integer, Integer> pair = this.mMeasuredStyles.get(valueOf);
        if (pair == null) {
            ProgressBar createProgressBar = createProgressBar(context, valueOf.intValue());
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            createProgressBar.measure(makeMeasureSpec, makeMeasureSpec);
            pair = Pair.create(Integer.valueOf(createProgressBar.getMeasuredWidth()), Integer.valueOf(createProgressBar.getMeasuredHeight()));
            this.mMeasuredStyles.put(valueOf, pair);
        }
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel(((Integer) pair.first).intValue()), PixelUtil.toDIPFromPixel(((Integer) pair.second).intValue()));
    }
}
