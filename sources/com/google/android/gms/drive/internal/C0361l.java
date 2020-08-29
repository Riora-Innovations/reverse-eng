package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

/* renamed from: com.google.android.gms.drive.internal.l */
public class C0361l implements DriveApi {

    /* renamed from: com.google.android.gms.drive.internal.l$a */
    static class C0367a implements ContentsResult {

        /* renamed from: CW */
        private final Contents f733CW;

        /* renamed from: vl */
        private final Status f734vl;

        public C0367a(Status status, Contents contents) {
            this.f734vl = status;
            this.f733CW = contents;
        }

        public Contents getContents() {
            return this.f733CW;
        }

        public Status getStatus() {
            return this.f734vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$b */
    private static class C0368b extends C0352c {

        /* renamed from: vj */
        private final C0299c<DriveIdResult> f735vj;

        public C0368b(C0299c<DriveIdResult> cVar) {
            this.f735vj = cVar;
        }

        /* renamed from: a */
        public void mo3689a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.f735vj.mo3311b(new C0369c(Status.f518zQ, new C0359j(onMetadataResponse.mo3612fe()).getDriveId()));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f735vj.mo3311b(new C0369c(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$c */
    static class C0369c implements DriveIdResult {

        /* renamed from: CS */
        private final DriveId f736CS;

        /* renamed from: vl */
        private final Status f737vl;

        public C0369c(Status status, DriveId driveId) {
            this.f737vl = status;
            this.f736CS = driveId;
        }

        public DriveId getDriveId() {
            return this.f736CS;
        }

        public Status getStatus() {
            return this.f737vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$d */
    abstract class C0370d extends C0379m<DriveIdResult> {
        C0370d() {
        }

        /* renamed from: m */
        public DriveIdResult mo3009d(Status status) {
            return new C0369c(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$e */
    static class C0371e implements MetadataBufferResult {

        /* renamed from: Dy */
        private final MetadataBuffer f739Dy;

        /* renamed from: vl */
        private final Status f740vl;

        public C0371e(Status status, MetadataBuffer metadataBuffer) {
            this.f740vl = status;
            this.f739Dy = metadataBuffer;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.f739Dy;
        }

        public Status getStatus() {
            return this.f740vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$f */
    private static class C0372f extends C0352c {

        /* renamed from: vj */
        private final C0299c<ContentsResult> f741vj;

        public C0372f(C0299c<ContentsResult> cVar) {
            this.f741vj = cVar;
        }

        /* renamed from: a */
        public void mo3684a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.f741vj.mo3311b(new C0367a(Status.f518zQ, onContentsResponse.mo3591eX()));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f741vj.mo3311b(new C0367a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$g */
    abstract class C0373g extends C0379m<ContentsResult> {
        C0373g() {
        }

        /* renamed from: n */
        public ContentsResult mo3009d(Status status) {
            return new C0367a(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$h */
    static class C0374h extends C0352c {

        /* renamed from: vj */
        private final C0299c<MetadataBufferResult> f743vj;

        public C0374h(C0299c<MetadataBufferResult> cVar) {
            this.f743vj = cVar;
        }

        /* renamed from: a */
        public void mo3687a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.f743vj.mo3311b(new C0371e(Status.f518zQ, new MetadataBuffer(onListEntriesResponse.mo3606fc(), null)));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f743vj.mo3311b(new C0371e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$i */
    abstract class C0375i extends C0379m<MetadataBufferResult> {
        C0375i() {
        }

        /* renamed from: o */
        public MetadataBufferResult mo3009d(Status status) {
            return new C0371e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$j */
    static abstract class C0376j extends C0379m<Status> {
        C0376j() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$k */
    static class C0377k extends C0376j {
        C0377k(Status status) {
            mo3311b(status);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo3004a(C0380n nVar) {
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.l$l */
    abstract class C0378l extends C0379m<Status> {
        C0378l() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, final Contents contents) {
        return apiClient.mo3258b(new C0376j() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0380n nVar) throws RemoteException {
                nVar.mo3738eT().mo3772a(new CloseContentsRequest(contents, false), (C0417v) new C0348ak(this));
            }
        });
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.mo3257a(new C0370d() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0380n nVar) throws RemoteException {
                nVar.mo3738eT().mo3777a(new GetMetadataRequest(DriveId.m625aq(resourceId)), (C0417v) new C0368b(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (!apiClient.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        }
        DriveId eV = ((C0380n) apiClient.mo3256a(Drive.f636va)).mo3740eV();
        if (eV != null) {
            return new C0392q(eV);
        }
        return null;
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0383o(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C0392q(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C0392q(((C0380n) apiClient.mo3256a(Drive.f636va)).mo3739eU());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.mo3257a(new C0373g() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0380n nVar) throws RemoteException {
                nVar.mo3738eT().mo3773a(new CreateContentsRequest(), (C0417v) new C0372f(this));
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.mo3257a(new C0375i() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    nVar.mo3738eT().mo3780a(new QueryRequest(query), (C0417v) new C0374h(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient client) {
        return client.mo3258b(new C0378l() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0380n nVar) throws RemoteException {
                nVar.mo3738eT().mo3784a((C0417v) new C0348ak(this));
            }
        });
    }
}
