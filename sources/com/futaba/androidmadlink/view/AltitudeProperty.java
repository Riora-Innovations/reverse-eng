package com.futaba.androidmadlink.view;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class AltitudeProperty extends SensorProperty {
    private boolean _alertEnable;
    private double _alertMax;
    private double _alertMin;
    private String _unitA;
    private String _unitV;

    public AltitudeProperty() {
        this._alertEnable = false;
        this._unitA = "m";
        this._unitV = "m/s";
        this._slot = 1;
        this._slotCount = 3;
        this._unitA = "m";
        this._unitV = "m/s";
    }

    public String getAltitudeUnit() {
        return this._unitA;
    }

    public void setAltitudeUnit(String unit) {
        this._unitA = unit;
        if (unit.equals("")) {
            this._unitA = "m";
        }
    }

    public String getVariometerUnit() {
        return this._unitV;
    }

    public void setVariometerUnit(String unit) {
        this._unitV = unit;
        if (unit.equals("")) {
            this._unitV = "m/s";
        }
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
            setAltitudeUnit(jsonResponse.getString("AltitudeUnit"));
            setVariometerUnit(jsonResponse.getString("VariometerUnit"));
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
            Log.d("FutabaRCTool", "AltitudeProperty Parser Json Error :" + e.getMessage());
        }
    }

    public String ToString() {
        return "";
    }
}
