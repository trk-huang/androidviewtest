package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zhiping.alibaba.androidcanvastest.R;

/**
 * Created by huangdaju on 17/7/31.
 */

public class GuaGuaView extends View {

    private Paint mPaint = new Paint();
    private int width, height;
    private Canvas mCanvas;

    private Bitmap dst;
    private Bitmap src;

    private Path mPath = new Path();

    private float lastX;
    private float lastY;

    public GuaGuaView(Context context) {
        super(context);
    }

    public GuaGuaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public GuaGuaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setDither(true);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        src = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(src);
        mCanvas.drawColor(Color.GRAY);
        dst = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //绘制下层图片
        canvas.drawBitmap(dst, 0, 0, null);
        //绘制操作
        drawPath();
        //绘制呱呱涂层
        canvas.drawBitmap(src, 0, 0, null);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float x = event.getX();
        float y = event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                mPath.moveTo(lastX, lastY);
                break;
            case MotionEvent.ACTION_MOVE:
                lastX = x;
                lastY = y;
                mPath.lineTo(lastX, lastY);
                break;
        }
        invalidate();
        return true;
    }

    private void drawPath() {
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        mCanvas.drawPath(mPath, mPaint);
    }
}
