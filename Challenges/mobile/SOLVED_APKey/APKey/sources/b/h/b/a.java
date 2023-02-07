package b.h.b;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.Property;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.EdgeEffect;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.h.c.b.c;
import b.h.c.b.d;
import b.h.c.b.e;
import b.h.h.c;
import b.h.k.f;
import b.k.b.m;
import b.k.b.t;
import b.o.b.s;
import b.q.g;
import com.example.apkey.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class a {
    public static Method a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f397b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f398c;
    public static boolean d;
    public static Field e;
    public static boolean f;
    public static Field g;
    public static boolean h;
    public static Method i;
    public static boolean j;
    public static Field k;
    public static boolean l;
    public static long m;
    public static Method n;

    public static int A(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            return drawable.getLayoutDirection();
        }
        if (i2 >= 17) {
            if (!d) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f398c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e2);
                }
                d = true;
            }
            Method method = f398c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e3) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e3);
                    f398c = null;
                }
            }
        }
        return 0;
    }

    public static int B(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginStart() : marginLayoutParams.leftMargin;
    }

    public static File C(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder g2 = c.a.a.a.a.g(".font");
        g2.append(Process.myPid());
        g2.append("-");
        g2.append(Process.myTid());
        g2.append("-");
        String sb = g2.toString();
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, sb + i2);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r10 != 2) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (r4 != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.h.h.c.a D(android.widget.TextView r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L10
            b.h.h.c$a r0 = new b.h.h.c$a
            android.text.PrecomputedText$Params r10 = r10.getTextMetricsParams()
            r0.<init>(r10)
            return r0
        L10:
            android.text.TextPaint r2 = new android.text.TextPaint
            android.text.TextPaint r3 = r10.getPaint()
            r2.<init>(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r5 = 23
            r6 = 1
            if (r3 < r5) goto L24
            r7 = 1
            r8 = 1
            goto L26
        L24:
            r7 = 0
            r8 = 0
        L26:
            r9 = 18
            if (r3 < r9) goto L2d
            android.text.TextDirectionHeuristic r3 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            goto L2e
        L2d:
            r3 = 0
        L2e:
            if (r0 < r5) goto L38
            int r7 = r10.getBreakStrategy()
            int r8 = r10.getHyphenationFrequency()
        L38:
            if (r0 < r9) goto L8c
            android.text.method.TransformationMethod r3 = r10.getTransformationMethod()
            boolean r3 = r3 instanceof android.text.method.PasswordTransformationMethod
            if (r3 == 0) goto L46
        L42:
            android.text.TextDirectionHeuristic r10 = android.text.TextDirectionHeuristics.LTR
        L44:
            r3 = r10
            goto L8c
        L46:
            if (r0 < r1) goto L6d
            int r0 = r10.getInputType()
            r0 = r0 & 15
            r1 = 3
            if (r0 != r1) goto L6d
            java.util.Locale r10 = r10.getTextLocale()
            android.icu.text.DecimalFormatSymbols r10 = android.icu.text.DecimalFormatSymbols.getInstance(r10)
            java.lang.String[] r10 = r10.getDigitStrings()
            r10 = r10[r4]
            int r10 = r10.codePointAt(r4)
            byte r10 = java.lang.Character.getDirectionality(r10)
            if (r10 == r6) goto L86
            r0 = 2
            if (r10 != r0) goto L42
            goto L86
        L6d:
            int r0 = r10.getLayoutDirection()
            if (r0 != r6) goto L74
            r4 = 1
        L74:
            int r10 = r10.getTextDirection()
            switch(r10) {
                case 2: goto L89;
                case 3: goto L42;
                case 4: goto L86;
                case 5: goto L83;
                case 6: goto L80;
                case 7: goto L7d;
                default: goto L7b;
            }
        L7b:
            if (r4 == 0) goto L80
        L7d:
            android.text.TextDirectionHeuristic r10 = android.text.TextDirectionHeuristics.FIRSTSTRONG_RTL
            goto L44
        L80:
            android.text.TextDirectionHeuristic r10 = android.text.TextDirectionHeuristics.FIRSTSTRONG_LTR
            goto L44
        L83:
            android.text.TextDirectionHeuristic r10 = android.text.TextDirectionHeuristics.LOCALE
            goto L44
        L86:
            android.text.TextDirectionHeuristic r10 = android.text.TextDirectionHeuristics.RTL
            goto L44
        L89:
            android.text.TextDirectionHeuristic r10 = android.text.TextDirectionHeuristics.ANYRTL_LTR
            goto L44
        L8c:
            b.h.h.c$a r10 = new b.h.h.c$a
            r10.<init>(r2, r3, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.b.a.D(android.widget.TextView):b.h.h.c$a");
    }

    public static int E(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static boolean F(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    public static boolean G(Rect rect, Rect rect2, int i2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        } else if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            int i9 = rect.top;
            int i10 = rect2.top;
            return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean H() {
        try {
            if (n == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (n == null) {
                    m = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                    n = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                }
                return ((Boolean) n.invoke(null, Long.valueOf(m))).booleanValue();
            } catch (Exception e2) {
                if (!(e2 instanceof InvocationTargetException)) {
                    Log.v("Trace", "Unable to call isTagEnabled via reflection", e2);
                    return false;
                }
                Throwable cause = e2.getCause();
                if (!(cause instanceof RuntimeException)) {
                    throw new RuntimeException(cause);
                }
                throw ((RuntimeException) cause);
            }
        }
        return false;
    }

    public static t I(Context context, m mVar, boolean z, boolean z2) {
        int k2;
        m.b bVar = mVar.I;
        boolean z3 = false;
        int i2 = bVar == null ? 0 : bVar.h;
        if (z2) {
            k2 = z ? mVar.u() : mVar.v();
        } else {
            k2 = z ? mVar.k() : mVar.n();
        }
        mVar.l0(0, 0, 0, 0);
        ViewGroup viewGroup = mVar.E;
        if (viewGroup != null && viewGroup.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            mVar.E.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = mVar.E;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation M = mVar.M();
            if (M != null) {
                return new t(M);
            }
            Animator N = mVar.N();
            if (N != null) {
                return new t(N);
            }
            if (k2 == 0 && i2 != 0) {
                k2 = i2 != 4097 ? i2 != 4099 ? i2 != 8194 ? -1 : z ? R.animator.fragment_close_enter : R.animator.fragment_close_exit : z ? R.animator.fragment_fade_enter : R.animator.fragment_fade_exit : z ? R.animator.fragment_open_enter : R.animator.fragment_open_exit;
            }
            if (k2 != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(k2));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, k2);
                        if (loadAnimation != null) {
                            return new t(loadAnimation);
                        }
                        z3 = true;
                    } catch (Resources.NotFoundException e2) {
                        throw e2;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z3) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, k2);
                        if (loadAnimator != null) {
                            return new t(loadAnimator);
                        }
                    } catch (RuntimeException e3) {
                        if (equals) {
                            throw e3;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, k2);
                        if (loadAnimation2 != null) {
                            return new t(loadAnimation2);
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static int J(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            i3 = rect2.top;
            i4 = rect.bottom;
        }
        return Math.max(0, i3 - i4);
    }

    public static int K(int i2, Rect rect, Rect rect2) {
        int height;
        int i3;
        int height2;
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = (rect.width() / 2) + rect.left;
            i3 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - ((height2 / 2) + i3));
        }
        height = (rect.height() / 2) + rect.top;
        i3 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - ((height2 / 2) + i3));
    }

    public static ByteBuffer L(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            fileInputStream.close();
            openFileDescriptor.close();
            return map;
        } catch (IOException unused) {
            return null;
        }
    }

    public static <T> ObjectAnimator M(T t, Property<T, PointF> property, Path path) {
        return Build.VERSION.SDK_INT >= 21 ? ObjectAnimator.ofObject(t, property, (TypeConverter) null, path) : ObjectAnimator.ofFloat(t, new g(property, path), 0.0f, 1.0f);
    }

    public static void N(EdgeEffect edgeEffect, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f2, f3);
        } else {
            edgeEffect.onPull(f2);
        }
    }

    public static b.h.c.b.b O(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.h.a.f395b);
                String string = obtainAttributes.getString(0);
                String string2 = obtainAttributes.getString(4);
                String string3 = obtainAttributes.getString(5);
                int resourceId = obtainAttributes.getResourceId(1, 0);
                int integer = obtainAttributes.getInteger(2, 1);
                int integer2 = obtainAttributes.getInteger(3, 500);
                String string4 = obtainAttributes.getString(6);
                obtainAttributes.recycle();
                if (string != null && string2 != null && string3 != null) {
                    while (xmlPullParser.next() != 3) {
                        j0(xmlPullParser);
                    }
                    return new e(new b.h.g.e(string, string2, string3, P(resources, resourceId)), integer, integer2, string4);
                }
                ArrayList arrayList = new ArrayList();
                while (xmlPullParser.next() != 3) {
                    if (xmlPullParser.getEventType() == 2) {
                        if (xmlPullParser.getName().equals("font")) {
                            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), b.h.a.f396c);
                            int i2 = 8;
                            if (!obtainAttributes2.hasValue(8)) {
                                i2 = 1;
                            }
                            int i3 = obtainAttributes2.getInt(i2, 400);
                            boolean z = 1 == obtainAttributes2.getInt(obtainAttributes2.hasValue(6) ? 6 : 2, 0);
                            int i4 = 9;
                            if (!obtainAttributes2.hasValue(9)) {
                                i4 = 3;
                            }
                            int i5 = 7;
                            if (!obtainAttributes2.hasValue(7)) {
                                i5 = 4;
                            }
                            String string5 = obtainAttributes2.getString(i5);
                            int i6 = obtainAttributes2.getInt(i4, 0);
                            int i7 = obtainAttributes2.hasValue(5) ? 5 : 0;
                            int resourceId2 = obtainAttributes2.getResourceId(i7, 0);
                            String string6 = obtainAttributes2.getString(i7);
                            obtainAttributes2.recycle();
                            while (xmlPullParser.next() != 3) {
                                j0(xmlPullParser);
                            }
                            arrayList.add(new d(string6, i3, z, string5, i6, resourceId2));
                        } else {
                            j0(xmlPullParser);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new c((d[]) arrayList.toArray(new d[arrayList.size()]));
                }
            } else {
                j0(xmlPullParser);
            }
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> P(Resources resources, int i2) {
        int i3;
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                i3 = obtainTypedArray.getType(0);
            } else {
                TypedValue typedValue = new TypedValue();
                obtainTypedArray.getValue(0, typedValue);
                i3 = typedValue.type;
            }
            if (i3 == 1) {
                for (int i4 = 0; i4 < obtainTypedArray.length(); i4++) {
                    int resourceId = obtainTypedArray.getResourceId(i4, 0);
                    if (resourceId != 0) {
                        arrayList.add(k0(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(k0(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static void Q(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void R(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (!(compoundButton instanceof f)) {
        } else {
            ((f) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    public static void S(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else if (i2 < 17) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            boolean z = true;
            if (textView.getLayoutDirection() != 1) {
                z = false;
            }
            Drawable drawable5 = z ? drawable3 : drawable;
            if (!z) {
                drawable = drawable3;
            }
            textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
        }
    }

    public static void T(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                w(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                w(layoutInflater, factory2);
            }
        }
    }

    public static void U(TextView textView, int i2) {
        g(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i2 <= Math.abs(i3)) {
            return;
        }
        textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
    }

    public static void V(Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void W(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public static void X(TextView textView, int i2) {
        g(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static boolean Y(Drawable drawable, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (i3 >= 17) {
            if (!f397b) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e2);
                }
                f397b = true;
            }
            Method method = a;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i2));
                    return true;
                } catch (Exception e3) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e3);
                    a = null;
                }
            }
        }
        return false;
    }

    public static void Z(TextView textView, int i2) {
        g(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing(i2 - fontMetricsInt, 1.0f);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static void a0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginEnd(i2);
        } else {
            marginLayoutParams.rightMargin = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r10.right <= r12.left) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        if (r10.top >= r12.bottom) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        if (r10.left >= r12.right) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        r7 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = c(r9, r10, r11)
            boolean r1 = c(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L7d
            if (r0 != 0) goto Lf
            goto L7d
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L45
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L45
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L45
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L45
        L43:
            r7 = 1
            goto L46
        L45:
            r7 = 0
        L46:
            if (r7 != 0) goto L49
            return r6
        L49:
            if (r9 == r5) goto L7c
            if (r9 != r4) goto L4e
            goto L7c
        L4e:
            int r11 = J(r9, r10, r11)
            if (r9 == r5) goto L6f
            if (r9 == r3) goto L6a
            if (r9 == r4) goto L65
            if (r9 != r1) goto L5f
            int r9 = r12.bottom
            int r10 = r10.bottom
            goto L73
        L5f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L65:
            int r9 = r12.right
            int r10 = r10.right
            goto L73
        L6a:
            int r9 = r10.top
            int r10 = r12.top
            goto L73
        L6f:
            int r9 = r10.left
            int r10 = r12.left
        L73:
            int r9 = r9 - r10
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L7b
            r2 = 1
        L7b:
            return r2
        L7c:
            return r6
        L7d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.b.a.b(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static void b0(ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(i2);
        } else {
            marginLayoutParams.leftMargin = i2;
        }
    }

    public static boolean c(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void c0(PopupWindow popupWindow, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (i2 < 21) {
        } else {
            if (!l) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    k = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e2);
                }
                l = true;
            }
            Field field = k;
            if (field == null) {
                return;
            }
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException e3) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e3);
            }
        }
    }

    public static void d(Object obj, StringBuilder sb) {
        String hexString;
        int lastIndexOf;
        if (obj == null) {
            hexString = "null";
        } else {
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }

    public static void d0(TextView textView, b.h.h.c cVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            cVar.getClass();
            textView.setText((CharSequence) null);
            return;
        }
        c.a D = D(textView);
        cVar.getClass();
        if (!D.a(null)) {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
        textView.setText(cVar);
    }

    public static boolean e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    public static void e0(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    public static boolean f(b.h.d.c[] cVarArr, b.h.d.c[] cVarArr2) {
        if (cVarArr == null || cVarArr2 == null || cVarArr.length != cVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < cVarArr.length; i2++) {
            if (cVarArr[i2].a != cVarArr2[i2].a || cVarArr[i2].f413b.length != cVarArr2[i2].f413b.length) {
                return false;
            }
        }
        return true;
    }

    public static void f0(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else if (!(drawable instanceof b.h.d.l.a)) {
        } else {
            ((b.h.d.l.a) drawable).setTint(i2);
        }
    }

    public static int g(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static void g0(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (!(drawable instanceof b.h.d.l.a)) {
        } else {
            ((b.h.d.l.a) drawable).setTintList(colorStateList);
        }
    }

    public static <T> T h(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void h0(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (!(drawable instanceof b.h.d.l.a)) {
        } else {
            ((b.h.d.l.a) drawable).setTintMode(mode);
        }
    }

    public static int i(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void i0(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!j) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                i = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            j = true;
        }
        Method method = i;
        if (method == null) {
            return;
        }
        try {
            method.invoke(popupWindow, Integer.valueOf(i2));
        } catch (Exception unused2) {
        }
    }

    public static void j(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Drawable a2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23 || i2 < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            a2 = ((InsetDrawable) drawable).getDrawable();
        } else if (!(drawable instanceof b.h.d.l.b)) {
            if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
                return;
            }
            int childCount = drawableContainerState.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                Drawable child = drawableContainerState.getChild(i3);
                if (child != null) {
                    j(child);
                }
            }
            return;
        } else {
            a2 = ((b.h.d.l.b) drawable).a();
        }
        j(a2);
    }

    public static void j0(XmlPullParser xmlPullParser) {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static int k(RecyclerView.w wVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z) {
        if (lVar.y() == 0 || wVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(lVar.R(view) - lVar.R(view2)) + 1;
        }
        return Math.min(sVar.l(), sVar.b(view2) - sVar.e(view));
    }

    public static List<byte[]> k0(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static int l(RecyclerView.w wVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z, boolean z2) {
        if (lVar.y() == 0 || wVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (wVar.b() - Math.max(lVar.R(view), lVar.R(view2))) - 1) : Math.max(0, Math.min(lVar.R(view), lVar.R(view2)));
        if (!z) {
            return max;
        }
        return Math.round((max * (Math.abs(sVar.b(view2) - sVar.e(view)) / (Math.abs(lVar.R(view) - lVar.R(view2)) + 1))) + (sVar.k() - sVar.e(view)));
    }

    public static Drawable l0(Drawable drawable) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 23 ? drawable : i2 >= 21 ? !(drawable instanceof b.h.d.l.a) ? new b.h.d.l.d(drawable) : drawable : !(drawable instanceof b.h.d.l.a) ? new b.h.d.l.c(drawable) : drawable;
    }

    public static int m(RecyclerView.w wVar, s sVar, View view, View view2, RecyclerView.l lVar, boolean z) {
        if (lVar.y() == 0 || wVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return wVar.b();
        }
        return (int) (((sVar.b(view2) - sVar.e(view)) / (Math.abs(lVar.R(view) - lVar.R(view2)) + 1)) * wVar.b());
    }

    public static ActionMode.Callback m0(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof b.h.k.d)) ? callback : new b.h.k.d(callback, textView);
    }

    public static float[] n(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static boolean o(File file, Resources resources, int i2) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i2);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean p = p(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return p;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean p(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static ColorStateList q(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return r(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.Object[], java.lang.Object] */
    public static ColorStateList r(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            int i2 = 1;
            int depth2 = xmlPullParser.getDepth() + 1;
            int[][] iArr = new int[20];
            int[] iArr2 = new int[20];
            int i3 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == i2 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    break;
                }
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    int[] iArr3 = b.h.a.a;
                    TypedArray obtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr3) : theme.obtainStyledAttributes(attributeSet, iArr3, 0, 0);
                    int color = obtainAttributes.getColor(0, -65281);
                    float f2 = 1.0f;
                    if (obtainAttributes.hasValue(i2)) {
                        f2 = obtainAttributes.getFloat(i2, 1.0f);
                    } else if (obtainAttributes.hasValue(2)) {
                        f2 = obtainAttributes.getFloat(2, 1.0f);
                    }
                    obtainAttributes.recycle();
                    int attributeCount = attributeSet.getAttributeCount();
                    int[] iArr4 = new int[attributeCount];
                    int i4 = 0;
                    for (int i5 = 0; i5 < attributeCount; i5++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i5);
                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R.attr.alpha) {
                            int i6 = i4 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i5, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr4[i4] = attributeNameResource;
                            i4 = i6;
                        }
                    }
                    int[] trimStateSet = StateSet.trimStateSet(iArr4, i4);
                    int round = (Math.round(Color.alpha(color) * f2) << 24) | (16777215 & color);
                    int i7 = i3 + 1;
                    int i8 = 8;
                    if (i7 > iArr2.length) {
                        int[] iArr5 = new int[i3 <= 4 ? 8 : i3 * 2];
                        System.arraycopy(iArr2, 0, iArr5, 0, i3);
                        iArr2 = iArr5;
                    }
                    iArr2[i3] = round;
                    if (i7 > iArr.length) {
                        Class<?> componentType = iArr.getClass().getComponentType();
                        if (i3 > 4) {
                            i8 = i3 * 2;
                        }
                        ?? r8 = (Object[]) Array.newInstance(componentType, i8);
                        System.arraycopy(iArr, 0, r8, 0, i3);
                        iArr = r8;
                    }
                    iArr[i3] = trimStateSet;
                    iArr = iArr;
                    i3 = i7;
                }
                i2 = 1;
            }
            int[] iArr6 = new int[i3];
            int[][] iArr7 = new int[i3];
            System.arraycopy(iArr2, 0, iArr6, 0, i3);
            System.arraycopy(iArr, 0, iArr7, 0, i3);
            return new ColorStateList(iArr7, iArr6);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x008b, code lost:
        if (r13 == false) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0098 A[Catch: NumberFormatException -> 0x00ba, LOOP:3: B:29:0x006d->B:49:0x0098, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00ba, blocks: (B:26:0x005a, B:29:0x006d, B:31:0x0073, B:36:0x0081, B:49:0x0098, B:51:0x009d, B:54:0x00ad, B:56:0x00b2), top: B:71:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d A[Catch: NumberFormatException -> 0x00ba, TryCatch #0 {NumberFormatException -> 0x00ba, blocks: (B:26:0x005a, B:29:0x006d, B:31:0x0073, B:36:0x0081, B:49:0x0098, B:51:0x009d, B:54:0x00ad, B:56:0x00b2), top: B:71:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ad A[Catch: NumberFormatException -> 0x00ba, TryCatch #0 {NumberFormatException -> 0x00ba, blocks: (B:26:0x005a, B:29:0x006d, B:31:0x0073, B:36:0x0081, B:49:0x0098, B:51:0x009d, B:54:0x00ad, B:56:0x00b2), top: B:71:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0097 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static b.h.d.c[] s(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.h.b.a.s(java.lang.String):b.h.d.c[]");
    }

    public static Path t(String str) {
        Path path = new Path();
        b.h.d.c[] s = s(str);
        if (s != null) {
            try {
                b.h.d.c.b(s, path);
                return path;
            } catch (RuntimeException e2) {
                throw new RuntimeException(c.a.a.a.a.d("Error in parsing ", str), e2);
            }
        }
        return null;
    }

    public static b.h.d.c[] u(b.h.d.c[] cVarArr) {
        if (cVarArr == null) {
            return null;
        }
        b.h.d.c[] cVarArr2 = new b.h.d.c[cVarArr.length];
        for (int i2 = 0; i2 < cVarArr.length; i2++) {
            cVarArr2[i2] = new b.h.d.c(cVarArr[i2]);
        }
        return cVarArr2;
    }

    public static boolean v(Object obj, Object obj2) {
        return Build.VERSION.SDK_INT >= 19 ? defpackage.a.a(obj, obj2) : obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void w(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField("mFactory2");
                e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                StringBuilder g2 = c.a.a.a.a.g("forceSetFactory2 Could not find field 'mFactory2' on class ");
                g2.append(LayoutInflater.class.getName());
                g2.append("; inflation may have unexpected results.");
                Log.e("LayoutInflaterCompatHC", g2.toString(), e2);
            }
            f = true;
        }
        Field field = e;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }

    public static int x(int i2, int i3) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i2, i3) : i2 & (-8388609);
    }

    public static Drawable y(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!h) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e2);
            }
            h = true;
        }
        Field field = g;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e3);
                g = null;
            }
        }
        return null;
    }

    public static Drawable[] z(TextView textView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i2 < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z = true;
        if (textView.getLayoutDirection() != 1) {
            z = false;
        }
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }
}
