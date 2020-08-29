package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C1002hc;

public final class Address {
    public static final Api API = new Api(f1092va, new Scope[0]);

    /* renamed from: va */
    static final C0294b<C1002hc> f1092va = new C0294b<C1002hc>() {
        /* renamed from: f */
        public C1002hc mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            AddressOptions addressOptions;
            C0766er.m1976b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            AddressOptions addressOptions2 = new AddressOptions();
            if (apiOptions != null) {
                C0766er.m1976b(apiOptions instanceof AddressOptions, (Object) "Must use AddressOptions with Address API");
                addressOptions = (AddressOptions) apiOptions;
            } else {
                addressOptions = addressOptions2;
            }
            return new C1002hc((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, eeVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public static final class AddressOptions implements ApiOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme2) {
            this.theme = theme2;
        }
    }

    /* renamed from: com.google.android.gms.identity.intents.Address$a */
    private static abstract class C0497a extends C0297a<Status, C1002hc> {
        public C0497a() {
            super(Address.f1092va);
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.mo3257a(new C0497a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1002hc hcVar) throws RemoteException {
                hcVar.mo5645a(request, requestCode);
                mo3311b(Status.f518zQ);
            }
        });
    }
}
