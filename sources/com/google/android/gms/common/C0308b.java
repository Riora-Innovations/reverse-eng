package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.FragmentManager;
import com.google.android.gms.internal.C0766er;

/* renamed from: com.google.android.gms.common.b */
public class C0308b extends DialogFragment {
    private Dialog mDialog = null;

    /* renamed from: yK */
    private OnCancelListener f560yK = null;

    /* renamed from: a */
    public static C0308b m499a(Dialog dialog, OnCancelListener onCancelListener) {
        C0308b bVar = new C0308b();
        Dialog dialog2 = (Dialog) C0766er.m1975b(dialog, (Object) "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        bVar.mDialog = dialog2;
        if (onCancelListener != null) {
            bVar.f560yK = onCancelListener;
        }
        return bVar;
    }

    public void onCancel(DialogInterface dialog) {
        if (this.f560yK != null) {
            this.f560yK.onCancel(dialog);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return this.mDialog;
    }

    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
    }
}
