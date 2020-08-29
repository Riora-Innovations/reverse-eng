package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.C1139jy;
import com.google.android.gms.internal.C1140jz;
import com.google.android.gms.internal.C1147kd;
import com.google.android.gms.internal.C1148ke;
import com.google.android.gms.internal.C1151kh;
import java.io.IOException;

/* renamed from: com.google.android.gms.drive.internal.y */
public final class C0424y extends C1148ke {

    /* renamed from: DU */
    public static final C0424y[] f802DU = new C0424y[0];

    /* renamed from: DV */
    public String f803DV = "";

    /* renamed from: DW */
    public long f804DW = -1;

    /* renamed from: DX */
    public long f805DX = -1;

    /* renamed from: DY */
    private int f806DY = -1;
    public int versionCode = 1;

    /* renamed from: g */
    public static C0424y m877g(byte[] bArr) throws C1147kd {
        return (C0424y) C1148ke.m3471a(new C0424y(), bArr);
    }

    /* renamed from: a */
    public void mo3797a(C1140jz jzVar) throws IOException {
        jzVar.mo6411f(1, this.versionCode);
        jzVar.mo6401b(2, this.f803DV);
        jzVar.mo6404c(3, this.f804DW);
        jzVar.mo6404c(4, this.f805DX);
    }

    /* renamed from: c */
    public int mo3799c() {
        int g = 0 + C1140jz.m3424g(1, this.versionCode) + C1140jz.m3425g(2, this.f803DV) + C1140jz.m3423e(3, this.f804DW) + C1140jz.m3423e(4, this.f805DX);
        this.f806DY = g;
        return g;
    }

    /* renamed from: eW */
    public int mo3800eW() {
        if (this.f806DY < 0) {
            mo3799c();
        }
        return this.f806DY;
    }

    /* renamed from: m */
    public C0424y mo3798b(C1139jy jyVar) throws IOException {
        while (true) {
            int ky = jyVar.mo6390ky();
            switch (ky) {
                case 0:
                    break;
                case 8:
                    this.versionCode = jyVar.mo6380kB();
                    continue;
                case 18:
                    this.f803DV = jyVar.readString();
                    continue;
                case 24:
                    this.f804DW = jyVar.mo6382kD();
                    continue;
                case 32:
                    this.f805DX = jyVar.mo6382kD();
                    continue;
                default:
                    if (!C1151kh.m3485b(jyVar, ky)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }
}
