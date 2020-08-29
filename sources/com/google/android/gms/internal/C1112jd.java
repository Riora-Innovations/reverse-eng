package com.google.android.gms.internal;

import com.google.android.gms.internal.C0608c.C0614f;
import com.google.android.gms.internal.C0608c.C0618j;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.jd */
public interface C1112jd {

    /* renamed from: com.google.android.gms.internal.jd$a */
    public static final class C1113a extends C1144ka<C1113a> {

        /* renamed from: Yb */
        public long f3070Yb;

        /* renamed from: Yc */
        public C0618j f3071Yc;

        /* renamed from: fV */
        public C0614f f3072fV;

        public C1113a() {
            mo6288kw();
        }

        /* renamed from: l */
        public static C1113a m3317l(byte[] bArr) throws C1147kd {
            return (C1113a) C1148ke.m3471a(new C1113a(), bArr);
        }

        /* renamed from: a */
        public void mo3797a(C1140jz jzVar) throws IOException {
            jzVar.mo6400b(1, this.f3070Yb);
            if (this.f3072fV != null) {
                jzVar.mo6397a(2, (C1148ke) this.f3072fV);
            }
            if (this.f3071Yc != null) {
                jzVar.mo6397a(3, (C1148ke) this.f3071Yc);
            }
            super.mo3797a(jzVar);
        }

        /* renamed from: c */
        public int mo3799c() {
            int c = super.mo3799c() + C1140jz.m3421d(1, this.f3070Yb);
            if (this.f3072fV != null) {
                c += C1140jz.m3413b(2, (C1148ke) this.f3072fV);
            }
            if (this.f3071Yc != null) {
                c += C1140jz.m3413b(3, (C1148ke) this.f3071Yc);
            }
            this.f3121DY = c;
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1113a)) {
                return false;
            }
            C1113a aVar = (C1113a) o;
            if (this.f3070Yb != aVar.f3070Yb) {
                return false;
            }
            if (this.f3072fV == null) {
                if (aVar.f3072fV != null) {
                    return false;
                }
            } else if (!this.f3072fV.equals(aVar.f3072fV)) {
                return false;
            }
            if (this.f3071Yc == null) {
                if (aVar.f3071Yc != null) {
                    return false;
                }
            } else if (!this.f3071Yc.equals(aVar.f3071Yc)) {
                return false;
            }
            if (this.aae == null || this.aae.isEmpty()) {
                return aVar.aae == null || aVar.aae.isEmpty();
            }
            return this.aae.equals(aVar.aae);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f3071Yc == null ? 0 : this.f3071Yc.hashCode()) + (((this.f3072fV == null ? 0 : this.f3072fV.hashCode()) + ((((int) (this.f3070Yb ^ (this.f3070Yb >>> 32))) + 527) * 31)) * 31)) * 31;
            if (this.aae != null && !this.aae.isEmpty()) {
                i = this.aae.hashCode();
            }
            return hashCode + i;
        }

        /* renamed from: kw */
        public C1113a mo6288kw() {
            this.f3070Yb = 0;
            this.f3072fV = null;
            this.f3071Yc = null;
            this.aae = null;
            this.f3121DY = -1;
            return this;
        }

        /* renamed from: n */
        public C1113a mo3798b(C1139jy jyVar) throws IOException {
            while (true) {
                int ky = jyVar.mo6390ky();
                switch (ky) {
                    case 0:
                        break;
                    case 8:
                        this.f3070Yb = jyVar.mo6379kA();
                        continue;
                    case 18:
                        if (this.f3072fV == null) {
                            this.f3072fV = new C0614f();
                        }
                        jyVar.mo6368a(this.f3072fV);
                        continue;
                    case 26:
                        if (this.f3071Yc == null) {
                            this.f3071Yc = new C0618j();
                        }
                        jyVar.mo6368a(this.f3071Yc);
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
    }
}
