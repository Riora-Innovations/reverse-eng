package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.C0433h;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.fu */
public class C0816fu extends C0433h<DriveId> {

    /* renamed from: EI */
    public static final C0816fu f2331EI = new C0816fu();

    private C0816fu() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId"}), 4100000);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public DriveId mo3807b(DataHolder dataHolder, int i, int i2) {
        long j = dataHolder.getMetadata().getLong("dbInstanceId");
        String string = dataHolder.getString("resourceId", i, i2);
        if (string != null && string.startsWith("generated-android-")) {
            string = null;
        }
        return new DriveId(string, Long.valueOf(dataHolder.getLong("sqlId", i, i2)).longValue(), j);
    }
}
