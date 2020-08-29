package com.google.android.gms.panorama;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.internal.C1058ih;
import com.google.android.gms.panorama.Panorama.PanoramaResult;

public class PanoramaClient implements GooglePlayServicesClient {

    /* renamed from: QB */
    private final C1058ih f3382QB;

    public interface OnPanoramaInfoLoadedListener {
        void onPanoramaInfoLoaded(ConnectionResult connectionResult, Intent intent);
    }

    public PanoramaClient(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
        this.f3382QB = new C1058ih(context, connectionCallbacks, connectionFailedListener);
    }

    public void connect() {
        this.f3382QB.connect();
    }

    public void disconnect() {
        this.f3382QB.disconnect();
    }

    public boolean isConnected() {
        return this.f3382QB.isConnected();
    }

    public boolean isConnecting() {
        return this.f3382QB.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.f3382QB.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.f3382QB.isConnectionFailedListenerRegistered(listener);
    }

    public void loadPanoramaInfo(final OnPanoramaInfoLoadedListener listener, Uri uri) {
        this.f3382QB.mo5855a(new C0299c<PanoramaResult>() {
            /* renamed from: a */
            public void mo3311b(PanoramaResult panoramaResult) {
                listener.onPanoramaInfoLoaded(panoramaResult.getStatus().mo3293dG(), panoramaResult.getViewerIntent());
            }
        }, uri, false);
    }

    public void loadPanoramaInfoAndGrantAccess(final OnPanoramaInfoLoadedListener listener, Uri uri) {
        this.f3382QB.mo5855a(new C0299c<PanoramaResult>() {
            /* renamed from: a */
            public void mo3311b(PanoramaResult panoramaResult) {
                listener.onPanoramaInfoLoaded(panoramaResult.getStatus().mo3293dG(), panoramaResult.getViewerIntent());
            }
        }, uri, true);
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.f3382QB.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f3382QB.registerConnectionFailedListener(listener);
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.f3382QB.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f3382QB.unregisterConnectionFailedListener(listener);
    }
}
