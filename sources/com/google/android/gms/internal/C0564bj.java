package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* renamed from: com.google.android.gms.internal.bj */
public final class C0564bj<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */

    /* renamed from: mT */
    public final C0560bh f1499mT;

    public C0564bj(C0560bh bhVar) {
        this.f1499mT = bhVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0662da.m1551s("Adapter called onClick.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onClick must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.mo4589O();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdClicked.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.mo4589O();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0662da.m1551s("Adapter called onDismissScreen.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onDismissScreen must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdClosed();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdClosed();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0662da.m1551s("Adapter called onDismissScreen.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onDismissScreen must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdClosed();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdClosed();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        C0662da.m1551s("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onFailedToReceiveAd must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdFailedToLoad(C0576bk.m1278a(errorCode));
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdFailedToLoad(C0576bk.m1278a(errorCode));
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        C0662da.m1551s("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onFailedToReceiveAd must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdFailedToLoad(C0576bk.m1278a(errorCode));
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdFailedToLoad(C0576bk.m1278a(errorCode));
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0662da.m1551s("Adapter called onLeaveApplication.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onLeaveApplication must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdLeftApplication();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdLeftApplication();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0662da.m1551s("Adapter called onLeaveApplication.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onLeaveApplication must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdLeftApplication();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdLeftApplication();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0662da.m1551s("Adapter called onPresentScreen.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onPresentScreen must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdOpened();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdOpened();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0662da.m1551s("Adapter called onPresentScreen.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onPresentScreen must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdOpened();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdOpened();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        C0662da.m1551s("Adapter called onReceivedAd.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onReceivedAd must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdLoaded();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdLoaded();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        C0662da.m1551s("Adapter called onReceivedAd.");
        if (!C0659cz.m1539aX()) {
            C0662da.m1555w("onReceivedAd must be called on the main UI thread.");
            C0659cz.f1785pT.post(new Runnable() {
                public void run() {
                    try {
                        C0564bj.this.f1499mT.onAdLoaded();
                    } catch (RemoteException e) {
                        C0662da.m1549b("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.f1499mT.onAdLoaded();
        } catch (RemoteException e) {
            C0662da.m1549b("Could not call onAdLoaded.", e);
        }
    }
}
