package com.futaba.androidmadlink.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.futaba.androidmadlink.C0112R;

public class VariometerView extends View {
    private String _type = "Optics";
    private float _value = 0.0f;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;
    private Paint mfont;

    public VariometerView(Context context) {
        super(context);
    }

    public VariometerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public String getType() {
        return this._type;
    }

    public void setType(String Type) {
        this._type = Type;
        init();
        invalidate();
    }

    public float getValue() {
        return this._value;
    }

    public void setValue(float Value) {
        this._value = Value;
        init();
        invalidate();
    }

    private void init() {
        if (this._type == "") {
            this._type = "Optics";
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawValue(canvas);
    }

    private void drawBackground(Canvas canvas) {
        Paint backgroundPaint = new Paint();
        backgroundPaint.setAntiAlias(true);
        Bitmap srcBitmap = BitmapFactory.decodeResource(getResources(), C0112R.C0113drawable.icon);
        float srcWidth = (float) srcBitmap.getWidth();
        float srcHeight = (float) srcBitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(((float) this.mWidth) / srcWidth, ((float) this.mHeight) / srcHeight);
        backgroundPaint.setShader(new BitmapShader(Bitmap.createBitmap(srcBitmap, 0, 0, (int) srcWidth, (int) srcHeight, matrix, true), TileMode.CLAMP, TileMode.CLAMP));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) this.mWidth, (float) this.mHeight), 0.0f, 0.0f, backgroundPaint);
        this.mfont = new Paint();
        this.mfont.setColor(-1);
        this.mfont.setTextSize((float) getDPFromPixels(23));
        this.mfont.setAntiAlias(true);
        canvas.drawText("RPM", (float) (this.mWidth / 16), (float) (this.mHeight / 15), this.mfont);
        this.mfont.setTextSkewX(-0.5f);
        this.mfont.setColor(-26317);
        canvas.drawText("Type：", (float) ((this.mWidth * 2) / 6), (float) ((this.mHeight * 5) / 7), this.mfont);
        canvas.drawText("Value：", (float) ((this.mWidth * 2) / 6), (float) ((this.mHeight * 6) / 7), this.mfont);
    }

    private void drawValue(Canvas canvas) {
        this.mfont = new Paint();
        this.mfont.setColor(-26317);
        this.mfont.setTextSize((float) getDPFromPixels(25));
        this.mfont.setAntiAlias(true);
        canvas.drawText(this._type, (float) ((this.mWidth * 4) / 7), (float) ((this.mHeight * 5) / 7), this.mfont);
        this.mfont.setTextSize((float) getDPFromPixels(27));
        this.mfont.setColor(-16711936);
        canvas.drawText(String.valueOf(this._value), (float) ((this.mWidth * 4) / 7), (float) ((this.mHeight * 7) / 8), this.mfont);
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
        if (this.mWidth < this.mHeight) {
            this.mHeight = (this.mWidth / 4) * 3;
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
}
