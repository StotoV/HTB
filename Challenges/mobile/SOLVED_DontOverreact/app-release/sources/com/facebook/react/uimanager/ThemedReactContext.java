package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
/* loaded from: classes.dex */
public class ThemedReactContext extends ReactContext {
    private final ReactApplicationContext mReactApplicationContext;
    private final String mSurfaceID;

    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context) {
        this(reactApplicationContext, context, null);
    }

    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context, String str) {
        super(context);
        if (reactApplicationContext.hasCatalystInstance()) {
            initializeWithInstance(reactApplicationContext.getCatalystInstance());
        }
        this.mReactApplicationContext = reactApplicationContext;
        this.mSurfaceID = str;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void addLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mReactApplicationContext.addLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mReactApplicationContext.removeLifecycleEventListener(lifecycleEventListener);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean hasCurrentActivity() {
        return this.mReactApplicationContext.hasCurrentActivity();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }

    public String getSurfaceID() {
        return this.mSurfaceID;
    }

    public ReactApplicationContext getReactApplicationContext() {
        return this.mReactApplicationContext;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public boolean isBridgeless() {
        return this.mReactApplicationContext.isBridgeless();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public JSIModule getJSIModule(JSIModuleType jSIModuleType) {
        if (isBridgeless()) {
            return this.mReactApplicationContext.getJSIModule(jSIModuleType);
        }
        return super.getJSIModule(jSIModuleType);
    }
}
