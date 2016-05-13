package com.roy.coffeetrip.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by ${Roy} on 16/5/10.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initData();
    }

    // 这是加载布局的抽象方法
    public abstract int getLayout();

    // 加载数据的方法
    public abstract void initData();

    // 加载组件的方法
    public abstract int initView();

    // 这个方法使组件实例化不需要转型
    // 使用方法 : TextView tv = bindView(R.id.tv);
    // 这样的话就不需要强转了
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

}
