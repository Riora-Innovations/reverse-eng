package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.C1167v.C1168a;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

/* renamed from: com.google.android.gms.internal.cp */
public final class C0644cp {

    /* renamed from: op */
    private static final Object f1752op = new Object();

    /* renamed from: pu */
    public static final String f1753pu;

    /* renamed from: pv */
    private static C0645cq f1754pv = new C0645cq(f1753pu);

    /* renamed from: pw */
    private static BigInteger f1755pw = BigInteger.ONE;

    /* renamed from: px */
    private static HashSet<C0642co> f1756px = new HashSet<>();

    /* renamed from: py */
    private static HashMap<String, C0646cr> f1757py = new HashMap<>();

    static {
        UUID randomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(randomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(randomUUID.getMostSignificantBits()).toByteArray();
        String bigInteger = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(byteArray);
                instance.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(instance.digest(), 0, bArr, 0, 8);
                bigInteger = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException e) {
            }
        }
        f1753pu = bigInteger;
    }

    /* renamed from: a */
    public static Bundle m1483a(C1168a aVar, String str, Context context) {
        Bundle bundle;
        synchronized (f1752op) {
            bundle = new Bundle();
            bundle.putBundle("app", f1754pv.mo4783b(str, context));
            Bundle bundle2 = new Bundle();
            for (String str2 : f1757py.keySet()) {
                bundle2.putBundle(str2, ((C0646cr) f1757py.get(str2)).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it = f1756px.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0642co) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            aVar.mo6452a(f1756px);
            f1756px = new HashSet<>();
        }
        return bundle;
    }

    /* renamed from: a */
    public static void m1484a(C0642co coVar) {
        synchronized (f1752op) {
            f1756px.add(coVar);
        }
    }

    /* renamed from: a */
    public static void m1485a(C1168a aVar) {
        synchronized (f1752op) {
            f1756px.addAll(aVar.mo6453ah());
        }
    }

    /* renamed from: a */
    public static void m1486a(String str, C0646cr crVar) {
        synchronized (f1752op) {
            f1757py.put(str, crVar);
        }
    }

    /* renamed from: aP */
    public static String m1487aP() {
        String bigInteger;
        synchronized (f1752op) {
            bigInteger = f1755pw.toString();
            f1755pw = f1755pw.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    /* renamed from: aQ */
    public static C0645cq m1488aQ() {
        C0645cq cqVar;
        synchronized (f1752op) {
            cqVar = f1754pv;
        }
        return cqVar;
    }
}
