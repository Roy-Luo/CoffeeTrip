package com.roy.coffeetrip.utill;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.*;
import com.android.volley.toolbox.StringRequest;
import com.roy.coffeetrip.base.MyApplication;

/**
 * Created by ${Roy} on 16/5/17.
 */
public class VolleySingleton {
    private static Context mContext;
    private RequestQueue queue;//请求队列
    private static VolleySingleton ourInstance =
            new VolleySingleton();
    //获取单例的对象
    public static VolleySingleton getInstance() {
        return ourInstance;
    }

    private VolleySingleton() {
        //获取Application里面的context
        //mContext =context.getApplicationContext();
        mContext = MyApplication.getContext();

        queue = getQueue();//初始化我的请求队列
        myImageLoader = new MyImageLoader(queue, new DoubleCache());
    }


    //提供一个方法新建请求队列
    public RequestQueue getQueue(){
        if (queue == null){
            if(MyApplication.getContext()==null){
                Log.d("Sysout","null");
            }
            queue = Volley.newRequestQueue(MyApplication.getContext());
        }
        return queue;
    }

    public  static  final String TAG = "VolleySingleton";

    //添加请求
    public  <T> void _addRequest(Request<T> request){
        request.setTag(TAG);//为我的请求添加标签,方便管理
        queue.add(request);//将请求添加到队列当中
    }

    public <T> void _addRequest(Request<T> request,
                                Object tag){
        request.setTag(tag);
        queue.add(request);

    }
    private static MyImageLoader myImageLoader;
    public static MyImageLoader getMyImageLoader(){
        return myImageLoader;
    }

    /**
     * 用法同getMyImg,只是多了个参数动画渐变的时间
     *
     * @param path
     * @param view
     * @param defaultImageResId
     * @param errorImageResId
     */
    public void getImg(String path, ImageView view, int defaultImageResId, int errorImageResId, int lastTime, View v) {


        MyImageLoader.ImageListener listener = MyImageLoader.getImageListener(view,
                defaultImageResId, errorImageResId, lastTime,v);

        myImageLoader.get(path, listener);
        //return
    }

//    public void _addRequest(String url,
//                            //这里为我的成功时候的回调加上String类型的泛型
//                            Response.Listener<String> listener,
//                            Response.ErrorListener errorListener){
//
//        //创建StringRequest
//        // 三个参数分别是 url接口网址
//        //成功时候的回调,失败时候的回调
//        StringRequest stringRequest = new StringRequest(url,listener,errorListener);
//        //将请求加入到队列
//        _addRequest(stringRequest);
//    }
    public void _addRequest(String url,Response.Listener<String> listener,Response.ErrorListener errorListener){
        StringRequest stringRequest = new StringRequest(url,listener,errorListener);
        _addRequest(stringRequest);
    }



    public <T> void _addRequest(String url, Class<T> mClass,
                                Response.Listener<T> listener,
                                Response.ErrorListener errorListener){
//        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET,
//                url,mClass,listener,errorListener);
        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET,url,errorListener,mClass,listener);
        _addRequest(gsonRequest);
    }

    //这个方法是将请求移除队列
    public void removeRequest(Object tag){
        queue.cancelAll(tag);//根据不同的tag移除出队列
    }

    public static void addRequest(String url,
                                  Response.Listener<String> listener,
                                  Response.ErrorListener
                                          errorListener){
        //获取单例的对象,调用添加请求的方法(这个是StringRequest的请求)
        getInstance()._addRequest(url,listener,errorListener);
    }
    public static  <T> void addRequest(String url,
                                       Class<T> mClass,
                                       Response.Listener<T> listener,
                                       Response.ErrorListener errorListener){
        //同上方法将GsonRequest请求加入单例的队列里
        getInstance()._addRequest(url,mClass,
                listener,errorListener);
    }

}
