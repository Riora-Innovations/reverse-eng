package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0314d;
import com.google.android.gms.common.data.DataHolder;

public final class InvitationBuffer extends C0314d<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: getEntry */
    public Invitation mo3384c(int rowIndex, int numChildren) {
        return new C0482b(this.f561zU, rowIndex, numChildren);
    }

    /* access modifiers changed from: protected */
    public String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
