package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.C0766er;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new Creator<RealTimeMessage>() {
        /* renamed from: ap */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        /* renamed from: bc */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;

    /* renamed from: JH */
    private final String f1009JH;

    /* renamed from: JI */
    private final byte[] f1010JI;

    /* renamed from: JJ */
    private final int f1011JJ;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.f1009JH = (String) C0766er.m1977f(senderParticipantId);
        this.f1010JI = (byte[]) ((byte[]) C0766er.m1977f(messageData)).clone();
        this.f1011JJ = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.f1010JI;
    }

    public String getSenderParticipantId() {
        return this.f1009JH;
    }

    public boolean isReliable() {
        return this.f1011JJ == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.f1009JH);
        parcel.writeByteArray(this.f1010JI);
        parcel.writeInt(this.f1011JJ);
    }
}
