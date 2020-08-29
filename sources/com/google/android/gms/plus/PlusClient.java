package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C1329e;
import com.google.android.gms.plus.internal.C1342i;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {

    /* renamed from: QN */
    final C1329e f3393QN;

    @Deprecated
    public static class Builder {

        /* renamed from: QS */
        private final ConnectionCallbacks f3408QS;

        /* renamed from: QT */
        private final OnConnectionFailedListener f3409QT;

        /* renamed from: QU */
        private final C1342i f3410QU = new C1342i(this.mContext);
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.f3408QS = connectionCallbacks;
            this.f3409QT = connectionFailedListener;
        }

        public PlusClient build() {
            return new PlusClient(new C1329e(this.mContext, this.f3408QS, this.f3409QT, this.f3410QU.mo7436hA()));
        }

        public Builder clearScopes() {
            this.f3410QU.mo7437hz();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.f3410QU.mo7433aS(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.f3410QU.mo7435f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.f3410QU.mo7434e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    PlusClient(C1329e plusClientImpl) {
        this.f3393QN = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.f3393QN.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.f3393QN.connect();
    }

    @Deprecated
    public void disconnect() {
        this.f3393QN.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.f3393QN.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.f3393QN.getCurrentPerson();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hj */
    public C1329e mo7299hj() {
        return this.f3393QN;
    }

    @Deprecated
    public boolean isConnected() {
        return this.f3393QN.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.f3393QN.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.f3393QN.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.f3393QN.isConnectionFailedListenerRegistered(listener);
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener) {
        this.f3393QN.mo7404i(new C0299c<LoadMomentsResult>() {
            /* renamed from: a */
            public void mo3311b(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().mo3293dG(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }
        });
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.f3393QN.mo7395a(new C0299c<LoadMomentsResult>() {
            /* renamed from: a */
            public void mo3311b(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().mo3293dG(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }
        }, maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.f3393QN.mo7397a((C0299c<LoadPeopleResult>) new C0299c<LoadPeopleResult>() {
            /* renamed from: a */
            public void mo3311b(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo3293dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, personIds);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, String... personIds) {
        this.f3393QN.mo7400c(new C0299c<LoadPeopleResult>() {
            /* renamed from: a */
            public void mo3311b(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo3293dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, personIds);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.f3393QN.mo7394a((C0299c<LoadPeopleResult>) new C0299c<LoadPeopleResult>() {
            /* renamed from: a */
            public void mo3311b(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo3293dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, String pageToken) {
        this.f3393QN.mo7405i(new C0299c<LoadPeopleResult>() {
            /* renamed from: a */
            public void mo3311b(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().mo3293dG(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.f3393QN.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f3393QN.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.f3393QN.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(final OnAccessRevokedListener listener) {
        this.f3393QN.mo7407k(new C0299c<Status>() {
            /* renamed from: K */
            public void mo3311b(Status status) {
                listener.onAccessRevoked(status.getStatus().mo3293dG());
            }
        });
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.f3393QN.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.f3393QN.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.f3393QN.mo7396a(null, moment);
    }
}
