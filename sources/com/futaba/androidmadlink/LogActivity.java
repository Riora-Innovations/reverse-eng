package com.futaba.androidmadlink;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Paint.Align;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ZoomButton;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.data.ByteArrayConverter;
import com.futaba.androidmadlink.data.LogData;
import com.futaba.androidmadlink.data.LogViewData;
import com.futaba.androidmadlink.file.FileDialog;
import com.futaba.androidmadlink.file.FileOperation;
import com.futaba.androidmadlink.file.OnFileOkListener;
import com.futaba.androidmadlink.util.MathUtil;
import com.futaba.androidmadlink.view.SensorTypes;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.RangeCategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class LogActivity extends Activity {
    private static final String X_LABEL_ms = "Time [ms]";
    private static final String X_LABEL_s = "Time [s]";
    private static final Align[] Y_ALIGN = {Align.LEFT, Align.RIGHT};
    private static final int[] Y_COLOR = {SupportMenu.CATEGORY_MASK, -256};
    private static final PointStyle[] Y_POINT_STYLE = {PointStyle.POINT, PointStyle.POINT};
    private static Map<String, Double[]> valueMap1 = new LinkedHashMap();
    private static Map<String, Double[]> valueMap2 = new LinkedHashMap();
    private static Map<String, Double[]> valueMap3 = new LinkedHashMap();
    String KEY_ALTITUDE;
    private Map<String, Integer> KEY_AXIS;
    private Map<String, Integer> KEY_AXISMin;
    String KEY_ExtVOLTAGE;
    String KEY_PRESSURE;
    String KEY_RPM;
    String KEY_RxVOLTAGE;
    String KEY_SPEED;
    String KEY_TEMPERATURE;
    String KEY_VARIOMETER;
    ArrayAdapter<String> adpSensor = null;
    int altitudeMax = 0;
    int altitudeMin = 0;
    /* access modifiers changed from: private */
    public RadioGroup btnGroup;
    /* access modifiers changed from: private */
    public ZoomButton btnzoomIn;
    /* access modifiers changed from: private */
    public ZoomButton btnzoomOut;
    /* access modifiers changed from: private */
    public ZoomButton btnzoomReset;
    public LinearLayout chart;
    int extVoltageMax = 0;
    int extVoltageMin = 0;
    File file = null;
    private Boolean fristLoad = Boolean.valueOf(false);
    /* access modifiers changed from: private */
    public GraphicalView graphicalView;
    /* access modifiers changed from: private */
    public LinearLayout layout1;
    /* access modifiers changed from: private */
    public LinearLayout layout2;
    /* access modifiers changed from: private */
    public List<LogData> logList = new LinkedList();
    /* access modifiers changed from: private */
    public List<double[]> logRowData1 = new ArrayList();
    /* access modifiers changed from: private */
    public List<Object[]> logRowData2 = new ArrayList();
    /* access modifiers changed from: private */
    public LogViewData logViewData;
    /* access modifiers changed from: private */
    public List<LogViewData> logViewsData = new ArrayList();
    private OnCheckedChangeListener mChangeRadio = new OnCheckedChangeListener() {
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == LogActivity.this.optValue1.getId()) {
                LogActivity.this.drawChart(LogActivity.this.KEY_ALTITUDE);
            } else if (checkedId == LogActivity.this.optValue2.getId()) {
                if (LogActivity.this.optValue2.getText().toString().equals(LogActivity.this.getString(C0112R.string.radioBtnVariometer))) {
                    LogActivity.this.drawChart(LogActivity.this.KEY_VARIOMETER);
                } else {
                    LogActivity.this.drawChart(LogActivity.this.KEY_ExtVOLTAGE);
                }
            } else if (checkedId == LogActivity.this.optValue3.getId()) {
                if (LogActivity.this.optValue1.getText().toString().equals(LogActivity.this.getString(C0112R.string.radioBtnSpeed))) {
                    LogActivity.this.drawChart(LogActivity.this.KEY_SPEED);
                } else {
                    LogActivity.this.drawChart(LogActivity.this.KEY_PRESSURE);
                }
            }
            LogActivity.this.chart.removeAllViews();
            LogActivity.this.chart.addView(LogActivity.this.graphicalView);
        }
    };
    /* access modifiers changed from: private */
    public ProgressDialog mDialog;
    private Handler mHandler = new Handler();
    /* access modifiers changed from: private */
    public SeekBar mSeekBar;
    /* access modifiers changed from: private */
    public boolean mStop;
    int maxCount = 100;
    int msTosNum = 17;
    public RadioGroup optGroup;
    public RadioButton optValue1;
    public RadioButton optValue2;
    public RadioButton optValue3;
    int pressureMax = 0;
    int pressureMin = 0;
    int rangeCount = 60;
    int rpmMax = 0;
    int rpmMin = 0;
    int rxVoltageMax = 0;
    int rxVoltageMin = 0;
    /* access modifiers changed from: private */
    public String[] sensorStrings;
    int speedMax = 0;
    int speedMin = 0;
    /* access modifiers changed from: private */
    public Spinner spin_Sensor;
    int tempratureMax = 0;
    int tempratureMin = 0;
    int totalCount = 0;
    /* access modifiers changed from: private */
    public TextView txtLegend1;
    /* access modifiers changed from: private */
    public TextView txtLegend2;
    /* access modifiers changed from: private */
    public TextView txtServoValue;
    int variometerMax = 0;
    int variometerMin = 0;
    private final int xLabelCount = 10;
    private final float zoomRate = 2.0f;

    class LoadingLogTask extends AsyncTask<String, Long, String> {
        LoadingLogTask() {
        }

        /* access modifiers changed from: protected */
        public String doInBackground(String... arg0) {
            try {
                LogActivity.this.mStop = false;
                Log.d(Parameter.TAG, "ReadSettings Start...");
                LogActivity.this.LoadData();
            } catch (Exception e) {
                Log.e(Parameter.TAG, e.getMessage(), e);
            }
            return "ok";
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            LogActivity.this.mDialog = new ProgressDialog(LogActivity.this);
            LogActivity.this.mDialog.setMessage("Loading...");
            LogActivity.this.mDialog.setCancelable(false);
            LogActivity.this.mDialog.setProgressStyle(1);
            LogActivity.this.mDialog.setButton(LogActivity.this.getString(C0112R.string.cancel), new OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    LogActivity.this.mStop = true;
                }
            });
            LogActivity.this.mDialog.show();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result.equals("ok")) {
                LogActivity.this.mDialog.dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancelled() {
            super.onCancelled();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        Log.d(Parameter.TAG, "LogActivity.onCreate()");
        setContentView(C0112R.layout.log);
        this.KEY_RxVOLTAGE = getString(C0112R.string.logRxVoltage);
        this.KEY_ExtVOLTAGE = getString(C0112R.string.logExtVoltage);
        this.KEY_TEMPERATURE = getString(C0112R.string.logTemperature);
        this.KEY_RPM = getString(C0112R.string.logRPM);
        this.KEY_SPEED = getString(C0112R.string.logSpeed);
        this.KEY_VARIOMETER = getString(C0112R.string.logVariometer);
        this.KEY_PRESSURE = getString(C0112R.string.logPressure);
        this.KEY_ALTITUDE = getString(C0112R.string.logAltitude);
        this.layout1 = (LinearLayout) findViewById(C0112R.C0114id.layout1);
        this.layout2 = (LinearLayout) findViewById(C0112R.C0114id.layout2);
        this.mSeekBar = (SeekBar) findViewById(C0112R.C0114id.seekBar);
        this.txtServoValue = (TextView) findViewById(C0112R.C0114id.txtServoValue);
        this.mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int count, boolean fromTouch) {
                LogActivity.this.txtServoValue.setText(new StringBuilder(String.valueOf(count)).append("/").append(seekBar.getMax()).toString());
                if (fromTouch) {
                    LogActivity.this.getServoView((double[]) LogActivity.this.logRowData1.get(count));
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.txtLegend1 = (TextView) findViewById(C0112R.C0114id.txtLegend1);
        this.txtLegend2 = (TextView) findViewById(C0112R.C0114id.txtLegend2);
        this.spin_Sensor = (Spinner) findViewById(C0112R.C0114id.spin_Sensor);
        this.optValue1 = (RadioButton) findViewById(C0112R.C0114id.optValue1);
        this.optValue2 = (RadioButton) findViewById(C0112R.C0114id.optValue2);
        this.optValue3 = (RadioButton) findViewById(C0112R.C0114id.optValue3);
        this.btnzoomIn = (ZoomButton) findViewById(C0112R.C0114id.zoomIn);
        this.btnzoomOut = (ZoomButton) findViewById(C0112R.C0114id.zoomOut);
        this.btnzoomReset = (ZoomButton) findViewById(C0112R.C0114id.zoomReset);
        this.btnzoomOut.setEnabled(false);
        this.btnzoomIn.setEnabled(false);
        this.btnzoomReset.setEnabled(false);
        this.btnGroup = (RadioGroup) findViewById(C0112R.C0114id.optGroup);
        this.btnGroup.setOnCheckedChangeListener(this.mChangeRadio);
        this.btnGroup.setVisibility(8);
        this.spin_Sensor.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                LogActivity.this.btnGroup.setVisibility(8);
                if (!LogActivity.this.spin_Sensor.getSelectedItem().toString().equals("")) {
                    String str = "";
                    String[] titleData = LogActivity.this.spin_Sensor.getSelectedItem().toString().split("-");
                    String SenserName = titleData[0];
                    int index = Integer.parseInt(titleData[1]);
                    if (SenserName.equals(LogActivity.this.getString(C0112R.string.servo))) {
                        LogActivity.this.layout1.setVisibility(8);
                        LogActivity.this.layout2.setVisibility(0);
                        if (LogActivity.this.logRowData1.size() > 0) {
                            LogActivity.this.mSeekBar.setProgress(0);
                            LogActivity.this.mSeekBar.setMax(LogActivity.this.logRowData1.size() - 1);
                            LogActivity.this.txtServoValue.setText("0/" + LogActivity.this.mSeekBar.getMax());
                            LogActivity.this.getServoView((double[]) LogActivity.this.logRowData1.get(0));
                            return;
                        }
                        return;
                    }
                    LogActivity.this.layout1.setVisibility(0);
                    LogActivity.this.layout2.setVisibility(8);
                    LogActivity.this.logViewData = (LogViewData) LogActivity.this.logViewsData.get(index - 1);
                    if (LogActivity.this.logViewData != null) {
                        LogActivity.this.genDataMap();
                        if (LogActivity.this.graphicalView != null) {
                            LogActivity.this.chart.removeAllViews();
                            LogActivity.this.chart.addView(LogActivity.this.graphicalView);
                        }
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.chart = (LinearLayout) findViewById(C0112R.C0114id.chart);
        this.btnzoomIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    LogActivity.this.graphicalView.zoomIn();
                    LogActivity.this.graphicalView.repaint();
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "LogActivity zoomIn Error:" + e.getMessage());
                }
            }
        });
        this.btnzoomOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    LogActivity.this.graphicalView.zoomOut();
                    LogActivity.this.graphicalView.repaint();
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "LogActivity zoomOut Error:" + e.getMessage());
                }
            }
        });
        this.btnzoomReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    LogActivity.this.graphicalView.zoomReset();
                    LogActivity.this.graphicalView.repaint();
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "LogActivity zoomReset Error:" + e.getMessage());
                }
            }
        });
    }

    public void onStart() {
        super.onStart();
        Log.d(Parameter.TAG, "LogActivity.onStart()");
    }

    public void onStop() {
        Log.d(Parameter.TAG, "LogActivity.onStop()");
        super.onStop();
    }

    public void onDestroy() {
        Log.d(Parameter.TAG, "LogActivity.onDestroy()");
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Log.d(Parameter.TAG, "LogActivity.onResume()");
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.mStop = true;
    }

    public void btnOpenLogClick(View view) {
        final FileDialog f = new FileDialog(this, "Log", Parameter.FILE_EXT_LOG);
        f.setOnFileOkListener(new OnFileOkListener() {
            public void onFileDialog_FileOk() {
                LogActivity.this.file = FileOperation.openFile(f.FileName);
                ((TextView) LogActivity.this.findViewById(C0112R.C0114id.lblDataName)).setText(LogActivity.this.file.getName());
                LogActivity.this.logViewsData.clear();
                LogActivity.this.logRowData1.clear();
                LogActivity.this.logRowData2.clear();
                LogActivity.this.logList.clear();
                LogActivity.this.txtLegend1.setText("");
                LogActivity.this.txtLegend2.setText("");
                LogActivity.this.sensorStrings = new String[0];
                LogActivity.this.adpSensor = new ArrayAdapter<>(LogActivity.this, 17367048, LogActivity.this.sensorStrings);
                LogActivity.this.spin_Sensor.setAdapter(LogActivity.this.adpSensor);
                new LoadingLogTask().execute(new String[0]);
            }
        });
        f.show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0356, code lost:
        r36.sensorStrings = new java.lang.String[(r36.logViewsData.size() + 1)];
        r36.sensorStrings[0] = getString(com.futaba.androidmadlink.C0112R.string.servo) + "-0";
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x03a3, code lost:
        if (r14 < r36.logViewsData.size()) goto L_0x03db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03a5, code lost:
        r0 = new android.widget.ArrayAdapter(r36, 17367048, r36.sensorStrings);
        r36.adpSensor = r0;
        r32 = r36.mHandler;
        r0 = new com.futaba.androidmadlink.LogActivity.C01019(r36);
        r32.post(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:?, code lost:
        r5.close();
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r33 = r36.sensorStrings;
        r34 = r14 + 1;
        r0 = new java.lang.StringBuilder(java.lang.String.valueOf(((com.futaba.androidmadlink.data.LogViewData) r36.logViewsData.get(r14)).getSensorTitle()));
        r33[r34] = r0.append("-").append(r14 + 1).toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x041c, code lost:
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        r36.totalCount = r36.logRowData1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
        if (r36.logRowData1.size() != 0) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (r36.logRowData2.size() != 0) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r32 = r36.mHandler;
        r0 = new com.futaba.androidmadlink.LogActivity.C01008(r36);
        r32.post(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void LoadData() {
        /*
            r36 = this;
            r12 = 0
            java.io.FileReader r13 = new java.io.FileReader     // Catch:{ Exception -> 0x023f }
            r0 = r36
            java.io.File r0 = r0.file     // Catch:{ Exception -> 0x023f }
            r32 = r0
            r0 = r32
            r13.<init>(r0)     // Catch:{ Exception -> 0x023f }
            java.io.LineNumberReader r21 = new java.io.LineNumberReader     // Catch:{ Exception -> 0x0420 }
            r0 = r21
            r0.<init>(r13)     // Catch:{ Exception -> 0x0420 }
            r20 = 0
        L_0x0017:
            java.lang.String r32 = r21.readLine()     // Catch:{ Exception -> 0x0420 }
            if (r32 != 0) goto L_0x007c
            java.io.FileReader r12 = new java.io.FileReader     // Catch:{ Exception -> 0x0420 }
            r0 = r36
            java.io.File r0 = r0.file     // Catch:{ Exception -> 0x0420 }
            r32 = r0
            r0 = r32
            r12.<init>(r0)     // Catch:{ Exception -> 0x0420 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x023f }
            r5.<init>(r12)     // Catch:{ Exception -> 0x023f }
            r19 = 0
            r26 = 0
            java.lang.String r29 = ""
        L_0x0035:
            java.lang.String r31 = r5.readLine()     // Catch:{ Exception -> 0x022d }
            if (r31 != 0) goto L_0x007f
            r0 = r36
            java.util.List<double[]> r0 = r0.logRowData1     // Catch:{ Exception -> 0x022d }
            r32 = r0
            int r32 = r32.size()     // Catch:{ Exception -> 0x022d }
            r0 = r32
            r1 = r36
            r1.totalCount = r0     // Catch:{ Exception -> 0x022d }
            r0 = r36
            java.util.List<double[]> r0 = r0.logRowData1     // Catch:{ Exception -> 0x022d }
            r32 = r0
            int r32 = r32.size()     // Catch:{ Exception -> 0x022d }
            if (r32 != 0) goto L_0x0356
            r0 = r36
            java.util.List<java.lang.Object[]> r0 = r0.logRowData2     // Catch:{ Exception -> 0x022d }
            r32 = r0
            int r32 = r32.size()     // Catch:{ Exception -> 0x022d }
            if (r32 != 0) goto L_0x0356
            r0 = r36
            android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x022d }
            r32 = r0
            com.futaba.androidmadlink.LogActivity$8 r33 = new com.futaba.androidmadlink.LogActivity$8     // Catch:{ Exception -> 0x022d }
            r0 = r33
            r1 = r36
            r0.<init>()     // Catch:{ Exception -> 0x022d }
            r32.post(r33)     // Catch:{ Exception -> 0x022d }
        L_0x0075:
            r5.close()     // Catch:{ Exception -> 0x023f }
            r12.close()     // Catch:{ Exception -> 0x023f }
        L_0x007b:
            return
        L_0x007c:
            int r20 = r20 + 1
            goto L_0x0017
        L_0x007f:
            r0 = r36
            boolean r0 = r0.mStop     // Catch:{ Exception -> 0x022d }
            r32 = r0
            if (r32 != 0) goto L_0x0075
            r32 = 1065353216(0x3f800000, float:1.0)
            float r19 = r19 + r32
            r0 = r20
            float r0 = (float) r0     // Catch:{ Exception -> 0x022d }
            r32 = r0
            float r10 = r19 / r32
            r32 = 1120403456(0x42c80000, float:100.0)
            float r32 = r32 * r10
            r0 = r32
            int r0 = (int) r0     // Catch:{ Exception -> 0x022d }
            r23 = r0
            r0 = r36
            android.app.ProgressDialog r0 = r0.mDialog     // Catch:{ Exception -> 0x022d }
            r32 = r0
            r0 = r32
            r1 = r23
            r0.setProgress(r1)     // Catch:{ Exception -> 0x022d }
            r32 = 1065353216(0x3f800000, float:1.0)
            int r32 = (r19 > r32 ? 1 : (r19 == r32 ? 0 : -1))
            if (r32 != 0) goto L_0x02a6
            org.json.JSONObject r18 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0212 }
            r0 = r18
            r1 = r31
            r0.<init>(r1)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r32 = "views"
            r0 = r18
            r1 = r32
            org.json.JSONArray r16 = r0.getJSONArray(r1)     // Catch:{ JSONException -> 0x0212 }
            r14 = 0
        L_0x00c2:
            int r32 = r16.length()     // Catch:{ JSONException -> 0x0212 }
            r0 = r32
            if (r14 >= r0) goto L_0x0035
            com.futaba.androidmadlink.data.LogViewData r22 = new com.futaba.androidmadlink.data.LogViewData     // Catch:{ JSONException -> 0x0212 }
            r22.<init>()     // Catch:{ JSONException -> 0x0212 }
            r27 = 0
            r28 = -1
            r0 = r16
            org.json.JSONObject r32 = r0.getJSONObject(r14)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r33 = "SensorType"
            java.lang.String r30 = r32.getString(r33)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r32 = "Voltage"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x0187
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.Voltage     // Catch:{ JSONException -> 0x0212 }
            r28 = 1
        L_0x00ef:
            r0 = r22
            r1 = r27
            r0.setSensorType(r1)     // Catch:{ JSONException -> 0x0212 }
            r0 = r16
            org.json.JSONObject r32 = r0.getJSONObject(r14)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r33 = "SensorTitle"
            java.lang.String r32 = r32.getString(r33)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setSensorTitle(r1)     // Catch:{ JSONException -> 0x0212 }
            java.lang.Integer r32 = java.lang.Integer.valueOf(r28)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setSlotCount(r1)     // Catch:{ JSONException -> 0x0212 }
            r0 = r16
            org.json.JSONObject r32 = r0.getJSONObject(r14)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r33 = "Attributes"
            java.lang.String r4 = r32.getString(r33)     // Catch:{ JSONException -> 0x0212 }
            org.json.JSONObject r17 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0212 }
            r0 = r17
            r0.<init>(r4)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r32 = "Slot"
            r0 = r17
            r1 = r32
            int r32 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0212 }
            java.lang.Integer r32 = java.lang.Integer.valueOf(r32)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setSlot(r1)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r32 = "Voltage"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 != 0) goto L_0x0154
            java.lang.String r32 = "Receiver"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x01f3
        L_0x0154:
            java.lang.String r32 = "ValueMax"
            r0 = r17
            r1 = r32
            int r32 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setMax(r1)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r32 = "Value2Max"
            r0 = r17
            r1 = r32
            int r32 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setMax2(r1)     // Catch:{ JSONException -> 0x0212 }
        L_0x0176:
            r0 = r36
            java.util.List<com.futaba.androidmadlink.data.LogViewData> r0 = r0.logViewsData     // Catch:{ JSONException -> 0x0212 }
            r32 = r0
            r0 = r32
            r1 = r22
            r0.add(r1)     // Catch:{ JSONException -> 0x0212 }
            int r14 = r14 + 1
            goto L_0x00c2
        L_0x0187:
            java.lang.String r32 = "Receiver"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x0199
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.Receiver     // Catch:{ JSONException -> 0x0212 }
            r28 = 1
            goto L_0x00ef
        L_0x0199:
            java.lang.String r32 = "Temperature"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x01ab
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.Temperature     // Catch:{ JSONException -> 0x0212 }
            r28 = 1
            goto L_0x00ef
        L_0x01ab:
            java.lang.String r32 = "RPM"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x01bd
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.RPM     // Catch:{ JSONException -> 0x0212 }
            r28 = 1
            goto L_0x00ef
        L_0x01bd:
            java.lang.String r32 = "Altitude"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x01cf
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.Altitude     // Catch:{ JSONException -> 0x0212 }
            r28 = 3
            goto L_0x00ef
        L_0x01cf:
            java.lang.String r32 = "GPS"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x01e1
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.GPS     // Catch:{ JSONException -> 0x0212 }
            r28 = 8
            goto L_0x00ef
        L_0x01e1:
            java.lang.String r32 = "GPSLocus"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x00ef
            com.futaba.androidmadlink.view.SensorTypes r27 = com.futaba.androidmadlink.view.SensorTypes.GPSLocus     // Catch:{ JSONException -> 0x0212 }
            r28 = 8
            goto L_0x00ef
        L_0x01f3:
            java.lang.String r32 = "RPM"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x024b
            java.lang.String r32 = "Range"
            r0 = r17
            r1 = r32
            double r32 = r0.getDouble(r1)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setRange(r1)     // Catch:{ JSONException -> 0x0212 }
            goto L_0x0176
        L_0x0212:
            r11 = move-exception
            java.lang.String r32 = "TMA1Tool"
            java.lang.StringBuilder r33 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022d }
            java.lang.String r34 = "Log Parser Json Error :"
            r33.<init>(r34)     // Catch:{ Exception -> 0x022d }
            java.lang.String r34 = r11.getMessage()     // Catch:{ Exception -> 0x022d }
            java.lang.StringBuilder r33 = r33.append(r34)     // Catch:{ Exception -> 0x022d }
            java.lang.String r33 = r33.toString()     // Catch:{ Exception -> 0x022d }
            android.util.Log.d(r32, r33)     // Catch:{ Exception -> 0x022d }
            goto L_0x0035
        L_0x022d:
            r11 = move-exception
            java.lang.String r32 = "TMA1Tool"
            java.lang.String r33 = r11.getMessage()     // Catch:{ all -> 0x0274 }
            android.util.Log.e(r32, r33)     // Catch:{ all -> 0x0274 }
            r5.close()     // Catch:{ Exception -> 0x023f }
            r12.close()     // Catch:{ Exception -> 0x023f }
            goto L_0x007b
        L_0x023f:
            r11 = move-exception
        L_0x0240:
            java.lang.String r32 = "TMA1Tool"
            java.lang.String r33 = r11.getMessage()
            android.util.Log.e(r32, r33)
            goto L_0x007b
        L_0x024b:
            java.lang.String r32 = "Altitude"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x0287
            java.lang.String r32 = "RegulateValue"
            r0 = r17
            r1 = r32
            java.lang.String r32 = r0.getString(r1)     // Catch:{ JSONException -> 0x0212 }
            java.lang.String r33 = ""
            boolean r32 = r32.equals(r33)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x027c
            r32 = 0
        L_0x026b:
            r0 = r22
            r1 = r32
            r0.setRegulateValue(r1)     // Catch:{ JSONException -> 0x0212 }
            goto L_0x0176
        L_0x0274:
            r32 = move-exception
            r5.close()     // Catch:{ Exception -> 0x023f }
            r12.close()     // Catch:{ Exception -> 0x023f }
            throw r32     // Catch:{ Exception -> 0x023f }
        L_0x027c:
            java.lang.String r32 = "RegulateValue"
            r0 = r17
            r1 = r32
            double r32 = r0.getDouble(r1)     // Catch:{ JSONException -> 0x0212 }
            goto L_0x026b
        L_0x0287:
            java.lang.String r32 = "Temperature"
            r0 = r30
            r1 = r32
            boolean r32 = r0.equals(r1)     // Catch:{ JSONException -> 0x0212 }
            if (r32 == 0) goto L_0x0176
            java.lang.String r32 = "ValueMax"
            r0 = r17
            r1 = r32
            int r32 = r0.getInt(r1)     // Catch:{ JSONException -> 0x0212 }
            r0 = r22
            r1 = r32
            r0.setMax(r1)     // Catch:{ JSONException -> 0x0212 }
            goto L_0x0176
        L_0x02a6:
            int r26 = r26 + 1
            java.lang.StringBuilder r32 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022d }
            java.lang.String r33 = java.lang.String.valueOf(r29)     // Catch:{ Exception -> 0x022d }
            r32.<init>(r33)     // Catch:{ Exception -> 0x022d }
            java.lang.String r33 = ","
            java.lang.String r34 = ""
            r0 = r31
            r1 = r33
            r2 = r34
            java.lang.String r33 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x022d }
            java.lang.StringBuilder r32 = r32.append(r33)     // Catch:{ Exception -> 0x022d }
            java.lang.String r29 = r32.toString()     // Catch:{ Exception -> 0x022d }
            r32 = 4
            r0 = r26
            r1 = r32
            if (r0 < r1) goto L_0x0035
            byte[] r9 = com.futaba.androidmadlink.data.ByteArrayConverter.hexStringToByteArray(r29)     // Catch:{ Exception -> 0x022d }
            r32 = 24
            r0 = r32
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x022d }
            r24 = r0
            r32 = 96
            r0 = r32
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x022d }
            r25 = r0
            r32 = 32
            r0 = r32
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x022d }
            r6 = 0
            r15 = 1
        L_0x02eb:
            r32 = 196(0xc4, float:2.75E-43)
            r0 = r32
            if (r15 < r0) goto L_0x031b
            java.util.List r8 = com.futaba.androidmadlink.data.ByteArrayConverter.SettingValues(r24)     // Catch:{ Exception -> 0x022d }
            r0 = r25
            java.lang.Object[] r7 = com.futaba.androidmadlink.data.ByteArrayConverter.DataToByteArray(r0, r7)     // Catch:{ Exception -> 0x022d }
            r0 = r36
            java.util.List<double[]> r0 = r0.logRowData1     // Catch:{ Exception -> 0x022d }
            r32 = r0
            r0 = r36
            double[] r33 = r0.setServorValues(r8)     // Catch:{ Exception -> 0x022d }
            r32.add(r33)     // Catch:{ Exception -> 0x022d }
            r0 = r36
            java.util.List<java.lang.Object[]> r0 = r0.logRowData2     // Catch:{ Exception -> 0x022d }
            r32 = r0
            r0 = r32
            r0.add(r7)     // Catch:{ Exception -> 0x022d }
            r26 = 0
            java.lang.String r29 = ""
            goto L_0x0035
        L_0x031b:
            r32 = 49
            r0 = r32
            if (r15 < r0) goto L_0x0327
            r32 = 73
            r0 = r32
            if (r15 <= r0) goto L_0x033f
        L_0x0327:
            r32 = 98
            r0 = r32
            if (r15 < r0) goto L_0x0333
            r32 = 122(0x7a, float:1.71E-43)
            r0 = r32
            if (r15 <= r0) goto L_0x033f
        L_0x0333:
            r32 = 147(0x93, float:2.06E-43)
            r0 = r32
            if (r15 < r0) goto L_0x0342
            r32 = 171(0xab, float:2.4E-43)
            r0 = r32
            if (r15 > r0) goto L_0x0342
        L_0x033f:
            int r15 = r15 + 1
            goto L_0x02eb
        L_0x0342:
            r32 = 24
            r0 = r32
            if (r15 > r0) goto L_0x034f
            int r32 = r15 + -1
            byte r33 = r9[r15]     // Catch:{ Exception -> 0x022d }
            r24[r32] = r33     // Catch:{ Exception -> 0x022d }
            goto L_0x033f
        L_0x034f:
            byte r32 = r9[r15]     // Catch:{ Exception -> 0x022d }
            r25[r6] = r32     // Catch:{ Exception -> 0x022d }
            int r6 = r6 + 1
            goto L_0x033f
        L_0x0356:
            r0 = r36
            java.util.List<com.futaba.androidmadlink.data.LogViewData> r0 = r0.logViewsData     // Catch:{ Exception -> 0x022d }
            r32 = r0
            int r32 = r32.size()     // Catch:{ Exception -> 0x022d }
            int r32 = r32 + 1
            r0 = r32
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch:{ Exception -> 0x022d }
            r32 = r0
            r0 = r32
            r1 = r36
            r1.sensorStrings = r0     // Catch:{ Exception -> 0x022d }
            r0 = r36
            java.lang.String[] r0 = r0.sensorStrings     // Catch:{ Exception -> 0x022d }
            r32 = r0
            r33 = 0
            java.lang.StringBuilder r34 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022d }
            r35 = 2131230779(0x7f08003b, float:1.807762E38)
            r0 = r36
            r1 = r35
            java.lang.String r35 = r0.getString(r1)     // Catch:{ Exception -> 0x022d }
            java.lang.String r35 = java.lang.String.valueOf(r35)     // Catch:{ Exception -> 0x022d }
            r34.<init>(r35)     // Catch:{ Exception -> 0x022d }
            java.lang.String r35 = "-0"
            java.lang.StringBuilder r34 = r34.append(r35)     // Catch:{ Exception -> 0x022d }
            java.lang.String r34 = r34.toString()     // Catch:{ Exception -> 0x022d }
            r32[r33] = r34     // Catch:{ Exception -> 0x022d }
            r14 = 0
        L_0x0397:
            r0 = r36
            java.util.List<com.futaba.androidmadlink.data.LogViewData> r0 = r0.logViewsData     // Catch:{ Exception -> 0x022d }
            r32 = r0
            int r32 = r32.size()     // Catch:{ Exception -> 0x022d }
            r0 = r32
            if (r14 < r0) goto L_0x03db
            android.widget.ArrayAdapter r32 = new android.widget.ArrayAdapter     // Catch:{ Exception -> 0x022d }
            r33 = 17367048(0x1090008, float:2.5162948E-38)
            r0 = r36
            java.lang.String[] r0 = r0.sensorStrings     // Catch:{ Exception -> 0x022d }
            r34 = r0
            r0 = r32
            r1 = r36
            r2 = r33
            r3 = r34
            r0.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x022d }
            r0 = r32
            r1 = r36
            r1.adpSensor = r0     // Catch:{ Exception -> 0x022d }
            r0 = r36
            android.os.Handler r0 = r0.mHandler     // Catch:{ Exception -> 0x022d }
            r32 = r0
            com.futaba.androidmadlink.LogActivity$9 r33 = new com.futaba.androidmadlink.LogActivity$9     // Catch:{ Exception -> 0x022d }
            r0 = r33
            r1 = r36
            r0.<init>()     // Catch:{ Exception -> 0x022d }
            r32.post(r33)     // Catch:{ Exception -> 0x022d }
            r5.close()     // Catch:{ Exception -> 0x023f }
            r12.close()     // Catch:{ Exception -> 0x023f }
            goto L_0x007b
        L_0x03db:
            r0 = r36
            java.lang.String[] r0 = r0.sensorStrings     // Catch:{ Exception -> 0x022d }
            r33 = r0
            int r34 = r14 + 1
            java.lang.StringBuilder r35 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022d }
            r0 = r36
            java.util.List<com.futaba.androidmadlink.data.LogViewData> r0 = r0.logViewsData     // Catch:{ Exception -> 0x022d }
            r32 = r0
            r0 = r32
            java.lang.Object r32 = r0.get(r14)     // Catch:{ Exception -> 0x022d }
            com.futaba.androidmadlink.data.LogViewData r32 = (com.futaba.androidmadlink.data.LogViewData) r32     // Catch:{ Exception -> 0x022d }
            java.lang.String r32 = r32.getSensorTitle()     // Catch:{ Exception -> 0x022d }
            java.lang.String r32 = java.lang.String.valueOf(r32)     // Catch:{ Exception -> 0x022d }
            r0 = r35
            r1 = r32
            r0.<init>(r1)     // Catch:{ Exception -> 0x022d }
            java.lang.String r32 = "-"
            r0 = r35
            r1 = r32
            java.lang.StringBuilder r32 = r0.append(r1)     // Catch:{ Exception -> 0x022d }
            int r35 = r14 + 1
            r0 = r32
            r1 = r35
            java.lang.StringBuilder r32 = r0.append(r1)     // Catch:{ Exception -> 0x022d }
            java.lang.String r32 = r32.toString()     // Catch:{ Exception -> 0x022d }
            r33[r34] = r32     // Catch:{ Exception -> 0x022d }
            int r14 = r14 + 1
            goto L_0x0397
        L_0x0420:
            r11 = move-exception
            r12 = r13
            goto L_0x0240
        */
        throw new UnsupportedOperationException("Method not decompiled: com.futaba.androidmadlink.LogActivity.LoadData():void");
    }

    public void btnClearClick(View view) {
        if (this.fristLoad.booleanValue()) {
            this.fristLoad = Boolean.valueOf(false);
            this.btnzoomOut.setEnabled(false);
            this.btnzoomIn.setEnabled(false);
            this.btnzoomReset.setEnabled(false);
        }
        this.spin_Sensor.setSelection(0);
        this.chart.removeAllViews();
        this.txtLegend1.setText("");
        this.txtLegend2.setText("");
    }

    private double[] setServorValues(List<Integer> dataList) {
        if (dataList == null || dataList.size() <= 0) {
            return null;
        }
        double[] values = new double[18];
        for (int i = 0; i < 18; i++) {
            String value = String.valueOf(dataList.get(i)).trim();
            if (i >= 16) {
                switch (Integer.valueOf(value).intValue()) {
                    case 0:
                        value = "-95.0";
                        break;
                    case 1:
                        value = "95.0";
                        break;
                }
                values[i] = (double) Float.valueOf(value).floatValue();
            } else {
                values[i] = Double.valueOf(String.valueOf(new BigDecimal((((double) Integer.parseInt(value)) * 0.0977039d) - 100.0d).setScale(1, 3))).doubleValue();
            }
        }
        return values;
    }

    /* access modifiers changed from: private */
    public void genDataMap() {
        int i = 10;
        int i2 = 5;
        this.btnGroup.setVisibility(8);
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> mapMin = new HashMap<>();
        if (this.logViewData.getSensorType() == SensorTypes.Receiver || this.logViewData.getSensorType() == SensorTypes.Voltage) {
            this.optValue1.setChecked(true);
            this.optValue1.setText(getString(C0112R.string.radioBtnRx));
            this.optValue2.setText(getString(C0112R.string.radioBtnExt));
            this.optValue3.setVisibility(8);
            this.btnGroup.setVisibility(0);
            setVoltage(this.logViewData);
            map.put(this.KEY_RxVOLTAGE, Integer.valueOf(this.rxVoltageMax == 0 ? 10 : this.rxVoltageMax));
            String str = this.KEY_ExtVOLTAGE;
            if (this.extVoltageMax != 0) {
                i = this.extVoltageMax;
            }
            map.put(str, Integer.valueOf(i));
            this.KEY_AXIS = Collections.unmodifiableMap(map);
            mapMin.put(this.KEY_RxVOLTAGE, Integer.valueOf(this.rxVoltageMin));
            mapMin.put(this.KEY_ExtVOLTAGE, Integer.valueOf(this.extVoltageMin));
            this.KEY_AXISMin = Collections.unmodifiableMap(mapMin);
            drawChart(this.KEY_RxVOLTAGE);
        } else if (this.logViewData.getSensorType() == SensorTypes.Temperature) {
            setTemperature(this.logViewData);
            String str2 = this.KEY_TEMPERATURE;
            if (this.tempratureMax != 0) {
                i = this.tempratureMax;
            }
            map.put(str2, Integer.valueOf(i));
            this.KEY_AXIS = Collections.unmodifiableMap(map);
            mapMin.put(this.KEY_TEMPERATURE, Integer.valueOf(this.tempratureMin));
            this.KEY_AXISMin = Collections.unmodifiableMap(mapMin);
            drawChart(this.KEY_TEMPERATURE);
        } else if (this.logViewData.getSensorType() == SensorTypes.RPM) {
            setRPM(this.logViewData);
            String str3 = this.KEY_RPM;
            if (this.rpmMax != 0) {
                i = this.rpmMax;
            }
            map.put(str3, Integer.valueOf(i));
            this.KEY_AXIS = Collections.unmodifiableMap(map);
            mapMin.put(this.KEY_RPM, Integer.valueOf(this.rpmMin));
            this.KEY_AXISMin = Collections.unmodifiableMap(mapMin);
            drawChart(this.KEY_RPM);
        } else if (this.logViewData.getSensorType() == SensorTypes.Altitude) {
            this.optValue1.setChecked(true);
            this.optValue1.setText(getString(C0112R.string.radioBtnAltitude));
            this.optValue2.setText(getString(C0112R.string.radioBtnVariometer));
            this.optValue3.setVisibility(0);
            this.btnGroup.setVisibility(0);
            setAltitude(this.logViewData);
            map.put(this.KEY_ALTITUDE, Integer.valueOf(this.altitudeMax == 0 ? 5 : this.altitudeMax));
            map.put(this.KEY_VARIOMETER, Integer.valueOf(this.variometerMax == 0 ? 5 : this.variometerMax));
            map.put(this.KEY_PRESSURE, Integer.valueOf(this.pressureMax == 0 ? 5 : this.pressureMax));
            this.KEY_AXIS = Collections.unmodifiableMap(map);
            mapMin.put(this.KEY_ALTITUDE, Integer.valueOf(this.altitudeMin == 0 ? 5 : this.altitudeMin));
            mapMin.put(this.KEY_VARIOMETER, Integer.valueOf(this.variometerMin == 0 ? 5 : this.variometerMin));
            String str4 = this.KEY_PRESSURE;
            if (this.pressureMin != 0) {
                i2 = this.pressureMin;
            }
            mapMin.put(str4, Integer.valueOf(i2));
            this.KEY_AXISMin = Collections.unmodifiableMap(mapMin);
            drawChart(this.KEY_ALTITUDE);
        } else if (this.logViewData.getSensorType() == SensorTypes.GPS || this.logViewData.getSensorType() == SensorTypes.GPSLocus) {
            this.optValue1.setChecked(true);
            this.optValue1.setText(getString(C0112R.string.radioBtnAltitude));
            this.optValue2.setText(getString(C0112R.string.radioBtnVariometer));
            this.optValue3.setText(getString(C0112R.string.radioBtnSpeed));
            this.optValue3.setVisibility(0);
            this.btnGroup.setVisibility(0);
            setGPS(this.logViewData);
            map.put(this.KEY_ALTITUDE, Integer.valueOf(this.altitudeMax == 0 ? 5 : this.altitudeMax));
            map.put(this.KEY_SPEED, Integer.valueOf(this.speedMax == 0 ? 5 : this.speedMax));
            map.put(this.KEY_VARIOMETER, Integer.valueOf(this.variometerMax == 0 ? 5 : this.variometerMax));
            this.KEY_AXIS = Collections.unmodifiableMap(map);
            mapMin.put(this.KEY_ALTITUDE, Integer.valueOf(this.altitudeMin == 0 ? 5 : this.altitudeMin));
            mapMin.put(this.KEY_SPEED, Integer.valueOf(this.speedMin == 0 ? 5 : this.speedMin));
            String str5 = this.KEY_VARIOMETER;
            if (this.variometerMin != 0) {
                i2 = this.variometerMin;
            }
            mapMin.put(str5, Integer.valueOf(i2));
            this.KEY_AXISMin = Collections.unmodifiableMap(mapMin);
            drawChart(this.KEY_SPEED);
        }
    }

    private void setVoltage(LogViewData logViewData2) {
        List<Double> voltageList = new ArrayList<>();
        List<Double> voltageList2 = new ArrayList<>();
        this.rxVoltageMax = 0;
        this.rxVoltageMin = 0;
        this.extVoltageMax = 0;
        this.extVoltageMin = 0;
        int _index = 1;
        if (this.totalCount > this.maxCount) {
            _index = this.msTosNum;
        }
        for (int i = 0; i < this.logRowData2.size(); i += _index) {
            Double valueOf = Double.valueOf(0.0d);
            Double valueOf2 = Double.valueOf(0.0d);
            if (!ByteArrayConverter.SlotsIsNull((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue())) {
                char[] collectChars = ByteArrayConverter.SlotsToBinaryArray((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue(), logViewData2.getSlotCount().intValue());
                if (logViewData2.getSensorType() != SensorTypes.Receiver) {
                    Double fRxValue = Double.valueOf(new BigDecimal(((double) ByteArrayConverter.convertToInt(collectChars, 1, 15)) / 10.0d).setScale(1, 4).toString());
                    if (fRxValue.doubleValue() > ((double) logViewData2.getMax())) {
                        fRxValue = Double.valueOf((double) logViewData2.getMax());
                    }
                    Double fExtValue = Double.valueOf(new BigDecimal(((double) ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue() + 1, logViewData2.getSlotCount().intValue()), 1, 15)) / 10.0d).setScale(1, 4).toString());
                    if (fExtValue.doubleValue() > ((double) logViewData2.getMax2())) {
                        fExtValue = Double.valueOf((double) logViewData2.getMax2());
                    }
                    if (((double) this.extVoltageMax) < fExtValue.doubleValue()) {
                        this.extVoltageMax = ((int) ((fExtValue.doubleValue() / 10.0d) + 1.0d)) * 10;
                        if (this.extVoltageMax > logViewData2.getMax2()) {
                            this.extVoltageMax = logViewData2.getMax2();
                        }
                    }
                    if (i == 0 && ((int) ((fExtValue.doubleValue() / 10.0d) - 1.0d)) >= 0) {
                        this.extVoltageMin = ((int) ((fExtValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                    } else if (((double) this.extVoltageMin) > fExtValue.doubleValue()) {
                        this.extVoltageMin = ((int) ((fExtValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                        if (this.extVoltageMin < 0) {
                            this.extVoltageMin = 0;
                        }
                    }
                    if (((double) this.rxVoltageMax) < fRxValue.doubleValue()) {
                        this.rxVoltageMax = ((int) ((fRxValue.doubleValue() / 10.0d) + 1.0d)) * 10;
                        if (this.rxVoltageMax > logViewData2.getMax()) {
                            this.rxVoltageMax = logViewData2.getMax();
                        }
                    }
                    if (i == 0 && ((int) ((fRxValue.doubleValue() / 10.0d) - 1.0d)) >= 0) {
                        this.rxVoltageMin = ((int) ((fRxValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                    } else if (((double) this.rxVoltageMin) > fRxValue.doubleValue()) {
                        this.rxVoltageMin = ((int) ((fRxValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                        if (this.rxVoltageMin < 0) {
                            this.rxVoltageMin = 0;
                        }
                    }
                    if (this.totalCount > this.maxCount) {
                        voltageList.add(fRxValue);
                        voltageList2.add(fExtValue);
                    } else {
                        for (int j = 0; j < this.rangeCount; j++) {
                            voltageList.add(fRxValue);
                            voltageList2.add(fExtValue);
                        }
                    }
                } else if (ByteArrayConverter.convertToInt(collectChars, 4, 2) == 1) {
                    Double fExtValue2 = Double.valueOf(new BigDecimal(((double) ByteArrayConverter.convertToInt(collectChars, 6, 10)) / 10.0d).setScale(1, 4).toString());
                    if (fExtValue2.doubleValue() > ((double) logViewData2.getMax2())) {
                        fExtValue2 = Double.valueOf((double) logViewData2.getMax2());
                    }
                    if (((double) this.extVoltageMax) < fExtValue2.doubleValue()) {
                        this.extVoltageMax = ((int) ((fExtValue2.doubleValue() / 10.0d) + 1.0d)) * 10;
                        if (this.extVoltageMax > logViewData2.getMax2()) {
                            this.extVoltageMax = logViewData2.getMax2();
                        }
                    }
                    if (i == 0 && ((int) ((fExtValue2.doubleValue() / 10.0d) - 1.0d)) >= 0) {
                        this.extVoltageMin = ((int) ((fExtValue2.doubleValue() / 10.0d) - 1.0d)) * 10;
                    } else if (((double) this.extVoltageMin) > fExtValue2.doubleValue()) {
                        this.extVoltageMin = ((int) ((fExtValue2.doubleValue() / 10.0d) - 1.0d)) * 10;
                        if (this.extVoltageMin < 0) {
                            this.extVoltageMin = 0;
                        }
                    }
                    double voltageValue = 0.0d;
                    if (i == 0 || voltageList.size() == 0) {
                        voltageValue = 0.0d;
                    } else if (i >= 0) {
                        voltageValue = ((Double) voltageList.get(voltageList.size() - 1)).doubleValue();
                    }
                    if (this.totalCount > this.maxCount) {
                        voltageList2.add(fExtValue2);
                        voltageList.add(Double.valueOf(voltageValue));
                    } else {
                        for (int j2 = 0; j2 < this.rangeCount; j2++) {
                            voltageList2.add(fExtValue2);
                            voltageList.add(Double.valueOf(voltageValue));
                        }
                    }
                } else {
                    Double fRxValue2 = Double.valueOf(new BigDecimal(((double) ByteArrayConverter.convertToInt(collectChars, 6, 10)) / 10.0d).setScale(1, 4).toString());
                    if (fRxValue2.doubleValue() > ((double) logViewData2.getMax())) {
                        fRxValue2 = Double.valueOf((double) logViewData2.getMax());
                    }
                    if (((double) this.rxVoltageMax) < fRxValue2.doubleValue()) {
                        this.rxVoltageMax = ((int) ((fRxValue2.doubleValue() / 10.0d) + 1.0d)) * 10;
                        if (this.rxVoltageMax > logViewData2.getMax()) {
                            this.rxVoltageMax = logViewData2.getMax();
                        }
                    }
                    if (i == 0 && ((int) ((fRxValue2.doubleValue() / 10.0d) - 1.0d)) >= 0) {
                        this.rxVoltageMin = ((int) ((fRxValue2.doubleValue() / 10.0d) - 1.0d)) * 10;
                    } else if (((double) this.rxVoltageMin) > fRxValue2.doubleValue()) {
                        this.rxVoltageMin = ((int) ((fRxValue2.doubleValue() / 10.0d) - 1.0d)) * 10;
                        if (this.rxVoltageMin < 0) {
                            this.rxVoltageMin = 0;
                        }
                    }
                    double voltageValue2 = 0.0d;
                    if (i == 0 || voltageList2.size() == 0) {
                        voltageValue2 = 0.0d;
                    } else if (i >= 0) {
                        voltageValue2 = ((Double) voltageList2.get(voltageList2.size() - 1)).doubleValue();
                    }
                    if (this.totalCount > this.maxCount) {
                        voltageList.add(fRxValue2);
                        voltageList2.add(Double.valueOf(voltageValue2));
                    } else {
                        for (int j3 = 0; j3 < this.rangeCount; j3++) {
                            voltageList.add(fRxValue2);
                            voltageList2.add(Double.valueOf(voltageValue2));
                        }
                    }
                }
            }
        }
        valueMap1 = new LinkedHashMap();
        Double[] voltageArray = new Double[voltageList.size()];
        voltageList.toArray(voltageArray);
        valueMap1.put(this.KEY_RxVOLTAGE, voltageArray);
        valueMap2 = new LinkedHashMap();
        Double[] voltageArray2 = new Double[voltageList2.size()];
        voltageList2.toArray(voltageArray2);
        valueMap2.put(this.KEY_ExtVOLTAGE, voltageArray2);
    }

    private void setTemperature(LogViewData logViewData2) {
        List<Double> temperatureList = new ArrayList<>();
        this.tempratureMax = 0;
        this.tempratureMin = 0;
        int _index = 1;
        if (this.totalCount > this.maxCount) {
            _index = this.msTosNum;
        }
        for (int i = 0; i < this.logRowData2.size(); i += _index) {
            Double valueOf = Double.valueOf(0.0d);
            if (!ByteArrayConverter.SlotsIsNull((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue())) {
                Double fValue = Double.valueOf((double) (ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray2((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue(), logViewData2.getSlotCount().intValue()), 1, 15) - 100));
                if (fValue.doubleValue() > ((double) logViewData2.getMax())) {
                    fValue = Double.valueOf((double) logViewData2.getMax());
                } else if (fValue.doubleValue() < -20.0d) {
                    fValue = Double.valueOf(-20.0d);
                }
                if (((double) this.tempratureMax) < fValue.doubleValue()) {
                    this.tempratureMax = ((int) ((fValue.doubleValue() / 10.0d) + 1.0d)) * 10;
                    if (this.tempratureMax > logViewData2.getMax()) {
                        this.tempratureMax = logViewData2.getMax();
                    }
                }
                if (i == 0 && ((int) ((fValue.doubleValue() / 10.0d) - 1.0d)) >= -20) {
                    this.tempratureMin = ((int) ((fValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                } else if (((double) this.tempratureMin) > fValue.doubleValue()) {
                    this.tempratureMin = ((int) ((fValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                    if (this.tempratureMin < -20) {
                        this.tempratureMin = -20;
                    }
                }
                if (this.totalCount > this.maxCount) {
                    temperatureList.add(fValue);
                } else {
                    for (int j = 0; j < this.rangeCount; j++) {
                        temperatureList.add(fValue);
                    }
                }
            }
        }
        Double[] temperatureArray = new Double[temperatureList.size()];
        temperatureList.toArray(temperatureArray);
        valueMap1 = new LinkedHashMap();
        valueMap1.put(this.KEY_TEMPERATURE, temperatureArray);
    }

    private void setRPM(LogViewData logViewData2) {
        List<Double> rpmList = new ArrayList<>();
        this.rpmMax = 0;
        this.rpmMin = 0;
        int _index = 1;
        if (this.totalCount > this.maxCount) {
            _index = this.msTosNum;
        }
        for (int i = 0; i < this.logRowData2.size(); i += _index) {
            if (!ByteArrayConverter.SlotsIsNull((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue())) {
                Double valueOf = Double.valueOf(0.0d);
                Double fValue = Double.valueOf(Double.valueOf((double) ((int) (((double) (ByteArrayConverter.convertToInt(ByteArrayConverter.SlotsToBinaryArray2((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue(), logViewData2.getSlotCount().intValue()), 0, 16) * 6)) / Double.valueOf(logViewData2.getRange()).doubleValue()))).doubleValue() / 1000.0d);
                if (((double) this.rpmMax) < fValue.doubleValue()) {
                    this.rpmMax = ((int) ((fValue.doubleValue() / 10.0d) + 1.0d)) * 10;
                }
                if (i == 0 && ((int) ((fValue.doubleValue() / 10.0d) - 1.0d)) >= 0) {
                    this.rpmMin = ((int) ((fValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                } else if (((double) this.rpmMin) > fValue.doubleValue()) {
                    this.rpmMin = ((int) ((fValue.doubleValue() / 10.0d) - 1.0d)) * 10;
                    if (this.rpmMin < 0) {
                        this.rpmMin = 0;
                    }
                }
                if (this.totalCount > this.maxCount) {
                    rpmList.add(fValue);
                } else {
                    for (int j = 0; j < this.rangeCount; j++) {
                        rpmList.add(fValue);
                    }
                }
            }
        }
        Double[] rpmArray = new Double[rpmList.size()];
        rpmList.toArray(rpmArray);
        valueMap1 = new LinkedHashMap();
        valueMap1.put(this.KEY_RPM, rpmArray);
    }

    private void setAltitude(LogViewData logViewData2) {
        List<Double> altitudeList = new ArrayList<>();
        List<Double> variometerList = new ArrayList<>();
        List<Double> pressureList = new ArrayList<>();
        this.altitudeMax = 0;
        this.altitudeMin = 0;
        this.pressureMax = 0;
        this.pressureMin = 0;
        this.variometerMax = 0;
        this.variometerMin = 0;
        int _index = 1;
        if (this.totalCount > this.maxCount) {
            _index = this.msTosNum;
        }
        for (int i = 0; i < this.logRowData2.size(); i += _index) {
            if (!ByteArrayConverter.SlotsIsNull((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue())) {
                Double valueOf = Double.valueOf(0.0d);
                Double valueOf2 = Double.valueOf(0.0d);
                Double valueOf3 = Double.valueOf(0.0d);
                char[] collectChars = ByteArrayConverter.SlotsToBinaryArray2((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue(), logViewData2.getSlotCount().intValue());
                Double varValue = Double.valueOf((double) ((int) ((((double) ByteArrayConverter.convertToInt(collectChars, 3, 12)) / 10.0d) - 150.0d)));
                Double altValue = Double.valueOf(new BigDecimal((((double) (ByteArrayConverter.convertToInt(collectChars, 15, 16) - 8551)) / 10.0d) - logViewData2.getRegulateValue()).setScale(1, 4).toString());
                Double preValue = Double.valueOf(new BigDecimal(((double) ByteArrayConverter.convertToInt(collectChars, 31, 17)) / 100.0d).setScale(1, 4).toString());
                if (((double) this.altitudeMax) < altValue.doubleValue()) {
                    this.altitudeMax = (int) (altValue.doubleValue() + 10.0d);
                }
                if (((double) this.variometerMax) < varValue.doubleValue()) {
                    this.variometerMax = (((int) (varValue.doubleValue() / 10.0d)) + 2) * 10;
                }
                if (((double) this.pressureMax) < preValue.doubleValue()) {
                    this.pressureMax = (((int) (preValue.doubleValue() / 100.0d)) + 2) * 100;
                }
                if (i == 0) {
                    this.altitudeMin = (int) (altValue.doubleValue() - 10.0d);
                    this.variometerMin = (((int) (varValue.doubleValue() / 10.0d)) - 2) * 10;
                    this.pressureMin = (((int) (preValue.doubleValue() / 100.0d)) - 2) * 100;
                } else {
                    if (((double) this.altitudeMin) > altValue.doubleValue()) {
                        this.altitudeMin = (int) (altValue.doubleValue() - 10.0d);
                    }
                    if (((double) this.variometerMin) > varValue.doubleValue()) {
                        this.variometerMin = (((int) (varValue.doubleValue() / 10.0d)) - 2) * 10;
                    }
                    if (((double) this.pressureMin) > preValue.doubleValue()) {
                        this.pressureMin = (((int) (preValue.doubleValue() / 100.0d)) - 2) * 100;
                    }
                }
                if (this.totalCount > this.maxCount) {
                    altitudeList.add(altValue);
                    variometerList.add(varValue);
                    pressureList.add(preValue);
                } else {
                    for (int j = 0; j < this.rangeCount; j++) {
                        altitudeList.add(altValue);
                        variometerList.add(varValue);
                        pressureList.add(preValue);
                    }
                }
            }
        }
        Double[] altitudeArray = new Double[altitudeList.size()];
        altitudeList.toArray(altitudeArray);
        Double[] variometerArray = new Double[variometerList.size()];
        variometerList.toArray(variometerArray);
        Double[] pressureArray = new Double[pressureList.size()];
        pressureList.toArray(pressureArray);
        valueMap1 = new LinkedHashMap();
        valueMap1.put(this.KEY_ALTITUDE, altitudeArray);
        valueMap2 = new LinkedHashMap();
        valueMap2.put(this.KEY_VARIOMETER, variometerArray);
        valueMap3 = new LinkedHashMap();
        valueMap3.put(this.KEY_PRESSURE, pressureArray);
    }

    private void setGPS(LogViewData logViewData2) {
        List<Double> speedList = new ArrayList<>();
        List<Double> variometerList = new ArrayList<>();
        List<Double> altitudeList = new ArrayList<>();
        this.speedMax = 0;
        this.speedMin = 0;
        this.variometerMax = 0;
        this.variometerMin = 0;
        this.altitudeMax = 0;
        this.altitudeMin = 0;
        int _index = 1;
        if (this.totalCount > this.maxCount) {
            _index = this.msTosNum;
        }
        for (int i = 0; i < this.logRowData2.size(); i += _index) {
            if (!ByteArrayConverter.SlotsIsNull((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue())) {
                Double valueOf = Double.valueOf(0.0d);
                Double valueOf2 = Double.valueOf(0.0d);
                Double valueOf3 = Double.valueOf(0.0d);
                char[] collectChars = ByteArrayConverter.SlotsToBinaryArray2((Object[]) this.logRowData2.get(i), logViewData2.getSlot().intValue(), logViewData2.getSlotCount().intValue());
                Double varValue = Double.valueOf(new BigDecimal((((double) ByteArrayConverter.convertToInt(collectChars, 1, 12)) / 10.0d) - 150.0d).setScale(1, 4).toString());
                Double speedValue = Double.valueOf((double) ByteArrayConverter.convertToInt(collectChars, 47, 9));
                Double altitudeValue = Double.valueOf(new BigDecimal(((double) (ByteArrayConverter.convertToInt(collectChars, 13, 16) - 8551)) / 10.0d).setScale(1, 4).toString());
                if (((double) this.speedMax) < speedValue.doubleValue()) {
                    this.speedMax = (int) (speedValue.doubleValue() + 10.0d);
                }
                if (((double) this.variometerMax) < varValue.doubleValue()) {
                    this.variometerMax = (((int) (varValue.doubleValue() / 10.0d)) + 2) * 10;
                }
                if (((double) this.altitudeMax) < altitudeValue.doubleValue()) {
                    this.altitudeMax = (((int) (altitudeValue.doubleValue() / 10.0d)) + 2) * 10;
                }
                if (i == 0) {
                    this.speedMin = (int) (speedValue.doubleValue() - 10.0d);
                    this.variometerMax = (((int) (varValue.doubleValue() / 10.0d)) - 2) * 10;
                    this.altitudeMax = (((int) (altitudeValue.doubleValue() / 10.0d)) - 2) * 10;
                } else {
                    if (((double) this.speedMin) > speedValue.doubleValue()) {
                        this.speedMin = (int) (speedValue.doubleValue() - 10.0d);
                    }
                    if (((double) this.variometerMin) > varValue.doubleValue()) {
                        this.variometerMin = (((int) (varValue.doubleValue() / 10.0d)) - 2) * 10;
                    }
                    if (((double) this.altitudeMin) > altitudeValue.doubleValue()) {
                        this.altitudeMin = (((int) (altitudeValue.doubleValue() / 10.0d)) - 2) * 10;
                    }
                }
                if (this.totalCount > this.maxCount) {
                    speedList.add(speedValue);
                    variometerList.add(varValue);
                    altitudeList.add(altitudeValue);
                } else {
                    for (int j = 0; j < this.rangeCount; j++) {
                        speedList.add(speedValue);
                        variometerList.add(varValue);
                        altitudeList.add(altitudeValue);
                    }
                }
            }
        }
        Double[] speedArray = new Double[speedList.size()];
        speedList.toArray(speedArray);
        Double[] variometerArray = new Double[variometerList.size()];
        variometerList.toArray(variometerArray);
        Double[] altitudeArray = new Double[altitudeList.size()];
        altitudeList.toArray(altitudeArray);
        valueMap1 = new LinkedHashMap();
        valueMap1.put(this.KEY_ALTITUDE, altitudeArray);
        valueMap2 = new LinkedHashMap();
        valueMap2.put(this.KEY_VARIOMETER, variometerArray);
        valueMap3 = new LinkedHashMap();
        valueMap3.put(this.KEY_SPEED, speedArray);
    }

    /* access modifiers changed from: private */
    public void getServoView(double[] dataValues) {
        double[] minValues = {0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d};
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        RangeCategorySeries rangeCategorySeries = new RangeCategorySeries(getString(C0112R.string.servo));
        int length = minValues.length;
        for (int k = 0; k < length; k++) {
            rangeCategorySeries.add(minValues[k], -dataValues[k]);
        }
        dataset.addSeries(rangeCategorySeries.toXYSeries());
        XYMultipleSeriesRenderer renderer = buildBarRenderer(new int[]{-16711681});
        renderer.setPanEnabled(false, false);
        renderer.setZoomEnabled(false, false);
        setChartSettings(renderer, getString(C0112R.string.labServoValue), "Ch", "", 0.5d, 19.0d, -100.0d, 100.0d, -7829368, DefaultRenderer.TEXT_COLOR);
        renderer.setBarSpacing(0.5d);
        renderer.setXLabels(0);
        renderer.setYLabels(0);
        renderer.addXTextLabel(1.0d, "1");
        renderer.addXTextLabel(2.0d, "2");
        renderer.addXTextLabel(3.0d, "3");
        renderer.addXTextLabel(4.0d, "4");
        renderer.addXTextLabel(5.0d, "5");
        renderer.addXTextLabel(6.0d, "6");
        renderer.addXTextLabel(7.0d, "7");
        renderer.addXTextLabel(8.0d, "8");
        renderer.addXTextLabel(9.0d, "9");
        renderer.addXTextLabel(10.0d, "10");
        renderer.addXTextLabel(11.0d, "11");
        renderer.addXTextLabel(12.0d, "12");
        renderer.addXTextLabel(13.0d, "13");
        renderer.addXTextLabel(14.0d, "14");
        renderer.addXTextLabel(15.0d, "15");
        renderer.addXTextLabel(16.0d, "16");
        renderer.addXTextLabel(17.0d, "DG1");
        renderer.addXTextLabel(18.0d, "DG2");
        renderer.addYTextLabel(100.0d, "100");
        renderer.addYTextLabel(-100.0d, "-100");
        renderer.addYTextLabel(0.0d, "0");
        renderer.addYTextLabel(50.0d, "");
        renderer.addYTextLabel(-50.0d, "");
        int[] iArr = new int[4];
        iArr[0] = 30;
        iArr[1] = 30;
        iArr[2] = 10;
        renderer.setMargins(iArr);
        renderer.setYLabelsAlign(Align.RIGHT);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setDisplayChartValues(true);
        r.setChartValuesTextSize(16.0f);
        r.setChartValuesSpacing(2.0f);
        r.setGradientEnabled(true);
        r.setGradientStart(-100.0d, -16776961);
        r.setGradientStop(100.0d, -16711936);
        GraphicalView rangeBarChartView = ChartFactory.getRangeBarChartView(this, dataset, renderer, Type.DEFAULT);
        rangeBarChartView.setBackgroundColor(-16777216);
        this.chart.removeAllViews();
        this.chart.addView(rangeBarChartView);
    }

    public void setChartSettings(XYMultipleSeriesRenderer renderer, String title, String xTitle, String yTitle, double xMin, double xMax, double yMin, double yMax, int axesColor, int labelsColor) {
        renderer.setChartTitle(title);
        renderer.setXTitle(xTitle);
        renderer.setYTitle(yTitle);
        renderer.setXAxisMin(xMin);
        renderer.setXAxisMax(xMax);
        renderer.setYAxisMin(yMin);
        renderer.setYAxisMax(yMax);
        renderer.setAxesColor(axesColor);
        renderer.setLabelsColor(labelsColor);
    }

    public XYMultipleSeriesRenderer buildBarRenderer(int[] colors) {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setAxisTitleTextSize(16.0f);
        renderer.setChartTitleTextSize(20.0f);
        renderer.setLabelsTextSize(15.0f);
        renderer.setLegendTextSize(15.0f);
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /* access modifiers changed from: private */
    public void drawChart(String keyValue) {
        if (keyValue == this.KEY_VARIOMETER) {
            this.txtLegend1.setText("---" + keyValue);
            this.txtLegend1.setTextColor(SupportMenu.CATEGORY_MASK);
            this.graphicalView = ChartFactory.getLineChartView(this, getDataset(valueMap2), getRenderer(this.logViewData.getValType(), valueMap2));
        } else if (keyValue == this.KEY_PRESSURE) {
            this.txtLegend1.setText("---" + keyValue);
            this.txtLegend1.setTextColor(SupportMenu.CATEGORY_MASK);
            this.graphicalView = ChartFactory.getLineChartView(this, getDataset(valueMap3), getRenderer(this.logViewData.getValType(), valueMap3));
        } else if (keyValue == this.KEY_ExtVOLTAGE) {
            this.txtLegend1.setText("---" + keyValue);
            this.txtLegend1.setTextColor(SupportMenu.CATEGORY_MASK);
            this.graphicalView = ChartFactory.getLineChartView(this, getDataset(valueMap2), getRenderer(this.logViewData.getValType(), valueMap2));
        } else {
            this.txtLegend1.setText("---" + keyValue);
            this.txtLegend1.setTextColor(SupportMenu.CATEGORY_MASK);
            this.graphicalView = ChartFactory.getLineChartView(this, getDataset(valueMap1), getRenderer(this.logViewData.getValType(), valueMap1));
        }
    }

    private XYMultipleSeriesRenderer getRenderer(String chartTitle, Map<String, Double[]> values) {
        int scaleCount = values.size();
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(scaleCount);
        renderer.setChartTitleTextSize(20.0f);
        renderer.setAxisTitleTextSize(18.0f);
        renderer.setPanEnabled(true, true);
        renderer.setZoomEnabled(true, false);
        renderer.setZoomButtonsVisible(false);
        renderer.setShowLegend(false);
        renderer.setShowGridY(true);
        renderer.setExternalZoomEnabled(true);
        for (int i = 0; i < scaleCount; i++) {
            XYSeriesRenderer r = new XYSeriesRenderer();
            r.setColor(Y_COLOR[i]);
            r.setPointStyle(Y_POINT_STYLE[i]);
            renderer.addSeriesRenderer(i, r);
            setChartSettings(chartTitle, values, renderer);
        }
        return renderer;
    }

    private XYMultipleSeriesDataset getDataset(Map<String, Double[]> values) {
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        int idx = 0;
        for (Entry<String, Double[]> entry : values.entrySet()) {
            XYSeries series = new XYSeries((String) entry.getKey(), idx);
            for (int k = 0; k < ((Double[]) entry.getValue()).length; k++) {
                series.add((double) k, ((Double[]) entry.getValue())[k].doubleValue());
            }
            dataset.addSeries(idx, series);
            idx++;
        }
        return dataset;
    }

    private void setChartSettings(String chartTitle, Map<String, Double[]> values, XYMultipleSeriesRenderer renderer) {
        renderer.setScale(1.0f);
        renderer.setChartTitle(chartTitle);
        if (this.totalCount > this.maxCount) {
            renderer.setXTitle(X_LABEL_s);
        } else {
            renderer.setXTitle(X_LABEL_ms);
        }
        renderer.setXLabels(10);
        renderer.setXZoomMax(10.0d);
        renderer.setZoomRate(2.0f);
        renderer.setLabelsTextSize(15.0f);
        int idx = 0;
        int maxXCnt = 0;
        for (Entry<String, Double[]> entry : values.entrySet()) {
            renderer.setYTitle((String) entry.getKey(), idx);
            renderer.setYLabels(20);
            renderer.setYAxisMin(MathUtil.calMinValue((Double[]) entry.getValue()), idx);
            renderer.setYAxisMax((double) ((Integer) this.KEY_AXIS.get(entry.getKey())).intValue(), idx);
            renderer.setYAxisMin((double) ((Integer) this.KEY_AXISMin.get(entry.getKey())).intValue(), idx);
            renderer.setYAxisAlign(Y_ALIGN[idx], idx);
            if (((Double[]) entry.getValue()).length > maxXCnt) {
                maxXCnt = ((Double[]) entry.getValue()).length;
            }
            renderer.setXAxisMin(0.0d, idx);
            renderer.setXAxisMax((double) maxXCnt, idx);
            idx++;
        }
        double[] renderLimits = {0.0d, (double) maxXCnt, 0.0d, 0.0d};
        renderer.setPanLimits(renderLimits);
        renderer.setZoomLimits(renderLimits);
    }
}
