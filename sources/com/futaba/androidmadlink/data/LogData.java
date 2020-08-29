package com.futaba.androidmadlink.data;

import com.futaba.androidmadlink.util.MathUtil;

public class LogData {
    private int times = 0;
    private double value1 = 0.0d;
    private double value2 = 0.0d;
    private double value3 = 0.0d;

    public int getTimes() {
        return this.times;
    }

    public void setTimes(int times2) {
        this.times = times2;
    }

    public double getsetValue1() {
        return MathUtil.round(this.value1, 2);
    }

    public void setValue1(double value) {
        this.value1 = value;
    }

    public double getsetValue2() {
        return MathUtil.round(this.value2, 2);
    }

    public void setValue2(double value) {
        this.value2 = value;
    }

    public double getsetValue3() {
        return MathUtil.round(this.value3, 2);
    }

    public void setValue3(double value) {
        this.value3 = value;
    }
}
