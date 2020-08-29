package com.futaba.androidmadlink;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.p005ui.AppUiService;
import com.futaba.androidmadlink.util.XMLHelper;
import org.w3c.dom.NodeList;

public class SettingActivity extends Activity {
    public static final String TAG = "SetFragment";
    private RadioGroup btnGroup;
    private OnCheckedChangeListener mChangeRadio = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            try {
                if (checkedId == SettingActivity.this.optValue1.getId()) {
                    Parameter.setScreenMode(0);
                    SettingActivity.this.optValue1.setChecked(true);
                    SettingActivity.this.optValue2.setChecked(false);
                } else if (checkedId == SettingActivity.this.optValue2.getId()) {
                    Parameter.setScreenMode(1);
                    SettingActivity.this.optValue1.setChecked(false);
                    SettingActivity.this.optValue2.setChecked(true);
                }
            } catch (Exception e) {
                Log.e(Parameter.TAG, "SetFragment mChangeRadio Error:" + e.getMessage());
            }
            SettingActivity.this.WriteSetToXml("ScreenMode");
        }
    };
    /* access modifiers changed from: private */
    public RadioButton optValue1;
    /* access modifiers changed from: private */
    public RadioButton optValue2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        setContentView(C0112R.layout.setting);
        this.optValue1 = (RadioButton) findViewById(C0112R.C0114id.radioMode1);
        this.optValue2 = (RadioButton) findViewById(C0112R.C0114id.radioMode2);
        LoadData();
        this.btnGroup = (RadioGroup) findViewById(C0112R.C0114id.radioGroup1);
        this.btnGroup.setOnCheckedChangeListener(this.mChangeRadio);
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "SettingActivity.onStart()");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.d(Parameter.TAG, "SettingActivity.onResume()");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        Log.d(Parameter.TAG, "SettingActivity.onPause()");
        super.onPause();
    }

    public void onStop() {
        Log.d(Parameter.TAG, "SettingActivity.onStop()");
        super.onStop();
    }

    public void onDestroy() {
        Log.e(Parameter.TAG, "SettingActivity.onDestroy");
        super.onDestroy();
    }

    private void LoadData() {
        try {
            ReadSetFromXml();
            switch (Parameter.getScreenMode()) {
                case 1:
                    this.optValue1.setChecked(false);
                    this.optValue2.setChecked(true);
                    return;
                default:
                    this.optValue1.setChecked(true);
                    this.optValue2.setChecked(false);
                    return;
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "SetFragment LoadData Error:" + e.getMessage());
        }
    }

    public void alertSountSet(View v) {
        Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
        intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
        intent.putExtra("android.intent.extra.ringtone.TITLE", getString(C0112R.string.labAlertSound));
        startActivityForResult(intent, 0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1) {
            Parameter.setAlertSound(data.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI").toString());
            WriteSetToXml("AlertSound");
        }
    }

    public void DefaultSet(View v) {
        new Builder(this).setTitle(getString(C0112R.string.labDefault)).setPositiveButton(getString(C0112R.string.btnConfirm), new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                SettingActivity.this.WriteSetToXml("DefaultSet");
            }
        }).setNegativeButton(getString(C0112R.string.cancel), new OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        }).show();
    }

    /* access modifiers changed from: protected */
    public void ReadSetFromXml() {
        int i = 0;
        NodeList setNodes = XMLHelper.getNodeLists(Parameter.FILE_EXT_SETTING);
        if (setNodes != null) {
            Parameter.setAlertSound(XMLHelper.Help_getNodeValueByName(setNodes.item(0), "AlertSound"));
            String ScreenModeString = XMLHelper.Help_getNodeValueByName(setNodes.item(0), "ScreenMode").trim();
            if (!ScreenModeString.equals("")) {
                i = Integer.valueOf(ScreenModeString).intValue();
            }
            Parameter.setScreenMode(i);
        }
    }

    /* access modifiers changed from: protected */
    public void WriteSetToXml(String nodeName) {
        NodeList setNodes = XMLHelper.getNodeLists(Parameter.FILE_EXT_SETTING);
        if (setNodes != null) {
            NodeList setNode = setNodes.item(0).getChildNodes();
            try {
                if (nodeName.equals("AlertSound")) {
                    XMLHelper.updateNode(setNode, "AlertSound", Parameter.getAlertSound());
                    XMLHelper.save();
                }
                if (nodeName.equals("ScreenMode")) {
                    XMLHelper.updateNode(setNode, "ScreenMode", String.valueOf(Parameter.getScreenMode()).trim());
                    XMLHelper.save();
                }
                if (nodeName.equals("DefaultSet")) {
                    XMLHelper.updateNode(setNode, "AlertSound", "");
                    XMLHelper.updateNode(setNode, "ScreenMode", "0");
                    Parameter.setAlertSound("");
                    Parameter.setScreenMode(0);
                    this.optValue1.setChecked(true);
                    this.optValue2.setChecked(false);
                    XMLHelper.save();
                }
                AppUiService.ShowMsgDialog(this, getString(C0112R.string.labSetSuccessTitle), getString(C0112R.string.labSetSuccess2));
            } catch (Exception e) {
                Log.e(Parameter.TAG, "SetActivity WriteSetToXml Error:" + e.getMessage());
                AppUiService.ShowMsgDialog(this, getString(C0112R.string.labSetErrorTitle), getString(C0112R.string.labSetError2));
            }
        }
    }
}
