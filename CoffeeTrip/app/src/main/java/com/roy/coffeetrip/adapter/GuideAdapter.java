package com.roy.coffeetrip.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.activity.MainActivity;
import com.roy.coffeetrip.utill.Image;

import java.util.ArrayList;

/**
 * Created by ${Roy} on 16/5/25.
 */
public class GuideAdapter extends PagerAdapter {
    // 界面列表
    private int[] ids;
    private Context context;

    public GuideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ids == null ? 0 : ids.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.a, container, false);
        ImageView image = (ImageView) view.findViewById(R.id.img_a);
        image.setImageResource(ids[position]);
        TextView textView = (TextView) view.findViewById(R.id.guide_tv1);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MainActivity.class));
                ((Activity)context).finish();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (container.getChildAt(position) == object) {
            container.removeViewAt(position);
        }
    }

    public void setData(int[] ids) {
        this.ids = ids;
        notifyDataSetChanged();
    }
}