package b.i.a;

import android.database.Cursor;
import android.widget.Filter;
import b.b.h.j0;
/* loaded from: classes.dex */
public class b extends Filter {
    public a a;

    /* loaded from: classes.dex */
    public interface a {
    }

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return ((j0) this.a).c((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r5) {
        /*
            r4 = this;
            b.i.a.b$a r0 = r4.a
            b.b.h.j0 r0 = (b.b.h.j0) r0
            r0.getClass()
            if (r5 != 0) goto Lc
            java.lang.String r5 = ""
            goto L10
        Lc:
            java.lang.String r5 = r5.toString()
        L10:
            androidx.appcompat.widget.SearchView r1 = r0.m
            int r1 = r1.getVisibility()
            r2 = 0
            if (r1 != 0) goto L38
            androidx.appcompat.widget.SearchView r1 = r0.m
            int r1 = r1.getWindowVisibility()
            if (r1 == 0) goto L22
            goto L38
        L22:
            android.app.SearchableInfo r1 = r0.n     // Catch: java.lang.RuntimeException -> L30
            r3 = 50
            android.database.Cursor r5 = r0.g(r1, r5, r3)     // Catch: java.lang.RuntimeException -> L30
            if (r5 == 0) goto L38
            r5.getCount()     // Catch: java.lang.RuntimeException -> L30
            goto L39
        L30:
            r5 = move-exception
            java.lang.String r0 = "SuggestionsAdapter"
            java.lang.String r1 = "Search suggestions query threw an exception."
            android.util.Log.w(r0, r1, r5)
        L38:
            r5 = r2
        L39:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r5 == 0) goto L49
            int r1 = r5.getCount()
            r0.count = r1
            r0.values = r5
            goto L4e
        L49:
            r5 = 0
            r0.count = r5
            r0.values = r2
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.b.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.a;
        Cursor cursor = ((b.i.a.a) aVar).d;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((j0) aVar).b((Cursor) obj);
    }
}
