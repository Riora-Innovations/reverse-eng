package com.futaba.androidmadlink.data;

import com.futaba.androidmadlink.view.SensorTypes;

public class LogViewData {
    private int _maxValue;
    private int _maxValue2;
    private double _range = -1.0d;
    private double _regulateValue = 0.0d;
    private SensorTypes _sensorType = null;
    private int _slot = -1;
    private int _slotCount = -1;
    private String _title = "";
    private String _valType;
    private int _valTypeValue = -1;

    public void setSensorTitle(String title) {
        this._title = title;
    }

    public String getSensorTitle() {
        return this._title;
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

    public double getRange() {
        return this._range;
    }

    public void setRange(double range) {
        this._range = range;
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

    public int getMax2() {
        return this._maxValue2;
    }

    public void setMax2(int maxValue) {
        this._maxValue2 = maxValue;
    }

    public double getRegulateValue() {
        return this._regulateValue;
    }

    public void setRegulateValue(double value) {
        this._regulateValue = value;
    }
}
