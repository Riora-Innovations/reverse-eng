package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0621cb.C0622a;
import com.google.android.gms.internal.C0621cb.C0623b;

/* renamed from: com.google.android.gms.internal.ca */
public final class C0619ca {

    /* renamed from: com.google.android.gms.internal.ca$a */
    public interface C0620a {
        /* renamed from: a */
        void mo4694a(C0628cf cfVar);
    }

    /* renamed from: a */
    public static C0648ct m1408a(Context context, C0625cd cdVar, C0620a aVar) {
        return cdVar.f1646kN.f1801pX ? m1409b(context, cdVar, aVar) : m1410c(context, cdVar, aVar);
    }

    /* renamed from: b */
    private static C0648ct m1409b(Context context, C0625cd cdVar, C0620a aVar) {
        C0662da.m1551s("Fetching ad response from local ad request service.");
        C0622a aVar2 = new C0622a(context, cdVar, aVar);
        aVar2.start();
        return aVar2;
    }

    /* renamed from: c */
    private static C0648ct m1410c(Context context, C0625cd cdVar, C0620a aVar) {
        C0662da.m1551s("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C0623b(context, cdVar, aVar);
        }
        C0662da.m1555w("Failed to connect to remote ad request service.");
        return null;
    }
}
