package com.google.android.gms.cast;

import com.google.android.gms.internal.C0709dr;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;

    /* renamed from: wP */
    private JSONObject f428wP;

    /* renamed from: wQ */
    private MediaInfo f429wQ;

    /* renamed from: wY */
    private long f430wY;

    /* renamed from: wZ */
    private double f431wZ;

    /* renamed from: xa */
    private int f432xa;

    /* renamed from: xb */
    private int f433xb;

    /* renamed from: xc */
    private long f434xc;

    /* renamed from: xd */
    private long f435xd;

    /* renamed from: xe */
    private double f436xe;

    /* renamed from: xf */
    private boolean f437xf;

    public MediaStatus(JSONObject json) throws JSONException {
        mo3153a(json, 0);
    }

    /* renamed from: a */
    public int mo3153a(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        int i3 = 2;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.f430wY) {
            this.f430wY = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.f432xa) {
                this.f432xa = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                if (!string2.equals("CANCELLED")) {
                    i3 = string2.equals("INTERRUPTED") ? 3 : string2.equals("FINISHED") ? 1 : string2.equals("ERROR") ? 4 : 0;
                }
                if (i3 != this.f433xb) {
                    this.f433xb = i3;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.f431wZ != d) {
                this.f431wZ = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long b = C0709dr.m1724b(jSONObject.getDouble("currentTime"));
            if (b != this.f434xc) {
                this.f434xc = b;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.f435xd) {
                this.f435xd = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.f436xe) {
                this.f436xe = d2;
                i2 |= 2;
            }
            boolean z = jSONObject2.getBoolean("muted");
            if (z != this.f437xf) {
                this.f437xf = z;
                i2 |= 2;
            }
        }
        if (jSONObject.has("customData")) {
            this.f428wP = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (!jSONObject.has("media")) {
            return i2;
        }
        JSONObject jSONObject3 = jSONObject.getJSONObject("media");
        this.f429wQ = new MediaInfo(jSONObject3);
        int i5 = i2 | 2;
        return jSONObject3.has("metadata") ? i5 | 4 : i5;
    }

    /* renamed from: cU */
    public long mo3154cU() {
        return this.f430wY;
    }

    public JSONObject getCustomData() {
        return this.f428wP;
    }

    public int getIdleReason() {
        return this.f433xb;
    }

    public MediaInfo getMediaInfo() {
        return this.f429wQ;
    }

    public double getPlaybackRate() {
        return this.f431wZ;
    }

    public int getPlayerState() {
        return this.f432xa;
    }

    public long getStreamPosition() {
        return this.f434xc;
    }

    public double getStreamVolume() {
        return this.f436xe;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.f435xd & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.f437xf;
    }
}
