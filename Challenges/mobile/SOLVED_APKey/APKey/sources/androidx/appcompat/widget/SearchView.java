package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import b.b.h.a0;
import b.b.h.j0;
import b.b.h.o0;
import b.b.h.u0;
import b.h.j.q;
import com.example.apkey.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SearchView extends a0 implements b.b.g.a {
    public static final n r0;
    public Rect A;
    public Rect B;
    public int[] C;
    public int[] D;
    public final ImageView E;
    public final Drawable F;
    public final int G;
    public final int H;
    public final Intent I;
    public final Intent J;
    public final CharSequence K;
    public l L;
    public k M;
    public View.OnFocusChangeListener N;
    public m O;
    public View.OnClickListener P;
    public boolean Q;
    public boolean R;
    public b.i.a.a S;
    public boolean T;
    public CharSequence U;
    public boolean V;
    public boolean W;
    public int a0;
    public boolean b0;
    public CharSequence c0;
    public CharSequence d0;
    public boolean e0;
    public int f0;
    public SearchableInfo g0;
    public Bundle h0;
    public final Runnable i0;
    public Runnable j0;
    public final WeakHashMap<String, Drawable.ConstantState> k0;
    public final View.OnClickListener l0;
    public View.OnKeyListener m0;
    public final TextView.OnEditorActionListener n0;
    public final AdapterView.OnItemClickListener o0;
    public final AdapterView.OnItemSelectedListener p0;
    public final SearchAutoComplete q;
    public TextWatcher q0;
    public final View r;
    public final View s;
    public final View t;
    public final ImageView u;
    public final ImageView v;
    public final ImageView w;
    public final ImageView x;
    public final View y;
    public p z;

    /* loaded from: classes.dex */
    public static class SearchAutoComplete extends b.b.h.d {
        public int e;
        public SearchView f;
        public boolean g;
        public final Runnable h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.g) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.g = false;
                }
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, R.attr.autoCompleteTextViewStyle);
            this.h = new a();
            this.e = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i < 960 || i2 < 720 || configuration.orientation != 2) {
                if (i >= 600) {
                    return 192;
                }
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 256;
        }

        public void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (!enoughToFilter()) {
                    return;
                }
                showDropDown();
                return;
            }
            n nVar = SearchView.r0;
            nVar.getClass();
            n.a();
            Method method = nVar.f39c;
            if (method == null) {
                return;
            }
            try {
                method.invoke(this, Boolean.TRUE);
            } catch (Exception unused) {
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        @Override // b.b.h.d, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.g) {
                removeCallbacks(this.h);
                post(this.h);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.f;
            searchView.F(searchView.R);
            searchView.post(searchView.i0);
            if (searchView.q.hasFocus()) {
                searchView.r();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (!z || !this.f.hasFocus() || getVisibility() != 0) {
                return;
            }
            boolean z2 = true;
            this.g = true;
            Context context = getContext();
            n nVar = SearchView.r0;
            if (context.getResources().getConfiguration().orientation != 2) {
                z2 = false;
            }
            if (!z2) {
                return;
            }
            a();
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.g = false;
                removeCallbacks(this.h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (!inputMethodManager.isActive(this)) {
                this.g = true;
            } else {
                this.g = false;
                removeCallbacks(this.h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.e = i;
        }
    }

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView searchView = SearchView.this;
            Editable text = searchView.q.getText();
            searchView.d0 = text;
            boolean z = !TextUtils.isEmpty(text);
            searchView.E(z);
            searchView.G(!z);
            searchView.A();
            searchView.D();
            if (searchView.L != null && !TextUtils.equals(charSequence, searchView.c0)) {
                searchView.L.b(charSequence.toString());
            }
            searchView.c0 = charSequence.toString();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.B();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.i.a.a aVar = SearchView.this.S;
            if (aVar instanceof j0) {
                aVar.b(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.N;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SearchView searchView = SearchView.this;
            if (searchView.y.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.s.getPaddingLeft();
                Rect rect = new Rect();
                boolean b2 = u0.b(searchView);
                int dimensionPixelSize = searchView.Q ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) : 0;
                searchView.q.getDropDownBackground().getPadding(rect);
                searchView.q.setDropDownHorizontalOffset(b2 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
                searchView.q.setDropDownWidth((((searchView.y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.u) {
                searchView.x();
            } else if (view == searchView.w) {
                searchView.t();
            } else if (view == searchView.v) {
                searchView.y();
            } else if (view == searchView.x) {
                SearchableInfo searchableInfo = searchView.g0;
                if (searchableInfo == null) {
                    return;
                }
                try {
                    if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        if (!searchableInfo.getVoiceSearchLaunchRecognizer()) {
                            return;
                        }
                        searchView.getContext().startActivity(searchView.q(searchView.J, searchableInfo));
                        return;
                    }
                    Intent intent = new Intent(searchView.I);
                    ComponentName searchActivity = searchableInfo.getSearchActivity();
                    intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                    searchView.getContext().startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Log.w("SearchView", "Could not find voice search activity");
                }
            } else if (view != searchView.q) {
            } else {
                searchView.r();
            }
        }
    }

    /* loaded from: classes.dex */
    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.g0 == null) {
                return false;
            }
            if (searchView.q.isPopupShowing() && SearchView.this.q.getListSelection() != -1) {
                return SearchView.this.z(i, keyEvent);
            }
            if ((TextUtils.getTrimmedLength(SearchView.this.q.getText()) == 0) || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.s(0, null, searchView2.q.getText().toString());
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.y();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.u(i);
        }
    }

    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.v(i);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        boolean a();
    }

    /* loaded from: classes.dex */
    public interface l {
        boolean a(String str);

        boolean b(String str);
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(int i);

        boolean b(int i);
    }

    /* loaded from: classes.dex */
    public static class n {
        public Method a;

        /* renamed from: b  reason: collision with root package name */
        public Method f38b;

        /* renamed from: c  reason: collision with root package name */
        public Method f39c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public n() {
            this.a = null;
            this.f38b = null;
            this.f39c = null;
            a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f38b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f39c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void a() {
            if (Build.VERSION.SDK_INT < 29) {
                return;
            }
            throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
        }
    }

    /* loaded from: classes.dex */
    public static class o extends b.j.a.a {
        public static final Parcelable.Creator<o> CREATOR = new a();
        public boolean d;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<o> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new o[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.d = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("SearchView.SavedState{");
            g.append(Integer.toHexString(System.identityHashCode(this)));
            g.append(" isIconified=");
            g.append(this.d);
            g.append("}");
            return g.toString();
        }

        @Override // b.j.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f510b, i);
            parcel.writeValue(Boolean.valueOf(this.d));
        }
    }

    /* loaded from: classes.dex */
    public static class p extends TouchDelegate {
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public final Rect f40b;

        /* renamed from: c  reason: collision with root package name */
        public final Rect f41c;
        public final Rect d;
        public final int e;
        public boolean f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f40b = new Rect();
            this.d = new Rect();
            this.f41c = new Rect();
            a(rect, rect2);
            this.a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f40b.set(rect);
            this.d.set(rect);
            Rect rect3 = this.d;
            int i = this.e;
            rect3.inset(-i, -i);
            this.f41c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float f;
            int i;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f;
                    if (z2 && !this.d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f;
                        this.f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else {
                if (this.f40b.contains(x, y)) {
                    this.f = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (z3) {
                if (!z || this.f41c.contains(x, y)) {
                    Rect rect = this.f41c;
                    f = x - rect.left;
                    i = y - rect.top;
                } else {
                    f = this.a.getWidth() / 2;
                    i = this.a.getHeight() / 2;
                }
                motionEvent.setLocation(f, i);
                return this.a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    static {
        r0 = Build.VERSION.SDK_INT < 29 ? new n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.A = new Rect();
        this.B = new Rect();
        this.C = new int[2];
        this.D = new int[2];
        this.i0 = new b();
        this.j0 = new c();
        this.k0 = new WeakHashMap<>();
        f fVar = new f();
        this.l0 = fVar;
        this.m0 = new g();
        h hVar = new h();
        this.n0 = hVar;
        i iVar = new i();
        this.o0 = iVar;
        j jVar = new j();
        this.p0 = jVar;
        this.q0 = new a();
        o0 o0Var = new o0(context, context.obtainStyledAttributes(attributeSet, b.b.b.t, i2, 0));
        LayoutInflater.from(context).inflate(o0Var.k(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.r = findViewById(R.id.search_edit_frame);
        View findViewById = findViewById(R.id.search_plate);
        this.s = findViewById;
        View findViewById2 = findViewById(R.id.submit_area);
        this.t = findViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.u = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.E = imageView5;
        Drawable g2 = o0Var.g(10);
        AtomicInteger atomicInteger = q.a;
        findViewById.setBackground(g2);
        findViewById2.setBackground(o0Var.g(14));
        imageView.setImageDrawable(o0Var.g(13));
        imageView2.setImageDrawable(o0Var.g(7));
        imageView3.setImageDrawable(o0Var.g(4));
        imageView4.setImageDrawable(o0Var.g(16));
        imageView5.setImageDrawable(o0Var.g(13));
        this.F = o0Var.g(12);
        b.b.a.e(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.G = o0Var.k(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.H = o0Var.k(5, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.q0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.m0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(o0Var.a(8, true));
        int f2 = o0Var.f(1, -1);
        if (f2 != -1) {
            setMaxWidth(f2);
        }
        this.K = o0Var.m(6);
        this.U = o0Var.m(11);
        int i3 = o0Var.i(3, -1);
        if (i3 != -1) {
            setImeOptions(i3);
        }
        int i4 = o0Var.i(2, -1);
        if (i4 != -1) {
            setInputType(i4);
        }
        setFocusable(o0Var.a(0, true));
        o0Var.f252b.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.J = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.y = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new e());
        }
        F(this.Q);
        C();
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        this.q.setText(charSequence);
        this.q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final void A() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        int i2 = 0;
        if (!z2 && (!this.Q || this.e0)) {
            z = false;
        }
        ImageView imageView = this.w;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.w.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public void B() {
        int[] iArr = this.q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void C() {
        SpannableStringBuilder queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.q;
        if (queryHint == null) {
            queryHint = "";
        }
        if (this.Q && this.F != null) {
            double textSize = searchAutoComplete.getTextSize();
            Double.isNaN(textSize);
            Double.isNaN(textSize);
            int i2 = (int) (textSize * 1.25d);
            this.F.setBounds(0, 0, i2, i2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(this.F), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void D() {
        int i2 = 0;
        if (!((this.T || this.b0) && !this.R) || (this.v.getVisibility() != 0 && this.x.getVisibility() != 0)) {
            i2 = 8;
        }
        this.t.setVisibility(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r2.b0 == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.T
            r1 = 0
            if (r0 == 0) goto L21
            if (r0 != 0) goto Lb
            boolean r0 = r2.b0
            if (r0 == 0) goto L11
        Lb:
            boolean r0 = r2.R
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L21
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L21
            if (r3 != 0) goto L23
            boolean r3 = r2.b0
            if (r3 != 0) goto L21
            goto L23
        L21:
            r1 = 8
        L23:
            android.widget.ImageView r3 = r2.v
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.E(boolean):void");
    }

    public final void F(boolean z) {
        this.R = z;
        int i2 = 0;
        int i3 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.q.getText());
        this.u.setVisibility(i3);
        E(z2);
        this.r.setVisibility(z ? 8 : 0);
        if (this.E.getDrawable() == null || this.Q) {
            i2 = 8;
        }
        this.E.setVisibility(i2);
        A();
        G(!z2);
        D();
    }

    public final void G(boolean z) {
        int i2 = 8;
        if (this.b0 && !this.R && z) {
            this.v.setVisibility(8);
            i2 = 0;
        }
        this.x.setVisibility(i2);
    }

    @Override // b.b.g.a
    public void a() {
        if (this.e0) {
            return;
        }
        this.e0 = true;
        int imeOptions = this.q.getImeOptions();
        this.f0 = imeOptions;
        this.q.setImeOptions(imeOptions | 33554432);
        this.q.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.W = true;
        super.clearFocus();
        this.q.clearFocus();
        this.q.setImeVisibility(false);
        this.W = false;
    }

    @Override // b.b.g.a
    public void d() {
        this.q.setText("");
        SearchAutoComplete searchAutoComplete = this.q;
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.d0 = "";
        clearFocus();
        F(true);
        this.q.setImeOptions(this.f0);
        this.e0 = false;
    }

    public int getImeOptions() {
        return this.q.getImeOptions();
    }

    public int getInputType() {
        return this.q.getInputType();
    }

    public int getMaxWidth() {
        return this.a0;
    }

    public CharSequence getQuery() {
        return this.q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.g0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.K : getContext().getText(this.g0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.H;
    }

    public int getSuggestionRowLayout() {
        return this.G;
    }

    public b.i.a.a getSuggestionsAdapter() {
        return this.S;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.i0);
        post(this.j0);
        super.onDetachedFromWindow();
    }

    @Override // b.b.h.a0, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.q;
            Rect rect = this.A;
            searchAutoComplete.getLocationInWindow(this.C);
            getLocationInWindow(this.D);
            int[] iArr = this.C;
            int i6 = iArr[1];
            int[] iArr2 = this.D;
            int i7 = i6 - iArr2[1];
            int i8 = iArr[0] - iArr2[0];
            rect.set(i8, i7, searchAutoComplete.getWidth() + i8, searchAutoComplete.getHeight() + i7);
            Rect rect2 = this.B;
            Rect rect3 = this.A;
            rect2.set(rect3.left, 0, rect3.right, i5 - i3);
            p pVar = this.z;
            if (pVar != null) {
                pVar.a(this.B, this.A);
                return;
            }
            p pVar2 = new p(this.B, this.A, this.q);
            this.z = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r0 <= 0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    @Override // b.b.h.a0, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            boolean r0 = r3.R
            if (r0 == 0) goto L8
            super.onMeasure(r4, r5)
            return
        L8:
            int r0 = android.view.View.MeasureSpec.getMode(r4)
            int r4 = android.view.View.MeasureSpec.getSize(r4)
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 == r1) goto L2a
            if (r0 == 0) goto L20
            if (r0 == r2) goto L1b
            goto L37
        L1b:
            int r0 = r3.a0
            if (r0 <= 0) goto L37
            goto L2e
        L20:
            int r4 = r3.a0
            if (r4 <= 0) goto L25
            goto L37
        L25:
            int r4 = r3.getPreferredWidth()
            goto L37
        L2a:
            int r0 = r3.a0
            if (r0 <= 0) goto L2f
        L2e:
            goto L33
        L2f:
            int r0 = r3.getPreferredWidth()
        L33:
            int r4 = java.lang.Math.min(r0, r4)
        L37:
            int r0 = android.view.View.MeasureSpec.getMode(r5)
            int r5 = android.view.View.MeasureSpec.getSize(r5)
            if (r0 == r1) goto L49
            if (r0 == 0) goto L44
            goto L51
        L44:
            int r5 = r3.getPreferredHeight()
            goto L51
        L49:
            int r0 = r3.getPreferredHeight()
            int r5 = java.lang.Math.min(r0, r5)
        L51:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r2)
            super.onMeasure(r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.f510b);
        F(oVar.d);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.d = this.R;
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.i0);
    }

    public final Intent p(String str, Uri uri, String str2, String str3, int i2, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.d0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.h0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i2 != 0) {
            intent.putExtra("action_key", i2);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.g0.getSearchActivity());
        return intent;
    }

    public final Intent q(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.h0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        int i2 = 1;
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String str = null;
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        if (searchableInfo.getVoiceMaxResults() != 0) {
            i2 = searchableInfo.getVoiceMaxResults();
        }
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", i2);
        if (searchActivity != null) {
            str = searchActivity.flattenToShortString();
        }
        intent3.putExtra("calling_package", str);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.q.refreshAutoCompleteResults();
            return;
        }
        n nVar = r0;
        SearchAutoComplete searchAutoComplete = this.q;
        nVar.getClass();
        n.a();
        Method method = nVar.a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        n nVar2 = r0;
        SearchAutoComplete searchAutoComplete2 = this.q;
        nVar2.getClass();
        n.a();
        Method method2 = nVar2.f38b;
        if (method2 == null) {
            return;
        }
        try {
            method2.invoke(searchAutoComplete2, new Object[0]);
        } catch (Exception unused2) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i2, Rect rect) {
        if (!this.W && isFocusable()) {
            if (this.R) {
                return super.requestFocus(i2, rect);
            }
            boolean requestFocus = this.q.requestFocus(i2, rect);
            if (requestFocus) {
                F(false);
            }
            return requestFocus;
        }
        return false;
    }

    public void s(int i2, String str, String str2) {
        getContext().startActivity(p("android.intent.action.SEARCH", null, null, str2, i2, null));
    }

    public void setAppSearchData(Bundle bundle) {
        this.h0 = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            t();
        } else {
            x();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.Q == z) {
            return;
        }
        this.Q = z;
        F(z);
        C();
    }

    public void setImeOptions(int i2) {
        this.q.setImeOptions(i2);
    }

    public void setInputType(int i2) {
        this.q.setInputType(i2);
    }

    public void setMaxWidth(int i2) {
        this.a0 = i2;
        requestLayout();
    }

    public void setOnCloseListener(k kVar) {
        this.M = kVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.N = onFocusChangeListener;
    }

    public void setOnQueryTextListener(l lVar) {
        this.L = lVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setOnSuggestionListener(m mVar) {
        this.O = mVar;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.U = charSequence;
        C();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.V = z;
        b.i.a.a aVar = this.S;
        if (aVar instanceof j0) {
            ((j0) aVar).r = z ? 2 : 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (getContext().getPackageManager().resolveActivity(r2, 65536) != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.g0 = r7
            r0 = 1
            r1 = 65536(0x10000, float:9.18355E-41)
            r2 = 0
            if (r7 == 0) goto L6e
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.q
            int r7 = r7.getSuggestThreshold()
            r3.setThreshold(r7)
            androidx.appcompat.widget.SearchView$SearchAutoComplete r7 = r6.q
            android.app.SearchableInfo r3 = r6.g0
            int r3 = r3.getImeOptions()
            r7.setImeOptions(r3)
            android.app.SearchableInfo r7 = r6.g0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r0) goto L36
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.g0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L36
            r7 = r7 | r1
            r3 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 | r3
        L36:
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.q
            r3.setInputType(r7)
            b.i.a.a r7 = r6.S
            if (r7 == 0) goto L42
            r7.b(r2)
        L42:
            android.app.SearchableInfo r7 = r6.g0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L6b
            b.b.h.j0 r7 = new b.b.h.j0
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.g0
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r5 = r6.k0
            r7.<init>(r3, r6, r4, r5)
            r6.S = r7
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.q
            r3.setAdapter(r7)
            b.i.a.a r7 = r6.S
            b.b.h.j0 r7 = (b.b.h.j0) r7
            boolean r3 = r6.V
            if (r3 == 0) goto L68
            r3 = 2
            goto L69
        L68:
            r3 = 1
        L69:
            r7.r = r3
        L6b:
            r6.C()
        L6e:
            android.app.SearchableInfo r7 = r6.g0
            r3 = 0
            if (r7 == 0) goto L9f
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L9f
            android.app.SearchableInfo r7 = r6.g0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L84
            android.content.Intent r2 = r6.I
            goto L8e
        L84:
            android.app.SearchableInfo r7 = r6.g0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L8e
            android.content.Intent r2 = r6.J
        L8e:
            if (r2 == 0) goto L9f
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r2, r1)
            if (r7 == 0) goto L9f
            goto La0
        L9f:
            r0 = 0
        La0:
            r6.b0 = r0
            if (r0 == 0) goto Lab
            androidx.appcompat.widget.SearchView$SearchAutoComplete r7 = r6.q
            java.lang.String r0 = "nm"
            r7.setPrivateImeOptions(r0)
        Lab:
            boolean r7 = r6.R
            r6.F(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.T = z;
        F(this.R);
    }

    public void setSuggestionsAdapter(b.i.a.a aVar) {
        this.S = aVar;
        this.q.setAdapter(aVar);
    }

    public void t() {
        if (!TextUtils.isEmpty(this.q.getText())) {
            this.q.setText("");
            this.q.requestFocus();
            this.q.setImeVisibility(true);
        } else if (!this.Q) {
        } else {
            k kVar = this.M;
            if (kVar != null && kVar.a()) {
                return;
            }
            clearFocus();
            F(true);
        }
    }

    public boolean u(int i2) {
        int i3;
        String h2;
        m mVar = this.O;
        if (mVar == null || !mVar.b(i2)) {
            Cursor cursor = this.S.d;
            if (cursor != null && cursor.moveToPosition(i2)) {
                Intent intent = null;
                try {
                    int i4 = j0.z;
                    String h3 = j0.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                    if (h3 == null) {
                        h3 = this.g0.getSuggestIntentAction();
                    }
                    if (h3 == null) {
                        h3 = "android.intent.action.SEARCH";
                    }
                    String str = h3;
                    String h4 = j0.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                    if (h4 == null) {
                        h4 = this.g0.getSuggestIntentData();
                    }
                    if (h4 != null && (h2 = j0.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                        h4 = h4 + "/" + Uri.encode(h2);
                    }
                    intent = p(str, h4 == null ? null : Uri.parse(h4), j0.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), j0.h(cursor, cursor.getColumnIndex("suggest_intent_query")), 0, null);
                } catch (RuntimeException e2) {
                    try {
                        i3 = cursor.getPosition();
                    } catch (RuntimeException unused) {
                        i3 = -1;
                    }
                    Log.w("SearchView", "Search suggestions cursor at row " + i3 + " returned exception.", e2);
                }
                if (intent != null) {
                    try {
                        getContext().startActivity(intent);
                    } catch (RuntimeException e3) {
                        Log.e("SearchView", "Failed launch activity: " + intent, e3);
                    }
                }
            }
            this.q.setImeVisibility(false);
            this.q.dismissDropDown();
            return true;
        }
        return false;
    }

    public boolean v(int i2) {
        CharSequence c2;
        m mVar = this.O;
        if (mVar == null || !mVar.a(i2)) {
            Editable text = this.q.getText();
            Cursor cursor = this.S.d;
            if (cursor == null) {
                return true;
            }
            if (!cursor.moveToPosition(i2) || (c2 = this.S.c(cursor)) == null) {
                setQuery(text);
                return true;
            }
            setQuery(c2);
            return true;
        }
        return false;
    }

    public void w(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void x() {
        F(false);
        this.q.requestFocus();
        this.q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void y() {
        Editable text = this.q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        l lVar = this.L;
        if (lVar != null && lVar.a(text.toString())) {
            return;
        }
        if (this.g0 != null) {
            s(0, null, text.toString());
        }
        this.q.setImeVisibility(false);
        this.q.dismissDropDown();
    }

    public boolean z(int i2, KeyEvent keyEvent) {
        if (this.g0 != null && this.S != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i2 == 66 || i2 == 84 || i2 == 61) {
                return u(this.q.getListSelection());
            }
            if (i2 == 21 || i2 == 22) {
                this.q.setSelection(i2 == 21 ? 0 : this.q.length());
                this.q.setListSelection(0);
                this.q.clearListSelection();
                this.q.a();
                return true;
            } else if (i2 != 19 || this.q.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }
}
