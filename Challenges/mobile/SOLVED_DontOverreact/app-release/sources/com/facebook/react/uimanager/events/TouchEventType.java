package com.facebook.react.uimanager.events;
/* loaded from: classes.dex */
public enum TouchEventType {
    START,
    END,
    MOVE,
    CANCEL;

    /* renamed from: com.facebook.react.uimanager.events.TouchEventType$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$TouchEventType;

        static {
            int[] iArr = new int[TouchEventType.values().length];
            $SwitchMap$com$facebook$react$uimanager$events$TouchEventType = iArr;
            try {
                iArr[TouchEventType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType[TouchEventType.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String getJSEventName(TouchEventType touchEventType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[touchEventType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return TouchesHelper.TOP_TOUCH_END_KEY;
            }
            if (i == 3) {
                return "topTouchMove";
            }
            if (i == 4) {
                return TouchesHelper.TOP_TOUCH_CANCEL_KEY;
            }
            throw new IllegalArgumentException("Unexpected type " + touchEventType);
        }
        return "topTouchStart";
    }
}
