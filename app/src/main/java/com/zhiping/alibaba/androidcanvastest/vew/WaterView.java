package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangdaju on 17/8/4.
 */

public class WaterView extends View {

    private Paint mPaint;
    private Path mPath;
    private float ctrX, ctrY;
    private float waterY;
    private int width, height, waterLevel;
    private boolean isInc;

    public WaterView(Context context) {
        super(context);
    }

    public WaterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public WaterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.BLUE);
        mPath = new Path();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        waterY = height;
        ctrY = 15 / 16f * height;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        drawWater(canvas);
        invalidate();
    }

    private void drawWater(Canvas canvas) {
        mPath.moveTo(-1 / 4f * width, waterY);
        mPath.quadTo(ctrX, ctrY, width + 1 / 4f * width, waterY);
        mPath.lineTo(width + 1 / 4f * width, height);
        mPath.lineTo((-1 / 4f * width), height);
        mPath.close();
        canvas.drawPath(mPath, mPaint);

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
        mPath.reset();
    }
}
