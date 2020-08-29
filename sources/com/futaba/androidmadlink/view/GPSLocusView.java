package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import com.google.android.gms.maps.model.LatLng;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GPSLocusView extends View implements ISBusView {
    private int _altitudeTemp;
    private double _altitudeValue = 0.0d;
    protected String _attributes = "{'Slot':'8'}";
    private int _col = -1;
    private float _distanceValue = 0.0f;
    private boolean _isWriteLog;
    private String _logFileName;
    private int _page = -1;
    private float _pressureValue = 0.0f;
    private GPSLocusProperty _property = new GPSLocusProperty();
    private byte[] _rawData;
    private float _regulateValue = 1.0f;
    private int _row = -1;
    private SensorTypes _sensorType;
    private boolean _showValue = false;
    private float _speedValue = 0.0f;
    private String _title = ((String) getResources().getText(C0112R.string.labGPSLocusTile));
    private double _variometerValue = 0.0d;
    double _xScale = 0.0d;
    Object[] data2Value = new Object[32];
    int flag = 0;
    private int mHeight;
    String mLastMap = "N 0° 00.0000,E 0° 00.0000";
    LatLng mOrigin;
    private Paint mPaint;
    private Paint mPaint2;
    private Paint mPaint3;
    private Paint mPaint4;
    private Paint mPaint5;
    LatLng mStart;
    private int mWidth;
    float mapA_X = 0.0f;
    float mapA_Y = 0.0f;
    float mapB_X = 0.0f;
    float mapB_Y = 0.0f;
    List<LatLng> mapLists = new ArrayList();
    private Paint mfont;
    private Paint mfont2;
    private Paint mfont3;

    public GPSLocusView(Context context) {
        super(context);
        setDrawTools();
    }

    public GPSLocusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setDrawTools();
    }

    public float getTotalDistance() {
        return this._distanceValue;
    }

    private void setTotalDistance(float vlaue) {
        this._distanceValue = vlaue;
    }

    public void setShowValue(boolean showValue) {
        this._showValue = showValue;
    }

    public boolean getShowValue() {
        return this._showValue;
    }

    private void setDrawTools() {
        this.mPaint = new Paint();
        this.mPaint.setColor(-2302756);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setAntiAlias(true);
        this.mPaint2 = new Paint();
        this.mPaint2.setColor(SupportMenu.CATEGORY_MASK);
        this.mPaint2.setStrokeWidth(3.0f);
        this.mPaint2.setAntiAlias(true);
        this.mPaint3 = new Paint();
        this.mPaint3.setColor(-16711936);
        this.mPaint3.setStrokeWidth(3.0f);
        this.mPaint3.setAntiAlias(true);
        this.mPaint4 = new Paint();
        this.mPaint4.setColor(-16777216);
        this.mPaint4.setStrokeWidth(2.0f);
        this.mPaint4.setAntiAlias(true);
        this.mPaint5 = new Paint();
        this.mPaint5.setColor(-16777216);
        this.mPaint5.setStrokeWidth(1.0f);
        this.mPaint5.setAntiAlias(true);
        this.mfont = new Paint();
        this.mfont.setColor(-16776961);
        this.mfont.setAntiAlias(true);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setTextAlign(Align.CENTER);
        this.mfont2 = new Paint();
        this.mfont2.setColor(-16777216);
        this.mfont2.setAntiAlias(true);
        this.mfont2.setTextSize(10.0f);
        this.mfont2.setTextAlign(Align.CENTER);
        this.mfont3 = new Paint();
        this.mfont3.setColor(SupportMenu.CATEGORY_MASK);
        this.mfont3.setTextSize(20.0f);
        this.mfont3.setAntiAlias(true);
        this.mfont3.setTextAlign(Align.CENTER);
    }

    /* access modifiers changed from: 0000 */
    public int getDPFromPixels(int pixels) {
        return pixels * (this.mWidth / 320);
    }

    public List<LatLng> getMapLists() {
        return this.mapLists;
    }

    public void setMapLists(List<LatLng> lists) {
        this.mapLists = lists;
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

    public void setSensorTitle(String title) {
        this._title = title;
    }

    public String getSensorTitle() {
        return this._title;
    }

    public double getAltitudeValue() {
        return this._altitudeValue;
    }

    public void setAltitudeValue(double value) {
        this._altitudeTemp = (int) value;
        this._altitudeValue = Double.valueOf(new BigDecimal((value - ((double) this._regulateValue)) * 1.0d).setScale(1, 4).toString()).doubleValue();
    }

    public double getVariometerValue() {
        return this._variometerValue;
    }

    public void setVariometerValue(double value) {
        this._variometerValue = Double.valueOf(new BigDecimal(value * 1.0d).setScale(1, 4).toString()).doubleValue();
    }

    public float getSpeedValue() {
        return this._speedValue;
    }

    public void setSpeedValue(int value) {
        this._speedValue = Float.valueOf(new BigDecimal((double) (((float) value) * 1.0f)).setScale(1, 4).toString()).floatValue();
    }

    public float getPressureValue() {
        return this._pressureValue;
    }

    public void setPressureValue(float value) {
        this._pressureValue = value;
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

    public void reset() {
        this.mStart = null;
        this.mOrigin = null;
        this.mapA_X = 0.0f;
        this.mapA_Y = 0.0f;
        this.mapB_X = 0.0f;
        this.mapB_Y = 0.0f;
        this.flag = 0;
        this._xScale = 0.0d;
        setVariometerValue(0.0d);
        setAltitudeValue(0.0d);
        setPressureValue(0.0f);
        this.mLastMap = "N 0° 00.0000　,E 0° 00.0000";
        this._distanceValue = 0.0f;
        this.mapLists.clear();
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

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(-1);
        this.flag = 0;
        for (LatLng mapList : this.mapLists) {
            if (this.flag == 0) {
                init(mapList);
            }
            drawMap(mapList, canvas);
        }
        setScale(canvas);
        canvas.drawCircle(this.mapA_X, this.mapA_Y, 5.0f, this.mPaint3);
        this.mfont.setColor(-16776961);
        this.mfont.setAntiAlias(true);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setTextAlign(Align.CENTER);
        canvas.drawText(getSensorTitle(), (float) (this.mWidth / 2), ((float) this.mHeight) * 0.1f, this.mfont);
        if (getShowValue()) {
            drawValue(canvas);
            setCompass(canvas, 20.0f);
            return;
        }
        setCompass(canvas, 0.0f);
    }

    private void drawValue(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) this.mWidth, ((float) this.mHeight) * 0.15f, this.mPaint);
        this.mfont.setTextSize((((float) this.mHeight) * 0.13f) / 4.0f);
        this.mfont.setTextAlign(Align.LEFT);
        this.mfont.setAntiAlias(true);
        this.mfont.setColor(-16776961);
        canvas.drawText(getSensorTitle(), 0.0f, ((((float) this.mHeight) * 0.13f) * 1.0f) / 4.0f, this.mfont);
        this.mfont = new Paint();
        this.mfont.setColor(-16777216);
        this.mfont.setTextAlign(Align.LEFT);
        this.mfont.setAntiAlias(true);
        this.mfont.setTextSize((((float) this.mHeight) * 0.13f) / 6.0f);
        canvas.drawText(this.mLastMap, 0.0f, ((((float) this.mHeight) * 0.13f) * 2.0f) / 4.0f, this.mfont);
        canvas.drawText(new StringBuilder(String.valueOf((String) getResources().getText(C0112R.string.labDistanceTile))).append(getTotalDistance()).append("m          ").append((String) getResources().getText(C0112R.string.labSpeedTile)).append(getSpeedValue()).append("km/h").toString(), 0.0f, ((((float) this.mHeight) * 0.13f) * 3.0f) / 4.0f, this.mfont);
        canvas.drawText(new StringBuilder(String.valueOf((String) getResources().getText(C0112R.string.labVariometerTile))).append(getVariometerValue()).append("m/s          ").append((String) getResources().getText(C0112R.string.labAltitudeTile2)).append(getAltitudeValue()).append("  m").toString(), 0.0f, ((float) this.mHeight) * 0.13f, this.mfont);
    }

    private void init(LatLng map) {
        this.mStart = map;
        this.mOrigin = new LatLng(this.mStart.latitude - ((((double) this.mHeight) * 0.005405405406d) / ((double) this.mWidth)), this.mStart.longitude - 0.005405405406d);
        this._xScale = ((double) (this.mWidth / 2)) / 0.005405405406d;
    }

    private void drawMap(LatLng map, Canvas canvas) {
        float mXmap = (float) ((map.longitude - this.mOrigin.longitude) * this._xScale);
        float mYmap = (float) (((double) this.mHeight) - ((map.latitude - this.mOrigin.latitude) * this._xScale));
        if (this.flag == 0) {
            this.mapA_X = mXmap;
            this.mapA_Y = mYmap;
            this.flag = 1;
            return;
        }
        this.mapB_X = mXmap;
        this.mapB_Y = mYmap;
        canvas.drawLine(this.mapA_X, this.mapA_Y, this.mapB_X, this.mapB_Y, this.mPaint2);
        this.mapA_X = this.mapB_X;
        this.mapA_Y = this.mapB_Y;
        this.mapB_X = 0.0f;
        this.mapB_Y = 0.0f;
    }

    private void setScale(Canvas canvas) {
        canvas.drawLine(20.0f, 10.0f, 20.0f, (float) (this.mHeight - 15), this.mPaint4);
        int intFontY = ((this.mHeight * 500) / this.mWidth) / 50;
        float valueY = Float.valueOf(new BigDecimal(((double) ((this.mHeight - 25) - 15)) / (((double) intFontY) * 2.0d)).setScale(1, 4).toString()).floatValue();
        for (int i = 0; i < (intFontY * 2) + 1; i++) {
            if (((intFontY * 50) - (i * 50)) % 100 == 0) {
                canvas.drawLine(15.0f, (((float) i) * valueY) + 15.0f, 25.0f, (((float) i) * valueY) + 15.0f, this.mPaint4);
                canvas.drawText(String.valueOf(Math.abs((intFontY * 50) - (i * 50))), 10.0f, 25.0f + (((float) i) * valueY), this.mfont2);
            } else {
                canvas.drawLine(17.0f, (((float) i) * valueY) + 15.0f, 23.0f, (((float) i) * valueY) + 15.0f, this.mPaint4);
            }
        }
        canvas.drawLine(20.0f, (float) (this.mHeight - 20), (float) (this.mWidth - 5), (float) (this.mHeight - 20), this.mPaint4);
        float valueX = Float.valueOf(new BigDecimal(((double) ((this.mHeight - 25) - 20)) / (((double) intFontY) * 2.0d)).setScale(1, 4).toString()).floatValue();
        for (int i2 = 0; i2 < 21; i2++) {
            if ((500 - (i2 * 50)) % 100 == 0) {
                canvas.drawLine((((float) i2) * valueX) + 20.0f, (float) (this.mHeight - 15), (((float) i2) * valueX) + 20.0f, (float) (this.mHeight - 25), this.mPaint4);
                canvas.drawText(String.valueOf(Math.abs(500 - (i2 * 50))), 20.0f + (((float) i2) * valueX), (float) (this.mHeight - 5), this.mfont2);
            } else {
                canvas.drawLine((((float) i2) * valueX) + 20.0f, (float) (this.mHeight - 17), (((float) i2) * valueX) + 20.0f, (float) (this.mHeight - 23), this.mPaint4);
            }
        }
    }

    private void setCompass(Canvas canvas, float value) {
        canvas.drawLine((((float) this.mWidth) - 30.0f) - (2.0f * value), 30.0f + value, (float) (this.mWidth - 10), 30.0f + value, this.mPaint5);
        canvas.drawLine((((float) this.mWidth) - 20.0f) - value, 20.0f + (value / 2.0f), ((float) (this.mWidth - 20)) - value, (2.0f * value) + 50.0f, this.mPaint5);
        this.mfont3.setTextSize((value / 2.0f) + 20.0f);
        canvas.drawText("N", ((float) (this.mWidth - 20)) - value, (value / 2.0f) + 20.0f, this.mfont3);
    }

    public double GetDistance(double Lat1, double Long1, double Lat2, double Long2) {
        double Lat1r = ConvertDegreeToRadians(Lat1);
        double Lat2r = ConvertDegreeToRadians(Lat2);
        double Long1r = ConvertDegreeToRadians(Long1);
        return (double) Float.valueOf(new BigDecimal(Math.acos((Math.sin(Lat1r) * Math.sin(Lat2r)) + (Math.cos(Lat1r) * Math.cos(Lat2r) * Math.cos(ConvertDegreeToRadians(Long2) - Long1r))) * 6371.0d * 1000.0d).setScale(1, 4).toString()).floatValue();
    }

    private double ConvertDegreeToRadians(double degrees) {
        return 0.017453292519943295d * degrees;
    }

    public void setISWriteLog(boolean isWriteLog) {
        this._isWriteLog = isWriteLog;
    }

    public boolean getISWriteLog() {
        return this._isWriteLog;
    }

    public void setLogFileName(String logFileName) {
        this._logFileName = new StringBuilder(String.valueOf(logFileName)).append("-GPS").append(getId()).append("-Slot").append(this._property.getSlot()).toString();
    }

    public void setLogFileName2(String logFileName) {
        this._logFileName = logFileName;
    }

    public String getLogFileName() {
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
        try {
            if (sensorValue.size() != 0 && ((Integer) sensorValue.get(0)).intValue() != 0) {
                String[] longString = (String[]) sensorValue.get(4);
                String lonStr = longString[0];
                int lonValue = Integer.valueOf(longString[1]).intValue();
                double lonValue1 = (((double) lonValue) / 60.0d) / 10000.0d;
                String[] latString = (String[]) sensorValue.get(5);
                String latStr = latString[0];
                int latValue = Integer.valueOf(latString[1]).intValue();
                double latValue1 = (((double) latValue) / 60.0d) / 10000.0d;
                LatLng latLng = new LatLng(latValue1, lonValue1);
                if (getShowValue()) {
                    setVariometerValue(((Double) sensorValue.get(1)).doubleValue());
                    setSpeedValue(((Integer) sensorValue.get(2)).intValue());
                    setAltitudeValue(((Double) sensorValue.get(3)).doubleValue());
                    this.mLastMap = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(latStr)).append(" ").append((int) latValue1).append("° ").append(new BigDecimal((((double) latValue) / 10000.0d) % 60.0d).setScale(4, 4).toString()).toString())).append("　,").append(new StringBuilder(String.valueOf(lonStr)).append(" ").append((int) lonValue1).append("° ").append(new BigDecimal((((double) lonValue) / 10000.0d) % 60.0d).setScale(4, 4).toString()).toString()).toString();
                }
                if (this.mapLists.size() != 0) {
                    LatLng mapList = (LatLng) this.mapLists.get(this.mapLists.size() - 1);
                    if (mapList.latitude == latLng.latitude && mapList.longitude == latLng.longitude) {
                        return;
                    }
                }
                if (this.mStart != null) {
                    this._distanceValue = (float) GetDistance(this.mStart.latitude, this.mStart.longitude, latLng.latitude, latLng.longitude);
                }
                this.mapLists.add(latLng);
                invalidate();
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "GPSLocusView setSensorValue Error:" + e.getMessage());
        }
    }
}
