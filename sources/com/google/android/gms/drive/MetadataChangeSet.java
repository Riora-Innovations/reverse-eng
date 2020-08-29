package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.C0813fs;
import com.google.android.gms.internal.C0815ft;
import java.util.Date;

public final class MetadataChangeSet {

    /* renamed from: Dj */
    private final MetadataBundle f647Dj;

    public static class Builder {

        /* renamed from: Dj */
        private final MetadataBundle f648Dj = MetadataBundle.m898fh();

        public MetadataChangeSet build() {
            return new MetadataChangeSet(this.f648Dj);
        }

        public Builder setIndexableText(String text) {
            this.f648Dj.mo3819b(C0813fs.f2310EC, text);
            return this;
        }

        public Builder setLastViewedByMeDate(Date date) {
            this.f648Dj.mo3819b(C0815ft.LAST_VIEWED_BY_ME, date);
            return this;
        }

        public Builder setMimeType(String mimeType) {
            this.f648Dj.mo3819b(C0813fs.MIME_TYPE, mimeType);
            return this;
        }

        public Builder setPinned(boolean pinned) {
            this.f648Dj.mo3819b(C0813fs.IS_PINNED, Boolean.valueOf(pinned));
            return this;
        }

        public Builder setStarred(boolean starred) {
            this.f648Dj.mo3819b(C0813fs.STARRED, Boolean.valueOf(starred));
            return this;
        }

        public Builder setTitle(String title) {
            this.f648Dj.mo3819b(C0813fs.TITLE, title);
            return this;
        }

        public Builder setViewed(boolean viewed) {
            this.f648Dj.mo3819b(C0813fs.f2323Ew, Boolean.valueOf(viewed));
            return this;
        }
    }

    private MetadataChangeSet(MetadataBundle bag) {
        this.f647Dj = MetadataBundle.m897a(bag);
    }

    /* renamed from: eS */
    public MetadataBundle mo3519eS() {
        return this.f647Dj;
    }

    public String getIndexableText() {
        return (String) this.f647Dj.mo3818a(C0813fs.f2310EC);
    }

    public Date getLastViewedByMeDate() {
        return (Date) this.f647Dj.mo3818a((MetadataField<T>) C0815ft.LAST_VIEWED_BY_ME);
    }

    public String getMimeType() {
        return (String) this.f647Dj.mo3818a(C0813fs.MIME_TYPE);
    }

    public String getTitle() {
        return (String) this.f647Dj.mo3818a(C0813fs.TITLE);
    }

    public Boolean isPinned() {
        return (Boolean) this.f647Dj.mo3818a(C0813fs.IS_PINNED);
    }

    public Boolean isStarred() {
        return (Boolean) this.f647Dj.mo3818a(C0813fs.STARRED);
    }

    public Boolean isViewed() {
        return (Boolean) this.f647Dj.mo3818a(C0813fs.f2323Ew);
    }
}
