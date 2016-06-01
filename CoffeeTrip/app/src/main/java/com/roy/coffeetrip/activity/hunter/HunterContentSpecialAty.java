package com.roy.coffeetrip.activity.hunter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
import com.roy.coffeetrip.adapter.hunter.HunterContentSpecialAdapter;
import com.roy.coffeetrip.bean.hunter.HunterContentSpecialBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Roy} on 16/5/24.
 */
public class HunterContentSpecialAty extends AppCompatActivity {

    private ListView listView;
    private List<HunterContentSpecialBean> datas;
    private HunterContentSpecialAdapter adapter;
    private int id;
    private String names;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_hunter_special);

        listView = (ListView) findViewById(R.id.hunter_content_special_lv);
        TextView textView = (TextView) findViewById(R.id.hunter_content_special_title_tv);
        findViewById(R.id.huntetn_content_special_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        id = getIntent().getIntExtra("id", 0);
        names = getIntent().getStringExtra("name");

        textView.setText(names + "专题");

        adapter = new HunterContentSpecialAdapter(this);

        initView();
        listView.setAdapter(adapter);
    }

    private void initView() {
        datas = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest("http://chanyouji.com/api/articles.json?destination_id=" + id + "&page=1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        datas = gson.fromJson(response,new  TypeToken<ArrayList<HunterContentSpecialBean>>(){}.getType());
                        adapter.setDatas(datas);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HunterContentSpecialAty", "error:----->" + error);
            }
        });
        requestQueue.add(request);
    }
}
