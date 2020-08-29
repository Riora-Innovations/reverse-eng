package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0312b;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.C0470d;
import com.google.android.gms.games.Player;
import com.google.android.gms.internal.C0731ed;
import com.google.android.gms.internal.C0762ep;
import com.google.android.gms.internal.C0762ep.C0764a;
import com.google.android.gms.plus.PlusShare;
import org.achartengine.chartdemo.demo.chart.IDemoChart;

/* renamed from: com.google.android.gms.games.achievement.a */
public final class C0467a extends C0312b implements Achievement {
    C0467a(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0731ed.m1826v(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        mo3372a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0731ed.m1826v(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0731ed.m1826v(z);
        mo3372a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0731ed.m1826v(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0731ed.m1826v(z);
        mo3372a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString(IDemoChart.NAME);
    }

    public void getName(CharArrayBuffer dataOut) {
        mo3372a(IDemoChart.NAME, dataOut);
    }

    public Player getPlayer() {
        return new C0470d(this.f581zU, this.f582zW);
    }

    public Uri getRevealedImageUri() {
        return mo3373aa("revealed_icon_image_uri");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0731ed.m1826v(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger("type");
    }

    public Uri getUnlockedImageUri() {
        return mo3373aa("unlocked_icon_image_uri");
    }

    public String toString() {
        C0764a a = C0762ep.m1965e(this).mo5118a("id", getAchievementId()).mo5118a(IDemoChart.NAME, getName()).mo5118a("state", Integer.valueOf(getState())).mo5118a("type", Integer.valueOf(getType()));
        if (getType() == 1) {
            a.mo5118a("steps", getCurrentSteps() + "/" + getTotalSteps());
        }
        return a.toString();
    }
}
