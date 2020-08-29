package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CollectionMetadataField;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0426a;
import com.google.android.gms.drive.metadata.internal.C0430e;
import com.google.android.gms.drive.metadata.internal.C0432g;
import com.google.android.gms.drive.metadata.internal.C0434i;
import com.google.android.gms.drive.metadata.internal.C0435j;
import com.google.android.gms.plus.PlusShare;

/* renamed from: com.google.android.gms.internal.fs */
public class C0813fs {

    /* renamed from: EA */
    public static final MetadataField<String> f2308EA = new C0435j("webContentLink", 4300000);

    /* renamed from: EB */
    public static final MetadataField<String> f2309EB = new C0435j("webViewLink", 4300000);

    /* renamed from: EC */
    public static final MetadataField<String> f2310EC = new C0435j("indexableText", 4300000);

    /* renamed from: ED */
    public static final MetadataField<Boolean> f2311ED = new C0426a("hasThumbnail", 4300000);

    /* renamed from: El */
    public static final MetadataField<DriveId> f2312El = C0816fu.f2331EI;

    /* renamed from: Em */
    public static final MetadataField<Boolean> f2313Em = new C0426a("isEditable", 4100000);

    /* renamed from: En */
    public static final MetadataField<Boolean> f2314En = new C0426a("isAppData", 4300000);

    /* renamed from: Eo */
    public static final MetadataField<Boolean> f2315Eo = new C0426a("isShared", 4300000);

    /* renamed from: Ep */
    public static final MetadataField<String> f2316Ep = new C0435j("alternateLink", 4300000);

    /* renamed from: Eq */
    public static final CollectionMetadataField<String> f2317Eq = new C0434i("ownerNames", 4300000);

    /* renamed from: Er */
    public static final MetadataField<String> f2318Er = new C0435j(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);

    /* renamed from: Es */
    public static final MetadataField<Boolean> f2319Es = new C0426a("isCopyable", 4300000);

    /* renamed from: Et */
    public static final MetadataField<String> f2320Et = new C0435j("embedLink", 4300000);

    /* renamed from: Eu */
    public static final MetadataField<String> f2321Eu = new C0435j("fileExtension", 4300000);

    /* renamed from: Ev */
    public static final MetadataField<Long> f2322Ev = new C0430e("fileSize", 4300000);

    /* renamed from: Ew */
    public static final MetadataField<Boolean> f2323Ew = new C0426a("isViewed", 4300000);

    /* renamed from: Ex */
    public static final MetadataField<Boolean> f2324Ex = new C0426a("isRestricted", 4300000);

    /* renamed from: Ey */
    public static final MetadataField<String> f2325Ey = new C0435j("originalFilename", 4300000);

    /* renamed from: Ez */
    public static final MetadataField<Long> f2326Ez = new C0430e("quotaBytesUsed", 4300000);
    public static final MetadataField<Boolean> IS_PINNED = new C0426a("isPinned", 4100000);
    public static final MetadataField<String> MIME_TYPE = new C0435j("mimeType", 4100000);
    public static final CollectionMetadataField<DriveId> PARENTS = new C0432g("parents", 4100000);
    public static final MetadataField<Boolean> STARRED = new C0426a("starred", 4100000);
    public static final MetadataField<String> TITLE = new C0435j("title", 4100000);
    public static final MetadataField<Boolean> TRASHED = new C0426a("trashed", 4100000) {
        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Boolean mo3807b(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.getInteger(getName(), i, i2) != 0);
        }
    };
}
