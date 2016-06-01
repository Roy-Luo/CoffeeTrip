package com.roy.coffeetrip.fragment;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.customize.CustomizeAdapter;
import com.roy.coffeetrip.adapter.customize.CustomizeHeaderAdapter;
import com.roy.coffeetrip.base.BaseFragment;
import com.roy.coffeetrip.bean.customize.CustomizeBean;
import com.roy.coffeetrip.utill.VolleySingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by ${Roy} on 16/5/10.
 */
public class CustomizeFragment extends BaseFragment implements ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener {

    private CustomizeBean datas;
    private CustomizeAdapter mAdapter;
    private CustomizeHeaderAdapter headerAdapter;
    private ViewPager viewPager;

    private boolean isRotate = false; // 是否轮播,默认false
    private Long lastTime = System.currentTimeMillis();
    private android.os.Handler handler = new android.os.Handler();
    private TextView title;
    private ImageView shareImg;
    private PullToRefreshListView mPulltoListView;
    private ListView listview;

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            //主线程
            if ((System.currentTimeMillis()-lastTime)>5000){
                // 获得ViewPager当前页
                int currentIndex = viewPager.getCurrentItem();
                // 设置 自增1
                // 这里要判断,轮播的下一张page不能超过viewpager的count
                // 否则会崩
                viewPager.setCurrentItem(++currentIndex);
                lastTime = System.currentTimeMillis();
            }
            // handler延时发送线程,实现轮播
            handler.postDelayed(thread, 5000);
        }
    });

    @Override
    public int setLayout() {
        return R.layout.fragment_customize;
    }

    @Override
    public void initView() {
        mPulltoListView = (PullToRefreshListView) getView().findViewById(R.id.customize_lv);
       listview=mPulltoListView.getRefreshableView();
        // add HeaderView
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_customize_header,null);

        listview.addHeaderView(view);
        viewPager = (ViewPager) view.findViewById(R.id.item_customize_header_vp);
        mPulltoListView.setOnItemClickListener(this);

        /**
         *  设置刷新!
         */
        mPulltoListView.setMode(PullToRefreshBase.Mode.BOTH);
        mPulltoListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                // 刷新结束
                mPulltoListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                // 刷新结束
                mPulltoListView.onRefreshComplete();
            }
        });


        // title
        title = (TextView) getView().findViewById(R.id.customize_wen_title_tv);
        title.setText("约吗?面粉!");

        // share
        shareImg = (ImageView) getView().findViewById(R.id.customize_web_share_img);
        shareImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShare();
            }
        });

    }

    @Override
    public void initData() {

        VolleySingleton.addRequest("http://api.miaotu.net/v2/yueyou/list?filter=&latitude=38.882480&longitude=121.539614&num=10&page=1",
                CustomizeBean.class, new Response.Listener<CustomizeBean>() {
                    @Override
                    public void onResponse(CustomizeBean response) {
                        mAdapter.setDatas(response.getItems());
                        headerAdapter.setDatas(response.getBanner());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("CustomizeFragment", "error:" + error);
                    }
                });

        // 设置主adapter 并且添加listView
        mAdapter =new CustomizeAdapter(mContext);
        mPulltoListView.setAdapter(mAdapter);


        // 轮播图的设置与adapter的初始化
        headerAdapter = new CustomizeHeaderAdapter(mContext);
        viewPager.setAdapter(headerAdapter);
        viewPager.setCurrentItem(200);
        viewPager.addOnPageChangeListener(this);

        handler.postDelayed(thread,5000);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate =true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(thread);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /**
     * 通过MOB 来分享到第三方
     */
    private void showShare() {

        ShareSDK.initSDK(mContext);
        OnekeyShare oks = new OnekeyShare();


        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.ssdk_oks_share));

        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");

        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");

        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");

        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");

        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));

        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(mContext);

    }
}
