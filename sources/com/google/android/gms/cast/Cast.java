package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.C0294b;
import com.google.android.gms.common.api.C0296a.C0297a;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0703dq;
import com.google.android.gms.internal.C0732ee;
import com.google.android.gms.internal.C0766er;
import java.io.IOException;

public final class Cast {
    public static final Api API = new Api(f377va, new Scope[0]);
    public static final CastApi CastApi = new C0260a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;

    /* renamed from: va */
    static final C0294b<C0703dq> f377va = new C0294b<C0703dq>() {
        /* renamed from: c */
        public C0703dq mo2998b(Context context, Looper looper, C0732ee eeVar, ApiOptions apiOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            C0766er.m1975b(apiOptions, (Object) "Setting the API options is required.");
            C0766er.m1976b(apiOptions instanceof CastOptions, (Object) "Must provide valid CastOptions!");
            CastOptions castOptions = (CastOptions) apiOptions;
            return new C0703dq(context, looper, castOptions.f396wv, (long) castOptions.f398wx, castOptions.f397ww, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    };

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        /* renamed from: com.google.android.gms.cast.Cast$CastApi$a */
        public static final class C0260a implements CastApi {
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((C0703dq) client.mo3256a(Cast.f377va)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((C0703dq) client.mo3256a(Cast.f377va)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((C0703dq) client.mo3256a(Cast.f377va)).mo4921da();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((C0703dq) client.mo3256a(Cast.f377va)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.mo3258b(new C0272c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4919b(null, null, this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.mo3258b(new C0272c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4919b(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.mo3258b(new C0272c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4919b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.mo3258b(new C0272c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4918a(applicationId, false, (C0299c<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final boolean relaunchIfRunning) {
                return client.mo3258b(new C0272c() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4918a(applicationId, relaunchIfRunning, (C0299c<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.mo3258b(new C0271b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4922e((C0299c<Status>) this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((C0703dq) client.mo3256a(Cast.f377va)).mo4913Q(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((C0703dq) client.mo3256a(Cast.f377va)).mo4920cZ();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.mo3258b(new C0271b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4917a(namespace, message, (C0299c<Status>) this);
                        } catch (IllegalArgumentException e) {
                            mo3087x(2001);
                        } catch (IllegalStateException e2) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((C0703dq) client.mo3256a(Cast.f377va)).mo4915a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((C0703dq) client.mo3256a(Cast.f377va)).mo4926t(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((C0703dq) client.mo3256a(Cast.f377va)).mo4914a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.mo3258b(new C0271b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        try {
                            dqVar.mo4916a("", (C0299c<Status>) this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.mo3258b(new C0271b() {
                    /* access modifiers changed from: protected */
                    /* renamed from: a */
                    public void mo3004a(C0703dq dqVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            mo3086c(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            dqVar.mo4916a(sessionId, (C0299c<Status>) this);
                        } catch (IllegalStateException e) {
                            mo3087x(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements ApiOptions {

        /* renamed from: wv */
        final CastDevice f396wv;

        /* renamed from: ww */
        final Listener f397ww;
        /* access modifiers changed from: private */

        /* renamed from: wx */
        public final int f398wx;

        public static final class Builder {
            /* access modifiers changed from: private */

            /* renamed from: wA */
            public int f399wA;

            /* renamed from: wy */
            CastDevice f400wy;

            /* renamed from: wz */
            Listener f401wz;

            private Builder(CastDevice castDevice, Listener castListener) {
                C0766er.m1975b(castDevice, (Object) "CastDevice parameter cannot be null");
                C0766er.m1975b(castListener, (Object) "CastListener parameter cannot be null");
                this.f400wy = castDevice;
                this.f401wz = castListener;
                this.f399wA = 0;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.f399wA |= 1;
                } else {
                    this.f399wA &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.f396wv = builder.f400wy;
            this.f397ww = builder.f401wz;
            this.f398wx = builder.f399wA;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    public static abstract class Listener {
        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    /* renamed from: com.google.android.gms.cast.Cast$a */
    protected static abstract class C0270a<R extends Result> extends C0297a<R, C0703dq> implements PendingResult<R> {
        public C0270a() {
            super(Cast.f377va);
        }

        /* renamed from: c */
        public void mo3086c(int i, String str) {
            mo3311b(mo3009d(new Status(i, str, null)));
        }

        /* renamed from: x */
        public void mo3087x(int i) {
            mo3311b(mo3009d(new Status(i)));
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$b */
    private static abstract class C0271b extends C0270a<Status> {
        private C0271b() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.cast.Cast$c */
    private static abstract class C0272c extends C0270a<ApplicationConnectionResult> {
        private C0272c() {
        }

        /* renamed from: h */
        public ApplicationConnectionResult mo3009d(final Status status) {
            return new ApplicationConnectionResult() {
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
