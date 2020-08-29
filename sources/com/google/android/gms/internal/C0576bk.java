package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.C0171a;
import java.util.Date;
import java.util.HashSet;

/* renamed from: com.google.android.gms.internal.bk */
public final class C0576bk {
    /* renamed from: a */
    public static int m1278a(ErrorCode errorCode) {
        switch (errorCode) {
            case INVALID_REQUEST:
                return 1;
            case NETWORK_ERROR:
                return 2;
            case NO_FILL:
                return 3;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    public static int m1279a(Gender gender) {
        switch (gender) {
            case FEMALE:
                return 2;
            case MALE:
                return 1;
            default:
                return 0;
        }
    }

    /* renamed from: b */
    public static AdSize m1280b(C0504ab abVar) {
        return new AdSize(C0171a.m19a(abVar.width, abVar.height, abVar.f1194ln));
    }

    /* renamed from: e */
    public static MediationAdRequest m1281e(C1173z zVar) {
        return new MediationAdRequest(new Date(zVar.f3158le), m1282g(zVar.f3159lf), zVar.f3160lg != null ? new HashSet(zVar.f3160lg) : null, zVar.f3161lh);
    }

    /* renamed from: g */
    public static Gender m1282g(int i) {
        switch (i) {
            case 1:
                return Gender.MALE;
            case 2:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    /* renamed from: h */
    public static final ErrorCode m1283h(int i) {
        switch (i) {
            case 1:
                return ErrorCode.INVALID_REQUEST;
            case 2:
                return ErrorCode.NETWORK_ERROR;
            case 3:
                return ErrorCode.NO_FILL;
            default:
                return ErrorCode.INTERNAL_ERROR;
        }
    }
}
