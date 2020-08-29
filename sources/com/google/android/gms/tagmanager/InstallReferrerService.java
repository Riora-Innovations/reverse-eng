package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService extends IntentService {

    /* renamed from: Vk */
    CampaignTrackingService f3550Vk;

    /* renamed from: Vl */
    Context f3551Vl;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String name) {
        super(name);
    }

    /* renamed from: a */
    private void m3967a(Context context, Intent intent) {
        if (this.f3550Vk == null) {
            this.f3550Vk = new CampaignTrackingService();
        }
        this.f3550Vk.processIntent(context, intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        Context applicationContext = this.f3551Vl != null ? this.f3551Vl : getApplicationContext();
        C1387ay.m4048c(applicationContext, stringExtra);
        m3967a(applicationContext, intent);
    }
}
