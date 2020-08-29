package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.C0709dr;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0810fp;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;

    /* renamed from: wK */
    private final String f413wK;

    /* renamed from: wL */
    private int f414wL;

    /* renamed from: wM */
    private String f415wM;

    /* renamed from: wN */
    private MediaMetadata f416wN;

    /* renamed from: wO */
    private long f417wO;

    /* renamed from: wP */
    private JSONObject f418wP;

    public static class Builder {

        /* renamed from: wQ */
        private final MediaInfo f419wQ;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.f419wQ = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.f419wQ.mo3109cS();
            return this.f419wQ;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.f419wQ.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.f419wQ.mo3108a(customData);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.f419wQ.mo3107a(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.f419wQ.mo3119j(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.f419wQ.setStreamType(streamType);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.f413wK = contentId;
        this.f414wL = -1;
    }

    MediaInfo(JSONObject json) throws JSONException {
        this.f413wK = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.f414wL = 0;
        } else if ("BUFFERED".equals(string)) {
            this.f414wL = 1;
        } else if ("LIVE".equals(string)) {
            this.f414wL = 2;
        } else {
            this.f414wL = -1;
        }
        this.f415wM = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.f416wN = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.f416wN.mo3129b(jSONObject);
        }
        this.f417wO = C0709dr.m1724b(json.optDouble("duration", 0.0d));
        this.f418wP = json.optJSONObject("customData");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3107a(MediaMetadata mediaMetadata) {
        this.f416wN = mediaMetadata;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo3108a(JSONObject jSONObject) {
        this.f418wP = jSONObject;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: cS */
    public void mo3109cS() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.f413wK)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        } else if (TextUtils.isEmpty(this.f415wM)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        } else if (this.f414wL == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    /* renamed from: cT */
    public JSONObject mo3110cT() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.f413wK);
            switch (this.f414wL) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.f415wM != null) {
                jSONObject.put("contentType", this.f415wM);
            }
            if (this.f416wN != null) {
                jSONObject.put("metadata", this.f416wN.mo3130cT());
            }
            jSONObject.put("duration", C0709dr.m1725l(this.f417wO));
            if (this.f418wP != null) {
                jSONObject.put("customData", this.f418wP);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.f418wP == null) != (mediaInfo.f418wP == null)) {
            return false;
        }
        if (this.f418wP != null && mediaInfo.f418wP != null && !C0810fp.m2118d(this.f418wP, mediaInfo.f418wP)) {
            return false;
        }
        if (!C0709dr.m1723a(this.f413wK, mediaInfo.f413wK) || this.f414wL != mediaInfo.f414wL || !C0709dr.m1723a(this.f415wM, mediaInfo.f415wM) || !C0709dr.m1723a(this.f416wN, mediaInfo.f416wN) || this.f417wO != mediaInfo.f417wO) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.f413wK;
    }

    public String getContentType() {
        return this.f415wM;
    }

    public JSONObject getCustomData() {
        return this.f418wP;
    }

    public MediaMetadata getMetadata() {
        return this.f416wN;
    }

    public long getStreamDuration() {
        return this.f417wO;
    }

    public int getStreamType() {
        return this.f414wL;
    }

    public int hashCode() {
        return C0762ep.hashCode(this.f413wK, Integer.valueOf(this.f414wL), this.f415wM, this.f416wN, Long.valueOf(this.f417wO), String.valueOf(this.f418wP));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo3119j(long j) throws IllegalArgumentException {
        if (j < 0) {
            throw new IllegalArgumentException("Stream duration cannot be negative");
        }
        this.f417wO = j;
    }

    /* access modifiers changed from: 0000 */
    public void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.f415wM = contentType;
    }

    /* access modifiers changed from: 0000 */
    public void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.f414wL = streamType;
    }
}
