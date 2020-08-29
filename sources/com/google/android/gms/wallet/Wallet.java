package com.google.android.gms.wallet;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
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
import com.google.android.gms.internal.C1120jg;

public final class Wallet {
    public static final Api API = new Api(f4027va, new Scope[0]);

    /* renamed from: va */
    static final C0294b<C1120jg> f4027va = new C0294b<C1120jg>() {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        /* renamed from: i */
        public C1120jg mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            C0766er.m1976b(context instanceof Activity, (Object) "An Activity must be used for Wallet APIs");
            Activity activity = (Activity) context;
            C0766er.m1976b(apiOptions == null || (apiOptions instanceof WalletOptions), (Object) "WalletOptions must be used for Wallet APIs");
            WalletOptions walletOptions = apiOptions != null ? (WalletOptions) apiOptions : new WalletOptions();
            return new C1120jg(activity, looper, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, eeVar.getAccountName(), walletOptions.theme);
        }
    };

    public static final class WalletOptions implements ApiOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: Zw */
            public int f4037Zw = 0;
            /* access modifiers changed from: private */
            public int mTheme = 0;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1) {
                    this.f4037Zw = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format("Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format("Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.f4037Zw;
            this.theme = builder.mTheme;
        }
    }

    /* renamed from: com.google.android.gms.wallet.Wallet$a */
    private static abstract class C1545a extends C0297a<Status, C1120jg> {
        public C1545a() {
            super(Wallet.f4027va);
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    public static void changeMaskedWallet(GoogleApiClient googleApiClient, final String googleTransactionId, final String merchantTransactionId, final int requestCode) {
        googleApiClient.mo3257a(new C1545a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1120jg jgVar) {
                jgVar.changeMaskedWallet(googleTransactionId, merchantTransactionId, requestCode);
                mo3311b(Status.f518zQ);
            }
        });
    }

    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.mo3257a(new C1545a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1120jg jgVar) {
                jgVar.checkForPreAuthorization(requestCode);
                mo3311b(Status.f518zQ);
            }
        });
    }

    public static void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.mo3257a(new C1545a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1120jg jgVar) {
                jgVar.loadFullWallet(request, requestCode);
                mo3311b(Status.f518zQ);
            }
        });
    }

    public static void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.mo3257a(new C1545a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1120jg jgVar) {
                jgVar.loadMaskedWallet(request, requestCode);
                mo3311b(Status.f518zQ);
            }
        });
    }

    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.mo3257a(new C1545a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C1120jg jgVar) {
                jgVar.notifyTransactionStatus(request);
                mo3311b(Status.f518zQ);
            }
        });
    }
}
