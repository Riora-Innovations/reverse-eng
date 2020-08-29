package com.google.android.gms.games.request;

import com.google.android.gms.common.data.C0314d;
import com.google.android.gms.common.data.DataHolder;

public final class GameRequestBuffer extends C0314d<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public GameRequest mo3384c(int rowIndex, int numChildren) {
        return new C0493a(this.f561zU, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_request_id";
    }
}
