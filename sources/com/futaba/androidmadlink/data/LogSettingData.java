package com.futaba.androidmadlink.data;

import com.futaba.androidmadlink.util.MathUtil;

public class LogSettingData {
    private int pinionGear = 0;
    private int pulleyLarge = 1;
    private int pulleySmall = 0;
    private int spurGear = 1;
    private int tireDiameterEven = 0;
    private int tireDiameterOdd = 0;

    public int getPinionGear() {
        return this.pinionGear;
    }

    public void setPinionGear(int pinionGear2) {
        this.pinionGear = pinionGear2;
    }

    public int getSpurGear() {
        return this.spurGear;
    }

    public void setSpurGear(int spurGear2) {
        if (spurGear2 == 0) {
            this.spurGear = 1;
        } else {
            this.spurGear = spurGear2;
        }
    }

    public int getPulleySmall() {
        return this.pulleySmall;
    }

    public void setPulleySmall(int pulleySmall2) {
        this.pulleySmall = pulleySmall2;
    }

    public int getPulleyLarge() {
        return this.pulleyLarge;
    }

    public void setPulleyLarge(int pulleyLarge2) {
        if (pulleyLarge2 == 0) {
            this.pulleyLarge = 1;
        } else {
            this.pulleyLarge = pulleyLarge2;
        }
    }

    public double getTireDiameter() {
        return (double) (((this.tireDiameterOdd * 256) + this.tireDiameterEven) / 10);
    }

    public void setTireDiameter(double tireDiameter) {
        int tireDiameter_int = MathUtil.roundToInt(10.0d * tireDiameter);
        this.tireDiameterOdd = tireDiameter_int / 256;
        this.tireDiameterEven = tireDiameter_int % 256;
    }

    public int getTireDiameterEven() {
        return this.tireDiameterEven;
    }

    public void setTireDiameterEven(int tireDiameterEven2) {
        this.tireDiameterEven = tireDiameterEven2;
    }

    public int getTireDiameterOdd() {
        return this.tireDiameterOdd;
    }

    public void setTireDiameterOdd(int tireDiameterOdd2) {
        this.tireDiameterOdd = tireDiameterOdd2;
    }
}
