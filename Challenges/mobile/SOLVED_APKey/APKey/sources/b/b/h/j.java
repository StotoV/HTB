package b.b.h;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import b.h.j.c;
import com.example.apkey.R;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class j extends EditText implements b.h.j.p, b.h.j.n {

    /* renamed from: b  reason: collision with root package name */
    public final e f234b;

    /* renamed from: c  reason: collision with root package name */
    public final q f235c;
    public final p d;
    public final b.h.k.e e;

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public j(Context context, AttributeSet attributeSet, int i) {
        super(l0.a(context), attributeSet, i);
        k0.a(this, getContext());
        e eVar = new e(this);
        this.f234b = eVar;
        eVar.d(attributeSet, i);
        q qVar = new q(this);
        this.f235c = qVar;
        qVar.e(attributeSet, i);
        qVar.b();
        this.d = new p(this);
        this.e = new b.h.k.e();
    }

    @Override // b.h.j.n
    public b.h.j.c a(b.h.j.c cVar) {
        return this.e.a(this, cVar);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f234b;
        if (eVar != null) {
            eVar.a();
        }
        q qVar = this.f235c;
        if (qVar != null) {
            qVar.b();
        }
    }

    @Override // b.h.j.p
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f234b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    @Override // b.h.j.p
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f234b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.EditText, android.widget.TextView
    /* renamed from: getText */
    public Editable mo4getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        p pVar;
        return (Build.VERSION.SDK_INT >= 28 || (pVar = this.d) == null) ? super.getTextClassifier() : pVar.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r8 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r8 != null) goto L19;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo r8) {
        /*
            r7 = this;
            android.view.inputmethod.InputConnection r0 = super.onCreateInputConnection(r8)
            b.b.h.q r1 = r7.f235c
            r1.g(r7, r0, r8)
            b.b.a.d(r0, r8, r7)
            java.util.concurrent.atomic.AtomicInteger r1 = b.h.j.q.a
            r1 = 2131231085(0x7f08016d, float:1.8078241E38)
            java.lang.Object r1 = r7.getTag(r1)
            java.lang.String[] r1 = (java.lang.String[]) r1
            if (r0 == 0) goto L7f
            if (r1 == 0) goto L7f
            int r2 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            java.lang.String r4 = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES"
            r5 = 25
            if (r2 < r5) goto L28
            r8.contentMimeTypes = r1
            goto L3d
        L28:
            android.os.Bundle r6 = r8.extras
            if (r6 != 0) goto L33
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            r8.extras = r6
        L33:
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r4, r1)
            android.os.Bundle r6 = r8.extras
            r6.putStringArray(r3, r1)
        L3d:
            b.b.h.o r1 = new b.b.h.o
            r1.<init>(r7)
            if (r8 == 0) goto L77
            r6 = 0
            if (r2 < r5) goto L4e
            b.h.j.d0.b r8 = new b.h.j.d0.b
            r8.<init>(r0, r6, r1)
        L4c:
            r0 = r8
            goto L7f
        L4e:
            if (r2 < r5) goto L55
            java.lang.String[] r8 = r8.contentMimeTypes
            if (r8 == 0) goto L6b
            goto L6d
        L55:
            android.os.Bundle r2 = r8.extras
            if (r2 != 0) goto L5a
            goto L6b
        L5a:
            java.lang.String[] r2 = r2.getStringArray(r4)
            if (r2 != 0) goto L67
            android.os.Bundle r8 = r8.extras
            java.lang.String[] r8 = r8.getStringArray(r3)
            goto L68
        L67:
            r8 = r2
        L68:
            if (r8 == 0) goto L6b
            goto L6d
        L6b:
            java.lang.String[] r8 = b.h.j.d0.a.a
        L6d:
            int r8 = r8.length
            if (r8 != 0) goto L71
            goto L7f
        L71:
            b.h.j.d0.c r8 = new b.h.j.d0.c
            r8.<init>(r0, r6, r1)
            goto L4c
        L77:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "editorInfo must be non-null"
            r8.<init>(r0)
            throw r8
        L7f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.h.j.onCreateInputConnection(android.view.inputmethod.EditorInfo):android.view.inputmethod.InputConnection");
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null) {
            AtomicInteger atomicInteger = b.h.j.q.a;
            if (((String[]) getTag(R.id.tag_on_receive_content_mime_types)) != null) {
                Context context = getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                        break;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity == null) {
                    Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
                } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                    activity.requestDragAndDropPermissions(dragEvent);
                    int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                    beginBatchEdit();
                    try {
                        Selection.setSelection((Spannable) getText(), offsetForPosition);
                        b.h.j.q.z(this, new b.h.j.c(new c.a(dragEvent.getClipData(), 3)));
                        endBatchEdit();
                        z = true;
                    } catch (Throwable th) {
                        endBatchEdit();
                        throw th;
                    }
                }
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        int i2 = 0;
        if (i == 16908322 || i == 16908337) {
            AtomicInteger atomicInteger = b.h.j.q.a;
            if (((String[]) getTag(R.id.tag_on_receive_content_mime_types)) != null) {
                ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
                ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
                if (primaryClip != null && primaryClip.getItemCount() > 0) {
                    c.a aVar = new c.a(primaryClip, 1);
                    if (i != 16908322) {
                        i2 = 1;
                    }
                    aVar.f473c = i2;
                    b.h.j.q.z(this, new b.h.j.c(aVar));
                }
                i2 = 1;
            }
        }
        if (i2 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f234b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f234b;
        if (eVar != null) {
            eVar.f(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(b.h.b.a.m0(this, callback));
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f234b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    @Override // b.h.j.p
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f234b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        q qVar = this.f235c;
        if (qVar != null) {
            qVar.f(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        p pVar;
        if (Build.VERSION.SDK_INT < 28 && (pVar = this.d) != null) {
            pVar.f254b = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }
}
