package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.gz */
public final class C0996gz implements SafeParcelable, GameRequest {
    public static final C0998ha CREATOR = new C0998ha();

    /* renamed from: IG */
    private final ArrayList<GameRequestEntity> f2637IG;

    /* renamed from: wj */
    private final int f2638wj;

    C0996gz(int i, ArrayList<GameRequestEntity> arrayList) {
        this.f2638wj = i;
        this.f2637IG = arrayList;
        m2924fR();
    }

    /* renamed from: fR */
    private void m2924fR() {
        C0731ed.m1826v(!this.f2637IG.isEmpty());
        GameRequest gameRequest = (GameRequest) this.f2637IG.get(0);
        int size = this.f2637IG.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.f2637IG.get(i);
            C0731ed.m1822a(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            C0731ed.m1822a(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0996gz)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        C0996gz gzVar = (C0996gz) obj;
        if (gzVar.f2637IG.size() != this.f2637IG.size()) {
            return false;
        }
        int size = this.f2637IG.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.f2637IG.get(i)).equals((GameRequest) gzVar.f2637IG.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: fT */
    public ArrayList<GameRequest> mo5627fT() {
        return new ArrayList<>(this.f2637IG);
    }

    /* renamed from: fU */
    public ArrayList<Player> mo4383fU() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Player getRecipient() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.f2637IG.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.f2637IG.get(0)).getSender();
    }

    public int getType() {
        return ((GameRequestEntity) this.f2637IG.get(0)).getType();
    }

    public int getVersionCode() {
        return this.f2638wj;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f2637IG.toArray());
    }

    public boolean isConsumed() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0998ha.m2931a(this, dest, flags);
    }
}
