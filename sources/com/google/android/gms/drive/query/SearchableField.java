package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.OrderedMetadataField;
import com.google.android.gms.internal.C0813fs;
import com.google.android.gms.internal.C0815ft;
import java.util.Date;

public class SearchableField {

    /* renamed from: EH */
    public static final OrderedMetadataField<Date> f818EH = C0815ft.f2330EH;
    public static final MetadataField<Boolean> IS_PINNED = C0813fs.IS_PINNED;
    public static final OrderedMetadataField<Date> LAST_VIEWED_BY_ME = C0815ft.LAST_VIEWED_BY_ME;
    public static final MetadataField<String> MIME_TYPE = C0813fs.MIME_TYPE;
    public static final OrderedMetadataField<Date> MODIFIED_DATE = C0815ft.f2327EE;
    public static final CollectionMetadataField<DriveId> PARENTS = C0813fs.PARENTS;
    public static final MetadataField<Boolean> STARRED = C0813fs.STARRED;
    public static final MetadataField<String> TITLE = C0813fs.TITLE;
    public static final MetadataField<Boolean> TRASHED = C0813fs.TRASHED;
}
