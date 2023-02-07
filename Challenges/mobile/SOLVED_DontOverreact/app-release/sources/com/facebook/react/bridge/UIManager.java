package com.facebook.react.bridge;

import android.view.View;
/* loaded from: classes.dex */
public interface UIManager extends JSIModule, PerformanceCounter {
    <T extends View> int addRootView(T t, WritableMap writableMap, String str);

    void addUIManagerEventListener(UIManagerListener uIManagerListener);

    void dispatchCommand(int i, int i2, ReadableArray readableArray);

    void dispatchCommand(int i, String str, ReadableArray readableArray);

    /* renamed from: getEventDispatcher */
    <T> T mo180getEventDispatcher();

    void receiveEvent(int i, String str, WritableMap writableMap);

    void removeUIManagerEventListener(UIManagerListener uIManagerListener);

    @Deprecated
    String resolveCustomDirectEventName(String str);

    void sendAccessibilityEvent(int i, int i2);

    <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i, int i2);

    void stopSurface(int i);

    void synchronouslyUpdateViewOnUIThread(int i, ReadableMap readableMap);

    void updateRootLayoutSpecs(int i, int i2, int i3, int i4, int i5);
}
