package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.C0554bf.C0555a;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.be */
public final class C0553be extends C0555a {

    /* renamed from: mQ */
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f1493mQ;

    /* renamed from: n */
    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> C0557bg m1254n(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, C0553be.class.getClassLoader());
            if (!MediationAdapter.class.isAssignableFrom(cls)) {
                C0662da.m1555w("Could not instantiate mediation adapter: " + str + ".");
                throw new RemoteException();
            }
            MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
            return new C0563bi(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.f1493mQ.get(mediationAdapter.getAdditionalParametersType()));
        } catch (Throwable th) {
            C0662da.m1555w("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            throw new RemoteException();
        }
    }

    /* renamed from: c */
    public void mo4601c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f1493mQ = map;
    }

    /* renamed from: m */
    public C0557bg mo4602m(String str) throws RemoteException {
        return m1254n(str);
    }
}
