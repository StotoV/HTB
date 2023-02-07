package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.config.ReactFeatureFlags;
/* loaded from: classes.dex */
public class FabricViewStateManager {
    private static final String TAG = "FabricViewStateManager";
    private StateWrapper mStateWrapper = null;

    /* loaded from: classes.dex */
    public interface HasFabricViewStateManager {
        FabricViewStateManager getFabricViewStateManager();
    }

    /* loaded from: classes.dex */
    public interface StateUpdateCallback {
        WritableMap getStateUpdate();
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    public boolean hasStateWrapper() {
        return this.mStateWrapper != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(final StateWrapper stateWrapper, final StateUpdateCallback stateUpdateCallback, final int i) {
        if (stateWrapper == null) {
            FLog.e(TAG, "setState called without a StateWrapper");
        } else if (stateWrapper != this.mStateWrapper || i > 60) {
        } else {
            Runnable runnable = null;
            if (ReactFeatureFlags.enableExperimentalStateUpdateRetry) {
                runnable = new Runnable() { // from class: com.facebook.react.uimanager.FabricViewStateManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FLog.e(FabricViewStateManager.TAG, "UpdateState failed - retrying! " + i);
                        FabricViewStateManager.this.setState(stateWrapper, stateUpdateCallback, i + 1);
                    }
                };
            }
            WritableMap stateUpdate = stateUpdateCallback.getStateUpdate();
            if (stateUpdate == null) {
                return;
            }
            stateWrapper.updateState(stateUpdate, runnable);
        }
    }

    public void setState(StateUpdateCallback stateUpdateCallback) {
        setState(this.mStateWrapper, stateUpdateCallback, 0);
    }

    public ReadableMap getState() {
        StateWrapper stateWrapper = this.mStateWrapper;
        if (stateWrapper != null) {
            return stateWrapper.getState();
        }
        return null;
    }
}
