package com.facebook.react.views.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidDropdownPickerManagerDelegate;
import com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface;
@ReactModule(name = ReactDropdownPickerManager.REACT_CLASS)
/* loaded from: classes.dex */
public class ReactDropdownPickerManager extends ReactPickerManager implements AndroidDropdownPickerManagerInterface<ReactPicker> {
    public static final String REACT_CLASS = "AndroidDropdownPicker";
    private final ViewManagerDelegate<ReactPicker> mDelegate = new AndroidDropdownPickerManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface
    @ReactProp(customType = "Color", name = ViewProps.COLOR)
    public /* bridge */ /* synthetic */ void setColor(ReactPicker reactPicker, Integer num) {
        super.setColor(reactPicker, num);
    }

    @Override // com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface
    @ReactProp(defaultBoolean = true, name = ViewProps.ENABLED)
    public /* bridge */ /* synthetic */ void setEnabled(ReactPicker reactPicker, boolean z) {
        super.setEnabled(reactPicker, z);
    }

    @Override // com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface
    @ReactProp(name = "items")
    public /* bridge */ /* synthetic */ void setItems(ReactPicker reactPicker, ReadableArray readableArray) {
        super.setItems(reactPicker, readableArray);
    }

    @Override // com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface
    @ReactProp(name = "prompt")
    public /* bridge */ /* synthetic */ void setPrompt(ReactPicker reactPicker, String str) {
        super.setPrompt(reactPicker, str);
    }

    @Override // com.facebook.react.viewmanagers.AndroidDropdownPickerManagerInterface
    @ReactProp(name = "selected")
    public /* bridge */ /* synthetic */ void setSelected(ReactPicker reactPicker, int i) {
        super.setSelected(reactPicker, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    /* renamed from: createViewInstance  reason: collision with other method in class */
    public ReactPicker mo207createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactPicker(themedReactContext, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactPicker> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.BaseViewManagerInterface
    public void setBackgroundColor(ReactPicker reactPicker, int i) {
        reactPicker.setStagedBackgroundColor(Integer.valueOf(i));
    }
}
