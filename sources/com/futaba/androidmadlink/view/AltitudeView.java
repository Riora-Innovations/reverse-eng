package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import java.util.List;

public class AltitudeView extends View implements ISBusView {
    private float _altitudeTemp;
    private int _altitudeValue;
    protected String _attributes = "{'Slot':'1','AltitudeUnit':'m','VariometerUnit':'m/s'}";
    private int _col = -1;
    int _color1 = -16777216;
    int _color2 = -1;
    int _color3 = -16713491;
    int _color4 = -26317;
    int _color5 = -16713491;
    int _color6 = -26317;
    int _color7 = -16711936;
    private int _maxValue;
    private int _minValue;
    private int _page = -1;
    private float _pressureValue;
    private AltitudeProperty _property = new AltitudeProperty();
    private byte[] _rawData;
    private float _regulateValue = 0.0f;
    private int _row = -1;
    private SensorTypes _sensorType;
    private String _title = ((String) getResources().getText(C0112R.string.labAltitudeTile));
    private int _variometerValue;
    Object[] data2Value = new Object[32];
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private Paint mfont;
    private float minScale;
    private float xStart;
    private float yEnd;
    private float yStart;

    public AltitudeView(Context context) {
        super(context);
        init();
    }

    public AltitudeView(Context context, AttributeSet attrs) {
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
                this._color7 = -16711936;
                return;
            default:
                this._color1 = -16777216;
                this._color2 = -1;
                this._color3 = -16713491;
                this._color4 = -26317;
                this._color5 = -8816265;
                this._color6 = -1;
                this._color7 = -16711936;
                return;
        }
    }

    public int getAltitudeValue() {
        return this._altitudeValue;
    }

    public void setAltitudeValue(float value) {
        this._altitudeTemp = value;
        if (this._property.getAltitudeUnit().equals("ft")) {
            this._altitudeValue = (int) (((double) ((int) (value - this._regulateValue))) * 3.281d);
        } else {
            this._altitudeValue = (int) (value - this._regulateValue);
        }
        this._maxValue = this._altitudeValue + 10;
        this._minValue = this._altitudeValue - 10;
    }

    public void setPressureValue(float value) {
        this._pressureValue = value;
    }

    public float getPressureValue() {
        return this._pressureValue;
    }

    public int getVariometerValue() {
        return this._variometerValue;
    }

    public void setVariometerValue(int value) {
        if (this._property.getVariometerUnit().equals("mph")) {
            this._variometerValue = (int) (((double) value) * 2.24d);
        } else {
            this._variometerValue = value;
        }
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

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.xStart = ((float) (this.mWidth / 6)) + 10.0f;
        this.yStart = (float) ((this.mHeight * 35) / 36);
        this.yEnd = ((float) this.mHeight) * 0.01f * 15.0f;
        this.minScale = (this.yStart - this.yEnd) / ((float) (this._maxValue - this._minValue));
        canvas.drawColor(this._color2);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color1);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        drawFace(canvas);
        drawValue(canvas);
    }

    private void drawFace(Canvas canvas) {
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color2);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setAntiAlias(true);
        this.mfont = new Paint();
        this.mfont.setColor(this._color2);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setTextAlign(Align.LEFT);
        this.mfont.setAntiAlias(true);
        canvas.drawLine(this.xStart, this.yStart, this.xStart, this.yEnd, this.mPaint);
        for (int i = this._minValue; i <= this._maxValue; i++) {
            if (i % 10 == 0) {
                Canvas canvas2 = canvas;
                canvas2.drawLine(this.xStart - ((float) (this.mWidth / 12)), this.yStart - (this.minScale * ((float) (i - this._minValue))), ((float) (this.mWidth / 12)) + this.xStart, this.yStart - (this.minScale * ((float) (i - this._minValue))), this.mPaint);
                canvas.drawText(String.valueOf(i), 0.0f, (this.yStart - (this.minScale * ((float) (i - this._minValue)))) + (this.minScale / 2.0f), this.mfont);
            } else if (i % 5 == 0) {
                Canvas canvas3 = canvas;
                canvas3.drawLine(this.xStart - ((float) (this.mWidth / 18)), this.yStart - (this.minScale * ((float) (i - this._minValue))), ((float) (this.mWidth / 18)) + this.xStart, this.yStart - (this.minScale * ((float) (i - this._minValue))), this.mPaint);
            } else {
                Canvas canvas4 = canvas;
                canvas4.drawLine(this.xStart - ((float) (this.mWidth / 30)), this.yStart - (this.minScale * ((float) (i - this._minValue))), ((float) (this.mWidth / 30)) + this.xStart, this.yStart - (this.minScale * ((float) (i - this._minValue))), this.mPaint);
            }
        }
        this.mfont = new Paint();
        this.mfont.setColor(this._color3);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setAntiAlias(true);
        this.mfont.setTextAlign(Align.CENTER);
        canvas.drawText(getSensorTitle(), (float) (this.mWidth / 2), ((float) this.mHeight) * 0.1f, this.mfont);
        this.mfont = new Paint();
        this.mfont.setTextSkewX(-0.5f);
        this.mfont.setColor(this._color4);
        this.mfont.setTextSize((float) getDPFromPixels(17));
        this.mfont.setFakeBoldText(true);
        this.mfont.setAntiAlias(true);
        canvas.drawText((String) getResources().getText(C0112R.string.labVariometer2), ((float) ((this.mWidth * 3) / 11)) - 5.0f, (float) (((this.mHeight * 1) / 7) + (this.mHeight / 14)), this.mfont);
        canvas.drawText((String) getResources().getText(C0112R.string.labAltitude2), (float) ((this.mWidth * 3) / 11), (float) (((this.mHeight * 3) / 7) + (this.mHeight / 14)), this.mfont);
        canvas.drawText((String) getResources().getText(C0112R.string.labPressure2), (float) ((this.mWidth * 3) / 11), (float) (((this.mHeight * 5) / 7) + (this.mHeight / 14)), this.mfont);
        this.mfont = new Paint();
        this.mfont.setColor(this._color5);
        this.mfont.setStrokeWidth((float) (this.mWidth / 8));
        this.mfont.setAntiAlias(true);
        canvas.drawLine((float) ((this.mWidth * 7) / 16), 0.24f * ((float) this.mHeight), (float) ((this.mWidth * 4) / 5), 0.24f * ((float) this.mHeight), this.mfont);
        canvas.drawLine((float) ((this.mWidth * 7) / 16), 0.525f * ((float) this.mHeight), (float) ((this.mWidth * 4) / 5), 0.525f * ((float) this.mHeight), this.mfont);
        canvas.drawLine((float) ((this.mWidth * 7) / 16), 0.815f * ((float) this.mHeight), (float) ((this.mWidth * 4) / 5), 0.815f * ((float) this.mHeight), this.mfont);
        this.mfont.setColor(this._color6);
        this.mfont.setStrokeWidth((float) (this.mWidth / 9));
        canvas.drawLine(4.0f + ((float) ((this.mWidth * 7) / 16)), 0.24f * ((float) this.mHeight), ((float) ((this.mWidth * 4) / 5)) - 4.0f, 0.24f * ((float) this.mHeight), this.mfont);
        canvas.drawLine(4.0f + ((float) ((this.mWidth * 7) / 16)), 0.525f * ((float) this.mHeight), ((float) ((this.mWidth * 4) / 5)) - 4.0f, 0.525f * ((float) this.mHeight), this.mfont);
        canvas.drawLine(4.0f + ((float) ((this.mWidth * 7) / 16)), 0.815f * ((float) this.mHeight), ((float) ((this.mWidth * 4) / 5)) - 4.0f, 0.815f * ((float) this.mHeight), this.mfont);
        this.mfont = new Paint();
        this.mfont.setColor(this._color2);
        this.mfont.setTextSize((float) getDPFromPixels(22));
        this.mfont.setAntiAlias(true);
        this.mfont.setFakeBoldText(true);
        this.mfont.setTextAlign(Align.LEFT);
        canvas.drawText(" " + this._property.getVariometerUnit(), (float) ((this.mWidth * 4) / 5), (float) ((this.mHeight * 2) / 7), this.mfont);
        canvas.drawText(" " + this._property.getAltitudeUnit(), (float) ((this.mWidth * 4) / 5), (float) ((this.mHeight * 4) / 7), this.mfont);
        canvas.drawText(" hPa", (float) ((this.mWidth * 4) / 5), (float) ((this.mHeight * 6) / 7), this.mfont);
        if (this._property.getAlertEnable()) {
            Path path = new Path();
            Paint p = new Paint();
            p.setColor(SupportMenu.CATEGORY_MASK);
            if (this._property.getAlertMax() > 0.0d && this._property.getAlertMax() < ((double) getMax())) {
                float xValue = (float) (((double) this.yStart) - (((double) this.minScale) * (this._property.getAlertMax() - ((double) this._minValue))));
                path.moveTo(this.xStart + ((float) (this.mWidth / 48)) + this.minScale, (this.minScale / 2.0f) + xValue);
                path.lineTo(this.xStart + ((float) (this.mWidth / 48)), xValue);
                path.lineTo(this.xStart + ((float) (this.mWidth / 48)) + this.minScale, xValue - (this.minScale / 2.0f));
                path.close();
                canvas.drawPath(path, p);
            }
            Paint p2 = new Paint();
            p2.setColor(SupportMenu.CATEGORY_MASK);
            if (this._property.getAlertMin() > ((double) getMin())) {
                float xValue2 = (float) (((double) this.yStart) - (((double) this.minScale) * (this._property.getAlertMin() - ((double) this._minValue))));
                path.moveTo(this.xStart + ((float) (this.mWidth / 48)) + this.minScale, (this.minScale / 2.0f) + xValue2);
                path.lineTo(this.xStart + ((float) (this.mWidth / 48)), xValue2);
                path.lineTo(this.xStart + ((float) (this.mWidth / 48)) + this.minScale, xValue2 - (this.minScale / 2.0f));
                path.close();
                canvas.drawPath(path, p2);
            }
        }
    }

    private void drawValue(Canvas canvas) {
        float xValue = this.yStart - (this.minScale * ((float) (getAltitudeValue() - this._minValue)));
        Paint p = new Paint();
        p.setStrokeWidth(5.0f);
        if (!this._property.getAlertEnable() || (this._property.getAlertMax() > ((double) getAltitudeValue()) && this._property.getAlertMin() < ((double) getAltitudeValue()))) {
            p.setColor(this._color7);
        } else {
            p.setColor(SupportMenu.CATEGORY_MASK);
        }
        Path path = new Path();
        path.moveTo(this.xStart + ((float) (this.mWidth / 48)) + this.minScale, (this.minScale / 2.0f) + xValue);
        path.lineTo(this.xStart + ((float) (this.mWidth / 48)), xValue);
        path.lineTo(this.xStart + ((float) (this.mWidth / 48)) + this.minScale, xValue - (this.minScale / 2.0f));
        path.close();
        path.moveTo((this.xStart - ((float) (this.mWidth / 48))) - this.minScale, (this.minScale / 2.0f) + xValue);
        path.lineTo(this.xStart - ((float) (this.mWidth / 48)), xValue);
        path.lineTo((this.xStart - ((float) (this.mWidth / 48))) - this.minScale, xValue - (this.minScale / 2.0f));
        path.close();
        canvas.drawPath(path, p);
        canvas.drawLine(this.xStart - ((float) (this.mWidth / 30)), xValue, ((float) (this.mWidth / 30)) + this.xStart, xValue, p);
        this.mfont = new Paint();
        this.mfont.setColor(this._color1);
        this.mfont.setTextSize((float) getDPFromPixels(40));
        this.mfont.setAntiAlias(true);
        this.mfont.setFakeBoldText(true);
        this.mfont.setTextAlign(Align.RIGHT);
        canvas.drawText(String.valueOf(getVariometerValue()), ((float) ((this.mWidth * 4) / 5)) - 4.0f, (float) ((this.mHeight * 2) / 7), this.mfont);
        if (!this._property.getAlertEnable() || (this._property.getAlertMax() >= ((double) getAltitudeValue()) && this._property.getAlertMin() <= ((double) getAltitudeValue()))) {
            this.mfont.setColor(this._color1);
        } else {
            this.mfont.setColor(SupportMenu.CATEGORY_MASK);
        }
        canvas.drawText(String.valueOf(getAltitudeValue()), ((float) ((this.mWidth * 4) / 5)) - 4.0f, (float) ((this.mHeight * 4) / 7), this.mfont);
        this.mfont.setColor(this._color1);
        canvas.drawText(String.valueOf(getPressureValue()), ((float) ((this.mWidth * 4) / 5)) - 4.0f, (float) ((this.mHeight * 6) / 7), this.mfont);
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
    }

    public void setISWriteLog(boolean isWriteLog) {
    }

    public void setLogFileName(String logFileName) {
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
        try {
            if (sensorValue.size() != 0) {
                setVariometerValue(((Integer) sensorValue.get(0)).intValue());
                setAltitudeValue(((Float) sensorValue.get(1)).floatValue());
                setPressureValue(Float.valueOf(sensorValue.get(2).toString()).floatValue());
                invalidate();
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "VoltageView setSensorValue Error:" + e.getMessage());
        }
    }
}
