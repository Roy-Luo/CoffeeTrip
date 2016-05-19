package com.roy.coffeetrip.fragment;


import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.roy.coffeetrip.BuildConfig;
import com.roy.coffeetrip.R;
import com.roy.coffeetrip.adapter.HunterListViewAdapter;
import com.roy.coffeetrip.base.BaseFragment;
import com.roy.coffeetrip.bean.HunterBean;
import com.roy.coffeetrip.utill.VolleySingleton;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ${Roy} on 16/5/10.
 */
public class HunterFragment extends BaseFragment {


    private ListView listView;
    private HunterListViewAdapter listViewAdapter;
    private List<HunterBean> datas;


    @Override
    public int setLayout() {
        return R.layout.fragment_hunter;
    }

    @Override
    public void initView() {
        listView = (ListView) getView().findViewById(R.id.hunter_lv);
        listViewAdapter = new HunterListViewAdapter(mContext);
    }

    @Override
    public void initData() {
        datas = new ArrayList<>();

         VolleySingleton.addRequest("http://chanyouji.com/api/destinations.json?page=1", HunterBean.class,
                new Response.Listener<HunterBean>() {
                    @Override
                    public void onResponse(HunterBean response) {
                        Log.d("HunterFragment", "response:-------->" + response);
                        listViewAdapter.setData(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("HunterFragment", "error---------->" + error);
                    }
                });

        listView.setAdapter(listViewAdapter);

    }
}

