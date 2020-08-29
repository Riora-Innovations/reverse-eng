package com.google.android.gms.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import java.io.FileOutputStream;
import java.io.IOException;

public class CampaignTrackingService extends IntentService {
    public CampaignTrackingService() {
        super("CampaignIntentService");
    }

    public CampaignTrackingService(String name) {
        super(name);
    }

    public void onHandleIntent(Intent intent) {
        processIntent(this, intent);
    }

    public void processIntent(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        try {
            FileOutputStream openFileOutput = context.openFileOutput("gaInstallData", 0);
            openFileOutput.write(stringExtra.getBytes());
            openFileOutput.close();
            C0181aa.m74v("Stored campaign information.");
        } catch (IOException e) {
            C0181aa.m72t("Error storing install campaign.");
        }
    }
}
