package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.C0766er;
import com.google.android.gms.internal.C0988gr;

public final class ParticipantResult implements SafeParcelable {
    public static final ParticipantResultCreator CREATOR = new ParticipantResultCreator();
    public static final int MATCH_RESULT_DISAGREED = 5;
    public static final int MATCH_RESULT_DISCONNECT = 4;
    public static final int MATCH_RESULT_LOSS = 1;
    public static final int MATCH_RESULT_NONE = 3;
    public static final int MATCH_RESULT_TIE = 2;
    public static final int MATCH_RESULT_UNINITIALIZED = -1;
    public static final int MATCH_RESULT_WIN = 0;
    public static final int PLACING_UNINITIALIZED = -1;

    /* renamed from: GZ */
    private final String f1001GZ;

    /* renamed from: JF */
    private final int f1002JF;

    /* renamed from: JG */
    private final int f1003JG;

    /* renamed from: wj */
    private final int f1004wj;

    public ParticipantResult(int versionCode, String participantId, int result, int placing) {
        this.f1004wj = versionCode;
        this.f1001GZ = (String) C0766er.m1977f(participantId);
        C0766er.m1978v(C0988gr.isValid(result));
        this.f1002JF = result;
        this.f1003JG = placing;
    }

    public ParticipantResult(String participantId, int result, int placing) {
        this(1, participantId, result, placing);
    }

    public int describeContents() {
        return 0;
    }

    public String getParticipantId() {
        return this.f1001GZ;
    }

    public int getPlacing() {
        return this.f1003JG;
    }

    public int getResult() {
        return this.f1002JF;
    }

    public int getVersionCode() {
        return this.f1004wj;
    }

    public void writeToParcel(Parcel out, int flags) {
        ParticipantResultCreator.m1080a(this, out, flags);
    }
}
