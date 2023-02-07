package b.b;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import b.b.h.r0;
import b.b.h.v0;
import b.f.b.h.c;
import b.f.b.h.d;
import b.f.b.h.f;
import b.f.b.h.h;
import b.f.b.h.l.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    /* JADX WARN: Code restructure failed: missing block: B:180:0x02d1, code lost:
        if (r3[r17].f.d == r9) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0149, code lost:
        if (r4[r2].f.d == r5) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x048d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x04f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x05f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0603  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:374:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x0678  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0708 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:404:0x071d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:409:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x073d  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0743  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x075b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0778 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x05e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(b.f.b.h.e r37, b.f.b.d r38, java.util.ArrayList<b.f.b.h.d> r39, int r40) {
        /*
            Method dump skipped, instructions count: 1926
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.a(b.f.b.h.e, b.f.b.d, java.util.ArrayList, int):void");
    }

    public static n b(d dVar, int i, ArrayList<n> arrayList, n nVar) {
        c cVar;
        int i2;
        int i3 = i == 0 ? dVar.j0 : dVar.k0;
        int i4 = 0;
        if (i3 != -1 && (nVar == null || i3 != nVar.f357b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                n nVar2 = arrayList.get(i5);
                if (nVar2.f357b == i3) {
                    if (nVar != null) {
                        nVar.d(i, nVar2);
                        arrayList.remove(nVar);
                    }
                    nVar = nVar2;
                } else {
                    i5++;
                }
            }
        } else if (i3 != -1) {
            return nVar;
        }
        if (nVar == null) {
            if (dVar instanceof h) {
                h hVar = (h) dVar;
                int i6 = 0;
                while (true) {
                    if (i6 >= hVar.m0) {
                        i2 = -1;
                        break;
                    }
                    d dVar2 = hVar.l0[i6];
                    if ((i == 0 && (i2 = dVar2.j0) != -1) || (i == 1 && (i2 = dVar2.k0) != -1)) {
                        break;
                    }
                    i6++;
                }
                if (i2 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        n nVar3 = arrayList.get(i7);
                        if (nVar3.f357b == i2) {
                            nVar = nVar3;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (nVar == null) {
                nVar = new n(i);
            }
            arrayList.add(nVar);
        }
        if (nVar.a(dVar)) {
            if (dVar instanceof f) {
                f fVar = (f) dVar;
                c cVar2 = fVar.o0;
                if (fVar.p0 == 0) {
                    i4 = 1;
                }
                cVar2.b(i4, arrayList, nVar);
            }
            if (i == 0) {
                dVar.j0 = nVar.f357b;
                dVar.D.b(i, arrayList, nVar);
                cVar = dVar.F;
            } else {
                dVar.k0 = nVar.f357b;
                dVar.E.b(i, arrayList, nVar);
                dVar.H.b(i, arrayList, nVar);
                cVar = dVar.G;
            }
            cVar.b(i, arrayList, nVar);
            dVar.K.b(i, arrayList, nVar);
        }
        return nVar;
    }

    public static n c(ArrayList<n> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            n nVar = arrayList.get(i2);
            if (i == nVar.f357b) {
                return nVar;
            }
        }
        return null;
    }

    public static InputConnection d(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof v0) {
                    editorInfo.hintText = ((v0) parent).a();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return inputConnection;
    }

    public static void e(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        r0 r0Var = r0.k;
        if (r0Var != null && r0Var.f265b == view) {
            r0.c(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new r0(view, charSequence);
            return;
        }
        r0 r0Var2 = r0.l;
        if (r0Var2 != null && r0Var2.f265b == view) {
            r0Var2.b();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static boolean f(d.a aVar, d.a aVar2, d.a aVar3, d.a aVar4) {
        d.a aVar5 = d.a.MATCH_PARENT;
        d.a aVar6 = d.a.WRAP_CONTENT;
        d.a aVar7 = d.a.FIXED;
        return (aVar3 == aVar7 || aVar3 == aVar6 || (aVar3 == aVar5 && aVar != aVar6)) || (aVar4 == aVar7 || aVar4 == aVar6 || (aVar4 == aVar5 && aVar2 != aVar6));
    }
}
