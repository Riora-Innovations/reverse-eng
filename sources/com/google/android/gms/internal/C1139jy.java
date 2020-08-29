package com.google.android.gms.internal;

import com.ftdi.j2xx.D2xxManager;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.jy */
public final class C1139jy {

    /* renamed from: ZU */
    private int f3112ZU;

    /* renamed from: ZV */
    private int f3113ZV;

    /* renamed from: ZW */
    private int f3114ZW;

    /* renamed from: ZX */
    private int f3115ZX;

    /* renamed from: ZY */
    private int f3116ZY;

    /* renamed from: ZZ */
    private int f3117ZZ = Integer.MAX_VALUE;
    private int aaa;
    private int aab = 64;
    private int aac = 67108864;
    private final byte[] buffer;

    private C1139jy(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.f3112ZU = i;
        this.f3113ZV = i + i2;
        this.f3115ZX = i;
    }

    /* renamed from: a */
    public static C1139jy m3381a(byte[] bArr, int i, int i2) {
        return new C1139jy(bArr, i, i2);
    }

    /* renamed from: kI */
    private void m3382kI() {
        this.f3113ZV += this.f3114ZW;
        int i = this.f3113ZV;
        if (i > this.f3117ZZ) {
            this.f3114ZW = i - this.f3117ZZ;
            this.f3113ZV -= this.f3114ZW;
            return;
        }
        this.f3114ZW = 0;
    }

    /* renamed from: n */
    public static C1139jy m3383n(byte[] bArr) {
        return m3381a(bArr, 0, bArr.length);
    }

    /* renamed from: w */
    public static long m3384w(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    /* renamed from: a */
    public void mo6368a(C1148ke keVar) throws IOException {
        int kE = mo6383kE();
        if (this.aaa >= this.aab) {
            throw C1147kd.m3470kU();
        }
        int cw = mo6373cw(kE);
        this.aaa++;
        keVar.mo3798b(this);
        mo6371cu(0);
        this.aaa--;
        mo6374cx(cw);
    }

    /* renamed from: a */
    public void mo6369a(C1148ke keVar, int i) throws IOException {
        if (this.aaa >= this.aab) {
            throw C1147kd.m3470kU();
        }
        this.aaa++;
        keVar.mo3798b(this);
        mo6371cu(C1151kh.m3489i(i, 4));
        this.aaa--;
    }

    /* renamed from: cA */
    public void mo6370cA(int i) throws IOException {
        if (i < 0) {
            throw C1147kd.m3465kP();
        } else if (this.f3115ZX + i > this.f3117ZZ) {
            mo6370cA(this.f3117ZZ - this.f3115ZX);
            throw C1147kd.m3464kO();
        } else if (i <= this.f3113ZV - this.f3115ZX) {
            this.f3115ZX += i;
        } else {
            throw C1147kd.m3464kO();
        }
    }

    /* renamed from: cu */
    public void mo6371cu(int i) throws C1147kd {
        if (this.f3116ZY != i) {
            throw C1147kd.m3468kS();
        }
    }

    /* renamed from: cv */
    public boolean mo6372cv(int i) throws IOException {
        switch (C1151kh.m3487cJ(i)) {
            case 0:
                mo6380kB();
                return true;
            case 1:
                mo6386kH();
                return true;
            case 2:
                mo6370cA(mo6383kE());
                return true;
            case 3:
                mo6391kz();
                mo6371cu(C1151kh.m3489i(C1151kh.m3488cK(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                mo6385kG();
                return true;
            default:
                throw C1147kd.m3469kT();
        }
    }

    /* renamed from: cw */
    public int mo6373cw(int i) throws C1147kd {
        if (i < 0) {
            throw C1147kd.m3465kP();
        }
        int i2 = this.f3115ZX + i;
        int i3 = this.f3117ZZ;
        if (i2 > i3) {
            throw C1147kd.m3464kO();
        }
        this.f3117ZZ = i2;
        m3382kI();
        return i3;
    }

    /* renamed from: cx */
    public void mo6374cx(int i) {
        this.f3117ZZ = i;
        m3382kI();
    }

    /* renamed from: cy */
    public void mo6375cy(int i) {
        if (i > this.f3115ZX - this.f3112ZU) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.f3115ZX - this.f3112ZU));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.f3115ZX = this.f3112ZU + i;
        }
    }

    /* renamed from: cz */
    public byte[] mo6376cz(int i) throws IOException {
        if (i < 0) {
            throw C1147kd.m3465kP();
        } else if (this.f3115ZX + i > this.f3117ZZ) {
            mo6370cA(this.f3117ZZ - this.f3115ZX);
            throw C1147kd.m3464kO();
        } else if (i <= this.f3113ZV - this.f3115ZX) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.f3115ZX, bArr, 0, i);
            this.f3115ZX += i;
            return bArr;
        } else {
            throw C1147kd.m3464kO();
        }
    }

    /* renamed from: e */
    public byte[] mo6377e(int i, int i2) {
        if (i2 == 0) {
            return C1151kh.aaq;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.f3112ZU + i, bArr, 0, i2);
        return bArr;
    }

    public int getPosition() {
        return this.f3115ZX - this.f3112ZU;
    }

    /* renamed from: kA */
    public long mo6379kA() throws IOException {
        return mo6384kF();
    }

    /* renamed from: kB */
    public int mo6380kB() throws IOException {
        return mo6383kE();
    }

    /* renamed from: kC */
    public boolean mo6381kC() throws IOException {
        return mo6383kE() != 0;
    }

    /* renamed from: kD */
    public long mo6382kD() throws IOException {
        return m3384w(mo6384kF());
    }

    /* renamed from: kE */
    public int mo6383kE() throws IOException {
        byte kL = mo6389kL();
        if (kL >= 0) {
            return kL;
        }
        byte b = kL & Byte.MAX_VALUE;
        byte kL2 = mo6389kL();
        if (kL2 >= 0) {
            return b | (kL2 << 7);
        }
        byte b2 = b | ((kL2 & Byte.MAX_VALUE) << 7);
        byte kL3 = mo6389kL();
        if (kL3 >= 0) {
            return b2 | (kL3 << 14);
        }
        byte b3 = b2 | ((kL3 & Byte.MAX_VALUE) << 14);
        byte kL4 = mo6389kL();
        if (kL4 >= 0) {
            return b3 | (kL4 << 21);
        }
        byte b4 = b3 | ((kL4 & Byte.MAX_VALUE) << 21);
        byte kL5 = mo6389kL();
        byte b5 = b4 | (kL5 << 28);
        if (kL5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (mo6389kL() >= 0) {
                return b5;
            }
        }
        throw C1147kd.m3466kQ();
    }

    /* renamed from: kF */
    public long mo6384kF() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte kL = mo6389kL();
            j |= ((long) (kL & Byte.MAX_VALUE)) << i;
            if ((kL & D2xxManager.FT_DCD) == 0) {
                return j;
            }
        }
        throw C1147kd.m3466kQ();
    }

    /* renamed from: kG */
    public int mo6385kG() throws IOException {
        return (mo6389kL() & 255) | ((mo6389kL() & 255) << 8) | ((mo6389kL() & 255) << 16) | ((mo6389kL() & 255) << 24);
    }

    /* renamed from: kH */
    public long mo6386kH() throws IOException {
        byte kL = mo6389kL();
        byte kL2 = mo6389kL();
        return ((((long) kL2) & 255) << 8) | (((long) kL) & 255) | ((((long) mo6389kL()) & 255) << 16) | ((((long) mo6389kL()) & 255) << 24) | ((((long) mo6389kL()) & 255) << 32) | ((((long) mo6389kL()) & 255) << 40) | ((((long) mo6389kL()) & 255) << 48) | ((((long) mo6389kL()) & 255) << 56);
    }

    /* renamed from: kJ */
    public int mo6387kJ() {
        if (this.f3117ZZ == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f3117ZZ - this.f3115ZX;
    }

    /* renamed from: kK */
    public boolean mo6388kK() {
        return this.f3115ZX == this.f3113ZV;
    }

    /* renamed from: kL */
    public byte mo6389kL() throws IOException {
        if (this.f3115ZX == this.f3113ZV) {
            throw C1147kd.m3464kO();
        }
        byte[] bArr = this.buffer;
        int i = this.f3115ZX;
        this.f3115ZX = i + 1;
        return bArr[i];
    }

    /* renamed from: ky */
    public int mo6390ky() throws IOException {
        if (mo6388kK()) {
            this.f3116ZY = 0;
            return 0;
        }
        this.f3116ZY = mo6383kE();
        if (this.f3116ZY != 0) {
            return this.f3116ZY;
        }
        throw C1147kd.m3467kR();
    }

    /* renamed from: kz */
    public void mo6391kz() throws IOException {
        int ky;
        do {
            ky = mo6390ky();
            if (ky == 0) {
                return;
            }
        } while (mo6372cv(ky));
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(mo6385kG());
    }

    public String readString() throws IOException {
        int kE = mo6383kE();
        if (kE > this.f3113ZV - this.f3115ZX || kE <= 0) {
            return new String(mo6376cz(kE), "UTF-8");
        }
        String str = new String(this.buffer, this.f3115ZX, kE, "UTF-8");
        this.f3115ZX = kE + this.f3115ZX;
        return str;
    }
}
