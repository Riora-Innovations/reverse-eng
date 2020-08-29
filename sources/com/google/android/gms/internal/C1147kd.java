package com.google.android.gms.internal;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.kd */
public class C1147kd extends IOException {
    public C1147kd(String str) {
        super(str);
    }

    /* renamed from: kO */
    static C1147kd m3464kO() {
        return new C1147kd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* renamed from: kP */
    static C1147kd m3465kP() {
        return new C1147kd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* renamed from: kQ */
    static C1147kd m3466kQ() {
        return new C1147kd("CodedInputStream encountered a malformed varint.");
    }

    /* renamed from: kR */
    static C1147kd m3467kR() {
        return new C1147kd("Protocol message contained an invalid tag (zero).");
    }

    /* renamed from: kS */
    static C1147kd m3468kS() {
        return new C1147kd("Protocol message end-group tag did not match expected tag.");
    }

    /* renamed from: kT */
    static C1147kd m3469kT() {
        return new C1147kd("Protocol message tag had invalid wire type.");
    }

    /* renamed from: kU */
    static C1147kd m3470kU() {
        return new C1147kd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
