package com.facebook.react.devsupport;

import android.content.Context;
import android.text.SpannedString;
import com.facebook.react.devsupport.interfaces.StackFrame;
/* loaded from: classes.dex */
public interface RedBoxHandler {

    /* loaded from: classes.dex */
    public interface ReportCompletedListener {
        void onReportError(SpannedString spannedString);

        void onReportSuccess(SpannedString spannedString);
    }

    void handleRedbox(String str, StackFrame[] stackFrameArr, ErrorType errorType);

    boolean isReportEnabled();

    void reportRedbox(Context context, String str, StackFrame[] stackFrameArr, String str2, ReportCompletedListener reportCompletedListener);

    /* loaded from: classes.dex */
    public enum ErrorType {
        JS("JS"),
        NATIVE("Native");
        
        private final String name;

        ErrorType(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }
    }
}
