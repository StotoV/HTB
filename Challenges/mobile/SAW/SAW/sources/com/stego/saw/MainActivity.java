package com.stego.saw;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.internal.view.SupportMenu;
import java.io.File;
/* loaded from: classes.dex */
public class MainActivity extends AppCompatActivity {
    String FILE_PATH_PREFIX = BuildConfig.FLAVOR;
    String answer = BuildConfig.FLAVOR;

    public native String a(String str, String str2);

    static {
        System.loadLibrary("default");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.FILE_PATH_PREFIX = getApplicationContext().getApplicationInfo().dataDir + File.separatorChar;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
        } else if (!extras.getString("open").equalsIgnoreCase("sesame")) {
            finish();
        } else {
            Button button = new Button(getApplicationContext());
            button.setText("Click me...");
            button.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            ((WindowManager) getSystemService("window")).addView(button, new WindowManager.LayoutParams(200, 200, 2, 8, -3));
            button.setOnClickListener(new View.OnClickListener() { // from class: com.stego.saw.MainActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MainActivity.this.f();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(200, 200, 2038, 8, -2);
        layoutParams.gravity = 17;
        Button button = new Button(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() { // from class: com.stego.saw.MainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.alert();
            }
        });
        ((WindowManager) getSystemService("window")).addView(button, layoutParams);
    }

    public final String alert() {
        final EditText editText = new EditText(this);
        new AlertDialog.Builder(this).setTitle("XOR XOR XOR").setMessage("XOR ME !").setView(editText).setPositiveButton("XORIFY", new DialogInterface.OnClickListener() { // from class: com.stego.saw.MainActivity.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.answer = editText.getText().toString();
                MainActivity mainActivity = MainActivity.this;
                mainActivity.a(mainActivity.FILE_PATH_PREFIX, MainActivity.this.answer);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.stego.saw.MainActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        }).show();
        return this.answer;
    }
}
