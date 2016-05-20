package com.roy.coffeetrip.utill;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Chen fengYao on 2015/8/5.
 * 为了重写加载动画的方法,使动画在加载图片是加载
 *
 */
public class MyImageLoader extends ImageLoader {
    public MyImageLoader(RequestQueue queue, ImageCache imageCache) {
        super(queue, imageCache);
    }

//有动画持续时间的
    public static ImageListener getImageListener(final ImageView view,
                                                             final int defaultImageResId,
                                                             final int errorImageResId,
                                                             final int lastTime) {
        return new ImageListener() {
            public void onErrorResponse(VolleyError error) {
                if(errorImageResId != 0) {
                    view.setImageResource(errorImageResId);
                }

            }

            public void onResponse(ImageContainer response, boolean isImmediate) {
                if(response.getBitmap() != null) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(lastTime);//设置动画持续时间4s
                    view.startAnimation(alphaAnimation);//播放动画
                    view.setImageBitmap(response.getBitmap());
                } else if(defaultImageResId != 0) {
                    view.setImageResource(defaultImageResId);
                }

            }
        };
    }

    //可以使目标view的背景颜色根据获取的图片改变的
    public static ImageListener getImageListener(final ImageView view,
                                                             final int defaultImageResId,
                                                             final int errorImageResId,
                                                             final int lastTime,
                                                             final View v) {
        return new ImageListener() {
            public void onErrorResponse(VolleyError error) {
                if(errorImageResId != 0) {
                    view.setImageResource(errorImageResId);
                }

            }

            public void onResponse(ImageContainer response, boolean isImmediate) {
                if(response.getBitmap() != null) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0f, 1f);
                    alphaAnimation.setDuration(lastTime);//设置动画持续时间4s
                    view.startAnimation(alphaAnimation);//播放动画
                    view.setImageBitmap(response.getBitmap());

                //    v.setBackgroundColor(ImageUtil.getColor(response.getBitmap()));//设置组件的元素

                } else if(defaultImageResId != 0) {
                    view.setImageResource(defaultImageResId);
                }

            }
        };
    }



}
