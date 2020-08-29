package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.google.android.gms.internal.bl */
public final class C0578bl {
    /* renamed from: a */
    public static boolean m1284a(Context context, C0580bn bnVar, C0592bu buVar) {
        if (bnVar == null) {
            C0662da.m1555w("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(bnVar.f1516mZ)) {
            C0662da.m1555w("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(bnVar.mimeType)) {
            intent.setDataAndType(Uri.parse(bnVar.f1516mZ), bnVar.mimeType);
        } else {
            intent.setData(Uri.parse(bnVar.f1516mZ));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(bnVar.packageName)) {
            intent.setPackage(bnVar.packageName);
        }
        if (!TextUtils.isEmpty(bnVar.f1517na)) {
            String[] split = bnVar.f1517na.split("/", 2);
            if (split.length < 2) {
                C0662da.m1555w("Could not parse component name from open GMSG: " + bnVar.f1517na);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        try {
            C0662da.m1554v("Launching an intent: " + intent);
            context.startActivity(intent);
            buVar.mo4685R();
            return true;
        } catch (ActivityNotFoundException e) {
            C0662da.m1555w(e.getMessage());
            return false;
        }
    }
}
