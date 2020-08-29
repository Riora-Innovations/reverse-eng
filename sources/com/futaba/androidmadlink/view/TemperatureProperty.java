package com.futaba.androidmadlink.view;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class TemperatureProperty extends SensorProperty {
    private boolean _alertEnable;
    private double _alertMax;
    private double _alertMin;
    private int _maxValue;
    private int _minValue;
    private String _unit;

    public TemperatureProperty() {
        this._unit = "°C";
        this._maxValue = 100;
        this._minValue = 0;
        this._alertEnable = false;
        this._alertMax = 0.0d;
        this._alertMin = 0.0d;
        this._slot = 1;
        this._slotCount = 1;
        this._unit = "°C";
    }

    public int getMax() {
        return this._maxValue;
    }

    public void setMax(int maxValue) {
        this._maxValue = maxValue;
    }

    public int getMin() {
        return this._minValue;
    }

    public void setMin(int minValue) {
        this._minValue = minValue;
    }

    public String getUnit() {
        return this._unit;
    }

    public void setUnit(String unit) {
        this._unit = unit;
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

    public void setValues(String vlaues) {
        boolean z;
        double d;
        double d2 = 0.0d;
        try {
            JSONObject jsonResponse = new JSONObject(vlaues);
            setSlot(Integer.valueOf(jsonResponse.getInt("Slot")));
            setUnit(jsonResponse.getString("Unit"));
            setMax(jsonResponse.getInt("ValueMax"));
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
            if (!jsonResponse.getString("AlertMin").equals("")) {
                d2 = jsonResponse.getDouble("AlertMin");
            }
            setAlertMin(d2);
        } catch (JSONException e) {
            Log.d("FutabaRCTool", "TemperatureProperty Parser Json Error :" + e.getMessage());
        }
    }

    public String ToString() {
        return "";
    }
}
