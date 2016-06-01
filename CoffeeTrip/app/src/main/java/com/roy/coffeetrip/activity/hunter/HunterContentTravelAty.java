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
import com.roy.coffeetrip.adapter.hunter.HunterContentTravelAdapter;
import com.roy.coffeetrip.bean.hunter.HunterContentTravelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${Roy} on 16/5/23.
 */
public class HunterContentTravelAty extends AppCompatActivity {

    private ListView listView;
    private List<HunterContentTravelBean> datas;
    private HunterContentTravelAdapter adapter;
    private int id;
    private String name;
    private TextView titleTv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_hunter_content_travel);

        listView = (ListView) findViewById(R.id.hunter_content_travel_lv);
        datas = new ArrayList<>();
        adapter = new HunterContentTravelAdapter(this);

        titleTv = (TextView) findViewById(R.id.hunter_content_travel_title_tv);
        findViewById(R.id.huntetn_content_travel_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        initView();
        titleTv.setText(name + "行程");
        listView.setAdapter(adapter);
    }

    private void initView() {
        id = getIntent().getIntExtra("id", 0);
        name = getIntent().getStringExtra("name");

        RequestQueue requestQuese = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest("http://chanyouji.com/api/destinations/plans/" + String.valueOf(id) + ".json?page=1" ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new Gson();
                        datas = gson.fromJson(response, new TypeToken<ArrayList<HunterContentTravelBean>>() {
                        }.getType());
                        adapter.setDatas(datas);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HunterContentTravelAty", "没有数据"+error);
            }
        });
        requestQuese.add(request);

    }
}
