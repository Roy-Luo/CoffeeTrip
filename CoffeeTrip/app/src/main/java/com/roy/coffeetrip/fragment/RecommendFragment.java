package com.roy.coffeetrip.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.activity.recommend.AnotherContentAty;
import com.roy.coffeetrip.adapter.recommend.RecommendAdapter;
import com.roy.coffeetrip.base.BaseFragment;
import com.roy.coffeetrip.bean.recommend.RecommendItemBean;
import com.roy.coffeetrip.bean.recommend.RecommendRotateBean;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

public class RecommendFragment extends BaseFragment implements ViewPager.OnPageChangeListener, AdapterView.OnItemClickListener {

    /***********以下是解析实体类集合***********/
    private ArrayList<RecommendRotateBean> rotate;
    private ArrayList<RecommendItemBean>  itemBean;
    private RecommendAdapter recommendAdapter;
    private PullToRefreshListView pullToRefreshListView;
    private ListView listView;
    private int ids;
    private List<Integer> data ;
    /**************以下是轮播图***************/
    private ViewPager viewPager;
    private LinearLayout layout;
    private MyAdapter myAdapter;
    private boolean isRotate = false; // 是否轮播,默认false
    private Long lastTime = System.currentTimeMillis();
    private Handler handler = new Handler();

    /**************以下不是******************/


    /************设置无限轮播****************************/
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
    /**************************************************/


    @Override
    public int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        pullToRefreshListView = (PullToRefreshListView) getView().findViewById(R.id.recommend_lv);
        listView = pullToRefreshListView.getRefreshableView();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recommend_recyclephoto,null);
        listView.addHeaderView(view);
        viewPager = (ViewPager) view.findViewById(R.id.recommend_vp);
        layout = (LinearLayout) view.findViewById(R.id.recommend_ll);
        pullToRefreshListView.setOnItemClickListener(this);

        /**
         * 刷新 加载
         */
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pullToRefreshListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                pullToRefreshListView.onRefreshComplete();
            }
        });

        /**
         * 设置显示文字
         */
//        String str = DateUtils.formatDateTime(getContext(), System.currentTimeMillis(), DateUtils.
//                FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//
//        ILoadingLayout startLabels = mPullToRefreshListView
//                .getLoadingLayoutProxy(true, false);
//        startLabels.setRefreshingLabel("正在刷新");
//        startLabels.setReleaseLabel("释放开始刷新");
//        startLabels.setLastUpdatedLabel("最后更新时间:" + str);
//        ILoadingLayout startLabelsNext = mPullToRefreshListView
//                .getLoadingLayoutProxy(false, true);
//        startLabelsNext.setRefreshingLabel("正在加载");
//        startLabelsNext.setPullLabel("上拉加载更多");

        String time = DateUtils.formatDateTime(getContext(),System.currentTimeMillis(),DateUtils.FORMAT_SHOW_TIME
                | DateUtils.FORMAT_SHOW_DATE|DateUtils.FORMAT_ABBREV_ALL);
        ILoadingLayout startUpText = pullToRefreshListView.getLoadingLayoutProxy(true,false);
        startUpText.setRefreshingLabel("尔等给爸爸等着!");
        startUpText.setReleaseLabel("老子马上告诉你");
        startUpText.setLastUpdatedLabel("倒计时 : "+ time);
        ILoadingLayout startDownText = pullToRefreshListView.getLoadingLayoutProxy(false,true);
        startDownText.setRefreshingLabel("尔等殿外跪候吧!");
        startDownText.setPullLabel("上拉加载更多!你都不知道?");
    }

    @Override
    public void initData() {
        rotate = new ArrayList<>();
        itemBean = new ArrayList<>();
        data = new ArrayList<>();
        /***********************解析网络数据*************************/
        RequestQueue referenceQueue = Volley.newRequestQueue(mContext);
        //https是加密的网址 在这里我们使用http保证请求的正确
        StringRequest requestItem = new StringRequest(Request.Method.GET, "http://chanyouji.com/api/trips/featured.json?page"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                itemBean = gson.fromJson(response,new TypeToken<ArrayList<RecommendItemBean>>(){}.getType());
                recommendAdapter.setDatas(itemBean);
                for (int i=0;i<itemBean.size();i++) {
                    ids = itemBean.get(i).getId();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ROY","出错了!"+error);
            }
        });
        referenceQueue.add(requestItem);

        StringRequest request = new StringRequest(Request.Method.GET, "http://chanyouji.com/api/adverts.json?name=app_featured_banner_android"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();
               //解析数据
                Type type = new TypeToken<ArrayList<RecommendRotateBean>>(){}.getType();
                rotate = gson.fromJson(response,type);

                myAdapter.setDatas(rotate);

                // 添加小点
                initPoint();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("roy","--->"+error);
            }
        });
        referenceQueue.add(request);




        /*************************************************************/

        recommendAdapter = new RecommendAdapter(mContext);
        listView.setAdapter(recommendAdapter);

        myAdapter = new MyAdapter(mContext,rotate);
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(500);
        viewPager.addOnPageChangeListener(this);

        handler.postDelayed(thread,5000);


    }
    // 添加设置小点
    private void initPoint() {
        for (int i= 0;i<rotate.size();i++){

            ImageView imgCircle = new ImageView(mContext);
            imgCircle.setPadding(10, 5, 10, 5);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15,15);
            imgCircle.setLayoutParams(params);
            // 设置小点样式
            if (i == 0){
                imgCircle.setImageResource(R.mipmap.point_pressed);
            }else {
                imgCircle.setImageResource(R.mipmap.point_unpressed);
            }

            layout.addView(imgCircle);

        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(thread);
    }

    @Override
    public void onPageSelected(int position) {


        for (int i=0;i<rotate.size();i++){
            ImageView child = (ImageView) layout.getChildAt(i);


            child.setImageResource(R.mipmap.point_pressed);
        }
        ImageView img = (ImageView) layout.getChildAt(position%rotate.size());
        img.setImageResource(R.mipmap.point_unpressed);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onResume() {
        super.onResume();
        isRotate = true;
    }

    // 跳转详情界面
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("shabi", "------>position:" + position);
        Log.d("2B", "itemBean.get(position).getId():" + itemBean.get(position-1).getId());
        Intent intent = new Intent(mContext, AnotherContentAty.class);
        intent.putExtra("id",itemBean.get(position-1).getId());


        mContext.startActivity(intent);


    }


    // 轮播适配器
    private class MyAdapter extends PagerAdapter{
        private Context context;

        private ArrayList<RecommendRotateBean> datas;

        public MyAdapter(Context context, ArrayList<RecommendRotateBean> data) {
            this.context = context;
        }

        public void setDatas(ArrayList<RecommendRotateBean> datas) {
            this.datas = datas;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return datas != null ? Integer.MAX_VALUE : 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_recyclephoto_photo,null);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_recommend_photo_img);
            Picasso.with(context).load(rotate.get(position%rotate.size()).getImage_url()).into(imageView);
            container.addView(view);
            return view;

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }

}