package com.roy.coffeetrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.GuideAdapter;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/26.
 */
public class GuideAty extends AppCompatActivity {


    // 定义viewpager对象
    private ViewPager viewPager;
    // 定义viewPager适配器
    private GuideAdapter adapter;
    // 定义一个ArrayList来存放View

    private int[] ids = {R.mipmap.user_guide_01,R.mipmap.user_guide_02,R.mipmap.user_guide_03,R.mipmap.user_guide_04,R.mipmap.user_guide_05};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_guide);
        viewPager = (ViewPager) findViewById(R.id.guide_viewpager);
        adapter = new GuideAdapter(this);
        adapter.setData(ids);
        viewPager.setAdapter(adapter);
    }


}