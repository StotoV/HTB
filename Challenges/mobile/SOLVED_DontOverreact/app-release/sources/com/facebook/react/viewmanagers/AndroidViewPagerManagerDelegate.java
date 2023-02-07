package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.BaseViewManagerDelegate;
import com.facebook.react.uimanager.BaseViewManagerInterface;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerInterface;
/* loaded from: classes.dex */
public class AndroidViewPagerManagerDelegate<T extends View, U extends BaseViewManagerInterface<T> & AndroidViewPagerManagerInterface<T>> extends BaseViewManagerDelegate<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public AndroidViewPagerManagerDelegate(BaseViewManagerInterface baseViewManagerInterface) {
        super(baseViewManagerInterface);
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void setProperty(T t, String str, Object obj) {
        str.hashCode();
        boolean z = true;
        int i = 0;
        boolean z2 = false;
        int i2 = 0;
        char c = 65535;
        switch (str.hashCode()) {
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    c = 0;
                    break;
                }
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c = 1;
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c = 2;
                    break;
                }
                break;
            case 1233251315:
                if (str.equals("initialPage")) {
                    c = 3;
                    break;
                }
                break;
            case 1919780198:
                if (str.equals("peekEnabled")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                AndroidViewPagerManagerInterface androidViewPagerManagerInterface = (AndroidViewPagerManagerInterface) this.mViewManager;
                if (obj != null) {
                    z = ((Boolean) obj).booleanValue();
                }
                androidViewPagerManagerInterface.setScrollEnabled(t, z);
                return;
            case 1:
                ((AndroidViewPagerManagerInterface) this.mViewManager).setKeyboardDismissMode(t, (String) obj);
                return;
            case 2:
                AndroidViewPagerManagerInterface androidViewPagerManagerInterface2 = (AndroidViewPagerManagerInterface) this.mViewManager;
                if (obj != null) {
                    i = ((Double) obj).intValue();
                }
                androidViewPagerManagerInterface2.setPageMargin(t, i);
                return;
            case 3:
                AndroidViewPagerManagerInterface androidViewPagerManagerInterface3 = (AndroidViewPagerManagerInterface) this.mViewManager;
                if (obj != null) {
                    i2 = ((Double) obj).intValue();
                }
                androidViewPagerManagerInterface3.setInitialPage(t, i2);
                return;
            case 4:
                AndroidViewPagerManagerInterface androidViewPagerManagerInterface4 = (AndroidViewPagerManagerInterface) this.mViewManager;
                if (obj != null) {
                    z2 = ((Boolean) obj).booleanValue();
                }
                androidViewPagerManagerInterface4.setPeekEnabled(t, z2);
                return;
            default:
                super.setProperty(t, str, obj);
                return;
        }
    }

    @Override // com.facebook.react.uimanager.BaseViewManagerDelegate, com.facebook.react.uimanager.ViewManagerDelegate
    public void receiveCommand(T t, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setPageWithoutAnimation")) {
            ((AndroidViewPagerManagerInterface) this.mViewManager).setPageWithoutAnimation(t, readableArray.getInt(0));
        } else if (!str.equals("setPage")) {
        } else {
            ((AndroidViewPagerManagerInterface) this.mViewManager).setPage(t, readableArray.getInt(0));
        }
    }
}
