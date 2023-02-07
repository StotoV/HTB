package b.r.a.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b.h.c.b.h;
import b.r.a.a.g;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public class b extends f implements Animatable {

    /* renamed from: c  reason: collision with root package name */
    public C0033b f739c;
    public Context d;
    public ArgbEvaluator e;
    public final Drawable.Callback f;

    /* loaded from: classes.dex */
    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            b.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            b.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            b.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: b.r.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0033b extends Drawable.ConstantState {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public g f741b;

        /* renamed from: c  reason: collision with root package name */
        public AnimatorSet f742c;
        public ArrayList<Animator> d;
        public b.e.a<Animator, String> e;

        public C0033b(C0033b c0033b, Drawable.Callback callback, Resources resources) {
            if (c0033b != null) {
                this.a = c0033b.a;
                g gVar = c0033b.f741b;
                if (gVar != null) {
                    Drawable.ConstantState constantState = gVar.getConstantState();
                    g gVar2 = (g) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.f741b = gVar2;
                    gVar2.mutate();
                    this.f741b = gVar2;
                    gVar2.setCallback(callback);
                    this.f741b.setBounds(c0033b.f741b.getBounds());
                    this.f741b.g = false;
                }
                ArrayList<Animator> arrayList = c0033b.d;
                if (arrayList == null) {
                    return;
                }
                int size = arrayList.size();
                this.d = new ArrayList<>(size);
                this.e = new b.e.a<>(size);
                for (int i = 0; i < size; i++) {
                    Animator animator = c0033b.d.get(i);
                    Animator clone = animator.clone();
                    String orDefault = c0033b.e.getOrDefault(animator, null);
                    clone.setTarget(this.f741b.f745c.f752b.p.getOrDefault(orDefault, null));
                    this.d.add(clone);
                    this.e.put(clone, orDefault);
                }
                if (this.f742c == null) {
                    this.f742c = new AnimatorSet();
                }
                this.f742c.playTogether(this.d);
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public b() {
        this(null, null, null);
    }

    public b(Context context, C0033b c0033b, Resources resources) {
        this.e = null;
        a aVar = new a();
        this.f = aVar;
        this.d = context;
        this.f739c = new C0033b(null, aVar, null);
    }

    public final void a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if (!"fillColor".equals(propertyName) && !"strokeColor".equals(propertyName)) {
                return;
            }
            if (this.e == null) {
                this.e = new ArgbEvaluator();
            }
            objectAnimator.setEvaluator(this.e);
        }
    }

    @Override // b.r.a.a.f, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            return b.h.b.a.e(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f739c.f741b.draw(canvas);
        if (!this.f739c.f742c.isStarted()) {
            return;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            if (Build.VERSION.SDK_INT < 19) {
                return 0;
            }
            return drawable.getAlpha();
        }
        return this.f739c.f741b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f739c.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return drawable.getColorFilter();
        }
        return this.f739c.f741b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f744b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f744b.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f739c.f741b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f739c.f741b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.getOpacity() : this.f739c.f741b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        XmlResourceParser xmlResourceParser;
        int i;
        Animator a2;
        g gVar;
        int next;
        Drawable drawable = this.f744b;
        int i2 = 21;
        if (drawable != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                drawable.inflate(resources, xmlPullParser, attributeSet, theme);
                return;
            } else {
                drawable.inflate(resources, xmlPullParser, attributeSet);
                return;
            }
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        for (int i3 = 1; eventType != i3 && (xmlPullParser.getDepth() >= depth || eventType != 3); i3 = 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray e = h.e(resources, theme, attributeSet, b.r.a.a.a.e);
                    int resourceId = e.getResourceId(0, 0);
                    if (resourceId != 0) {
                        PorterDuff.Mode mode = g.k;
                        int i4 = Build.VERSION.SDK_INT;
                        if (i4 >= 24) {
                            gVar = new g();
                            gVar.f744b = i4 >= i2 ? resources.getDrawable(resourceId, theme) : resources.getDrawable(resourceId);
                            new g.i(gVar.f744b.getConstantState());
                        } else {
                            try {
                                XmlResourceParser xml = resources.getXml(resourceId);
                                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                                while (true) {
                                    next = xml.next();
                                    if (next == 2 || next == i3) {
                                        break;
                                    }
                                }
                                if (next != 2) {
                                    throw new XmlPullParserException("No start tag found");
                                    break;
                                }
                                gVar = g.a(resources, xml, asAttributeSet, theme);
                            } catch (IOException | XmlPullParserException e2) {
                                Log.e("VectorDrawableCompat", "parser error", e2);
                                gVar = null;
                            }
                        }
                        gVar.g = false;
                        gVar.setCallback(this.f);
                        g gVar2 = this.f739c.f741b;
                        if (gVar2 != null) {
                            gVar2.setCallback(null);
                        }
                        this.f739c.f741b = gVar;
                    }
                    e.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, b.r.a.a.a.f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(i3, 0);
                    if (resourceId2 != 0) {
                        Context context = this.d;
                        if (context != null) {
                            int i5 = Build.VERSION.SDK_INT;
                            if (i5 >= 24) {
                                a2 = AnimatorInflater.loadAnimator(context, resourceId2);
                                i = i5;
                            } else {
                                Resources resources2 = context.getResources();
                                Resources.Theme theme2 = context.getTheme();
                                try {
                                    try {
                                        xmlResourceParser = resources2.getAnimation(resourceId2);
                                    } catch (Throwable th) {
                                        th = th;
                                        xmlResourceParser = null;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                } catch (XmlPullParserException e4) {
                                    e = e4;
                                }
                                try {
                                    i = i5;
                                    a2 = b.r.a.a.c.a(context, resources2, theme2, xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), null, 0, 1.0f);
                                    xmlResourceParser.close();
                                } catch (IOException e5) {
                                    e = e5;
                                    Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                    notFoundException.initCause(e);
                                    throw notFoundException;
                                } catch (XmlPullParserException e6) {
                                    e = e6;
                                    Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(resourceId2));
                                    notFoundException2.initCause(e);
                                    throw notFoundException2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (xmlResourceParser != null) {
                                        xmlResourceParser.close();
                                    }
                                    throw th;
                                }
                            }
                            a2.setTarget(this.f739c.f741b.f745c.f752b.p.getOrDefault(string, null));
                            if (i < 21) {
                                a(a2);
                            }
                            C0033b c0033b = this.f739c;
                            if (c0033b.d == null) {
                                c0033b.d = new ArrayList<>();
                                this.f739c.e = new b.e.a<>();
                            }
                            this.f739c.d.add(a2);
                            this.f739c.e.put(a2, string);
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                    eventType = xmlPullParser.next();
                    i2 = 21;
                }
            }
            eventType = xmlPullParser.next();
            i2 = 21;
        }
        C0033b c0033b2 = this.f739c;
        if (c0033b2.f742c == null) {
            c0033b2.f742c = new AnimatorSet();
        }
        c0033b2.f742c.playTogether(c0033b2.d);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f744b;
        return drawable != null ? b.h.b.a.F(drawable) : this.f739c.f741b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f744b;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f739c.f742c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.isStateful() : this.f739c.f741b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f739c.f741b.setBounds(rect);
        }
    }

    @Override // b.r.a.a.f, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.setLevel(i) : this.f739c.f741b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f744b;
        return drawable != null ? drawable.setState(iArr) : this.f739c.f741b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f739c.f741b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.Q(drawable, z);
            return;
        }
        g gVar = this.f739c.f741b;
        Drawable drawable2 = gVar.f744b;
        if (drawable2 != null) {
            b.h.b.a.Q(drawable2, z);
        } else {
            gVar.f745c.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        g gVar = this.f739c.f741b;
        Drawable drawable2 = gVar.f744b;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        gVar.e = colorFilter;
        gVar.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTint(int i) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.f0(drawable, i);
        } else {
            this.f739c.f741b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.g0(drawable, colorStateList);
        } else {
            this.f739c.f741b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, b.h.d.l.a
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            b.h.b.a.h0(drawable, mode);
        } else {
            this.f739c.f741b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f739c.f741b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f739c.f742c.isStarted()) {
        } else {
            this.f739c.f742c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f744b;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f739c.f742c.end();
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            b bVar = new b(null, null, null);
            Drawable newDrawable = this.a.newDrawable();
            bVar.f744b = newDrawable;
            newDrawable.setCallback(bVar.f);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            b bVar = new b(null, null, null);
            Drawable newDrawable = this.a.newDrawable(resources);
            bVar.f744b = newDrawable;
            newDrawable.setCallback(bVar.f);
            return bVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            b bVar = new b(null, null, null);
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            bVar.f744b = newDrawable;
            newDrawable.setCallback(bVar.f);
            return bVar;
        }
    }
}
