package com.roy.coffeetrip.utill;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.roy.coffeetrip.interfacebean.IImageFilter;
import com.roy.coffeetrip.R;

/**
 * Created by ${Roy} on 16/5/15.
 */
public class ProcessImageTask extends AsyncTask<Void, Void, Bitmap> {
    private IImageFilter filter;
    private Activity activity = null;

    CallBack mCallBack ;


    public ProcessImageTask(Activity activity, IImageFilter imageFilter) {
        this.filter = imageFilter;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

    public Bitmap doInBackground(Void... params) {
        Image img = null;
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.imagesix);
            Bitmap scbit = Bitmap.createScaledBitmap(bitmap,360,239,true) ;
            img = new Image(scbit);
            if (filter != null) {
                img = filter.process(img);
                img.copyPixelsFromBuffer();
            }
            return img.getImage();
        } catch (Exception e) {
            if (img != null && img.destImage.isRecycled()) {
                img.destImage.recycle();
                img.destImage = null;
                System.gc(); // 提醒系统及时回收
            }
        } finally {
            if (img != null && img.image.isRecycled()) {
                img.image.recycle();
                img.image = null;
                System.gc(); // 提醒系统及时回收
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (result != null) {
            super.onPostExecute(result);
            if(mCallBack !=null){
                mCallBack.complete(result);
            }
        }
    }

    public void setCallBack(CallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public interface CallBack{
        void complete(Bitmap bitmap) ;
    }
}