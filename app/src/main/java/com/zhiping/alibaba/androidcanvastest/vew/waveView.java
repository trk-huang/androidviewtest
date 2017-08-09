package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by huangdaju on 17/8/9.
 */

public class waveView extends View {
    private Paint mPaint;
    private Path mPath1;
    private Path mPath2;
    private BitmapShader mWaveShader;
    private double x, y;
    private float m;
    private float[] normalX;
    private float[] mapX;
    private int width, height;
    private float ctrX, ctrY;
    private float waterY;
    private boolean isInc;
    private int num;

    public waveView(Context context) {
        super(context);
    }

    public waveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public waveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(Color.RED);
        PorterDuffXfermode mode = new PorterDuffXfermode(PorterDuff.Mode.XOR);
        mPaint.setXfermode(mode);
        mPath1 = new Path();
        mPath2 = new Path();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        waterY = height;
        ctrY = 15 / 16f * height;
        num = width / 10 + 1;
        mapX = new float[num];
        normalX = new float[num];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
//        mWaveShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
//        mPaint.setShader(mWaveShader);


//        mPaint.setColor(Color.YELLOW);
//        canvas.drawCircle(getWidth() / 2f, getHeight() / 2f, getWidth() / 2f, mPaint);
        drawWater(canvas);
        invalidate();
    }


    private void drawWater(Canvas canvas) {

        if (ctrX >= width + 1 / 4f * width) {
            isInc = false;
        } else if (ctrX <= -1 / 4f * width) {
            isInc = true;
        }
        ctrX = isInc ? ctrX + 20 : ctrX - 20;
        if (ctrY >= 0.5 * height && ctrY <= height) {
            ctrY -= 3;
            waterY -= 2;
        } else if (ctrY <= 0.5 * height) {
            ctrY -= 2;
            waterY -= 2;
        }

        canvas.drawColor(Color.CYAN);
        m = getWidth() / 21f;
        x = 0;
        mPath1.moveTo(-1 / 4f * width, getHeight() / 2);
        mPath2.moveTo(-1 / 4f * width, getHeight() / 2);

        for (int i = 0; i < num; i++) {
            x += 10;
            normalX[i] = (float) x;
            mapX[i] = (float) (21 * x / getWidth());
        }

        for (int i = 0; i < num; i++) {
            y = Math.sin(0.3 * mapX[i]);
            mPath1.lineTo(normalX[i], (float) y * m + waterY);
            mPath2.lineTo(normalX[i], (float) -y * m + waterY);
        }
        mPath1.lineTo(getWidth(), getHeight());
        mPath1.lineTo(0, getHeight());
        mPath1.close();
        mPath2.lineTo(getWidth(), getHeight());
        mPath2.lineTo(0, getHeight());
        mPath2.close();
        canvas.drawPath(mPath1, mPaint);
        canvas.drawPath(mPath2, mPaint);



        mPath1.reset();
        mPath2.reset();
    }
}
