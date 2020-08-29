package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0296a.C0299c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.leaderboard.C0472a;
import com.google.android.gms.games.leaderboard.C0475d;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.realtime.C0488a;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.C0736eh.C0740d;
import com.google.android.gms.internal.C0736eh.C0741e;
import com.google.android.gms.internal.C0896gb.C0897a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.fx */
public final class C0819fx extends C0736eh<C0896gb> implements ConnectionCallbacks, OnConnectionFailedListener {

    /* renamed from: GA */
    private boolean f2334GA = false;

    /* renamed from: GB */
    private boolean f2335GB = false;

    /* renamed from: GC */
    private int f2336GC;

    /* renamed from: GD */
    private final Binder f2337GD;

    /* renamed from: GE */
    private final long f2338GE;

    /* renamed from: GF */
    private final boolean f2339GF;

    /* renamed from: GG */
    private final int f2340GG;

    /* renamed from: GH */
    private final boolean f2341GH;

    /* renamed from: Gv */
    private final String f2342Gv;

    /* renamed from: Gw */
    private final Map<String, RealTimeSocket> f2343Gw;

    /* renamed from: Gx */
    private PlayerEntity f2344Gx;

    /* renamed from: Gy */
    private GameEntity f2345Gy;

    /* renamed from: Gz */
    private final C0900gd f2346Gz;

    /* renamed from: vi */
    private final String f2347vi;

    /* renamed from: com.google.android.gms.internal.fx$a */
    abstract class C0820a extends C0866c {

        /* renamed from: GI */
        private final ArrayList<String> f2348GI = new ArrayList<>();

        C0820a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder);
            for (String add : strArr) {
                this.f2348GI.add(add);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5365a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            mo5366a(roomStatusUpdateListener, room, this.f2348GI);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    /* renamed from: com.google.android.gms.internal.fx$aa */
    final class C0821aa extends C0738b<RoomStatusUpdateListener> {

        /* renamed from: GZ */
        private final String f2351GZ;

        C0821aa(RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            super(roomStatusUpdateListener);
            this.f2351GZ = str;
        }

        /* renamed from: a */
        public void mo4885a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PConnected(this.f2351GZ);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ab */
    final class C0822ab extends C0738b<RoomStatusUpdateListener> {

        /* renamed from: GZ */
        private final String f2353GZ;

        C0822ab(RoomStatusUpdateListener roomStatusUpdateListener, String str) {
            super(roomStatusUpdateListener);
            this.f2353GZ = str;
        }

        /* renamed from: a */
        public void mo4885a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener != null) {
                roomStatusUpdateListener.onP2PDisconnected(this.f2353GZ);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ac */
    final class C0823ac extends C0820a {
        C0823ac(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ad */
    final class C0824ad extends C0820a {
        C0824ad(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ae */
    final class C0825ae extends C0820a {
        C0825ae(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$af */
    final class C0826af extends C0820a {
        C0826af(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ag */
    final class C0827ag extends C0820a {
        C0827ag(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ah */
    final class C0828ah extends C0820a {
        C0828ah(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] strArr) {
            super(roomStatusUpdateListener, dataHolder, strArr);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo5366a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ai */
    final class C0829ai extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LoadPlayerScoreResult> f2361vj;

        C0829ai(C0299c<LoadPlayerScoreResult> cVar) {
            this.f2361vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: C */
        public void mo5237C(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0830aj<Object>(this.f2361vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$aj */
    final class C0830aj extends C0740d<C0299c<LoadPlayerScoreResult>> implements LoadPlayerScoreResult {

        /* renamed from: Ha */
        private final C0475d f2363Ha;

        /* renamed from: vl */
        private final Status f2364vl;

        C0830aj(C0299c<LoadPlayerScoreResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2364vl = new Status(dataHolder.getStatusCode());
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.f2363Ha = (C0475d) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.f2363Ha = null;
                }
            } finally {
                leaderboardScoreBuffer.close();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadPlayerScoreResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public LeaderboardScore getScore() {
            return this.f2363Ha;
        }

        public Status getStatus() {
            return this.f2364vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ak */
    final class C0831ak extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LoadPlayersResult> f2366vj;

        C0831ak(C0299c<LoadPlayersResult> cVar) {
            this.f2366vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo5258e(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0832al<Object>(this.f2366vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$al */
    final class C0832al extends C0842av<C0299c<LoadPlayersResult>> implements LoadPlayersResult {

        /* renamed from: Hb */
        private final PlayerBuffer f2368Hb;

        C0832al(C0299c<LoadPlayersResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2368Hb = new PlayerBuffer(dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadPlayersResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public PlayerBuffer getPlayers() {
            return this.f2368Hb;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$am */
    final class C0833am extends C0738b<ReliableMessageSentCallback> {

        /* renamed from: Hc */
        private final String f2370Hc;

        /* renamed from: Hd */
        private final int f2371Hd;

        /* renamed from: yJ */
        private final int f2372yJ;

        C0833am(ReliableMessageSentCallback reliableMessageSentCallback, int i, int i2, String str) {
            super(reliableMessageSentCallback);
            this.f2372yJ = i;
            this.f2371Hd = i2;
            this.f2370Hc = str;
        }

        /* renamed from: a */
        public void mo4885a(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.f2372yJ, this.f2371Hd, this.f2370Hc);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$an */
    final class C0834an extends C0818fw {

        /* renamed from: He */
        final ReliableMessageSentCallback f2374He;

        public C0834an(ReliableMessageSentCallback reliableMessageSentCallback) {
            this.f2374He = reliableMessageSentCallback;
        }

        /* renamed from: b */
        public void mo5247b(int i, int i2, String str) {
            C0819fx.this.mo5036a((C0738b<?>) new C0833am<Object>(this.f2374He, i, i2, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ao */
    final class C0835ao extends C0818fw {

        /* renamed from: Hf */
        private final OnRequestReceivedListener f2376Hf;

        C0835ao(OnRequestReceivedListener onRequestReceivedListener) {
            this.f2376Hf = onRequestReceivedListener;
        }

        /* renamed from: m */
        public void mo5269m(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                if (gameRequest != null) {
                    C0819fx.this.mo5036a((C0738b<?>) new C0836ap<Object>(this.f2376Hf, gameRequest));
                }
            } finally {
                gameRequestBuffer.close();
            }
        }

        public void onRequestRemoved(String requestId) {
            C0819fx.this.mo5036a((C0738b<?>) new C0837aq<Object>(this.f2376Hf, requestId));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ap */
    final class C0836ap extends C0738b<OnRequestReceivedListener> {

        /* renamed from: Hg */
        private final GameRequest f2378Hg;

        C0836ap(OnRequestReceivedListener onRequestReceivedListener, GameRequest gameRequest) {
            super(onRequestReceivedListener);
            this.f2378Hg = gameRequest;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.f2378Hg);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$aq */
    final class C0837aq extends C0738b<OnRequestReceivedListener> {

        /* renamed from: Hh */
        private final String f2380Hh;

        C0837aq(OnRequestReceivedListener onRequestReceivedListener, String str) {
            super(onRequestReceivedListener);
            this.f2380Hh = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.f2380Hh);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ar */
    final class C0838ar extends C0818fw {

        /* renamed from: Hi */
        private final C0299c<LoadRequestsResult> f2382Hi;

        public C0838ar(C0299c<LoadRequestsResult> cVar) {
            this.f2382Hi = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: b */
        public void mo5248b(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            C0819fx.this.mo5036a((C0738b<?>) new C0839as<Object>(this.f2382Hi, new Status(i), bundle));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$as */
    final class C0839as extends C0738b<C0299c<LoadRequestsResult>> implements LoadRequestsResult {

        /* renamed from: Hj */
        private final Bundle f2384Hj;

        /* renamed from: vl */
        private final Status f2385vl;

        C0839as(C0299c<LoadRequestsResult> cVar, Status status, Bundle bundle) {
            super(cVar);
            this.f2385vl = status;
            this.f2384Hj = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<LoadRequestsResult> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
            release();
        }

        public GameRequestBuffer getRequests(int requestType) {
            String aW = C0989gs.m2916aW(requestType);
            if (!this.f2384Hj.containsKey(aW)) {
                return null;
            }
            return new GameRequestBuffer((DataHolder) this.f2384Hj.get(aW));
        }

        public Status getStatus() {
            return this.f2385vl;
        }

        public void release() {
            for (String parcelable : this.f2384Hj.keySet()) {
                DataHolder dataHolder = (DataHolder) this.f2384Hj.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$at */
    final class C0840at extends C0818fw {

        /* renamed from: Hk */
        private final C0299c<UpdateRequestsResult> f2387Hk;

        public C0840at(C0299c<UpdateRequestsResult> cVar) {
            this.f2387Hk = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: D */
        public void mo5238D(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0841au<Object>(this.f2387Hk, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$au */
    final class C0841au extends C0842av<C0299c<UpdateRequestsResult>> implements UpdateRequestsResult {

        /* renamed from: Hl */
        private final C0999hb f2389Hl;

        C0841au(C0299c<UpdateRequestsResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2389Hl = C0999hb.m2934H(dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<UpdateRequestsResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public Set<String> getRequestIds() {
            return this.f2389Hl.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.f2389Hl.getRequestOutcome(requestId);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$av */
    abstract class C0842av<R extends C0299c<?>> extends C0740d<R> implements Releasable, Result {

        /* renamed from: vl */
        final Status f2391vl;

        /* renamed from: zU */
        final DataHolder f2392zU;

        public C0842av(R r, DataHolder dataHolder) {
            super(r, dataHolder);
            this.f2391vl = new Status(dataHolder.getStatusCode());
            this.f2392zU = dataHolder;
        }

        public Status getStatus() {
            return this.f2391vl;
        }

        public void release() {
            if (this.f2392zU != null) {
                this.f2392zU.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$aw */
    final class C0843aw extends C0866c {
        C0843aw(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5365a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ax */
    final class C0844ax extends C0818fw {

        /* renamed from: Hm */
        private final RoomUpdateListener f2395Hm;

        /* renamed from: Hn */
        private final RoomStatusUpdateListener f2396Hn;

        /* renamed from: Ho */
        private final RealTimeMessageReceivedListener f2397Ho;

        public C0844ax(RoomUpdateListener roomUpdateListener) {
            this.f2395Hm = (RoomUpdateListener) C0766er.m1975b(roomUpdateListener, (Object) "Callbacks must not be null");
            this.f2396Hn = null;
            this.f2397Ho = null;
        }

        public C0844ax(RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.f2395Hm = (RoomUpdateListener) C0766er.m1975b(roomUpdateListener, (Object) "Callbacks must not be null");
            this.f2396Hn = roomStatusUpdateListener;
            this.f2397Ho = realTimeMessageReceivedListener;
        }

        /* renamed from: a */
        public void mo5244a(DataHolder dataHolder, String[] strArr) {
            C0819fx.this.mo5036a((C0738b<?>) new C0826af<Object>(this.f2396Hn, dataHolder, strArr));
        }

        /* renamed from: b */
        public void mo5250b(DataHolder dataHolder, String[] strArr) {
            C0819fx.this.mo5036a((C0738b<?>) new C0827ag<Object>(this.f2396Hn, dataHolder, strArr));
        }

        /* renamed from: c */
        public void mo5252c(DataHolder dataHolder, String[] strArr) {
            C0819fx.this.mo5036a((C0738b<?>) new C0828ah<Object>(this.f2396Hn, dataHolder, strArr));
        }

        /* renamed from: d */
        public void mo5256d(DataHolder dataHolder, String[] strArr) {
            C0819fx.this.mo5036a((C0738b<?>) new C0824ad<Object>(this.f2396Hn, dataHolder, strArr));
        }

        /* renamed from: e */
        public void mo5259e(DataHolder dataHolder, String[] strArr) {
            C0819fx.this.mo5036a((C0738b<?>) new C0823ac<Object>(this.f2396Hn, dataHolder, strArr));
        }

        /* renamed from: f */
        public void mo5262f(DataHolder dataHolder, String[] strArr) {
            C0819fx.this.mo5036a((C0738b<?>) new C0825ae<Object>(this.f2396Hn, dataHolder, strArr));
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            C0819fx.this.mo5036a((C0738b<?>) new C0885v<Object>(this.f2395Hm, statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            C0819fx.this.mo5036a((C0738b<?>) new C0821aa<Object>(this.f2396Hn, participantId));
        }

        public void onP2PDisconnected(String participantId) {
            C0819fx.this.mo5036a((C0738b<?>) new C0822ab<Object>(this.f2396Hn, participantId));
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            C0819fx.this.mo5036a((C0738b<?>) new C0889z<Object>(this.f2397Ho, message));
        }

        /* renamed from: s */
        public void mo5282s(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0848ba<Object>(this.f2395Hm, dataHolder));
        }

        /* renamed from: t */
        public void mo5283t(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0880q<Object>(this.f2395Hm, dataHolder));
        }

        /* renamed from: u */
        public void mo5284u(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0846az<Object>(this.f2396Hn, dataHolder));
        }

        /* renamed from: v */
        public void mo5285v(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0843aw<Object>(this.f2396Hn, dataHolder));
        }

        /* renamed from: w */
        public void mo5286w(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0845ay<Object>(this.f2395Hm, dataHolder));
        }

        /* renamed from: x */
        public void mo5287x(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0871h<Object>(this.f2396Hn, dataHolder));
        }

        /* renamed from: y */
        public void mo5288y(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0872i<Object>(this.f2396Hn, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$ay */
    final class C0845ay extends C0847b {
        C0845ay(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5376a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$az */
    final class C0846az extends C0866c {
        C0846az(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5365a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$b */
    abstract class C0847b extends C0740d<RoomUpdateListener> {
        C0847b(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            mo5376a(roomUpdateListener, C0819fx.this.m2179G(dataHolder), dataHolder.getStatusCode());
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5376a(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    /* renamed from: com.google.android.gms.internal.fx$ba */
    final class C0848ba extends C0847b {
        public C0848ba(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5376a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bb */
    final class C0849bb extends C0818fw {

        /* renamed from: vj */
        private final C0299c<Status> f2403vj;

        public C0849bb(C0299c<Status> cVar) {
            this.f2403vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: cM */
        public void mo5253cM() {
            C0819fx.this.mo5036a((C0738b<?>) new C0850bc<Object>(this.f2403vj, new Status(0)));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bc */
    final class C0850bc extends C0738b<C0299c<Status>> {

        /* renamed from: vl */
        private final Status f2405vl;

        public C0850bc(C0299c<Status> cVar, Status status) {
            super(cVar);
            this.f2405vl = status;
        }

        /* renamed from: c */
        public void mo4885a(C0299c<Status> cVar) {
            cVar.mo3311b(this.f2405vl);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bd */
    final class C0851bd extends C0818fw {

        /* renamed from: vj */
        private final C0299c<SubmitScoreResult> f2407vj;

        public C0851bd(C0299c<SubmitScoreResult> cVar) {
            this.f2407vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: d */
        public void mo5255d(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0852be<Object>(this.f2407vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$be */
    final class C0852be extends C0842av<C0299c<SubmitScoreResult>> implements SubmitScoreResult {

        /* renamed from: Hp */
        private final ScoreSubmissionData f2409Hp;

        public C0852be(C0299c<SubmitScoreResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            try {
                this.f2409Hp = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        /* renamed from: a */
        public void mo4889a(C0299c<SubmitScoreResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public ScoreSubmissionData getScoreData() {
            return this.f2409Hp;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bf */
    abstract class C0853bf<T extends C0299c<?>> extends C0842av<T> {

        /* renamed from: GX */
        final TurnBasedMatch f2411GX;

        C0853bf(T t, DataHolder dataHolder) {
            super(t, dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.f2411GX = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.f2411GX = null;
                }
            } finally {
                turnBasedMatchBuffer.close();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(T t, DataHolder dataHolder) {
            mo5382h(t);
        }

        public TurnBasedMatch getMatch() {
            return this.f2411GX;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: h */
        public abstract void mo5382h(T t);
    }

    /* renamed from: com.google.android.gms.internal.fx$bg */
    final class C0854bg extends C0818fw {

        /* renamed from: Hq */
        private final C0299c<CancelMatchResult> f2413Hq;

        public C0854bg(C0299c<CancelMatchResult> cVar) {
            this.f2413Hq = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: f */
        public void mo5260f(int i, String str) {
            C0819fx.this.mo5036a((C0738b<?>) new C0855bh<Object>(this.f2413Hq, new Status(i), str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bh */
    final class C0855bh extends C0738b<C0299c<CancelMatchResult>> implements CancelMatchResult {

        /* renamed from: Hr */
        private final String f2415Hr;

        /* renamed from: vl */
        private final Status f2416vl;

        C0855bh(C0299c<CancelMatchResult> cVar, Status status, String str) {
            super(cVar);
            this.f2416vl = status;
            this.f2415Hr = str;
        }

        /* renamed from: c */
        public void mo4885a(C0299c<CancelMatchResult> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }

        public String getMatchId() {
            return this.f2415Hr;
        }

        public Status getStatus() {
            return this.f2416vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bi */
    final class C0856bi extends C0818fw {

        /* renamed from: Hs */
        private final C0299c<InitiateMatchResult> f2418Hs;

        public C0856bi(C0299c<InitiateMatchResult> cVar) {
            this.f2418Hs = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: o */
        public void mo5271o(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0857bj<Object>(this.f2418Hs, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bj */
    final class C0857bj extends C0853bf<C0299c<InitiateMatchResult>> implements InitiateMatchResult {
        C0857bj(C0299c<InitiateMatchResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo5382h(C0299c<InitiateMatchResult> cVar) {
            cVar.mo3311b(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bk */
    final class C0858bk extends C0818fw {

        /* renamed from: Ht */
        private final C0299c<LeaveMatchResult> f2421Ht;

        public C0858bk(C0299c<LeaveMatchResult> cVar) {
            this.f2421Ht = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: q */
        public void mo5280q(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0859bl<Object>(this.f2421Ht, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bl */
    final class C0859bl extends C0853bf<C0299c<LeaveMatchResult>> implements LeaveMatchResult {
        C0859bl(C0299c<LeaveMatchResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo5382h(C0299c<LeaveMatchResult> cVar) {
            cVar.mo3311b(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bm */
    final class C0860bm extends C0818fw {

        /* renamed from: Hu */
        private final C0299c<LoadMatchResult> f2424Hu;

        public C0860bm(C0299c<LoadMatchResult> cVar) {
            this.f2424Hu = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: n */
        public void mo5270n(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0861bn<Object>(this.f2424Hu, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bn */
    final class C0861bn extends C0853bf<C0299c<LoadMatchResult>> implements LoadMatchResult {
        C0861bn(C0299c<LoadMatchResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo5382h(C0299c<LoadMatchResult> cVar) {
            cVar.mo3311b(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bo */
    final class C0862bo extends C0818fw {

        /* renamed from: Hv */
        private final C0299c<UpdateMatchResult> f2427Hv;

        public C0862bo(C0299c<UpdateMatchResult> cVar) {
            this.f2427Hv = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: p */
        public void mo5279p(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0863bp<Object>(this.f2427Hv, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bp */
    final class C0863bp extends C0853bf<C0299c<UpdateMatchResult>> implements UpdateMatchResult {
        C0863bp(C0299c<UpdateMatchResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo5382h(C0299c<UpdateMatchResult> cVar) {
            cVar.mo3311b(this);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$bq */
    final class C0864bq extends C0818fw {

        /* renamed from: Hw */
        private final C0299c<LoadMatchesResult> f2430Hw;

        public C0864bq(C0299c<LoadMatchesResult> cVar) {
            this.f2430Hw = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo5241a(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            C0819fx.this.mo5036a((C0738b<?>) new C0865br<Object>(this.f2430Hw, new Status(i), bundle));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$br */
    final class C0865br extends C0738b<C0299c<LoadMatchesResult>> implements LoadMatchesResult {

        /* renamed from: Hx */
        private final LoadMatchesResponse f2432Hx;

        /* renamed from: vl */
        private final Status f2433vl;

        C0865br(C0299c<LoadMatchesResult> cVar, Status status, Bundle bundle) {
            super(cVar);
            this.f2433vl = status;
            this.f2432Hx = new LoadMatchesResponse(bundle);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<LoadMatchesResult> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }

        public LoadMatchesResponse getMatches() {
            return this.f2432Hx;
        }

        public Status getStatus() {
            return this.f2433vl;
        }

        public void release() {
            this.f2432Hx.close();
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$c */
    abstract class C0866c extends C0740d<RoomStatusUpdateListener> {
        C0866c(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            mo5365a(roomStatusUpdateListener, C0819fx.this.m2179G(dataHolder));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo5365a(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    /* renamed from: com.google.android.gms.internal.fx$d */
    final class C0867d extends C0818fw {

        /* renamed from: vj */
        private final C0299c<UpdateAchievementResult> f2436vj;

        C0867d(C0299c<UpdateAchievementResult> cVar) {
            this.f2436vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: e */
        public void mo5257e(int i, String str) {
            C0819fx.this.mo5036a((C0738b<?>) new C0868e<Object>(this.f2436vj, i, str));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$e */
    final class C0868e extends C0738b<C0299c<UpdateAchievementResult>> implements UpdateAchievementResult {

        /* renamed from: GK */
        private final String f2438GK;

        /* renamed from: vl */
        private final Status f2439vl;

        C0868e(C0299c<UpdateAchievementResult> cVar, int i, String str) {
            super(cVar);
            this.f2439vl = new Status(i);
            this.f2438GK = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void mo4885a(C0299c<UpdateAchievementResult> cVar) {
            cVar.mo3311b(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }

        public String getAchievementId() {
            return this.f2438GK;
        }

        public Status getStatus() {
            return this.f2439vl;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$f */
    final class C0869f extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LoadAchievementsResult> f2441vj;

        C0869f(C0299c<LoadAchievementsResult> cVar) {
            this.f2441vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: b */
        public void mo5249b(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0870g<Object>(this.f2441vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$g */
    final class C0870g extends C0842av<C0299c<LoadAchievementsResult>> implements LoadAchievementsResult {

        /* renamed from: GL */
        private final AchievementBuffer f2443GL;

        C0870g(C0299c<LoadAchievementsResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2443GL = new AchievementBuffer(dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadAchievementsResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public AchievementBuffer getAchievements() {
            return this.f2443GL;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$h */
    final class C0871h extends C0866c {
        C0871h(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5365a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$i */
    final class C0872i extends C0866c {
        C0872i(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5365a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$j */
    final class C0873j extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LoadGamesResult> f2447vj;

        C0873j(C0299c<LoadGamesResult> cVar) {
            this.f2447vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: g */
        public void mo5263g(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0874k<Object>(this.f2447vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$k */
    final class C0874k extends C0842av<C0299c<LoadGamesResult>> implements LoadGamesResult {

        /* renamed from: GM */
        private final GameBuffer f2449GM;

        C0874k(C0299c<LoadGamesResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2449GM = new GameBuffer(dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadGamesResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public GameBuffer getGames() {
            return this.f2449GM;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$l */
    final class C0875l extends C0818fw {

        /* renamed from: GN */
        private final OnInvitationReceivedListener f2451GN;

        C0875l(OnInvitationReceivedListener onInvitationReceivedListener) {
            this.f2451GN = onInvitationReceivedListener;
        }

        /* renamed from: l */
        public void mo5268l(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                if (invitation != null) {
                    C0819fx.this.mo5036a((C0738b<?>) new C0876m<Object>(this.f2451GN, invitation));
                }
            } finally {
                invitationBuffer.close();
            }
        }

        public void onInvitationRemoved(String invitationId) {
            C0819fx.this.mo5036a((C0738b<?>) new C0877n<Object>(this.f2451GN, invitationId));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$m */
    final class C0876m extends C0738b<OnInvitationReceivedListener> {

        /* renamed from: GO */
        private final Invitation f2453GO;

        C0876m(OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            super(onInvitationReceivedListener);
            this.f2453GO = invitation;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.f2453GO);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$n */
    final class C0877n extends C0738b<OnInvitationReceivedListener> {

        /* renamed from: GP */
        private final String f2455GP;

        C0877n(OnInvitationReceivedListener onInvitationReceivedListener, String str) {
            super(onInvitationReceivedListener);
            this.f2455GP = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.f2455GP);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$o */
    final class C0878o extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LoadInvitationsResult> f2457vj;

        C0878o(C0299c<LoadInvitationsResult> cVar) {
            this.f2457vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: k */
        public void mo5267k(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0879p<Object>(this.f2457vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$p */
    final class C0879p extends C0842av<C0299c<LoadInvitationsResult>> implements LoadInvitationsResult {

        /* renamed from: GQ */
        private final InvitationBuffer f2459GQ;

        C0879p(C0299c<LoadInvitationsResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2459GQ = new InvitationBuffer(dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadInvitationsResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public InvitationBuffer getInvitations() {
            return this.f2459GQ;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$q */
    final class C0880q extends C0847b {
        public C0880q(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        /* renamed from: a */
        public void mo5376a(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$r */
    final class C0881r extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LoadScoresResult> f2462vj;

        C0881r(C0299c<LoadScoresResult> cVar) {
            this.f2462vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: a */
        public void mo5243a(DataHolder dataHolder, DataHolder dataHolder2) {
            C0819fx.this.mo5036a((C0738b<?>) new C0882s<Object>(this.f2462vj, dataHolder, dataHolder2));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$s */
    final class C0882s extends C0842av<C0299c<LoadScoresResult>> implements LoadScoresResult {

        /* renamed from: GR */
        private final C0472a f2464GR;

        /* renamed from: GS */
        private final LeaderboardScoreBuffer f2465GS;

        /* JADX INFO: finally extract failed */
        C0882s(C0299c<LoadScoresResult> cVar, DataHolder dataHolder, DataHolder dataHolder2) {
            super(cVar, dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.f2464GR = (C0472a) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.f2464GR = null;
                }
                leaderboardBuffer.close();
                this.f2465GS = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.close();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LoadScoresResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public Leaderboard getLeaderboard() {
            return this.f2464GR;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.f2465GS;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$t */
    final class C0883t extends C0818fw {

        /* renamed from: vj */
        private final C0299c<LeaderboardMetadataResult> f2467vj;

        C0883t(C0299c<LeaderboardMetadataResult> cVar) {
            this.f2467vj = (C0299c) C0766er.m1975b(cVar, (Object) "Holder must not be null");
        }

        /* renamed from: c */
        public void mo5251c(DataHolder dataHolder) {
            C0819fx.this.mo5036a((C0738b<?>) new C0884u<Object>(this.f2467vj, dataHolder));
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$u */
    final class C0884u extends C0842av<C0299c<LeaderboardMetadataResult>> implements LeaderboardMetadataResult {

        /* renamed from: GT */
        private final LeaderboardBuffer f2469GT;

        C0884u(C0299c<LeaderboardMetadataResult> cVar, DataHolder dataHolder) {
            super(cVar, dataHolder);
            this.f2469GT = new LeaderboardBuffer(dataHolder);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo4889a(C0299c<LeaderboardMetadataResult> cVar, DataHolder dataHolder) {
            cVar.mo3311b(this);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.f2469GT;
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$v */
    final class C0885v extends C0738b<RoomUpdateListener> {

        /* renamed from: GU */
        private final String f2471GU;

        /* renamed from: yJ */
        private final int f2472yJ;

        C0885v(RoomUpdateListener roomUpdateListener, int i, String str) {
            super(roomUpdateListener);
            this.f2472yJ = i;
            this.f2471GU = str;
        }

        /* renamed from: a */
        public void mo4885a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.f2472yJ, this.f2471GU);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$w */
    final class C0886w extends C0738b<OnTurnBasedMatchUpdateReceivedListener> {

        /* renamed from: GV */
        private final String f2474GV;

        C0886w(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, String str) {
            super(onTurnBasedMatchUpdateReceivedListener);
            this.f2474GV = str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.f2474GV);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$x */
    final class C0887x extends C0818fw {

        /* renamed from: GW */
        private final OnTurnBasedMatchUpdateReceivedListener f2476GW;

        C0887x(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            this.f2476GW = onTurnBasedMatchUpdateReceivedListener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            C0819fx.this.mo5036a((C0738b<?>) new C0886w<Object>(this.f2476GW, matchId));
        }

        /* renamed from: r */
        public void mo5281r(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                if (turnBasedMatch != null) {
                    C0819fx.this.mo5036a((C0738b<?>) new C0888y<Object>(this.f2476GW, turnBasedMatch));
                }
            } finally {
                turnBasedMatchBuffer.close();
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$y */
    final class C0888y extends C0738b<OnTurnBasedMatchUpdateReceivedListener> {

        /* renamed from: GX */
        private final TurnBasedMatch f2478GX;

        C0888y(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, TurnBasedMatch turnBasedMatch) {
            super(onTurnBasedMatchUpdateReceivedListener);
            this.f2478GX = turnBasedMatch;
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void mo4885a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.f2478GX);
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    /* renamed from: com.google.android.gms.internal.fx$z */
    final class C0889z extends C0738b<RealTimeMessageReceivedListener> {

        /* renamed from: GY */
        private final RealTimeMessage f2480GY;

        C0889z(RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            super(realTimeMessageReceivedListener);
            this.f2480GY = realTimeMessage;
        }

        /* renamed from: a */
        public void mo4885a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener != null) {
                realTimeMessageReceivedListener.onRealTimeMessageReceived(this.f2480GY);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: cP */
        public void mo4887cP() {
        }
    }

    public C0819fx(Context context, Looper looper, String str, String str2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, int i, View view, boolean z, boolean z2, int i2, boolean z3, int i3) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.f2342Gv = str;
        this.f2347vi = (String) C0766er.m1977f(str2);
        this.f2337GD = new Binder();
        this.f2343Gw = new HashMap();
        this.f2346Gz = C0900gd.m2794a(this, i);
        mo5336e(view);
        this.f2335GB = z2;
        this.f2336GC = i2;
        this.f2338GE = (long) hashCode();
        this.f2339GF = z;
        this.f2341GH = z3;
        this.f2340GG = i3;
        registerConnectionCallbacks((ConnectionCallbacks) this);
        registerConnectionFailedListener((OnConnectionFailedListener) this);
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public Room m2179G(DataHolder dataHolder) {
        C0488a aVar = new C0488a(dataHolder);
        Room room = null;
        try {
            if (aVar.getCount() > 0) {
                room = (Room) ((Room) aVar.get(0)).freeze();
            }
            return room;
        } finally {
            aVar.close();
        }
    }

    /* renamed from: aw */
    private RealTimeSocket m2181aw(String str) {
        try {
            ParcelFileDescriptor aD = ((C0896gb) mo5039eb()).mo5452aD(str);
            if (aD != null) {
                C0891fz.m2397f("GamesClientImpl", "Created native libjingle socket.");
                C0899gc gcVar = new C0899gc(aD);
                this.f2343Gw.put(str, gcVar);
                return gcVar;
            }
            C0891fz.m2397f("GamesClientImpl", "Unable to create native libjingle socket, resorting to old socket.");
            String ay = ((C0896gb) mo5039eb()).mo5456ay(str);
            if (ay == null) {
                return null;
            }
            LocalSocket localSocket = new LocalSocket();
            try {
                localSocket.connect(new LocalSocketAddress(ay));
                C0904ge geVar = new C0904ge(localSocket, str);
                this.f2343Gw.put(str, geVar);
                return geVar;
            } catch (IOException e) {
                C0891fz.m2399h("GamesClientImpl", "connect() call failed on socket: " + e.getMessage());
                return null;
            }
        } catch (RemoteException e2) {
            C0891fz.m2399h("GamesClientImpl", "Unable to create socket. Service died.");
            return null;
        }
    }

    /* renamed from: fG */
    private void m2182fG() {
        for (RealTimeSocket close : this.f2343Gw.values()) {
            try {
                close.close();
            } catch (IOException e) {
                C0891fz.m2396a("GamesClientImpl", "IOException:", e);
            }
        }
        this.f2343Gw.clear();
    }

    /* renamed from: fm */
    private void m2183fm() {
        this.f2344Gx = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public C0896gb mo3741p(IBinder iBinder) {
        return C0897a.m2645J(iBinder);
    }

    /* renamed from: a */
    public int mo5291a(ReliableMessageSentCallback reliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((C0896gb) mo5039eb()).mo5401a((C0893ga) new C0834an(reliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public int mo5292a(byte[] bArr, String str, String[] strArr) {
        C0766er.m1975b(strArr, (Object) "Participant IDs must not be null");
        try {
            return ((C0896gb) mo5039eb()).mo5458b(bArr, str, strArr);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: a */
    public Intent mo5293a(int i, int i2, boolean z) {
        try {
            return ((C0896gb) mo5039eb()).mo5402a(i, i2, z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent mo5294a(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent a = ((C0896gb) mo5039eb()).mo5403a(i, bArr, i2, str);
            C0766er.m1975b(bitmap, (Object) "Must provide a non null icon");
            a.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return a;
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: a */
    public Intent mo5295a(Room room, int i) {
        try {
            return ((C0896gb) mo5039eb()).mo5404a((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3733a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null) {
            this.f2334GA = bundle.getBoolean("show_welcome_popup");
        }
        super.mo3733a(i, iBinder, bundle);
    }

    /* renamed from: a */
    public void mo5296a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((C0896gb) mo5039eb()).mo5409a(iBinder, bundle);
            } catch (RemoteException e) {
                C0891fz.m2398g("GamesClientImpl", "service died");
            }
        }
    }

    /* renamed from: a */
    public void mo5297a(C0299c<LoadRequestsResult> cVar, int i, int i2, int i3) {
        try {
            ((C0896gb) mo5039eb()).mo5412a((C0893ga) new C0838ar(cVar), i, i2, i3);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5298a(C0299c<LoadPlayersResult> cVar, int i, boolean z, boolean z2) {
        try {
            ((C0896gb) mo5039eb()).mo5415a((C0893ga) new C0831ak(cVar), i, z, z2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5299a(C0299c<LoadMatchesResult> cVar, int i, int[] iArr) {
        try {
            ((C0896gb) mo5039eb()).mo5416a((C0893ga) new C0864bq(cVar), i, iArr);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5300a(C0299c<LoadScoresResult> cVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        try {
            ((C0896gb) mo5039eb()).mo5419a((C0893ga) new C0881r(cVar), leaderboardScoreBuffer.mo4087fX().mo4130fY(), i, i2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5301a(C0299c<InitiateMatchResult> cVar, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((C0896gb) mo5039eb()).mo5414a((C0893ga) new C0856bi(cVar), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.getMinPlayers(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5302a(C0299c<LoadPlayersResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5422a((C0893ga) new C0831ak(cVar), str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5303a(C0299c<UpdateAchievementResult> cVar, String str, int i) {
        try {
            ((C0896gb) mo5039eb()).mo5425a((C0893ga) cVar == null ? null : new C0867d(cVar), str, i, this.f2346Gz.mo5555fP(), this.f2346Gz.mo5554fO());
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5304a(C0299c<LoadScoresResult> cVar, String str, int i, int i2, int i3, boolean z) {
        try {
            ((C0896gb) mo5039eb()).mo5424a((C0893ga) new C0881r(cVar), str, i, i2, i3, z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5305a(C0299c<LoadPlayersResult> cVar, String str, int i, boolean z, boolean z2) {
        if (!str.equals("playedWith")) {
            throw new IllegalArgumentException("Invalid player collection: " + str);
        }
        try {
            ((C0896gb) mo5039eb()).mo5494d(new C0831ak(cVar), str, i, z, z2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5306a(C0299c<SubmitScoreResult> cVar, String str, long j, String str2) {
        try {
            ((C0896gb) mo5039eb()).mo5431a((C0893ga) cVar == null ? null : new C0851bd(cVar), str, j, str2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5307a(C0299c<LeaveMatchResult> cVar, String str, String str2) {
        try {
            ((C0896gb) mo5039eb()).mo5485c((C0893ga) new C0858bk(cVar), str, str2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5308a(C0299c<LoadPlayerScoreResult> cVar, String str, String str2, int i, int i2) {
        try {
            ((C0896gb) mo5039eb()).mo5434a((C0893ga) new C0829ai(cVar), str, str2, i, i2);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5309a(C0299c<LeaderboardMetadataResult> cVar, String str, boolean z) {
        try {
            ((C0896gb) mo5039eb()).mo5486c((C0893ga) new C0883t(cVar), str, z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5310a(C0299c<UpdateMatchResult> cVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) {
        try {
            ((C0896gb) mo5039eb()).mo5441a((C0893ga) new C0862bo(cVar), str, bArr, str2, participantResultArr);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5311a(C0299c<UpdateMatchResult> cVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) {
        try {
            ((C0896gb) mo5039eb()).mo5442a((C0893ga) new C0862bo(cVar), str, bArr, participantResultArr);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5312a(C0299c<LoadPlayersResult> cVar, boolean z) {
        try {
            ((C0896gb) mo5039eb()).mo5487c((C0893ga) new C0831ak(cVar), z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5313a(C0299c<UpdateRequestsResult> cVar, String[] strArr) {
        try {
            ((C0896gb) mo5039eb()).mo5448a((C0893ga) new C0840at(cVar), strArr);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5314a(OnInvitationReceivedListener onInvitationReceivedListener) {
        try {
            ((C0896gb) mo5039eb()).mo5417a((C0893ga) new C0875l(onInvitationReceivedListener), this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5315a(RoomConfig roomConfig) {
        try {
            ((C0896gb) mo5039eb()).mo5420a((C0893ga) new C0844ax(roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), (IBinder) this.f2337GD, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5316a(RoomUpdateListener roomUpdateListener, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5483c((C0893ga) new C0844ax(roomUpdateListener), str);
            m2182fG();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5317a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        try {
            ((C0896gb) mo5039eb()).mo5463b((C0893ga) new C0887x(onTurnBasedMatchUpdateReceivedListener), this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: a */
    public void mo5318a(OnRequestReceivedListener onRequestReceivedListener) {
        try {
            ((C0896gb) mo5039eb()).mo5481c((C0893ga) new C0835ao(onRequestReceivedListener), this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3734a(C0756en enVar, C0741e eVar) throws RemoteException {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.f2339GF);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.f2335GB);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.f2336GC);
        bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.f2341GH);
        bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.f2340GG);
        enVar.mo5095a(eVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.f2347vi, mo5038ea(), this.f2342Gv, this.f2346Gz.mo5555fP(), locale, bundle);
    }

    /* access modifiers changed from: protected */
    /* renamed from: aF */
    public String mo3735aF() {
        return "com.google.android.gms.games.service.START";
    }

    /* access modifiers changed from: protected */
    /* renamed from: aG */
    public String mo3736aG() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    /* renamed from: aT */
    public void mo5319aT(int i) {
        this.f2346Gz.setGravity(i);
    }

    /* renamed from: aU */
    public void mo5320aU(int i) {
        try {
            ((C0896gb) mo5039eb()).mo5453aU(i);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: au */
    public Intent mo5321au(String str) {
        try {
            return ((C0896gb) mo5039eb()).mo5454au(str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: av */
    public void mo5322av(String str) {
        try {
            ((C0896gb) mo5039eb()).mo5451aC(str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public Intent mo5323b(int i, int i2, boolean z) {
        try {
            return ((C0896gb) mo5039eb()).mo5459b(i, i2, z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: b */
    public void mo5324b(C0299c<Status> cVar) {
        try {
            ((C0896gb) mo5039eb()).mo5410a(new C0849bb(cVar));
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo5325b(C0299c<UpdateAchievementResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5432a((C0893ga) cVar == null ? null : new C0867d(cVar), str, this.f2346Gz.mo5555fP(), this.f2346Gz.mo5554fO());
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo5326b(C0299c<UpdateAchievementResult> cVar, String str, int i) {
        try {
            ((C0896gb) mo5039eb()).mo5467b((C0893ga) cVar == null ? null : new C0867d(cVar), str, i, this.f2346Gz.mo5555fP(), this.f2346Gz.mo5554fO());
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo5327b(C0299c<LoadScoresResult> cVar, String str, int i, int i2, int i3, boolean z) {
        try {
            ((C0896gb) mo5039eb()).mo5466b(new C0881r(cVar), str, i, i2, i3, z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo5328b(C0299c<LeaderboardMetadataResult> cVar, boolean z) {
        try {
            ((C0896gb) mo5039eb()).mo5475b((C0893ga) new C0883t(cVar), z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo5329b(C0299c<UpdateRequestsResult> cVar, String[] strArr) {
        try {
            ((C0896gb) mo5039eb()).mo5476b((C0893ga) new C0840at(cVar), strArr);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: b */
    public void mo5330b(RoomConfig roomConfig) {
        try {
            ((C0896gb) mo5039eb()).mo5421a((C0893ga) new C0844ax(roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener()), (IBinder) this.f2337GD, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo4881b(String... strArr) {
        boolean z = false;
        boolean z2 = false;
        for (String str : strArr) {
            if (str.equals(Scopes.GAMES)) {
                z2 = true;
            } else if (str.equals("https://www.googleapis.com/auth/games.firstparty")) {
                z = true;
            }
        }
        if (z) {
            C0766er.m1970a(!z2, String.format("Cannot have both %s and %s!", new Object[]{Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty"}));
            return;
        }
        C0766er.m1970a(z2, String.format("Games APIs requires %s to function.", new Object[]{Scopes.GAMES}));
    }

    /* renamed from: c */
    public void mo5331c(C0299c<LoadInvitationsResult> cVar, int i) {
        try {
            ((C0896gb) mo5039eb()).mo5411a((C0893ga) new C0878o(cVar), i);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo5332c(C0299c<UpdateAchievementResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5470b((C0893ga) cVar == null ? null : new C0867d(cVar), str, this.f2346Gz.mo5555fP(), this.f2346Gz.mo5554fO());
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: c */
    public void mo5333c(C0299c<LoadAchievementsResult> cVar, boolean z) {
        try {
            ((C0896gb) mo5039eb()).mo5445a((C0893ga) new C0869f(cVar), z);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: cY */
    public Bundle mo3323cY() {
        try {
            Bundle cY = ((C0896gb) mo5039eb()).mo5490cY();
            if (cY == null) {
                return cY;
            }
            cY.setClassLoader(C0819fx.class.getClassLoader());
            return cY;
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    public void connect() {
        m2183fm();
        super.connect();
    }

    /* renamed from: d */
    public int mo5334d(byte[] bArr, String str) {
        try {
            return ((C0896gb) mo5039eb()).mo5458b(bArr, str, (String[]) null);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return -1;
        }
    }

    /* renamed from: d */
    public void mo5335d(C0299c<InitiateMatchResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5534l((C0893ga) new C0856bi(cVar), str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    public void disconnect() {
        this.f2334GA = false;
        if (isConnected()) {
            try {
                C0896gb gbVar = (C0896gb) mo5039eb();
                gbVar.mo5510fH();
                gbVar.mo5538n(this.f2338GE);
            } catch (RemoteException e) {
                C0891fz.m2398g("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        m2182fG();
        super.disconnect();
    }

    /* renamed from: e */
    public void mo5336e(View view) {
        this.f2346Gz.mo5552f(view);
    }

    /* renamed from: e */
    public void mo5337e(C0299c<InitiateMatchResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5536m((C0893ga) new C0856bi(cVar), str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: f */
    public void mo5338f(C0299c<LeaveMatchResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5542o((C0893ga) new C0858bk(cVar), str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: fA */
    public int mo5339fA() {
        try {
            return ((C0896gb) mo5039eb()).mo5504fA();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return 4368;
        }
    }

    /* renamed from: fB */
    public String mo5340fB() {
        try {
            return ((C0896gb) mo5039eb()).mo5505fB();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fC */
    public int mo5341fC() {
        try {
            return ((C0896gb) mo5039eb()).mo5506fC();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return 2;
        }
    }

    /* renamed from: fD */
    public Intent mo5342fD() {
        try {
            return ((C0896gb) mo5039eb()).mo5507fD();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fE */
    public int mo5343fE() {
        try {
            return ((C0896gb) mo5039eb()).mo5508fE();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return 2;
        }
    }

    /* renamed from: fF */
    public int mo5344fF() {
        try {
            return ((C0896gb) mo5039eb()).mo5509fF();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return 2;
        }
    }

    /* renamed from: fH */
    public void mo5345fH() {
        if (isConnected()) {
            try {
                ((C0896gb) mo5039eb()).mo5510fH();
            } catch (RemoteException e) {
                C0891fz.m2398g("GamesClientImpl", "service died");
            }
        }
    }

    /* renamed from: fn */
    public String mo5346fn() {
        try {
            return ((C0896gb) mo5039eb()).mo5516fn();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fo */
    public String mo5347fo() {
        try {
            return ((C0896gb) mo5039eb()).mo5517fo();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fp */
    public Player mo5348fp() {
        PlayerBuffer playerBuffer;
        mo5037bm();
        synchronized (this) {
            if (this.f2344Gx == null) {
                try {
                    playerBuffer = new PlayerBuffer(((C0896gb) mo5039eb()).mo5511fI());
                    if (playerBuffer.getCount() > 0) {
                        this.f2344Gx = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.close();
                } catch (RemoteException e) {
                    C0891fz.m2398g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    playerBuffer.close();
                    throw th;
                }
            }
        }
        return this.f2344Gx;
    }

    /* renamed from: fq */
    public Game mo5349fq() {
        GameBuffer gameBuffer;
        mo5037bm();
        synchronized (this) {
            if (this.f2345Gy == null) {
                try {
                    gameBuffer = new GameBuffer(((C0896gb) mo5039eb()).mo5513fK());
                    if (gameBuffer.getCount() > 0) {
                        this.f2345Gy = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.close();
                } catch (RemoteException e) {
                    C0891fz.m2398g("GamesClientImpl", "service died");
                } catch (Throwable th) {
                    gameBuffer.close();
                    throw th;
                }
            }
        }
        return this.f2345Gy;
    }

    /* renamed from: fr */
    public Intent mo5350fr() {
        try {
            return ((C0896gb) mo5039eb()).mo5518fr();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fs */
    public Intent mo5351fs() {
        try {
            return ((C0896gb) mo5039eb()).mo5519fs();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: ft */
    public Intent mo5352ft() {
        try {
            return ((C0896gb) mo5039eb()).mo5520ft();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fu */
    public Intent mo5353fu() {
        try {
            return ((C0896gb) mo5039eb()).mo5521fu();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fv */
    public void mo5354fv() {
        try {
            ((C0896gb) mo5039eb()).mo5541o(this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: fw */
    public void mo5355fw() {
        try {
            ((C0896gb) mo5039eb()).mo5544p(this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: fx */
    public void mo5356fx() {
        try {
            ((C0896gb) mo5039eb()).mo5546q(this.f2338GE);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: fy */
    public Intent mo5357fy() {
        try {
            return ((C0896gb) mo5039eb()).mo5522fy();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: fz */
    public Intent mo5358fz() {
        try {
            return ((C0896gb) mo5039eb()).mo5523fz();
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
            return null;
        }
    }

    /* renamed from: g */
    public void mo5359g(C0299c<LoadGamesResult> cVar) {
        try {
            ((C0896gb) mo5039eb()).mo5491d(new C0873j(cVar));
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: g */
    public void mo5360g(C0299c<CancelMatchResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5539n((C0893ga) new C0854bg(cVar), str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: h */
    public void mo5361h(C0299c<LoadMatchResult> cVar, String str) {
        try {
            ((C0896gb) mo5039eb()).mo5545p(new C0860bm(cVar), str);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: i */
    public RealTimeSocket mo5362i(String str, String str2) {
        if (str2 == null || !ParticipantUtils.m1081aE(str2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        RealTimeSocket realTimeSocket = (RealTimeSocket) this.f2343Gw.get(str2);
        return (realTimeSocket == null || realTimeSocket.isClosed()) ? m2181aw(str2) : realTimeSocket;
    }

    /* renamed from: l */
    public void mo5363l(String str, int i) {
        try {
            ((C0896gb) mo5039eb()).mo5535l(str, i);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    /* renamed from: m */
    public void mo5364m(String str, int i) {
        try {
            ((C0896gb) mo5039eb()).mo5537m(str, i);
        } catch (RemoteException e) {
            C0891fz.m2398g("GamesClientImpl", "service died");
        }
    }

    public void onConnected(Bundle connectionHint) {
        if (this.f2334GA) {
            this.f2346Gz.mo5553fN();
            this.f2334GA = false;
        }
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.f2334GA = false;
    }

    public void onConnectionSuspended(int cause) {
    }
}
