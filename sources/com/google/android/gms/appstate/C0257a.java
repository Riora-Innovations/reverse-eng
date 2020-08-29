package com.google.android.gms.appstate;

import com.google.android.gms.internal.C0762ep;

/* renamed from: com.google.android.gms.appstate.a */
public final class C0257a implements AppState {

    /* renamed from: uU */
    private final int f360uU;

    /* renamed from: uV */
    private final String f361uV;

    /* renamed from: uW */
    private final byte[] f362uW;

    /* renamed from: uX */
    private final boolean f363uX;

    /* renamed from: uY */
    private final String f364uY;

    /* renamed from: uZ */
    private final byte[] f365uZ;

    public C0257a(AppState appState) {
        this.f360uU = appState.getKey();
        this.f361uV = appState.getLocalVersion();
        this.f362uW = appState.getLocalData();
        this.f363uX = appState.hasConflict();
        this.f364uY = appState.getConflictVersion();
        this.f365uZ = appState.getConflictData();
    }

    /* renamed from: a */
    static int m323a(AppState appState) {
        return C0762ep.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    /* renamed from: a */
    static boolean m324a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return C0762ep.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && C0762ep.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && C0762ep.equal(appState2.getLocalData(), appState.getLocalData()) && C0762ep.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && C0762ep.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && C0762ep.equal(appState2.getConflictData(), appState.getConflictData());
    }

    /* renamed from: b */
    static String m325b(AppState appState) {
        return C0762ep.m1965e(appState).mo5118a("Key", Integer.valueOf(appState.getKey())).mo5118a("LocalVersion", appState.getLocalVersion()).mo5118a("LocalData", appState.getLocalData()).mo5118a("HasConflict", Boolean.valueOf(appState.hasConflict())).mo5118a("ConflictVersion", appState.getConflictVersion()).mo5118a("ConflictData", appState.getConflictData()).toString();
    }

    /* renamed from: cL */
    public AppState freeze() {
        return this;
    }

    public boolean equals(Object obj) {
        return m324a(this, obj);
    }

    public byte[] getConflictData() {
        return this.f365uZ;
    }

    public String getConflictVersion() {
        return this.f364uY;
    }

    public int getKey() {
        return this.f360uU;
    }

    public byte[] getLocalData() {
        return this.f362uW;
    }

    public String getLocalVersion() {
        return this.f361uV;
    }

    public boolean hasConflict() {
        return this.f363uX;
    }

    public int hashCode() {
        return m323a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m325b(this);
    }
}
