package com.roy.coffeetrip.activity.customize;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.roy.coffeetrip.R;


/**
 * Created by ${Roy} on 16/5/27.
 */
public class CustomizeWebAty extends AppCompatActivity {

    private WebView webView;
    private Handler handler = new Handler();
    private String web,getTitle;
    private TextView title;
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_customize_web_view);

        getWebTitle();

        getFinish();

        initWebView();


    }

    private void initWebView() {

        // 获取跳转数据
        web = getIntent().getStringExtra("web");

        // 初始化webView
        webView = (WebView) findViewById(R.id.customize_webView);

        /**
         * 网络内容
         1、LoadUrl 直接显示网页内容(单独显示网络图片)
         2、LoadData 显示中文网页内容(含空格的处理)
         ,该方法将一个 java 对象绑定到一个javascript 对象中 ,
         javascript 对象名就是 interfaceName(demo),
         作用域是 Global. 这样初始化 WebView 后 ,
         在WebView 加载的页面中就可以直接通过 javascript
         */
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new Object() {
            public void clickOnAndroid() {
                handler.post(new Runnable() {
                    public void run() {
                        webView.loadUrl("javascript：wave()");
                    }
                });
            }
        }, "demo");
        webView.loadUrl(web);
    }


    private void getFinish() {

        // 初始化finish imageView
        imageView = (ImageView) findViewById(R.id.customize_web_img);
        // 设置其点击事件,finish
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void getWebTitle() {

        getTitle = getIntent().getStringExtra("title");
        Log.d("CustomizeWebAty", getTitle);
        // 初始化title
        title = (TextView) findViewById(R.id.customize_wen_title_tv);
        title.setText(getTitle);

    }


}
