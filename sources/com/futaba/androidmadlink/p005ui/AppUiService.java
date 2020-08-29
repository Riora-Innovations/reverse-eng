package com.futaba.androidmadlink.p005ui;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.IActivityCallback;

/* renamed from: com.futaba.androidmadlink.ui.AppUiService */
public class AppUiService {
    public static final boolean IS_DEBUG = true;
    public static IActivityCallback activityCallback = null;

    public static void ShowMsgDialog(Context ctx, String title, String msg) {
        Builder myAlertDialog = new Builder(ctx);
        myAlertDialog.setTitle(title);
        View theView = LayoutInflater.from(ctx).inflate(C0112R.layout.alert_content, null);
        ((TextView) theView.findViewById(C0112R.C0114id.textView1)).setText(msg);
        myAlertDialog.setView(theView);
        myAlertDialog.setNeutralButton("OK", new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        myAlertDialog.show();
    }

    public static void Vibrate(Context ctx) {
        ((Vibrator) ctx.getSystemService("vibrator")).vibrate(50);
    }
}
