package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.dv */
public class C0716dv extends C0702dp {

    /* renamed from: yi */
    private static final long f1947yi = TimeUnit.HOURS.toMillis(24);

    /* renamed from: yj */
    private static final long f1948yj = TimeUnit.HOURS.toMillis(24);

    /* renamed from: yk */
    private static final long f1949yk = TimeUnit.HOURS.toMillis(24);

    /* renamed from: yl */
    private static final long f1950yl = TimeUnit.SECONDS.toMillis(1);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: ym */
    private long f1951ym;

    /* renamed from: yn */
    private MediaStatus f1952yn;
    /* access modifiers changed from: private */

    /* renamed from: yo */
    public final C0721dy f1953yo = new C0721dy(f1948yj);
    /* access modifiers changed from: private */

    /* renamed from: yp */
    public final C0721dy f1954yp = new C0721dy(f1947yi);
    /* access modifiers changed from: private */

    /* renamed from: yq */
    public final C0721dy f1955yq = new C0721dy(f1947yi);
    /* access modifiers changed from: private */

    /* renamed from: yr */
    public final C0721dy f1956yr = new C0721dy(f1947yi);
    /* access modifiers changed from: private */

    /* renamed from: ys */
    public final C0721dy f1957ys = new C0721dy(f1949yk);
    /* access modifiers changed from: private */

    /* renamed from: yt */
    public final C0721dy f1958yt = new C0721dy(f1947yi);
    /* access modifiers changed from: private */

    /* renamed from: yu */
    public final C0721dy f1959yu = new C0721dy(f1947yi);
    /* access modifiers changed from: private */

    /* renamed from: yv */
    public final C0721dy f1960yv = new C0721dy(f1947yi);

    /* renamed from: yw */
    private final Runnable f1961yw = new C0718a();
    /* access modifiers changed from: private */

    /* renamed from: yx */
    public boolean f1962yx;

    /* renamed from: com.google.android.gms.internal.dv$a */
    private class C0718a implements Runnable {
        private C0718a() {
        }

        public void run() {
            boolean z = false;
            C0716dv.this.f1962yx = false;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C0716dv.this.f1953yo.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1954yp.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1955yq.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1956yr.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1957ys.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1958yt.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1959yu.mo4984d(elapsedRealtime, 3);
            C0716dv.this.f1960yv.mo4984d(elapsedRealtime, 3);
            synchronized (C0721dy.f1965yD) {
                if (C0716dv.this.f1953yo.mo4985dl() || C0716dv.this.f1957ys.mo4985dl() || C0716dv.this.f1958yt.mo4985dl() || C0716dv.this.f1959yu.mo4985dl() || C0716dv.this.f1960yv.mo4985dl()) {
                    z = true;
                }
            }
            C0716dv.this.m1781u(z);
        }
    }

    public C0716dv() {
        super("urn:x-cast:com.google.cast.media", "MediaControlChannel");
        m1776dj();
    }

    /* renamed from: a */
    private void m1770a(long j, JSONObject jSONObject) throws JSONException {
        int i;
        boolean z = true;
        boolean m = this.f1953yo.mo4986m(j);
        boolean z2 = this.f1957ys.mo4985dl() && !this.f1957ys.mo4986m(j);
        if ((!this.f1958yt.mo4985dl() || this.f1958yt.mo4986m(j)) && (!this.f1959yu.mo4985dl() || this.f1959yu.mo4986m(j))) {
            z = false;
        }
        int i2 = z2 ? 2 : 0;
        if (z) {
            i2 |= 1;
        }
        if (m || this.f1952yn == null) {
            this.f1952yn = new MediaStatus(jSONObject);
            this.f1951ym = SystemClock.elapsedRealtime();
            i = 7;
        } else {
            i = this.f1952yn.mo3153a(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.f1951ym = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0) {
            this.f1951ym = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0) {
            onMetadataUpdated();
        }
        this.f1953yo.mo4982c(j, 0);
        this.f1954yp.mo4982c(j, 0);
        this.f1955yq.mo4982c(j, 0);
        this.f1956yr.mo4982c(j, 0);
        this.f1957ys.mo4982c(j, 0);
        this.f1958yt.mo4982c(j, 0);
        this.f1959yu.mo4982c(j, 0);
        this.f1960yv.mo4982c(j, 0);
    }

    /* renamed from: dj */
    private void m1776dj() {
        m1781u(false);
        this.f1951ym = 0;
        this.f1952yn = null;
        this.f1953yo.clear();
        this.f1957ys.clear();
        this.f1958yt.clear();
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public void m1781u(boolean z) {
        if (this.f1962yx != z) {
            this.f1962yx = z;
            if (z) {
                this.mHandler.postDelayed(this.f1961yw, f1950yl);
            } else {
                this.mHandler.removeCallbacks(this.f1961yw);
            }
        }
    }

    /* renamed from: P */
    public final void mo4906P(String str) {
        this.f1903xB.mo4961b("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    m1770a(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.f1952yn = null;
                onStatusUpdated();
                onMetadataUpdated();
                this.f1960yv.mo4982c(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.f1903xB.mo4963d("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                this.f1953yo.mo4981b(optLong, 1, optJSONObject);
                this.f1954yp.mo4981b(optLong, 1, optJSONObject);
                this.f1955yq.mo4981b(optLong, 1, optJSONObject);
                this.f1956yr.mo4981b(optLong, 1, optJSONObject);
                this.f1957ys.mo4981b(optLong, 1, optJSONObject);
                this.f1958yt.mo4981b(optLong, 1, optJSONObject);
                this.f1959yu.mo4981b(optLong, 1, optJSONObject);
                this.f1960yv.mo4981b(optLong, 1, optJSONObject);
            } else if (string.equals("LOAD_FAILED")) {
                this.f1953yo.mo4981b(optLong, 1, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.f1953yo.mo4981b(optLong, 2, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.f1903xB.mo4963d("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                this.f1953yo.mo4981b(optLong, 1, optJSONObject2);
                this.f1954yp.mo4981b(optLong, 1, optJSONObject2);
                this.f1955yq.mo4981b(optLong, 1, optJSONObject2);
                this.f1956yr.mo4981b(optLong, 1, optJSONObject2);
                this.f1957ys.mo4981b(optLong, 1, optJSONObject2);
                this.f1958yt.mo4981b(optLong, 1, optJSONObject2);
                this.f1959yu.mo4981b(optLong, 1, optJSONObject2);
                this.f1960yv.mo4981b(optLong, 1, optJSONObject2);
            }
        } catch (JSONException e) {
            this.f1903xB.mo4963d("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* renamed from: a */
    public long mo4966a(C0720dx dxVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long cW = mo4910cW();
        this.f1960yv.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject.put("requestId", cW);
            jSONObject.put("type", "GET_STATUS");
            if (this.f1952yn != null) {
                jSONObject.put("mediaSessionId", this.f1952yn.mo3154cU());
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject.toString(), cW, null);
        return cW;
    }

    /* renamed from: a */
    public long mo4967a(C0720dx dxVar, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1958yt.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", mo4974cU());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: a */
    public long mo4968a(C0720dx dxVar, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1957ys.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", mo4974cU());
            jSONObject2.put("currentTime", C0709dr.m1725l(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: a */
    public long mo4969a(C0720dx dxVar, MediaInfo mediaInfo, boolean z, long j, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1953yo.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.mo3110cT());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", C0709dr.m1725l(j));
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: a */
    public long mo4970a(C0720dx dxVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1954yp.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", mo4974cU());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: a */
    public long mo4971a(C0720dx dxVar, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1959yu.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", mo4974cU());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: a */
    public void mo4907a(long j, int i) {
        this.f1953yo.mo4982c(j, i);
        this.f1954yp.mo4982c(j, i);
        this.f1955yq.mo4982c(j, i);
        this.f1956yr.mo4982c(j, i);
        this.f1957ys.mo4982c(j, i);
        this.f1958yt.mo4982c(j, i);
        this.f1959yu.mo4982c(j, i);
        this.f1960yv.mo4982c(j, i);
    }

    /* renamed from: b */
    public long mo4972b(C0720dx dxVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1956yr.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", mo4974cU());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: c */
    public long mo4973c(C0720dx dxVar, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long cW = mo4910cW();
        this.f1955yq.mo4980a(cW, dxVar);
        m1781u(true);
        try {
            jSONObject2.put("requestId", cW);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", mo4974cU());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        mo4909a(jSONObject2.toString(), cW, null);
        return cW;
    }

    /* renamed from: cU */
    public long mo4974cU() throws IllegalStateException {
        if (this.f1952yn != null) {
            return this.f1952yn.mo3154cU();
        }
        throw new IllegalStateException("No current media session");
    }

    /* renamed from: cX */
    public void mo4911cX() {
        m1776dj();
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.f1951ym == 0) {
            return 0;
        }
        double playbackRate = this.f1952yn.getPlaybackRate();
        long streamPosition = this.f1952yn.getStreamPosition();
        int playerState = this.f1952yn.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f1951ym;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long j2 = streamPosition + ((long) (((double) j) * playbackRate));
        if (j2 <= streamDuration) {
            streamDuration = j2 < 0 ? 0 : j2;
        }
        return streamDuration;
    }

    public MediaInfo getMediaInfo() {
        if (this.f1952yn == null) {
            return null;
        }
        return this.f1952yn.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.f1952yn;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMetadataUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onStatusUpdated() {
    }
}
