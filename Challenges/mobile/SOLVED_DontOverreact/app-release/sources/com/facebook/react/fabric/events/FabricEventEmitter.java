package com.facebook.react.fabric.events;

import android.util.Pair;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.facebook.systrace.Systrace;
import java.util.HashSet;
/* loaded from: classes.dex */
public class FabricEventEmitter implements RCTEventEmitter {
    private static final String TAG = "FabricEventEmitter";
    private final FabricUIManager mUIManager;

    public FabricEventEmitter(FabricUIManager fabricUIManager) {
        this.mUIManager = fabricUIManager;
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveEvent(int i, String str, WritableMap writableMap) {
        Systrace.beginSection(0L, "FabricEventEmitter.receiveEvent('" + str + "')");
        this.mUIManager.receiveEvent(i, str, writableMap);
        Systrace.endSection(0L);
    }

    @Override // com.facebook.react.uimanager.events.RCTEventEmitter
    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        Pair<WritableArray, WritableArray> removeTouchesAtIndices;
        if (TouchesHelper.TOP_TOUCH_END_KEY.equalsIgnoreCase(str) || TouchesHelper.TOP_TOUCH_CANCEL_KEY.equalsIgnoreCase(str)) {
            removeTouchesAtIndices = removeTouchesAtIndices(writableArray, writableArray2);
        } else {
            removeTouchesAtIndices = touchSubsequence(writableArray, writableArray2);
        }
        WritableArray writableArray3 = (WritableArray) removeTouchesAtIndices.first;
        WritableArray writableArray4 = (WritableArray) removeTouchesAtIndices.second;
        for (int i = 0; i < writableArray3.size(); i++) {
            WritableMap writableMap = getWritableMap(writableArray3.mo175getMap(i));
            writableMap.putArray(TouchesHelper.CHANGED_TOUCHES_KEY, copyWritableArray(writableArray3));
            writableMap.putArray(TouchesHelper.TOUCHES_KEY, copyWritableArray(writableArray4));
            int i2 = writableMap.getInt(TouchesHelper.TARGET_KEY);
            if (i2 < 1) {
                FLog.e(TAG, "A view is reporting that a touch occurred on tag zero.");
                i2 = 0;
            }
            receiveEvent(i2, str, writableMap);
        }
    }

    private WritableArray copyWritableArray(WritableArray writableArray) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < writableArray.size(); i++) {
            writableNativeArray.pushMap(getWritableMap(writableArray.mo175getMap(i)));
        }
        return writableNativeArray;
    }

    private Pair<WritableArray, WritableArray> removeTouchesAtIndices(WritableArray writableArray, WritableArray writableArray2) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < writableArray2.size(); i++) {
            int i2 = writableArray2.getInt(i);
            writableNativeArray.pushMap(getWritableMap(writableArray.mo175getMap(i2)));
            hashSet.add(Integer.valueOf(i2));
        }
        for (int i3 = 0; i3 < writableArray.size(); i3++) {
            if (!hashSet.contains(Integer.valueOf(i3))) {
                writableNativeArray2.pushMap(getWritableMap(writableArray.mo175getMap(i3)));
            }
        }
        return new Pair<>(writableNativeArray, writableNativeArray2);
    }

    private Pair<WritableArray, WritableArray> touchSubsequence(WritableArray writableArray, WritableArray writableArray2) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i = 0; i < writableArray2.size(); i++) {
            writableNativeArray.pushMap(getWritableMap(writableArray.mo175getMap(writableArray2.getInt(i))));
        }
        return new Pair<>(writableNativeArray, writableArray);
    }

    private WritableMap getWritableMap(ReadableMap readableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.merge(readableMap);
        return writableNativeMap;
    }
}
