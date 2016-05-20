package com.roy.coffeetrip.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
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
import com.android.volley.toolbox.ImageLoader;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.RecommendContentAdapter;
import com.roy.coffeetrip.base.BaseActivity;
import com.roy.coffeetrip.bean.RecommendContentBean;
import com.roy.coffeetrip.utill.FastBlur;
import com.roy.coffeetrip.utill.MyImageLoader;
import com.roy.coffeetrip.utill.VolleySingleton;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ChenFengYao on 16/5/19.
 */
public class AnotherContentAty extends BaseActivity implements AbsListView.OnScrollListener {
    private ListView mListView;
    private RelativeLayout mListViewHeader;
    private int mActionBarSize;
    private RecommendContentAdapter mAdapter;
    private ImageView picImg;
    private SimpleDraweeView iconSdv;
    private TextView titleTv, dateTv;


    @Override
    public int getLayout() {
        return R.layout.aty_content;
    }

    @Override
    public void initView() {

        mListView = (ListView) findViewById(R.id.id_list_view);
        View view = LayoutInflater.from(this).inflate(R.layout.item_content_pic, null);
        mListView.addHeaderView(view);
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


    }

    /**
     * 解析网络数据
     */
    private void getVolleySingleton() {
        String url = getIntent().getStringExtra("url");
        Log.d("RecommendContentAty", "url---------->" + url);
        VolleySingleton.addRequest(url, RecommendContentBean.class,
                new Response.Listener<RecommendContentBean>() {
                    @Override
                    public void onResponse(RecommendContentBean response) {
                        mAdapter.setRecommendContentBean(response);
                      //  Picasso.with(AnotherContentAty.this).load(response.getFront_cover_photo_url()).into(picImg);
//                        ImageLoader imageLoader = new ImageLoader(VolleySingleton.)
                        MyImageLoader myImageLoader = VolleySingleton.getMyImageLoader();
                        myImageLoader.get(response.getFront_cover_photo_url(), new ImageLoader.ImageListener() {
                            @Override
                            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                                if(response.getBitmap()!=null) {
                                    bitmap = response.getBitmap();
                                    Log.d("AnotherContentAty", "bitmap==null:" + (bitmap == null));
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
        getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
        mActionBarSize = TypedValue.complexToDimensionPixelSize(typedValue.data,
                getResources().getDisplayMetrics());
        Log.d("RecommendContentAty", "mActionBarSize:----->" + mActionBarSize);
    }

    /**
     * ScrollListener
     *
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    public boolean flag = true;
    private Bitmap bitmap;

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        int scrollY = getScrollY();
        //picImg.setImageBitmap(FastBlur.doBlur(((BitmapDrawable) picImg.getDrawable()).getBitmap(), 2, false));
        if (flag) {
            bitmap = ((BitmapDrawable) picImg.getDrawable()).getBitmap();
            flag = false;
        }
        clear(bitmap, picImg, scrollY / 10 + 1);
        // bitmap.recycle();
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
        Log.d("AnotherContentAty", "scrollY:" + scrollY);
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
}
