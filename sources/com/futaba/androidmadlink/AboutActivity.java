package com.futaba.androidmadlink;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.futaba.androidmadlink.config.Parameter;

public class AboutActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0112R.layout.about);
        ((TextView) findViewById(C0112R.C0114id.textView1)).setText("Copyright 2014 by Futaba\n\n Version:　" + Parameter.getVerName(this));
    }
}
