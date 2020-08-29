package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.gc */
public final class C0899gc implements RealTimeSocket {
    private static final String TAG = C0899gc.class.getSimpleName();

    /* renamed from: AC */
    private final ParcelFileDescriptor f2484AC;

    /* renamed from: HA */
    private final OutputStream f2485HA;

    /* renamed from: Hz */
    private final InputStream f2486Hz;

    C0899gc(ParcelFileDescriptor parcelFileDescriptor) {
        this.f2484AC = parcelFileDescriptor;
        this.f2486Hz = new AutoCloseInputStream(parcelFileDescriptor);
        this.f2485HA = new AutoCloseOutputStream(parcelFileDescriptor);
    }

    public void close() throws IOException {
        this.f2484AC.close();
    }

    public InputStream getInputStream() throws IOException {
        return this.f2486Hz;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.f2485HA;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() throws IOException {
        return this.f2484AC;
    }

    public boolean isClosed() {
        try {
            this.f2486Hz.available();
            return false;
        } catch (IOException e) {
            return true;
        }
    }
}
