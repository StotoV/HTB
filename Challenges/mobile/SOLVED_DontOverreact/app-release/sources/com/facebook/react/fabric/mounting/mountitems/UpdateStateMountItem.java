package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.StateWrapper;
/* loaded from: classes.dex */
public class UpdateStateMountItem implements MountItem {
    private final int mReactTag;
    private final StateWrapper mStateWrapper;

    public UpdateStateMountItem(int i, StateWrapper stateWrapper) {
        this.mReactTag = i;
        this.mStateWrapper = stateWrapper;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        mountingManager.updateState(this.mReactTag, this.mStateWrapper);
    }

    public String toString() {
        return "UpdateStateMountItem [" + this.mReactTag + "]";
    }
}
