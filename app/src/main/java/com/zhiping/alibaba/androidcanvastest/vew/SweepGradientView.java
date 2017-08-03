package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhiping.alibaba.androidcanvastest.R;

/**
 * Created by huangdaju on 17/8/3.
 */

public class SweepGradientView extends View {

    private Paint mPaint;

    public SweepGradientView(Context context) {
        super(context);
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] colors = new int[]{
                Color.MAGENTA, Color.CYAN, Color.RED
        };
        float[] positions = new float[]{
                0f, 0.5f, 1.0f
        };
//
//        SweepGradient sweepGradient = new SweepGradient(width, height, Color.RED, Color.YELLOW);
        SweepGradient sweepGradient = new SweepGradient(width, height, colors, positions);
        mPaint.setShader(sweepGradient);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
