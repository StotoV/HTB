package com.facebook.react.views.swiperefresh;

import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
/* loaded from: classes.dex */
public class RefreshEvent extends Event<RefreshEvent> {
    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topRefresh";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RefreshEvent(int i) {
        super(i);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), null);
    }
}
