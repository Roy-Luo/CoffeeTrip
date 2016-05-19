package com.roy.coffeetrip.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${Roy} on 16/5/17.
 */
public class MyApplication extends Application {

    public static Context context;
    // Application创建的原因是因为我们需要一个属于自己的context对象
    // 保证自己的app拥有单独的一个context对象
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
    // 对外提供一个方法,这个方法就是让别的类获取自己的context对象
    public static Context getContext(){
        return context;
    }

}
