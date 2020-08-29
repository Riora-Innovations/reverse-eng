package com.google.android.gms.wallet;

import android.app.Activity;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.C1120jg;

@Deprecated
public class WalletClient implements GooglePlayServicesClient {

    /* renamed from: Zx */
    private final C1120jg f4038Zx;

    public WalletClient(Activity activity, int environment, String accountName, int theme, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
        this.f4038Zx = new C1120jg(activity, connectionCallbacks, connectionFailedListener, environment, accountName, theme);
    }

    public WalletClient(Activity activity, int environment, String accountName, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
        this(activity, environment, accountName, 0, connectionCallbacks, connectionFailedListener);
    }

    public void changeMaskedWallet(String googleTransactionId, String merchantTransactionId, int requestCode) {
        this.f4038Zx.changeMaskedWallet(googleTransactionId, merchantTransactionId, requestCode);
    }

    public void checkForPreAuthorization(int requestCode) {
        this.f4038Zx.checkForPreAuthorization(requestCode);
    }

    public void connect() {
        this.f4038Zx.connect();
    }

    public void disconnect() {
        this.f4038Zx.disconnect();
    }

    public boolean isConnected() {
        return this.f4038Zx.isConnected();
    }

    public boolean isConnecting() {
        return this.f4038Zx.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.f4038Zx.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.f4038Zx.isConnectionFailedListenerRegistered(listener);
    }

    public void loadFullWallet(FullWalletRequest request, int requestCode) {
        this.f4038Zx.loadFullWallet(request, requestCode);
    }

    public void loadMaskedWallet(MaskedWalletRequest request, int requestCode) {
        this.f4038Zx.loadMaskedWallet(request, requestCode);
    }

    public void notifyTransactionStatus(NotifyTransactionStatusRequest request) {
        this.f4038Zx.notifyTransactionStatus(request);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.f4038Zx.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f4038Zx.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.f4038Zx.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f4038Zx.unregisterConnectionFailedListener(listener);
    }
}
