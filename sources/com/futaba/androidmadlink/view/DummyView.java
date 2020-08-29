package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.config.Parameter;
import java.util.List;

public class DummyView extends View implements ISBusView {
    private int _col = -1;
    int _color1 = -12895429;
    int _color2 = -1;
    private int _page = -1;
    private int _row = -1;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    public DummyView(Context context) {
        super(context);
        init();
    }

    public DummyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DataTypes getDataType() {
        return null;
    }

    public void setSensorTitle(String title) {
    }

    public String getSensorTitle() {
        return null;
    }

    public SensorTypes getSensorType() {
        return null;
    }

    public void setSensorType(SensorTypes sensorType) {
    }

    public void setData(byte[] rawData) {
    }

    public String getAttributes() {
        return null;
    }

    public void setAttributes(String attributes) {
    }

    public void reset() {
    }

    private void init() {
        switch (Parameter.getScreenMode()) {
            case 1:
                this._color1 = -1;
                this._color2 = -12895429;
                return;
            default:
                this._color1 = -12895429;
                this._color2 = -1;
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float value = (float) this.mWidth;
        if (this.mHeight < this.mWidth) {
            value = (float) this.mHeight;
        }
        canvas.drawColor(this._color2);
        this.mPaint = new Paint();
        this.mPaint.setColor(this._color1);
        this.mPaint.setAntiAlias(true);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(5.0f);
        this.mPaint.setColor(this._color2);
        canvas.drawCircle((float) (this.mWidth / 2), (float) (this.mHeight / 2), value / 6.0f, this.mPaint);
        this.mPaint.setColor(this._color1);
        canvas.drawCircle((float) (this.mWidth / 2), (float) (this.mHeight / 2), (value / 6.0f) - 4.0f, this.mPaint);
        this.mPaint.setColor(this._color2);
        Canvas canvas2 = canvas;
        canvas2.drawLine((float) (this.mWidth / 2), (value / 12.0f) + ((float) (this.mHeight / 2)), (float) (this.mWidth / 2), ((float) (this.mHeight / 2)) - (value / 12.0f), this.mPaint);
        Canvas canvas3 = canvas;
        canvas3.drawLine((value / 12.0f) + ((float) (this.mWidth / 2)), (float) (this.mHeight / 2), ((float) (this.mWidth / 2)) - (value / 12.0f), (float) (this.mHeight / 2), this.mPaint);
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

    public void setSensorValue(List<Object> list) {
    }
}
