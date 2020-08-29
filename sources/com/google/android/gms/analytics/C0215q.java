package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: com.google.android.gms.analytics.q */
class C0215q extends BroadcastReceiver {

    /* renamed from: rg */
    static final String f196rg = C0215q.class.getName();

    /* renamed from: rh */
    private final C0188af f197rh;

    C0215q(C0188af afVar) {
        this.f197rh = afVar;
    }

    /* renamed from: p */
    public static void m198p(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(f196rg, true);
        context.sendBroadcast(intent);
    }

    /* renamed from: o */
    public void mo2946o(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter2.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter2);
    }

    public void onReceive(Context ctx, Intent intent) {
        boolean z = false;
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            C0188af afVar = this.f197rh;
            if (!booleanExtra) {
                z = true;
            }
            afVar.mo2891q(z);
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(f196rg)) {
            this.f197rh.mo2889bF();
        }
    }
}
