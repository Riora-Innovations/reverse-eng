package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

/* renamed from: com.google.android.gms.drive.internal.o */
public class C0383o extends C0400r implements DriveFile {

    /* renamed from: com.google.android.gms.drive.internal.o$a */
    private abstract class C0387a extends C0379m<Status> {
        private C0387a() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$b */
    private abstract class C0388b extends C0379m<Status> {
        private C0388b() {
        }

        /* renamed from: f */
        public Status mo3009d(Status status) {
            return status;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$c */
    private static class C0389c extends C0352c {

        /* renamed from: DL */
        private final DownloadProgressListener f769DL;

        /* renamed from: vj */
        private final C0299c<ContentsResult> f770vj;

        public C0389c(C0299c<ContentsResult> cVar, DownloadProgressListener downloadProgressListener) {
            this.f770vj = cVar;
            this.f769DL = downloadProgressListener;
        }

        /* renamed from: a */
        public void mo3684a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.f770vj.mo3311b(new C0367a(Status.f518zQ, onContentsResponse.mo3591eX()));
        }

        /* renamed from: a */
        public void mo3685a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.f769DL != null) {
                this.f769DL.onProgress(onDownloadProgressResponse.mo3594eY(), onDownloadProgressResponse.mo3595eZ());
            }
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f770vj.mo3311b(new C0367a(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.o$d */
    private abstract class C0390d extends C0379m<ContentsResult> {
        private C0390d() {
        }

        /* renamed from: n */
        public ContentsResult mo3009d(Status status) {
            return new C0367a(status, null);
        }
    }

    public C0383o(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents) {
        if (contents != null) {
            return apiClient.mo3258b(new C0388b() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    contents.close();
                    nVar.mo3738eT().mo3772a(new CloseContentsRequest(contents, true), (C0417v) new C0348ak(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents, final MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.mo3258b(new C0387a() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    contents.close();
                    nVar.mo3738eT().mo3771a(new CloseContentsAndUpdateMetadataRequest(C0383o.this.f784CS, changeSet.mo3519eS(), contents), (C0417v) new C0348ak(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, final int mode, final DownloadProgressListener listener) {
        if (mode == 268435456 || mode == 536870912 || mode == 805306368) {
            return apiClient.mo3257a(new C0390d() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    nVar.mo3738eT().mo3779a(new OpenContentsRequest(C0383o.this.getDriveId(), mode), (C0417v) new C0389c(this, listener));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
