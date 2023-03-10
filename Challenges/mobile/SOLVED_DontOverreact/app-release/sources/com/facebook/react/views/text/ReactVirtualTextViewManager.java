package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
@ReactModule(name = ReactVirtualTextViewManager.REACT_CLASS)
/* loaded from: classes.dex */
public class ReactVirtualTextViewManager extends BaseViewManager<View, ReactVirtualTextShadowNode> {
    public static final String REACT_CLASS = "RCTVirtualText";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(View view, Object obj) {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    /* renamed from: createViewInstance */
    public View mo207createViewInstance(ThemedReactContext themedReactContext) {
        throw new IllegalStateException("Attempt to create a native view for RCTVirtualText");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Class<ReactVirtualTextShadowNode> getShadowNodeClass() {
        return ReactVirtualTextShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    /* renamed from: createShadowNodeInstance  reason: collision with other method in class */
    public ReactVirtualTextShadowNode mo204createShadowNodeInstance() {
        return new ReactVirtualTextShadowNode();
    }
}
