package com.google.android.gms.internal;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.android.gms.tagmanager.DataLayer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.bs */
public final class C0588bs extends FrameLayout implements OnCompletionListener, OnErrorListener, OnPreparedListener {

    /* renamed from: nB */
    private final MediaController f1546nB;

    /* renamed from: nC */
    private final C0589a f1547nC = new C0589a(this);

    /* renamed from: nD */
    private final VideoView f1548nD;

    /* renamed from: nE */
    private long f1549nE;

    /* renamed from: nF */
    private String f1550nF;

    /* renamed from: ng */
    private final C0665dd f1551ng;

    /* renamed from: com.google.android.gms.internal.bs$a */
    private static final class C0589a {

        /* renamed from: kW */
        private final Runnable f1552kW;
        /* access modifiers changed from: private */

        /* renamed from: nG */
        public volatile boolean f1553nG = false;

        public C0589a(final C0588bs bsVar) {
            this.f1552kW = new Runnable() {

                /* renamed from: nH */
                private final WeakReference<C0588bs> f1554nH = new WeakReference<>(bsVar);

                public void run() {
                    C0588bs bsVar = (C0588bs) this.f1554nH.get();
                    if (!C0589a.this.f1553nG && bsVar != null) {
                        bsVar.mo4669az();
                        C0589a.this.mo4680aA();
                    }
                }
            };
        }

        /* renamed from: aA */
        public void mo4680aA() {
            C0659cz.f1785pT.postDelayed(this.f1552kW, 250);
        }

        public void cancel() {
            this.f1553nG = true;
            C0659cz.f1785pT.removeCallbacks(this.f1552kW);
        }
    }

    public C0588bs(Context context, C0665dd ddVar) {
        super(context);
        this.f1551ng = ddVar;
        this.f1548nD = new VideoView(context);
        addView(this.f1548nD, new LayoutParams(-1, -1, 17));
        this.f1546nB = new MediaController(context);
        this.f1547nC.mo4680aA();
        this.f1548nD.setOnCompletionListener(this);
        this.f1548nD.setOnPreparedListener(this);
        this.f1548nD.setOnErrorListener(this);
    }

    /* renamed from: a */
    private static void m1313a(C0665dd ddVar, String str) {
        m1316a(ddVar, str, (Map<String, String>) new HashMap<String,String>(1));
    }

    /* renamed from: a */
    public static void m1314a(C0665dd ddVar, String str, String str2) {
        boolean z = str2 == null;
        HashMap hashMap = new HashMap(z ? 2 : 3);
        hashMap.put("what", str);
        if (!z) {
            hashMap.put("extra", str2);
        }
        m1316a(ddVar, "error", (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static void m1315a(C0665dd ddVar, String str, String str2, String str3) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(str2, str3);
        m1316a(ddVar, str, (Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private static void m1316a(C0665dd ddVar, String str, Map<String, String> map) {
        map.put(DataLayer.EVENT_KEY, str);
        ddVar.mo4808a("onVideoEvent", map);
    }

    /* renamed from: ay */
    public void mo4668ay() {
        if (!TextUtils.isEmpty(this.f1550nF)) {
            this.f1548nD.setVideoPath(this.f1550nF);
        } else {
            m1314a(this.f1551ng, "no_src", (String) null);
        }
    }

    /* renamed from: az */
    public void mo4669az() {
        long currentPosition = (long) this.f1548nD.getCurrentPosition();
        if (this.f1549nE != currentPosition) {
            m1315a(this.f1551ng, "timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.f1549nE = currentPosition;
        }
    }

    /* renamed from: b */
    public void mo4670b(MotionEvent motionEvent) {
        this.f1548nD.dispatchTouchEvent(motionEvent);
    }

    public void destroy() {
        this.f1547nC.cancel();
        this.f1548nD.stopPlayback();
    }

    /* renamed from: i */
    public void mo4672i(boolean z) {
        if (z) {
            this.f1548nD.setMediaController(this.f1546nB);
            return;
        }
        this.f1546nB.hide();
        this.f1548nD.setMediaController(null);
    }

    /* renamed from: o */
    public void mo4673o(String str) {
        this.f1550nF = str;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m1313a(this.f1551ng, "ended");
    }

    public boolean onError(MediaPlayer mediaPlayer, int what, int extra) {
        m1314a(this.f1551ng, String.valueOf(what), String.valueOf(extra));
        return true;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m1315a(this.f1551ng, "canplaythrough", "duration", String.valueOf(((float) this.f1548nD.getDuration()) / 1000.0f));
    }

    public void pause() {
        this.f1548nD.pause();
    }

    public void play() {
        this.f1548nD.start();
    }

    public void seekTo(int timeInMilliseconds) {
        this.f1548nD.seekTo(timeInMilliseconds);
    }
}
