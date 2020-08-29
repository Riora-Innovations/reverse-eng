package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0703dq;
import com.google.android.gms.internal.C0716dv;
import com.google.android.gms.internal.C0719dw;
import com.google.android.gms.internal.C0720dx;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    /* access modifiers changed from: private */

    /* renamed from: mg */
    public final Object f438mg = new Object();
    /* access modifiers changed from: private */

    /* renamed from: xg */
    public final C0716dv f439xg = new C0716dv() {
        /* access modifiers changed from: protected */
        public void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        /* access modifiers changed from: protected */
        public void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: xh */
    public final C0284a f440xh = new C0284a();

    /* renamed from: xi */
    private OnMetadataUpdatedListener f441xi;

    /* renamed from: xj */
    private OnStatusUpdatedListener f442xj;

    public interface MediaChannelResult extends Result {
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a */
    private class C0284a implements C0719dw {

        /* renamed from: xu */
        private GoogleApiClient f475xu;

        /* renamed from: xv */
        private long f476xv = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$a$a */
        private final class C0285a implements ResultCallback<Status> {

            /* renamed from: xw */
            private final long f477xw;

            C0285a(long j) {
                this.f477xw = j;
            }

            /* renamed from: i */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    RemoteMediaPlayer.this.f439xg.mo4907a(this.f477xw, status.getStatusCode());
                }
            }
        }

        public C0284a() {
        }

        /* renamed from: a */
        public void mo3201a(String str, String str2, long j, String str3) throws IOException {
            if (this.f475xu == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.f475xu, str, str2).setResultCallback(new C0285a(j));
        }

        /* renamed from: b */
        public void mo3202b(GoogleApiClient googleApiClient) {
            this.f475xu = googleApiClient;
        }

        /* renamed from: cV */
        public long mo3203cV() {
            long j = this.f476xv + 1;
            this.f476xv = j;
            return j;
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$b */
    private static abstract class C0286b extends C0270a<MediaChannelResult> {

        /* renamed from: xy */
        C0720dx f479xy = new C0720dx() {
            /* renamed from: a */
            public void mo3207a(long j, int i, JSONObject jSONObject) {
                C0286b.this.mo3311b(new C0289c(new Status(i), jSONObject));
            }

            /* renamed from: k */
            public void mo3208k(long j) {
                C0286b.this.mo3311b(C0286b.this.mo3009d(new Status(4)));
            }
        };

        C0286b() {
        }

        /* renamed from: j */
        public MediaChannelResult mo3009d(final Status status) {
            return new MediaChannelResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$c */
    private static final class C0289c implements MediaChannelResult {

        /* renamed from: vl */
        private final Status f483vl;

        /* renamed from: wP */
        private final JSONObject f484wP;

        C0289c(Status status, JSONObject jSONObject) {
            this.f483vl = status;
            this.f484wP = jSONObject;
        }

        public Status getStatus() {
            return this.f483vl;
        }
    }

    public RemoteMediaPlayer() {
        this.f439xg.mo4908a(this.f440xh);
    }

    /* access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.f441xi != null) {
            this.f441xi.onMetadataUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.f442xj != null) {
            this.f442xj.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.f438mg) {
            approximateStreamPosition = this.f439xg.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.f438mg) {
            mediaInfo = this.f439xg.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.f438mg) {
            mediaStatus = this.f439xg.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.f439xg.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.f438mg) {
            streamDuration = this.f439xg.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4969a(this.f479xy, mediaInfo2, z, j, jSONObject);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.f439xg.mo4906P(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4970a(this.f479xy, customData);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4973c(this.f479xy, customData);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4966a(this.f479xy);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4968a(this.f479xy, j, i, jSONObject);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.f441xi = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.f442xj = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4971a(this.f479xy, muteState, customData);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IllegalStateException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e2) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4967a(this.f479xy, d, jSONObject);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IllegalStateException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IllegalArgumentException e2) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e3) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
                return;
            }
        });
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo3258b(new C0286b() {
            /* access modifiers changed from: protected */
            /* renamed from: a */
            public void mo3004a(C0703dq dqVar) {
                synchronized (RemoteMediaPlayer.this.f438mg) {
                    RemoteMediaPlayer.this.f440xh.mo3202b(apiClient);
                    try {
                        RemoteMediaPlayer.this.f439xg.mo4972b(this.f479xy, customData);
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (IOException e) {
                        mo3311b(mo3009d(new Status(1)));
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.f440xh.mo3202b(null);
                        throw th;
                    }
                }
            }
        });
    }
}
