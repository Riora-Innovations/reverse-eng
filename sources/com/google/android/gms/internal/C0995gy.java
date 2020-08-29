package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.gy */
public final class C0995gy implements SafeParcelable, Invitation {
    public static final C0994gx CREATOR = new C0994gx();

    /* renamed from: IF */
    private final ArrayList<InvitationEntity> f2635IF;

    /* renamed from: wj */
    private final int f2636wj;

    C0995gy(int i, ArrayList<InvitationEntity> arrayList) {
        this.f2636wj = i;
        this.f2635IF = arrayList;
        m2922fR();
    }

    /* renamed from: fR */
    private void m2922fR() {
        C0731ed.m1826v(!this.f2635IF.isEmpty());
        Invitation invitation = (Invitation) this.f2635IF.get(0);
        int size = this.f2635IF.size();
        for (int i = 1; i < size; i++) {
            C0731ed.m1822a(invitation.getInviter().equals(((Invitation) this.f2635IF.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0995gy)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0995gy gyVar = (C0995gy) obj;
        if (gyVar.f2635IF.size() != this.f2635IF.size()) {
            return false;
        }
        int size = this.f2635IF.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.f2635IF.get(i)).equals((Invitation) gyVar.f2635IF.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: fS */
    public ArrayList<Invitation> mo5621fS() {
        return new ArrayList<>(this.f2635IF);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return ((InvitationEntity) this.f2635IF.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity) this.f2635IF.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.f2636wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2635IF.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0994gx.m2919a(this, dest, flags);
    }
}
