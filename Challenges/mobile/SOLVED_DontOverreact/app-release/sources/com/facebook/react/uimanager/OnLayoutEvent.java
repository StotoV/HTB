package com.facebook.react.uimanager;

import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
/* loaded from: classes.dex */
public class OnLayoutEvent extends Event<OnLayoutEvent> {
    private static final Pools.SynchronizedPool<OnLayoutEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(20);
    private int mHeight;
    private int mWidth;
    private int mX;
    private int mY;

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topLayout";
    }

    public static OnLayoutEvent obtain(int i, int i2, int i3, int i4, int i5) {
        OnLayoutEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new OnLayoutEvent();
        }
        acquire.init(i, i2, i3, i4, i5);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        EVENTS_POOL.release(this);
    }

    private OnLayoutEvent() {
    }

    protected void init(int i, int i2, int i3, int i4, int i5) {
        super.init(i);
        this.mX = i2;
        this.mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", PixelUtil.toDIPFromPixel(this.mX));
        createMap.putDouble("y", PixelUtil.toDIPFromPixel(this.mY));
        createMap.putDouble("width", PixelUtil.toDIPFromPixel(this.mWidth));
        createMap.putDouble("height", PixelUtil.toDIPFromPixel(this.mHeight));
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("layout", createMap);
        createMap2.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), createMap2);
    }
}
