package com.roy.coffeetrip.activity.hunter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.hunter.HuntetContentDesitinationAdapter;
import com.roy.coffeetrip.bean.hunter.HunterContentDesitinationBean;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by ${Roy} on 16/5/24.
 */
public class HunterContentDesitinationAty extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private List<HunterContentDesitinationBean> datas;
    private HuntetContentDesitinationAdapter adapter;
    private String names;
    private int id;
    private ImageView shareImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_destination);

        // 设置三方分享
        shareImg = (ImageView) findViewById(R.id.hunter_destination_share_img);
        shareImg.setOnClickListener(this);

        listView = (ListView) findViewById(R.id.hunter_content_destination_lv);
        adapter = new HuntetContentDesitinationAdapter(this);
        TextView textView = (TextView) findViewById(R.id.hunter_content_destination_title_tv);
        findViewById(R.id.hunter_content_destination_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        names = getIntent().getStringExtra("name");
        id = getIntent().getIntExtra("id",0);

        textView.setText(names+"旅行地");
        initView();
        listView.setAdapter(adapter);
    }

    private void initView() {
        datas = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest("http://chanyouji.com/api/destinations/attractions/" + id + ".json?per_page=20&page=1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        datas = gson.fromJson(response,new  TypeToken<ArrayList<HunterContentDesitinationBean>>(){}.getType());
                        adapter.setDatas(datas);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HunterContentDesitinati", "error:---->" + error);
            }
        });
        requestQueue.add(request);

    }

    @Override
    public void onClick(View v) {

        showShare();

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
