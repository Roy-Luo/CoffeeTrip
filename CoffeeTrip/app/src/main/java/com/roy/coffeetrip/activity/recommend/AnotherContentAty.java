package com.roy.coffeetrip.activity.recommend;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.activity.login.LoginAty;
import com.roy.coffeetrip.activity.login.SignUpAty;
import com.roy.coffeetrip.adapter.recommend.RecommendContentAdapter;
import com.roy.coffeetrip.base.BaseActivity;
import com.roy.coffeetrip.bean.recommend.RecommendContentBean;
import com.roy.coffeetrip.greendaolite.Collection;
import com.roy.coffeetrip.greendaolite.CollectionDao;
import com.roy.coffeetrip.greendaolite.DaoMaster;
import com.roy.coffeetrip.greendaolite.GreenDaoSingleton;
import com.roy.coffeetrip.utill.FastBlur;
import com.roy.coffeetrip.utill.MyImageLoader;
import com.roy.coffeetrip.utill.VolleySingleton;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import de.greenrobot.dao.query.Query;


/**
 * Created by ChenFengYao on 16/5/19.
 */
public class AnotherContentAty extends BaseActivity implements View.OnClickListener {
    private ListView mListView;
    private RelativeLayout floatDateLayout;
    private int mActionBarSize;
    private RecommendContentAdapter mAdapter;
    private ImageView picImg;
    private SimpleDraweeView iconSdv;
    private TextView titleTv, dateTv;
    private View frameLayout;
    private ImageView finishImg, shareImg;
    private CheckBox collectionBox;
    private CollectionDao collectionDao;
    private RecommendContentBean data;
    private boolean isFirstLogin;
    private Collection collection;

    private TextView dayTv, numTv;

    public boolean flag = true;
    private Bitmap bitmap;
    private int temp;

    @Override
    public int getLayout() {
        return R.layout.aty_content;
    }

    @Override
    public void initView() {
        // 单例的CollectionDao 在所有类当中我们保证只是用一个
        collectionDao = GreenDaoSingleton.getInstance().getCollectionDao();

        mListView = (ListView) findViewById(R.id.listView);

        // 判断收藏或注册
        collectionBox = (CheckBox) findViewById(R.id.another_collection_img);


        // 设置三方分享
        shareImg = (ImageView) findViewById(R.id.annither_content_share_img);
        shareImg.setOnClickListener(this);

        /**
         * 添加头布局
         */
        View view = LayoutInflater.from(this).inflate(R.layout.item_content_pic, null);
        mListView.addHeaderView(view);
        // 设置头布局的组件初始化
        picImg = (ImageView) view.findViewById(R.id.content_pic_img);
        iconSdv = (SimpleDraweeView) view.findViewById(R.id.content_icon_sdv);
        titleTv = (TextView) view.findViewById(R.id.content_title_tv);
        dateTv = (TextView) view.findViewById(R.id.content_date_tv);


        /**
         * listView分组与悬浮header,参数设置
         */
        floatDateLayout = (RelativeLayout) findViewById(R.id.floatGroupLayout);
        frameLayout = findViewById(R.id.aty_content_frame);
        dayTv = (TextView) findViewById(R.id.item_date_tv);
        numTv = (TextView) findViewById(R.id.item_date_numTv);


        mAdapter = new RecommendContentAdapter(this);


        /**
         * 设置finish
         */
        finishImg = (ImageView) findViewById(R.id.item_content_finish_img);
        finishImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void initData() {

        getActionBarSize();

        getVolleySingleton();

        collectionDao = GreenDaoSingleton.getInstance().getCollectionDao();

        collectionBox.setChecked(hasChecked());

        // 设置收藏

        collectionBox.setOnClickListener(this);


    }

    /**
     * 判断点击的页面是否处于收藏的状态
     *
     * @return
     */
    private boolean hasChecked() {
        List<Collection> c = collectionDao.queryBuilder().where(CollectionDao.Properties.ContentId.eq(getIntent().getIntExtra("id",0)))
                .list();
        if (c.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 解析网络数据
     */
    private void getVolleySingleton() {

        int id = getIntent().getIntExtra("id", 0);
        String url = "http://chanyouji.com/api/trips/" + id + ".json";
        Log.d("2B", "id:------>" + id);

        VolleySingleton.addRequest(url, RecommendContentBean.class,
                new Response.Listener<RecommendContentBean>() {
                    @Override
                    public void onResponse(final RecommendContentBean response) {
                        data = response;
                        // 添加适配器
                        mAdapter.setRecommendContentBean(response);

                        /**
                         * ScrollListener
                         * 除了设置高斯滤镜还会
                         * 还会设置listView分组与悬浮header
                         */
                        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                            @Override
                            public void onScrollStateChanged(AbsListView view, int scrollState) {

                            }

                            @Override
                            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                                int scrollY = getScrollY();
                                if (flag) {
                                    bitmap = ((BitmapDrawable) picImg.getDrawable()).getBitmap();
                                    flag = false;
                                }
                                clear(bitmap, picImg, scrollY / 10 + 1);

                                /**
                                 * 开始设置悬浮header
                                 * 首先,在XML文件中,将FragmeLayout设置setVibility(View.GONE)
                                 * 避免,一进入页面就在顶部显示
                                 * 然后,通过设置firstVibilityItem,来改变悬浮头的显隐
                                 * 已达到页面要求
                                 *
                                 * 因为头布局也是一个Item,所以,如果不设置的话,就会默认头布局为1
                                 * 这时候就需要进行改动
                                 * 首先,DAY + ? 因为获取的 getDay() 本身为int类型,所以直接 -1 就可以
                                 * 然后,因为getTrip_date()为String类型,所以需要进行subString()截取
                                 * 然后,在进行拼接方可!
                                 */
                                int day = Integer.parseInt(response.getTrip_days().get(firstVisibleItem).
                                        getTrip_date().substring(9));
                                String year = response.getTrip_days().get(firstVisibleItem).
                                        getTrip_date().substring(0, 9);
//
                                Log.d("sanlengzi", "----->" + (response.getTrip_days().get(firstVisibleItem).getDay() - 1));
                                //这应该是DP
                                if (temp != mListView.getChildAt(0).getHeight() + mListView.getChildAt(0).getTop()) {
                                    temp = mListView.getChildAt(0).getHeight() + mListView.getChildAt(0).getTop();
                                    Log.d("AnotherContentAty", "temp:" + temp);
                                }
                                if (totalItemCount > 0 && temp < 150) {
                                    frameLayout.setVisibility(View.VISIBLE);
                                    dayTv.setText("DAY" + (response.getTrip_days().get(firstVisibleItem).getDay() - 1));
                                    numTv.setText(year + (day - 1));
                                } else if (firstVisibleItem == 0) {
                                    frameLayout.setVisibility(View.GONE);
                                }

                            }

                        });

                        List<Integer> days = new ArrayList<Integer>();
                        for (int i = 0; i < response.getTrip_days().size(); i++) {
                            days.add(i);
                        }

                        floatDateLayout.setVisibility(View.VISIBLE);
                        for (int i = 0; i < days.size(); i++) {
                            if (response.getTrip_days().size() > 0) {
                                dayTv.setText("DAY" + response.getTrip_days().get(i).getDay());
                                numTv.setText(response.getTrip_days().get(i).getTrip_date());
                                Log.d("3B", "DAY" + response.getTrip_days().get(i).getDay());
                            }
                        }


                        /**
                         * 从解析的图片中使用ImageLoader获取bitmap,
                         * 然后用此bitmap来实现高斯滤镜效果
                         */
                        MyImageLoader myImageLoader = VolleySingleton.getMyImageLoader();
                        myImageLoader.get(response.getFront_cover_photo_url(), new ImageLoader.ImageListener() {
                            @Override
                            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                                if (response.getBitmap() != null) {
                                    bitmap = response.getBitmap();
                                    //  Log.d("AnotherContentAty", "bitmap==null:" + (bitmap == null));
                                    picImg.setImageBitmap(bitmap);
                                }
                            }

                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                        DraweeController controllerIcon = Fresco.newDraweeControllerBuilder().setUri(response.getUser().getImage()).build();
                        iconSdv.setController(controllerIcon);
                        titleTv.setText(response.getName());
                        flag = true;
                        dateTv.setText(response.getStart_date() + " 丨 " + response.getPhotos_count() + "图");


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.d("ContentAty", "error:--->" + error);
                    }
                });

        mListView.setAdapter(mAdapter);
    }


    /**
     * 测量ActionBar的高度
     */
    private void getActionBarSize() {
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        mActionBarSize = TypedValue.complexToDimensionPixelSize(typedValue.data,
                getResources().getDisplayMetrics());
    }


    /**
     * 获取滚动的高度,用于检测是否需要滚动
     *
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
//            Log.d("AnotherContentAty", "mListViewHeader.getMeasuredHeight():" + mListViewHeader.getMeasuredHeight());
        if (itemNum >= 1) {
            // itemScrollY = mListViewHeader.getMeasuredHeight();
            itemScrollY = 0;
        }
        scrollY = itemScrollY - firstVisible.getTop();
        // Log.d("AnotherContentAty", "scrollY:" + scrollY);
        return scrollY;
    }


    //先缩小-再模糊,再拉伸
    private void clear(Bitmap bkg, ImageView view, int radio) {

        float scaleFactor = 5;
        // Log.d("AnotherContentAty", "bkg.getHeight():" + bkg.getHeight());
        // Log.d("AnotherContentAty", "bkg.getWidth():" + bkg.getWidth());

        Bitmap overlay = Bitmap.createBitmap((int) (bkg.getWidth() / scaleFactor),
                (int) (bkg.getHeight() / scaleFactor), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(overlay);
        canvas.translate(-view.getLeft() / scaleFactor, -view.getTop() / scaleFactor);


        canvas.scale(1 / scaleFactor, 1 / scaleFactor);
        Paint paint = new Paint();
        paint.setFlags(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(bkg, 0, 0, paint);

        overlay = FastBlur.doBlur(overlay, radio, true);
        view.setImageBitmap(overlay);

    }


    /**
     * 点击分享
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.annither_content_share_img:
                showShare();
                break;
            case R.id.another_collection_img:
                showCollection();
                break;
        }

    }

    private void showCollection() {
        // 判断该ID是否为第一次登录,如果是则跳转登录界面
        SharedPreferences preferences = getSharedPreferences("isFirstLogin", MODE_WORLD_READABLE);

        isFirstLogin = preferences.getBoolean("isFirstLogin", true);

        if (isFirstLogin) {
            Intent intent = new Intent(this, SignUpAty.class);
            startActivity(intent);
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstLogin", false);
        editor.commit();

        /**
         * 判断点击状态
         * 如果为false 则保存到数据库
         * 如果为true  则删除
         */

        if (!collectionBox.isChecked()) {

            // 按照ContentId 找到数据! 直接删除!~
            collectionDao.queryBuilder().where(CollectionDao.Properties.ContentId.eq(data.getId())).
                    orderDesc(CollectionDao.Properties.Id).buildDelete().
                    executeDeleteWithoutDetachingEntities();

//            Log.d("自寻死路", "data.getId():" + data.getId());
//            collectionDao.queryBuilder().where(CollectionDao.Properties.ContentId.eq(data.getId()))
//                    .orderDesc(CollectionDao.Properties.Id).buildDelete().
//                    executeDeleteWithoutDetachingEntities();

            Toast.makeText(this, "你们这是自寻死路!", Toast.LENGTH_SHORT).show();
        } else {


            // 从接口中解析出需要的数据
            long id = System.currentTimeMillis();

            String title = data.getName();
            String url = data.getFront_cover_photo_url();
            int contentId = data.getId();

            // 添加到数据库中
            Collection collection = new Collection(id, title, url, contentId);
            collectionDao.insert(collection);
            Toast.makeText(this, "已添加到麦当劳豪华午餐!", Toast.LENGTH_SHORT).show();


        }
    }


    /**
     * 通过MOB 来分享到第三方
     */
    private void showShare() {

        ShareSDK.initSDK(this);
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
        oks.show(this);

    }
}
