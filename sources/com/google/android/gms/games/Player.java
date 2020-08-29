package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface Player extends Parcelable, Freezable<Player> {
    /* renamed from: fl */
    int mo3993fl();

    String getDisplayName();

    void getDisplayName(CharArrayBuffer charArrayBuffer);

    Uri getHiResImageUri();

    @Deprecated
    String getHiResImageUrl();

    Uri getIconImageUri();

    @Deprecated
    String getIconImageUrl();

    long getLastPlayedWithTimestamp();

    String getPlayerId();

    long getRetrievedTimestamp();

    boolean hasHiResImage();

    boolean hasIconImage();
}
