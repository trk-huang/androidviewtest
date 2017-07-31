package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by huangdaju on 17/7/30.
 */

public class CircleImageView extends ImageView {

    private Paint mpaint;

    public CircleImageView(Context context) {
        this(context, null);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable();
        if (drawable != null) {
            Bitmap bitmap = drawable.getBitmap();
            drawCircleBitmap(canvas, bitmap);
        }
    }


    private void drawCircleBitmap(Canvas canvas, Bitmap bitmap) {
        int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //绘制dst层
        int width = getWidth();
        int height = getHeight();
        float raduis = (width > height ? height : width) >> 1 ;
        float x = width >> 1, y = height >> 1;
        Log.d("MainActivity3", " x , " + x + "y, " + y + "radius, " + raduis);
        canvas.drawCircle(x, y, raduis, mpaint);
        PorterDuffXfermode mode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        mpaint.setXfermode(mode);

        //src层
        float srcX = (width - bitmap.getWidth()) >> 1;
        float srcY = (height - bitmap.getHeight()) >> 1;
        Log.d("MainActivity3", " srcX , " + srcX + "srcY, " + srcY);
        canvas.drawBitmap(bitmap, srcX, srcY, mpaint);

        mpaint.setXfermode(null);
        canvas.restoreToCount(sc);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


}
