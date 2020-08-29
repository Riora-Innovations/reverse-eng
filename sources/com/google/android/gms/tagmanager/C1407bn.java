package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

/* renamed from: com.google.android.gms.tagmanager.bn */
class C1407bn extends BroadcastReceiver {

    /* renamed from: rg */
    static final String f3642rg = C1407bn.class.getName();

    /* renamed from: VG */
    private final C1470cx f3643VG;

    C1407bn(C1470cx cxVar) {
        this.f3643VG = cxVar;
    }

    /* renamed from: p */
    public static void m4094p(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f3642rg, true);
        context.sendBroadcast(intent);
    }

    /* renamed from: o */
    public void mo7618o(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter2.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter2);
    }

    public void onReceive(Context ctx, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.f3643VG.mo7759q(!bool.booleanValue());
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(f3642rg)) {
            this.f3643VG.mo7758bF();
        }
    }
}
