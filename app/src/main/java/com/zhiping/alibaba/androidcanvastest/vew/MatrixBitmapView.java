package com.zhiping.alibaba.androidcanvastest.vew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhiping.alibaba.androidcanvastest.R;

/**
 * Created by huangdaju on 17/8/9.
 */

public class MatrixBitmapView extends View {

    private Bitmap mBitmap;

    public MatrixBitmapView(Context context) {
        super(context);
    }

    public MatrixBitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MatrixBitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Matrix matrix = new Matrix();
        matrix.setScale(0.5f, 0.5f, getWidth() / 2, getHeight() / 2);
//        matrix.setTranslate(100f,100f);
        canvas.drawBitmap(mBitmap, matrix, new Paint());
    }
}
