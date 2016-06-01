package com.roy.coffeetrip.activity;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.fragment.CustomizeFragment;
import com.roy.coffeetrip.fragment.HunterFragment;
import com.roy.coffeetrip.fragment.MyselfFragment;
import com.roy.coffeetrip.fragment.RecommendFragment;
import com.roy.coffeetrip.greendaolite.CollectionDao;
import com.roy.coffeetrip.greendaolite.GreenDaoSingleton;

/**
 * CoffeeTrip
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioButton recommendBtn,hunterBtn,customizeBtn,myselfBtn;
    private CollectionDao collectionDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        // 数据库单例
        collectionDao = GreenDaoSingleton.getInstance().getCollectionDao();

        recommendBtn = (RadioButton) findViewById(R.id.recommend_btn);
        hunterBtn = (RadioButton) findViewById(R.id.hunter_btn);
        customizeBtn = (RadioButton) findViewById(R.id.customize_btn);
        myselfBtn = (RadioButton) findViewById(R.id.myself_btn);

        recommendBtn.setOnClickListener(this);
        hunterBtn.setOnClickListener(this);
        customizeBtn.setOnClickListener(this);
        myselfBtn.setOnClickListener(this);

        // 在onCreate中替换首页
        // 保证,第一次进入页面,显示的不是占位布局
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.recommend_frame,new RecommendFragment());
        // 切记提交任务
        transaction.commit();


    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tran = manager.beginTransaction();
        switch (v.getId()){
            case R.id.recommend_btn:
                tran.replace(R.id.recommend_frame,new RecommendFragment());
                break;
            case R.id.hunter_btn:
                tran.replace(R.id.recommend_frame,new HunterFragment());
                break;
            case R.id.customize_btn:
                tran.replace(R.id.recommend_frame,new CustomizeFragment());
                break;
            case R.id.myself_btn:

                tran.replace(R.id.recommend_frame,new MyselfFragment());
                break;
        }
        tran.commit();
    }
}
