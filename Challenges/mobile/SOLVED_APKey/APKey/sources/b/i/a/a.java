package b.i.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import b.i.a.b;
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f507b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f508c;
    public Cursor d;
    public Context e;
    public int f;
    public C0022a g;
    public DataSetObserver h;
    public b.i.a.b i;

    /* renamed from: b.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0022a extends ContentObserver {
        public C0022a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (!aVar.f508c || (cursor = aVar.d) == null || cursor.isClosed()) {
                return;
            }
            aVar.f507b = aVar.d.requery();
        }
    }

    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.f507b = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.f507b = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        b bVar;
        boolean z2 = true;
        int i = z ? 1 : 2;
        if ((i & 1) == 1) {
            i |= 2;
            this.f508c = true;
        } else {
            this.f508c = false;
        }
        z2 = cursor == null ? false : z2;
        this.d = cursor;
        this.f507b = z2;
        this.e = context;
        this.f = z2 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.g = new C0022a();
            bVar = new b();
        } else {
            bVar = null;
            this.g = null;
        }
        this.h = bVar;
        if (z2) {
            C0022a c0022a = this.g;
            if (c0022a != null) {
                cursor.registerContentObserver(c0022a);
            }
            DataSetObserver dataSetObserver = this.h;
            if (dataSetObserver == null) {
                return;
            }
            cursor.registerDataSetObserver(dataSetObserver);
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.d;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0022a c0022a = this.g;
                if (c0022a != null) {
                    cursor2.unregisterContentObserver(c0022a);
                }
                DataSetObserver dataSetObserver = this.h;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.d = cursor;
            if (cursor != null) {
                C0022a c0022a2 = this.g;
                if (c0022a2 != null) {
                    cursor.registerContentObserver(c0022a2);
                }
                DataSetObserver dataSetObserver2 = this.h;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.f = cursor.getColumnIndexOrThrow("_id");
                this.f507b = true;
                notifyDataSetChanged();
            } else {
                this.f = -1;
                this.f507b = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f507b || (cursor = this.d) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.f507b) {
            this.d.moveToPosition(i);
            if (view == null) {
                c cVar = (c) this;
                view = cVar.l.inflate(cVar.k, viewGroup, false);
            }
            a(view, this.e, this.d);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.i == null) {
            this.i = new b.i.a.b(this);
        }
        return this.i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f507b || (cursor = this.d) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.d;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (!this.f507b || (cursor = this.d) == null || !cursor.moveToPosition(i)) {
            return 0L;
        }
        return this.d.getLong(this.f);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f507b) {
            if (this.d.moveToPosition(i)) {
                if (view == null) {
                    view = d(this.e, this.d, viewGroup);
                }
                a(view, this.e, this.d);
                return view;
            }
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
