package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangdaju on 17/7/30.
 */

public class DrawTestView extends View {

    private int width;
    private int height;
    private int radius = 150;
    private Paint mPaint;

    public DrawTestView(Context context) {
        super(context);
    }

    public DrawTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public DrawTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.GRAY);
//        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.OVERLAY);
//        mPaint.setColorFilter(porterDuffColorFilter);
//        LightingColorFilter lightingColorFilter = new LightingColorFilter(Color.GREEN,Color.BLUE);
//        mPaint.setColorFilter(lightingColorFilter);
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1.5F, 0, 0, 0, 0,
//                0, 1.5F, 0, 0, 0,
//                0, 0, 1F, 0, 0,
//                0, 0, 0, 1F, 0
//        });

        //色调
//        ColorMatrix rotateMatrix = new ColorMatrix();
//        rotateMatrix.setRotate(0,0.8f);//红
//        rotateMatrix.setRotate(1,0.8f);//绿
//        rotateMatrix.setRotate(2,0.8f);//蓝

        //饱和度
        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(0.5f);


        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(saturationMatrix);
        mPaint.setColorFilter(colorMatrixColorFilter);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = canvas.getWidth();
        height = canvas.getHeight();
        canvas.drawCircle(width >> 1, height >> 1, radius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
