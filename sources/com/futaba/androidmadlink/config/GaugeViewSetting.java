package com.futaba.androidmadlink.config;

import android.util.Log;
import com.futaba.androidmadlink.view.DataTypes;
import com.futaba.androidmadlink.view.SensorTypes;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GaugeViewSetting {
    private boolean _alert2Enable = false;
    private double _alert2Max;
    private double _alert2Min;
    private boolean _alertEnable = false;
    private double _alertMax;
    private double _alertMin;
    private String _attributes = "";
    private int _colNo = 0;
    private int _colSpan = 0;
    private DataTypes _dataType = null;
    private int _no = 1;
    private List<Object> _regulateValueList = new ArrayList();
    private int _rowNo = 0;
    private int _rowSpan = 0;
    private String _rxShowStatus;
    private String _sensorTitle = "";
    private SensorTypes _sensorType = null;
    private List<Object> _sersorValueList = new ArrayList();
    int _slot = -1;
    private String _unit = "";
    private String _valType = "";

    public int getPageNo() {
        return this._no;
    }

    public void setPageNo(int no) {
        this._no = no;
    }

    public int getRowNo() {
        return this._rowNo;
    }

    public void setRowNo(int rowNo) {
        this._rowNo = rowNo;
    }

    public int getColNo() {
        return this._colNo;
    }

    public void setColNo(int colNo) {
        this._colNo = colNo;
    }

    public int getRowSpan() {
        return this._rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this._rowSpan = rowSpan;
    }

    public int getColSpan() {
        return this._colSpan;
    }

    public void setColSpan(int colSpan) {
        this._colSpan = colSpan;
    }

    public String getSensorTitle() {
        return this._sensorTitle;
    }

    public void setSensorTitle(String SensorTitle) {
        this._sensorTitle = SensorTitle;
    }

    public DataTypes getDataType() {
        return this._dataType;
    }

    public void setDataType(DataTypes dataType) {
        this._dataType = dataType;
    }

    public SensorTypes getSensorType() {
        return this._sensorType;
    }

    public void setSensorType(SensorTypes sensorType) {
        this._sensorType = sensorType;
    }

    public String getAttributes() {
        return this._attributes;
    }

    public void setAttributes(String attributes) {
        this._attributes = attributes;
        setValues(attributes);
    }

    public String getUnit() {
        return this._unit;
    }

    public void setUnit(String unit) {
        this._unit = unit;
    }

    public String getValType() {
        return this._valType;
    }

    public void setValType(String type) {
        this._valType = type;
    }

    public String getShowBattery() {
        return this._rxShowStatus;
    }

    public void setShowBattery(String value) {
        this._rxShowStatus = value;
    }

    public boolean getAlertEnable() {
        return this._alertEnable;
    }

    public void setAlertEnable(boolean value) {
        this._alertEnable = value;
    }

    public double getAlertMax() {
        return this._alertMax;
    }

    public void setAlertMax(double value) {
        this._alertMax = value;
    }

    public double getAlertMin() {
        return this._alertMin;
    }

    public void setAlertMin(double value) {
        this._alertMin = value;
    }

    public boolean getAlert2Enable() {
        return this._alert2Enable;
    }

    public void setAlert2Enable(boolean value) {
        this._alert2Enable = value;
    }

    public double getAlert2Max() {
        return this._alert2Max;
    }

    public void setAlert2Max(double value) {
        this._alert2Max = value;
    }

    public double getAlert2Min() {
        return this._alert2Min;
    }

    public void setAlert2Min(double value) {
        this._alert2Min = value;
    }

    public void setValues(String vlaues) {
        int i;
        boolean z;
        double d;
        double d2;
        double d3;
        boolean z2 = false;
        double d4 = 0.0d;
        try {
            JSONObject jsonResponse = new JSONObject(vlaues);
            if (jsonResponse.getString("Slot").equals("")) {
                i = -1;
            } else {
                i = jsonResponse.getInt("Slot");
            }
            setSlot(i);
            if (jsonResponse.getString("AlertEnable").equals("")) {
                z = false;
            } else {
                z = jsonResponse.getBoolean("AlertEnable");
            }
            setAlertEnable(z);
            if (jsonResponse.getString("AlertMax").equals("")) {
                d = 0.0d;
            } else {
                d = jsonResponse.getDouble("AlertMax");
            }
            setAlertMax(d);
            if (jsonResponse.getString("AlertMin").equals("")) {
                d2 = 0.0d;
            } else {
                d2 = jsonResponse.getDouble("AlertMin");
            }
            setAlertMin(d2);
            if (getSensorType() == SensorTypes.Receiver || getSensorType() == SensorTypes.Voltage) {
                if (getSensorType() == SensorTypes.Voltage) {
                    setShowBattery(jsonResponse.getString("ShowBattery"));
                }
                if (!jsonResponse.getString("Alert2Enable").equals("")) {
                    z2 = jsonResponse.getBoolean("Alert2Enable");
                }
                setAlert2Enable(z2);
                if (jsonResponse.getString("Alert2Max").equals("")) {
                    d3 = 0.0d;
                } else {
                    d3 = jsonResponse.getDouble("Alert2Max");
                }
                setAlert2Max(d3);
                if (!jsonResponse.getString("Alert2Min").equals("")) {
                    d4 = jsonResponse.getDouble("Alert2Min");
                }
                setAlert2Min(d4);
            } else if (getSensorType() == SensorTypes.Temperature) {
                setUnit(jsonResponse.getString("Unit"));
            } else if (getSensorType() == SensorTypes.Altitude) {
                if (!jsonResponse.getString("RegulateValue").equals("")) {
                    d4 = jsonResponse.getDouble("RegulateValue");
                }
                setRegulateValue(d4);
            }
        } catch (JSONException e) {
            Log.d(Parameter.TAG, "GaugeViewSetting Values Parser Json Error :" + e.getMessage());
        }
    }

    public int getSlot() {
        return this._slot;
    }

    private void setSlot(int slot) {
        this._slot = slot;
    }

    public List<Object> getSersorValueList() {
        return this._sersorValueList;
    }

    public void setSersorValueList(List<Object> sersorValueList) {
        this._sersorValueList = sersorValueList;
    }

    public List<Object> getRegulateValue() {
        return this._regulateValueList;
    }

    public void setRegulateValue(List<Object> regulateValueList) {
        this._regulateValueList = regulateValueList;
    }

    public void setRegulateValue(double _regulateValue) {
        List<Object> listValues = new ArrayList<>();
        listValues.add(Float.valueOf((float) _regulateValue));
        this._regulateValueList = listValues;
    }
}
