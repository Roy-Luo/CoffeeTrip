package com.roy.coffeetrip.fragment;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.roy.coffeetrip.R;
import com.roy.coffeetrip.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class RecommendFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private LinearLayout layout;
    private int[] imgPath;//图片路径
    private int currentIndex = 300;//当前页面下表
    private List<ImageView> viewList;
    private MyAdapter myAdapter;
    private Long lastTime = System.currentTimeMillis();
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //主线程
            if ((System.currentTimeMillis()-lastTime)>3000){
                currentIndex++;
                viewPager.setCurrentItem(currentIndex);
                lastTime = System.currentTimeMillis();
            }
            handler.postDelayed(runnable, 3000);
            Log.d("TestFragment", "Let's go!");
        }

    };

    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        viewPager = (ViewPager) getView().findViewById(R.id.recommend_vp);
        layout = (LinearLayout) getView().findViewById(R.id.recommend_ll);

    }

    @Override
    public void initData() {

        imgPath = new int[]{R.mipmap.imageone,R.mipmap.imagesix,R.mipmap.imageseven,R.mipmap.imagethree};
        viewList = new ArrayList<>();
        for (int i= 0;i<imgPath.length;i++){
            ImageView view = new ImageView(mContext);
            view.setImageResource(imgPath[i]);
            viewList.add(view);

            ImageView imgCircle = new ImageView(mContext);
            imgCircle.setImageResource(R.mipmap.point_pressed);
            imgCircle.setPadding(10, 5, 10, 5);
            layout.addView(imgCircle);
        }
        myAdapter = new MyAdapter();
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(300);
        viewPager.setOnPageChangeListener(this);
        handler.postDelayed(runnable,3000);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onPageSelected(int position) {
        currentIndex = position;
        int index = position%viewList.size();
        for (int i=0;i<layout.getChildCount();i++){
            ImageView child = (ImageView) layout.getChildAt(i);
            if (i == index){
                child.setImageResource(R.mipmap.point_unpressed);
            }else {
                child.setImageResource(R.mipmap.point_pressed);
            }
            lastTime = System.currentTimeMillis();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int index = position % viewList.size();
            container.addView(viewList.get(index));
            return viewList.get(index);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position%viewList.size()));
        }
    }
}