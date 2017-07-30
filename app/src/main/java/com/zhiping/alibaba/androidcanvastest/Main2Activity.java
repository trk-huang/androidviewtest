package com.zhiping.alibaba.androidcanvastest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;


public class Main2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private SeekBar mSeekBar1;
    private SeekBar mSeekBar2;
    private SeekBar mSeekBar3;
    private ImageView iv;

    private float hue;
    private float saturation;
    private float lum;

    private float mid_value = 100f;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mSeekBar1 = (SeekBar) this.findViewById(R.id.seekBar);
        mSeekBar2 = (SeekBar) this.findViewById(R.id.seekBar2);
        mSeekBar3 = (SeekBar) this.findViewById(R.id.seekBar3);
        iv = (ImageView) this.findViewById(R.id.imageView);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        iv.setImageBitmap(bitmap);
        mSeekBar1.setOnSeekBarChangeListener(this);
        mSeekBar2.setOnSeekBarChangeListener(this);
        mSeekBar3.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("MainActivity2","progress " + progress);
        switch (seekBar.getId()) {
            case R.id.seekBar:
                hue = (progress) / 100f;
                break;
            case R.id.seekBar2:
                saturation = progress / 100f;
                break;
            case R.id.seekBar3:
                lum = progress / 100f;
                break;
        }
        handleImageBitmap();
    }

    private void handleImageBitmap() {
        Bitmap bm = Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas ca = new Canvas(bm);
        Paint pa = new Paint();

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0,hue);
        hueMatrix.setRotate(1,hue);
        hueMatrix.setRotate(2,hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix scaleMatrix = new ColorMatrix();
        scaleMatrix.setScale(lum,lum,lum,1);

        ColorMatrix imageMatrix = new ColorMatrix();
        imageMatrix.postConcat(hueMatrix);
        imageMatrix.postConcat(saturationMatrix);
        imageMatrix.postConcat(scaleMatrix);

        pa.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
        ca.drawBitmap(bitmap,0,0,pa);
        iv.setImageBitmap(bm);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
