package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by huangdaju on 17/7/29.
 */

public class TextTestView extends View {

    private Paint mPaint;
    private String text = "Hello world!";

    public TextTestView(Context context) {
        this(context, null);
    }

    public TextTestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        initPaint();
    }

    public TextTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#FFF000"));
        mPaint.setTextSize(90);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = mPaint.measureText(text);
        Paint.FontMetrics metrics = mPaint.getFontMetrics();
        float x = (getWidth() - width) / 2f;
        float y = getHeight() / 2 + (Math.abs(metrics.ascent - metrics.descent) / 2f);
        canvas.drawText(text, x, y, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}

