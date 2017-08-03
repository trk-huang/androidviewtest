package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangdaju on 17/8/3.
 */

public class ComposeView extends View {

    private Paint mPaint;

    public ComposeView(Context context) {
        super(context);
    }

    public ComposeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ComposeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initPaint() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth() / 2;
        int height = getHeight() / 2;

        LinearGradient linearGradient = new LinearGradient(0, 0, width, height, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT);
        RadialGradient radialGradient = new RadialGradient(width, height, width, Color.BLUE, Color.CYAN, Shader.TileMode.REPEAT);
        ComposeShader composeShader = new ComposeShader(linearGradient, radialGradient, new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        mPaint.setShader(composeShader);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
    }
}
