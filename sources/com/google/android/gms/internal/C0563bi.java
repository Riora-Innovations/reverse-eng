package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.mediation.admob.AdMobServerParameters;
import com.google.android.gms.dynamic.C0453b;
import com.google.android.gms.dynamic.C0456c;
import com.google.android.gms.internal.C0557bg.C0558a;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.bi */
public final class C0563bi<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0558a {

    /* renamed from: mR */
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f1497mR;

    /* renamed from: mS */
    private final NETWORK_EXTRAS f1498mS;

    public C0563bi(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f1497mR = mediationAdapter;
        this.f1498mS = network_extras;
    }

    /* renamed from: a */
    private SERVER_PARAMETERS m1272a(String str, int i, String str2) throws RemoteException {
        HashMap hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                HashMap hashMap2 = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap2.put(str3, jSONObject.getString(str3));
                }
                hashMap = hashMap2;
            } catch (Throwable th) {
                C0662da.m1549b("Could not get MediationServerParameters.", th);
                throw new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f1497mR.getServerParametersType();
        SERVER_PARAMETERS server_parameters = null;
        if (serverParametersType != null) {
            SERVER_PARAMETERS server_parameters2 = (MediationServerParameters) serverParametersType.newInstance();
            server_parameters2.load(hashMap);
            server_parameters = server_parameters2;
        }
        if (server_parameters instanceof AdMobServerParameters) {
            AdMobServerParameters adMobServerParameters = (AdMobServerParameters) server_parameters;
            adMobServerParameters.adJson = str2;
            adMobServerParameters.tagForChildDirectedTreatment = i;
        }
        return server_parameters;
    }

    /* renamed from: a */
    public void mo4606a(C0453b bVar, C0504ab abVar, C1173z zVar, String str, C0560bh bhVar) throws RemoteException {
        mo4607a(bVar, abVar, zVar, str, null, bhVar);
    }

    /* renamed from: a */
    public void mo4607a(C0453b bVar, C0504ab abVar, C1173z zVar, String str, String str2, C0560bh bhVar) throws RemoteException {
        if (!(this.f1497mR instanceof MediationBannerAdapter)) {
            C0662da.m1555w("MediationAdapter is not a MediationBannerAdapter: " + this.f1497mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C0662da.m1551s("Requesting banner ad from adapter.");
        try {
            ((MediationBannerAdapter) this.f1497mR).requestBannerAd(new C0564bj(bhVar), (Activity) C0456c.m1000b(bVar), m1272a(str, zVar.tagForChildDirectedTreatment, str2), C0576bk.m1280b(abVar), C0576bk.m1281e(zVar), this.f1498mS);
        } catch (Throwable th) {
            C0662da.m1549b("Could not request banner ad from adapter.", th);
            throw new RemoteException();
        }
    }

    /* renamed from: a */
    public void mo4608a(C0453b bVar, C1173z zVar, String str, C0560bh bhVar) throws RemoteException {
        mo4609a(bVar, zVar, str, (String) null, bhVar);
    }

    /* renamed from: a */
    public void mo4609a(C0453b bVar, C1173z zVar, String str, String str2, C0560bh bhVar) throws RemoteException {
        if (!(this.f1497mR instanceof MediationInterstitialAdapter)) {
            C0662da.m1555w("MediationAdapter is not a MediationInterstitialAdapter: " + this.f1497mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C0662da.m1551s("Requesting interstitial ad from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f1497mR).requestInterstitialAd(new C0564bj(bhVar), (Activity) C0456c.m1000b(bVar), m1272a(str, zVar.tagForChildDirectedTreatment, str2), C0576bk.m1281e(zVar), this.f1498mS);
        } catch (Throwable th) {
            C0662da.m1549b("Could not request interstitial ad from adapter.", th);
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.f1497mR.destroy();
        } catch (Throwable th) {
            C0662da.m1549b("Could not destroy adapter.", th);
            throw new RemoteException();
        }
    }

    public C0453b getView() throws RemoteException {
        if (!(this.f1497mR instanceof MediationBannerAdapter)) {
            C0662da.m1555w("MediationAdapter is not a MediationBannerAdapter: " + this.f1497mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
        try {
            return C0456c.m1001h(((MediationBannerAdapter) this.f1497mR).getBannerView());
        } catch (Throwable th) {
            C0662da.m1549b("Could not get banner view from adapter.", th);
            throw new RemoteException();
        }
    }

    public void showInterstitial() throws RemoteException {
        if (!(this.f1497mR instanceof MediationInterstitialAdapter)) {
            C0662da.m1555w("MediationAdapter is not a MediationInterstitialAdapter: " + this.f1497mR.getClass().getCanonicalName());
            throw new RemoteException();
        }
        C0662da.m1551s("Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter) this.f1497mR).showInterstitial();
        } catch (Throwable th) {
            C0662da.m1549b("Could not show interstitial from adapter.", th);
            throw new RemoteException();
        }
    }
}
