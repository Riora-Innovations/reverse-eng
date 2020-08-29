package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import java.math.BigDecimal;
import java.util.List;

public class VoltageView extends View implements ISBusView {
    protected String _attributes = "{'Slot':'1'}";
    private int _col = -1;
    int _color1 = -16777216;
    int _color2 = -1;
    int _color3 = -1;
    int _color4 = -1;
    int _color5 = -1;
    int _color6 = -16713491;
    private int _page = -1;
    private VoltageProperty _property = new VoltageProperty();
    private byte[] _rawData;
    private int _row = -1;
    private SensorTypes _sensorType;
    private String _title = ((String) getResources().getText(C0112R.string.labVariometerTile));
    private float _value;
    private float _value2;
    Object[] data2Value = new Object[32];
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private Paint mfont;
    private Paint mfont2;

    public VoltageView(Context context) {
        super(context);
        init();
    }

    public VoltageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setExtValue(float value) {
        this._value2 = value;
        invalidate();
    }

    public float getExtValue() {
        return this._value2;
    }

    public void setRxValue(float value) {
        this._value = value;
        invalidate();
    }

    public float getRxValue() {
        return this._value;
    }

    private void init() {
        switch (Parameter.getScreenMode()) {
            case 1:
                this._color1 = -1;
                this._color2 = -16777216;
                this._color3 = -5570578;
                this._color4 = -16759621;
                this._color5 = -43759;
                this._color6 = -16776961;
                return;
            default:
                this._color1 = -16777216;
                this._color2 = -1;
                this._color3 = -3947581;
                this._color4 = -2960686;
                this._color5 = -26317;
                this._color6 = -16713491;
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawFace(canvas);
        drawValue(canvas);
    }

    private void drawFace(Canvas canvas) {
        String titleString;
        String rxTitleString;
        String exTitleString;
        canvas.drawColor(this._color2);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color1);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        this.mfont = new Paint();
        this.mfont.setColor(this._color6);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setAntiAlias(true);
        this.mfont.setTextAlign(Align.CENTER);
        canvas.drawText(getSensorTitle(), (float) (this.mWidth / 2), ((float) this.mHeight) * 0.1f, this.mfont);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        if (this._property.getShowBattery().equals("I") || this._property.getShowBattery().equals("E")) {
            this.mPaint.setColor(this._color2);
            this.mPaint.setStyle(Style.FILL);
            canvas.drawRect((float) ((this.mWidth * 3) / 16), (float) ((this.mHeight / 12) * 2), (float) ((this.mWidth * 15) / 16), (float) (this.mHeight - (this.mHeight / 12)), this.mPaint);
            this.mPaint.setColor(this._color3);
            canvas.drawRect(((float) ((this.mWidth * 3) / 16)) + 5.0f, ((float) ((this.mHeight / 12) * 2)) + 5.0f, ((float) ((this.mWidth * 15) / 16)) - 5.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 5.0f, this.mPaint);
            this.mPaint.setColor(this._color4);
            canvas.drawRect(((float) ((this.mWidth * 3) / 16)) + 7.0f, ((float) ((this.mHeight / 12) * 2)) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 7.0f, this.mPaint);
            canvas.drawRect((float) ((this.mWidth * 2) / 16), (float) ((((this.mHeight / 2) * 11) / 21) + (this.mHeight / 12)), (float) ((this.mWidth * 3) / 16), (float) ((this.mHeight / 2) + (((this.mHeight / 2) * 9) / 21)), this.mPaint);
            this.mfont2 = new Paint();
            this.mfont2.setTextSkewX(-0.5f);
            this.mfont2.setTextAlign(Align.LEFT);
            this.mfont2.setColor(this._color5);
            this.mfont2.setTextSize((float) getDPFromPixels(17));
            this.mfont2.setAntiAlias(true);
            String str = "";
            if (this._property.getShowBattery().equals("I")) {
                if (this._property.getSlot().intValue() == 0) {
                    titleString = (String) getResources().getText(C0112R.string.labRx);
                } else {
                    titleString = (String) getResources().getText(C0112R.string.labBattery);
                }
            } else if (this._property.getSlot().intValue() == 0) {
                titleString = (String) getResources().getText(C0112R.string.labExt);
            } else {
                titleString = (String) getResources().getText(C0112R.string.labExtBattery);
            }
            canvas.drawText(titleString, 0.0f, (float) ((this.mHeight * 1) / 7), this.mfont2);
            return;
        }
        this.mPaint.setColor(this._color2);
        this.mPaint.setStyle(Style.FILL);
        canvas.drawRect((float) ((this.mWidth * 3) / 16), (float) ((this.mHeight / 12) * 2), (float) ((this.mWidth * 15) / 16), (float) (this.mHeight / 2), this.mPaint);
        this.mPaint.setColor(this._color3);
        canvas.drawRect(((float) ((this.mWidth * 3) / 16)) + 5.0f, ((float) ((this.mHeight / 12) * 2)) + 5.0f, ((float) ((this.mWidth * 15) / 16)) - 5.0f, ((float) (this.mHeight / 2)) - 5.0f, this.mPaint);
        this.mPaint.setColor(this._color4);
        canvas.drawRect(((float) ((this.mWidth * 3) / 16)) + 7.0f, ((float) ((this.mHeight / 12) * 2)) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight / 2)) - 7.0f, this.mPaint);
        this.mPaint.setColor(this._color2);
        this.mPaint.setStyle(Style.FILL);
        canvas.drawRect((float) ((this.mWidth * 3) / 16), (float) ((this.mHeight / 2) + (this.mHeight / 12)), (float) ((this.mWidth * 15) / 16), (float) (this.mHeight - (this.mHeight / 12)), this.mPaint);
        this.mPaint.setColor(this._color3);
        canvas.drawRect(((float) ((this.mWidth * 3) / 16)) + 5.0f, ((float) ((this.mHeight / 2) + (this.mHeight / 12))) + 5.0f, ((float) ((this.mWidth * 15) / 16)) - 5.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 5.0f, this.mPaint);
        this.mPaint.setColor(this._color4);
        canvas.drawRect(((float) ((this.mWidth * 3) / 16)) + 7.0f, ((float) ((this.mHeight / 2) + (this.mHeight / 12))) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 7.0f, this.mPaint);
        canvas.drawRect((float) ((this.mWidth * 2) / 16), (float) ((((this.mHeight / 2) * 8) / 21) + (this.mHeight / 12)), (float) ((this.mWidth * 3) / 16), (float) ((((this.mHeight / 2) * 13) / 21) + (this.mHeight / 12)), this.mPaint);
        canvas.drawRect((float) ((this.mWidth * 2) / 16), (float) ((this.mHeight / 2) + (((this.mHeight / 2) * 8) / 21)), (float) ((this.mWidth * 3) / 16), (float) ((this.mHeight / 2) + (((this.mHeight / 2) * 13) / 21)), this.mPaint);
        this.mfont2 = new Paint();
        this.mfont2.setTextSkewX(-0.5f);
        this.mfont2.setTextAlign(Align.LEFT);
        this.mfont2.setColor(this._color5);
        this.mfont2.setTextSize((float) getDPFromPixels(17));
        this.mfont2.setAntiAlias(true);
        String str2 = "";
        String str3 = "";
        if (this._property.getSlot().intValue() == 0) {
            rxTitleString = (String) getResources().getText(C0112R.string.labRx);
            exTitleString = (String) getResources().getText(C0112R.string.labExt);
        } else {
            rxTitleString = (String) getResources().getText(C0112R.string.labBattery);
            exTitleString = (String) getResources().getText(C0112R.string.labExtBattery);
        }
        canvas.drawText(rxTitleString, 0.0f, (float) (this.mHeight / 7), this.mfont2);
        canvas.drawText(exTitleString, 0.0f, (float) ((this.mHeight * 4) / 7), this.mfont2);
    }

    private void drawValue(Canvas canvas) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        this.mfont = new Paint();
        this.mfont.setColor(this._color1);
        this.mfont.setTextAlign(Align.RIGHT);
        this.mfont.setAntiAlias(true);
        this.mfont.setTextSize((float) (this.mHeight / 6));
        float mRValue = getRxValue();
        float mEValue = getExtValue();
        if (this._property.getShowBattery().equals("I")) {
            if (this.mHeight > this.mWidth) {
                this.mfont.setTextSize((float) (this.mWidth / 5));
            } else {
                this.mfont.setTextSize((float) (this.mHeight / 4));
            }
            this.mPaint.reset();
            if (!this._property.getAlertEnable() || ((this._property.getAlertMax() <= 0.0d || ((double) getRxValue()) <= this._property.getAlertMax()) && ((double) getRxValue()) >= this._property.getAlertMin())) {
                this.mPaint.setColor(-16711936);
            } else {
                this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            }
            if (getRxValue() > ((float) this._property.getMax())) {
                mRValue = (float) this._property.getMax();
            }
            canvas.drawRect((((float) ((this.mWidth * 15) / 16)) - 7.0f) - ((((((float) ((this.mWidth * 15) / 16)) - 7.0f) - (((float) ((this.mWidth * 3) / 16)) + 7.0f)) * mRValue) / ((float) this._property.getMax())), ((float) ((this.mHeight / 12) * 2)) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 7.0f, this.mPaint);
            if (this._property.getMax() >= 100) {
                valueOf4 = new BigDecimal((double) getRxValue()).setScale(1, 4).toString();
            } else {
                valueOf4 = Float.valueOf(getRxValue());
            }
            canvas.drawText(String.valueOf(valueOf4) + "V", ((float) ((this.mWidth * 15) / 16)) - 7.0f, (float) ((this.mHeight / 2) + (((this.mHeight / 2) * 5) / 21)), this.mfont);
        } else if (this._property.getShowBattery().equals("E")) {
            if (this.mHeight > this.mWidth) {
                this.mfont.setTextSize((float) (this.mWidth / 5));
            } else {
                this.mfont.setTextSize((float) (this.mHeight / 4));
            }
            this.mPaint.reset();
            if (!this._property.getAlert2Enable() || ((this._property.getAlert2Max() <= 0.0d || ((double) getExtValue()) <= this._property.getAlert2Max()) && ((double) getExtValue()) >= this._property.getAlert2Min())) {
                this.mPaint.setColor(-16711936);
            } else {
                this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            }
            if (getExtValue() > ((float) this._property.getMax2())) {
                mEValue = (float) this._property.getMax2();
            }
            canvas.drawRect((((float) ((this.mWidth * 15) / 16)) - 7.0f) - ((((((float) ((this.mWidth * 15) / 16)) - 7.0f) - (((float) ((this.mWidth * 3) / 16)) + 7.0f)) * mEValue) / ((float) this._property.getMax2())), ((float) ((this.mHeight / 12) * 2)) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 7.0f, this.mPaint);
            if (this._property.getMax2() >= 100) {
                valueOf3 = new BigDecimal((double) getExtValue()).setScale(1, 4).toString();
            } else {
                valueOf3 = Float.valueOf(getExtValue());
            }
            canvas.drawText(String.valueOf(valueOf3) + "V", ((float) ((this.mWidth * 15) / 16)) - 7.0f, (float) ((this.mHeight / 2) + (((this.mHeight / 2) * 5) / 21)), this.mfont);
        } else {
            this.mPaint.reset();
            if (!this._property.getAlertEnable() || ((this._property.getAlertMax() <= 0.0d || ((double) getRxValue()) <= this._property.getAlertMax()) && ((double) getRxValue()) >= this._property.getAlertMin())) {
                this.mPaint.setColor(-16711936);
            } else {
                this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            }
            if (getRxValue() > ((float) this._property.getMax())) {
                mRValue = (float) this._property.getMax();
            }
            canvas.drawRect((((float) ((this.mWidth * 15) / 16)) - 7.0f) - ((((((float) ((this.mWidth * 15) / 16)) - 7.0f) - (((float) ((this.mWidth * 3) / 16)) + 7.0f)) * mRValue) / ((float) this._property.getMax())), ((float) ((this.mHeight / 12) * 2)) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight / 2)) - 7.0f, this.mPaint);
            if (this._property.getMax() >= 100) {
                valueOf = new BigDecimal((double) getRxValue()).setScale(1, 4).toString();
            } else {
                valueOf = Float.valueOf(getRxValue());
            }
            canvas.drawText(String.valueOf(valueOf) + "V", ((float) ((this.mWidth * 15) / 16)) - 7.0f, (float) ((((this.mHeight / 2) * 13) / 21) + (this.mHeight / 12)), this.mfont);
            this.mPaint.reset();
            if (!this._property.getAlert2Enable() || ((this._property.getAlert2Max() <= 0.0d || ((double) getExtValue()) <= this._property.getAlert2Max()) && ((double) getExtValue()) >= this._property.getAlert2Min())) {
                this.mPaint.setColor(-16711936);
            } else {
                this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
            }
            if (getExtValue() > ((float) this._property.getMax2())) {
                mEValue = (float) this._property.getMax2();
            }
            canvas.drawRect((((float) ((this.mWidth * 15) / 16)) - 7.0f) - ((((((float) ((this.mWidth * 15) / 16)) - 7.0f) - (((float) ((this.mWidth * 3) / 16)) + 7.0f)) * mEValue) / ((float) this._property.getMax2())), ((float) ((this.mHeight / 2) + (this.mHeight / 12))) + 7.0f, ((float) ((this.mWidth * 15) / 16)) - 7.0f, ((float) (this.mHeight - (this.mHeight / 12))) - 7.0f, this.mPaint);
            if (this._property.getMax2() >= 100) {
                valueOf2 = new BigDecimal((double) getExtValue()).setScale(1, 4).toString();
            } else {
                valueOf2 = Float.valueOf(getExtValue());
            }
            canvas.drawText(String.valueOf(valueOf2) + "V", ((float) ((this.mWidth * 15) / 16)) - 7.0f, (float) ((this.mHeight / 2) + (((this.mHeight / 2) * 13) / 21)), this.mfont);
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

    /* access modifiers changed from: 0000 */
    public int getDPFromPixels(int pixels) {
        return pixels * (this.mWidth / 320);
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
        return this._property.getSlot().intValue();
    }

    public int getSlotCount() {
        return this._property.getSlotCount().intValue();
    }

    public void setSensorValue(List<Object> sensorValue) {
        try {
            String[] voltageValues = new String[2];
            if (sensorValue.size() != 0) {
                voltageValues = (String[]) sensorValue.get(0);
            }
            if (voltageValues.length != 0) {
                if (voltageValues[0] != null || !voltageValues[0].equals("")) {
                    setRxValue(Float.valueOf(voltageValues[0].toString()).floatValue());
                }
                if (voltageValues[1] != null || !voltageValues[1].equals("")) {
                    setExtValue(Float.valueOf(voltageValues[1].toString()).floatValue());
                }
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "VoltageView setSensorValue Error:" + e.getMessage());
        }
    }
}
