package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {

    /* renamed from: d */
    private final Date f18d;

    /* renamed from: e */
    private final Gender f19e;

    /* renamed from: f */
    private final Set<String> f20f;

    /* renamed from: g */
    private final boolean f21g;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting) {
        this.f18d = birthday;
        this.f19e = gender;
        this.f20f = keywords;
        this.f21g = isTesting;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f18d;
    }

    public Gender getGender() {
        return this.f19e;
    }

    public Set<String> getKeywords() {
        return this.f20f;
    }

    public Location getLocation() {
        return null;
    }

    public boolean isTesting() {
        return this.f21g;
    }
}
