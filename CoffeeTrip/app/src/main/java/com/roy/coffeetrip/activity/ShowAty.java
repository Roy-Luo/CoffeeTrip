package com.roy.coffeetrip.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.roy.coffeetrip.R;

/**
 * Created by ${Roy} on 16/5/26.
 */
public class ShowAty extends AppCompatActivity {

    private boolean isFistUse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 延迟3秒
                    Thread.sleep(3000);
                    // 读取SharedPreferences中需要的数据
                    SharedPreferences preferences = getSharedPreferences("isFirstUse",
                            MODE_WORLD_READABLE);

                    isFistUse = preferences.getBoolean("isFirstUse", true);

                    // 如果用户不是第一次使用则直接跳转到显示界面,否则跳转到引导页面
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            if (true) {
                                startActivity(new Intent(ShowAty.this, GuideAty.class));
                            } else {
                                startActivity(new Intent(ShowAty.this, MainActivity.class));
                            }
                            finish();
                        }
                    });

                    // 实例化Editor对象
                    SharedPreferences.Editor editor = preferences.edit();
                    // 存入数据
                    editor.putBoolean("isFirstUse", false);
                    // 提交
                    editor.commit();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
