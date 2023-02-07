package b.h.k;

import android.content.ClipData;
import android.content.Context;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import b.h.j.m;
/* loaded from: classes.dex */
public final class e implements m {
    public static CharSequence b(Context context, ClipData.Item item, int i) {
        if ((i & 1) != 0) {
            CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
        }
        return item.coerceToStyledText(context);
    }

    public static void c(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Override // b.h.j.m
    public b.h.j.c a(View view, b.h.j.c cVar) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + cVar);
        }
        int i = cVar.f470b;
        if (i == 2) {
            return cVar;
        }
        int i2 = 0;
        if (i == 3) {
            TextView textView = (TextView) view;
            ClipData clipData = cVar.a;
            Context context = textView.getContext();
            int i3 = cVar.f471c;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            while (i2 < clipData.getItemCount()) {
                CharSequence b2 = b(context, clipData.getItemAt(i2), i3);
                if (b2 != null) {
                    spannableStringBuilder.append(b2);
                }
                i2++;
            }
            c((Editable) textView.getText(), spannableStringBuilder);
            return null;
        }
        ClipData clipData2 = cVar.a;
        int i4 = cVar.f471c;
        TextView textView2 = (TextView) view;
        Editable editable = (Editable) textView2.getText();
        Context context2 = textView2.getContext();
        boolean z = false;
        while (i2 < clipData2.getItemCount()) {
            CharSequence b3 = b(context2, clipData2.getItemAt(i2), i4);
            if (b3 != null) {
                if (!z) {
                    c(editable, b3);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), b3);
                }
            }
            i2++;
        }
        return null;
    }
}
