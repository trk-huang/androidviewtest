package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhiping.alibaba.androidcanvastest.R;

/**
 * Created by huangdaju on 17/8/4.
 */

public class DrawBitmapTestView extends View {
    public DrawBitmapTestView(Context context) {
        super(context);
    }

    public DrawBitmapTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawBitmapTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
//        canvas.drawBitmap(bitmap,0,0,new Paint());
//        canvas.drawBitmap(bitmap, new Rect(0, 0, getWidth() - 200, getHeight() /2), new Rect(100, 0, getWidth()-100, getHeight() / 2), new Paint());
//        canvas.drawBitmap(bitmap, new Rect(0, 0, getWidth() / 2, getHeight() / 2), new RectF(0, 0, getWidth(), getHeight() / 4), new Paint());
//        float[] pts = new float[]{100f,500f,200f,700f,400f,400f};
//        Paint mp = new Paint();
//        mp.setStrokeWidth(10f);
//        mp.setColor(Color.parseColor("#FF4081"));
//        canvas.drawPoints(pts,mp);

//        Paint mp = new Paint();
//        mp.setColor(Color.parseColor("#FF4081"));
//        mp.setStyle(Paint.Style.FILL);
////        RectF rectF = new RectF(0,0,400,300);
//        Path path = new Path();
//        path.moveTo(0,0);
//        path.lineTo(200,250);
//        path.lineTo(500,600);
//        path.lineTo(0,400);
//        path.close();
//
//        canvas.drawColor(Color.YELLOW);
//        canvas.clipPath(path);
//        canvas.drawColor(Color.CYAN);
//        canvas.drawRect(200,200,600,600,mp);

        Paint mp = new Paint();
        mp.setColor(Color.parseColor("#FF4081"));
        mp.setStyle(Paint.Style.FILL);

        RectF rectF1 = new RectF(100,100,300,300);
        RectF rectF2 = new RectF(200,200,400,400);

        canvas.drawColor(Color.BLUE);
        canvas.save();
        canvas.clipRect(rectF1);
        canvas.clipRect(rectF2, Region.Op.XOR);

        canvas.drawColor(Color.RED);
        canvas.restore();
//        canvas.drawRect(rectF1,mp);
//        canvas.drawRect(rectF2,mp);

    }
}
