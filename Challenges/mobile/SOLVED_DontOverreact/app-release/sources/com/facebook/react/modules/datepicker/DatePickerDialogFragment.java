package com.facebook.react.modules.datepicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;
import java.util.Locale;
/* loaded from: classes.dex */
public class DatePickerDialogFragment extends DialogFragment {
    private static final long DEFAULT_MIN_DATE = -2208988800001L;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private DialogInterface.OnDismissListener mOnDismissListener;

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
    }

    static Dialog createDialog(Bundle bundle, Context context, DatePickerDialog.OnDateSetListener onDateSetListener) {
        DismissableDatePickerDialog dismissableDatePickerDialog;
        DatePicker datePicker;
        Calendar calendar = Calendar.getInstance();
        if (bundle != null && bundle.containsKey("date")) {
            calendar.setTimeInMillis(bundle.getLong("date"));
        }
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        DatePickerMode datePickerMode = DatePickerMode.DEFAULT;
        DismissableDatePickerDialog dismissableDatePickerDialog2 = null;
        if (bundle != null && bundle.getString("mode", null) != null) {
            datePickerMode = DatePickerMode.valueOf(bundle.getString("mode").toUpperCase(Locale.US));
        }
        int i4 = AnonymousClass1.$SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[datePickerMode.ordinal()];
        if (i4 == 1) {
            dismissableDatePickerDialog = new DismissableDatePickerDialog(context, context.getResources().getIdentifier("CalendarDatePickerDialog", "style", context.getPackageName()), onDateSetListener, i, i2, i3);
        } else if (i4 == 2) {
            dismissableDatePickerDialog = new DismissableDatePickerDialog(context, 16973939, onDateSetListener, i, i2, i3);
            dismissableDatePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } else {
            if (i4 == 3) {
                dismissableDatePickerDialog = new DismissableDatePickerDialog(context, onDateSetListener, i, i2, i3);
            }
            datePicker = dismissableDatePickerDialog2.getDatePicker();
            if (bundle == null && bundle.containsKey("minDate")) {
                calendar.setTimeInMillis(bundle.getLong("minDate"));
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                datePicker.setMinDate(calendar.getTimeInMillis());
            } else {
                datePicker.setMinDate(DEFAULT_MIN_DATE);
            }
            if (bundle != null && bundle.containsKey("maxDate")) {
                calendar.setTimeInMillis(bundle.getLong("maxDate"));
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 59);
                calendar.set(14, 999);
                datePicker.setMaxDate(calendar.getTimeInMillis());
            }
            return dismissableDatePickerDialog2;
        }
        dismissableDatePickerDialog2 = dismissableDatePickerDialog;
        datePicker = dismissableDatePickerDialog2.getDatePicker();
        if (bundle == null) {
        }
        datePicker.setMinDate(DEFAULT_MIN_DATE);
        if (bundle != null) {
            calendar.setTimeInMillis(bundle.getLong("maxDate"));
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, 999);
            datePicker.setMaxDate(calendar.getTimeInMillis());
        }
        return dismissableDatePickerDialog2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.facebook.react.modules.datepicker.DatePickerDialogFragment$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode;

        static {
            int[] iArr = new int[DatePickerMode.values().length];
            $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode = iArr;
            try {
                iArr[DatePickerMode.CALENDAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[DatePickerMode.SPINNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[DatePickerMode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogInterface.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnDateSetListener(DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }
}
