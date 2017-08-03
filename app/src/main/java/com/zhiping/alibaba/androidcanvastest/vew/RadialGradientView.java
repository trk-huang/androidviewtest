package com.zhiping.alibaba.androidcanvastest.vew;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangdaju on 17/8/3.
 */

public class RadialGradientView extends View {

    private Paint mPaint;

    public RadialGradientView(Context context) {
        super(context);
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int radius = width;
//        RadialGradient radialGradient = new RadialGradient(width, height, radius, Color.RED, Color.BLUE, Shader.TileMode.REPEAT);
        int[] colors = new int[]{
                Color.MAGENTA, Color.CYAN, Color.RED
        };
        float[] positions = new float[]{
                0f, 0.5f, 1.0f
        };
        RadialGradient radialGradient = new RadialGradient(width, height, radius, colors, positions, Shader.TileMode.REPEAT);

        mPaint.setShader(radialGradient);
        canvas.drawCircle(width, height, width, mPaint);
    }
}
