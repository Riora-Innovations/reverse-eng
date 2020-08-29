package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import com.futaba.androidmadlink.data.WriteLog;
import com.google.android.gms.maps.model.LatLng;
import java.math.BigDecimal;
import java.util.List;

public class GPSView extends View implements ISBusView {
    private int _altitudeTemp;
    private double _altitudeValue;
    protected String _attributes = "{'Slot':'8','SpeedUnit':'km/s','AltitudeUnit':'m','VariometerUnit':'m/s'}";
    private int _col = -1;
    int _color1 = -16777216;
    int _color2 = -1;
    int _color3 = -16713491;
    int _color4 = -26317;
    int _color5 = -16713491;
    int _color6 = -26317;
    private float _distanceValue;
    private boolean _isWriteLog;
    private String _latitude = "";
    private String _logFileName;
    private String _longitude = "";
    private int _page = -1;
    private double _pressureValue;
    private GPSProperty _property = new GPSProperty();
    private byte[] _rawData;
    private double _regulateValue = 1.0d;
    private int _row = -1;
    private SensorTypes _sensorType;
    private double _speedValue;
    private String _title = ((String) getResources().getText(C0112R.string.labGPSTile));
    private double _variometerValue;
    Object[] data2Value = new Object[32];
    private int distanceFlag = 0;
    private double latapA = 0.0d;
    private double longapB = 0.0d;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private Paint mfont;
    float xTitle_E;
    float xTitle_S;

    public GPSView(Context context) {
        super(context);
        init();
    }

    public GPSView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        switch (Parameter.getScreenMode()) {
            case 1:
                this._color1 = -1;
                this._color2 = -16777216;
                this._color3 = -16776961;
                this._color4 = -43759;
                this._color5 = -16777216;
                this._color6 = -16777012;
                this._color6 = -16777012;
                return;
            default:
                this._color1 = -16777216;
                this._color2 = -1;
                this._color3 = -16713491;
                this._color4 = -26317;
                this._color5 = -8816265;
                this._color6 = -1;
                return;
        }
    }

    public double getRegulateValue() {
        return this._regulateValue;
    }

    public void setRegulateValue(double value) {
        this._regulateValue = value;
    }

    public float getDistanceValue() {
        return this._distanceValue;
    }

    public void setDistanceValue(String value) {
        this._distanceValue = Float.valueOf(value).floatValue();
    }

    public double getAltitudeValue() {
        return this._altitudeValue;
    }

    public void setAltitudeValue(double value) {
        this._altitudeTemp = (int) value;
        double parameter = 1.0d;
        if (this._property.getAltitudeUnit().equals("ft")) {
            parameter = 3.281d;
        }
        this._altitudeValue = Double.valueOf(new BigDecimal((value - this._regulateValue) * parameter).setScale(1, 4).toString()).doubleValue();
    }

    public double getVariometerValue() {
        return this._variometerValue;
    }

    public void setVariometerValue(double value) {
        double parameter = 1.0d;
        if (this._property.getVariometerUnit().equals("mph")) {
            parameter = 2.24d;
        }
        this._variometerValue = Double.valueOf(new BigDecimal(value * parameter).setScale(1, 4).toString()).doubleValue();
    }

    public double getSpeedValue() {
        return this._speedValue;
    }

    public void setSpeedValue(int value) {
        float parameter = 1.0f;
        if (this._property.getVariometerUnit() == "m/h") {
            parameter = 1.61f;
        }
        this._speedValue = Double.valueOf(new BigDecimal((double) (((float) value) * parameter)).setScale(1, 4).toString()).doubleValue();
    }

    public double getPressureValue() {
        return this._pressureValue;
    }

    public void setPressureValue(double value) {
        this._pressureValue = value;
    }

    public String getLatitude() {
        return this._latitude;
    }

    public void setLatitude(String value) {
        this._latitude = value;
    }

    public String getLongitude() {
        return this._longitude;
    }

    public void setLongitude(String value) {
        this._longitude = value;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this._color2);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color1);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        drawBackground(canvas);
        drawValue(canvas);
    }

    private void drawBackground(Canvas canvas) {
        this.mfont = new Paint();
        this.mfont.setColor(this._color3);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setAntiAlias(true);
        this.mfont.setTextAlign(Align.CENTER);
        canvas.drawText(getSensorTitle(), (float) (this.mWidth / 2), ((float) this.mHeight) * 0.1f, this.mfont);
        this.mfont = new Paint();
        this.mfont.setTextSkewX(-0.5f);
        this.mfont.setTextAlign(Align.RIGHT);
        this.mfont.setColor(this._color4);
        this.mfont.setTextSize((float) ((this.mWidth / 7) / 3));
        this.mfont.setFakeBoldText(true);
        this.mfont.setAntiAlias(true);
        this.xTitle_S = (float) ((this.mWidth * 3) / 13);
        canvas.drawText("GPS：", this.xTitle_S, ((float) ((this.mHeight * 1) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText((String) getResources().getText(C0112R.string.labDistance2), this.xTitle_S, ((float) ((this.mHeight * 2) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText((String) getResources().getText(C0112R.string.labSpeedTile), this.xTitle_S, ((float) ((this.mHeight * 3) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText((String) getResources().getText(C0112R.string.labAltitude2), this.xTitle_S, ((float) ((this.mHeight * 4) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText((String) getResources().getText(C0112R.string.labVariometer2), this.xTitle_S, ((float) ((this.mHeight * 5) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color5);
        this.mPaint.setStrokeWidth((float) (this.mHeight / 8));
        this.mPaint.setAntiAlias(true);
        this.xTitle_E = (float) ((this.mWidth * 4) / 5);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 1) / 6), this.xTitle_E, (float) ((this.mHeight * 1) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 2) / 6), this.xTitle_E, (float) ((this.mHeight * 2) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 3) / 6), this.xTitle_E, (float) ((this.mHeight * 3) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 4) / 6), this.xTitle_E, (float) ((this.mHeight * 4) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 5) / 6), this.xTitle_E, (float) ((this.mHeight * 5) / 6), this.mPaint);
        this.mPaint.setColor(this._color6);
        this.mPaint.setStrokeWidth((float) (this.mHeight / 9));
        this.xTitle_S += (float) ((this.mHeight / 9) / 20);
        this.xTitle_E -= (float) ((this.mHeight / 9) / 20);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 1) / 6), this.xTitle_E, (float) ((this.mHeight * 1) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 2) / 6), this.xTitle_E, (float) ((this.mHeight * 2) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 3) / 6), this.xTitle_E, (float) ((this.mHeight * 3) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 4) / 6), this.xTitle_E, (float) ((this.mHeight * 4) / 6), this.mPaint);
        canvas.drawLine(this.xTitle_S, (float) ((this.mHeight * 5) / 6), this.xTitle_E, (float) ((this.mHeight * 5) / 6), this.mPaint);
        this.mfont = new Paint();
        this.mfont.setColor(this._color2);
        this.mfont.setTextAlign(Align.LEFT);
        this.mfont.setTextSize((float) ((this.mWidth / 7) / 3));
        this.mfont.setFakeBoldText(true);
        this.mfont.setAntiAlias(true);
        this.xTitle_S = this.xTitle_E + 10.0f;
        canvas.drawText("m", this.xTitle_S, ((float) ((this.mHeight * 2) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText(this._property.getSpeedUnit(), this.xTitle_S, ((float) ((this.mHeight * 3) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText(this._property.getAltitudeUnit(), this.xTitle_S, ((float) ((this.mHeight * 4) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText(this._property.getVariometerUnit(), this.xTitle_S, ((float) ((this.mHeight * 5) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
    }

    private void drawValue(Canvas canvas) {
        this.mfont = new Paint();
        this.mfont.setTextAlign(Align.LEFT);
        this.mfont.setColor(this._color1);
        this.mfont.setTextSize((float) ((this.mHeight / 11) / 2));
        this.mfont.setAntiAlias(true);
        float xValue = (float) (((this.mWidth * 3) / 13) + ((this.mHeight / 11) / 20));
        canvas.drawText(getLatitude(), xValue, (float) (((this.mHeight * 1) / 6) - ((this.mHeight / 11) / 8)), this.mfont);
        canvas.drawText(getLongitude(), xValue, (float) (((this.mHeight * 1) / 6) + ((this.mHeight / 11) / 2)), this.mfont);
        this.mfont.setTextAlign(Align.RIGHT);
        this.mfont.setTextSize((float) (this.mHeight / 11));
        this.mfont.setColor(this._color1);
        float xValue2 = (float) (((this.mWidth * 4) / 5) - ((this.mHeight / 11) / 20));
        canvas.drawText(String.valueOf(getDistanceValue()), xValue2, ((float) ((this.mHeight * 2) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText(String.valueOf(getSpeedValue()), xValue2, ((float) ((this.mHeight * 3) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText(String.valueOf(getAltitudeValue()), xValue2, ((float) ((this.mHeight * 4) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
        canvas.drawText(String.valueOf(getVariometerValue()), xValue2, ((float) ((this.mHeight * 5) / 6)) + (this.mfont.getTextSize() / 3.0f), this.mfont);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthSpecMode == 1073741824 || widthSpecMode == Integer.MIN_VALUE) {
            this.mWidth = widthSpecSize;
        } else {
            this.mWidth = 0;
        }
        if (heightSpecMode == Integer.MIN_VALUE || heightSpecMode == 0) {
            this.mHeight = dipToPx(15);
        } else {
            this.mHeight = heightSpecSize;
        }
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    private int dipToPx(int dip) {
        return (int) ((((float) (dip >= 0 ? 1 : -1)) * 0.5f) + (((float) dip) * getContext().getResources().getDisplayMetrics().density));
    }

    /* access modifiers changed from: 0000 */
    public int getDPFromPixels(int pixels) {
        return pixels * (this.mWidth / 320);
    }

    public DataTypes getDataType() {
        return DataTypes.Sensor;
    }

    public void setSensorType(SensorTypes sensorType) {
        this._sensorType = sensorType;
    }

    public SensorTypes getSensorType() {
        return this._sensorType;
    }

    public void setData(byte[] rawData) {
    }

    public String getAttributes() {
        return this._attributes;
    }

    public void setAttributes(String attributes) {
        this._attributes = attributes;
        this._property.setValues(this._attributes);
    }

    public void setSensorTitle(String title) {
        this._title = title;
    }

    public String getSensorTitle() {
        return this._title;
    }

    public void reset() {
        this.latapA = 0.0d;
        this.longapB = 0.0d;
        this.distanceFlag = 0;
        setRegulateValue((double) this._altitudeTemp);
    }

    public void setISWriteLog(boolean isWriteLog) {
        this._isWriteLog = isWriteLog;
    }

    private boolean getISWriteLog() {
        return this._isWriteLog;
    }

    public void setLogFileName(String logFileName) {
        this._logFileName = logFileName;
    }

    private String getLogFileName() {
        return this._logFileName;
    }

    public void setPage(int Page) {
        this._page = Page;
    }

    public int getPage() {
        return this._page;
    }

    public void setRow(int Row) {
        this._row = Row;
    }

    public int getRow() {
        return this._row;
    }

    public void setCol(int Col) {
        this._col = Col;
    }

    public int getCol() {
        return this._col;
    }

    public int getSlot() {
        return this._property._slot;
    }

    public int getSlotCount() {
        return this._property._slotCount;
    }

    public void setSensorValue(List<Object> sensorValue) {
        float fDistance;
        try {
            if (sensorValue.size() != 0) {
                setVariometerValue(((Double) sensorValue.get(1)).doubleValue());
                setSpeedValue(((Integer) sensorValue.get(2)).intValue());
                setAltitudeValue(((Double) sensorValue.get(3)).doubleValue());
                String[] longString = (String[]) sensorValue.get(4);
                String lonStr = longString[0];
                int lonValue = Integer.valueOf(longString[1]).intValue();
                setLongitude(new StringBuilder(String.valueOf(lonStr)).append(" ").append((lonValue / 60) / 10000).append("° ").append(new BigDecimal((((double) lonValue) / 10000.0d) % 60.0d).setScale(4, 4).toString()).toString());
                String[] latString = (String[]) sensorValue.get(5);
                String latStr = latString[0];
                int latValue = Integer.valueOf(latString[1]).intValue();
                setLatitude(new StringBuilder(String.valueOf(latStr)).append(" ").append((latValue / 60) / 10000).append("° ").append(new BigDecimal((((double) latValue) / 10000.0d) % 60.0d).setScale(1, 4).toString()).toString());
                if (this.distanceFlag == 0) {
                    this.latapA = (double) latValue;
                    this.longapB = (double) lonValue;
                    this.distanceFlag = 1;
                    fDistance = 0.0f;
                } else {
                    Double valueOf = Double.valueOf(0.0d);
                    Double valueOf2 = Double.valueOf(0.0d);
                    Double valueOf3 = Double.valueOf(0.0d);
                    Double valueOf4 = Double.valueOf(0.0d);
                    double latapC = (double) latValue;
                    double longapD = (double) lonValue;
                    Double latapValue = Double.valueOf(Math.abs(this.latapA - latapC) / 600000.0d);
                    Double longValue = Double.valueOf(Math.abs(this.longapB - longapD) / 600000.0d);
                    if (longValue.doubleValue() > 180.0d) {
                        longValue = Double.valueOf(360.0d - longValue.doubleValue());
                    }
                    Double ra = Double.valueOf(6378137.0d);
                    fDistance = Float.valueOf(new BigDecimal(Math.sqrt(Math.pow(Double.valueOf(((6.283185307179586d * Double.valueOf(6356752.314245d).doubleValue()) * latapValue.doubleValue()) / 360.0d).doubleValue(), 2.0d) + Math.pow(Double.valueOf((((6.283185307179586d * ra.doubleValue()) * Math.cos((((this.latapA + latapC) / 2.0d) / 600000.0d) * 0.017453292519943295d)) * longValue.doubleValue()) / 360.0d).doubleValue(), 2.0d))).setScale(1, 4).toString()).floatValue();
                }
                LatLng map = new LatLng((((double) latValue) / 60.0d) / 10000.0d, (((double) lonValue) / 60.0d) / 10000.0d);
                setDistanceValue(new BigDecimal((double) fDistance).setScale(1, 4).toString());
                if (getISWriteLog()) {
                    WriteLog.WriteGPSLog(getLogFileName() + "-GPS" + getId() + "-Slot" + this._property.getSlot(), map, getAltitudeValue(), getSpeedValue());
                }
                invalidate();
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "GPSView setSensorValue Error:" + e.getMessage());
        }
    }
}
