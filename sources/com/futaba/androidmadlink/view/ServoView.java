package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.config.Parameter;
import java.util.List;

public class ServoView extends View implements ISBusView {
    private int _col = -1;
    int _color1 = -16777216;
    int _color2 = -1;
    int _color3 = -256;
    int _color4 = -16776961;
    int _color5 = -1;
    private int _page = -1;
    private byte[] _rawData;
    private int _row = -1;
    private String _title = "Servo";
    float _yEnd;
    float _yStart;
    List<Integer> dataValue;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private Paint mfont;
    private float[] servoValues;
    private float xEnd;
    private float xLong;
    private float xStart;
    private float yEnd;
    private float yLong;
    private int yMax;
    private int yMid;
    private int yMin;
    private float yStart;

    public ServoView(Context context) {
        super(context);
        init();
    }

    public ServoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public float[] getChValues() {
        return this.servoValues;
    }

    public void setChValues(float[] valueCh) {
        this.servoValues = valueCh;
        invalidate();
    }

    private void init() {
        this.yMax = 100;
        this.yMin = -100;
        this.yMid = (this.yMax + this.yMin) / 2;
        switch (Parameter.getScreenMode()) {
            case 1:
                this._color1 = -1;
                this._color2 = -16777216;
                this._color3 = -16777012;
                this._color4 = -14518528;
                this._color5 = -52429;
                return;
            default:
                this._color1 = -16777216;
                this._color2 = -1;
                this._color3 = -16711936;
                this._color4 = -16776961;
                this._color5 = -1;
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.xStart = (float) (this.mWidth / 12);
        this.xEnd = (float) this.mWidth;
        this.xLong = this.xEnd - this.xStart;
        this.yStart = (float) ((this.mHeight * 3) / 11);
        this.yEnd = (float) ((this.mHeight / 10) * 9);
        this.yLong = this.yEnd - this.yStart;
        drawFace(canvas);
        drawHistogram(canvas, this.servoValues);
    }

    private void drawFace(Canvas canvas) {
        canvas.drawColor(this._color2);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color1);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color2);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setAntiAlias(true);
        this.mfont = new Paint();
        this.mfont.setFakeBoldText(true);
        this.mfont.setColor(this._color2);
        this.mfont.setTextSize(15.0f);
        this.mfont.setTextAlign(Align.CENTER);
        this.mfont.setAntiAlias(true);
        canvas.drawLine(this.xStart, this.yEnd, (float) this.mWidth, this.yEnd, this.mPaint);
        canvas.drawLine(this.xStart, this.yStart, this.xStart, this.yEnd, this.mPaint);
        canvas.drawLine(this.xStart - 7.0f, this.yStart, this.xStart, this.yStart, this.mPaint);
        canvas.drawText(String.valueOf(-this.yMin), this.xStart - 15.0f, this.yStart - 3.0f, this.mfont);
        Canvas canvas2 = canvas;
        canvas2.drawLine(this.xStart - 7.0f, (this.yLong / 4.0f) + this.yStart, this.xStart, (this.yLong / 4.0f) + this.yStart, this.mPaint);
        Canvas canvas3 = canvas;
        canvas3.drawLine(this.xStart - 7.0f, (this.yLong / 2.0f) + this.yStart, this.xStart, (this.yLong / 2.0f) + this.yStart, this.mPaint);
        Canvas canvas4 = canvas;
        canvas4.drawLine(this.xStart - 7.0f, ((this.yLong / 4.0f) * 3.0f) + this.yStart, this.xStart, ((this.yLong / 4.0f) * 3.0f) + this.yStart, this.mPaint);
        canvas.drawText(String.valueOf(this.yMid), this.xStart - 20.0f, this.yStart + (this.yLong / 2.0f) + 2.0f, this.mfont);
        canvas.drawLine(this.xStart - 7.0f, this.yEnd, this.xStart, this.yEnd, this.mPaint);
        canvas.drawText(String.valueOf(-this.yMax), this.xStart - 15.0f, this.yEnd + 12.0f, this.mfont);
        for (int i = 1; i <= 16; i++) {
            float xValue = this.xStart + ((this.xLong / 17.0f) * ((float) i));
            canvas.drawLine(xValue, this.yEnd, xValue, this.yEnd + 7.0f, this.mPaint);
            canvas.drawText(String.valueOf(i), xValue, this.yEnd + 20.0f, this.mfont);
        }
        this.mPaint = new Paint();
        this.mPaint.setColor(-7634332);
        this.mPaint.setStrokeWidth(this.xLong / 10.0f);
        this.mPaint.setAntiAlias(true);
        this._yStart = this.yStart - 20.0f;
        this._yEnd = 20.0f;
        canvas.drawLine((float) (this.mWidth / 4), this._yStart, (float) (this.mWidth / 4), this._yEnd, this.mPaint);
        canvas.drawLine((float) (this.mWidth / 2), this._yStart, (float) (this.mWidth / 2), this._yEnd, this.mPaint);
        this.mPaint.setColor(this._color1);
        this.mPaint.setStrokeWidth(3.0f);
        this.mfont.setTextSize((float) getDPFromPixels(13));
        canvas.drawLine(((float) (this.mWidth / 4)) - (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), ((float) (this.mWidth / 4)) - (this.xLong / 27.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 4)) - (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 4)) - (this.xLong / 23.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 4)) - (this.xLong / 20.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 4)) - (this.xLong / 23.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 4)) + (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), ((float) (this.mWidth / 4)) + (this.xLong / 27.0f), this._yStart - ((this._yStart - 20.0f) / 2.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 4)) + (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 4)) + (this.xLong / 23.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 4)) + (this.xLong / 20.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 4)) + (this.xLong / 23.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawText("DG1", ((float) (this.mWidth / 4)) - (this.xLong / 10.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), this.mfont);
        canvas.drawLine(((float) (this.mWidth / 2)) - (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), ((float) (this.mWidth / 2)) - (this.xLong / 27.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 2)) - (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 2)) - (this.xLong / 23.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 2)) - (this.xLong / 20.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 2)) - (this.xLong / 23.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 2)) + (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), ((float) (this.mWidth / 2)) + (this.xLong / 27.0f), this._yStart - ((this._yStart - 20.0f) / 2.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 2)) + (this.xLong / 20.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 2)) + (this.xLong / 23.0f), this._yStart - ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawLine(((float) (this.mWidth / 2)) + (this.xLong / 20.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), ((float) (this.mWidth / 2)) + (this.xLong / 23.0f), this._yEnd + ((this._yStart - this._yEnd) / 4.0f), this.mPaint);
        canvas.drawText("DG2", ((float) (this.mWidth / 2)) - (this.xLong / 10.0f), this._yStart - ((this._yStart - this._yEnd) / 2.0f), this.mfont);
    }

    private void drawHistogram(Canvas canvas, float[] Values) {
        this.mPaint = new Paint();
        this.mPaint.setColor(-16711936);
        this.mPaint.setAntiAlias(true);
        int Ch = 0;
        for (float Value : Values) {
            Ch++;
            this.mPaint.setStrokeWidth(this.xLong / 15.0f);
            if (Ch == 17) {
                this.mPaint.setShader(new LinearGradient((float) (this.mWidth / 4), this._yStart, (float) (this.mWidth / 4), this._yEnd, this._color4, this._color3, TileMode.MIRROR));
                if (Value < 0.0f) {
                    canvas.drawLine((float) (this.mWidth / 4), this._yStart - ((this._yStart - this._yEnd) / 2.0f), (float) (this.mWidth / 4), this._yEnd, this.mPaint);
                } else {
                    canvas.drawLine((float) (this.mWidth / 4), this._yStart - ((this._yStart - this._yEnd) / 2.0f), (float) (this.mWidth / 4), this._yStart, this.mPaint);
                }
            } else if (Ch == 18) {
                this.mPaint.setShader(new LinearGradient((float) (this.mWidth / 2), this._yStart, (float) (this.mWidth / 2), this._yEnd, this._color4, this._color3, TileMode.MIRROR));
                if (Value < 0.0f) {
                    canvas.drawLine((float) (this.mWidth / 2), this._yStart - ((this._yStart - this._yEnd) / 2.0f), (float) (this.mWidth / 2), this._yEnd, this.mPaint);
                } else {
                    canvas.drawLine((float) (this.mWidth / 2), this._yStart - ((this._yStart - this._yEnd) / 2.0f), (float) (this.mWidth / 2), this._yStart, this.mPaint);
                }
            } else {
                this.mPaint.setStrokeWidth(this.xLong / 20.0f);
                double _value = (double) Value;
                if (Value >= ((float) this.yMax)) {
                    _value = (double) this.yMax;
                } else if (Value <= ((float) this.yMin)) {
                    _value = (double) this.yMin;
                } else if (Value <= 1.0f && Value >= 0.0f) {
                    _value = 1.0d;
                } else if (Value < 0.0f && Value >= -1.0f) {
                    _value = -1.0d;
                }
                this.mPaint.setShader(new LinearGradient(this.xStart + ((this.xLong / 17.0f) * ((float) Ch)), this.yStart, this.xStart + ((this.xLong / 17.0f) * ((float) Ch)), this.yEnd, this._color3, this._color4, TileMode.MIRROR));
                canvas.drawLine(((this.xLong / 17.0f) * ((float) Ch)) + this.xStart, (this.yLong / 2.0f) + this.yStart, ((this.xLong / 17.0f) * ((float) Ch)) + this.xStart, ((float) ((((double) this.yLong) * _value) / ((double) (this.yMax - this.yMin)))) + this.yStart + (this.yLong / 2.0f), this.mPaint);
            }
        }
        int Ch2 = 0;
        int length = Values.length;
        int i = 0;
        while (i < length) {
            float Value2 = Values[i];
            Ch2++;
            if (Ch2 < 17) {
                this.mfont = new Paint();
                this.mfont.setColor(this._color5);
                this.mfont.setTextSize((float) getDPFromPixels(13));
                this.mfont.setTextAlign(Align.CENTER);
                this.mfont.setFakeBoldText(true);
                this.mfont.setAntiAlias(true);
                if (Ch2 == 1 || Ch2 == 3 || Ch2 == 5 || Ch2 == 7 || Ch2 == 9 || Ch2 == 11 || Ch2 == 13 || Ch2 == 15) {
                    canvas.drawText(String.valueOf(-Value2), this.xStart + ((this.xLong / 17.0f) * ((float) Ch2)), (this.yStart + (this.yLong / 2.0f)) - 15.0f, this.mfont);
                } else {
                    canvas.drawText(String.valueOf(-Value2), this.xStart + ((this.xLong / 17.0f) * ((float) Ch2)), this.yStart + (this.yLong / 2.0f) + 20.0f, this.mfont);
                }
                i++;
            } else {
                return;
            }
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
        return DataTypes.Servo;
    }

    public void setData(byte[] rawData) {
    }

    public SensorTypes getSensorType() {
        return null;
    }

    public void setSensorType(SensorTypes sensorType) {
    }

    public String getAttributes() {
        return null;
    }

    public void setAttributes(String attributes) {
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
        return -1;
    }

    public int getSlotCount() {
        return -1;
    }

    public void setSensorValue(List<Object> sensorValue) {
        try {
            if (sensorValue.size() != 0) {
                float[] fArr = new float[18];
                setChValues((float[]) sensorValue.get(0));
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "VoltageView setSensorValue Error:" + e.getMessage());
        }
    }
}
