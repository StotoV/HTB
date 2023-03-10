package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
/* loaded from: classes.dex */
public interface AndroidDialogPickerManagerInterface<T extends View> {
    void setBackgroundColor(T t, Integer num);

    void setColor(T t, Integer num);

    void setEnabled(T t, boolean z);

    void setItems(T t, ReadableArray readableArray);

    void setPrompt(T t, String str);

    void setSelected(T t, int i);
}
