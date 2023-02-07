package b.h.j;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class g {
    public ViewParent a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f484b;

    /* renamed from: c  reason: collision with root package name */
    public final View f485c;
    public boolean d;
    public int[] e;

    public g(View view) {
        this.f485c = view;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent g;
        if (!this.d || (g = g(0)) == null) {
            return false;
        }
        View view = this.f485c;
        if (Build.VERSION.SDK_INT < 21) {
            if (!(g instanceof j)) {
                return false;
            }
            return ((j) g).onNestedFling(view, f, f2, z);
        }
        try {
            return g.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + g + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public boolean b(float f, float f2) {
        ViewParent g;
        if (!this.d || (g = g(0)) == null) {
            return false;
        }
        View view = this.f485c;
        if (Build.VERSION.SDK_INT < 21) {
            if (!(g instanceof j)) {
                return false;
            }
            return ((j) g).onNestedPreFling(view, f, f2);
        }
        try {
            return g.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + g + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent g;
        int i4;
        int i5;
        int[] iArr3;
        if (!this.d || (g = g(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f485c.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.e == null) {
                    this.e = new int[2];
                }
                iArr3 = this.e;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            View view = this.f485c;
            if (g instanceof h) {
                ((h) g).f(view, i, i2, iArr3, i3);
            } else if (i3 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        g.onNestedPreScroll(view, i, i2, iArr3);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + g + " does not implement interface method onNestedPreScroll", e);
                    }
                } else if (g instanceof j) {
                    ((j) g).onNestedPreScroll(view, i, i2, iArr3);
                }
            }
            if (iArr2 != null) {
                this.f485c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            if (iArr3[0] != 0 || iArr3[1] != 0) {
                return true;
            }
        } else if (iArr2 != null) {
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return false;
    }

    public void d(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        f(i, i2, i3, i4, null, i5, iArr2);
    }

    public boolean e(int i, int i2, int i3, int i4, int[] iArr) {
        return f(i, i2, i3, i4, iArr, 0, null);
    }

    public final boolean f(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent g;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.d || (g = g(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f485c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            int[] iArr4 = this.e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view = this.f485c;
        if (g instanceof i) {
            ((i) g).c(view, i, i2, i3, i4, i5, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i3;
            iArr3[1] = iArr3[1] + i4;
            if (g instanceof h) {
                ((h) g).d(view, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        g.onNestedScroll(view, i, i2, i3, i4);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + g + " does not implement interface method onNestedScroll", e);
                    }
                } else if (g instanceof j) {
                    ((j) g).onNestedScroll(view, i, i2, i3, i4);
                }
            }
        }
        if (iArr != null) {
            this.f485c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public final ViewParent g(int i) {
        if (i != 0) {
            if (i == 1) {
                return this.f484b;
            }
            return null;
        }
        return this.a;
    }

    public boolean h(int i) {
        return g(i) != null;
    }

    public void i(boolean z) {
        if (this.d) {
            View view = this.f485c;
            AtomicInteger atomicInteger = q.a;
            if (Build.VERSION.SDK_INT >= 21) {
                view.stopNestedScroll();
            } else if (view instanceof f) {
                ((f) view).stopNestedScroll();
            }
        }
        this.d = z;
    }

    public boolean j(int i, int i2) {
        boolean z;
        if (g(i2) != null) {
            return true;
        }
        if (this.d) {
            View view = this.f485c;
            for (ViewParent parent = this.f485c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f485c;
                boolean z2 = parent instanceof h;
                if (z2) {
                    z = ((h) parent).g(view, view2, i, i2);
                } else {
                    if (i2 == 0) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            try {
                                z = parent.onStartNestedScroll(view, view2, i);
                            } catch (AbstractMethodError e) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                            }
                        } else if (parent instanceof j) {
                            z = ((j) parent).onStartNestedScroll(view, view2, i);
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i2 == 0) {
                        this.a = parent;
                    } else if (i2 == 1) {
                        this.f484b = parent;
                    }
                    View view3 = this.f485c;
                    if (z2) {
                        ((h) parent).a(view, view3, i, i2);
                    } else if (i2 == 0) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            try {
                                parent.onNestedScrollAccepted(view, view3, i);
                            } catch (AbstractMethodError e2) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                            }
                        } else if (parent instanceof j) {
                            ((j) parent).onNestedScrollAccepted(view, view3, i);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = parent;
                }
            }
        }
        return false;
    }

    public void k(int i) {
        ViewParent g = g(i);
        if (g != null) {
            View view = this.f485c;
            if (g instanceof h) {
                ((h) g).e(view, i);
            } else if (i == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        g.onStopNestedScroll(view);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + g + " does not implement interface method onStopNestedScroll", e);
                    }
                } else if (g instanceof j) {
                    ((j) g).onStopNestedScroll(view);
                }
            }
            if (i == 0) {
                this.a = null;
            } else if (i != 1) {
            } else {
                this.f484b = null;
            }
        }
    }
}
