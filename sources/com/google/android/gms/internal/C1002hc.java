package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C1004hd.C1005a;
import com.google.android.gms.internal.C1007he.C1008a;

/* renamed from: com.google.android.gms.internal.hc */
public class C1002hc extends C0736eh<C1007he> {

    /* renamed from: KA */
    private C1003a f2644KA;
    private final int mTheme;

    /* renamed from: nd */
    private Activity f2645nd;

    /* renamed from: vi */
    private final String f2646vi;

    /* renamed from: com.google.android.gms.internal.hc$a */
    public static final class C1003a extends C1005a {

        /* renamed from: Bq */
        private final int f2647Bq;

        /* renamed from: nd */
        private Activity f2648nd;

        public C1003a(int i, Activity activity) {
            this.f2647Bq = i;
            this.f2648nd = activity;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.f2648nd = activity;
        }

        /* renamed from: c */
        public void mo5648c(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent createPendingResult = this.f2648nd.createPendingResult(this.f2647Bq, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                    } catch (CanceledException e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                    }
                }
            } else {
                PendingIntent pendingIntent = null;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
                }
                ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
                if (connectionResult.hasResolution()) {
                    try {
                        connectionResult.startResolutionForResult(this.f2648nd, this.f2647Bq);
                    } catch (SendIntentException e2) {
                        Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    }
                } else {
                    try {
                        PendingIntent createPendingResult2 = this.f2648nd.createPendingResult(this.f2647Bq, new Intent(), 1073741824);
                        if (createPendingResult2 != null) {
                            createPendingResult2.send(1);
                        }
                    } catch (CanceledException e3) {
                        Log.w("AddressClientImpl", "Exception setting pending result", e3);
                    }
                }
            }
        }
    }

    public C1002hc(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, int i) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f2646vi = str;
        this.f2645nd = activity;
        this.mTheme = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public C1007he mo3741p(IBinder iBinder) {
        return C1008a.m2952M(iBinder);
    }

    /* renamed from: a */
    public void mo5645a(UserAddressRequest userAddressRequest, int i) {
        mo5647gj();
        this.f2644KA = new C1003a(i, this.f2645nd);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.f2646vi)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.f2646vi, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            mo5646gi().mo5652a(this.f2644KA, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.f2644KA.mo5648c(1, bundle2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        enVar.mo5101d(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.identity.service.BIND";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public void disconnect() {
        super.disconnect();
        if (this.f2644KA != null) {
            this.f2644KA.setActivity(null);
            this.f2644KA = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: gi */
    public C1007he mo5646gi() {
        return (C1007he) super.mo5039eb();
    }

    /* access modifiers changed from: protected */
    /* renamed from: gj */
    public void mo5647gj() {
        super.mo5037bm();
    }
}
