package c.c.a.a.l;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.apkey.R;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
public class f extends BaseAdapter {
    public static final int e;

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f804b;

    /* renamed from: c  reason: collision with root package name */
    public final int f805c;
    public final int d;

    static {
        e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public f() {
        Calendar e2 = a0.e();
        this.f804b = e2;
        this.f805c = e2.getMaximum(7);
        this.d = e2.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f805c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int i2 = this.f805c;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.d;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f804b;
        int i2 = i + this.d;
        int i3 = this.f805c;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.f804b.getDisplayName(7, e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f804b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
