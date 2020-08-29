package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;

/* renamed from: com.google.android.gms.drive.internal.r */
public class C0400r implements DriveResource {

    /* renamed from: CS */
    protected final DriveId f784CS;

    /* renamed from: com.google.android.gms.drive.internal.r$a */
    private abstract class C0404a extends C0379m<MetadataResult> {
        private C0404a() {
        }

        /* renamed from: r */
        public MetadataResult mo3009d(Status status) {
            return new C0408e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$b */
    private static class C0405b extends C0352c {

        /* renamed from: vj */
        private final C0299c<MetadataBufferResult> f790vj;

        public C0405b(C0299c<MetadataBufferResult> cVar) {
            this.f790vj = cVar;
        }

        /* renamed from: a */
        public void mo3688a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.f790vj.mo3311b(new C0371e(Status.f518zQ, new MetadataBuffer(onListParentsResponse.mo3609fd(), null)));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f790vj.mo3311b(new C0371e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$c */
    private abstract class C0406c extends C0379m<MetadataBufferResult> {
        private C0406c() {
        }

        /* renamed from: o */
        public MetadataBufferResult mo3009d(Status status) {
            return new C0371e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$d */
    private static class C0407d extends C0352c {

        /* renamed from: vj */
        private final C0299c<MetadataResult> f792vj;

        public C0407d(C0299c<MetadataResult> cVar) {
            this.f792vj = cVar;
        }

        /* renamed from: a */
        public void mo3689a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.f792vj.mo3311b(new C0408e(Status.f518zQ, new C0359j(onMetadataResponse.mo3612fe())));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f792vj.mo3311b(new C0408e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$e */
    private static class C0408e implements MetadataResult {

        /* renamed from: DQ */
        private final Metadata f793DQ;

        /* renamed from: vl */
        private final Status f794vl;

        public C0408e(Status status, Metadata metadata) {
            this.f794vl = status;
            this.f793DQ = metadata;
        }

        public Metadata getMetadata() {
            return this.f793DQ;
        }

        public Status getStatus() {
            return this.f794vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.r$f */
    private abstract class C0409f extends C0379m<MetadataResult> {
        private C0409f() {
        }

        /* renamed from: r */
        public MetadataResult mo3009d(Status status) {
            return new C0408e(status, null);
        }
    }

    protected C0400r(DriveId driveId) {
        this.f784CS = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0380n) apiClient.mo3256a(Drive.f636va)).mo3732a(apiClient, this.f784CS, 1, listener);
    }

    public DriveId getDriveId() {
        return this.f784CS;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.mo3257a(new C0404a() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0380n nVar) throws RemoteException {
                nVar.mo3738eT().mo3777a(new GetMetadataRequest(C0400r.this.f784CS), (C0417v) new C0407d(this));
            }
        });
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.mo3257a(new C0406c() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0380n nVar) throws RemoteException {
                nVar.mo3738eT().mo3778a(new ListParentsRequest(C0400r.this.f784CS), (C0417v) new C0405b(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C0380n) apiClient.mo3256a(Drive.f636va)).mo3737b(apiClient, this.f784CS, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.mo3258b(new C0409f() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    nVar.mo3738eT().mo3783a(new UpdateMetadataRequest(C0400r.this.f784CS, changeSet.mo3519eS()), (C0417v) new C0407d(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
