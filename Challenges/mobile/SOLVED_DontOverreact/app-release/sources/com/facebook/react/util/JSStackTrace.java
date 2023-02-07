package com.facebook.react.util;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class JSStackTrace {
    private static final String COLUMN_KEY = "column";
    private static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");
    private static final String FILE_KEY = "file";
    private static final String LINE_NUMBER_KEY = "lineNumber";
    private static final String METHOD_NAME_KEY = "methodName";

    public static String format(String str, ReadableArray readableArray) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(", stack:\n");
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap mo175getMap = readableArray.mo175getMap(i);
            sb.append(mo175getMap.getString(METHOD_NAME_KEY));
            sb.append("@");
            sb.append(parseFileId(mo175getMap));
            if (mo175getMap.hasKey("lineNumber") && !mo175getMap.isNull("lineNumber") && mo175getMap.getType("lineNumber") == ReadableType.Number) {
                sb.append(mo175getMap.getInt("lineNumber"));
            } else {
                sb.append(-1);
            }
            if (mo175getMap.hasKey("column") && !mo175getMap.isNull("column") && mo175getMap.getType("column") == ReadableType.Number) {
                sb.append(":");
                sb.append(mo175getMap.getInt("column"));
            }
            sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
        }
        return sb.toString();
    }

    private static String parseFileId(ReadableMap readableMap) {
        String string;
        if (!readableMap.hasKey("file") || readableMap.isNull("file") || readableMap.getType("file") != ReadableType.String || (string = readableMap.getString("file")) == null) {
            return "";
        }
        Matcher matcher = FILE_ID_PATTERN.matcher(string);
        if (!matcher.find()) {
            return "";
        }
        return matcher.group(1) + ":";
    }
}
