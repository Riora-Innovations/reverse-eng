package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import com.google.ads.AdSize;
import com.google.android.gms.internal.C0660d.C0661a;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.c */
public interface C0608c {

    /* renamed from: com.google.android.gms.internal.c$a */
    public static final class C0609a extends C1144ka<C0609a> {

        /* renamed from: eP */
        public int f1580eP;

        /* renamed from: eQ */
        public int f1581eQ;
        public int level;

        public C0609a() {
            mo4702b();
        }

        /* renamed from: a */
        public C0609a mo3798b(C1139jy jyVar) throws IOException {
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
                                this.level = kB;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.f1580eP = jyVar.mo6380kB();
                        continue;
                    case 24:
                        this.f1581eQ = jyVar.mo6380kB();
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

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.level != 1) {
                jzVar.mo6411f(1, this.level);
            }
            if (this.f1580eP != 0) {
                jzVar.mo6411f(2, this.f1580eP);
            }
            if (this.f1581eQ != 0) {
                jzVar.mo6411f(3, this.f1581eQ);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: b */
        public C0609a mo4702b() {
            this.level = 1;
            this.f1580eP = 0;
            this.f1581eQ = 0;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c();
            if (this.level != 1) {
                c += C1140jz.m3424g(1, this.level);
            }
            if (this.f1580eP != 0) {
                c += C1140jz.m3424g(2, this.f1580eP);
            }
            if (this.f1581eQ != 0) {
                c += C1140jz.m3424g(3, this.f1581eQ);
            }
            this.f3121DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0609a)) {
                return false;
            }
            C0609a aVar = (C0609a) o;
            if (this.level != aVar.level || this.f1580eP != aVar.f1580eP || this.f1581eQ != aVar.f1581eQ) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return aVar.aae == null || aVar.aae.isEmpty();
            }
            return this.aae.equals(aVar.aae);
        }

        public int hashCode() {
            return ((this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode()) + ((((((this.level + 527) * 31) + this.f1580eP) * 31) + this.f1581eQ) * 31);
        }
    }

    /* renamed from: com.google.android.gms.internal.c$b */
    public static final class C0610b extends C1144ka<C0610b> {

        /* renamed from: eR */
        private static volatile C0610b[] f1582eR;

        /* renamed from: eS */
        public int[] f1583eS;

        /* renamed from: eT */
        public int f1584eT;

        /* renamed from: eU */
        public boolean f1585eU;

        /* renamed from: eV */
        public boolean f1586eV;
        public int name;

        public C0610b() {
            mo4706e();
        }

        /* renamed from: d */
        public static C0610b[] m1356d() {
            if (f1582eR == null) {
                synchronized (C1146kc.aah) {
                    if (f1582eR == null) {
                        f1582eR = new C0610b[0];
                    }
                }
            }
            return f1582eR;
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.f1586eV) {
                jzVar.mo6398a(1, this.f1586eV);
            }
            jzVar.mo6411f(2, this.f1584eT);
            if (this.f1583eS != null && this.f1583eS.length > 0) {
                for (int f : this.f1583eS) {
                    jzVar.mo6411f(3, f);
                }
            }
            if (this.name != 0) {
                jzVar.mo6411f(4, this.name);
            }
            if (this.f1585eU) {
                jzVar.mo6398a(6, this.f1585eU);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int i;
            int i2 = 0;
            int c = super.mo3799c();
            if (this.f1586eV) {
                c += C1140jz.m3414b(1, this.f1586eV);
            }
            int g = C1140jz.m3424g(2, this.f1584eT) + c;
            if (this.f1583eS == null || this.f1583eS.length <= 0) {
                i = g;
            } else {
                for (int cC : this.f1583eS) {
                    i2 += C1140jz.m3418cC(cC);
                }
                i = g + i2 + (this.f1583eS.length * 1);
            }
            if (this.name != 0) {
                i += C1140jz.m3424g(4, this.name);
            }
            if (this.f1585eU) {
                i += C1140jz.m3414b(6, this.f1585eU);
            }
            this.f3121DY = i;
            return i;
        }

        /* renamed from: c */
        public C0610b mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 8:
                        this.f1586eV = jyVar.mo6381kC();
                        continue;
                    case 16:
                        this.f1584eT = jyVar.mo6380kB();
                        continue;
                    case 24:
                        int c = C1151kh.m3486c(jyVar, 24);
                        int length = this.f1583eS == null ? 0 : this.f1583eS.length;
                        int[] iArr = new int[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1583eS, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length++;
                        }
                        iArr[length] = jyVar.mo6380kB();
                        this.f1583eS = iArr;
                        continue;
                    case 26:
                        int cw = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position = jyVar.getPosition();
                        int i = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i++;
                        }
                        jyVar.mo6375cy(position);
                        int length2 = this.f1583eS == null ? 0 : this.f1583eS.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f1583eS, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = jyVar.mo6380kB();
                            length2++;
                        }
                        this.f1583eS = iArr2;
                        jyVar.mo6374cx(cw);
                        continue;
                    case 32:
                        this.name = jyVar.mo6380kB();
                        continue;
                    case 48:
                        this.f1585eU = jyVar.mo6381kC();
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

        /* renamed from: e */
        public C0610b mo4706e() {
            this.f1583eS = C1151kh.aaj;
            this.f1584eT = 0;
            this.name = 0;
            this.f1585eU = false;
            this.f1586eV = false;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0610b)) {
                return false;
            }
            C0610b bVar = (C0610b) o;
            if (!C1146kc.equals(this.f1583eS, bVar.f1583eS) || this.f1584eT != bVar.f1584eT || this.name != bVar.name || this.f1585eU != bVar.f1585eU || this.f1586eV != bVar.f1586eV) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return bVar.aae == null || bVar.aae.isEmpty();
            }
            return this.aae.equals(bVar.aae);
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.f1585eU ? 1231 : 1237) + ((((((C1146kc.hashCode(this.f1583eS) + 527) * 31) + this.f1584eT) * 31) + this.name) * 31)) * 31;
            if (!this.f1586eV) {
                i = 1237;
            }
            return ((this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode()) + ((hashCode + i) * 31);
        }
    }

    /* renamed from: com.google.android.gms.internal.c$c */
    public static final class C0611c extends C1144ka<C0611c> {

        /* renamed from: eW */
        private static volatile C0611c[] f1587eW;

        /* renamed from: eX */
        public String f1588eX;

        /* renamed from: eY */
        public long f1589eY;

        /* renamed from: eZ */
        public long f1590eZ;

        /* renamed from: fa */
        public boolean f1591fa;

        /* renamed from: fb */
        public long f1592fb;

        public C0611c() {
            mo4711g();
        }

        /* renamed from: f */
        public static C0611c[] m1362f() {
            if (f1587eW == null) {
                synchronized (C1146kc.aah) {
                    if (f1587eW == null) {
                        f1587eW = new C0611c[0];
                    }
                }
            }
            return f1587eW;
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (!this.f1588eX.equals("")) {
                jzVar.mo6401b(1, this.f1588eX);
            }
            if (this.f1589eY != 0) {
                jzVar.mo6400b(2, this.f1589eY);
            }
            if (this.f1590eZ != 2147483647L) {
                jzVar.mo6400b(3, this.f1590eZ);
            }
            if (this.f1591fa) {
                jzVar.mo6398a(4, this.f1591fa);
            }
            if (this.f1592fb != 0) {
                jzVar.mo6400b(5, this.f1592fb);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c();
            if (!this.f1588eX.equals("")) {
                c += C1140jz.m3425g(1, this.f1588eX);
            }
            if (this.f1589eY != 0) {
                c += C1140jz.m3421d(2, this.f1589eY);
            }
            if (this.f1590eZ != 2147483647L) {
                c += C1140jz.m3421d(3, this.f1590eZ);
            }
            if (this.f1591fa) {
                c += C1140jz.m3414b(4, this.f1591fa);
            }
            if (this.f1592fb != 0) {
                c += C1140jz.m3421d(5, this.f1592fb);
            }
            this.f3121DY = c;
            return c;
        }

        /* renamed from: d */
        public C0611c mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 10:
                        this.f1588eX = jyVar.readString();
                        continue;
                    case 16:
                        this.f1589eY = jyVar.mo6379kA();
                        continue;
                    case 24:
                        this.f1590eZ = jyVar.mo6379kA();
                        continue;
                    case 32:
                        this.f1591fa = jyVar.mo6381kC();
                        continue;
                    case 40:
                        this.f1592fb = jyVar.mo6379kA();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0611c)) {
                return false;
            }
            C0611c cVar = (C0611c) o;
            if (this.f1588eX == null) {
                if (cVar.f1588eX != null) {
                    return false;
                }
            } else if (!this.f1588eX.equals(cVar.f1588eX)) {
                return false;
            }
            if (this.f1589eY != cVar.f1589eY || this.f1590eZ != cVar.f1590eZ || this.f1591fa != cVar.f1591fa || this.f1592fb != cVar.f1592fb) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return cVar.aae == null || cVar.aae.isEmpty();
            }
            return this.aae.equals(cVar.aae);
        }

        /* renamed from: g */
        public C0611c mo4711g() {
            this.f1588eX = "";
            this.f1589eY = 0;
            this.f1590eZ = 2147483647L;
            this.f1591fa = false;
            this.f1592fb = 0;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.f1591fa ? 1231 : 1237) + (((((((this.f1588eX == null ? 0 : this.f1588eX.hashCode()) + 527) * 31) + ((int) (this.f1589eY ^ (this.f1589eY >>> 32)))) * 31) + ((int) (this.f1590eZ ^ (this.f1590eZ >>> 32)))) * 31)) * 31) + ((int) (this.f1592fb ^ (this.f1592fb >>> 32)))) * 31;
            if (this.aae != null && !this.aae.isEmpty()) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$d */
    public static final class C0612d extends C1144ka<C0612d> {

        /* renamed from: fc */
        public C0661a[] f1593fc;

        /* renamed from: fd */
        public C0661a[] f1594fd;

        /* renamed from: fe */
        public C0611c[] f1595fe;

        public C0612d() {
            mo4715h();
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.f1593fc != null && this.f1593fc.length > 0) {
                for (C0661a aVar : this.f1593fc) {
                    if (aVar != null) {
                        jzVar.mo6397a(1, (C1148ke) aVar);
                    }
                }
            }
            if (this.f1594fd != null && this.f1594fd.length > 0) {
                for (C0661a aVar2 : this.f1594fd) {
                    if (aVar2 != null) {
                        jzVar.mo6397a(2, (C1148ke) aVar2);
                    }
                }
            }
            if (this.f1595fe != null && this.f1595fe.length > 0) {
                for (C0611c cVar : this.f1595fe) {
                    if (cVar != null) {
                        jzVar.mo6397a(3, (C1148ke) cVar);
                    }
                }
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c();
            if (this.f1593fc != null && this.f1593fc.length > 0) {
                int i = c;
                for (C0661a aVar : this.f1593fc) {
                    if (aVar != null) {
                        i += C1140jz.m3413b(1, (C1148ke) aVar);
                    }
                }
                c = i;
            }
            if (this.f1594fd != null && this.f1594fd.length > 0) {
                int i2 = c;
                for (C0661a aVar2 : this.f1594fd) {
                    if (aVar2 != null) {
                        i2 += C1140jz.m3413b(2, (C1148ke) aVar2);
                    }
                }
                c = i2;
            }
            if (this.f1595fe != null && this.f1595fe.length > 0) {
                for (C0611c cVar : this.f1595fe) {
                    if (cVar != null) {
                        c += C1140jz.m3413b(3, (C1148ke) cVar);
                    }
                }
            }
            this.f3121DY = c;
            return c;
        }

        /* renamed from: e */
        public C0612d mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 10:
                        int c = C1151kh.m3486c(jyVar, 10);
                        int length = this.f1593fc == null ? 0 : this.f1593fc.length;
                        C0661a[] aVarArr = new C0661a[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1593fc, 0, aVarArr, 0, length);
                        }
                        while (length < aVarArr.length - 1) {
                            aVarArr[length] = new C0661a();
                            jyVar.mo6368a(aVarArr[length]);
                            jyVar.mo6390ky();
                            length++;
                        }
                        aVarArr[length] = new C0661a();
                        jyVar.mo6368a(aVarArr[length]);
                        this.f1593fc = aVarArr;
                        continue;
                    case 18:
                        int c2 = C1151kh.m3486c(jyVar, 18);
                        int length2 = this.f1594fd == null ? 0 : this.f1594fd.length;
                        C0661a[] aVarArr2 = new C0661a[(c2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f1594fd, 0, aVarArr2, 0, length2);
                        }
                        while (length2 < aVarArr2.length - 1) {
                            aVarArr2[length2] = new C0661a();
                            jyVar.mo6368a(aVarArr2[length2]);
                            jyVar.mo6390ky();
                            length2++;
                        }
                        aVarArr2[length2] = new C0661a();
                        jyVar.mo6368a(aVarArr2[length2]);
                        this.f1594fd = aVarArr2;
                        continue;
                    case 26:
                        int c3 = C1151kh.m3486c(jyVar, 26);
                        int length3 = this.f1595fe == null ? 0 : this.f1595fe.length;
                        C0611c[] cVarArr = new C0611c[(c3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f1595fe, 0, cVarArr, 0, length3);
                        }
                        while (length3 < cVarArr.length - 1) {
                            cVarArr[length3] = new C0611c();
                            jyVar.mo6368a(cVarArr[length3]);
                            jyVar.mo6390ky();
                            length3++;
                        }
                        cVarArr[length3] = new C0611c();
                        jyVar.mo6368a(cVarArr[length3]);
                        this.f1595fe = cVarArr;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0612d)) {
                return false;
            }
            C0612d dVar = (C0612d) o;
            if (!C1146kc.equals((Object[]) this.f1593fc, (Object[]) dVar.f1593fc) || !C1146kc.equals((Object[]) this.f1594fd, (Object[]) dVar.f1594fd) || !C1146kc.equals((Object[]) this.f1595fe, (Object[]) dVar.f1595fe)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return dVar.aae == null || dVar.aae.isEmpty();
            }
            return this.aae.equals(dVar.aae);
        }

        /* renamed from: h */
        public C0612d mo4715h() {
            this.f1593fc = C0661a.m1542r();
            this.f1594fd = C0661a.m1542r();
            this.f1595fe = C0611c.m1362f();
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }

        public int hashCode() {
            return ((this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode()) + ((((((C1146kc.hashCode((Object[]) this.f1593fc) + 527) * 31) + C1146kc.hashCode((Object[]) this.f1594fd)) * 31) + C1146kc.hashCode((Object[]) this.f1595fe)) * 31);
        }
    }

    /* renamed from: com.google.android.gms.internal.c$e */
    public static final class C0613e extends C1144ka<C0613e> {

        /* renamed from: ff */
        private static volatile C0613e[] f1596ff;
        public int key;
        public int value;

        public C0613e() {
            mo4720j();
        }

        /* renamed from: i */
        public static C0613e[] m1373i() {
            if (f1596ff == null) {
                synchronized (C1146kc.aah) {
                    if (f1596ff == null) {
                        f1596ff = new C0613e[0];
                    }
                }
            }
            return f1596ff;
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            jzVar.mo6411f(1, this.key);
            jzVar.mo6411f(2, this.value);
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c() + C1140jz.m3424g(1, this.key) + C1140jz.m3424g(2, this.value);
            this.f3121DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0613e)) {
                return false;
            }
            C0613e eVar = (C0613e) o;
            if (this.key != eVar.key || this.value != eVar.value) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return eVar.aae == null || eVar.aae.isEmpty();
            }
            return this.aae.equals(eVar.aae);
        }

        /* renamed from: f */
        public C0613e mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 8:
                        this.key = jyVar.mo6380kB();
                        continue;
                    case 16:
                        this.value = jyVar.mo6380kB();
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

        public int hashCode() {
            return ((this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode()) + ((((this.key + 527) * 31) + this.value) * 31);
        }

        /* renamed from: j */
        public C0613e mo4720j() {
            this.key = 0;
            this.value = 0;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$f */
    public static final class C0614f extends C1144ka<C0614f> {

        /* renamed from: fg */
        public String[] f1597fg;

        /* renamed from: fh */
        public String[] f1598fh;

        /* renamed from: fi */
        public C0661a[] f1599fi;

        /* renamed from: fj */
        public C0613e[] f1600fj;

        /* renamed from: fk */
        public C0610b[] f1601fk;

        /* renamed from: fl */
        public C0610b[] f1602fl;

        /* renamed from: fm */
        public C0610b[] f1603fm;

        /* renamed from: fn */
        public C0615g[] f1604fn;

        /* renamed from: fo */
        public String f1605fo;

        /* renamed from: fp */
        public String f1606fp;

        /* renamed from: fq */
        public String f1607fq;

        /* renamed from: fr */
        public String f1608fr;

        /* renamed from: fs */
        public C0609a f1609fs;

        /* renamed from: ft */
        public float f1610ft;

        /* renamed from: fu */
        public boolean f1611fu;

        /* renamed from: fv */
        public String[] f1612fv;

        /* renamed from: fw */
        public int f1613fw;

        public C0614f() {
            mo4724k();
        }

        /* renamed from: a */
        public static C0614f m1379a(byte[] bArr) throws C1147kd {
            return (C0614f) C1148ke.m3471a(new C0614f(), bArr);
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.f1598fh != null && this.f1598fh.length > 0) {
                for (String str : this.f1598fh) {
                    if (str != null) {
                        jzVar.mo6401b(1, str);
                    }
                }
            }
            if (this.f1599fi != null && this.f1599fi.length > 0) {
                for (C0661a aVar : this.f1599fi) {
                    if (aVar != null) {
                        jzVar.mo6397a(2, (C1148ke) aVar);
                    }
                }
            }
            if (this.f1600fj != null && this.f1600fj.length > 0) {
                for (C0613e eVar : this.f1600fj) {
                    if (eVar != null) {
                        jzVar.mo6397a(3, (C1148ke) eVar);
                    }
                }
            }
            if (this.f1601fk != null && this.f1601fk.length > 0) {
                for (C0610b bVar : this.f1601fk) {
                    if (bVar != null) {
                        jzVar.mo6397a(4, (C1148ke) bVar);
                    }
                }
            }
            if (this.f1602fl != null && this.f1602fl.length > 0) {
                for (C0610b bVar2 : this.f1602fl) {
                    if (bVar2 != null) {
                        jzVar.mo6397a(5, (C1148ke) bVar2);
                    }
                }
            }
            if (this.f1603fm != null && this.f1603fm.length > 0) {
                for (C0610b bVar3 : this.f1603fm) {
                    if (bVar3 != null) {
                        jzVar.mo6397a(6, (C1148ke) bVar3);
                    }
                }
            }
            if (this.f1604fn != null && this.f1604fn.length > 0) {
                for (C0615g gVar : this.f1604fn) {
                    if (gVar != null) {
                        jzVar.mo6397a(7, (C1148ke) gVar);
                    }
                }
            }
            if (!this.f1605fo.equals("")) {
                jzVar.mo6401b(9, this.f1605fo);
            }
            if (!this.f1606fp.equals("")) {
                jzVar.mo6401b(10, this.f1606fp);
            }
            if (!this.f1607fq.equals("0")) {
                jzVar.mo6401b(12, this.f1607fq);
            }
            if (!this.f1608fr.equals("")) {
                jzVar.mo6401b(13, this.f1608fr);
            }
            if (this.f1609fs != null) {
                jzVar.mo6397a(14, (C1148ke) this.f1609fs);
            }
            if (Float.floatToIntBits(this.f1610ft) != Float.floatToIntBits(0.0f)) {
                jzVar.mo6396a(15, this.f1610ft);
            }
            if (this.f1612fv != null && this.f1612fv.length > 0) {
                for (String str2 : this.f1612fv) {
                    if (str2 != null) {
                        jzVar.mo6401b(16, str2);
                    }
                }
            }
            if (this.f1613fw != 0) {
                jzVar.mo6411f(17, this.f1613fw);
            }
            if (this.f1611fu) {
                jzVar.mo6398a(18, this.f1611fu);
            }
            if (this.f1597fg != null && this.f1597fg.length > 0) {
                for (String str3 : this.f1597fg) {
                    if (str3 != null) {
                        jzVar.mo6401b(19, str3);
                    }
                }
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int i;
            int c = super.mo3799c();
            if (this.f1598fh == null || this.f1598fh.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.f1598fh) {
                    if (str != null) {
                        i3++;
                        i2 += C1140jz.m3416bQ(str);
                    }
                }
                i = c + i2 + (i3 * 1);
            }
            if (this.f1599fi != null && this.f1599fi.length > 0) {
                int i4 = i;
                for (C0661a aVar : this.f1599fi) {
                    if (aVar != null) {
                        i4 += C1140jz.m3413b(2, (C1148ke) aVar);
                    }
                }
                i = i4;
            }
            if (this.f1600fj != null && this.f1600fj.length > 0) {
                int i5 = i;
                for (C0613e eVar : this.f1600fj) {
                    if (eVar != null) {
                        i5 += C1140jz.m3413b(3, (C1148ke) eVar);
                    }
                }
                i = i5;
            }
            if (this.f1601fk != null && this.f1601fk.length > 0) {
                int i6 = i;
                for (C0610b bVar : this.f1601fk) {
                    if (bVar != null) {
                        i6 += C1140jz.m3413b(4, (C1148ke) bVar);
                    }
                }
                i = i6;
            }
            if (this.f1602fl != null && this.f1602fl.length > 0) {
                int i7 = i;
                for (C0610b bVar2 : this.f1602fl) {
                    if (bVar2 != null) {
                        i7 += C1140jz.m3413b(5, (C1148ke) bVar2);
                    }
                }
                i = i7;
            }
            if (this.f1603fm != null && this.f1603fm.length > 0) {
                int i8 = i;
                for (C0610b bVar3 : this.f1603fm) {
                    if (bVar3 != null) {
                        i8 += C1140jz.m3413b(6, (C1148ke) bVar3);
                    }
                }
                i = i8;
            }
            if (this.f1604fn != null && this.f1604fn.length > 0) {
                int i9 = i;
                for (C0615g gVar : this.f1604fn) {
                    if (gVar != null) {
                        i9 += C1140jz.m3413b(7, (C1148ke) gVar);
                    }
                }
                i = i9;
            }
            if (!this.f1605fo.equals("")) {
                i += C1140jz.m3425g(9, this.f1605fo);
            }
            if (!this.f1606fp.equals("")) {
                i += C1140jz.m3425g(10, this.f1606fp);
            }
            if (!this.f1607fq.equals("0")) {
                i += C1140jz.m3425g(12, this.f1607fq);
            }
            if (!this.f1608fr.equals("")) {
                i += C1140jz.m3425g(13, this.f1608fr);
            }
            if (this.f1609fs != null) {
                i += C1140jz.m3413b(14, (C1148ke) this.f1609fs);
            }
            if (Float.floatToIntBits(this.f1610ft) != Float.floatToIntBits(0.0f)) {
                i += C1140jz.m3412b(15, this.f1610ft);
            }
            if (this.f1612fv != null && this.f1612fv.length > 0) {
                int i10 = 0;
                int i11 = 0;
                for (String str2 : this.f1612fv) {
                    if (str2 != null) {
                        i11++;
                        i10 += C1140jz.m3416bQ(str2);
                    }
                }
                i = i + i10 + (i11 * 2);
            }
            if (this.f1613fw != 0) {
                i += C1140jz.m3424g(17, this.f1613fw);
            }
            if (this.f1611fu) {
                i += C1140jz.m3414b(18, this.f1611fu);
            }
            if (this.f1597fg != null && this.f1597fg.length > 0) {
                int i12 = 0;
                int i13 = 0;
                for (String str3 : this.f1597fg) {
                    if (str3 != null) {
                        i13++;
                        i12 += C1140jz.m3416bQ(str3);
                    }
                }
                i = i + i12 + (i13 * 2);
            }
            this.f3121DY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0614f)) {
                return false;
            }
            C0614f fVar = (C0614f) o;
            if (!C1146kc.equals((Object[]) this.f1597fg, (Object[]) fVar.f1597fg) || !C1146kc.equals((Object[]) this.f1598fh, (Object[]) fVar.f1598fh) || !C1146kc.equals((Object[]) this.f1599fi, (Object[]) fVar.f1599fi) || !C1146kc.equals((Object[]) this.f1600fj, (Object[]) fVar.f1600fj) || !C1146kc.equals((Object[]) this.f1601fk, (Object[]) fVar.f1601fk) || !C1146kc.equals((Object[]) this.f1602fl, (Object[]) fVar.f1602fl) || !C1146kc.equals((Object[]) this.f1603fm, (Object[]) fVar.f1603fm) || !C1146kc.equals((Object[]) this.f1604fn, (Object[]) fVar.f1604fn)) {
                return false;
            }
            if (this.f1605fo == null) {
                if (fVar.f1605fo != null) {
                    return false;
                }
            } else if (!this.f1605fo.equals(fVar.f1605fo)) {
                return false;
            }
            if (this.f1606fp == null) {
                if (fVar.f1606fp != null) {
                    return false;
                }
            } else if (!this.f1606fp.equals(fVar.f1606fp)) {
                return false;
            }
            if (this.f1607fq == null) {
                if (fVar.f1607fq != null) {
                    return false;
                }
            } else if (!this.f1607fq.equals(fVar.f1607fq)) {
                return false;
            }
            if (this.f1608fr == null) {
                if (fVar.f1608fr != null) {
                    return false;
                }
            } else if (!this.f1608fr.equals(fVar.f1608fr)) {
                return false;
            }
            if (this.f1609fs == null) {
                if (fVar.f1609fs != null) {
                    return false;
                }
            } else if (!this.f1609fs.equals(fVar.f1609fs)) {
                return false;
            }
            if (Float.floatToIntBits(this.f1610ft) != Float.floatToIntBits(fVar.f1610ft) || this.f1611fu != fVar.f1611fu || !C1146kc.equals((Object[]) this.f1612fv, (Object[]) fVar.f1612fv) || this.f1613fw != fVar.f1613fw) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return fVar.aae == null || fVar.aae.isEmpty();
            }
            return this.aae.equals(fVar.aae);
        }

        /* renamed from: g */
        public C0614f mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 10:
                        int c = C1151kh.m3486c(jyVar, 10);
                        int length = this.f1598fh == null ? 0 : this.f1598fh.length;
                        String[] strArr = new String[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1598fh, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = jyVar.readString();
                            jyVar.mo6390ky();
                            length++;
                        }
                        strArr[length] = jyVar.readString();
                        this.f1598fh = strArr;
                        continue;
                    case 18:
                        int c2 = C1151kh.m3486c(jyVar, 18);
                        int length2 = this.f1599fi == null ? 0 : this.f1599fi.length;
                        C0661a[] aVarArr = new C0661a[(c2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f1599fi, 0, aVarArr, 0, length2);
                        }
                        while (length2 < aVarArr.length - 1) {
                            aVarArr[length2] = new C0661a();
                            jyVar.mo6368a(aVarArr[length2]);
                            jyVar.mo6390ky();
                            length2++;
                        }
                        aVarArr[length2] = new C0661a();
                        jyVar.mo6368a(aVarArr[length2]);
                        this.f1599fi = aVarArr;
                        continue;
                    case 26:
                        int c3 = C1151kh.m3486c(jyVar, 26);
                        int length3 = this.f1600fj == null ? 0 : this.f1600fj.length;
                        C0613e[] eVarArr = new C0613e[(c3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f1600fj, 0, eVarArr, 0, length3);
                        }
                        while (length3 < eVarArr.length - 1) {
                            eVarArr[length3] = new C0613e();
                            jyVar.mo6368a(eVarArr[length3]);
                            jyVar.mo6390ky();
                            length3++;
                        }
                        eVarArr[length3] = new C0613e();
                        jyVar.mo6368a(eVarArr[length3]);
                        this.f1600fj = eVarArr;
                        continue;
                    case 34:
                        int c4 = C1151kh.m3486c(jyVar, 34);
                        int length4 = this.f1601fk == null ? 0 : this.f1601fk.length;
                        C0610b[] bVarArr = new C0610b[(c4 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f1601fk, 0, bVarArr, 0, length4);
                        }
                        while (length4 < bVarArr.length - 1) {
                            bVarArr[length4] = new C0610b();
                            jyVar.mo6368a(bVarArr[length4]);
                            jyVar.mo6390ky();
                            length4++;
                        }
                        bVarArr[length4] = new C0610b();
                        jyVar.mo6368a(bVarArr[length4]);
                        this.f1601fk = bVarArr;
                        continue;
                    case 42:
                        int c5 = C1151kh.m3486c(jyVar, 42);
                        int length5 = this.f1602fl == null ? 0 : this.f1602fl.length;
                        C0610b[] bVarArr2 = new C0610b[(c5 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.f1602fl, 0, bVarArr2, 0, length5);
                        }
                        while (length5 < bVarArr2.length - 1) {
                            bVarArr2[length5] = new C0610b();
                            jyVar.mo6368a(bVarArr2[length5]);
                            jyVar.mo6390ky();
                            length5++;
                        }
                        bVarArr2[length5] = new C0610b();
                        jyVar.mo6368a(bVarArr2[length5]);
                        this.f1602fl = bVarArr2;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        int c6 = C1151kh.m3486c(jyVar, 50);
                        int length6 = this.f1603fm == null ? 0 : this.f1603fm.length;
                        C0610b[] bVarArr3 = new C0610b[(c6 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f1603fm, 0, bVarArr3, 0, length6);
                        }
                        while (length6 < bVarArr3.length - 1) {
                            bVarArr3[length6] = new C0610b();
                            jyVar.mo6368a(bVarArr3[length6]);
                            jyVar.mo6390ky();
                            length6++;
                        }
                        bVarArr3[length6] = new C0610b();
                        jyVar.mo6368a(bVarArr3[length6]);
                        this.f1603fm = bVarArr3;
                        continue;
                    case 58:
                        int c7 = C1151kh.m3486c(jyVar, 58);
                        int length7 = this.f1604fn == null ? 0 : this.f1604fn.length;
                        C0615g[] gVarArr = new C0615g[(c7 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.f1604fn, 0, gVarArr, 0, length7);
                        }
                        while (length7 < gVarArr.length - 1) {
                            gVarArr[length7] = new C0615g();
                            jyVar.mo6368a(gVarArr[length7]);
                            jyVar.mo6390ky();
                            length7++;
                        }
                        gVarArr[length7] = new C0615g();
                        jyVar.mo6368a(gVarArr[length7]);
                        this.f1604fn = gVarArr;
                        continue;
                    case 74:
                        this.f1605fo = jyVar.readString();
                        continue;
                    case 82:
                        this.f1606fp = jyVar.readString();
                        continue;
                    case 98:
                        this.f1607fq = jyVar.readString();
                        continue;
                    case 106:
                        this.f1608fr = jyVar.readString();
                        continue;
                    case 114:
                        if (this.f1609fs == null) {
                            this.f1609fs = new C0609a();
                        }
                        jyVar.mo6368a(this.f1609fs);
                        continue;
                    case 125:
                        this.f1610ft = jyVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        int c8 = C1151kh.m3486c(jyVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        int length8 = this.f1612fv == null ? 0 : this.f1612fv.length;
                        String[] strArr2 = new String[(c8 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.f1612fv, 0, strArr2, 0, length8);
                        }
                        while (length8 < strArr2.length - 1) {
                            strArr2[length8] = jyVar.readString();
                            jyVar.mo6390ky();
                            length8++;
                        }
                        strArr2[length8] = jyVar.readString();
                        this.f1612fv = strArr2;
                        continue;
                    case 136:
                        this.f1613fw = jyVar.mo6380kB();
                        continue;
                    case 144:
                        this.f1611fu = jyVar.mo6381kC();
                        continue;
                    case 154:
                        int c9 = C1151kh.m3486c(jyVar, 154);
                        int length9 = this.f1597fg == null ? 0 : this.f1597fg.length;
                        String[] strArr3 = new String[(c9 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.f1597fg, 0, strArr3, 0, length9);
                        }
                        while (length9 < strArr3.length - 1) {
                            strArr3[length9] = jyVar.readString();
                            jyVar.mo6390ky();
                            length9++;
                        }
                        strArr3[length9] = jyVar.readString();
                        this.f1597fg = strArr3;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.f1611fu ? 1231 : 1237) + (((((this.f1609fs == null ? 0 : this.f1609fs.hashCode()) + (((this.f1608fr == null ? 0 : this.f1608fr.hashCode()) + (((this.f1607fq == null ? 0 : this.f1607fq.hashCode()) + (((this.f1606fp == null ? 0 : this.f1606fp.hashCode()) + (((this.f1605fo == null ? 0 : this.f1605fo.hashCode()) + ((((((((((((((((C1146kc.hashCode((Object[]) this.f1597fg) + 527) * 31) + C1146kc.hashCode((Object[]) this.f1598fh)) * 31) + C1146kc.hashCode((Object[]) this.f1599fi)) * 31) + C1146kc.hashCode((Object[]) this.f1600fj)) * 31) + C1146kc.hashCode((Object[]) this.f1601fk)) * 31) + C1146kc.hashCode((Object[]) this.f1602fl)) * 31) + C1146kc.hashCode((Object[]) this.f1603fm)) * 31) + C1146kc.hashCode((Object[]) this.f1604fn)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.f1610ft)) * 31)) * 31) + C1146kc.hashCode((Object[]) this.f1612fv)) * 31) + this.f1613fw) * 31;
            if (this.aae != null && !this.aae.isEmpty()) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: k */
        public C0614f mo4724k() {
            this.f1597fg = C1151kh.aao;
            this.f1598fh = C1151kh.aao;
            this.f1599fi = C0661a.m1542r();
            this.f1600fj = C0613e.m1373i();
            this.f1601fk = C0610b.m1356d();
            this.f1602fl = C0610b.m1356d();
            this.f1603fm = C0610b.m1356d();
            this.f1604fn = C0615g.m1385l();
            this.f1605fo = "";
            this.f1606fp = "";
            this.f1607fq = "0";
            this.f1608fr = "";
            this.f1609fs = null;
            this.f1610ft = 0.0f;
            this.f1611fu = false;
            this.f1612fv = C1151kh.aao;
            this.f1613fw = 0;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$g */
    public static final class C0615g extends C1144ka<C0615g> {

        /* renamed from: fx */
        private static volatile C0615g[] f1614fx;

        /* renamed from: fA */
        public int[] f1615fA;

        /* renamed from: fB */
        public int[] f1616fB;

        /* renamed from: fC */
        public int[] f1617fC;

        /* renamed from: fD */
        public int[] f1618fD;

        /* renamed from: fE */
        public int[] f1619fE;

        /* renamed from: fF */
        public int[] f1620fF;

        /* renamed from: fG */
        public int[] f1621fG;

        /* renamed from: fH */
        public int[] f1622fH;

        /* renamed from: fy */
        public int[] f1623fy;

        /* renamed from: fz */
        public int[] f1624fz;

        public C0615g() {
            mo4728m();
        }

        /* renamed from: l */
        public static C0615g[] m1385l() {
            if (f1614fx == null) {
                synchronized (C1146kc.aah) {
                    if (f1614fx == null) {
                        f1614fx = new C0615g[0];
                    }
                }
            }
            return f1614fx;
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.f1623fy != null && this.f1623fy.length > 0) {
                for (int f : this.f1623fy) {
                    jzVar.mo6411f(1, f);
                }
            }
            if (this.f1624fz != null && this.f1624fz.length > 0) {
                for (int f2 : this.f1624fz) {
                    jzVar.mo6411f(2, f2);
                }
            }
            if (this.f1615fA != null && this.f1615fA.length > 0) {
                for (int f3 : this.f1615fA) {
                    jzVar.mo6411f(3, f3);
                }
            }
            if (this.f1616fB != null && this.f1616fB.length > 0) {
                for (int f4 : this.f1616fB) {
                    jzVar.mo6411f(4, f4);
                }
            }
            if (this.f1617fC != null && this.f1617fC.length > 0) {
                for (int f5 : this.f1617fC) {
                    jzVar.mo6411f(5, f5);
                }
            }
            if (this.f1618fD != null && this.f1618fD.length > 0) {
                for (int f6 : this.f1618fD) {
                    jzVar.mo6411f(6, f6);
                }
            }
            if (this.f1619fE != null && this.f1619fE.length > 0) {
                for (int f7 : this.f1619fE) {
                    jzVar.mo6411f(7, f7);
                }
            }
            if (this.f1620fF != null && this.f1620fF.length > 0) {
                for (int f8 : this.f1620fF) {
                    jzVar.mo6411f(8, f8);
                }
            }
            if (this.f1621fG != null && this.f1621fG.length > 0) {
                for (int f9 : this.f1621fG) {
                    jzVar.mo6411f(9, f9);
                }
            }
            if (this.f1622fH != null && this.f1622fH.length > 0) {
                for (int f10 : this.f1622fH) {
                    jzVar.mo6411f(10, f10);
                }
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int i;
            int c = super.mo3799c();
            if (this.f1623fy == null || this.f1623fy.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                for (int cC : this.f1623fy) {
                    i2 += C1140jz.m3418cC(cC);
                }
                i = c + i2 + (this.f1623fy.length * 1);
            }
            if (this.f1624fz != null && this.f1624fz.length > 0) {
                int i3 = 0;
                for (int cC2 : this.f1624fz) {
                    i3 += C1140jz.m3418cC(cC2);
                }
                i = i + i3 + (this.f1624fz.length * 1);
            }
            if (this.f1615fA != null && this.f1615fA.length > 0) {
                int i4 = 0;
                for (int cC3 : this.f1615fA) {
                    i4 += C1140jz.m3418cC(cC3);
                }
                i = i + i4 + (this.f1615fA.length * 1);
            }
            if (this.f1616fB != null && this.f1616fB.length > 0) {
                int i5 = 0;
                for (int cC4 : this.f1616fB) {
                    i5 += C1140jz.m3418cC(cC4);
                }
                i = i + i5 + (this.f1616fB.length * 1);
            }
            if (this.f1617fC != null && this.f1617fC.length > 0) {
                int i6 = 0;
                for (int cC5 : this.f1617fC) {
                    i6 += C1140jz.m3418cC(cC5);
                }
                i = i + i6 + (this.f1617fC.length * 1);
            }
            if (this.f1618fD != null && this.f1618fD.length > 0) {
                int i7 = 0;
                for (int cC6 : this.f1618fD) {
                    i7 += C1140jz.m3418cC(cC6);
                }
                i = i + i7 + (this.f1618fD.length * 1);
            }
            if (this.f1619fE != null && this.f1619fE.length > 0) {
                int i8 = 0;
                for (int cC7 : this.f1619fE) {
                    i8 += C1140jz.m3418cC(cC7);
                }
                i = i + i8 + (this.f1619fE.length * 1);
            }
            if (this.f1620fF != null && this.f1620fF.length > 0) {
                int i9 = 0;
                for (int cC8 : this.f1620fF) {
                    i9 += C1140jz.m3418cC(cC8);
                }
                i = i + i9 + (this.f1620fF.length * 1);
            }
            if (this.f1621fG != null && this.f1621fG.length > 0) {
                int i10 = 0;
                for (int cC9 : this.f1621fG) {
                    i10 += C1140jz.m3418cC(cC9);
                }
                i = i + i10 + (this.f1621fG.length * 1);
            }
            if (this.f1622fH != null && this.f1622fH.length > 0) {
                int i11 = 0;
                for (int cC10 : this.f1622fH) {
                    i11 += C1140jz.m3418cC(cC10);
                }
                i = i + i11 + (this.f1622fH.length * 1);
            }
            this.f3121DY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0615g)) {
                return false;
            }
            C0615g gVar = (C0615g) o;
            if (!C1146kc.equals(this.f1623fy, gVar.f1623fy) || !C1146kc.equals(this.f1624fz, gVar.f1624fz) || !C1146kc.equals(this.f1615fA, gVar.f1615fA) || !C1146kc.equals(this.f1616fB, gVar.f1616fB) || !C1146kc.equals(this.f1617fC, gVar.f1617fC) || !C1146kc.equals(this.f1618fD, gVar.f1618fD) || !C1146kc.equals(this.f1619fE, gVar.f1619fE) || !C1146kc.equals(this.f1620fF, gVar.f1620fF) || !C1146kc.equals(this.f1621fG, gVar.f1621fG) || !C1146kc.equals(this.f1622fH, gVar.f1622fH)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return gVar.aae == null || gVar.aae.isEmpty();
            }
            return this.aae.equals(gVar.aae);
        }

        /* renamed from: h */
        public C0615g mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 8:
                        int c = C1151kh.m3486c(jyVar, 8);
                        int length = this.f1623fy == null ? 0 : this.f1623fy.length;
                        int[] iArr = new int[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1623fy, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length++;
                        }
                        iArr[length] = jyVar.mo6380kB();
                        this.f1623fy = iArr;
                        continue;
                    case 10:
                        int cw = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position = jyVar.getPosition();
                        int i = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i++;
                        }
                        jyVar.mo6375cy(position);
                        int length2 = this.f1623fy == null ? 0 : this.f1623fy.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f1623fy, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = jyVar.mo6380kB();
                            length2++;
                        }
                        this.f1623fy = iArr2;
                        jyVar.mo6374cx(cw);
                        continue;
                    case 16:
                        int c2 = C1151kh.m3486c(jyVar, 16);
                        int length3 = this.f1624fz == null ? 0 : this.f1624fz.length;
                        int[] iArr3 = new int[(c2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f1624fz, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length3++;
                        }
                        iArr3[length3] = jyVar.mo6380kB();
                        this.f1624fz = iArr3;
                        continue;
                    case 18:
                        int cw2 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position2 = jyVar.getPosition();
                        int i2 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i2++;
                        }
                        jyVar.mo6375cy(position2);
                        int length4 = this.f1624fz == null ? 0 : this.f1624fz.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f1624fz, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = jyVar.mo6380kB();
                            length4++;
                        }
                        this.f1624fz = iArr4;
                        jyVar.mo6374cx(cw2);
                        continue;
                    case 24:
                        int c3 = C1151kh.m3486c(jyVar, 24);
                        int length5 = this.f1615fA == null ? 0 : this.f1615fA.length;
                        int[] iArr5 = new int[(c3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.f1615fA, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length5++;
                        }
                        iArr5[length5] = jyVar.mo6380kB();
                        this.f1615fA = iArr5;
                        continue;
                    case 26:
                        int cw3 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position3 = jyVar.getPosition();
                        int i3 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i3++;
                        }
                        jyVar.mo6375cy(position3);
                        int length6 = this.f1615fA == null ? 0 : this.f1615fA.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f1615fA, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = jyVar.mo6380kB();
                            length6++;
                        }
                        this.f1615fA = iArr6;
                        jyVar.mo6374cx(cw3);
                        continue;
                    case 32:
                        int c4 = C1151kh.m3486c(jyVar, 32);
                        int length7 = this.f1616fB == null ? 0 : this.f1616fB.length;
                        int[] iArr7 = new int[(c4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.f1616fB, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length7++;
                        }
                        iArr7[length7] = jyVar.mo6380kB();
                        this.f1616fB = iArr7;
                        continue;
                    case 34:
                        int cw4 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position4 = jyVar.getPosition();
                        int i4 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i4++;
                        }
                        jyVar.mo6375cy(position4);
                        int length8 = this.f1616fB == null ? 0 : this.f1616fB.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.f1616fB, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = jyVar.mo6380kB();
                            length8++;
                        }
                        this.f1616fB = iArr8;
                        jyVar.mo6374cx(cw4);
                        continue;
                    case 40:
                        int c5 = C1151kh.m3486c(jyVar, 40);
                        int length9 = this.f1617fC == null ? 0 : this.f1617fC.length;
                        int[] iArr9 = new int[(c5 + length9)];
                        if (length9 != 0) {
                            System.arraycopy(this.f1617fC, 0, iArr9, 0, length9);
                        }
                        while (length9 < iArr9.length - 1) {
                            iArr9[length9] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length9++;
                        }
                        iArr9[length9] = jyVar.mo6380kB();
                        this.f1617fC = iArr9;
                        continue;
                    case 42:
                        int cw5 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position5 = jyVar.getPosition();
                        int i5 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i5++;
                        }
                        jyVar.mo6375cy(position5);
                        int length10 = this.f1617fC == null ? 0 : this.f1617fC.length;
                        int[] iArr10 = new int[(i5 + length10)];
                        if (length10 != 0) {
                            System.arraycopy(this.f1617fC, 0, iArr10, 0, length10);
                        }
                        while (length10 < iArr10.length) {
                            iArr10[length10] = jyVar.mo6380kB();
                            length10++;
                        }
                        this.f1617fC = iArr10;
                        jyVar.mo6374cx(cw5);
                        continue;
                    case 48:
                        int c6 = C1151kh.m3486c(jyVar, 48);
                        int length11 = this.f1618fD == null ? 0 : this.f1618fD.length;
                        int[] iArr11 = new int[(c6 + length11)];
                        if (length11 != 0) {
                            System.arraycopy(this.f1618fD, 0, iArr11, 0, length11);
                        }
                        while (length11 < iArr11.length - 1) {
                            iArr11[length11] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length11++;
                        }
                        iArr11[length11] = jyVar.mo6380kB();
                        this.f1618fD = iArr11;
                        continue;
                    case AdSize.PORTRAIT_AD_HEIGHT /*50*/:
                        int cw6 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position6 = jyVar.getPosition();
                        int i6 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i6++;
                        }
                        jyVar.mo6375cy(position6);
                        int length12 = this.f1618fD == null ? 0 : this.f1618fD.length;
                        int[] iArr12 = new int[(i6 + length12)];
                        if (length12 != 0) {
                            System.arraycopy(this.f1618fD, 0, iArr12, 0, length12);
                        }
                        while (length12 < iArr12.length) {
                            iArr12[length12] = jyVar.mo6380kB();
                            length12++;
                        }
                        this.f1618fD = iArr12;
                        jyVar.mo6374cx(cw6);
                        continue;
                    case 56:
                        int c7 = C1151kh.m3486c(jyVar, 56);
                        int length13 = this.f1619fE == null ? 0 : this.f1619fE.length;
                        int[] iArr13 = new int[(c7 + length13)];
                        if (length13 != 0) {
                            System.arraycopy(this.f1619fE, 0, iArr13, 0, length13);
                        }
                        while (length13 < iArr13.length - 1) {
                            iArr13[length13] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length13++;
                        }
                        iArr13[length13] = jyVar.mo6380kB();
                        this.f1619fE = iArr13;
                        continue;
                    case 58:
                        int cw7 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position7 = jyVar.getPosition();
                        int i7 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i7++;
                        }
                        jyVar.mo6375cy(position7);
                        int length14 = this.f1619fE == null ? 0 : this.f1619fE.length;
                        int[] iArr14 = new int[(i7 + length14)];
                        if (length14 != 0) {
                            System.arraycopy(this.f1619fE, 0, iArr14, 0, length14);
                        }
                        while (length14 < iArr14.length) {
                            iArr14[length14] = jyVar.mo6380kB();
                            length14++;
                        }
                        this.f1619fE = iArr14;
                        jyVar.mo6374cx(cw7);
                        continue;
                    case 64:
                        int c8 = C1151kh.m3486c(jyVar, 64);
                        int length15 = this.f1620fF == null ? 0 : this.f1620fF.length;
                        int[] iArr15 = new int[(c8 + length15)];
                        if (length15 != 0) {
                            System.arraycopy(this.f1620fF, 0, iArr15, 0, length15);
                        }
                        while (length15 < iArr15.length - 1) {
                            iArr15[length15] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length15++;
                        }
                        iArr15[length15] = jyVar.mo6380kB();
                        this.f1620fF = iArr15;
                        continue;
                    case 66:
                        int cw8 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position8 = jyVar.getPosition();
                        int i8 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i8++;
                        }
                        jyVar.mo6375cy(position8);
                        int length16 = this.f1620fF == null ? 0 : this.f1620fF.length;
                        int[] iArr16 = new int[(i8 + length16)];
                        if (length16 != 0) {
                            System.arraycopy(this.f1620fF, 0, iArr16, 0, length16);
                        }
                        while (length16 < iArr16.length) {
                            iArr16[length16] = jyVar.mo6380kB();
                            length16++;
                        }
                        this.f1620fF = iArr16;
                        jyVar.mo6374cx(cw8);
                        continue;
                    case 72:
                        int c9 = C1151kh.m3486c(jyVar, 72);
                        int length17 = this.f1621fG == null ? 0 : this.f1621fG.length;
                        int[] iArr17 = new int[(c9 + length17)];
                        if (length17 != 0) {
                            System.arraycopy(this.f1621fG, 0, iArr17, 0, length17);
                        }
                        while (length17 < iArr17.length - 1) {
                            iArr17[length17] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length17++;
                        }
                        iArr17[length17] = jyVar.mo6380kB();
                        this.f1621fG = iArr17;
                        continue;
                    case 74:
                        int cw9 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position9 = jyVar.getPosition();
                        int i9 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i9++;
                        }
                        jyVar.mo6375cy(position9);
                        int length18 = this.f1621fG == null ? 0 : this.f1621fG.length;
                        int[] iArr18 = new int[(i9 + length18)];
                        if (length18 != 0) {
                            System.arraycopy(this.f1621fG, 0, iArr18, 0, length18);
                        }
                        while (length18 < iArr18.length) {
                            iArr18[length18] = jyVar.mo6380kB();
                            length18++;
                        }
                        this.f1621fG = iArr18;
                        jyVar.mo6374cx(cw9);
                        continue;
                    case 80:
                        int c10 = C1151kh.m3486c(jyVar, 80);
                        int length19 = this.f1622fH == null ? 0 : this.f1622fH.length;
                        int[] iArr19 = new int[(c10 + length19)];
                        if (length19 != 0) {
                            System.arraycopy(this.f1622fH, 0, iArr19, 0, length19);
                        }
                        while (length19 < iArr19.length - 1) {
                            iArr19[length19] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length19++;
                        }
                        iArr19[length19] = jyVar.mo6380kB();
                        this.f1622fH = iArr19;
                        continue;
                    case 82:
                        int cw10 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position10 = jyVar.getPosition();
                        int i10 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i10++;
                        }
                        jyVar.mo6375cy(position10);
                        int length20 = this.f1622fH == null ? 0 : this.f1622fH.length;
                        int[] iArr20 = new int[(i10 + length20)];
                        if (length20 != 0) {
                            System.arraycopy(this.f1622fH, 0, iArr20, 0, length20);
                        }
                        while (length20 < iArr20.length) {
                            iArr20[length20] = jyVar.mo6380kB();
                            length20++;
                        }
                        this.f1622fH = iArr20;
                        jyVar.mo6374cx(cw10);
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

        public int hashCode() {
            return ((this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode()) + ((((((((((((((((((((C1146kc.hashCode(this.f1623fy) + 527) * 31) + C1146kc.hashCode(this.f1624fz)) * 31) + C1146kc.hashCode(this.f1615fA)) * 31) + C1146kc.hashCode(this.f1616fB)) * 31) + C1146kc.hashCode(this.f1617fC)) * 31) + C1146kc.hashCode(this.f1618fD)) * 31) + C1146kc.hashCode(this.f1619fE)) * 31) + C1146kc.hashCode(this.f1620fF)) * 31) + C1146kc.hashCode(this.f1621fG)) * 31) + C1146kc.hashCode(this.f1622fH)) * 31);
        }

        /* renamed from: m */
        public C0615g mo4728m() {
            this.f1623fy = C1151kh.aaj;
            this.f1624fz = C1151kh.aaj;
            this.f1615fA = C1151kh.aaj;
            this.f1616fB = C1151kh.aaj;
            this.f1617fC = C1151kh.aaj;
            this.f1618fD = C1151kh.aaj;
            this.f1619fE = C1151kh.aaj;
            this.f1620fF = C1151kh.aaj;
            this.f1621fG = C1151kh.aaj;
            this.f1622fH = C1151kh.aaj;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$h */
    public static final class C0616h extends C1144ka<C0616h> {

        /* renamed from: fI */
        public static final C1145kb<C0661a, C0616h> f1625fI = C1145kb.m3459a(11, C0616h.class, 810);

        /* renamed from: fJ */
        private static final C0616h[] f1626fJ = new C0616h[0];

        /* renamed from: fK */
        public int[] f1627fK;

        /* renamed from: fL */
        public int[] f1628fL;

        /* renamed from: fM */
        public int[] f1629fM;

        /* renamed from: fN */
        public int f1630fN;

        /* renamed from: fO */
        public int[] f1631fO;

        /* renamed from: fP */
        public int f1632fP;

        /* renamed from: fQ */
        public int f1633fQ;

        public C0616h() {
            mo4732n();
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.f1627fK != null && this.f1627fK.length > 0) {
                for (int f : this.f1627fK) {
                    jzVar.mo6411f(1, f);
                }
            }
            if (this.f1628fL != null && this.f1628fL.length > 0) {
                for (int f2 : this.f1628fL) {
                    jzVar.mo6411f(2, f2);
                }
            }
            if (this.f1629fM != null && this.f1629fM.length > 0) {
                for (int f3 : this.f1629fM) {
                    jzVar.mo6411f(3, f3);
                }
            }
            if (this.f1630fN != 0) {
                jzVar.mo6411f(4, this.f1630fN);
            }
            if (this.f1631fO != null && this.f1631fO.length > 0) {
                for (int f4 : this.f1631fO) {
                    jzVar.mo6411f(5, f4);
                }
            }
            if (this.f1632fP != 0) {
                jzVar.mo6411f(6, this.f1632fP);
            }
            if (this.f1633fQ != 0) {
                jzVar.mo6411f(7, this.f1633fQ);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int i;
            int c = super.mo3799c();
            if (this.f1627fK == null || this.f1627fK.length <= 0) {
                i = c;
            } else {
                int i2 = 0;
                for (int cC : this.f1627fK) {
                    i2 += C1140jz.m3418cC(cC);
                }
                i = c + i2 + (this.f1627fK.length * 1);
            }
            if (this.f1628fL != null && this.f1628fL.length > 0) {
                int i3 = 0;
                for (int cC2 : this.f1628fL) {
                    i3 += C1140jz.m3418cC(cC2);
                }
                i = i + i3 + (this.f1628fL.length * 1);
            }
            if (this.f1629fM != null && this.f1629fM.length > 0) {
                int i4 = 0;
                for (int cC3 : this.f1629fM) {
                    i4 += C1140jz.m3418cC(cC3);
                }
                i = i + i4 + (this.f1629fM.length * 1);
            }
            if (this.f1630fN != 0) {
                i += C1140jz.m3424g(4, this.f1630fN);
            }
            if (this.f1631fO != null && this.f1631fO.length > 0) {
                int i5 = 0;
                for (int cC4 : this.f1631fO) {
                    i5 += C1140jz.m3418cC(cC4);
                }
                i = i + i5 + (this.f1631fO.length * 1);
            }
            if (this.f1632fP != 0) {
                i += C1140jz.m3424g(6, this.f1632fP);
            }
            if (this.f1633fQ != 0) {
                i += C1140jz.m3424g(7, this.f1633fQ);
            }
            this.f3121DY = i;
            return i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0616h)) {
                return false;
            }
            C0616h hVar = (C0616h) o;
            if (!C1146kc.equals(this.f1627fK, hVar.f1627fK) || !C1146kc.equals(this.f1628fL, hVar.f1628fL) || !C1146kc.equals(this.f1629fM, hVar.f1629fM) || this.f1630fN != hVar.f1630fN || !C1146kc.equals(this.f1631fO, hVar.f1631fO) || this.f1632fP != hVar.f1632fP || this.f1633fQ != hVar.f1633fQ) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return hVar.aae == null || hVar.aae.isEmpty();
            }
            return this.aae.equals(hVar.aae);
        }

        public int hashCode() {
            return ((this.aae == null || this.aae.isEmpty()) ? 0 : this.aae.hashCode()) + ((((((((((((((C1146kc.hashCode(this.f1627fK) + 527) * 31) + C1146kc.hashCode(this.f1628fL)) * 31) + C1146kc.hashCode(this.f1629fM)) * 31) + this.f1630fN) * 31) + C1146kc.hashCode(this.f1631fO)) * 31) + this.f1632fP) * 31) + this.f1633fQ) * 31);
        }

        /* renamed from: i */
        public C0616h mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 8:
                        int c = C1151kh.m3486c(jyVar, 8);
                        int length = this.f1627fK == null ? 0 : this.f1627fK.length;
                        int[] iArr = new int[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1627fK, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length++;
                        }
                        iArr[length] = jyVar.mo6380kB();
                        this.f1627fK = iArr;
                        continue;
                    case 10:
                        int cw = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position = jyVar.getPosition();
                        int i = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i++;
                        }
                        jyVar.mo6375cy(position);
                        int length2 = this.f1627fK == null ? 0 : this.f1627fK.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.f1627fK, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = jyVar.mo6380kB();
                            length2++;
                        }
                        this.f1627fK = iArr2;
                        jyVar.mo6374cx(cw);
                        continue;
                    case 16:
                        int c2 = C1151kh.m3486c(jyVar, 16);
                        int length3 = this.f1628fL == null ? 0 : this.f1628fL.length;
                        int[] iArr3 = new int[(c2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.f1628fL, 0, iArr3, 0, length3);
                        }
                        while (length3 < iArr3.length - 1) {
                            iArr3[length3] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length3++;
                        }
                        iArr3[length3] = jyVar.mo6380kB();
                        this.f1628fL = iArr3;
                        continue;
                    case 18:
                        int cw2 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position2 = jyVar.getPosition();
                        int i2 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i2++;
                        }
                        jyVar.mo6375cy(position2);
                        int length4 = this.f1628fL == null ? 0 : this.f1628fL.length;
                        int[] iArr4 = new int[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.f1628fL, 0, iArr4, 0, length4);
                        }
                        while (length4 < iArr4.length) {
                            iArr4[length4] = jyVar.mo6380kB();
                            length4++;
                        }
                        this.f1628fL = iArr4;
                        jyVar.mo6374cx(cw2);
                        continue;
                    case 24:
                        int c3 = C1151kh.m3486c(jyVar, 24);
                        int length5 = this.f1629fM == null ? 0 : this.f1629fM.length;
                        int[] iArr5 = new int[(c3 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.f1629fM, 0, iArr5, 0, length5);
                        }
                        while (length5 < iArr5.length - 1) {
                            iArr5[length5] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length5++;
                        }
                        iArr5[length5] = jyVar.mo6380kB();
                        this.f1629fM = iArr5;
                        continue;
                    case 26:
                        int cw3 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position3 = jyVar.getPosition();
                        int i3 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i3++;
                        }
                        jyVar.mo6375cy(position3);
                        int length6 = this.f1629fM == null ? 0 : this.f1629fM.length;
                        int[] iArr6 = new int[(i3 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.f1629fM, 0, iArr6, 0, length6);
                        }
                        while (length6 < iArr6.length) {
                            iArr6[length6] = jyVar.mo6380kB();
                            length6++;
                        }
                        this.f1629fM = iArr6;
                        jyVar.mo6374cx(cw3);
                        continue;
                    case 32:
                        this.f1630fN = jyVar.mo6380kB();
                        continue;
                    case 40:
                        int c4 = C1151kh.m3486c(jyVar, 40);
                        int length7 = this.f1631fO == null ? 0 : this.f1631fO.length;
                        int[] iArr7 = new int[(c4 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.f1631fO, 0, iArr7, 0, length7);
                        }
                        while (length7 < iArr7.length - 1) {
                            iArr7[length7] = jyVar.mo6380kB();
                            jyVar.mo6390ky();
                            length7++;
                        }
                        iArr7[length7] = jyVar.mo6380kB();
                        this.f1631fO = iArr7;
                        continue;
                    case 42:
                        int cw4 = jyVar.mo6373cw(jyVar.mo6383kE());
                        int position4 = jyVar.getPosition();
                        int i4 = 0;
                        while (jyVar.mo6387kJ() > 0) {
                            jyVar.mo6380kB();
                            i4++;
                        }
                        jyVar.mo6375cy(position4);
                        int length8 = this.f1631fO == null ? 0 : this.f1631fO.length;
                        int[] iArr8 = new int[(i4 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.f1631fO, 0, iArr8, 0, length8);
                        }
                        while (length8 < iArr8.length) {
                            iArr8[length8] = jyVar.mo6380kB();
                            length8++;
                        }
                        this.f1631fO = iArr8;
                        jyVar.mo6374cx(cw4);
                        continue;
                    case 48:
                        this.f1632fP = jyVar.mo6380kB();
                        continue;
                    case 56:
                        this.f1633fQ = jyVar.mo6380kB();
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

        /* renamed from: n */
        public C0616h mo4732n() {
            this.f1627fK = C1151kh.aaj;
            this.f1628fL = C1151kh.aaj;
            this.f1629fM = C1151kh.aaj;
            this.f1630fN = 0;
            this.f1631fO = C1151kh.aaj;
            this.f1632fP = 0;
            this.f1633fQ = 0;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$i */
    public static final class C0617i extends C1144ka<C0617i> {

        /* renamed from: fR */
        private static volatile C0617i[] f1634fR;

        /* renamed from: fS */
        public C0661a f1635fS;

        /* renamed from: fT */
        public C0612d f1636fT;
        public String name;

        public C0617i() {
            mo4736p();
        }

        /* renamed from: o */
        public static C0617i[] m1396o() {
            if (f1634fR == null) {
                synchronized (C1146kc.aah) {
                    if (f1634fR == null) {
                        f1634fR = new C0617i[0];
                    }
                }
            }
            return f1634fR;
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (!this.name.equals("")) {
                jzVar.mo6401b(1, this.name);
            }
            if (this.f1635fS != null) {
                jzVar.mo6397a(2, (C1148ke) this.f1635fS);
            }
            if (this.f1636fT != null) {
                jzVar.mo6397a(3, (C1148ke) this.f1636fT);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c();
            if (!this.name.equals("")) {
                c += C1140jz.m3425g(1, this.name);
            }
            if (this.f1635fS != null) {
                c += C1140jz.m3413b(2, (C1148ke) this.f1635fS);
            }
            if (this.f1636fT != null) {
                c += C1140jz.m3413b(3, (C1148ke) this.f1636fT);
            }
            this.f3121DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0617i)) {
                return false;
            }
            C0617i iVar = (C0617i) o;
            if (this.name == null) {
                if (iVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(iVar.name)) {
                return false;
            }
            if (this.f1635fS == null) {
                if (iVar.f1635fS != null) {
                    return false;
                }
            } else if (!this.f1635fS.equals(iVar.f1635fS)) {
                return false;
            }
            if (this.f1636fT == null) {
                if (iVar.f1636fT != null) {
                    return false;
                }
            } else if (!this.f1636fT.equals(iVar.f1636fT)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return iVar.aae == null || iVar.aae.isEmpty();
            }
            return this.aae.equals(iVar.aae);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f1636fT == null ? 0 : this.f1636fT.hashCode()) + (((this.f1635fS == null ? 0 : this.f1635fS.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (this.aae != null && !this.aae.isEmpty()) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: j */
        public C0617i mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 10:
                        this.name = jyVar.readString();
                        continue;
                    case 18:
                        if (this.f1635fS == null) {
                            this.f1635fS = new C0661a();
                        }
                        jyVar.mo6368a(this.f1635fS);
                        continue;
                    case 26:
                        if (this.f1636fT == null) {
                            this.f1636fT = new C0612d();
                        }
                        jyVar.mo6368a(this.f1636fT);
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

        /* renamed from: p */
        public C0617i mo4736p() {
            this.name = "";
            this.f1635fS = null;
            this.f1636fT = null;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.c$j */
    public static final class C0618j extends C1144ka<C0618j> {

        /* renamed from: fU */
        public C0617i[] f1637fU;

        /* renamed from: fV */
        public C0614f f1638fV;

        /* renamed from: fW */
        public String f1639fW;

        public C0618j() {
            mo4740q();
        }

        /* renamed from: b */
        public static C0618j m1402b(byte[] bArr) throws C1147kd {
            return (C0618j) C1148ke.m3471a(new C0618j(), bArr);
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            if (this.f1637fU != null && this.f1637fU.length > 0) {
                for (C0617i iVar : this.f1637fU) {
                    if (iVar != null) {
                        jzVar.mo6397a(1, (C1148ke) iVar);
                    }
                }
            }
            if (this.f1638fV != null) {
                jzVar.mo6397a(2, (C1148ke) this.f1638fV);
            }
            if (!this.f1639fW.equals("")) {
                jzVar.mo6401b(3, this.f1639fW);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c();
            if (this.f1637fU != null && this.f1637fU.length > 0) {
                for (C0617i iVar : this.f1637fU) {
                    if (iVar != null) {
                        c += C1140jz.m3413b(1, (C1148ke) iVar);
                    }
                }
            }
            if (this.f1638fV != null) {
                c += C1140jz.m3413b(2, (C1148ke) this.f1638fV);
            }
            if (!this.f1639fW.equals("")) {
                c += C1140jz.m3425g(3, this.f1639fW);
            }
            this.f3121DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C0618j)) {
                return false;
            }
            C0618j jVar = (C0618j) o;
            if (!C1146kc.equals((Object[]) this.f1637fU, (Object[]) jVar.f1637fU)) {
                return false;
            }
            if (this.f1638fV == null) {
                if (jVar.f1638fV != null) {
                    return false;
                }
            } else if (!this.f1638fV.equals(jVar.f1638fV)) {
                return false;
            }
            if (this.f1639fW == null) {
                if (jVar.f1639fW != null) {
                    return false;
                }
            } else if (!this.f1639fW.equals(jVar.f1639fW)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return jVar.aae == null || jVar.aae.isEmpty();
            }
            return this.aae.equals(jVar.aae);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f1639fW == null ? 0 : this.f1639fW.hashCode()) + (((this.f1638fV == null ? 0 : this.f1638fV.hashCode()) + ((C1146kc.hashCode((Object[]) this.f1637fU) + 527) * 31)) * 31)) * 31;
            if (this.aae != null && !this.aae.isEmpty()) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: k */
        public C0618j mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 10:
                        int c = C1151kh.m3486c(jyVar, 10);
                        int length = this.f1637fU == null ? 0 : this.f1637fU.length;
                        C0617i[] iVarArr = new C0617i[(c + length)];
                        if (length != 0) {
                            System.arraycopy(this.f1637fU, 0, iVarArr, 0, length);
                        }
                        while (length < iVarArr.length - 1) {
                            iVarArr[length] = new C0617i();
                            jyVar.mo6368a(iVarArr[length]);
                            jyVar.mo6390ky();
                            length++;
                        }
                        iVarArr[length] = new C0617i();
                        jyVar.mo6368a(iVarArr[length]);
                        this.f1637fU = iVarArr;
                        continue;
                    case 18:
                        if (this.f1638fV == null) {
                            this.f1638fV = new C0614f();
                        }
                        jyVar.mo6368a(this.f1638fV);
                        continue;
                    case 26:
                        this.f1639fW = jyVar.readString();
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

        /* renamed from: q */
        public C0618j mo4740q() {
            this.f1637fU = C0617i.m1396o();
            this.f1638fV = null;
            this.f1639fW = "";
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }
    }
}
