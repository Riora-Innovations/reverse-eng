package com.futaba.androidmadlink.view;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class SensorProperty {
    protected final String TAG;
    private SensorTypes _sensorType;
    protected int _slot;
    protected int _slotCount;

    public SensorProperty() {
        this.TAG = "FutabaRCTool";
        this._sensorType = SensorTypes.Receiver;
        this._slot = 1;
        this._slotCount = 1;
        this._slot = 1;
        this._slotCount = 1;
    }

    public SensorTypes getSensorType() {
        return this._sensorType;
    }

    public void setSensorType(SensorTypes sensorType) {
        this._sensorType = sensorType;
    }

    public Integer getSlot() {
        return Integer.valueOf(this._slot);
    }

    public void setSlot(Integer slot) {
        this._slot = slot.intValue();
    }

    public Integer getSlotCount() {
        return Integer.valueOf(this._slotCount);
    }

    public void setSlotCount(Integer slotCount) {
        this._slotCount = slotCount.intValue();
    }

    public void setValues(String vlaues) {
        try {
            setSlot(Integer.valueOf(new JSONObject(vlaues).getInt("Slot")));
        } catch (JSONException e) {
            Log.d("FutabaRCTool", "AltitudeProperty Parser Json Error :" + e.getMessage());
        }
    }

    public String ToString() {
        return "";
    }
}
