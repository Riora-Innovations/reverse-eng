package com.futaba.androidmadlink.view;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class GPSProperty extends SensorProperty {
    private String _unitA;
    private String _unitS;
    private String _unitV;

    public GPSProperty() {
        this._slot = 8;
        this._slotCount = 8;
        this._unitS = "km/h";
        this._unitA = "m";
        this._unitV = "m/s";
    }

    public String getSpeedUnit() {
        return this._unitS;
    }

    public void setSpeedUnit(String unit) {
        this._unitS = unit;
    }

    public String getAltitudeUnit() {
        return this._unitA;
    }

    public void setAltitudeUnit(String unit) {
        this._unitA = unit;
    }

    public String getVariometerUnit() {
        return this._unitV;
    }

    public void setVariometerUnit(String unit) {
        this._unitV = unit;
    }

    public void setValues(String vlaues) {
        try {
            JSONObject jsonResponse = new JSONObject(vlaues);
            setSlot(Integer.valueOf(jsonResponse.getInt("Slot")));
            setAltitudeUnit(jsonResponse.getString("AltitudeUnit"));
            setVariometerUnit(jsonResponse.getString("VariometerUnit"));
            setSpeedUnit(jsonResponse.getString("SpeedUnit"));
        } catch (JSONException e) {
            Log.d("FutabaRCTool", "GPSProperty Parser Json Error :" + e.getMessage());
        }
    }

    public String ToString() {
        return "";
    }
}
