package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import java.math.BigDecimal;
import java.util.List;

public class TemperatureView extends View implements ISBusView {
    protected String _attributes = "{'Slot':'1','Unit':'°C'}";
    private int _col = -1;
    int _color1 = -16777216;
    int _color2 = -1;
    int _color3 = -16713491;
    int _color4 = -26317;
    int _color5 = -332841;
    int _color6 = -16711936;
    private int _majorTick = 10;
    private int _maxValue = 100;
    private int _minValue = -20;
    private int _minorTick = 2;
    private int _page = -1;
    private TemperatureProperty _property = new TemperatureProperty();
    private byte[] _rawData;
    private int _row = -1;
    private SensorTypes _sensorType;
    private String _title = ((String) getResources().getText(C0112R.string.labTemperatureTile));
    private String _unit = "˚C";
    private float _value;
    private float _valueEnter;
    Object[] data2Value = new Object[32];
    int fontSize = 15;
    float fontX = 0.0f;
    float fontY = 2.0f;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private Paint mfont;
    private float xEnd;
    private float xLong;
    private float xStart;
    private float yEnd;
    private float yLong;
    private int yMax;
    private int yMid;
    private int yMin;
    private float yStart;

    public TemperatureView(Context context) {
        super(context);
        init();
    }

    public TemperatureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public float getValue() {
        return this._valueEnter;
    }

    public void setValue(float value) {
        this._valueEnter = value;
        if (value > ((float) getMax())) {
            this._valueEnter = (float) getMax();
        }
        if (value < ((float) getMin())) {
            this._valueEnter = (float) getMin();
        }
        init();
        invalidate();
    }

    public String getUnit() {
        return this._unit;
    }

    public void setUnit(String Unit) {
        this._unit = Unit;
        if (this._unit.equals("˚F")) {
            this._minValue = 0;
        } else {
            this._minValue = -20;
        }
    }

    public int getMax() {
        return this._maxValue;
    }

    public void setMax(int maxValue) {
        this._maxValue = maxValue;
        if (!getUnit().equals("˚C")) {
            switch (maxValue) {
                case 250:
                    this._majorTick = 50;
                    this._minorTick = 10;
                    break;
                case 400:
                    this._majorTick = 80;
                    this._minorTick = 16;
                    break;
                default:
                    this._majorTick = 30;
                    this._minorTick = 6;
                    break;
            }
        } else {
            switch (maxValue) {
                case 100:
                    this._majorTick = 20;
                    this._minorTick = 4;
                    break;
                case 200:
                    this._majorTick = 40;
                    this._minorTick = 4;
                    break;
                default:
                    this._majorTick = 10;
                    this._minorTick = 2;
                    break;
            }
        }
        invalidate();
    }

    public int getMin() {
        return this._minValue;
    }

    public void setMin(int minValue) {
        this._minValue = minValue;
        invalidate();
    }

    private float setCtoF(float value) {
        float fValue = value;
        if (this._unit == "") {
            this._unit = "˚C";
            return fValue;
        } else if (this._unit.equals("˚F")) {
            return Float.valueOf(new BigDecimal((((double) (9.0f * value)) / 5.0d) + 32.0d).setScale(1, 4).toString()).floatValue();
        } else {
            return fValue;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawFace(canvas);
    }

    private void init() {
        this._value = this._valueEnter;
        if (this._unit == "") {
            this._unit = "˚C";
        } else if (this._unit.equals("˚F")) {
            this._value = setCtoF(this._valueEnter);
        }
        switch (Parameter.getScreenMode()) {
            case 1:
                this._color1 = -1;
                this._color2 = -16777216;
                this._color3 = -16776961;
                this._color4 = -18751;
                this._color5 = -332841;
                this._color6 = -16777216;
                this.fontSize = 20;
                this.fontX = 5.0f;
                this.fontY = 2.0f;
                return;
            default:
                this._color1 = -16777216;
                this._color2 = -1;
                this._color3 = -16713491;
                this._color4 = -655366;
                this._color5 = -332841;
                this._color6 = -16711936;
                this.fontSize = 15;
                this.fontX = 0.0f;
                this.fontY = 2.0f;
                return;
        }
    }

    private void drawFace(Canvas canvas) {
        canvas.drawColor(this._color2);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color1);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this._color4);
        RectF rectBg = new RectF();
        rectBg.left = ((float) this.mWidth) * 0.01f * 2.0f;
        rectBg.top = ((float) this.mHeight) * 0.01f * 2.0f;
        rectBg.right = ((float) (this.mWidth / 3)) - ((((float) this.mWidth) * 0.01f) * 2.0f);
        rectBg.bottom = ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 2.0f);
        canvas.drawRoundRect(rectBg, 30.0f, 30.0f, this.mPaint);
        this.mPaint.setColor(this._color5);
        RectF rectBg2 = new RectF();
        rectBg2.left = ((float) this.mWidth) * 0.01f * 3.0f;
        rectBg2.top = ((float) this.mHeight) * 0.01f * 3.0f;
        rectBg2.right = ((float) (this.mWidth / 3)) - ((((float) this.mWidth) * 0.01f) * 3.0f);
        rectBg2.bottom = ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 3.0f);
        canvas.drawRoundRect(rectBg2, 30.0f, 30.0f, this.mPaint);
        this.mPaint = new Paint();
        this.mPaint.setColor(-16777216);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setAntiAlias(true);
        this.xStart = (float) (this.mWidth / 6);
        this.yStart = (((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 8.0f)) - 15.0f;
        this.yEnd = ((float) this.mHeight) * 0.01f * 7.0f;
        float _minScale = (this.yStart - this.yEnd) / ((float) (getMax() - getMin()));
        this.mfont = new Paint();
        this.mfont.setColor(-16777216);
        this.mfont.setTextAlign(Align.CENTER);
        this.mfont.setTextSize((float) getDPFromPixels(this.fontSize));
        this.mfont.setAntiAlias(true);
        if (getUnit().equals("˚C")) {
            int i = getMin();
            while (i <= getMax()) {
                if (i % this._majorTick == 0) {
                    Canvas canvas2 = canvas;
                    canvas2.drawLine(this.xStart - ((float) (this.mWidth / 12)), this.yStart - (((float) (i + 20)) * _minScale), ((float) (this.mWidth / 12)) + this.xStart, this.yStart - (((float) (i + 20)) * _minScale), this.mPaint);
                    canvas.drawText(String.valueOf(i), (((this.xStart - ((float) (this.mWidth / 12))) + 5.0f) - (((float) String.valueOf(i).length()) * _minScale)) - this.fontX, (this.yStart - (((float) (i + 20)) * _minScale)) - this.fontY, this.mfont);
                } else {
                    Canvas canvas3 = canvas;
                    canvas3.drawLine(this.xStart - ((float) (this.mWidth / 24)), this.yStart - (((float) (i + 20)) * _minScale), ((float) (this.mWidth / 24)) + this.xStart, this.yStart - (((float) (i + 20)) * _minScale), this.mPaint);
                    if (i == this._minValue) {
                        canvas.drawText(String.valueOf(i), (((this.xStart - ((float) (this.mWidth / 12))) + 5.0f) - (((float) String.valueOf(i).length()) * _minScale)) - this.fontX, (this.yStart - (((float) (i + 20)) * _minScale)) - this.fontY, this.mfont);
                    }
                }
                i += this._minorTick;
            }
        } else {
            int i2 = getMin();
            while (i2 <= getMax()) {
                if (i2 % this._majorTick == 0) {
                    Canvas canvas4 = canvas;
                    canvas4.drawLine(this.xStart - ((float) (this.mWidth / 12)), this.yStart - (((float) i2) * _minScale), ((float) (this.mWidth / 12)) + this.xStart, this.yStart - (((float) i2) * _minScale), this.mPaint);
                    canvas.drawText(String.valueOf(i2), (((this.xStart - ((float) (this.mWidth / 12))) + 5.0f) - (((float) String.valueOf(i2).length()) * _minScale)) - this.fontX, (this.yStart - (((float) i2) * _minScale)) - this.fontY, this.mfont);
                } else {
                    Canvas canvas5 = canvas;
                    canvas5.drawLine(this.xStart - ((float) (this.mWidth / 24)), this.yStart - (((float) i2) * _minScale), ((float) (this.mWidth / 24)) + this.xStart, this.yStart - (((float) i2) * _minScale), this.mPaint);
                }
                i2 += this._minorTick;
            }
        }
        this.mfont = new Paint();
        this.mfont.setColor(-16777216);
        this.mfont.setTextSize((float) getDPFromPixels(20));
        this.mfont.setAntiAlias(true);
        canvas.drawText(this._unit, this.xStart + ((float) (this.mWidth / 13)), (float) (this.mHeight / 7), this.mfont);
        this.mPaint.setColor(-9543);
        RectF rectBg3 = new RectF();
        rectBg3.left = ((float) this.mWidth) * 0.01f * 15.0f;
        rectBg3.top = ((float) this.mHeight) * 0.01f * 5.0f;
        rectBg3.right = ((float) (this.mWidth / 3)) - ((((float) this.mWidth) * 0.01f) * 15.0f);
        rectBg3.bottom = ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 5.0f);
        canvas.drawRoundRect(rectBg3, (float) getDPFromPixels(15), (float) getDPFromPixels(15), this.mPaint);
        drawValue(canvas, _minScale);
        this.mPaint.setColor(-2354116);
        canvas.drawCircle((float) (this.mWidth / 6), ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 8.0f), ((float) this.mWidth) / 27.0f, this.mPaint);
        this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
        canvas.drawCircle((float) (this.mWidth / 6), ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 8.0f), (((float) this.mWidth) / 27.0f) - 2.0f, this.mPaint);
        this.mfont = new Paint();
        this.mfont.setColor(this._color3);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setAntiAlias(true);
        this.mfont.setTextAlign(Align.CENTER);
        canvas.drawText(getSensorTitle(), (float) (this.mWidth / 2), ((float) this.mHeight) * 0.1f, this.mfont);
        if (this._property.getAlertEnable()) {
            this.mPaint = new Paint();
            Path path = new Path();
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            float yAlertMax = this.yStart - (((((float) this._property.getAlertMax()) - ((float) this._minValue)) / ((float) (this._maxValue - this._minValue))) * (this.yStart - this.yEnd));
            path.moveTo(this.xStart + ((float) (this.mWidth / 48)) + ((float) (this.mHeight / 40)), ((float) (this.mHeight / 40)) + yAlertMax);
            path.lineTo(this.xStart + ((float) (this.mWidth / 48)), yAlertMax);
            path.lineTo(this.xStart + ((float) (this.mWidth / 48)) + ((float) (this.mHeight / 40)), yAlertMax - ((float) (this.mHeight / 40)));
            path.close();
            canvas.drawPath(path, this.mPaint);
            this.mPaint = new Paint();
            Path path2 = new Path();
            this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            float yAlertMin = this.yStart - (((((float) this._property.getAlertMin()) - ((float) this._minValue)) / ((float) (this._maxValue - this._minValue))) * (this.yStart - this.yEnd));
            path2.moveTo(this.xStart + ((float) (this.mWidth / 48)) + ((float) (this.mHeight / 40)), ((float) (this.mHeight / 40)) + yAlertMin);
            path2.lineTo(this.xStart + ((float) (this.mWidth / 48)), yAlertMin);
            path2.lineTo(this.xStart + ((float) (this.mWidth / 48)) + ((float) (this.mHeight / 40)), yAlertMin - ((float) (this.mHeight / 40)));
            path2.close();
            canvas.drawPath(path2, this.mPaint);
        }
    }

    private void drawValue(Canvas canvas, float minScale) {
        this.mfont = new Paint();
        this.mfont.setTextAlign(Align.RIGHT);
        this.mfont.setAntiAlias(true);
        this.mfont.setColor(this._color6);
        if (this._property.getAlertEnable() && (this._value > ((float) this._property.getAlertMax()) || this._value < ((float) this._property.getAlertMin()))) {
            this.mfont.setColor(SupportMenu.CATEGORY_MASK);
        }
        this.mfont.setTextSize((float) (this.mWidth / 6));
        canvas.drawText(new StringBuilder(String.valueOf((int) this._value)).append(this._unit).toString(), (float) (this.mWidth - 4), (float) (this.mHeight / 2), this.mfont);
        this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
        this.mPaint.setStrokeWidth((float) (this.mWidth / 36));
        this.mPaint.setAntiAlias(true);
        RectF rectBg = new RectF();
        if (this._value >= ((float) this._maxValue)) {
            rectBg.left = ((float) this.mWidth) * 0.01f * 15.0f;
            rectBg.top = ((float) this.mHeight) * 0.01f * 5.0f;
            rectBg.right = ((float) (this.mWidth / 3)) - ((((float) this.mWidth) * 0.01f) * 15.0f);
            rectBg.bottom = ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 5.0f);
            canvas.drawRoundRect(rectBg, 20.0f, 20.0f, this.mPaint);
        } else if (this._value <= ((float) this._minValue)) {
            canvas.drawLine((float) (this.mWidth / 6), ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 5.0f), (float) (this.mWidth / 6), this.yStart, this.mPaint);
        } else {
            canvas.drawLine((float) (this.mWidth / 6), ((float) this.mHeight) - ((((float) this.mHeight) * 0.01f) * 5.0f), (float) (this.mWidth / 6), this.yStart - (((this._value - ((float) this._minValue)) / ((float) (this._maxValue - this._minValue))) * (this.yStart - this.yEnd)), this.mPaint);
        }
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
        setUnit(this._property.getUnit());
        setMax(this._property.getMax());
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
                setValue(((Float) sensorValue.get(0)).floatValue());
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "VoltageView setSensorValue Error:" + e.getMessage());
        }
    }
}
