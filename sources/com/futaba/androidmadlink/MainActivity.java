package com.futaba.androidmadlink;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.futaba.androidmadlink.config.CreateSettingsXml;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.util.XMLHelper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.w3c.dom.NodeList;

public class MainActivity extends Activity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        String fileStoragePath;
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        setContentView(C0112R.layout.main);
        String str = "";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            fileStoragePath = Environment.getExternalStorageDirectory().getPath();
        } else {
            fileStoragePath = getFilesDir().getPath();
        }
        Parameter.setPath(fileStoragePath);
        File vPath = new File(Parameter.rootPath);
        if (!vPath.exists()) {
            vPath.mkdirs();
        }
        setTitle("TMA-1  " + Parameter.getVerName(this));
        ReadSetFromXml();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0112R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent();
        switch (item.getItemId()) {
            case C0112R.C0114id.action_set /*2131165345*/:
                intent.setClass(this, SettingActivity.class);
                startActivity(intent);
                break;
            case C0112R.C0114id.action_about /*2131165346*/:
                intent.setClass(this, AboutActivity.class);
                startActivity(intent);
                break;
            case C0112R.C0114id.action_quit /*2131165347*/:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "MainActivity.onStart()");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(Parameter.TAG, "MainActivity.onPause()");
        super.onPause();
    }

    public void onStop() {
        Log.d(Parameter.TAG, "MainActivity.onStop()");
        super.onStop();
    }

    public void onDestroy() {
        Log.e(Parameter.TAG, "MainActivity.onDestroy");
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.d(Parameter.TAG, "MainActivity.onResume()");
    }

    public void btnGaugeClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, GaugeActivity.class);
        startActivity(intent);
    }

    public void btnMapClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, MapActivity.class);
        startActivity(intent);
    }

    public void btnLogClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, LogActivity.class);
        startActivity(intent);
    }

    public void btnSystemSetClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this, SystemSetActivity.class);
        startActivity(intent);
    }

    public void btnManual(View view) {
        String fileName;
        String str = "";
        if (getString(C0112R.string.manual).contains("マニュアル")) {
            fileName = "TMA-1_Manual_JA.pdf";
        } else {
            fileName = "TMA-1_Manual.pdf";
        }
        CopyReadAssets(fileName);
    }

    private void CopyReadAssets(String fileName) {
        AssetManager assetManager = getAssets();
        File file = new File(getFilesDir(), fileName);
        try {
            InputStream in = assetManager.open(fileName);
            OutputStream out = openFileOutput(file.getName(), 1);
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/" + fileName), "application/pdf");
        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        while (true) {
            int read = in.read(buffer);
            if (read != -1) {
                out.write(buffer, 0, read);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void ReadSetFromXml() {
        int i = 0;
        try {
            CreateSettingsXml.CreateXmlSettings();
            NodeList setNodes = XMLHelper.getNodeLists(Parameter.FILE_EXT_SETTING);
            if (setNodes != null) {
                Parameter.setAlertSound(XMLHelper.Help_getNodeValueByName(setNodes.item(0), "AlertSound"));
                String ScreenModeString = XMLHelper.Help_getNodeValueByName(setNodes.item(0), "ScreenMode").trim();
                if (!ScreenModeString.equals("")) {
                    i = Integer.valueOf(ScreenModeString).intValue();
                }
                Parameter.setScreenMode(i);
            }
        } catch (Exception e) {
            Log.d(Parameter.TAG, "MainActivity ReadSetFromXml Error:" + e.getMessage());
        }
    }
}
