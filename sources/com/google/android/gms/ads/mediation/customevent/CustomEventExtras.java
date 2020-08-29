package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;

public final class CustomEventExtras implements NetworkExtras {

    /* renamed from: qt */
    private final HashMap<String, Object> f69qt = new HashMap<>();

    public Object getExtra(String label) {
        return this.f69qt.get(label);
    }

    public void setExtra(String label, Object value) {
        this.f69qt.put(label, value);
    }
}
