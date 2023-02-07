package b.r.a.a;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import b.h.c.b.h;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static class a implements TypeEvaluator<b.h.d.c[]> {
        public b.h.d.c[] a;

        @Override // android.animation.TypeEvaluator
        public b.h.d.c[] evaluate(float f, b.h.d.c[] cVarArr, b.h.d.c[] cVarArr2) {
            b.h.d.c[] cVarArr3 = cVarArr;
            b.h.d.c[] cVarArr4 = cVarArr2;
            if (b.h.b.a.f(cVarArr3, cVarArr4)) {
                if (!b.h.b.a.f(this.a, cVarArr3)) {
                    this.a = b.h.b.a.u(cVarArr3);
                }
                for (int i = 0; i < cVarArr3.length; i++) {
                    b.h.d.c cVar = this.a[i];
                    b.h.d.c cVar2 = cVarArr3[i];
                    b.h.d.c cVar3 = cVarArr4[i];
                    cVar.getClass();
                    cVar.a = cVar2.a;
                    int i2 = 0;
                    while (true) {
                        float[] fArr = cVar2.f413b;
                        if (i2 < fArr.length) {
                            cVar.f413b[i2] = (cVar3.f413b[i2] * f) + ((1.0f - f) * fArr[i2]);
                            i2++;
                        }
                    }
                }
                return this.a;
            }
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:0x034a, code lost:
        if (r26 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x034c, code lost:
        if (r13 == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x034e, code lost:
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x035d, code lost:
        if (r2.hasNext() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x035f, code lost:
        r1[r3] = (android.animation.Animator) r2.next();
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x036b, code lost:
        if (r27 != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x036d, code lost:
        r26.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0371, code lost:
        r26.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0374, code lost:
        return r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator a(android.content.Context r21, android.content.res.Resources r22, android.content.res.Resources.Theme r23, org.xmlpull.v1.XmlPullParser r24, android.util.AttributeSet r25, android.animation.AnimatorSet r26, int r27, float r28) {
        /*
            Method dump skipped, instructions count: 885
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.r.a.a.c.a(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.animation.AnimatorSet, int, float):android.animation.Animator");
    }

    public static Keyframe b(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    public static PropertyValuesHolder c(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder ofInt;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i2);
        boolean z = peekValue != null;
        int i4 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i3);
        boolean z2 = peekValue2 != null;
        int i5 = z2 ? peekValue2.type : 0;
        if (i == 4) {
            i = ((!z || !d(i4)) && (!z2 || !d(i5))) ? 0 : 3;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i != 2) {
            d dVar = i == 3 ? d.a : null;
            if (z3) {
                if (z) {
                    float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                    if (z2) {
                        ofInt = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                    } else {
                        ofInt = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    ofInt = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                }
            } else if (!z) {
                if (z2) {
                    ofInt = PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : d(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                }
                if (propertyValuesHolder == null && dVar != null) {
                    propertyValuesHolder.setEvaluator(dVar);
                    return propertyValuesHolder;
                }
            } else {
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : d(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    ofInt = PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : d(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                } else {
                    ofInt = PropertyValuesHolder.ofInt(str, dimension2);
                }
            }
            propertyValuesHolder = ofInt;
            return propertyValuesHolder == null ? propertyValuesHolder : propertyValuesHolder;
        }
        String string = typedArray.getString(i2);
        String string2 = typedArray.getString(i3);
        b.h.d.c[] s = b.h.b.a.s(string);
        b.h.d.c[] s2 = b.h.b.a.s(string2);
        if (s == null && s2 == null) {
            return null;
        }
        if (s == null) {
            if (s2 == null) {
                return null;
            }
            return PropertyValuesHolder.ofObject(str, new a(), s2);
        }
        a aVar = new a();
        if (s2 == null) {
            ofObject = PropertyValuesHolder.ofObject(str, aVar, s);
        } else if (!b.h.b.a.f(s, s2)) {
            throw new InflateException(" Can't morph from " + string + " to " + string2);
        } else {
            ofObject = PropertyValuesHolder.ofObject(str, aVar, s, s2);
        }
        return ofObject;
    }

    public static boolean d(int i) {
        return i >= 28 && i <= 31;
    }

    public static ValueAnimator e(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        ValueAnimator valueAnimator2;
        TypedArray typedArray;
        TypedArray typedArray2;
        ValueAnimator valueAnimator3;
        PropertyValuesHolder propertyValuesHolder;
        TypedArray e = h.e(resources, theme, attributeSet, b.r.a.a.a.g);
        TypedArray e2 = h.e(resources, theme, attributeSet, b.r.a.a.a.k);
        ValueAnimator valueAnimator4 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        int i = 300;
        if (h.c(xmlPullParser, "duration")) {
            i = e.getInt(1, 300);
        }
        long j = i;
        int i2 = 0;
        long j2 = !h.c(xmlPullParser, "startOffset") ? 0 : e.getInt(2, 0);
        int i3 = !h.c(xmlPullParser, "valueType") ? 4 : e.getInt(7, 4);
        if (h.c(xmlPullParser, "valueFrom") && h.c(xmlPullParser, "valueTo")) {
            if (i3 == 4) {
                TypedValue peekValue = e.peekValue(5);
                boolean z = peekValue != null;
                int i4 = z ? peekValue.type : 0;
                TypedValue peekValue2 = e.peekValue(6);
                boolean z2 = peekValue2 != null;
                i3 = ((!z || !d(i4)) && (!z2 || !d(z2 ? peekValue2.type : 0))) ? 0 : 3;
            }
            PropertyValuesHolder c2 = c(e, i3, 5, 6, "");
            if (c2 != null) {
                valueAnimator4.setValues(c2);
            }
        }
        valueAnimator4.setDuration(j);
        valueAnimator4.setStartDelay(j2);
        valueAnimator4.setRepeatCount(!h.c(xmlPullParser, "repeatCount") ? 0 : e.getInt(3, 0));
        valueAnimator4.setRepeatMode(!h.c(xmlPullParser, "repeatMode") ? 1 : e.getInt(4, 1));
        if (e2 != null) {
            ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator4;
            String b2 = h.b(e2, xmlPullParser, "pathData", 1);
            if (b2 != null) {
                String b3 = h.b(e2, xmlPullParser, "propertyXName", 2);
                String b4 = h.b(e2, xmlPullParser, "propertyYName", 3);
                if (b3 == null && b4 == null) {
                    throw new InflateException(e2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path t = b.h.b.a.t(b2);
                float f2 = 0.5f * f;
                PathMeasure pathMeasure = new PathMeasure(t, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f3 = 0.0f;
                do {
                    f3 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f3));
                } while (pathMeasure.nextContour());
                PathMeasure pathMeasure2 = new PathMeasure(t, false);
                int min = Math.min(100, ((int) (f3 / f2)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f4 = f3 / (min - 1);
                valueAnimator2 = valueAnimator4;
                typedArray = e;
                int i5 = 0;
                float f5 = 0.0f;
                while (true) {
                    propertyValuesHolder = null;
                    if (i2 >= min) {
                        break;
                    }
                    int i6 = min;
                    pathMeasure2.getPosTan(f5 - ((Float) arrayList.get(i5)).floatValue(), fArr3, null);
                    fArr[i2] = fArr3[0];
                    fArr2[i2] = fArr3[1];
                    f5 += f4;
                    int i7 = i5 + 1;
                    if (i7 < arrayList.size() && f5 > ((Float) arrayList.get(i7)).floatValue()) {
                        pathMeasure2.nextContour();
                        i5 = i7;
                    }
                    i2++;
                    min = i6;
                }
                PropertyValuesHolder ofFloat = b3 != null ? PropertyValuesHolder.ofFloat(b3, fArr) : null;
                if (b4 != null) {
                    propertyValuesHolder = PropertyValuesHolder.ofFloat(b4, fArr2);
                }
                if (ofFloat == null) {
                    i2 = 0;
                    objectAnimator.setValues(propertyValuesHolder);
                } else {
                    i2 = 0;
                    if (propertyValuesHolder == null) {
                        objectAnimator.setValues(ofFloat);
                    } else {
                        objectAnimator.setValues(ofFloat, propertyValuesHolder);
                    }
                }
            } else {
                valueAnimator2 = valueAnimator4;
                typedArray = e;
                objectAnimator.setPropertyName(h.b(e2, xmlPullParser, "propertyName", 0));
            }
        } else {
            valueAnimator2 = valueAnimator4;
            typedArray = e;
        }
        if (!h.c(xmlPullParser, "interpolator")) {
            typedArray2 = typedArray;
        } else {
            typedArray2 = typedArray;
            i2 = typedArray2.getResourceId(i2, i2);
        }
        if (i2 > 0) {
            valueAnimator3 = valueAnimator2;
            valueAnimator3.setInterpolator(b.q.h.b(context, i2));
        } else {
            valueAnimator3 = valueAnimator2;
        }
        typedArray2.recycle();
        if (e2 != null) {
            e2.recycle();
        }
        return valueAnimator3;
    }
}
