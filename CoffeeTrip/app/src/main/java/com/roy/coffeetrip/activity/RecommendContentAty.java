package com.roy.coffeetrip.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.RecommendContentAdapter;
import com.roy.coffeetrip.adapter.RecommendContentHeaderAdapter;
import com.roy.coffeetrip.base.BaseActivity;
import com.roy.coffeetrip.bean.RecommendContentBean;
import com.roy.coffeetrip.utill.GaussianBlurFilter;
import com.roy.coffeetrip.utill.ProcessImageTask;
import com.roy.coffeetrip.utill.VolleySingleton;

import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ${Roy} on 16/5/14.
 */
public class RecommendContentAty extends BaseActivity implements AbsListView.OnScrollListener {

    private RecommendContentBean recommendContentBean;
    private ListView mListView;
    private ImageView headerImg;
    private RelativeLayout mListViewHeader;
    private int mActionBarSize;
    private RecommendContentAdapter mAdapter;
    private int mMinHeaderTranslation;
    private ProcessImageTask processImageTask;
    private AccelerateDecelerateInterpolator mSmoothInterPolator;
    private ImageView picImg;
    private SimpleDraweeView iconSdv;
    private TextView titleTv,dateTv;


    @Override
    public int getLayout() {
        return R.layout.aty_content;
    }

    @Override
    public void initView() {
        mSmoothInterPolator = new AccelerateDecelerateInterpolator();
        mListView = (ListView) findViewById(R.id.id_list_view);
        View view = LayoutInflater.from(this).inflate(R.layout.item_content_pic,null);
        mListView.addHeaderView(view);
        headerImg = (ImageView) view.findViewById(R.id.content_pic_img);
        picImg = (ImageView) view.findViewById(R.id.content_pic_img);
        iconSdv = (SimpleDraweeView) view.findViewById(R.id.content_icon_sdv);
        titleTv = (TextView) view.findViewById(R.id.content_title_tv);
        dateTv = (TextView) view.findViewById(R.id.content_date_tv);


        mAdapter = new RecommendContentAdapter(this);
        mListView.setOnScrollListener(this);
    }

    @Override
    public void initData() {

        getActionBarSize();
        getVolleySingleton();
        headerImg.post(new Runnable() {
            @Override
            public void run() {
                // 获取滚动的最小值
                mMinHeaderTranslation = -headerImg.getMeasuredHeight() + mActionBarSize;
                Log.d("RecommendContentAty", "headerImg.getMeasuredHeight():--->" + headerImg.getMeasuredHeight());
            }
        });

        // 以下代码是用来生成毛玻璃效果图，
        // * 记住一定要异步实现，因为这个过程需要很久的时间
        // * 而，生成毛玻璃效果的代码是国外以为大神写的，
        // * 这里就不贴出来了，需要的可以再 github 上找到

        processImageTask = new ProcessImageTask(this, new GaussianBlurFilter());
        processImageTask.setCallBack(new ProcessImageTask.CallBack() {
            @Override
            public void complete(Bitmap bitmap) {
                headerImg.setImageBitmap(bitmap);
            }
        });
        processImageTask.execute();

    }

    /**
     * 解析网络数据
     */
    private void getVolleySingleton() {
        String url = getIntent().getStringExtra("url");
        Log.d("RecommendContentAty", "url---------->"+url);
        VolleySingleton.addRequest(url, RecommendContentBean.class,
                new Response.Listener<RecommendContentBean>() {
                    @Override
                    public void onResponse(RecommendContentBean response) {
                        mAdapter.setRecommendContentBean(response);
//                        Log.d("RecommendContentAty", "response:----->" + response);
//                        Log.d("RecommendContentAty", "------->"+response.getFront_cover_photo_url());
//                        Log.d("RecommendContentAty", "picImg:------>" + picImg);
//                        Log.d("RecommendContentAty", "iconSdv:" + iconSdv + titleTv + dateTv);
//                        Log.d("RecommendContentAty", "name----->"+response.getName());
                        Picasso.with(RecommendContentAty.this).load(response.getFront_cover_photo_url()).into(picImg);
                        DraweeController controllerIcon = Fresco.newDraweeControllerBuilder().setUri(response.getUser().getImage()).build();
                        iconSdv.setController(controllerIcon);
                        titleTv.setText(response.getName());
                        dateTv.setText(response.getStart_date()+" 丨 "+response.getPhotos_count()+"图");
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("RecommendContentAty", "error:--->" + error);
                    }
                });
        mListView.setAdapter(mAdapter);
    }

    /**
     * 测量ActionBar的高度
     */
    private void getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.actionBarSize,typedValue,true);
        mActionBarSize = TypedValue.complexToDimensionPixelSize(typedValue.data,
                getResources().getDisplayMetrics());
        Log.d("RecommendContentAty", "mActionBarSize:----->" + mActionBarSize);
    }

    /**
     * ScrollListener
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int scrollY = getScrollY();
        headerImg.setTranslationY(Math.max(-scrollY,
                mMinHeaderTranslation));
        Log.v("zgy", "======mMainHeader.getTranslationX()========" + headerImg.getTranslationY());
        float alpha = clamp(headerImg.getTranslationY() /
                mMinHeaderTranslation, 0.0f, 1.0f);
        Log.v("zgy", "======alpha========" + alpha);
        float actual = clamp(1.0f - mSmoothInterPolator.getInterpolation(alpha),
                0.0f, 1.0f);
        headerImg.setAlpha(1.0f - actual);
    }

    /**
     * 这个方法还是比较有用的，
     * * @param value      * @param min      * @param max
     * * @return
     */
    public static float clamp(float value, float min, float max) {
        return Math.max(Math.min(value, max), min);
    }


    /**
     * 获取滚动的高度,用于检测是否需要滚动
     * @return
     */
    private int getScrollY() {
        int scrollY = 0;
        int itemScrollY = 0;
        int itemNum = mListView.getFirstVisiblePosition();
        View firstVisible = mListView.getChildAt(0);
        if (firstVisible == null) {
            return scrollY;
        }
        if (itemNum >= 1) {
            itemScrollY = mListViewHeader.getMeasuredHeight();
        }
        scrollY = itemScrollY - firstVisible.getTop();
        return scrollY;
    }

}

