package b.f.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class c {
    public SparseArray<a> a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<d> f369b = new SparseArray<>();

    /* loaded from: classes.dex */
    public static class a {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<b> f370b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f371c;
        public d d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f371c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.h);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == 1) {
                    this.f371c = obtainStyledAttributes.getResourceId(index, this.f371c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f371c);
                    context.getResources().getResourceName(this.f371c);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.d = dVar;
                        dVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.f371c, (ViewGroup) null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f372b;

        /* renamed from: c  reason: collision with root package name */
        public float f373c;
        public float d;
        public int e;
        public d f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.a = Float.NaN;
            this.f372b = Float.NaN;
            this.f373c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), i.j);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f = dVar;
                        dVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.e, (ViewGroup) null));
                    }
                } else if (index == 1) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == 2) {
                    this.f372b = obtainStyledAttributes.getDimension(index, this.f372b);
                } else if (index == 3) {
                    this.f373c = obtainStyledAttributes.getDimension(index, this.f373c);
                } else if (index == 4) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public c(Context context, ConstraintLayout constraintLayout, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (c2 != 0 && c2 != 1) {
                        if (c2 == 2) {
                            aVar = new a(context, xml);
                            this.a.put(aVar.a, aVar);
                            continue;
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.f370b.add(bVar);
                                continue;
                            } else {
                                continue;
                            }
                        } else if (c2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                            continue;
                        } else {
                            a(context, xml);
                            continue;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x01d0, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r13, org.xmlpull.v1.XmlPullParser r14) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.c.c.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }
}
