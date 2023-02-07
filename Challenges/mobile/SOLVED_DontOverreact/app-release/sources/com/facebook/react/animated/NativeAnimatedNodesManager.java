package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final String TAG = "NativeAnimatedNodesManager";
    private final ReactApplicationContext mReactApplicationContext;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();
    private final Map<String, List<EventAnimationDriver>> mEventDrivers = new HashMap();
    private int mAnimatedGraphBFSColor = 0;
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private boolean mEventListenerInitializedForFabric = false;
    private boolean mEventListenerInitializedForNonFabric = false;
    private boolean mWarnedAboutGraphTraversal = false;

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    public void initializeEventListenerForUIManagerType(final int i) {
        if (i != 2 || !this.mEventListenerInitializedForFabric) {
            if (i == 1 && this.mEventListenerInitializedForNonFabric) {
                return;
            }
            this.mReactApplicationContext.runOnUiQueueThread(new Runnable() { // from class: com.facebook.react.animated.NativeAnimatedNodesManager.1
                @Override // java.lang.Runnable
                public void run() {
                    UIManager uIManager = UIManagerHelper.getUIManager(NativeAnimatedNodesManager.this.mReactApplicationContext, i);
                    if (uIManager != null) {
                        ((EventDispatcher) uIManager.mo180getEventDispatcher()).addListener(this);
                        if (i == 2) {
                            NativeAnimatedNodesManager.this.mEventListenerInitializedForFabric = true;
                        } else {
                            NativeAnimatedNodesManager.this.mEventListenerInitializedForNonFabric = true;
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public boolean hasActiveAnimations() {
        return this.mActiveAnimations.size() > 0 || this.mUpdatedNodes.size() > 0;
    }

    public void createAnimatedNode(int i, ReadableMap readableMap) {
        AnimatedNode trackingAnimatedNode;
        if (this.mAnimatedNodes.get(i) != null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " already exists");
        }
        String string = readableMap.getString("type");
        if ("style".equals(string)) {
            trackingAnimatedNode = new StyleAnimatedNode(readableMap, this);
        } else if ("value".equals(string)) {
            trackingAnimatedNode = new ValueAnimatedNode(readableMap);
        } else if ("props".equals(string)) {
            trackingAnimatedNode = new PropsAnimatedNode(readableMap, this);
        } else if ("interpolation".equals(string)) {
            trackingAnimatedNode = new InterpolationAnimatedNode(readableMap);
        } else if ("addition".equals(string)) {
            trackingAnimatedNode = new AdditionAnimatedNode(readableMap, this);
        } else if ("subtraction".equals(string)) {
            trackingAnimatedNode = new SubtractionAnimatedNode(readableMap, this);
        } else if ("division".equals(string)) {
            trackingAnimatedNode = new DivisionAnimatedNode(readableMap, this);
        } else if ("multiplication".equals(string)) {
            trackingAnimatedNode = new MultiplicationAnimatedNode(readableMap, this);
        } else if ("modulus".equals(string)) {
            trackingAnimatedNode = new ModulusAnimatedNode(readableMap, this);
        } else if ("diffclamp".equals(string)) {
            trackingAnimatedNode = new DiffClampAnimatedNode(readableMap, this);
        } else if (ViewProps.TRANSFORM.equals(string)) {
            trackingAnimatedNode = new TransformAnimatedNode(readableMap, this);
        } else if ("tracking".equals(string)) {
            trackingAnimatedNode = new TrackingAnimatedNode(readableMap, this);
        } else {
            throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
        }
        trackingAnimatedNode.mTag = i;
        this.mAnimatedNodes.put(i, trackingAnimatedNode);
        this.mUpdatedNodes.put(i, trackingAnimatedNode);
    }

    public void dropAnimatedNode(int i) {
        this.mAnimatedNodes.remove(i);
        this.mUpdatedNodes.remove(i);
    }

    public void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(null);
    }

    public void setAnimatedNodeValue(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).mValue = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void setAnimatedNodeOffset(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).mOffset = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    public void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver decayAnimation;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exist");
        } else if (!(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node should be of type " + ValueAnimatedNode.class.getName());
        } else {
            AnimationDriver animationDriver = this.mActiveAnimations.get(i);
            if (animationDriver != null) {
                animationDriver.resetConfig(readableMap);
                return;
            }
            String string = readableMap.getString("type");
            if ("frames".equals(string)) {
                decayAnimation = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(string)) {
                decayAnimation = new SpringAnimation(readableMap);
            } else if ("decay".equals(string)) {
                decayAnimation = new DecayAnimation(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported animation type: " + string);
            }
            decayAnimation.mId = i;
            decayAnimation.mEndCallback = callback;
            decayAnimation.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i, decayAnimation);
        }
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public void stopAnimation(int i) {
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            if (valueAt.mId == i) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                }
                this.mActiveAnimations.removeAt(i2);
                return;
            }
        }
    }

    public void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
        }
        AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
        if (animatedNode2 == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
        }
        animatedNode.addChild(animatedNode2);
        this.mUpdatedNodes.put(i2, animatedNode2);
    }

    public void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
        }
        AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
        if (animatedNode2 == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
        }
        animatedNode.removeChild(animatedNode2);
        this.mUpdatedNodes.put(i2, animatedNode2);
    }

    public void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
        } else if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        } else {
            ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
            if (reactApplicationContext == null) {
                throw new IllegalStateException("Animated node could not be connected, no ReactApplicationContext: " + i2);
            }
            UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i2);
            if (uIManagerForReactTag == null) {
                ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException("Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i2));
                return;
            }
            ((PropsAnimatedNode) animatedNode).connectToView(i2, uIManagerForReactTag);
            this.mUpdatedNodes.put(i, animatedNode);
        }
    }

    public void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists");
        } else if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        } else {
            ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
        }
    }

    public void getValue(int i, Callback callback) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null && (animatedNode instanceof ValueAnimatedNode)) {
            callback.invoke(Double.valueOf(((ValueAnimatedNode) animatedNode).getValue()));
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with tag " + i + " does not exists or is not a 'value' node");
    }

    public void restoreDefaultValues(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            return;
        }
        if (!(animatedNode instanceof PropsAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + PropsAnimatedNode.class.getName());
        }
        ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
    }

    public void addAnimatedEventToView(int i, String str, ReadableMap readableMap) {
        int i2 = readableMap.getInt("animatedValueTag");
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("Animated node with tag " + i2 + " does not exists");
        } else if (!(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("Animated node connected to event should beof type " + ValueAnimatedNode.class.getName());
        } else {
            ReadableArray array = readableMap.getArray("nativeEventPath");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i3 = 0; i3 < array.size(); i3++) {
                arrayList.add(array.getString(i3));
            }
            EventAnimationDriver eventAnimationDriver = new EventAnimationDriver(arrayList, (ValueAnimatedNode) animatedNode);
            String str2 = i + str;
            if (this.mEventDrivers.containsKey(str2)) {
                this.mEventDrivers.get(str2).add(eventAnimationDriver);
                return;
            }
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(eventAnimationDriver);
            this.mEventDrivers.put(str2, arrayList2);
        }
    }

    public void removeAnimatedEventFromView(int i, String str, int i2) {
        String str2 = i + str;
        if (this.mEventDrivers.containsKey(str2)) {
            List<EventAnimationDriver> list = this.mEventDrivers.get(str2);
            if (list.size() == 1) {
                this.mEventDrivers.remove(i + str);
                return;
            }
            ListIterator<EventAnimationDriver> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().mValueNode.mTag == i2) {
                    listIterator.remove();
                    return;
                }
            }
        }
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherListener
    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.animated.NativeAnimatedNodesManager.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEvent(Event event) {
        ReactApplicationContext reactApplicationContext;
        UIManager uIManagerForReactTag;
        if (this.mEventDrivers.isEmpty() || (reactApplicationContext = this.mReactApplicationContext) == null || (uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, event.getViewTag())) == null) {
            return;
        }
        String resolveCustomDirectEventName = uIManagerForReactTag.resolveCustomDirectEventName(event.getEventName());
        if (resolveCustomDirectEventName == null) {
            resolveCustomDirectEventName = "";
        }
        Map<String, List<EventAnimationDriver>> map = this.mEventDrivers;
        List<EventAnimationDriver> list = map.get(event.getViewTag() + resolveCustomDirectEventName);
        if (list == null) {
            return;
        }
        for (EventAnimationDriver eventAnimationDriver : list) {
            stopAnimationsForNode(eventAnimationDriver.mValueNode);
            event.dispatch(eventAnimationDriver);
            this.mRunUpdateNodeList.add(eventAnimationDriver.mValueNode);
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            valueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    private void updateNodes(List<AnimatedNode> list) {
        int i = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i;
        if (i == 0) {
            this.mAnimatedGraphBFSColor = i + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i2 = 0;
        for (AnimatedNode animatedNode : list) {
            int i3 = animatedNode.mBFSColor;
            int i4 = this.mAnimatedGraphBFSColor;
            if (i3 != i4) {
                animatedNode.mBFSColor = i4;
                i2++;
                arrayDeque.add(animatedNode);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode2 = (AnimatedNode) arrayDeque.poll();
            if (animatedNode2.mChildren != null) {
                for (int i5 = 0; i5 < animatedNode2.mChildren.size(); i5++) {
                    AnimatedNode animatedNode3 = animatedNode2.mChildren.get(i5);
                    animatedNode3.mActiveIncomingNodes++;
                    int i6 = animatedNode3.mBFSColor;
                    int i7 = this.mAnimatedGraphBFSColor;
                    if (i6 != i7) {
                        animatedNode3.mBFSColor = i7;
                        i2++;
                        arrayDeque.add(animatedNode3);
                    }
                }
            }
        }
        int i8 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i8;
        if (i8 == 0) {
            this.mAnimatedGraphBFSColor = i8 + 1;
        }
        int i9 = 0;
        for (AnimatedNode animatedNode4 : list) {
            if (animatedNode4.mActiveIncomingNodes == 0) {
                int i10 = animatedNode4.mBFSColor;
                int i11 = this.mAnimatedGraphBFSColor;
                if (i10 != i11) {
                    animatedNode4.mBFSColor = i11;
                    i9++;
                    arrayDeque.add(animatedNode4);
                }
            }
        }
        int i12 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode5 = (AnimatedNode) arrayDeque.poll();
            try {
                animatedNode5.update();
                if (animatedNode5 instanceof PropsAnimatedNode) {
                    ((PropsAnimatedNode) animatedNode5).updateView();
                }
            } catch (JSApplicationCausedNativeException e) {
                FLog.e(TAG, "Native animation workaround, frame lost as result of race condition", e);
            }
            if (animatedNode5 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode5).onValueUpdate();
            }
            if (animatedNode5.mChildren != null) {
                for (int i13 = 0; i13 < animatedNode5.mChildren.size(); i13++) {
                    AnimatedNode animatedNode6 = animatedNode5.mChildren.get(i13);
                    animatedNode6.mActiveIncomingNodes--;
                    if (animatedNode6.mBFSColor != this.mAnimatedGraphBFSColor && animatedNode6.mActiveIncomingNodes == 0) {
                        animatedNode6.mBFSColor = this.mAnimatedGraphBFSColor;
                        i9++;
                        arrayDeque.add(animatedNode6);
                    } else if (animatedNode6.mBFSColor == this.mAnimatedGraphBFSColor) {
                        i12++;
                    }
                }
            }
        }
        if (i2 != i9) {
            if (this.mWarnedAboutGraphTraversal) {
                return;
            }
            this.mWarnedAboutGraphTraversal = true;
            FLog.e(TAG, "Detected animation cycle or disconnected graph. ");
            for (AnimatedNode animatedNode7 : list) {
                FLog.e(TAG, animatedNode7.prettyPrintWithChildren());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + (i12 > 0 ? "cycles (" + i12 + ")" : "disconnected regions") + ", there are " + i2 + " but toposort visited only " + i9);
            boolean z = this.mEventListenerInitializedForFabric;
            if (z && i12 == 0) {
                ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException(illegalStateException));
                return;
            } else if (z) {
                ReactSoftException.logSoftException(TAG, new ReactNoCrashSoftException(illegalStateException));
                return;
            } else {
                throw illegalStateException;
            }
        }
        this.mWarnedAboutGraphTraversal = false;
    }
}
