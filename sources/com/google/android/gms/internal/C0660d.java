package com.google.android.gms.internal;

import com.google.ads.AdSize;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.d */
public interface C0660d {

    /* renamed from: com.google.android.gms.internal.d$a */
    public static final class C0661a extends C1144ka<C0661a> {

        /* renamed from: fX */
        private static volatile C0661a[] f1786fX;

        /* renamed from: fY */
        public String f1787fY;

        /* renamed from: fZ */
        public C0661a[] f1788fZ;

        /* renamed from: ga */
        public C0661a[] f1789ga;

        /* renamed from: gb */
        public C0661a[] f1790gb;

        /* renamed from: gc */
        public String f1791gc;

        /* renamed from: gd */
        public String f1792gd;

        /* renamed from: ge */
        public long f1793ge;

        /* renamed from: gf */
        public boolean f1794gf;

        /* renamed from: gg */
        public C0661a[] f1795gg;

        /* renamed from: gh */
        public int[] f1796gh;

        /* renamed from: gi */
        public boolean f1797gi;
        public int type;

        public C0661a() {
            mo4797s();
        }

        /* renamed from: r */
        public static C0661a[] m1542r() {
            if (f1786fX == null) {
                synchronized (C1146kc.aah) {
                    if (f1786fX == null) {
                        f1786fX = new C0661a[0];
                    }
                }
            }
            return f1786fX;
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            jzVar.mo6411f(1, this.type);
            if (!this.f1787fY.equals("")) {
                jzVar.mo6401b(2, this.f1787fY);
            }
            if (this.f1788fZ != null && this.f1788fZ.length > 0) {
                for (C0661a aVar : this.f1788fZ) {
                    if (aVar != null) {
                        jzVar.mo6397a(3, (C1148ke) aVar);
                    }
                }
            }
            if (this.f1789ga != null && this.f1789ga.length > 0) {
                for (C0661a aVar2 : this.f1789ga) {
                    if (aVar2 != null) {
                        jzVar.mo6397a(4, (C1148ke) aVar2);
                    }
                }
            }
            if (this.f1790gb != null && this.f1790gb.length > 0) {
                for (C0661a aVar3 : this.f1790gb) {
                    if (aVar3 != null) {
                        jzVar.mo6397a(5, (C1148ke) aVar3);
                    }
                }
            }
            if (!this.f1791gc.equals("")) {
                jzVar.mo6401b(6, this.f1791gc);
            }
            if (!this.f1792gd.equals("")) {
                jzVar.mo6401b(7, this.f1792gd);
            }
            if (this.f1793ge != 0) {
                jzVar.mo6400b(8, this.f1793ge);
            }
            if (this.f1797gi) {
                jzVar.mo6398a(9, this.f1797gi);
            }
            if (this.f1796gh != null && this.f1796gh.length > 0) {
                for (int f : this.f1796gh) {
                    jzVar.mo6411f(10, f);
                }
            }
            if (this.f1795gg != null && this.f1795gg.length > 0) {
                for (C0661a aVar4 : this.f1795gg) {
                    if (aVar4 != null) {
                        jzVar.mo6397a(11, (C1148ke) aVar4);
                    }
                }
            }
            if (this.f1794gf) {
                jzVar.mo6398a(12, this.f1794gf);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c() + C1140jz.m3424g(1, this.type);
            if (!this.f1787fY.equals("")) {
                c += C1140jz.m3425g(2, this.f1787fY);
            }
            if (this.f1788fZ != null && this.f1788fZ.length > 0) {
                int i = c;
                for (C0661a aVar : this.f1788fZ) {
                    if (aVar != null) {
                        i += C1140jz.m3413b(3, (C1148ke) aVar);
                    }
                }
                c = i;
            }
            if (this.f1789ga != null && this.f1789ga.length > 0) {
                int i2 = c;
                for (C0661a aVar2 : this.f1789ga) {
                    if (aVar2 != null) {
                        i2 += C1140jz.m3413b(4, (C1148ke) aVar2);
                    }
                }
                c = i2;
            }
            if (this.f1790gb != null && this.f1790gb.length > 0) {
                int i3 = c;
                for (C0661a aVar3 : this.f1790gb) {
                    if (aVar3 != null) {
                        i3 += C1140jz.m3413b(5, (C1148ke) aVar3);
                    }
                }
                c = i3;
            }
            if (!this.f1791gc.equals("")) {
                c += C1140jz.m3425g(6, this.f1791gc);
            }
            if (!this.f1792gd.equals("")) {
                c += C1140jz.m3425g(7, this.f1792gd);
            }
            if (this.f1793ge != 0) {
                c += C1140jz.m3421d(8, this.f1793ge);
            }
            if (this.f1797gi) {
                c += C1140jz.m3414b(9, this.f1797gi);
            }
            if (this.f1796gh != null && this.f1796gh.length > 0) {
                int i4 = 0;
                for (int cC : this.f1796gh) {
                    i4 += C1140jz.m3418cC(cC);
                }
                c = c + i4 + (this.f1796gh.length * 1);
            }
            if (this.f1795gg != null && this.f1795gg.length > 0) {
                for (C0661a aVar4 : this.f1795gg) {
                    if (aVar4 != null) {
                        c += C1140jz.m3413b(11, (C1148ke) aVar4);
                    }
                }
            }
            if (this.f1794gf) {
                c += C1140jz.m3414b(12, this.f1794gf);
            }
            this.f3121DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0661a)) {
                return false;
            }
            C0661a aVar = (C0661a) o;
            if (this.type != aVar.type) {
                return false;
            }
            if (this.f1787fY == null) {
                if (aVar.f1787fY != null) {
                    return false;
                }
            } else if (!this.f1787fY.equals(aVar.f1787fY)) {
                return false;
            }
            if (!C1146kc.equals((Object[]) this.f1788fZ, (Object[]) aVar.f1788fZ) || !C1146kc.equals((Object[]) this.f1789ga, (Object[]) aVar.f1789ga) || !C1146kc.equals((Object[]) this.f1790gb, (Object[]) aVar.f1790gb)) {
                return false;
            }
            if (this.f1791gc == null) {
                if (aVar.f1791gc != null) {
                    return false;
                }
            } else if (!this.f1791gc.equals(aVar.f1791gc)) {
                return false;
            }
            if (this.f1792gd == null) {
                if (aVar.f1792gd != null) {
                    return false;
                }
            } else if (!this.f1792gd.equals(aVar.f1792gd)) {
                return false;
            }
            if (this.f1793ge != aVar.f1793ge || this.f1794gf != aVar.f1794gf || !C1146kc.equals((Object[]) this.f1795gg, (Object[]) aVar.f1795gg) || !C1146kc.equals(this.f1796gh, aVar.f1796gh) || this.f1797gi != aVar.f1797gi) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return aVar.aae == null || aVar.aae.isEmpty();
            }
            return this.aae.equals(aVar.aae);
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.f1794gf ? 1231 : 1237) + (((((this.f1792gd == null ? 0 : this.f1792gd.hashCode()) + (((this.f1791gc == null ? 0 : this.f1791gc.hashCode()) + (((((((((this.f1787fY == null ? 0 : this.f1787fY.hashCode()) + ((this.type + 527) * 31)) * 31) + C1146kc.hashCode((Object[]) this.f1788fZ)) * 31) + C1146kc.hashCode((Object[]) this.f1789ga)) * 31) + C1146kc.hashCode((Object[]) this.f1790gb)) * 31)) * 31)) * 31) + ((int) (this.f1793ge ^ (this.f1793ge >>> 32)))) * 31)) * 31) + C1146kc.hashCode((Object[]) this.f1795gg)) * 31) + C1146kc.hashCode(this.f1796gh)) * 31;
            if (!this.f1797gi) {
                i = 1237;
            }
            int i3 = (hashCode + i) * 31;
            if (this.aae != null && !this.aae.isEmpty()) {
                i2 = this.aae.hashCode();
            }
            return i3 + i2;
        }

        /* renamed from: l */
        public C0661a mo3798b(C1139jy jyVar) throws IOException {
            int i;
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 8:
                        int kB = jyVar.mo6380kB();
                        switch (kB) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = kB;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.f1787fY = jyVar.readString();
                        continue;
                    case 26:
                        int c = C1151kh.m3486c(jyVar, 26);
                        int length = this.f1788fZ == null ? 0 : this.f1788fZ.length;
                        C0661a[] aVarArr = new C0661a[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1788fZ, 0, aVarArr, 0, length);
                        }
                        while (length < aVarArr.length - 1) {
                            aVarArr[length] = new C0661a();
                            jyVar.mo6368a(aVarArr[length]);
                            jyVar.mo6390ky();
                            length++;
                        }
                        aVarArr[length] = new C0661a();
                        jyVar.mo6368a(aVarArr[length]);
                        this.f1788fZ = aVarArr;
                        continue;
                    case 34:
                        int c2 = C1151kh.m3486c(jyVar, 34);
                        int length2 = this.f1789ga == null ? 0 : this.f1789ga.length;
                        C0661a[] aVarArr2 = new C0661a[(c2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f1789ga, 0, aVarArr2, 0, length2);
                        }
                        while (length2 < aVarArr2.length - 1) {
                            aVarArr2[length2] = new C0661a();
                            jyVar.mo6368a(aVarArr2[length2]);
                            jyVar.mo6390ky();
                            length2++;
                        }
                        aVarArr2[length2] = new C0661a();
                        jyVar.mo6368a(aVarArr2[length2]);
                        this.f1789ga = aVarArr2;
                        continue;
                    case 42:
                        int c3 = C1151kh.m3486c(jyVar, 42);
                        int length3 = this.f1790gb == null ? 0 : this.f1790gb.length;
                        C0661a[] aVarArr3 = new C0661a[(c3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f1790gb, 0, aVarArr3, 0, length3);
                        }
                        while (length3 < aVarArr3.length - 1) {
                            aVarArr3[length3] = new C0661a();
                            jyVar.mo6368a(aVarArr3[length3]);
                            jyVar.mo6390ky();
                            length3++;
                        }
                        aVarArr3[length3] = new C0661a();
                        jyVar.mo6368a(aVarArr3[length3]);
                        this.f1790gb = aVarArr3;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        this.f1791gc = jyVar.readString();
                        continue;
                    case 58:
                        this.f1792gd = jyVar.readString();
                        continue;
                    case 64:
                        this.f1793ge = jyVar.mo6379kA();
                        continue;
                    case 72:
                        this.f1797gi = jyVar.mo6381kC();
                        continue;
                    case 80:
                        int c4 = C1151kh.m3486c(jyVar, 80);
                        int[] iArr = new int[c4];
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < c4) {
                            if (i2 != 0) {
                                jyVar.mo6390ky();
                            }
                            int kB2 = jyVar.mo6380kB();
                            switch (kB2) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i = i3 + 1;
                                    iArr[i3] = kB2;
                                    break;
                                default:
                                    i = i3;
                                    break;
                            }
                            i2++;
                            i3 = i;
                        }
                        if (i3 != 0) {
                            int length4 = this.f1796gh == null ? 0 : this.f1796gh.length;
                            if (length4 != 0 || i3 != iArr.length) {
                                int[] iArr2 = new int[(length4 + i3)];
                                if (length4 != 0) {
                                    System.arraycopy(this.f1796gh, 0, iArr2, 0, length4);
                                }
                                System.arraycopy(iArr, 0, iArr2, length4, i3);
                                this.f1796gh = iArr2;
                                break;
                            } else {
                                this.f1796gh = iArr;
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 82:
                        int cw = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position = jyVar.getPosition();
                        int i4 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            switch (jyVar.mo6380kB()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    i4++;
                                    break;
                            }
                        }
                        if (i4 != 0) {
                            jyVar.mo6375cy(position);
                            int length5 = this.f1796gh == null ? 0 : this.f1796gh.length;
                            int[] iArr3 = new int[(i4 + length5)];
                            if (length5 != 0) {
                                System.arraycopy(this.f1796gh, 0, iArr3, 0, length5);
                            }
                            while (jyVar.mo6387kJ() > 0) {
                                int kB3 = jyVar.mo6380kB();
                                switch (kB3) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        int i5 = length5 + 1;
                                        iArr3[length5] = kB3;
                                        length5 = i5;
                                        break;
                                }
                            }
                            this.f1796gh = iArr3;
                        }
                        jyVar.mo6374cx(cw);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        int c5 = C1151kh.m3486c(jyVar, 90);
                        int length6 = this.f1795gg == null ? 0 : this.f1795gg.length;
                        C0661a[] aVarArr4 = new C0661a[(c5 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f1795gg, 0, aVarArr4, 0, length6);
                        }
                        while (length6 < aVarArr4.length - 1) {
                            aVarArr4[length6] = new C0661a();
                            jyVar.mo6368a(aVarArr4[length6]);
                            jyVar.mo6390ky();
                            length6++;
                        }
                        aVarArr4[length6] = new C0661a();
                        jyVar.mo6368a(aVarArr4[length6]);
                        this.f1795gg = aVarArr4;
                        continue;
                    case 96:
                        this.f1794gf = jyVar.mo6381kC();
                        continue;
                    default:
                        if (!mo6422a(jyVar, ky)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* renamed from: s */
        public C0661a mo4797s() {
            this.type = 1;
            this.f1787fY = "";
            this.f1788fZ = m1542r();
            this.f1789ga = m1542r();
            this.f1790gb = m1542r();
            this.f1791gc = "";
            this.f1792gd = "";
            this.f1793ge = 0;
            this.f1794gf = false;
            this.f1795gg = m1542r();
            this.f1796gh = C1151kh.aaj;
            this.f1797gi = false;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }
}
