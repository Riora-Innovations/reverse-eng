package com.futaba.androidmadlink.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.GaugeActivity;
import com.futaba.androidmadlink.config.GaugeViewSetting;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.constant.ArgumentKey;
import com.futaba.androidmadlink.util.XMLHelper;
import com.futaba.androidmadlink.view.DataTypes;
import com.futaba.androidmadlink.view.SensorTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

public class SettingsFragment extends DialogFragment {
    public static final String TAG = "SettingsFragment";
    String[] AltitudeUnit = {"m", "ft"};
    String Attributes = "";
    int Col = -1;
    DataTypes DataType = DataTypes.Sensor;
    String[] Device = new String[2];
    String MaxValue = "";
    String MaxValue2 = "";
    String[] MaxValue_C = {"50", "100", "200"};
    String[] MaxValue_F = {"150", "250", "400"};
    int Page = -1;
    String RegulateValue = "0.0";
    int Row = -1;
    String SensorTitle = "";
    SensorTypes SensorType = SensorTypes.Receiver;
    String[] SpeedUnit = {"km/h", "m/h"};
    int State = 1;
    String[] Types = new String[2];
    String[] Units = {"˚C", "˚F"};
    String[] VariometerUnit = {"m/s", "mph"};
    ArrayAdapter<String> adpAltitudeUnit = null;
    ArrayAdapter<String> adpDevice = null;
    ArrayAdapter<String> adpMaxValue = null;
    ArrayAdapter<String> adpRange = null;
    ArrayAdapter<String> adpSensorType = null;
    ArrayAdapter<String> adpSlot = null;
    ArrayAdapter<String> adpSpeedUnit = null;
    ArrayAdapter<String> adpType = null;
    ArrayAdapter<String> adpUnit = null;
    ArrayAdapter<String> adpValType = null;
    ArrayAdapter<String> adpVariometerUnit = null;
    Button btn_Cancel = null;
    Button btn_OK = null;
    CheckBox ckBox_ShowBattery = null;
    CheckBox ckBox_ShowExtBattery = null;
    EditText et_Alert2Max = null;
    EditText et_Alert2Min = null;
    EditText et_AlertMax = null;
    EditText et_AlertMin = null;
    EditText et_MaxValue = null;
    EditText et_MaxValue2 = null;
    EditText et_Range = null;
    EditText et_Title = null;
    int flag = 0;
    boolean fristSet = true;
    LinearLayout layout_Alert2Enable = null;
    LinearLayout layout_Alert2Max = null;
    LinearLayout layout_Alert2Min = null;
    LinearLayout layout_AlertEnable = null;
    LinearLayout layout_MaxValue2 = null;
    private boolean[] mAllSlots = new boolean[32];
    private String[] mAllSlotsSensorName = new String[32];
    GaugeViewSetting mGaugeViewSetting = new GaugeViewSetting();
    int slotCount = 0;
    private String[] slotLists_ARRAY = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] slotLists_ARRAY2 = {"1", "2", "3", "4", "5", "6", "8", "9", "10", "11", "12", "13", "14", "16", "17", "18", "19", "20", "21", "22", "24", "25", "26", "27", "28", "29", "30"};
    private String[] slotLists_ARRAY3 = {"1", "2", "3", "4", "5", "8", "9", "10", "11", "12", "13", "16", "17", "18", "19", "20", "21", "24", "25", "26", "27", "28", "29"};
    private String[] slotLists_ARRAY4 = {"8", "16", "24"};
    int slotValue = 0;
    boolean spinTypeFristSet = true;
    Spinner spin_AltitudeUnit = null;
    Spinner spin_Device = null;
    Spinner spin_MaxValue = null;
    Spinner spin_Sensor = null;
    Spinner spin_Slot = null;
    Spinner spin_SpeedUnit = null;
    Spinner spin_Type = null;
    Spinner spin_Unit = null;
    Spinner spin_ValType = null;
    Spinner spin_VariometerUnit = null;
    String strShowBattery = "A";
    ToggleButton tBtn_Alert2Enable = null;
    ToggleButton tBtn_AlertEnable = null;
    TableLayout tableLayout_ShowBattery = null;
    TextView tv_Alert2Max = null;
    TextView tv_Alert2Min = null;
    TextView tv_AlertEnable = null;
    TextView tv_AlertMax = null;
    TextView tv_AlertMin = null;
    TextView tv_AltitudeUnit = null;
    TextView tv_MaxValue = null;
    TextView tv_MaxValue2 = null;
    TextView tv_Range = null;
    TextView tv_Range2 = null;
    TextView tv_RpmMax2 = null;
    TextView tv_Sensor = null;
    TextView tv_Slot = null;
    TextView tv_SpeedUnit = null;
    TextView tv_Title = null;
    TextView tv_Type = null;
    TextView tv_Unit = null;
    TextView tv_ValType = null;
    TextView tv_VariometerUnit = null;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(C0112R.layout.dialog_settings, container, false);
        Bundle bundle = getArguments();
        String strAttributes = bundle.getString(ArgumentKey.Key_Attributes);
        this.Page = bundle.getInt(ArgumentKey.Key_Page);
        this.Row = bundle.getInt(ArgumentKey.Key_Row);
        this.Col = bundle.getInt(ArgumentKey.Key_Col);
        String strDataType = bundle.getString(ArgumentKey.Key_DataType);
        if (strDataType == null || strDataType.equals("")) {
            this.mGaugeViewSetting.setDataType(DataTypes.Sensor);
        } else {
            if (strDataType.equals("Receiver")) {
                this.DataType = DataTypes.Servo;
            } else if (strDataType.equals("Sensor")) {
                this.DataType = DataTypes.Sensor;
            }
            this.mGaugeViewSetting.setDataType(this.DataType);
        }
        bundle.putString(ArgumentKey.Key_DataType, strDataType);
        String strSensorType = bundle.getString(ArgumentKey.Key_SensorType);
        if (strSensorType != null && !strSensorType.equals("")) {
            if (strSensorType.equals("Receiver")) {
                this.SensorType = SensorTypes.Receiver;
            } else if (strSensorType.equals("Voltage")) {
                this.SensorType = SensorTypes.Voltage;
            } else if (strSensorType.equals("Temperature")) {
                this.SensorType = SensorTypes.Temperature;
            } else if (strSensorType.equals("RPM")) {
                this.SensorType = SensorTypes.RPM;
            } else if (strSensorType.equals("Altitude")) {
                this.SensorType = SensorTypes.Altitude;
            } else if (strSensorType.equals("GPS")) {
                this.SensorType = SensorTypes.GPS;
            } else if (strSensorType.equals("GPSLocus")) {
                this.SensorType = SensorTypes.GPSLocus;
            }
            this.mGaugeViewSetting.setSensorType(this.SensorType);
        }
        this.Device[0] = (String) getResources().getText(C0112R.string.servo);
        this.Device[1] = (String) getResources().getText(C0112R.string.labSensor);
        this.Types[0] = (String) getResources().getText(C0112R.string.optics);
        this.Types[1] = (String) getResources().getText(C0112R.string.magnet);
        this.mGaugeViewSetting.setPageNo(this.Page);
        this.mGaugeViewSetting.setRowNo(this.Row);
        this.mGaugeViewSetting.setColNo(this.Col);
        this.mAllSlots = GaugeActivity.mGaugePagerAdapter.getAllSlots();
        this.mAllSlotsSensorName = GaugeActivity.mGaugePagerAdapter.getAllSlotsSenserName();
        if (!strAttributes.equals("")) {
            this.mGaugeViewSetting.setAttributes(strAttributes);
        }
        this.spin_Device = (Spinner) rootView.findViewById(C0112R.C0114id.spin_Device);
        this.spin_Type = (Spinner) rootView.findViewById(C0112R.C0114id.spin_Type);
        this.spin_Sensor = (Spinner) rootView.findViewById(C0112R.C0114id.spin_Sensor);
        this.spin_Unit = (Spinner) rootView.findViewById(C0112R.C0114id.spin_Unit);
        this.spin_Slot = (Spinner) rootView.findViewById(C0112R.C0114id.spin_Slot);
        this.spin_AltitudeUnit = (Spinner) rootView.findViewById(C0112R.C0114id.spin_AltitudeUnit);
        this.spin_VariometerUnit = (Spinner) rootView.findViewById(C0112R.C0114id.spin_VariometerUnit);
        this.spin_SpeedUnit = (Spinner) rootView.findViewById(C0112R.C0114id.spin_SpeedUnit);
        this.spin_ValType = (Spinner) rootView.findViewById(C0112R.C0114id.spin_ValType);
        this.spin_MaxValue = (Spinner) rootView.findViewById(C0112R.C0114id.spin_MaxValue);
        this.tv_Slot = (TextView) rootView.findViewById(C0112R.C0114id.tv_Slot);
        this.tv_Title = (TextView) rootView.findViewById(C0112R.C0114id.tv_Title);
        this.tv_Sensor = (TextView) rootView.findViewById(C0112R.C0114id.tv_Sensor);
        this.tv_Type = (TextView) rootView.findViewById(C0112R.C0114id.tv_Type);
        this.tv_ValType = (TextView) rootView.findViewById(C0112R.C0114id.tv_ValType);
        this.tv_Unit = (TextView) rootView.findViewById(C0112R.C0114id.tv_Unit);
        this.tv_Range = (TextView) rootView.findViewById(C0112R.C0114id.tv_Range);
        this.tv_Range2 = (TextView) rootView.findViewById(C0112R.C0114id.tv_Range2);
        this.tv_AltitudeUnit = (TextView) rootView.findViewById(C0112R.C0114id.tv_AltitudeUnit);
        this.tv_VariometerUnit = (TextView) rootView.findViewById(C0112R.C0114id.tv_VariometerUnit);
        this.tv_SpeedUnit = (TextView) rootView.findViewById(C0112R.C0114id.tv_SpeedUnit);
        this.tv_MaxValue = (TextView) rootView.findViewById(C0112R.C0114id.tv_MaxValue);
        this.tv_RpmMax2 = (TextView) rootView.findViewById(C0112R.C0114id.tv_RpmMax2);
        this.tv_AlertEnable = (TextView) rootView.findViewById(C0112R.C0114id.tv_AlertEnable);
        this.tv_AlertMax = (TextView) rootView.findViewById(C0112R.C0114id.tv_AlertMax);
        this.tv_AlertMin = (TextView) rootView.findViewById(C0112R.C0114id.tv_AlertMin);
        this.tv_MaxValue2 = (TextView) rootView.findViewById(C0112R.C0114id.tv_MaxValue2);
        this.tv_Alert2Max = (TextView) rootView.findViewById(C0112R.C0114id.tv_Alert2Max);
        this.tv_Alert2Min = (TextView) rootView.findViewById(C0112R.C0114id.tv_Alert2Min);
        this.et_Title = (EditText) rootView.findViewById(C0112R.C0114id.et_Title);
        this.et_Range = (EditText) rootView.findViewById(C0112R.C0114id.et_Range);
        this.et_MaxValue = (EditText) rootView.findViewById(C0112R.C0114id.et_MaxValue);
        InputFilter[] filters = {new LengthFilter(3)};
        this.et_MaxValue.setFilters(filters);
        this.et_AlertMax = (EditText) rootView.findViewById(C0112R.C0114id.et_AlertMax);
        this.et_AlertMin = (EditText) rootView.findViewById(C0112R.C0114id.et_AlertMin);
        this.et_MaxValue2 = (EditText) rootView.findViewById(C0112R.C0114id.et_MaxValue2);
        this.et_MaxValue2.setFilters(filters);
        this.et_Alert2Max = (EditText) rootView.findViewById(C0112R.C0114id.et_Alert2Max);
        this.et_Alert2Min = (EditText) rootView.findViewById(C0112R.C0114id.et_Alert2Min);
        this.tableLayout_ShowBattery = (TableLayout) rootView.findViewById(C0112R.C0114id.tableLayout_ShowBattery);
        this.layout_AlertEnable = (LinearLayout) rootView.findViewById(C0112R.C0114id.layout_AlertEnable);
        this.layout_MaxValue2 = (LinearLayout) rootView.findViewById(C0112R.C0114id.layout_MaxValue2);
        this.layout_Alert2Enable = (LinearLayout) rootView.findViewById(C0112R.C0114id.layout_Alert2Enable);
        this.layout_Alert2Max = (LinearLayout) rootView.findViewById(C0112R.C0114id.layout_Alert2Max);
        this.layout_Alert2Min = (LinearLayout) rootView.findViewById(C0112R.C0114id.layout_Alert2Min);
        this.tBtn_AlertEnable = (ToggleButton) rootView.findViewById(C0112R.C0114id.tBtn_AlertEnable);
        this.tBtn_Alert2Enable = (ToggleButton) rootView.findViewById(C0112R.C0114id.tBtn_Alert2Enable);
        this.btn_OK = (Button) rootView.findViewById(C0112R.C0114id.btn_OK);
        this.btn_Cancel = (Button) rootView.findViewById(C0112R.C0114id.btn_Cancel);
        this.ckBox_ShowBattery = (CheckBox) rootView.findViewById(C0112R.C0114id.ckBox_ShowBattery);
        this.ckBox_ShowExtBattery = (CheckBox) rootView.findViewById(C0112R.C0114id.ckBox_ShowExtBattery);
        this.ckBox_ShowBattery.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean z;
                if (isChecked) {
                    SettingsFragment.this.layout_AlertEnable.setVisibility(0);
                    SettingsFragment.this.tv_MaxValue.setVisibility(0);
                    SettingsFragment.this.et_MaxValue.setVisibility(0);
                    return;
                }
                if (SettingsFragment.this.fristSet) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && (!SettingsFragment.this.ckBox_ShowExtBattery.isChecked())) {
                    SettingsFragment.this.ckBox_ShowBattery.setChecked(true);
                    return;
                }
                SettingsFragment.this.layout_AlertEnable.setVisibility(8);
                SettingsFragment.this.tBtn_AlertEnable.setChecked(false);
                SettingsFragment.this.tv_MaxValue.setVisibility(8);
                SettingsFragment.this.et_MaxValue.setVisibility(8);
                SettingsFragment.this.tv_AlertMax.setVisibility(8);
                SettingsFragment.this.tv_AlertMin.setVisibility(8);
                SettingsFragment.this.et_AlertMax.setVisibility(8);
                SettingsFragment.this.et_AlertMin.setVisibility(8);
                SettingsFragment.this.et_AlertMax.setText("");
                SettingsFragment.this.et_AlertMin.setText("");
            }
        });
        this.ckBox_ShowExtBattery.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boolean z;
                if (isChecked) {
                    SettingsFragment.this.layout_Alert2Enable.setVisibility(0);
                    SettingsFragment.this.tv_MaxValue2.setVisibility(0);
                    SettingsFragment.this.et_MaxValue2.setVisibility(0);
                    return;
                }
                if (SettingsFragment.this.fristSet) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && (!SettingsFragment.this.ckBox_ShowBattery.isChecked())) {
                    SettingsFragment.this.ckBox_ShowExtBattery.setChecked(true);
                    return;
                }
                SettingsFragment.this.layout_Alert2Enable.setVisibility(8);
                SettingsFragment.this.tBtn_Alert2Enable.setChecked(false);
                SettingsFragment.this.tv_MaxValue2.setVisibility(8);
                SettingsFragment.this.et_MaxValue2.setVisibility(8);
                SettingsFragment.this.tv_Alert2Max.setVisibility(8);
                SettingsFragment.this.tv_Alert2Min.setVisibility(8);
                SettingsFragment.this.et_Alert2Max.setVisibility(8);
                SettingsFragment.this.et_Alert2Min.setVisibility(8);
                SettingsFragment.this.et_Alert2Max.setText("");
                SettingsFragment.this.et_Alert2Min.setText("");
            }
        });
        setDeviceState(getString(C0112R.string.labReceiverTile));
        addSpinner();
        this.spin_Device.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                SettingsFragment.this.setDeviceState(adapterView.getSelectedItem().toString());
            }

            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(SettingsFragment.this.getActivity(), "您沒有選擇任何項目", 1).show();
            }
        });
        this.spin_Sensor.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                SettingsFragment.this.flag = 1;
                String sel = adapterView.getSelectedItem().toString();
                if (sel.equals(SettingsFragment.this.getString(C0112R.string.labVoltageTile))) {
                    SettingsFragment.this.setState(1);
                } else if (sel.equals(SettingsFragment.this.getString(C0112R.string.labReceiverTile))) {
                    SettingsFragment.this.setState(0);
                } else if (sel.equals(SettingsFragment.this.getString(C0112R.string.labTemperatureTile))) {
                    SettingsFragment.this.setState(2);
                } else if (sel.equals(SettingsFragment.this.getString(C0112R.string.labRPMTile))) {
                    SettingsFragment.this.setState(3);
                } else if (sel.equals(SettingsFragment.this.getString(C0112R.string.labAltitudeTile))) {
                    SettingsFragment.this.setState(4);
                } else if (sel.equals(SettingsFragment.this.getString(C0112R.string.labGPSTile))) {
                    SettingsFragment.this.setState(5);
                } else if (sel.equals(SettingsFragment.this.getString(C0112R.string.labGPSLocusTile))) {
                    SettingsFragment.this.setState(6);
                }
                SettingsFragment.this.slotValue = 0;
            }

            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(SettingsFragment.this.getActivity(), "您沒有選擇任何項目", 1).show();
            }
        });
        this.spin_Unit.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                String sel = adapterView.getSelectedItem().toString();
                if (SettingsFragment.this.State == 2) {
                    if (sel.equals("˚C")) {
                        SettingsFragment.this.adpMaxValue = new ArrayAdapter<>(SettingsFragment.this.getActivity(), 17367048, SettingsFragment.this.MaxValue_C);
                        SettingsFragment.this.spin_MaxValue.setAdapter(SettingsFragment.this.adpMaxValue);
                    } else {
                        SettingsFragment.this.adpMaxValue = new ArrayAdapter<>(SettingsFragment.this.getActivity(), 17367048, SettingsFragment.this.MaxValue_F);
                        SettingsFragment.this.spin_MaxValue.setAdapter(SettingsFragment.this.adpMaxValue);
                    }
                    if (!SettingsFragment.this.MaxValue.equals("")) {
                        SettingsFragment.this.spin_MaxValue.setSelection(SettingsFragment.this.adpMaxValue.getPosition(SettingsFragment.this.MaxValue));
                        SettingsFragment.this.MaxValue = "";
                    }
                } else if (!SettingsFragment.this.et_MaxValue.getText().toString().equals("")) {
                    float floatValue = Float.valueOf(SettingsFragment.this.et_MaxValue.getText().toString()).floatValue();
                    switch (SettingsFragment.this.State) {
                    }
                }
            }

            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(SettingsFragment.this.getActivity(), "您沒有選擇任何項目", 1).show();
            }
        });
        this.spin_Type.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int position, long id) {
                if (adapterView.getSelectedItem().toString().equals(SettingsFragment.this.getString(C0112R.string.optics))) {
                    SettingsFragment.this.tv_Range.setText(SettingsFragment.this.getString(C0112R.string.labRange1));
                    SettingsFragment.this.tv_Range2.setText("(2~10)");
                    if (!SettingsFragment.this.spinTypeFristSet) {
                        SettingsFragment.this.et_Range.setText("2");
                    }
                } else {
                    SettingsFragment.this.tv_Range.setText(SettingsFragment.this.getString(C0112R.string.labRange2));
                    SettingsFragment.this.tv_Range2.setText("(1.00~99.00)");
                    if (!SettingsFragment.this.spinTypeFristSet) {
                        SettingsFragment.this.et_Range.setText("1");
                    }
                }
                SettingsFragment.this.spinTypeFristSet = false;
            }

            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(SettingsFragment.this.getActivity(), "您沒有選擇任何項目", 1).show();
            }
        });
        this.et_Range.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                if (temp.length() != 0) {
                    int posDot = temp.indexOf(".");
                    if (SettingsFragment.this.spin_Type.getSelectedItem().toString().equals(SettingsFragment.this.getString(C0112R.string.optics))) {
                        if (Double.valueOf(temp).doubleValue() > 10.0d) {
                            SettingsFragment.this.et_Range.setText("10");
                        } else if (Double.valueOf(temp).doubleValue() < 1.0d) {
                            SettingsFragment.this.et_Range.setText("2");
                        } else if (posDot <= 0) {
                            if (temp.length() > 2) {
                                edt.delete(2, 3);
                            }
                        } else if (temp.length() - posDot > 0) {
                            edt.delete(posDot, posDot + 1);
                        }
                    } else if (Double.valueOf(temp).doubleValue() > 99.0d) {
                        SettingsFragment.this.et_Range.setText("99");
                    } else {
                        if (Double.valueOf(temp).doubleValue() < 1.0d) {
                            SettingsFragment.this.et_Range.setText("1");
                        }
                        if (posDot <= 0) {
                            if (temp.length() > 2) {
                                edt.delete(2, 3);
                            }
                        } else if ((temp.length() - posDot) - 1 > 2) {
                            edt.delete(posDot + 3, posDot + 4);
                        }
                    }
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
        this.et_MaxValue.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (!SettingsFragment.this.et_MaxValue.getText().toString().equals("")) {
                    float value = Float.valueOf(SettingsFragment.this.et_MaxValue.getText().toString()).floatValue();
                    switch (SettingsFragment.this.State) {
                        case 0:
                            if (value > 70.0f || value < 0.0f) {
                                SettingsFragment.this.et_MaxValue.setText("70");
                                return;
                            }
                            return;
                        case 1:
                            if (value > 100.0f || value < 0.0f) {
                                SettingsFragment.this.et_MaxValue.setText("100");
                                return;
                            }
                            return;
                        case 3:
                            if (value > 300.0f || value < 0.0f) {
                                SettingsFragment.this.et_MaxValue.setText("300");
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        this.et_MaxValue2.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                if (!SettingsFragment.this.et_MaxValue2.getText().toString().equals("")) {
                    float value = Float.valueOf(SettingsFragment.this.et_MaxValue2.getText().toString()).floatValue();
                    switch (SettingsFragment.this.State) {
                        case 0:
                            if (value > 70.0f || value < 0.0f) {
                                SettingsFragment.this.et_MaxValue2.setText("70");
                                return;
                            }
                            return;
                        case 1:
                            if (value > 100.0f || value < 0.0f) {
                                SettingsFragment.this.et_MaxValue2.setText("100");
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        this.btn_Cancel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SettingsFragment.this.CloseDialog();
            }
        });
        this.btn_OK.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                try {
                    if (!SettingsFragment.this.SaveBack()) {
                        Toast.makeText(SettingsFragment.this.getActivity(), "Failed to Save Back!", 1).show();
                        return;
                    }
                    Toast.makeText(SettingsFragment.this.getActivity(), "Update Success!", 1).show();
                    SettingsFragment.this.CloseDialog();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(SettingsFragment.this.getActivity(), "Failed to Save Back!", 1).show();
                }
            }
        });
        this.tBtn_AlertEnable.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SettingsFragment.this.setAlertEnable();
            }
        });
        this.tBtn_Alert2Enable.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SettingsFragment.this.setAlert2Enable();
            }
        });
        try {
            loadData();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.et_AlertMax.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                try {
                    if (!SettingsFragment.this.et_AlertMax.getText().toString().equals("") && !SettingsFragment.this.et_AlertMax.getText().toString().equals("-")) {
                        float value = Float.valueOf(SettingsFragment.this.et_AlertMax.getText().toString()).floatValue();
                        Integer valueMax = Integer.valueOf(0);
                        if (SettingsFragment.this.State != 4 && SettingsFragment.this.State != 2) {
                            valueMax = Integer.valueOf(SettingsFragment.this.et_MaxValue.getText().toString());
                        } else if (SettingsFragment.this.State == 2) {
                            valueMax = Integer.valueOf(SettingsFragment.this.spin_MaxValue.getSelectedItem().toString());
                        }
                        switch (SettingsFragment.this.State) {
                            case 0:
                                if (value > 70.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMax.setText("70");
                                    return;
                                }
                                return;
                            case 1:
                                if (value > 100.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMax.setText("100");
                                    return;
                                }
                                return;
                            case 2:
                                if (SettingsFragment.this.spin_Unit.getSelectedItem().toString().equals("˚C")) {
                                    if (value > ((float) valueMax.intValue()) || value > 200.0f || value < -20.0f) {
                                        SettingsFragment.this.et_AlertMax.setText(String.valueOf(valueMax));
                                        return;
                                    }
                                    return;
                                } else if (value > ((float) valueMax.intValue()) || value > 400.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMax.setText(String.valueOf(valueMax));
                                    return;
                                } else {
                                    return;
                                }
                            case 3:
                                if (value > ((float) (valueMax.intValue() * 1000)) || value > 300000.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMax.setText(String.valueOf(valueMax.intValue() * 1000));
                                    return;
                                }
                                return;
                            case 4:
                                if (value > 5500.0f || value < -700.0f) {
                                    SettingsFragment.this.et_AlertMax.setText("5500");
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "SettingsFragment et_AlertMax addTextChangedListener Error: " + e.getMessage());
                }
            }
        });
        this.et_AlertMin.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                try {
                    if (!SettingsFragment.this.et_AlertMin.getText().toString().equals("") && !SettingsFragment.this.et_AlertMin.getText().toString().equals("-")) {
                        float value = Float.valueOf(SettingsFragment.this.et_AlertMin.getText().toString()).floatValue();
                        Integer valueMax = Integer.valueOf(0);
                        if (SettingsFragment.this.State != 4 && SettingsFragment.this.State != 2) {
                            valueMax = Integer.valueOf(SettingsFragment.this.et_MaxValue.getText().toString());
                        } else if (SettingsFragment.this.State == 2) {
                            valueMax = Integer.valueOf(SettingsFragment.this.spin_MaxValue.getSelectedItem().toString());
                        }
                        switch (SettingsFragment.this.State) {
                            case 0:
                                if (value > ((float) valueMax.intValue()) || value > 70.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMin.setText("0");
                                    return;
                                }
                                return;
                            case 1:
                                if (value > ((float) valueMax.intValue()) || value > 100.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMin.setText("0");
                                    return;
                                }
                                return;
                            case 2:
                                if (SettingsFragment.this.spin_Unit.getSelectedItem().toString().equals("˚C")) {
                                    if (value > ((float) valueMax.intValue()) || value > 200.0f || value < -20.0f) {
                                        SettingsFragment.this.et_AlertMin.setText("-20");
                                        return;
                                    }
                                    return;
                                } else if (value > ((float) valueMax.intValue()) || value > 400.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMin.setText("0");
                                    return;
                                } else {
                                    return;
                                }
                            case 3:
                                if (value > ((float) (valueMax.intValue() * 1000)) || value > 300000.0f || value < 0.0f) {
                                    SettingsFragment.this.et_AlertMin.setText("0");
                                    return;
                                }
                                return;
                            case 4:
                                if (value > 5500.0f || value < -700.0f) {
                                    SettingsFragment.this.et_AlertMax.setText("-700");
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                } catch (Exception e) {
                    Log.e(Parameter.TAG, "SettingsFragment et_AlertMax addTextChangedListener Error: " + e.getMessage());
                }
            }
        });
        return rootView;
    }

    /* access modifiers changed from: private */
    public void setAlertEnable() {
        if (this.tBtn_AlertEnable.isChecked()) {
            this.tv_AlertMax.setVisibility(0);
            this.tv_AlertMin.setVisibility(0);
            this.et_AlertMax.setVisibility(0);
            this.et_AlertMin.setVisibility(0);
            switch (this.State) {
                case 0:
                case 1:
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText(this.et_MaxValue.getText());
                    }
                    if (this.et_AlertMin.getText().toString().equals("")) {
                        this.et_AlertMin.setText("0");
                        return;
                    }
                    return;
                case 2:
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText(this.spin_MaxValue.getSelectedItem().toString());
                    }
                    if (this.spin_Unit.getSelectedItem().toString().equals("˚C")) {
                        if (this.et_AlertMin.getText().toString().equals("")) {
                            this.et_AlertMin.setText("-20");
                            return;
                        }
                        return;
                    } else if (this.et_AlertMin.getText().toString().equals("")) {
                        this.et_AlertMin.setText("-4");
                        return;
                    } else {
                        return;
                    }
                case 3:
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText(String.valueOf(Integer.valueOf(this.et_MaxValue.getText().toString()).intValue() * 1000));
                    }
                    if (this.et_AlertMin.getText().toString().equals("")) {
                        this.et_AlertMin.setText("0");
                        return;
                    }
                    return;
                case 4:
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText("5500");
                    }
                    if (this.et_AlertMin.getText().toString().equals("")) {
                        this.et_AlertMin.setText("-700");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.tv_AlertMax.setVisibility(8);
            this.tv_AlertMin.setVisibility(8);
            this.et_AlertMax.setVisibility(8);
            this.et_AlertMin.setVisibility(8);
            this.et_AlertMax.setText("");
            this.et_AlertMin.setText("");
        }
    }

    /* access modifiers changed from: private */
    public void setAlert2Enable() {
        if (this.tBtn_Alert2Enable.isChecked()) {
            this.tv_Alert2Max.setVisibility(0);
            this.tv_Alert2Min.setVisibility(0);
            this.et_Alert2Max.setVisibility(0);
            this.et_Alert2Min.setVisibility(0);
            switch (this.State) {
                case 0:
                case 1:
                    if (this.et_Alert2Max.getText().toString().equals("")) {
                        this.et_Alert2Max.setText(this.et_MaxValue2.getText());
                    }
                    if (this.et_Alert2Min.getText().toString().equals("")) {
                        this.et_Alert2Min.setText("0");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.tv_Alert2Max.setVisibility(8);
            this.tv_Alert2Min.setVisibility(8);
            this.et_Alert2Max.setVisibility(8);
            this.et_Alert2Min.setVisibility(8);
            this.et_Alert2Max.setText("");
            this.et_Alert2Min.setText("");
        }
    }

    public void addSpinner() {
        this.adpDevice = new ArrayAdapter<>(getActivity(), 17367048, this.Device);
        this.adpDevice.setDropDownViewResource(17367049);
        this.spin_Device.setAdapter(this.adpDevice);
        this.adpSensorType = new ArrayAdapter<>(getActivity(), 17367048, getResources().getStringArray(C0112R.array.SensorType));
        addTypeOnSpinner();
        addUnitOnSpinner();
        addSlotOnSpinner(this.slotLists_ARRAY);
        this.adpAltitudeUnit = new ArrayAdapter<>(getActivity(), 17367048, this.AltitudeUnit);
        this.adpAltitudeUnit.setDropDownViewResource(17367049);
        this.spin_AltitudeUnit.setAdapter(this.adpAltitudeUnit);
        this.adpVariometerUnit = new ArrayAdapter<>(getActivity(), 17367048, this.VariometerUnit);
        this.adpVariometerUnit.setDropDownViewResource(17367049);
        this.spin_VariometerUnit.setAdapter(this.adpVariometerUnit);
        this.adpSpeedUnit = new ArrayAdapter<>(getActivity(), 17367048, this.SpeedUnit);
        this.adpSpeedUnit.setDropDownViewResource(17367049);
        this.spin_SpeedUnit.setAdapter(this.adpSpeedUnit);
        this.adpMaxValue = new ArrayAdapter<>(getActivity(), 17367048, this.MaxValue_C);
        this.spin_MaxValue.setAdapter(this.adpMaxValue);
    }

    public void addTypeOnSpinner() {
        this.adpType = new ArrayAdapter<>(getActivity(), 17367048, this.Types);
        this.adpType.setDropDownViewResource(17367049);
        this.spin_Type.setAdapter(this.adpType);
    }

    public void addUnitOnSpinner() {
        this.adpUnit = new ArrayAdapter<>(getActivity(), 17367048, this.Units);
        this.adpUnit.setDropDownViewResource(17367049);
        this.spin_Unit.setAdapter(this.adpUnit);
    }

    public void addSlotOnSpinner(String[] Slots) {
        this.adpSlot = new ArrayAdapter<>(getActivity(), 17367048, Slots);
        this.adpSlot.setDropDownViewResource(17367049);
        this.spin_Slot.setAdapter(this.adpSlot);
    }

    /* access modifiers changed from: private */
    public void setDeviceState(String strDevice) {
        if (strDevice.equals("Servo") || strDevice.equals((String) getResources().getText(C0112R.string.servo))) {
            this.spin_Device.setVisibility(0);
            this.spin_Sensor.setVisibility(8);
            this.spin_Slot.setVisibility(8);
            this.spin_Type.setVisibility(8);
            this.spin_ValType.setVisibility(8);
            this.spin_Unit.setVisibility(8);
            this.spin_AltitudeUnit.setVisibility(8);
            this.spin_VariometerUnit.setVisibility(8);
            this.spin_SpeedUnit.setVisibility(8);
            this.spin_MaxValue.setVisibility(8);
            this.tv_Slot.setVisibility(8);
            this.tv_Title.setVisibility(8);
            this.tv_Sensor.setVisibility(8);
            this.tv_Type.setVisibility(8);
            this.tv_ValType.setVisibility(8);
            this.tv_Unit.setVisibility(8);
            this.tv_Range.setVisibility(8);
            this.tv_Range2.setVisibility(8);
            this.tv_AltitudeUnit.setVisibility(8);
            this.tv_VariometerUnit.setVisibility(8);
            this.tv_SpeedUnit.setVisibility(8);
            this.tv_MaxValue.setVisibility(8);
            this.tv_RpmMax2.setVisibility(8);
            this.tv_AlertMax.setVisibility(8);
            this.tv_AlertMin.setVisibility(8);
            this.et_Title.setVisibility(8);
            this.et_Range.setVisibility(8);
            this.et_MaxValue.setVisibility(8);
            this.et_AlertMax.setVisibility(8);
            this.et_AlertMin.setVisibility(8);
            this.layout_AlertEnable.setVisibility(8);
            this.layout_MaxValue2.setVisibility(8);
            this.layout_Alert2Enable.setVisibility(8);
            this.layout_Alert2Max.setVisibility(8);
            this.layout_Alert2Min.setVisibility(8);
            this.tableLayout_ShowBattery.setVisibility(8);
            this.btn_OK.setEnabled(true);
            this.spin_Sensor.setSelection(0);
            return;
        }
        setState(0);
    }

    /* access modifiers changed from: private */
    public void setState(int key) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        String[] strArr6;
        List<String> mSlotLists = new ArrayList<>();
        this.State = key;
        this.spin_Device.setVisibility(0);
        this.spin_Sensor.setVisibility(0);
        this.spin_Slot.setVisibility(0);
        this.tv_Slot.setVisibility(0);
        this.tv_Title.setVisibility(0);
        this.tv_Sensor.setVisibility(0);
        this.et_Title.setVisibility(0);
        this.btn_OK.setEnabled(true);
        this.spin_Type.setVisibility(8);
        this.spin_ValType.setVisibility(8);
        this.spin_Unit.setVisibility(8);
        this.spin_AltitudeUnit.setVisibility(8);
        this.spin_VariometerUnit.setVisibility(8);
        this.spin_SpeedUnit.setVisibility(8);
        this.spin_MaxValue.setVisibility(8);
        this.tv_ValType.setVisibility(8);
        this.tv_Type.setVisibility(8);
        this.tv_Unit.setVisibility(8);
        this.tv_Range.setVisibility(8);
        this.tv_Range2.setVisibility(8);
        this.tv_AltitudeUnit.setVisibility(8);
        this.tv_VariometerUnit.setVisibility(8);
        this.tv_SpeedUnit.setVisibility(8);
        this.tv_MaxValue.setVisibility(8);
        this.tv_RpmMax2.setVisibility(8);
        this.tv_AlertMax.setVisibility(8);
        this.tv_AlertMin.setVisibility(8);
        this.tv_MaxValue.setText(getString(C0112R.string.labMaxValue));
        this.tv_AlertEnable.setText(getString(C0112R.string.labAlertEnable));
        this.tv_AlertMax.setText(getString(C0112R.string.labAlertMax));
        this.tv_AlertMin.setText(getString(C0112R.string.labAlertMin));
        this.et_Range.setVisibility(8);
        this.et_MaxValue.setVisibility(8);
        this.et_AlertMax.setVisibility(8);
        this.et_AlertMin.setVisibility(8);
        this.layout_AlertEnable.setVisibility(8);
        this.layout_MaxValue2.setVisibility(8);
        this.layout_Alert2Enable.setVisibility(8);
        this.layout_Alert2Max.setVisibility(8);
        this.layout_Alert2Min.setVisibility(8);
        this.tableLayout_ShowBattery.setVisibility(8);
        switch (key) {
            case 0:
                InputFilter[] filters = {new LengthFilter(3)};
                this.et_AlertMax.setFilters(filters);
                this.et_AlertMin.setFilters(filters);
                this.et_Alert2Max.setFilters(filters);
                this.et_Alert2Min.setFilters(filters);
                if (this.mAllSlots[0]) {
                    addSlotOnSpinner(new String[]{""});
                    this.btn_OK.setEnabled(false);
                } else {
                    addSlotOnSpinner(new String[]{"0"});
                }
                this.tv_MaxValue.setVisibility(0);
                this.tv_AlertMax.setVisibility(0);
                this.tv_AlertMin.setVisibility(0);
                this.tv_MaxValue.setText(getString(C0112R.string.labRxMaxValue));
                this.tv_AlertEnable.setText(getString(C0112R.string.labRxAlertEnable));
                this.tv_AlertMax.setText(getString(C0112R.string.labRxAlertMax));
                this.tv_AlertMin.setText(getString(C0112R.string.labRxAlertMin));
                this.et_MaxValue.setVisibility(0);
                this.et_MaxValue2.setVisibility(0);
                this.et_Alert2Max.setVisibility(0);
                this.et_Alert2Min.setVisibility(0);
                this.layout_AlertEnable.setVisibility(0);
                this.layout_MaxValue2.setVisibility(0);
                this.layout_Alert2Enable.setVisibility(0);
                this.layout_Alert2Max.setVisibility(0);
                this.layout_Alert2Min.setVisibility(0);
                this.tableLayout_ShowBattery.setVisibility(0);
                if (this.flag != 0) {
                    if (this.SensorTitle.equals("")) {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labReceiverTile));
                        this.flag = 0;
                    } else {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                    }
                    if (this.MaxValue.equals("")) {
                        this.et_MaxValue.setText("10");
                    } else {
                        this.et_MaxValue.setText(this.MaxValue);
                        this.MaxValue = "";
                    }
                    if (this.MaxValue2.equals("")) {
                        this.et_MaxValue2.setText("10");
                    } else {
                        this.et_MaxValue2.setText(this.MaxValue2);
                        this.MaxValue2 = "";
                    }
                    if (this.ckBox_ShowBattery.isChecked()) {
                        this.layout_AlertEnable.setVisibility(0);
                        this.tv_MaxValue.setVisibility(0);
                        this.et_MaxValue.setVisibility(0);
                    } else {
                        this.layout_AlertEnable.setVisibility(8);
                        this.tv_MaxValue.setVisibility(8);
                        this.et_MaxValue.setVisibility(8);
                    }
                    if (!this.ckBox_ShowExtBattery.isChecked()) {
                        this.layout_Alert2Enable.setVisibility(8);
                        this.tv_MaxValue2.setVisibility(8);
                        this.et_MaxValue2.setVisibility(8);
                        break;
                    } else {
                        this.layout_Alert2Enable.setVisibility(0);
                        this.tv_MaxValue2.setVisibility(0);
                        this.et_MaxValue2.setVisibility(0);
                        break;
                    }
                }
                break;
            case 1:
                InputFilter[] filters2 = {new LengthFilter(3)};
                this.et_AlertMax.setFilters(filters2);
                this.et_AlertMin.setFilters(filters2);
                for (String mSlot : this.slotLists_ARRAY2) {
                    boolean status = false;
                    for (int i = 0; i < 2; i++) {
                        if (this.mAllSlots[Integer.valueOf(mSlot).intValue() + i]) {
                            status = true;
                        }
                    }
                    if (!status) {
                        mSlotLists.add(mSlot);
                    }
                }
                String[] mSlotArray = new String[mSlotLists.size()];
                mSlotLists.toArray(mSlotArray);
                addSlotOnSpinner(mSlotArray);
                this.tv_MaxValue.setVisibility(0);
                this.tv_AlertMax.setVisibility(0);
                this.tv_AlertMin.setVisibility(0);
                this.tv_MaxValue.setText(getString(C0112R.string.labRxMaxValue));
                this.tv_AlertEnable.setText(getString(C0112R.string.labRxAlertEnable));
                this.tv_AlertMax.setText(getString(C0112R.string.labRxAlertMax));
                this.tv_AlertMin.setText(getString(C0112R.string.labRxAlertMin));
                this.et_MaxValue.setVisibility(0);
                this.et_MaxValue2.setVisibility(0);
                this.et_Alert2Max.setVisibility(0);
                this.et_Alert2Min.setVisibility(0);
                this.layout_AlertEnable.setVisibility(0);
                this.layout_MaxValue2.setVisibility(0);
                this.layout_Alert2Enable.setVisibility(0);
                this.layout_Alert2Max.setVisibility(0);
                this.layout_Alert2Min.setVisibility(0);
                this.tableLayout_ShowBattery.setVisibility(0);
                if (this.flag != 0) {
                    if (this.SensorTitle.equals("")) {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labVoltageTile));
                        this.flag = 0;
                    } else {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                    }
                    if (this.MaxValue.equals("")) {
                        this.et_MaxValue.setText("10");
                    } else {
                        this.et_MaxValue.setText(this.MaxValue);
                        this.MaxValue = "";
                    }
                    if (this.MaxValue2.equals("")) {
                        this.et_MaxValue2.setText("10");
                    } else {
                        this.et_MaxValue2.setText(this.MaxValue2);
                        this.MaxValue2 = "";
                    }
                    if (this.ckBox_ShowBattery.isChecked()) {
                        this.layout_AlertEnable.setVisibility(0);
                        this.tv_MaxValue.setVisibility(0);
                        this.et_MaxValue.setVisibility(0);
                    } else {
                        this.layout_AlertEnable.setVisibility(8);
                        this.tv_MaxValue.setVisibility(8);
                        this.et_MaxValue.setVisibility(8);
                    }
                    if (!this.ckBox_ShowExtBattery.isChecked()) {
                        this.layout_Alert2Enable.setVisibility(8);
                        this.tv_MaxValue2.setVisibility(8);
                        this.et_MaxValue2.setVisibility(8);
                        break;
                    } else {
                        this.layout_Alert2Enable.setVisibility(0);
                        this.tv_MaxValue2.setVisibility(0);
                        this.et_MaxValue2.setVisibility(0);
                        break;
                    }
                }
                break;
            case 2:
                InputFilter[] filters3 = {new LengthFilter(3)};
                this.et_AlertMax.setFilters(filters3);
                this.et_AlertMin.setFilters(filters3);
                this.et_Alert2Max.setFilters(filters3);
                this.et_Alert2Min.setFilters(filters3);
                for (String mSlot2 : this.slotLists_ARRAY) {
                    if (!this.mAllSlots[Integer.valueOf(mSlot2).intValue()]) {
                        mSlotLists.add(mSlot2);
                    }
                }
                String[] mSlotArray2 = new String[mSlotLists.size()];
                mSlotLists.toArray(mSlotArray2);
                addSlotOnSpinner(mSlotArray2);
                this.spin_Unit.setVisibility(0);
                this.tv_Unit.setVisibility(0);
                this.tv_MaxValue.setVisibility(0);
                this.tv_AlertMax.setVisibility(0);
                this.tv_AlertMin.setVisibility(0);
                this.spin_MaxValue.setVisibility(0);
                this.et_AlertMax.setVisibility(0);
                this.et_AlertMin.setVisibility(0);
                this.layout_AlertEnable.setVisibility(0);
                if (this.flag != 0) {
                    if (!this.SensorTitle.equals("")) {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                        break;
                    } else {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labTemperatureTile));
                        this.flag = 0;
                        break;
                    }
                }
                break;
            case 3:
                InputFilter[] filters4 = {new LengthFilter(6)};
                this.et_AlertMax.setFilters(filters4);
                this.et_AlertMin.setFilters(filters4);
                for (String mSlot3 : this.slotLists_ARRAY) {
                    if (!this.mAllSlots[Integer.valueOf(mSlot3).intValue()]) {
                        mSlotLists.add(mSlot3);
                    }
                }
                String[] mSlotArray3 = new String[mSlotLists.size()];
                mSlotLists.toArray(mSlotArray3);
                addSlotOnSpinner(mSlotArray3);
                this.spin_Type.setVisibility(0);
                this.tv_Type.setVisibility(0);
                this.tv_Range.setVisibility(0);
                this.tv_Range2.setVisibility(0);
                this.tv_MaxValue.setVisibility(0);
                this.tv_RpmMax2.setVisibility(0);
                this.tv_AlertMax.setVisibility(0);
                this.tv_AlertMin.setVisibility(0);
                this.et_Range.setVisibility(0);
                this.et_MaxValue.setVisibility(0);
                this.et_AlertMax.setVisibility(0);
                this.et_AlertMin.setVisibility(0);
                this.layout_AlertEnable.setVisibility(0);
                if (this.flag != 0) {
                    if (this.SensorTitle.equals("")) {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labRPMTile));
                        this.flag = 0;
                    } else {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                    }
                    if (this.MaxValue.equals("")) {
                        this.et_MaxValue.setText("10");
                    } else {
                        this.et_MaxValue.setText(this.MaxValue);
                        this.MaxValue = "";
                    }
                    if (this.et_Range.getText().toString().equals("")) {
                        this.et_Range.setText("2");
                        break;
                    }
                }
                break;
            case 4:
                InputFilter[] filters5 = {new LengthFilter(4)};
                this.et_AlertMax.setFilters(filters5);
                this.et_AlertMin.setFilters(filters5);
                for (String mSlot4 : this.slotLists_ARRAY3) {
                    boolean status2 = false;
                    for (int i2 = 0; i2 < 3; i2++) {
                        if (this.mAllSlots[Integer.valueOf(mSlot4).intValue() + i2]) {
                            status2 = true;
                        }
                    }
                    if (!status2) {
                        mSlotLists.add(mSlot4);
                    }
                }
                String[] mSlotArray4 = new String[mSlotLists.size()];
                mSlotLists.toArray(mSlotArray4);
                addSlotOnSpinner(mSlotArray4);
                this.spin_AltitudeUnit.setVisibility(0);
                this.spin_VariometerUnit.setVisibility(0);
                this.tv_AltitudeUnit.setVisibility(0);
                this.tv_VariometerUnit.setVisibility(0);
                this.tv_AlertMax.setVisibility(0);
                this.tv_AlertMin.setVisibility(0);
                this.et_AlertMax.setVisibility(0);
                this.et_AlertMin.setVisibility(0);
                this.layout_AlertEnable.setVisibility(0);
                if (this.flag != 0) {
                    if (!this.SensorTitle.equals("")) {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                        break;
                    } else {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labAltitudeTile));
                        this.flag = 0;
                        break;
                    }
                }
                break;
            case 5:
                for (String mSlot5 : this.slotLists_ARRAY4) {
                    boolean status3 = false;
                    for (int i3 = 0; i3 < 8; i3++) {
                        if ((this.mAllSlotsSensorName[Integer.valueOf(mSlot5).intValue() + i3] == null || !this.mAllSlotsSensorName[Integer.valueOf(mSlot5).intValue() + i3].equals((String) getResources().getText(C0112R.string.labGPSLocusTile))) && this.mAllSlots[Integer.valueOf(mSlot5).intValue() + i3]) {
                            status3 = true;
                        }
                    }
                    if (!status3) {
                        mSlotLists.add(mSlot5);
                    }
                }
                String[] mSlotArray5 = new String[mSlotLists.size()];
                mSlotLists.toArray(mSlotArray5);
                addSlotOnSpinner(mSlotArray5);
                this.spin_AltitudeUnit.setVisibility(0);
                this.spin_VariometerUnit.setVisibility(0);
                this.spin_SpeedUnit.setVisibility(0);
                this.tv_AltitudeUnit.setVisibility(0);
                this.tv_VariometerUnit.setVisibility(0);
                this.tv_SpeedUnit.setVisibility(0);
                if (this.flag != 0) {
                    if (!this.SensorTitle.equals("")) {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                        break;
                    } else {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labGPSTile));
                        this.flag = 0;
                        break;
                    }
                }
                break;
            case 6:
                for (String mSlot6 : this.slotLists_ARRAY4) {
                    boolean status4 = false;
                    for (int i4 = 0; i4 < 8; i4++) {
                        if ((this.mAllSlotsSensorName[Integer.valueOf(mSlot6).intValue() + i4] == null || !this.mAllSlotsSensorName[Integer.valueOf(mSlot6).intValue() + i4].equals((String) getResources().getText(C0112R.string.labGPSTile))) && this.mAllSlots[Integer.valueOf(mSlot6).intValue() + i4]) {
                            status4 = true;
                        }
                    }
                    if (!status4) {
                        mSlotLists.add(mSlot6);
                    }
                }
                String[] mSlotArray6 = new String[mSlotLists.size()];
                mSlotLists.toArray(mSlotArray6);
                addSlotOnSpinner(mSlotArray6);
                if (this.flag != 0) {
                    if (!this.SensorTitle.equals("")) {
                        this.et_Title.setText(this.SensorTitle);
                        this.SensorTitle = "";
                        break;
                    } else {
                        this.et_Title.setText((String) getResources().getText(C0112R.string.labGPSLocusTile));
                        this.flag = 0;
                        break;
                    }
                }
                break;
        }
        this.spin_Slot.setSelection(this.slotValue);
        setAlertEnable();
        setAlert2Enable();
    }

    private void loadData() throws ParserConfigurationException, SAXException, IOException {
        String DataType2;
        String strType;
        if (this.mGaugeViewSetting == null) {
            CloseDialog();
        }
        if (this.mGaugeViewSetting.getDataType() == null) {
            DataType2 = "Sensor";
        } else {
            DataType2 = this.mGaugeViewSetting.getDataType().toString();
        }
        this.SensorTitle = this.mGaugeViewSetting.getSensorTitle();
        this.Attributes = this.mGaugeViewSetting.getAttributes();
        if (DataType2.equals("Servo")) {
            setDeviceState(DataType2);
            return;
        }
        String Slots = XMLHelper.GetValue(this.Attributes, "Slot");
        int mSlot = -1;
        if (!Slots.equals("")) {
            mSlot = Integer.valueOf(Slots).intValue();
        }
        String SensorType2 = "";
        int position_DataType = 0;
        if (DataType2.equals("Sensor")) {
            position_DataType = 1;
            if (this.mGaugeViewSetting.getSensorType() == null) {
                SensorType2 = "";
            } else {
                SensorType2 = this.mGaugeViewSetting.getSensorType().toString();
            }
            if (this.mGaugeViewSetting.getSensorType() == SensorTypes.Receiver || this.mGaugeViewSetting.getSensorType() == SensorTypes.Temperature || this.mGaugeViewSetting.getSensorType() == SensorTypes.RPM) {
                this.slotCount = 1;
            } else {
                if (this.mGaugeViewSetting.getSensorType() == SensorTypes.Voltage) {
                    this.slotCount = 2;
                } else {
                    if (this.mGaugeViewSetting.getSensorType() == SensorTypes.Altitude) {
                        this.slotCount = 3;
                    } else {
                        if (this.mGaugeViewSetting.getSensorType() == SensorTypes.GPS || this.mGaugeViewSetting.getSensorType() == SensorTypes.GPSLocus) {
                            this.slotCount = 8;
                        }
                    }
                }
            }
            for (int i = 0; i < this.slotCount; i++) {
                this.mAllSlots[mSlot + i] = false;
            }
        }
        int position_SensorType = 0;
        if (SensorType2.equals("Receiver")) {
            setState(0);
            position_SensorType = 0;
        } else if (SensorType2.equals("Voltage")) {
            setState(1);
            position_SensorType = 1;
        } else if (SensorType2.equals("Temperature")) {
            setState(2);
            position_SensorType = 2;
        } else if (SensorType2.equals("RPM")) {
            setState(3);
            position_SensorType = 3;
        } else if (SensorType2.equals("Altitude")) {
            setState(4);
            position_SensorType = 4;
        } else if (SensorType2.equals("GPS")) {
            setState(5);
            position_SensorType = 5;
        } else if (SensorType2.equals("GPSLocus")) {
            setState(6);
            position_SensorType = 6;
        }
        this.spin_Device.setSelection(position_DataType);
        this.spin_Sensor.setSelection(position_SensorType);
        boolean AlertEnable = false;
        boolean Alert2Enable = false;
        String str = "";
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        switch (this.State) {
            case 0:
            case 1:
                this.MaxValue = XMLHelper.GetValue(this.Attributes, "ValueMax");
                this.MaxValue2 = XMLHelper.GetValue(this.Attributes, "Value2Max");
                this.strShowBattery = XMLHelper.GetValue(this.Attributes, "ShowBattery");
                if (this.strShowBattery.equals("I")) {
                    this.ckBox_ShowBattery.setChecked(true);
                    this.ckBox_ShowExtBattery.setChecked(false);
                } else if (this.strShowBattery.equals("E")) {
                    this.ckBox_ShowBattery.setChecked(false);
                    this.ckBox_ShowExtBattery.setChecked(true);
                } else {
                    this.ckBox_ShowBattery.setChecked(true);
                    this.ckBox_ShowExtBattery.setChecked(true);
                }
                this.fristSet = false;
                String strAlertEnable = XMLHelper.GetValue(this.Attributes, "AlertEnable");
                if (!strAlertEnable.equals("")) {
                    AlertEnable = Boolean.valueOf(strAlertEnable).booleanValue();
                }
                this.tBtn_AlertEnable.setChecked(AlertEnable);
                String strAlert2Enable = XMLHelper.GetValue(this.Attributes, "Alert2Enable");
                if (!strAlert2Enable.equals("")) {
                    Alert2Enable = Boolean.valueOf(strAlert2Enable).booleanValue();
                }
                this.tBtn_Alert2Enable.setChecked(Alert2Enable);
                if (AlertEnable) {
                    this.et_AlertMax.setText(XMLHelper.GetValue(this.Attributes, "AlertMax"));
                    this.et_AlertMin.setText(XMLHelper.GetValue(this.Attributes, "AlertMin"));
                }
                if (Alert2Enable) {
                    this.et_Alert2Max.setText(XMLHelper.GetValue(this.Attributes, "Alert2Max"));
                    this.et_Alert2Min.setText(XMLHelper.GetValue(this.Attributes, "Alert2Min"));
                    break;
                }
                break;
            case 2:
                this.spin_Unit.setSelection(this.adpUnit.getPosition(XMLHelper.GetValue(this.Attributes, "Unit")));
                this.MaxValue = XMLHelper.GetValue(this.Attributes, "ValueMax");
                String strAlertEnable2 = XMLHelper.GetValue(this.Attributes, "AlertEnable");
                if (!strAlertEnable2.equals("")) {
                    AlertEnable = Boolean.valueOf(strAlertEnable2).booleanValue();
                }
                this.tBtn_AlertEnable.setChecked(AlertEnable);
                if (AlertEnable) {
                    this.et_AlertMax.setText(XMLHelper.GetValue(this.Attributes, "AlertMax"));
                    this.et_AlertMin.setText(XMLHelper.GetValue(this.Attributes, "AlertMin"));
                    break;
                }
                break;
            case 3:
                String str6 = "";
                if (XMLHelper.GetValue(this.Attributes, "Type").equals("Optics")) {
                    strType = getString(C0112R.string.optics);
                } else {
                    strType = getString(C0112R.string.magnet);
                }
                this.spin_Type.setSelection(this.adpType.getPosition(strType));
                this.MaxValue = XMLHelper.GetValue(this.Attributes, "RpmMax");
                this.et_Range.setText(XMLHelper.GetValue(this.Attributes, "Range"));
                String strAlertEnable3 = XMLHelper.GetValue(this.Attributes, "AlertEnable");
                if (!strAlertEnable3.equals("")) {
                    AlertEnable = Boolean.valueOf(strAlertEnable3).booleanValue();
                }
                this.tBtn_AlertEnable.setChecked(AlertEnable);
                if (AlertEnable) {
                    this.et_AlertMax.setText(XMLHelper.GetValue(this.Attributes, "AlertMax"));
                    this.et_AlertMin.setText(XMLHelper.GetValue(this.Attributes, "AlertMin"));
                    break;
                }
                break;
            case 4:
                this.spin_AltitudeUnit.setSelection(this.adpAltitudeUnit.getPosition(XMLHelper.GetValue(this.Attributes, "AltitudeUnit")));
                this.spin_VariometerUnit.setSelection(this.adpVariometerUnit.getPosition(XMLHelper.GetValue(this.Attributes, "VariometerUnit")));
                this.RegulateValue = XMLHelper.GetValue(this.Attributes, "RegulateValue");
                String strAlertEnable4 = XMLHelper.GetValue(this.Attributes, "AlertEnable");
                if (!strAlertEnable4.equals("")) {
                    AlertEnable = Boolean.valueOf(strAlertEnable4).booleanValue();
                }
                this.tBtn_AlertEnable.setChecked(AlertEnable);
                if (AlertEnable) {
                    this.et_AlertMax.setText(XMLHelper.GetValue(this.Attributes, "AlertMax"));
                    this.et_AlertMin.setText(XMLHelper.GetValue(this.Attributes, "AlertMin"));
                    break;
                }
                break;
            case 5:
                this.spin_AltitudeUnit.setSelection(this.adpAltitudeUnit.getPosition(XMLHelper.GetValue(this.Attributes, "AltitudeUnit")));
                this.spin_VariometerUnit.setSelection(this.adpVariometerUnit.getPosition(XMLHelper.GetValue(this.Attributes, "VariometerUnit")));
                this.spin_SpeedUnit.setSelection(this.adpSpeedUnit.getPosition(XMLHelper.GetValue(this.Attributes, "SpeedUnit")));
                break;
        }
        this.slotValue = this.adpSlot.getPosition(Slots);
    }

    /* access modifiers changed from: private */
    public boolean SaveBack() throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DataTypes mDataType;
        String sType;
        XMLHelper.ReLoadXml();
        SensorTypes mSensorType = null;
        String mAttributes = "";
        String mTitle = "";
        if (this.spin_Device.getSelectedItem().toString().equals((String) getResources().getText(C0112R.string.servo))) {
            mDataType = DataTypes.Servo;
        } else {
            mDataType = DataTypes.Sensor;
        }
        this.mGaugeViewSetting.setDataType(mDataType);
        if (mDataType == DataTypes.Servo) {
            this.mGaugeViewSetting.setSensorTitle(mTitle);
            this.mGaugeViewSetting.setDataType(mDataType);
            this.mGaugeViewSetting.setSensorType(null);
            this.mGaugeViewSetting.setAttributes(mAttributes);
            return true;
        }
        String sSensor = this.spin_Sensor.getSelectedItem().toString();
        if (sSensor.equals((String) getResources().getText(C0112R.string.labReceiverTile))) {
            mSensorType = SensorTypes.Receiver;
        } else if (sSensor.equals((String) getResources().getText(C0112R.string.labVoltageTile))) {
            mSensorType = SensorTypes.Voltage;
        } else if (sSensor.equals((String) getResources().getText(C0112R.string.labAltitudeTile))) {
            mSensorType = SensorTypes.Altitude;
        } else if (sSensor.equals((String) getResources().getText(C0112R.string.labTemperatureTile))) {
            mSensorType = SensorTypes.Temperature;
        } else if (sSensor.equals((String) getResources().getText(C0112R.string.labRPMTile))) {
            mSensorType = SensorTypes.RPM;
        } else if (sSensor.equals((String) getResources().getText(C0112R.string.labGPSTile))) {
            mSensorType = SensorTypes.GPS;
        } else if (sSensor.equals((String) getResources().getText(C0112R.string.labGPSLocusTile))) {
            mSensorType = SensorTypes.GPSLocus;
        }
        String mTitle2 = this.et_Title.getText().toString();
        switch (this.State) {
            case 0:
            case 1:
                if (this.tBtn_AlertEnable.isChecked()) {
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText(this.et_MaxValue.getText());
                    }
                    if (this.et_AlertMin.getText().toString().equals("")) {
                        this.et_AlertMin.setText("0");
                    }
                }
                if (this.tBtn_Alert2Enable.isChecked()) {
                    if (this.et_Alert2Max.getText().toString().equals("")) {
                        this.et_Alert2Max.setText(this.et_MaxValue2.getText());
                    }
                    if (this.et_Alert2Min.getText().toString().equals("")) {
                        this.et_Alert2Min.setText("0");
                    }
                }
                if (this.ckBox_ShowBattery.isChecked() && this.ckBox_ShowExtBattery.isChecked()) {
                    this.strShowBattery = "A";
                } else if (!this.ckBox_ShowBattery.isChecked() || this.ckBox_ShowExtBattery.isChecked()) {
                    this.strShowBattery = "E";
                } else {
                    this.strShowBattery = "I";
                }
                mAttributes = XMLHelper.GetUpdateStr(new String[]{"Slot", "ValueMax", "Value2Max", "ShowBattery", "AlertEnable", "AlertMax", "AlertMin", "Alert2Enable", "Alert2Max", "Alert2Min"}, new String[]{this.spin_Slot.getSelectedItem().toString(), this.et_MaxValue.getText().toString(), this.et_MaxValue2.getText().toString(), this.strShowBattery, String.valueOf(this.tBtn_AlertEnable.isChecked()), this.et_AlertMax.getText().toString(), this.et_AlertMin.getText().toString(), String.valueOf(this.tBtn_Alert2Enable.isChecked()), this.et_Alert2Max.getText().toString(), this.et_Alert2Min.getText().toString()});
                break;
            case 2:
                if (this.tBtn_AlertEnable.isChecked()) {
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText(this.et_MaxValue.getText());
                    }
                    if (this.et_AlertMin.getText().toString().equals("")) {
                        if (this.spin_Unit.getSelectedItem().toString().equals("˚C")) {
                            this.et_AlertMin.setText("-20");
                        } else {
                            this.et_AlertMin.setText("-4");
                        }
                    }
                }
                mAttributes = XMLHelper.GetUpdateStr(new String[]{"Slot", "Unit", "ValueMax", "AlertEnable", "AlertMax", "AlertMin"}, new String[]{this.spin_Slot.getSelectedItem().toString(), this.spin_Unit.getSelectedItem().toString(), this.spin_MaxValue.getSelectedItem().toString(), String.valueOf(this.tBtn_AlertEnable.isChecked()), this.et_AlertMax.getText().toString(), this.et_AlertMin.getText().toString()});
                break;
            case 3:
                if (this.tBtn_AlertEnable.isChecked()) {
                    if (this.et_AlertMax.getText().toString().equals("")) {
                        this.et_AlertMax.setText(String.valueOf(Integer.valueOf(this.et_MaxValue.getText().toString()).intValue() * 1000));
                    }
                    if (this.et_AlertMin.getText().toString().equals("")) {
                        this.et_AlertMin.setText("0");
                    }
                }
                if (this.spin_Type.getSelectedItem().toString().equals(getString(C0112R.string.optics)) && Double.valueOf(this.et_Range.getText().toString()).doubleValue() < 2.0d) {
                    this.et_Range.setText("2");
                }
                String str = "";
                if (this.spin_Type.getSelectedItem().toString().equals(getString(C0112R.string.optics))) {
                    sType = "Optics";
                } else {
                    sType = "Magnet";
                }
                mAttributes = XMLHelper.GetUpdateStr(new String[]{"Slot", "Type", "Range", "RpmMax", "AlertEnable", "AlertMax", "AlertMin"}, new String[]{this.spin_Slot.getSelectedItem().toString(), sType, this.et_Range.getText().toString(), this.et_MaxValue.getText().toString(), String.valueOf(this.tBtn_AlertEnable.isChecked()), this.et_AlertMax.getText().toString(), this.et_AlertMin.getText().toString()});
                break;
            case 4:
                mAttributes = XMLHelper.GetUpdateStr(new String[]{"Slot", "AltitudeUnit", "VariometerUnit", "AlertEnable", "AlertMax", "AlertMin", "RegulateValue"}, new String[]{this.spin_Slot.getSelectedItem().toString(), this.spin_AltitudeUnit.getSelectedItem().toString(), this.spin_VariometerUnit.getSelectedItem().toString(), String.valueOf(this.tBtn_AlertEnable.isChecked()), this.et_AlertMax.getText().toString(), this.et_AlertMin.getText().toString(), this.RegulateValue});
                break;
            case 5:
                mAttributes = XMLHelper.GetUpdateStr(new String[]{"Slot", "AltitudeUnit", "VariometerUnit", "SpeedUnit"}, new String[]{this.spin_Slot.getSelectedItem().toString(), this.spin_AltitudeUnit.getSelectedItem().toString(), this.spin_VariometerUnit.getSelectedItem().toString(), this.spin_SpeedUnit.getSelectedItem().toString()});
                break;
            case 6:
                mAttributes = XMLHelper.GetUpdateStr(new String[]{"Slot"}, new String[]{this.spin_Slot.getSelectedItem().toString()});
                break;
        }
        this.mGaugeViewSetting.setSensorTitle(mTitle2);
        this.mGaugeViewSetting.setDataType(mDataType);
        this.mGaugeViewSetting.setSensorType(mSensorType);
        this.mGaugeViewSetting.setAttributes(mAttributes);
        this.slotValue = Integer.valueOf(this.spin_Slot.getSelectedItem().toString()).intValue();
        for (int i = 0; i < this.slotCount; i++) {
            this.mAllSlots[this.slotValue + i] = true;
        }
        GaugeActivity.mGaugePagerAdapter.setAllSlots(this.mAllSlots);
        return true;
    }

    /* access modifiers changed from: private */
    public void CloseDialog() {
        try {
            Intent intent = getActivity().getIntent();
            intent.putExtra(ArgumentKey.Key_Page, this.Page);
            intent.putExtra(ArgumentKey.Key_Col, this.Col);
            intent.putExtra(ArgumentKey.Key_Row, this.Row);
            ArrayList<Object> vlist = new ArrayList<>();
            vlist.add(this.mGaugeViewSetting);
            intent.putExtra(ArgumentKey.Key_ViewSetting, vlist);
            getTargetFragment().onActivityResult(getTargetRequestCode(), -1, intent);
            getDialog().dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
