package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.StateWrapper;
/* loaded from: classes.dex */
public class StateWrapperImpl implements StateWrapper {
    private Runnable mFailureCallback = null;
    private int mUpdateStateId = 0;
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    @Override // com.facebook.react.uimanager.StateWrapper
    public native ReadableNativeMap getState();

    public native void updateStateImpl(NativeMap nativeMap);

    public native void updateStateWithFailureCallbackImpl(NativeMap nativeMap, Object obj, int i);

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
    }

    @Override // com.facebook.react.uimanager.StateWrapper
    public void updateState(WritableMap writableMap, Runnable runnable) {
        int i = this.mUpdateStateId + 1;
        this.mUpdateStateId = i;
        this.mFailureCallback = runnable;
        updateStateWithFailureCallbackImpl((NativeMap) writableMap, this, i);
    }

    public void updateStateFailed(int i) {
        if (i != this.mUpdateStateId) {
            return;
        }
        Runnable runnable = this.mFailureCallback;
        this.mFailureCallback = null;
        if (runnable == null) {
            return;
        }
        UiThreadUtil.runOnUiThread(runnable);
    }
}
