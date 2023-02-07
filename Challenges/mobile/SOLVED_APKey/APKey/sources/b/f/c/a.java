package b.f.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class a {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public EnumC0014a f363b;

    /* renamed from: c  reason: collision with root package name */
    public int f364c;
    public float d;
    public String e;
    public boolean f;
    public int g;

    /* renamed from: b.f.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0014a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE
    }

    public a(a aVar, Object obj) {
        this.a = aVar.a;
        this.f363b = aVar.f363b;
        b(obj);
    }

    public a(String str, EnumC0014a enumC0014a, Object obj) {
        this.a = str;
        this.f363b = enumC0014a;
        b(obj);
    }

    public static void a(Context context, XmlPullParser xmlPullParser, HashMap<String, a> hashMap) {
        EnumC0014a enumC0014a;
        Object string;
        int integer;
        float dimension;
        EnumC0014a enumC0014a2 = EnumC0014a.DIMENSION_TYPE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.d);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        EnumC0014a enumC0014a3 = null;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                enumC0014a3 = EnumC0014a.BOOLEAN_TYPE;
            } else {
                if (index == 3) {
                    enumC0014a = EnumC0014a.COLOR_TYPE;
                } else if (index == 2) {
                    enumC0014a = EnumC0014a.COLOR_DRAWABLE_TYPE;
                } else {
                    if (index == 7) {
                        dimension = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == 4) {
                        dimension = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else {
                        if (index == 5) {
                            enumC0014a = EnumC0014a.FLOAT_TYPE;
                            string = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                        } else if (index == 6) {
                            enumC0014a = EnumC0014a.INT_TYPE;
                            integer = obtainStyledAttributes.getInteger(index, -1);
                            string = Integer.valueOf(integer);
                        } else if (index == 8) {
                            enumC0014a = EnumC0014a.STRING_TYPE;
                            string = obtainStyledAttributes.getString(index);
                        }
                        Object obj2 = string;
                        enumC0014a3 = enumC0014a;
                        obj = obj2;
                    }
                    obj = Float.valueOf(dimension);
                    enumC0014a3 = enumC0014a2;
                }
                integer = obtainStyledAttributes.getColor(index, 0);
                string = Integer.valueOf(integer);
                Object obj22 = string;
                enumC0014a3 = enumC0014a;
                obj = obj22;
            }
        }
        if (str != null && obj != null) {
            hashMap.put(str, new a(str, enumC0014a3, obj));
        }
        obtainStyledAttributes.recycle();
    }

    public void b(Object obj) {
        switch (this.f363b.ordinal()) {
            case 0:
                this.f364c = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.g = ((Integer) obj).intValue();
                return;
            case 4:
                this.e = (String) obj;
                return;
            case 5:
                this.f = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }
}
