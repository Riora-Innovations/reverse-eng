package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.C0293a;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0766er;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public interface ApiOptions {
    }

    public static final class Builder {
        private final Context mContext;

        /* renamed from: vi */
        private String f508vi;

        /* renamed from: zn */
        private final Set<String> f509zn;

        /* renamed from: zo */
        private int f510zo;

        /* renamed from: zp */
        private View f511zp;

        /* renamed from: zq */
        private String f512zq;

        /* renamed from: zr */
        private final Map<Api, ApiOptions> f513zr;

        /* renamed from: zs */
        private Looper f514zs;

        /* renamed from: zt */
        private final Set<ConnectionCallbacks> f515zt;

        /* renamed from: zu */
        private final Set<OnConnectionFailedListener> f516zu;

        public Builder(Context context) {
            this.f509zn = new HashSet();
            this.f513zr = new HashMap();
            this.f515zt = new HashSet();
            this.f516zu = new HashSet();
            this.mContext = context;
            this.f514zs = context.getMainLooper();
            this.f512zq = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            C0766er.m1975b(connectedListener, (Object) "Must provide a connected listener");
            this.f515zt.add(connectedListener);
            C0766er.m1975b(connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.f516zu.add(connectionFailedListener);
        }

        public Builder addApi(Api api) {
            return addApi(api, null);
        }

        public Builder addApi(Api api, ApiOptions options) {
            this.f513zr.put(api, options);
            List dq = api.mo3251dq();
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                this.f509zn.add(((Scope) dq.get(i)).mo3290dD());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.f515zt.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.f516zu.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.f509zn.add(scope.mo3290dD());
            return this;
        }

        public GoogleApiClient build() {
            return new C0300b(this.mContext, this.f514zs, mo3277dx(), this.f513zr, this.f515zt, this.f516zu);
        }

        /* renamed from: dx */
        public C0732ee mo3277dx() {
            return new C0732ee(this.f508vi, this.f509zn, this.f510zo, this.f511zp, this.f512zq);
        }

        public Builder setAccountName(String accountName) {
            this.f508vi = accountName;
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.f510zo = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            C0766er.m1975b(handler, (Object) "Handler must not be null");
            this.f514zs = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.f511zp = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener {
    }

    /* renamed from: a */
    <C extends C0293a> C mo3256a(C0294b<C> bVar);

    /* renamed from: a */
    <A extends C0293a, T extends C0297a<? extends Result, A>> T mo3257a(T t);

    /* renamed from: b */
    <A extends C0293a, T extends C0297a<? extends Result, A>> T mo3258b(T t);

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
