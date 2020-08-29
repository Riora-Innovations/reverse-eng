package com.futaba.androidmadlink.view;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class RPMProperty extends SensorProperty {
    private boolean _alertEnable = false;
    private double _alertMax = 0.0d;
    private double _alertMin = 0.0d;
    private int _maxRPM = 0;
    private double _range = 2.0d;
    private String _type = "Optics";

    public String getType() {
        return this._type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public double getRange() {
        return this._range;
    }

    public void setRange(double rage) {
        this._range = rage;
    }

    public int getMaxRPM() {
        return this._maxRPM;
    }

    public void setMaxRPM(int value) {
        this._maxRPM = value;
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
            setType(jsonResponse.getString("Type"));
            setRange(jsonResponse.getDouble("Range"));
            setMaxRPM(jsonResponse.getInt("RpmMax"));
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
            Log.d("FutabaRCTool", "SensorProperty Parser Json Error :" + e.getMessage());
        }
    }

    public String ToString() {
        return "";
    }
}
