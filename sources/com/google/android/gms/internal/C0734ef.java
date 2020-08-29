package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.google.android.gms.internal.ef */
public class C0734ef implements OnClickListener {

    /* renamed from: Bq */
    private final int f2003Bq;
    private final Intent mIntent;

    /* renamed from: nd */
    private final Activity f2004nd;

    public C0734ef(Activity activity, Intent intent, int i) {
        this.f2004nd = activity;
        this.mIntent = intent;
        this.f2003Bq = i;
    }

    public void onClick(DialogInterface dialog, int which) {
        try {
            if (this.mIntent != null) {
                this.f2004nd.startActivityForResult(this.mIntent, this.f2003Bq);
            }
            dialog.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}
