package com.facebook.react.uimanager.events;
/* loaded from: classes.dex */
public interface EventDispatcher {
    void addBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener);

    void addListener(EventDispatcherListener eventDispatcherListener);

    void dispatchAllEvents();

    void dispatchEvent(Event event);

    void onCatalystInstanceDestroyed();

    void registerEventEmitter(int i, RCTEventEmitter rCTEventEmitter);

    void removeBatchEventDispatchedListener(BatchEventDispatchedListener batchEventDispatchedListener);

    void removeListener(EventDispatcherListener eventDispatcherListener);

    void unregisterEventEmitter(int i);
}
