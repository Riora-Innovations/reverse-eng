package com.futaba.androidmadlink.view;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class VoltageProperty extends SensorProperty {
    private boolean _alert2Enable;
    private double _alert2Max;
    private double _alert2Min;
    private boolean _alertEnable;
    private double _alertMax;
    private double _alertMin;
    private int _maxValue;
    private int _maxValue2;
    private String _rxShowStatus;
    private String _valType;
    private int _valTypeValue;

    public VoltageProperty() {
        this._alertEnable = false;
        this._alert2Enable = false;
        this._rxShowStatus = "A";
        this._slot = 1;
        this._slotCount = 1;
        this._maxValue = 10;
        this._maxValue2 = 10;
        this._valType = "Receiver";
        this._valTypeValue = 0;
        this._rxShowStatus = "A";
    }

    public int getValTypeValue() {
        return this._valTypeValue;
    }

    public String getValType() {
        return this._valType;
    }

    public void setValType(String type) {
        this._valType = type;
        if (type.equals("External")) {
            this._valTypeValue = 1;
        } else {
            this._valTypeValue = 0;
        }
    }

    public int getMax() {
        return this._maxValue;
    }

    public void setMax(int maxValue) {
        this._maxValue = maxValue;
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

    public int getMax2() {
        return this._maxValue2;
    }

    public void setMax2(int maxValue) {
        this._maxValue2 = maxValue;
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

    public String getShowBattery() {
        return this._rxShowStatus;
    }

    public void setShowBattery(String value) {
        this._rxShowStatus = value;
    }

    public void setValues(String vlaues) {
        boolean z;
        double d;
        double d2;
        double d3;
        boolean z2 = false;
        double d4 = 0.0d;
        try {
            JSONObject jsonResponse = new JSONObject(vlaues);
            setSlot(Integer.valueOf(jsonResponse.getInt("Slot")));
            setMax(jsonResponse.getInt("ValueMax"));
            setMax2(jsonResponse.getInt("Value2Max"));
            setShowBattery(jsonResponse.getString("ShowBattery"));
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
        } catch (JSONException e) {
            Log.d("FutabaRCTool", "VoltageProperty Parser Json Error :" + e.getMessage());
        }
    }

    public String ToString() {
        return "";
    }
}
