package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

/* renamed from: com.google.android.gms.drive.internal.q */
public class C0392q extends C0400r implements DriveFolder {

    /* renamed from: com.google.android.gms.drive.internal.q$a */
    private static class C0395a extends C0352c {

        /* renamed from: vj */
        private final C0299c<DriveFileResult> f777vj;

        public C0395a(C0299c<DriveFileResult> cVar) {
            this.f777vj = cVar;
        }

        /* renamed from: a */
        public void mo3686a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.f777vj.mo3311b(new C0398d(Status.f518zQ, new C0383o(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f777vj.mo3311b(new C0398d(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$b */
    private static class C0396b extends C0352c {

        /* renamed from: vj */
        private final C0299c<DriveFolderResult> f778vj;

        public C0396b(C0299c<DriveFolderResult> cVar) {
            this.f778vj = cVar;
        }

        /* renamed from: a */
        public void mo3686a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.f778vj.mo3311b(new C0399e(Status.f518zQ, new C0392q(onDriveIdResponse.getDriveId())));
        }

        /* renamed from: l */
        public void mo3670l(Status status) throws RemoteException {
            this.f778vj.mo3311b(new C0399e(status, null));
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$c */
    private abstract class C0397c extends C0379m<DriveFolderResult> {
        private C0397c() {
        }

        /* renamed from: q */
        public DriveFolderResult mo3009d(Status status) {
            return new C0399e(status, null);
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$d */
    private static class C0398d implements DriveFileResult {

        /* renamed from: DN */
        private final DriveFile f780DN;

        /* renamed from: vl */
        private final Status f781vl;

        public C0398d(Status status, DriveFile driveFile) {
            this.f781vl = status;
            this.f780DN = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.f780DN;
        }

        public Status getStatus() {
            return this.f781vl;
        }
    }

    /* renamed from: com.google.android.gms.drive.internal.q$e */
    private static class C0399e implements DriveFolderResult {

        /* renamed from: DO */
        private final DriveFolder f782DO;

        /* renamed from: vl */
        private final Status f783vl;

        public C0399e(Status status, DriveFolder driveFolder) {
            this.f783vl = status;
            this.f782DO = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.f782DO;
        }

        public Status getStatus() {
            return this.f783vl;
        }
    }

    public C0392q(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, final MetadataChangeSet changeSet, final Contents contents) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(changeSet.getMimeType())) {
            return apiClient.mo3258b(new C0379m<DriveFileResult>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    contents.close();
                    nVar.mo3738eT().mo3774a(new CreateFileRequest(C0392q.this.getDriveId(), changeSet.mo3519eS(), contents), (C0417v) new C0395a(this));
                }

                /* renamed from: p */
                public DriveFileResult mo3009d(Status status) {
                    return new C0398d(status, null);
                }
            });
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetatadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.mo3258b(new C0397c() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo3004a(C0380n nVar) throws RemoteException {
                    nVar.mo3738eT().mo3775a(new CreateFolderRequest(C0392q.this.getDriveId(), changeSet.mo3519eS()), (C0417v) new C0396b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.m954in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
        }
        return new C0361l().query(apiClient, addFilter.build());
    }
}
