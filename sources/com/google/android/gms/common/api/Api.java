package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.C0732ee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api {

    /* renamed from: za */
    private final C0294b<?> f506za;

    /* renamed from: zb */
    private final ArrayList<Scope> f507zb;

    /* renamed from: com.google.android.gms.common.api.Api$a */
    public interface C0293a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    /* renamed from: com.google.android.gms.common.api.Api$b */
    public interface C0294b<T extends C0293a> {
        /* renamed from: b */
        T mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public Api(C0294b<?> ClientBuilder, Scope... impliedScopes) {
        this.f506za = ClientBuilder;
        this.f507zb = new ArrayList<>(Arrays.asList(impliedScopes));
    }

    /* renamed from: dp */
    public C0294b<?> mo3250dp() {
        return this.f506za;
    }

    /* renamed from: dq */
    public List<Scope> mo3251dq() {
        return this.f507zb;
    }
}
