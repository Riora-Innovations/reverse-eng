package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.p */
public class C1156p {

    /* renamed from: ka */
    private final C1154n f3127ka;

    /* renamed from: kt */
    private final SecureRandom f3128kt;

    /* renamed from: com.google.android.gms.internal.p$a */
    public class C1157a extends Exception {
        public C1157a() {
        }

        public C1157a(Throwable th) {
            super(th);
        }
    }

    public C1156p(C1154n nVar, SecureRandom secureRandom) {
        this.f3127ka = nVar;
        this.f3128kt = secureRandom;
    }

    /* renamed from: c */
    static void m3501c(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ 68);
        }
    }

    /* renamed from: c */
    public byte[] mo6438c(byte[] bArr, String str) throws C1157a {
        if (bArr.length != 16) {
            throw new C1157a();
        }
        try {
            byte[] a = this.f3127ka.mo4988a(str, false);
            if (a.length <= 16) {
                throw new C1157a();
            }
            ByteBuffer allocate = ByteBuffer.allocate(a.length);
            allocate.put(a);
            allocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[(a.length - 16)];
            allocate.get(bArr2);
            allocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr3);
        } catch (NoSuchAlgorithmException e) {
            throw new C1157a(e);
        } catch (InvalidKeyException e2) {
            throw new C1157a(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new C1157a(e3);
        } catch (NoSuchPaddingException e4) {
            throw new C1157a(e4);
        } catch (BadPaddingException e5) {
            throw new C1157a(e5);
        } catch (InvalidAlgorithmParameterException e6) {
            throw new C1157a(e6);
        } catch (IllegalArgumentException e7) {
            throw new C1157a(e7);
        }
    }

    /* renamed from: d */
    public byte[] mo6439d(String str) throws C1157a {
        try {
            byte[] a = this.f3127ka.mo4988a(str, false);
            if (a.length != 32) {
                throw new C1157a();
            }
            byte[] bArr = new byte[16];
            ByteBuffer.wrap(a, 4, 16).get(bArr);
            m3501c(bArr);
            return bArr;
        } catch (IllegalArgumentException e) {
            throw new C1157a(e);
        }
    }
}
