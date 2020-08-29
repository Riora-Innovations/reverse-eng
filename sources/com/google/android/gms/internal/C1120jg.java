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
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.C0736eh.C0739c;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C0736eh.C0743g;
import com.google.android.gms.internal.C1114je.C1115a;
import com.google.android.gms.internal.C1117jf.C1118a;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;

/* renamed from: com.google.android.gms.internal.jg */
public class C1120jg extends C0736eh<C1114je> {

    /* renamed from: Zw */
    private final int f3075Zw;
    private final int mTheme;
    /* access modifiers changed from: private */

    /* renamed from: nd */
    public final Activity f3076nd;

    /* renamed from: vi */
    private final String f3077vi;

    /* renamed from: com.google.android.gms.internal.jg$a */
    final class C1121a extends C1118a {

        /* renamed from: Bq */
        private final int f3078Bq;

        public C1121a(int i) {
            this.f3078Bq = i;
        }

        /* renamed from: a */
        public void mo6298a(int i, FullWallet fullWallet, Bundle bundle) {
            int i2;
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C1120jg.this.f3076nd, this.f3078Bq);
                } catch (SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                PendingIntent createPendingResult = C1120jg.this.f3076nd.createPendingResult(this.f3078Bq, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                    return;
                }
                try {
                    createPendingResult.send(i2);
                } catch (CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        /* renamed from: a */
        public void mo6299a(int i, MaskedWallet maskedWallet, Bundle bundle) {
            int i2;
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C1120jg.this.f3076nd, this.f3078Bq);
                } catch (SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                PendingIntent createPendingResult = C1120jg.this.f3076nd.createPendingResult(this.f3078Bq, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                    return;
                }
                try {
                    createPendingResult.send(i2);
                } catch (CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        /* renamed from: a */
        public void mo6300a(int i, boolean z, Bundle bundle) {
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = C1120jg.this.f3076nd.createPendingResult(this.f3078Bq, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        /* renamed from: e */
        public void mo6301e(int i, Bundle bundle) {
            C0766er.m1975b(bundle, (Object) "Bundle should not be null");
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(C1120jg.this.f3076nd, this.f3078Bq);
                } catch (SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
                Intent intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
                PendingIntent createPendingResult = C1120jg.this.f3076nd.createPendingResult(this.f3078Bq, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                    return;
                }
                try {
                    createPendingResult.send(1);
                } catch (CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }
    }

    public C1120jg(Activity activity, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        super(activity, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
        this.f3076nd = activity;
        this.f3075Zw = i;
        this.f3077vi = str;
        this.mTheme = i2;
    }

    @Deprecated
    public C1120jg(Activity activity, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, int i, String str, int i2) {
        this(activity, activity.getMainLooper(), new C0739c(connectionCallbacks), new C0743g(onConnectionFailedListener), i, str, i2);
    }

    /* renamed from: kx */
    private Bundle m3346kx() {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", this.f3075Zw);
        bundle.putString("androidPackageName", this.f3076nd.getPackageName());
        if (!TextUtils.isEmpty(this.f3077vi)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(this.f3077vi, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", this.mTheme);
        return bundle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        enVar.mo5089a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aE */
    public C1114je mo3741p(IBinder iBinder) {
        return C1115a.m3329aC(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void changeMaskedWallet(String googleTransactionId, String merchantTransactionId, int requestCode) {
        Bundle kx = m3346kx();
        C1121a aVar = new C1121a(requestCode);
        try {
            ((C1114je) mo5039eb()).mo6295a(googleTransactionId, merchantTransactionId, kx, aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            aVar.mo6299a(8, (MaskedWallet) null, (Bundle) null);
        }
    }

    public void checkForPreAuthorization(int requestCode) {
        Bundle kx = m3346kx();
        C1121a aVar = new C1121a(requestCode);
        try {
            ((C1114je) mo5039eb()).mo6290a(kx, (C1117jf) aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            aVar.mo6300a(8, false, (Bundle) null);
        }
    }

    public void loadFullWallet(FullWalletRequest request, int requestCode) {
        C1121a aVar = new C1121a(requestCode);
        try {
            ((C1114je) mo5039eb()).mo6291a(request, m3346kx(), (C1117jf) aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            aVar.mo6298a(8, (FullWallet) null, (Bundle) null);
        }
    }

    public void loadMaskedWallet(MaskedWalletRequest request, int requestCode) {
        Bundle kx = m3346kx();
        C1121a aVar = new C1121a(requestCode);
        try {
            ((C1114je) mo5039eb()).mo6292a(request, kx, (C1117jf) aVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            aVar.mo6299a(8, (MaskedWallet) null, (Bundle) null);
        }
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest request) {
        try {
            ((C1114je) mo5039eb()).mo6293a(request, m3346kx());
        } catch (RemoteException e) {
        }
    }
}
