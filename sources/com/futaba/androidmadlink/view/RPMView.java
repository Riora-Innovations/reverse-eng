package com.futaba.androidmadlink.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;
import com.futaba.androidmadlink.config.Parameter;
import java.util.ArrayList;
import java.util.List;

public class RPMView extends View implements ISBusView {
    public static final double DEFAULT_MAJOR_TICK_STEP = 1.0d;
    public static final double DEFAULT_MAX_RPM = 10.0d;
    public static final int DEFAULT_MINOR_TICKS = 4;
    /* access modifiers changed from: private */
    public static final String TAG = RPMView.class.getSimpleName();
    protected String _attributes = "{'Slot':'1','Type':'Optics','Range':'2'}";
    private int _col = -1;
    int _color1 = -16777216;
    int _color10 = -8421505;
    int _color2 = -1;
    int _color3 = -16713491;
    int _color4 = -1331;
    int _color5 = -8421505;
    int _color6 = -1;
    int _color7 = -8421505;
    int _color8 = -6908266;
    int _color9 = -4934476;
    int _ice1 = C0112R.C0113drawable.spot_mask;
    private double _maxRpm = 10.0d;
    private int _page = -1;
    private RPMProperty _property = new RPMProperty();
    private byte[] _rawData;
    private int _row = -1;
    private double _rpm = 0.0d;
    private SensorTypes _sensorType;
    private int _solCount = 1;
    private String _title = ((String) getResources().getText(C0112R.string.labRPMTile));
    private Paint backgroundInnerPaint;
    private Paint backgroundPaint;
    private Paint backgroundPaint2;
    private Paint colorLinePaint;
    Object[] data2Value = new Object[32];
    private int defaultColor = Color.rgb(180, 180, 180);
    private LabelConverter labelConverter;
    private int mHeight;
    private Bitmap mMask;
    private Paint mPaint;
    private int mWidth;
    private double majorTickStep = 1.0d;
    private Paint maskPaint;
    private Paint mfont;
    private int minorTicks = 4;
    private Paint needlePaint;
    private List<ColoredRange> ranges = new ArrayList();
    private Paint ticksPaint;
    private Paint txtPaint;
    private Paint txtPaint2;

    public static class ColoredRange {
        private double begin;
        private int color;
        private double end;

        public ColoredRange(int color2, double begin2, double end2) {
            this.color = color2;
            this.begin = begin2;
            this.end = end2;
        }

        public int getColor() {
            return this.color;
        }

        public void setColor(int color2) {
            this.color = color2;
        }

        public double getBegin() {
            return this.begin;
        }

        public void setBegin(double begin2) {
            this.begin = begin2;
        }

        public double getEnd() {
            return this.end;
        }

        public void setEnd(double end2) {
            this.end = end2;
        }
    }

    public interface LabelConverter {
        String getLabelFor(double d, double d2);
    }

    public RPMView(Context context) {
        super(context);
        init();
    }

    /* JADX INFO: finally extract failed */
    public RPMView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attributes = context.getTheme().obtainStyledAttributes(attrs, C0112R.styleable.RPMView, 0, 0);
        try {
            setMaxRpm((double) attributes.getFloat(0, 10.0f));
            setRpm((double) attributes.getFloat(1, 0.0f));
            attributes.recycle();
            init();
        } catch (Throwable th) {
            attributes.recycle();
            throw th;
        }
    }

    public double getMaxRpm() {
        return this._maxRpm;
    }

    public void setMaxRpm(double maxRpm) {
        if (maxRpm > 0.0d) {
            this._maxRpm = maxRpm;
        }
    }

    public double getRpm() {
        return this._rpm;
    }

    public void setRpm(double rpm) {
        this._rpm = rpm;
    }

    @TargetApi(11)
    public ValueAnimator setRpm(double progress, long duration, long startDelay) {
        if (progress <= 0.0d) {
            progress = 0.0d;
        }
        if (progress > this._maxRpm) {
            progress = this._maxRpm;
        }
        ValueAnimator va = ValueAnimator.ofObject(new TypeEvaluator<Double>() {
            public Double evaluate(float fraction, Double startValue, Double endValue) {
                return Double.valueOf(startValue.doubleValue() + (((double) fraction) * (endValue.doubleValue() - startValue.doubleValue())));
            }
        }, new Object[]{Double.valueOf(getRpm()), Double.valueOf(progress)});
        va.setDuration(duration);
        va.setStartDelay(startDelay);
        va.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                Double value = (Double) animation.getAnimatedValue();
                if (value != null) {
                    RPMView.this.setRpm(value.doubleValue());
                }
                Log.d(RPMView.TAG, "setRpm(): onAnumationUpdate() -> value = " + value);
            }
        });
        va.start();
        return va;
    }

    @TargetApi(11)
    public ValueAnimator setRpm(double progress, boolean animate) {
        return setRpm(progress, 1500, 10);
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }

    public void setDefaultColor(int defaultColor2) {
        this.defaultColor = defaultColor2;
    }

    public double getMajorTickStep() {
        return this.majorTickStep;
    }

    public void setMajorTickStep(double majorTickStep2) {
        if (majorTickStep2 <= 0.0d) {
            throw new IllegalArgumentException("Non-positive value specified as a major tick step.");
        }
        this.majorTickStep = majorTickStep2;
    }

    public int getMinorTicks() {
        return this.minorTicks;
    }

    public void setMinorTicks(int minorTicks2) {
        this.minorTicks = minorTicks2;
    }

    public LabelConverter getLabelConverter() {
        return this.labelConverter;
    }

    public void setLabelConverter(LabelConverter labelConverter2) {
        this.labelConverter = labelConverter2;
    }

    public void clearColoredRanges() {
        this.ranges.clear();
    }

    public void addColoredRange(double begin, double end, int color) {
        if (begin > end) {
            throw new IllegalArgumentException("Incorrect number range specified!");
        }
        double beginValue = 0.03125d * this._maxRpm;
        double endValue = this._maxRpm * 1.03125d;
        if (begin < (-beginValue)) {
            begin = -beginValue;
        }
        if (end > endValue) {
            end = endValue;
        }
        this.ranges.add(new ColoredRange(color, begin, end));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this._color2);
        this.mPaint.setColor(this._color1);
        canvas.drawRect(1.0f, 1.0f, (float) (this.mWidth - 1), (float) (this.mHeight - 1), this.mPaint);
        drawBackground(canvas);
        drawTicks(canvas);
        drawNeedle(canvas);
    }

    private void drawNeedle(Canvas canvas) {
        RectF oval = getOval(canvas, 1.0f, 0.0f, 0.0f);
        float radius = oval.width() * 0.35f;
        double rpmValue = getRpm();
        if (rpmValue > getMaxRpm() * 1000.0d) {
            rpmValue = getMaxRpm() * 1000.0d;
        } else if (rpmValue < 0.0d) {
            rpmValue = 0.0d;
        }
        float angle = 10.0f + ((float) (((rpmValue / 1000.0d) / getMaxRpm()) * 160.0d));
        canvas.drawLine(oval.centerX() + 0.0f, oval.centerY() - 0.0f, (float) (((double) oval.centerX()) + (Math.cos(((double) ((180.0f - angle) / 180.0f)) * 3.141592653589793d) * ((double) radius))), (float) (((double) oval.centerY()) - (Math.sin(((double) (angle / 180.0f)) * 3.141592653589793d) * ((double) radius))), this.needlePaint);
        canvas.drawArc(getOval(canvas, 0.2f, 0.0f, 2.5f), 180.0f, 180.0f, true, this.backgroundPaint2);
        float radius2 = oval.height() * 0.5f;
        if (!this._property.getAlertEnable() || ((this._property.getAlertMax() <= 0.0d || getRpm() <= this._property.getAlertMax()) && (this._property.getAlertMin() <= 0.0d || getRpm() >= this._property.getAlertMin()))) {
            this.txtPaint2.setColor(this._color1);
        } else {
            this.txtPaint2.setColor(SupportMenu.CATEGORY_MASK);
        }
        float value2 = (0.45f * radius) - 7.0f;
        this.txtPaint2.setTextSize(value2);
        canvas.drawText(String.valueOf((int) getRpm()), (oval.centerX() + (0.6f * radius2)) - 3.0f, oval.centerY() + (0.3f * radius2) + (0.3f * value2), this.txtPaint2);
    }

    private void drawTicks(Canvas canvas) {
        this.majorTickStep = this._maxRpm * 0.1d;
        float majorStep = (float) ((this.majorTickStep / this._maxRpm) * ((double) 160.0f));
        float minorStep = majorStep / ((float) (this.minorTicks + 1));
        float minorTicksLength = 30.0f * 0.5f;
        RectF oval = getOval(canvas, 1.0f, 0.0f, 0.0f);
        float radius = oval.width() * 0.315f;
        float currentAngle = 10.0f;
        double curProgress = 0.0d;
        if (this._maxRpm > 100.0d) {
            this.txtPaint.setTextSize((float) getDPFromPixels(14));
        } else {
            this.txtPaint.setTextSize((float) getDPFromPixels(18));
        }
        while (currentAngle <= 170.0f) {
            canvas.drawLine((float) (((double) oval.centerX()) + (Math.cos(((double) ((180.0f - currentAngle) / 180.0f)) * 3.141592653589793d) * ((double) (radius - (30.0f / 2.0f))))), (float) (((double) oval.centerY()) - (Math.sin(((double) (currentAngle / 180.0f)) * 3.141592653589793d) * ((double) (radius - (30.0f / 2.0f))))), (float) (((double) oval.centerX()) + (Math.cos(((double) ((180.0f - currentAngle) / 180.0f)) * 3.141592653589793d) * ((double) ((30.0f / 2.0f) + radius)))), (float) (((double) oval.centerY()) - (Math.sin(((double) (currentAngle / 180.0f)) * 3.141592653589793d) * ((double) ((30.0f / 2.0f) + radius)))), this.ticksPaint);
            for (int i = 1; i <= this.minorTicks; i++) {
                float angle = currentAngle + (((float) i) * minorStep);
                if (angle >= 170.0f + (minorStep / 2.0f)) {
                    break;
                }
                canvas.drawLine((float) (((double) oval.centerX()) + (Math.cos(((double) ((180.0f - angle) / 180.0f)) * 3.141592653589793d) * ((double) radius))), (float) (((double) oval.centerY()) - (Math.sin(((double) (angle / 180.0f)) * 3.141592653589793d) * ((double) radius))), (float) (((double) oval.centerX()) + (Math.cos(((double) ((180.0f - angle) / 180.0f)) * 3.141592653589793d) * ((double) (radius + minorTicksLength)))), (float) (((double) oval.centerY()) - (Math.sin(((double) (angle / 180.0f)) * 3.141592653589793d) * ((double) (radius + minorTicksLength)))), this.ticksPaint);
            }
            if (this.labelConverter != null) {
                canvas.save();
                canvas.rotate(180.0f + currentAngle, oval.centerX(), oval.centerY());
                float txtX = oval.centerX() + radius + (30.0f / 2.0f) + 8.0f;
                float txtY = oval.centerY();
                canvas.rotate(90.0f, txtX, txtY);
                canvas.drawText(this.labelConverter.getLabelFor(curProgress, this._maxRpm), txtX, txtY, this.txtPaint);
                canvas.restore();
            }
            currentAngle += majorStep;
            curProgress += this.majorTickStep;
        }
        RectF smallOval = getOval(canvas, 0.7f, 0.0f, 0.0f);
        this.colorLinePaint.setColor(this._color9);
        canvas.drawArc(smallOval, 185.0f, 170.0f, false, this.colorLinePaint);
        for (ColoredRange range : this.ranges) {
            this.colorLinePaint.setColor(range.getColor());
            canvas.drawArc(smallOval, (float) (190.0d + ((range.getBegin() / this._maxRpm) * 160.0d)), (float) (((range.getEnd() - range.getBegin()) / this._maxRpm) * 160.0d), false, this.colorLinePaint);
        }
    }

    private RectF getOval(Canvas canvas, float factor, float oval_X, float oval_Y) {
        RectF oval;
        int canvasWidth = (canvas.getWidth() - getPaddingLeft()) - getPaddingRight();
        int canvasHeight = (canvas.getHeight() - getPaddingTop()) - getPaddingBottom();
        if (canvasHeight >= canvasWidth) {
            oval = new RectF(0.0f, 0.0f, ((float) canvasWidth) * factor, ((float) canvasWidth) * factor);
        } else {
            oval = new RectF(0.0f, 0.0f, ((float) canvasHeight) * factor, ((float) canvasHeight) * factor);
        }
        oval.offset(((((float) canvasWidth) - oval.width()) / 2.0f) + ((float) getPaddingLeft()) + oval_X, ((((float) canvasHeight) - oval.height()) / 2.0f) + ((float) getPaddingTop()) + oval_Y);
        return oval;
    }

    private void drawBackground(Canvas canvas) {
        RectF oval = getOval(canvas, 0.9f, 0.0f, 0.0f);
        canvas.drawCircle((float) (this.mWidth / 2), ((float) (this.mHeight / 2)) + (((float) this.mHeight) * 0.01f), oval.height() / 2.0f, this.backgroundPaint);
        float radius = getOval(canvas, 0.85f, 0.0f, 0.0f).height() / 2.0f;
        canvas.drawCircle((float) (this.mWidth / 2), ((float) (this.mHeight / 2)) + (((float) this.mHeight) * 0.01f), radius, this.backgroundInnerPaint);
        canvas.drawBitmap(Bitmap.createScaledBitmap(this.mMask, (int) (oval.width() * 1.17f), (int) (oval.height() * 1.17f), true), (((float) this.mWidth) - (oval.width() * 1.17f)) / 2.0f, (((float) this.mHeight) - (oval.height() * 1.17f)) / 2.0f, this.maskPaint);
        this.txtPaint.setTextSize(18.0f);
        canvas.drawText("RPM  x1000", oval.centerX() + 0.0f, oval.centerY() - ((oval.height() * 0.9f) / 8.0f), this.txtPaint);
        this.mPaint.setColor(this._color5);
        this.mPaint.setStrokeWidth(0.45f * radius);
        Canvas canvas2 = canvas;
        canvas2.drawLine(oval.centerX() - (radius * 0.7f), (radius * 0.3f) + oval.centerY(), (radius * 0.7f) + oval.centerX(), (radius * 0.3f) + oval.centerY(), this.mPaint);
        this.mPaint.setColor(this._color6);
        this.mPaint.setStrokeWidth((0.45f * radius) - 6.0f);
        Canvas canvas3 = canvas;
        canvas3.drawLine(3.0f + (oval.centerX() - (radius * 0.7f)), (radius * 0.3f) + oval.centerY(), (oval.centerX() + (radius * 0.7f)) - 3.0f, (radius * 0.3f) + oval.centerY(), this.mPaint);
        this.mfont.setTextSize((float) getDPFromPixels(26));
        canvas.drawText(getSensorTitle(), 4.0f, ((float) this.mHeight) * 0.11f, this.mfont);
    }

    private void init() {
        switch (Parameter.getScreenMode()) {
            case 1:
                this._ice1 = C0112R.C0113drawable.spot_mask_2;
                this._color1 = -1;
                this._color2 = -16777216;
                this._color3 = -16776961;
                this._color4 = -2894893;
                this._color5 = -13369345;
                this._color6 = -16776961;
                this._color7 = -29696;
                this._color8 = -331546;
                this._color9 = -8355712;
                this._color10 = -4144960;
                break;
            default:
                this._ice1 = C0112R.C0113drawable.spot_mask;
                this._color1 = -16777216;
                this._color2 = -1;
                this._color3 = -16713491;
                this._color4 = -1331;
                this._color5 = -8421505;
                this._color6 = -1;
                this._color7 = -8421505;
                this._color8 = -6908266;
                this._color9 = -4934476;
                this._color10 = -8421505;
                break;
        }
        if (VERSION.SDK_INT >= 11 && !isInEditMode()) {
            setLayerType(2, null);
        }
        this.mPaint = new Paint();
        this.backgroundPaint = new Paint(1);
        this.backgroundPaint.setStyle(Style.FILL);
        this.backgroundPaint.setColor(this._color7);
        this.backgroundPaint2 = new Paint(1);
        this.backgroundPaint2.setStyle(Style.FILL);
        this.backgroundPaint2.setColor(this._color10);
        this.backgroundInnerPaint = new Paint(1);
        this.backgroundInnerPaint.setStyle(Style.FILL);
        this.backgroundInnerPaint.setColor(this._color8);
        this.txtPaint = new Paint(1);
        this.txtPaint.setColor(this._color2);
        this.txtPaint.setTextSize(18.0f);
        this.txtPaint.setTextAlign(Align.CENTER);
        this.txtPaint2 = new Paint(1);
        this.txtPaint2.setColor(-16711936);
        this.txtPaint2.setTextAlign(Align.RIGHT);
        this.mMask = BitmapFactory.decodeResource(getResources(), this._ice1);
        this.mMask = Bitmap.createBitmap(this.mMask, 0, 0, this.mMask.getWidth(), this.mMask.getHeight());
        this.maskPaint = new Paint(1);
        this.maskPaint.setDither(true);
        this.ticksPaint = new Paint(1);
        this.ticksPaint.setStrokeWidth(3.0f);
        this.ticksPaint.setStyle(Style.STROKE);
        this.ticksPaint.setColor(this._color9);
        this.colorLinePaint = new Paint(1);
        this.colorLinePaint.setStyle(Style.STROKE);
        this.colorLinePaint.setStrokeWidth(5.0f);
        this.colorLinePaint.setColor(this._color9);
        this.needlePaint = new Paint(1);
        this.needlePaint.setStrokeWidth(5.0f);
        this.needlePaint.setStyle(Style.STROKE);
        this.needlePaint.setColor(Color.argb(200, MotionEventCompat.ACTION_MASK, 0, 0));
        this.mfont = new Paint();
        this.mfont.setColor(this._color3);
        this.mfont.setAntiAlias(true);
        this.mfont.setTextAlign(Align.LEFT);
    }

    private void setRangeColor() {
        double d;
        int alertMaxValue = (int) (this._property.getAlertMax() / 1000.0d);
        int alertMinValue = (int) (this._property.getAlertMin() / 1000.0d);
        if (alertMaxValue > 0 || alertMinValue > 0) {
            addColoredRange(0.0d, this._maxRpm, -16711936);
            if (this._property.getAlertMax() > 0.0d) {
                addColoredRange(((double) alertMaxValue) > this._maxRpm ? this._maxRpm : (double) alertMaxValue, this._maxRpm, SupportMenu.CATEGORY_MASK);
            }
            if (this._property.getAlertMin() > 0.0d) {
                if (((double) alertMinValue) > this._maxRpm) {
                    d = this._maxRpm;
                } else {
                    d = (double) alertMinValue;
                }
                addColoredRange(0.0d, d, SupportMenu.CATEGORY_MASK);
                return;
            }
            return;
        }
        addColoredRange(0.0d, this._maxRpm, -1);
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
        setMaxRpm((double) this._property.getMaxRPM());
        if (this._property.getAlertEnable()) {
            setRangeColor();
        }
    }

    /* access modifiers changed from: 0000 */
    public int getDPFromPixels(int pixels) {
        return pixels * ((int) (((double) this.mWidth) * 0.003125d));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (widthMode == 1073741824 || widthMode == Integer.MIN_VALUE) {
            this.mWidth = widthSize;
        } else {
            this.mWidth = -1;
        }
        if (heightMode == 1073741824 || heightMode == Integer.MIN_VALUE) {
            this.mHeight = heightSize;
        } else {
            this.mHeight = -1;
        }
        setMeasuredDimension(this.mWidth, this.mHeight);
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
            if (sensorValue.size() != 0) {
                setRpm(((Double) sensorValue.get(0)).doubleValue());
                invalidate();
            }
        } catch (Exception e) {
            Log.e(Parameter.TAG, "VoltageView setSensorValue Error:" + e.getMessage());
        }
    }
}
