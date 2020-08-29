package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.C0813fs;
import com.google.android.gms.internal.C0815ft;
import com.google.android.gms.internal.C0817fv;
import java.util.Date;

public abstract class Metadata implements Freezable<Metadata> {
    public static final int CONTENT_AVAILABLE_LOCALLY = 1;
    public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract <T> T mo3488a(MetadataField<T> metadataField);

    public String getAlternateLink() {
        return (String) mo3488a(C0813fs.f2316Ep);
    }

    public int getContentAvailability() {
        Integer num = (Integer) mo3488a(C0817fv.f2332EJ);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Date getCreatedDate() {
        return (Date) mo3488a(C0815ft.f2329EG);
    }

    public String getDescription() {
        return (String) mo3488a(C0813fs.f2318Er);
    }

    public DriveId getDriveId() {
        return (DriveId) mo3488a(C0813fs.f2312El);
    }

    public String getEmbedLink() {
        return (String) mo3488a(C0813fs.f2320Et);
    }

    public String getFileExtension() {
        return (String) mo3488a(C0813fs.f2321Eu);
    }

    public long getFileSize() {
        return ((Long) mo3488a(C0813fs.f2322Ev)).longValue();
    }

    public Date getLastViewedByMeDate() {
        return (Date) mo3488a(C0815ft.LAST_VIEWED_BY_ME);
    }

    public String getMimeType() {
        return (String) mo3488a(C0813fs.MIME_TYPE);
    }

    public Date getModifiedByMeDate() {
        return (Date) mo3488a(C0815ft.f2328EF);
    }

    public Date getModifiedDate() {
        return (Date) mo3488a(C0815ft.f2327EE);
    }

    public String getOriginalFilename() {
        return (String) mo3488a(C0813fs.f2325Ey);
    }

    public long getQuotaBytesUsed() {
        return ((Long) mo3488a(C0813fs.f2326Ez)).longValue();
    }

    public Date getSharedWithMeDate() {
        return (Date) mo3488a(C0815ft.f2330EH);
    }

    public String getTitle() {
        return (String) mo3488a(C0813fs.TITLE);
    }

    public String getWebContentLink() {
        return (String) mo3488a(C0813fs.f2308EA);
    }

    public String getWebViewLink() {
        return (String) mo3488a(C0813fs.f2309EB);
    }

    public boolean isEditable() {
        Boolean bool = (Boolean) mo3488a(C0813fs.f2313Em);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isFolder() {
        return DriveFolder.MIME_TYPE.equals(getMimeType());
    }

    public boolean isInAppFolder() {
        Boolean bool = (Boolean) mo3488a(C0813fs.f2314En);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isPinnable() {
        Boolean bool = (Boolean) mo3488a(C0817fv.f2333EK);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isPinned() {
        Boolean bool = (Boolean) mo3488a(C0813fs.IS_PINNED);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isRestricted() {
        Boolean bool = (Boolean) mo3488a(C0813fs.f2324Ex);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isShared() {
        Boolean bool = (Boolean) mo3488a(C0813fs.f2315Eo);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isStarred() {
        Boolean bool = (Boolean) mo3488a(C0813fs.STARRED);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isTrashed() {
        Boolean bool = (Boolean) mo3488a(C0813fs.TRASHED);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean isViewed() {
        Boolean bool = (Boolean) mo3488a(C0813fs.f2323Ew);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
