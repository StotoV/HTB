package com.facebook.react.fabric;

import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;
/* loaded from: classes.dex */
public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback {
    private final NativeModuleCallExceptionHandler mExceptionHandler;

    protected abstract void doFrameGuarded(long j);

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public GuardedFrameCallback(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedFrameCallback(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mExceptionHandler = nativeModuleCallExceptionHandler;
    }

    @Override // com.facebook.react.modules.core.ChoreographerCompat.FrameCallback
    public final void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
    }
}
