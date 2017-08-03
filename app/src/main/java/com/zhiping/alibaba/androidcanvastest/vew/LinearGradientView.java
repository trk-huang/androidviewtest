package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangdaju on 17/8/3.
 */

public class LinearGradientView extends View {

    private Paint mPaint;

    public LinearGradientView(Context context) {
        super(context);
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        LinearGradient linearGradient = new LinearGradient(0,0);
    }

    @Override
    protected void onDraw(Canvas canvas) {

//        int color0 = Color.parseColor("#ffffff");
//        int color1 = Color.parseColor("#343445");
//        LinearGradient linearGradient = new LinearGradient(0, 0, getWidth() / 2, getHeight() / 2, color0, color1, Shader.TileMode.REPEAT);

        int[] colors = new int[]{
                Color.MAGENTA, Color.CYAN, Color.RED
        };
        float[] positions = new float[]{
                0f, 0.5f, 1.0f
        };
        LinearGradient linearGradient = new LinearGradient(0, 0, getWidth(), getHeight(), colors, positions, Shader.TileMode.REPEAT);
        mPaint.setShader(linearGradient);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
