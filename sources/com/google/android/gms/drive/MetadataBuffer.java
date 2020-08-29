package com.google.android.gms.drive;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.C0428c;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public final class MetadataBuffer extends DataBuffer<Metadata> {

    /* renamed from: Dg */
    private static final String[] f642Dg;

    /* renamed from: Dh */
    private final String f643Dh;

    /* renamed from: com.google.android.gms.drive.MetadataBuffer$a */
    private static class C0328a extends Metadata {

        /* renamed from: Di */
        private final int f644Di;

        /* renamed from: zU */
        private final DataHolder f645zU;

        /* renamed from: zX */
        private final int f646zX;

        public C0328a(DataHolder dataHolder, int i) {
            this.f645zU = dataHolder;
            this.f644Di = i;
            this.f646zX = dataHolder.mo3333I(i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public <T> T mo3488a(MetadataField<T> metadataField) {
            return metadataField.mo3811c(this.f645zU, this.f644Di, this.f646zX);
        }

        /* renamed from: eQ */
        public Metadata freeze() {
            MetadataBundle fh = MetadataBundle.m898fh();
            for (MetadataField a : C0428c.m916fg()) {
                a.mo3809a(this.f645zU, fh, this.f644Di, this.f646zX);
            }
            return new C0331b(fh);
        }

        public boolean isDataValid() {
            return !this.f645zU.isClosed();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        for (MetadataField ff : C0428c.m916fg()) {
            arrayList.addAll(ff.mo3814ff());
        }
        f642Dg = (String[]) arrayList.toArray(new String[0]);
    }

    public MetadataBuffer(DataHolder dataHolder, String nextPageToken) {
        super(dataHolder);
        this.f643Dh = nextPageToken;
    }

    public Metadata get(int row) {
        return new C0328a(this.f561zU, row);
    }

    public String getNextPageToken() {
        return this.f643Dh;
    }
}
