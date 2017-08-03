package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhiping.alibaba.androidcanvastest.R;

/**
 * Created by huangdaju on 17/8/3.
 */

public class BitmapShaderClampView extends View {

    private Paint mPaint;

    public BitmapShaderClampView(Context context) {
        super(context);
    }

    public BitmapShaderClampView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public BitmapShaderClampView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        final BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(bitmapShader);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float height = getHeight() / 2 ;

        canvas.drawCircle(width, height, width / 2, mPaint);

    }
}
